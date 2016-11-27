/*    */ package com.hundsun.eclp.biz.service.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.service.ToolService;
/*    */ import com.hundsun.eclp.biz.service.common.RemoteService;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("toolService")
/*    */ public class ToolServiceImpl
/*    */   implements ToolService
/*    */ {
/* 18 */   protected Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   private RemoteService remoteService;
/*    */ 
/*    */   public boolean synchronizeUpdateTime(String subSystemCode)
/*    */   {
/* 27 */     boolean result = this.remoteService.synchronizeUpdateTime(subSystemCode);
/* 28 */     this.log.info("synchronizeUpdateTime result is " + result);
/* 29 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.ToolServiceImpl
 * JD-Core Version:    0.6.0
 */