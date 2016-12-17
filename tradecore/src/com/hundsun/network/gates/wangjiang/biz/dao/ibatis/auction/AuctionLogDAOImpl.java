/*    */ package com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLog;
/*    */ import com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionLogDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("AuctionLogDAO")
/*    */ public class AuctionLogDAOImpl extends BaseDAO
/*    */   implements AuctionLogDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 14 */     AuctionLog _key = new AuctionLog();
/* 15 */     _key.setId(id);
/* 16 */     int rows = getSqlMapClientTemplate().delete("AUCTION_LOG.deleteByPrimaryKey", _key);
/* 17 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionLog record) {
/* 21 */     getSqlMapClientTemplate().insert("AUCTION_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public AuctionLog selectByPrimaryKey(Long id)
/*    */   {
/* 26 */     AuctionLog _key = new AuctionLog();
/* 27 */     _key.setId(id);
/* 28 */     AuctionLog record = (AuctionLog)getSqlMapClientTemplate().queryForObject("AUCTION_LOG.selectByPrimaryKey", _key);
/* 29 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionLog record)
/*    */   {
/* 34 */     int rows = getSqlMapClientTemplate().update("AUCTION_LOG.updateByPrimaryKeySelective", record);
/* 35 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction.AuctionLogDAOImpl
 * JD-Core Version:    0.6.0
 */