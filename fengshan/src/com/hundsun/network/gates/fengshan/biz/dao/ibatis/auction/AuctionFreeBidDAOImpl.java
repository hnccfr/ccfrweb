/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionFreeBidDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBid;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionFreeBidQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionFreeBidDAO")
/*    */ public class AuctionFreeBidDAOImpl extends BaseDAO
/*    */   implements AuctionFreeBidDAO
/*    */ {
/*    */   public void queryFreeBidList(AuctionFreeBidQuery query)
/*    */   {
/* 20 */     paginate(query, "AUCTION_FREE_BID.queryFreeBidListCount", "AUCTION_FREE_BID.queryFreeBidList");
/*    */   }
/*    */ 
/*    */   public Long insert(AuctionFreeBid record)
/*    */   {
/* 25 */     return (Long)getSqlMapClientTemplate().insert("AUCTION_FREE_BID.insert", record);
/*    */   }
/*    */ 
/*    */   public AuctionFreeBid selectByPrimaryKey(Long id)
/*    */   {
/* 30 */     return (AuctionFreeBid)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionFreeBid record)
/*    */   {
/* 36 */     return getSqlMapClientTemplate().update("AUCTION_FREE_BID.updateByPrimaryKeySelective", record);
/*    */   }
/*    */ 
/*    */   public List<AuctionFreeBid> selectOneProjectAuctionOfUser(AuctionFreeBid auctionFreeBid)
/*    */   {
/* 43 */     return getSqlMapClientTemplate().queryForList("selectOneAuctionOfSomeOne", auctionFreeBid);
/*    */   }
/*    */ 
/*    */   public int selectFreeBidCount(String bidderAccount, String projectCode)
/*    */   {
/* 52 */     AuctionFreeBidQuery query = new AuctionFreeBidQuery();
/* 53 */     query.setBidderAccount(bidderAccount);
/* 54 */     query.setProjectCode(projectCode);
/* 55 */     return ((Integer)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID.selectFreeBidCount", query)).intValue();
/*    */   }
/*    */ 
/*    */   public int selectBidCountByProjectCode(String projectCode)
/*    */   {
/* 64 */     AuctionFreeBidQuery query = new AuctionFreeBidQuery();
/* 65 */     query.setProjectCode(projectCode);
/* 66 */     return ((Integer)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID.selectBidCountByProjectCode", query)).intValue();
/*    */   }
/*    */ 
/*    */   public AuctionFreeBid selectLatestAuctionFreeBidByTradeMark(String tradeMark)
/*    */   {
/* 71 */     Object obj = getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID.selectLatestAuctionFreeBidByTradeMark", tradeMark);
/* 72 */     return null == obj ? null : (AuctionFreeBid)obj;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction.AuctionFreeBidDAOImpl
 * JD-Core Version:    0.6.0
 */