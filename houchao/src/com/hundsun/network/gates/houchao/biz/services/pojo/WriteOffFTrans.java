/*     */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountLogDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyTotalDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.TransReq;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccount;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountLog;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoneyTotal;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundAccountStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransCode;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("writeOffFTrans")
/*     */ @Scope("prototype")
/*     */ public class WriteOffFTrans extends AbstractFundCoreTrans
/*     */ {
/*     */   protected FundAccountLog accountLog;
/*     */   private FundAccount account;
/*     */   private static final String ACCOUNT_UNDOFLAG_C = "C";
/*     */   private static final String ACCOUNT_UNDOFLAG_B = "B";
/*     */ 
/*     */   protected EnumFundResultCode ExecuteTrans(TransReq transReq)
/*     */   {
/*  38 */     if (StringUtil.equals(this.accountLog.getSubTransCode(), EnumTransCode.TXCODE_FUND_IN.getCode()))
/*     */     {
/*  40 */       TransReq transRequest = new TransReq();
/*  41 */       transRequest.setFundAccount(this.account.getFundAccount());
/*  42 */       transRequest.setMoneyType(transReq.getMoneyType());
/*  43 */       transRequest.setTransCode(EnumTransCode.TXCODE_FUND_OUT);
/*  44 */       Long drawAmount = Long.valueOf(this.fundMoney.getAmount().longValue() - this.fundMoney.getFreezeTotal().longValue());
/*  45 */       if ((drawAmount == null) || (drawAmount.longValue() < 0L))
/*  46 */         return EnumFundResultCode.OPERATE_FAILURE;
/*  47 */       if (this.accountLog.getTransAmount().longValue() <= drawAmount.longValue()) {
/*  48 */         long amount = this.fundMoney.getAmount().longValue() - this.accountLog.getTransAmount().longValue();
/*     */ 
/*  50 */         this.fundMoney.setAmount(Long.valueOf(amount));
/*     */       } else {
/*  52 */         return EnumFundResultCode.WRITE_OFF_BUY_UNCOME;
/*     */       }
/*  53 */     } else if (StringUtil.equals(this.accountLog.getSubTransCode(), EnumTransCode.TXCODE_FUND_OUT.getCode())) {
/*  54 */       long amount = this.fundMoney.getAmount().longValue() + this.accountLog.getTransAmount().longValue();
/*  55 */       this.fundMoney.setAmount(Long.valueOf(amount));
/*     */     }
/*     */ 
/*  59 */     this.fundMoney.setModifyId(transReq.getOperator());
/*  60 */     this.fundMoney.setMemo(transReq.getMemo());
/*  61 */     this.fundMoneyDAO.updateFundMoneyByfundAccount(this.fundMoney);
/*     */ 
/*  64 */     this.accountLog.setModifyId(transReq.getOperator());
/*  65 */     this.accountLog.setUndoFlag("B");
/*  66 */     this.fundAccountLogDAO.updateToCancelFlag(this.accountLog);
/*     */ 
/*  69 */     transReq.setFundAccount(this.account.getFundAccount());
/*  70 */     transReq.setAmount(Long.valueOf(-this.accountLog.getTransAmount().longValue()));
/*  71 */     addFundAccountLogWriteoff(transReq, "C");
/*     */ 
/*  73 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   protected boolean checkParams(TransReq transReq)
/*     */   {
/*  78 */     if (transReq == null) {
/*  79 */       return false;
/*     */     }
/*     */ 
/*  90 */     return (!StringUtil.isBlank(transReq.getBizNo())) && (!StringUtil.isBlank(transReq.getOperator())) && (!StringUtil.isBlank(transReq.getTransDate()));
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode postExecuteTrans(TransReq transReq)
/*     */   {
/* 102 */     EnumFundResultCode resultcode = updateFundMoneyTotalLog(transReq);
/*     */ 
/* 104 */     return resultcode;
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode preExecuteTrans(TransReq transReq)
/*     */   {
/* 110 */     this.accountLog = new FundAccountLog();
/* 111 */     this.accountLog = this.fundAccountLogDAO.fundAccountLogBybizNO(transReq.getBizNo());
/* 112 */     if (this.accountLog == null) {
/* 113 */       return EnumFundResultCode.WRITE_OFF_NOT_EXIST_OR_BE_DONE;
/*     */     }
/*     */ 
/* 116 */     if ((null == this.accountLog.getUndoFlag()) || (StringUtil.equals(this.accountLog.getUndoFlag(), "C")))
/*     */     {
/* 119 */       if ((!StringUtil.equals(this.accountLog.getSubTransCode(), EnumTransCode.TXCODE_FUND_IN.getCode())) && (!StringUtil.equals(this.accountLog.getSubTransCode(), EnumTransCode.TXCODE_FUND_OUT.getCode())))
/*     */       {
/* 122 */         return EnumFundResultCode.OPERATE_NOT_SUPPORT;
/*     */       }
/*     */ 
/* 126 */       this.account = this.fundAccountDAO.queryByFundAccount(this.accountLog.getFundAccount(), true);
/* 127 */       if (this.account == null) {
/* 128 */         return EnumFundResultCode.ACCOUNT_NOT_EXIST;
/*     */       }
/*     */ 
/* 131 */       if (StringUtil.equals(this.account.getStatus(), EnumFundAccountStatus.CLOSE.getCode())) {
/* 132 */         return EnumFundResultCode.ACCOUNT_BE_CANCELED;
/*     */       }
/*     */ 
/* 136 */       this.fundMoney = this.fundMoneyDAO.getByFundAccountWithMoneyType(this.accountLog.getFundAccount(), transReq.getMoneyType());
/*     */     }
/*     */ 
/* 139 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   protected Long addFundAccountLogWriteoff(TransReq transReq, String undoFlag)
/*     */   {
/* 148 */     FundAccountLog fundAccountLog = new FundAccountLog();
/* 149 */     fundAccountLog.setTransDate(transReq.getTransDate());
/* 150 */     fundAccountLog.setFundAccount(transReq.getFundAccount());
/* 151 */     fundAccountLog.setTransCode(StringUtils.substring(transReq.getTransCode().getCode(), 0, 4));
/* 152 */     fundAccountLog.setSubTransCode(transReq.getTransCode().getCode());
/* 153 */     fundAccountLog.setTransAmount(transReq.getAmount());
/* 154 */     fundAccountLog.setPostAmount(this.fundMoney.getAmount());
/* 155 */     fundAccountLog.setBizNo(transReq.getBizNo());
/*     */ 
/* 157 */     fundAccountLog.setUndoFlag(undoFlag);
/* 158 */     fundAccountLog.setOperator(transReq.getOperator());
/* 159 */     if (StringUtil.isNotBlank(transReq.getBankBranch()))
/* 160 */       fundAccountLog.setBranchNo(transReq.getBankBranch());
/*     */     else {
/* 162 */       fundAccountLog.setBranchNo("00001");
/*     */     }
/* 164 */     fundAccountLog.setCreateId(transReq.getOperator());
/* 165 */     fundAccountLog.setModifyId(transReq.getOperator());
/* 166 */     fundAccountLog.setMemo(transReq.getMemo());
/*     */ 
/* 168 */     Long id = this.fundAccountLogDAO.insert(fundAccountLog);
/* 169 */     return id;
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode updateFundMoneyTotalLog(TransReq transReq)
/*     */   {
/* 178 */     FundMoneyTotal fundMoneyTotal = this.fundMoneyTotalDAO.queryByTransCode(transReq.getFundAccount(), this.accountLog.getSubTransCode(), transReq.getTransDate());
/*     */ 
/* 180 */     if (null != fundMoneyTotal) {
/* 181 */       Long totalAmount = Long.valueOf(fundMoneyTotal.getTotalAmount().longValue() - this.accountLog.getTransAmount().longValue());
/* 182 */       fundMoneyTotal.setTotalAmount(totalAmount);
/* 183 */       fundMoneyTotal.setModifyId(transReq.getOperator());
/* 184 */       fundMoneyTotal.setMemo(transReq.getMemo());
/* 185 */       this.fundMoneyTotalDAO.update(fundMoneyTotal);
/* 186 */       return EnumFundResultCode.FUND_SUCCESS;
/*     */     }
/* 188 */     this.log.error("fundMoneyTotal is null:fundaccount=" + transReq.getFundAccount() + ",subTransCode=" + this.accountLog.getSubTransCode());
/*     */ 
/* 190 */     return EnumFundResultCode.OPERATE_FAILURE;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.WriteOffFTrans
 * JD-Core Version:    0.6.0
 */