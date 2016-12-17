/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumUserCreditAutoRankValue;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumUserCreditLogRanktype;
/*     */ import com.hundsun.network.gates.luosi.common.enums.UserCreditType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.BigDecimalUtil;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemCreditLevelDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemDictDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.baseset.UserCreditDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.baseset.UserCreditLogDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemCreditLevel;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserCredit;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserCreditLog;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserCreditService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("userCreditService")
/*     */ public class UserCreditServiceImpl extends BaseService
/*     */   implements UserCreditService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserCreditDAO userCreditDAO;
/*     */ 
/*     */   @Autowired
/*     */   private SystemCreditLevelDAO systemCreditLevelDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UserCreditLogDAO userCreditLogDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private SystemDictDAO systemDictDAO;
/*     */ 
/*     */   public Long addInsertUserCredit(String userAccount)
/*     */   {
/*  55 */     SystemCreditLevel creditLevel = this.systemCreditLevelDAO.selectInitCreditLevel();
/*  56 */     UserCredit uc = new UserCredit();
/*  57 */     uc.setBuyCreditLevel(creditLevel.getCreditLevel());
/*  58 */     uc.setBuyCreditNum(Long.valueOf(0L));
/*  59 */     uc.setBuyGoodNum(Long.valueOf(0L));
/*  60 */     uc.setBuyMiddNum(Long.valueOf(0L));
/*  61 */     uc.setBuyBadNum(Long.valueOf(0L));
/*  62 */     uc.setLogisticsSpeed(new BigDecimal(0));
/*  63 */     uc.setServiceAttitude(new BigDecimal(0));
/*  64 */     uc.setSellerCreditLevel(creditLevel.getCreditLevel());
/*  65 */     uc.setSellerCreditNum(Long.valueOf(0L));
/*  66 */     uc.setSellerGoodNum(Long.valueOf(0L));
/*  67 */     uc.setSellerMiddNum(Long.valueOf(0L));
/*  68 */     uc.setSellerBadNum(Long.valueOf(0L));
/*  69 */     uc.setUserAccount(userAccount);
/*  70 */     uc.setCreator(userAccount);
/*  71 */     uc.setGmtCreate(new Date());
/*  72 */     uc.setGmtModify(new Date());
/*  73 */     uc.setModifier(userAccount);
/*  74 */     return this.userCreditDAO.addInsertUserCredit(uc);
/*     */   }
/*     */ 
/*     */   public ServiceResult autoUserCredit(final TradeOrder order, final String userAccount, final String operator)
/*     */   {
/*  87 */     ServiceResult result = new ServiceResult();
/*     */ 
/*  89 */     final String orderNo = order.getOrderNo();
/*  90 */     if (StringUtil.isBlank(orderNo)) {
/*  91 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/*  92 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/*  93 */       return result;
/*     */     }
/*  95 */     final UserCredit uc = this.userCreditDAO.selectByUserAccount(userAccount);
/*  96 */     if (userAccount.equals(order.getSellerAccount())) {
/*  97 */       long integralLong = uc.getSellerCreditNum().longValue() + EnumUserCreditAutoRankValue.GOOD_RANK.getValue().longValue();
/*     */ 
/*  99 */       uc.setSellerCreditNum(Long.valueOf(integralLong));
/* 100 */       SystemCreditLevel crlevel = this.systemCreditLevelDAO.calcCreditLevel(Long.valueOf(integralLong));
/* 101 */       uc.setSellerCreditLevel(crlevel.getCreditLevel());
/* 102 */       uc.setSellerGoodNum(Long.valueOf(uc.getSellerGoodNum().longValue() + EnumUserCreditAutoRankValue.GOOD_RANK.getValue().longValue()));
/*     */ 
/* 104 */       Long serviceAttitude = Long.valueOf(EnumUserCreditAutoRankValue.SERVICE_ATTITUDE.getValue().longValue());
/*     */ 
/* 106 */       if (uc.getServiceAttitude().doubleValue() != 0.0D) {
/* 107 */         BigDecimalUtil util = new BigDecimalUtil();
/* 108 */         BigDecimal serviceAttitudeBig = BigDecimalUtil.div(BigDecimalUtil.add(uc.getServiceAttitude(), new BigDecimal(serviceAttitude.longValue())), new BigDecimal(2));
/*     */ 
/* 110 */         uc.setServiceAttitude(serviceAttitudeBig);
/*     */       }
/*     */       else {
/* 113 */         uc.setServiceAttitude(new BigDecimal(serviceAttitude.longValue()).setScale(2, 4));
/*     */       }
/*     */ 
/* 117 */       Long logisticsSpeed = Long.valueOf(EnumUserCreditAutoRankValue.LOGISTICS_SPEED.getValue().longValue());
/*     */ 
/* 119 */       if (logisticsSpeed != null)
/*     */       {
/* 121 */         if (uc.getLogisticsSpeed().doubleValue() != 0.0D) {
/* 122 */           BigDecimalUtil util = new BigDecimalUtil();
/* 123 */           BigDecimal logisticsSpeedBig = BigDecimalUtil.div(BigDecimalUtil.add(uc.getLogisticsSpeed(), new BigDecimal(logisticsSpeed.longValue())), new BigDecimal(2));
/*     */ 
/* 125 */           uc.setLogisticsSpeed(logisticsSpeedBig);
/*     */         }
/*     */         else {
/* 128 */           uc.setLogisticsSpeed(new BigDecimal(logisticsSpeed.longValue()).setScale(2, 4));
/*     */         }
/*     */       }
/*     */ 
/* 132 */       uc.setModifier(operator);
/*     */ 
/* 134 */       result = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */       {
/*     */         public ServiceResult doInTransaction(TransactionStatus status) {
/* 137 */           ServiceResult result = new ServiceResult();
/*     */           try
/*     */           {
/* 140 */             UserCreditServiceImpl.this.userCreditDAO.updateUserCredit(uc);
/*     */ 
/* 142 */             Short rankType = Short.valueOf(EnumUserCreditLogRanktype.SET_BUY.getValue());
/* 143 */             String memo = DateUtil.getDateFormat(new Date(), null) + "系统自动评价: 改变用户" + userAccount + "卖家信用" + EnumUserCreditAutoRankValue.GOOD_RANK.getValue().longValue();
/*     */ 
/* 150 */             UserCreditServiceImpl.this.addUserCreditLog(userAccount, orderNo, order.getProjectCode(), rankType, Integer.valueOf(EnumUserCreditAutoRankValue.GOOD_RANK.getValue().intValue()), null, null, memo, operator, "系统自动好评");
/*     */ 
/* 154 */             Map param = new HashMap();
/* 155 */             param.put("hasBuyerRank", EnumHasEnabled.NEED.getValue());
/* 156 */             param.put("operator", operator);
/* 157 */             UserCreditServiceImpl.this.tradeOrderDAO.updateParamByOrderNo(param, orderNo);
/*     */           }
/*     */           catch (Exception e) {
/* 160 */             UserCreditServiceImpl.this.log.error("UserCreditServiceImpl autoUserCredit error:", e);
/* 161 */             status.setRollbackOnly();
/* 162 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 163 */             result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 164 */             return result;
/*     */           }
/* 166 */           return result;
/*     */         } } );
/*     */     }
/* 170 */     else if (userAccount.equals(order.getBuyerAccount()))
/*     */     {
/* 172 */       long integralLong = uc.getBuyCreditNum().longValue() + EnumUserCreditAutoRankValue.GOOD_RANK.getValue().longValue();
/*     */ 
/* 174 */       uc.setBuyCreditNum(Long.valueOf(integralLong));
/* 175 */       SystemCreditLevel crlevel = this.systemCreditLevelDAO.calcCreditLevel(Long.valueOf(integralLong));
/* 176 */       uc.setBuyCreditLevel(crlevel.getCreditLevel());
/* 177 */       uc.setBuyGoodNum(Long.valueOf(uc.getBuyGoodNum().longValue() + EnumUserCreditAutoRankValue.GOOD_RANK.getValue().longValue()));
/*     */ 
/* 179 */       uc.setModifier(operator);
/*     */ 
/* 181 */       result = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */       {
/*     */         public ServiceResult doInTransaction(TransactionStatus status) {
/* 184 */           ServiceResult result = new ServiceResult();
/*     */           try
/*     */           {
/* 187 */             UserCreditServiceImpl.this.userCreditDAO.updateUserCredit(uc);
/*     */ 
/* 189 */             Short rankType = Short.valueOf(EnumUserCreditLogRanktype.SET_SELL.getValue());
/* 190 */             String memo = DateUtil.getDateFormat(new Date(), null) + "系统自动评价: 改变用户" + userAccount + "买家信用" + EnumUserCreditAutoRankValue.GOOD_RANK.getValue().longValue();
/*     */ 
/* 197 */             UserCreditServiceImpl.this.addUserCreditLog(userAccount, orderNo, order.getProjectCode(), rankType, Integer.valueOf(EnumUserCreditAutoRankValue.GOOD_RANK.getValue().intValue()), null, null, memo, operator, "系统自动好评");
/*     */ 
/* 201 */             Map param = new HashMap();
/* 202 */             param.put("hasSellerRank", EnumHasEnabled.NEED.getValue());
/* 203 */             param.put("operator", operator);
/* 204 */             UserCreditServiceImpl.this.tradeOrderDAO.updateParamByOrderNo(param, orderNo);
/*     */           }
/*     */           catch (Exception e) {
/* 207 */             UserCreditServiceImpl.this.log.error("UserCreditServiceImpl autoUserCredit error:", e);
/* 208 */             status.setRollbackOnly();
/* 209 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 210 */             result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 211 */             return result;
/*     */           }
/* 213 */           return result;
/*     */         } } );
/*     */     }
/*     */     else {
/* 218 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 219 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 220 */       return result;
/*     */     }
/* 222 */     return result;
/*     */   }
/*     */ 
/*     */   public int updateUserCredit(String userAccount, String userCreditType, Integer integral, Integer serviceAttitude, Integer logisticsSpeed, String operator)
/*     */   {
/* 239 */     UserCredit uc = this.userCreditDAO.selectByUserAccount(userAccount);
/*     */ 
/* 242 */     if (UserCreditType.SET_SELLER_CREDIT.getValue().equals(userCreditType)) {
/* 243 */       String evaluateType = null;
/* 244 */       if (integral.intValue() >= 1) {
/* 245 */         uc.setSellerGoodNum(Long.valueOf(uc.getSellerGoodNum().longValue() + 1L));
/* 246 */         evaluateType = EnumSystemDictKey.EVALUATE_POSITIVE.getValue();
/* 247 */       } else if (integral.intValue() == 0) {
/* 248 */         uc.setSellerMiddNum(Long.valueOf(uc.getSellerMiddNum().longValue() + 1L));
/* 249 */         evaluateType = EnumSystemDictKey.EVALUATE_MODERATE.getValue();
/* 250 */       } else if (integral.intValue() <= -1) {
/* 251 */         uc.setSellerBadNum(Long.valueOf(uc.getSellerBadNum().longValue() + 1L));
/* 252 */         evaluateType = EnumSystemDictKey.EVALUATE_NEGATIVE.getValue();
/*     */       }
/*     */ 
/* 255 */       long integralLong = uc.getSellerCreditNum().longValue();
/*     */ 
/* 261 */       if (integralLong <= 0L) {
/* 262 */         integralLong = 0L;
/*     */       }
/* 264 */       uc.setSellerCreditNum(Long.valueOf(integralLong));
/* 265 */       SystemCreditLevel crlevel = this.systemCreditLevelDAO.calcCreditLevel(Long.valueOf(integralLong));
/* 266 */       uc.setSellerCreditLevel(crlevel.getCreditLevel());
/*     */ 
/* 268 */       if (serviceAttitude != null)
/*     */       {
/* 270 */         if (uc.getServiceAttitude().doubleValue() != 0.0D) {
/* 271 */           double sat = (uc.getServiceAttitude().doubleValue() + serviceAttitude.intValue()) / 2.0D;
/* 272 */           BigDecimal serviceAttitudeBig = new BigDecimal(sat).setScale(2, 4);
/*     */ 
/* 274 */           uc.setServiceAttitude(serviceAttitudeBig);
/*     */         } else {
/* 276 */           uc.setServiceAttitude(new BigDecimal(serviceAttitude.intValue()).setScale(2, 4));
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 281 */       if (logisticsSpeed != null)
/*     */       {
/* 283 */         if (uc.getLogisticsSpeed().doubleValue() != 0.0D) {
/* 284 */           double logistspeed = (uc.getLogisticsSpeed().doubleValue() + logisticsSpeed.intValue()) / 2.0D;
/* 285 */           BigDecimal logisticsSpeedBig = new BigDecimal(logistspeed).setScale(2, 4);
/*     */ 
/* 287 */           uc.setLogisticsSpeed(logisticsSpeedBig);
/*     */         } else {
/* 289 */           uc.setLogisticsSpeed(new BigDecimal(logisticsSpeed.intValue()).setScale(2, 4));
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 296 */     if (UserCreditType.SET_BUYER_CREDIT.getValue().equals(userCreditType)) {
/* 297 */       String evaluateType = null;
/* 298 */       if (integral.intValue() >= 1) {
/* 299 */         uc.setSellerGoodNum(Long.valueOf(uc.getSellerGoodNum().longValue() + 1L));
/* 300 */         evaluateType = EnumSystemDictKey.EVALUATE_POSITIVE.getValue();
/* 301 */       } else if (integral.intValue() == 0) {
/* 302 */         uc.setSellerMiddNum(Long.valueOf(uc.getSellerMiddNum().longValue() + 1L));
/* 303 */         evaluateType = EnumSystemDictKey.EVALUATE_MODERATE.getValue();
/* 304 */       } else if (integral.intValue() <= -1) {
/* 305 */         uc.setSellerBadNum(Long.valueOf(uc.getSellerBadNum().longValue() + 1L));
/* 306 */         evaluateType = EnumSystemDictKey.EVALUATE_NEGATIVE.getValue();
/*     */       }
/* 308 */       long integralLong = uc.getBuyCreditNum().longValue();
/*     */ 
/* 313 */       if (integralLong <= 0L) {
/* 314 */         integralLong = 0L;
/*     */       }
/* 316 */       uc.setBuyCreditNum(Long.valueOf(integralLong));
/* 317 */       SystemCreditLevel crlevel = this.systemCreditLevelDAO.calcCreditLevel(Long.valueOf(integralLong));
/* 318 */       uc.setBuyCreditLevel(crlevel.getCreditLevel());
/*     */     }
/* 320 */     uc.setModifier(operator);
/*     */ 
/* 322 */     return this.userCreditDAO.updateUserCredit(uc);
/*     */   }
/*     */ 
/*     */   public UserCredit selectByUserAccount(String userAccount)
/*     */   {
/* 338 */     return this.userCreditDAO.selectByUserAccount(userAccount);
/*     */   }
/*     */ 
/*     */   public int deductUserCredit(String userAccount, String userCreditType, Integer integral, String operator)
/*     */   {
/* 352 */     UserCredit uc = this.userCreditDAO.selectByUserAccount(userAccount);
/*     */ 
/* 355 */     if (UserCreditType.SET_SELLER_CREDIT.getValue().equals(userCreditType)) {
/* 356 */       long integralLong = uc.getSellerCreditNum().longValue() + integral.intValue();
/* 357 */       uc.setSellerCreditNum(Long.valueOf(integralLong));
/*     */ 
/* 360 */       if (integralLong <= 0L) {
/* 361 */         integralLong = 0L;
/*     */       }
/*     */ 
/* 364 */       SystemCreditLevel crlevel = this.systemCreditLevelDAO.calcCreditLevel(Long.valueOf(integralLong));
/* 365 */       uc.setSellerCreditLevel(crlevel.getCreditLevel());
/*     */     }
/*     */ 
/* 369 */     if (UserCreditType.SET_BUYER_CREDIT.getValue().equals(userCreditType)) {
/* 370 */       long integralLong = uc.getBuyCreditNum().longValue() + integral.intValue();
/* 371 */       uc.setBuyCreditNum(Long.valueOf(integralLong));
/* 372 */       if (integralLong <= 0L) {
/* 373 */         integralLong = 0L;
/*     */       }
/* 375 */       SystemCreditLevel crlevel = this.systemCreditLevelDAO.calcCreditLevel(Long.valueOf(integralLong));
/* 376 */       uc.setBuyCreditLevel(crlevel.getCreditLevel());
/*     */     }
/* 378 */     uc.setGmtModify(new Date());
/* 379 */     uc.setModifier(operator);
/*     */ 
/* 381 */     return this.userCreditDAO.updateUserCredit(uc);
/*     */   }
/*     */ 
/*     */   public Long addUserCreditLog(String userAccount, String orderNo, String projectListingCode, Short rankType, Integer integral, Integer serviceAttitude, Integer logisticsSpeed, String memo, String creator, String remark)
/*     */   {
/* 399 */     UserCreditLog record = new UserCreditLog();
/* 400 */     record.setUserAccount(userAccount);
/* 401 */     record.setOrderNo(orderNo);
/* 402 */     record.setProjectListingCode(projectListingCode);
/* 403 */     record.setRankType(rankType);
/* 404 */     record.setRankValue(new Long(integral.intValue()));
/* 405 */     record.setRemark(remark);
/* 406 */     if (serviceAttitude != null) {
/* 407 */       record.setServiceAttitude(Long.valueOf(serviceAttitude.longValue()));
/*     */     }
/* 409 */     if (logisticsSpeed != null) {
/* 410 */       record.setLogisticsSpeed(Long.valueOf(logisticsSpeed.longValue()));
/*     */     }
/* 412 */     record.setMemo(memo);
/* 413 */     record.setCreator(creator);
/* 414 */     return this.userCreditLogDAO.insert(record);
/*     */   }
/*     */ 
/*     */   public void changeUserCredit(String userAccount, String userCreditType, String projectCode, Integer integral, String orderNo, String operator)
/*     */   {
/* 422 */     deductUserCredit(userAccount, userCreditType, integral, operator);
/*     */ 
/* 424 */     Short rankType = Short.valueOf(EnumUserCreditLogRanktype.SET_DEDUCT.getValue());
/* 425 */     String memo = DateUtil.getDateFormat(new Date(), null) + "操作人:" + operator + " 改变用户" + userAccount + "信用" + integral.intValue();
/*     */ 
/* 427 */     addUserCreditLog(userAccount, orderNo, projectCode, rankType, integral, null, null, memo, operator, "投诉工单扣除信用");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.baseset.UserCreditServiceImpl
 * JD-Core Version:    0.6.0
 */