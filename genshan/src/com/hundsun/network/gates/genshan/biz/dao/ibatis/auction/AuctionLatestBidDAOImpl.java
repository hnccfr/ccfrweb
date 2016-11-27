/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionLatestBidDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionLatestBid;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionLatestBidDAO")
/*    */ public class AuctionLatestBidDAOImpl extends BaseDAO
/*    */   implements AuctionLatestBidDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 16 */     AuctionLatestBid _key = new AuctionLatestBid();
/* 17 */     _key.setId(id);
/* 18 */     int rows = getSqlMapClientTemplate().delete("AUCTION_LATEST_BID.deleteByPrimaryKey", _key);
/* 19 */     return rows;
/*    */   }
/*    */ 
/*    */   public Long insert(AuctionLatestBid record)
/*    */   {
/* 26 */     return (Long)getSqlMapClientTemplate().insert("AUCTION_LATEST_BID.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionLatestBid record) {
/* 30 */     getSqlMapClientTemplate().insert("AUCTION_LATEST_BID.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionLatestBid selectByPrimaryKey(Long id)
/*    */   {
/* 35 */     AuctionLatestBid _key = new AuctionLatestBid();
/* 36 */     _key.setId(id);
/* 37 */     AuctionLatestBid record = (AuctionLatestBid)getSqlMapClientTemplate().queryForObject("AUCTION_LATEST_BID.selectByPrimaryKey", _key);
/* 38 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionLatestBid record)
/*    */   {
/* 43 */     int rows = getSqlMapClientTemplate().update("AUCTION_LATEST_BID.updateByPrimaryKeySelective", record);
/* 44 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(AuctionLatestBid record) {
/* 48 */     int rows = getSqlMapClientTemplate().update("AUCTION_LATEST_BID.updateByPrimaryKey", record);
/* 49 */     return rows;
/*    */   }
/*    */ 
/*    */   public void batchInsert(List<AuctionLatestBid> list)
/*    */   {
/* 57 */     batchInsert("AUCTION_LATEST_BID.insert", list);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.auction.AuctionLatestBidDAOImpl
 * JD-Core Version:    0.6.0
 */