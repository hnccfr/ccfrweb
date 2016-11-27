/*     */ package com.hundsun.network.gates.genshan.web.action.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionResult;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.AuctionBidRecordHisQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.auction.AuctionBidRecordHisService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.auction.AuctionResultService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionResultTranResult;
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
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_U_PROJECT_AUCTION_BIDHIS})
/*     */   @RequestMapping(value={"auction/bidrecordhis"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String buyBidRecordHisList(@RequestParam(value="returnUrl", required=true) String returnUrl, @RequestParam(value="projectCode", required=true) String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/*  47 */     model.addAttribute("returnUrl", returnUrl);
/*  48 */     model.addAttribute("EnumAuctionResultTranResultMap", EnumAuctionResultTranResult.toMap());
/*  49 */     AuctionBidRecordHisQuery brhquery = new AuctionBidRecordHisQuery();
/*  50 */     if (StringUtil.isNotBlank(projectCode)) {
/*  51 */       brhquery.setProjectCode(projectCode);
/*  52 */       ProjectListing listing = this.projectListingDAO.selectProjectListingByCode(projectCode);
/*     */ 
/*  54 */       Long substationId = getSubstationId(userAgent);
/*     */ 
/*  56 */       if ((substationId != null) && (!substationId.equals(listing.getSubstationId()))) {
/*  57 */         return "accessDenied";
/*     */       }
/*     */ 
/*  60 */       model.addAttribute("listing", listing);
/*     */ 
/*  62 */       this.auctionBidRecordHisService.queryBidRecordHis(brhquery);
/*     */ 
/*  64 */       AuctionResult auctionResult = this.auctionResultService.selectByProjectCode(projectCode);
/*  65 */       model.addAttribute("auctionResult", auctionResult);
/*     */     }
/*  67 */     model.addAttribute("brhquery", brhquery);
/*  68 */     return "/auction/bidrecordhis";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_U_PROJECT_AUCTION_BIDHIS})
/*     */   @RequestMapping(value={"auction/bidrecordhis"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String buyBidRecordHisList(@RequestParam(value="returnUrl", required=true) String returnUrl, @ModelAttribute("brhquery") AuctionBidRecordHisQuery brhquery, UserAgent userAgent, ModelMap model)
/*     */   {
/*  84 */     model.addAttribute("returnUrl", returnUrl);
/*  85 */     model.addAttribute("EnumAuctionResultTranResultMap", EnumAuctionResultTranResult.toMap());
/*  86 */     if (StringUtil.isNotBlank(brhquery.getProjectCode())) {
/*  87 */       ProjectListing listing = this.projectListingDAO.selectProjectListingByCode(brhquery.getProjectCode());
/*     */ 
/*  89 */       Long substationId = getSubstationId(userAgent);
/*     */ 
/*  91 */       if ((substationId != null) && (!substationId.equals(listing.getSubstationId()))) {
/*  92 */         return "accessDenied";
/*     */       }
/*     */ 
/*  95 */       model.addAttribute("listing", listing);
/*     */ 
/*  97 */       this.auctionBidRecordHisService.queryBidRecordHis(brhquery);
/*     */ 
/*  99 */       AuctionResult auctionResult = this.auctionResultService.selectByProjectCode(brhquery.getProjectCode());
/* 100 */       model.addAttribute("auctionResult", auctionResult);
/*     */     }
/* 102 */     return "/auction/bidrecordhis";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.auction.AuctionBidRecordHisAction
 * JD-Core Version:    0.6.0
 */