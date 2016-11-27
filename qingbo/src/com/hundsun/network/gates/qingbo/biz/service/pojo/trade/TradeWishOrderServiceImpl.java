/*    */ package com.hundsun.network.gates.qingbo.biz.service.pojo.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeWishOrderDTO;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeWishOrderServiceResult;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.trade.TradeWishOrderDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.trade.TradeWishOrderService;
/*    */ import com.hundsun.network.gates.qingbo.biz.util.ConvertUtils;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tradeWishOrderService")
/*    */ public class TradeWishOrderServiceImpl extends BaseService
/*    */   implements TradeWishOrderService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeWishOrderDAO tradeWishOrderDAO;
/*    */ 
/*    */   public TradeWishOrderServiceResult addTradeWishOrder(TradeWishOrder tradeWishOrder)
/*    */     throws Exception
/*    */   {
/* 34 */     TradeWishOrderServiceResult result = new TradeWishOrderServiceResult();
/* 35 */     if (null == tradeWishOrder) {
/* 36 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 37 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 38 */       this.log.error("fail:check afferent parameter");
/* 39 */       throw new ServiceException(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*    */     }
/*    */ 
/* 42 */     tradeWishOrder.setWishOrderNum(generalWishOrderNo());
/* 43 */     Long tradeWishOrderId = this.tradeWishOrderDAO.insert(tradeWishOrder);
/* 44 */     TradeWishOrderDTO tradeWishOrderDTO = ConvertUtils.convertTradeWishOrder2TradeWishOrderDTO(tradeWishOrder);
/*    */ 
/* 46 */     tradeWishOrderDTO.setId(tradeWishOrderId);
/* 47 */     result.setTradeWishOrderDTO(tradeWishOrderDTO);
/* 48 */     return result;
/*    */   }
/*    */ 
/*    */   public List<TradeWishOrderDTO> selectLatestTradeWishOrder(int counts) {
/* 52 */     List list = new ArrayList();
/* 53 */     List<TradeWishOrder> tlist = this.tradeWishOrderDAO.selectLatestTradeWishOrder(counts);
/* 54 */     for (TradeWishOrder tradeWishOrder : tlist) {
/* 55 */       TradeWishOrderDTO tradeWishOrderDTO = new TradeWishOrderDTO();
/* 56 */       tradeWishOrderDTO = ConvertUtils.convertTradeWishOrder2TradeWishOrderDTO(tradeWishOrder);
/*    */ 
/* 58 */       list.add(tradeWishOrderDTO);
/* 59 */       tradeWishOrder = null;
/*    */     }
/* 61 */     return list;
/*    */   }
/*    */ 
/*    */   public String generalWishOrderNo()
/*    */   {
/* 70 */     return this.tradeWishOrderDAO.generalWishOrderNo();
/*    */   }
/*    */ 
/*    */   public boolean deleteTradeWishOrderByNo(String tradeWishOrderNo) {
/* 74 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.pojo.trade.TradeWishOrderServiceImpl
 * JD-Core Version:    0.6.0
 */