/*    */ package com.hundsun.network.gates.taiping.remote.service.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.service.RemoteAuctionPushletService;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionMessageServiceRequest;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionResultServiceRequest;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallDataServiceRequest;
/*    */ import com.hundsun.network.gates.taiping.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.taiping.biz.service.auction.AuctionPushletService;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("remoteAuctionPushletService")
/*    */ public class RemoteAuctionPushletServiceImpl extends BaseService
/*    */   implements RemoteAuctionPushletService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AuctionPushletService auctionPushletService;
/*    */ 
/*    */   public ServiceResult sendAuctionLatestBid(HallDataServiceRequest request)
/*    */   {
/* 22 */     ServiceResult result = new ServiceResult();
/* 23 */     if (this.log.isDebugEnabled()) {
/* 24 */       this.log.debug("sendAuctionLatestBid !!!");
/*    */     }
/* 26 */     this.auctionPushletService.sendAuctionLatestBid(request);
/* 27 */     return result;
/*    */   }
/*    */ 
/*    */   public ServiceResult sendAuctionResult(AuctionResultServiceRequest request)
/*    */   {
/* 32 */     ServiceResult result = new ServiceResult();
/* 33 */     if (this.log.isDebugEnabled()) {
/* 34 */       this.log.debug("!!!!!!!!!!!!!!sendAuctionResult !!!");
/*    */     }
/* 36 */     this.auctionPushletService.sendAuctionResult(request);
/* 37 */     return result;
/*    */   }
/*    */ 
/*    */   public ServiceResult sendAuctionMessage(AuctionMessageServiceRequest request)
/*    */   {
/* 42 */     ServiceResult result = new ServiceResult();
/* 43 */     if (this.log.isDebugEnabled()) {
/* 44 */       this.log.debug("!!!!!!!!!!!!!!sendAuctionMessage !!!");
/*    */     }
/* 46 */     this.auctionPushletService.sendAuctionMessage(request);
/* 47 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.remote.service.pojo.RemoteAuctionPushletServiceImpl
 * JD-Core Version:    0.6.0
 */