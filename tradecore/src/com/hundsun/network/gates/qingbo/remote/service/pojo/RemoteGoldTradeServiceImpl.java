/*     */ package com.hundsun.network.gates.qingbo.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.biz.service.TradeAdapter;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.enums.EnumTradeResultErrors;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.request.PlaceOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.request.ProjectRequest;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.request.TradeRequest;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.result.ProjectTradeServiceResult;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.service.RemoteGoldTradeService;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLevelRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserLevelServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.qingbo.biz.validator.CommonValidate;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteGoldTradeService")
/*     */ public class RemoteGoldTradeServiceImpl extends BaseService
/*     */   implements RemoteGoldTradeService<Object>
/*     */ {
/*  34 */   private Map<String, TradeAdapter<Object>> functionMap = new HashMap();
/*     */ 
/*     */   @Autowired
/*     */   private CommonValidate commonValidate;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*  37 */   public void setFunctionMap(Map<String, TradeAdapter<Object>> functionMap) { this.functionMap.putAll(functionMap);
/*     */   }
/*     */ 
/*     */   public ProjectTradeServiceResult getTradingStatus(PlaceOrderRequest request)
/*     */   {
/*  54 */     ProjectTradeServiceResult result = new ProjectTradeServiceResult();
/*  55 */     result.setTradeProjectStatus("normal");
/*  56 */     return result;
/*     */   }
/*     */ 
/*     */   public OrderServiceResult bargain(TradeRequest request)
/*     */   {
/*  67 */     OrderServiceResult result = new OrderServiceResult();
/*  68 */     String funId = request.getFunId();
/*  69 */     BaseTradeDTO baseTradeDTO = (BaseTradeDTO)request.getTradeDTO();
/*  70 */     result = this.commonValidate.validateData(baseTradeDTO);
/*  71 */     if (!result.correct()) {
/*  72 */       return result;
/*     */     }
/*  74 */     if ((StringUtil.isEmpty(funId)) || (null == funId)) {
/*  75 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeResultErrors.TRADE_IMPL_CALSS_NOT_FIND_ERROR.getValue()), funId + EnumTradeResultErrors.TRADE_IMPL_CALSS_NOT_FIND_ERROR.getInfo());
/*     */ 
/*  77 */       return result;
/*     */     }
/*  79 */     TradeAdapter tradeAdapter = (TradeAdapter)this.functionMap.get(funId);
/*  80 */     if (tradeAdapter == null) {
/*  81 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeResultErrors.GOLD_TRADE_IMPL_INTANCE_NOT_FIND.getValue()), EnumTradeResultErrors.GOLD_TRADE_IMPL_INTANCE_NOT_FIND.getInfo());
/*     */     }
/*     */ 
/*  85 */     if (this.log.isInfoEnabled()) {
/*  86 */       this.log.info("--Do bargin  in qingbo at RemoteGoldTradeServiceImpl.java--");
/*     */     }
/*  88 */     return tradeAdapter.bargain(request.getTradeDTO());
/*     */   }
/*     */ 
/*     */   public ServiceResult suspension(ProjectRequest request)
/*     */   {
/*  98 */     ServiceResult result = new ServiceResult();
/*  99 */     int integral = 0;
/*     */     try
/*     */     {
/* 109 */       UserLevelRequest urequest = new UserLevelRequest();
/* 110 */       urequest.setIntegral(Integer.valueOf(integral));
/* 111 */       urequest.setUserAccount(request.getUserAccount());
/* 112 */       urequest.setOperator(request.getUserAccount());
/* 113 */       urequest.setOperateCode(EnumSystemDictKey.PROJECT_LISTING_ADDINTEGRAL.getValue());
/* 114 */       if (this.remoteUserService == null) {
/* 115 */         this.log.debug("===========连接远程用户的用户接口失败！");
/*     */       }
/*     */       else {
/* 118 */         UserLevelServiceResult uresult = this.remoteUserService.updateUserLevel(urequest);
/* 119 */         if (uresult == null) {
/* 120 */           this.log.debug("====挂牌新增会员积分=======连接远程用户的用户接口新增会员积分失败！+ 会员名称：" + urequest.getOperator() + "   获得积分：" + urequest.getIntegral() + " 时间：" + new Date());
/*     */         }
/* 123 */         else if (!uresult.correct())
/* 124 */           this.log.debug(uresult.getErrorInfo());
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 129 */       this.log.debug(e + "====挂牌新增会员积分=======连接远程用户的用户接口新增会员积分失败！+ 会员名称：" + request.getUserAccount() + "   获得积分：" + integral + " 时间：" + new Date());
/*     */     }
/*     */ 
/* 132 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult withdraw(ProjectRequest request)
/*     */   {
/* 142 */     int integral = 0;
/* 143 */     ServiceResult result = new ServiceResult();
/*     */     try
/*     */     {
/* 153 */       UserLevelRequest urequest = new UserLevelRequest();
/* 154 */       urequest.setIntegral(Integer.valueOf(integral));
/* 155 */       urequest.setUserAccount(request.getUserAccount());
/* 156 */       urequest.setOperator(request.getUserAccount());
/* 157 */       urequest.setOperateCode(EnumSystemDictKey.PROJECT_LISTING_ADDINTEGRAL.getValue());
/* 158 */       if (this.remoteUserService == null) {
/* 159 */         this.log.debug("===========连接远程用户的用户接口失败！");
/*     */       }
/*     */       else {
/* 162 */         UserLevelServiceResult uresult = this.remoteUserService.updateUserLevel(urequest);
/* 163 */         if (uresult == null) {
/* 164 */           this.log.debug("====挂牌新增会员积分=======连接远程用户的用户接口新增会员积分失败！+ 会员名称：" + urequest.getOperator() + "   获得积分：" + urequest.getIntegral() + " 时间：" + new Date());
/*     */         }
/* 167 */         else if (!uresult.correct())
/* 168 */           this.log.debug(uresult.getErrorInfo());
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 173 */       this.log.debug(e + "====挂牌新增会员积分=======连接远程用户的用户接口新增会员积分失败！+ 会员名称：" + request.getUserAccount() + "   获得积分：" + integral + " 时间：" + new Date());
/*     */     }
/*     */ 
/* 201 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.remote.service.pojo.RemoteGoldTradeServiceImpl
 * JD-Core Version:    0.6.0
 */