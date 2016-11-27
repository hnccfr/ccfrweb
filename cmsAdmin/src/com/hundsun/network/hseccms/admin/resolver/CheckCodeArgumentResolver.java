/*    */ package com.hundsun.network.hseccms.admin.resolver;
/*    */ 
/*    */ import com.hundsun.network.hseccms.common.CheckCode;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import org.springframework.core.MethodParameter;
/*    */ import org.springframework.web.bind.support.WebArgumentResolver;
/*    */ import org.springframework.web.context.request.NativeWebRequest;
/*    */ 
/*    */ public class CheckCodeArgumentResolver
/*    */   implements WebArgumentResolver
/*    */ {
/*    */   public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest)
/*    */     throws Exception
/*    */   {
/* 24 */     if (methodParameter.getParameterType().equals(CheckCode.class)) {
/* 25 */       Cookyjar cookyjar = (Cookyjar)webRequest.getAttribute("cookyjar", 0);
/*    */ 
/* 27 */       if (cookyjar != null) {
/* 28 */         return cookyjar.getObject(CheckCode.class);
/*    */       }
/*    */     }
/* 31 */     return UNRESOLVED;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.resolver.CheckCodeArgumentResolver
 * JD-Core Version:    0.6.0
 */