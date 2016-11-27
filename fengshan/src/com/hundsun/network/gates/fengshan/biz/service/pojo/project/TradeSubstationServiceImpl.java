/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.TradeSubstationDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.TradeSubstation;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.project.TradeSubstationService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tradeSubstationService")
/*    */ public class TradeSubstationServiceImpl
/*    */   implements TradeSubstationService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeSubstationDAO tradeSubstationDAO;
/*    */ 
/*    */   public List<TradeSubstation> selectAllSubstationList()
/*    */   {
/* 19 */     return this.tradeSubstationDAO.selectAllSubstationList();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.project.TradeSubstationServiceImpl
 * JD-Core Version:    0.6.0
 */