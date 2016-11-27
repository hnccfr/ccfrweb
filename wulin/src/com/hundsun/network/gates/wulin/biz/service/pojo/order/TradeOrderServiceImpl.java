/*      */ package com.hundsun.network.gates.wulin.biz.service.pojo.order;
/*      */ 
/*      */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemServicechargeSpecialType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*      */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*      */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*      */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumGoodsAmountType;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumPenaltyType;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*      */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectBaseSettingDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectBaseSettingRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemServicechargeSpecialRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCashDepositRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectBaseSettingServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemServicechargeSpecialResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCashDepositResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderFinishedServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectBaseSettingService;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemDictDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDetailDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderMoneyDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectListingDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectMetasDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.baseset.BaseDay;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserCredit;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserLevel;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderAndPro;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderDetail;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.query.TradeOrderQuery;
/*      */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*      */ import com.hundsun.network.gates.wulin.biz.factory.TradeOrderBrokenServiceFactory;
/*      */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.baseset.BaseDayService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserCreditService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserLevelService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderBrokenService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderLogService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods.TradeOrderCheckGoodsProcessService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.pojo.order.checkticket.TradeOrderCheckTicketProcessService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.pojo.order.penaltycheckgoods.PenaltyCheckGoodsProcessService;
/*      */ import com.hundsun.network.gates.wulin.biz.service.user.UserService;
/*      */ import com.hundsun.network.melody.common.util.Money;
/*      */ import com.hundsun.network.melody.common.util.StringUtil;
/*      */ import java.math.BigDecimal;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.apache.commons.logging.LogFactory;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.stereotype.Service;
/*      */ import org.springframework.transaction.TransactionStatus;
/*      */ import org.springframework.transaction.support.TransactionCallback;
/*      */ import org.springframework.transaction.support.TransactionTemplate;
/*      */ 
/*      */ @Service("tradeOrderService")
/*      */ public class TradeOrderServiceImpl extends BaseService
/*      */   implements TradeOrderService
/*      */ {
/*   91 */   protected final Log logger = LogFactory.getLog(getClass());
/*      */ 
/*      */   @Autowired
/*      */   private TradeOrderDAO tradeOrderDAO;
/*      */ 
/*      */   @Autowired
/*      */   private TradeOrderDetailDAO tradeOrderDetailDAO;
/*      */ 
/*      */   @Autowired
/*      */   private UserCreditService userCreditService;
/*      */ 
/*      */   @Autowired
/*      */   private UserLevelService userLevelService;
/*      */ 
/*      */   @Autowired
/*      */   private UserAccountDAO userAccountDAO;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteProjectBaseSettingService remoteProjectBaseSettingService;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectListingDAO projectListingDAO;
/*      */ 
/*      */   @Autowired
/*      */   private TradeOrderLogService tradeOrderLogService;
/*      */ 
/*      */   @Autowired
/*      */   private TradeOrderMoneyDAO tradeOrderMoneyDAO;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteSystemBaseService remoteSystemBaseService;
/*      */ 
/*      */   @Autowired
/*      */   private UserService userService;
/*      */ 
/*      */   @Autowired
/*      */   private SystemDictDAO systemDictDAO;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteFundService remoteFundService;
/*      */ 
/*      */   @Autowired
/*      */   private TradeOrderBrokenServiceFactory tradeOrderBrokenServiceFactory;
/*      */ 
/*      */   @Autowired
/*      */   private TradeOrderCheckGoodsProcessService tradeOrderCheckGoodsProcessService;
/*      */ 
/*      */   @Autowired
/*      */   private TradeOrderCheckTicketProcessService tradeOrderCheckTicketProcessService;
/*      */ 
/*      */   @Autowired
/*      */   private PenaltyCheckGoodsProcessService penaltyCheckGoodsProcessService;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectMetasDAO projectMetasDAO;
/*      */ 
/*      */   @Autowired
/*      */   private BaseDayService baseDayService;
/*      */ 
/*  138 */   public TradeOrder selectByOrderNo(String orderNo) { return this.tradeOrderDAO.selectByOrderNo(orderNo);
/*      */   }
/*      */ 
/*      */   public TradeOrderDetail selectDetailByOrderNo(String orderNo)
/*      */   {
/*  147 */     return this.tradeOrderDetailDAO.selectByOrderNo(orderNo);
/*      */   }
/*      */ 
/*      */   public int updateParamByOrderNo(Map<String, Object> paramMap, String orderNo)
/*      */   {
/*  157 */     return this.tradeOrderDAO.updateParamByOrderNo(paramMap, orderNo);
/*      */   }
/*      */ 
/*      */   public TradeOrderServiceResult initAddOrder(TradeOrder tradeOrder, TradeOrderDetail tradeOrderDetail, final String operator, Long buyTradeDeposit, Long sellTradeDeposit)
/*      */   {
/*  170 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/*  171 */     final String orderNo = this.tradeOrderDAO.generalOrderNo();
/*  172 */     tradeOrder.setOrderNo(orderNo);
/*  173 */     tradeOrderDetail.setOrderNo(orderNo);
/*  174 */     tradeOrder.setStatus(EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue());
/*      */ 
/*  176 */     if (tradeOrder.getBuyerAccount().equals(tradeOrder.getSellerAccount())) {
/*  177 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.BUY_MYSELF_GOODS_ERROR.getValue()));
/*  178 */       result.setErrorInfo(EnumTradeOrderResultErrors.BUY_MYSELF_GOODS_ERROR.getInfo());
/*  179 */       return result;
/*      */     }
/*      */ 
/*  182 */     SystemDict dict = this.systemDictDAO.selectSingleByKey(EnumSystemDictKey.CONFIM_ORDER_DAYS
/*  183 */       .getValue());
/*  184 */     if ((dict == null) || (StringUtil.isBlank(dict.getParaValue()))) {
/*  185 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIM_ORDER_DAYS_SET_ERROR.getValue()));
/*  186 */       result.setErrorInfo(EnumTradeOrderResultErrors.CONFIM_ORDER_DAYS_SET_ERROR.getInfo());
/*  187 */       return result;
/*      */     }
/*  189 */     Long endDateConfirmDays = Long.valueOf(0L);
/*      */     try {
/*  191 */       endDateConfirmDays = Long.valueOf(Long.parseLong(dict.getParaValue()));
/*      */     } catch (NumberFormatException e1) {
/*  193 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIM_ORDER_DAYS_SET_ERROR.getValue()));
/*  194 */       result.setErrorInfo(EnumTradeOrderResultErrors.CONFIM_ORDER_DAYS_SET_ERROR.getInfo());
/*  195 */       return result;
/*      */     }
/*  197 */     BaseDay endDateConfirmBaseDays = this.baseDayService.getNextBaseDay(endDateConfirmDays);
/*  198 */     if (endDateConfirmBaseDays == null) {
/*  199 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_GET_END_DATE_CONFIRM_ERROR.getValue()));
/*  200 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_GET_END_DATE_CONFIRM_ERROR.getInfo());
/*  201 */       return result;
/*      */     }
/*  203 */     tradeOrder.setEndDateConfirm(endDateConfirmBaseDays.getDay());
/*  204 */     tradeOrder.setGmtCreate(new Date());
/*  205 */     tradeOrder.setGmtModify(new Date());
/*  206 */     result.setOrderNo(orderNo);
/*  207 */     UserAccount sellAcc = this.userAccountDAO.selectByUserAccount(tradeOrder
/*  208 */       .getSellerAccount());
/*  209 */     UserAccount buyAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getBuyerAccount());
/*  210 */     tradeOrderDetail.setSellerName(sellAcc.getName());
/*  211 */     tradeOrderDetail.setBuyerName(buyAcc.getName());
/*  212 */     final TradeOrderMoney sellMoney = new TradeOrderMoney();
/*  213 */     sellMoney.setOrderNo(orderNo);
/*  214 */     sellMoney.setUserAccount(tradeOrder.getSellerAccount());
/*  215 */     sellMoney.setFundAccount(sellAcc.getFundAccount());
/*  216 */     sellMoney.setTradeDeposit(sellTradeDeposit);
/*  217 */     sellMoney.setOperator(tradeOrder.getSellerAccount());
/*  218 */     final TradeOrderMoney buyMoney = new TradeOrderMoney();
/*  219 */     buyMoney.setOrderNo(orderNo);
/*  220 */     buyMoney.setUserAccount(tradeOrder.getBuyerAccount());
/*  221 */     buyMoney.setFundAccount(buyAcc.getFundAccount());
/*  222 */     buyMoney.setTradeDeposit(buyTradeDeposit);
/*  223 */     buyMoney.setOperator(tradeOrder.getBuyerAccount());
/*  224 */     final TradeOrder to = tradeOrder;
/*  225 */     final TradeOrderDetail tod = tradeOrderDetail;
/*  226 */     result = (TradeOrderServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public TradeOrderServiceResult doInTransaction(TransactionStatus status) {
/*  228 */         TradeOrderServiceResult result = new TradeOrderServiceResult();
/*  229 */         result.setOrderNo(orderNo);
/*      */         try
/*      */         {
/*  232 */           TradeOrderServiceImpl.this.tradeOrderDAO.insert(to);
/*      */ 
/*  234 */           TradeOrderServiceImpl.this.tradeOrderDetailDAO.insert(tod);
/*      */ 
/*  236 */           TradeOrderServiceImpl.this.tradeOrderMoneyDAO.insert(sellMoney);
/*  237 */           TradeOrderServiceImpl.this.tradeOrderMoneyDAO.insert(buyMoney);
/*      */ 
/*  239 */           String remark = DateUtil.getDateFormat(new Date(), null) + "操作人:" + operator + 
/*  240 */             " 处理:订单新建";
/*  241 */           TradeOrderServiceImpl.this.tradeOrderLogService.insert(to.getOrderNo(), to.getStatus(), to.getStatus(), 
/*  242 */             operator, EnumOperatorType.USER.getValue(), remark);
/*      */         }
/*      */         catch (Exception e) {
/*  245 */           TradeOrderServiceImpl.this.logger.error("TradeOrderServiceImpl initAddOrder error:", e);
/*  246 */           status.setRollbackOnly();
/*  247 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*  248 */           result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/*  249 */           return result;
/*      */         }
/*  251 */         return result;
/*      */       }
/*      */     });
/*  254 */     return result;
/*      */   }
/*      */ 
/*      */   public TradeOrderServiceResult rollbackOrder(final TradeOrderRequest request)
/*      */   {
/*  263 */     final String orderNo = request.getOrderNo();
/*  264 */     final String operator = request.getOperator();
/*  265 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/*  266 */     if ((StringUtil.isBlank(orderNo)) || (StringUtil.isBlank(operator))) {
/*  267 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  268 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  269 */       this.log.error("TradeOrderServiceImpl rollbackOrder error: " + result.getErrorInfo());
/*  270 */       return result;
/*      */     }
/*  272 */     final TradeOrder tradeOrder = this.tradeOrderDAO.selectByOrderNo(orderNo);
/*  273 */     result = (TradeOrderServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public TradeOrderServiceResult doInTransaction(TransactionStatus status) {
/*  275 */         TradeOrderServiceResult result = new TradeOrderServiceResult();
/*      */         try
/*      */         {
/*  278 */           TradeOrderServiceImpl.this.tradeOrderDAO.deleteByOrderNo(orderNo);
/*      */ 
/*  280 */           TradeOrderServiceImpl.this.tradeOrderDetailDAO.deleteByOrderNo(orderNo);
/*      */ 
/*  282 */           TradeOrderServiceImpl.this.tradeOrderMoneyDAO.deleteByOrderNo(orderNo);
/*      */ 
/*  285 */           String remark = DateUtil.getDateFormat(new Date(), null) + "操作人:" + 
/*  286 */             request.getOperator() + " 处理:订单回滚删除";
/*  287 */           TradeOrderServiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/*  288 */             EnumTradeOrderStatus.ROLLBACK_DELETE.getValue(), operator, 
/*  289 */             EnumOperatorType.USER.getValue(), remark);
/*      */         } catch (Exception e) {
/*  291 */           TradeOrderServiceImpl.this.logger.error("TradeOrderServiceImpl rollbackOrder error:", e);
/*  292 */           status.setRollbackOnly();
/*  293 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*  294 */           result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/*  295 */           return result;
/*      */         }
/*  297 */         return result;
/*      */       }
/*      */     });
/*  300 */     return result;
/*      */   }
/*      */ 
/*      */   public TradeOrderCashDepositResult queryOrderCashDeposit(TradeOrderCashDepositRequest request)
/*      */   {
/*  311 */     TradeOrderCashDepositResult result = new TradeOrderCashDepositResult();
/*  312 */     if ((request == null) || (request.getOrderNo() == null)) {
/*  313 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  314 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  315 */       this.log
/*  316 */         .error("TradeOrderServiceImpl queryOrderCashDeposit error: " + 
/*  317 */         result.getErrorInfo());
/*  318 */       return result;
/*      */     }
/*  320 */     Map buyerFee = new HashMap();
/*  321 */     Map sellerFee = new HashMap();
/*      */     try
/*      */     {
/*  324 */       if (!StringUtil.isEmpty(request.getBuyerAccount())) {
/*  325 */         buyerFee = calculateOrderCashDeposit(request.getOrderNo(), request
/*  326 */           .getBuyerAccount(), true);
/*      */       }
/*  328 */       if (!StringUtil.isEmpty(request.getSellerAccount()))
/*  329 */         sellerFee = calculateOrderCashDeposit(request.getOrderNo(), request
/*  330 */           .getSellerAccount(), false);
/*      */     }
/*      */     catch (ServiceException e) {
/*  333 */       result.setErrorInfo(e.getErrorInfo());
/*  334 */       result.setErrorNO(e.getErrorNO());
/*  335 */       return result;
/*      */     } catch (Exception e) {
/*  337 */       this.log.error("", e);
/*  338 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/*  339 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*  340 */       return result;
/*      */     }
/*  342 */     result
/*  343 */       .setBuyerDeliveryCashDeposit(buyerFee.get("cash") == null ? 0L : ((Long)buyerFee.get("cash")).longValue());
/*  344 */     result.setBuyerServiceCharge(buyerFee.get("serviceCharge") == null ? 0L : 
/*  345 */       ((Long)buyerFee
/*  345 */       .get("serviceCharge")).longValue());
/*  346 */     result.setSellerDeliveryCashDeposit(sellerFee.get("cash") == null ? 0L : 
/*  347 */       ((Long)sellerFee
/*  347 */       .get("cash")).longValue());
/*  348 */     result.setSellerServiceCharge(sellerFee.get("serviceCharge") == null ? 0L : 
/*  349 */       ((Long)sellerFee
/*  349 */       .get("serviceCharge")).longValue());
/*  350 */     return result;
/*      */   }
/*      */ 
/*      */   private Map<String, Long> calculateOrderCashDeposit(String orderNo, String account, boolean isBuy)
/*      */     throws ServiceException
/*      */   {
/*  365 */     long cash = -1L;
/*  366 */     if ((StringUtil.isEmpty(orderNo)) || (StringUtil.isEmpty(account))) {
/*  367 */       this.log.error("getOrderCash input param error");
/*  368 */       throw new ServiceException(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*      */     }
/*  370 */     ProjectBaseSettingRequest request = new ProjectBaseSettingRequest();
/*  371 */     UserLevel userLevel = this.userLevelService.selectByAccount(account);
/*  372 */     if (userLevel == null) {
/*  373 */       this.log.error("getOrderCash can not find user level by account:" + account);
/*  374 */       throw new ServiceException(EnumUserResultErrors.USER_LEVEL_NULL_ERROR.getInfo());
/*      */     }
/*  376 */     request.setMemberLevel(userLevel.getMemberLevel());
/*  377 */     UserCredit userCredit = this.userCreditService.selectByUserAccount(account);
/*  378 */     if (userCredit == null) {
/*  379 */       this.log.error("getOrderCash can not find user credit");
/*  380 */       throw new ServiceException(EnumUserResultErrors.USER_CREDIT_NULL_ERROR.getInfo());
/*      */     }
/*  382 */     if (isBuy) {
/*  383 */       request.setBadComment(userCredit.getBuyBadNum());
/*  384 */       request.setGoodComment(userCredit.getBuyGoodNum());
/*      */     } else {
/*  386 */       request.setBadComment(userCredit.getSellerBadNum());
/*  387 */       request.setGoodComment(userCredit.getSellerGoodNum());
/*      */     }
/*  389 */     TradeOrder order = this.tradeOrderDAO.selectByOrderNo(orderNo);
/*  390 */     ProjectListing project = null;
/*  391 */     if ((order == null) || (order.getOrderAmount() == null)) {
/*  392 */       this.log.error("getOrderCash can not find order info by order no:" + orderNo);
/*  393 */       throw new ServiceException(EnumTradeOrderResultErrors.ORDER_NULL_ERROR.getInfo());
/*      */     }
/*  395 */     request.setTradingType(order.getTradingType());
/*  396 */     project = this.projectListingDAO.selectByProjectCode(order.getProjectCode());
/*  397 */     if (project == null) {
/*  398 */       this.log.error("getOrderCash can not find order info by order no:" + orderNo);
/*  399 */       throw new ServiceException(EnumTradeOrderResultErrors.ORDER_PROJECT_NULL_ERROR
/*  400 */         .getInfo());
/*      */     }
/*  402 */     request.setProTypeCode(project.getProjectTypeCode());
/*  403 */     ProjectBaseSettingServiceResult result = this.remoteProjectBaseSettingService
/*  404 */       .getProjectBaseSet(request);
/*  405 */     if ((result == null) || (result.error()) || (result.getProjectBaseSettingDTO() == null)) {
/*  406 */       String msg = result != null ? result.getErrorInfo() : 
/*  407 */         EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo();
/*  408 */       this.log.error("getOrderCash getProjectBaseSet fail info:" + msg);
/*  409 */       throw new ServiceException(msg);
/*      */     }
/*  411 */     Money money = new Money();
/*  412 */     money.setCent(order.getOrderAmount().longValue());
/*  413 */     if (isBuy)
/*  414 */       cash = money.multiply(
/*  415 */         BigDecimal.valueOf(result.getProjectBaseSettingDTO().getOrderJsProportion().longValue())
/*  416 */         .movePointLeft(4)).getCent();
/*      */     else {
/*  418 */       cash = money.multiply(
/*  419 */         BigDecimal.valueOf(result.getProjectBaseSettingDTO().getListingJsProportion().longValue())
/*  420 */         .movePointLeft(4)).getCent();
/*      */     }
/*  422 */     SystemServicechargeSpecialRequest serviceChargeSpecialRequest = new SystemServicechargeSpecialRequest();
/*  423 */     serviceChargeSpecialRequest.setUserAccount(account);
/*      */ 
/*  425 */     if (account.equals(project.getUserAccount()))
/*  426 */       serviceChargeSpecialRequest
/*  427 */         .setChargeKey(EnumSystemServicechargeSpecialType.LIST_TURNOVER.getValue());
/*      */     else {
/*  429 */       serviceChargeSpecialRequest
/*  430 */         .setChargeKey(EnumSystemServicechargeSpecialType.ORDER_TURNOVER.getValue());
/*      */     }
/*  432 */     serviceChargeSpecialRequest.setProTypeCode(project.getProjectTypeCode());
/*      */ 
/*  434 */     serviceChargeSpecialRequest.setTradingType(order.getTradingType());
/*  435 */     serviceChargeSpecialRequest.setTurnoverAmount(order.getOrderAmount());
/*  436 */     if ((EnumTradingType.BID_ORDER.getValue().equalsIgnoreCase(order.getTradingType())) || 
/*  438 */       (EnumTradingType.MULIT_BID_ORDER.getValue()
/*  438 */       .equalsIgnoreCase(order.getTradingType())))
/*      */     {
/*  440 */       ProjectMetas proMeta = this.projectMetasDAO.getProjectMetasByProIDAndKey(project.getId(), 
/*  441 */         EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/*  442 */       serviceChargeSpecialRequest.setHaveAuctioneer(proMeta.getMetaValue());
/*      */     }
/*      */ 
/*  445 */     SystemServicechargeSpecialResult systemServicechargeSpecialResult = this.remoteSystemBaseService
/*  446 */       .selectChargeSpecial(serviceChargeSpecialRequest);
/*  447 */     money = new Money();
/*  448 */     money.setCent(order.getOrderAmount().longValue());
/*  449 */     Long serviceCharge = 
/*  451 */       Long.valueOf(money.multiply(
/*  450 */       BigDecimal.valueOf(systemServicechargeSpecialResult.getChargeRate().longValue()).movePointLeft(4))
/*  451 */       .getCent());
/*      */ 
/*  453 */     Map map = new HashMap();
/*  454 */     map.put("cash", Long.valueOf(cash));
/*  455 */     map.put("serviceCharge", serviceCharge);
/*  456 */     return map;
/*      */   }
/*      */ 
/*      */   public ServiceResult orderConfirm(final TradeOrderRequest request)
/*      */   {
/*  468 */     ServiceResult serviceResult = new ServiceResult();
/*  469 */     final TradeOrder order = this.tradeOrderDAO.selectByOrderNo(request.getOrderNo());
/*  470 */     if (order == null) {
/*  471 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NULL_ERROR.getInfo());
/*  472 */       serviceResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NULL_ERROR.getValue()));
/*  473 */       return serviceResult;
/*      */     }
/*  475 */     if (order.isBuyerOrder(request.getUserAccount())) {
/*  476 */       if (EnumActiveStatus.Yes.getValue().equals(order.getHasBuyerConfirm())) {
/*  477 */         serviceResult.setErrorInfo(EnumTradeOrderResultErrors.ORDER_CONFIRM_ALREADY_ERROR
/*  478 */           .getInfo());
/*  479 */         serviceResult.setErrorNO(
/*  480 */           Integer.valueOf(EnumTradeOrderResultErrors.ORDER_CONFIRM_ALREADY_ERROR
/*  480 */           .getValue()));
/*  481 */         return serviceResult;
/*      */       }
/*  483 */     } else if (order.isSellerOrder(request.getUserAccount())) {
/*  484 */       if (EnumActiveStatus.Yes.getValue().equals(order.getHasSellerConfirm())) {
/*  485 */         serviceResult.setErrorInfo(EnumTradeOrderResultErrors.ORDER_CONFIRM_ALREADY_ERROR
/*  486 */           .getInfo());
/*  487 */         serviceResult.setErrorNO(
/*  488 */           Integer.valueOf(EnumTradeOrderResultErrors.ORDER_CONFIRM_ALREADY_ERROR
/*  488 */           .getValue()));
/*  489 */         return serviceResult;
/*      */       }
/*      */     } else {
/*  492 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NULL_ERROR.getInfo());
/*  493 */       serviceResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NULL_ERROR.getValue()));
/*  494 */       return serviceResult;
/*      */     }
/*  496 */     TradeOrderCashDepositRequest cashDepositRequest = new TradeOrderCashDepositRequest();
/*  497 */     if (order.isBuyerOrder(request.getUserAccount()))
/*  498 */       cashDepositRequest.setBuyerAccount(request.getUserAccount());
/*      */     else {
/*  500 */       cashDepositRequest.setSellerAccount(request.getUserAccount());
/*      */     }
/*  502 */     cashDepositRequest.setOrderNo(request.getOrderNo());
/*  503 */     TradeOrderCashDepositResult result = new TradeOrderCashDepositResult();
/*      */     try {
/*  505 */       result = queryOrderCashDeposit(cashDepositRequest);
/*      */     } catch (Exception e) {
/*  507 */       e.printStackTrace();
/*  508 */       serviceResult.setErrorNO(
/*  509 */         Integer.valueOf(EnumTradeOrderResultErrors.QUERY_ORDER_CASH_DEPOSIT_ERROR
/*  509 */         .getValue()));
/*  510 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.QUERY_ORDER_CASH_DEPOSIT_ERROR
/*  511 */         .getInfo());
/*  512 */       return serviceResult;
/*      */     }
/*  514 */     if (result == null) {
/*  515 */       serviceResult.setErrorNO(
/*  516 */         Integer.valueOf(EnumTradeOrderResultErrors.QUERY_ORDER_CASH_DEPOSIT_ERROR
/*  516 */         .getValue()));
/*  517 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.QUERY_ORDER_CASH_DEPOSIT_ERROR
/*  518 */         .getInfo());
/*  519 */       return serviceResult;
/*      */     }
/*  521 */     if (result.error()) {
/*  522 */       serviceResult.setErrorInfo(result.getErrorInfo());
/*  523 */       serviceResult.setErrorNO(result.getErrorNO());
/*  524 */       return serviceResult;
/*      */     }
/*      */ 
/*  527 */     TradeOrderMoney tradeOrderMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(request
/*  528 */       .getOrderNo(), request.getUserAccount());
/*  529 */     if (tradeOrderMoney == null) {
/*  530 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.QUERY_ORDER_TRADE_DEPOSIT_ERROR
/*  531 */         .getInfo());
/*  532 */       serviceResult.setErrorNO(
/*  533 */         Integer.valueOf(EnumTradeOrderResultErrors.QUERY_ORDER_TRADE_DEPOSIT_ERROR
/*  533 */         .getValue()));
/*  534 */       return serviceResult;
/*      */     }
/*  536 */     Map map = new HashMap();
/*  537 */     boolean isShouldSendGoods = false;
/*  538 */     if (order.isBuyerOrder(request.getUserAccount())) {
/*  539 */       map.put("hasBuyerConfirm", EnumActiveStatus.Yes.getValue());
/*  540 */       map.put("whereHasBuyerConfirm", EnumActiveStatus.No.getValue());
/*  541 */       tradeOrderMoney.setDeliveryDeposit(Long.valueOf(result.getBuyerDeliveryCashDeposit()));
/*  542 */       tradeOrderMoney.setTradeServiceCharge(Long.valueOf(result.getBuyerServiceCharge()));
/*  543 */       if (EnumActiveStatus.Yes.getValue().equals(order.getHasSellerConfirm())) {
/*  544 */         isShouldSendGoods = true;
/*  545 */         if (EnumPaymentType.OffLine.getValue().equals(order.getPaymentType()))
/*  546 */           map.put("status", EnumTradeOrderStatus.WAIT_SENDGOODS.getValue());
/*      */         else
/*  548 */           map.put("status", EnumTradeOrderStatus.WAIT_PAYGOODS.getValue());
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  553 */       map.put("hasSellerConfirm", EnumActiveStatus.Yes.getValue());
/*  554 */       map.put("whereHasSellerConfirm", EnumActiveStatus.No.getValue());
/*  555 */       tradeOrderMoney.setDeliveryDeposit(Long.valueOf(result.getSellerDeliveryCashDeposit()));
/*  556 */       tradeOrderMoney.setTradeServiceCharge(Long.valueOf(result.getSellerServiceCharge()));
/*  557 */       if (EnumActiveStatus.Yes.getValue().equals(order.getHasBuyerConfirm())) {
/*  558 */         isShouldSendGoods = true;
/*  559 */         if (EnumPaymentType.OffLine.getValue().equals(order.getPaymentType()))
/*  560 */           map.put("status", EnumTradeOrderStatus.WAIT_SENDGOODS.getValue());
/*      */         else {
/*  562 */           map.put("status", EnumTradeOrderStatus.WAIT_PAYGOODS.getValue());
/*      */         }
/*      */       }
/*      */     }
/*  566 */     if (isShouldSendGoods) {
/*  567 */       List param = new ArrayList();
/*  568 */       param.add(EnumSystemDictKey.UNPAY_GENORDER_DAYS);
/*  569 */       param.add(EnumSystemDictKey.UNDELIVERY_GENORDER_DAYS);
/*  570 */       param.add(EnumSystemDictKey.ARRIVEDGOODS_GENORDER_DAYS);
/*  571 */       param.add(EnumSystemDictKey.ARRIVEDTICKET_GENORDER_DAYS);
/*  572 */       Map dictMap = this.systemDictDAO.selectListByMultiKey(param);
/*  573 */       BaseDay baseDay = null;
/*  574 */       if (dictMap.containsKey(EnumSystemDictKey.UNPAY_GENORDER_DAYS.getValue()))
/*      */       {
/*  577 */         baseDay = this.baseDayService.getNextBaseDay(Long.valueOf(((SystemDict)dictMap.get(
/*  578 */           EnumSystemDictKey.UNPAY_GENORDER_DAYS.getValue())).getParaValue()));
/*  579 */         if (baseDay == null) {
/*  580 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_UNPAY_GENORDER_DATE_CONFIRM_ERROR.getValue()));
/*  581 */           result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_UNPAY_GENORDER_DATE_CONFIRM_ERROR.getInfo());
/*  582 */           return result;
/*      */         }
/*  584 */         map.put("endDatePay", baseDay.getDay());
/*      */       }
/*      */ 
/*  587 */       if (dictMap.containsKey(EnumSystemDictKey.ARRIVEDGOODS_GENORDER_DAYS.getValue()))
/*      */       {
/*  590 */         baseDay = this.baseDayService.getNextBaseDay(Long.valueOf(((SystemDict)dictMap.get(
/*  591 */           EnumSystemDictKey.ARRIVEDGOODS_GENORDER_DAYS.getValue())).getParaValue()));
/*  592 */         if (baseDay == null) {
/*  593 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_ARRIVEDGOODS_GENORDER_DATE_CONFIRM_ERROR.getValue()));
/*  594 */           result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_ARRIVEDGOODS_GENORDER_DATE_CONFIRM_ERROR.getInfo());
/*  595 */           return result;
/*      */         }
/*  597 */         map.put("endDateGoods", baseDay.getDay());
/*      */       }
/*      */ 
/*  600 */       if (dictMap.containsKey(EnumSystemDictKey.ARRIVEDTICKET_GENORDER_DAYS.getValue()))
/*      */       {
/*  603 */         baseDay = this.baseDayService.getNextBaseDay(Long.valueOf(((SystemDict)dictMap.get(
/*  604 */           EnumSystemDictKey.ARRIVEDTICKET_GENORDER_DAYS.getValue())).getParaValue()));
/*  605 */         if (baseDay == null) {
/*  606 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_ARRIVEDTICKET_GENORDER_DATE_CONFIRM_ERROR.getValue()));
/*  607 */           result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_ARRIVEDTICKET_GENORDER_DATE_CONFIRM_ERROR.getInfo());
/*  608 */           return result;
/*      */         }
/*  610 */         map.put("endDateBill", baseDay.getDay());
/*      */       }
/*      */ 
/*  613 */       if (dictMap.containsKey(EnumSystemDictKey.UNDELIVERY_GENORDER_DAYS.getValue()))
/*      */       {
/*  616 */         baseDay = this.baseDayService.getNextBaseDay(Long.valueOf(((SystemDict)dictMap.get(
/*  617 */           EnumSystemDictKey.UNDELIVERY_GENORDER_DAYS.getValue())).getParaValue()));
/*  618 */         if (baseDay == null) {
/*  619 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_UNDELIVERY_GENORDER_DATE_CONFIRM_ERROR.getValue()));
/*  620 */           result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_UNDELIVERY_GENORDER_DATE_CONFIRM_ERROR.getInfo());
/*  621 */           return result;
/*      */         }
/*  623 */         map.put("endDateSendGoods", baseDay.getDay());
/*      */       }
/*      */     }
/*  626 */     map.put("whereStatus", order.getStatus());
/*      */ 
/*  628 */     TransRequest transRequest = new TransRequest();
/*      */ 
/*  630 */     transRequest.setFundAccount(request.getFundAccount());
/*  631 */     transRequest.setOrderProperty(order.getTradingType());
/*  632 */     transRequest.setFreezeDepositAmount(tradeOrderMoney.getTradeDeposit());
/*  633 */     transRequest.setFreezeFeeAmount(Long.valueOf(0L));
/*  634 */     transRequest.setDeliveryAmount(tradeOrderMoney.getDeliveryDeposit());
/*  635 */     transRequest.setFeeAmount(tradeOrderMoney.getTradeServiceCharge());
/*  636 */     transRequest.setBizNo(order.getOrderNo());
/*  637 */     transRequest.setOperator(request.getOperator());
/*      */ 
/*  639 */     final Map paramMap = map;
/*  640 */     tradeOrderMoney.setTradeDeposit(Long.valueOf(0L));
/*  641 */     final TradeOrderMoney fTradeOrderMoney = tradeOrderMoney;
/*  642 */     final TransRequest fTransRequest = transRequest;
/*  643 */     serviceResult = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public UserServiceResult doInTransaction(TransactionStatus status) {
/*  645 */         UserServiceResult result = new UserServiceResult();
/*  646 */         Object savePoint = status.createSavepoint();
/*      */         try
/*      */         {
/*  649 */           if (TradeOrderServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(fTradeOrderMoney) <= 0) {
/*  650 */             throw new ServiceException(
/*  651 */               EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo(), 
/*  652 */               Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/*      */           }
/*      */ 
/*  655 */           if (TradeOrderServiceImpl.this.tradeOrderDAO.updateParamByOrderNo(paramMap, request.getOrderNo()) <= 0) {
/*  656 */             throw new ServiceException(
/*  657 */               EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR.getInfo(), 
/*  658 */               Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR.getValue()));
/*      */           }
/*      */ 
/*  661 */           String remark = DateUtil.getDateFormat(new Date(), null) + "操作人:" + 
/*  662 */             request.getOperator() + " 处理:订单确认";
/*  663 */           TradeOrderServiceImpl.this.tradeOrderLogService.insert(request.getOrderNo(), order.getStatus(), 
/*  664 */             paramMap.get("status") == null ? order.getStatus() : paramMap.get("status")
/*  665 */             .toString(), request.getOperator(), request.getOperatorType(), remark);
/*      */ 
/*  668 */           FundOperateResult fundOperateResult = TradeOrderServiceImpl.this.remoteFundService
/*  669 */             .fillFundByTrade(fTransRequest);
/*  670 */           if (fundOperateResult.isError())
/*  671 */             throw new ServiceException(fundOperateResult.getErrorInfo());
/*      */         }
/*      */         catch (ServiceException e) {
/*  674 */           status.rollbackToSavepoint(savePoint);
/*  675 */           TradeOrderServiceImpl.this.log.error("TradeOrderServiceImpl orderConfirm fail", e);
/*  676 */           result.setErrorNO(e.getErrorNO());
/*  677 */           result.setErrorInfo(e.getErrorInfo());
/*      */         } catch (Exception e) {
/*  679 */           status.rollbackToSavepoint(savePoint);
/*  680 */           TradeOrderServiceImpl.this.log.error("TradeOrderServiceImpl orderConfirm error", e);
/*  681 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*  682 */           result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/*      */         }
/*  684 */         return result;
/*      */       }
/*      */     });
/*  687 */     return serviceResult;
/*      */   }
/*      */ 
/*      */   public TradeOrderGoodAmountServiceResult orderGoodsValidate(TradeOrderBaseRequest request)
/*      */   {
/*  705 */     return this.tradeOrderCheckGoodsProcessService.process(request);
/*      */   }
/*      */ 
/*      */   public TradeOrderGoodAmountServiceResult orderInvoiceValidate(TradeOrderBaseRequest request)
/*      */   {
/*  721 */     return this.tradeOrderCheckTicketProcessService.process(request);
/*      */   }
/*      */ 
/*      */   public ServiceResult orderPay(TradeOrderBaseRequest request)
/*      */   {
/*  737 */     ServiceResult result = new ServiceResult();
/*  738 */     final String operator = request.getOperator();
/*  739 */     final String operatorType = request.getOperatorType();
/*  740 */     final String orderNo = request.getOrderNo();
/*  741 */     String userAccount = request.getUserAccount();
/*  742 */     String payPwd = request.getPayPwd();
/*  743 */     if ((request == null) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || 
/*  744 */       (StringUtil.isEmpty(orderNo)) || (StringUtil.isEmpty(payPwd))) {
/*  745 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  746 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  747 */       this.log.error("TradeOrderServiceImpl orderPay error: " + result.getErrorInfo());
/*  748 */       return result;
/*      */     }
/*  750 */     final TradeOrder tradeOrder = selectByOrderNo(orderNo);
/*      */ 
/*  752 */     if (!EnumTradeOrderStatus.WAIT_PAYGOODS.getValue().equalsIgnoreCase(tradeOrder.getStatus())) {
/*  753 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/*  754 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/*  755 */       return result;
/*      */     }
/*      */ 
/*  758 */     if (!EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType())) {
/*  759 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_FLOW_DATA.getValue()));
/*  760 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_FLOW_DATA.getInfo());
/*  761 */       this.log.error("TradeOrderServiceImpl orderPay error: " + result.getErrorInfo());
/*  762 */       return result;
/*      */     }
/*      */ 
/*  765 */     if (!tradeOrder.getBuyerAccount().equals(userAccount)) {
/*  766 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getValue()));
/*  767 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getInfo());
/*  768 */       this.log.error("TradeOrderServiceImpl orderPay error: " + result.getErrorInfo());
/*  769 */       return result;
/*      */     }
/*  771 */     if (!this.userService.checkPayPwd(userAccount, payPwd)) {
/*  772 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getValue()));
/*  773 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getInfo());
/*  774 */       this.log.error("TradeOrderServiceImpl orderGoodsValidate error: " + result.getErrorInfo());
/*  775 */       return result;
/*      */     }
/*      */ 
/*  778 */     result = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public ServiceResult doInTransaction(TransactionStatus status) {
/*  780 */         ServiceResult result = new ServiceResult();
/*      */         try
/*      */         {
/*  783 */           Map param = new HashMap();
/*  784 */           param.put("operator", operator);
/*  785 */           param.put("hasPay", EnumHasEnabled.NEED.getValue());
/*  786 */           param.put("whereStatus", tradeOrder.getStatus());
/*  787 */           param.put("status", EnumTradeOrderStatus.WAIT_SENDGOODS.getValue());
/*      */ 
/*  789 */           UserAccount buyAcc = TradeOrderServiceImpl.this.userAccountDAO.selectByUserAccount(tradeOrder
/*  790 */             .getBuyerAccount());
/*  791 */           TradeOrderMoney buyMoney = new TradeOrderMoney();
/*  792 */           buyMoney.setOrderNo(orderNo);
/*  793 */           buyMoney.setUserAccount(tradeOrder.getBuyerAccount());
/*  794 */           buyMoney.setGoodsAmount(tradeOrder.getOrderAmount());
/*  795 */           buyMoney.setOperator(operator);
/*      */ 
/*  797 */           if (TradeOrderServiceImpl.this.tradeOrderDAO.updateParamByOrderNo(param, orderNo) <= 0) {
/*  798 */             status.setRollbackOnly();
/*  799 */             result.setErrorNO(
/*  800 */               Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR
/*  800 */               .getValue()));
/*  801 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR
/*  802 */               .getInfo());
/*  803 */             return result;
/*      */           }
/*      */ 
/*  806 */           if (TradeOrderServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/*  807 */             status.setRollbackOnly();
/*  808 */             result
/*  809 */               .setErrorNO(
/*  810 */               Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/*  810 */               .getValue()));
/*  811 */             result
/*  812 */               .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/*  813 */               .getInfo());
/*  814 */             return result;
/*      */           }
/*      */ 
/*  817 */           String remark = DateUtil.getDateFormat(new Date(), null) + 
/*  818 */             "操作人:" + 
/*  819 */             operator + 
/*  820 */             " 处理订单支付货款:->等待卖家交割" + 
/*  821 */             " 订单金额：" + 
/*  822 */             CommonUtils.getValuationUnitDesc(
/*  823 */             Long.valueOf(tradeOrder.getOrderAmount()
/*  823 */             .longValue()), tradeOrder.getValuationUnit());
/*      */ 
/*  825 */           TradeOrderServiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/*  826 */             EnumTradeOrderStatus.WAIT_SENDGOODS.getValue(), operator, operatorType, 
/*  827 */             remark);
/*      */ 
/*  829 */           TransRequest request = new TransRequest();
/*  830 */           request.setFundAccount(buyAcc.getFundAccount());
/*  831 */           request.setOrderProperty(tradeOrder.getTradingType());
/*  832 */           request.setGoodsAmount(tradeOrder.getOrderAmount());
/*  833 */           request.setBizNo(orderNo);
/*  834 */           request.setOperator(operator);
/*  835 */           request.setMemo(remark);
/*      */ 
/*  837 */           FundOperateResult rr = TradeOrderServiceImpl.this.remoteFundService.prePayPayment(request);
/*  838 */           if (rr.isError())
/*      */           {
/*  840 */             TradeOrderServiceImpl.this.logger.error("TradeOrderServiceImpl orderPay remoteFundService error");
/*  841 */             status.setRollbackOnly();
/*  842 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*  843 */             result.setErrorInfo(rr.getErrorInfo());
/*  844 */             return result;
/*      */           }
/*      */         }
/*      */         catch (Exception e) {
/*  848 */           TradeOrderServiceImpl.this.logger.error("TradeOrderServiceImpl orderPay error:", e);
/*  849 */           status.setRollbackOnly();
/*  850 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*  851 */           result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/*  852 */           return result;
/*      */         }
/*  854 */         return result;
/*      */       }
/*      */     });
/*  857 */     return result;
/*      */   }
/*      */ 
/*      */   public ServiceResult orderSendGoods(TradeOrderBaseRequest request)
/*      */   {
/*  870 */     ServiceResult result = new ServiceResult();
/*  871 */     final String operator = request.getOperator();
/*  872 */     final String operatorType = request.getOperatorType();
/*  873 */     final String orderNo = request.getOrderNo();
/*  874 */     String userAccount = request.getUserAccount();
/*  875 */     if ((request == null) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || 
/*  876 */       (StringUtil.isEmpty(orderNo))) {
/*  877 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  878 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  879 */       this.log.error("TradeOrderServiceImpl orderSendGoods error: " + result.getErrorInfo());
/*  880 */       return result;
/*      */     }
/*  882 */     final TradeOrder tradeOrder = selectByOrderNo(orderNo);
/*  883 */     if (!EnumTradeOrderStatus.WAIT_SENDGOODS.getValue().equals(tradeOrder.getStatus()))
/*      */     {
/*  885 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/*  886 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/*  887 */       return result;
/*      */     }
/*      */ 
/*  890 */     if (!tradeOrder.getSellerAccount().equals(userAccount)) {
/*  891 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getValue()));
/*  892 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getInfo());
/*  893 */       this.log.error("TradeOrderServiceImpl orderSendGoods error: " + result.getErrorInfo());
/*  894 */       return result;
/*      */     }
/*      */ 
/*  897 */     result = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*      */       public ServiceResult doInTransaction(TransactionStatus status) {
/*  899 */         ServiceResult result = new ServiceResult();
/*      */         try
/*      */         {
/*  902 */           Map param = new HashMap();
/*  903 */           param.put("operator", operator);
/*  904 */           param.put("whereStatus", tradeOrder.getStatus());
/*  905 */           param.put("status", EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue());
/*      */ 
/*  907 */           TradeOrderServiceImpl.this.updateParamByOrderNo(param, orderNo);
/*      */ 
/*  909 */           String remark = DateUtil.getDateFormat(new Date(), null) + 
/*  910 */             "操作人:" + 
/*  911 */             operator + 
/*  912 */             " 处理订单交割:->待买家确认交割" + 
/*  913 */             " 订单金额：" + 
/*  914 */             CommonUtils.getValuationUnitDesc(
/*  915 */             Long.valueOf(tradeOrder.getOrderAmount()
/*  915 */             .longValue()), tradeOrder.getValuationUnit());
/*  916 */           TradeOrderServiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/*  917 */             EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue(), operator, operatorType, 
/*  918 */             remark);
/*      */         }
/*      */         catch (Exception e) {
/*  921 */           TradeOrderServiceImpl.this.logger.error("TradeOrderServiceImpl orderSendGoods error:", e);
/*  922 */           status.setRollbackOnly();
/*  923 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*  924 */           result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/*  925 */           return result;
/*      */         }
/*  927 */         return result;
/*      */       }
/*      */     });
/*  930 */     return result;
/*      */   }
/*      */ 
/*      */   public TradeOrderFinishedServiceResult orderClose(TradeOrderBaseRequest request)
/*      */   {
/*  942 */     TradeOrderBrokenService brokenService = this.tradeOrderBrokenServiceFactory
/*  943 */       .getBrokenService(request.getOrderNo());
/*  944 */     return brokenService.dealBroken(request);
/*      */   }
/*      */ 
/*      */   public List<TradeOrderAndPro> selectLatestOrder(int counts, String projectTypeCode)
/*      */   {
/*  949 */     if (counts == 0) {
/*  950 */       counts = 10;
/*      */     }
/*      */ 
/*  953 */     TradeOrderQuery query = new TradeOrderQuery();
/*  954 */     query.setProjectTypeCode(projectTypeCode);
/*  955 */     query.setTradeOrderCount(Integer.valueOf(counts));
/*  956 */     List list = this.tradeOrderDAO.selectLatestOrderByCounts(query);
/*  957 */     return list;
/*      */   }
/*      */ 
/*      */   public TradeOrderGoodAmountServiceResult penaltyCheckGoods(TradeOrderBaseRequest request)
/*      */   {
/*  979 */     return this.penaltyCheckGoodsProcessService.process(request);
/*      */   }
/*      */ 
/*      */   public TradeOrderGoodAmountServiceResult penaltyCheckTicket(TradeOrderBaseRequest request)
/*      */   {
/*  993 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*      */ 
/*  995 */     final String orderNo = request.getOrderNo();
/*  996 */     final String operator = request.getOperator();
/*  997 */     final Long goodsAmount = request.getGoodsAmount();
/*  998 */     boolean hasSellerPenalty = request.getHasSellerPenalty();
/*  999 */     final String operatorType = EnumOperatorType.SYSTEM.getValue();
/* 1000 */     if ((request == null) || (StringUtil.isEmpty(operator)) || (goodsAmount == null) || 
/* 1001 */       (StringUtil.isEmpty(orderNo))) {
/* 1002 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 1003 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 1004 */       this.log.error("TradeOrderServiceImpl penaltyCheckTicket error: " + result.getErrorInfo());
/* 1005 */       return result;
/*      */     }
/*      */ 
/* 1009 */     if ((goodsAmount.longValue() == 0L) && (!hasSellerPenalty)) {
/* 1010 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PENALTYCT_PARAMETER_ERROR.getValue()));
/* 1011 */       result.setErrorInfo(EnumTradeOrderResultErrors.PENALTYCT_PARAMETER_ERROR.getInfo());
/* 1012 */       this.log.error("TradeOrderServiceImpl penaltyCheckTicket error: " + result.getErrorInfo());
/* 1013 */       return result;
/*      */     }
/* 1015 */     final TradeOrder tradeOrder = selectByOrderNo(orderNo);
/* 1016 */     if (!EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue().equals(tradeOrder.getStatus()))
/*      */     {
/* 1018 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/* 1019 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/* 1020 */       return result;
/*      */     }
/* 1022 */     if ((EnumPaymentType.OffLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType())) && 
/* 1023 */       (!hasSellerPenalty))
/*      */     {
/* 1025 */       result.setErrorNO(
/* 1026 */         Integer.valueOf(EnumTradeOrderResultErrors.PENALTYCT_OFFLINE_NOPENALTYCT_ERROR
/* 1026 */         .getValue()));
/* 1027 */       result.setErrorInfo(EnumTradeOrderResultErrors.PENALTYCT_OFFLINE_NOPENALTYCT_ERROR
/* 1028 */         .getInfo());
/* 1029 */       return result;
/*      */     }
/*      */ 
/* 1032 */     final TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, 
/* 1033 */       tradeOrder.getBuyerAccount());
/* 1034 */     final TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, 
/* 1035 */       tradeOrder.getSellerAccount());
/* 1036 */     if ((EnumPaymentType.OffLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType())) && 
/* 1037 */       (goodsAmount.longValue() > 0L))
/*      */     {
/* 1039 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PENALTYCT_OFFLINE_AMOUNT_ERROR.getValue()));
/* 1040 */       result
/* 1041 */         .setErrorInfo(EnumTradeOrderResultErrors.PENALTYCT_OFFLINE_AMOUNT_ERROR.getInfo());
/* 1042 */       return result;
/* 1043 */     }if (EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType()))
/*      */     {
/* 1045 */       if ((goodsAmount.longValue() < 0L) || 
/* 1046 */         (goodsAmount.longValue() > buyMoney
/* 1046 */         .getGoodsAmount().longValue()))
/*      */       {
/* 1048 */         result.setErrorNO(
/* 1049 */           Integer.valueOf(EnumTradeOrderResultErrors.PENALTYCT_ONLINE_AMOUNT_ERROR
/* 1049 */           .getValue()));
/* 1050 */         result.setErrorInfo(EnumTradeOrderResultErrors.PENALTYCT_ONLINE_AMOUNT_ERROR
/* 1051 */           .getInfo());
/* 1052 */         return result;
/*      */       }
/*      */     }
/*      */ 
/* 1056 */     long spa = 0L;
/*      */ 
/* 1058 */     if (hasSellerPenalty) {
/* 1059 */       BigDecimal rate = getDeliveryBrokenRate();
/* 1060 */       if (rate == null) {
/* 1061 */         result.setErrorNO(
/* 1062 */           Integer.valueOf(EnumTradeOrderResultErrors.QUERY_DELIVERY_BROKEN_RATE_ERROR
/* 1062 */           .getValue()));
/* 1063 */         result.setErrorInfo(EnumTradeOrderResultErrors.QUERY_DELIVERY_BROKEN_RATE_ERROR
/* 1064 */           .getInfo());
/* 1065 */         return result;
/*      */       }
/* 1067 */       Money money = new Money();
/* 1068 */       money.setCent(sellMoney.getDeliveryDeposit().longValue());
/* 1069 */       spa = money.multiply(rate).getCent();
/*      */     }
/*      */ 
/* 1072 */     final Long sellPenaltyAmount = Long.valueOf(spa == 0L ? 0L : spa);
/*      */ 
/* 1074 */     final String checkGoodsTicketType = hasSellerPenalty ? EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY
/* 1075 */       .getValue() : 
/* 1076 */       EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getValue();
/* 1077 */     final String checkGoodsTicketTypeName = hasSellerPenalty ? EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY
/* 1078 */       .getName() : 
/* 1079 */       EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getName();
/* 1080 */     final UserAccount sellAcc = this.userAccountDAO.selectByUserAccount(tradeOrder
/* 1081 */       .getSellerAccount());
/* 1082 */     final UserAccount buyAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getBuyerAccount());
/*      */ 
/* 1085 */     result = 
/* 1086 */       (TradeOrderGoodAmountServiceResult)this.transactionTemplate
/* 1086 */       .execute(new TransactionCallback() {
/*      */       public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status) {
/* 1088 */         TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*      */         try
/*      */         {
/* 1091 */           Map param = new HashMap();
/* 1092 */           param.put("operator", operator);
/* 1093 */           param.put("whereStatus", tradeOrder.getStatus());
/* 1094 */           param.put("status", EnumTradeOrderStatus.FINISHED.getValue());
/*      */ 
/* 1096 */           TradeOrderServiceImpl.this.updateParamByOrderNo(param, orderNo);
/*      */ 
/* 1098 */           String remark = DateUtil.getDateFormat(new Date(), null) + 
/* 1099 */             "操作人:" + 
/* 1100 */             operator + 
/* 1101 */             " 验票投诉操作:" + 
/* 1102 */             checkGoodsTicketTypeName + 
/* 1103 */             " 订单状态:" + 
/* 1104 */             EnumTradeOrderStatus.FINISHED.getName() + 
/* 1105 */             CommonUtils.getValuationUnitDesc(
/* 1106 */             Long.valueOf(tradeOrder
/* 1106 */             .getOrderAmount().longValue()), tradeOrder
/* 1107 */             .getValuationUnit());
/* 1108 */           TradeOrderServiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/* 1109 */             EnumTradeOrderStatus.FINISHED.getValue(), operator, operatorType, 
/* 1110 */             remark);
/*      */ 
/* 1113 */           Long buyDeliveryDeposit = buyMoney.getDeliveryDeposit();
/* 1114 */           Long sellDeliveryDeposit = sellMoney.getDeliveryDeposit();
/* 1115 */           Long bbyamount = buyMoney.getGoodsAmount();
/* 1116 */           Long sslamount = sellMoney.getGoodsAmount();
/*      */ 
/* 1118 */           Long othergoodsAmount = Long.valueOf(bbyamount.longValue() - goodsAmount.longValue());
/*      */ 
/* 1120 */           buyMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 1121 */           buyMoney.setGoodsAmount(Long.valueOf(0L));
/* 1122 */           buyMoney.setPenaltyAmount(sellPenaltyAmount);
/* 1123 */           if (TradeOrderServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/* 1124 */             status.setRollbackOnly();
/* 1125 */             result
/* 1126 */               .setErrorNO(
/* 1127 */               Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 1127 */               .getValue()));
/* 1128 */             result
/* 1129 */               .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 1130 */               .getInfo());
/* 1131 */             return result;
/*      */           }
/*      */ 
/* 1134 */           sellMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 1135 */           sellMoney.setGoodsAmount(
/* 1136 */             Long.valueOf(sslamount.longValue() + 
/* 1136 */             othergoodsAmount.longValue()));
/* 1137 */           sellMoney.setPenaltyAmount(Long.valueOf(-sellPenaltyAmount.longValue()));
/* 1138 */           if (TradeOrderServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(sellMoney) <= 0) {
/* 1139 */             status.setRollbackOnly();
/* 1140 */             result
/* 1141 */               .setErrorNO(
/* 1142 */               Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 1142 */               .getValue()));
/* 1143 */             result
/* 1144 */               .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 1145 */               .getInfo());
/* 1146 */             return result;
/*      */           }
/*      */ 
/* 1150 */           TransRequest trRequest = new TransRequest();
/* 1151 */           trRequest.setFundAccount(buyAcc.getFundAccount());
/* 1152 */           trRequest.setSellFundAccount(sellAcc.getFundAccount());
/* 1153 */           trRequest.setOrderProperty(tradeOrder.getTradingType());
/* 1154 */           trRequest.setGoodsAmountType(EnumGoodsAmountType.CHECK_TICKETS.getValue());
/* 1155 */           trRequest.setHasInvoice(tradeOrder.getHasInvoice());
/* 1156 */           trRequest.setGoodsAmount(Long.valueOf(othergoodsAmount.longValue()));
/* 1157 */           trRequest.setBuyerGoodsAmount(Long.valueOf(goodsAmount.longValue()));
/* 1158 */           trRequest.setPenaltyType(EnumPenaltyType.PENALTY_TYPE_SELLER.getValue());
/* 1159 */           trRequest.setPenaltyamount(sellPenaltyAmount);
/* 1160 */           trRequest.setPenaltydeliveryAmount(sellDeliveryDeposit);
/* 1161 */           trRequest.setDeliveryAmount(buyDeliveryDeposit);
/* 1162 */           trRequest.setCheckGoodsTicketType(checkGoodsTicketType);
/* 1163 */           trRequest.setBizNo(orderNo);
/* 1164 */           trRequest.setOperator(operator);
/* 1165 */           trRequest.setMemo(remark);
/* 1166 */           FundOperateResult fundOperateResult = TradeOrderServiceImpl.this.remoteFundService
/* 1167 */             .checkGoodsTicketBroken(trRequest);
/* 1168 */           if (fundOperateResult.isError())
/*      */           {
/* 1170 */             TradeOrderServiceImpl.this.log.error("remoteFundService.checkGoodsTicketBroken error:" + 
/* 1171 */               fundOperateResult.getErrorInfo());
/* 1172 */             status.setRollbackOnly();
/* 1173 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 1174 */             result.setErrorInfo(fundOperateResult.getErrorInfo());
/* 1175 */             return result;
/*      */           }
/* 1177 */           result.setGoodsAmount(goodsAmount);
/* 1178 */           result.setSellGoodsAmount(othergoodsAmount);
/* 1179 */           result.setSellPenaltyAmount(sellPenaltyAmount);
/* 1180 */           result.setSellDeliveryDeposit(sellDeliveryDeposit);
/* 1181 */           result.setBuyDeliveryDeposit(buyDeliveryDeposit);
/*      */         }
/*      */         catch (Exception e) {
/* 1184 */           TradeOrderServiceImpl.this.logger.error("TradeOrderServiceImpl.penaltyCheckTicket() error:", e);
/* 1185 */           status.setRollbackOnly();
/* 1186 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 1187 */           result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 1188 */           return result;
/*      */         }
/* 1190 */         return result;
/*      */       }
/*      */     });
/* 1193 */     return result;
/*      */   }
/*      */ 
/*      */   private BigDecimal getDeliveryBrokenRate()
/*      */   {
/* 1201 */     SystemDictRequest request = new SystemDictRequest();
/* 1202 */     request.setParaCode(EnumSystemDictKey.JS_LIQUIDATED_DAMAGES.getValue());
/*      */     try {
/* 1204 */       SystemDictServiceResult result = this.remoteSystemBaseService
/* 1205 */         .selectLiquidatedDamages(request);
/* 1206 */       if (result.correct()) {
/* 1207 */         return BigDecimal.valueOf(Long.valueOf(result.getSystemDictDTO().getParaValue()).longValue())
/* 1208 */           .movePointLeft(4);
/*      */       }
/* 1210 */       this.log
/* 1211 */         .error("in getTradeBrokenRate,selectLiquidatedDamages fail:" + 
/* 1212 */         result.getErrorInfo());
/*      */     } catch (Exception e) {
/* 1214 */       this.log.error("in getTradeBrokenRate,selectLiquidatedDamages fail: ", e);
/*      */     }
/* 1216 */     return null;
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.TradeOrderServiceImpl
 * JD-Core Version:    0.6.0
 */