/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionBidderDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidderQuery;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.auction.AuctionBidderService;
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumAuctionErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AuctionMulitBidRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteMulitAuctionService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("auctionBidderService")
/*    */ public class AuctionBidderServiceImpl extends BaseService
/*    */   implements AuctionBidderService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AuctionBidderDAO auctionBidderDAO;
/*    */ 
/*    */   @Autowired
/*    */   private RemoteMulitAuctionService remoteMulitAuctionService;
/*    */ 
/*    */   public void getBiddersByQuery(AuctionBidderQuery query)
/*    */   {
/* 27 */     this.auctionBidderDAO.selectByQuery(query);
/*    */   }
/*    */ 
/*    */   public ServiceResult review(AuctionMulitBidRequest request)
/*    */   {
/* 32 */     ServiceResult result = new ServiceResult();
/* 33 */     if ((null == request) || (StringUtil.isEmpty(request.getBidderAccount())) || (StringUtil.isEmpty(request.getProjectCode())) || (StringUtil.isEmpty(request.getReviewer())) || (StringUtil.isEmpty(request.getRemark())) || (request.getRemark().length() > 666))
/*    */     {
/* 38 */       result.setErrorNO(Integer.valueOf(EnumAuctionErrors.PARAMETER_ERROR.getValue()));
/* 39 */       result.setErrorInfo(EnumAuctionErrors.PARAMETER_ERROR.getInfo());
/* 40 */       return result;
/*    */     }
/*    */     try {
/* 43 */       result = this.remoteMulitAuctionService.review(request);
/*    */     } catch (Exception e) {
/* 45 */       e.printStackTrace();
/* 46 */       if (this.log.isErrorEnabled()) {
/* 47 */         this.log.error("", e);
/*    */       }
/* 49 */       result.setErrorNO(Integer.valueOf(EnumAuctionErrors.SERVER_ERROR.getValue()));
/* 50 */       result.setErrorInfo(EnumAuctionErrors.SERVER_ERROR.getInfo());
/* 51 */       return result;
/*    */     }
/* 53 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.auction.AuctionBidderServiceImpl
 * JD-Core Version:    0.6.0
 */