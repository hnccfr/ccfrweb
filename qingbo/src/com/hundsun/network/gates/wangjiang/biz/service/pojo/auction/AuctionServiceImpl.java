/*    */ package com.hundsun.network.gates.wangjiang.biz.service.pojo.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
/*    */ import com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionBidRecordDAO;
/*    */ import com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionBidderDAO;
/*    */ import com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionHallDAO;
/*    */ import com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionLatestBidDAO;
/*    */ import com.hundsun.network.gates.wangjiang.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wangjiang.biz.service.auction.AuctionService;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("auctionService")
/*    */ public class AuctionServiceImpl extends BaseService
/*    */   implements AuctionService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AuctionHallDAO auctionHallDAO;
/*    */ 
/*    */   @Autowired
/*    */   private AuctionLatestBidDAO auctionLatestBidDAO;
/*    */ 
/*    */   @Autowired
/*    */   private AuctionBidderDAO auctionBidderDAO;
/*    */ 
/*    */   @Autowired
/*    */   private AuctionBidRecordDAO auctionBidRecordDAO;
/*    */ 
/*    */   public List<AuctionBidder> selectBidderListByProCode(String projectCode)
/*    */   {
/* 41 */     return this.auctionBidderDAO.selectBidderListByProCode(projectCode);
/*    */   }
/*    */ 
/*    */   public AuctionBidder selectBidderBy(String projectCode, String account)
/*    */   {
/* 49 */     return this.auctionBidderDAO.selectBidderBy(projectCode, account);
/*    */   }
/*    */ 
/*    */   public Map<String, String> selectListerAccount(String projectCode)
/*    */   {
/* 58 */     return this.auctionBidderDAO.selectListerAccount(projectCode);
/*    */   }
/*    */ 
/*    */   public List<AuctionBidRecord> selectRecordListByProjectCode(String projectCode)
/*    */   {
/* 68 */     return this.auctionBidRecordDAO.selectRecordListByProjectCode(projectCode);
/*    */   }
/*    */ 
/*    */   public AuctionHall selectHallByProjectCode(String projectCode)
/*    */   {
/* 78 */     return this.auctionHallDAO.selectHallByProjectCode(projectCode);
/*    */   }
/*    */ 
/*    */   public AuctionLatestBid selectLBByProjectCode(String projectCode)
/*    */   {
/* 87 */     return this.auctionLatestBidDAO.selectLBByProjectCode(projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.service.pojo.auction.AuctionServiceImpl
 * JD-Core Version:    0.6.0
 */