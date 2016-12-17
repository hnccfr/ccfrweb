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
/*    */ public class FinancingRepayValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 17 */     Assert.notNull(obj);
/* 18 */     Assert.isInstanceOf(Financing.class, obj);
/* 19 */     super.validate(obj, err);
/*    */ 
/* 21 */     Financing financing = (Financing)obj;
/*    */ 
/* 24 */     String repayAmountDes = financing.getRepayAmountDes();
/* 25 */     if (StringUtil.isBlank(repayAmountDes)) {
/* 26 */       err.rejectValue("repayAmountDes", null, null, "不能为空");
/*    */     } else {
/* 28 */       Pattern p = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
/* 29 */       Matcher match = p.matcher(repayAmountDes);
/* 30 */       if (!match.matches())
/* 31 */         err.rejectValue("repayAmountDes", null, null, "格式有误，精确到分");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.FinancingRepayValidator
 * JD-Core Version:    0.6.0
 */