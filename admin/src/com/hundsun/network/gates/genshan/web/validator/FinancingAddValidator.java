/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.financing.Financing;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.springframework.util.Assert;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class FinancingAddValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 17 */     Assert.notNull(obj);
/* 18 */     Assert.isInstanceOf(Financing.class, obj);
/* 19 */     super.validate(obj, err);
/*    */ 
/* 21 */     Financing financing = (Financing)obj;
/*    */ 
/* 24 */     String applyAmountDes = financing.getApplyAmountDes();
/* 25 */     if (StringUtil.isBlank(applyAmountDes)) {
/* 26 */       err.rejectValue("applyAmountDes", null, null, "不能为空");
/*    */     } else {
/* 28 */       Pattern p = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
/* 29 */       Matcher match = p.matcher(applyAmountDes);
/* 30 */       if (!match.matches()) {
/* 31 */         err.rejectValue("applyAmountDes", null, null, "格式有误，精确到分");
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 36 */     String loanRateDes = financing.getLoanRateDes();
/* 37 */     if (StringUtil.isNotBlank(loanRateDes)) {
/* 38 */       Pattern p = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
/* 39 */       Matcher match = p.matcher(loanRateDes);
/* 40 */       if (!match.matches()) {
/* 41 */         err.rejectValue("loanRateDes", null, null, "格式有误，精确到0.01%");
/*    */       } else {
/* 43 */         Double loanRateDouble = Double.valueOf(loanRateDes);
/* 44 */         if (loanRateDouble.doubleValue() < 0.0D) {
/* 45 */           err.rejectValue("loanRateDes", null, null, "不能小于0");
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 54 */     String applyLimitDes = financing.getApplyLimitDes();
/* 55 */     if (StringUtil.isNotBlank(applyLimitDes)) {
/* 56 */       Pattern p = Pattern.compile("\\d*");
/* 57 */       Matcher match = p.matcher(applyLimitDes);
/* 58 */       if (!match.matches())
/* 59 */         err.rejectValue("applyLimitDes", null, null, "请输入整数");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.FinancingAddValidator
 * JD-Core Version:    0.6.0
 */