/*    */ package com.hundsun.eclp.web.validator;
/*    */ 
/*    */ import com.hundsun.eclp.biz.domain.user.UserInfo;
/*    */ import com.hundsun.eclp.enums.EnumUserInfoIDType;
/*    */ import com.hundsun.eclp.util.StringUtil;
/*    */ import com.hundsun.eclp.util.WordUtil;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class UserInfoValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 18 */     super.validate(obj, err);
/* 19 */     UserInfo uInfo = (UserInfo)obj;
/*    */ 
/* 21 */     if ((EnumUserInfoIDType.IDCARD.getCode() != uInfo.getIdType()) && 
/* 22 */       (StringUtil.isNotBlank(uInfo.getIdCard())) && (uInfo.getIdCard().length() > 20)) {
/* 23 */       err.rejectValue("idCard", null, null, "证件号长度不能大于20，请重新输入");
/*    */     }
/*    */ 
/* 26 */     if ((uInfo.getWorkYear() != null) && 
/* 27 */       (!uInfo.getWorkYear().toString().matches("^\\d{1,3}$"))) {
/* 28 */       err.rejectValue("workYear", null, null, "请正确输入工作年限");
/*    */     }
/*    */ 
/* 31 */     if ((uInfo.getJobNo() != null) && 
/* 32 */       (WordUtil.length(uInfo.getJobNo()) > 20)) {
/* 33 */       err.rejectValue("jobNo", null, null, "工号最长为20字符或6个中文");
/*    */     }
/*    */ 
/* 36 */     if (uInfo.getBirthday() != null) {
/* 37 */       Calendar currDate = Calendar.getInstance();
/* 38 */       if (uInfo.getBirthday().getTime() >= currDate.getTime().getTime()) {
/* 39 */         err.rejectValue("birthday", null, null, "生日不能大于等于系统时间");
/*    */       }
/*    */     }
/* 42 */     if (uInfo.getAvailableDate() != null) {
/* 43 */       Calendar currDate = Calendar.getInstance();
/* 44 */       if (uInfo.getAvailableDate().getTime() > currDate.getTime().getTime()) {
/* 45 */         err.rejectValue("availableDate", null, null, "入职时间不能大于系统时间");
/*    */       }
/* 47 */       if ((uInfo.getBirthday() != null) && 
/* 48 */         (uInfo.getBirthday().getTime() >= uInfo.getAvailableDate().getTime())) {
/* 49 */         err.rejectValue("birthday", null, null, "生日不能大于等于入职时间");
/*    */       }
/*    */ 
/*    */     }
/*    */ 
/* 54 */     if (StringUtil.isNotBlank(uInfo.getMobilePhone())) {
/* 55 */       Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
/* 56 */       if (!p.matcher(uInfo.getMobilePhone()).find()) {
/* 57 */         err.rejectValue("mobilePhone", null, null, "移动电话 格式有误");
/*    */       }
/*    */     }
/*    */ 
/* 61 */     if (StringUtil.isNotBlank(uInfo.getHomePhone()))
/*    */     {
/* 63 */       Pattern pattern = Pattern.compile("^\\d{3,8}+(-\\d{7,8})?$");
/* 64 */       if (!pattern.matcher(uInfo.getHomePhone()).find()) {
/* 65 */         err.rejectValue("homePhone", null, null, "住宅电话 格式有误");
/*    */       }
/*    */     }
/*    */ 
/* 69 */     if (StringUtil.isNotBlank(uInfo.getOfficePhone()))
/*    */     {
/* 71 */       Pattern pattern = Pattern.compile("^\\d{3,8}+(-\\d{7,8})?$");
/* 72 */       if (!pattern.matcher(uInfo.getOfficePhone()).find())
/* 73 */         err.rejectValue("officePhone", null, null, "办公电话 格式有误");
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void main(String[] arges) {
/* 78 */     Pattern pattern = Pattern.compile("^\\d{3,8}+(-\\d{7,8})?$");
/*    */ 
/* 81 */     System.out.println(pattern.matcher("124568314").find());
/*    */ 
/* 83 */     Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
/* 84 */     System.out.println(p.matcher("16667188900").find());
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.validator.UserInfoValidator
 * JD-Core Version:    0.6.0
 */