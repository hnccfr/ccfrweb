/*    */ package com.hundsun.network.gates.wulin.biz.domain.user;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class UserRoleRelationship
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -5099765553001218255L;
/*    */   private Long id;
/*    */   private Long userId;
/*    */   private Long roleId;
/*    */   private Date gmtCreate;
/*    */   private Date gmtModify;
/*    */   private String operator;
/*    */ 
/*    */   public UserRoleRelationship()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UserRoleRelationship(Long userId, Long roleId, String operator)
/*    */   {
/* 45 */     this.userId = userId;
/* 46 */     this.roleId = roleId;
/* 47 */     this.operator = operator;
/*    */   }
/*    */ 
/*    */   public Long getId() {
/* 51 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 55 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Long getRoleId() {
/* 59 */     return this.roleId;
/*    */   }
/*    */ 
/*    */   public void setRoleId(Long roleId) {
/* 63 */     this.roleId = roleId;
/*    */   }
/*    */ 
/*    */   public Date getGmtCreate() {
/* 67 */     return this.gmtCreate;
/*    */   }
/*    */ 
/*    */   public void setGmtCreate(Date gmtCreate) {
/* 71 */     this.gmtCreate = gmtCreate;
/*    */   }
/*    */ 
/*    */   public Date getGmtModify() {
/* 75 */     return this.gmtModify;
/*    */   }
/*    */ 
/*    */   public void setGmtModify(Date gmtModify) {
/* 79 */     this.gmtModify = gmtModify;
/*    */   }
/*    */ 
/*    */   public String getOperator() {
/* 83 */     return this.operator;
/*    */   }
/*    */ 
/*    */   public void setOperator(String operator) {
/* 87 */     this.operator = operator;
/*    */   }
/*    */ 
/*    */   public Long getUserId() {
/* 91 */     return this.userId;
/*    */   }
/*    */ 
/*    */   public void setUserId(Long userId) {
/* 95 */     this.userId = userId;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.user.UserRoleRelationship
 * JD-Core Version:    0.6.0
 */