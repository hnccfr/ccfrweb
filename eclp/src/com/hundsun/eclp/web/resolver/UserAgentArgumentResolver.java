/*    */ package com.hundsun.eclp.web.resolver;
/*    */ 
/*    */ import com.hundsun.eclp.biz.domain.user.UserAgent;
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
/* 20 */     if (methodParameter.getParameterType().equals(UserAgent.class)) {
/* 21 */       Cookyjar cookyjar = (Cookyjar)webRequest.getAttribute("cookyjar", 0);
/*    */ 
/* 24 */       if (cookyjar != null) {
/* 25 */         return cookyjar.getObject(UserAgent.class);
/*    */       }
/*    */     }
/* 28 */     return UNRESOLVED;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.resolver.UserAgentArgumentResolver
 * JD-Core Version:    0.6.0
 */