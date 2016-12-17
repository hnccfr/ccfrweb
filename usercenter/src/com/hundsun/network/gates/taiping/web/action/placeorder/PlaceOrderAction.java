/*     */ package com.hundsun.network.gates.taiping.web.action.placeorder;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAddress;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserAddressService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.fengshan.web.validator.common.UserValidator;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.enums.EnumTradeResultErrors;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.dto.ProjectInfo;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.enums.EnumTradeError;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.result.ProjectInfoServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectBaseSettingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserCreditDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserLevelDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectBaseSettingRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserCreditRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLevelRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectBaseSettingServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserCreditServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserLevelServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectBaseSettingService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.gates.taiping.biz.domain.placeorder.PlaceOrderInput;
/*     */ import com.hundsun.network.gates.taiping.biz.service.project.ProjectService;
/*     */ import com.hundsun.network.gates.taiping.biz.service.trade.TradeService;
/*     */ import com.hundsun.network.gates.taiping.common.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.taiping.web.validator.PlaceOrderValidator;
/*     */ import com.hundsun.network.melody.common.util.Money;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class PlaceOrderAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectService projectService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeService<PlaceOrderInput> tradeService;
/*     */ 
/*     */   @Autowired
/*     */   private PlaceOrderValidator placeOrderValidator;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteProjectBaseSettingService remoteProjectBaseSettingService;
/*     */ 
/*     */   @Autowired
/*     */   private UserValidator userValidator;
/*     */ 
/*     */   @Autowired
/*     */   private UserAddressService userAddressService;
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_TRADE_PLACEO_RDER_SHOW_ADD})
/*     */   @RequestMapping(value={"placeOrder/trade"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String goPlaceOrder(@RequestParam(value="projectCode", required=true) String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/*  97 */     ServiceResult result = new ServiceResult();
/*  98 */     result = this.userValidator.isPermission(userAgent);
/*  99 */     if (!result.correct()) {
/* 100 */       model.put("message", result.getErrorInfo());
/* 101 */       return "error";
/*     */     }
/* 103 */     if (StringUtil.isEmpty(projectCode)) {
/* 104 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.GET_PROJECT_CODE_ERROR.getValue()), EnumTradeError.GET_PROJECT_CODE_ERROR.getName());
/*     */     }
/*     */ 
/* 108 */     ProjectInfoServiceResult pResult = this.projectService.getProjectInfo(projectCode);
/* 109 */     if (pResult.correct()) {
/* 110 */       ProjectInfo projectInfo = pResult.getProjectInfo();
/* 111 */       PlaceOrderInput placeOrderInput = ConvertUtils.converntProjectInfo2PlaceOrderINfo(projectInfo);
/*     */ 
/* 113 */       placeOrderInput.setUserAccount(userAgent.getAccount());
/* 114 */       placeOrderInput.setFundAccount(userAgent.getFundAccount());
/* 115 */       UserAddress queryAddress = new UserAddress();
/*     */ 
/* 121 */       if (EnumListingType.SELL.getValue().equals(projectInfo.getProjectListingDTO().getListingType()))
/* 122 */         queryAddress.setType("P");
/* 123 */       else if (EnumListingType.BUY.getValue().equals(projectInfo.getProjectListingDTO().getListingType())) {
/* 124 */         queryAddress.setType("S");
/*     */       }
/* 126 */       queryAddress.setUserAccount(userAgent.getAccount());
/* 127 */       queryAddress.setIsDefault("Y");
/* 128 */       UserAddress userAddress = new UserAddress();
/* 129 */       userAddress = this.userAddressService.getDefaultUserAddresses(queryAddress);
/* 130 */       model.addAttribute("userAddress", userAddress);
/* 131 */       prepareListingType(userAgent, model, projectInfo);
/* 132 */       model.addAttribute("placeOrderInput", placeOrderInput);
/*     */ 
/* 134 */       model.addAttribute("listingAccount", projectInfo.getProjectListingDTO().getUserAccount());
/* 135 */       model.addAttribute("addressType", queryAddress.getType());
/* 136 */       return "placeOrder/trade";
/*     */     }
/* 138 */     model.put("message", pResult.getErrorInfo());
/* 139 */     return "error";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_TRADE_PLACEO_RDER_DO_ADD})
/*     */   @RequestMapping(value={"placeOrder/trade"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String doPlaceOrder(UserAgent userAgent, @ModelAttribute("placeOrderInput") PlaceOrderInput placeOrderInput, BindingResult bdResult, ModelMap model)
/*     */   {
/* 154 */     this.log.info(placeOrderInput.toString());
/* 155 */     ServiceResult sresult = this.userValidator.isPermission(userAgent);
/* 156 */     if (!sresult.correct()) {
/* 157 */       model.put("message", sresult.getErrorInfo());
/* 158 */       return "error";
/*     */     }
/* 160 */     OrderServiceResult result = new OrderServiceResult();
/*     */ 
/* 162 */     placeOrderInput.setUserAccount(userAgent.getAccount());
/* 163 */     placeOrderInput.setFundAccount(userAgent.getFundAccount());
/*     */ 
/* 165 */     ProjectInfoServiceResult pResult = this.projectService.getProjectInfo(placeOrderInput.getProjectCode());
/*     */ 
/* 167 */     if (pResult.error()) {
/* 168 */       model.put("message", pResult.getErrorInfo());
/* 169 */       return "error";
/*     */     }
/* 171 */     this.placeOrderValidator.validate(placeOrderInput, bdResult);
/* 172 */     ProjectInfo projectInfo = pResult.getProjectInfo();
/*     */ 
/* 174 */     if (userAgent.getAccount().equals(projectInfo.getProjectListingDTO().getUserAccount())) {
/* 175 */       model.put("message", EnumTradeError.TRADE_WITH_ONESELF_ERROR.getName());
/* 176 */       return "error";
/*     */     }
/*     */ 
/* 179 */     if (bdResult.hasErrors()) {
/* 180 */       placeOrderInput = ConvertUtils.converntProjectInfo2PlaceOrderINfo(projectInfo);
/* 181 */       model.addAttribute("placeOrderInput", placeOrderInput);
/* 182 */       this.log.info("[placeOrderValidator] has error!!!");
/* 183 */       prepareListingType(userAgent, model, projectInfo);
/* 184 */       return "placeOrder/trade";
/*     */     }
/* 186 */     this.log.info("placeOrderValidator ok!!");
/* 187 */     Long quantity = placeOrderInput.getQuantity();
/* 188 */     ConvertUtils.copyBaseTradeToPalceOrder(placeOrderInput, projectInfo.getProjectListingDTO());
/* 189 */     Money money = new Money();
/* 190 */     placeOrderInput.setQuantity(quantity);
/* 191 */     money.setCent(projectInfo.getProjectListingDTO().getListingPrice().longValue());
/* 192 */     placeOrderInput.setTotalPay(Long.valueOf(money.multiply(placeOrderInput.getQuantity().longValue()).getCent()));
/* 193 */     placeOrderInput.setTradingType(EnumTradingType.PLACE_ORDER.getValue());
/* 194 */     if (EnumListingType.SELL.getValue().equals(projectInfo.getProjectListingDTO().getListingType()))
/*     */     {
/* 196 */       placeOrderInput.setListingType(EnumListingType.BUY.getValue());
/*     */     }
/* 198 */     else placeOrderInput.setListingType(EnumListingType.SELL.getValue());
/*     */ 
/* 200 */     if (this.log.isInfoEnabled()) {
/* 201 */       this.log.info("--begin to invoke in fengshan at TradeService : bargin--");
/*     */     }
/* 203 */     result = this.tradeService.bargain(EnumTradingType.PLACE_ORDER.getValue(), placeOrderInput);
/* 204 */     if (this.log.isInfoEnabled()) {
/* 205 */       this.log.info("-- invoke end in fengshan at TradeService : bargin--");
/*     */     }
/* 207 */     if (!result.correct()) {
/* 208 */       model.put("message", result.getErrorInfo());
/* 209 */       return "error";
/*     */     }
/* 211 */     setResult(model, result);
/*     */ 
/* 213 */     model.put("message", "下单成功！订单号为：" + result.getOrderNo());
/*     */ 
/* 215 */     model.put("confirmUrl", "/order/" + placeOrderInput.getListingType() + "/nodialogconfirm");
/* 216 */     model.put("listUrl", "/order/" + placeOrderInput.getListingType() + "/list");
/*     */ 
/* 218 */     model.put("orderNo", result.getOrderNo());
/* 219 */     return "/order/success";
/*     */   }
/*     */ 
/*     */   private void prepareListingType(UserAgent userAgent, ModelMap model, ProjectInfo projectInfo)
/*     */   {
/* 227 */     model.addAttribute("tradingTypes", EnumTradingType.values());
/* 228 */     model.addAttribute("measureUnits", EnumMeasureUnit.values());
/* 229 */     model.addAttribute("valuationUnits", EnumValuationUnit.values());
/* 230 */     if (projectInfo.getProjectListingDTO().getDeliveryType() != null) {
/* 231 */       String[] deliverTypeList = projectInfo.getProjectListingDTO().getDeliveryType().split(",");
/*     */ 
/* 233 */       List deliverTypell = new ArrayList();
/* 234 */       for (int i = 0; i < deliverTypeList.length; i++) {
/* 235 */         if (deliverTypeList[i] != null) {
/* 236 */           deliverTypell.add(EnumDeliveryType.indexByValue(deliverTypeList[i]));
/*     */         }
/*     */       }
/* 239 */       model.addAttribute("deliveryTypes", deliverTypell);
/*     */     }
/* 241 */     if (projectInfo.getProjectListingDTO().getPaymentType() != null) {
/* 242 */       String[] getPaymentTypeList = projectInfo.getProjectListingDTO().getPaymentType().split(",");
/*     */ 
/* 244 */       List paymentTypes = new ArrayList();
/* 245 */       for (int i = 0; i < getPaymentTypeList.length; i++) {
/* 246 */         if (getPaymentTypeList[i] != null) {
/* 247 */           paymentTypes.add(EnumPaymentType.indexByValue(getPaymentTypeList[i]));
/*     */         }
/*     */       }
/* 250 */       model.addAttribute("paymentTypes", paymentTypes);
/*     */     }
/* 252 */     if (projectInfo.getProjectListingDTO().getInvoice() != null) {
/* 253 */       String[] getInvoiceList = projectInfo.getProjectListingDTO().getInvoice().split(",");
/* 254 */       List invoices = new ArrayList();
/* 255 */       for (int i = 0; i < getInvoiceList.length; i++) {
/* 256 */         if (getInvoiceList[i] != null) {
/* 257 */           invoices.add(EnumInvoice.indexByValue(getInvoiceList[i].trim()));
/*     */         }
/*     */       }
/* 260 */       model.addAttribute("invoices", invoices);
/*     */     }
/* 262 */     Long tradeDeposit = Long.valueOf(0L);
/*     */     try {
/* 264 */       tradeDeposit = getDeposit(projectInfo, userAgent);
/*     */     } catch (ServiceException e) {
/* 266 */       this.log.error("", e);
/* 267 */       model.put("message", "获取用户保证金错误");
/*     */     }
/* 269 */     BigDecimal bg = new BigDecimal(tradeDeposit.longValue());
/* 270 */     model.addAttribute("tradeDeposit", bg.movePointLeft(4).toString());
/*     */   }
/*     */ 
/*     */   private Long getDeposit(ProjectInfo projectInfo, UserAgent userAgent)
/*     */     throws ServiceException
/*     */   {
/* 280 */     String userAccount = userAgent.getAccount();
/* 281 */     UserLevelDTO userLevelDTO = getUserLevelByAccount(userAccount);
/* 282 */     UserCreditDTO userCreditDTO = getUserCredit(userAccount);
/*     */ 
/* 284 */     ProjectBaseSettingRequest pbsRequest = new ProjectBaseSettingRequest();
/* 285 */     pbsRequest.setDictParaCode(EnumSystemDictKey.ORDER_JY_PROPORTION.getValue());
/* 286 */     pbsRequest.setProTypeCode(projectInfo.getProjectListingDTO().getProjectTypeCode());
/* 287 */     pbsRequest.setTradingType(EnumTradingType.PLACE_ORDER.getValue());
/*     */ 
/* 289 */     String memberLevel = userLevelDTO.getMemberLevel();
/* 290 */     Long goodComment = Long.valueOf(0L);
/* 291 */     Long badComment = Long.valueOf(0L);
/* 292 */     if (EnumListingType.BUY.getValue().equals(projectInfo.getProjectListingDTO().getListingType()))
/*     */     {
/* 294 */       goodComment = userCreditDTO.getSellerGoodNum();
/* 295 */       badComment = userCreditDTO.getSellerBadNum();
/*     */     } else {
/* 297 */       goodComment = userCreditDTO.getBuyGoodNum();
/* 298 */       badComment = userCreditDTO.getBuyBadNum();
/*     */     }
/*     */ 
/* 301 */     pbsRequest.setMemberLevel(memberLevel);
/* 302 */     pbsRequest.setGoodComment(goodComment);
/* 303 */     pbsRequest.setBadComment(badComment);
/* 304 */     ProjectBaseSettingServiceResult pbssResult = this.remoteProjectBaseSettingService.getProjectBaseSet(pbsRequest);
/*     */ 
/* 306 */     return pbssResult.getProjectBaseSettingDTO().getOrderJyProportion();
/*     */   }
/*     */ 
/*     */   private UserLevelDTO getUserLevelByAccount(String userAccount)
/*     */     throws ServiceException
/*     */   {
/* 316 */     UserLevelRequest request = new UserLevelRequest();
/* 317 */     request.setUserAccount(userAccount);
/* 318 */     UserLevelServiceResult ulResult = this.remoteUserService.selectUserLevelByAccount(request);
/* 319 */     if (ulResult == null) {
/* 320 */       throw new ServiceException("qingbo调用 remoteUserService 会的会员级别失败：" + EnumTradeResultErrors.SERVER_ERROR.getInfo(), Integer.valueOf(EnumTradeResultErrors.SERVER_ERROR.getValue()));
/*     */     }
/*     */ 
/* 324 */     if (!ulResult.correct()) {
/* 325 */       throw new ServiceException(ulResult.getErrorInfo(), Integer.valueOf(ulResult.getErrorNO().intValue()));
/*     */     }
/*     */ 
/* 328 */     return ulResult.getUserLevelDTO();
/*     */   }
/*     */ 
/*     */   private UserCreditDTO getUserCredit(String userAccount)
/*     */     throws ServiceException
/*     */   {
/* 337 */     UserCreditRequest ucRequest = new UserCreditRequest();
/* 338 */     ucRequest.setUserAccount(userAccount);
/* 339 */     UserCreditServiceResult ucResult = this.remoteUserService.selectByUserAccount(ucRequest);
/* 340 */     if (ucResult == null) {
/* 341 */       throw new ServiceException("qingbo调用 remoteUserService 获得会员信誉失败：" + EnumTradeResultErrors.SERVER_ERROR.getInfo(), Integer.valueOf(EnumTradeResultErrors.SERVER_ERROR.getValue()));
/*     */     }
/*     */ 
/* 345 */     if (!ucResult.correct()) {
/* 346 */       throw new ServiceException(ucResult.getErrorInfo(), Integer.valueOf(ucResult.getErrorNO().intValue()));
/*     */     }
/*     */ 
/* 349 */     return ucResult.getUserCreditDTO();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.web.action.placeorder.PlaceOrderAction
 * JD-Core Version:    0.6.0
 */