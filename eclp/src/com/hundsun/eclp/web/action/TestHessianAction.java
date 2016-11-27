/*    */ package com.hundsun.eclp.web.action;
/*    */ 
/*    */ import com.hundsun.eclp.client.remote.client.RemoteUserService;
/*    */ import com.hundsun.eclp.client.remote.dto.UserDTO;
/*    */ import java.io.PrintStream;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class TestHessianAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   RemoteUserService remoteUserService;
/*    */ 
/*    */   @RequestMapping({"/test"})
/*    */   public String testHessianClient()
/*    */   {
/* 18 */     UserDTO user = this.remoteUserService.getUserInfoByID(Long.valueOf(123L));
/* 19 */     System.out.println(user.toString());
/* 20 */     return "";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.TestHessianAction
 * JD-Core Version:    0.6.0
 */