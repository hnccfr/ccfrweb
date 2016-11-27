/*     */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.base.BaseDictDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountBankDao;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.AccountTransReq;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.TransReq;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.base.BaseDict;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.base.query.BaseDictQuery;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccount;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountBank;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundAccountStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.annotation.Scope;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("openedAccountTrans")
/*     */ @Scope("prototype")
/*     */ public class OpenedAccountTrans extends AbstractFundCoreTrans
/*     */ {
/*     */   private FundAccount account;
/*     */ 
/*     */   @Autowired
/*     */   private BaseDictDAO baseDictDAO;
/*     */   private static final String FUND_FORBID_FLAG = "FUND_FORBID_FLAG_TOTAL";
/*     */ 
/*     */   protected EnumFundResultCode ExecuteTrans(TransReq transReq)
/*     */   {
/*  37 */     AccountTransReq accountTransReq = (AccountTransReq)transReq;
/*     */ 
/*  39 */     if (this.account == null) {
/*  40 */       return createFundAccount(accountTransReq);
/*     */     }
/*  42 */     return reCreateFundAccount(accountTransReq);
/*     */   }
/*     */ 
/*     */   protected boolean checkParams(TransReq transReq)
/*     */   {
/*  49 */     if (transReq == null) {
/*  50 */       return false;
/*     */     }
/*  52 */     AccountTransReq accountTransReq = (AccountTransReq)transReq;
/*     */ 
/*  54 */     if ((StringUtil.isBlank(accountTransReq.getFundAccount())) || (StringUtil.isBlank(accountTransReq.getMoneyType())) || (StringUtil.isBlank(accountTransReq.getClientId())) || (StringUtil.isBlank(accountTransReq.getBankNo())) || (StringUtil.isBlank(accountTransReq.getBankAccount())) || (StringUtil.isBlank(accountTransReq.getBankBranch())) || (StringUtil.isBlank(accountTransReq.getIdKind())) || (StringUtil.isBlank(accountTransReq.getIdNo())) || (StringUtil.isBlank(accountTransReq.getOperator())) || (StringUtil.isBlank(accountTransReq.getBankAccountType())) || (StringUtil.isBlank(accountTransReq.getBranchNo())) || (StringUtil.isBlank(accountTransReq.getPositionId())))
/*     */     {
/*  66 */       return false;
/*     */     }
/*     */ 
/*  69 */     if (StringUtil.isBlank(accountTransReq.getCountry())) {
/*  70 */       accountTransReq.setCountry("CHN");
/*     */     }
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode postExecuteTrans(TransReq transReq)
/*     */   {
/*  78 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   protected EnumFundResultCode preExecuteTrans(TransReq transReq)
/*     */   {
/*  84 */     AccountTransReq accountTransReq = (AccountTransReq)transReq;
/*     */ 
/*  86 */     this.account = this.fundAccountDAO.queryByFundAccount(transReq.getFundAccount(), true);
/*     */ 
/*  88 */     if ((this.account != null) && (StringUtil.equals(this.account.getStatus(), EnumFundAccountStatus.OPEN.getCode()))) {
/*  89 */       return EnumFundResultCode.ACCOUNT_OPEN_EXIST;
/*     */     }
/*     */ 
/*  93 */     if (!StringUtil.isBlank(accountTransReq.getIdNo())) {
/*  94 */       FundAccountBank fundAccountBank = this.fundAccountBankDAO.getFundAccountBankIsExist(accountTransReq.getIdNo());
/*  95 */       if (fundAccountBank != null) {
/*  96 */         return EnumFundResultCode.FUND_ACCOUNT_BANK_CARDNO_EXIST;
/*     */       }
/*     */     }
/*     */ 
/* 100 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   private EnumFundResultCode createFundAccount(AccountTransReq req)
/*     */   {
/* 116 */     addFundAccount(req);
/*     */ 
/* 118 */     addFundAcctountBank(req);
/*     */ 
/* 120 */     addFundMoney(req);
/*     */ 
/* 122 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   private EnumFundResultCode reCreateFundAccount(AccountTransReq req)
/*     */   {
/* 136 */     updateFundAccountSataus(req);
/*     */ 
/* 138 */     addFundAcctountBank(req);
/*     */ 
/* 140 */     updateFundMoneyAmount(req);
/*     */ 
/* 142 */     return EnumFundResultCode.FUND_SUCCESS;
/*     */   }
/*     */ 
/*     */   private void addFundAccount(AccountTransReq trans)
/*     */   {
/* 150 */     FundAccount fundAccount = new FundAccount();
/* 151 */     fundAccount.setFundAccount(trans.getFundAccount());
/* 152 */     fundAccount.setClientId(trans.getClientId());
/* 153 */     fundAccount.setBankNo(trans.getBankNo());
/* 154 */     fundAccount.setStatus(EnumFundAccountStatus.OPEN.getCode());
/* 155 */     fundAccount.setCreateId(trans.getOperator());
/* 156 */     fundAccount.setModifyId(trans.getOperator());
/* 157 */     fundAccount.setMemo(trans.getMemo());
/* 158 */     this.fundAccountDAO.insert(fundAccount);
/*     */   }
/*     */ 
/*     */   private void addFundMoney(AccountTransReq trans)
/*     */   {
/* 166 */     FundMoney fundMoney = new FundMoney();
/* 167 */     fundMoney.setFundAccount(trans.getFundAccount());
/* 168 */     fundMoney.setMoneyType(trans.getMoneyType());
/* 169 */     fundMoney.setFotbidFlag("C");
/* 170 */     fundMoney.setFotbidAmount(Long.valueOf(0L));
/* 171 */     fundMoney.setCreateId(trans.getOperator());
/* 172 */     fundMoney.setModifyId(trans.getOperator());
/* 173 */     fundMoney.setMemo(trans.getMemo());
/*     */ 
/* 175 */     this.fundMoneyDAO.insertFundMoney(fundMoney);
/*     */   }
/*     */ 
/*     */   private void addFundAcctountBank(AccountTransReq trans)
/*     */   {
/* 183 */     FundAccountBank fundAccountBank = new FundAccountBank();
/* 184 */     fundAccountBank.setFundAccount(trans.getFundAccount());
/* 185 */     fundAccountBank.setClientId(trans.getClientId());
/* 186 */     fundAccountBank.setPositionId(trans.getPositionId());
/* 187 */     fundAccountBank.setMoneyType(trans.getMoneyType());
/* 188 */     fundAccountBank.setBranchNo(trans.getBranchNo());
/* 189 */     fundAccountBank.setBankNo(trans.getBankNo());
/* 190 */     fundAccountBank.setBankBranch(trans.getBankBranch());
/* 191 */     fundAccountBank.setBankAccount(trans.getBankAccount());
/* 192 */     fundAccountBank.setBankAccountType(trans.getBankAccountType());
/* 193 */     fundAccountBank.setCustomerName(trans.getCustomerName());
/* 194 */     fundAccountBank.setCardKind(trans.getIdKind());
/* 195 */     fundAccountBank.setCardNo(trans.getIdNo());
/* 196 */     fundAccountBank.setCountry(trans.getCountry());
/* 197 */     fundAccountBank.setCreateId(trans.getOperator());
/* 198 */     fundAccountBank.setModifyId(trans.getOperator());
/* 199 */     fundAccountBank.setMemo(trans.getMemo());
/*     */ 
/* 201 */     this.fundAccountBankDAO.insertFundAccountBank(fundAccountBank);
/*     */   }
/*     */ 
/*     */   private void updateFundAccountSataus(AccountTransReq trans)
/*     */   {
/* 209 */     FundAccount fundAccount = new FundAccount();
/* 210 */     fundAccount.setFundAccount(trans.getFundAccount());
/* 211 */     fundAccount.setClientId(trans.getClientId());
/* 212 */     fundAccount.setBankNo(trans.getBankNo());
/* 213 */     fundAccount.setStatus(EnumFundAccountStatus.OPEN.getCode());
/* 214 */     fundAccount.setModifyId(trans.getOperator());
/* 215 */     fundAccount.setMemo(trans.getMemo());
/*     */ 
/* 217 */     this.fundAccountDAO.updateFundAccountByAcc(fundAccount);
/*     */   }
/*     */ 
/*     */   private void updateFundMoneyAmount(AccountTransReq trans)
/*     */   {
/* 225 */     FundMoney fundMoney = new FundMoney();
/* 226 */     fundMoney.setFundAccount(trans.getFundAccount());
/* 227 */     fundMoney.setMoneyType(trans.getMoneyType());
/* 228 */     fundMoney.setAmount(trans.getAmount());
/* 229 */     fundMoney.setCreateId(trans.getOperator());
/* 230 */     fundMoney.setModifyId(trans.getOperator());
/* 231 */     fundMoney.setMemo(trans.getMemo());
/* 232 */     fundMoney.setFotbidFlag("C");
/* 233 */     fundMoney.setFotbidAmount(Long.valueOf(0L));
/*     */ 
/* 235 */     this.fundMoneyDAO.updateFundMoneyByfundAccount(fundMoney);
/*     */   }
/*     */ 
/*     */   private String getBaseDictNoVersionByFlay(AccountTransReq trans)
/*     */   {
/* 244 */     BaseDictQuery query = new BaseDictQuery();
/* 245 */     query.setFlag("FUND_FORBID_FLAG_TOTAL");
/* 246 */     BaseDict baseDict = this.baseDictDAO.getBaseDictNoVersionByFlay(query);
/* 247 */     return baseDict.getValue();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.OpenedAccountTrans
 * JD-Core Version:    0.6.0
 */