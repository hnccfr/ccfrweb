/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeWishOrderDTO;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeWishOrderServiceResult;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.trade.TradeWishOrderDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.trade.TradeWishOrder;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.trade.TradeWishOrderService;
/*    */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
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
/*    */   {
/* 34 */     TradeWishOrderServiceResult result = new TradeWishOrderServiceResult();
/*    */     try {
/* 36 */       if (null == tradeWishOrder) {
/* 37 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 38 */         result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 39 */         this.log.error("fail:check afferent parameter");
/* 40 */         return result;
/*    */       }
/* 42 */       tradeWishOrder.setWishOrderNum(generalWishOrderNo());
/* 43 */       Long tradeWishOrderId = this.tradeWishOrderDAO.insert(tradeWishOrder);
/* 44 */       TradeWishOrderDTO tradeWishOrderDTO = ConvertUtils.convertTradeWishOrder2TradeWishOrderDTO(tradeWishOrder);
/*    */ 
/* 46 */       tradeWishOrderDTO.setId(tradeWishOrderId);
/* 47 */       result.setTradeWishOrderDTO(tradeWishOrderDTO);
/*    */     } catch (Exception e) {
/* 49 */       this.log.debug(e);
/* 50 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 51 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/*    */     }
/* 53 */     return result;
/*    */   }
/*    */ 
/*    */   @Deprecated
/*    */   protected String TradeWishOrderNUmberCreator()
/*    */   {
/* 64 */     String dateStr = CommonUtils.convertDateToString("yyyyMMdd", new Date());
/*    */ 
/* 67 */     int seqNumber = this.tradeWishOrderDAO.getTradeWishOrderCountByDate();
/* 68 */     String temp = "00000000" + Long.valueOf(seqNumber + 1L).toString();
/* 69 */     String seqNumberStr = temp.substring(temp.length() - 8, temp.length());
/*    */ 
/* 71 */     String projectCode = "" + dateStr + seqNumberStr;
/*    */ 
/* 73 */     return projectCode;
/*    */   }
/*    */ 
/*    */   public List<TradeWishOrderDTO> selectLatestTradeWishOrder(int counts) {
/* 77 */     List list = new ArrayList();
/* 78 */     List<TradeWishOrder> tlist = this.tradeWishOrderDAO.selectLatestTradeWishOrder(counts);
/* 79 */     for (TradeWishOrder tradeWishOrder : tlist) {
/* 80 */       TradeWishOrderDTO tradeWishOrderDTO = new TradeWishOrderDTO();
/* 81 */       tradeWishOrderDTO = ConvertUtils.convertTradeWishOrder2TradeWishOrderDTO(tradeWishOrder);
/*    */ 
/* 83 */       list.add(tradeWishOrderDTO);
/* 84 */       tradeWishOrder = null;
/*    */     }
/* 86 */     return list;
/*    */   }
/*    */ 
/*    */   public String generalWishOrderNo()
/*    */   {
/* 95 */     return this.tradeWishOrderDAO.generalWishOrderNo();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.trade.TradeWishOrderServiceImpl
 * JD-Core Version:    0.6.0
 */