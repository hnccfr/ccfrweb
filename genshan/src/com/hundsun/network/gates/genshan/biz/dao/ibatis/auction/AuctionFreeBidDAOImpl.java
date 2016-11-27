/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionFreeBidDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionFreeBid;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionFreeBidDAO")
/*    */ public class AuctionFreeBidDAOImpl extends BaseDAO
/*    */   implements AuctionFreeBidDAO
/*    */ {
/*    */   public Long insert(AuctionFreeBid record)
/*    */   {
/* 16 */     return (Long)getSqlMapClientTemplate().insert("AUCTION_FREE_BID.insert", record);
/*    */   }
/*    */ 
/*    */   public AuctionFreeBid selectByPrimaryKey(Long id)
/*    */   {
/* 21 */     return (AuctionFreeBid)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionFreeBid record)
/*    */   {
/* 27 */     return getSqlMapClientTemplate().update("AUCTION_FREE_BID.updateByPrimaryKeySelective", record);
/*    */   }
/*    */ 
/*    */   public List<AuctionFreeBid> selectOneProjectAuctionOfUser(AuctionFreeBid auctionFreeBid)
/*    */   {
/* 34 */     return getSqlMapClientTemplate().queryForList("selectOneAuctionOfSomeOne", auctionFreeBid);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.auction.AuctionFreeBidDAOImpl
 * JD-Core Version:    0.6.0
 */