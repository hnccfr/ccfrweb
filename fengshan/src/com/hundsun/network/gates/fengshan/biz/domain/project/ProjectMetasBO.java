/*    */ package com.hundsun.network.gates.fengshan.biz.domain.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ProjectMetasBO extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = 4270232215615198272L;
/* 14 */   public List<ProjectMetas> metaValues = new ArrayList();
/*    */ 
/*    */   public List<ProjectMetas> getMetaValues() {
/* 17 */     return this.metaValues;
/*    */   }
/*    */ 
/*    */   public void setMetaValues(List<ProjectMetas> metaValues) {
/* 21 */     this.metaValues = metaValues;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetasBO
 * JD-Core Version:    0.6.0
 */