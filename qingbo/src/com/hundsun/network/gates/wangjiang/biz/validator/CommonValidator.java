/*     */ package com.hundsun.network.gates.wangjiang.biz.validator;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictErrors;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumTradeError;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserAccountDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLoginRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("commonValidator")
/*     */ public class CommonValidator
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*  30 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   public OrderServiceResult validateData(BaseTradeDTO baseTradeDTO)
/*     */   {
/*  38 */     OrderServiceResult result = new OrderServiceResult();
/*  39 */     if (StringUtil.isEmpty(baseTradeDTO.getFundAccount())) {
/*  40 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.FUNDACCOUNT_NOT_NULL.getValue()), EnumTradeError.FUNDACCOUNT_NOT_NULL.getName());
/*     */     }
/*     */ 
/*  43 */     if (StringUtil.isEmpty(baseTradeDTO.getProjectCode())) {
/*  44 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.PROJECT_CODE_NOT_NULL.getValue()), EnumTradeError.PROJECT_CODE_NOT_NULL.getName());
/*     */     }
/*     */ 
/*  47 */     if ((StringUtil.isEmpty(baseTradeDTO.getTradingType())) || (EnumTradingType.indexByValue(baseTradeDTO.getTradingType()) == null) || (StringUtil.isEmpty(EnumTradingType.indexByValue(baseTradeDTO.getTradingType()).getName())))
/*     */     {
/*  51 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.TRADING_TYPE_ERROR.getValue()), EnumTradeError.PROJECT_CODE_NOT_NULL.getName());
/*     */     }
/*     */ 
/*  55 */     if (StringUtil.isEmpty(baseTradeDTO.getUserAccount())) {
/*  56 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.USER_ACCOUNT_NOT_NULL.getValue()), EnumTradeError.USER_ACCOUNT_NOT_NULL.getName());
/*     */     }
/*     */ 
/*  60 */     if (baseTradeDTO.getQuantity().longValue() < 1L) {
/*  61 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.QUANTITY_MUST_GREAT_THAN_ZERO.getValue()), EnumTradeError.QUANTITY_MUST_GREAT_THAN_ZERO.getName());
/*     */     }
/*     */ 
/*  65 */     if (baseTradeDTO.getTotalPay().longValue() < 1L) {
/*  66 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.TOTAL_PAY_MUST_GREAT_THAN_ZERO.getValue()), EnumTradeError.TOTAL_PAY_MUST_GREAT_THAN_ZERO.getName());
/*     */     }
/*     */ 
/*  70 */     if (baseTradeDTO.getListingPrice().longValue() < 1L) {
/*  71 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.LISTING_PRICE_GREAT_THAN_ZERO.getValue()), EnumTradeError.LISTING_PRICE_GREAT_THAN_ZERO.getName());
/*     */     }
/*     */ 
/*  74 */     return result;
/*     */   }
/*     */ 
/*     */   public OrderServiceResult isMarketOpen()
/*     */   {
/*  82 */     OrderServiceResult result = new OrderServiceResult();
/*  83 */     SystemDictRequest request = new SystemDictRequest();
/*  84 */     request.setParaCode(EnumSystemDictKey.MARKET_STATUS.getValue());
/*  85 */     SystemDictServiceResult result1 = this.remoteSystemBaseService.selectListByKey(request);
/*  86 */     if (result1 == null) {
/*  87 */       result.setErrorNOInfo(Integer.valueOf(EnumSystemDictErrors.GET_SYSTEM_DICT_ERROR.getValue()), EnumSystemDictErrors.GET_SYSTEM_DICT_ERROR.getInfo());
/*     */ 
/*  89 */       this.log.error("调用remoteSystemBaseService接口失败：请求参数request:" + request + " 错误信息：" + result.getErrorInfo());
/*     */     }
/*  91 */     else if ((result1.getSystemDictList() != null) && (result1.getSystemDictList().size() > 0) && ("N".equals(((SystemDictDTO)result1.getSystemDictList().get(0)).getParaValue().toUpperCase())))
/*     */     {
/*  93 */       result.setErrorNOInfo(Integer.valueOf(EnumSystemDictErrors.MARKT_IS_CLOSE.getValue()), EnumSystemDictErrors.MARKT_IS_CLOSE.getInfo());
/*     */ 
/*  95 */       this.log.error("调用remoteSystemBaseService接口失败：请求参数request:" + request + " 错误信息：" + result.getErrorInfo());
/*     */     }
/*     */ 
/*  98 */     return result;
/*     */   }
/*     */ 
/*     */   public OrderServiceResult validateUser(String userAccount)
/*     */   {
/* 107 */     OrderServiceResult result = new OrderServiceResult();
/* 108 */     UserLoginRequest request = new UserLoginRequest();
/* 109 */     request.setUserAccount(userAccount);
/* 110 */     UserServiceResult uresult = this.remoteUserService.getUserMsgByAccount(request);
/* 111 */     if (uresult == null) {
/* 112 */       result.setErrorNO(Integer.valueOf(EnumTradeError.REMOTE_USER_CALL_ERROR.getValue()));
/* 113 */       result.setErrorInfo(EnumTradeError.REMOTE_USER_CALL_ERROR.getName());
/* 114 */       this.log.error("调用用户接口失败：请求参数request:" + request + " 错误信息：" + result.getErrorInfo());
/* 115 */       return result;
/* 116 */     }if (!uresult.correct()) {
/* 117 */       result.setErrorNO(uresult.getErrorNO());
/* 118 */       result.setErrorInfo(uresult.getErrorInfo());
/* 119 */       this.log.error("调用用户接口失败：请求参数request:" + request + " 错误信息：" + result.getErrorInfo());
/* 120 */       return result;
/*     */     }
/* 122 */     UserAccountDTO userAccountDTO = uresult.getUserAccountDTO();
/* 123 */     if (EnumUserStatus.Nonactivated.getValue().equals(userAccountDTO.getStatus())) {
/* 124 */       result.setErrorNO(Integer.valueOf(EnumTradeError.REMOTE_USER_CALL_ERROR.getValue()));
/* 125 */       result.setErrorInfo("对不起，您的账号" + EnumUserStatus.Nonactivated.getName());
/* 126 */       this.log.error("调用用户接口失败：请求参数request:" + request + " 错误信息：" + result.getErrorInfo());
/* 127 */       return result;
/* 128 */     }if (EnumUserStatus.Unfund.getValue().equals(userAccountDTO.getStatus())) {
/* 129 */       result.setErrorNO(Integer.valueOf(EnumTradeError.REMOTE_USER_CALL_ERROR.getValue()));
/* 130 */       result.setErrorInfo("对不起，您的账号" + EnumUserStatus.Unfund.getName());
/* 131 */       this.log.error("调用用户接口失败：请求参数request:" + request + " 错误信息：" + result.getErrorInfo());
/* 132 */       return result;
/* 133 */     }if (EnumUserStatus.Forbid.getValue().equals(userAccountDTO.getStatus())) {
/* 134 */       result.setErrorNO(Integer.valueOf(EnumTradeError.REMOTE_USER_CALL_ERROR.getValue()));
/* 135 */       result.setErrorInfo("对不起，您的账号" + EnumUserStatus.Forbid.getName());
/* 136 */       this.log.error("调用用户接口失败：请求参数request:" + request + " 错误信息：" + result.getErrorInfo());
/* 137 */       return result;
/* 138 */     }if (EnumUserStatus.Delete.getValue().equals(userAccountDTO.getStatus())) {
/* 139 */       result.setErrorNO(Integer.valueOf(EnumTradeError.REMOTE_USER_CALL_ERROR.getValue()));
/* 140 */       result.setErrorInfo("对不起，您的账号" + EnumUserStatus.Delete.getName());
/* 141 */       this.log.error("调用用户接口失败：请求参数request:" + request + " 错误信息：" + result.getErrorInfo());
/* 142 */       return result;
/*     */     }
/* 144 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.validator.CommonValidator
 * JD-Core Version:    0.6.0
 */