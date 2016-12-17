/*    */ package com.hundsun.network.gates.genshan.biz.domain.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*    */ 
/*    */ public class AttriMeta extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = -1725132069145779676L;
/*    */   private ProjectTypeAttri attr;
/*    */   private ProjectMetas meta;
/*    */ 
/*    */   public ProjectTypeAttri getAttr()
/*    */   {
/* 14 */     return this.attr;
/*    */   }
/*    */ 
/*    */   public void setAttr(ProjectTypeAttri attr) {
/* 18 */     this.attr = attr;
/*    */   }
/*    */ 
/*    */   public ProjectMetas getMeta() {
/* 22 */     return this.meta;
/*    */   }
/*    */ 
/*    */   public void setMeta(ProjectMetas meta) {
/* 26 */     this.meta = meta;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.project.AttriMeta
 * JD-Core Version:    0.6.0
 */