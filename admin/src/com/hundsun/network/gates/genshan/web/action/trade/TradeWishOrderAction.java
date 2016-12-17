/*     */ package com.hundsun.network.gates.genshan.web.action.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeWishOrderQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.WishOrderAudit;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.EnumAuditWishOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectMetasService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.trade.TradeWishOrderService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.trade.WishOrderAuditService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.genshan.common.MobileMessageUtil;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuditRes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProcessAuditNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTenderOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransferOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumYesOrNo;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class TradeWishOrderAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderService tradeWishOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private WishOrderAuditService wishOrderAuditService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasService projectMetasService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @Autowired
/*     */   private MobileMessageUtil mobileMessageUtil;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.WIH_R_SELL_LIST})
/*     */   @RequestMapping({"tradeWishOrder/sell"})
/*     */   public void doShowMyTradeWishOrderSellingPage(@ModelAttribute("query") TradeWishOrderQuery query, ModelMap model, UserAgent userAgent)
/*     */   {
/*  76 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/*  78 */     if (substationId != null) {
/*  79 */       query.setSubstationId(Long.valueOf(substationId.longValue()));
/*     */     }
/*     */ 
/*  82 */     EnumTradeWishOrderStatus[] twoStatus = EnumTradeWishOrderStatus.values();
/*  83 */     EnumPaymentType[] payTypes = EnumPaymentType.values();
/*  84 */     query.setTradeDictor(EnumListingType.SELL.getValue());
/*  85 */     this.tradeWishOrderService.getTradeWishOrderByQuery(query);
/*  86 */     model.addAttribute("query", query);
/*  87 */     model.addAttribute("twoStatus", twoStatus);
/*  88 */     model.addAttribute("payTypes", payTypes);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.WIH_R_BUY_LIST})
/*     */   @RequestMapping({"tradeWishOrder/buy"})
/*     */   public void doShowMyTradeWishOrderBuyingPage(@ModelAttribute("query") TradeWishOrderQuery query, ModelMap model, UserAgent userAgent)
/*     */   {
/*  97 */     Long subStationId = getSubstationId(userAgent);
/*     */ 
/*  99 */     if (subStationId != null) {
/* 100 */       query.setSubstationId(Long.valueOf(subStationId.longValue()));
/*     */     }
/*     */ 
/* 103 */     EnumTradeWishOrderStatus[] twoStatus = EnumTradeWishOrderStatus.values();
/* 104 */     EnumPaymentType[] payTypes = EnumPaymentType.values();
/* 105 */     query.setTradeDictor(EnumListingType.BUY.getValue());
/* 106 */     this.tradeWishOrderService.getTradeWishOrderByQuery(query);
/* 107 */     model.addAttribute("query", query);
/* 108 */     model.addAttribute("twoStatus", twoStatus);
/* 109 */     model.addAttribute("payTypes", payTypes);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.WIH_R_DETAIL})
/*     */   @RequestMapping({"tradeWishOrder/detail"})
/*     */   public String doShowTradeWishOrderDetail(@RequestParam(value="wishOrderNum", required=true) String wishOrderNum, ModelMap model, UserAgent userAgent)
/*     */   {
/* 119 */     String returnURL = "";
/* 120 */     TradeWishOrder tradeWishOrder = this.tradeWishOrderService.getTradeWishOrderByWishOrderNum(wishOrderNum);
/* 121 */     if (null != tradeWishOrder) {
/* 122 */       Long substationId = getSubstationId(userAgent);
/*     */ 
/* 124 */       if ((substationId != null) && (!substationId.equals(tradeWishOrder.getSubstationId()))) {
/* 125 */         return "accessDenied";
/*     */       }
/*     */ 
/* 129 */       if (!EnumTradingType.PLACE_ORDER.getValue().equals(tradeWishOrder.getTradeType())) {
/* 130 */         ProjectListing projectListing = this.projectListingService.getProjectListingByCode(tradeWishOrder.getProjectCode());
/* 131 */         ProjectMetas projectMetas = new ProjectMetas();
/* 132 */         projectMetas.setProjectId(projectListing.getId());
/* 133 */         String metaKey = EnumMulitBidOrderProperty.BID_START_PRICE.getKey();
/*     */ 
/* 135 */         if (EnumTradingType.TRANSFER_ORDER.getValue().equals(tradeWishOrder.getTradeType()))
/* 136 */           metaKey = EnumTransferOrderProperty.START_PRICE.getKey();
/* 137 */         else if (EnumTradingType.TENDER_ORDER.getValue().equals(tradeWishOrder.getTradeType())) {
/* 138 */           metaKey = EnumTenderOrderProperty.EVALUATION.getKey();
/*     */         }
/* 140 */         projectMetas.setMetaKey(metaKey);
/* 141 */         Long bidStartPrice = Long.valueOf(Long.parseLong(this.projectMetasService.getOneMetaValue(projectMetas)));
/* 142 */         model.addAttribute("bidStartPrice", bidStartPrice);
/*     */       }
/* 144 */       returnURL = "tradeWishOrder/detail";
/* 145 */       model.addAttribute("tradeWishOrder", tradeWishOrder);
/*     */     } else {
/* 147 */       returnURL = "error";
/*     */     }
/* 149 */     return returnURL;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.WIH_U_AUDIT})
/*     */   @RequestMapping(value={"tradeWishOrder/auction/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String initAuditTradeWishOrder(@RequestParam(value="wishOrderNum", required=true) String wishOrderNum, @RequestParam(value="returnUrl", required=true) String returnUrl, ModelMap model, UserAgent userAgent)
/*     */   {
/* 167 */     if (null == returnUrl)
/* 168 */       model.put("url", "/tradeWishOrder/buy");
/*     */     else {
/* 170 */       model.put("url", returnUrl);
/*     */     }
/* 172 */     if (null == wishOrderNum) {
/* 173 */       model.put("message", "意向单号不存在");
/* 174 */       return "error";
/*     */     }
/* 176 */     TradeWishOrder tradeWishOrder = this.tradeWishOrderService.getTradeWishOrderByWishOrderNum(wishOrderNum);
/* 177 */     if (null == tradeWishOrder) {
/* 178 */       model.put("message", "该意向单不存在");
/* 179 */       return "error";
/*     */     }
/*     */ 
/* 182 */     WishOrderAudit wishOrderAudit = new WishOrderAudit();
/* 183 */     wishOrderAudit.setOrderId(tradeWishOrder.getId());
/* 184 */     WishOrderAudit resultAudit = this.wishOrderAuditService.selectWishOrderAuditInAudit(wishOrderAudit);
/* 185 */     if (null == resultAudit) {
/* 186 */       model.put("message", "意向单审核流程丢失");
/* 187 */       return "error";
/*     */     }
/* 189 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/* 191 */     if ((substationId != null) && ((!substationId.equals(tradeWishOrder.getSubstationId())) || (!EnumProcessAuditNodes.ADVANCE_AUDIT.getValue().endsWith(resultAudit.getAuditNode()))))
/*     */     {
/* 193 */       model.put("message", "终审由系统管理员执行");
/* 194 */       return "accessDenied";
/*     */     }
/*     */ 
/* 197 */     if (EnumProcessAuditNodes.ADVANCE_AUDIT.getValue().endsWith(resultAudit.getAuditNode())) {
/* 198 */       model.addAttribute("advance", Boolean.valueOf(true));
/*     */     }
/*     */ 
/* 202 */     ProjectListing projectListing = this.projectListingService.getSimpleInfoOfProject(tradeWishOrder.getProjectCode());
/* 203 */     if (!EnumProjectStatus.TRADE.getValue().equals(projectListing.getStatus())) {
/* 204 */       model.put("message", "该挂牌项目目前为非正常状态");
/* 205 */       return "error";
/*     */     }
/* 207 */     if (this.wishOrderAuditService.isOutOfTime(projectListing.getId()).booleanValue()) {
/* 208 */       model.put("message", "审核时间已过，您不能再审核");
/* 209 */       return "error";
/*     */     }
/* 211 */     ProjectMetas projectMetas = new ProjectMetas();
/* 212 */     projectMetas.setProjectId(projectListing.getId());
/* 213 */     String metaKey = EnumMulitBidOrderProperty.BID_START_PRICE.getKey();
/*     */ 
/* 215 */     if (EnumTradingType.TRANSFER_ORDER.getValue().equals(tradeWishOrder.getTradeType()))
/* 216 */       metaKey = EnumTransferOrderProperty.START_PRICE.getKey();
/* 217 */     else if (EnumTradingType.TENDER_ORDER.getValue().equals(tradeWishOrder.getTradeType())) {
/* 218 */       metaKey = EnumTenderOrderProperty.EVALUATION.getKey();
/*     */     }
/* 220 */     projectMetas.setMetaKey(metaKey);
/* 221 */     Long bidStartPrice = Long.valueOf(Long.parseLong(this.projectMetasService.getOneMetaValue(projectMetas)));
/* 222 */     String trademark = this.wishOrderAuditService.getTradeMark(tradeWishOrder.getProjectCode(), null);
/* 223 */     EnumYesOrNo[] enable = EnumYesOrNo.values();
/* 224 */     model.addAttribute("enable", enable);
/* 225 */     model.addAttribute("projectId", projectListing.getId());
/* 226 */     model.addAttribute("tradeWishOrder", tradeWishOrder);
/* 227 */     model.addAttribute("trademark", trademark);
/* 228 */     model.addAttribute("bidStartPrice", bidStartPrice);
/* 229 */     return "tradeWishOrder/auction/audit";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.WIH_U_AUDIT})
/*     */   @RequestMapping(value={"tradeWishOrder/auction/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String auditTradeWishOrder(UserAgent userAgent, @RequestParam("id") Long wishOrderId, @RequestParam("auditNodeRemark") String auditNodeRemark, @RequestParam("auditResult") String auditResult, @RequestParam("projectCode") String projectCode, @RequestParam("projectId") Long projectId, @RequestParam(value="isSpecialMan", required=false, defaultValue="N") String isSpecialMan, @RequestParam("trademark") String trademark, @RequestParam("url") String url, HttpServletRequest request, ModelMap model)
/*     */   {
/* 256 */     model.put("url", url);
/* 257 */     ProjectListing projectListing = this.projectListingService.getSimpleInfoOfProject(projectCode);
/* 258 */     if (!EnumProjectStatus.TRADE.getValue().equals(projectListing.getStatus())) {
/* 259 */       model.put("message", "该挂牌项目目前为非正常状态");
/* 260 */       return "error";
/*     */     }
/* 262 */     if (this.wishOrderAuditService.isOutOfTime(projectId).booleanValue()) {
/* 263 */       model.put("message", "审核时间已过，您不能再审核");
/* 264 */       return "error";
/*     */     }
/* 266 */     String ip = CommonUtils.getIpAddr(request);
/* 267 */     if (null == ip) {
/* 268 */       ip = "0.0.0.0";
/*     */     }
/* 270 */     String result = this.wishOrderAuditService.auditWishOrder(ip, userAgent, wishOrderId, auditNodeRemark, auditResult, projectCode, isSpecialMan, trademark, projectListing);
/* 271 */     if (!EnumAuditWishOrder.SUCCESS.getValue().equals(result)) {
/* 272 */       model.put("message", result);
/* 273 */       return "error";
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 278 */       TradeWishOrder tradeWishOrder = this.tradeWishOrderService.getTradeWishOrderById(wishOrderId);
/* 279 */       UserAccount userAccount = this.userAccountService.getUserByAccount(tradeWishOrder.getUserAccount());
/* 280 */       List nums = new ArrayList();
/* 281 */       nums.add(userAccount.getMobile());
/* 282 */       WishOrderAudit query = new WishOrderAudit();
/* 283 */       query.setOrderId(wishOrderId);
/* 284 */       WishOrderAudit resultAudit = this.wishOrderAuditService.selectWishOrderAuditInAudit(query);
/* 285 */       String msg = "尊敬的" + userAccount.getName() + "您好，您报名的挂牌项目" + projectListing.getTitle() + "的意向单";
/*     */ 
/* 287 */       if (EnumAuditRes.NO.getValue().equals(auditResult))
/*     */       {
/* 289 */         msg = msg + "未通过审核【中部林业产权交易服务中心】";
/* 290 */         this.mobileMessageUtil.sendMsg(nums, msg);
/* 291 */       } else if (EnumProcessAuditNodes.END_AUDIT.getValue().equals(resultAudit.getAuditNode()))
/*     */       {
/* 293 */         msg = msg + "已通过审核，请及时关注交易动态【中部林业产权交易服务中心】";
/* 294 */         this.mobileMessageUtil.sendMsg(nums, msg);
/*     */       }
/*     */     } catch (Exception e) {
/* 297 */       this.log.error("send mobileMessage for tradeWishOrder audit error cause by:" + e);
/*     */     }
/*     */ 
/* 300 */     return "success";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.trade.TradeWishOrderAction
 * JD-Core Version:    0.6.0
 */