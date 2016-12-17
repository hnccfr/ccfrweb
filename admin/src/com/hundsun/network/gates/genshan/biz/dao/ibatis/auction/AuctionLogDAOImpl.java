/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionLogDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionLog;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("AuctionLogDAO")
/*    */ public class AuctionLogDAOImpl extends BaseDAO
/*    */   implements AuctionLogDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 16 */     AuctionLog _key = new AuctionLog();
/* 17 */     _key.setId(id);
/* 18 */     int rows = getSqlMapClientTemplate().delete("AUCTION_LOG.deleteByPrimaryKey", _key);
/* 19 */     return rows;
/*    */   }
/*    */ 
/*    */   public Long insert(AuctionLog record) {
/* 23 */     return (Long)getSqlMapClientTemplate().insert("AUCTION_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public AuctionLog selectByPrimaryKey(Long id)
/*    */   {
/* 28 */     AuctionLog _key = new AuctionLog();
/* 29 */     _key.setId(id);
/* 30 */     AuctionLog record = (AuctionLog)getSqlMapClientTemplate().queryForObject("AUCTION_LOG.selectByPrimaryKey", _key);
/* 31 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionLog record)
/*    */   {
/* 36 */     int rows = getSqlMapClientTemplate().update("AUCTION_LOG.updateByPrimaryKeySelective", record);
/* 37 */     return rows;
/*    */   }
/*    */ 
/*    */   public void batchInsert(List<AuctionLog> list)
/*    */   {
/* 45 */     batchInsert("AUCTION_LOG.insert", list);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.auction.AuctionLogDAOImpl
 * JD-Core Version:    0.6.0
 */