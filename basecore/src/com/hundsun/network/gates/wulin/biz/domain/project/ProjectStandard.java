/*    */ package com.hundsun.network.gates.wulin.biz.domain.project;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*    */ 
/*    */ public class ProjectStandard extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = 477456526737995954L;
/*    */   private Long id;
/*    */   private String proTypeCode;
/*    */   private String proTypeName;
/*    */   private String name;
/*    */   private String content;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 39 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id)
/*    */   {
/* 46 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getProTypeCode()
/*    */   {
/* 53 */     return this.proTypeCode;
/*    */   }
/*    */ 
/*    */   public void setProTypeCode(String proTypeCode)
/*    */   {
/* 60 */     this.proTypeCode = proTypeCode;
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 67 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 74 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getContent() {
/* 78 */     return this.content;
/*    */   }
/*    */ 
/*    */   public void setContent(String content) {
/* 82 */     this.content = content;
/*    */   }
/*    */ 
/*    */   public String getProTypeName() {
/* 86 */     return this.proTypeName;
/*    */   }
/*    */ 
/*    */   public void setProTypeName(String proTypeName) {
/* 90 */     this.proTypeName = proTypeName;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.project.ProjectStandard
 * JD-Core Version:    0.6.0
 */