/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumCheckCommonNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemBaseSetErrors;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictErrors;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemServicechargeSpecialType;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemCreditLevelDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemMemberLevelDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumBaseDayResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemCreditLevelRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMemberLevelRequset;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemServicechargeSpecialRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemUserCheckRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.BaseDayServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemCreditLevelServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMemberLevelServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemServicechargeSpecialResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemUserCheckResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemCreditLevel;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemMemberlevelSet;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemServicechargeSpecialExt;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemUserCheck;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.BaseDayService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemCreditLevelService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemDictService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemMemberlevelSetService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemServicechargeSpecialService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemUserCheckService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteSystemBaseService")
/*     */ public class RemoteSystemBaseServiceImpl extends BaseService
/*     */   implements RemoteSystemBaseService
/*     */ {
/*  52 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private SystemDictService systemDictService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemMemberlevelSetService systemMemberlevelSetService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemServicechargeSpecialService systemServicechargeSpecialService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemUserCheckService systemUserCheckService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemCreditLevelService systemCreditLevelService;
/*     */ 
/*     */   @Autowired
/*     */   private BaseDayService baseDayService;
/*     */ 
/*     */   public SystemUserCheckResult getUserUpgradeCheckProcess(SystemUserCheckRequest request)
/*     */   {
/* 103 */     SystemUserCheckResult result = new SystemUserCheckResult();
/*     */     try
/*     */     {
/* 106 */       if ((null == request) || (StringUtil.isEmpty(request.getRoleName())) || (StringUtil.isEmpty(request.getUpgradeRoleName())))
/*     */       {
/* 108 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 109 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 110 */         this.log.error("getProjectBaseSet fail, " + result.getErrorInfo());
/* 111 */         return result;
/*     */       }
/*     */ 
/* 114 */       SystemUserCheck sysUserCheck = this.systemUserCheckService.selectByRole(request.getRoleName());
/*     */ 
/* 116 */       SystemUserCheck sysUserCheckUpdate = this.systemUserCheckService.selectByRole(request.getUpgradeRoleName());
/*     */ 
/* 118 */       String checkProcessCurr = "";
/* 119 */       String checkProcessUp = "";
/* 120 */       String needCheckProcess = "";
/* 121 */       if (null != sysUserCheck) {
/* 122 */         checkProcessCurr = sysUserCheck.getCheckProcess();
/*     */       }
/* 124 */       if (null != sysUserCheckUpdate) {
/* 125 */         checkProcessUp = sysUserCheckUpdate.getCheckProcess();
/*     */       }
/*     */ 
/* 128 */       if (checkProcessUp.length() > checkProcessCurr.length()) {
/* 129 */         checkProcessCurr = checkProcessCurr.endsWith(EnumCheckCommonNodes.END_NODE.getValue()) ? checkProcessCurr.substring(0, checkProcessCurr.length() - 1) : checkProcessCurr;
/*     */ 
/* 132 */         if (checkProcessUp.startsWith(checkProcessCurr)) {
/* 133 */           needCheckProcess = checkProcessUp.substring(checkProcessCurr.length(), checkProcessUp.length());
/*     */         }
/*     */         else {
/* 136 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 137 */           result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 138 */           return result;
/*     */         }
/* 140 */       } else if (checkProcessUp.equalsIgnoreCase(checkProcessCurr)) {
/* 141 */         needCheckProcess = checkProcessUp;
/*     */       } else {
/* 143 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 144 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 145 */         return result;
/*     */       }
/* 147 */       result.setCheckProcess(needCheckProcess);
/*     */     } catch (Exception e) {
/* 149 */       e.printStackTrace();
/* 150 */       this.log.error("getUserUpgradeCheckProcess fail code:" + request.getRoleName() + request.getUpgradeRoleName(), e);
/*     */ 
/* 152 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 153 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/* 155 */     return result;
/*     */   }
/*     */ 
/*     */   public SystemDictServiceResult selectListByKey(SystemDictRequest request)
/*     */   {
/* 193 */     SystemDictServiceResult result = new SystemDictServiceResult();
/* 194 */     String paraCode = request.getParaCode();
/* 195 */     if (StringUtil.isBlank(paraCode)) {
/* 196 */       result.setErrorNO(Integer.valueOf(EnumSystemDictErrors.INPUT_ERROR.getValue()));
/* 197 */       result.setErrorInfo(EnumSystemDictErrors.INPUT_ERROR.getInfo());
/* 198 */       return result;
/*     */     }
/*     */     try {
/* 201 */       List<SystemDict> dictList = this.systemDictService.selectListByKey(paraCode);
/* 202 */       List dictDtoList = new ArrayList();
/* 203 */       if (!dictList.isEmpty()) {
/* 204 */         for (SystemDict dict : dictList) {
/* 205 */           SystemDictDTO dto = new SystemDictDTO();
/* 206 */           BeanUtils.copyProperties(dto, dict);
/* 207 */           dictDtoList.add(dto);
/*     */         }
/*     */       }
/* 210 */       result.setSystemDictList(dictDtoList);
/*     */     } catch (IllegalAccessException e) {
/* 212 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 213 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 214 */       this.logger.error("RemoteSystemBaseServiceImpl.selectListByKey() error:", e);
/*     */     } catch (InvocationTargetException e) {
/* 216 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 217 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 218 */       this.logger.error("RemoteSystemBaseServiceImpl.selectListByKey() error:", e);
/*     */     }
/* 220 */     return result;
/*     */   }
/*     */ 
/*     */   public SystemDictServiceResult selectSingleByKey(SystemDictRequest request)
/*     */   {
/* 229 */     SystemDictServiceResult result = new SystemDictServiceResult();
/* 230 */     String paraCode = request.getParaCode();
/* 231 */     if (StringUtil.isBlank(paraCode)) {
/* 232 */       result.setErrorNO(Integer.valueOf(EnumSystemDictErrors.INPUT_ERROR.getValue()));
/* 233 */       result.setErrorInfo(EnumSystemDictErrors.INPUT_ERROR.getInfo());
/* 234 */       return result;
/*     */     }
/*     */     try {
/* 237 */       SystemDict dict = this.systemDictService.selectSingleByKey(paraCode);
/* 238 */       SystemDictDTO dto = new SystemDictDTO();
/* 239 */       BeanUtils.copyProperties(dto, dict);
/* 240 */       result.setSystemDictDTO(dto);
/*     */     } catch (IllegalAccessException e) {
/* 242 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 243 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 244 */       this.logger.error("RemoteSystemBaseServiceImpl.selectSingleByKey() error:", e);
/*     */     } catch (InvocationTargetException e) {
/* 246 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 247 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 248 */       this.logger.error("RemoteSystemBaseServiceImpl.selectSingleByKey() error:", e);
/*     */     }
/* 250 */     return result;
/*     */   }
/*     */ 
/*     */   public SystemMemberLevelServiceResult selectAllMemberLevel(SystemMemberLevelRequset request)
/*     */   {
/* 260 */     SystemMemberLevelServiceResult result = new SystemMemberLevelServiceResult();
/* 261 */     List list = this.systemMemberlevelSetService.selectAll();
/* 262 */     List dtoList = new ArrayList();
/* 263 */     if (null != list) {
/* 264 */       Iterator iterator = list.iterator();
/* 265 */       while (iterator.hasNext()) {
/* 266 */         SystemMemberLevelDTO dto = new SystemMemberLevelDTO();
/* 267 */         SystemMemberlevelSet sms = (SystemMemberlevelSet)iterator.next();
/*     */         try {
/* 269 */           BeanUtils.copyProperties(dto, sms);
/* 270 */           dtoList.add(dto);
/*     */         } catch (IllegalAccessException e) {
/* 272 */           result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 273 */           result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 274 */           this.logger.error("RemoteSystemBaseServiceImpl selectAllMemberLevel error:", e);
/*     */         } catch (InvocationTargetException e) {
/* 276 */           result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 277 */           result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 278 */           this.logger.error("RemoteSystemBaseServiceImpl selectAllMemberLevel error:", e);
/*     */         }
/*     */       }
/*     */     }
/* 282 */     result.setSystemMemberLevelList(dtoList);
/* 283 */     return result;
/*     */   }
/*     */ 
/*     */   private Long getCurrBigDecimal(String chargeKey, SystemServicechargeSpecialExt ext) {
/*     */     try {
/* 288 */       if (EnumSystemServicechargeSpecialType.LIST_UNTURNOVER.getValue().equals(chargeKey))
/* 289 */         return Long.valueOf(ext.getListUnturnover().longValue());
/* 290 */       if (EnumSystemServicechargeSpecialType.LIST_TURNOVER.getValue().equals(chargeKey))
/*     */       {
/* 292 */         return Long.valueOf(ext.getListTurnover().longValue());
/* 293 */       }if (EnumSystemServicechargeSpecialType.ORDER_UNTURNOVER.getValue().equals(chargeKey))
/*     */       {
/* 295 */         return Long.valueOf(ext.getOrderUnturnover().longValue());
/* 296 */       }if (EnumSystemServicechargeSpecialType.ORDER_TURNOVER.getValue().equals(chargeKey))
/*     */       {
/* 298 */         return Long.valueOf(ext.getOrderTurnover().longValue());
/*     */       }
/* 300 */       return null;
/*     */     } catch (Exception e) {
/*     */     }
/* 303 */     return null;
/*     */   }
/*     */ 
/*     */   public SystemServicechargeSpecialResult selectChargeSpecial(SystemServicechargeSpecialRequest request)
/*     */   {
/* 316 */     SystemServicechargeSpecialResult result = new SystemServicechargeSpecialResult();
/* 317 */     String userAccount = request.getUserAccount();
/* 318 */     String proTypeCode = request.getProTypeCode();
/* 319 */     String tradingType = request.getTradingType();
/* 320 */     String haveAuctioneer = request.getHaveAuctioneer();
/* 321 */     Long turnoverAmount = request.getTurnoverAmount();
/* 322 */     String chargeKey = request.getChargeKey();
/*     */     try
/*     */     {
/* 325 */       List configList = this.systemServicechargeSpecialService.selectChargeSpecialByCond(userAccount, proTypeCode, tradingType, haveAuctioneer, turnoverAmount);
/*     */ 
/* 328 */       if ((null != configList) && (configList.size() > 0))
/* 329 */         for (int i = 0; i < configList.size(); i++) {
/* 330 */           SystemServicechargeSpecialExt ext = (SystemServicechargeSpecialExt)configList.get(i);
/* 331 */           Long bb = getCurrBigDecimal(chargeKey, ext);
/* 332 */           if (bb != null) {
/* 333 */             result.setChargeRate(bb);
/* 334 */             return result;
/*     */           }
/*     */         }
/*     */     }
/*     */     catch (Exception e) {
/* 339 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 340 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 341 */       this.logger.error("RemoteSystemBaseServiceImpl.selectChargeSpecial() error:", e);
/* 342 */       return result;
/*     */     }
/* 344 */     result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.KEY_NOT_DATA.getValue()));
/* 345 */     result.setErrorInfo(EnumSystemBaseSetErrors.KEY_NOT_DATA.getInfo());
/* 346 */     return result;
/*     */   }
/*     */ 
/*     */   public SystemCreditLevelServiceResult selectAllListSystemCreditLevel(SystemCreditLevelRequest request)
/*     */   {
/* 353 */     SystemCreditLevelServiceResult result = new SystemCreditLevelServiceResult();
/* 354 */     List list = this.systemCreditLevelService.selectAllList();
/* 355 */     List dtoList = new ArrayList();
/* 356 */     if (null != list) {
/* 357 */       Iterator iterator = list.iterator();
/* 358 */       while (iterator.hasNext()) {
/* 359 */         SystemCreditLevelDTO dto = new SystemCreditLevelDTO();
/* 360 */         SystemCreditLevel sms = (SystemCreditLevel)iterator.next();
/*     */         try {
/* 362 */           BeanUtils.copyProperties(dto, sms);
/* 363 */           dtoList.add(dto);
/*     */         } catch (IllegalAccessException e) {
/* 365 */           result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 366 */           result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 367 */           this.logger.error("RemoteSystemBaseServiceImpl selectAllList error:", e);
/*     */         } catch (InvocationTargetException e) {
/* 369 */           result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 370 */           result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 371 */           this.logger.error("RemoteSystemBaseServiceImpl selectAllList error:", e);
/*     */         }
/*     */       }
/*     */     }
/* 375 */     result.setSystemCreditLevelList(dtoList);
/* 376 */     return result;
/*     */   }
/*     */ 
/*     */   public SystemCreditLevelServiceResult selectByCreditLevel(SystemCreditLevelRequest request)
/*     */   {
/* 382 */     SystemCreditLevelServiceResult result = new SystemCreditLevelServiceResult();
/* 383 */     String creditLevel = request.getCreditLevel();
/* 384 */     if (StringUtil.isEmpty(creditLevel)) {
/* 385 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.INPUT_ERROR.getValue()));
/* 386 */       result.setErrorInfo(EnumSystemBaseSetErrors.INPUT_ERROR.getInfo());
/* 387 */       return result;
/*     */     }
/* 389 */     SystemCreditLevel systemCreditLevel = this.systemCreditLevelService.selectByCreditLevel(creditLevel);
/*     */ 
/* 391 */     SystemCreditLevelDTO dto = new SystemCreditLevelDTO();
/*     */     try {
/* 393 */       BeanUtils.copyProperties(dto, systemCreditLevel);
/* 394 */       result.setSystemCreditLevelDTO(dto);
/*     */     } catch (IllegalAccessException e) {
/* 396 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 397 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 398 */       this.logger.error("RemoteSystemBaseServiceImpl selectByCreditLevel error:", e);
/*     */     } catch (InvocationTargetException e) {
/* 400 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 401 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 402 */       this.logger.error("RemoteSystemBaseServiceImpl selectByCreditLevel error:", e);
/*     */     }
/* 404 */     return result;
/*     */   }
/*     */ 
/*     */   public SystemCreditLevelServiceResult selectInitCreditLevel(SystemCreditLevelRequest request)
/*     */   {
/* 412 */     SystemCreditLevelServiceResult result = new SystemCreditLevelServiceResult();
/* 413 */     SystemCreditLevel systemCreditLevel = this.systemCreditLevelService.selectInitCreditLevel();
/* 414 */     SystemCreditLevelDTO dto = new SystemCreditLevelDTO();
/*     */     try {
/* 416 */       BeanUtils.copyProperties(dto, systemCreditLevel);
/* 417 */       result.setSystemCreditLevelDTO(dto);
/*     */     } catch (IllegalAccessException e) {
/* 419 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 420 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 421 */       this.logger.error("RemoteSystemBaseServiceImpl selectInitCreditLevel error:", e);
/*     */     } catch (InvocationTargetException e) {
/* 423 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 424 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 425 */       this.logger.error("RemoteSystemBaseServiceImpl selectInitCreditLevel error:", e);
/*     */     }
/* 427 */     return result;
/*     */   }
/*     */ 
/*     */   public SystemCreditLevelServiceResult calcCreditLevel(SystemCreditLevelRequest request)
/*     */   {
/* 436 */     SystemCreditLevelServiceResult result = new SystemCreditLevelServiceResult();
/* 437 */     Long integral = request.getIntegral();
/* 438 */     if (integral == null) {
/* 439 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.INPUT_ERROR.getValue()));
/* 440 */       result.setErrorInfo(EnumSystemBaseSetErrors.INPUT_ERROR.getInfo());
/* 441 */       return result;
/*     */     }
/* 443 */     SystemCreditLevel systemCreditLevel = this.systemCreditLevelService.calcCreditLevel(integral);
/* 444 */     SystemCreditLevelDTO dto = new SystemCreditLevelDTO();
/*     */     try {
/* 446 */       BeanUtils.copyProperties(dto, systemCreditLevel);
/* 447 */       result.setSystemCreditLevelDTO(dto);
/*     */     } catch (IllegalAccessException e) {
/* 449 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 450 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 451 */       this.logger.error("RemoteSystemBaseServiceImpl calcCreditLevel error:", e);
/*     */     } catch (InvocationTargetException e) {
/* 453 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 454 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 455 */       this.logger.error("RemoteSystemBaseServiceImpl calcCreditLevel error:", e);
/*     */     }
/* 457 */     return result;
/*     */   }
/*     */ 
/*     */   public SystemDictServiceResult selectLiquidatedDamages(SystemDictRequest request)
/*     */   {
/* 465 */     return selectSingleByKey(request);
/*     */   }
/*     */ 
/*     */   public SystemDictServiceResult selectIntegralRule(SystemDictRequest request)
/*     */   {
/* 473 */     return selectSingleByKey(request);
/*     */   }
/*     */ 
/*     */   public BaseDayServiceResult selectBaseTradeDay()
/*     */   {
/* 483 */     BaseDayServiceResult result = new BaseDayServiceResult();
/*     */     try {
/* 485 */       result = this.baseDayService.selectBaseTradeDay();
/*     */     } catch (Exception e) {
/* 487 */       this.log.error("", e);
/* 488 */       result.setErrorNOInfo(Integer.valueOf(EnumBaseDayResultErrors.INTERNAL_ERROR.getValue()), EnumBaseDayResultErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/*     */ 
/* 491 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteSystemBaseServiceImpl
 * JD-Core Version:    0.6.0
 */