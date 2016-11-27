/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.message;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMessageResult;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.message.SystemMessageDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.message.SystemMessageTextDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.message.MessageForMore;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.message.SystemMessageText;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.message.SystemMessageService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("systemMessageService")
/*    */ public class SystemMessageServiceImpl extends BaseService
/*    */   implements SystemMessageService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemMessageTextDAO systemMessageTextDAO;
/*    */ 
/*    */   @Autowired
/*    */   private SystemMessageDAO systemMessageDAO;
/*    */ 
/*    */   public Long addMessageText(SystemMessageText systemMessageText)
/*    */   {
/* 35 */     return this.systemMessageTextDAO.insert(systemMessageText);
/*    */   }
/*    */ 
/*    */   public void addMessage(MessageForMore messageForMore)
/*    */   {
/* 40 */     this.systemMessageDAO.batchInsertMessage(messageForMore);
/*    */   }
/*    */ 
/*    */   public SystemMessageResult sendSystemMessage(SystemMessageRequest request)
/*    */   {
/* 45 */     SystemMessageResult systemMessageResult = new SystemMessageResult();
/* 46 */     if ((null == request) || (request.getUserAccountList().size() <= 0) || (StringUtil.isEmpty(request.getTitle())) || (StringUtil.isEmpty(request.getContent())) || (StringUtil.isEmpty(request.getSendAccount())))
/*    */     {
/* 48 */       systemMessageResult.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 49 */       systemMessageResult.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 50 */       return systemMessageResult;
/*    */     }
/*    */ 
/* 53 */     SystemMessageText systemMessageText = new SystemMessageText();
/* 54 */     systemMessageText.setTitle(request.getTitle());
/* 55 */     systemMessageText.setContent(request.getContent());
/* 56 */     systemMessageText.setOperator(request.getSendAccount());
/* 57 */     Long textId = addMessageText(systemMessageText);
/* 58 */     if (textId.longValue() > 0L) {
/* 59 */       MessageForMore messageForMore = new MessageForMore();
/* 60 */       messageForMore.setUserAccountList(request.getUserAccountList());
/* 61 */       messageForMore.setMessageId(textId);
/* 62 */       messageForMore.setSendAccount(request.getSendAccount());
/* 63 */       addMessage(messageForMore);
/* 64 */       return systemMessageResult;
/*    */     }
/* 66 */     systemMessageResult.setErrorNO(Integer.valueOf(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getValue()));
/* 67 */     systemMessageResult.setErrorInfo(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getInfo());
/* 68 */     return systemMessageResult;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.message.SystemMessageServiceImpl
 * JD-Core Version:    0.6.0
 */