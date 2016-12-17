/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionBidderDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionBidder;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidderDAO")
/*    */ public class AuctionBidderDAOImpl extends BaseDAO
/*    */   implements AuctionBidderDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 15 */     AuctionBidder _key = new AuctionBidder();
/* 16 */     _key.setId(id);
/* 17 */     int rows = getSqlMapClientTemplate().delete("AUCTION_BIDDER.deleteByPrimaryKey", _key);
/* 18 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionBidder record) {
/* 22 */     getSqlMapClientTemplate().insert("AUCTION_BIDDER.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionBidder record) {
/* 26 */     getSqlMapClientTemplate().insert("AUCTION_BIDDER.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionBidder selectByPrimaryKey(Long id)
/*    */   {
/* 31 */     AuctionBidder _key = new AuctionBidder();
/* 32 */     _key.setId(id);
/* 33 */     AuctionBidder record = (AuctionBidder)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER.selectByPrimaryKey", _key);
/* 34 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionBidder record)
/*    */   {
/* 40 */     int rows = getSqlMapClientTemplate().update("AUCTION_BIDDER.updateByPrimaryKeySelective", record);
/* 41 */     return rows;
/*    */   }
/*    */ 
/*    */   public void batchInsert(List<AuctionBidder> list)
/*    */   {
/* 49 */     batchInsert("AUCTION_BIDDER.insert", list);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.auction.AuctionBidderDAOImpl
 * JD-Core Version:    0.6.0
 */