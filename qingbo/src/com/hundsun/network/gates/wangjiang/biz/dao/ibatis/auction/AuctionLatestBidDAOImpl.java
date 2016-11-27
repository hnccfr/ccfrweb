/*    */ package com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
/*    */ import com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionLatestBidDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionLatestBidDAO")
/*    */ public class AuctionLatestBidDAOImpl extends BaseDAO
/*    */   implements AuctionLatestBidDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 14 */     AuctionLatestBid _key = new AuctionLatestBid();
/* 15 */     _key.setId(id);
/* 16 */     int rows = getSqlMapClientTemplate().delete("AUCTION_LATEST_BID.deleteByPrimaryKey", _key);
/* 17 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionLatestBid record) {
/* 21 */     getSqlMapClientTemplate().insert("AUCTION_LATEST_BID.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionLatestBid record) {
/* 25 */     getSqlMapClientTemplate().insert("AUCTION_LATEST_BID.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionLatestBid selectByPrimaryKey(Long id)
/*    */   {
/* 30 */     AuctionLatestBid _key = new AuctionLatestBid();
/* 31 */     _key.setId(id);
/* 32 */     AuctionLatestBid record = (AuctionLatestBid)getSqlMapClientTemplate().queryForObject("AUCTION_LATEST_BID.selectByPrimaryKey", _key);
/* 33 */     return record;
/*    */   }
/*    */ 
/*    */   public AuctionLatestBid selectLBByProjectCode(String projectCode)
/*    */   {
/* 40 */     AuctionLatestBid _key = new AuctionLatestBid();
/* 41 */     _key.setProjectCode(projectCode);
/* 42 */     AuctionLatestBid record = (AuctionLatestBid)getSqlMapClientTemplate().queryForObject("AUCTION_LATEST_BID.selectByProjectCode", _key);
/* 43 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionLatestBid record)
/*    */   {
/* 48 */     int rows = getSqlMapClientTemplate().update("AUCTION_LATEST_BID.updateByPrimaryKeySelective", record);
/* 49 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(AuctionLatestBid record) {
/* 53 */     int rows = getSqlMapClientTemplate().update("AUCTION_LATEST_BID.updateByPrimaryKey", record);
/* 54 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction.AuctionLatestBidDAOImpl
 * JD-Core Version:    0.6.0
 */