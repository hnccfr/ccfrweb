/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectStandard;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectStandardService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class ProjectStandardValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectStandardService standardService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 19 */     super.validate(obj, errors);
/*    */ 
/* 21 */     ProjectStandard currObj = (ProjectStandard)obj;
/*    */ 
/* 24 */     if (StringUtil.isNotEmpty(currObj.getName())) {
/* 25 */       ProjectStandard queryObj = new ProjectStandard();
/* 26 */       queryObj.setProTypeCode(currObj.getProTypeCode());
/* 27 */       queryObj.setName(currObj.getName());
/* 28 */       if (null != currObj.getId()) {
/* 29 */         queryObj.setId(currObj.getId());
/*    */       }
/* 31 */       List list = this.standardService.selectStandardListBySelective(queryObj);
/* 32 */       if ((list != null) && (list.size() > 0)) {
/* 33 */         errors.rejectValue("name", "", "标准规格名称重复！");
/*    */       }
/*    */     }
/*    */ 
/* 37 */     if (StringUtil.isEmpty(currObj.getContent()))
/* 38 */       errors.rejectValue("content", "", "此项为必填项！");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.ProjectStandardValidator
 * JD-Core Version:    0.6.0
 */