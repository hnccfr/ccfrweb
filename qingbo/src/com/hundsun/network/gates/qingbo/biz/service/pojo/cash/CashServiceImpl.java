/*    */ package com.hundsun.network.gates.qingbo.biz.service.pojo.cash;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.enums.EnumTradeResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectBaseSettingService;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderService;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.cash.TradeCashDTO;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.cash.CashService;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("cashService")
/*    */ public class CashServiceImpl extends BaseService
/*    */   implements CashService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   RemoteUserService remoteUserService;
/*    */ 
/*    */   @Autowired
/*    */   RemoteSystemBaseService remoteSystemBaseService;
/*    */ 
/*    */   @Autowired
/*    */   RemoteProjectBaseSettingService remoteProjectBaseSettingService;
/*    */ 
/*    */   @Autowired
/*    */   RemoteFundService remoteFundService;
/*    */ 
/*    */   @Autowired
/*    */   private RemoteTradeOrderService remoteTradeOrderService;
/*    */ 
/*    */   public ServiceResult tradeClearCash(TradeCashDTO tradeCashDTO, String wishOrderNo, Long orderJyProportionCash, Long listingturnover)
/*    */     throws ServiceException
/*    */   {
/* 55 */     ServiceResult result = new ServiceResult();
/*    */ 
/* 57 */     TransRequest frequest = new TransRequest();
/* 58 */     frequest.setFundAccount(tradeCashDTO.getFundAccount());
/* 59 */     frequest.setOrderProperty(tradeCashDTO.getTradingType());
/* 60 */     frequest.setFreezeFeeAmount(listingturnover);
/* 61 */     frequest.setBizNo(wishOrderNo);
/* 62 */     frequest.setOperator(tradeCashDTO.getUserAccount());
/*    */ 
/* 64 */     frequest.setFreezeDepositAmount(orderJyProportionCash);
/* 65 */     FundOperateResult foresult = this.remoteFundService.freezeFundByTrade(frequest);
/* 66 */     if (foresult == null) {
/* 67 */       this.log.debug("调用资金的远程接口失败");
/* 68 */       result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getValue()));
/* 69 */       result.setErrorInfo(EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getInfo());
/* 70 */       rollbackClearOrder(wishOrderNo, tradeCashDTO.getUserAccount());
/* 71 */       throw new ServiceException(EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getInfo(), Integer.valueOf(EnumTradeResultErrors.REMOTE_CASH_CALL_ERROR.getValue()));
/*    */     }
/* 73 */     if (foresult.isError()) {
/* 74 */       this.log.debug("调用资金的远程接口失败:" + foresult.getErrorInfo());
/* 75 */       result.setErrorNO(Integer.valueOf(foresult.getErrorNO()));
/* 76 */       result.setErrorInfo(foresult.getErrorInfo());
/* 77 */       rollbackClearOrder(wishOrderNo, tradeCashDTO.getUserAccount());
/* 78 */       throw new ServiceException(foresult.getErrorInfo(), Integer.valueOf(foresult.getErrorNO()));
/*    */     }
/*    */ 
/* 81 */     return result;
/*    */   }
/*    */ 
/*    */   private ServiceResult rollbackClearOrder(String orderNo, String operator)
/*    */   {
/* 90 */     TradeOrderRequest request = new TradeOrderRequest();
/* 91 */     request.setOrderNo(orderNo);
/* 92 */     request.setOperator(operator);
/* 93 */     TradeOrderServiceResult tosResult = this.remoteTradeOrderService.rollbackOrder(request);
/* 94 */     return tosResult;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.pojo.cash.CashServiceImpl
 * JD-Core Version:    0.6.0
 */