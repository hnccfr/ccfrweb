/*     */ package com.hundsun.network.gates.fengshan.web.action.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionFreeBidDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionFreeBidHisDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBidHis;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidderQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionFreeBidQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionMulitBidProjectQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectListingQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.auction.AuctionBidderService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.enums.PermissionEnum;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidCheckStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.AjaxResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AuctionMulitBidRequest;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class AuctionProjectListingAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionFreeBidDAO auctionFreeBidDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionFreeBidHisDAO auctionFreeBidHisDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidderService auctionBidderService;
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_P_PROJECT_LIST_WAIT})
/*     */   @RequestMapping({"/auction/auctioneer/waitprojectlist"})
/*     */   public void waitprojectlist(@ModelAttribute("query") ProjectListingQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/*  64 */     model.addAttribute("EnumProjectStatusMap", EnumProjectStatus.toMap());
/*  65 */     model.addAttribute("EnumTradingTypeMap", EnumTradingType.toMap());
/*     */ 
/*  67 */     String[] tradingTypeArr = { EnumTradingType.BID_ORDER.getValue(), EnumTradingType.MULIT_BID_ORDER.getValue() };
/*  68 */     query.setTradingTypeArr(tradingTypeArr);
/*  69 */     query.setStatus(EnumProjectStatus.TRADE.getValue());
/*  70 */     query.setAuctioneerAccount(userAgent.getAccount());
/*  71 */     query.setAuctioneerAccountKey(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*  72 */     query.setHaveAuctioneerKey(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/*  73 */     query.setApplyStartTimeKey(EnumBidOrderProperty.BID_START_TIME.getKey());
/*  74 */     this.projectListingService.selectAuctionProjectlist(query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_P_PROJECT_LIST_CLOSE})
/*     */   @RequestMapping({"/auction/auctioneer/closeprojectlist"})
/*     */   public void closeprojectlist(@ModelAttribute("query") ProjectListingQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/*  88 */     model.addAttribute("EnumProjectStatusMap", EnumProjectStatus.toMap());
/*  89 */     model.addAttribute("EnumTradingTypeMap", EnumTradingType.toMap());
/*     */ 
/*  91 */     String[] tradingTypeArr = { EnumTradingType.BID_ORDER.getValue(), EnumTradingType.MULIT_BID_ORDER.getValue() };
/*  92 */     query.setTradingTypeArr(tradingTypeArr);
/*  93 */     query.setStatus(EnumProjectStatus.OVER.getValue());
/*  94 */     query.setAuctioneerAccount(userAgent.getAccount());
/*  95 */     query.setAuctioneerAccountKey(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*  96 */     query.setHaveAuctioneerKey(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/*  97 */     query.setApplyStartTimeKey(EnumBidOrderProperty.APPLY_START_TIME.getKey());
/*  98 */     this.projectListingService.selectAuctionProjectlist(query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_WAIT})
/*     */   @RequestMapping({"/auction/reviewer/waitreviewprolist"})
/*     */   public String reviewwaitprojectlist(@ModelAttribute("query") AuctionMulitBidProjectQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 112 */     model.addAttribute("EnumProjectStatusMap", EnumProjectStatus.toMap());
/* 113 */     model.addAttribute("EnumTradingTypeMap", EnumTradingType.toMap());
/* 114 */     query.setReviewer(userAgent.getAccount());
/* 115 */     this.projectListingService.queryAuctionMulitBidProjectUnchecked(query);
/* 116 */     return "auction/reviewer/waitreviewprolist";
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_CLOSE})
/*     */   @RequestMapping({"/auction/reviewer/closereviewprolist"})
/*     */   public void reviewcloseprojectlist(@ModelAttribute("query") AuctionMulitBidProjectQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 130 */     model.addAttribute("EnumProjectStatusMap", EnumProjectStatus.toMap());
/* 131 */     model.addAttribute("EnumTradingTypeMap", EnumTradingType.toMap());
/* 132 */     query.setReviewer(userAgent.getAccount());
/* 133 */     this.projectListingService.queryAuctionMulitBidProjectChecked(query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_WAITU, PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_WAIT})
/*     */   @RequestMapping({"/auction/reviewer/waituserprolist"})
/*     */   public String waitreviewprolist(@ModelAttribute("query") AuctionMulitBidProjectQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 148 */     if (userAgent.haveFunction(PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_WAIT)) {
/* 149 */       return reviewwaitprojectlist(query, userAgent, model);
/*     */     }
/* 151 */     if (userAgent.haveFunction(PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_WAITU)) {
/* 152 */       model.addAttribute("EnumProjectStatusMap", EnumProjectStatus.toMap());
/* 153 */       model.addAttribute("EnumTradingTypeMap", EnumTradingType.toMap());
/* 154 */       query.setReviewer(userAgent.getAccount());
/* 155 */       query.setUserAccount(userAgent.getAccount());
/* 156 */       this.projectListingService.queryAuctionMulitBidProjectUnchecked(query);
/* 157 */       return "auction/reviewer/waituserprolist";
/*     */     }
/* 159 */     return "403";
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_CLOSEU})
/*     */   @RequestMapping({"/auction/reviewer/closeuserprolist"})
/*     */   public void closereviewprolist(@ModelAttribute("query") AuctionMulitBidProjectQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 173 */     model.addAttribute("EnumProjectStatusMap", EnumProjectStatus.toMap());
/* 174 */     model.addAttribute("EnumTradingTypeMap", EnumTradingType.toMap());
/* 175 */     query.setReviewer(userAgent.getAccount());
/* 176 */     query.setUserAccount(userAgent.getAccount());
/* 177 */     this.projectListingService.queryAuctionMulitBidProjectChecked(query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"/auction/reviewer/freebidhis"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void freebidhis(@RequestParam(value="returnUrl", required=true) String returnUrl, @RequestParam(value="projectCode", required=true) String projectCode, @RequestParam(value="from", required=true) String from, UserAgent userAgent, ModelMap model)
/*     */   {
/* 193 */     model.addAttribute("EnumBidPriceStatusMap", EnumBidPriceStatus.toMap());
/* 194 */     model.addAttribute("EnumBidCheckStatusMap", EnumBidCheckStatus.toMap());
/* 195 */     ProjectListing listing = this.projectListingService.getProjectListingByCode(projectCode);
/* 196 */     model.addAttribute("listing", listing);
/* 197 */     AuctionFreeBidQuery brhquery = new AuctionFreeBidQuery();
/* 198 */     brhquery.setProjectCode(projectCode);
/* 199 */     brhquery.setFrom(from);
/* 200 */     brhquery.setReturnUrl(returnUrl);
/* 201 */     if (this.auctionFreeBidHisDAO.selectBidCountByProjectCode(brhquery.getProjectCode()) > 0) {
/* 202 */       if (brhquery.getFrom().equals("user"))
/*     */       {
/* 204 */         if (userAgent.getAccount().equals(listing.getUserAccount()))
/*     */         {
/* 206 */           this.auctionFreeBidHisDAO.queryFreeBidHisList(brhquery);
/*     */         }
/*     */         else {
/* 209 */           int aa = this.auctionFreeBidHisDAO.selectFreeBidHisCount(userAgent.getAccount(), brhquery.getProjectCode());
/* 210 */           if (aa > 0) {
/* 211 */             brhquery.setBidderAccount(userAgent.getAccount());
/* 212 */             this.auctionFreeBidHisDAO.queryFreeBidHisList(brhquery);
/*     */           }
/*     */         }
/* 215 */       } else if (brhquery.getFrom().equals("reviewer"))
/*     */       {
/* 217 */         this.auctionFreeBidHisDAO.queryFreeBidHisList(brhquery);
/*     */       }
/*     */     }
/* 220 */     else if (brhquery.getFrom().equals("user"))
/*     */     {
/* 222 */       if (userAgent.getAccount().equals(listing.getUserAccount()))
/*     */       {
/* 224 */         this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */       }
/*     */       else {
/* 227 */         int aa = this.auctionFreeBidDAO.selectFreeBidCount(userAgent.getAccount(), brhquery.getProjectCode());
/* 228 */         if (aa > 0) {
/* 229 */           brhquery.setBidderAccount(userAgent.getAccount());
/* 230 */           this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */         }
/*     */       }
/* 233 */     } else if (brhquery.getFrom().equals("reviewer"))
/*     */     {
/* 235 */       this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */     }
/*     */ 
/* 238 */     model.addAttribute("brhquery", brhquery);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"/auction/reviewer/freebidhis"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void freebidhis(@ModelAttribute("brhquery") AuctionFreeBidQuery brhquery, UserAgent userAgent, ModelMap model)
/*     */   {
/* 253 */     model.addAttribute("EnumBidPriceStatusMap", EnumBidPriceStatus.toMap());
/* 254 */     model.addAttribute("EnumBidCheckStatusMap", EnumBidCheckStatus.toMap());
/* 255 */     ProjectListing listing = this.projectListingService.getProjectListingByCode(brhquery.getProjectCode());
/* 256 */     model.addAttribute("listing", listing);
/* 257 */     brhquery.setProjectCode(brhquery.getProjectCode());
/* 258 */     if (this.auctionFreeBidHisDAO.selectBidCountByProjectCode(brhquery.getProjectCode()) > 0) {
/* 259 */       if (brhquery.getFrom().equals("user"))
/*     */       {
/* 261 */         if (userAgent.getAccount().equals(listing.getUserAccount()))
/*     */         {
/* 263 */           this.auctionFreeBidHisDAO.queryFreeBidHisList(brhquery);
/*     */         }
/*     */         else {
/* 266 */           int aa = this.auctionFreeBidHisDAO.selectFreeBidHisCount(userAgent.getAccount(), brhquery.getProjectCode());
/* 267 */           if (aa > 0) {
/* 268 */             brhquery.setBidderAccount(userAgent.getAccount());
/* 269 */             this.auctionFreeBidHisDAO.queryFreeBidHisList(brhquery);
/*     */           }
/*     */         }
/* 272 */       } else if (brhquery.getFrom().equals("reviewer"))
/*     */       {
/* 274 */         this.auctionFreeBidHisDAO.queryFreeBidHisList(brhquery);
/*     */       }
/*     */     }
/* 277 */     else if (brhquery.getFrom().equals("user"))
/*     */     {
/* 279 */       if (userAgent.getAccount().equals(listing.getUserAccount()))
/*     */       {
/* 281 */         this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */       }
/*     */       else {
/* 284 */         int aa = this.auctionFreeBidDAO.selectFreeBidCount(userAgent.getAccount(), brhquery.getProjectCode());
/* 285 */         if (aa > 0) {
/* 286 */           brhquery.setBidderAccount(userAgent.getAccount());
/* 287 */           this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */         }
/*     */       }
/* 290 */     } else if (brhquery.getFrom().equals("reviewer"))
/*     */     {
/* 292 */       this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */     }
/*     */ 
/* 295 */     model.addAttribute("brhquery", brhquery);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"/auction/reviewer/freebid"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void freebid(@RequestParam(value="returnUrl", required=true) String returnUrl, @RequestParam(value="projectCode", required=true) String projectCode, @RequestParam(value="from", required=true) String from, UserAgent userAgent, ModelMap model)
/*     */   {
/* 311 */     model.addAttribute("EnumBidPriceStatusMap", EnumBidPriceStatus.toMap());
/* 312 */     model.addAttribute("EnumBidCheckStatusMap", EnumBidCheckStatus.toMap());
/* 313 */     ProjectListing listing = this.projectListingService.getProjectListingByCode(projectCode);
/* 314 */     model.addAttribute("listing", listing);
/* 315 */     AuctionFreeBidQuery brhquery = new AuctionFreeBidQuery();
/* 316 */     brhquery.setProjectCode(projectCode);
/* 317 */     brhquery.setFrom(from);
/* 318 */     brhquery.setReturnUrl(returnUrl);
/* 319 */     if (from.equals("user"))
/*     */     {
/* 321 */       if (userAgent.getAccount().equals(listing.getUserAccount()))
/*     */       {
/* 323 */         this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */       }
/*     */       else {
/* 326 */         int aa = this.auctionFreeBidDAO.selectFreeBidCount(userAgent.getAccount(), projectCode);
/* 327 */         if (aa > 0) {
/* 328 */           brhquery.setBidderAccount(userAgent.getAccount());
/* 329 */           this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */         }
/*     */       }
/* 332 */     } else if (from.equals("reviewer"))
/*     */     {
/* 334 */       this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */     }
/* 336 */     model.addAttribute("brhquery", brhquery);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_VIEW_BIDHIS})
/*     */   @RequestMapping(value={"/auction/reviewer/freebid"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void freebid(@ModelAttribute("brhquery") AuctionFreeBidQuery brhquery, UserAgent userAgent, ModelMap model)
/*     */   {
/* 350 */     model.addAttribute("EnumBidPriceStatusMap", EnumBidPriceStatus.toMap());
/* 351 */     model.addAttribute("EnumBidCheckStatusMap", EnumBidCheckStatus.toMap());
/* 352 */     ProjectListing listing = this.projectListingService.getProjectListingByCode(brhquery.getProjectCode());
/* 353 */     model.addAttribute("listing", listing);
/* 354 */     brhquery.setProjectCode(brhquery.getProjectCode());
/* 355 */     if (brhquery.getFrom().equals("user"))
/*     */     {
/* 357 */       if (userAgent.getAccount().equals(listing.getUserAccount()))
/*     */       {
/* 359 */         this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */       }
/*     */       else {
/* 362 */         int aa = this.auctionFreeBidDAO.selectFreeBidCount(userAgent.getAccount(), brhquery.getProjectCode());
/* 363 */         if (aa > 0) {
/* 364 */           brhquery.setBidderAccount(userAgent.getAccount());
/* 365 */           this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */         }
/*     */       }
/* 368 */     } else if (brhquery.getFrom().equals("reviewer"))
/*     */     {
/* 370 */       this.auctionFreeBidDAO.queryFreeBidList(brhquery);
/*     */     }
/* 372 */     model.addAttribute("brhquery", brhquery);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_VIEW_BIDHIS})
/*     */   @RequestMapping({"/auction/freebiddialog"})
/*     */   @ResponseBody
/*     */   public Map freebiddialog(@RequestParam("projectCode") String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/* 385 */     Map dataMap = new HashMap();
/* 386 */     AuctionFreeBidHis freeBidHis = this.auctionFreeBidHisDAO.selectLastBidRecord(userAgent.getAccount(), projectCode);
/* 387 */     ProjectListing pl = this.projectListingService.getProjectListingByCode(projectCode);
/* 388 */     if ((freeBidHis != null) && (freeBidHis.getPrice() != null)) {
/* 389 */       String priceDesc = CommonUtils.getValuationUnitDesc(freeBidHis.getPrice(), pl.getValuationUnit());
/* 390 */       dataMap.put("priceDesc", priceDesc);
/*     */     }
/* 392 */     return dataMap;
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_BIDDER_WAIT})
/*     */   @RequestMapping({"/auction/reviewer/reviewList"})
/*     */   public void waitReviewBidRecords(@RequestParam("projectCode") String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/* 404 */     AuctionBidderQuery query = new AuctionBidderQuery();
/* 405 */     query.setProjectCode(projectCode);
/* 406 */     this.auctionBidderService.getBiddersByQuery(query);
/* 407 */     ProjectListing pl = this.projectListingService.getProjectListingByCode(projectCode);
/* 408 */     query.setValuationUnit(pl.getValuationUnit());
/* 409 */     model.addAttribute("query", query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_BIDDER_WAIT})
/*     */   @RequestMapping({"/auction/reviewer/reviewQuery"})
/*     */   public String queryWaitReviewBidRecords(@ModelAttribute("query") AuctionBidderQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 422 */     this.auctionBidderService.getBiddersByQuery(query);
/* 423 */     model.addAttribute("query", query);
/* 424 */     return "/auction/reviewer/reviewList";
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_BIDDER_WAITU})
/*     */   @RequestMapping({"/auction/reviewer/listerReviewList"})
/*     */   public void listerWaitReviewBidRecords(@RequestParam("projectCode") String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/* 436 */     AuctionBidderQuery query = new AuctionBidderQuery();
/* 437 */     query.setProjectCode(projectCode);
/* 438 */     this.auctionBidderService.getBiddersByQuery(query);
/* 439 */     ProjectListing pl = this.projectListingService.getProjectListingByCode(projectCode);
/* 440 */     query.setValuationUnit(pl.getValuationUnit());
/* 441 */     model.addAttribute("query", query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_R_PROJECT_REVIEWER_LIST_BIDDER_WAITU})
/*     */   @RequestMapping({"/auction/reviewer/listerReviewQuery"})
/*     */   public String listerQueryWaitReviewBidRecords(@ModelAttribute("query") AuctionBidderQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 455 */     this.auctionBidderService.getBiddersByQuery(query);
/* 456 */     model.addAttribute("query", query);
/* 457 */     return "/auction/reviewer/listerReviewList";
/*     */   }
/*     */ 
/*     */   @SystemAccess({PermissionEnum.BIZ_U_PROJECT_REVIEWER_REVIEW_BIDDER})
/*     */   @RequestMapping(value={"/auction/reviewer/review"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxResult review(@ModelAttribute("request") AuctionMulitBidRequest request, @ModelAttribute("operator") String operator, HttpServletRequest httpServletRequest, UserAgent userAgent)
/*     */   {
/* 474 */     AjaxResult result = new AjaxResult();
/*     */ 
/* 476 */     if ("reviewer".equals(operator))
/* 477 */       request.setOperator(EnumOperatorType.REVIEWER.getValue());
/* 478 */     else if ("listinger".equals(operator)) {
/* 479 */       request.setOperator(EnumOperatorType.LISTINGER.getValue());
/*     */     }
/*     */ 
/* 482 */     request.setReviewer(userAgent.getAccount());
/* 483 */     result.setServiceResult(this.auctionBidderService.review(request));
/* 484 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.auction.AuctionProjectListingAction
 * JD-Core Version:    0.6.0
 */