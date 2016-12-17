/*    */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionHallCoreDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionHallCoreDAO")
/*    */ public class AuctionHallDAOCoreImpl extends BaseDAO
/*    */   implements AuctionHallCoreDAO
/*    */ {
/*    */   public AuctionHall selectHallByProjectCode(String projectCode)
/*    */   {
/* 19 */     AuctionHall _key = new AuctionHall();
/* 20 */     _key.setProjectCode(projectCode);
/* 21 */     AuctionHall record = (AuctionHall)getSqlMapClientTemplate().queryForObject("AUCTION_HALL_CORE.selectByProjectCode", _key);
/* 22 */     return record;
/*    */   }
/*    */ 
/*    */   public Map<String, Object> selectSimpleHallByProjectCode(String projectCode)
/*    */   {
/* 31 */     AuctionHall _key = new AuctionHall();
/* 32 */     _key.setProjectCode(projectCode);
/* 33 */     return (Map)getSqlMapClientTemplate().queryForObject("AUCTION_HALL_CORE.selectSimpleMsgByProjectCode", _key);
/*    */   }
/*    */ 
/*    */   public int updateByProjectCode(AuctionHall hallPara)
/*    */   {
/* 41 */     return getSqlMapClientTemplate().update("AUCTION_HALL_CORE.updateByProjectCodeSelective", hallPara);
/*    */   }
/*    */ 
/*    */   public Map<String, Object> selectSimpleHallForBidByProjectCode(String projectCode)
/*    */   {
/* 50 */     AuctionHall _key = new AuctionHall();
/* 51 */     _key.setProjectCode(projectCode);
/* 52 */     return (Map)getSqlMapClientTemplate().queryForObject("AUCTION_HALL_CORE.selectSimpleHallForBidByProjectCode", _key);
/*    */   }
/*    */ 
/*    */   public Map<String, Object> selectSimpleHallForEndByProjectCode(String projectCode)
/*    */   {
/* 61 */     AuctionHall _key = new AuctionHall();
/* 62 */     _key.setProjectCode(projectCode);
/* 63 */     return (Map)getSqlMapClientTemplate().queryForObject("AUCTION_HALL_CORE.selectSimpleHallForEndByProjectCode", _key);
/*    */   }
/*    */ 
/*    */   public int deleteByProjectCode(String projectCode)
/*    */   {
/* 72 */     return getSqlMapClientTemplate().delete("AUCTION_HALL_CORE.deleteByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.auction.AuctionHallDAOCoreImpl
 * JD-Core Version:    0.6.0
 */