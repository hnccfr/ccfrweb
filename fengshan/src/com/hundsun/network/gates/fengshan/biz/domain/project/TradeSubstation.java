/*    */ package com.hundsun.network.gates.fengshan.biz.domain.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class TradeSubstation extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = -4460583081313970208L;
/*    */   private Long id;
/*    */   private String name;
/*    */   private Long parentId;
/*    */   private Date gmtCreate;
/*    */   private Date gmtModify;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 36 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 40 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 44 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 48 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public Long getParentId() {
/* 52 */     return this.parentId;
/*    */   }
/*    */ 
/*    */   public void setParentId(Long parentId) {
/* 56 */     this.parentId = parentId;
/*    */   }
/*    */ 
/*    */   public Date getGmtCreate() {
/* 60 */     return this.gmtCreate;
/*    */   }
/*    */ 
/*    */   public void setGmtCreate(Date gmtCreate) {
/* 64 */     this.gmtCreate = gmtCreate;
/*    */   }
/*    */ 
/*    */   public Date getGmtModify() {
/* 68 */     return this.gmtModify;
/*    */   }
/*    */ 
/*    */   public void setGmtModify(Date gmtModify) {
/* 72 */     this.gmtModify = gmtModify;
/*    */   }
/*    */ 
/*    */   public static long getSerialversionuid() {
/* 76 */     return -4460583081313970208L;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.project.TradeSubstation
 * JD-Core Version:    0.6.0
 */