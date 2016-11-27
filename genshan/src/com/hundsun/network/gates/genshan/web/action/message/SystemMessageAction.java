/*     */ package com.hundsun.network.gates.genshan.web.action.message;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.message.MessageInfo;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.message.SystemMessageText;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemMessageTextQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.message.SystemMessageService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMessageResult;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class SystemMessageAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private SystemMessageService systemMessageService;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_C_SYSTEM_MESSAGE})
/*     */   @RequestMapping(value={"/message/send"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void initMessageSending(@ModelAttribute("messageInfo") MessageInfo messageInfo)
/*     */   {
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_C_SYSTEM_MESSAGE})
/*     */   @RequestMapping(value={"/message/send"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String messageSending(UserAgent userAgent, @ModelAttribute("messageInfo") MessageInfo messageInfo, ModelMap model)
/*     */   {
/*  65 */     messageInfo.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/*  66 */     SystemMessageResult result = this.systemMessageService.sendMessage(messageInfo);
/*  67 */     if ((result.error()) && (null != result.getNotExitUsers())) {
/*  68 */       model.put("message", "您输入的站内信接收者都不存在！");
/*  69 */       model.put("url", "/message/list");
/*  70 */       return "waring";
/*  71 */     }if (result.error()) {
/*  72 */       model.put("message", result.getErrorInfo());
/*  73 */       model.put("url", "/message/list");
/*  74 */       return error(model);
/*  75 */     }if (null != result.getNotExitUsers()) {
/*  76 */       model.put("message", "用户" + result.getNotExitUsers() + "不存在，其余用户将会收到您发送的站内信");
/*  77 */       model.put("url", "/message/list");
/*  78 */       return "waring";
/*     */     }
/*  80 */     model.put("url", "/message/list");
/*  81 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_SYSTEM_MESSAGE_LIST})
/*     */   @RequestMapping({"/message/list"})
/*     */   public void systemMessageList(@ModelAttribute("query") SystemMessageTextQuery query)
/*     */   {
/* 104 */     this.systemMessageService.getAllSystemMessageText(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_D_SYSTEM_MESSAGE_DELETE})
/*     */   @RequestMapping(value={"/message/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String systemMessageDelete(@RequestParam("id") Long id, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 119 */     int result = this.systemMessageService.deleteMessageOfOne(id).intValue();
/* 120 */     if (result == 0) {
/* 121 */       model.put("message", "删除失败，服务器异常");
/* 122 */       model.put("url", "/message/list");
/* 123 */       return error(model);
/*     */     }
/* 125 */     model.put("url", "/message/list");
/* 126 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_SYSTEM_MESSAGE_VIEW})
/*     */   @RequestMapping(value={"/message/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void systemMessageView(@RequestParam("id") Long id, Model model)
/*     */   {
/* 139 */     SystemMessageText systemMessageText = this.systemMessageService.getSystemMessageText(id);
/* 140 */     model.addAttribute("systemMessageText", systemMessageText);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_SYSTEM_MESSAGE_MORE})
/*     */   @RequestMapping(value={"/message/more"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public List<String> getAllReceived(@RequestParam("id") Long id, @RequestParam("systemMessageId") String systemMessageId)
/*     */   {
/* 154 */     SystemMessageText systemMessageText = new SystemMessageText();
/* 155 */     systemMessageText.setId(id);
/* 156 */     systemMessageText.setSystemMessageId(systemMessageId);
/* 157 */     List receivedList = this.systemMessageService.getReceivedList(systemMessageText);
/* 158 */     return receivedList;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_D_SYSTEM_MESSAGE_ALLDELETE})
/*     */   @RequestMapping(value={"/message/deleteAll"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String systemMessageDeleteAll(@RequestParam("id") Long id, ModelMap model)
/*     */   {
/* 173 */     int result = this.systemMessageService.deleteMessage(id).intValue();
/* 174 */     if (0 == result) {
/* 175 */       model.put("message", "删除失败，服务器异常");
/* 176 */       model.put("url", "/message/list");
/* 177 */       return error(model);
/*     */     }
/* 179 */     model.put("url", "/message/list");
/* 180 */     return success(model);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.message.SystemMessageAction
 * JD-Core Version:    0.6.0
 */