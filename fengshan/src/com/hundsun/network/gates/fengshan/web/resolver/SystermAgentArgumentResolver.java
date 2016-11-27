/*    */ package com.hundsun.network.gates.fengshan.web.resolver;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import org.springframework.core.MethodParameter;
/*    */ import org.springframework.web.bind.support.WebArgumentResolver;
/*    */ import org.springframework.web.context.request.NativeWebRequest;
/*    */ 
/*    */ public class SystermAgentArgumentResolver
/*    */   implements WebArgumentResolver
/*    */ {
/*    */   public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest)
/*    */     throws Exception
/*    */   {
/* 16 */     if (methodParameter.getParameterType().equals(UserAgent.class)) {
/* 17 */       Cookyjar cookyjar = (Cookyjar)webRequest.getAttribute("cookyjar", 0);
/*    */ 
/* 19 */       if (cookyjar != null) {
/* 20 */         return cookyjar.getObject(UserAgent.class);
/*    */       }
/*    */     }
/* 23 */     return UNRESOLVED;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.resolver.SystermAgentArgumentResolver
 * JD-Core Version:    0.6.0
 */