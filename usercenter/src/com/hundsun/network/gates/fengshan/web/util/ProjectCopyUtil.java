/*     */ package com.hundsun.network.gates.fengshan.web.util;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetasBO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTradeBO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.PackageTradeData;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPlaceOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CopyUtil;
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
/*  52 */     for (Object obj : projectMetasDTOList) {
/*  53 */       ProjectMetas projectMetas = new ProjectMetas();
/*  54 */       CopyUtil.copyProperties(obj, projectMetas);
/*  55 */       projectMetasList.add(projectMetas);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyMetasList2DTOList(List<ProjectMetas> projectMetasList, List<ProjectMetasDTO> projectMetasDTOList)
/*     */   {
/*  66 */     for (Object obj : projectMetasList) {
/*  67 */       ProjectMetasDTO projectMetasDTO = new ProjectMetasDTO();
/*  68 */       CopyUtil.copyProperties(obj, projectMetasDTO);
/*     */ 
/*  70 */       projectMetasDTOList.add(projectMetasDTO);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyProperties(List<TradeShowDTO> list, ProjectListing projectListing)
/*     */     throws com.hundsun.network.melody.common.util.html.parse.ParseException, Exception
/*     */   {
/*  77 */     CopyUtil.copyProperties(getTradeMap(list), projectListing);
/*     */   }
/*     */ 
/*     */   public static ProjectListing copyTradeShowDTOList2ProjectListing(List<TradeShowDTO> list, ProjectListing projectListing)
/*     */     throws java.text.ParseException
/*     */   {
/*  84 */     String listingPrice = "";
/*  85 */     for (TradeShowDTO tradeShowDTO : list)
/*     */     {
/* 102 */       if ("retail".equals(tradeShowDTO.getKey())) {
/* 103 */         projectListing.setRetail(tradeShowDTO.getInputValue());
/* 104 */         continue;
/*     */       }
/*     */ 
/* 118 */       if ("multipleBase".equals(tradeShowDTO.getKey())) {
/* 119 */         projectListing.setMultipleBase(Long.valueOf(tradeShowDTO.getInputValue()));
/* 120 */         continue;
/*     */       }
/* 122 */       if ("maxQuantity".equals(tradeShowDTO.getKey())) {
/* 123 */         projectListing.setMaxQuantity(Long.valueOf(tradeShowDTO.getInputValue()));
/* 124 */         continue;
/*     */       }
/* 126 */       if ("minQuantity".equals(tradeShowDTO.getKey())) {
/* 127 */         projectListing.setMinQuantity(Long.valueOf(tradeShowDTO.getInputValue()));
/* 128 */         continue;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 154 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static HashMap getTradeMap(List<TradeShowDTO> list)
/*     */     throws com.hundsun.network.melody.common.util.html.parse.ParseException
/*     */   {
/* 167 */     HashMap map = new HashMap();
/* 168 */     for (TradeShowDTO tradeShowDTO : list) {
/* 169 */       map.put(tradeShowDTO.getKey(), tradeShowDTO.getInputValue());
/*     */     }
/* 171 */     return map;
/*     */   }
/*     */ 
/*     */   public static ProjectMetasBO copyProjectTradeBO2ProjectMetasBO(ProjectTradeBO tradeBo, ProjectMetasBO metasBo)
/*     */   {
/* 181 */     List metas = metasBo.getMetaValues();
/* 182 */     Long projectId = null;
/* 183 */     Date gmtCreate = null;
/* 184 */     Date gmtModify = null;
/* 185 */     String operator = null;
/* 186 */     if ((metas != null) && (metas.size() > 0)) {
/* 187 */       projectId = ((ProjectMetas)metas.get(0)).getProjectId() == null ? null : ((ProjectMetas)metas.get(0)).getProjectId();
/* 188 */       gmtCreate = ((ProjectMetas)metas.get(0)).getGmtCreate();
/* 189 */       gmtModify = ((ProjectMetas)metas.get(0)).getGmtModify();
/* 190 */       operator = ((ProjectMetas)metas.get(0)).getOperator();
/*     */     }
/* 192 */     List<TradeShowDTO> tradeMetas = new ArrayList();
/* 193 */     tradeMetas = tradeBo.getTradeMetas();
/* 194 */     for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 195 */       metas.add(copyTradeShowDTO2ProjectMetas(projectId, gmtCreate, gmtModify, operator, tradeShowDTO));
/*     */     }
/*     */ 
/* 198 */     return metasBo;
/*     */   }
/*     */ 
/*     */   private static ProjectMetas copyTradeShowDTO2ProjectMetas(Long projectId, Date gmtCreate, Date gmtModify, String operator, TradeShowDTO tradeShowDTO)
/*     */   {
/* 204 */     ProjectMetas metas = new ProjectMetas();
/* 205 */     metas.setProjectId(projectId);
/* 206 */     metas.setGmtCreate(gmtCreate);
/* 207 */     metas.setGmtModify(gmtModify);
/* 208 */     metas.setOperator(operator);
/* 209 */     metas.setInputType(tradeShowDTO.getShowType());
/* 210 */     metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 211 */     metas.setMetaKey(tradeShowDTO.getKey());
/* 212 */     metas.setMetaTitle(tradeShowDTO.getName());
/* 213 */     metas.setMetaValue(tradeShowDTO.getInputValue());
/* 214 */     return metas;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 218 */     Money money = new Money();
/* 219 */     BigDecimal gb = new BigDecimal("2.1234567");
/* 220 */     Long p = Long.valueOf(gb.movePointRight(EnumValuationUnit.WANYUAN.getScale()).longValue());
/* 221 */     System.out.println(p);
/* 222 */     System.out.println();
/* 223 */     System.out.println(gb.longValue());
/* 224 */     money.setCent(EnumValuationUnit.WANYUAN.getRate().longValue());
/* 225 */     System.out.println(money.multiply(gb).getCent());
/*     */   }
/*     */ 
/*     */   public static void copyProjectTypeAttriDTOListAdd2ProjectTypeAttriList(List<ProjectTypeAttriDTO> projectTypeAttriDTOList, List<ProjectTypeAttri> projectTypeAttriLIst)
/*     */   {
/* 237 */     for (ProjectTypeAttriDTO projectTypeAttriDTO : projectTypeAttriDTOList) {
/* 238 */       ProjectTypeAttri projectTypeAttri = new ProjectTypeAttri();
/* 239 */       if (projectTypeAttriDTO != null) {
/* 240 */         ConvertUtils.convertProjectTypeAttriDTO2ProjectTypeAttri(projectTypeAttriDTO, projectTypeAttri);
/*     */ 
/* 242 */         if ((projectTypeAttriLIst == null) || (projectTypeAttriLIst.size() < 0)) {
/* 243 */           projectTypeAttriLIst = new ArrayList();
/*     */         }
/* 245 */         projectTypeAttriLIst.add(projectTypeAttri);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyProjectListing2ProjectMetasList(ProjectListing projectListing, List<ProjectMetas> projectMetasList)
/*     */   {
/* 259 */     List<TradeShowDTO> tslist = null;
/* 260 */     if (projectListing != null) {
/* 261 */       ProjectListingDTO plDto = new ProjectListingDTO();
/* 262 */       plDto.setListingType(projectListing.getListingType());
/* 263 */       tslist = PackageTradeData.getPlaceOrderShowDTO(plDto);
/*     */     }
/* 265 */     if ((projectListing != null) && (projectListing.getRetail() != null)) {
/* 266 */       ProjectMetas metas = new ProjectMetas();
/* 267 */       metas.setProjectId(projectListing.getId());
/* 268 */       metas.setGmtCreate(projectListing.getGmtCreate());
/* 269 */       metas.setGmtModify(projectListing.getGmtModify());
/* 270 */       metas.setOperator(projectListing.getOperator());
/* 271 */       for (TradeShowDTO tradeShowDTO : tslist) {
/* 272 */         if (tradeShowDTO.getKey().equals("retail")) {
/* 273 */           metas.setInputType(tradeShowDTO.getShowType());
/* 274 */           metas.setMetaValue(projectListing.getRetail());
/* 275 */           metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 276 */           metas.setMetaKey(tradeShowDTO.getKey());
/* 277 */           metas.setMetaTitle(tradeShowDTO.getName());
/*     */ 
/* 279 */           break;
/*     */         }
/*     */       }
/* 282 */       projectMetasList.add(metas);
/*     */     }
/* 284 */     if ((projectListing != null) && (projectListing.getMultipleBase() != null)) {
/* 285 */       ProjectMetas metas = new ProjectMetas();
/* 286 */       metas.setProjectId(projectListing.getId());
/* 287 */       metas.setGmtCreate(projectListing.getGmtCreate());
/* 288 */       metas.setGmtModify(projectListing.getGmtModify());
/* 289 */       metas.setOperator(projectListing.getOperator());
/* 290 */       for (TradeShowDTO tradeShowDTO : tslist) {
/* 291 */         if (tradeShowDTO.getKey().equals("multipleBase")) {
/* 292 */           metas.setInputType(tradeShowDTO.getShowType());
/* 293 */           metas.setMetaValue(projectListing.getMultipleBase().toString());
/* 294 */           metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 295 */           metas.setMetaKey(tradeShowDTO.getKey());
/* 296 */           metas.setMetaTitle(tradeShowDTO.getName());
/*     */ 
/* 298 */           break;
/*     */         }
/*     */       }
/* 301 */       projectMetasList.add(metas);
/*     */     }
/* 303 */     if ((projectListing != null) && (projectListing.getMinQuantity() != null)) {
/* 304 */       ProjectMetas metas = new ProjectMetas();
/* 305 */       metas.setProjectId(projectListing.getId());
/* 306 */       metas.setGmtCreate(projectListing.getGmtCreate());
/* 307 */       metas.setGmtModify(projectListing.getGmtModify());
/* 308 */       metas.setOperator(projectListing.getOperator());
/* 309 */       for (TradeShowDTO tradeShowDTO : tslist) {
/* 310 */         if (tradeShowDTO.getKey().equals("minQuantity")) {
/* 311 */           metas.setInputType(tradeShowDTO.getShowType());
/* 312 */           metas.setMetaValue(projectListing.getMinQuantity().toString());
/* 313 */           metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 314 */           metas.setMetaKey(tradeShowDTO.getKey());
/* 315 */           metas.setMetaTitle(tradeShowDTO.getName());
/*     */ 
/* 317 */           break;
/*     */         }
/*     */       }
/* 320 */       projectMetasList.add(metas);
/*     */     }
/* 322 */     if ((projectListing != null) && (projectListing.getMaxQuantity() != null)) {
/* 323 */       ProjectMetas metas = new ProjectMetas();
/* 324 */       metas.setProjectId(projectListing.getId());
/* 325 */       metas.setGmtCreate(projectListing.getGmtCreate());
/* 326 */       metas.setGmtModify(projectListing.getGmtModify());
/* 327 */       metas.setOperator(projectListing.getOperator());
/* 328 */       for (TradeShowDTO tradeShowDTO : tslist) {
/* 329 */         if (tradeShowDTO.getKey().equals("maxQuantity")) {
/* 330 */           metas.setInputType(tradeShowDTO.getShowType());
/* 331 */           metas.setMetaValue(projectListing.getMaxQuantity().toString());
/* 332 */           metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 333 */           metas.setMetaKey(tradeShowDTO.getKey());
/* 334 */           metas.setMetaTitle(tradeShowDTO.getName());
/*     */ 
/* 336 */           break;
/*     */         }
/*     */       }
/* 339 */       projectMetasList.add(metas);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static ProjectMetas[] copyTradeShowDTOArrayAdd2ProjectMetasArray(Long projectId, Date gmtCreate, Date gmtModify, String operator, List<TradeShowDTO> tradeMetas, ProjectMetas[] metaValues)
/*     */   {
/* 356 */     ProjectMetas[] newMetaValues = new ProjectMetas[tradeMetas.size() + metaValues.length];
/* 357 */     int i = 0;
/* 358 */     if ((metaValues != null) && (metaValues.length > 0)) {
/* 359 */       for (; i < metaValues.length; i++) {
/* 360 */         newMetaValues[i] = metaValues[i];
/*     */       }
/*     */     }
/* 363 */     if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 364 */       for (int j = 0 + metaValues.length; j < tradeMetas.size(); j++) {
/* 365 */         if (i + j > 1) {
/* 366 */           newMetaValues[(i + j - 1)] = copyTradeShowDTO2ProjectMetas(projectId, gmtCreate, gmtModify, operator, (TradeShowDTO)tradeMetas.get(j));
/*     */         }
/*     */         else {
/* 369 */           newMetaValues[j] = copyTradeShowDTO2ProjectMetas(projectId, gmtCreate, gmtModify, operator, (TradeShowDTO)tradeMetas.get(j));
/*     */         }
/*     */       }
/*     */     }
/* 373 */     return newMetaValues;
/*     */   }
/*     */ 
/*     */   public static ProjectMetas[] copyTradeShowDTOArrayAdd2ProjectMetasArray(Long projectId, Date gmtCreate, Date gmtModify, String operator, ProjectMetas[] metaValues, ProjectTradeBO tradeBo)
/*     */   {
/* 384 */     return copyTradeShowDTOArrayAdd2ProjectMetasArray(projectId, gmtCreate, gmtModify, operator, tradeBo.getTradeMetas(), metaValues);
/*     */   }
/*     */ 
/*     */   public static void copyTradeShowDTOArrayAdd2ProjectMetasArray(ProjectListing projectListing, ProjectTradeBO tradeBo)
/*     */   {
/* 396 */     if ((projectListing != null) && (projectListing.getMetaValues() != null) && (projectListing.getMetaValues().length > 0) && (tradeBo != null))
/*     */     {
/* 398 */       projectListing.setMetaValues(copyTradeShowDTOArrayAdd2ProjectMetasArray(projectListing.getId(), projectListing.getGmtCreate(), projectListing.getGmtModify(), projectListing.getOperator(), projectListing.getMetaValues(), tradeBo));
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyTradeShowDTOArrayAdd2ProjectListing(ProjectListing projectListing, ProjectTradeBO tradeBo)
/*     */   {
/* 405 */     if ((tradeBo != null) && (tradeBo.getTradeMetas() != null))
/* 406 */       for (TradeShowDTO tradeShowDTO : tradeBo.getTradeMetas()) {
/* 407 */         if ("multipleBase".equals(tradeShowDTO.getKey()))
/* 408 */           projectListing.setMultipleBase(Long.valueOf(tradeShowDTO.getInputValue()));
/* 409 */         if ("maxQuantity".equals(tradeShowDTO.getKey()))
/* 410 */           projectListing.setMaxQuantity(Long.valueOf(tradeShowDTO.getInputValue()));
/* 411 */         if ("minQuantity".equals(tradeShowDTO.getKey()))
/* 412 */           projectListing.setMinQuantity(Long.valueOf(tradeShowDTO.getInputValue()));
/* 413 */         if ("retail".equals(tradeShowDTO.getKey()))
/* 414 */           projectListing.setRetail(tradeShowDTO.getInputValue());
/*     */       }
/*     */   }
/*     */ 
/*     */   public static void convertProjectTypeAttrList2Map(List<ProjectTypeAttri> projectTypeAttriList, HashMap<String, ProjectTypeAttri> map)
/*     */   {
/* 427 */     if (projectTypeAttriList != null)
/* 428 */       for (int i = 0; i < projectTypeAttriList.size(); i++) {
/* 429 */         ProjectTypeAttri projectTypeAttri = (ProjectTypeAttri)projectTypeAttriList.get(i);
/* 430 */         map.put(projectTypeAttri.getKeyName(), projectTypeAttri);
/*     */       }
/*     */   }
/*     */ 
/*     */   public static void copyTradeMetasList2Map(List<TradeShowDTO> tradeMetas, Map<String, String> metaSubmitValue)
/*     */   {
/* 443 */     if ((tradeMetas != null) && (tradeMetas.size() > 0))
/* 444 */       for (TradeShowDTO tradeShowDTO : tradeMetas)
/* 445 */         if ((tradeShowDTO != null) && (tradeShowDTO.getKey() != null))
/* 446 */           metaSubmitValue.put(tradeShowDTO.getKey(), tradeShowDTO.getInputValue());
/*     */   }
/*     */ 
/*     */   public static void hiddenTradeMetas(ProjectListing projectListing, HashMap<String, String> map)
/*     */   {
/* 456 */     if ((projectListing != null) && (map != null) && 
/* 457 */       (projectListing.getTradeMeta() != null) && (projectListing.getTradeMeta().size() > 0)) {
/* 458 */       List metaList = new ArrayList();
/* 459 */       for (AttriMeta ameta : projectListing.getTradeMeta()) {
/* 460 */         if (!map.containsKey(ameta.getMeta().getMetaKey())) {
/* 461 */           metaList.add(ameta);
/*     */         }
/*     */       }
/* 464 */       projectListing.setTradeMeta(metaList);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void copyProjectMetasList2Map(List<ProjectMetas> metaList, Map<String, String> metaSubmitValue)
/*     */   {
/* 476 */     if ((metaList != null) && (metaList.size() > 0))
/* 477 */       for (ProjectMetas projectMetas : metaList)
/* 478 */         if ((projectMetas != null) && (projectMetas.getMetaKey() != null))
/* 479 */           metaSubmitValue.put(projectMetas.getMetaKey(), projectMetas.getMetaValue());
/*     */   }
/*     */ 
/*     */   public static void copyProjectMetasList2Map(ProjectMetas[] metaValues, Map<String, String> metaSubmitValue)
/*     */   {
/* 491 */     if ((metaValues != null) && (metaValues.length > 0))
/* 492 */       for (ProjectMetas projectMetas : metaValues)
/* 493 */         if ((projectMetas != null) && (projectMetas.getMetaKey() != null))
/* 494 */           metaSubmitValue.put(projectMetas.getMetaKey(), projectMetas.getMetaValue());
/*     */   }
/*     */ 
/*     */   public static void copyProjectTradeBO2ProjectListing(ProjectTradeBO tradeBo, ProjectListing projectListing)
/*     */   {
/* 507 */     if ((tradeBo != null) && (tradeBo.getTradeMetas() != null) && (projectListing != null) && (tradeBo.getTradeMetas().size() > 0) && (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())))
/*     */     {
/*     */       try
/*     */       {
/* 511 */         HashMap map = getTradeMap(tradeBo.getTradeMetas());
/* 512 */         projectListing.setRetail((String)map.get(EnumPlaceOrderProperty.RETAIL.getKey()));
/* 513 */         projectListing.setMultipleBase(Long.valueOf((String)map.get(EnumPlaceOrderProperty.MULTIPLE_BASE.getKey())));
/*     */ 
/* 515 */         projectListing.setMinQuantity(Long.valueOf((String)map.get(EnumPlaceOrderProperty.MIN_QUANTITY.getKey())));
/*     */ 
/* 517 */         projectListing.setMaxQuantity(Long.valueOf((String)map.get(EnumPlaceOrderProperty.MAX_QUANTITY.getKey())));
/*     */       }
/*     */       catch (com.hundsun.network.melody.common.util.html.parse.ParseException e) {
/* 520 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.util.ProjectCopyUtil
 * JD-Core Version:    0.6.0
 */