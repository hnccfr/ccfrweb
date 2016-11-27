/*    */ package com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
/*    */ import com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionBidRecordDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidRecordDAO")
/*    */ public class AuctionBidRecordDAOImpl extends BaseDAO
/*    */   implements AuctionBidRecordDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 15 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 16 */     _key.setId(id);
/* 17 */     int rows = getSqlMapClientTemplate().delete("AUCTION_BID_RECORD.deleteByPrimaryKey", _key);
/* 18 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionBidRecord record) {
/* 22 */     getSqlMapClientTemplate().insert("AUCTION_BID_RECORD.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionBidRecord record) {
/* 26 */     getSqlMapClientTemplate().insert("AUCTION_BID_RECORD.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionBidRecord selectByPrimaryKey(Long id)
/*    */   {
/* 31 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 32 */     _key.setId(id);
/* 33 */     AuctionBidRecord record = (AuctionBidRecord)getSqlMapClientTemplate().queryForObject("AUCTION_BID_RECORD.selectByPrimaryKey", _key);
/* 34 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionBidRecord record)
/*    */   {
/* 39 */     int rows = getSqlMapClientTemplate().update("AUCTION_BID_RECORD.updateByPrimaryKeySelective", record);
/* 40 */     return rows;
/*    */   }
/*    */ 
/*    */   public List<AuctionBidRecord> selectRecordListByProjectCode(String projectCode)
/*    */   {
/* 49 */     AuctionBidRecord _key = new AuctionBidRecord();
/* 50 */     _key.setProjectCode(projectCode);
/* 51 */     _key.setStatus("B");
/* 52 */     return getSqlMapClientTemplate().queryForList("AUCTION_BID_RECORD.selectListByProjectCode", _key);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction.AuctionBidRecordDAOImpl
 * JD-Core Version:    0.6.0
 */