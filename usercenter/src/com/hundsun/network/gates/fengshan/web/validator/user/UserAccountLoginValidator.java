/*    */ package com.hundsun.network.gates.fengshan.web.validator.user;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserLogin;
/*    */ import org.apache.log4j.Logger;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class UserAccountLoginValidator extends ValangValidator
/*    */ {
/* 16 */   protected final Logger log = Logger.getLogger(getClass());
/*    */ 
/*    */   public void validate(Object target, Errors errors)
/*    */   {
/* 26 */     super.validate(target, errors);
/* 27 */     if (!(target instanceof UserLogin))
/* 28 */       return;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.validator.user.UserAccountLoginValidator
 * JD-Core Version:    0.6.0
 */