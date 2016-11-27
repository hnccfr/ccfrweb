/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionBidRecordHisDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionBidRecordHis;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidRecordHisDAO")
/*    */ public class AuctionBidRecordHisDAOImpl extends BaseDAO
/*    */   implements AuctionBidRecordHisDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 13 */     AuctionBidRecordHis _key = new AuctionBidRecordHis();
/* 14 */     _key.setId(id);
/* 15 */     int rows = getSqlMapClientTemplate().delete("AUCTION_BID_RECORD_HIS.deleteByPrimaryKey", _key);
/* 16 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionBidRecordHis record)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionBidRecordHis record) {
/* 24 */     getSqlMapClientTemplate().insert("AUCTION_BID_RECORD_HIS.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionBidRecordHis selectByPrimaryKey(Long id) {
/* 28 */     AuctionBidRecordHis _key = new AuctionBidRecordHis();
/* 29 */     _key.setId(id);
/* 30 */     AuctionBidRecordHis record = (AuctionBidRecordHis)getSqlMapClientTemplate().queryForObject("AUCTION_BID_RECORD_HIS.selectByPrimaryKey", _key);
/* 31 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionBidRecordHis record)
/*    */   {
/* 36 */     int rows = getSqlMapClientTemplate().update("AUCTION_BID_RECORD_HIS.updateByPrimaryKeySelective", record);
/* 37 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insertHisFromBidRecordByProjectCode(String projectCode)
/*    */   {
/* 47 */     getSqlMapClientTemplate().insert("AUCTION_BID_RECORD_HIS.insertHisFromBidRecordByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.auction.AuctionBidRecordHisDAOImpl
 * JD-Core Version:    0.6.0
 */