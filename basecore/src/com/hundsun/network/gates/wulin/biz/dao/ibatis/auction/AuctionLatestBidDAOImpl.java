/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionLatestBidDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionLatestBid;
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
/*    */   public int updateByPrimaryKeySelective(AuctionLatestBid record)
/*    */   {
/* 38 */     int rows = getSqlMapClientTemplate().update("AUCTION_LATEST_BID.updateByPrimaryKeySelective", record);
/* 39 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(AuctionLatestBid record) {
/* 43 */     int rows = getSqlMapClientTemplate().update("AUCTION_LATEST_BID.updateByPrimaryKey", record);
/* 44 */     return rows;
/*    */   }
/*    */ 
/*    */   public int deleteByProjectCode(String projectCode)
/*    */   {
/* 54 */     return getSqlMapClientTemplate().delete("AUCTION_LATEST_BID.deleteByProjectCode", projectCode);
/*    */   }
/*    */ 
/*    */   public AuctionLatestBid selectByProjectCode(String projectCode)
/*    */   {
/* 65 */     return (AuctionLatestBid)getSqlMapClientTemplate().queryForObject("AUCTION_LATEST_BID.selectByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.auction.AuctionLatestBidDAOImpl
 * JD-Core Version:    0.6.0
 */