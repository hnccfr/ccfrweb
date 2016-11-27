/*    */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionBidderBidStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceAuditStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceStatus;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionFreeBidCoreDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionFreeBid;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionFreeBidCoreDAO")
/*    */ public class AuctionFreeBidCoreDAOImpl extends BaseDAO
/*    */   implements AuctionFreeBidCoreDAO
/*    */ {
/*    */   public void insert(AuctionFreeBid record)
/*    */   {
/* 21 */     getSqlMapClientTemplate().insert("AUCTION_FREE_BID_CORE.insert", record);
/*    */   }
/*    */ 
/*    */   public AuctionFreeBid selectByPrimaryKey(Long id)
/*    */   {
/* 26 */     return (AuctionFreeBid)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID_CORE.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public List<AuctionFreeBid> selectLastFreeBid(String projectCode, Long priceDirection)
/*    */   {
/* 36 */     Map paraMap = new HashMap();
/* 37 */     paraMap.put("bidStatus", EnumAuctionBidderBidStatus.A.getValue());
/* 38 */     paraMap.put("projectCode", projectCode);
/* 39 */     paraMap.put("checkStatus", EnumBidPriceAuditStatus.PASS.getValue());
/* 40 */     paraMap.put("status", EnumBidPriceStatus.EFFECTIVE.getValue());
/* 41 */     String priceOrder = "desc";
/* 42 */     if ((priceDirection != null) && (priceDirection.longValue() < 0L)) {
/* 43 */       priceOrder = "asc";
/*    */     }
/* 45 */     paraMap.put("priceOrder", priceOrder);
/* 46 */     return getSqlMapClientTemplate().queryForList("AUCTION_FREE_BID_CORE.selectLastFreeBid", paraMap);
/*    */   }
/*    */ 
/*    */   public void insertHisFromFreeBidByProjectCode(String projectCode)
/*    */   {
/* 54 */     Map paraMap = new HashMap();
/* 55 */     paraMap.put("projectCode", projectCode);
/* 56 */     getSqlMapClientTemplate().insert("AUCTION_FREE_BID_CORE.insertHisFromFreeBidByProjectCode", paraMap);
/*    */   }
/*    */ 
/*    */   public int deleteByProjectCode(String projectCode)
/*    */   {
/* 64 */     return getSqlMapClientTemplate().delete("AUCTION_FREE_BID_CORE.deleteByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction.AuctionFreeBidCoreDAOImpl
 * JD-Core Version:    0.6.0
 */