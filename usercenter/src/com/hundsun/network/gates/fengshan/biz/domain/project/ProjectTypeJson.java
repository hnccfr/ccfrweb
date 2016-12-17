/*    */ package com.hundsun.network.gates.fengshan.biz.domain.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeDTO;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class ProjectTypeJson
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -2351707183043220639L;
/*    */   private String code;
/*    */   private String parentcodeShort;
/*    */   private String parentcode;
/*    */   private String name;
/*    */ 
/*    */   public ProjectTypeJson()
/*    */   {
/*    */   }
/*    */ 
/*    */   public ProjectTypeJson(ProjectType type, String parentcode)
/*    */   {
/* 22 */     if (type != null) {
/* 23 */       setCode(type.getCode());
/* 24 */       setName(type.getName());
/* 25 */       setParentcode(null == type.getParCode() ? "" : type.getParCode());
/* 26 */       setParentcodeShort(null == parentcode ? "" : parentcode);
/*    */     }
/*    */   }
/*    */ 
/*    */   public ProjectTypeJson(ProjectTypeDTO type, String parentcode) {
/* 31 */     if (type != null) {
/* 32 */       setCode(type.getCode());
/* 33 */       setName(type.getName());
/* 34 */       setParentcode(null == type.getParCode() ? "" : type.getParCode());
/* 35 */       setParentcodeShort(null == parentcode ? "" : parentcode);
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 60 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(String code) {
/* 64 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getParentcodeShort() {
/* 68 */     return this.parentcodeShort;
/*    */   }
/*    */ 
/*    */   public void setParentcodeShort(String parentcodeShort) {
/* 72 */     this.parentcodeShort = parentcodeShort;
/*    */   }
/*    */ 
/*    */   public String getParentcode() {
/* 76 */     return this.parentcode;
/*    */   }
/*    */ 
/*    */   public void setParentcode(String parentcode) {
/* 80 */     this.parentcode = parentcode;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 84 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 88 */     this.name = name;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeJson
 * JD-Core Version:    0.6.0
 */