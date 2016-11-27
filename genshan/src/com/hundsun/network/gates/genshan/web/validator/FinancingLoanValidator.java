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
/*    */ public class FinancingLoanValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 17 */     Assert.notNull(obj);
/* 18 */     Assert.isInstanceOf(Financing.class, obj);
/* 19 */     super.validate(obj, err);
/*    */ 
/* 21 */     Financing financing = (Financing)obj;
/*    */ 
/* 24 */     String loanRateDes = financing.getLoanRateDes();
/* 25 */     if (StringUtil.isNotBlank(loanRateDes)) {
/* 26 */       Pattern p = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
/* 27 */       Matcher match = p.matcher(loanRateDes);
/* 28 */       if (!match.matches()) {
/* 29 */         err.rejectValue("loanRateDes", null, null, "格式有误，精确到0.01%");
/*    */       } else {
/* 31 */         Double loanRateDouble = Double.valueOf(loanRateDes);
/* 32 */         if (loanRateDouble.doubleValue() < 0.0D) {
/* 33 */           err.rejectValue("loanRateDes", null, null, "不能小于0");
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 38 */     String applyLimitDes = financing.getApplyLimitDes();
/* 39 */     if (StringUtil.isBlank(applyLimitDes)) {
/* 40 */       err.rejectValue("applyLimitDes", null, null, "不能为空");
/* 41 */     } else if (StringUtil.isNotBlank(applyLimitDes)) {
/* 42 */       Pattern p = Pattern.compile("\\d*");
/* 43 */       Matcher match = p.matcher(applyLimitDes);
/* 44 */       if (!match.matches()) {
/* 45 */         err.rejectValue("applyLimitDes", null, null, "请输入整数");
/*    */       }
/*    */     }
/*    */ 
/* 49 */     String loanAmountDes = financing.getLoanAmountDes();
/* 50 */     if (StringUtil.isBlank(loanAmountDes)) {
/* 51 */       err.rejectValue("loanAmountDes", null, null, "不能为空");
/*    */     } else {
/* 53 */       Pattern p = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
/* 54 */       Matcher match = p.matcher(loanAmountDes);
/* 55 */       if (!match.matches())
/* 56 */         err.rejectValue("loanAmountDes", null, null, "格式有误，精确到分");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.FinancingLoanValidator
 * JD-Core Version:    0.6.0
 */