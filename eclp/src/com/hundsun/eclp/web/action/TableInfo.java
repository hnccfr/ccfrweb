/*     */ package com.hundsun.eclp.web.action;
/*     */ 
/*     */ class TableInfo
/*     */ {
/*     */   String tableName;
/*     */   String seq;
/*     */   String whereStr;
/*     */ 
/*     */   public TableInfo(String tableName, String seq, String whereStr)
/*     */   {
/* 395 */     this.tableName = tableName;
/* 396 */     this.seq = seq;
/* 397 */     this.whereStr = whereStr;
/*     */   }
/*     */ 
/*     */   public String getTableName()
/*     */   {
/* 403 */     return this.tableName;
/*     */   }
/*     */ 
/*     */   public void setTableName(String tableName)
/*     */   {
/* 409 */     this.tableName = tableName;
/*     */   }
/*     */ 
/*     */   public String getSeq()
/*     */   {
/* 415 */     return this.seq;
/*     */   }
/*     */ 
/*     */   public void setSeq(String seq)
/*     */   {
/* 421 */     this.seq = seq;
/*     */   }
/*     */ 
/*     */   public String getWhereStr()
/*     */   {
/* 427 */     return this.whereStr;
/*     */   }
/*     */ 
/*     */   public void setWhereStr(String whereStr)
/*     */   {
/* 433 */     this.whereStr = whereStr;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.TableInfo
 * JD-Core Version:    0.6.0
 */