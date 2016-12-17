/*    */ package com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall;
/*    */ import com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionHallDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionHallDAO")
/*    */ public class AuctionHallDAOImpl extends BaseDAO
/*    */   implements AuctionHallDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 14 */     AuctionHall _key = new AuctionHall();
/* 15 */     _key.setId(id);
/* 16 */     int rows = getSqlMapClientTemplate().delete("AUCTION_HALL.deleteByPrimaryKey", _key);
/* 17 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionHall record) {
/* 21 */     getSqlMapClientTemplate().insert("AUCTION_HALL.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionHall record) {
/* 25 */     getSqlMapClientTemplate().insert("AUCTION_HALL.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionHall selectByPrimaryKey(Long id)
/*    */   {
/* 30 */     AuctionHall _key = new AuctionHall();
/* 31 */     _key.setId(id);
/* 32 */     AuctionHall record = (AuctionHall)getSqlMapClientTemplate().queryForObject("AUCTION_HALL.selectByPrimaryKey", _key);
/* 33 */     return record;
/*    */   }
/*    */ 
/*    */   public AuctionHall selectHallByProjectCode(String projectCode)
/*    */   {
/* 40 */     AuctionHall _key = new AuctionHall();
/* 41 */     _key.setProjectCode(projectCode);
/* 42 */     AuctionHall record = (AuctionHall)getSqlMapClientTemplate().queryForObject("AUCTION_HALL.selectByProjectCode", _key);
/* 43 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionHall record) {
/* 47 */     int rows = getSqlMapClientTemplate().update("AUCTION_HALL.updateByPrimaryKeySelective", record);
/* 48 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(AuctionHall record) {
/* 52 */     int rows = getSqlMapClientTemplate().update("AUCTION_HALL.updateByPrimaryKey", record);
/* 53 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.dao.ibatis.auction.AuctionHallDAOImpl
 * JD-Core Version:    0.6.0
 */