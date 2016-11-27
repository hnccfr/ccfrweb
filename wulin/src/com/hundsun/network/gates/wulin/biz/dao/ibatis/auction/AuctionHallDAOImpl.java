/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionHallDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionHall;
/*    */ import java.util.HashMap;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionHallDAO")
/*    */ public class AuctionHallDAOImpl extends BaseDAO
/*    */   implements AuctionHallDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 15 */     AuctionHall _key = new AuctionHall();
/* 16 */     _key.setId(id);
/* 17 */     int rows = getSqlMapClientTemplate().delete("AUCTION_HALL.deleteByPrimaryKey", _key);
/* 18 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(AuctionHall record) {
/* 22 */     getSqlMapClientTemplate().insert("AUCTION_HALL.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(AuctionHall record) {
/* 26 */     getSqlMapClientTemplate().insert("AUCTION_HALL.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public AuctionHall selectByPrimaryKey(Long id) {
/* 30 */     AuctionHall _key = new AuctionHall();
/* 31 */     _key.setId(id);
/* 32 */     AuctionHall record = (AuctionHall)getSqlMapClientTemplate().queryForObject("AUCTION_HALL.selectByPrimaryKey", _key);
/*    */ 
/* 34 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(AuctionHall record) {
/* 38 */     int rows = getSqlMapClientTemplate().update("AUCTION_HALL.updateByPrimaryKeySelective", record);
/*    */ 
/* 40 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(AuctionHall record) {
/* 44 */     int rows = getSqlMapClientTemplate().update("AUCTION_HALL.updateByPrimaryKey", record);
/* 45 */     return rows;
/*    */   }
/*    */ 
/*    */   public AuctionHall selectByProjectCode(String projectCode)
/*    */   {
/* 56 */     return (AuctionHall)getSqlMapClientTemplate().queryForObject("AUCTION_HALL.selectByProjectCode", projectCode);
/*    */   }
/*    */ 
/*    */   public int deleteByProjectCode(String projectCode)
/*    */   {
/* 67 */     return getSqlMapClientTemplate().delete("AUCTION_HALL.deleteByProjectCode", projectCode);
/*    */   }
/*    */ 
/*    */   public int updateByMap(HashMap<String, Object> actionHallMap) {
/* 71 */     return getSqlMapClientTemplate().update("AUCTION_HALL.updateByMap", actionHallMap);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.auction.AuctionHallDAOImpl
 * JD-Core Version:    0.6.0
 */