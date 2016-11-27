/*    */ package com.hundsun.eclp.biz.service.sys.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.WorkLogDAO;
/*    */ import com.hundsun.eclp.biz.domain.sys.WorkLog;
/*    */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*    */ import com.hundsun.eclp.biz.query.WorkLogQuery;
/*    */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("workLogService")
/*    */ public class WorkLogServiceImpl
/*    */   implements WorkLogService
/*    */ {
/* 20 */   protected Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   private WorkLogDAO workLogDAO;
/*    */ 
/* 27 */   public void addWorkLog(String operatorType, String remark, UserAgent user) { WorkLog workLog = new WorkLog();
/* 28 */     workLog.setUserId(Long.valueOf(user.getId()));
/* 29 */     workLog.setAccount(user.getName());
/* 30 */     workLog.setOperatorType(operatorType);
/* 31 */     workLog.setRemark(remark);
/* 32 */     workLog.setSubSystemCode("eclp");
/* 33 */     this.workLogDAO.insert(workLog);
/*    */   }
/*    */ 
/*    */   public WorkLogQuery selectWorkLogByPage(WorkLogQuery query)
/*    */   {
/* 39 */     this.log.info("WorkLogServiceImpl.selectWorkLogByPage method");
/*    */     try {
/* 41 */       return this.workLogDAO.serarchByPage(query);
/*    */     } catch (Exception e) {
/* 43 */       this.log.error(e.getMessage());
/*    */     }
/* 45 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.sys.impl.WorkLogServiceImpl
 * JD-Core Version:    0.6.0
 */