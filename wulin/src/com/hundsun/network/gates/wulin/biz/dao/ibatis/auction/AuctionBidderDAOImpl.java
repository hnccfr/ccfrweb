/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionBidderDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionBidder;
/*    */ import java.util.HashMap;
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
/*    */   public Long insert(AuctionBidder record) {
/* 22 */     return (Long)getSqlMapClientTemplate().insert("AUCTION_BIDDER.insert", record);
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
/*    */   public int deleteByProjectCode(String projectCode)
/*    */   {
/* 51 */     return getSqlMapClientTemplate().delete("AUCTION_BIDDER.deleteByProjectCode", projectCode);
/*    */   }
/*    */ 
/*    */   public int deleteByBidderAccount(String projectCode, String bidderAccount)
/*    */   {
/* 60 */     HashMap map = new HashMap();
/* 61 */     map.put("projectCode", projectCode);
/* 62 */     map.put("bidderAccount", bidderAccount);
/* 63 */     return getSqlMapClientTemplate().delete("AUCTION_BIDDER.deleteByBidderAccount", map);
/*    */   }
/*    */ 
/*    */   public AuctionBidder selectNormalByBidderAccount(String projectCode, String bidderAccount)
/*    */   {
/* 74 */     HashMap map = new HashMap();
/* 75 */     map.put("projectCode", projectCode);
/* 76 */     map.put("bidderAccount", bidderAccount);
/* 77 */     return (AuctionBidder)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER.selectNormalByBidderAccount", map);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.auction.AuctionBidderDAOImpl
 * JD-Core Version:    0.6.0
 */