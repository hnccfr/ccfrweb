/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionBidRecordHisDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.AuctionBidRecordHisQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidRecordHisDAO")
/*    */ public class AuctionBidRecordHisDAOImpl extends BaseDAO
/*    */   implements AuctionBidRecordHisDAO
/*    */ {
/*    */   public void queryBidRecordHis(AuctionBidRecordHisQuery query)
/*    */   {
/* 14 */     paginate(query, "AUCTION_BID_RECORD_HIS.queryBidRecordHisCount", "AUCTION_BID_RECORD_HIS.queryBidRecordHis");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.auction.AuctionBidRecordHisDAOImpl
 * JD-Core Version:    0.6.0
 */