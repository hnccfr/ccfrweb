/*    */ package com.hundsun.eclp.security;
/*    */ 
/*    */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*    */ import com.hundsun.eclp.enums.PermissionEnum;
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
/* 24 */   private static final Integer placeholder = Integer.valueOf(0);
/*    */ 
/* 41 */   private Map<Method, PermissionEnum[]> caches = new ConcurrentHashMap();
/*    */ 
/* 43 */   private Map<Method, Integer> noControlCaches = new ConcurrentHashMap();
/*    */ 
/*    */   public void preInvoke(Method handlerMethod, Object handler, ServletWebRequest webRequest)
/*    */   {
/* 29 */     Cookyjar cookyjar = (Cookyjar)webRequest.getAttribute("cookyjar", 0);
/*    */ 
/* 31 */     if (cookyjar == null) {
/* 32 */       throw new IllegalStateException("cookyjar not find in request");
/*    */     }
/* 34 */     UserAgent agent = (UserAgent)cookyjar.getObject(UserAgent.class);
/*    */ 
/* 36 */     if (!pass(agent, handlerMethod, handler))
/* 37 */       throw new AdminAccessDeniedException();
/*    */   }
/*    */ 
/*    */   private boolean pass(UserAgent user, Method handlerMethod, Object handler)
/*    */   {
/* 47 */     PermissionEnum[] permissions = null;
/* 48 */     permissions = (PermissionEnum[])this.caches.get(handlerMethod);
/* 49 */     if (permissions == null) {
/* 50 */       if (this.noControlCaches.containsKey(handlerMethod)) {
/* 51 */         return true;
/*    */       }
/* 53 */       AdminAccess access = (AdminAccess)AnnotationUtils.getAnnotation(handlerMethod, AdminAccess.class);
/* 54 */       if (access == null) {
/* 55 */         this.noControlCaches.put(handlerMethod, placeholder);
/* 56 */         return true;
/*    */       }
/* 58 */       permissions = access.value();
/* 59 */       this.caches.put(handlerMethod, permissions);
/*    */     }
/* 61 */     if (permissions.length == 0) {
/* 62 */       return user != null;
/*    */     }
/* 64 */     if (user != null) {
/* 65 */       for (PermissionEnum em : permissions) {
/* 66 */         if (user.havePermission(em)) {
/* 67 */           return true;
/*    */         }
/*    */       }
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.security.AdminAuthorityHandlerInterceptor
 * JD-Core Version:    0.6.0
 */