/*     */ package com.hundsun.network.gates.houchao.remote;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.manager.AccountQueryManager;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryPageRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundInOutQueryResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundQueryResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundQueryService;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteFundQueryService")
/*     */ public class RemoteFundQueryServiceImpl
/*     */   implements RemoteFundQueryService
/*     */ {
/*  30 */   private Log log = LogFactory.getLog(RemoteFundQueryServiceImpl.class);
/*     */ 
/*     */   @Autowired
/*     */   private AccountQueryManager accountQueryManager;
/*     */ 
/*     */   public FundQueryResult queryFundByTrader(FundQueryRequest request)
/*     */   {
/*  58 */     if (this.log.isDebugEnabled()) {
/*  59 */       this.log.debug("queryFundByTrader params:" + request);
/*     */     }
/*  61 */     FundQueryResult fundQueryResult = new FundQueryResult();
/*     */ 
/*  63 */     if (request == null) {
/*  64 */       fundQueryResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  65 */       fundQueryResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  66 */       this.log.error("queryFundByTrader request params is null!");
/*  67 */       return fundQueryResult;
/*     */     }
/*     */ 
/*  70 */     return this.accountQueryManager.queryFundByTrader(request);
/*     */   }
/*     */ 
/*     */   public FundQueryResult useBalanceCalculate(FundQueryRequest request)
/*     */   {
/*  84 */     if (this.log.isDebugEnabled()) {
/*  85 */       this.log.debug("createFundAccount params:" + request);
/*     */     }
/*  87 */     FundQueryResult fundQueryResult = new FundQueryResult();
/*     */ 
/*  89 */     if (null == request) {
/*  90 */       fundQueryResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  91 */       fundQueryResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  92 */       this.log.error("useBalanceCalculate request params is null!");
/*  93 */       return fundQueryResult;
/*     */     }
/*     */ 
/*  96 */     return this.accountQueryManager.useBalanceCalculate(request);
/*     */   }
/*     */ 
/*     */   public FundInOutQueryResult fundInOutQuery(FundQueryPageRequest request)
/*     */   {
/* 113 */     if (this.log.isDebugEnabled()) {
/* 114 */       this.log.debug("createFundAccount params:" + request);
/*     */     }
/*     */ 
/* 117 */     return this.accountQueryManager.fundInOutQuery(request);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.remote.RemoteFundQueryServiceImpl
 * JD-Core Version:    0.6.0
 */