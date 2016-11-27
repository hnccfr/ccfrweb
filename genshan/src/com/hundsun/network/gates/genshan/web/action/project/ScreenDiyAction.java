/*     */ package com.hundsun.network.gates.genshan.web.action.project;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.TradeScreen;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeScreenQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeSubstationQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeSubstation;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectTypeService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ScreenDiyService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.trade.TradeSubstationService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.melody.common.util.DateUtil;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class ScreenDiyAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ScreenDiyService screenDiyService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectTypeService projectTypeService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeSubstationService tradeSubstationService;
/*  63 */   private final String EMPTY_DEFAULT_STR = "";
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SCREEN_C_ADD})
/*     */   @RequestMapping(value={"/screen/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String doAddScreenPage(@ModelAttribute("screenDiy") TradeScreen screenDiy, ModelMap model)
/*     */   {
/*  72 */     initScreenTypes(model);
/*  73 */     model.put("screenDiy", screenDiy);
/*  74 */     return "/screen/add";
/*     */   }
/*     */ 
/*     */   private void initScreenTypes(ModelMap model)
/*     */   {
/*  82 */     List projectTypeList = this.projectTypeService.getProjectTypeForScreen();
/*  83 */     model.put("projectTypeList", projectTypeList.toArray());
/*     */ 
/*  85 */     EnumTradingType[] tradingTypeList = { EnumTradingType.BID_ORDER, EnumTradingType.TRANSFER_ORDER, EnumTradingType.TENDER_ORDER, EnumTradingType.PLACE_ORDER };
/*     */ 
/*  91 */     model.put("tradingTypeList", tradingTypeList);
/*     */ 
/*  93 */     EnumProjectStatus[] statusList = { EnumProjectStatus.TRADE, EnumProjectStatus.OVER };
/*     */ 
/*  97 */     model.put("statusList", statusList);
/*     */ 
/*  99 */     TradeSubstationQuery query = new TradeSubstationQuery();
/* 100 */     query.setPageSize(2147483647);
/* 101 */     this.tradeSubstationService.getTradeSubstationList(query);
/* 102 */     model.put("substationList", query.getData().toArray());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SCREEN_C_ADD})
/*     */   @RequestMapping(value={"/screen/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String doAddScreen(@ModelAttribute("screenDiy") TradeScreen screenDiy, ModelMap model, UserAgent userAgent)
/*     */   {
/* 113 */     if (StringUtil.isBlank(screenDiy.getName())) {
/* 114 */       model.put("errorMsg", "大屏名称不能为空");
/* 115 */       return "/screen/add";
/*     */     }
/* 117 */     model.put("url", "/screen/list.htm");
/* 118 */     Long substationId = getSubstationId(userAgent);
/* 119 */     screenDiy.setSubstationId(substationId);
/* 120 */     screenDiy.setCreator(userAgent.getUserAccount());
/* 121 */     screenDiy.setOperator(userAgent.getUserAccount());
/* 122 */     if (this.screenDiyService.add(screenDiy).longValue() <= 0L) {
/* 123 */       model.put("errorMsg", "添加大屏失败");
/* 124 */       return "/screen/add";
/*     */     }
/* 126 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SCREEN_U_EDIT})
/*     */   @RequestMapping(value={"/screen/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String doEditScreenPage(@ModelAttribute("screenDiy") TradeScreen screenDiy, ModelMap model, UserAgent userAgent, @RequestParam("id") Long id)
/*     */   {
/* 137 */     model.put("url", "/screen/list.htm");
/* 138 */     initScreenTypes(model);
/* 139 */     screenDiy = this.screenDiyService.getTradeScreenById(id);
/* 140 */     if (null == screenDiy) {
/* 141 */       return error(model);
/*     */     }
/* 143 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/* 145 */     if ((substationId != null) && (!substationId.equals(screenDiy.getSubstationId()))) {
/* 146 */       return "accessDenied";
/*     */     }
/* 148 */     model.put("screenDiy", screenDiy);
/* 149 */     return "/screen/edit";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SCREEN_U_EDIT})
/*     */   @RequestMapping(value={"/screen/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String doEditScreen(@ModelAttribute("screenDiy") TradeScreen screenDiy, ModelMap model, UserAgent userAgent)
/*     */   {
/* 160 */     model.put("url", "/screen/list.htm");
/* 161 */     initScreenTypes(model);
/* 162 */     if (null == screenDiy.getId()) {
/* 163 */       return error(model);
/*     */     }
/* 165 */     TradeScreen tradeScreen = this.screenDiyService.getTradeScreenById(screenDiy.getId());
/* 166 */     if (null == tradeScreen) {
/* 167 */       return error(model);
/*     */     }
/* 169 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/* 171 */     if ((substationId != null) && (!substationId.equals(tradeScreen.getSubstationId()))) {
/* 172 */       return "accessDenied";
/*     */     }
/*     */ 
/* 175 */     screenDiy.setSubstationId(substationId);
/* 176 */     screenDiy.setOperator(userAgent.getUserAccount());
/* 177 */     if (this.screenDiyService.edit(screenDiy).intValue() <= 0) {
/* 178 */       model.put("errorMsg", "编辑大屏失败");
/* 179 */       return "/screen/edit";
/*     */     }
/* 181 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SCREEN_R_LIST})
/*     */   @RequestMapping({"/screen/list"})
/*     */   public String doSearchScreen(ModelMap model, UserAgent userAgent, @ModelAttribute("page") TradeScreenQuery<TradeScreen> page)
/*     */   {
/* 192 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/* 194 */     if (substationId != null) {
/* 195 */       page.setSubstationId(Long.valueOf(substationId.longValue()));
/*     */     }
/* 197 */     this.screenDiyService.paginate(page);
/* 198 */     TradeSubstationQuery query = new TradeSubstationQuery();
/* 199 */     query.setPageSize(2147483647);
/* 200 */     this.tradeSubstationService.getTradeSubstationList(query);
/* 201 */     Map substationMap = new HashMap();
/* 202 */     for (TradeSubstation sub : query.getData()) {
/* 203 */       substationMap.put(sub.getId(), sub.getName());
/*     */     }
/* 205 */     model.put("substationMap", substationMap);
/* 206 */     return "/screen/list";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SCREEN_D_DEL})
/*     */   @RequestMapping(value={"/screen/del"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String del(ModelMap model, UserAgent userAgent, @RequestParam("id") Long id)
/*     */   {
/* 217 */     model.put("url", "/screen/list.htm");
/* 218 */     TradeScreen tradeScreen = this.screenDiyService.getTradeScreenById(id);
/* 219 */     if (null == tradeScreen) {
/* 220 */       return error(model);
/*     */     }
/* 222 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/* 224 */     if ((substationId != null) && (!substationId.equals(tradeScreen.getSubstationId()))) {
/* 225 */       return "accessDenied";
/*     */     }
/* 227 */     this.screenDiyService.delTradeScreenById(id);
/* 228 */     return success(model);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/screen/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String doPreview(ModelMap model, UserAgent userAgent, @RequestParam("id") Long id)
/*     */   {
/* 238 */     if (id != null) {
/* 239 */       TradeScreen screenDiy = this.screenDiyService.getTradeScreenById(id);
/* 240 */       model.put("screenDiy", screenDiy);
/*     */     }
/* 242 */     return "/screen/view";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/screen/screenData"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public Map<String, Object> getProjectListByJQ(@RequestParam("cols") String cols, @RequestParam("tProjectType") String tProjectType, @RequestParam("tTradingType") String tTradingType, @RequestParam("tT") String tT, @RequestParam("tO") String tO, ModelMap model)
/*     */   {
/* 265 */     Map parMap = new HashMap();
/* 266 */     parMap.put("tProjectType", tProjectType);
/* 267 */     parMap.put("tTradingType", tTradingType);
/*     */ 
/* 272 */     parMap.put("tT", tT);
/* 273 */     parMap.put("tO", tO);
/*     */ 
/* 275 */     String[] colsList = cols.split(",");
/* 276 */     Map jsonData = new LinkedHashMap();
/* 277 */     jsonData.put("data", doFilterData(colsList, getProjectList(parMap)));
/* 278 */     return jsonData;
/*     */   }
/*     */ 
/*     */   private List<ProjectListing> getProjectList(Map parMap)
/*     */   {
/* 284 */     String tProjectType = parMap.get("tProjectType").toString();
/* 285 */     String tTradingType = parMap.get("tTradingType").toString();
/* 286 */     Map map = new HashMap();
/* 287 */     map.put("projectType", tProjectType);
/* 288 */     List codeList = new ArrayList();
/* 289 */     codeList.add(tTradingType);
/*     */ 
/* 302 */     map.put("codeList", codeList);
/*     */ 
/* 305 */     String status = null;
/* 306 */     String tT = parMap.get("tT").toString();
/* 307 */     String tO = parMap.get("tO").toString();
/* 308 */     if (("1".equals(tT)) && ("1".equals(tO)))
/* 309 */       status = "All";
/* 310 */     else if (("1".equals(tT)) && (!"1".equals(tO)))
/* 311 */       status = "tT";
/* 312 */     else if ((!"1".equals(tT)) && ("1".equals(tO)))
/* 313 */       status = "tO";
/*     */     else {
/* 315 */       status = null;
/*     */     }
/* 317 */     if (null == status) {
/* 318 */       return null;
/*     */     }
/* 320 */     map.put("status", status);
/*     */ 
/* 322 */     return this.projectListingService.getProjectForScreen(map);
/*     */   }
/*     */ 
/*     */   private List<Map> doFilterData(String[] cols, List<ProjectListing> activityList)
/*     */   {
/* 328 */     List resultList = new ArrayList();
/* 329 */     if ((activityList != null) && (activityList.size() > 0)) {
/* 330 */       for (ProjectListing activity : activityList) {
/* 331 */         Map tempMap = new HashMap();
/* 332 */         Map aActivityMap = getMappedProject(activity);
/* 333 */         for (String colName : cols) {
/* 334 */           tempMap.put(colName, aActivityMap.get(colName) != null ? aActivityMap.get(colName) : "");
/*     */         }
/*     */ 
/* 338 */         resultList.add(tempMap);
/*     */       }
/*     */     }
/* 341 */     return resultList;
/*     */   }
/*     */ 
/*     */   private Map<String, Object> getMappedProject(ProjectListing activity)
/*     */   {
/* 352 */     Map map = new HashMap();
/*     */ 
/* 354 */     map.put("TITLE", activity.getTitle());
/* 355 */     map.put("CODE", activity.getCode());
/* 356 */     map.put("LISTING_TYPE", EnumListingType.indexByValue(activity.getListingType()).getName());
/* 357 */     map.put("QUANTITY", activity.getQuantity() + activity.getMeasureUnitDesc());
/* 358 */     map.put("LISTING_PRICE", CommonUtils.getValuationUnitDesc(activity.getListingPrice(), activity.getValuationUnit()) + "/" + activity.getMeasureUnitDesc());
/* 359 */     map.put("PROJECT_TYPE_CODE", activity.getProjectTypeName());
/* 360 */     map.put("TRADING_TYPE", activity.getTradingTypeDesc());
/* 361 */     map.put("LISTING_START_TIME", DateUtil.convertDateToString("yyyy-MM-dd", activity.getListingStartTime()));
/* 362 */     map.put("LISTING_END_TIME", DateUtil.convertDateToString("yyyy-MM-dd", activity.getListingEndTime()));
/* 363 */     map.put("USER_ACCOUNT", activity.getUserAccount());
/* 364 */     map.put("DELIVERY_DATE", DateUtil.convertDateToString("yyyy-MM-dd", activity.getDeliveryDate()));
/* 365 */     map.put("ADDRESS", activity.getAddress());
/*     */ 
/* 368 */     TradeOrder tradeOrder = new TradeOrder();
/* 369 */     if ((activity.getTradeOrderList() != null) && (activity.getTradeOrderList().size() > 0)) {
/* 370 */       tradeOrder = (TradeOrder)activity.getTradeOrderList().get(0);
/*     */     }
/* 372 */     map.put("ORDER_NO", tradeOrder.getOrderNo());
/* 373 */     map.put("BID_PRICE", CommonUtils.getValuationUnitDesc(tradeOrder.getBidPrice(), activity.getValuationUnit()) + "/" + activity.getMeasureUnitDesc());
/* 374 */     map.put("ORDER_QUANTITY", tradeOrder.getQuantity());
/* 375 */     map.put("ORDER_AMOUNT", CommonUtils.getValuationUnitDesc(tradeOrder.getQuantity(), activity.getValuationUnit()));
/* 376 */     map.put("DELIVERY_TYPE", EnumDeliveryType.indexByValue(tradeOrder.getDeliveryType()));
/* 377 */     map.put("PAYMENT_TYPE", EnumPaymentType.indexByValue(tradeOrder.getPaymentType()));
/* 378 */     map.put("ORDER_STATUS", tradeOrder.getStatusDesc());
/*     */ 
/* 381 */     List<AttriMeta> attriMetas = activity.getAttriMeta();
/* 382 */     if ((attriMetas != null) && (attriMetas.size() > 0)) {
/* 383 */       for (AttriMeta value : attriMetas) {
/* 384 */         map.put(value.getMeta().getMetaKey(), value.getMeta().getMetaValue());
/*     */       }
/*     */     }
/* 387 */     List<AttriMeta> tradeMetas = activity.getTradeMeta();
/* 388 */     if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 389 */       for (AttriMeta value : tradeMetas)
/*     */       {
/* 391 */         String key = value.getMeta().getMetaKey();
/* 392 */         String val = value.getMeta().getMetaValue();
/* 393 */         String vUnit = activity.getValuationUnit();
/* 394 */         String unitDes = "";
/* 395 */         if (EnumValuationUnit.indexByValue(vUnit) != null) {
/* 396 */           unitDes = EnumValuationUnit.indexByValue(vUnit).getName();
/*     */         }
/*     */ 
/* 399 */         if (!EnumTradingType.PLACE_ORDER.getValue().equals(activity.getTradingType()))
/*     */         {
/* 401 */           if ((EnumTradingType.BID_ORDER.getValue().equals(activity.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(activity.getTradingType())))
/*     */           {
/* 404 */             if ((("bidStartPrice".equals(key)) || ("reservePrice".equals(key)) || ("bidRate".equals(key))) && (StringUtil.isNotEmpty(val)))
/*     */             {
/* 406 */               val = CommonUtils.getValuationUnit(Long.valueOf(val), vUnit) + unitDes;
/*     */             }
/*     */           }
/* 409 */           else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(activity.getTradingType())) {
/* 410 */             if (("startPrice".equals(key)) && (StringUtil.isNotEmpty(val)))
/* 411 */               val = CommonUtils.getValuationUnit(Long.valueOf(val), vUnit) + unitDes;
/*     */           }
/* 413 */           else if ((EnumTradingType.TENDER_ORDER.getValue().equals(activity.getTradingType())) && 
/* 414 */             ("evaluation".equals(key)) && (StringUtil.isNotEmpty(val))) {
/* 415 */             val = CommonUtils.getValuationUnit(Long.valueOf(val), vUnit) + unitDes;
/*     */           }
/*     */         }
/* 418 */         map.put(key, val);
/*     */       }
/*     */     }
/*     */ 
/* 422 */     return map;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.project.ScreenDiyAction
 * JD-Core Version:    0.6.0
 */