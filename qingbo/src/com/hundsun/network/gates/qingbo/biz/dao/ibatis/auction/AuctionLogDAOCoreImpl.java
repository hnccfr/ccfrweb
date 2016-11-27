/*    */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionLogCoreDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLog;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionLogCoreDAO")
/*    */ public class AuctionLogDAOCoreImpl extends BaseDAO
/*    */   implements AuctionLogCoreDAO
/*    */ {
/*    */   public Long insert(AuctionLog record)
/*    */   {
/* 14 */     return (Long)getSqlMapClientTemplate().insert("AUCTION_LOG_CORE.insert", record);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction.AuctionLogDAOCoreImpl
 * JD-Core Version:    0.6.0
 */