/*      */ package com.hundsun.network.gates.wulin.biz.service.pojo.fund;
/*      */ 
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumFundsOperateType;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.request.AccountRequest;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundBatchResult;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.funds.CashTradeAccountDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.funds.CashTradeStatusDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.funds.CashTradeAccount;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.funds.CashTradeStatus;
/*      */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.fund.CashTradeService;
/*      */ import com.hundsun.network.melody.common.util.StringUtil;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.stereotype.Repository;
/*      */ import org.springframework.transaction.TransactionStatus;
/*      */ import org.springframework.transaction.support.TransactionCallback;
/*      */ import org.springframework.transaction.support.TransactionTemplate;
/*      */ 
/*      */ @Repository("cashTradeService")
/*      */ public class CashTradeServiceImpl extends BaseService
/*      */   implements CashTradeService
/*      */ {
/*      */ 
/*      */   @Autowired
/*      */   private CashTradeAccountDAO cashTradeAccountDAO;
/*      */ 
/*      */   @Autowired
/*      */   private CashTradeStatusDAO cashTradeStatusDAO;
/*   38 */   private String sysFundsAccount = "9999";
/*   39 */   private String sysServiceChargeAccount = "8888";
/*      */ 
/*      */   public FundOperateResult createFundAccount(final AccountRequest request)
/*      */   {
/*   63 */     final FundOperateResult result = new FundOperateResult();
/*   64 */     result.setFundAccount(request.getFundAccount());
/*   65 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*   66 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */ 
/*   69 */     if ((null == request) || (StringUtil.isEmpty(request.getTradeAccount())) || (StringUtil.isEmpty(request.getFundAccount())) || (null == request.getBalance()) || (StringUtil.isEmpty(request.getBankAccount())) || (StringUtil.isEmpty(request.getHolderName())) || (StringUtil.isEmpty(request.getIdKind())) || (StringUtil.isEmpty(request.getIdNo())))
/*      */     {
/*   72 */       result.setErrorNO(EnumFundResultCode.ACCOUNT_INFO_NOT_ENOUGH.getCode());
/*   73 */       result.setErrorInfo(EnumFundResultCode.ACCOUNT_INFO_NOT_ENOUGH.getDescription());
/*   74 */       return result;
/*      */     }
/*      */     try
/*      */     {
/*   78 */       Map parasMap = new HashMap();
/*   79 */       parasMap.put("taid", request.getFundAccount());
/*      */ 
/*   81 */       CashTradeAccount exitCTA = this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*   82 */       if (exitCTA != null) {
/*   83 */         result.setErrorNO(EnumFundResultCode.ACCOUNT_OPEN_EXIST.getCode());
/*   84 */         result.setErrorInfo(EnumFundResultCode.ACCOUNT_OPEN_EXIST.getDescription());
/*   85 */         return result;
/*      */       }
/*      */ 
/*   89 */       Map cerMap = new HashMap();
/*   90 */       cerMap.put("cerNum", request.getIdNo());
/*   91 */       cerMap.put("cerType", request.getIdKind());
/*   92 */       exitCTA = this.cashTradeAccountDAO.selectCashTradeAccountByTaid(cerMap);
/*   93 */       if (exitCTA != null) {
/*   94 */         result.setErrorNO(EnumFundResultCode.FUND_ACCOUNT_BANK_CARDNO_EXIST.getCode());
/*   95 */         result.setErrorInfo(EnumFundResultCode.FUND_ACCOUNT_BANK_CARDNO_EXIST.getDescription());
/*   96 */         return result;
/*      */       }
/*   98 */       this.transactionTemplate.execute(new TransactionCallback() {
/*      */         public FundOperateResult doInTransaction(TransactionStatus status) {
/*      */           try {
/*  101 */             CashTradeAccount ctAccount = new CashTradeAccount();
/*  102 */             ctAccount.setBalance(request.getBalance());
/*  103 */             ctAccount.setBankAccount(request.getBankAccount());
/*  104 */             ctAccount.setBankName(request.getBankNo());
/*  105 */             ctAccount.setCertificateNum(request.getIdNo());
/*  106 */             ctAccount.setCertificateType(request.getIdKind());
/*  107 */             ctAccount.setFreeMoney(request.getBalance());
/*  108 */             ctAccount.setFrozenMoney(Long.valueOf(0L));
/*  109 */             ctAccount.setState("N");
/*  110 */             ctAccount.setTaid(request.getFundAccount());
/*  111 */             ctAccount.setUserAccount(request.getTradeAccount());
/*  112 */             ctAccount.setTradePwd("123456");
/*  113 */             Long num = CashTradeServiceImpl.this.cashTradeAccountDAO.registFundsAccount(ctAccount);
/*  114 */             if (num.longValue() < 0L) {
/*  115 */               result.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  116 */               result.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*  117 */               status.setRollbackOnly();
/*  118 */               return result;
/*      */             }
/*      */ 
/*  122 */             String subject = EnumFundsOperateType.REGIST_FUNDACCOUNT.getValue();
/*  123 */             CashTradeStatus cts = new CashTradeStatus();
/*  124 */             cts.setComments("开户：" + request.getFundAccount());
/*  125 */             cts.setSubject(subject);
/*  126 */             cts.setTaid(request.getFundAccount());
/*  127 */             cts.setTotalPay(request.getBalance());
/*  128 */             cts.setSourceId(request.getBizNo());
/*  129 */             Long numCS = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/*  130 */             if (numCS.longValue() < 0L) {
/*  131 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  132 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  133 */               status.setRollbackOnly();
/*  134 */               return result;
/*      */             }
/*      */           } catch (Exception e) {
/*  137 */             status.setRollbackOnly();
/*  138 */             e.printStackTrace();
/*  139 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  140 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  141 */             return result;
/*      */           }
/*  143 */           return result;
/*      */         }
/*      */       });
/*  147 */       return result;
/*      */     } catch (Exception e) {
/*  149 */       e.printStackTrace();
/*  150 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  151 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  152 */     }return result;
/*      */   }
/*      */ 
/*      */   public FundOperateResult fundInAccount(final TransRequest request)
/*      */   {
/*  169 */     final FundOperateResult result = new FundOperateResult();
/*  170 */     result.setFundAccount(request.getFundAccount());
/*  171 */     result.setBizNo(request.getBizNo());
/*  172 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  173 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */     try
/*      */     {
/*  177 */       if ((null == request) || (StringUtil.isEmpty(request.getFundAccount())) || (null == request.getAmount()) || (request.getAmount().longValue() < 0L) || (StringUtil.isEmpty(request.getOperator())))
/*      */       {
/*  179 */         result.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  180 */         result.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  181 */         return result;
/*      */       }
/*      */ 
/*  184 */       final Map parasMap = new HashMap();
/*  185 */       parasMap.put("taid", request.getFundAccount());
/*      */ 
/*  187 */       CashTradeAccount ctAccount = this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*  188 */       if (ctAccount == null) {
/*  189 */         result.setErrorNO(EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode());
/*  190 */         result.setErrorInfo(EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription());
/*  191 */         return result;
/*      */       }
/*      */ 
/*  194 */       this.transactionTemplate.execute(new TransactionCallback() {
/*      */         public FundOperateResult doInTransaction(TransactionStatus status) {
/*      */           try {
/*  197 */             parasMap.put("money", request.getAmount());
/*      */ 
/*  199 */             int inNum = CashTradeServiceImpl.this.cashTradeAccountDAO.incomeCashAccount(parasMap);
/*  200 */             if (inNum != 1) {
/*  201 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  202 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  203 */               status.setRollbackOnly();
/*  204 */               return result;
/*      */             }
/*      */ 
/*  207 */             String subject = EnumFundsOperateType.INCOME.getValue();
/*  208 */             CashTradeStatus cts = new CashTradeStatus();
/*  209 */             cts.setComments("入金，金额：" + request.getAmount() + "分");
/*  210 */             cts.setSubject(subject);
/*  211 */             cts.setTaid(request.getFundAccount());
/*  212 */             cts.setTotalPay(request.getAmount());
/*  213 */             cts.setSourceId(request.getBizNo());
/*  214 */             Long numCS = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/*  215 */             if (numCS.longValue() < 0L) {
/*  216 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  217 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  218 */               status.setRollbackOnly();
/*  219 */               return result;
/*      */             }
/*      */           }
/*      */           catch (Exception e) {
/*  223 */             status.setRollbackOnly();
/*  224 */             e.printStackTrace();
/*  225 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  226 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  227 */             return result;
/*      */           }
/*  229 */           return result;
/*      */         }
/*      */       });
/*  232 */       return result;
/*      */     } catch (Exception e) {
/*  234 */       e.printStackTrace();
/*  235 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  236 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  237 */     }return result;
/*      */   }
/*      */ 
/*      */   public FundOperateResult fundOutAccount(final TransRequest request)
/*      */   {
/*  254 */     final FundOperateResult result = new FundOperateResult();
/*  255 */     result.setFundAccount(request.getFundAccount());
/*  256 */     result.setBizNo(request.getBizNo());
/*  257 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  258 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */     try
/*      */     {
/*  262 */       if ((null == request) || (StringUtil.isEmpty(request.getFundAccount())) || (null == request.getAmount()) || (request.getAmount().longValue() < 0L) || (StringUtil.isEmpty(request.getOperator())))
/*      */       {
/*  264 */         result.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  265 */         result.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  266 */         return result;
/*      */       }
/*      */ 
/*  269 */       final Map parasMap = new HashMap();
/*  270 */       parasMap.put("taid", request.getFundAccount());
/*      */ 
/*  272 */       this.transactionTemplate.execute(new TransactionCallback() {
/*      */         public FundOperateResult doInTransaction(TransactionStatus status) {
/*      */           try {
/*  275 */             parasMap.put("money", request.getAmount());
/*      */ 
/*  278 */             CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*  279 */             if ((ctAccount == null) || (ctAccount.getFreeMoney() == null) || (ctAccount.getFreeMoney().longValue() < request.getAmount().longValue())) {
/*  280 */               String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.AMOUNT_OFF_FORBID_BALANCE.getCode();
/*  281 */               String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.AMOUNT_OFF_FORBID_BALANCE.getDescription();
/*  282 */               result.setErrorNO(errCode);
/*  283 */               result.setErrorInfo(errInfo);
/*  284 */               return result;
/*      */             }
/*  286 */             int outNum = CashTradeServiceImpl.this.cashTradeAccountDAO.outcomeCashAccount(parasMap);
/*  287 */             if (outNum != 1) {
/*  288 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  289 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  290 */               status.setRollbackOnly();
/*  291 */               return result;
/*      */             }
/*      */ 
/*  294 */             String subject = EnumFundsOperateType.OUTCOME.getValue();
/*  295 */             CashTradeStatus cts = new CashTradeStatus();
/*  296 */             cts.setComments("出金，金额：" + request.getAmount() + "分");
/*  297 */             cts.setSubject(subject);
/*  298 */             cts.setTaid(request.getFundAccount());
/*  299 */             cts.setTotalPay(request.getAmount());
/*  300 */             cts.setSourceId(request.getBizNo());
/*  301 */             Long numCS = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/*  302 */             if (numCS.longValue() < 0L) {
/*  303 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  304 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  305 */               status.setRollbackOnly();
/*  306 */               return result;
/*      */             }
/*      */           }
/*      */           catch (Exception e) {
/*  310 */             status.setRollbackOnly();
/*  311 */             e.printStackTrace();
/*  312 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  313 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  314 */             return result;
/*      */           }
/*  316 */           return result;
/*      */         }
/*      */       });
/*  319 */       return result;
/*      */     } catch (Exception e) {
/*  321 */       e.printStackTrace();
/*  322 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  323 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  324 */     }return result;
/*      */   }
/*      */ 
/*      */   public FundOperateResult freezeFundByTrade(final TransRequest request)
/*      */   {
/*  348 */     final FundOperateResult result = new FundOperateResult();
/*  349 */     result.setFundAccount(request.getFundAccount());
/*  350 */     result.setBizNo(request.getBizNo());
/*  351 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  352 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */     try
/*      */     {
/*  356 */       if ((null == request) || (StringUtil.isEmpty(request.getFundAccount())) || (StringUtil.isEmpty(request.getOrderProperty())) || (StringUtil.isEmpty(request.getOperator())) || (null == request.getFreezeDepositAmount()) || (request.getFreezeDepositAmount().longValue() < 0L) || (StringUtil.isEmpty(request.getBizNo())))
/*      */       {
/*  358 */         result.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  359 */         result.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  360 */         return result;
/*      */       }
/*      */ 
/*  364 */       final Map parasMap = new HashMap();
/*  365 */       parasMap.put("taid", request.getFundAccount());
/*      */ 
/*  368 */       CashTradeAccount ctAccount = this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*  369 */       if ((ctAccount == null) || (ctAccount.getFreeMoney() == null) || (ctAccount.getFreeMoney().longValue() < request.getFreezeDepositAmount().longValue())) {
/*  370 */         String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/*  371 */         String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/*  372 */         result.setErrorNO(errCode);
/*  373 */         result.setErrorInfo(errInfo);
/*  374 */         return result;
/*      */       }
/*      */ 
/*  378 */       this.transactionTemplate.execute(new TransactionCallback() {
/*      */         public FundOperateResult doInTransaction(TransactionStatus status) {
/*      */           try {
/*  381 */             parasMap.put("money", request.getFreezeDepositAmount());
/*      */ 
/*  383 */             int frozenNum = CashTradeServiceImpl.this.cashTradeAccountDAO.frozenCashAccount(parasMap);
/*  384 */             if (frozenNum != 1) {
/*  385 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  386 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  387 */               status.setRollbackOnly();
/*  388 */               return result;
/*      */             }
/*      */ 
/*  391 */             String subject = EnumFundsOperateType.OUT_JY.getValue();
/*  392 */             CashTradeStatus cts = new CashTradeStatus();
/*  393 */             cts.setComments("冻结交易保证金，金额：" + request.getFreezeDepositAmount() + "分");
/*  394 */             cts.setSubject(subject);
/*  395 */             cts.setTaid(request.getFundAccount());
/*  396 */             cts.setTotalPay(request.getFreezeDepositAmount());
/*  397 */             cts.setSourceId(request.getBizNo());
/*  398 */             Long numCS = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/*  399 */             if (numCS.longValue() < 0L) {
/*  400 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  401 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  402 */               status.setRollbackOnly();
/*  403 */               return result;
/*      */             }
/*      */           } catch (Exception e) {
/*  406 */             status.setRollbackOnly();
/*  407 */             e.printStackTrace();
/*  408 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  409 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  410 */             return result;
/*      */           }
/*  412 */           return result;
/*      */         }
/*      */       });
/*  415 */       return result;
/*      */     } catch (Exception e) {
/*  417 */       e.printStackTrace();
/*  418 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  419 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  420 */     }return result;
/*      */   }
/*      */ 
/*      */   public FundOperateResult fillFundByTrade(final TransRequest request)
/*      */   {
/*  442 */     final FundOperateResult result = new FundOperateResult();
/*  443 */     result.setFundAccount(request.getFundAccount());
/*  444 */     result.setBizNo(request.getBizNo());
/*  445 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  446 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */     try
/*      */     {
/*  450 */       if (!validatorSettlePara(request)) {
/*  451 */         result.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  452 */         result.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  453 */         return result;
/*      */       }
/*      */ 
/*  457 */       this.transactionTemplate.execute(new TransactionCallback() {
/*      */         public FundOperateResult doInTransaction(TransactionStatus status) {
/*      */           try {
/*  460 */             Map paraMap = new HashMap();
/*  461 */             paraMap.put("taid", request.getFundAccount());
/*      */ 
/*  465 */             CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(paraMap);
/*  466 */             if ((ctAccount == null) || (ctAccount.getFrozenMoney() == null) || (ctAccount.getFrozenMoney().longValue() < request.getFreezeDepositAmount().longValue())) {
/*  467 */               String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/*  468 */               String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/*  469 */               result.setErrorNO(errCode);
/*  470 */               result.setErrorInfo(errInfo);
/*  471 */               status.setRollbackOnly();
/*  472 */               return result;
/*      */             }
/*  474 */             paraMap.put("money", request.getFreezeDepositAmount());
/*  475 */             int thawNum = CashTradeServiceImpl.this.cashTradeAccountDAO.thawCashAccount(paraMap);
/*  476 */             if (thawNum != 1) {
/*  477 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  478 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  479 */               status.setRollbackOnly();
/*  480 */               return result;
/*      */             }
/*      */ 
/*  486 */             ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(paraMap);
/*  487 */             if ((ctAccount == null) || (ctAccount.getFreeMoney() == null) || (ctAccount.getFreeMoney().longValue() < request.getDeliveryAmount().longValue())) {
/*  488 */               String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/*  489 */               String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/*  490 */               result.setErrorNO(errCode);
/*  491 */               result.setErrorInfo(errInfo);
/*  492 */               status.setRollbackOnly();
/*  493 */               return result;
/*      */             }
/*  495 */             paraMap.put("money", request.getDeliveryAmount());
/*  496 */             int frozenNum = CashTradeServiceImpl.this.cashTradeAccountDAO.frozenCashAccount(paraMap);
/*  497 */             if (frozenNum != 1) {
/*  498 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  499 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  500 */               status.setRollbackOnly();
/*  501 */               return result;
/*      */             }
/*      */ 
/*  506 */             ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(paraMap);
/*  507 */             if ((ctAccount == null) || (ctAccount.getFreeMoney() == null) || (ctAccount.getFreeMoney().longValue() < request.getFeeAmount().longValue())) {
/*  508 */               String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/*  509 */               String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/*  510 */               result.setErrorNO(errCode);
/*  511 */               result.setErrorInfo(errInfo);
/*  512 */               status.setRollbackOnly();
/*  513 */               return result;
/*      */             }
/*  515 */             paraMap.put("money", request.getFeeAmount());
/*  516 */             int outSCNum = CashTradeServiceImpl.this.cashTradeAccountDAO.outcomeCashAccount(paraMap);
/*  517 */             paraMap.put("taid", CashTradeServiceImpl.this.sysServiceChargeAccount);
/*  518 */             int inSCNum = CashTradeServiceImpl.this.cashTradeAccountDAO.incomeCashAccount(paraMap);
/*  519 */             if ((outSCNum != 1) || (inSCNum != 1)) {
/*  520 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  521 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  522 */               status.setRollbackOnly();
/*  523 */               return result;
/*      */             }
/*      */ 
/*  527 */             String subject = EnumFundsOperateType.OUT_ORDER_JS.getValue();
/*  528 */             CashTradeStatus cts = new CashTradeStatus();
/*  529 */             cts.setComments("冻结交收保证金：1、解冻交易保证金，" + request.getFreezeDepositAmount() + "；2、冻结交收保证金，" + request.getDeliveryAmount() + "分；" + "3、收取服务费，" + request.getFeeAmount());
/*      */ 
/*  531 */             cts.setSubject(subject);
/*  532 */             cts.setTaid(request.getFundAccount());
/*  533 */             cts.setTotalPay(request.getDeliveryAmount());
/*  534 */             cts.setSourceId(request.getBizNo());
/*  535 */             Long numCS = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/*  536 */             if (numCS.longValue() < 0L) {
/*  537 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  538 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  539 */               status.setRollbackOnly();
/*  540 */               return result;
/*      */             }
/*      */           } catch (Exception e) {
/*  543 */             status.setRollbackOnly();
/*  544 */             e.printStackTrace();
/*  545 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  546 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  547 */             return result;
/*      */           }
/*  549 */           return result;
/*      */         }
/*      */       });
/*  552 */       return result;
/*      */     } catch (Exception e) {
/*  554 */       e.printStackTrace();
/*  555 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  556 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  557 */     }return result;
/*      */   }
/*      */ 
/*      */   private boolean validatorSettlePara(TransRequest request)
/*      */   {
/*  569 */     return (null != request) && (!StringUtil.isEmpty(request.getFundAccount())) && (!StringUtil.isEmpty(request.getOrderProperty())) && (!StringUtil.isEmpty(request.getOperator())) && (null != request.getFreezeDepositAmount()) && (null != request.getDeliveryAmount()) && (null != request.getFeeAmount()) && (!StringUtil.isEmpty(request.getBizNo()));
/*      */   }
/*      */ 
/*      */   public FundOperateResult prePayPayment(final TransRequest request)
/*      */   {
/*  589 */     final FundOperateResult result = new FundOperateResult();
/*  590 */     result.setFundAccount(request.getFundAccount());
/*  591 */     result.setBizNo(request.getBizNo());
/*  592 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  593 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */     try
/*      */     {
/*  597 */       if ((null == request) || (StringUtil.isEmpty(request.getFundAccount())) || (StringUtil.isEmpty(request.getOrderProperty())) || (StringUtil.isEmpty(request.getOperator())) || (null == request.getGoodsAmount()) || (StringUtil.isEmpty(request.getBizNo())))
/*      */       {
/*  599 */         result.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  600 */         result.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  601 */         return result;
/*      */       }
/*      */ 
/*  605 */       final Map parasMap = new HashMap();
/*  606 */       parasMap.put("taid", request.getFundAccount());
/*  607 */       CashTradeAccount ctAccount = this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*  608 */       if ((ctAccount == null) || (ctAccount.getFreeMoney() == null) || (ctAccount.getFreeMoney().longValue() < request.getGoodsAmount().longValue())) {
/*  609 */         String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getCode();
/*  610 */         String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getDescription();
/*  611 */         result.setErrorNO(errCode);
/*  612 */         result.setErrorInfo(errInfo);
/*  613 */         return result;
/*      */       }
/*      */ 
/*  617 */       this.transactionTemplate.execute(new TransactionCallback() {
/*      */         public FundOperateResult doInTransaction(TransactionStatus status) {
/*      */           try {
/*  620 */             parasMap.put("money", request.getGoodsAmount());
/*      */ 
/*  622 */             int outNum = CashTradeServiceImpl.this.cashTradeAccountDAO.outcomeCashAccount(parasMap);
/*      */ 
/*  624 */             parasMap.put("taid", CashTradeServiceImpl.this.sysFundsAccount);
/*  625 */             int inNum = CashTradeServiceImpl.this.cashTradeAccountDAO.incomeCashAccount(parasMap);
/*  626 */             if ((outNum != 1) || (inNum != 1)) {
/*  627 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  628 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  629 */               status.setRollbackOnly();
/*  630 */               return result;
/*      */             }
/*      */ 
/*  633 */             String subject = EnumFundsOperateType.OUT_PAYMENTS.getValue();
/*  634 */             CashTradeStatus cts = new CashTradeStatus();
/*  635 */             cts.setComments("支付货款，" + request.getGoodsAmount());
/*  636 */             cts.setSubject(subject);
/*  637 */             cts.setTaid(request.getFundAccount());
/*  638 */             cts.setTotalPay(request.getGoodsAmount());
/*  639 */             cts.setSourceId(request.getBizNo());
/*  640 */             Long numPay = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/*  641 */             if (numPay.longValue() < 0L) {
/*  642 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  643 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  644 */               status.setRollbackOnly();
/*  645 */               return result;
/*      */             }
/*  647 */             return result;
/*      */           } catch (Exception e) {
/*  649 */             status.setRollbackOnly();
/*  650 */             e.printStackTrace();
/*  651 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  652 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  653 */           }return result;
/*      */         }
/*      */       });
/*  657 */       return result;
/*      */     } catch (Exception e) {
/*  659 */       e.printStackTrace();
/*  660 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  661 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  662 */     }return result;
/*      */   }
/*      */ 
/*      */   public FundOperateResult payPayment(final TransRequest request)
/*      */   {
/*  687 */     final FundOperateResult result = new FundOperateResult();
/*  688 */     result.setFundAccount(request.getFundAccount());
/*  689 */     result.setBizNo(request.getBizNo());
/*  690 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  691 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */     try {
/*  693 */       if (!validatePayPara(request)) {
/*  694 */         result.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  695 */         result.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  696 */         return result;
/*      */       }
/*      */ 
/*  700 */       this.transactionTemplate.execute(new TransactionCallback()
/*      */       {
/*      */         public FundOperateResult doInTransaction(TransactionStatus status) {
/*      */           try {
/*  704 */             String ctsComments = "支付货款或解冻交收保证金。";
/*  705 */             Map parasMap = new HashMap();
/*      */ 
/*  708 */             if (request.getGoodsAmount().longValue() > 0L) {
/*  709 */               parasMap.put("taid", CashTradeServiceImpl.this.sysFundsAccount);
/*      */ 
/*  712 */               CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*  713 */               if ((ctAccount == null) || (ctAccount.getFreeMoney() == null) || (ctAccount.getFreeMoney().longValue() < request.getGoodsAmount().longValue())) {
/*  714 */                 String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getCode();
/*  715 */                 String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getDescription();
/*  716 */                 result.setErrorNO(errCode);
/*  717 */                 result.setErrorInfo(errInfo);
/*  718 */                 return result;
/*      */               }
/*  720 */               parasMap.put("money", request.getGoodsAmount());
/*  721 */               int outNum = CashTradeServiceImpl.this.cashTradeAccountDAO.outcomeCashAccount(parasMap);
/*  722 */               parasMap.put("taid", request.getFundAccount());
/*  723 */               int inNum = CashTradeServiceImpl.this.cashTradeAccountDAO.incomeCashAccount(parasMap);
/*  724 */               if ((outNum != 1) || (inNum != 1)) {
/*  725 */                 result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  726 */                 result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  727 */                 status.setRollbackOnly();
/*  728 */                 return result;
/*      */               }
/*  730 */               ctsComments = ctsComments + "支付货款，" + request.getGoodsAmount() + "分。";
/*      */             }
/*      */ 
/*  733 */             if (request.getDeliveryAmount().longValue() > 0L) {
/*  734 */               parasMap.put("taid", request.getFundAccount());
/*      */ 
/*  736 */               CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*  737 */               if ((ctAccount == null) || (ctAccount.getFrozenMoney() == null) || (ctAccount.getFrozenMoney().longValue() < request.getDeliveryAmount().longValue())) {
/*  738 */                 String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/*  739 */                 String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/*  740 */                 result.setErrorNO(errCode);
/*  741 */                 result.setErrorInfo(errInfo);
/*  742 */                 status.setRollbackOnly();
/*  743 */                 return result;
/*      */               }
/*  745 */               parasMap.put("money", request.getDeliveryAmount());
/*  746 */               int thawNum = CashTradeServiceImpl.this.cashTradeAccountDAO.thawCashAccount(parasMap);
/*  747 */               if (thawNum != 1) {
/*  748 */                 result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  749 */                 result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  750 */                 status.setRollbackOnly();
/*  751 */                 return result;
/*      */               }
/*  753 */               ctsComments = ctsComments + "解冻交收保证金，" + request.getDeliveryAmount() + "分。";
/*      */             }
/*      */ 
/*  757 */             String subject = EnumFundsOperateType.IN_PAYMENTS.getValue();
/*  758 */             CashTradeStatus cts = new CashTradeStatus();
/*  759 */             cts.setComments(ctsComments);
/*  760 */             cts.setSubject(subject);
/*  761 */             cts.setTaid(request.getFundAccount());
/*  762 */             cts.setTotalPay(request.getGoodsAmount());
/*  763 */             cts.setSourceId(request.getBizNo());
/*  764 */             Long numPay = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/*  765 */             if (numPay.longValue() < 0L) {
/*  766 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  767 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  768 */               status.setRollbackOnly();
/*  769 */               return result;
/*      */             }
/*  771 */             return result;
/*      */           } catch (Exception e) {
/*  773 */             status.setRollbackOnly();
/*  774 */             e.printStackTrace();
/*  775 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  776 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  777 */           }return result;
/*      */         }
/*      */       });
/*  781 */       return result;
/*      */     } catch (Exception e) {
/*  783 */       e.printStackTrace();
/*  784 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  785 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  786 */     }return result;
/*      */   }
/*      */ 
/*      */   private boolean validatePayPara(TransRequest request)
/*      */   {
/*  795 */     if ((null == request) || (StringUtil.isEmpty(request.getFundAccount())) || (null == request.getGoodsAmount()) || (StringUtil.isEmpty(request.getOrderProperty())) || (StringUtil.isEmpty(request.getOperator())) || (null == request.getDeliveryAmount()) || (StringUtil.isEmpty(request.getBizNo())))
/*      */     {
/*  798 */       return false;
/*      */     }
/*      */ 
/*  801 */     return (request.getGoodsAmount().longValue() != 0L) || (request.getDeliveryAmount().longValue() != 0L);
/*      */   }
/*      */ 
/*      */   public FundOperateResult tradeBroken(final TransRequest request)
/*      */   {
/*  823 */     final FundOperateResult result = new FundOperateResult();
/*  824 */     result.setBizNo(request.getBizNo());
/*  825 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  826 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */     try
/*      */     {
/*  829 */       if (!validateTradePara(request)) {
/*  830 */         result.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  831 */         result.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  832 */         return result;
/*      */       }
/*      */ 
/*  835 */       this.transactionTemplate.execute(new TransactionCallback() {
/*      */         public FundOperateResult doInTransaction(TransactionStatus status) {
/*      */           try {
/*  838 */             String ctsComments = "交易违约。";
/*  839 */             Map parasMap = new HashMap();
/*      */ 
/*  842 */             if (request.getFreezeDepositAmount().longValue() > 0L) {
/*  843 */               parasMap.put("taid", request.getPenaltyAccount());
/*      */ 
/*  845 */               CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*  846 */               if ((ctAccount == null) || (ctAccount.getFrozenMoney() == null) || (ctAccount.getFrozenMoney().longValue() < request.getFreezeDepositAmount().longValue())) {
/*  847 */                 String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/*  848 */                 String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/*  849 */                 result.setErrorNO(errCode);
/*  850 */                 result.setErrorInfo(errInfo);
/*  851 */                 status.setRollbackOnly();
/*  852 */                 return result;
/*      */               }
/*  854 */               parasMap.put("money", request.getFreezeDepositAmount());
/*  855 */               int thawNum = CashTradeServiceImpl.this.cashTradeAccountDAO.thawCashAccount(parasMap);
/*  856 */               if (thawNum != 1) {
/*  857 */                 result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  858 */                 result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  859 */                 status.setRollbackOnly();
/*  860 */                 return result;
/*      */               }
/*  862 */               ctsComments = ctsComments + "解冻" + request.getPenaltyAccount() + "交易保证金，" + request.getFreezeDepositAmount() + "分；";
/*      */             }
/*      */ 
/*  866 */             if (request.getPenaltyamount().longValue() > 0L) {
/*  867 */               parasMap.put("taid", request.getPenaltyAccount());
/*  868 */               CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*      */ 
/*  870 */               if ((null == ctAccount) || (null == ctAccount.getFreeMoney()) || (ctAccount.getFreeMoney().longValue() < request.getPenaltyamount().longValue())) {
/*  871 */                 String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getCode();
/*  872 */                 String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getDescription();
/*  873 */                 result.setErrorNO(errCode);
/*  874 */                 result.setErrorInfo(errInfo);
/*  875 */                 status.setRollbackOnly();
/*  876 */                 return result;
/*      */               }
/*  878 */               parasMap.put("money", request.getPenaltyamount());
/*  879 */               int outNum = CashTradeServiceImpl.this.cashTradeAccountDAO.outcomeCashAccount(parasMap);
/*  880 */               parasMap.put("taid", request.getFundAccount());
/*  881 */               int inNum = CashTradeServiceImpl.this.cashTradeAccountDAO.incomeCashAccount(parasMap);
/*  882 */               if ((outNum != 1) || (inNum != 1)) {
/*  883 */                 result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  884 */                 result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  885 */                 status.setRollbackOnly();
/*  886 */                 return result;
/*      */               }
/*  888 */               ctsComments = ctsComments + "违约方" + request.getPenaltyAccount() + "扣除违约金，" + request.getPenaltyamount() + "分；补偿履约方" + request.getFundAccount() + "；";
/*      */             }
/*      */ 
/*  892 */             if (request.getDeliveryAmount().longValue() > 0L)
/*      */             {
/*  894 */               parasMap.put("taid", request.getFundAccount());
/*  895 */               CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*  896 */               if ((null == ctAccount) || (ctAccount.getFrozenMoney() == null) || (ctAccount.getFrozenMoney().longValue() < request.getDeliveryAmount().longValue())) {
/*  897 */                 String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/*  898 */                 String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/*  899 */                 result.setErrorNO(errCode);
/*  900 */                 result.setErrorInfo(errInfo);
/*  901 */                 status.setRollbackOnly();
/*  902 */                 return result;
/*      */               }
/*  904 */               parasMap.put("money", request.getDeliveryAmount());
/*  905 */               int thawNum = CashTradeServiceImpl.this.cashTradeAccountDAO.thawCashAccount(parasMap);
/*  906 */               if (thawNum != 1) {
/*  907 */                 result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  908 */                 result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  909 */                 status.setRollbackOnly();
/*  910 */                 return result;
/*      */               }
/*  912 */               ctsComments = ctsComments + "解冻履约方交收保证金，" + request.getDeliveryAmount() + "分；";
/*      */             }
/*      */ 
/*  916 */             String subject = EnumFundsOperateType.JY_LIQUIDATED.getValue();
/*  917 */             CashTradeStatus cts = new CashTradeStatus();
/*  918 */             cts.setComments(ctsComments);
/*  919 */             cts.setSubject(subject);
/*  920 */             cts.setTaid(request.getFundAccount());
/*  921 */             cts.setTotalPay(request.getPenaltyamount());
/*  922 */             cts.setSourceId(request.getBizNo());
/*  923 */             Long numPay = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/*  924 */             if (numPay.longValue() < 0L) {
/*  925 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  926 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  927 */               status.setRollbackOnly();
/*  928 */               return result;
/*      */             }
/*  930 */             return result;
/*      */           } catch (Exception e) {
/*  932 */             status.setRollbackOnly();
/*  933 */             e.printStackTrace();
/*  934 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  935 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  936 */           }return result;
/*      */         }
/*      */       });
/*  940 */       return result;
/*      */     } catch (Exception e) {
/*  942 */       e.printStackTrace();
/*  943 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/*  944 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/*  945 */     }return result;
/*      */   }
/*      */ 
/*      */   private boolean validateTradePara(TransRequest request)
/*      */   {
/*  953 */     if ((null == request) || (StringUtil.isEmpty(request.getPenaltyAccount())) || (StringUtil.isEmpty(request.getFundAccount())) || (StringUtil.isEmpty(request.getOrderProperty())) || (StringUtil.isEmpty(request.getOperator())) || (null == request.getFreezeDepositAmount()) || (null == request.getDeliveryAmount()) || (null == request.getPenaltyamount()) || (StringUtil.isEmpty(request.getBizNo())))
/*      */     {
/*  957 */       return false;
/*      */     }
/*      */ 
/*  960 */     return (request.getFreezeDepositAmount().longValue() != 0L) || (request.getDeliveryAmount().longValue() != 0L) || (request.getPenaltyamount().longValue() != 0L);
/*      */   }
/*      */ 
/*      */   public FundOperateResult deliveryBroken(final TransRequest request)
/*      */   {
/*  983 */     final FundOperateResult result = new FundOperateResult();
/*  984 */     result.setBizNo(request.getBizNo());
/*  985 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  986 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */     try
/*      */     {
/*  989 */       if (!validateDeliveryPara(request)) {
/*  990 */         result.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  991 */         result.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  992 */         return result;
/*      */       }
/*      */ 
/*  996 */       this.transactionTemplate.execute(new TransactionCallback() {
/*      */         public FundOperateResult doInTransaction(TransactionStatus status) {
/*      */           try {
/*  999 */             String ctsComments = "交收违约。";
/* 1000 */             Map parasMap = new HashMap();
/*      */ 
/* 1003 */             if (request.getPenaltydeliveryAmount().longValue() > 0L) {
/* 1004 */               parasMap.put("taid", request.getPenaltyAccount());
/*      */ 
/* 1006 */               CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/* 1007 */               if ((null == ctAccount) || (ctAccount.getFrozenMoney() == null) || (ctAccount.getFrozenMoney().longValue() < request.getPenaltydeliveryAmount().longValue())) {
/* 1008 */                 String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/* 1009 */                 String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/* 1010 */                 result.setErrorNO(errCode);
/* 1011 */                 result.setErrorInfo(errInfo);
/* 1012 */                 status.setRollbackOnly();
/* 1013 */                 return result;
/*      */               }
/* 1015 */               parasMap.put("money", request.getPenaltydeliveryAmount());
/* 1016 */               int thawNum = CashTradeServiceImpl.this.cashTradeAccountDAO.thawCashAccount(parasMap);
/* 1017 */               if (thawNum != 1) {
/* 1018 */                 result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1019 */                 result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1020 */                 status.setRollbackOnly();
/* 1021 */                 return result;
/*      */               }
/* 1023 */               ctsComments = ctsComments + "解冻违约方交收保证金，" + request.getDeliveryAmount() + "分；";
/*      */             }
/*      */ 
/* 1027 */             if (request.getPenaltyamount().longValue() > 0L) {
/* 1028 */               parasMap.put("taid", request.getPenaltyAccount());
/* 1029 */               CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*      */ 
/* 1031 */               if ((null == ctAccount) || (null == ctAccount.getFreeMoney()) || (ctAccount.getFreeMoney().longValue() < request.getPenaltyamount().longValue())) {
/* 1032 */                 String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getCode();
/* 1033 */                 String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getDescription();
/* 1034 */                 result.setErrorNO(errCode);
/* 1035 */                 result.setErrorInfo(errInfo);
/* 1036 */                 status.setRollbackOnly();
/* 1037 */                 return result;
/*      */               }
/* 1039 */               parasMap.put("money", request.getPenaltyamount());
/* 1040 */               int outNum = CashTradeServiceImpl.this.cashTradeAccountDAO.outcomeCashAccount(parasMap);
/* 1041 */               parasMap.put("taid", request.getFundAccount());
/* 1042 */               int inNum = CashTradeServiceImpl.this.cashTradeAccountDAO.incomeCashAccount(parasMap);
/* 1043 */               if ((outNum != 1) || (inNum != 1)) {
/* 1044 */                 result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1045 */                 result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1046 */                 status.setRollbackOnly();
/* 1047 */                 return result;
/*      */               }
/* 1049 */               ctsComments = ctsComments + "违约方" + request.getPenaltyAccount() + "扣除违约金，" + request.getPenaltyamount() + "分；补偿履约方" + request.getFundAccount() + "；";
/*      */             }
/*      */ 
/* 1053 */             if (request.getDeliveryAmount().longValue() > 0L) {
/* 1054 */               parasMap.put("taid", request.getFundAccount());
/*      */ 
/* 1056 */               CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/* 1057 */               if ((null == ctAccount) || (ctAccount.getFrozenMoney() == null) || (ctAccount.getFrozenMoney().longValue() < request.getDeliveryAmount().longValue())) {
/* 1058 */                 String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/* 1059 */                 String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/* 1060 */                 result.setErrorNO(errCode);
/* 1061 */                 result.setErrorInfo(errInfo);
/* 1062 */                 status.setRollbackOnly();
/* 1063 */                 return result;
/*      */               }
/* 1065 */               parasMap.put("money", request.getDeliveryAmount());
/* 1066 */               int thawNum = CashTradeServiceImpl.this.cashTradeAccountDAO.thawCashAccount(parasMap);
/* 1067 */               if (thawNum != 1) {
/* 1068 */                 result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1069 */                 result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1070 */                 status.setRollbackOnly();
/* 1071 */                 return result;
/*      */               }
/* 1073 */               ctsComments = ctsComments + "解冻履约方交收保证金，" + request.getDeliveryAmount() + "分；";
/*      */             }
/*      */ 
/* 1077 */             if (request.getGoodsAmount().longValue() > 0L) {
/* 1078 */               parasMap.put("taid", CashTradeServiceImpl.this.sysFundsAccount);
/* 1079 */               CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*      */ 
/* 1081 */               if ((null == ctAccount) || (null == ctAccount.getFreeMoney()) || (ctAccount.getFreeMoney().longValue() < request.getGoodsAmount().longValue())) {
/* 1082 */                 String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getCode();
/* 1083 */                 String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.ACCOUNT_BALANCE_NOT_ENOUGH.getDescription();
/* 1084 */                 result.setErrorNO(errCode);
/* 1085 */                 result.setErrorInfo(errInfo);
/* 1086 */                 status.setRollbackOnly();
/* 1087 */                 return result;
/*      */               }
/* 1089 */               parasMap.put("money", request.getGoodsAmount());
/* 1090 */               int outNum = CashTradeServiceImpl.this.cashTradeAccountDAO.outcomeCashAccount(parasMap);
/* 1091 */               parasMap.put("taid", request.getFundAccount());
/* 1092 */               int inNum = CashTradeServiceImpl.this.cashTradeAccountDAO.incomeCashAccount(parasMap);
/* 1093 */               if ((outNum != 1) || (inNum != 1)) {
/* 1094 */                 result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1095 */                 result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1096 */                 status.setRollbackOnly();
/* 1097 */                 return result;
/*      */               }
/* 1099 */               ctsComments = ctsComments + "退还" + request.getFundAccount() + "货款，" + request.getGoodsAmount() + "；";
/*      */             }
/*      */ 
/* 1103 */             String subject = EnumFundsOperateType.JS_LIQUIDATED.getValue();
/* 1104 */             CashTradeStatus cts = new CashTradeStatus();
/* 1105 */             cts.setComments(ctsComments);
/* 1106 */             cts.setSubject(subject);
/* 1107 */             cts.setTaid(request.getFundAccount());
/* 1108 */             cts.setTotalPay(request.getPenaltyamount());
/* 1109 */             cts.setSourceId(request.getBizNo());
/* 1110 */             Long numPay = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/* 1111 */             if (numPay.longValue() < 0L) {
/* 1112 */               result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1113 */               result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1114 */               status.setRollbackOnly();
/* 1115 */               return result;
/*      */             }
/*      */ 
/* 1118 */             return result;
/*      */           } catch (Exception e) {
/* 1120 */             status.setRollbackOnly();
/* 1121 */             e.printStackTrace();
/* 1122 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1123 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1124 */           }return result;
/*      */         }
/*      */       });
/* 1128 */       return result;
/*      */     } catch (Exception e) {
/* 1130 */       e.printStackTrace();
/* 1131 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1132 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1133 */     }return result;
/*      */   }
/*      */ 
/*      */   private boolean validateDeliveryPara(TransRequest request)
/*      */   {
/* 1141 */     if ((null == request) || (StringUtil.isEmpty(request.getPenaltyAccount())) || (StringUtil.isEmpty(request.getFundAccount())) || (StringUtil.isEmpty(request.getOrderProperty())) || (StringUtil.isEmpty(request.getOperator())) || (null == request.getPenaltydeliveryAmount()) || (null == request.getDeliveryAmount()) || (null == request.getPenaltyamount()) || (StringUtil.isEmpty(request.getBizNo())) || (null == request.getGoodsAmount()) || (request.getGoodsAmount().longValue() < 0L))
/*      */     {
/* 1145 */       return false;
/*      */     }
/*      */ 
/* 1148 */     return (request.getPenaltydeliveryAmount().longValue() != 0L) || (request.getDeliveryAmount().longValue() != 0L) || (request.getPenaltyamount().longValue() != 0L);
/*      */   }
/*      */ 
/*      */   public FundOperateResult cancelFundByTrade(TransRequest request)
/*      */   {
/* 1168 */     FundOperateResult result = new FundOperateResult();
/* 1169 */     result.setBizNo(request.getBizNo());
/* 1170 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/* 1171 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */     try
/*      */     {
/* 1174 */       cancelFundByTradeInner(request, result);
/*      */ 
/* 1176 */       return result;
/*      */     } catch (Exception e) {
/* 1178 */       e.printStackTrace();
/* 1179 */       result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1180 */       result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1181 */     }return result;
/*      */   }
/*      */ 
/*      */   private boolean cancelFundByTradeInner(final TransRequest request, final FundOperateResult result)
/*      */   {
/* 1187 */     if ((null == request) || (StringUtil.isEmpty(request.getFundAccount())) || (null == request.getAmount()) || (request.getAmount().longValue() < 0L) || (StringUtil.isEmpty(request.getOrderProperty())) || (StringUtil.isEmpty(request.getBizNo())) || (StringUtil.isEmpty(request.getOperator())))
/*      */     {
/* 1189 */       result.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/* 1190 */       result.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/* 1191 */       return false;
/*      */     }
/*      */ 
/* 1194 */     boolean flag = true;
/* 1195 */     flag = ((Boolean)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public Boolean doInTransaction(TransactionStatus status) {
/*      */         try {
/* 1198 */           Map parasMap = new HashMap();
/* 1199 */           parasMap.put("taid", request.getFundAccount());
/* 1200 */           parasMap.put("money", request.getAmount());
/* 1201 */           CashTradeAccount ctAccount = CashTradeServiceImpl.this.cashTradeAccountDAO.selectCashTradeAccountByTaid(parasMap);
/*      */ 
/* 1203 */           if ((null == ctAccount) || (null == ctAccount.getFrozenMoney()) || (ctAccount.getFrozenMoney().longValue() < request.getAmount().longValue())) {
/* 1204 */             String errCode = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getCode();
/* 1205 */             String errInfo = ctAccount == null ? EnumFundResultCode.ACCOUNT_NOT_EXIST.getDescription() : EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH.getDescription();
/* 1206 */             result.setErrorNO(errCode);
/* 1207 */             result.setErrorInfo(errInfo);
/* 1208 */             status.setRollbackOnly();
/* 1209 */             return Boolean.valueOf(false);
/*      */           }
/*      */ 
/* 1212 */           int thawNum = CashTradeServiceImpl.this.cashTradeAccountDAO.thawCashAccount(parasMap);
/* 1213 */           if (thawNum != 1) {
/* 1214 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1215 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1216 */             status.setRollbackOnly();
/* 1217 */             return Boolean.valueOf(false);
/*      */           }
/*      */ 
/* 1220 */           String subject = EnumFundsOperateType.IN_JY.getValue();
/* 1221 */           CashTradeStatus cts = new CashTradeStatus();
/* 1222 */           cts.setComments("解冻交易保证金，金额：" + request.getAmount() + "分");
/* 1223 */           cts.setSubject(subject);
/* 1224 */           cts.setTaid(request.getFundAccount());
/* 1225 */           cts.setTotalPay(request.getAmount());
/* 1226 */           cts.setSourceId(request.getBizNo());
/* 1227 */           Long numCS = CashTradeServiceImpl.this.cashTradeStatusDAO.insertCashStatus(cts);
/* 1228 */           if (numCS.longValue() < 0L) {
/* 1229 */             result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1230 */             result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1231 */             status.setRollbackOnly();
/* 1232 */             return Boolean.valueOf(false);
/*      */           }
/* 1234 */           return Boolean.valueOf(true);
/*      */         } catch (Exception e) {
/* 1236 */           status.setRollbackOnly();
/* 1237 */           e.printStackTrace();
/* 1238 */           result.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1239 */           result.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1240 */         }return Boolean.valueOf(false);
/*      */       }
/*      */     })).booleanValue();
/*      */ 
/* 1244 */     return flag;
/*      */   }
/*      */ 
/*      */   public FundBatchResult cancelFundBatchByTrade(List<TransRequest> requestList)
/*      */   {
/* 1258 */     FundBatchResult resultList = new FundBatchResult();
/* 1259 */     resultList.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/* 1260 */     resultList.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */ 
/* 1263 */     if ((null == requestList) || (requestList.size() == 0)) {
/* 1264 */       resultList.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/* 1265 */       resultList.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/* 1266 */       return resultList;
/*      */     }
/*      */ 
/* 1269 */     List fundResultList = new ArrayList();
/*      */     try {
/* 1271 */       FundOperateResult result = new FundOperateResult();
/* 1272 */       Iterator it = requestList.iterator();
/* 1273 */       int allNum = requestList.size();
/* 1274 */       int succNum = 0;
/* 1275 */       int errNum = 0;
/* 1276 */       while (it.hasNext()) {
/* 1277 */         result = new FundOperateResult();
/* 1278 */         result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/* 1279 */         result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*      */ 
/* 1281 */         TransRequest request = (TransRequest)it.next();
/* 1282 */         boolean oneFlag = cancelFundByTradeInner(request, result);
/* 1283 */         if (oneFlag == true)
/* 1284 */           succNum += 1;
/*      */         else {
/* 1286 */           errNum += 1;
/*      */         }
/* 1288 */         fundResultList.add(result);
/* 1289 */         resultList.setFundResultList(fundResultList);
/*      */       }
/*      */ 
/* 1292 */       if (succNum == allNum) {
/* 1293 */         resultList.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/* 1294 */         resultList.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/* 1295 */       } else if (errNum == allNum) {
/* 1296 */         resultList.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/* 1297 */         resultList.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*      */       } else {
/* 1299 */         resultList.setErrorNO(EnumFundResultCode.PART_SUCCESS.getCode());
/* 1300 */         resultList.setErrorInfo(EnumFundResultCode.PART_SUCCESS.getDescription());
/*      */       }
/* 1302 */       return resultList;
/*      */     } catch (Exception e) {
/* 1304 */       e.printStackTrace();
/* 1305 */       resultList.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 1306 */       resultList.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 1307 */     }return resultList;
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.fund.CashTradeServiceImpl
 * JD-Core Version:    0.6.0
 */