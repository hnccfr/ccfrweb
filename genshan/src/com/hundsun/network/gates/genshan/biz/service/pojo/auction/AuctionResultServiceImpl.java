/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionResultDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionResult;
/*    */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.auction.AuctionResultService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("auctionResultService")
/*    */ public class AuctionResultServiceImpl extends BaseService
/*    */   implements AuctionResultService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AuctionResultDAO auctionResultDAO;
/*    */ 
/*    */   public AuctionResult selectByProjectCode(String projectCode)
/*    */   {
/* 24 */     return this.auctionResultDAO.selectByProjectCode(projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.auction.AuctionResultServiceImpl
 * JD-Core Version:    0.6.0
 */