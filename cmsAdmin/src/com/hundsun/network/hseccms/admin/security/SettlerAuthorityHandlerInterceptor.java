/*    */ package com.hundsun.network.hseccms.admin.security;
/*    */ 
/*    */ import com.hundsun.network.melody.common.web.adapter.AnnotationMethodHandlerInterceptorAdapter;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.springframework.core.annotation.AnnotationUtils;
/*    */ import org.springframework.web.context.request.ServletWebRequest;
/*    */ 
/*    */ public class SettlerAuthorityHandlerInterceptor extends AnnotationMethodHandlerInterceptorAdapter
/*    */ {
/* 23 */   private static final Integer placeholder = Integer.valueOf(0);
/*    */ 
/* 41 */   private Map<Method, PermissionEnum[]> caches = new ConcurrentHashMap();
/*    */ 
/* 43 */   private Map<Method, Integer> noControlCaches = new ConcurrentHashMap();
/*    */ 
/*    */   public void preInvoke(Method handlerMethod, Object handler, ServletWebRequest webRequest)
/*    */   {
/* 28 */     Cookyjar cookyjar = (Cookyjar)webRequest.getAttribute("cookyjar", 0);
/*    */ 
/* 30 */     if (cookyjar == null) {
/* 31 */       throw new IllegalStateException("cookyjar not find in request");
/*    */     }
/* 33 */     SettlerAgent agent = (SettlerAgent)cookyjar.getObject(SettlerAgent.class);
/*    */ 
/* 35 */     if (!pass(agent, handlerMethod, handler))
/* 36 */       throw new SettlerAccessDeniedException();
/*    */   }
/*    */ 
/*    */   private boolean pass(SettlerAgent user, Method handlerMethod, Object handler)
/*    */   {
/* 46 */     PermissionEnum[] perms = null;
/* 47 */     perms = (PermissionEnum[])this.caches.get(handlerMethod);
/* 48 */     if (perms == null) {
/* 49 */       if (this.noControlCaches.containsKey(handlerMethod))
/*    */       {
/* 51 */         return true;
/*    */       }
/* 53 */       SettlerAccess access = (SettlerAccess)AnnotationUtils.getAnnotation(handlerMethod, SettlerAccess.class);
/*    */ 
/* 55 */       if (access == null)
/*    */       {
/* 57 */         this.noControlCaches.put(handlerMethod, placeholder);
/* 58 */         return true;
/*    */       }
/* 60 */       perms = access.value();
/* 61 */       this.caches.put(handlerMethod, perms);
/*    */     }
/* 63 */     if (perms.length == 0)
/*    */     {
/* 65 */       return user != null;
/*    */     }
/*    */ 
/* 68 */     if (user != null) {
/* 69 */       for (PermissionEnum em : perms) {
/* 70 */         if (user.haveFunction(em)) {
/* 71 */           return true;
/*    */         }
/*    */       }
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.security.SettlerAuthorityHandlerInterceptor
 * JD-Core Version:    0.6.0
 */