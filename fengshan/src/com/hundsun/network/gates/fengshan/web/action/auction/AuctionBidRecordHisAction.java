/*     */ package com.hundsun.network.gates.fengshan.web.action.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionResult;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidRecordHisQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumLoginOutAuction;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.auction.AuctionBidRecordHisService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.auction.AuctionResultService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.trade.TradeWishOrderService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionResultTranResult;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeDirect;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class AuctionBidRecordHisAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidRecordHisService auctionBidRecordHisService;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionResultService auctionResultService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderService tradeWishOrderService;
/*     */ 
/*     */   private void setDataGet(String returnUrl, String projectCode, ModelMap model)
/*     */   {
/*  48 */     AuctionBidRecordHisQuery brhquery = new AuctionBidRecordHisQuery();
/*  49 */     if (StringUtil.isNotBlank(projectCode)) {
/*  50 */       brhquery.setProjectCode(projectCode);
/*     */ 
/*  52 */       this.auctionBidRecordHisService.queryBidRecordHis(brhquery);
/*     */ 
/*  54 */       AuctionResult auctionResult = this.auctionResultService.selectByProjectCode(projectCode);
/*  55 */       model.addAttribute("auctionResult", auctionResult);
/*     */     }
/*  57 */     model.addAttribute("brhquery", brhquery);
/*     */   }
/*     */ 
/*     */   private void setDataPost(String returnUrl, AuctionBidRecordHisQuery brhquery, ModelMap model)
/*     */   {
/*  67 */     if (StringUtil.isNotBlank(brhquery.getProjectCode()))
/*     */     {
/*  69 */       this.auctionBidRecordHisService.queryBidRecordHis(brhquery);
/*     */ 
/*  71 */       AuctionResult auctionResult = this.auctionResultService.selectByProjectCode(brhquery.getProjectCode());
/*  72 */       model.addAttribute("auctionResult", auctionResult);
/*     */     }
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_P_PROJECT_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"auction/wishorder/bidrecordhis"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String buyBidRecordHisList(@RequestParam(value="returnUrl", required=true) String returnUrl, @RequestParam(value="projectCode", required=true) String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/*  89 */     model.addAttribute("returnUrl", returnUrl);
/*  90 */     model.addAttribute("EnumAuctionResultTranResultMap", EnumAuctionResultTranResult.toMap());
/*     */ 
/*  93 */     int count = this.tradeWishOrderService.existsWishOrderBidBuyer(projectCode, userAgent.getAccount());
/*  94 */     if (count > 0) {
/*  95 */       ProjectListing listing = this.projectListingService.getProjectListingByCode(projectCode);
/*  96 */       model.addAttribute("listing", listing);
/*  97 */       if (listing == null) {
/*  98 */         model.addAttribute("message", "拍卖项目不存在");
/*  99 */         return "error";
/*     */       }
/*     */ 
/* 102 */       setDataGet(returnUrl, projectCode, model);
/*     */     } else {
/* 104 */       model.addAttribute("message", "您未参加本次拍卖活动");
/* 105 */       return "error";
/*     */     }
/* 107 */     return "auction/wishorder/bidrecordhis";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_P_PROJECT_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"auction/wishorder/bidrecordhis"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String buyBidRecordHisList(@RequestParam(value="returnUrl", required=true) String returnUrl, @ModelAttribute("brhquery") AuctionBidRecordHisQuery brhquery, UserAgent userAgent, ModelMap model)
/*     */   {
/* 123 */     model.addAttribute("returnUrl", returnUrl);
/* 124 */     model.addAttribute("EnumAuctionResultTranResultMap", EnumAuctionResultTranResult.toMap());
/*     */ 
/* 127 */     int count = this.tradeWishOrderService.existsWishOrderBidBuyer(brhquery.getProjectCode(), userAgent.getAccount());
/* 128 */     if (count > 0) {
/* 129 */       ProjectListing listing = this.projectListingService.getProjectListingByCode(brhquery.getProjectCode());
/* 130 */       model.addAttribute("listing", listing);
/* 131 */       if (listing == null) {
/* 132 */         model.addAttribute("message", "拍卖项目不存在");
/* 133 */         return "error";
/*     */       }
/*     */ 
/* 136 */       setDataPost(returnUrl, brhquery, model);
/*     */     } else {
/* 138 */       model.addAttribute("message", "您未参加本次拍卖活动");
/* 139 */       return "error";
/*     */     }
/* 141 */     return "auction/wishorder/bidrecordhis";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_P_PROJECT_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"auction/project/bidrecordhis"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String sellBidRecordHisList(@RequestParam(value="returnUrl", required=true) String returnUrl, @RequestParam(value="projectCode", required=true) String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/* 157 */     model.addAttribute("returnUrl", returnUrl);
/* 158 */     model.addAttribute("EnumAuctionResultTranResultMap", EnumAuctionResultTranResult.toMap());
/*     */ 
/* 161 */     ProjectListing listing = this.projectListingService.getProjectListingByCode(projectCode);
/* 162 */     if (listing == null) {
/* 163 */       model.addAttribute("message", "拍卖项目不存在");
/* 164 */       return "error";
/*     */     }
/*     */ 
/* 167 */     if (userAgent.getAccount().equals(listing.getUserAccount())) {
/* 168 */       model.addAttribute("listing", listing);
/*     */ 
/* 170 */       setDataGet(returnUrl, projectCode, model);
/*     */     } else {
/* 172 */       model.addAttribute("message", "该挂牌项目归属者不是你");
/* 173 */       return "error";
/*     */     }
/* 175 */     return "auction/project/bidrecordhis";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_P_PROJECT_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"auction/project/bidrecordhis"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String sellBidRecordHisList(@RequestParam(value="returnUrl", required=true) String returnUrl, @ModelAttribute("brhquery") AuctionBidRecordHisQuery brhquery, UserAgent userAgent, ModelMap model)
/*     */   {
/* 191 */     model.addAttribute("returnUrl", returnUrl);
/* 192 */     model.addAttribute("EnumAuctionResultTranResultMap", EnumAuctionResultTranResult.toMap());
/*     */ 
/* 194 */     ProjectListing listing = this.projectListingService.getProjectListingByCode(brhquery.getProjectCode());
/* 195 */     if (listing == null) {
/* 196 */       model.addAttribute("message", "拍卖项目不存在");
/* 197 */       return "error";
/*     */     }
/*     */ 
/* 200 */     if (userAgent.getAccount().equals(listing.getUserAccount())) {
/* 201 */       model.addAttribute("listing", listing);
/*     */ 
/* 203 */       setDataPost(returnUrl, brhquery, model);
/*     */     } else {
/* 205 */       model.addAttribute("message", "该挂牌项目归属者不是你");
/* 206 */       return "error";
/*     */     }
/* 208 */     return "auction/project/bidrecordhis";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_P_PROJECT_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"auction/auctioneer/bidrecordhis"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String aucterBidRecordHisList(@RequestParam(value="returnUrl", required=true) String returnUrl, @RequestParam(value="projectCode", required=true) String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/* 225 */     model.addAttribute("returnUrl", returnUrl);
/* 226 */     model.addAttribute("EnumAuctionResultTranResultMap", EnumAuctionResultTranResult.toMap());
/* 227 */     int count = this.projectListingService.existsAuctioner(projectCode, userAgent.getAccount());
/* 228 */     if (count > 0) {
/* 229 */       ProjectListing listing = this.projectListingService.getProjectListingByCode(projectCode);
/* 230 */       model.addAttribute("listing", listing);
/* 231 */       if (listing == null) {
/* 232 */         model.addAttribute("message", "拍卖项目不存在");
/* 233 */         return "error";
/*     */       }
/*     */ 
/* 236 */       setDataGet(returnUrl, projectCode, model);
/* 237 */       return "auction/auctioneer/bidrecordhis";
/*     */     }
/* 239 */     model.addAttribute("message", "您无权权限操作本页面");
/* 240 */     return "error";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_P_PROJECT_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"auction/auctioneer/bidrecordhis"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String aucterBidRecordHisList(@RequestParam(value="returnUrl", required=true) String returnUrl, @ModelAttribute("brhquery") AuctionBidRecordHisQuery brhquery, UserAgent userAgent, ModelMap model)
/*     */   {
/* 257 */     model.addAttribute("returnUrl", returnUrl);
/* 258 */     model.addAttribute("EnumAuctionResultTranResultMap", EnumAuctionResultTranResult.toMap());
/* 259 */     int count = this.projectListingService.existsAuctioner(brhquery.getProjectCode(), userAgent.getAccount());
/* 260 */     if (count > 0) {
/* 261 */       ProjectListing listing = this.projectListingService.getProjectListingByCode(brhquery.getProjectCode());
/* 262 */       model.addAttribute("listing", listing);
/* 263 */       if (listing == null) {
/* 264 */         model.addAttribute("message", "拍卖项目不存在");
/* 265 */         return "error";
/*     */       }
/*     */ 
/* 268 */       setDataPost(returnUrl, brhquery, model);
/* 269 */       return "auction/auctioneer/bidrecordhis";
/*     */     }
/* 271 */     model.addAttribute("message", "您无权权限操作本页面");
/* 272 */     return "error";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_AUCTION_QUIT})
/*     */   @RequestMapping(value={"auction/loginOut"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String loginOutOfAuction(UserAgent userAgent, @RequestParam("wishOrderNum") String wishOrderNum, ModelMap model)
/*     */   {
/* 291 */     if (null == wishOrderNum) {
/* 292 */       model.put("message", "意向单号不存在");
/* 293 */       return "error";
/*     */     }
/* 295 */     TradeWishOrder tradeWishOrder = this.tradeWishOrderService.getTradeWishOrderByOrderNum(wishOrderNum);
/* 296 */     if (null == tradeWishOrder) {
/* 297 */       model.put("message", "意向单不存在");
/* 298 */       return "error";
/*     */     }
/* 300 */     String url = "/tradeWishOrder/";
/* 301 */     if (EnumTradeDirect.SELL.getValue().equals(tradeWishOrder.getTradeDictor()))
/* 302 */       url = url + EnumTradeDirect.SELL.getValue();
/*     */     else {
/* 304 */       url = url + EnumTradeDirect.BUY.getValue();
/*     */     }
/* 306 */     model.put("url", url);
/* 307 */     if (EnumTradeWishOrderStatus.CREATE.getValue().equals(tradeWishOrder.getStatus())) {
/* 308 */       tradeWishOrder.setStatus(EnumTradeWishOrderStatus.SFCANCEL.getValue());
/* 309 */       this.tradeWishOrderService.changeWishOrderStatus(tradeWishOrder);
/* 310 */       return "success";
/*     */     }
/* 312 */     if (EnumTradeWishOrderStatus.SFCANCEL.getValue().equals(tradeWishOrder.getStatus())) {
/* 313 */       model.put("message", "您已经退出了,请不要重复操作");
/* 314 */       return "error";
/*     */     }
/* 316 */     String result = this.auctionBidRecordHisService.loginOut(tradeWishOrder, userAgent);
/* 317 */     if (EnumLoginOutAuction.SUCCESS.getValue().equals(result)) {
/* 318 */       return "success";
/*     */     }
/* 320 */     model.put("message", result);
/* 321 */     return "error";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.auction.AuctionBidRecordHisAction
 * JD-Core Version:    0.6.0
 */