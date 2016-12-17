/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumCheckCommonNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectBaseSettingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumProjectErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectBaseSettingRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectBaseSettingServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectBaseSettingService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectBaseSetting;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectBaseSettingService;
/*     */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteProjectBaseSettingService")
/*     */ public class RemoteProjectBaseSettingServiceImpl extends BaseService
/*     */   implements RemoteProjectBaseSettingService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectBaseSettingService projectBaseSettingService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   public ProjectBaseSettingServiceResult getProjectBaseSet(ProjectBaseSettingRequest request)
/*     */   {
/*  48 */     ProjectBaseSettingServiceResult result = new ProjectBaseSettingServiceResult();
/*     */     try
/*     */     {
/*  51 */       if (null == request) {
/*  52 */         result.setErrorNO(Integer.valueOf(EnumProjectErrors.PARAMETER_ERROR.getValue()));
/*  53 */         result.setErrorInfo(EnumProjectErrors.PARAMETER_ERROR.getInfo());
/*  54 */         this.log.error("getProjectBaseSet fail, " + result.getErrorInfo());
/*  55 */         return result;
/*     */       }
/*  57 */       if ((StringUtil.isEmpty(request.getProTypeCode())) && (StringUtil.isEmpty(request.getTradingType())) && (StringUtil.isEmpty(request.getMemberLevel())) && (request.getGoodComment() == null) && (request.getBadComment() == null))
/*     */       {
/*  60 */         result.setErrorNO(Integer.valueOf(EnumProjectErrors.PARAMETER_ERROR.getValue()));
/*  61 */         result.setErrorInfo(EnumProjectErrors.PARAMETER_ERROR.getInfo());
/*  62 */         this.log.error("getProjectBaseSet fail, " + result.getErrorInfo());
/*  63 */         return result;
/*     */       }
/*     */ 
/*  67 */       Map parasMap = new HashMap();
/*  68 */       parasMap.put("proTypeCode", request.getProTypeCode());
/*  69 */       parasMap.put("tradingType", request.getTradingType());
/*  70 */       parasMap.put("memberLevel", request.getMemberLevel());
/*  71 */       parasMap.put("goodComment", request.getGoodComment());
/*  72 */       parasMap.put("badComment", request.getBadComment());
/*     */ 
/*  75 */       ProjectBaseSetting proBSet = getBaseSetByLevel(parasMap);
/*  76 */       ProjectBaseSettingDTO dto = new ProjectBaseSettingDTO();
/*  77 */       if (proBSet != null) {
/*  78 */         dto = ConvertUtils.convertPBS2PBSDTO(proBSet);
/*     */ 
/*  80 */         result.setProjectBaseSettingDTO(dto);
/*     */       }
/*     */ 
/*  85 */       setSystemDefault(request.getDictParaCode(), result, dto);
/*     */     } catch (Exception e) {
/*  87 */       e.printStackTrace();
/*  88 */       this.log.error("getProjectBaseSet fail code:" + request.getProTypeCode(), e);
/*  89 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/*  90 */       result.setErrorInfo(EnumProjectErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/*  92 */     return result;
/*     */   }
/*     */ 
/*     */   private ProjectBaseSetting getBaseSetByLevel(Map<String, Object> parasMap)
/*     */   {
/* 104 */     ProjectBaseSetting proBSet = new ProjectBaseSetting();
/* 105 */     List list = this.projectBaseSettingService.selectBaseSetList(parasMap);
/* 106 */     if ((list == null) || (list.size() < 1)) {
/* 107 */       return null;
/*     */     }
/* 109 */     Iterator it = list.iterator();
/* 110 */     int num = 0;
/* 111 */     while (it.hasNext()) {
/* 112 */       ProjectBaseSetting tmpBS = (ProjectBaseSetting)it.next();
/* 113 */       if (tmpBS != null) {
/* 114 */         if ((StringUtil.isEmpty(proBSet.getIntentionCheckProcess())) && (StringUtil.isNotEmpty(tmpBS.getIntentionCheckProcess()))) {
/* 115 */           proBSet.setIntentionCheckProcess(tmpBS.getIntentionCheckProcess());
/* 116 */           num++;
/*     */         }
/* 118 */         if ((StringUtil.isEmpty(proBSet.getListingCheckProcess())) && (StringUtil.isNotEmpty(tmpBS.getListingCheckProcess()))) {
/* 119 */           proBSet.setListingCheckProcess(tmpBS.getListingCheckProcess());
/* 120 */           num++;
/*     */         }
/* 122 */         if ((proBSet.getListingJsProportion() == null) && (tmpBS.getListingJsProportion() != null)) {
/* 123 */           proBSet.setListingJsProportion(tmpBS.getListingJsProportion());
/* 124 */           num++;
/*     */         }
/* 126 */         if ((proBSet.getListingJyProportion() == null) && (tmpBS.getListingJyProportion() != null)) {
/* 127 */           proBSet.setListingJyProportion(tmpBS.getListingJyProportion());
/* 128 */           num++;
/*     */         }
/* 130 */         if ((proBSet.getOrderJsProportion() == null) && (tmpBS.getOrderJsProportion() != null)) {
/* 131 */           proBSet.setOrderJsProportion(tmpBS.getOrderJsProportion());
/* 132 */           num++;
/*     */         }
/* 134 */         if ((proBSet.getOrderJyProportion() == null) && (tmpBS.getOrderJyProportion() != null)) {
/* 135 */           proBSet.setOrderJyProportion(tmpBS.getOrderJyProportion());
/* 136 */           num++;
/*     */         }
/*     */       }
/*     */ 
/* 140 */       if (num == 6)
/*     */       {
/*     */         break;
/*     */       }
/*     */     }
/* 145 */     return proBSet;
/*     */   }
/*     */ 
/*     */   private void setSystemDefault(String dictParaCode, ProjectBaseSettingServiceResult result, ProjectBaseSettingDTO dto)
/*     */   {
/* 157 */     SystemDictRequest dictRequest = new SystemDictRequest();
/* 158 */     SystemDictServiceResult dictResult = new SystemDictServiceResult();
/*     */ 
/* 161 */     EnumSystemDictKey dictEnum = EnumSystemDictKey.indexByValue(dictParaCode);
/* 162 */     if (((StringUtil.isEmpty(dictParaCode)) || (dictEnum.getValue().equals(EnumSystemDictKey.LIST_AUDITPROCESS.getValue()))) && 
/* 163 */       (StringUtil.isEmpty(dto.getListingCheckProcess()))) {
/* 164 */       dictRequest.setParaCode(EnumSystemDictKey.LIST_AUDITPROCESS.getValue());
/* 165 */       dictResult = this.remoteSystemBaseService.selectSingleByKey(dictRequest);
/* 166 */       if (dictResult.correct()) {
/* 167 */         SystemDictDTO dictDto = dictResult.getSystemDictDTO();
/* 168 */         String paraV = dictDto.getParaValue();
/* 169 */         if (StringUtil.isNotEmpty(paraV)) {
/* 170 */           paraV = paraV + EnumCheckCommonNodes.END_NODE.getValue();
/* 171 */           dto.setListingCheckProcess(paraV);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 176 */     if (((StringUtil.isEmpty(dictParaCode)) || (dictEnum.getValue().equals(EnumSystemDictKey.INTENTION_AUDITPROCESS.getValue()))) && 
/* 177 */       (StringUtil.isEmpty(dto.getIntentionCheckProcess()))) {
/* 178 */       dictRequest.setParaCode(EnumSystemDictKey.INTENTION_AUDITPROCESS.getValue());
/* 179 */       dictResult = this.remoteSystemBaseService.selectSingleByKey(dictRequest);
/* 180 */       if (dictResult.correct()) {
/* 181 */         SystemDictDTO dictDto = dictResult.getSystemDictDTO();
/* 182 */         String paraV = dictDto.getParaValue();
/* 183 */         if (StringUtil.isNotEmpty(paraV)) {
/* 184 */           paraV = paraV + EnumCheckCommonNodes.END_NODE.getValue();
/* 185 */           dto.setIntentionCheckProcess(paraV);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 190 */     if (((StringUtil.isEmpty(dictParaCode)) || (dictEnum.getValue().equals(EnumSystemDictKey.LISTING_JY_PROPORTION.getValue()))) && 
/* 191 */       (dto.getListingJyProportion() == null)) {
/* 192 */       dictRequest.setParaCode(EnumSystemDictKey.LISTING_JY_PROPORTION.getValue());
/* 193 */       dictResult = this.remoteSystemBaseService.selectSingleByKey(dictRequest);
/* 194 */       if (dictResult.correct()) {
/* 195 */         SystemDictDTO dictDto = dictResult.getSystemDictDTO();
/* 196 */         String paraV = dictDto.getParaValue();
/* 197 */         if (StringUtil.isNotEmpty(paraV)) {
/* 198 */           Long doubleparaV = Long.valueOf(Long.parseLong(paraV));
/* 199 */           dto.setListingJyProportion(doubleparaV);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 204 */     if (((StringUtil.isEmpty(dictParaCode)) || (dictEnum.getValue().equals(EnumSystemDictKey.LISTING_JS_PROPORTION.getValue()))) && 
/* 205 */       (dto.getListingJsProportion() == null)) {
/* 206 */       dictRequest.setParaCode(EnumSystemDictKey.LISTING_JS_PROPORTION.getValue());
/* 207 */       dictResult = this.remoteSystemBaseService.selectSingleByKey(dictRequest);
/* 208 */       if (dictResult.correct()) {
/* 209 */         SystemDictDTO dictDto = dictResult.getSystemDictDTO();
/* 210 */         String paraV = dictDto.getParaValue();
/* 211 */         if (StringUtil.isNotEmpty(paraV)) {
/* 212 */           Long doubleparaV = Long.valueOf(Long.parseLong(paraV));
/* 213 */           dto.setListingJsProportion(doubleparaV);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 218 */     if (((StringUtil.isEmpty(dictParaCode)) || (dictEnum.getValue().equals(EnumSystemDictKey.ORDER_JY_PROPORTION.getValue()))) && 
/* 219 */       (dto.getOrderJyProportion() == null)) {
/* 220 */       dictRequest.setParaCode(EnumSystemDictKey.ORDER_JY_PROPORTION.getValue());
/* 221 */       dictResult = this.remoteSystemBaseService.selectSingleByKey(dictRequest);
/* 222 */       if (dictResult.correct()) {
/* 223 */         SystemDictDTO dictDto = dictResult.getSystemDictDTO();
/* 224 */         String paraV = dictDto.getParaValue();
/* 225 */         if (StringUtil.isNotEmpty(paraV)) {
/* 226 */           Long doubleparaV = Long.valueOf(Long.parseLong(paraV));
/* 227 */           dto.setOrderJyProportion(doubleparaV);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 232 */     if (((StringUtil.isEmpty(dictParaCode)) || (dictEnum.getValue().equals(EnumSystemDictKey.ORDER_JS_PROPORTION.getValue()))) && 
/* 233 */       (dto.getOrderJsProportion() == null)) {
/* 234 */       dictRequest.setParaCode(EnumSystemDictKey.ORDER_JS_PROPORTION.getValue());
/* 235 */       dictResult = this.remoteSystemBaseService.selectSingleByKey(dictRequest);
/* 236 */       if (dictResult.correct()) {
/* 237 */         SystemDictDTO dictDto = dictResult.getSystemDictDTO();
/* 238 */         String paraV = dictDto.getParaValue();
/* 239 */         if (StringUtil.isNotEmpty(paraV)) {
/* 240 */           Long doubleparaV = Long.valueOf(Long.parseLong(paraV));
/* 241 */           dto.setOrderJsProportion(doubleparaV);
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 250 */     result.setProjectBaseSettingDTO(dto);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteProjectBaseSettingServiceImpl
 * JD-Core Version:    0.6.0
 */