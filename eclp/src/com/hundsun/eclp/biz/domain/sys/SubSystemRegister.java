/*     */ package com.hundsun.eclp.biz.domain.sys;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SubSystemRegister
/*     */ {
/*     */   private Long id;
/*     */   private String serverIp;
/*     */   private String serverPort;
/*     */   private String subsystemCode;
/*     */   private Short enable;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String remark;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  47 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  51 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getServerIp() {
/*  55 */     return this.serverIp;
/*     */   }
/*     */ 
/*     */   public void setServerIp(String serverIp) {
/*  59 */     this.serverIp = serverIp;
/*     */   }
/*     */ 
/*     */   public String getServerPort() {
/*  63 */     return this.serverPort;
/*     */   }
/*     */ 
/*     */   public void setServerPort(String serverPort) {
/*  67 */     this.serverPort = serverPort;
/*     */   }
/*     */ 
/*     */   public String getSubsystemCode() {
/*  71 */     return this.subsystemCode;
/*     */   }
/*     */ 
/*     */   public void setSubsystemCode(String subsystemCode) {
/*  75 */     this.subsystemCode = subsystemCode;
/*     */   }
/*     */ 
/*     */   public Short getEnable() {
/*  79 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(Short enable) {
/*  83 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/*  87 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/*  91 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/*  95 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/*  99 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 103 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 107 */     this.remark = remark;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.sys.SubSystemRegister
 * JD-Core Version:    0.6.0
 */