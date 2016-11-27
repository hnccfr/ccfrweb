/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionResultDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionResult;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionResultDAO")
/*    */ public class AuctionResultDAOImpl extends BaseDAO
/*    */   implements AuctionResultDAO
/*    */ {
/*    */   public AuctionResult selectByProjectCode(String projectCode)
/*    */   {
/* 13 */     AuctionResult _key = new AuctionResult();
/* 14 */     _key.setProjectCode(projectCode);
/* 15 */     AuctionResult record = (AuctionResult)getSqlMapClientTemplate().queryForObject("AUCTION_RESULT.selectByProjectCode", projectCode);
/* 16 */     return record;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionResult record)
/*    */   {
/* 21 */     getSqlMapClientTemplate().insert("AUCTION_RESULT.insert", record);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.auction.AuctionResultDAOImpl
 * JD-Core Version:    0.6.0
 */