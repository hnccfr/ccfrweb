/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemCreditLevelDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemCreditLevel;
/*    */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemCreditLevelService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("systemCreditLevelService")
/*    */ public class SystemCreditLevelServiceImpl
/*    */   implements SystemCreditLevelService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemCreditLevelDAO systemCreditLevelDAO;
/*    */ 
/*    */   public List<SystemCreditLevel> selectAllList()
/*    */   {
/* 22 */     return this.systemCreditLevelDAO.selectAllList();
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel selectByCreditLevel(String creditLevel)
/*    */   {
/* 31 */     return this.systemCreditLevelDAO.selectByCreditLevel(creditLevel);
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel selectInitCreditLevel()
/*    */   {
/* 39 */     return this.systemCreditLevelDAO.selectInitCreditLevel();
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel calcCreditLevel(Long integral)
/*    */   {
/* 48 */     if (integral.longValue() <= 0L)
/* 49 */       integral = new Long(0L);
/* 50 */     return this.systemCreditLevelDAO.calcCreditLevel(integral);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.baseset.SystemCreditLevelServiceImpl
 * JD-Core Version:    0.6.0
 */