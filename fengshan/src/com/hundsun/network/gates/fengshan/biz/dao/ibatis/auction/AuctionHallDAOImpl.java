/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionHallDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionHall;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("auctionHallDAO")
/*    */ public class AuctionHallDAOImpl extends BaseDAO
/*    */   implements AuctionHallDAO
/*    */ {
/*    */   public AuctionHall selectByProjectCode(String projectCode)
/*    */   {
/* 19 */     return (AuctionHall)getSqlMapClientTemplate().queryForObject("AUCTION_HALL.selectByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.auction.AuctionHallDAOImpl
 * JD-Core Version:    0.6.0
 */