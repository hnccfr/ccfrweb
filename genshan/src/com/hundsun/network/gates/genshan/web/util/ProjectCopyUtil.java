/*     */ package com.hundsun.network.gates.genshan.web.util;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetasBO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTradeBO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.PackageTradeData;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPlaceOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CopyUtil;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectMetasDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeAttriDTO;
/*     */ import com.hundsun.network.melody.common.util.Money;
/*     */ import java.io.PrintStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class ProjectCopyUtil
/*     */ {
/*     */   public static void copyProperties(List<ProjectMetasDTO> projectMetasDTOList, List<ProjectMetas> projectMetasList)
/*     */   {
/*  53 */     for (Object obj : projectMetasDTOList) {
/*  54 */       ProjectMetas projectMetas = new ProjectMetas();
/*  55 */       CopyUtil.copyProperties(obj, projectMetas);
/*  56 */       projectMetasList.add(projectMetas);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyMetasList2DTOList(List<ProjectMetas> projectMetasList, List<ProjectMetasDTO> projectMetasDTOList)
/*     */   {
/*  67 */     for (Object obj : projectMetasList) {
/*  68 */       ProjectMetasDTO projectMetasDTO = new ProjectMetasDTO();
/*  69 */       CopyUtil.copyProperties(obj, projectMetasDTO);
/*     */ 
/*  71 */       projectMetasDTOList.add(projectMetasDTO);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyProperties(List<TradeShowDTO> list, ProjectListing projectListing)
/*     */     throws com.hundsun.network.melody.common.util.html.parse.ParseException, Exception
/*     */   {
/*  78 */     CopyUtil.copyProperties(getTradeMap(list), projectListing);
/*     */   }
/*     */ 
/*     */   public static ProjectListing copyTradeShowDTOList2ProjectListing(List<TradeShowDTO> list, ProjectListing projectListing)
/*     */     throws java.text.ParseException
/*     */   {
/*  85 */     String listingPrice = "";
/*  86 */     for (TradeShowDTO tradeShowDTO : list) {
/*  87 */       if ("projectName".equals(tradeShowDTO.getKey())) {
/*  88 */         projectListing.setTitle(tradeShowDTO.getInputValue());
/*  89 */         continue;
/*     */       }
/*  91 */       if ("projectCode".equals(tradeShowDTO.getKey())) {
/*  92 */         projectListing.setCode(tradeShowDTO.getInputValue());
/*  93 */         continue;
/*     */       }
/*  95 */       if ("tradeType".equals(tradeShowDTO.getKey())) {
/*  96 */         projectListing.setTradingType(tradeShowDTO.getInputValue());
/*  97 */         continue;
/*     */       }
/*  99 */       if ("listingType".equals(tradeShowDTO.getKey())) {
/* 100 */         projectListing.setListingType(tradeShowDTO.getInputValue());
/* 101 */         continue;
/*     */       }
/* 103 */       if ("retail".equals(tradeShowDTO.getKey())) {
/* 104 */         projectListing.setRetail(tradeShowDTO.getInputValue());
/* 105 */         continue;
/*     */       }
/* 107 */       if ("listingPrice".equals(tradeShowDTO.getKey())) {
/* 108 */         listingPrice = tradeShowDTO.getInputValue();
/* 109 */         continue;
/*     */       }
/* 111 */       if ("quantity".equals(tradeShowDTO.getKey())) {
/* 112 */         projectListing.setQuantity(Long.valueOf(tradeShowDTO.getInputValue()));
/* 113 */         continue;
/*     */       }
/* 115 */       if ("userAccount".equals(tradeShowDTO.getKey())) {
/* 116 */         projectListing.setUserAccount(tradeShowDTO.getInputValue());
/* 117 */         continue;
/*     */       }
/* 119 */       if ("multipleBase".equals(tradeShowDTO.getKey())) {
/* 120 */         projectListing.setMultipleBase(Long.valueOf(tradeShowDTO.getInputValue()));
/* 121 */         continue;
/*     */       }
/* 123 */       if ("maxQuantity".equals(tradeShowDTO.getKey())) {
/* 124 */         projectListing.setMaxQuantity(Long.valueOf(tradeShowDTO.getInputValue()));
/* 125 */         continue;
/*     */       }
/* 127 */       if ("minQuantity".equals(tradeShowDTO.getKey())) {
/* 128 */         projectListing.setMinQuantity(Long.valueOf(tradeShowDTO.getInputValue()));
/* 129 */         continue;
/*     */       }
/* 131 */       if ("listingStartTime".equals(tradeShowDTO.getKey())) {
/* 132 */         projectListing.setListingStartTime(DateUtil.convertStringToDate(tradeShowDTO.getInputValue()));
/*     */ 
/* 134 */         continue;
/*     */       }
/* 136 */       if ("listingEndTime".equals(tradeShowDTO.getKey())) {
/* 137 */         projectListing.setListingEndTime(DateUtil.convertStringToDate(tradeShowDTO.getInputValue()));
/*     */ 
/* 139 */         continue;
/*     */       }
/* 141 */       if ("valuationUnit".equals(tradeShowDTO.getKey())) {
/* 142 */         projectListing.setValuationUnit(tradeShowDTO.getInputValue());
/* 143 */         continue;
/*     */       }
/* 145 */       if ("measureUnit".equals(tradeShowDTO.getKey())) {
/* 146 */         projectListing.setMeasureUnit(tradeShowDTO.getInputValue());
/* 147 */         continue;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 155 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static HashMap<String, String> getTradeMap(List<TradeShowDTO> list)
/*     */     throws com.hundsun.network.melody.common.util.html.parse.ParseException
/*     */   {
/* 161 */     HashMap map = new HashMap();
/* 162 */     for (TradeShowDTO tradeShowDTO : list) {
/* 163 */       if ((tradeShowDTO != null) && (tradeShowDTO.getKey() != null))
/* 164 */         map.put(tradeShowDTO.getKey(), tradeShowDTO.getInputValue());
/*     */     }
/* 166 */     return map;
/*     */   }
/*     */ 
/*     */   public static ProjectMetasBO copyProjectTradeBO2ProjectMetasBO(ProjectTradeBO tradeBo, ProjectMetasBO metasBo)
/*     */   {
/* 176 */     List metas = metasBo.getMetas();
/* 177 */     Long projectId = null;
/* 178 */     Date gmtCreate = null;
/* 179 */     Date gmtModify = null;
/* 180 */     String operator = null;
/* 181 */     if ((metas != null) && (metas.size() > 0)) {
/* 182 */       projectId = ((ProjectMetas)metas.get(0)).getProjectId() == null ? null : ((ProjectMetas)metas.get(0)).getProjectId();
/* 183 */       gmtCreate = ((ProjectMetas)metas.get(0)).getGmtCreate();
/* 184 */       gmtModify = ((ProjectMetas)metas.get(0)).getGmtModify();
/* 185 */       operator = ((ProjectMetas)metas.get(0)).getOperator();
/*     */     }
/* 187 */     List<TradeShowDTO> tradeMetas = new ArrayList();
/* 188 */     tradeMetas = tradeBo.getTradeMetas();
/* 189 */     for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 190 */       metas.add(copyTradeShowDTO2ProjectMetas(projectId, gmtCreate, gmtModify, operator, tradeShowDTO));
/*     */     }
/*     */ 
/* 193 */     return metasBo;
/*     */   }
/*     */ 
/*     */   private static ProjectMetas copyTradeShowDTO2ProjectMetas(Long projectId, Date gmtCreate, Date gmtModify, String operator, TradeShowDTO tradeShowDTO)
/*     */   {
/* 199 */     ProjectMetas metas = new ProjectMetas();
/* 200 */     metas.setProjectId(projectId);
/* 201 */     metas.setGmtCreate(gmtCreate);
/* 202 */     metas.setGmtModify(gmtModify);
/* 203 */     metas.setOperator(operator);
/* 204 */     metas.setInputType(tradeShowDTO.getShowType());
/* 205 */     metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 206 */     metas.setMetaKey(tradeShowDTO.getKey());
/* 207 */     metas.setMetaTitle(tradeShowDTO.getName());
/* 208 */     metas.setMetaValue(tradeShowDTO.getInputValue());
/* 209 */     return metas;
/*     */   }
/*     */ 
/*     */   private static ProjectMetasDTO copyTradeShowDTO2ProjectMetasDTO(Long projectId, Date gmtCreate, Date gmtModify, String operator, TradeShowDTO tradeShowDTO)
/*     */   {
/* 216 */     ProjectMetasDTO metasDTO = new ProjectMetasDTO();
/* 217 */     metasDTO.setProjectId(projectId);
/* 218 */     metasDTO.setGmtCreate(gmtCreate);
/* 219 */     metasDTO.setGmtModify(gmtModify);
/* 220 */     metasDTO.setOperator(operator);
/* 221 */     metasDTO.setInputType(tradeShowDTO.getShowType());
/* 222 */     metasDTO.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 223 */     metasDTO.setMetaKey(tradeShowDTO.getKey());
/* 224 */     metasDTO.setMetaTitle(tradeShowDTO.getName());
/* 225 */     metasDTO.setMetaValue(tradeShowDTO.getInputValue());
/* 226 */     return metasDTO;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 230 */     Money money = new Money();
/* 231 */     BigDecimal gb = new BigDecimal("2.1234567");
/* 232 */     Long p = Long.valueOf(gb.movePointRight(EnumValuationUnit.WANYUAN.getScale()).longValue());
/* 233 */     System.out.println(p);
/* 234 */     System.out.println();
/* 235 */     System.out.println(gb.longValue());
/* 236 */     money.setCent(EnumValuationUnit.WANYUAN.getRate().longValue());
/* 237 */     System.out.println(money.multiply(gb).getCent());
/*     */   }
/*     */ 
/*     */   public static void copyProjectTypeAttriDTOListAdd2ProjectTypeAttriList(List<ProjectTypeAttriDTO> projectTypeAttriDTOList, List<ProjectTypeAttri> projectTypeAttriLIst)
/*     */   {
/* 249 */     for (ProjectTypeAttriDTO projectTypeAttriDTO : projectTypeAttriDTOList) {
/* 250 */       ProjectTypeAttri projectTypeAttri = new ProjectTypeAttri();
/* 251 */       if (projectTypeAttriDTO != null) {
/* 252 */         ConvertUtils.convertProjectTypeAttriDTO2ProjectTypeAttri(projectTypeAttriDTO, projectTypeAttri);
/*     */ 
/* 254 */         if ((projectTypeAttriLIst == null) || (projectTypeAttriLIst.size() < 0)) {
/* 255 */           projectTypeAttriLIst = new ArrayList();
/*     */         }
/* 257 */         projectTypeAttriLIst.add(projectTypeAttri);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyProjectListing2ProjectMetasList(ProjectListing projectListing, List<ProjectMetas> projectMetasList)
/*     */   {
/* 272 */     List<TradeShowDTO> tslist = null;
/* 273 */     if (projectListing != null) {
/* 274 */       ProjectListingDTO plDto = new ProjectListingDTO();
/* 275 */       plDto.setListingType(projectListing.getListingType());
/* 276 */       tslist = PackageTradeData.getPlaceOrderShowDTO(plDto);
/*     */     }
/* 278 */     if ((projectListing != null) && (projectListing.getRetail() != null)) {
/* 279 */       ProjectMetas metas = new ProjectMetas();
/* 280 */       metas.setProjectId(projectListing.getId());
/* 281 */       metas.setGmtCreate(projectListing.getGmtCreate());
/* 282 */       metas.setGmtModify(projectListing.getGmtModify());
/* 283 */       metas.setOperator(projectListing.getOperator());
/* 284 */       for (TradeShowDTO tradeShowDTO : tslist) {
/* 285 */         if (tradeShowDTO.getKey().equals("retail")) {
/* 286 */           metas.setInputType(tradeShowDTO.getShowType());
/* 287 */           metas.setMetaValue(projectListing.getRetail());
/* 288 */           metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 289 */           metas.setMetaKey(tradeShowDTO.getKey());
/* 290 */           metas.setMetaTitle(tradeShowDTO.getName());
/*     */ 
/* 292 */           break;
/*     */         }
/*     */       }
/* 295 */       projectMetasList.add(metas);
/*     */     }
/* 297 */     if ((projectListing != null) && (projectListing.getMultipleBase() != null)) {
/* 298 */       ProjectMetas metas = new ProjectMetas();
/* 299 */       metas.setProjectId(projectListing.getId());
/* 300 */       metas.setGmtCreate(projectListing.getGmtCreate());
/* 301 */       metas.setGmtModify(projectListing.getGmtModify());
/* 302 */       metas.setOperator(projectListing.getOperator());
/* 303 */       for (TradeShowDTO tradeShowDTO : tslist) {
/* 304 */         if (tradeShowDTO.getKey().equals("multipleBase")) {
/* 305 */           metas.setInputType(tradeShowDTO.getShowType());
/* 306 */           metas.setMetaValue(projectListing.getMultipleBase().toString());
/* 307 */           metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 308 */           metas.setMetaKey(tradeShowDTO.getKey());
/* 309 */           metas.setMetaTitle(tradeShowDTO.getName());
/*     */ 
/* 311 */           break;
/*     */         }
/*     */       }
/* 314 */       projectMetasList.add(metas);
/*     */     }
/* 316 */     if ((projectListing != null) && (projectListing.getMinQuantity() != null)) {
/* 317 */       ProjectMetas metas = new ProjectMetas();
/* 318 */       metas.setProjectId(projectListing.getId());
/* 319 */       metas.setGmtCreate(projectListing.getGmtCreate());
/* 320 */       metas.setGmtModify(projectListing.getGmtModify());
/* 321 */       metas.setOperator(projectListing.getOperator());
/* 322 */       for (TradeShowDTO tradeShowDTO : tslist) {
/* 323 */         if (tradeShowDTO.getKey().equals("minQuantity")) {
/* 324 */           metas.setInputType(tradeShowDTO.getShowType());
/* 325 */           metas.setMetaValue(projectListing.getMinQuantity().toString());
/* 326 */           metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 327 */           metas.setMetaKey(tradeShowDTO.getKey());
/* 328 */           metas.setMetaTitle(tradeShowDTO.getName());
/*     */ 
/* 330 */           break;
/*     */         }
/*     */       }
/* 333 */       projectMetasList.add(metas);
/*     */     }
/* 335 */     if ((projectListing != null) && (projectListing.getMaxQuantity() != null)) {
/* 336 */       ProjectMetas metas = new ProjectMetas();
/* 337 */       metas.setProjectId(projectListing.getId());
/* 338 */       metas.setGmtCreate(projectListing.getGmtCreate());
/* 339 */       metas.setGmtModify(projectListing.getGmtModify());
/* 340 */       metas.setOperator(projectListing.getOperator());
/* 341 */       for (TradeShowDTO tradeShowDTO : tslist) {
/* 342 */         if (tradeShowDTO.getKey().equals("maxQuantity")) {
/* 343 */           metas.setInputType(tradeShowDTO.getShowType());
/* 344 */           metas.setMetaValue(projectListing.getMaxQuantity().toString());
/* 345 */           metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 346 */           metas.setMetaKey(tradeShowDTO.getKey());
/* 347 */           metas.setMetaTitle(tradeShowDTO.getName());
/*     */ 
/* 349 */           break;
/*     */         }
/*     */       }
/* 352 */       projectMetasList.add(metas);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static ProjectMetas[] copyTradeShowDTOArrayAdd2ProjectMetasArray(Long projectId, Date gmtCreate, Date gmtModify, String operator, List<TradeShowDTO> tradeMetas, ProjectMetas[] metaValues)
/*     */   {
/* 369 */     ProjectMetas[] newMetaValues = new ProjectMetas[(tradeMetas == null ? 0 : tradeMetas.size()) + (metaValues == null ? 0 : metaValues.length)];
/*     */ 
/* 372 */     int i = 0;
/* 373 */     if ((metaValues != null) && (metaValues.length > 0)) {
/* 374 */       for (; i < metaValues.length; i++) {
/* 375 */         newMetaValues[i] = metaValues[i];
/*     */       }
/*     */     }
/* 378 */     if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 379 */       for (int j = 0 + (metaValues == null ? 0 : metaValues.length); j < tradeMetas.size(); j++) {
/* 380 */         if (i + j > 1) {
/* 381 */           newMetaValues[(i + j - 1)] = copyTradeShowDTO2ProjectMetas(projectId, gmtCreate, gmtModify, operator, (TradeShowDTO)tradeMetas.get(j));
/*     */         }
/*     */         else {
/* 384 */           newMetaValues[j] = copyTradeShowDTO2ProjectMetas(projectId, gmtCreate, gmtModify, operator, (TradeShowDTO)tradeMetas.get(j));
/*     */         }
/*     */       }
/*     */     }
/* 388 */     return newMetaValues;
/*     */   }
/*     */ 
/*     */   public static ProjectMetas[] copyTradeShowDTOArrayAdd2ProjectMetasArray(Long projectId, Date gmtCreate, Date gmtModify, String operator, ProjectMetas[] metaValues, ProjectTradeBO tradeBo)
/*     */   {
/* 398 */     return copyTradeShowDTOArrayAdd2ProjectMetasArray(projectId, gmtCreate, gmtModify, operator, tradeBo.getTradeMetas(), metaValues);
/*     */   }
/*     */ 
/*     */   public static void copyTradeShowDTOArrayAdd2ProjectMetasArray(ProjectListing projectListing, ProjectTradeBO tradeBo)
/*     */   {
/* 410 */     projectListing.setMetaValues(copyTradeShowDTOArrayAdd2ProjectMetasArray(projectListing.getId(), projectListing.getGmtCreate(), projectListing.getGmtModify(), projectListing.getOperator(), projectListing.getMetaValues(), tradeBo));
/*     */   }
/*     */ 
/*     */   public static void copyTradeShowDTOArrayAdd2ProjectListing(ProjectListing projectListing, ProjectTradeBO tradeBo)
/*     */   {
/* 421 */     if ((tradeBo != null) && (tradeBo.getTradeMetas() != null))
/* 422 */       for (TradeShowDTO tradeShowDTO : tradeBo.getTradeMetas()) {
/* 423 */         if ("multipleBase".equals(tradeShowDTO.getKey()))
/* 424 */           projectListing.setMultipleBase(Long.valueOf(tradeShowDTO.getInputValue()));
/* 425 */         if ("maxQuantity".equals(tradeShowDTO.getKey()))
/* 426 */           projectListing.setMaxQuantity(Long.valueOf(tradeShowDTO.getInputValue()));
/* 427 */         if ("minQuantity".equals(tradeShowDTO.getKey()))
/* 428 */           projectListing.setMinQuantity(Long.valueOf(tradeShowDTO.getInputValue()));
/* 429 */         if ("retail".equals(tradeShowDTO.getKey()))
/* 430 */           projectListing.setRetail(tradeShowDTO.getInputValue());
/*     */       }
/*     */   }
/*     */ 
/*     */   public static void convertProjectTypeAttrList2Map(List<ProjectTypeAttri> projectTypeAttriList, HashMap<String, ProjectTypeAttri> map)
/*     */   {
/* 443 */     if (projectTypeAttriList != null)
/* 444 */       for (int i = 0; i < projectTypeAttriList.size(); i++) {
/* 445 */         ProjectTypeAttri projectTypeAttri = (ProjectTypeAttri)projectTypeAttriList.get(i);
/* 446 */         map.put(projectTypeAttri.getKeyName(), projectTypeAttri);
/*     */       }
/*     */   }
/*     */ 
/*     */   public static void copyTradeMetasList2Map(List<TradeShowDTO> tradeMetas, Map<String, String> metaSubmitValue)
/*     */   {
/* 459 */     if ((tradeMetas != null) && (tradeMetas.size() > 0))
/* 460 */       for (TradeShowDTO tradeShowDTO : tradeMetas)
/* 461 */         if ((tradeShowDTO != null) && (tradeShowDTO.getKey() != null))
/* 462 */           metaSubmitValue.put(tradeShowDTO.getKey(), tradeShowDTO.getInputValue());
/*     */   }
/*     */ 
/*     */   public static void copyProjectMetasList2Map(ProjectMetas[] metaValues, Map<String, String> metaSubmitValue)
/*     */   {
/* 474 */     if ((metaValues != null) && (metaValues.length > 0))
/* 475 */       for (ProjectMetas projectMetas : metaValues)
/* 476 */         if ((projectMetas != null) && (projectMetas.getMetaKey() != null))
/* 477 */           metaSubmitValue.put(projectMetas.getMetaKey(), projectMetas.getMetaValue());
/*     */   }
/*     */ 
/*     */   public static List<ProjectMetasDTO> convertTradeShowDTOList2TradeMetasList(Long projectId, Date gmtCreate, Date gmtModify, String operator, List<TradeShowDTO> tradeMetas)
/*     */   {
/* 493 */     List tradeShowDTOList = new ArrayList();
/* 494 */     if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 495 */       for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 496 */         tradeShowDTOList.add(copyTradeShowDTO2ProjectMetasDTO(projectId, gmtCreate, gmtModify, operator, tradeShowDTO));
/*     */       }
/*     */     }
/*     */ 
/* 500 */     return tradeShowDTOList;
/*     */   }
/*     */ 
/*     */   public static void hiddenTradeMetas(ProjectListing projectListing, HashMap<String, String> map)
/*     */   {
/* 508 */     if ((projectListing != null) && (map != null) && 
/* 509 */       (projectListing.getTradeMeta() != null) && (projectListing.getTradeMeta().size() > 0)) {
/* 510 */       List metaList = new ArrayList();
/* 511 */       for (AttriMeta ameta : projectListing.getTradeMeta()) {
/* 512 */         if (!map.containsKey(ameta.getMeta().getMetaKey())) {
/* 513 */           metaList.add(ameta);
/*     */         }
/*     */       }
/* 516 */       projectListing.setTradeMeta(metaList);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyProjectTradeBO2ProjectListing(ProjectTradeBO tradeBo, ProjectListing projectListing)
/*     */   {
/* 528 */     if ((tradeBo != null) && (tradeBo.getTradeMetas() != null) && (projectListing != null) && (tradeBo.getTradeMetas().size() > 0) && (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())))
/*     */     {
/*     */       try
/*     */       {
/* 532 */         HashMap map = getTradeMap(tradeBo.getTradeMetas());
/* 533 */         projectListing.setRetail((String)map.get(EnumPlaceOrderProperty.RETAIL.getKey()));
/* 534 */         projectListing.setMultipleBase(Long.valueOf((String)map.get(EnumPlaceOrderProperty.MULTIPLE_BASE.getKey())));
/*     */ 
/* 536 */         projectListing.setMinQuantity(Long.valueOf((String)map.get(EnumPlaceOrderProperty.MIN_QUANTITY.getKey())));
/*     */ 
/* 538 */         projectListing.setMaxQuantity(Long.valueOf((String)map.get(EnumPlaceOrderProperty.MAX_QUANTITY.getKey())));
/*     */       }
/*     */       catch (com.hundsun.network.melody.common.util.html.parse.ParseException e) {
/* 541 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.util.ProjectCopyUtil
 * JD-Core Version:    0.6.0
 */