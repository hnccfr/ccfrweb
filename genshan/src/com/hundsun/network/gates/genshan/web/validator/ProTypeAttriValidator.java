/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectTypeService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class ProTypeAttriValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectTypeService projectTypeService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/*    */     try
/*    */     {
/* 20 */       super.validate(obj, errors);
/*    */ 
/* 22 */       ProjectTypeAttri proTypeAttri = (ProjectTypeAttri)obj;
/*    */ 
/* 25 */       ProjectTypeAttri queryObj = new ProjectTypeAttri();
/* 26 */       queryObj.setProTypeCode(proTypeAttri.getProTypeCode());
/* 27 */       queryObj.setKeyName(proTypeAttri.getKeyName());
/* 28 */       if (null != proTypeAttri.getId()) {
/* 29 */         queryObj.setId(proTypeAttri.getId());
/*    */       }
/* 31 */       List list = this.projectTypeService.getProjectAttriListBySelective(queryObj);
/* 32 */       if ((list != null) && (list.size() > 0)) {
/* 33 */         errors.rejectValue("keyName", "", "属性key重复！");
/*    */       }
/*    */ 
/* 37 */       queryObj = new ProjectTypeAttri();
/* 38 */       queryObj.setProTypeCode(proTypeAttri.getProTypeCode());
/* 39 */       queryObj.setKeyTitle(proTypeAttri.getKeyTitle());
/* 40 */       if (null != proTypeAttri.getId()) {
/* 41 */         queryObj.setId(proTypeAttri.getId());
/*    */       }
/* 43 */       List list2 = this.projectTypeService.getProjectAttriListBySelective(queryObj);
/* 44 */       if ((list2 != null) && (list2.size() > 0)) {
/* 45 */         errors.rejectValue("keyTitle", "", "属性title重复！");
/*    */       }
/*    */ 
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 63 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.ProTypeAttriValidator
 * JD-Core Version:    0.6.0
 */