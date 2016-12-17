/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidCheckStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceStatus;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionFreeBidDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionFreeBid;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.query.MulitAuctionReviewQuery;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionFreeBidDAO")
/*    */ public class AuctionFreeBidDAOImpl extends BaseDAO
/*    */   implements AuctionFreeBidDAO
/*    */ {
/*    */   public Long insert(AuctionFreeBid record)
/*    */   {
/* 20 */     return (Long)getSqlMapClientTemplate().insert("AUCTION_FREE_BID.insert", record);
/*    */   }
/*    */ 
/*    */   public AuctionFreeBid selectByPrimaryKey(Long id)
/*    */   {
/* 25 */     return (AuctionFreeBid)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionFreeBid record)
/*    */   {
/* 31 */     return getSqlMapClientTemplate().update("AUCTION_FREE_BID.updateByPrimaryKeySelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionFreeBid selectTopByMulitAuctionReviewQuery(MulitAuctionReviewQuery query)
/*    */   {
/* 37 */     return (AuctionFreeBid)getSqlMapClientTemplate().queryForObject("AUCTION_FREE_BID.selectTopByMulitAuctionReviewQuery", query);
/*    */   }
/*    */ 
/*    */   public void insertHisFromFreeBidByProjectCode(String projectCode)
/*    */   {
/* 46 */     Map paraMap = new HashMap();
/* 47 */     paraMap.put("projectCode", projectCode);
/* 48 */     paraMap.put("status", EnumBidPriceStatus.CANCEL.getValue());
/* 49 */     getSqlMapClientTemplate().insert("AUCTION_FREE_BID.insertHisFromFreeBidByProjectCode", paraMap);
/*    */   }
/*    */ 
/*    */   public void insertHisWithOutInitData(String projectCode)
/*    */   {
/* 58 */     Map paraMap = new HashMap();
/* 59 */     paraMap.put("projectCode", projectCode);
/* 60 */     paraMap.put("status", EnumBidPriceStatus.CANCEL.getValue());
/* 61 */     paraMap.put("checkStatus", EnumBidCheckStatus.Fail.getValue());
/* 62 */     getSqlMapClientTemplate().insert("AUCTION_FREE_BID.insertHisWithOutInitData", paraMap);
/*    */   }
/*    */ 
/*    */   public int deleteWithoutInitData(String projectCode)
/*    */   {
/* 70 */     Map paraMap = new HashMap();
/* 71 */     paraMap.put("projectCode", projectCode);
/* 72 */     paraMap.put("status", EnumBidPriceStatus.CANCEL.getValue());
/* 73 */     paraMap.put("checkStatus", EnumBidCheckStatus.Fail.getValue());
/* 74 */     return getSqlMapClientTemplate().delete("AUCTION_FREE_BID.deleteWithoutInitData", paraMap);
/*    */   }
/*    */ 
/*    */   public int deleteAllByProjectCode(String projectCode)
/*    */   {
/* 82 */     return getSqlMapClientTemplate().delete("AUCTION_FREE_BID.deleteAllByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.auction.AuctionFreeBidDAOImpl
 * JD-Core Version:    0.6.0
 */