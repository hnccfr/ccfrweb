/*     */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountBankDao;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountLogDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyTotalDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.TransReq;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccount;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountLog;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoneyTotal;
/*     */ import com.hundsun.network.gates.houchao.biz.enums.EnumMiddleFundAccount;
/*     */ import com.hundsun.network.gates.houchao.biz.services.FundCoreTrans;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundAccountStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransCode;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ 
/*     */ public abstract class AbstractFundCoreTrans
/*     */   implements FundCoreTrans
/*     */ {
/*  38 */   protected final Log log = LogFactory.getLog(AbstractFundCoreTrans.class);
/*     */ 
/*     */   @Autowired
/*     */   protected FundAccountDAO fundAccountDAO;
/*     */ 
/*     */   @Autowired
/*     */   protected FundMoneyDAO fundMoneyDAO;
/*     */ 
/*     */   @Autowired
/*     */   protected FundAccountLogDAO fundAccountLogDAO;
/*     */ 
/*     */   @Autowired
/*     */   protected FundMoneyTotalDAO fundMoneyTotalDAO;
/*     */ 
/*     */   @Autowired
/*     */   protected FundAccountBankDao fundAccountBankDAO;
/*     */   protected FundMoney fundMoney;
/*     */   protected FundAccountLog fundAccountLog;
/*     */ 
/*  62 */   public EnumFundResultCode execute(TransReq transReq) { if (!checkParams(transReq)) {
/*  63 */       return EnumFundResultCode.REQUEST_PARAM_ERROR;
/*     */     }
/*     */ 
/*  66 */     EnumFundResultCode resultCode = preExecuteTrans(transReq);
/*  67 */     if (resultCode != EnumFundResultCode.FUND_SUCCESS) {
/*  68 */       return resultCode;
/*     */     }
/*     */ 
/*  71 */     resultCode = ExecuteTrans(transReq);
/*  72 */     if (resultCode != EnumFundResultCode.FUND_SUCCESS) {
/*  73 */       return resultCode;
/*     */     }
/*     */ 
/*  76 */     if (resultCode == EnumFundResultCode.FUND_SUCCESS) {
/*  77 */       resultCode = postExecuteTrans(transReq);
/*  78 */       if (resultCode != EnumFundResultCode.FUND_SUCCESS) {
/*  79 */         return resultCode;
/*     */       }
/*     */     }
/*     */ 
/*  83 */     return resultCode;
/*     */   }
/*     */ 
/*     */   protected abstract boolean checkParams(TransReq paramTransReq);
/*     */ 
/*     */   protected EnumFundResultCode preExecuteTrans(TransReq transReq)
/*     */   {
/* 100 */     FundAccount fundAccount = this.fundAccountDAO.queryByFundAccount(transReq.getFundAccount(), true);
/* 101 */     if (fundAccount == null) {
/* 102 */       this.log.error("fundAccount not exist!");
/* 103 */       return EnumFundResultCode.ACCOUNT_NOT_EXIST;
/*     */     }
/*     */ 
/* 106 */     if (!StringUtil.equals(fundAccount.getStatus(), EnumFundAccountStatus.OPEN.getCode())) {
/* 107 */       this.log.error("fundAccount is closed!");
/* 108 */       return EnumFundResultCode.ACCOUNT_BE_CANCELED;
/*     */     }
/*     */ 
/* 112 */     if (checkBizNoIsExist(transReq)) {
/* 113 */       this.log.error("fundAccountLog is exist!");
/* 114 */       return EnumFundResultCode.BIZ_NO_EXIST;
/*     */     }
/*     */ 
/* 118 */     this.fundMoney = this.fundMoneyDAO.getByFundAccountWithMoneyType(transReq.getFundAccount(), transReq.getMoneyType());
/* 119 */     if (this.fundMoney == null) {
/* 120 */       this.log.error("fundMoney not exist!");
/* 121 */       return EnumFundResultCode.FUND_MONEY_NOT_EXIST;
/*     */     }
/* 123 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   protected abstract EnumFundResultCode ExecuteTrans(TransReq paramTransReq);
/*     */ 
/*     */   protected EnumFundResultCode postExecuteTrans(TransReq transReq)
/*     */   {
/* 139 */     addFundAccountLog(transReq);
/*     */ 
/* 141 */     addFundMoneyTotalLog(transReq);
/* 142 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   protected Long addFundAccountLog(TransReq transReq)
/*     */   {
/* 151 */     FundAccountLog fundAccountLog = new FundAccountLog();
/* 152 */     fundAccountLog.setTransDate(transReq.getTransDate());
/* 153 */     fundAccountLog.setFundAccount(transReq.getFundAccount());
/* 154 */     fundAccountLog.setTransCode(StringUtils.substring(transReq.getTransCode().getCode(), 0, 4));
/* 155 */     fundAccountLog.setSubTransCode(transReq.getTransCode().getCode());
/* 156 */     fundAccountLog.setTransAmount(transReq.getAmount());
/* 157 */     fundAccountLog.setPostAmount(this.fundMoney.getPostAmount());
/* 158 */     fundAccountLog.setBizNo(transReq.getBizNo());
/*     */ 
/* 160 */     fundAccountLog.setOperator(transReq.getOperator());
/* 161 */     if (StringUtil.isNotBlank(transReq.getBankBranch()))
/* 162 */       fundAccountLog.setBranchNo(transReq.getBankBranch());
/*     */     else {
/* 164 */       fundAccountLog.setBranchNo("00001");
/*     */     }
/* 166 */     fundAccountLog.setCreateId(transReq.getOperator());
/* 167 */     fundAccountLog.setModifyId(transReq.getOperator());
/*     */ 
/* 169 */     if (StringUtil.isBlank(transReq.getMemo()))
/* 170 */       fundAccountLog.setMemo(transReq.getTransCode().getDescription());
/*     */     else {
/* 172 */       fundAccountLog.setMemo(transReq.getMemo());
/*     */     }
/* 174 */     Long id = this.fundAccountLogDAO.insert(fundAccountLog);
/* 175 */     return id;
/*     */   }
/*     */ 
/*     */   protected void addFundMoneyTotalLog(TransReq transReq)
/*     */   {
/* 184 */     FundMoneyTotal fundMoneyTotal = this.fundMoneyTotalDAO.queryByTransCode(transReq.getFundAccount(), transReq.getTransCode().getCode(), transReq.getTransDate());
/*     */ 
/* 186 */     if (fundMoneyTotal == null) {
/* 187 */       fundMoneyTotal = new FundMoneyTotal();
/* 188 */       fundMoneyTotal.setFundAccount(transReq.getFundAccount());
/* 189 */       fundMoneyTotal.setTransDate(transReq.getTransDate());
/* 190 */       fundMoneyTotal.setTransSubCode(transReq.getTransCode().getCode());
/* 191 */       fundMoneyTotal.setTotalAmount(transReq.getAmount());
/* 192 */       fundMoneyTotal.setCreateId(transReq.getOperator());
/* 193 */       fundMoneyTotal.setModifyId(transReq.getOperator());
/* 194 */       if (StringUtil.isBlank(transReq.getMemo()))
/* 195 */         fundMoneyTotal.setMemo(transReq.getTransCode().getDescription());
/*     */       else {
/* 197 */         fundMoneyTotal.setMemo(transReq.getMemo());
/*     */       }
/* 199 */       this.fundMoneyTotalDAO.insert(fundMoneyTotal);
/*     */     } else {
/* 201 */       Long totalAmount = Long.valueOf(fundMoneyTotal.getTotalAmount().longValue() + transReq.getAmount().longValue());
/* 202 */       fundMoneyTotal.setTotalAmount(totalAmount);
/* 203 */       fundMoneyTotal.setModifyId(transReq.getOperator());
/* 204 */       if (StringUtil.isBlank(transReq.getMemo()))
/* 205 */         fundMoneyTotal.setMemo(transReq.getTransCode().getDescription());
/*     */       else {
/* 207 */         fundMoneyTotal.setMemo(transReq.getMemo());
/*     */       }
/* 209 */       this.fundMoneyTotalDAO.update(fundMoneyTotal);
/*     */     }
/*     */   }
/*     */ 
/*     */   protected boolean checkBizNoIsExist(TransReq transReq)
/*     */   {
/* 225 */     FundAccountLog accountLog = new FundAccountLog();
/* 226 */     if (isCheckBizNoByBankNO(transReq.getTransCode().getCode())) {
/* 227 */       accountLog.setBizNo(transReq.getBizNo());
/* 228 */       accountLog.setSubTransCode(transReq.getTransCode().getCode());
/*     */ 
/* 230 */       accountLog = this.fundAccountLogDAO.getFundAccountLog(accountLog);
/* 231 */     } else if ((StringUtil.equals(transReq.getFundAccount(), EnumMiddleFundAccount.MIDDLE_FEE_FUND_ACCOUNT.getCode())) || (StringUtil.equals(transReq.getFundAccount(), EnumMiddleFundAccount.MIDDLE_GOODS_FUND_ACCOUNT.getCode())))
/*     */     {
/* 233 */       accountLog = null;
/*     */     } else {
/* 235 */       accountLog = this.fundAccountLogDAO.getByBizNoAndSubTransCodeAndFundAccount(transReq.getBizNo(), transReq.getTransCode().getCode(), transReq.getFundAccount());
/*     */     }
/*     */ 
/* 238 */     return accountLog != null;
/*     */   }
/*     */ 
/*     */   protected boolean isCheckBizNoByBankNO(String subTransCode)
/*     */   {
/* 250 */     return (StringUtil.equals(EnumTransCode.TXCODE_FUND_IN.getCode(), subTransCode)) || (StringUtil.equals(EnumTransCode.TXCODE_FUND_OUT.getCode(), subTransCode)) || (StringUtil.equals(EnumTransCode.TXCODE_FUND_WRITEOFF.getCode(), subTransCode));
/*     */   }
/*     */ 
/*     */   protected Long calculateBalance()
/*     */   {
/* 260 */     Long amount = Long.valueOf(this.fundMoney.getAmount() == null ? 0L : this.fundMoney.getAmount().longValue());
/* 261 */     Long freezeTotal = Long.valueOf(this.fundMoney.getFreezeTotal() == null ? 0L : this.fundMoney.getFreezeTotal().longValue());
/* 262 */     Long balance = Long.valueOf(amount.longValue() - freezeTotal.longValue());
/* 263 */     return balance;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.AbstractFundCoreTrans
 * JD-Core Version:    0.6.0
 */