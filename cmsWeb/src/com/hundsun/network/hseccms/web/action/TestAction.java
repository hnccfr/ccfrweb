/*    */ package com.hundsun.network.hseccms.web.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.security.SettlerAgent;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class TestAction
/*    */ {
/*    */   @RequestMapping({"/test"})
/*    */   public String test(Model model, SettlerAgent settlerAgent)
/*    */   {
/* 14 */     return "/test";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.TestAction
 * JD-Core Version:    0.6.0
 */