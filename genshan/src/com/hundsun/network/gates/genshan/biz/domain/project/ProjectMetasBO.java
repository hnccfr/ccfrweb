/*    */ package com.hundsun.network.gates.genshan.biz.domain.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ProjectMetasBO extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = 4270232215615198272L;
/* 14 */   public List<ProjectMetas> metas = new ArrayList();
/*    */ 
/*    */   public List<ProjectMetas> getMetas() {
/* 17 */     return this.metas;
/*    */   }
/*    */ 
/*    */   public void setMetas(List<ProjectMetas> metas) {
/* 21 */     this.metas = metas;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetasBO
 * JD-Core Version:    0.6.0
 */