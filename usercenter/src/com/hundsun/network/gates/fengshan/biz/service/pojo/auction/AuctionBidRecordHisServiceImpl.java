/*     */ package com.hundsun.network.gates.fengshan.biz.service.pojo.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionBidRecordHisDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionBidderDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionFreeBidDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionHallDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectMetasDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionBidder;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBid;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionHall;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidRecordHisQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumLoginOutAuction;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.auction.AuctionBidRecordHisService;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionBidderBidStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.melody.common.util.DateUtil;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("auctionBidRecordHisService")
/*     */ public class AuctionBidRecordHisServiceImpl extends BaseService
/*     */   implements AuctionBidRecordHisService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidRecordHisDAO auctionBidRecordHisDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasDAO projectMetasDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionHallDAO auctionHallDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderDAO tradeWishOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidderDAO auctionBidderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionFreeBidDAO auctionFreeBidDAO;
/*     */ 
/*     */   public void queryBidRecordHis(AuctionBidRecordHisQuery query)
/*     */   {
/*  69 */     this.auctionBidRecordHisDAO.queryBidRecordHis(query);
/*     */   }
/*     */ 
/*     */   public int existsBidRecord(String projectCode, String bidderAccount)
/*     */   {
/*  79 */     return this.auctionBidRecordHisDAO.existsBidRecord(projectCode, bidderAccount);
/*     */   }
/*     */ 
/*     */   public Boolean isOutOfTime(Long projectId)
/*     */   {
/*  91 */     int num = this.projectMetasDAO.selectNumByProjectId(projectId).intValue();
/*  92 */     if (num > 0) {
/*  93 */       return Boolean.valueOf(false);
/*     */     }
/*  95 */     return Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   public String loginOut(final TradeWishOrder tradeWishOrder, final UserAgent userAgent)
/*     */   {
/* 110 */     ProjectListing projectListing = this.projectListingDAO.selectByCode(tradeWishOrder.getProjectCode());
/* 111 */     if ((isOutOfTime(projectListing.getId()).booleanValue()) && (!EnumProjectStatus.SUSPENSION.getValue().equals(projectListing.getStatus()))) {
/* 112 */       return EnumLoginOutAuction.LATE_THAN_END.getName();
/*     */     }
/* 114 */     final AuctionHall auctionHall = this.auctionHallDAO.selectByProjectCode(tradeWishOrder.getProjectCode());
/* 115 */     String result = (String)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public String doInTransaction(TransactionStatus status) {
/* 117 */         TransRequest request = new TransRequest();
/* 118 */         request.setFundAccount(userAgent.getFundAccount());
/* 119 */         request.setOrderProperty(tradeWishOrder.getTradeType());
/* 120 */         request.setAmount(tradeWishOrder.getDeposit());
/* 121 */         request.setBizNo(tradeWishOrder.getWishOrderNum());
/* 122 */         request.setOperator(userAgent.getAccount());
/* 123 */         request.setTransDate(DateUtil.convertDateToString("yyyyMMdd", tradeWishOrder.getGmtModify()));
/* 124 */         FundOperateResult fundResult = new FundOperateResult();
/*     */         try {
/* 126 */           tradeWishOrder.setStatus(EnumTradeWishOrderStatus.SFCANCEL.getValue());
/* 127 */           int number = AuctionBidRecordHisServiceImpl.this.tradeWishOrderDAO.updateStatusByOrderNum(tradeWishOrder);
/* 128 */           if (number <= 0) {
/* 129 */             status.setRollbackOnly();
/* 130 */             AuctionBidRecordHisServiceImpl.this.log.error("loginOut erro, cause by:" + EnumLoginOutAuction.CHANGE_STATUS_ERROR.getName());
/* 131 */             return EnumLoginOutAuction.CHANGE_STATUS_ERROR.getName();
/*     */           }
/* 133 */           if (null != auctionHall) {
/* 134 */             AuctionBidder query = new AuctionBidder();
/* 135 */             query.setBidderAccount(userAgent.getAccount());
/* 136 */             query.setProjectCode(tradeWishOrder.getProjectCode());
/* 137 */             if (AuctionBidRecordHisServiceImpl.this.auctionBidderDAO.selectCountOfOneBidder(query).intValue() > 0) {
/* 138 */               AuctionBidder auctionBidder = new AuctionBidder();
/* 139 */               auctionBidder.setBidStatus(EnumAuctionBidderBidStatus.E.getValue());
/* 140 */               auctionBidder.setBidderAccount(userAgent.getAccount());
/* 141 */               auctionBidder.setProjectCode(tradeWishOrder.getProjectCode());
/* 142 */               int changResult = AuctionBidRecordHisServiceImpl.this.auctionBidderDAO.changeStatusByBidderAccount(auctionBidder);
/* 143 */               if (changResult <= 0) {
/* 144 */                 status.setRollbackOnly();
/* 145 */                 AuctionBidRecordHisServiceImpl.this.log.error("loginOut erro, cause by:" + EnumLoginOutAuction.CHANGE_BIDDER_STATUS_ERROR.getName());
/* 146 */                 return EnumLoginOutAuction.CHANGE_BIDDER_STATUS_ERROR.getName();
/*     */               }
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 152 */           if ((EnumTradingType.MULIT_BID_ORDER.getValue().equals(tradeWishOrder.getTradeType())) && 
/* 153 */             (EnumTradeWishOrderStatus.TRADING.getValue().equals(tradeWishOrder.getStatus()))) {
/* 154 */             AuctionFreeBid query = new AuctionFreeBid();
/* 155 */             query.setBidderAccount(userAgent.getAccount());
/* 156 */             query.setProjectCode(tradeWishOrder.getProjectCode());
/* 157 */             List auctionFreebidList = AuctionBidRecordHisServiceImpl.this.auctionFreeBidDAO.selectOneProjectAuctionOfUser(query);
/* 158 */             if (auctionFreebidList.size() <= 0) {
/* 159 */               status.setRollbackOnly();
/* 160 */               AuctionBidRecordHisServiceImpl.this.log.error("loginOut error, cause by: " + EnumLoginOutAuction.NOT_HAS_FREE_AUCTION.getName());
/* 161 */               return EnumLoginOutAuction.NOT_HAS_FREE_AUCTION.getName();
/*     */             }
/* 163 */             AuctionFreeBid auctionFreeBid = (AuctionFreeBid)auctionFreebidList.get(0);
/* 164 */             auctionFreeBid.setStatus(EnumBidPriceStatus.CANCEL.getValue());
/* 165 */             Long auctionFreeBidId = AuctionBidRecordHisServiceImpl.this.auctionFreeBidDAO.insert(auctionFreeBid);
/* 166 */             if (auctionFreeBidId.intValue() <= 0) {
/* 167 */               status.setRollbackOnly();
/* 168 */               AuctionBidRecordHisServiceImpl.this.log.error("loginOut error, cause by: " + EnumLoginOutAuction.INSERT_FREE_AUCTION_ERROR.getName());
/* 169 */               return EnumLoginOutAuction.INSERT_FREE_AUCTION_ERROR.getName();
/*     */             }
/*     */           }
/*     */ 
/* 173 */           fundResult = AuctionBidRecordHisServiceImpl.this.remoteFundService.cancelFundByTrade(request);
/* 174 */           if (fundResult.isError()) {
/* 175 */             status.setRollbackOnly();
/* 176 */             AuctionBidRecordHisServiceImpl.this.log.error("loginOut erro, cause by:" + fundResult.getErrorInfo());
/* 177 */             return fundResult.getErrorInfo();
/*     */           }
/*     */         } catch (Exception e) {
/* 180 */           status.setRollbackOnly();
/* 181 */           AuctionBidRecordHisServiceImpl.this.log.error("loginOut erro, cause by:", e);
/* 182 */           return EnumLoginOutAuction.EXCEPTION.getName();
/*     */         }
/* 184 */         return EnumLoginOutAuction.SUCCESS.getValue();
/*     */       }
/*     */     });
/* 187 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.auction.AuctionBidRecordHisServiceImpl
 * JD-Core Version:    0.6.0
 */