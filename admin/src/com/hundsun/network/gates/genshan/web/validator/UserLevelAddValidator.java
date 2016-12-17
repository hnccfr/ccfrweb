/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.UserLevelService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class UserLevelAddValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserAccountService userAccountService;
/*    */ 
/*    */   @Autowired
/*    */   private UserLevelService UserLevelService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 22 */     super.validate(obj, errors);
/* 23 */     UserLevel userLevel = (UserLevel)obj;
/* 24 */     if (userLevel.getUserAccount() != null)
/*    */     {
/* 26 */       UserAccount userAccount = this.userAccountService.getUserByAccount(userLevel.getUserAccount());
/* 27 */       if (userAccount == null) {
/* 28 */         errors.rejectValue("userAccount", "", "不存在的会员！");
/*    */       }
/*    */ 
/* 31 */       UserLevel ul = this.UserLevelService.selectByUserAccount(userLevel.getUserAccount());
/* 32 */       if (ul != null)
/* 33 */         errors.rejectValue("userAccount", "", "该会员已经有设置会员级别！");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.UserLevelAddValidator
 * JD-Core Version:    0.6.0
 */