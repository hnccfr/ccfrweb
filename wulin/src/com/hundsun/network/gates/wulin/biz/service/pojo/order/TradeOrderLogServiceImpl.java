/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.order;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderLogDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderLog;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderLogService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tradeOrderLogService")
/*    */ public class TradeOrderLogServiceImpl extends BaseService
/*    */   implements TradeOrderLogService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderLogDAO tradeOrderLogDAO;
/*    */ 
/*    */   public Long insert(String orderNo, String preOrderStatus, String orderStatus, String operator, String operType, String remark)
/*    */   {
/* 25 */     TradeOrderLog record = new TradeOrderLog();
/* 26 */     record.setOrderNo(orderNo);
/* 27 */     record.setPreOrderStatus(preOrderStatus);
/* 28 */     record.setOrderStatus(orderStatus);
/* 29 */     record.setOperator(operator);
/* 30 */     record.setOperType(operType);
/* 31 */     record.setRemark(remark);
/* 32 */     return this.tradeOrderLogDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public List<TradeOrderLog> selectByOrderNo(String orderNo)
/*    */   {
/* 41 */     return this.tradeOrderLogDAO.selectByOrderNo(orderNo);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.TradeOrderLogServiceImpl
 * JD-Core Version:    0.6.0
 */