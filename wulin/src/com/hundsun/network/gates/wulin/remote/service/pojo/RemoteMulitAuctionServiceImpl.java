/*    */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumAuctionErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AuctionMulitBidRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteMulitAuctionService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.auction.MulitAuctionService;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("remoteMulitAuctionService")
/*    */ public class RemoteMulitAuctionServiceImpl extends BaseService
/*    */   implements RemoteMulitAuctionService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private MulitAuctionService mulitAuctionService;
/*    */ 
/*    */   public ServiceResult review(AuctionMulitBidRequest request)
/*    */   {
/* 29 */     ServiceResult result = new ServiceResult();
/*    */     try {
/* 31 */       result = this.mulitAuctionService.review(request);
/*    */     } catch (Exception e) {
/* 33 */       this.log.error("", e);
/* 34 */       result.setErrorInfo(EnumAuctionErrors.INTERNAL_ERROR.getInfo());
/* 35 */       result.setErrorNO(Integer.valueOf(EnumAuctionErrors.INTERNAL_ERROR.getValue()));
/*    */     }
/* 37 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteMulitAuctionServiceImpl
 * JD-Core Version:    0.6.0
 */