/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.message;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.message.SystemMessageTextDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.message.MessageInfo;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.message.SystemMessageText;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemMessageTextQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.message.SystemMessageService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMessageResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemMessageService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("systemMessageService")
/*     */ public class SystemMessageServiceImpl extends BaseService
/*     */   implements SystemMessageService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemMessageService remoteSystemMessageService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemMessageTextDAO systemMessageTextDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountDAO userAccountDAO;
/*     */ 
/*     */   public SystemMessageResult sendMessage(MessageInfo messageInfo)
/*     */   {
/*  45 */     SystemMessageRequest request = new SystemMessageRequest();
/*  46 */     SystemMessageResult result = new SystemMessageResult();
/*  47 */     List userAccountList = new ArrayList();
/*  48 */     String notExitUsers = null;
/*  49 */     String[] userAccounts = messageInfo.getUserAccounts().split(";");
/*  50 */     HashSet set = new HashSet();
/*  51 */     for (int i = 0; i < userAccounts.length; i++) {
/*  52 */       set.add(userAccounts[i].trim());
/*  53 */       userAccountList.add(userAccounts[i].trim());
/*     */     }
/*  55 */     List exitUserList = this.userAccountDAO.selectAccountList(userAccountList);
/*     */ 
/*  57 */     for (int i = 0; i < exitUserList.size(); i++) {
/*  58 */       if (set.contains(exitUserList.get(i))) {
/*  59 */         set.remove(exitUserList.get(i));
/*     */       }
/*     */     }
/*  62 */     if (set.size() > 0) {
/*  63 */       notExitUsers = set.toString();
/*     */     }
/*     */ 
/*  66 */     if (exitUserList.size() == 0) {
/*  67 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/*  68 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/*  69 */       result.setNotExitUsers(notExitUsers);
/*  70 */       return result;
/*     */     }
/*  72 */     request.setUserAccountList(exitUserList);
/*  73 */     request.setSendAccount(messageInfo.getSendAccount().trim());
/*  74 */     request.setOperator(messageInfo.getSendAccount().trim());
/*  75 */     request.setTitle(messageInfo.getTitle().trim());
/*  76 */     request.setContent(messageInfo.getContent());
/*     */     try {
/*  78 */       result = this.remoteSystemMessageService.sendSystemMessage(request);
/*  79 */       result.setNotExitUsers(notExitUsers);
/*  80 */       return result;
/*     */     } catch (Exception e) {
/*  82 */       this.log.error("SystemMessageServiceImpl sendMessage error:" + e.getMessage());
/*  83 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/*  84 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/*  85 */     }return result;
/*     */   }
/*     */ 
/*     */   public void getAllSystemMessageText(SystemMessageTextQuery query)
/*     */   {
/*  92 */     this.systemMessageTextDAO.selectSystemMessageTextList(query);
/*     */   }
/*     */ 
/*     */   public SystemMessageText getSystemMessageText(Long id)
/*     */   {
/*  97 */     return this.systemMessageTextDAO.selectTextById(id);
/*     */   }
/*     */ 
/*     */   public Integer deleteMessage(final Long id)
/*     */   {
/* 102 */     int result = ((Integer)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public Integer doInTransaction(TransactionStatus status) {
/* 104 */         Integer result = Integer.valueOf(0);
/*     */         try {
/* 106 */           SystemMessageServiceImpl.this.systemMessageTextDAO.deleteTextById(id);
/* 107 */           result = SystemMessageServiceImpl.this.systemMessageTextDAO.deleteUnionByMessageId(id);
/*     */         } catch (Exception e) {
/* 109 */           status.rollbackToSavepoint(status);
/* 110 */           e.printStackTrace();
/* 111 */           SystemMessageServiceImpl.this.log.error("SystemMessageServiceImpl deleteMessage error:" + EnumUserResultErrors.SERVER_ERROR.getInfo());
/*     */         }
/*     */ 
/* 114 */         return result;
/*     */       }
/*     */     })).intValue();
/*     */ 
/* 117 */     return Integer.valueOf(result);
/*     */   }
/*     */ 
/*     */   public Integer changeSystemMessageText(SystemMessageText systemMessageText)
/*     */   {
/* 122 */     return this.systemMessageTextDAO.updateTextById(systemMessageText);
/*     */   }
/*     */ 
/*     */   public Integer deleteUnionByMessage(Long id) {
/* 126 */     return this.systemMessageTextDAO.deleteUnionByMessageId(id);
/*     */   }
/*     */ 
/*     */   public Integer deleteSystemMessageText(Long id) {
/* 130 */     return this.systemMessageTextDAO.deleteTextById(id);
/*     */   }
/*     */ 
/*     */   public List<String> getReceivedList(SystemMessageText systemMessageText)
/*     */   {
/* 147 */     return this.systemMessageTextDAO.selectReceiveAccountList(systemMessageText);
/*     */   }
/*     */ 
/*     */   public Integer deleteMessageOfOne(Long id)
/*     */   {
/* 152 */     return this.systemMessageTextDAO.deleteMessageOfOne(id);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.message.SystemMessageServiceImpl
 * JD-Core Version:    0.6.0
 */