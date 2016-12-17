/*     */ package com.hundsun.network.gates.fengshan.biz.service.pojo.order;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderDetailDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderMoneyDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.common.CacheDTO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderAndPro;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderDetail;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectMetasService;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCashDepositRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserCreditRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCashDepositResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserCreditServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("tradeOrderService")
/*     */ public class TradeOrderServiceImpl extends BaseService
/*     */   implements TradeOrderService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDetailDAO tradeOrderDetailDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteTradeOrderService remoteTradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderMoneyDAO tradeOrderMoneyDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasService projectMetasService;
/*  60 */   private static Map<String, CacheDTO<? extends Collection>> cache = new HashMap();
/*     */ 
/*     */   public void queryTradeOrder(TradeOrderQuery query)
/*     */   {
/*  64 */     this.tradeOrderDAO.queryTradeOrder(query);
/*     */   }
/*     */ 
/*     */   public TradeOrder selectByOrderNo(String orderNo)
/*     */   {
/*  69 */     return this.tradeOrderDAO.selectByOrderNo(orderNo);
/*     */   }
/*     */ 
/*     */   public TradeOrderDetail selectDetailByOrderNo(String orderNo)
/*     */   {
/*  74 */     return this.tradeOrderDetailDAO.selectByOrderNo(orderNo);
/*     */   }
/*     */ 
/*     */   public TradeOrderDetail selectBuyerOrderDetailByOrderNo(String orderNo, String buyerAccount)
/*     */   {
/*  79 */     Map map = new HashMap();
/*  80 */     map.put("orderNo", orderNo);
/*  81 */     map.put("buyerAccount", buyerAccount);
/*  82 */     return this.tradeOrderDetailDAO.selectOrderByMapParam(map);
/*     */   }
/*     */ 
/*     */   public TradeOrderDetail selectSellerOrderDetailByOrderNo(String orderNo, String sellerAccount)
/*     */   {
/*  87 */     Map map = new HashMap();
/*  88 */     map.put("orderNo", orderNo);
/*  89 */     map.put("sellerAccount", sellerAccount);
/*  90 */     return this.tradeOrderDetailDAO.selectOrderByMapParam(map);
/*     */   }
/*     */ 
/*     */   public ServiceResult orderConfirm(TradeOrderRequest request)
/*     */   {
/* 102 */     ServiceResult serviceResult = new ServiceResult();
/* 103 */     if ((request == null) || (StringUtil.isEmpty(request.getUserAccount())) || 
/* 104 */       (StringUtil.isEmpty(request.getOrderNo()))) {
/* 105 */       serviceResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 106 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 107 */       return serviceResult;
/*     */     }
/*     */     try {
/* 110 */       serviceResult = this.remoteTradeOrderService.orderConfirm(request);
/*     */     } catch (Exception e) {
/* 112 */       serviceResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 113 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/* 114 */       return serviceResult;
/*     */     }
/* 116 */     return serviceResult;
/*     */   }
/*     */ 
/*     */   public TradeOrderCashDepositResult queryBuyerOrderCashDeposit(String orderNo, String userAccount)
/*     */   {
/* 121 */     TradeOrderCashDepositRequest request = new TradeOrderCashDepositRequest();
/* 122 */     TradeOrderCashDepositResult result = new TradeOrderCashDepositResult();
/* 123 */     if ((StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(orderNo))) {
/* 124 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 125 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 126 */       return result;
/*     */     }
/* 128 */     request.setBuyerAccount(userAccount);
/* 129 */     request.setOrderNo(orderNo);
/*     */     try {
/* 131 */       result = this.remoteTradeOrderService.queryOrderCashDeposit(request);
/*     */     } catch (Exception e) {
/* 133 */       e.printStackTrace();
/* 134 */       this.log.error("", e);
/* 135 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 136 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/* 137 */       return result;
/*     */     }
/* 139 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderCashDepositResult querySellerOrderCashDeposit(String orderNo, String userAccount)
/*     */   {
/* 145 */     TradeOrderCashDepositRequest request = new TradeOrderCashDepositRequest();
/* 146 */     TradeOrderCashDepositResult result = new TradeOrderCashDepositResult();
/* 147 */     if ((StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(orderNo))) {
/* 148 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 149 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 150 */       return result;
/*     */     }
/* 152 */     request.setSellerAccount(userAccount);
/* 153 */     request.setOrderNo(orderNo);
/*     */     try {
/* 155 */       result = this.remoteTradeOrderService.queryOrderCashDeposit(request);
/*     */     } catch (Exception e) {
/* 157 */       e.printStackTrace();
/* 158 */       this.log.error("", e);
/* 159 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 160 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/* 161 */       return result;
/*     */     }
/* 163 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult orderPay(TradeOrderBaseRequest request)
/*     */   {
/* 172 */     ServiceResult result = new ServiceResult();
/*     */     try {
/* 174 */       result = this.remoteTradeOrderService.orderPay(request);
/*     */     } catch (Exception e) {
/* 176 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 177 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 179 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult orderSendGoods(TradeOrderBaseRequest request)
/*     */   {
/* 188 */     ServiceResult result = new ServiceResult();
/*     */     try {
/* 190 */       result = this.remoteTradeOrderService.orderSendGoods(request);
/*     */     } catch (Exception e) {
/* 192 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 193 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 195 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult orderGoodsValidate(TradeOrderBaseRequest request)
/*     */   {
/* 204 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */     try {
/* 206 */       result = this.remoteTradeOrderService.orderGoodsValidate(request);
/*     */     } catch (Exception e) {
/* 208 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 209 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 211 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult orderInvoiceValidate(TradeOrderBaseRequest request)
/*     */   {
/* 220 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */     try {
/* 222 */       result = this.remoteTradeOrderService.orderInvoiceValidate(request);
/*     */     } catch (Exception e) {
/* 224 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 225 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 227 */     return result;
/*     */   }
/*     */ 
/*     */   public UserCreditServiceResult evaluateUser(UserCreditRequest request)
/*     */   {
/* 232 */     UserCreditServiceResult result = new UserCreditServiceResult();
/* 233 */     if (request == null) {
/* 234 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 235 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 236 */       return result;
/*     */     }
/*     */     try {
/* 239 */       result = this.remoteUserService.updateUserCredit(request);
/*     */     } catch (Exception e) {
/* 241 */       this.log.error("TradeOrderServiceImpl evaluateUser error:评价用户错误,服务器出错");
/* 242 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 243 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/*     */ 
/* 246 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderMoney queryTradeOrderMoneyByAccountOrderNo(String orderNo, String userAccount)
/*     */   {
/* 251 */     return this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, userAccount);
/*     */   }
/*     */ 
/*     */   public List<TradeOrderAndPro> selectLatestOrder(Integer count, String projectTypeCode)
/*     */   {
/* 261 */     TradeOrderQuery query = new TradeOrderQuery();
/* 262 */     query.setProjectTypeCode(projectTypeCode);
/* 263 */     query.setTradeOrderCount(count);
/* 264 */     List list = this.tradeOrderDAO.selectLatestOrderByCounts(query);
/* 265 */     List result = new ArrayList();
/* 266 */     for (int i = 0; i < count.intValue(); i++) {
/* 267 */       if (i < list.size()) {
/* 268 */         TradeOrderAndPro op = (TradeOrderAndPro)list.get(i);
/*     */ 
/* 273 */         String forestryQuantityDes = "";
/* 274 */         ProjectMetas projectMetas = new ProjectMetas();
/* 275 */         projectMetas.setProjectId(op.getProjectId());
/* 276 */         projectMetas.setMetaKey("AREA");
/* 277 */         String mushu = this.projectMetasService.getMetaValue(projectMetas);
/* 278 */         projectMetas.setMetaKey("AREA_UNIT");
/* 279 */         String mu = this.projectMetasService.getMetaValue(projectMetas);
/* 280 */         if ((StringUtil.isNotBlank(mushu)) && (StringUtil.isNotBlank(mu))) {
/* 281 */           forestryQuantityDes = mushu + mu;
/*     */         }
/* 283 */         op.setForestryQuantityDes(forestryQuantityDes);
/*     */ 
/* 285 */         result.add(op);
/*     */       } else {
/* 287 */         result.add(new TradeOrderAndPro());
/*     */       }
/*     */     }
/* 290 */     return result;
/*     */   }
/*     */ 
/*     */   public Map<String, List<TradeOrderAndPro>> selectLatestOrder(Integer count)
/*     */   {
/* 302 */     if ((cache.get("cmsOrder") == null) || (((CacheDTO)cache.get("cmsOrder")).isOutTime()))
/* 303 */       updateLatestOrderCache(count);
/* 304 */     List proList = (List)((CacheDTO)cache.get("cmsOrder")).getData();
/* 305 */     Map map = new HashMap();
/* 306 */     map.put("type1", (List)proList.get(0));
/* 307 */     map.put("type2", (List)proList.get(1));
/* 308 */     map.put("type3", (List)proList.get(2));
/* 309 */     map.put("type4", (List)proList.get(3));
/* 310 */     return map;
/*     */   }
/*     */ 
/*     */   private void updateLatestOrderCache(Integer count)
/*     */   {
/* 320 */     CacheDTO cmsOrder = new CacheDTO();
/* 321 */     ArrayList ordList = new ArrayList();
/*     */ 
/* 323 */     ordList.add(0, selectLatestOrder(count, "0|1"));
/* 324 */     ordList.add(1, selectLatestOrder(count, "0|2"));
/* 325 */     ordList.add(2, selectLatestOrder(count, "0|3"));
/* 326 */     ordList.add(3, selectLatestOrder(count, "0|4"));
/* 327 */     cmsOrder.setData(ordList);
/* 328 */     cmsOrder.setOutMs(1800000L);
/*     */     try {
/* 330 */       cmsOrder.setUpdateTimeMs(DateUtil.getCurrentDay().getTimeInMillis());
/*     */     } catch (ParseException e) {
/* 332 */       e.printStackTrace();
/*     */     }
/* 334 */     cache.put("cmsOrder", cmsOrder);
/*     */   }
/*     */ 
/*     */   public List<DateStatistics> queryProjectListingByDate(EnumDateStatisticsType type, Long interval)
/*     */   {
/* 339 */     return this.tradeOrderDAO.queryProjectListingByDate(type, interval);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.order.TradeOrderServiceImpl
 * JD-Core Version:    0.6.0
 */