/*     */ package com.hundsun.network.gates.genshan.web.action.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionResult;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.genshan.biz.service.auction.TransferOrderService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.trade.TradeWishOrderService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.genshan.common.MobileMessageUtil;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.validator.TransferInputValidator;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionResultTranResult;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AnnouncementRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteAnnouncementService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemMessageService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class TransferOrderAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderService tradeWishOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private TransferInputValidator transferInputValidator;
/*     */ 
/*     */   @Autowired
/*     */   private TransferOrderService transferOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteAnnouncementService remoteAnnouncementService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemMessageService remoteSystemMessageService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @Autowired
/*     */   private MobileMessageUtil mobileMessageUtil;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_C_TRANSFER_INPUT})
/*     */   @RequestMapping(value={"auction/transfer/input"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String transferInput(ModelMap model, UserAgent userAgent, @RequestParam(value="url", required=true) String url, @RequestParam(value="projectId", required=true) Long projectId)
/*     */   {
/*  78 */     model.addAttribute("url", url);
/*  79 */     if (null == projectId) {
/*  80 */       model.put("message", "项目编号不能为空");
/*  81 */       return error(model);
/*     */     }
/*  83 */     ProjectListing listing = this.projectListingService.getProSimpInfo(projectId);
/*  84 */     if ((null == listing) || (!EnumProjectStatus.TRADE.getValue().equals(listing.getStatus())) || (!EnumTradingType.TRANSFER_ORDER.getValue().equals(listing.getTradingType())))
/*     */     {
/*  86 */       model.put("message", "操作项目不存在");
/*  87 */       return error(model);
/*     */     }
/*  89 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/*  91 */     if ((substationId != null) && (!substationId.equals(listing.getSubstationId()))) {
/*  92 */       return "accessDenied";
/*     */     }
/*     */ 
/*  97 */     AuctionResult auctionResult = new AuctionResult();
/*  98 */     auctionResult.setProjectCode(listing.getCode());
/*  99 */     auctionResult.setValuationUnit(listing.getValuationUnit());
/* 100 */     model.addAttribute("auctionResult", auctionResult);
/*     */ 
/* 103 */     List tradeWishOrderList = getEffectiveTradeWishOrderList(listing.getCode());
/* 104 */     model.addAttribute("tradeWishOrderList", tradeWishOrderList);
/*     */ 
/* 106 */     return "/auction/transfer/input";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_C_TRANSFER_INPUT})
/*     */   @RequestMapping(value={"auction/transfer/input"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String transferInput(ModelMap model, UserAgent userAgent, @ModelAttribute("auctionResult") AuctionResult auctionResult, BindingResult valiResult, @RequestParam("url") String url)
/*     */   {
/* 118 */     model.addAttribute("url", url);
/*     */ 
/* 121 */     this.transferInputValidator.validate(auctionResult, valiResult);
/* 122 */     List<TradeWishOrder> tradeWishOrderList = getEffectiveTradeWishOrderList(auctionResult.getProjectCode());
/* 123 */     if (valiResult.hasErrors()) {
/* 124 */       model.addAttribute("tradeWishOrderList", tradeWishOrderList);
/* 125 */       return "/auction/transfer/input";
/*     */     }
/*     */ 
/* 128 */     ProjectListing listing = this.projectListingService.getSimpleInfoOfProject(auctionResult.getProjectCode());
/* 129 */     if ((null == listing) || (!EnumProjectStatus.TRADE.getValue().equals(listing.getStatus())) || (!EnumTradingType.TRANSFER_ORDER.getValue().equals(listing.getTradingType())))
/*     */     {
/* 131 */       model.put("message", "操作项目不存在或已结束");
/* 132 */       return error(model);
/*     */     }
/* 134 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/* 136 */     if ((substationId != null) && (!substationId.equals(listing.getSubstationId()))) {
/* 137 */       return "accessDenied";
/*     */     }
/*     */ 
/* 140 */     auctionResult.setValuationUnit(listing.getValuationUnit());
/* 141 */     AuctionResult resultPara = convert(auctionResult, userAgent.getUserAccount());
/*     */ 
/* 144 */     TradeOrderServiceResult result = this.transferOrderService.endAuctionResult(resultPara);
/*     */ 
/* 146 */     String proTitle = listing.getTitle();
/* 147 */     if (proTitle.length() > 100) proTitle = proTitle.substring(0, 95) + "..";
/* 148 */     String title = "【" + proTitle + "】项目已" + EnumAuctionResultTranResult.indexByValue(auctionResult.getTranResult()).getName();
/* 149 */     String content = "【" + proTitle + "（项目编号:" + listing.getCode() + "）】的挂牌项目已" + EnumAuctionResultTranResult.indexByValue(auctionResult.getTranResult()).getName() + "！如有疑问请联系交易所管理员";
/*     */ 
/* 153 */     if (result.correct())
/*     */     {
/* 155 */       AnnouncementDTO announcement = new AnnouncementDTO();
/* 156 */       announcement.setTitle(title);
/* 157 */       announcement.setContent(content);
/* 158 */       announcement.setType(EnumAnnouncementType.SYSTEM.getValue());
/* 159 */       announcement.setProjectId(listing.getId());
/* 160 */       announcement.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/* 161 */       announcement.setCreator(EnumOperatorType.SYSTEM.getValue());
/* 162 */       AnnouncementRequest announcementRequest = new AnnouncementRequest();
/* 163 */       announcementRequest.setAnnouncementDTO(announcement);
/* 164 */       announcementRequest.setInsertNormal(true);
/* 165 */       this.remoteAnnouncementService.createAnnouncement(announcementRequest);
/*     */ 
/* 168 */       SystemMessageRequest request = new SystemMessageRequest();
/* 169 */       request.setTitle(title);
/* 170 */       request.setContent(content);
/* 171 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 172 */       request.addUser(listing.getUserAccount());
/* 173 */       if ((tradeWishOrderList != null) && (tradeWishOrderList.size() > 0))
/* 174 */         for (TradeWishOrder tradeWishOrder : tradeWishOrderList)
/* 175 */           request.addUser(tradeWishOrder.getUserAccount());
/* 176 */       this.remoteSystemMessageService.sendSystemMessage(request);
/*     */       try
/*     */       {
/* 180 */         List nums = new ArrayList();
/* 181 */         UserAccount listingAccount = this.userAccountService.getUserByAccount(listing.getUserAccount());
/* 182 */         nums.add(listingAccount.getMobile());
/* 183 */         String msg = "尊敬的" + listingAccount.getName() + "您好，您的挂牌项目" + listing.getTitle();
/*     */ 
/* 185 */         if (EnumAuctionResultTranResult.RESULT_FINISHED.getValue().equals(auctionResult.getTranResult()))
/*     */         {
/* 187 */           msg = msg + "已成交，请及时登录个人中心确认订单【中部林业产权交易服务中心】";
/* 188 */           this.mobileMessageUtil.sendMsg(nums, msg);
/*     */ 
/* 190 */           List bidderNums = new ArrayList();
/* 191 */           UserAccount bidderAccount = this.userAccountService.getUserByAccount(auctionResult.getBidderAccount());
/* 192 */           bidderNums.add(bidderAccount.getMobile());
/* 193 */           String bidderMsg = "尊敬的" + bidderAccount.getName() + "您好，您报名的挂牌项目" + listing.getTitle() + "已成交，请及时登录个人中心确认订单【中部林业产权交易服务中心】";
/*     */ 
/* 196 */           this.mobileMessageUtil.sendMsg(bidderNums, bidderMsg);
/* 197 */         } else if (EnumAuctionResultTranResult.RESULT_FLOWPAT.getValue().equals(auctionResult.getTranResult()))
/*     */         {
/* 199 */           msg = msg + "已流拍【中部林业产权交易服务中心】";
/* 200 */           this.mobileMessageUtil.sendMsg(nums, msg);
/*     */         }
/*     */       } catch (Exception e) {
/* 203 */         this.log.error("send mobileMessage for transfer input error cause by:" + e);
/*     */       }
/*     */     }
/* 206 */     return result(result.correct());
/*     */   }
/*     */ 
/*     */   private List<TradeWishOrder> getEffectiveTradeWishOrderList(String projectCode)
/*     */   {
/* 213 */     TradeWishOrder tradeWishOrderParm = new TradeWishOrder();
/* 214 */     tradeWishOrderParm.setProjectCode(projectCode);
/* 215 */     tradeWishOrderParm.setStatus(EnumTradeWishOrderStatus.TRADING.getValue());
/* 216 */     List tradeWishOrderList = this.tradeWishOrderService.getTradeWishOrderList(tradeWishOrderParm);
/* 217 */     return tradeWishOrderList;
/*     */   }
/*     */ 
/*     */   private AuctionResult convert(AuctionResult param, String operator) {
/* 221 */     AuctionResult result = new AuctionResult();
/* 222 */     result.setProjectCode(param.getProjectCode());
/* 223 */     result.setTranResult(param.getTranResult());
/*     */ 
/* 225 */     String priceDesc = param.getPriceDesc();
/* 226 */     if (StringUtil.isNotBlank(priceDesc)) {
/* 227 */       BigDecimal bgPrice = new BigDecimal(priceDesc);
/* 228 */       Long money = Long.valueOf(bgPrice.movePointRight(EnumValuationUnit.indexByValue(param.getValuationUnit()).getScale()).longValue());
/* 229 */       result.setPrice(money);
/*     */     }
/*     */ 
/* 232 */     result.setValuationUnit(param.getValuationUnit());
/* 233 */     result.setBidderAccount(param.getBidderAccount());
/* 234 */     result.setRemark(param.getRemark());
/* 235 */     result.setOperator(operator);
/*     */ 
/* 241 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.auction.TransferOrderAction
 * JD-Core Version:    0.6.0
 */