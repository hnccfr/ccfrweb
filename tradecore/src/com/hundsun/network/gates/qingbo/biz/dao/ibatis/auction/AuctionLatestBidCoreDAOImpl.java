/*    */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionLatestBidCoreDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.ControlAuction;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionLatestBidCoreDAO")
/*    */ public class AuctionLatestBidCoreDAOImpl extends BaseDAO
/*    */   implements AuctionLatestBidCoreDAO
/*    */ {
/*    */   public AuctionLatestBid selectLBByProjectCode(String projectCode)
/*    */   {
/* 21 */     AuctionLatestBid _key = new AuctionLatestBid();
/* 22 */     _key.setProjectCode(projectCode);
/* 23 */     AuctionLatestBid record = (AuctionLatestBid)getSqlMapClientTemplate().queryForObject("AUCTION_LATEST_BID_CORE.selectByProjectCode", _key);
/* 24 */     return record;
/*    */   }
/*    */ 
/*    */   public Map<String, String> selectCurrStatusByProjectCode(String projectCode)
/*    */   {
/* 33 */     AuctionLatestBid _key = new AuctionLatestBid();
/* 34 */     _key.setProjectCode(projectCode);
/* 35 */     return (Map)getSqlMapClientTemplate().queryForObject("AUCTION_LATEST_BID_CORE.selectStatusByProjectCode", _key);
/*    */   }
/*    */ 
/*    */   public int updateLatestStatus(Map<String, String> paraMap)
/*    */   {
/* 43 */     return getSqlMapClientTemplate().update("AUCTION_LATEST_BID_CORE.updateStatusSelective", paraMap);
/*    */   }
/*    */ 
/*    */   public int updateBidRate(Map<String, Object> paraMap)
/*    */   {
/* 51 */     return getSqlMapClientTemplate().update("AUCTION_LATEST_BID_CORE.updateBidRate", paraMap);
/*    */   }
/*    */ 
/*    */   public int updateLatestStatusInDid(AuctionLatestBid latestBid)
/*    */   {
/* 59 */     return getSqlMapClientTemplate().update("AUCTION_LATEST_BID_CORE.updateLatestStatusInDid", latestBid);
/*    */   }
/*    */ 
/*    */   public List<ControlAuction> selectAutoControlLists()
/*    */   {
/* 70 */     return getSqlMapClientTemplate().queryForList("AUCTION_LATEST_BID_CORE.selectAutoControlList");
/*    */   }
/*    */ 
/*    */   public int deleteByProjectCode(String projectCode)
/*    */   {
/* 80 */     return getSqlMapClientTemplate().delete("AUCTION_LATEST_BID_CORE.deleteByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction.AuctionLatestBidCoreDAOImpl
 * JD-Core Version:    0.6.0
 */