/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionHallDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionHall;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionHallDAO")
/*    */ public class AuctionHallDAOImpl extends BaseDAO
/*    */   implements AuctionHallDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 16 */     AuctionHall _key = new AuctionHall();
/* 17 */     _key.setId(id);
/* 18 */     int rows = getSqlMapClientTemplate().delete("AUCTION_HALL.deleteByPrimaryKey", _key);
/* 19 */     return rows;
/*    */   }
/*    */ 
/*    */   public Long insert(AuctionHall record) {
/* 23 */     return (Long)getSqlMapClientTemplate().insert("AUCTION_HALL.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionHall record) {
/* 27 */     getSqlMapClientTemplate().insert("AUCTION_HALL.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionHall selectByPrimaryKey(Long id)
/*    */   {
/* 32 */     AuctionHall _key = new AuctionHall();
/* 33 */     _key.setId(id);
/* 34 */     AuctionHall record = (AuctionHall)getSqlMapClientTemplate().queryForObject("AUCTION_HALL.selectByPrimaryKey", _key);
/* 35 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionHall record)
/*    */   {
/* 40 */     int rows = getSqlMapClientTemplate().update("AUCTION_HALL.updateByPrimaryKeySelective", record);
/* 41 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(AuctionHall record) {
/* 45 */     int rows = getSqlMapClientTemplate().update("AUCTION_HALL.updateByPrimaryKey", record);
/* 46 */     return rows;
/*    */   }
/*    */ 
/*    */   public void batchInsert(List<AuctionHall> list)
/*    */   {
/* 54 */     batchInsert("AUCTION_HALL.insert", list);
/*    */   }
/*    */ 
/*    */   public AuctionHall selectByProjectCode(String projectCode)
/*    */   {
/* 59 */     return (AuctionHall)getSqlMapClientTemplate().queryForObject("AUCTION_HALL.selectByProjectCode", projectCode);
/*    */   }
/*    */ 
/*    */   public int updatePriorityNumById(Long id)
/*    */   {
/* 64 */     return Integer.valueOf(getSqlMapClientTemplate().update("AUCTION_HALL.updatePriorityNumById", id)).intValue();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.auction.AuctionHallDAOImpl
 * JD-Core Version:    0.6.0
 */