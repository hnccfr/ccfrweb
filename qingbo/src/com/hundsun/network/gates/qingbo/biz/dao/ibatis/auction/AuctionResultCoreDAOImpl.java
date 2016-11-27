/*    */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionResultCoreDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionResult;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionResultCoreDAO")
/*    */ public class AuctionResultCoreDAOImpl extends BaseDAO
/*    */   implements AuctionResultCoreDAO
/*    */ {
/*    */   public void insert(AuctionResult record)
/*    */   {
/* 13 */     getSqlMapClientTemplate().insert("AUCTION_RESULT_CORE.insert", record);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction.AuctionResultCoreDAOImpl
 * JD-Core Version:    0.6.0
 */