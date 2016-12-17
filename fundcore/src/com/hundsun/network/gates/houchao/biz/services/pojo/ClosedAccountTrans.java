/*     */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountBankDao;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.AccountTransReq;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.TransReq;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccount;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountBank;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundAccountStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("closedAccountTrans")
/*     */ @Scope("prototype")
/*     */ public class ClosedAccountTrans extends AbstractFundCoreTrans
/*     */ {
/*     */   protected EnumFundResultCode ExecuteTrans(TransReq transReq)
/*     */   {
/*  27 */     return closedFundAccount((AccountTransReq)transReq);
/*     */   }
/*     */ 
/*     */   protected boolean checkParams(TransReq transReq)
/*     */   {
/*  32 */     if (transReq == null) {
/*  33 */       return false;
/*     */     }
/*     */ 
/*  36 */     AccountTransReq accountTransReq = (AccountTransReq)transReq;
/*     */ 
/*  40 */     return (!StringUtil.isBlank(accountTransReq.getFundAccount())) && (!StringUtil.isBlank(accountTransReq.getOperator()));
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode postExecuteTrans(TransReq transReq)
/*     */   {
/*  48 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode preExecuteTrans(TransReq transReq)
/*     */   {
/*  53 */     AccountTransReq accountTransReq = (AccountTransReq)transReq;
/*     */ 
/*  55 */     FundAccount account = this.fundAccountDAO.queryByFundAccount(accountTransReq.getFundAccount(), true);
/*  56 */     if (account == null) {
/*  57 */       return EnumFundResultCode.ACCOUNT_NOT_EXIST;
/*     */     }
/*     */ 
/*  61 */     if (StringUtil.equals(account.getStatus(), EnumFundAccountStatus.CLOSE.getCode())) {
/*  62 */       return EnumFundResultCode.ACCOUNT_BE_CANCELED;
/*     */     }
/*     */ 
/*  66 */     List<FundMoney> list = this.fundMoneyDAO.getFundMoneyByAccount(transReq.getFundAccount());
/*  67 */     for (FundMoney fundmoney : list) {
/*  68 */       if ((fundmoney.getAmount() != null) && (fundmoney.getAmount().longValue() != 0L)) {
/*  69 */         return EnumFundResultCode.CURRENT_BALANCE_NOT_ZERO;
/*     */       }
/*  71 */       if ((fundmoney.getBeginAmount() != null) && (fundmoney.getBeginAmount().longValue() != 0L)) {
/*  72 */         return EnumFundResultCode.BEGIN_AMOUNT_NOT_ZERO;
/*     */       }
/*  74 */       if ((fundmoney.getFreezeTotal() != null) && (fundmoney.getFreezeTotal().longValue() != 0L)) {
/*  75 */         return EnumFundResultCode.TRADE_FROZEN_NOT_ZERO;
/*     */       }
/*     */     }
/*     */ 
/*  79 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   private EnumFundResultCode closedFundAccount(AccountTransReq req)
/*     */   {
/*  91 */     updateFundAccountStatusC(req.getFundAccount(), req.getOperator());
/*     */ 
/*  93 */     updateFundAccountBankSatus(req);
/*     */ 
/*  95 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   private void updateFundAccountStatusC(String fundAcct, String modifyId)
/*     */   {
/* 104 */     FundAccount fundAccount = new FundAccount();
/* 105 */     fundAccount.setFundAccount(fundAcct);
/* 106 */     fundAccount.setModifyId(modifyId);
/* 107 */     fundAccount.setStatus(EnumFundAccountStatus.CLOSE.getCode());
/*     */ 
/* 109 */     this.fundAccountDAO.updateStatusClosed(fundAccount);
/*     */   }
/*     */ 
/*     */   private void updateFundAccountBankSatus(AccountTransReq req)
/*     */   {
/* 117 */     FundAccountBank fundAccountBank = new FundAccountBank();
/* 118 */     fundAccountBank.setFundAccount(req.getFundAccount());
/* 119 */     fundAccountBank.setModifyId(req.getOperator());
/* 120 */     fundAccountBank.setMemo(req.getMemo());
/*     */ 
/* 122 */     this.fundAccountBankDAO.updateFundAccountBankStatus(fundAccountBank);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.ClosedAccountTrans
 * JD-Core Version:    0.6.0
 */