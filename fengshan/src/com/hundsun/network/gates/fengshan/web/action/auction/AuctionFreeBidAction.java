/*    */ package com.hundsun.network.gates.fengshan.web.action.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBid;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.auction.AuctionFreeBidService;
/*    */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*    */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*    */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceAuditStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*    */ import com.hundsun.network.gates.luosi.common.remote.AjaxResult;
/*    */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class AuctionFreeBidAction extends BaseAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AuctionFreeBidService auctionFreeBidService;
/*    */ 
/*    */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_NULIT_AUCTION_BID})
/*    */   @RequestMapping({"auction/freeBid"})
/*    */   @ResponseBody
/*    */   public AjaxResult freeBid(@RequestParam("price") Long price, @RequestParam("wishOrderNum") String wishOrderNum, HttpServletRequest httpServletRequest, UserAgent userAgent)
/*    */   {
/* 46 */     AjaxResult result = new AjaxResult();
/* 47 */     AuctionFreeBid auctionFreeBid = new AuctionFreeBid();
/* 48 */     auctionFreeBid.setBidderAccount(userAgent.getAccount());
/* 49 */     auctionFreeBid.setBidOperatorAccount(userAgent.getAccount());
/* 50 */     auctionFreeBid.setStatus(EnumBidPriceStatus.EFFECTIVE.getValue());
/* 51 */     auctionFreeBid.setCheckStatus(EnumBidPriceAuditStatus.PASS.getValue());
/* 52 */     auctionFreeBid.setIp(CommonUtils.getIpAddr(httpServletRequest));
/* 53 */     auctionFreeBid.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 54 */     auctionFreeBid.setPrice(price);
/* 55 */     result.setServiceResult(this.auctionFreeBidService.freeBid(auctionFreeBid, wishOrderNum));
/* 56 */     return result;
/*    */   }
/*    */ 
/*    */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_NULIT_AUCTION_BID})
/*    */   @RequestMapping({"auction/latestFreeBid"})
/*    */   @ResponseBody
/*    */   public AuctionFreeBid latestFreeBid(@RequestParam("trademark") String trademark, UserAgent userAgent)
/*    */   {
/* 69 */     return this.auctionFreeBidService.latestFreeBid(trademark);
/*    */   }
/*    */ 
/*    */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_NULIT_AUCTION_BID})
/*    */   @RequestMapping({"auction/canFreeBid"})
/*    */   @ResponseBody
/*    */   public AjaxResult canFreeBid(@RequestParam("wishOrderNum") String wishOrderNum)
/*    */   {
/* 81 */     AjaxResult result = new AjaxResult();
/* 82 */     result.setServiceResult(this.auctionFreeBidService.canFreeBid(wishOrderNum));
/* 83 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.auction.AuctionFreeBidAction
 * JD-Core Version:    0.6.0
 */