/*    */ package com.hundsun.network.hseccms.admin.validator;
/*    */ 
/*    */ import com.hundsun.network.hseccms.model.Cms2ContAll;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class ContValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 13 */     super.validate(obj, err);
/*    */ 
/* 15 */     Cms2ContAll entity = (Cms2ContAll)obj;
/* 16 */     if (null == entity.getTitle())
/* 17 */       err.rejectValue("title", null, null, "标题不能为空");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.validator.ContValidator
 * JD-Core Version:    0.6.0
 */