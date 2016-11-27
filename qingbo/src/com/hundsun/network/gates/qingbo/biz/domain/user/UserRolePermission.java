/*    */ package com.hundsun.network.gates.qingbo.biz.domain.user;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class UserRolePermission
/*    */ {
/*    */   private Long id;
/*    */   private Long roleId;
/*    */   private Long permissionId;
/*    */   private Date gmtCreate;
/*    */   private Date gmtModify;
/*    */   private String operator;
/*    */ 
/*    */   public UserRolePermission()
/*    */   {
/*    */   }
/*    */ 
/*    */   public UserRolePermission(Long roleId, Long permissionId, String operator)
/*    */   {
/* 42 */     this.roleId = roleId;
/* 43 */     this.permissionId = permissionId;
/* 44 */     this.operator = operator;
/*    */   }
/*    */ 
/*    */   public Long getId() {
/* 48 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 52 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Long getRoleId() {
/* 56 */     return this.roleId;
/*    */   }
/*    */ 
/*    */   public void setRoleId(Long roleId) {
/* 60 */     this.roleId = roleId;
/*    */   }
/*    */ 
/*    */   public Long getPermissionId() {
/* 64 */     return this.permissionId;
/*    */   }
/*    */ 
/*    */   public void setPermissionId(Long permissionId) {
/* 68 */     this.permissionId = permissionId;
/*    */   }
/*    */ 
/*    */   public Date getGmtCreate() {
/* 72 */     return this.gmtCreate;
/*    */   }
/*    */ 
/*    */   public void setGmtCreate(Date gmtCreate) {
/* 76 */     this.gmtCreate = gmtCreate;
/*    */   }
/*    */ 
/*    */   public Date getGmtModify() {
/* 80 */     return this.gmtModify;
/*    */   }
/*    */ 
/*    */   public void setGmtModify(Date gmtModify) {
/* 84 */     this.gmtModify = gmtModify;
/*    */   }
/*    */ 
/*    */   public String getOperator() {
/* 88 */     return this.operator;
/*    */   }
/*    */ 
/*    */   public void setOperator(String operator) {
/* 92 */     this.operator = operator;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.user.UserRolePermission
 * JD-Core Version:    0.6.0
 */