/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionBidRecordDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionBidRecord;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidRecordDAO")
/*    */ public class AuctionBidRecordDAOImpl extends BaseDAO
/*    */   implements AuctionBidRecordDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 13 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 14 */     _key.setId(id);
/* 15 */     int rows = getSqlMapClientTemplate().delete("AUCTION_BID_RECORD.deleteByPrimaryKey", _key);
/* 16 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionBidRecord record) {
/* 20 */     getSqlMapClientTemplate().insert("AUCTION_BID_RECORD.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionBidRecord record) {
/* 24 */     getSqlMapClientTemplate().insert("AUCTION_BID_RECORD.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionBidRecord selectByPrimaryKey(Long id)
/*    */   {
/* 29 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 30 */     _key.setId(id);
/* 31 */     AuctionBidRecord record = (AuctionBidRecord)getSqlMapClientTemplate().queryForObject("AUCTION_BID_RECORD.selectByPrimaryKey", _key);
/* 32 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionBidRecord record)
/*    */   {
/* 37 */     int rows = getSqlMapClientTemplate().update("AUCTION_BID_RECORD.updateByPrimaryKeySelective", record);
/* 38 */     return rows;
/*    */   }
/*    */ 
/*    */   public int deleteByProjectCode(String projectCode)
/*    */   {
/* 48 */     return getSqlMapClientTemplate().delete("AUCTION_BID_RECORD.deleteByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.auction.AuctionBidRecordDAOImpl
 * JD-Core Version:    0.6.0
 */