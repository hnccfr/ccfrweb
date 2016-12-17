/*    */ package com.hundsun.network.gates.fengshan.web.action.message;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.message.SystemMessage;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.SystemMessageQuery;
/*    */ import com.hundsun.network.gates.fengshan.biz.enums.EnumSystemMessageStatus;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.message.SystemMessageService;
/*    */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*    */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*    */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class SystemMessageAction extends BaseAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemMessageService systemMessageService;
/*    */ 
/*    */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_USER_MESSAGE})
/*    */   @RequestMapping({"/user/message/list"})
/*    */   public void userMessageList(UserAgent userAgent, @ModelAttribute("query") SystemMessageQuery query, Model model)
/*    */   {
/* 51 */     EnumSystemMessageStatus[] enumSystemMessageStatus = EnumSystemMessageStatus.values();
/* 52 */     model.addAttribute("enumSystemMessageStatus", enumSystemMessageStatus);
/* 53 */     if (null != query.getSendAccount())
/* 54 */       query.setSendAccount(query.getSendAccount().trim());
/* 55 */     if (null != query.getTitle())
/* 56 */       query.setTitle(query.getTitle().trim());
/* 57 */     query.setReceiveAccount(userAgent.getAccount());
/* 58 */     this.systemMessageService.getMessageList(query);
/*    */   }
/*    */ 
/*    */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_USER_MESSAGE})
/*    */   @RequestMapping(value={"/user/message/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void userMessageView(@ModelAttribute("systemMessage") SystemMessage systemMessage, Model model)
/*    */   {
/* 73 */     systemMessage = this.systemMessageService.getMessage(systemMessage.getId());
/* 74 */     model.addAttribute("systemMessage", systemMessage);
/*    */   }
/*    */ 
/*    */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_USER_MESSAGE})
/*    */   @RequestMapping(value={"/user/message/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @ResponseBody
/*    */   public int userMessageDelete(@RequestParam("id") Long id)
/*    */   {
/* 88 */     int result = this.systemMessageService.deleteMessage(id).intValue();
/* 89 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.message.SystemMessageAction
 * JD-Core Version:    0.6.0
 */