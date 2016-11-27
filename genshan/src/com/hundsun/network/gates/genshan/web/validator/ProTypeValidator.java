/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectType;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectTypeService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class ProTypeValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectTypeService projectTypeService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 18 */     super.validate(obj, errors);
/*    */ 
/* 20 */     ProjectType proType = (ProjectType)obj;
/*    */ 
/* 23 */     ProjectType queryObj = new ProjectType();
/* 24 */     queryObj.setParCode(proType.getParCode());
/* 25 */     queryObj.setName(proType.getName());
/* 26 */     if (null != proType.getId()) {
/* 27 */       queryObj.setId(proType.getId());
/*    */     }
/* 29 */     List list = this.projectTypeService.getProTypeListBySelective(queryObj);
/* 30 */     if ((list != null) && (list.size() > 0))
/* 31 */       errors.rejectValue("name", "", "类型名称重复！");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.ProTypeValidator
 * JD-Core Version:    0.6.0
 */