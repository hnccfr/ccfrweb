/*    */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMessageResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemMessageService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.message.SystemMessageService;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("remoteSystemMessageService")
/*    */ public class RemoteSystemMessageServiceImpl extends BaseService
/*    */   implements RemoteSystemMessageService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemMessageService systemMessageService;
/*    */ 
/*    */   public SystemMessageResult sendSystemMessage(SystemMessageRequest request)
/*    */   {
/* 38 */     this.log.debug("RemoteSystemMessageService sendSystemMessage");
/* 39 */     SystemMessageResult systemMessageResult = new SystemMessageResult();
/*    */     try {
/* 41 */       systemMessageResult = this.systemMessageService.sendSystemMessage(request);
/*    */     } catch (Exception e) {
/* 43 */       systemMessageResult.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 44 */       systemMessageResult.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 45 */       return systemMessageResult;
/*    */     }
/* 47 */     return systemMessageResult;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteSystemMessageServiceImpl
 * JD-Core Version:    0.6.0
 */