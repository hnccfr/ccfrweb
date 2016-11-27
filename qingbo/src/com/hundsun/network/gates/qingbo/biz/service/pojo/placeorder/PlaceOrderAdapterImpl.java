/*     */ package com.hundsun.network.gates.qingbo.biz.service.pojo.placeorder;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*     */ import com.hundsun.network.gates.luosi.biz.service.TradeAdapter;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.PlaceOrderTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.enums.EnumTradeResultErrors;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectBaseSettingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDetailDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeWishOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserCreditDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserLevelDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectBaseSettingRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeWishOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserCreditRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLevelRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectBaseSettingServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeWishOrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserCreditServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserLevelServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectBaseSettingService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.cash.TradeCashDTO;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.cash.CashService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.project.ProjectService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.trade.TradeWishOrderService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.qingbo.biz.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.qingbo.common.MobileMessageUtil;
/*     */ import com.hundsun.network.melody.common.util.Money;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ public class PlaceOrderAdapterImpl extends BaseService
/*     */   implements TradeAdapter<PlaceOrderTradeDTO>
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderService tradeWishOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteTradeOrderService remoteTradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteProjectBaseSettingService remoteProjectBaseSettingService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   private CashService cashService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectService projectService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @Autowired
/*     */   private MobileMessageUtil mobileMessageUtil;
/*     */ 
/*     */   public OrderServiceResult bargain(PlaceOrderTradeDTO placeOrderTradeDTO)
/*     */   {
/*  87 */     if (this.log.isInfoEnabled()) {
/*  88 */       this.log.info("--Do bargin BEGIN in qingbo at PlaceOrderAdapterImpl.java--");
/*     */     }
/*  90 */     OrderServiceResult result = new OrderServiceResult();
/*     */ 
/*  92 */     final PlaceOrderTradeDTO poTradeDTO = placeOrderTradeDTO;
/*     */ 
/*  94 */     result = (OrderServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public OrderServiceResult doInTransaction(TransactionStatus status) {
/*  96 */         Object savePoint = status.createSavepoint();
/*  97 */         OrderServiceResult result1 = new OrderServiceResult();
/*     */         try
/*     */         {
/* 100 */           String projectTypeCode = poTradeDTO.getProjectTypeCode();
/* 101 */           String userAccount = poTradeDTO.getUserAccount();
/* 102 */           UserLevelDTO userLevelDTO = PlaceOrderAdapterImpl.this.getUserLevelByAccount(userAccount);
/* 103 */           UserCreditDTO userCreditDTO = PlaceOrderAdapterImpl.this.getUserCredit(userAccount);
/* 104 */           Long totalPay = Long.valueOf(0L);
/* 105 */           BigDecimal gb = new BigDecimal(poTradeDTO.getListingPrice().longValue());
/* 106 */           gb = gb.multiply(new BigDecimal(poTradeDTO.getQuantity().longValue()));
/* 107 */           totalPay = Long.valueOf(gb.longValue());
/* 108 */           String memberLevel = userLevelDTO.getMemberLevel();
/* 109 */           Long goodComment = Long.valueOf(0L);
/* 110 */           Long badComment = Long.valueOf(0L);
/*     */ 
/* 112 */           if (EnumListingType.BUY.getValue().equals(poTradeDTO.getListingType())) {
/* 113 */             goodComment = userCreditDTO.getBuyGoodNum();
/* 114 */             badComment = userCreditDTO.getBuyBadNum();
/*     */           } else {
/* 116 */             goodComment = userCreditDTO.getSellerGoodNum();
/* 117 */             badComment = userCreditDTO.getSellerBadNum();
/*     */           }
/* 119 */           Long orderJyProportionCash = PlaceOrderAdapterImpl.this.getOrderJyProportionCash(totalPay, projectTypeCode, memberLevel, goodComment, badComment);
/*     */ 
/* 122 */           TradeWishOrderServiceResult twoResult = PlaceOrderAdapterImpl.this.clearWishOrder(orderJyProportionCash, poTradeDTO);
/*     */ 
/* 124 */           String wishOrderNo = null;
/* 125 */           if ((twoResult == null) || (!twoResult.correct())) {
/* 126 */             if (twoResult == null) {
/* 127 */               result1.setErrorNO(Integer.valueOf(EnumTradeResultErrors.REMOTE_WISH_ORDER_CALL_ERROR.getValue()));
/*     */ 
/* 129 */               result1.setErrorInfo("qingbo调用  意向单失败：" + EnumTradeResultErrors.REMOTE_WISH_ORDER_CALL_ERROR.getInfo());
/*     */             }
/*     */ 
/* 134 */             return result1;
/*     */           }
/* 136 */           wishOrderNo = twoResult.getTradeWishOrderDTO().getWishOrderNum();
/*     */ 
/* 139 */           Long listingturnover = Long.valueOf(0L);
/*     */ 
/* 147 */           ProjectListingServiceResult projectResult = PlaceOrderAdapterImpl.this.clearProject(poTradeDTO);
/* 148 */           if ((projectResult == null) || (!projectResult.correct())) {
/* 149 */             if (projectResult == null) {
/* 150 */               result1.setErrorNO(Integer.valueOf(EnumTradeResultErrors.REMOTE_PROJECT_CALL_ERROR.getValue()));
/*     */ 
/* 152 */               result1.setErrorInfo("qingbo调用 挂牌项目库存更新失败：" + EnumTradeResultErrors.REMOTE_PROJECT_CALL_ERROR.getInfo());
/*     */ 
/* 155 */               throw new ServiceException(result1.getErrorInfo(), result1.getErrorNO());
/*     */             }
/* 157 */             throw new ServiceException(projectResult.getErrorInfo(), projectResult.getErrorNO());
/*     */           }
/*     */ 
/* 163 */           TradeOrderServiceResult toResult = PlaceOrderAdapterImpl.this.clearOrder(poTradeDTO, wishOrderNo, orderJyProportionCash);
/*     */ 
/* 165 */           if ((toResult == null) || (!toResult.correct())) {
/* 166 */             if (toResult == null) {
/* 167 */               result1.setErrorNO(Integer.valueOf(EnumTradeResultErrors.REMOTE_ORDER_CALL_ERROR.getValue()));
/*     */ 
/* 169 */               result1.setErrorInfo("qingbo调用 订单 失败：" + EnumTradeResultErrors.REMOTE_ORDER_CALL_ERROR.getInfo());
/*     */             }
/*     */             else
/*     */             {
/* 173 */               result1.setErrorNO(toResult.getErrorNO());
/* 174 */               result1.setErrorInfo(toResult.getErrorInfo());
/*     */             }
/* 176 */             throw new ServiceException(result1.getErrorInfo(), result1.getErrorNO());
/*     */           }
/*     */ 
/* 179 */           String orderNo = toResult.getOrderNo();
/*     */ 
/* 182 */           if ((StringUtil.isEmpty(wishOrderNo)) || (wishOrderNo == null)) {
/* 183 */             PlaceOrderAdapterImpl.this.log.debug("形成意向单编号失败！");
/* 184 */             result1.setErrorNO(Integer.valueOf(EnumTradeResultErrors.GET_WISH_ORDER_NO_ERROR.getValue()));
/*     */ 
/* 186 */             result1.setErrorInfo("qingbo 生成意向单 失败：" + EnumTradeResultErrors.GET_WISH_ORDER_NO_ERROR.getInfo());
/*     */ 
/* 189 */             throw new ServiceException(result1.getErrorInfo(), result1.getErrorNO());
/*     */           }
/* 191 */           ServiceResult cashresult = new ServiceResult();
/* 192 */           cashresult = PlaceOrderAdapterImpl.this.clearCash(poTradeDTO, orderNo, orderJyProportionCash, listingturnover);
/*     */ 
/* 194 */           if ((cashresult == null) || (!cashresult.correct())) {
/* 195 */             if (cashresult == null) {
/* 196 */               result1.setErrorNO(Integer.valueOf(EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getValue()));
/*     */ 
/* 198 */               result1.setErrorInfo("qingbo调用 调用资金失败：" + EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getInfo());
/*     */             }
/*     */             else
/*     */             {
/* 202 */               result1.setErrorNO(cashresult.getErrorNO());
/* 203 */               result1.setErrorInfo(cashresult.getErrorInfo());
/*     */             }
/*     */ 
/* 206 */             PlaceOrderAdapterImpl.this.rollbackClearOrder(toResult.getOrderNo());
/*     */ 
/* 208 */             throw new ServiceException(result1.getErrorInfo(), result1.getErrorNO());
/*     */           }
/* 210 */           result1.setOrderNo(toResult.getOrderNo());
/* 211 */           return result1;
/*     */         } catch (ServiceException e) {
/* 213 */           status.rollbackToSavepoint(savePoint);
/* 214 */           PlaceOrderAdapterImpl.this.log.error("TradeOrderServiceImpl orderConfirm fail", e);
/* 215 */           result1.setErrorNO(e.getErrorNO());
/* 216 */           result1.setErrorInfo(e.getErrorInfo());
/* 217 */           return result1;
/*     */         } catch (Exception e) {
/* 219 */           status.rollbackToSavepoint(savePoint);
/* 220 */           PlaceOrderAdapterImpl.this.log.error("TradeOrderServiceImpl orderConfirm error", e);
/* 221 */           result1.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 222 */           result1.setErrorInfo("qingbo调用 订单 失败：" + EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/*     */         }
/* 224 */         return result1;
/*     */       }
/*     */     });
/* 229 */     if (this.log.isInfoEnabled()) {
/* 230 */       this.log.info("--Do bargin END in qingbo at PlaceOrderAdapterImpl.java--");
/*     */     }
/*     */ 
/* 233 */     return result;
/*     */   }
/*     */ 
/*     */   private Long getOrderJyProportionCash(Long totalPay, String projectTypeCode, String memberLevel, Long goodComment, Long badComment)
/*     */     throws ServiceException
/*     */   {
/* 249 */     ProjectBaseSettingRequest pbsRequest = new ProjectBaseSettingRequest();
/* 250 */     pbsRequest.setDictParaCode(EnumSystemDictKey.ORDER_JY_PROPORTION.getValue());
/* 251 */     pbsRequest.setProTypeCode(projectTypeCode);
/* 252 */     pbsRequest.setTradingType(EnumTradingType.PLACE_ORDER.getValue());
/* 253 */     pbsRequest.setMemberLevel(memberLevel);
/* 254 */     pbsRequest.setGoodComment(goodComment);
/* 255 */     pbsRequest.setBadComment(badComment);
/* 256 */     ProjectBaseSettingServiceResult pbssResult = this.remoteProjectBaseSettingService.getProjectBaseSet(pbsRequest);
/*     */ 
/* 258 */     BigDecimal orderJyProportion = BigDecimal.valueOf(0L);
/* 259 */     if ((pbssResult == null) || (pbssResult.getProjectBaseSettingDTO() == null)) {
/* 260 */       throw new ServiceException("qingbo调用 remoteProjectBaseSettingService失败：" + EnumTradeResultErrors.GET_PROJECT_BASE_INFO_ERROR.getInfo(), Integer.valueOf(EnumTradeResultErrors.GET_PROJECT_BASE_INFO_ERROR.getValue()));
/*     */     }
/*     */ 
/* 265 */     if (!pbssResult.correct()) {
/* 266 */       throw new ServiceException(pbssResult.getErrorInfo(), Integer.valueOf(pbssResult.getErrorNO().intValue()));
/*     */     }
/*     */ 
/* 269 */     if (pbssResult.getProjectBaseSettingDTO().getOrderJyProportion() != null) {
/* 270 */       orderJyProportion = BigDecimal.valueOf(pbssResult.getProjectBaseSettingDTO().getOrderJyProportion().longValue()).movePointLeft(4);
/*     */     }
/*     */ 
/* 273 */     Money money = new Money();
/* 274 */     money.setCent(totalPay.longValue());
/* 275 */     Long orderJyProportionCash = Long.valueOf(money.multiply(orderJyProportion).getCent());
/* 276 */     return orderJyProportionCash;
/*     */   }
/*     */ 
/*     */   private UserCreditDTO getUserCredit(String userAccount)
/*     */     throws ServiceException
/*     */   {
/* 302 */     UserCreditRequest ucRequest = new UserCreditRequest();
/* 303 */     ucRequest.setUserAccount(userAccount);
/* 304 */     UserCreditServiceResult ucResult = this.remoteUserService.selectByUserAccount(ucRequest);
/* 305 */     if (ucResult == null) {
/* 306 */       throw new ServiceException("qingbo调用 remoteUserService 获得会员信誉失败：" + EnumTradeResultErrors.SERVER_ERROR.getInfo(), Integer.valueOf(EnumTradeResultErrors.SERVER_ERROR.getValue()));
/*     */     }
/*     */ 
/* 310 */     if (!ucResult.correct()) {
/* 311 */       throw new ServiceException(ucResult.getErrorInfo(), Integer.valueOf(ucResult.getErrorNO().intValue()));
/*     */     }
/*     */ 
/* 314 */     return ucResult.getUserCreditDTO();
/*     */   }
/*     */ 
/*     */   private UserLevelDTO getUserLevelByAccount(String userAccount)
/*     */     throws ServiceException
/*     */   {
/* 323 */     UserLevelRequest request = new UserLevelRequest();
/* 324 */     request.setUserAccount(userAccount);
/* 325 */     UserLevelServiceResult ulResult = this.remoteUserService.selectUserLevelByAccount(request);
/* 326 */     if (ulResult == null) {
/* 327 */       throw new ServiceException("qingbo调用 remoteUserService 会的会员级别失败：" + EnumTradeResultErrors.SERVER_ERROR.getInfo(), Integer.valueOf(EnumTradeResultErrors.SERVER_ERROR.getValue()));
/*     */     }
/*     */ 
/* 331 */     if (!ulResult.correct()) {
/* 332 */       throw new ServiceException(ulResult.getErrorInfo(), Integer.valueOf(ulResult.getErrorNO().intValue()));
/*     */     }
/*     */ 
/* 335 */     return ulResult.getUserLevelDTO();
/*     */   }
/*     */ 
/*     */   private TradeWishOrderServiceResult clearWishOrder(Long orderJyProportionCash, PlaceOrderTradeDTO placeOrderTradeDTO)
/*     */     throws Exception
/*     */   {
/* 345 */     ProjectListing projectListing = this.projectService.getProjectListingByCode(placeOrderTradeDTO.getProjectCode());
/* 346 */     TradeWishOrderServiceResult toResult = new TradeWishOrderServiceResult();
/* 347 */     TradeWishOrder tradeWishOrder = new TradeWishOrder();
/* 348 */     tradeWishOrder = ConvertUtils.convertTradeWishOrderDTO2TradeWishOrder(placeOrderTradeDTO, projectListing);
/* 349 */     tradeWishOrder.setDeposit(orderJyProportionCash);
/* 350 */     tradeWishOrder.setStatus(EnumTradeWishOrderStatus.DONE.getValue());
/* 351 */     tradeWishOrder.setTradeType(EnumTradingType.PLACE_ORDER.getValue());
/* 352 */     tradeWishOrder.setSubstationId(projectListing.getSubstationId());
/* 353 */     toResult = this.tradeWishOrderService.addTradeWishOrder(tradeWishOrder);
/* 354 */     return toResult;
/*     */   }
/*     */ 
/*     */   private ServiceResult rollbackClearWishOrder(String tradeWishOrderNo)
/*     */   {
/* 364 */     ServiceResult result = new ServiceResult();
/*     */ 
/* 366 */     if (this.tradeWishOrderService.deleteTradeWishOrderByNo(tradeWishOrderNo)) {
/* 367 */       this.log.debug("删除根据意向单编号：" + tradeWishOrderNo + " 删除失败");
/* 368 */       result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.WISH_ORDER_DELETE_ERROR.getValue()));
/* 369 */       result.setErrorInfo(EnumTradeResultErrors.WISH_ORDER_DELETE_ERROR.getInfo());
/*     */     }
/* 371 */     return result;
/*     */   }
/*     */ 
/*     */   private TradeOrderServiceResult clearOrder(PlaceOrderTradeDTO placeOrderTradeDTO, String tradeWishOrderNo, Long orderJyProportionCash)
/*     */     throws Exception
/*     */   {
/* 385 */     String projectCode = placeOrderTradeDTO.getProjectCode();
/* 386 */     ProjectListing projectListing = this.projectService.getProjectListingByCode(projectCode);
/* 387 */     TradeOrderRequest request = new TradeOrderRequest();
/* 388 */     TradeOrderDetailDTO tradeOrderDetailDTO = new TradeOrderDetailDTO();
/* 389 */     TradeOrderDTO tradeOrderDTO = new TradeOrderDTO();
/*     */ 
/* 391 */     tradeOrderDTO = ConvertUtils.converntPlaceOrderTradeDTO2TradeOrderDTO(placeOrderTradeDTO);
/* 392 */     tradeOrderDTO.setSubstationId(projectListing.getSubstationId());
/*     */ 
/* 394 */     tradeOrderDTO.setTradingType(EnumTradingType.PLACE_ORDER.getValue());
/* 395 */     if (EnumListingType.SELL.getValue().equals(projectListing.getListingType()))
/*     */     {
/* 398 */       tradeOrderDTO.setSellerAccount(projectListing.getUserAccount());
/* 399 */       tradeOrderDTO.setBuyerAccount(placeOrderTradeDTO.getUserAccount());
/* 400 */       tradeOrderDetailDTO.setSellerLinkMan(projectListing.getLinkMan());
/* 401 */       tradeOrderDetailDTO.setSellerPhone(projectListing.getPhone());
/* 402 */       tradeOrderDetailDTO.setSellerProvince(projectListing.getProvince());
/* 403 */       tradeOrderDetailDTO.setSellerCity(projectListing.getCity());
/* 404 */       tradeOrderDetailDTO.setSellerArea(projectListing.getArea());
/* 405 */       tradeOrderDetailDTO.setSellerZipCode(projectListing.getZipCode());
/* 406 */       tradeOrderDetailDTO.setSellerAddress(projectListing.getAddress());
/* 407 */       tradeOrderDetailDTO.setSellerName(projectListing.getLinkMan());
/* 408 */       tradeOrderDetailDTO.setStorehouse(projectListing.getStorehouse());
/* 409 */       tradeOrderDetailDTO.setSellerCompany(null);
/*     */ 
/* 411 */       tradeOrderDetailDTO.setBuyerLinkMan(placeOrderTradeDTO.getLinkMan());
/* 412 */       tradeOrderDetailDTO.setBuyerPhone(placeOrderTradeDTO.getPhone());
/* 413 */       tradeOrderDetailDTO.setBuyerProvince(placeOrderTradeDTO.getProvince());
/* 414 */       tradeOrderDetailDTO.setBuyerCity(placeOrderTradeDTO.getCity());
/* 415 */       tradeOrderDetailDTO.setBuyerArea(placeOrderTradeDTO.getArea());
/* 416 */       tradeOrderDetailDTO.setBuyerZipCode(placeOrderTradeDTO.getZipCode());
/* 417 */       tradeOrderDetailDTO.setBuyerAddress(placeOrderTradeDTO.getAddress());
/* 418 */       tradeOrderDetailDTO.setBuyerName(placeOrderTradeDTO.getLinkMan());
/*     */ 
/* 420 */       tradeOrderDetailDTO.setBuyerCompany(null);
/* 421 */       Money money = new Money();
/* 422 */       money.setCent(projectListing.getDeposit().longValue());
/* 423 */       tradeOrderDTO.setSellerDepositAmount(Long.valueOf(money.multiply(placeOrderTradeDTO.getQuantity().longValue()).getCent()));
/*     */ 
/* 425 */       tradeOrderDTO.setBuyerDepositAmount(orderJyProportionCash);
/*     */     }
/*     */     else
/*     */     {
/* 429 */       tradeOrderDTO.setSellerAccount(placeOrderTradeDTO.getUserAccount());
/* 430 */       tradeOrderDTO.setBuyerAccount(projectListing.getUserAccount());
/* 431 */       tradeOrderDetailDTO.setSellerLinkMan(placeOrderTradeDTO.getLinkMan());
/* 432 */       tradeOrderDetailDTO.setSellerPhone(placeOrderTradeDTO.getPhone());
/* 433 */       tradeOrderDetailDTO.setSellerProvince(placeOrderTradeDTO.getProvince());
/* 434 */       tradeOrderDetailDTO.setSellerCity(placeOrderTradeDTO.getCity());
/* 435 */       tradeOrderDetailDTO.setSellerArea(placeOrderTradeDTO.getArea());
/* 436 */       tradeOrderDetailDTO.setSellerZipCode(placeOrderTradeDTO.getZipCode());
/* 437 */       tradeOrderDetailDTO.setSellerAddress(placeOrderTradeDTO.getAddress());
/* 438 */       tradeOrderDetailDTO.setSellerName(placeOrderTradeDTO.getLinkMan());
/*     */ 
/* 440 */       tradeOrderDetailDTO.setSellerCompany(null);
/*     */ 
/* 442 */       tradeOrderDetailDTO.setBuyerLinkMan(projectListing.getLinkMan());
/* 443 */       tradeOrderDetailDTO.setBuyerPhone(projectListing.getPhone());
/* 444 */       tradeOrderDetailDTO.setBuyerProvince(projectListing.getProvince());
/* 445 */       tradeOrderDetailDTO.setBuyerCity(projectListing.getCity());
/* 446 */       tradeOrderDetailDTO.setBuyerArea(projectListing.getArea());
/* 447 */       tradeOrderDetailDTO.setBuyerZipCode(projectListing.getZipCode());
/* 448 */       tradeOrderDetailDTO.setBuyerAddress(projectListing.getAddress());
/* 449 */       tradeOrderDetailDTO.setBuyerName(projectListing.getLinkMan());
/* 450 */       tradeOrderDetailDTO.setStorehouse(placeOrderTradeDTO.getStorehouse());
/* 451 */       tradeOrderDetailDTO.setBuyerCompany(null);
/* 452 */       Money money = new Money();
/* 453 */       money.setCent(projectListing.getDeposit().longValue());
/* 454 */       tradeOrderDTO.setBuyerDepositAmount(Long.valueOf(money.multiply(placeOrderTradeDTO.getQuantity().longValue()).getCent()));
/*     */ 
/* 456 */       tradeOrderDTO.setSellerDepositAmount(orderJyProportionCash);
/*     */     }
/*     */ 
/* 459 */     tradeOrderDetailDTO.setRemark(placeOrderTradeDTO.getComments());
/* 460 */     tradeOrderDTO.setWishOrderNum(tradeWishOrderNo);
/* 461 */     tradeOrderDTO.setCreator(placeOrderTradeDTO.getUserAccount());
/*     */ 
/* 463 */     request.setSellTradeDeposit(tradeOrderDTO.getSellerDepositAmount());
/* 464 */     request.setBuyTradeDeposit(tradeOrderDTO.getBuyerDepositAmount());
/*     */ 
/* 466 */     request.setTradeOrderDTO(tradeOrderDTO);
/* 467 */     request.setTradeOrderDetailDTO(tradeOrderDetailDTO);
/*     */ 
/* 469 */     request.setOperator(placeOrderTradeDTO.getUserAccount());
/* 470 */     TradeOrderServiceResult tosResult = this.remoteTradeOrderService.initAddOrder(request);
/*     */ 
/* 472 */     if ((tosResult != null) && (tosResult.correct())) {
/*     */       try
/*     */       {
/* 475 */         List nums = new ArrayList();
/* 476 */         UserAccount userAccount = this.userAccountService.getUserByAccount(projectListing.getUserAccount());
/* 477 */         nums.add(userAccount.getMobile());
/* 478 */         UserAccount bidderAccount = this.userAccountService.getUserByAccount(placeOrderTradeDTO.getUserAccount());
/* 479 */         nums.add(bidderAccount.getMobile());
/* 480 */         String msg = projectListing.getTitle() + "项目已成交，请及时登录个人中心确认订单【中部林业产权交易服务中心】";
/* 481 */         this.mobileMessageUtil.sendMsg(nums, msg);
/*     */       } catch (Exception e) {
/* 483 */         this.log.error("send mobileMessage for placeOrder clearOrder error cause by:" + e);
/*     */       }
/*     */     }
/*     */ 
/* 487 */     return tosResult;
/*     */   }
/*     */ 
/*     */   private ServiceResult rollbackClearOrder(String orderNo)
/*     */   {
/* 496 */     TradeOrderRequest request = new TradeOrderRequest();
/* 497 */     request.setOrderNo(orderNo);
/* 498 */     TradeOrderServiceResult tosResult = this.remoteTradeOrderService.rollbackOrder(request);
/* 499 */     return tosResult;
/*     */   }
/*     */ 
/*     */   private ServiceResult clearCash(PlaceOrderTradeDTO placeOrderTradeDTO, String wishOrderNo, Long orderJyProportionCash, Long listingturnover)
/*     */     throws Exception
/*     */   {
/* 509 */     ServiceResult result = new ServiceResult();
/* 510 */     TradeCashDTO tradeCashDTO = new TradeCashDTO();
/* 511 */     tradeCashDTO = ConvertUtils.converntPlaceOrderTradeDTO2TradeCashDTO(placeOrderTradeDTO);
/* 512 */     result = this.cashService.tradeClearCash(tradeCashDTO, wishOrderNo, orderJyProportionCash, listingturnover);
/*     */ 
/* 514 */     return result;
/*     */   }
/*     */ 
/*     */   private ServiceResult rollBackClearCash(PlaceOrderTradeDTO placeOrderTradeDTO)
/*     */   {
/* 524 */     TradeWishOrderServiceResult toResult = new TradeWishOrderServiceResult();
/* 525 */     TradeWishOrderDTO tradeWishOrderDTO = new TradeWishOrderDTO();
/* 526 */     TradeWishOrderRequest toRequest = new TradeWishOrderRequest();
/* 527 */     return toResult;
/*     */   }
/*     */ 
/*     */   private ProjectListingServiceResult clearProject(PlaceOrderTradeDTO placeOrderTradeDTO)
/*     */     throws Exception
/*     */   {
/* 536 */     ProjectListingServiceResult pResult = this.projectService.tradeClearProject(placeOrderTradeDTO);
/* 537 */     return pResult;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.pojo.placeorder.PlaceOrderAdapterImpl
 * JD-Core Version:    0.6.0
 */