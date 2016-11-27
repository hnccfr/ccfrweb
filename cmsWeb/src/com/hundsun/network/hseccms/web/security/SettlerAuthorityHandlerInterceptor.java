/*    */ package com.hundsun.network.hseccms.web.security;
/*    */ 
/*    */ import com.hundsun.network.hseccms.security.PermissionEnum;
/*    */ import com.hundsun.network.hseccms.security.SettlerAgent;
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
/* 25 */   private static final Integer placeholder = Integer.valueOf(0);
/*    */ 
/* 43 */   private Map<Method, PermissionEnum[]> caches = new ConcurrentHashMap();
/*    */ 
/* 45 */   private Map<Method, Integer> noControlCaches = new ConcurrentHashMap();
/*    */ 
/*    */   public void preInvoke(Method handlerMethod, Object handler, ServletWebRequest webRequest)
/*    */   {
/* 30 */     Cookyjar cookyjar = (Cookyjar)webRequest.getAttribute("cookyjar", 0);
/*    */ 
/* 32 */     if (cookyjar == null) {
/* 33 */       throw new IllegalStateException("cookyjar not find in request");
/*    */     }
/* 35 */     SettlerAgent agent = (SettlerAgent)cookyjar.getObject(SettlerAgent.class);
/*    */ 
/* 37 */     if (!pass(agent, handlerMethod, handler))
/* 38 */       throw new SettlerAccessDeniedException();
/*    */   }
/*    */ 
/*    */   private boolean pass(SettlerAgent user, Method handlerMethod, Object handler)
/*    */   {
/* 48 */     PermissionEnum[] perms = null;
/* 49 */     perms = (PermissionEnum[])this.caches.get(handlerMethod);
/* 50 */     if (perms == null) {
/* 51 */       if (this.noControlCaches.containsKey(handlerMethod))
/*    */       {
/* 53 */         return true;
/*    */       }
/* 55 */       SettlerAccess access = (SettlerAccess)AnnotationUtils.getAnnotation(handlerMethod, SettlerAccess.class);
/*    */ 
/* 57 */       if (access == null)
/*    */       {
/* 59 */         this.noControlCaches.put(handlerMethod, placeholder);
/* 60 */         return true;
/*    */       }
/* 62 */       perms = access.value();
/* 63 */       this.caches.put(handlerMethod, perms);
/*    */     }
/* 65 */     if (perms.length == 0)
/*    */     {
/* 67 */       return user != null;
/*    */     }
/*    */ 
/* 70 */     if (user != null) {
/* 71 */       for (PermissionEnum em : perms) {
/* 72 */         if (user.haveFunction(em)) {
/* 73 */           return true;
/*    */         }
/*    */       }
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.security.SettlerAuthorityHandlerInterceptor
 * JD-Core Version:    0.6.0
 */