/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionBidRecordHisDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidRecordHisQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidRecordHisDAO")
/*    */ public class AuctionBidRecordHisDAOImpl extends BaseDAO
/*    */   implements AuctionBidRecordHisDAO
/*    */ {
/*    */   public void queryBidRecordHis(AuctionBidRecordHisQuery query)
/*    */   {
/* 17 */     paginate(query, "AUCTION_BID_RECORD_HIS.queryBidRecordHisCount", "AUCTION_BID_RECORD_HIS.queryBidRecordHis");
/*    */   }
/*    */ 
/*    */   public int existsBidRecord(String projectCode, String bidderAccount)
/*    */   {
/* 27 */     Map map = new HashMap();
/* 28 */     map.put("projectCode", projectCode);
/* 29 */     map.put("bidderAccount", bidderAccount);
/* 30 */     return ((Integer)getSqlMapClientTemplate().queryForObject("AUCTION_BID_RECORD_HIS.existsBidRecord", map)).intValue();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction.AuctionBidRecordHisDAOImpl
 * JD-Core Version:    0.6.0
 */