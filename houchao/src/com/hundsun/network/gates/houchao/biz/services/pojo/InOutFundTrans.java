/*     */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.TransReq;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransCode;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.apache.commons.logging.Log;
/*     */ 
/*     */ public abstract class InOutFundTrans extends AbstractFundCoreTrans
/*     */ {
/*     */   protected boolean checkParams(TransReq transReq)
/*     */   {
/*  27 */     return (transReq != null) && (transReq.getAmount() != null) && (transReq.getAmount().longValue() > 0L) && (!StringUtil.isBlank(transReq.getFundAccount())) && (!StringUtil.isBlank(transReq.getBizNo())) && (!StringUtil.isBlank(transReq.getMoneyType())) && (!StringUtil.isBlank(transReq.getTransDate())) && (!StringUtil.isBlank(transReq.getOperator()));
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode preExecuteTrans(TransReq transReq)
/*     */   {
/*  34 */     EnumFundResultCode fundResultCode = super.preExecuteTrans(transReq);
/*  35 */     if (!StringUtil.equals(fundResultCode.getCode(), EnumFundResultCode.FUND_SUCCESS.getCode())) {
/*  36 */       return fundResultCode;
/*     */     }
/*  38 */     if (fundResultCode != EnumFundResultCode.FUND_SUCCESS) {
/*  39 */       return fundResultCode;
/*     */     }
/*     */ 
/*  42 */     Long usedBanlance = Long.valueOf(0L);
/*     */ 
/*  44 */     Long amount = transReq.getAmount();
/*     */ 
/*  47 */     if (isOutFund())
/*     */     {
/*  49 */       usedBanlance = calculateBalance();
/*     */ 
/*  51 */       if (usedBanlance == null) {
/*  52 */         if (this.log.isDebugEnabled()) {
/*  53 */           this.log.debug("fundMoney.getAmount is null");
/*     */         }
/*  55 */         return EnumFundResultCode.BALACE_NOT_ENOUGH;
/*     */       }
/*     */ 
/*  59 */       if (amount.longValue() > usedBanlance.longValue()) {
/*  60 */         if (this.log.isDebugEnabled()) {
/*  61 */           this.log.debug("usedBanlance is not enough,usedBanlance = " + usedBanlance + ",amount = " + amount);
/*     */         }
/*     */ 
/*  64 */         if (StringUtil.equals(EnumTransCode.TXCODE_FUND_OUT.getCode(), transReq.getTransCode().getCode()))
/*  65 */           return EnumFundResultCode.DRAWBALACE_NOT_ENOUGH;
/*  66 */         if ((StringUtil.equals(EnumTransCode.TXCODE_TRANS_GOODS_FUND_OUT.getCode(), transReq.getTransCode().getCode())) || (StringUtil.equals(EnumTransCode.TXCODE_TRANS_PENALTY_FUND_OUT.getCode(), transReq.getTransCode().getCode())) || (StringUtil.equals(EnumTransCode.TXCODE_TRANS_COMMISSION_FUND_OUT.getCode(), transReq.getTransCode().getCode())))
/*     */         {
/*  69 */           return EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH;
/*     */         }
/*  71 */         return EnumFundResultCode.BALACE_NOT_ENOUGH;
/*     */       }
/*     */     }
/*     */ 
/*  75 */     return fundResultCode;
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode ExecuteTrans(TransReq transReq)
/*     */   {
/*  80 */     Long amount = Long.valueOf(0L);
/*     */ 
/*  83 */     if (isTrans())
/*     */     {
/*  85 */       if (isInOutTrans())
/*  86 */         amount = Long.valueOf(transReq.getAmount().longValue() * -1L);
/*     */       else {
/*  88 */         amount = transReq.getAmount();
/*     */       }
/*     */ 
/*     */     }
/*  92 */     else if (isOutFund())
/*  93 */       amount = Long.valueOf(transReq.getAmount().longValue() * -1L);
/*     */     else {
/*  95 */       amount = transReq.getAmount();
/*     */     }
/*     */ 
/* 100 */     this.fundMoney.setPostAmount(Long.valueOf(this.fundMoney.getAmount().longValue() + amount.longValue()));
/*     */ 
/* 103 */     if (isTrans())
/*     */     {
/* 105 */       if (isNeedRecordUncomeFund()) {
/* 106 */         this.fundMoneyDAO.updateCurrentBalance(transReq.getFundAccount(), transReq.getMoneyType(), amount, transReq.getOperator(), Boolean.valueOf(true));
/*     */       }
/*     */       else {
/* 109 */         this.fundMoneyDAO.updateCurrentBalance(transReq.getFundAccount(), transReq.getMoneyType(), amount, transReq.getOperator(), Boolean.valueOf(false));
/*     */       }
/*     */     }
/*     */     else {
/* 113 */       this.fundMoneyDAO.updateCurrentBalance(transReq.getFundAccount(), transReq.getMoneyType(), amount, transReq.getOperator(), null);
/*     */     }
/*     */ 
/* 116 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode postExecuteTrans(TransReq transReq)
/*     */   {
/* 124 */     EnumFundResultCode fundResultCode = super.postExecuteTrans(transReq);
/* 125 */     return fundResultCode;
/*     */   }
/*     */ 
/*     */   protected abstract boolean isTrans();
/*     */ 
/*     */   protected abstract boolean isOutFund();
/*     */ 
/*     */   protected abstract boolean isNeedRecordUncomeFund();
/*     */ 
/*     */   protected abstract boolean isInOutTrans();
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.InOutFundTrans
 * JD-Core Version:    0.6.0
 */