/*    */ package com.hundsun.eclp.web.validator;
/*    */ 
/*    */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*    */ import com.hundsun.eclp.enums.EnumAuthStatus;
/*    */ import com.hundsun.eclp.enums.EnumAuthorityOpenType;
/*    */ import com.hundsun.eclp.enums.EnumAuthorityType;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class AuthValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 16 */     super.validate(obj, err);
/*    */ 
/* 18 */     Authority entity = (Authority)obj;
/* 19 */     if (null == entity.getType())
/* 20 */       err.rejectValue("type", null, null, "请选择类型");
/* 21 */     else if ((entity.getType().shortValue() != EnumAuthorityType.MENU_BAR.getCode()) && (entity.getType().shortValue() != EnumAuthorityType.MENU.getCode()) && (entity.getType().shortValue() != EnumAuthorityType.OPERATION.getCode()))
/*    */     {
/* 24 */       err.rejectValue("type", null, null, "请选择类型");
/*    */     }
/* 26 */     if ((null != entity.getType()) && (EnumAuthorityType.MENU.getCode() == entity.getType().shortValue())) {
/* 27 */       if (null == entity.getOpenType())
/* 28 */         err.rejectValue("openType", null, null, "请选择打开方式");
/* 29 */       else if ((entity.getOpenType().shortValue() != EnumAuthorityOpenType.INNER.getCode()) && (entity.getOpenType().shortValue() != EnumAuthorityOpenType.OUTER.getCode()))
/*    */       {
/* 31 */         err.rejectValue("openType", null, null, "请选择打开方式");
/*    */       }
/*    */     }
/* 34 */     if ((null != entity.getType()) && ((null == entity.getUrl()) || (entity.getUrl().equals(""))))
/*    */     {
/* 36 */       if (EnumAuthorityType.MENU.getCode() == entity.getType().shortValue())
/* 37 */         err.rejectValue("url", null, null, "URL不能为空");
/*    */     }
/* 39 */     if (null == entity.getStatus())
/* 40 */       err.rejectValue("status", null, null, "请选择状态");
/* 41 */     else if ((entity.getStatus().shortValue() != EnumAuthStatus.USE.getCode()) && (entity.getStatus().shortValue() != EnumAuthStatus.DISUSE.getCode()))
/*    */     {
/* 43 */       err.rejectValue("status", null, null, "请选择状态");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.validator.AuthValidator
 * JD-Core Version:    0.6.0
 */