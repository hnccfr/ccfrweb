/*    */ package com.hundsun.network.gates.wangjiang.common;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionBidRecordDTO;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionBidderDTO;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionHallDTO;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionLatestBidDTO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
/*    */ 
/*    */ public class ConvertUtil
/*    */ {
/*    */   public static void auctionHall2DTO(AuctionHall o, AuctionHallDTO dto)
/*    */   {
/* 17 */     dto.setAllowWatch(o.getAllowWatch());
/* 18 */     dto.setAuctioneerAccount(o.getAuctioneerAccount());
/* 19 */     dto.setAuctionEndTime(o.getAuctionEndTime());
/* 20 */     dto.setAuctionType(o.getAuctionType());
/* 21 */     dto.setBidLimitedPeriod(o.getBidLimitedPeriod());
/* 22 */     dto.setBidStartPrice(o.getBidStartPrice());
/* 23 */     dto.setBidStartTime(o.getBidStartTime());
/* 24 */     dto.setComFreeEndtime(o.getComFreeEndtime());
/* 25 */     dto.setComFreeStarttime(o.getComFreeStarttime());
/* 26 */     dto.setFirstWaitTime(o.getFirstWaitTime());
/* 27 */     dto.setGmtCreator(o.getGmtCreator());
/* 28 */     dto.setGmtModify(o.getGmtModify());
/* 29 */     dto.setHaveAuctioneer(o.getHaveAuctioneer());
/* 30 */     dto.setHaveReservePrice(o.getHaveReservePrice());
/* 31 */     dto.setId(o.getId());
/* 32 */     dto.setOperator(o.getOperator());
/* 33 */     dto.setPriceDirection(o.getPriceDirection());
/* 34 */     dto.setPriorityNum(o.getPriorityNum());
/* 35 */     dto.setProjectCode(o.getProjectCode());
/* 36 */     dto.setReservePrice(o.getReservePrice());
/* 37 */     dto.setSupportPriority(o.getSupportPriority());
/* 38 */     dto.setValuationUnit(o.getValuationUnit());
/* 39 */     dto.setWatchPassword(o.getWatchPassword());
/* 40 */     dto.setBidStartCountDownMilliSeconds(o.getBidStartCountDownMilliSeconds());
/*    */   }
/*    */ 
/*    */   public static void AuctionLatestBid2DTO(AuctionLatestBid o, AuctionLatestBidDTO dto)
/*    */   {
/* 47 */     dto.setBidderTrademark(o.getBidderTrademark());
/* 48 */     dto.setBidRate(o.getBidRate());
/* 49 */     dto.setGmtCreate(o.getGmtCreate());
/* 50 */     dto.setGmtModify(o.getGmtModify());
/* 51 */     dto.setId(o.getId());
/* 52 */     dto.setIsPriority(o.getIsPriority());
/* 53 */     dto.setLastBidTrademark(o.getLastBidTrademark());
/* 54 */     dto.setLatestBid(o.getLatestBid());
/* 55 */     dto.setLatestBidTime(o.getLatestBidTime());
/* 56 */     dto.setLatestStatus(o.getLatestStatus());
/* 57 */     dto.setNextBidEndtime(o.getNextBidEndtime());
/* 58 */     dto.setOperator(o.getOperator());
/* 59 */     dto.setProjectCode(o.getProjectCode());
/* 60 */     dto.setNextBidInterval(o.getNextBidInterval());
/*    */   }
/*    */ 
/*    */   public static void AuctionBidder2DTO(AuctionBidder o, AuctionBidderDTO dto)
/*    */   {
/* 67 */     dto.setBidderAccount(o.getBidderAccount());
/* 68 */     dto.setBidderTrademark(o.getBidderTrademark());
/* 69 */     dto.setBidStatus(o.getBidStatus());
/* 70 */     dto.setBrokerAccount(o.getBrokerAccount());
/* 71 */     dto.setGmtCreate(o.getGmtCreate());
/* 72 */     dto.setGmtModify(o.getGmtModify());
/* 73 */     dto.setId(o.getId());
/* 74 */     dto.setIsPriority(o.getIsPriority());
/* 75 */     dto.setOperator(o.getOperator());
/* 76 */     dto.setProjectCode(o.getProjectCode());
/* 77 */     dto.setServiceCode(o.getServiceCode());
/*    */   }
/*    */ 
/*    */   public static void AuctionBidRecord2DTO(AuctionBidRecord o, AuctionBidRecordDTO dto)
/*    */   {
/* 84 */     dto.setBidderAccount(o.getBidderAccount());
/* 85 */     dto.setBidderTrademark(o.getBidderTrademark());
/* 86 */     dto.setBidOperatorAccount(o.getBidOperatorAccount());
/* 87 */     dto.setGmtCreate(o.getGmtCreate());
/* 88 */     dto.setGmtModify(o.getGmtModify());
/* 89 */     dto.setId(o.getId());
/* 90 */     dto.setIp(o.getIp());
/* 91 */     dto.setOperator(o.getOperator());
/* 92 */     dto.setPrice(o.getPrice());
/* 93 */     dto.setProjectCode(o.getProjectCode());
/* 94 */     dto.setStatus(o.getStatus());
/* 95 */     dto.setUsePriority(o.getUsePriority());
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.common.ConvertUtil
 * JD-Core Version:    0.6.0
 */