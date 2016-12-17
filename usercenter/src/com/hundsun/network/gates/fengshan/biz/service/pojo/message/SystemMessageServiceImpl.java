/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.message;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.message.SystemMessageDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.message.SystemMessage;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.SystemMessageQuery;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.message.SystemMessageService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("systemMessageService")
/*    */ public class SystemMessageServiceImpl extends BaseService
/*    */   implements SystemMessageService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemMessageDAO systemMessageDAO;
/*    */ 
/*    */   public Integer changeMessage(Long id)
/*    */   {
/* 27 */     return this.systemMessageDAO.updateMessageById(id);
/*    */   }
/*    */ 
/*    */   public Integer deleteMessage(Long id)
/*    */   {
/* 32 */     return this.systemMessageDAO.deleteMessageById(id);
/*    */   }
/*    */ 
/*    */   public SystemMessage getMessage(Long id)
/*    */   {
/* 41 */     SystemMessage systemMessage = this.systemMessageDAO.selectMessageById(id);
/* 42 */     if (null != systemMessage.getId()) {
/* 43 */       changeMessage(id);
/*    */     }
/* 45 */     return systemMessage;
/*    */   }
/*    */ 
/*    */   public void getMessageList(SystemMessageQuery query)
/*    */   {
/* 50 */     this.systemMessageDAO.selectMessageListByQuery(query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.message.SystemMessageServiceImpl
 * JD-Core Version:    0.6.0
 */