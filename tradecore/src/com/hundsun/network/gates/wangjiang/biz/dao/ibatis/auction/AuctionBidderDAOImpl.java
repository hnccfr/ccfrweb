/*    */ package com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionBidderBidStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
/*    */ import com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionBidderDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionBidderDAO")
/*    */ public class AuctionBidderDAOImpl extends BaseDAO
/*    */   implements AuctionBidderDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 19 */     AuctionBidder _key = new AuctionBidder();
/* 20 */     _key.setId(id);
/* 21 */     int rows = getSqlMapClientTemplate().delete("AUCTION_BIDDER.deleteByPrimaryKey", _key);
/* 22 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionBidder record)
/*    */   {
/* 27 */     getSqlMapClientTemplate().insert("AUCTION_BIDDER.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionBidder record) {
/* 31 */     getSqlMapClientTemplate().insert("AUCTION_BIDDER.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionBidder selectByPrimaryKey(Long id)
/*    */   {
/* 36 */     AuctionBidder _key = new AuctionBidder();
/* 37 */     _key.setId(id);
/* 38 */     AuctionBidder record = (AuctionBidder)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER.selectByPrimaryKey", _key);
/* 39 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionBidder record)
/*    */   {
/* 44 */     int rows = getSqlMapClientTemplate().update("AUCTION_BIDDER.updateByPrimaryKeySelective", record);
/* 45 */     return rows;
/*    */   }
/*    */ 
/*    */   public List<AuctionBidder> selectBidderListByProCode(String projectCode)
/*    */   {
/* 54 */     AuctionBidder _key = new AuctionBidder();
/* 55 */     _key.setProjectCode(projectCode);
/* 56 */     _key.setBidStatus(EnumAuctionBidderBidStatus.A.getValue());
/* 57 */     return getSqlMapClientTemplate().queryForList("AUCTION_BIDDER.selectBidderListByProCode", _key);
/*    */   }
/*    */ 
/*    */   public AuctionBidder selectBidderBy(String projectCode, String account)
/*    */   {
/* 65 */     AuctionBidder _key = new AuctionBidder();
/* 66 */     _key.setProjectCode(projectCode);
/* 67 */     _key.setBidderAccount(account);
/* 68 */     _key.setBidStatus(EnumAuctionBidderBidStatus.A.getValue());
/* 69 */     return (AuctionBidder)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER.selectBidderListByProCode", _key);
/*    */   }
/*    */ 
/*    */   public Map<String, String> selectListerAccount(String projectCode)
/*    */   {
/* 78 */     Map paraMap = new HashMap();
/* 79 */     paraMap.put("projectCode", projectCode);
/* 80 */     paraMap.put("reviewerAccount", EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey());
/*    */ 
/* 82 */     Map map = (Map)getSqlMapClientTemplate().queryForObject("AUCTION_BIDDER.selectListerAccount", paraMap);
/* 83 */     return map;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction.AuctionBidderDAOImpl
 * JD-Core Version:    0.6.0
 */