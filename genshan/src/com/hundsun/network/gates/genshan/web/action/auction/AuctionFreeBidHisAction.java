/*    */ package com.hundsun.network.gates.genshan.web.action.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionFreeBidHisDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.AuctionFreeBidQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService;
/*    */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*    */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*    */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidCheckStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceStatus;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ @Controller
/*    */ public class AuctionFreeBidHisAction extends BaseAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectListingService projectListingService;
/*    */ 
/*    */   @Autowired
/*    */   private AuctionFreeBidHisDAO auctionFreeBidHisDAO;
/*    */ 
/*    */   @RequestMapping(value={"auction/freebidhis"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void freebidhis(@RequestParam(value="returnUrl", required=true) String returnUrl, @RequestParam(value="projectCode", required=true) String projectCode, UserAgent userAgent, ModelMap model)
/*    */   {
/* 40 */     model.addAttribute("EnumBidPriceStatusMap", EnumBidPriceStatus.toMap());
/* 41 */     model.addAttribute("EnumBidCheckStatusMap", EnumBidCheckStatus.toMap());
/* 42 */     ProjectListing listing = this.projectListingService.getProjectListingByCode(projectCode);
/* 43 */     model.addAttribute("listing", listing);
/* 44 */     AuctionFreeBidQuery brhquery = new AuctionFreeBidQuery();
/* 45 */     brhquery.setProjectCode(projectCode);
/* 46 */     brhquery.setReturnUrl(returnUrl);
/* 47 */     this.auctionFreeBidHisDAO.queryFreeBidHisList(brhquery);
/* 48 */     model.addAttribute("brhquery", brhquery);
/*    */   }
/*    */ 
/*    */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_REVIEWER_VIEW_BIDHIS})
/*    */   @RequestMapping(value={"auction/freebidhis"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void freebidhis(@ModelAttribute("brhquery") AuctionFreeBidQuery brhquery, UserAgent userAgent, ModelMap model)
/*    */   {
/* 62 */     model.addAttribute("EnumBidPriceStatusMap", EnumBidPriceStatus.toMap());
/* 63 */     model.addAttribute("EnumBidCheckStatusMap", EnumBidCheckStatus.toMap());
/* 64 */     ProjectListing listing = this.projectListingService.getProjectListingByCode(brhquery.getProjectCode());
/* 65 */     model.addAttribute("listing", listing);
/* 66 */     brhquery.setProjectCode(brhquery.getProjectCode());
/* 67 */     this.auctionFreeBidHisDAO.queryFreeBidHisList(brhquery);
/* 68 */     model.addAttribute("brhquery", brhquery);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.auction.AuctionFreeBidHisAction
 * JD-Core Version:    0.6.0
 */