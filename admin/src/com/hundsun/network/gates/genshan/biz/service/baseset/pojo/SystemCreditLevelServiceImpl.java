/*    */ package com.hundsun.network.gates.genshan.biz.service.baseset.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.SystemCreditLevelDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemCreditLevel;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemCreditLevelQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemCreditLevelService;
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
/*    */   public void selectPageList(SystemCreditLevelQuery query)
/*    */   {
/* 24 */     this.systemCreditLevelDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public List<SystemCreditLevel> selectAllList()
/*    */   {
/* 32 */     return this.systemCreditLevelDAO.selectAllList();
/*    */   }
/*    */ 
/*    */   public Long insert(SystemCreditLevel record)
/*    */   {
/* 40 */     return this.systemCreditLevelDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(SystemCreditLevel record)
/*    */   {
/* 48 */     return this.systemCreditLevelDAO.updateByPrimaryKey(record);
/*    */   }
/*    */ 
/*    */   public int updateBySelective(SystemCreditLevel record)
/*    */   {
/* 56 */     return this.systemCreditLevelDAO.updateBySelective(record);
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel selectByPrimaryKey(Long id)
/*    */   {
/* 65 */     return this.systemCreditLevelDAO.selectByPrimaryKey(id);
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel selectByCond(SystemCreditLevelQuery record)
/*    */   {
/* 74 */     return this.systemCreditLevelDAO.selectByCond(record);
/*    */   }
/*    */ 
/*    */   public int checkIntegralRange(SystemCreditLevelQuery query)
/*    */   {
/* 81 */     return this.systemCreditLevelDAO.checkIntegralRange(query);
/*    */   }
/*    */ 
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 89 */     return this.systemCreditLevelDAO.deleteByPrimaryKey(id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.pojo.SystemCreditLevelServiceImpl
 * JD-Core Version:    0.6.0
 */