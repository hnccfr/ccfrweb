/*      */ package com.hundsun.network.gates.houchao.biz.manager.pojo;
/*      */ 
/*      */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.AccountTransReq;
/*      */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.Cache;
/*      */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.TradeTransReq;
/*      */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.TransReq;
/*      */ import com.hundsun.network.gates.houchao.biz.enums.EnumMiddleFundAccount;
/*      */ import com.hundsun.network.gates.houchao.biz.manager.AccountCoreManager;
/*      */ import com.hundsun.network.gates.houchao.biz.manager.FundTransFactory;
/*      */ import com.hundsun.network.gates.houchao.biz.services.FundCoreTrans;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMoneyType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTransCode;
/*      */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumGoodsAmountType;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumPenaltyType;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.request.AccountRequest;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundBatchResult;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*      */ import com.hundsun.network.melody.common.util.StringUtil;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.apache.commons.logging.LogFactory;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.stereotype.Service;
/*      */ import org.springframework.transaction.TransactionStatus;
/*      */ import org.springframework.transaction.support.TransactionCallback;
/*      */ import org.springframework.transaction.support.TransactionTemplate;
/*      */ 
/*      */ @Service("accountCoreManager")
/*      */ public class AccountCoreManagerImpl
/*      */   implements AccountCoreManager
/*      */ {
/*   51 */   private Log log = LogFactory.getLog(AccountCoreManagerImpl.class);
/*      */ 
/*      */   @Autowired
/*      */   private TransactionTemplate transactionTemplate;
/*      */ 
/*      */   @Autowired
/*      */   private FundTransFactory fundTransFactory;
/*      */ 
/*      */   private FundOperateResult execute(TransReq transReq)
/*      */   {
/*   70 */     FundOperateResult fundResult = new FundOperateResult();
/*   71 */     if (transReq == null) {
/*   72 */       fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*   73 */       fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*   74 */       return fundResult;
/*      */     }
/*      */ 
/*   78 */     FundCoreTrans fundCoreTrans = this.fundTransFactory.getFundCoreTrans(transReq.getTransCode().getCode());
/*      */ 
/*   81 */     if (fundCoreTrans == null) {
/*   82 */       fundResult.setErrorNO(EnumFundResultCode.OPERATE_NOT_SUPPORT.getCode());
/*   83 */       fundResult.setErrorInfo(EnumFundResultCode.OPERATE_NOT_SUPPORT.getDescription());
/*   84 */       return fundResult;
/*      */     }
/*      */ 
/*   88 */     EnumFundResultCode fundResultCode = fundCoreTrans.execute(transReq);
/*   89 */     fundResult.setErrorNO(fundResultCode.getCode());
/*   90 */     fundResult.setErrorInfo(fundResultCode.getDescription());
/*      */ 
/*   92 */     return fundResult;
/*      */   }
/*      */ 
/*      */   public FundOperateResult createFundAccount(final AccountRequest request)
/*      */   {
/*  102 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/*  104 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/*  106 */           if (request == null) {
/*  107 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  108 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  109 */             AccountCoreManagerImpl.this.log.error("openedAccount request params is null!");
/*  110 */             return fundResult;
/*      */           }
/*      */ 
/*  114 */           if (StringUtil.isBlank(request.getOperator())) {
/*  115 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  116 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*      */ 
/*  118 */             AccountCoreManagerImpl.this.log.error("openedAccount Operator params is null, Operator=" + request.getOperator());
/*      */ 
/*  120 */             return fundResult;
/*      */           }
/*      */ 
/*  124 */           if (StringUtil.isBlank(request.getMoneyType())) {
/*  125 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*  127 */           if (StringUtil.isBlank(request.getBankAccountType())) {
/*  128 */             request.setBankAccountType("10");
/*      */           }
/*  130 */           if (StringUtil.isBlank(request.getBankBranch())) {
/*  131 */             request.setBankBranch("000001");
/*      */           }
/*      */ 
/*  137 */           AccountTransReq transReq = new AccountTransReq();
/*  138 */           transReq.setFundAccount(request.getFundAccount());
/*  139 */           transReq.setClientId(request.getClientId());
/*  140 */           transReq.setPositionId(request.getPositionId());
/*  141 */           transReq.setBankNo(request.getBankNo());
/*  142 */           transReq.setBankBranch(request.getBankBranch());
/*  143 */           transReq.setBranchNo(request.getBranchNo());
/*  144 */           transReq.setBankAccountType(request.getBankAccountType());
/*  145 */           transReq.setBankAccount(request.getBankAccount());
/*  146 */           transReq.setMoneyType(request.getMoneyType());
/*  147 */           transReq.setCustomerName(request.getHolderName());
/*  148 */           transReq.setIdKind(request.getIdKind());
/*  149 */           transReq.setIdNo(request.getIdNo());
/*  150 */           transReq.setCountry(request.getCountry());
/*  151 */           transReq.setMemo(request.getMemo());
/*  152 */           transReq.setOperator(request.getOperator());
/*  153 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/*  156 */           transReq.setTransCode(EnumTransCode.TXCODE_ACCOUNT_OPEN);
/*  157 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  158 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  159 */           if (fundResult.isError()) {
/*  160 */             status.setRollbackOnly();
/*  161 */             AccountCoreManagerImpl.this.log.error("openedAccountTrans is error! fundResult" + fundResult);
/*  162 */             return fundResult;
/*      */           }
/*      */ 
/*  165 */           return fundResult;
/*      */         } catch (Exception e) {
/*  167 */           status.setRollbackOnly();
/*  168 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  169 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*  170 */           AccountCoreManagerImpl.this.log.error("openedAccount execute error:" + request, e);
/*  171 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult cancelFundAccount(final AccountRequest request)
/*      */   {
/*  186 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/*  188 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/*  190 */           if (request == null) {
/*  191 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  192 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*      */ 
/*  194 */             AccountCoreManagerImpl.this.log.error("cancelFundAccount request params is null!");
/*  195 */             return fundResult;
/*      */           }
/*      */ 
/*  199 */           if (StringUtil.isBlank(request.getOperator())) {
/*  200 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  201 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*      */ 
/*  203 */             AccountCoreManagerImpl.this.log.error("cancelFundAccount Operator params is null, Operator=" + request.getOperator());
/*      */ 
/*  205 */             return fundResult;
/*      */           }
/*      */ 
/*  209 */           if (StringUtil.isBlank(request.getMoneyType())) {
/*  210 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/*  216 */           AccountTransReq transReq = new AccountTransReq();
/*  217 */           transReq.setFundAccount(request.getFundAccount());
/*  218 */           transReq.setMoneyType(request.getMoneyType());
/*  219 */           transReq.setMemo(request.getMemo());
/*  220 */           transReq.setOperator(request.getOperator());
/*  221 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/*  224 */           transReq.setTransCode(EnumTransCode.TXCODE_ACCOUNT_CLOSE);
/*  225 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  226 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  227 */           if (fundResult.isError()) {
/*  228 */             status.setRollbackOnly();
/*  229 */             AccountCoreManagerImpl.this.log.error("cancelFundAccount is error! fundResult" + fundResult);
/*  230 */             return fundResult;
/*      */           }
/*      */ 
/*  233 */           return fundResult;
/*      */         } catch (Exception e) {
/*  235 */           status.setRollbackOnly();
/*  236 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  237 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*  238 */           AccountCoreManagerImpl.this.log.error("cancelFundAccount execute error:" + request, e);
/*  239 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult fundInAccount(final TransRequest request)
/*      */   {
/*  255 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/*  257 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/*  259 */           if (request == null) {
/*  260 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  261 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  262 */             AccountCoreManagerImpl.this.log.error("fundInAccount request params is null!");
/*  263 */             return fundResult;
/*      */           }
/*      */ 
/*  267 */           if (StringUtil.isBlank(request.getOperator())) {
/*  268 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  269 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  270 */             AccountCoreManagerImpl.this.log.error("fundInAccount Operator params is null, Operator=" + request.getOperator());
/*  271 */             return fundResult;
/*      */           }
/*      */ 
/*  275 */           if (StringUtil.isBlank(request.getMoneyType())) {
/*  276 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/*  280 */           if ((null == request.getFundAccount()) || (null == request.getAmount()) || (request.getAmount().longValue() < 0L) || (StringUtil.isBlank(request.getBizNo())))
/*      */           {
/*  282 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  283 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  284 */             AccountCoreManagerImpl.this.log.error("fundInAccount params is error,BizNo=" + request.getBizNo() + "FundAccount=" + request.getFundAccount() + ", Amount=" + request.getAmount());
/*      */ 
/*  287 */             return fundResult;
/*      */           }
/*      */ 
/*  291 */           TradeTransReq transReq = new TradeTransReq();
/*  292 */           transReq.setFundAccount(request.getFundAccount());
/*  293 */           transReq.setAmount(request.getAmount());
/*  294 */           transReq.setBizNo(request.getBizNo());
/*  295 */           transReq.setOperator(request.getOperator());
/*  296 */           transReq.setMemo(request.getMemo());
/*  297 */           transReq.setMoneyType(request.getMoneyType());
/*  298 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/*  301 */           transReq.setTransCode(EnumTransCode.TXCODE_FUND_IN);
/*  302 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  303 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  304 */           fundResult.setBizNo(transReq.getBizNo());
/*  305 */           if (fundResult.isError()) {
/*  306 */             status.setRollbackOnly();
/*  307 */             AccountCoreManagerImpl.this.log.error("fundInAccount is error! fundResult" + fundResult);
/*  308 */             return fundResult;
/*      */           }
/*      */ 
/*  311 */           return fundResult;
/*      */         } catch (Exception e) {
/*  313 */           status.setRollbackOnly();
/*  314 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  315 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*  316 */           AccountCoreManagerImpl.this.log.error("fundInAccount execute error:" + request, e);
/*  317 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult fundOutAccount(final TransRequest request)
/*      */   {
/*  331 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/*  333 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/*  335 */           if (request == null) {
/*  336 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  337 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  338 */             AccountCoreManagerImpl.this.log.error("fundOutAccount request params is null!");
/*  339 */             return fundResult;
/*      */           }
/*      */ 
/*  343 */           if (StringUtil.isBlank(request.getOperator())) {
/*  344 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  345 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  346 */             AccountCoreManagerImpl.this.log.error("fundOutAccount Operator params is null, Operator=" + request.getOperator());
/*  347 */             return fundResult;
/*      */           }
/*      */ 
/*  351 */           if (StringUtil.isBlank(request.getMoneyType())) {
/*  352 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/*  356 */           if ((null == request.getFundAccount()) || (null == request.getAmount()) || (request.getAmount().longValue() < 0L) || (StringUtil.isBlank(request.getBizNo())))
/*      */           {
/*  358 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  359 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  360 */             AccountCoreManagerImpl.this.log.error("fundOutAccount params is error,BizNo=" + request.getBizNo() + "FundAccount=" + request.getFundAccount() + ", Amount=" + request.getAmount());
/*      */ 
/*  363 */             return fundResult;
/*      */           }
/*      */ 
/*  367 */           TradeTransReq transReq = new TradeTransReq();
/*  368 */           transReq.setFundAccount(request.getFundAccount());
/*  369 */           transReq.setAmount(request.getAmount());
/*  370 */           transReq.setBizNo(request.getBizNo());
/*  371 */           transReq.setOperator(request.getOperator());
/*  372 */           transReq.setMemo(request.getMemo());
/*  373 */           transReq.setMoneyType(request.getMoneyType());
/*  374 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/*  377 */           transReq.setTransCode(EnumTransCode.TXCODE_FUND_OUT);
/*  378 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  379 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  380 */           fundResult.setBizNo(transReq.getBizNo());
/*  381 */           if (fundResult.isError()) {
/*  382 */             status.setRollbackOnly();
/*  383 */             AccountCoreManagerImpl.this.log.error("fundOutAccount is error! fundResult" + fundResult);
/*  384 */             return fundResult;
/*      */           }
/*      */ 
/*  387 */           return fundResult;
/*      */         } catch (Exception e) {
/*  389 */           status.setRollbackOnly();
/*  390 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  391 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*  392 */           AccountCoreManagerImpl.this.log.error("fundOutAccount execute error:" + request, e);
/*  393 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult freezeFundByTrade(final TransRequest request)
/*      */   {
/*  407 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/*  409 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/*  411 */           if (request == null) {
/*  412 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  413 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  414 */             AccountCoreManagerImpl.this.log.error("freezeFundByTrade request params is null!");
/*  415 */             return fundResult;
/*      */           }
/*      */ 
/*  419 */           if (StringUtil.isBlank(request.getOperator())) {
/*  420 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  421 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  422 */             AccountCoreManagerImpl.this.log.error("freezeFundByTrade Operator params is null, Operator=" + request.getOperator());
/*  423 */             return fundResult;
/*      */           }
/*      */ 
/*  427 */           if (StringUtil.isBlank(request.getMoneyType())) {
/*  428 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/*  432 */           if ((null == request.getFundAccount()) || (null == request.getOrderProperty()) || (null == request.getFreezeDepositAmount()) || (StringUtil.isBlank(request.getBizNo())))
/*      */           {
/*  435 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  436 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  437 */             AccountCoreManagerImpl.this.log.error("freezeFundByTrade  params is error, FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ", OrderProperty=" + request.getOrderProperty() + ",FreezeDepositAmount=" + request.getFreezeDepositAmount());
/*      */ 
/*  441 */             return fundResult;
/*      */           }
/*      */ 
/*  444 */           if (request.getFreezeDepositAmount().longValue() < 0L) {
/*  445 */             fundResult.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  446 */             fundResult.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  447 */             AccountCoreManagerImpl.this.log.error("freezeFundByTrade  params is error,FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ",FreezeDepositAmount=" + request.getFreezeDepositAmount());
/*      */ 
/*  450 */             return fundResult;
/*      */           }
/*      */ 
/*  454 */           TradeTransReq transReq = new TradeTransReq();
/*  455 */           transReq.setFundAccount(request.getFundAccount());
/*  456 */           transReq.setAmount(request.getFreezeDepositAmount());
/*  457 */           transReq.setMoneyType(request.getMoneyType());
/*  458 */           transReq.setBizNo(request.getBizNo());
/*  459 */           transReq.setOperator(request.getOperator());
/*  460 */           transReq.setMemo(request.getMemo());
/*  461 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/*  464 */           transReq.setTransCode(EnumTransCode.TXCODE_TRANS_FREEZE_DEPOSIT);
/*  465 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  466 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  467 */           fundResult.setBizNo(transReq.getBizNo());
/*  468 */           if (fundResult.isError()) {
/*  469 */             status.setRollbackOnly();
/*  470 */             AccountCoreManagerImpl.this.log.error("freezeFundByTrade is error! fundResult" + fundResult);
/*  471 */             return fundResult;
/*      */           }
/*      */ 
/*  474 */           return fundResult;
/*      */         } catch (Exception e) {
/*  476 */           status.setRollbackOnly();
/*  477 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  478 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*  479 */           AccountCoreManagerImpl.this.log.error("freezeFundByTrade execute error:" + request, e);
/*  480 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult fillFundByTrade(final TransRequest request)
/*      */   {
/*  495 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/*  497 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/*  499 */           if (request == null) {
/*  500 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  501 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  502 */             AccountCoreManagerImpl.this.log.error("fillFundByTrade request params is null!");
/*  503 */             return fundResult;
/*      */           }
/*      */ 
/*  507 */           if (StringUtil.isBlank(request.getOperator())) {
/*  508 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  509 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  510 */             AccountCoreManagerImpl.this.log.error("fillFundByTrade Operator params is null, Operator=" + request.getOperator());
/*  511 */             return fundResult;
/*      */           }
/*      */ 
/*  515 */           if (StringUtil.isBlank(request.getMoneyType())) {
/*  516 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*  518 */           request.setTransDate(AccountCoreManagerImpl.this.getTransDate());
/*      */ 
/*  522 */           if ((null == request.getFundAccount()) || (null == request.getFreezeDepositAmount()) || (null == request.getDeliveryAmount()) || (null == request.getFeeAmount()) || (StringUtil.isBlank(request.getBizNo())))
/*      */           {
/*  526 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  527 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  528 */             AccountCoreManagerImpl.this.log.error("fillFundByTrade  params is error,FundAccount=" + request.getFundAccount() + ",FreezeDepositAmount=" + request.getFreezeDepositAmount() + ",DeliveryAmount=" + request.getDeliveryAmount() + ", FeeAmount=" + request.getFeeAmount());
/*      */ 
/*  533 */             return fundResult;
/*      */           }
/*  535 */           if ((request.getFreezeDepositAmount().longValue() < 0L) || (request.getDeliveryAmount().longValue() < 0L) || (request.getFeeAmount().longValue() < 0L))
/*      */           {
/*  537 */             fundResult.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  538 */             fundResult.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  539 */             AccountCoreManagerImpl.this.log.error("fillFundByTrade  params is error,FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ",FreezeDepositAmount=" + request.getFreezeDepositAmount() + ",DeliveryAmount=" + request.getDeliveryAmount() + ", FeeAmount=" + request.getFeeAmount());
/*      */ 
/*  544 */             return fundResult;
/*      */           }
/*      */ 
/*  549 */           TradeTransReq transReq = new TradeTransReq();
/*  550 */           transReq.setFundAccount(request.getFundAccount());
/*  551 */           transReq.setMoneyType(request.getMoneyType());
/*  552 */           transReq.setBizNo(request.getBizNo());
/*  553 */           transReq.setOperator(request.getOperator());
/*  554 */           transReq.setMemo(request.getMemo());
/*  555 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/*  558 */           transReq.setAmount(request.getFreezeDepositAmount());
/*  559 */           transReq.setTransCode(EnumTransCode.TXCODE_TRANS_UNFREEZE_DEPOSIT);
/*  560 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  561 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  562 */           fundResult.setBizNo(transReq.getBizNo());
/*  563 */           if (fundResult.isError()) {
/*  564 */             status.setRollbackOnly();
/*  565 */             AccountCoreManagerImpl.this.log.error("fillFundByTrade is error! fundResult" + fundResult);
/*  566 */             return fundResult;
/*      */           }
/*      */ 
/*  570 */           transReq.setAmount(request.getDeliveryAmount());
/*  571 */           transReq.setTransCode(EnumTransCode.TXCODE_DELIVERY_FREEZE_DEPOSIT);
/*  572 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  573 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  574 */           fundResult.setBizNo(transReq.getBizNo());
/*  575 */           if (fundResult.isError()) {
/*  576 */             status.setRollbackOnly();
/*  577 */             AccountCoreManagerImpl.this.log.error("fillFundByTrade is error! fundResult" + fundResult);
/*  578 */             return fundResult;
/*      */           }
/*      */ 
/*  582 */           if (request.getFeeAmount().longValue() > 0L)
/*      */           {
/*  584 */             transReq.setAmount(request.getFeeAmount());
/*  585 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_COMMISSION_FUND_OUT);
/*  586 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  587 */             fundResult.setFundAccount(transReq.getFundAccount());
/*  588 */             fundResult.setBizNo(transReq.getBizNo());
/*  589 */             if (fundResult.isError()) {
/*  590 */               status.setRollbackOnly();
/*  591 */               AccountCoreManagerImpl.this.log.error("fillFundByTrade is error! fundResult" + fundResult);
/*  592 */               return fundResult;
/*      */             }
/*      */ 
/*  596 */             transReq.setFundAccount(EnumMiddleFundAccount.MIDDLE_FEE_FUND_ACCOUNT.getCode());
/*  597 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_COMMISSION_FUND_IN);
/*  598 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  599 */             fundResult.setFundAccount(transReq.getFundAccount());
/*  600 */             fundResult.setBizNo(transReq.getBizNo());
/*  601 */             if (fundResult.isError()) {
/*  602 */               status.setRollbackOnly();
/*  603 */               AccountCoreManagerImpl.this.log.error("fillFundByTrade is error! fundResult" + fundResult);
/*  604 */               return fundResult;
/*      */             }
/*      */           }
/*      */ 
/*  608 */           return fundResult;
/*      */         } catch (Exception e) {
/*  610 */           status.setRollbackOnly();
/*  611 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  612 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*  613 */           AccountCoreManagerImpl.this.log.error("fillFundByTrade execute error:" + request, e);
/*  614 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundBatchResult fillFundBatchByTrade(List<TransRequest> requestList)
/*      */   {
/*  630 */     int successRecords = 0;
/*  631 */     int failedRecords = 0;
/*  632 */     int records = requestList.size();
/*  633 */     FundOperateResult fundResult = null;
/*  634 */     FundBatchResult fundBatchResult = new FundBatchResult();
/*  635 */     List fundResultList = new ArrayList();
/*      */ 
/*  638 */     if ((null == requestList) || (0 == requestList.size())) {
/*  639 */       fundBatchResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  640 */       fundBatchResult.setErrorInfo("input param is null");
/*  641 */       this.log.error("fillFundBatchByTrade input params is null");
/*  642 */       return fundBatchResult;
/*      */     }
/*      */ 
/*  645 */     for (TransRequest transRequest : requestList)
/*      */     {
/*  647 */       fundResult = fillFundByTrade(transRequest);
/*      */ 
/*  649 */       fundResult.setFundAccount(fundResult.getFundAccount());
/*  650 */       fundResult.setBizNo(fundResult.getBizNo());
/*  651 */       fundResultList.add(fundResult);
/*      */ 
/*  653 */       if (fundResult.isError())
/*  654 */         failedRecords++;
/*      */       else {
/*  656 */         successRecords++;
/*      */       }
/*      */     }
/*      */ 
/*  660 */     if ((successRecords > 0) && (successRecords == records)) {
/*  661 */       if (this.log.isDebugEnabled()) {
/*  662 */         this.log.debug("all fillFundBatchByTrade are successed");
/*      */       }
/*  664 */       fundBatchResult.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  665 */       fundBatchResult.setErrorInfo("all successed!");
/*  666 */     } else if (successRecords > 0) {
/*  667 */       if (this.log.isDebugEnabled()) {
/*  668 */         this.log.debug("part fillFundBatchByTrade are successed");
/*      */       }
/*  670 */       fundBatchResult.setErrorNO(EnumFundResultCode.PART_SUCCESS.getCode());
/*  671 */       fundBatchResult.setErrorInfo("successed = " + successRecords + "; failed" + failedRecords);
/*      */     }
/*      */     else {
/*  674 */       this.log.error("all fillFundBatchByTrade are failed");
/*  675 */       fundBatchResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  676 */       fundBatchResult.setErrorInfo("all failed!");
/*      */     }
/*  678 */     fundBatchResult.setFundResultList(fundResultList);
/*  679 */     return fundBatchResult;
/*      */   }
/*      */ 
/*      */   public FundOperateResult cancelFundByTrade(final TransRequest request)
/*      */   {
/*  691 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/*  693 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/*  695 */           if (request == null) {
/*  696 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  697 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  698 */             AccountCoreManagerImpl.this.log.error("cancelFundByTrade request params is null!");
/*  699 */             return fundResult;
/*      */           }
/*      */ 
/*  703 */           if (StringUtil.isBlank(request.getOperator())) {
/*  704 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  705 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  706 */             AccountCoreManagerImpl.this.log.error("cancelFundByTrade Operator params is null, Operator=" + request.getOperator());
/*  707 */             return fundResult;
/*      */           }
/*      */ 
/*  711 */           if (StringUtil.isBlank(request.getMoneyType())) {
/*  712 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/*  715 */           request.setTransDate(AccountCoreManagerImpl.this.getTransDate());
/*      */ 
/*  719 */           if ((null == request.getFundAccount()) || (null == request.getOrderProperty()) || (null == request.getAmount()) || (StringUtil.isBlank(request.getBizNo())))
/*      */           {
/*  722 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  723 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  724 */             AccountCoreManagerImpl.this.log.error("cancelFundByTrade  params is error, FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ", OrderProperty=" + request.getOrderProperty() + ",Amount=" + request.getAmount());
/*      */ 
/*  728 */             return fundResult;
/*      */           }
/*      */ 
/*  731 */           if (request.getAmount().longValue() < 0L) {
/*  732 */             fundResult.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  733 */             fundResult.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  734 */             AccountCoreManagerImpl.this.log.error("cancelFundByTrade  params is error,FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ",Amount=" + request.getAmount());
/*      */ 
/*  737 */             return fundResult;
/*      */           }
/*      */ 
/*  741 */           TradeTransReq transReq = new TradeTransReq();
/*  742 */           transReq.setFundAccount(request.getFundAccount());
/*  743 */           transReq.setAmount(request.getAmount());
/*  744 */           transReq.setMoneyType(request.getMoneyType());
/*  745 */           transReq.setBizNo(request.getBizNo());
/*  746 */           transReq.setOperator(request.getOperator());
/*  747 */           transReq.setMemo(request.getMemo());
/*  748 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/*  751 */           transReq.setTransCode(EnumTransCode.TXCODE_TRANS_UNFREEZE_DEPOSIT);
/*  752 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  753 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  754 */           fundResult.setBizNo(transReq.getBizNo());
/*  755 */           if (fundResult.isError()) {
/*  756 */             status.setRollbackOnly();
/*  757 */             AccountCoreManagerImpl.this.log.error("cancelFundByTrade is error! fundResult" + fundResult);
/*  758 */             return fundResult;
/*      */           }
/*      */ 
/*  761 */           return fundResult;
/*      */         } catch (Exception e) {
/*  763 */           status.setRollbackOnly();
/*  764 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  765 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*  766 */           AccountCoreManagerImpl.this.log.error("cancelFundByTrade execute error:" + request, e);
/*  767 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundBatchResult cancelFundBatchByTrade(List<TransRequest> requestList)
/*      */   {
/*  782 */     int successRecords = 0;
/*  783 */     int failedRecords = 0;
/*  784 */     int records = requestList.size();
/*  785 */     FundOperateResult fundResult = null;
/*  786 */     FundBatchResult fundBatchResult = new FundBatchResult();
/*  787 */     List fundResultList = new ArrayList();
/*      */ 
/*  790 */     if ((null == requestList) || (0 == requestList.size())) {
/*  791 */       fundBatchResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  792 */       fundBatchResult.setErrorInfo("input param is null");
/*  793 */       this.log.error("cancelFundBatchByTrade input params is null");
/*  794 */       return fundBatchResult;
/*      */     }
/*      */ 
/*  797 */     for (TransRequest transRequest : requestList)
/*      */     {
/*  799 */       fundResult = cancelFundByTrade(transRequest);
/*      */ 
/*  801 */       fundResult.setFundAccount(fundResult.getFundAccount());
/*  802 */       fundResult.setBizNo(fundResult.getBizNo());
/*  803 */       fundResultList.add(fundResult);
/*      */ 
/*  805 */       if (fundResult.isError())
/*  806 */         failedRecords++;
/*      */       else {
/*  808 */         successRecords++;
/*      */       }
/*      */     }
/*      */ 
/*  812 */     if ((successRecords > 0) && (successRecords == records)) {
/*  813 */       if (this.log.isDebugEnabled()) {
/*  814 */         this.log.debug("all cancelFundBatchByTrade are successed");
/*      */       }
/*  816 */       fundBatchResult.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  817 */       fundBatchResult.setErrorInfo("all successed!");
/*  818 */     } else if (successRecords > 0) {
/*  819 */       if (this.log.isDebugEnabled()) {
/*  820 */         this.log.debug("part cancelFundBatchByTrade are successed");
/*      */       }
/*  822 */       fundBatchResult.setErrorNO(EnumFundResultCode.PART_SUCCESS.getCode());
/*  823 */       fundBatchResult.setErrorInfo("successed = " + successRecords + "; failed" + failedRecords);
/*      */     }
/*      */     else {
/*  826 */       this.log.error("all cancelFundBatchByTrade are failed");
/*  827 */       fundBatchResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  828 */       fundBatchResult.setErrorInfo("all failed!");
/*      */     }
/*  830 */     fundBatchResult.setFundResultList(fundResultList);
/*  831 */     return fundBatchResult;
/*      */   }
/*      */ 
/*      */   public FundOperateResult prePayPayment(final TransRequest request)
/*      */   {
/*  842 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/*  844 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/*  846 */           if (request == null) {
/*  847 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  848 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  849 */             AccountCoreManagerImpl.this.log.error("prePayPayment request params is null!");
/*  850 */             return fundResult;
/*      */           }
/*      */ 
/*  854 */           if (StringUtil.isBlank(request.getOperator())) {
/*  855 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  856 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  857 */             AccountCoreManagerImpl.this.log.error("prePayPayment Operator params is null, Operator=" + request.getOperator());
/*      */ 
/*  859 */             return fundResult;
/*      */           }
/*      */ 
/*  863 */           if (StringUtil.isBlank(request.getMoneyType())) {
/*  864 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/*  868 */           if ((null == request.getFundAccount()) || (null == request.getOrderProperty()) || (StringUtil.isBlank(request.getBizNo())) || (null == request.getGoodsAmount()))
/*      */           {
/*  870 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  871 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  872 */             AccountCoreManagerImpl.this.log.error("prePayPayment  params is error,FundAccount=" + request.getFundAccount() + ", OrderProperty=" + request.getOrderProperty() + ",Amount=" + request.getAmount());
/*      */ 
/*  875 */             return fundResult;
/*      */           }
/*  877 */           if (request.getGoodsAmount().longValue() < 0L) {
/*  878 */             fundResult.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  879 */             fundResult.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  880 */             AccountCoreManagerImpl.this.log.error("prePayPayment  params is error,FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ",GoodsAmount=" + request.getGoodsAmount());
/*      */ 
/*  883 */             return fundResult;
/*      */           }
/*      */ 
/*  887 */           TradeTransReq transReq = new TradeTransReq();
/*  888 */           transReq.setAmount(request.getGoodsAmount());
/*  889 */           transReq.setBizNo(request.getBizNo());
/*  890 */           transReq.setOperator(request.getOperator());
/*  891 */           transReq.setMemo(request.getMemo());
/*  892 */           transReq.setMoneyType(request.getMoneyType());
/*  893 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/*  897 */           transReq.setFundAccount(EnumMiddleFundAccount.MIDDLE_GOODS_FUND_ACCOUNT.getCode());
/*  898 */           transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_IN);
/*  899 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  900 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  901 */           fundResult.setBizNo(transReq.getBizNo());
/*  902 */           if (fundResult.isError()) {
/*  903 */             status.setRollbackOnly();
/*  904 */             AccountCoreManagerImpl.this.log.error("prePayPayment is error! fundResult" + fundResult);
/*  905 */             return fundResult;
/*      */           }
/*      */ 
/*  909 */           transReq.setFundAccount(request.getFundAccount());
/*  910 */           transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_OUT);
/*  911 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  912 */           fundResult.setFundAccount(transReq.getFundAccount());
/*  913 */           fundResult.setBizNo(transReq.getBizNo());
/*  914 */           if (fundResult.isError()) {
/*  915 */             status.setRollbackOnly();
/*  916 */             AccountCoreManagerImpl.this.log.error("prePayPayment is error! fundResult" + fundResult);
/*  917 */             return fundResult;
/*      */           }
/*      */ 
/*  920 */           return fundResult;
/*      */         } catch (Exception e) {
/*  922 */           status.setRollbackOnly();
/*  923 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/*  924 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/*  925 */           AccountCoreManagerImpl.this.log.error("prePayPayment execute error:" + request, e);
/*  926 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult refundPayment(final TransRequest request)
/*      */   {
/*  941 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/*  943 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/*  945 */           if (request == null) {
/*  946 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  947 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  948 */             AccountCoreManagerImpl.this.log.error("refundPayment request params is null!");
/*  949 */             return fundResult;
/*      */           }
/*      */ 
/*  953 */           if (StringUtil.isBlank(request.getOperator())) {
/*  954 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  955 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  956 */             AccountCoreManagerImpl.this.log.error("refundPayment Operator params is null, Operator=" + request.getOperator());
/*      */ 
/*  958 */             return fundResult;
/*      */           }
/*      */ 
/*  962 */           if (StringUtil.isBlank(request.getMoneyType())) {
/*  963 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/*  967 */           if ((null == request.getFundAccount()) || (null == request.getOrderProperty()) || (StringUtil.isBlank(request.getBizNo())) || (null == request.getGoodsAmount()))
/*      */           {
/*  969 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  970 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  971 */             AccountCoreManagerImpl.this.log.error("refundPayment  params is error,FundAccount=" + request.getFundAccount() + ", OrderProperty=" + request.getOrderProperty() + ",Amount=" + request.getAmount());
/*      */ 
/*  974 */             return fundResult;
/*      */           }
/*  976 */           if (request.getGoodsAmount().longValue() < 0L) {
/*  977 */             fundResult.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/*  978 */             fundResult.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/*  979 */             AccountCoreManagerImpl.this.log.error("refundPayment  params is error,FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ",GoodsAmount=" + request.getGoodsAmount());
/*      */ 
/*  982 */             return fundResult;
/*      */           }
/*      */ 
/*  986 */           TradeTransReq transReq = new TradeTransReq();
/*  987 */           transReq.setAmount(request.getGoodsAmount());
/*  988 */           transReq.setBizNo(request.getBizNo());
/*  989 */           transReq.setOperator(request.getOperator());
/*  990 */           transReq.setMemo(request.getMemo());
/*  991 */           transReq.setMoneyType(request.getMoneyType());
/*  992 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/*  996 */           transReq.setFundAccount(EnumMiddleFundAccount.MIDDLE_GOODS_FUND_ACCOUNT.getCode());
/*  997 */           transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_OUT);
/*  998 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/*  999 */           fundResult.setFundAccount(transReq.getFundAccount());
/* 1000 */           fundResult.setBizNo(transReq.getBizNo());
/* 1001 */           if (fundResult.isError()) {
/* 1002 */             status.setRollbackOnly();
/* 1003 */             AccountCoreManagerImpl.this.log.error("refundPayment is error! fundResult" + fundResult);
/* 1004 */             return fundResult;
/*      */           }
/*      */ 
/* 1008 */           transReq.setFundAccount(request.getFundAccount());
/* 1009 */           transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_IN);
/* 1010 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1011 */           fundResult.setFundAccount(transReq.getFundAccount());
/* 1012 */           fundResult.setBizNo(transReq.getBizNo());
/* 1013 */           if (fundResult.isError()) {
/* 1014 */             status.setRollbackOnly();
/* 1015 */             AccountCoreManagerImpl.this.log.error("refundPayment is error! fundResult" + fundResult);
/* 1016 */             return fundResult;
/*      */           }
/*      */ 
/* 1019 */           return fundResult;
/*      */         } catch (Exception e) {
/* 1021 */           status.setRollbackOnly();
/* 1022 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/* 1023 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/* 1024 */           AccountCoreManagerImpl.this.log.error("refundPayment execute error:" + request, e);
/* 1025 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult payPayment(final TransRequest request)
/*      */   {
/* 1040 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/* 1042 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/* 1044 */           if (request == null) {
/* 1045 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1046 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1047 */             AccountCoreManagerImpl.this.log.error("payPayment request params is null!");
/* 1048 */             return fundResult;
/*      */           }
/*      */ 
/* 1052 */           if (StringUtil.isBlank(request.getOperator())) {
/* 1053 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1054 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1055 */             AccountCoreManagerImpl.this.log.error("payPayment Operator params is null, Operator=" + request.getOperator());
/*      */ 
/* 1057 */             return fundResult;
/*      */           }
/*      */ 
/* 1061 */           if (StringUtil.isBlank(request.getMoneyType())) {
/* 1062 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/* 1066 */           if ((null == request.getFundAccount()) || (StringUtil.isBlank(request.getBizNo())) || (StringUtil.isBlank(request.getSellFundAccount())) || (null == request.getSellDeliveryAmount()) || (null == request.getDeliveryAmount()) || (null == request.getGoodsAmount()) || (StringUtil.isBlank(request.getGoodsAmountType())) || (StringUtil.isBlank(request.getHasInvoice())))
/*      */           {
/* 1072 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1073 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1074 */             AccountCoreManagerImpl.this.log.error("payPayment  params is error,FundAccount=" + request.getFundAccount() + ",SellFundAccount=" + request.getSellFundAccount() + ", OrderProperty=" + request.getOrderProperty() + ",DeliveryAmount=" + request.getDeliveryAmount() + ",GoodsAmount=" + request.getGoodsAmount() + ",SellDeliveryAmount=" + request.getSellDeliveryAmount() + ", GoodsAmountType=" + request.getGoodsAmountType() + ", HasInvoice=" + request.getHasInvoice());
/*      */ 
/* 1083 */             return fundResult;
/*      */           }
/* 1085 */           if ((request.getGoodsAmount().longValue() < 0L) || (request.getDeliveryAmount().longValue() < 0L) || (request.getSellDeliveryAmount().longValue() < 0L)) {
/* 1086 */             fundResult.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/* 1087 */             fundResult.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/* 1088 */             AccountCoreManagerImpl.this.log.error("payPayment  params is error,FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ",DeliveryAmount=" + request.getDeliveryAmount() + ",GoodsAmount=" + request.getGoodsAmount() + ",SellDeliveryAmount=" + request.getSellDeliveryAmount());
/*      */ 
/* 1093 */             return fundResult;
/*      */           }
/*      */ 
/* 1097 */           TradeTransReq transReq = new TradeTransReq();
/* 1098 */           transReq.setBizNo(request.getBizNo());
/* 1099 */           transReq.setOperator(request.getOperator());
/* 1100 */           transReq.setMemo(request.getMemo());
/* 1101 */           transReq.setMoneyType(request.getMoneyType());
/* 1102 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/* 1105 */           if (((StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_TICKETS.getValue())) || ((StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_GOODS.getValue())) && (StringUtil.equals(request.getHasInvoice(), EnumHasEnabled.NO_NEED.getValue())))) && (request.getDeliveryAmount().longValue() > 0L))
/*      */           {
/* 1110 */             transReq.setFundAccount(request.getFundAccount());
/* 1111 */             transReq.setAmount(request.getDeliveryAmount());
/* 1112 */             transReq.setTransCode(EnumTransCode.TXCODE_DELIVERY_UNFREEZE_DEPOSIT);
/* 1113 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1114 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1115 */             fundResult.setBizNo(transReq.getBizNo());
/* 1116 */             if (fundResult.isError()) {
/* 1117 */               status.setRollbackOnly();
/* 1118 */               AccountCoreManagerImpl.this.log.error("payPayment is error! fundResult" + fundResult);
/* 1119 */               return fundResult;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1124 */           if (((StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_TICKETS.getValue())) || ((StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_GOODS.getValue())) && (StringUtil.equals(request.getHasInvoice(), EnumHasEnabled.NO_NEED.getValue())))) && (request.getSellDeliveryAmount().longValue() > 0L))
/*      */           {
/* 1129 */             transReq.setFundAccount(request.getSellFundAccount());
/* 1130 */             transReq.setAmount(request.getSellDeliveryAmount());
/* 1131 */             transReq.setTransCode(EnumTransCode.TXCODE_DELIVERY_UNFREEZE_DEPOSIT);
/* 1132 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1133 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1134 */             fundResult.setBizNo(transReq.getBizNo());
/* 1135 */             if (fundResult.isError()) {
/* 1136 */               status.setRollbackOnly();
/* 1137 */               AccountCoreManagerImpl.this.log.error("payPayment is error! fundResult" + fundResult);
/* 1138 */               return fundResult;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1143 */           if (request.getGoodsAmount().longValue() > 0L)
/*      */           {
/* 1145 */             transReq.setFundAccount(EnumMiddleFundAccount.MIDDLE_GOODS_FUND_ACCOUNT.getCode());
/* 1146 */             transReq.setAmount(request.getGoodsAmount());
/* 1147 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_OUT);
/* 1148 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1149 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1150 */             fundResult.setBizNo(transReq.getBizNo());
/* 1151 */             if (fundResult.isError()) {
/* 1152 */               status.setRollbackOnly();
/* 1153 */               AccountCoreManagerImpl.this.log.error("payPayment is error! fundResult" + fundResult);
/* 1154 */               return fundResult;
/*      */             }
/*      */ 
/* 1158 */             transReq.setFundAccount(request.getSellFundAccount());
/* 1159 */             transReq.setAmount(request.getGoodsAmount());
/*      */ 
/* 1161 */             if (StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_GOODS.getValue()))
/* 1162 */               transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_IN);
/* 1163 */             else if (StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_TICKETS.getValue())) {
/* 1164 */               transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FINAL_FUND_IN);
/*      */             }
/* 1166 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1167 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1168 */             fundResult.setBizNo(transReq.getBizNo());
/* 1169 */             if (fundResult.isError()) {
/* 1170 */               status.setRollbackOnly();
/* 1171 */               AccountCoreManagerImpl.this.log.error("payPayment is error! fundResult" + fundResult);
/* 1172 */               return fundResult;
/*      */             }
/*      */           }
/*      */ 
/* 1176 */           return fundResult;
/*      */         } catch (Exception e) {
/* 1178 */           status.setRollbackOnly();
/* 1179 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/* 1180 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/* 1181 */           AccountCoreManagerImpl.this.log.error("payPayment execute error:" + request, e);
/* 1182 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult penaltyManager(TransRequest request)
/*      */   {
/* 1195 */     return null;
/*      */   }
/*      */ 
/*      */   public FundOperateResult tradeBroken(final TransRequest request)
/*      */   {
/* 1205 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/* 1207 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/* 1209 */           if (request == null) {
/* 1210 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1211 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1212 */             AccountCoreManagerImpl.this.log.error("tradeBroken request params is null!");
/* 1213 */             return fundResult;
/*      */           }
/*      */ 
/* 1217 */           if (StringUtil.isBlank(request.getOperator())) {
/* 1218 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1219 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1220 */             AccountCoreManagerImpl.this.log.error("tradeBroken Operator params is null, Operator=" + request.getOperator());
/* 1221 */             return fundResult;
/*      */           }
/*      */ 
/* 1225 */           if (StringUtil.isBlank(request.getMoneyType())) {
/* 1226 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/* 1231 */           if ((null == request.getFundAccount()) || (null == request.getPenaltyAccount()) || (null == request.getDeliveryAmount()) || (null == request.getFreezeDepositAmount()) || (null == request.getPenaltyamount()) || (StringUtil.isBlank(request.getBizNo())))
/*      */           {
/* 1236 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1237 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1238 */             AccountCoreManagerImpl.this.log.error("tradeBroken  params is error,BizNo=" + request.getBizNo() + "FundAccount=" + request.getFundAccount() + ", PenaltyAccount=" + request.getPenaltyAccount() + ",DeliveryAmount=" + request.getDeliveryAmount() + ",FreezeDepositAmount=" + request.getFreezeDepositAmount() + ",Penaltyamount=" + request.getPenaltyamount());
/*      */ 
/* 1244 */             return fundResult;
/*      */           }
/* 1246 */           if ((request.getDeliveryAmount().longValue() < 0L) || (request.getFreezeDepositAmount().longValue() < 0L) || (request.getPenaltyamount().longValue() < 0L)) {
/* 1247 */             fundResult.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/* 1248 */             fundResult.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/* 1249 */             AccountCoreManagerImpl.this.log.error("tradeBroken  params is error,FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ",DeliveryAmount=" + request.getDeliveryAmount() + ",FreezeDepositAmount=" + request.getFreezeDepositAmount() + ",Penaltyamount=" + request.getPenaltyamount());
/*      */ 
/* 1254 */             return fundResult;
/*      */           }
/*      */ 
/* 1258 */           TradeTransReq transReq = new TradeTransReq();
/* 1259 */           transReq.setBizNo(request.getBizNo());
/* 1260 */           transReq.setOperator(request.getOperator());
/* 1261 */           transReq.setMemo(request.getMemo());
/* 1262 */           transReq.setMoneyType(request.getMoneyType());
/* 1263 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/* 1266 */           transReq.setFundAccount(request.getPenaltyAccount());
/* 1267 */           transReq.setAmount(request.getFreezeDepositAmount());
/* 1268 */           transReq.setTransCode(EnumTransCode.TXCODE_TRANS_UNFREEZE_DEPOSIT);
/* 1269 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1270 */           fundResult.setFundAccount(transReq.getFundAccount());
/* 1271 */           fundResult.setBizNo(transReq.getBizNo());
/* 1272 */           if (fundResult.isError()) {
/* 1273 */             status.setRollbackOnly();
/* 1274 */             AccountCoreManagerImpl.this.log.error("tradeBroken is error! fundResult" + fundResult);
/* 1275 */             return fundResult;
/*      */           }
/*      */ 
/* 1279 */           if (request.getPenaltyamount().longValue() > 0L)
/*      */           {
/* 1281 */             transReq.setFundAccount(request.getPenaltyAccount());
/* 1282 */             transReq.setAmount(request.getPenaltyamount());
/* 1283 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_PENALTY_FUND_OUT);
/* 1284 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1285 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1286 */             fundResult.setBizNo(transReq.getBizNo());
/* 1287 */             if (fundResult.isError()) {
/* 1288 */               status.setRollbackOnly();
/* 1289 */               AccountCoreManagerImpl.this.log.error("tradeBroken is error! fundResult" + fundResult);
/* 1290 */               return fundResult;
/*      */             }
/*      */ 
/* 1294 */             transReq.setFundAccount(request.getFundAccount());
/* 1295 */             transReq.setAmount(request.getPenaltyamount());
/* 1296 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_PENALTY_FUND_IN);
/* 1297 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1298 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1299 */             fundResult.setBizNo(transReq.getBizNo());
/* 1300 */             if (fundResult.isError()) {
/* 1301 */               status.setRollbackOnly();
/* 1302 */               AccountCoreManagerImpl.this.log.error("tradeBroken is error! fundResult" + fundResult);
/* 1303 */               return fundResult;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1308 */           transReq.setFundAccount(request.getFundAccount());
/* 1309 */           transReq.setAmount(request.getDeliveryAmount());
/* 1310 */           transReq.setTransCode(EnumTransCode.TXCODE_DELIVERY_UNFREEZE_DEPOSIT);
/* 1311 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1312 */           fundResult.setFundAccount(transReq.getFundAccount());
/* 1313 */           fundResult.setBizNo(transReq.getBizNo());
/* 1314 */           if (fundResult.isError()) {
/* 1315 */             status.setRollbackOnly();
/* 1316 */             AccountCoreManagerImpl.this.log.error("tradeBroken is error! fundResult" + fundResult);
/* 1317 */             return fundResult;
/*      */           }
/*      */ 
/* 1320 */           return fundResult;
/*      */         } catch (Exception e) {
/* 1322 */           status.setRollbackOnly();
/* 1323 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/* 1324 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/* 1325 */           AccountCoreManagerImpl.this.log.error("tradeBroken execute error:" + request, e);
/* 1326 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult deliveryBroken(final TransRequest request)
/*      */   {
/* 1339 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/* 1341 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/* 1343 */           if (request == null) {
/* 1344 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1345 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1346 */             AccountCoreManagerImpl.this.log.error("deliveryBroken request params is null!");
/* 1347 */             return fundResult;
/*      */           }
/*      */ 
/* 1351 */           if (StringUtil.isBlank(request.getOperator())) {
/* 1352 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1353 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1354 */             AccountCoreManagerImpl.this.log.error("deliveryBroken Operator params is null, Operator=" + request.getOperator());
/* 1355 */             return fundResult;
/*      */           }
/*      */ 
/* 1359 */           if (StringUtil.isBlank(request.getMoneyType())) {
/* 1360 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/* 1365 */           if ((null == request.getFundAccount()) || (null == request.getPenaltyAccount()) || (null == request.getDeliveryAmount()) || (null == request.getPenaltydeliveryAmount()) || (null == request.getPenaltyamount()) || (null == request.getGoodsAmount()) || (StringUtil.isBlank(request.getBizNo())))
/*      */           {
/* 1371 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1372 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1373 */             AccountCoreManagerImpl.this.log.error("deliveryBroken  params is error,BizNo=" + request.getBizNo() + "FundAccount=" + request.getFundAccount() + ", PenaltyAccount=" + request.getPenaltyAccount() + ",DeliveryAmount=" + request.getDeliveryAmount() + ",PenaltydeliveryAmount=" + request.getPenaltydeliveryAmount() + ",Penaltyamount=" + request.getPenaltyamount());
/*      */ 
/* 1379 */             return fundResult;
/*      */           }
/* 1381 */           if ((request.getDeliveryAmount().longValue() < 0L) || (request.getPenaltydeliveryAmount().longValue() < 0L) || (request.getPenaltyamount().longValue() < 0L) || (request.getGoodsAmount().longValue() < 0L))
/*      */           {
/* 1383 */             fundResult.setErrorNO(EnumFundResultCode.OPERATE_UNDO.getCode());
/* 1384 */             fundResult.setErrorInfo(EnumFundResultCode.OPERATE_UNDO.getDescription());
/* 1385 */             AccountCoreManagerImpl.this.log.error("deliveryBroken  params is error,FundAccount=" + request.getFundAccount() + ",BizNo" + request.getBizNo() + ",DeliveryAmount=" + request.getDeliveryAmount() + ",PenaltydeliveryAmount=" + request.getPenaltydeliveryAmount() + ",Penaltyamount=" + request.getPenaltyamount() + ",GoodsAmount=" + request.getGoodsAmount());
/*      */ 
/* 1391 */             return fundResult;
/*      */           }
/*      */ 
/* 1395 */           TradeTransReq transReq = new TradeTransReq();
/* 1396 */           transReq.setBizNo(request.getBizNo());
/* 1397 */           transReq.setOperator(request.getOperator());
/* 1398 */           transReq.setMemo(request.getMemo());
/* 1399 */           transReq.setMoneyType(request.getMoneyType());
/* 1400 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/* 1403 */           transReq.setFundAccount(request.getPenaltyAccount());
/* 1404 */           transReq.setAmount(request.getPenaltydeliveryAmount());
/* 1405 */           transReq.setTransCode(EnumTransCode.TXCODE_DELIVERY_UNFREEZE_DEPOSIT);
/* 1406 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1407 */           fundResult.setFundAccount(transReq.getFundAccount());
/* 1408 */           if (fundResult.isError()) {
/* 1409 */             status.setRollbackOnly();
/* 1410 */             AccountCoreManagerImpl.this.log.error("deliveryBroken is error! fundResult" + fundResult);
/* 1411 */             return fundResult;
/*      */           }
/*      */ 
/* 1415 */           if (request.getPenaltyamount().longValue() > 0L)
/*      */           {
/* 1417 */             transReq.setFundAccount(request.getPenaltyAccount());
/* 1418 */             transReq.setAmount(request.getPenaltyamount());
/* 1419 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_PENALTY_FUND_OUT);
/* 1420 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1421 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1422 */             fundResult.setBizNo(transReq.getBizNo());
/* 1423 */             if (fundResult.isError()) {
/* 1424 */               status.setRollbackOnly();
/* 1425 */               AccountCoreManagerImpl.this.log.error("deliveryBroken is error! fundResult" + fundResult);
/* 1426 */               return fundResult;
/*      */             }
/*      */ 
/* 1430 */             transReq.setFundAccount(request.getFundAccount());
/* 1431 */             transReq.setAmount(request.getPenaltyamount());
/* 1432 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_PENALTY_FUND_IN);
/* 1433 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1434 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1435 */             fundResult.setBizNo(transReq.getBizNo());
/* 1436 */             if (fundResult.isError()) {
/* 1437 */               status.setRollbackOnly();
/* 1438 */               AccountCoreManagerImpl.this.log.error("deliveryBroken is error! fundResult" + fundResult);
/* 1439 */               return fundResult;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1444 */           transReq.setFundAccount(request.getFundAccount());
/* 1445 */           transReq.setAmount(request.getDeliveryAmount());
/* 1446 */           transReq.setTransCode(EnumTransCode.TXCODE_DELIVERY_UNFREEZE_DEPOSIT);
/* 1447 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1448 */           fundResult.setFundAccount(transReq.getFundAccount());
/* 1449 */           fundResult.setBizNo(transReq.getBizNo());
/* 1450 */           if (fundResult.isError()) {
/* 1451 */             status.setRollbackOnly();
/* 1452 */             AccountCoreManagerImpl.this.log.error("deliveryBroken is error! fundResult" + fundResult);
/* 1453 */             return fundResult;
/*      */           }
/*      */ 
/* 1457 */           if (request.getGoodsAmount().longValue() > 0L)
/*      */           {
/* 1459 */             transReq.setFundAccount(EnumMiddleFundAccount.MIDDLE_GOODS_FUND_ACCOUNT.getCode());
/* 1460 */             transReq.setAmount(request.getGoodsAmount());
/* 1461 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_OUT);
/* 1462 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1463 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1464 */             fundResult.setBizNo(transReq.getBizNo());
/* 1465 */             if (fundResult.isError()) {
/* 1466 */               status.setRollbackOnly();
/* 1467 */               AccountCoreManagerImpl.this.log.error("deliveryBroken is error! fundResult" + fundResult);
/* 1468 */               return fundResult;
/*      */             }
/*      */ 
/* 1472 */             transReq.setFundAccount(request.getFundAccount());
/* 1473 */             transReq.setAmount(request.getGoodsAmount());
/* 1474 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_IN);
/* 1475 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1476 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1477 */             fundResult.setBizNo(transReq.getBizNo());
/* 1478 */             if (fundResult.isError()) {
/* 1479 */               status.setRollbackOnly();
/* 1480 */               AccountCoreManagerImpl.this.log.error("deliveryBroken is error! fundResult" + fundResult);
/* 1481 */               return fundResult;
/*      */             }
/*      */           }
/*      */ 
/* 1485 */           return fundResult;
/*      */         } catch (Exception e) {
/* 1487 */           status.setRollbackOnly();
/* 1488 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/* 1489 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/* 1490 */           AccountCoreManagerImpl.this.log.error("deliveryBroken execute error:" + request, e);
/* 1491 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult checkGoodsTicketBroken(final TransRequest request)
/*      */   {
/* 1504 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/* 1506 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/* 1508 */           if (request == null) {
/* 1509 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1510 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1511 */             AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken request params is null!");
/* 1512 */             return fundResult;
/*      */           }
/*      */ 
/* 1516 */           if (StringUtil.isBlank(request.getOperator())) {
/* 1517 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1518 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1519 */             AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken Operator params is null, Operator=" + request.getOperator());
/* 1520 */             return fundResult;
/*      */           }
/*      */ 
/* 1524 */           if (StringUtil.isBlank(request.getMoneyType())) {
/* 1525 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/* 1527 */           if (StringUtil.isBlank(request.getTransDate())) {
/* 1528 */             request.setTransDate(AccountCoreManagerImpl.this.getTransDate());
/*      */           }
/*      */ 
/* 1533 */           if ((StringUtil.isBlank(request.getFundAccount())) || (StringUtil.isBlank(request.getSellFundAccount())) || (null == request.getGoodsAmount()) || (null == request.getBuyerGoodsAmount()) || (StringUtil.isBlank(request.getPenaltyType())) || (null == request.getPenaltyamount()) || (null == request.getPenaltydeliveryAmount()) || (null == request.getDeliveryAmount()) || (StringUtil.isBlank(request.getCheckGoodsTicketType())) || (StringUtil.isBlank(request.getGoodsAmountType())) || (StringUtil.isBlank(request.getHasInvoice())) || (StringUtil.isBlank(request.getBizNo())))
/*      */           {
/* 1544 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1545 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1546 */             AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken  params is error,BizNo=" + request.getBizNo() + " FundAccount=" + request.getFundAccount() + ", SellFundAccount=" + request.getSellFundAccount() + ", GoodsAmount=" + request.getGoodsAmount() + ", BuyerGoodsAmount=" + request.getBuyerGoodsAmount() + ", PenaltyType=" + request.getPenaltyType() + ", Penaltyamount=" + request.getPenaltyamount() + ", PenaltydeliveryAmount=" + request.getPenaltydeliveryAmount() + ", DeliveryAmount=" + request.getDeliveryAmount() + ", CheckGoodsTicketType=" + request.getCheckGoodsTicketType() + ", HasInvoice=" + request.getHasInvoice() + ", GoodsAmountType=" + request.getGoodsAmountType());
/*      */ 
/* 1558 */             return fundResult;
/*      */           }
/*      */ 
/* 1563 */           TradeTransReq transReq = new TradeTransReq();
/* 1564 */           transReq.setBizNo(request.getBizNo());
/* 1565 */           transReq.setOperator(request.getOperator());
/* 1566 */           transReq.setMemo(request.getMemo());
/* 1567 */           transReq.setMoneyType(request.getMoneyType());
/* 1568 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/* 1572 */           if ((AccountCoreManagerImpl.this.tradeCheckGoodsTicket(1, request)) && (request.getPenaltydeliveryAmount().longValue() > 0L)) {
/* 1573 */             if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_BUYER.getValue()))
/* 1574 */               transReq.setFundAccount(request.getFundAccount());
/* 1575 */             else if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_SELLER.getValue()))
/* 1576 */               transReq.setFundAccount(request.getSellFundAccount());
/* 1577 */             else if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_NO.getValue())) {
/* 1578 */               transReq.setFundAccount(request.getSellFundAccount());
/*      */             }
/* 1580 */             transReq.setAmount(request.getPenaltydeliveryAmount());
/* 1581 */             transReq.setTransCode(EnumTransCode.TXCODE_DELIVERY_UNFREEZE_DEPOSIT);
/* 1582 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1583 */             fundResult.setBizNo(transReq.getBizNo());
/* 1584 */             if (fundResult.isError()) {
/* 1585 */               status.setRollbackOnly();
/* 1586 */               AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken TXCODE_DELIVERY_UNFREEZE_DEPOSIT is error! fundResult" + fundResult);
/*      */ 
/* 1588 */               return fundResult;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1594 */           if ((AccountCoreManagerImpl.this.tradeCheckGoodsTicket(1, request)) && (request.getDeliveryAmount().longValue() > 0L)) {
/* 1595 */             if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_BUYER.getValue()))
/* 1596 */               transReq.setFundAccount(request.getSellFundAccount());
/* 1597 */             else if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_SELLER.getValue()))
/* 1598 */               transReq.setFundAccount(request.getFundAccount());
/* 1599 */             else if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_NO.getValue())) {
/* 1600 */               transReq.setFundAccount(request.getFundAccount());
/*      */             }
/* 1602 */             transReq.setAmount(request.getDeliveryAmount());
/* 1603 */             transReq.setTransCode(EnumTransCode.TXCODE_DELIVERY_UNFREEZE_DEPOSIT);
/* 1604 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1605 */             fundResult.setBizNo(transReq.getBizNo());
/* 1606 */             if (fundResult.isError()) {
/* 1607 */               status.setRollbackOnly();
/* 1608 */               AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken TXCODE_DELIVERY_UNFREEZE_DEPOSIT is error! fundResult" + fundResult);
/*      */ 
/* 1610 */               return fundResult;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1616 */           if ((AccountCoreManagerImpl.this.tradeCheckGoodsTicket(2, request)) && (request.getBuyerGoodsAmount().longValue() > 0L))
/*      */           {
/* 1618 */             transReq.setFundAccount(EnumMiddleFundAccount.MIDDLE_GOODS_FUND_ACCOUNT.getCode());
/* 1619 */             transReq.setAmount(request.getBuyerGoodsAmount());
/* 1620 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_OUT);
/* 1621 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1622 */             fundResult.setBizNo(transReq.getBizNo());
/* 1623 */             if (fundResult.isError()) {
/* 1624 */               status.setRollbackOnly();
/* 1625 */               AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken TXCODE_TRANS_GOODS_FUND_OUT is error! fundResult" + fundResult);
/* 1626 */               return fundResult;
/*      */             }
/*      */ 
/* 1630 */             transReq.setFundAccount(request.getFundAccount());
/* 1631 */             transReq.setAmount(request.getBuyerGoodsAmount());
/*      */ 
/* 1633 */             if (StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_GOODS.getValue()))
/* 1634 */               transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_IN);
/* 1635 */             else if (StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_TICKETS.getValue())) {
/* 1636 */               transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FINAL_FUND_IN);
/*      */             }
/* 1638 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1639 */             fundResult.setBizNo(transReq.getBizNo());
/* 1640 */             if (fundResult.isError()) {
/* 1641 */               status.setRollbackOnly();
/* 1642 */               AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken TXCODE_TRANS_GOODS_FUND_IN is error! fundResult" + fundResult);
/* 1643 */               return fundResult;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1649 */           if ((AccountCoreManagerImpl.this.tradeCheckGoodsTicket(2, request)) && (request.getGoodsAmount().longValue() > 0L))
/*      */           {
/* 1651 */             transReq.setFundAccount(EnumMiddleFundAccount.MIDDLE_GOODS_FUND_ACCOUNT.getCode());
/* 1652 */             transReq.setAmount(request.getGoodsAmount());
/* 1653 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_OUT);
/* 1654 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1655 */             fundResult.setBizNo(transReq.getBizNo());
/* 1656 */             if (fundResult.isError()) {
/* 1657 */               status.setRollbackOnly();
/* 1658 */               AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken TXCODE_TRANS_GOODS_FUND_OUT is error! fundResult" + fundResult);
/* 1659 */               return fundResult;
/*      */             }
/*      */ 
/* 1663 */             transReq.setFundAccount(request.getSellFundAccount());
/* 1664 */             transReq.setAmount(request.getGoodsAmount());
/*      */ 
/* 1666 */             if (StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_GOODS.getValue()))
/* 1667 */               transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FUND_IN);
/* 1668 */             else if (StringUtil.equals(request.getGoodsAmountType(), EnumGoodsAmountType.CHECK_TICKETS.getValue())) {
/* 1669 */               transReq.setTransCode(EnumTransCode.TXCODE_TRANS_GOODS_FINAL_FUND_IN);
/*      */             }
/* 1671 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1672 */             fundResult.setBizNo(transReq.getBizNo());
/* 1673 */             if (fundResult.isError()) {
/* 1674 */               status.setRollbackOnly();
/* 1675 */               AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken TXCODE_TRANS_GOODS_FUND_IN is error! fundResult" + fundResult);
/* 1676 */               return fundResult;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1682 */           if ((AccountCoreManagerImpl.this.tradeCheckGoodsTicket(3, request)) && (request.getPenaltyamount().longValue() > 0L) && (!StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_NO.getValue())))
/*      */           {
/* 1685 */             if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_BUYER.getValue()))
/* 1686 */               transReq.setFundAccount(request.getFundAccount());
/* 1687 */             else if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_SELLER.getValue())) {
/* 1688 */               transReq.setFundAccount(request.getSellFundAccount());
/*      */             }
/* 1690 */             transReq.setAmount(request.getPenaltyamount());
/* 1691 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_PENALTY_FUND_OUT);
/* 1692 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1693 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1694 */             fundResult.setBizNo(transReq.getBizNo());
/* 1695 */             if (fundResult.isError()) {
/* 1696 */               status.setRollbackOnly();
/* 1697 */               AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken TXCODE_TRANS_PENALTY_FUND_OUT is error! fundResult" + fundResult);
/* 1698 */               return fundResult;
/*      */             }
/*      */ 
/* 1702 */             if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_BUYER.getValue()))
/* 1703 */               transReq.setFundAccount(request.getSellFundAccount());
/* 1704 */             else if (StringUtil.equals(request.getPenaltyType(), EnumPenaltyType.PENALTY_TYPE_SELLER.getValue())) {
/* 1705 */               transReq.setFundAccount(request.getFundAccount());
/*      */             }
/* 1707 */             transReq.setAmount(request.getPenaltyamount());
/* 1708 */             transReq.setTransCode(EnumTransCode.TXCODE_TRANS_PENALTY_FUND_IN);
/* 1709 */             fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1710 */             fundResult.setFundAccount(transReq.getFundAccount());
/* 1711 */             fundResult.setBizNo(transReq.getBizNo());
/* 1712 */             if (fundResult.isError()) {
/* 1713 */               status.setRollbackOnly();
/* 1714 */               AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken TXCODE_TRANS_PENALTY_FUND_IN is error! fundResult" + fundResult);
/* 1715 */               return fundResult;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1721 */           return fundResult;
/*      */         } catch (Exception e) {
/* 1723 */           status.setRollbackOnly();
/* 1724 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/* 1725 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/* 1726 */           AccountCoreManagerImpl.this.log.error("checkGoodsTicketBroken execute error:" + request, e);
/* 1727 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public FundOperateResult writeOffFund(final TransRequest request)
/*      */   {
/* 1741 */     return (FundOperateResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public FundOperateResult doInTransaction(TransactionStatus status) {
/* 1743 */         FundOperateResult fundResult = new FundOperateResult();
/*      */         try {
/* 1745 */           if (request == null) {
/* 1746 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1747 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1748 */             AccountCoreManagerImpl.this.log.error("writeOffFund request params is null!");
/* 1749 */             return fundResult;
/*      */           }
/*      */ 
/* 1753 */           if (StringUtil.isBlank(request.getOperator())) {
/* 1754 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1755 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1756 */             AccountCoreManagerImpl.this.log.error("writeOffFund Operator params is null, Operator=" + request.getOperator());
/* 1757 */             return fundResult;
/*      */           }
/*      */ 
/* 1761 */           if (StringUtil.isBlank(request.getBizNo()))
/*      */           {
/* 1763 */             fundResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 1764 */             fundResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 1765 */             fundResult.setFundAccount(request.getFundAccount());
/* 1766 */             AccountCoreManagerImpl.this.log.error("When writeOffFund, request params is blank. bizNo=" + request.getBizNo());
/* 1767 */             return fundResult;
/*      */           }
/*      */ 
/* 1771 */           if (StringUtil.isBlank(request.getMoneyType())) {
/* 1772 */             request.setMoneyType(EnumMoneyType.CNY.getCode());
/*      */           }
/*      */ 
/* 1776 */           TradeTransReq transReq = new TradeTransReq();
/* 1777 */           transReq.setBizNo(request.getBizNo());
/*      */ 
/* 1780 */           transReq.setMoneyType(request.getMoneyType());
/* 1781 */           transReq.setMemo(request.getMemo());
/* 1782 */           transReq.setOperator(request.getOperator());
/* 1783 */           transReq.setTransDate(request.getTransDate());
/*      */ 
/* 1786 */           transReq.setTransCode(EnumTransCode.TXCODE_FUND_WRITEOFF);
/* 1787 */           fundResult = AccountCoreManagerImpl.this.execute(transReq);
/* 1788 */           fundResult.setFundAccount(transReq.getFundAccount());
/* 1789 */           fundResult.setBizNo(transReq.getBizNo());
/* 1790 */           if (fundResult.isError()) {
/* 1791 */             status.setRollbackOnly();
/* 1792 */             AccountCoreManagerImpl.this.log.error("writeOffFund is error! fundResult:" + fundResult);
/*      */           }
/* 1794 */           return fundResult;
/*      */         } catch (Exception e) {
/* 1796 */           status.setRollbackOnly();
/* 1797 */           fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/* 1798 */           fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/* 1799 */           AccountCoreManagerImpl.this.log.error("when writeOffFund, execute error:" + request, e);
/* 1800 */         }return fundResult;
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   private String getTransDate()
/*      */   {
/* 1811 */     if (StringUtil.isBlank(Cache.coreCurrentTradingDay)) {
/* 1812 */       return DateUtil.getDateFormat(new Date(), "yyyyMMdd");
/*      */     }
/* 1814 */     return Cache.coreCurrentTradingDay;
/*      */   }
/*      */ 
/*      */   private boolean tradeCheckGoodsTicket(int i, TransRequest request)
/*      */   {
/* 1821 */     switch (i) {
/*      */     case 1:
/* 1823 */       return (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getValue(), request.getCheckGoodsTicketType())) || (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue(), request.getCheckGoodsTicketType())) || (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue(), request.getCheckGoodsTicketType())) || (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue(), request.getCheckGoodsTicketType())) || ((StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue(), request.getCheckGoodsTicketType())) && (StringUtil.equals(request.getHasInvoice(), EnumHasEnabled.NO_NEED.getValue())));
/*      */     case 2:
/* 1831 */       return (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getValue(), request.getCheckGoodsTicketType())) || (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue(), request.getCheckGoodsTicketType())) || (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue(), request.getCheckGoodsTicketType())) || (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue(), request.getCheckGoodsTicketType())) || (StringUtil.equals(request.getCheckGoodsTicketType(), EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue()));
/*      */     case 3:
/* 1838 */       return (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue(), request.getCheckGoodsTicketType())) || (StringUtil.equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue(), request.getCheckGoodsTicketType()));
/*      */     }
/*      */ 
/* 1841 */     return false;
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.manager.pojo.AccountCoreManagerImpl
 * JD-Core Version:    0.6.0
 */