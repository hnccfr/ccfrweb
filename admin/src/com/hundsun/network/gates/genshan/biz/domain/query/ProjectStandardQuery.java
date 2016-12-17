/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectStandard;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ProjectStandardQuery extends Pagination<ProjectStandard>
/*    */ {
/*    */   private static final long serialVersionUID = -4400018690841409936L;
/*    */   private String projectTypeCode;
/*    */   private String sleProTypeName;
/*    */   private List<String> codeList;
/*    */   private String standardName;
/*    */ 
/*    */   public String getProjectTypeCode()
/*    */   {
/* 23 */     return this.projectTypeCode;
/*    */   }
/*    */   public void setProjectTypeCode(String projectTypeCode) {
/* 26 */     this.projectTypeCode = projectTypeCode;
/* 27 */     if (projectTypeCode != null)
/* 28 */       setCodeList();
/*    */   }
/*    */ 
/*    */   public String getStandardName() {
/* 32 */     return this.standardName;
/*    */   }
/*    */   public void setStandardName(String standardName) {
/* 35 */     this.standardName = standardName;
/*    */   }
/*    */ 
/*    */   public void setCodeList() {
/* 39 */     if (null == this.projectTypeCode) {
/* 40 */       return;
/*    */     }
/* 42 */     this.codeList = new ArrayList();
/* 43 */     String proTypeCode = this.projectTypeCode;
/*    */ 
/* 45 */     this.codeList.add(proTypeCode);
/*    */ 
/* 47 */     String tCode = "";
/* 48 */     int i = 0;
/* 49 */     while ((proTypeCode.length() > 0) && (proTypeCode.indexOf("|") > 0)) {
/* 50 */       String tmpCode = proTypeCode.substring(0, proTypeCode.indexOf("|"));
/* 51 */       if (i > 0)
/* 52 */         tCode = tCode + "|" + tmpCode;
/*    */       else {
/* 54 */         tCode = tmpCode;
/*    */       }
/* 56 */       this.codeList.add(tCode);
/* 57 */       proTypeCode = proTypeCode.substring(proTypeCode.indexOf("|") + 1, proTypeCode.length());
/* 58 */       i++;
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getSleProTypeName() {
/* 62 */     return this.sleProTypeName;
/*    */   }
/*    */   public void setSleProTypeName(String sleProTypeName) {
/* 65 */     this.sleProTypeName = sleProTypeName;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.ProjectStandardQuery
 * JD-Core Version:    0.6.0
 */