/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionResultDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionResult;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionResultDAO")
/*    */ public class AuctionResultDAOImpl extends BaseDAO
/*    */   implements AuctionResultDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 14 */     AuctionResult _key = new AuctionResult();
/* 15 */     _key.setId(id);
/* 16 */     int rows = getSqlMapClientTemplate().delete("AUCTION_RESULT.deleteByPrimaryKey", _key);
/* 17 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionResult record) {
/* 21 */     getSqlMapClientTemplate().insert("AUCTION_RESULT.insert", record);
/*    */   }
/*    */ 
/*    */   public AuctionResult selectByPrimaryKey(Long id)
/*    */   {
/* 26 */     AuctionResult _key = new AuctionResult();
/* 27 */     _key.setId(id);
/* 28 */     AuctionResult record = (AuctionResult)getSqlMapClientTemplate().queryForObject("AUCTION_RESULT.selectByPrimaryKey", _key);
/* 29 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionResult record)
/*    */   {
/* 34 */     int rows = getSqlMapClientTemplate().update("AUCTION_RESULT.updateByPrimaryKeySelective", record);
/* 35 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.auction.AuctionResultDAOImpl
 * JD-Core Version:    0.6.0
 */