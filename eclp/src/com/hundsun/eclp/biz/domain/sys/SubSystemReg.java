/*    */ package com.hundsun.eclp.biz.domain.sys;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class SubSystemReg
/*    */ {
/*    */   private String sysCode;
/*    */   private String serverIp;
/*    */   private String serverPort;
/*    */   private boolean status;
/*    */   private Date permissionUpdateTime;
/*    */ 
/*    */   public String getSysCode()
/*    */   {
/* 32 */     return this.sysCode;
/*    */   }
/*    */ 
/*    */   public void setSysCode(String sysCode) {
/* 36 */     this.sysCode = sysCode;
/*    */   }
/*    */ 
/*    */   public String getServerIp() {
/* 40 */     return this.serverIp;
/*    */   }
/*    */ 
/*    */   public void setServerIp(String serverIp) {
/* 44 */     this.serverIp = serverIp;
/*    */   }
/*    */ 
/*    */   public boolean isStatus() {
/* 48 */     return this.status;
/*    */   }
/*    */ 
/*    */   public void setStatus(boolean status) {
/* 52 */     this.status = status;
/*    */   }
/*    */ 
/*    */   public Date getPermissionUpdateTime() {
/* 56 */     return this.permissionUpdateTime;
/*    */   }
/*    */ 
/*    */   public void setPermissionUpdateTime(Date permissionUpdateTime) {
/* 60 */     this.permissionUpdateTime = permissionUpdateTime;
/*    */   }
/*    */ 
/*    */   public String getServerPort() {
/* 64 */     return this.serverPort;
/*    */   }
/*    */ 
/*    */   public void setServerPort(String serverPort) {
/* 68 */     this.serverPort = serverPort;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.sys.SubSystemReg
 * JD-Core Version:    0.6.0
 */