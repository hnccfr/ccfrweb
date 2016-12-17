/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionBidderDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionBidder;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidderQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidderDAO")
/*    */ public class AuctionBidderDAOImpl extends BaseDAO
/*    */   implements AuctionBidderDAO
/*    */ {
/*    */   public Long selectByCondition(AuctionBidderQuery query)
/*    */   {
/* 19 */     return (Long)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER.selectByCondition", query);
/*    */   }
/*    */ 
/*    */   public int changeStatusByBidderAccount(AuctionBidder auctionBidder)
/*    */   {
/* 24 */     return Integer.valueOf(getSqlMapClientTemplate().update("AUCTION_BIDDER.changeStatusByBidderAccount", auctionBidder)).intValue();
/*    */   }
/*    */ 
/*    */   public void selectByQuery(AuctionBidderQuery query)
/*    */   {
/* 29 */     paginate(query, "AUCTION_BIDDER.queryBiddersCount", "AUCTION_BIDDER.queryBidders");
/*    */   }
/*    */ 
/*    */   public Long selectCountOfOneBidder(AuctionBidder query)
/*    */   {
/* 34 */     return (Long)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER.queryIfBiddersExit", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction.AuctionBidderDAOImpl
 * JD-Core Version:    0.6.0
 */