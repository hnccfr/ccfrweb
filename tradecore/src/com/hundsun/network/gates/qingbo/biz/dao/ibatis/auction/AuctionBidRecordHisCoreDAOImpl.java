/*    */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionBidRecordHisCoreDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidRecordHisCoreDAO")
/*    */ public class AuctionBidRecordHisCoreDAOImpl extends BaseDAO
/*    */   implements AuctionBidRecordHisCoreDAO
/*    */ {
/*    */   public void insertHisFromBidRecordByProjectCode(String projectCode)
/*    */   {
/* 18 */     getSqlMapClientTemplate().insert("AUCTION_BID_RECORD_HIS_CORE.insertHisFromBidRecordByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction.AuctionBidRecordHisCoreDAOImpl
 * JD-Core Version:    0.6.0
 */