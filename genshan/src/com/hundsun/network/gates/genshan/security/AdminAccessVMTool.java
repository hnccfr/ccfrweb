/*    */ package com.hundsun.network.gates.genshan.security;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.common.PermissionEnum;
/*    */ import com.hundsun.network.gates.genshan.common.UserAgent;
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
/* 17 */     if (!(obj instanceof ViewContext)) {
/* 18 */       throw new IllegalArgumentException("Tool can only be initialized with a ViewContext");
/*    */     }
/*    */ 
/* 21 */     ViewContext viewContext = (ViewContext)obj;
/* 22 */     HttpServletRequest request = viewContext.getRequest();
/* 23 */     Cookyjar cookyjar = (Cookyjar)request.getAttribute("cookyjar");
/*    */ 
/* 25 */     if (cookyjar == null) {
/* 26 */       throw new IllegalStateException("Cookyjar not find in HttpServletRequest");
/*    */     }
/*    */ 
/* 29 */     this.agent = ((UserAgent)cookyjar.getObject(UserAgent.class));
/* 30 */     if (this.agent == null)
/* 31 */       throw new IllegalStateException("AdministerAgent not find in Cookyjar");
/*    */   }
/*    */ 
/*    */   public boolean havePermission(String permissionName)
/*    */   {
/* 37 */     PermissionEnum permission = PermissionEnum.valueOf(permissionName);
/* 38 */     if (permission == null) {
/* 39 */       throw new IllegalArgumentException("unknow permission name:" + permissionName);
/*    */     }
/*    */ 
/* 42 */     return this.agent.havePermission(permission);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.security.AdminAccessVMTool
 * JD-Core Version:    0.6.0
 */