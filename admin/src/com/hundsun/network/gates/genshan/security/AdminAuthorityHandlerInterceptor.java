/*    */ package com.hundsun.network.gates.genshan.security;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.common.PermissionEnum;
/*    */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*    */ import com.hundsun.network.melody.common.web.adapter.AnnotationMethodHandlerInterceptorAdapter;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.springframework.core.annotation.AnnotationUtils;
/*    */ import org.springframework.web.context.request.ServletWebRequest;
/*    */ 
/*    */ public class AdminAuthorityHandlerInterceptor extends AnnotationMethodHandlerInterceptorAdapter
/*    */ {
/* 20 */   private static final Integer placeholder = Integer.valueOf(0);
/*    */ 
/* 37 */   private Map<Method, PermissionEnum[]> caches = new ConcurrentHashMap();
/*    */ 
/* 39 */   private Map<Method, Integer> noControlCaches = new ConcurrentHashMap();
/*    */ 
/*    */   public void preInvoke(Method handlerMethod, Object handler, ServletWebRequest webRequest)
/*    */   {
/* 25 */     Cookyjar cookyjar = (Cookyjar)webRequest.getAttribute("cookyjar", 0);
/*    */ 
/* 27 */     if (cookyjar == null) {
/* 28 */       throw new IllegalStateException("cookyjar not find in request");
/*    */     }
/* 30 */     UserAgent agent = (UserAgent)cookyjar.getObject(UserAgent.class);
/*    */ 
/* 32 */     if (!pass(agent, handlerMethod, handler))
/* 33 */       throw new AdminAccessDeniedException();
/*    */   }
/*    */ 
/*    */   private boolean pass(UserAgent user, Method handlerMethod, Object handler)
/*    */   {
/* 43 */     PermissionEnum[] permissions = null;
/* 44 */     permissions = (PermissionEnum[])this.caches.get(handlerMethod);
/* 45 */     if (permissions == null) {
/* 46 */       if (this.noControlCaches.containsKey(handlerMethod)) {
/* 47 */         return true;
/*    */       }
/* 49 */       AdminAccess access = (AdminAccess)AnnotationUtils.getAnnotation(handlerMethod, AdminAccess.class);
/* 50 */       if (access == null) {
/* 51 */         this.noControlCaches.put(handlerMethod, placeholder);
/* 52 */         return true;
/*    */       }
/* 54 */       permissions = access.value();
/* 55 */       this.caches.put(handlerMethod, permissions);
/*    */     }
/* 57 */     if (permissions.length == 0) {
/* 58 */       return user != null;
/*    */     }
/* 60 */     if (user != null) {
/* 61 */       for (PermissionEnum em : permissions) {
/* 62 */         if (user.havePermission(em)) {
/* 63 */           return true;
/*    */         }
/*    */       }
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.security.AdminAuthorityHandlerInterceptor
 * JD-Core Version:    0.6.0
 */