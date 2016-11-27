/*    */ package com.hundsun.eclp.web.validator;
/*    */ 
/*    */ import com.hundsun.eclp.biz.domain.user.Users;
/*    */ import com.hundsun.eclp.biz.service.UsersService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import com.hundsun.network.melody.common.util.digest.MessageDigest;
/*    */ import com.hundsun.network.melody.common.util.digest.impl.MD5MessageDigestImpl;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class PasswordValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UsersService usersService;
/*    */ 
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 18 */     super.validate(obj, err);
/*    */ 
/* 20 */     Users user = (Users)obj;
/*    */ 
/* 22 */     Users q_user = this.usersService.selectUserById(user.getId());
/*    */ 
/* 24 */     MessageDigest digest = new MD5MessageDigestImpl();
/* 25 */     if (!StringUtil.equals(digest.digest(user.getPassword()), q_user.getPassword())) {
/* 26 */       err.rejectValue("password", null, null, "原密码错误，请重新输入");
/*    */     }
/* 28 */     if (StringUtil.equals(digest.digest(user.getNewPassword()), q_user.getPassword()))
/* 29 */       err.rejectValue("newPassword", null, null, "新密码必须和原密码不同，请重新输入");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.validator.PasswordValidator
 * JD-Core Version:    0.6.0
 */