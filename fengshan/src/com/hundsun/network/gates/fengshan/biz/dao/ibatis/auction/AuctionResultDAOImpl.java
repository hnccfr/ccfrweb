/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionResultDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionResult;
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
/* 18 */     AuctionResult _key = new AuctionResult();
/* 19 */     _key.setProjectCode(projectCode);
/* 20 */     AuctionResult record = (AuctionResult)getSqlMapClientTemplate().queryForObject("AUCTION_RESULT.selectByProjectCode", projectCode);
/* 21 */     return record;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction.AuctionResultDAOImpl
 * JD-Core Version:    0.6.0
 */