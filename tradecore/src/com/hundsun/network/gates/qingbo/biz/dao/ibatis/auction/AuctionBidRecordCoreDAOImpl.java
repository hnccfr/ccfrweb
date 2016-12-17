/*    */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionBidRecordCoreDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidRecordCoreDAO")
/*    */ public class AuctionBidRecordCoreDAOImpl extends BaseDAO
/*    */   implements AuctionBidRecordCoreDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 15 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 16 */     _key.setId(id);
/* 17 */     int rows = getSqlMapClientTemplate().delete("AUCTION_BID_RECORD_CORE.deleteByPrimaryKey", _key);
/* 18 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionBidRecord record) {
/* 22 */     getSqlMapClientTemplate().insert("AUCTION_BID_RECORD_CORE.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionBidRecord record) {
/* 26 */     getSqlMapClientTemplate().insert("AUCTION_BID_RECORD_CORE.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionBidRecord selectByPrimaryKey(Long id)
/*    */   {
/* 31 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 32 */     _key.setId(id);
/* 33 */     AuctionBidRecord record = (AuctionBidRecord)getSqlMapClientTemplate().queryForObject("AUCTION_BID_RECORD_CORE.selectByPrimaryKey", _key);
/* 34 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionBidRecord record)
/*    */   {
/* 39 */     int rows = getSqlMapClientTemplate().update("AUCTION_BID_RECORD_CORE.updateByPrimaryKeySelective", record);
/* 40 */     return rows;
/*    */   }
/*    */ 
/*    */   public List<AuctionBidRecord> selectRecordListByProjectCode(String projectCode)
/*    */   {
/* 49 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 50 */     _key.setProjectCode(projectCode);
/* 51 */     _key.setStatus("B");
/* 52 */     return getSqlMapClientTemplate().queryForList("AUCTION_BID_RECORD_CORE.selectBidderListByProCode", _key);
/*    */   }
/*    */ 
/*    */   public int getRecordsNumByProjectCode(String projectCode)
/*    */   {
/* 60 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 61 */     _key.setProjectCode(projectCode);
/* 62 */     _key.setUsePriority("N");
/* 63 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("AUCTION_BID_RECORD_CORE.selectRecordsNumByProjectCode", _key);
/* 64 */     return count.intValue();
/*    */   }
/*    */ 
/*    */   public int getPriorityRecordsNumByProjectCode(String projectCode)
/*    */   {
/* 72 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 73 */     _key.setProjectCode(projectCode);
/* 74 */     _key.setUsePriority("Y");
/* 75 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("AUCTION_BID_RECORD_CORE.selectRecordsNumByProjectCode", _key);
/* 76 */     return count.intValue();
/*    */   }
/*    */ 
/*    */   public int deleteByProjectCode(String projectCode)
/*    */   {
/* 86 */     return getSqlMapClientTemplate().delete("AUCTION_BID_RECORD_CORE.deleteByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction.AuctionBidRecordCoreDAOImpl
 * JD-Core Version:    0.6.0
 */