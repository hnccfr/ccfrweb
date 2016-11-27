/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.AccountRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundBatchResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.fund.CashTradeService;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteFundServiceMock")
/*     */ public class RemoteFundServiceImpl extends BaseService
/*     */   implements RemoteFundService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private CashTradeService cashTradeService;
/*     */ 
/*     */   public FundOperateResult createFundAccount(AccountRequest request)
/*     */   {
/*  42 */     return this.cashTradeService.createFundAccount(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult cancelFundAccount(AccountRequest request)
/*     */   {
/*  56 */     return null;
/*     */   }
/*     */ 
/*     */   public FundOperateResult fundInAccount(TransRequest request)
/*     */   {
/*  73 */     return this.cashTradeService.fundInAccount(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult fundOutAccount(TransRequest request)
/*     */   {
/*  90 */     return this.cashTradeService.fundOutAccount(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult freezeFundByTrade(TransRequest request)
/*     */   {
/* 111 */     return this.cashTradeService.freezeFundByTrade(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult fillFundByTrade(TransRequest request)
/*     */   {
/* 131 */     return this.cashTradeService.fillFundByTrade(request);
/*     */   }
/*     */ 
/*     */   public FundBatchResult fillFundBatchByTrade(List<TransRequest> request)
/*     */   {
/* 152 */     return null;
/*     */   }
/*     */ 
/*     */   public FundOperateResult cancelFundByTrade(TransRequest request)
/*     */   {
/* 171 */     return this.cashTradeService.cancelFundByTrade(request);
/*     */   }
/*     */ 
/*     */   public FundBatchResult cancelFundBatchByTrade(List<TransRequest> request)
/*     */   {
/* 184 */     return this.cashTradeService.cancelFundBatchByTrade(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult prePayPayment(TransRequest request)
/*     */   {
/* 202 */     return this.cashTradeService.prePayPayment(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult refundPayment(TransRequest request)
/*     */   {
/* 220 */     return null;
/*     */   }
/*     */ 
/*     */   public FundOperateResult payPayment(TransRequest request)
/*     */   {
/* 245 */     return this.cashTradeService.payPayment(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult penaltyManager(TransRequest request)
/*     */   {
/* 263 */     return null;
/*     */   }
/*     */ 
/*     */   public FundOperateResult tradeBroken(TransRequest request)
/*     */   {
/* 285 */     return this.cashTradeService.tradeBroken(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult deliveryBroken(TransRequest request)
/*     */   {
/* 306 */     return this.cashTradeService.deliveryBroken(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult fundInByExchange(TransRequest request)
/*     */   {
/* 320 */     return this.cashTradeService.fundInAccount(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult fundOutByExchange(TransRequest request)
/*     */   {
/* 334 */     return this.cashTradeService.fundOutAccount(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult checkGoodsTicketBroken(TransRequest request)
/*     */   {
/* 339 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteFundServiceImpl
 * JD-Core Version:    0.6.0
 */