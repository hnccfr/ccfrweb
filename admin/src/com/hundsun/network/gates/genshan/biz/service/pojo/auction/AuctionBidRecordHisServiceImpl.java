/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionBidRecordHisDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.AuctionBidRecordHisQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.auction.AuctionBidRecordHisService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("auctionBidRecordHisService")
/*    */ public class AuctionBidRecordHisServiceImpl extends BaseService
/*    */   implements AuctionBidRecordHisService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AuctionBidRecordHisDAO auctionBidRecordHisDAO;
/*    */ 
/*    */   public void queryBidRecordHis(AuctionBidRecordHisQuery query)
/*    */   {
/* 22 */     this.auctionBidRecordHisDAO.queryBidRecordHis(query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.auction.AuctionBidRecordHisServiceImpl
 * JD-Core Version:    0.6.0
 */