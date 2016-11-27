/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemCreditLevel;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemCreditLevelQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemCreditLevelService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class SystemCreditLevelAddValidator extends ValangValidator
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
/* 23 */     query.setCreditLevel(creditLevel.getCreditLevel());
/* 24 */     SystemCreditLevel sl = this.systemCreditLevelService.selectByCond(query);
/* 25 */     if (sl != null) {
/* 26 */       errors.rejectValue("creditLevel", "", "信用等级重复 ！");
/*    */     }
/*    */ 
/* 29 */     if ((creditLevel.getIntegralStart() != null) && (creditLevel.getIntegralEnd() != null) && 
/* 30 */       (creditLevel.getIntegralEnd().intValue() <= creditLevel.getIntegralStart().intValue())) {
/* 31 */       errors.rejectValue("integralEnd", "", "结束值必须大于开始值 ！");
/*    */     }
/*    */ 
/* 36 */     if ((creditLevel.getIntegralStart() != null) && (creditLevel.getIntegralEnd() != null)) {
/* 37 */       query = new SystemCreditLevelQuery();
/* 38 */       query.setIntegralStart(Integer.valueOf(creditLevel.getIntegralStart().intValue()));
/* 39 */       query.setIntegralEnd(Integer.valueOf(creditLevel.getIntegralEnd().intValue()));
/* 40 */       int cc = this.systemCreditLevelService.checkIntegralRange(query);
/* 41 */       if (cc > 0)
/* 42 */         errors.rejectValue("integralStart", "", "积分范围已经被占用 ！");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.SystemCreditLevelAddValidator
 * JD-Core Version:    0.6.0
 */