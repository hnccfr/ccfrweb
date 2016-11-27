/*    */ package com.hundsun.network.gates.genshan.biz.domain.trade;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class TradeSubstation
/*    */ {
/*    */   private Long id;
/*    */   private String name;
/*    */   private Long parentId;
/*    */   private Date gmtCreate;
/*    */   private Date gmtModify;
/*    */   private String operator;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 41 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 45 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 49 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 53 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public Long getParentId() {
/* 57 */     return this.parentId;
/*    */   }
/*    */ 
/*    */   public void setParentId(Long parentId) {
/* 61 */     this.parentId = parentId;
/*    */   }
/*    */ 
/*    */   public Date getGmtCreate() {
/* 65 */     return this.gmtCreate;
/*    */   }
/*    */ 
/*    */   public void setGmtCreate(Date gmtCreate) {
/* 69 */     this.gmtCreate = gmtCreate;
/*    */   }
/*    */ 
/*    */   public Date getGmtModify() {
/* 73 */     return this.gmtModify;
/*    */   }
/*    */ 
/*    */   public void setGmtModify(Date gmtModify) {
/* 77 */     this.gmtModify = gmtModify;
/*    */   }
/*    */ 
/*    */   public String getOperator() {
/* 81 */     return this.operator;
/*    */   }
/*    */ 
/*    */   public void setOperator(String operator) {
/* 85 */     this.operator = operator;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.trade.TradeSubstation
 * JD-Core Version:    0.6.0
 */