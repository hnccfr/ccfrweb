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
/*     */ public class TenderOrderAction extends BaseAction
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
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_C_TENDER_INPUT})
/*     */   @RequestMapping(value={"auction/tender/input"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String transferInput(ModelMap model, UserAgent userAgent, @RequestParam(value="url", required=true) String url, @RequestParam(value="projectId", required=true) Long projectId)
/*     */   {
/*  78 */     model.addAttribute("url", url);
/*  79 */     if (null == projectId) {
/*  80 */       model.put("message", "项目编号不能为空");
/*  81 */       return error(model);
/*     */     }
/*  83 */     ProjectListing listing = this.projectListingService.getProSimpInfo(projectId);
/*  84 */     if ((null == listing) || (!EnumProjectStatus.TRADE.getValue().equals(listing.getStatus())) || (!EnumTradingType.TENDER_ORDER.getValue().equals(listing.getTradingType())))
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
/* 106 */     return "/auction/tender/input";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_C_TENDER_INPUT})
/*     */   @RequestMapping(value={"auction/tender/input"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String transferInput(ModelMap model, UserAgent userAgent, @ModelAttribute("auctionResult") AuctionResult auctionResult, BindingResult valiResult, @RequestParam("url") String url)
/*     */   {
/* 118 */     model.addAttribute("url", url);
/*     */ 
/* 122 */     this.transferInputValidator.validate(auctionResult, valiResult);
/* 123 */     List<TradeWishOrder> tradeWishOrderList = getEffectiveTradeWishOrderList(auctionResult.getProjectCode());
/* 124 */     if (valiResult.hasErrors()) {
/* 125 */       model.addAttribute("tradeWishOrderList", tradeWishOrderList);
/* 126 */       return "/auction/tender/input";
/*     */     }
/*     */ 
/* 129 */     ProjectListing listing = this.projectListingService.getSimpleInfoOfProject(auctionResult.getProjectCode());
/* 130 */     if ((null == listing) || (!EnumProjectStatus.TRADE.getValue().equals(listing.getStatus())) || (!EnumTradingType.TENDER_ORDER.getValue().equals(listing.getTradingType())))
/*     */     {
/* 132 */       model.put("message", "操作项目不存在或已结束");
/* 133 */       return error(model);
/*     */     }
/* 135 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/* 137 */     if ((substationId != null) && (!substationId.equals(listing.getSubstationId()))) {
/* 138 */       return "accessDenied";
/*     */     }
/*     */ 
/* 141 */     auctionResult.setValuationUnit(listing.getValuationUnit());
/* 142 */     AuctionResult resultPara = convert(auctionResult, userAgent.getUserAccount());
/*     */ 
/* 146 */     TradeOrderServiceResult result = this.transferOrderService.endAuctionResult(resultPara);
/*     */ 
/* 148 */     String proTitle = listing.getTitle();
/* 149 */     if (proTitle.length() > 100) proTitle = proTitle.substring(0, 95) + "..";
/* 150 */     String title = "【" + proTitle + "】项目已" + EnumAuctionResultTranResult.indexByValue(auctionResult.getTranResult()).getName();
/* 151 */     String content = "【" + proTitle + "（项目编号:" + listing.getCode() + "）】的挂牌项目已" + EnumAuctionResultTranResult.indexByValue(auctionResult.getTranResult()).getName() + "！如有疑问请联系交易所管理员";
/*     */ 
/* 155 */     if (result.correct())
/*     */     {
/* 157 */       AnnouncementDTO announcement = new AnnouncementDTO();
/* 158 */       announcement.setTitle(title);
/* 159 */       announcement.setContent(content);
/* 160 */       announcement.setType(EnumAnnouncementType.SYSTEM.getValue());
/* 161 */       announcement.setProjectId(listing.getId());
/* 162 */       announcement.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/* 163 */       announcement.setCreator(EnumOperatorType.SYSTEM.getValue());
/* 164 */       AnnouncementRequest announcementRequest = new AnnouncementRequest();
/* 165 */       announcementRequest.setAnnouncementDTO(announcement);
/* 166 */       announcementRequest.setInsertNormal(true);
/* 167 */       this.remoteAnnouncementService.createAnnouncement(announcementRequest);
/*     */ 
/* 170 */       SystemMessageRequest request = new SystemMessageRequest();
/* 171 */       request.setTitle(title);
/* 172 */       request.setContent(content);
/* 173 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 174 */       request.addUser(listing.getUserAccount());
/* 175 */       if ((tradeWishOrderList != null) && (tradeWishOrderList.size() > 0))
/* 176 */         for (TradeWishOrder tradeWishOrder : tradeWishOrderList)
/* 177 */           request.addUser(tradeWishOrder.getUserAccount());
/* 178 */       this.remoteSystemMessageService.sendSystemMessage(request);
/*     */       try
/*     */       {
/* 182 */         List nums = new ArrayList();
/* 183 */         UserAccount listingAccount = this.userAccountService.getUserByAccount(listing.getUserAccount());
/* 184 */         nums.add(listingAccount.getMobile());
/* 185 */         String msg = "尊敬的" + listingAccount.getName() + "您好，您的挂牌项目" + listing.getTitle();
/*     */ 
/* 187 */         if (EnumAuctionResultTranResult.RESULT_FINISHED.getValue().equals(auctionResult.getTranResult()))
/*     */         {
/* 189 */           msg = msg + "已成交，请及时登录个人中心确认订单【中部林业产权交易服务中心】";
/* 190 */           this.mobileMessageUtil.sendMsg(nums, msg);
/*     */ 
/* 192 */           List bidderNums = new ArrayList();
/* 193 */           UserAccount bidderAccount = this.userAccountService.getUserByAccount(auctionResult.getBidderAccount());
/* 194 */           bidderNums.add(bidderAccount.getMobile());
/* 195 */           String bidderMsg = "尊敬的" + bidderAccount.getName() + "您好，您报名的挂牌项目" + listing.getTitle() + "已成交，请及时登录个人中心确认订单【中部林业产权交易服务中心】";
/*     */ 
/* 198 */           this.mobileMessageUtil.sendMsg(bidderNums, bidderMsg);
/* 199 */         } else if (EnumAuctionResultTranResult.RESULT_FLOWPAT.getValue().equals(auctionResult.getTranResult()))
/*     */         {
/* 201 */           msg = msg + "已流拍【中部林业产权交易服务中心】";
/* 202 */           this.mobileMessageUtil.sendMsg(nums, msg);
/*     */         }
/*     */       } catch (Exception e) {
/* 205 */         this.log.error("send mobileMessage for tender input error cause by:" + e);
/*     */       }
/*     */     }
/* 208 */     return result(result.correct());
/*     */   }
/*     */ 
/*     */   private List<TradeWishOrder> getEffectiveTradeWishOrderList(String projectCode)
/*     */   {
/* 215 */     TradeWishOrder tradeWishOrderParm = new TradeWishOrder();
/* 216 */     tradeWishOrderParm.setProjectCode(projectCode);
/* 217 */     tradeWishOrderParm.setStatus(EnumTradeWishOrderStatus.TRADING.getValue());
/* 218 */     List tradeWishOrderList = this.tradeWishOrderService.getTradeWishOrderList(tradeWishOrderParm);
/* 219 */     return tradeWishOrderList;
/*     */   }
/*     */ 
/*     */   private AuctionResult convert(AuctionResult param, String operator) {
/* 223 */     AuctionResult result = new AuctionResult();
/* 224 */     result.setProjectCode(param.getProjectCode());
/* 225 */     result.setTranResult(param.getTranResult());
/*     */ 
/* 227 */     String priceDesc = param.getPriceDesc();
/* 228 */     if (StringUtil.isNotBlank(priceDesc)) {
/* 229 */       BigDecimal bgPrice = new BigDecimal(priceDesc);
/* 230 */       Long money = Long.valueOf(bgPrice.movePointRight(EnumValuationUnit.indexByValue(param.getValuationUnit()).getScale()).longValue());
/* 231 */       result.setPrice(money);
/*     */     }
/*     */ 
/* 234 */     result.setValuationUnit(param.getValuationUnit());
/* 235 */     result.setBidderAccount(param.getBidderAccount());
/* 236 */     result.setRemark(param.getRemark());
/* 237 */     result.setOperator(operator);
/*     */ 
/* 243 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.auction.TenderOrderAction
 * JD-Core Version:    0.6.0
 */