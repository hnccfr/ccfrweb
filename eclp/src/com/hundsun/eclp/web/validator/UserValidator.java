/*    */ package com.hundsun.eclp.web.validator;
/*    */ 
/*    */ import com.hundsun.eclp.biz.domain.user.Users;
/*    */ import com.hundsun.eclp.biz.service.UsersService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class UserValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UsersService usersService;
/*    */ 
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 15 */     super.validate(obj, err);
/* 16 */     if (!err.hasErrors()) {
/* 17 */       Users user = (Users)obj;
/* 18 */       if (user.getId() == null) {
/* 19 */         Users users = this.usersService.getUserByAccount(user.getAccount());
/* 20 */         if (users != null)
/* 21 */           err.rejectValue("account", null, null, "该账户已存在,请重新填写");
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.validator.UserValidator
 * JD-Core Version:    0.6.0
 */