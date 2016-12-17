/*    */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionBidderCoreDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidderCoreDAO")
/*    */ public class AuctionBidderCoreDAOImpl extends BaseDAO
/*    */   implements AuctionBidderCoreDAO
/*    */ {
/*    */   public AuctionBidder selectBidderByBidAccountAndProjectCode(String bidOperatorAccount, String projectCode)
/*    */   {
/* 17 */     AuctionBidder _key = new AuctionBidder();
/* 18 */     _key.setBidderAccount(bidOperatorAccount);
/* 19 */     _key.setProjectCode(projectCode);
/* 20 */     return (AuctionBidder)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER_CORE.selectBidderByBidAccountAndProjectCode", _key);
/*    */   }
/*    */ 
/*    */   public int selectBidderNumProjectCode(String projectCode)
/*    */   {
/* 27 */     AuctionBidder _key = new AuctionBidder();
/* 28 */     _key.setProjectCode(projectCode);
/* 29 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER_CORE.selectBidderNumProjectCode", _key);
/* 30 */     return count.intValue();
/*    */   }
/*    */ 
/*    */   public int deleteByProjectCode(String projectCode)
/*    */   {
/* 40 */     return getSqlMapClientTemplate().delete("AUCTION_BIDDER_CORE.deleteByProjectCode", projectCode);
/*    */   }
/*    */ 
/*    */   public AuctionBidder selectBidderByBidderTrademarkAndProjectCode(String projectCode, String bidderTrademark)
/*    */   {
/* 51 */     AuctionBidder _key = new AuctionBidder();
/* 52 */     _key.setBidderTrademark(bidderTrademark);
/* 53 */     _key.setProjectCode(projectCode);
/* 54 */     return (AuctionBidder)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER_CORE.selectBidderByBidderTrademarkAndProjectCode", _key);
/*    */   }
/*    */ 
/*    */   public AuctionBidder selectLatestBidder(String projectCode)
/*    */   {
/* 61 */     AuctionBidder _key = new AuctionBidder();
/* 62 */     _key.setProjectCode(projectCode);
/* 63 */     return (AuctionBidder)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER_CORE.selectLatestBidder", _key);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction.AuctionBidderCoreDAOImpl
 * JD-Core Version:    0.6.0
 */