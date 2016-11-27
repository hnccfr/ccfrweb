/*    */ package com.hundsun.eclp.security;
/*    */ 
/*    */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*    */ import com.hundsun.eclp.enums.PermissionEnum;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.velocity.tools.view.context.ViewContext;
/*    */ 
/*    */ public class AdminAccessVMTool
/*    */ {
/*    */   private UserAgent agent;
/*    */ 
/*    */   public void init(Object obj)
/*    */   {
/* 21 */     if (!(obj instanceof ViewContext)) {
/* 22 */       throw new IllegalArgumentException("Tool can only be initialized with a ViewContext");
/*    */     }
/*    */ 
/* 25 */     ViewContext viewContext = (ViewContext)obj;
/* 26 */     HttpServletRequest request = viewContext.getRequest();
/* 27 */     Cookyjar cookyjar = (Cookyjar)request.getAttribute("cookyjar");
/*    */ 
/* 29 */     if (cookyjar == null) {
/* 30 */       throw new IllegalStateException("Cookyjar not find in HttpServletRequest");
/*    */     }
/*    */ 
/* 33 */     this.agent = ((UserAgent)cookyjar.getObject(UserAgent.class));
/* 34 */     if (this.agent == null)
/* 35 */       throw new IllegalStateException("AdministerAgent not find in Cookyjar");
/*    */   }
/*    */ 
/*    */   public boolean has(String permissionName)
/*    */   {
/* 41 */     PermissionEnum permission = PermissionEnum.valueOf(permissionName);
/* 42 */     if (permission == null) {
/* 43 */       throw new IllegalArgumentException("unknow permission name:" + permissionName);
/*    */     }
/*    */ 
/* 46 */     return this.agent.havePermission(permission);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.security.AdminAccessVMTool
 * JD-Core Version:    0.6.0
 */