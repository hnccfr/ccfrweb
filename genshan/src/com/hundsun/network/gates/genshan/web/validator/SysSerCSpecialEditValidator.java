/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemServicechargeSpecial;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectType;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemServicechargeSpecialQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemServiceCSpecialService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectTypeService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class SysSerCSpecialEditValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserAccountService userAccountService;
/*    */ 
/*    */   @Autowired
/*    */   private ProjectTypeService projectTypeService;
/*    */ 
/*    */   @Autowired
/*    */   private SystemServiceCSpecialService systemServiceCSpecialService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 34 */     super.validate(obj, errors);
/* 35 */     SystemServicechargeSpecial sscSpecial = (SystemServicechargeSpecial)obj;
/* 36 */     String userAccount = sscSpecial.getUserAccount();
/* 37 */     String proTypeCode = sscSpecial.getProTypeCode();
/* 38 */     String isSystem = sscSpecial.getIsSystem();
/* 39 */     if ("Y".equals(isSystem)) {
/* 40 */       if ((StringUtil.isNotBlank(userAccount)) || (StringUtil.isNotBlank(proTypeCode)))
/* 41 */         errors.rejectValue("userAccount", "", "该项目是系统配置，'会员'和'项目类型编码'都不用填写！");
/*    */     }
/*    */     else {
/* 44 */       if ((StringUtil.isBlank(userAccount)) && (StringUtil.isBlank(proTypeCode))) {
/* 45 */         errors.rejectValue("userAccount", "", "'会员'和'项目类型编码'至少填写一项！");
/*    */       }
/* 47 */       if (StringUtil.isNotBlank(sscSpecial.getUserAccount()))
/*    */       {
/* 49 */         UserAccount ua = this.userAccountService.getUserByAccount(sscSpecial.getUserAccount());
/* 50 */         if (ua == null) {
/* 51 */           errors.rejectValue("userAccount", "", "会员不存在！");
/*    */         }
/*    */       }
/*    */ 
/* 55 */       if (StringUtil.isNotBlank(sscSpecial.getProTypeCode())) {
/* 56 */         ProjectType proType = this.projectTypeService.getProjectTypeByCode(sscSpecial.getProTypeCode());
/* 57 */         if (proType == null) {
/* 58 */           errors.rejectValue("proTypeCode", "", "项目类型编码不存在！");
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/* 63 */       if ((StringUtil.isNotBlank(userAccount)) && (StringUtil.isNotBlank(proTypeCode))) {
/* 64 */         SystemServicechargeSpecialQuery query = new SystemServicechargeSpecialQuery();
/* 65 */         query.setUserAccount(userAccount);
/* 66 */         query.setProTypeCode(proTypeCode);
/* 67 */         query.setNoneId(sscSpecial.getId());
/* 68 */         List list = this.systemServiceCSpecialService.selectRepeatConfig(query);
/* 69 */         if ((list != null) && (list.size() > 0)) {
/* 70 */           errors.rejectValue("userAccount", "", "'会员'和'项目类型编码'已经提交过相同配置！");
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/* 75 */       if ((StringUtil.isNotBlank(userAccount)) && (StringUtil.isBlank(proTypeCode))) {
/* 76 */         SystemServicechargeSpecialQuery query = new SystemServicechargeSpecialQuery();
/* 77 */         query.setUserAccount(userAccount);
/* 78 */         query.setNoneId(sscSpecial.getId());
/* 79 */         List list = this.systemServiceCSpecialService.selectRepeatConfig(query);
/* 80 */         if ((list != null) && (list.size() > 0)) {
/* 81 */           errors.rejectValue("userAccount", "", "'会员'已经提交过相同配置！");
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/* 86 */       if ((StringUtil.isBlank(userAccount)) && (StringUtil.isNotBlank(proTypeCode))) {
/* 87 */         SystemServicechargeSpecialQuery query = new SystemServicechargeSpecialQuery();
/* 88 */         query.setProTypeCode(proTypeCode);
/* 89 */         query.setNoneId(sscSpecial.getId());
/* 90 */         List list = this.systemServiceCSpecialService.selectRepeatConfig(query);
/* 91 */         if ((list != null) && (list.size() > 0)) {
/* 92 */           errors.rejectValue("proTypeCode", "", "'项目类型编码'已经提交过相同配置！");
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 97 */     if ((sscSpecial.getListTurnover() == null) && (sscSpecial.getListUnturnover() == null) && (sscSpecial.getOrderTurnover() == null) && (sscSpecial.getOrderUnturnover() == null))
/*    */     {
/* 99 */       errors.rejectValue("listTurnover", "", "设置值不允许都是空！");
/* 100 */       errors.rejectValue("listUnturnover", "", "设置值不允许都是空！");
/* 101 */       errors.rejectValue("orderTurnover", "", "设置值不允许都是空！");
/* 102 */       errors.rejectValue("orderUnturnover", "", "设置值不允许都是空！");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.SysSerCSpecialEditValidator
 * JD-Core Version:    0.6.0
 */