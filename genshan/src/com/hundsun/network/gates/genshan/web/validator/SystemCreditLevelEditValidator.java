/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemCreditLevel;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemCreditLevelQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemCreditLevelService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class SystemCreditLevelEditValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemCreditLevelService systemCreditLevelService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 18 */     super.validate(obj, errors);
/* 19 */     SystemCreditLevel creditLevel = (SystemCreditLevel)obj;
/*    */ 
/* 22 */     SystemCreditLevelQuery query = new SystemCreditLevelQuery();
/* 23 */     query.setNoneId(creditLevel.getId());
/* 24 */     query.setCreditLevel(creditLevel.getCreditLevel());
/* 25 */     SystemCreditLevel sl = this.systemCreditLevelService.selectByCond(query);
/* 26 */     if (sl != null) {
/* 27 */       errors.rejectValue("creditLevel", "", "信用等级重复 ！");
/*    */     }
/*    */ 
/* 30 */     if ((creditLevel.getIntegralStart() != null) && (creditLevel.getIntegralEnd() != null) && 
/* 31 */       (creditLevel.getIntegralEnd().intValue() <= creditLevel.getIntegralStart().intValue())) {
/* 32 */       errors.rejectValue("integralEnd", "", "结束值必须大于开始值 ！");
/*    */     }
/*    */ 
/* 37 */     if ((creditLevel.getIntegralStart() != null) && (creditLevel.getIntegralEnd() != null)) {
/* 38 */       query = new SystemCreditLevelQuery();
/* 39 */       query.setNoneId(creditLevel.getId());
/* 40 */       query.setIntegralStart(Integer.valueOf(creditLevel.getIntegralStart().intValue()));
/* 41 */       query.setIntegralEnd(Integer.valueOf(creditLevel.getIntegralEnd().intValue()));
/* 42 */       int cc = this.systemCreditLevelService.checkIntegralRange(query);
/* 43 */       if (cc > 0)
/* 44 */         errors.rejectValue("integralStart", "", "积分范围已经被占用 ！");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.SystemCreditLevelEditValidator
 * JD-Core Version:    0.6.0
 */