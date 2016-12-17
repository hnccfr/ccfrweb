/*    */ package com.hundsun.network.gates.genshan.web.resolver;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import org.springframework.core.MethodParameter;
/*    */ import org.springframework.web.bind.support.WebArgumentResolver;
/*    */ import org.springframework.web.context.request.NativeWebRequest;
/*    */ 
/*    */ public class UserAgentArgumentResolver
/*    */   implements WebArgumentResolver
/*    */ {
/*    */   public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest)
/*    */     throws Exception
/*    */   {
/* 16 */     if (methodParameter.getParameterType().equals(UserAgent.class)) {
/* 17 */       Cookyjar cookyjar = (Cookyjar)webRequest.getAttribute("cookyjar", 0);
/*    */ 
/* 20 */       if (cookyjar != null) {
/* 21 */         return cookyjar.getObject(UserAgent.class);
/*    */       }
/*    */     }
/* 24 */     return UNRESOLVED;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.resolver.UserAgentArgumentResolver
 * JD-Core Version:    0.6.0
 */