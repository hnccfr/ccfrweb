/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionFreeBidDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionHallDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectListingDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBid;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionHall;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
/*    */ import com.hundsun.network.gates.fengshan.biz.enums.EnumAuctionFreeBidError;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.auction.AuctionFreeBidService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.trade.TradeWishOrderService;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("auctionFreeBidService")
/*    */ public class AuctionFreebidServiceImpl extends BaseService
/*    */   implements AuctionFreeBidService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeWishOrderService tradeWishOrderService;
/*    */ 
/*    */   @Autowired
/*    */   private AuctionFreeBidDAO auctionFreeBidDAO;
/*    */ 
/*    */   @Autowired
/*    */   private AuctionHallDAO auctionHallDAO;
/*    */ 
/*    */   @Autowired
/*    */   private ProjectListingDAO projectListingDAO;
/*    */ 
/*    */   public ServiceResult freeBid(AuctionFreeBid auctionFreeBid, String wishOrderNum)
/*    */   {
/* 35 */     ServiceResult result = new ServiceResult();
/* 36 */     result = canFreeBid(wishOrderNum);
/* 37 */     if (!result.correct()) {
/* 38 */       return result;
/*    */     }
/* 40 */     TradeWishOrder tradeWishOrder = this.tradeWishOrderService.getTradeWishOrderByOrderNum(wishOrderNum);
/*    */     try {
/* 42 */       auctionFreeBid.setBidderTrademark(tradeWishOrder.getTrademark());
/* 43 */       auctionFreeBid.setProjectCode(tradeWishOrder.getProjectCode());
/* 44 */       this.auctionFreeBidDAO.insert(auctionFreeBid);
/*    */     } catch (Exception e) {
/* 46 */       e.printStackTrace();
/* 47 */       if (this.log.isErrorEnabled()) {
/* 48 */         this.log.error("", e);
/*    */       }
/* 50 */       result.setErrorNO(Integer.valueOf(EnumAuctionFreeBidError.BID_ERROR.getValue()));
/* 51 */       result.setErrorInfo(EnumAuctionFreeBidError.BID_ERROR.getName());
/*    */     }
/* 53 */     return result;
/*    */   }
/*    */ 
/*    */   public AuctionFreeBid latestFreeBid(String trademark)
/*    */   {
/* 59 */     return this.auctionFreeBidDAO.selectLatestAuctionFreeBidByTradeMark(trademark);
/*    */   }
/*    */ 
/*    */   public ServiceResult canFreeBid(String wishOrderNum)
/*    */   {
/* 65 */     ServiceResult result = new ServiceResult();
/* 66 */     TradeWishOrder tradeWishOrder = this.tradeWishOrderService.getTradeWishOrderByOrderNum(wishOrderNum);
/* 67 */     if (null == tradeWishOrder) {
/* 68 */       result.setErrorNO(Integer.valueOf(EnumAuctionFreeBidError.NONE_APPLY_ERROR.getValue()));
/* 69 */       result.setErrorInfo(EnumAuctionFreeBidError.NONE_APPLY_ERROR.getName());
/* 70 */       return result;
/*    */     }
/*    */ 
/* 73 */     String projectStatus = this.projectListingDAO.selectStatusByCode(tradeWishOrder.getProjectCode());
/* 74 */     if (null == projectStatus) {
/* 75 */       result.setErrorNO(Integer.valueOf(EnumAuctionFreeBidError.PROJECT_NULL_ERROR.getValue()));
/* 76 */       result.setErrorInfo(EnumAuctionFreeBidError.PROJECT_NULL_ERROR.getName());
/* 77 */       return result;
/* 78 */     }if (!EnumProjectStatus.TRADE.getValue().equals(projectStatus)) {
/* 79 */       result.setErrorNO(Integer.valueOf(EnumAuctionFreeBidError.PROJECT_STATUS_ERROR.getValue()));
/* 80 */       result.setErrorInfo(EnumAuctionFreeBidError.PROJECT_STATUS_ERROR.getName());
/* 81 */       return result;
/*    */     }
/* 83 */     if (!EnumTradingType.MULIT_BID_ORDER.getValue().equals(tradeWishOrder.getTradeType())) {
/* 84 */       result.setErrorNO(Integer.valueOf(EnumAuctionFreeBidError.TRADE_TYPE_ERROR.getValue()));
/* 85 */       result.setErrorInfo(EnumAuctionFreeBidError.TRADE_TYPE_ERROR.getName());
/* 86 */       return result;
/*    */     }
/* 88 */     if (!EnumTradeWishOrderStatus.TRADING.getValue().equals(tradeWishOrder.getStatus())) {
/* 89 */       result.setErrorNO(Integer.valueOf(EnumAuctionFreeBidError.WISH_ORDER_STATUS_ERROR.getValue()));
/* 90 */       result.setErrorInfo(EnumAuctionFreeBidError.WISH_ORDER_STATUS_ERROR.getName());
/* 91 */       return result;
/*    */     }
/* 93 */     AuctionHall auctionHall = this.auctionHallDAO.selectByProjectCode(tradeWishOrder.getProjectCode());
/* 94 */     if (null != auctionHall) {
/* 95 */       result.setErrorNO(Integer.valueOf(EnumAuctionFreeBidError.TIME_PASSED_ERROR.getValue()));
/* 96 */       result.setErrorInfo(EnumAuctionFreeBidError.TIME_PASSED_ERROR.getName());
/* 97 */       return result;
/*    */     }
/* 99 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.auction.AuctionFreebidServiceImpl
 * JD-Core Version:    0.6.0
 */