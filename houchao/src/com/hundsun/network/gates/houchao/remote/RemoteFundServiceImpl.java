/*     */ package com.hundsun.network.gates.houchao.remote;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountBankDao;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.Cache;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccount;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountBank;
/*     */ import com.hundsun.network.gates.houchao.biz.manager.AccountCoreManager;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundAccountStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.AccountRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundBatchResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserAccountDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserActivateRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLoginRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.CancleAccountResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteFundService")
/*     */ public class RemoteFundServiceImpl
/*     */   implements RemoteFundService
/*     */ {
/*  57 */   private Log log = LogFactory.getLog(RemoteFundServiceImpl.class);
/*     */   private static final String TRANS_TYPE_TO_EXCHANGE = "01";
/*     */   private static final String TRANS_TYPE_TO_BANK = "02";
/*     */ 
/*     */   @Autowired
/*     */   private AccountCoreManager accountCoreManager;
/*     */ 
/*     */   @Autowired
/*     */   private FundAccountDAO fundAccountDAO;
/*     */ 
/*     */   @Autowired
/*     */   private FundMoneyDAO fundMoneyDAO;
/*     */ 
/*     */   @Autowired
/*     */   private FundAccountBankDao fundAccountBankDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   public FundOperateResult createFundAccount(AccountRequest request)
/*     */   {
/*  85 */     if (this.log.isDebugEnabled()) {
/*  86 */       this.log.debug("createFundAccount params:" + request);
/*     */     }
/*  88 */     FundOperateResult fundResult = new FundOperateResult();
/*     */ 
/*  90 */     request.setTransDate(getTransDate());
/*     */ 
/*  94 */     UserActivateRequest userActivateRequest = new UserActivateRequest();
/*  95 */     userActivateRequest.setFundAccount(request.getFundAccount());
/*  96 */     userActivateRequest.setBank(request.getBankNo());
/*  97 */     userActivateRequest.setBankCard(request.getBankAccount());
/*  98 */     userActivateRequest.setCertificateType(request.getIdKind());
/*  99 */     userActivateRequest.setCertificateNum(request.getIdNo());
/* 100 */     UserServiceResult userServiceResult = this.remoteUserService.checkFundActivate(userActivateRequest);
/* 101 */     if (userServiceResult.error()) {
/* 102 */       fundResult.setErrorNO(String.valueOf(userServiceResult.getErrorNO()));
/* 103 */       fundResult.setErrorInfo(userServiceResult.getErrorInfo());
/* 104 */       this.log.error("createFundAccount checkFundActivate is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params userActivateRequest:" + userActivateRequest);
/*     */ 
/* 107 */       return fundResult;
/*     */     }
/*     */ 
/* 111 */     request.setClientId(userServiceResult.getUserAccountDTO().getAccount());
/* 112 */     request.setPositionId(userServiceResult.getUserAccountDTO().getAccount());
/* 113 */     fundResult = this.accountCoreManager.createFundAccount(request);
/* 114 */     if (fundResult.isError()) {
/* 115 */       this.log.error("createFundAccount is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params request:" + request);
/*     */ 
/* 118 */       return fundResult;
/*     */     }
/*     */ 
/* 122 */     ServiceResult serviceResult = this.remoteUserService.fundActivate(userActivateRequest);
/* 123 */     if (serviceResult.error()) {
/* 124 */       fundResult.setErrorNO(String.valueOf(serviceResult.getErrorNO()));
/* 125 */       fundResult.setErrorInfo(serviceResult.getErrorInfo());
/* 126 */       this.log.error("createFundAccount fundActivate is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params userActivateRequest:" + userActivateRequest);
/*     */ 
/* 129 */       return fundResult;
/*     */     }
/*     */ 
/* 132 */     return fundResult;
/*     */   }
/*     */ 
/*     */   public FundOperateResult cancelFundAccount(AccountRequest request)
/*     */   {
/* 143 */     if (this.log.isDebugEnabled()) {
/* 144 */       this.log.debug("cancelFundAccount params:" + request);
/*     */     }
/* 146 */     FundOperateResult fundResult = new FundOperateResult();
/*     */ 
/* 148 */     request.setTransDate(getTransDate());
/*     */ 
/* 155 */     FundAccount fundAccount = this.fundAccountDAO.queryByFundAccount(request.getFundAccount(), false);
/* 156 */     if (null == fundAccount) {
/* 157 */       fundResult.setErrorNO(EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode());
/* 158 */       fundResult.setErrorInfo(EnumFundResultCode.ACCOUNT_NOT_EXIST.getCode());
/* 159 */       this.log.error("cancelFundAccount  is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params FundAccount:" + request.getFundAccount());
/*     */ 
/* 162 */       return fundResult;
/*     */     }
/* 164 */     if (!StringUtil.equals(fundAccount.getStatus(), EnumFundAccountStatus.OPEN.getCode())) {
/* 165 */       fundResult.setErrorNO(EnumFundResultCode.ACCOUNT_BE_CANCELED.getCode());
/* 166 */       fundResult.setErrorInfo(EnumFundResultCode.ACCOUNT_BE_CANCELED.getCode());
/* 167 */       this.log.error("cancelFundAccount is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params FundAccount:" + request.getFundAccount());
/*     */ 
/* 170 */       return fundResult;
/*     */     }
/*     */ 
/* 174 */     UserLoginRequest userRequest = new UserLoginRequest();
/* 175 */     userRequest.setUserAccount(fundAccount.getClientId());
/*     */ 
/* 178 */     CancleAccountResult cancleAccountResult = this.remoteUserService.applyCancleAccount(userRequest);
/* 179 */     if (cancleAccountResult.error()) {
/* 180 */       fundResult.setErrorNO(String.valueOf(cancleAccountResult.getErrorNO()));
/* 181 */       fundResult.setErrorInfo(cancleAccountResult.getErrorInfo());
/* 182 */       this.log.error("cancelFundAccount applyCancleAccount is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params UserLoginRequest:" + userRequest);
/*     */ 
/* 185 */       return fundResult;
/*     */     }
/*     */ 
/* 189 */     fundResult = this.accountCoreManager.cancelFundAccount(request);
/* 190 */     if (fundResult.isError()) {
/* 191 */       this.log.error("cancelFundAccount cancelFundAccount is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params AccountRequest:" + request);
/*     */ 
/* 194 */       return fundResult;
/*     */     }
/*     */ 
/* 198 */     cancleAccountResult = this.remoteUserService.cancleAccount(userRequest);
/* 199 */     if (cancleAccountResult.error()) {
/* 200 */       fundResult.setErrorNO(String.valueOf(cancleAccountResult.getErrorNO()));
/* 201 */       fundResult.setErrorInfo(cancleAccountResult.getErrorInfo());
/* 202 */       this.log.error("cancelFundAccount cancleAccount is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params UserLoginRequest:" + userRequest);
/*     */ 
/* 205 */       return fundResult;
/*     */     }
/*     */ 
/* 208 */     return fundResult;
/*     */   }
/*     */ 
/*     */   public FundOperateResult fundInAccount(TransRequest request)
/*     */   {
/* 219 */     if (this.log.isDebugEnabled()) {
/* 220 */       this.log.debug("fundInAccount params:" + request);
/*     */     }
/*     */ 
/* 224 */     if (checkTradeTime()) {
/* 225 */       FundOperateResult fundResult = new FundOperateResult();
/* 226 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 227 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 228 */       this.log.error("sorry!! system is backup data.");
/* 229 */       return fundResult;
/*     */     }
/*     */ 
/* 233 */     request.setTransDate(getTransDate());
/*     */ 
/* 236 */     if (StringUtil.isBlank(request.getBizNo())) {
/* 237 */       request.setBizNo(getBankBillNo("01"));
/*     */     }
/* 239 */     return this.accountCoreManager.fundInAccount(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult fundOutAccount(TransRequest request)
/*     */   {
/* 250 */     if (this.log.isDebugEnabled()) {
/* 251 */       this.log.debug("fundOutAccount params:" + request);
/*     */     }
/*     */ 
/* 255 */     if (checkTradeTime()) {
/* 256 */       FundOperateResult fundResult = new FundOperateResult();
/* 257 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 258 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 259 */       this.log.error("sorry!! system is backup data.");
/* 260 */       return fundResult;
/*     */     }
/*     */ 
/* 264 */     request.setTransDate(getTransDate());
/*     */ 
/* 267 */     if (StringUtil.isBlank(request.getBizNo())) {
/* 268 */       request.setBizNo(getBankBillNo("02"));
/*     */     }
/* 270 */     return this.accountCoreManager.fundOutAccount(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult fundInByExchange(TransRequest request)
/*     */   {
/* 281 */     if (this.log.isDebugEnabled()) {
/* 282 */       this.log.debug("fundInAccount params:" + request);
/*     */     }
/* 284 */     FundOperateResult fundResult = new FundOperateResult();
/*     */ 
/* 287 */     if (checkTradeTime()) {
/* 288 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 289 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 290 */       this.log.error("sorry!! system is backup data.");
/* 291 */       return fundResult;
/*     */     }
/*     */ 
/* 295 */     request.setTransDate(getTransDate());
/*     */ 
/* 298 */     if (StringUtil.isBlank(request.getBizNo())) {
/* 299 */       request.setBizNo(getBankBillNo("01"));
/*     */     }
/*     */ 
/* 334 */     fundResult = this.accountCoreManager.fundInAccount(request);
/* 335 */     if (fundResult.isError()) {
/* 336 */       this.log.error("fundInByExchange fundInAccount is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params request:" + request);
/*     */ 
/* 339 */       return fundResult;
/*     */     }
/*     */ 
/* 342 */     return fundResult;
/*     */   }
/*     */ 
/*     */   public FundOperateResult fundOutByExchange(TransRequest request)
/*     */   {
/* 353 */     if (this.log.isDebugEnabled()) {
/* 354 */       this.log.debug("fundOutByExchange params:" + request);
/*     */     }
/* 356 */     FundOperateResult fundResult = new FundOperateResult();
/*     */ 
/* 359 */     if (checkTradeTime()) {
/* 360 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 361 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 362 */       this.log.error("sorry!! system is backup data.");
/* 363 */       return fundResult;
/*     */     }
/*     */ 
/* 367 */     request.setTransDate(getTransDate());
/*     */ 
/* 370 */     if (StringUtil.isBlank(request.getBizNo())) {
/* 371 */       request.setBizNo(getBankBillNo("02"));
/*     */     }
/*     */ 
/* 380 */     FundAccountBank fundAccountBank = this.fundAccountBankDAO.getFundAccountBankByAccount(request.getFundAccount());
/* 381 */     if (null == fundAccountBank) {
/* 382 */       fundResult.setErrorNO(EnumFundResultCode.ACCOUNT_BANK_NOT_EXIST.getCode());
/* 383 */       fundResult.setErrorInfo(EnumFundResultCode.ACCOUNT_BANK_NOT_EXIST.getDescription());
/* 384 */       this.log.error("fundOutByExchange fundAccountBank is null!");
/* 385 */       return fundResult;
/*     */     }
/*     */ 
/* 389 */     fundResult = this.accountCoreManager.fundOutAccount(request);
/* 390 */     if (fundResult.isError()) {
/* 391 */       this.log.error("fundOutByExchange fundOutAccount is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params request:" + request);
/*     */ 
/* 394 */       return fundResult;
/*     */     }
/*     */ 
/* 448 */     return fundResult;
/*     */   }
/*     */ 
/*     */   public FundOperateResult freezeFundByTrade(TransRequest request)
/*     */   {
/* 459 */     if (this.log.isDebugEnabled()) {
/* 460 */       this.log.debug("freezeFundByTrade params:" + request);
/*     */     }
/*     */ 
/* 464 */     if (checkTradeTime()) {
/* 465 */       FundOperateResult fundResult = new FundOperateResult();
/* 466 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 467 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 468 */       this.log.error("sorry!! system is backup data.");
/* 469 */       return fundResult;
/*     */     }
/*     */ 
/* 473 */     request.setTransDate(getTransDate());
/*     */ 
/* 475 */     return this.accountCoreManager.freezeFundByTrade(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult fillFundByTrade(TransRequest request)
/*     */   {
/* 486 */     if (this.log.isDebugEnabled()) {
/* 487 */       this.log.debug("fillFundByTrade params:" + request);
/*     */     }
/*     */ 
/* 491 */     if (checkTradeTime()) {
/* 492 */       FundOperateResult fundResult = new FundOperateResult();
/* 493 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 494 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 495 */       this.log.error("sorry!! system is backup data.");
/* 496 */       return fundResult;
/*     */     }
/*     */ 
/* 500 */     request.setTransDate(getTransDate());
/*     */ 
/* 502 */     return this.accountCoreManager.fillFundByTrade(request);
/*     */   }
/*     */ 
/*     */   public FundBatchResult fillFundBatchByTrade(List<TransRequest> request)
/*     */   {
/* 513 */     if (this.log.isDebugEnabled()) {
/* 514 */       this.log.debug("fillFundBatchByTrade params:" + request);
/*     */     }
/*     */ 
/* 518 */     if (checkTradeTime()) {
/* 519 */       FundBatchResult fundResult = new FundBatchResult();
/* 520 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 521 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 522 */       this.log.error("sorry!! system is backup data.");
/* 523 */       return fundResult;
/*     */     }
/*     */ 
/* 526 */     return this.accountCoreManager.fillFundBatchByTrade(request);
/*     */   }
/*     */ 
/*     */   public FundBatchResult cancelFundBatchByTrade(List<TransRequest> request)
/*     */   {
/* 537 */     if (this.log.isDebugEnabled()) {
/* 538 */       this.log.debug("cancelFundBatchByTrade params:" + request);
/*     */     }
/*     */ 
/* 542 */     if (checkTradeTime()) {
/* 543 */       FundBatchResult fundResult = new FundBatchResult();
/* 544 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 545 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 546 */       this.log.error("sorry!! system is backup data.");
/* 547 */       return fundResult;
/*     */     }
/*     */ 
/* 550 */     return this.accountCoreManager.cancelFundBatchByTrade(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult prePayPayment(TransRequest request)
/*     */   {
/* 560 */     if (this.log.isDebugEnabled()) {
/* 561 */       this.log.debug("prePayPayment params:" + request);
/*     */     }
/*     */ 
/* 565 */     if (checkTradeTime()) {
/* 566 */       FundOperateResult fundResult = new FundOperateResult();
/* 567 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 568 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 569 */       this.log.error("sorry!! system is backup data.");
/* 570 */       return fundResult;
/*     */     }
/*     */ 
/* 574 */     request.setTransDate(getTransDate());
/*     */ 
/* 577 */     return this.accountCoreManager.prePayPayment(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult refundPayment(TransRequest request)
/*     */   {
/* 588 */     if (this.log.isDebugEnabled()) {
/* 589 */       this.log.debug("refundPayment params:" + request);
/*     */     }
/*     */ 
/* 593 */     if (checkTradeTime()) {
/* 594 */       FundOperateResult fundResult = new FundOperateResult();
/* 595 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 596 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 597 */       this.log.error("sorry!! system is backup data.");
/* 598 */       return fundResult;
/*     */     }
/*     */ 
/* 602 */     request.setTransDate(getTransDate());
/*     */ 
/* 605 */     return this.accountCoreManager.refundPayment(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult payPayment(TransRequest request)
/*     */   {
/* 616 */     if (this.log.isDebugEnabled()) {
/* 617 */       this.log.debug("payPayment params:" + request);
/*     */     }
/*     */ 
/* 621 */     if (checkTradeTime()) {
/* 622 */       FundOperateResult fundResult = new FundOperateResult();
/* 623 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 624 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 625 */       this.log.error("sorry!! system is backup data.");
/* 626 */       return fundResult;
/*     */     }
/*     */ 
/* 630 */     request.setTransDate(getTransDate());
/*     */ 
/* 633 */     return this.accountCoreManager.payPayment(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult penaltyManager(TransRequest request)
/*     */   {
/* 644 */     if (this.log.isDebugEnabled()) {
/* 645 */       this.log.debug("penaltyManager params:" + request);
/*     */     }
/*     */ 
/* 649 */     if (checkTradeTime()) {
/* 650 */       FundOperateResult fundResult = new FundOperateResult();
/* 651 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 652 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 653 */       this.log.error("sorry!! system is backup data.");
/* 654 */       return fundResult;
/*     */     }
/*     */ 
/* 659 */     request.setTransDate(getTransDate());
/*     */ 
/* 662 */     return this.accountCoreManager.penaltyManager(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult cancelFundByTrade(TransRequest request)
/*     */   {
/* 673 */     if (this.log.isDebugEnabled()) {
/* 674 */       this.log.debug("cancelFundByTrade params:" + request);
/*     */     }
/*     */ 
/* 678 */     if (checkTradeTime()) {
/* 679 */       FundOperateResult fundResult = new FundOperateResult();
/* 680 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 681 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 682 */       this.log.error("sorry!! system is backup data.");
/* 683 */       return fundResult;
/*     */     }
/*     */ 
/* 687 */     request.setTransDate(getTransDate());
/*     */ 
/* 690 */     return this.accountCoreManager.cancelFundByTrade(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult tradeBroken(TransRequest request)
/*     */   {
/* 701 */     if (this.log.isDebugEnabled()) {
/* 702 */       this.log.debug("tradeBroken params:" + request);
/*     */     }
/*     */ 
/* 706 */     if (checkTradeTime()) {
/* 707 */       FundOperateResult fundResult = new FundOperateResult();
/* 708 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 709 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 710 */       this.log.error("sorry!! system is backup data.");
/* 711 */       return fundResult;
/*     */     }
/*     */ 
/* 715 */     request.setTransDate(getTransDate());
/*     */ 
/* 718 */     return this.accountCoreManager.tradeBroken(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult deliveryBroken(TransRequest request)
/*     */   {
/* 729 */     if (this.log.isDebugEnabled()) {
/* 730 */       this.log.debug("deliveryBroken params:" + request);
/*     */     }
/*     */ 
/* 734 */     if (checkTradeTime()) {
/* 735 */       FundOperateResult fundResult = new FundOperateResult();
/* 736 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 737 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 738 */       this.log.error("sorry!! system is backup data.");
/* 739 */       return fundResult;
/*     */     }
/*     */ 
/* 743 */     request.setTransDate(getTransDate());
/*     */ 
/* 745 */     return this.accountCoreManager.deliveryBroken(request);
/*     */   }
/*     */ 
/*     */   public FundOperateResult checkGoodsTicketBroken(TransRequest request)
/*     */   {
/* 754 */     if (this.log.isDebugEnabled()) {
/* 755 */       this.log.debug("checkGoodsTicketBroken params:" + request);
/*     */     }
/*     */ 
/* 759 */     if (checkTradeTime()) {
/* 760 */       FundOperateResult fundResult = new FundOperateResult();
/* 761 */       fundResult.setErrorNO(EnumFundResultCode.INTERNAL_ERROR.getCode());
/* 762 */       fundResult.setErrorInfo(EnumFundResultCode.INTERNAL_ERROR.getDescription());
/* 763 */       this.log.error("sorry!! system is backup data.");
/* 764 */       return fundResult;
/*     */     }
/*     */ 
/* 768 */     request.setTransDate(getTransDate());
/*     */ 
/* 770 */     return this.accountCoreManager.checkGoodsTicketBroken(request);
/*     */   }
/*     */ 
/*     */   private FundOperateResult writeOffFund(TransRequest request)
/*     */   {
/* 777 */     FundOperateResult fundResult = new FundOperateResult();
/* 778 */     fundResult = this.accountCoreManager.writeOffFund(request);
/* 779 */     if (fundResult.isError())
/*     */     {
/* 781 */       fundResult.setErrorNO(EnumFundResultCode.OPERATE_FAILURE.getCode());
/* 782 */       fundResult.setErrorInfo(EnumFundResultCode.OPERATE_FAILURE.getDescription());
/* 783 */       this.log.error("writeOffFund writeOffAccount is failure,ERRORMSG: errorNO=" + fundResult.getErrorNO() + ",errorINFO=" + fundResult.getErrorInfo() + "; params request:" + request);
/*     */ 
/* 786 */       return fundResult;
/*     */     }
/* 788 */     return fundResult;
/*     */   }
/*     */ 
/*     */   private String getBankBillNo(String transType)
/*     */   {
/* 797 */     Date date = new Date();
/* 798 */     DateFormat df = new SimpleDateFormat("yyyyMMdd");
/* 799 */     String dateStr = df.format(date);
/* 800 */     String seq = StringUtil.alignLeft(this.fundAccountDAO.getInnerBillNoSeq(), 8, '0');
/*     */ 
/* 802 */     return StringUtil.alignLeft(dateStr + transType + seq, 20, '0');
/*     */   }
/*     */ 
/*     */   private String getTransDate()
/*     */   {
/* 810 */     if (StringUtil.isBlank(Cache.coreCurrentTradingDay)) {
/* 811 */       return DateUtil.getDateFormat(new Date(), "yyyyMMdd");
/*     */     }
/* 813 */     return Cache.coreCurrentTradingDay;
/*     */   }
/*     */ 
/*     */   private boolean checkTradeTime()
/*     */   {
/* 821 */     int startTime = 25955;
/* 822 */     int endTime = 30030;
/* 823 */     int currentTime = Integer.valueOf(DateUtil.convertDateToString("HHmmss", new Date())).intValue();
/*     */ 
/* 825 */     return (currentTime >= startTime) && (currentTime <= endTime);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.remote.RemoteFundServiceImpl
 * JD-Core Version:    0.6.0
 */