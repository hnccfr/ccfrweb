/*     */ package com.hundsun.network.gates.fengshan.web.action.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeWishOrderQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumApplyTime;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectMetasService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.trade.TradeWishOrderService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransferOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.melody.common.util.DateUtil;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class TradeWishOrderAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderService tradeWishOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasService projectMetasService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_WISHORDER_SELLER_LIST})
/*     */   @RequestMapping({"tradeWishOrder/sell"})
/*     */   public void doShowMyTradeWishOrderSellingPage(@ModelAttribute("query") TradeWishOrderQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/*  63 */     EnumTradeWishOrderStatus[] twoStatus = EnumTradeWishOrderStatus.values();
/*  64 */     EnumPaymentType[] payTypes = EnumPaymentType.values();
/*  65 */     query.setUserAccount(userAgent.getAccount());
/*     */ 
/*  67 */     query.setTradeDictor(EnumListingType.SELL.getValue());
/*  68 */     this.tradeWishOrderService.getTradeWishOrderByQuery(query);
/*  69 */     model.addAttribute("query", query);
/*  70 */     model.addAttribute("twoStatus", twoStatus);
/*  71 */     model.addAttribute("payTypes", payTypes);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_WISHORDER_BUYER_LIST})
/*     */   @RequestMapping({"tradeWishOrder/buy"})
/*     */   public void doShowMyTradeWishOrderBuyingPage(@ModelAttribute("query") TradeWishOrderQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/*  80 */     EnumTradeWishOrderStatus[] twoStatus = EnumTradeWishOrderStatus.values();
/*  81 */     EnumPaymentType[] payTypes = EnumPaymentType.values();
/*  82 */     query.setUserAccount(userAgent.getAccount());
/*     */ 
/*  84 */     query.setTradeDictor(EnumListingType.BUY.getValue());
/*  85 */     this.tradeWishOrderService.getTradeWishOrderByQuery(query);
/*  86 */     model.addAttribute("query", query);
/*  87 */     model.addAttribute("twoStatus", twoStatus);
/*  88 */     model.addAttribute("payTypes", payTypes);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_WISHORDER_DETAI})
/*     */   @RequestMapping(value={"tradeWishOrder/detail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String doShowTradeWishOrderDetail(@RequestParam(value="wishOrderNum", required=true) String wishOrderNum, ModelMap model)
/*     */   {
/*  98 */     String returnURL = "";
/*  99 */     TradeWishOrder tradeWishOrder = this.tradeWishOrderService.getTradeWishOrderByOrderNum(wishOrderNum);
/* 100 */     if (null != tradeWishOrder)
/*     */     {
/* 102 */       if (!EnumTradingType.PLACE_ORDER.getValue().equals(tradeWishOrder.getTradeType())) {
/* 103 */         ProjectListing projectListing = this.projectListingService.getProjectListingByCode(tradeWishOrder.getProjectCode());
/* 104 */         ProjectMetas projectMetas = new ProjectMetas();
/* 105 */         projectMetas.setProjectId(projectListing.getId());
/* 106 */         String metaKey = EnumMulitBidOrderProperty.BID_START_PRICE.getKey();
/*     */ 
/* 108 */         if ((EnumTradingType.TRANSFER_ORDER.getValue().equals(tradeWishOrder.getTradeType())) || (EnumTradingType.TENDER_ORDER.getValue().equals(tradeWishOrder.getTradeType())))
/*     */         {
/* 110 */           metaKey = EnumTransferOrderProperty.START_PRICE.getKey();
/*     */         }
/* 112 */         projectMetas.setMetaKey(metaKey);
/* 113 */         Long bidStartPrice = Long.valueOf(Long.parseLong(this.projectMetasService.getMetaValue(projectMetas)));
/* 114 */         model.addAttribute("bidStartPrice", bidStartPrice);
/*     */       }
/* 116 */       returnURL = "tradeWishOrder/detail";
/* 117 */       model.addAttribute("tradeWishOrder", tradeWishOrder);
/*     */     } else {
/* 119 */       returnURL = "error";
/*     */     }
/* 121 */     return returnURL;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_AUCTION_APPLY})
/*     */   @RequestMapping(value={"tradeWishOrder/registration/info"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String initWishOrderAdd(UserAgent userAgent, @RequestParam("projectCode") String projectCode, ModelMap model)
/*     */   {
/* 139 */     if ((null != projectCode) && (!projectCode.equals(""))) {
/* 140 */       ProjectListing projectListing = this.projectListingService.getProjectListingByCode(projectCode);
/* 141 */       if (null == projectListing) {
/* 142 */         model.put("url", "/home/list");
/* 143 */         return error(model, "project.not.exit", new String[0]);
/*     */       }
/* 145 */       if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 146 */         model.put("url", "/home/list");
/* 147 */         return error(model, "project.not.auction", new String[0]);
/*     */       }
/* 149 */       if (!EnumProjectStatus.TRADE.getValue().equals(projectListing.getStatus())) {
/* 150 */         model.put("url", "/home/list");
/* 151 */         return error(model, "project.not.nomal", new String[0]);
/*     */       }
/* 153 */       if (userAgent.getAccount().equals(projectListing.getCreator())) {
/* 154 */         model.put("url", "/home/list");
/* 155 */         return error(model, "not.myself.project", new String[0]);
/*     */       }
/* 157 */       String result = this.tradeWishOrderService.isApplyTime(projectListing.getId());
/* 158 */       if (!EnumApplyTime.SUCCESS.getValue().equals(result)) {
/* 159 */         model.put("url", "/home/list");
/* 160 */         model.put("message", result);
/* 161 */         return "error";
/*     */       }
/* 163 */       TradeWishOrder query = new TradeWishOrder();
/* 164 */       query.setUserAccount(userAgent.getAccount());
/* 165 */       query.setProjectCode(projectCode);
/* 166 */       int count = this.tradeWishOrderService.getCountOfMyWishOrder(query);
/* 167 */       if (count >= 1) {
/* 168 */         if (EnumListingType.BUY.getValue().equals(projectListing.getListingType()))
/* 169 */           model.put("url", "/tradeWishOrder/sell");
/*     */         else {
/* 171 */           model.put("url", "/tradeWishOrder/buy");
/*     */         }
/* 173 */         return error(model, "user.has.auction", new String[0]);
/*     */       }
/*     */ 
/* 176 */       ProjectMetas projectMetas = new ProjectMetas();
/* 177 */       projectMetas.setProjectId(projectListing.getId());
/* 178 */       projectMetas.setMetaKey("supportPriority");
/* 179 */       String supportPriority = this.projectMetasService.getMetaValue(projectMetas);
/*     */ 
/* 181 */       EnumDeliveryType[] deliveryTypes = EnumDeliveryType.values();
/* 182 */       EnumPaymentType[] paymentTypes = EnumPaymentType.values();
/* 183 */       EnumHasEnabled[] invoices = EnumHasEnabled.values();
/* 184 */       model.addAttribute("supportPriority", supportPriority);
/* 185 */       model.addAttribute("paymentTypes", paymentTypes);
/* 186 */       model.addAttribute("deliveryTypes", deliveryTypes);
/* 187 */       model.addAttribute("invoices", invoices);
/* 188 */       model.addAttribute("projectListing", projectListing);
/*     */ 
/* 190 */       if (EnumListingType.BUY.getValue().equals(projectListing.getListingType()))
/* 191 */         model.addAttribute("defaultLinkman", userAgent.getAccount());
/*     */       else {
/* 193 */         model.addAttribute("defaultLinkman", projectListing.getUserAccount());
/*     */       }
/* 195 */       model.addAttribute("addressType", "S");
/*     */     } else {
/* 197 */       model.put("url", "/home/list");
/* 198 */       return error(model, "parameter.error.null", new String[0]);
/*     */     }
/* 200 */     return "tradeWishOrder/registration/info";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_AUCTION_APPLY})
/*     */   @RequestMapping(value={"tradeWishOrder/registration/info"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String wishOrderAdd(UserAgent userAgent, @ModelAttribute("tradeWishOrder") TradeWishOrder tradeWishOrder, ModelMap model)
/*     */   {
/* 218 */     ProjectListing projectListing = this.projectListingService.getProjectListingByCode(tradeWishOrder.getProjectCode());
/* 219 */     String result = this.tradeWishOrderService.isApplyTime(projectListing.getId());
/* 220 */     if (!EnumApplyTime.SUCCESS.getValue().equals(result)) {
/* 221 */       model.put("message", result);
/* 222 */       model.put("url", "/home/list");
/* 223 */       return "error";
/*     */     }
/* 225 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 226 */       model.put("url", "/home/list");
/* 227 */       return error(model, "project.not.auction", new String[0]);
/*     */     }
/* 229 */     if (!EnumProjectStatus.TRADE.getValue().equals(projectListing.getStatus())) {
/* 230 */       model.put("url", "/home/list");
/* 231 */       return error(model, "project.not.nomal", new String[0]);
/*     */     }
/* 233 */     String listUrl = null;
/* 234 */     if (EnumListingType.BUY.getValue().equals(projectListing.getListingType())) {
/* 235 */       tradeWishOrder.setTradeDictor(EnumListingType.SELL.getValue());
/* 236 */       listUrl = "/tradeWishOrder/sell";
/*     */     } else {
/* 238 */       tradeWishOrder.setTradeDictor(EnumListingType.BUY.getValue());
/* 239 */       listUrl = "/tradeWishOrder/buy";
/*     */     }
/* 241 */     TradeWishOrder query = new TradeWishOrder();
/* 242 */     query.setUserAccount(userAgent.getAccount());
/* 243 */     query.setProjectCode(projectListing.getCode());
/* 244 */     int count = this.tradeWishOrderService.getCountOfMyWishOrder(query);
/* 245 */     if (count >= 1) {
/* 246 */       model.put("url", listUrl);
/* 247 */       return error(model, "user.has.auction", new String[0]);
/*     */     }
/* 249 */     tradeWishOrder.setWishOrderNum(this.tradeWishOrderService.generatorWishOrderNo());
/* 250 */     tradeWishOrder.setProjectCode(projectListing.getCode());
/* 251 */     tradeWishOrder.setProjectName(projectListing.getTitle());
/* 252 */     tradeWishOrder.setUserAccount(userAgent.getAccount());
/* 253 */     tradeWishOrder.setValuationUnit(projectListing.getValuationUnit());
/* 254 */     tradeWishOrder.setQuantity(projectListing.getQuantity());
/* 255 */     tradeWishOrder.setMeasureUnit(projectListing.getMeasureUnit());
/*     */ 
/* 257 */     Long bidStartPrice = null;
/*     */ 
/* 259 */     if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*     */     {
/* 261 */       ProjectMetas projectMetas = new ProjectMetas();
/* 262 */       projectMetas.setMetaKey("bidStartPrice");
/* 263 */       projectMetas.setProjectId(projectListing.getId());
/* 264 */       String metaValue = this.projectMetasService.getMetaValue(projectMetas);
/* 265 */       if (null == metaValue) {
/* 266 */         model.put("url", "/home/list");
/* 267 */         return error(model, "get.bidStartPrice.error", new String[0]);
/*     */       }
/* 269 */       bidStartPrice = Long.valueOf(Long.parseLong(metaValue));
/*     */     }
/*     */ 
/* 272 */     tradeWishOrder.setTotalPay(Long.valueOf(projectListing.getListingPrice().longValue() * projectListing.getQuantity().longValue()));
/* 273 */     tradeWishOrder.setStatus(EnumTradeWishOrderStatus.CREATE.getValue());
/* 274 */     tradeWishOrder.setTradeType(projectListing.getTradingType());
/* 275 */     Long deposit = this.tradeWishOrderService.depositGenerator(userAgent.getAccount(), projectListing, bidStartPrice);
/* 276 */     if (deposit.equals(Long.valueOf(-1L))) {
/* 277 */       model.addAttribute("url", listUrl);
/* 278 */       return error(model, "get.deposit.rat.error", new String[0]);
/*     */     }
/* 280 */     tradeWishOrder.setDeposit(deposit);
/* 281 */     tradeWishOrder.setSubstationId(projectListing.getSubstationId());
/* 282 */     if (this.tradeWishOrderService.addTradeWishOrder(tradeWishOrder).longValue() > 0L) {
/* 283 */       model.addAttribute("url", listUrl);
/* 284 */       model.addAttribute("deposit", deposit);
/* 285 */       model.addAttribute("valuationUnit", projectListing.getValuationUnit());
/* 286 */       model.addAttribute("wishOrderNo", tradeWishOrder.getWishOrderNum());
/* 287 */       model.addAttribute("tradingType", projectListing.getTradingType());
/* 288 */       return "tradeWishOrder/registration/success";
/*     */     }
/* 290 */     model.addAttribute("url", listUrl);
/* 291 */     return error(model, "wish.order.create.error", new String[0]);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_AUCTION_APPLY})
/*     */   @RequestMapping(value={"tradeWishOrder/registration/check"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String checkWishOrder(UserAgent userAgent, @RequestParam("wishOrderNum") String wishOrderNum, ModelMap model)
/*     */   {
/* 307 */     if (StringUtil.isEmpty(wishOrderNum)) {
/* 308 */       model.put("message", "wishOrderNum.not.exit");
/* 309 */       model.put("url", "/home/list");
/* 310 */       return "error";
/*     */     }
/* 312 */     TradeWishOrder tradeWishOrder = this.tradeWishOrderService.getTradeWishOrderByOrderNum(wishOrderNum);
/* 313 */     if (null == tradeWishOrder) {
/* 314 */       model.put("message", "wishOrder.not.exit");
/* 315 */       model.put("url", "/home/list");
/* 316 */       return "error";
/*     */     }
/* 318 */     ProjectListing projectListing = this.projectListingService.getProjectListingByCode(tradeWishOrder.getProjectCode());
/* 319 */     if (!EnumProjectStatus.TRADE.getValue().equals(projectListing.getStatus())) {
/* 320 */       model.put("url", "/home/list");
/* 321 */       return error(model, "project.not.nomal", new String[0]);
/*     */     }
/* 323 */     String timeResult = this.tradeWishOrderService.isApplyTime(projectListing.getId());
/* 324 */     if (EnumListingType.BUY.getValue().equals(tradeWishOrder.getTradeDictor()))
/* 325 */       model.put("url", "/tradeWishOrder/buy");
/*     */     else {
/* 327 */       model.put("url", "/tradeWishOrder/sell");
/*     */     }
/* 329 */     if (!EnumApplyTime.SUCCESS.getValue().equals(timeResult)) {
/* 330 */       model.put("message", timeResult);
/* 331 */       return "error";
/*     */     }
/* 333 */     TransRequest request = new TransRequest();
/* 334 */     request.setFreezeDepositAmount(tradeWishOrder.getDeposit());
/* 335 */     request.setBizNo(wishOrderNum);
/* 336 */     request.setFundAccount(userAgent.getFundAccount());
/* 337 */     request.setOrderProperty(tradeWishOrder.getTradeType());
/* 338 */     request.setOperator(userAgent.getAccount());
/* 339 */     request.setTransDate(DateUtil.convertDateToString("yyyymmdd", tradeWishOrder.getGmtModify()));
/* 340 */     FundOperateResult result = this.remoteFundService.freezeFundByTrade(request);
/* 341 */     if (result.isError()) {
/* 342 */       model.put("message", result.getErrorInfo());
/* 343 */       return "error";
/*     */     }
/* 345 */     tradeWishOrder.setStatus(EnumTradeWishOrderStatus.AUDIT.getValue());
/* 346 */     int number = this.tradeWishOrderService.modifyTradeWishOrder(tradeWishOrder, userAgent.getAccount());
/* 347 */     if (number == 0) {
/* 348 */       model.put("message", "更改意向单状态失败，请联系管理员");
/* 349 */       return "error";
/*     */     }
/* 351 */     model.put("message", "提交审核成功，请耐心等待系统的审核");
/* 352 */     return "success";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.trade.TradeWishOrderAction
 * JD-Core Version:    0.6.0
 */