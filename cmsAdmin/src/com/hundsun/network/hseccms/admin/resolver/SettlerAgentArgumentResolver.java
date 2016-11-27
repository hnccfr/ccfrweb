/*    */ package com.hundsun.network.hseccms.admin.resolver;
/*    */ 
/*    */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import org.springframework.core.MethodParameter;
/*    */ import org.springframework.web.bind.support.WebArgumentResolver;
/*    */ import org.springframework.web.context.request.NativeWebRequest;
/*    */ 
/*    */ public class SettlerAgentArgumentResolver
/*    */   implements WebArgumentResolver
/*    */ {
/*    */   public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest)
/*    */     throws Exception
/*    */   {
/* 20 */     if (methodParameter.getParameterType().equals(SettlerAgent.class)) {
/* 21 */       Cookyjar cookyjar = (Cookyjar)webRequest.getAttribute("cookyjar", 0);
/*    */ 
/* 24 */       if (cookyjar != null) {
/* 25 */         return cookyjar.getObject(SettlerAgent.class);
/*    */       }
/*    */     }
/* 28 */     return UNRESOLVED;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.resolver.SettlerAgentArgumentResolver
 * JD-Core Version:    0.6.0
 */