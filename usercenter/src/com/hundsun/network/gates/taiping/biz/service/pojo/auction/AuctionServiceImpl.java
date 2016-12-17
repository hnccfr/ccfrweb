/*     */ package com.hundsun.network.gates.taiping.biz.service.pojo.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionLatestStatus;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallBidServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallControlServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.result.HallServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.service.RemoteAuctionService;
/*     */ import com.hundsun.network.gates.taiping.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.taiping.biz.service.auction.AuctionService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("auctionService")
/*     */ public class AuctionServiceImpl extends BaseService
/*     */   implements AuctionService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RemoteAuctionService remoteAuctionService;
/*     */ 
/*     */   public HallServiceResult joinAuctionHall(String projectCode, String userAccount, String authorizdCode)
/*     */   {
/*  26 */     HallServiceResult result = new HallServiceResult();
/*  27 */     if ((null == projectCode) || (StringUtil.isEmpty(projectCode))) {
/*  28 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()));
/*  29 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/*  30 */       return result;
/*     */     }
/*  32 */     if ((null == userAccount) || (StringUtil.isEmpty(userAccount))) {
/*  33 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()));
/*  34 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/*  35 */       return result;
/*     */     }
/*  37 */     HallServiceRequest request = new HallServiceRequest();
/*  38 */     request.setProjectCode(projectCode);
/*  39 */     request.setUserAccount(userAccount);
/*  40 */     request.setWatchPassword(authorizdCode);
/*     */     try {
/*  42 */       result = this.remoteAuctionService.loginHall(request);
/*     */     } catch (Exception e) {
/*  44 */       this.log.error("", e);
/*  45 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.SERVER_ERROR.getValue()));
/*  46 */       result.setErrorInfo(EnumHallErrorNO.SERVER_ERROR.getName());
/*  47 */       return result;
/*     */     }
/*  49 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult bidderDid(HallBidServiceRequest request)
/*     */   {
/*  54 */     ServiceResult result = new ServiceResult();
/*  55 */     if (null == request) {
/*  56 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_ERROR_NULL.getValue()));
/*  57 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_ERROR_NULL.getName());
/*  58 */       return result;
/*     */     }
/*     */     try {
/*  61 */       result = this.remoteAuctionService.bidderDid(request);
/*     */     } catch (Exception e) {
/*  63 */       this.log.error("", e);
/*  64 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.SERVER_ERROR.getValue()));
/*  65 */       result.setErrorInfo(EnumHallErrorNO.SERVER_ERROR.getName());
/*  66 */       return result;
/*     */     }
/*  68 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerDo(String userAccount, String projectCode, EnumAuctionLatestStatus status)
/*     */   {
/*  75 */     ServiceResult result = new ServiceResult();
/*  76 */     if (StringUtil.isEmpty(userAccount)) {
/*  77 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()));
/*  78 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/*  79 */       return result;
/*     */     }
/*  81 */     if (StringUtil.isEmpty(projectCode)) {
/*  82 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()));
/*  83 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/*  84 */       return result;
/*     */     }
/*  86 */     if (null == status) {
/*  87 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_NEXTSTATUS_NULL.getValue()));
/*  88 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_NEXTSTATUS_NULL.getName());
/*  89 */       return result;
/*     */     }
/*     */     try {
/*  92 */       HallControlServiceRequest request = new HallControlServiceRequest();
/*  93 */       request.setUserAccount(userAccount);
/*  94 */       request.setProjectCode(projectCode);
/*  95 */       request.setLatestStatus(status.getValue());
/*  96 */       result = this.remoteAuctionService.auctioneerDo(request);
/*     */     } catch (Exception e) {
/*  98 */       this.log.error("", e);
/*  99 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.SERVER_ERROR.getValue()));
/* 100 */       result.setErrorInfo(EnumHallErrorNO.SERVER_ERROR.getName());
/* 101 */       return result;
/*     */     }
/* 103 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerSetReservePrice(String userAccount, String projectCode, Long reservePrice)
/*     */   {
/* 109 */     ServiceResult result = new ServiceResult();
/* 110 */     if (StringUtil.isEmpty(userAccount)) {
/* 111 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()));
/* 112 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/* 113 */       return result;
/*     */     }
/* 115 */     if (StringUtil.isEmpty(projectCode)) {
/* 116 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()));
/* 117 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/* 118 */       return result;
/*     */     }
/* 120 */     if (null == reservePrice) {
/* 121 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_RESERVEPRICE_NULL.getValue()));
/* 122 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_RESERVEPRICE_NULL.getName());
/* 123 */       return result;
/*     */     }
/*     */     try {
/* 126 */       HallControlServiceRequest request = new HallControlServiceRequest();
/* 127 */       request.setUserAccount(userAccount);
/* 128 */       request.setProjectCode(projectCode);
/* 129 */       request.setReservePrice(reservePrice);
/* 130 */       result = this.remoteAuctionService.auctioneerSetReservePrice(request);
/*     */     } catch (Exception e) {
/* 132 */       this.log.error("", e);
/* 133 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.SERVER_ERROR.getValue()));
/* 134 */       result.setErrorInfo(EnumHallErrorNO.SERVER_ERROR.getName());
/* 135 */       return result;
/*     */     }
/* 137 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerUpdateBidRate(String userAccount, String projectCode, Long bidRate)
/*     */   {
/* 143 */     ServiceResult result = new ServiceResult();
/* 144 */     if (StringUtil.isEmpty(userAccount)) {
/* 145 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()));
/* 146 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/* 147 */       return result;
/*     */     }
/* 149 */     if (StringUtil.isEmpty(projectCode)) {
/* 150 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()));
/* 151 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/* 152 */       return result;
/*     */     }
/* 154 */     if (null == bidRate) {
/* 155 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_BIDRATE_NULL.getValue()));
/* 156 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_BIDRATE_NULL.getName());
/* 157 */       return result;
/*     */     }
/*     */     try {
/* 160 */       HallControlServiceRequest request = new HallControlServiceRequest();
/* 161 */       request.setUserAccount(userAccount);
/* 162 */       request.setProjectCode(projectCode);
/* 163 */       request.setBidRate(bidRate);
/* 164 */       result = this.remoteAuctionService.auctioneerUpdateBidRate(request);
/*     */     } catch (Exception e) {
/* 166 */       this.log.error("", e);
/* 167 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.SERVER_ERROR.getValue()));
/* 168 */       result.setErrorInfo(EnumHallErrorNO.SERVER_ERROR.getName());
/* 169 */       return result;
/*     */     }
/* 171 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerDo(String userAccount, String projectCode, String cmd, String status)
/*     */   {
/* 176 */     ServiceResult result = new ServiceResult();
/* 177 */     if (StringUtil.isEmpty(userAccount)) {
/* 178 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()));
/* 179 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/* 180 */       return result;
/*     */     }
/* 182 */     if (StringUtil.isEmpty(projectCode)) {
/* 183 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()));
/* 184 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/* 185 */       return result;
/*     */     }
/*     */ 
/* 198 */     EnumAuctionLatestStatus lastestStatus = EnumAuctionLatestStatus.indexByValue(status);
/* 199 */     if (null == lastestStatus) {
/* 200 */       result.setErrorNO(Integer.valueOf(EnumHallErrorNO.PARAMETER_CMD_ERROR.getValue()));
/* 201 */       result.setErrorInfo(EnumHallErrorNO.PARAMETER_CMD_ERROR.getName());
/* 202 */       return result;
/*     */     }
/* 204 */     return auctioneerDo(userAccount, projectCode, lastestStatus);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.pojo.auction.AuctionServiceImpl
 * JD-Core Version:    0.6.0
 */