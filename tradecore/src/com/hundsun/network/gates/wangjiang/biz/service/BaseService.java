/*    */ package com.hundsun.network.gates.wangjiang.biz.service;
/*    */ 
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.InitializingBean;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.transaction.support.TransactionTemplate;
/*    */ 
/*    */ public abstract class BaseService
/*    */   implements InitializingBean
/*    */ {
/* 11 */   protected Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   protected TransactionTemplate transactionTemplate;
/*    */ 
/*    */   public void afterPropertiesSet()
/*    */     throws Exception
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.service.BaseService
 * JD-Core Version:    0.6.0
 */