/*     */ package com.hundsun.eclp.biz.domain.sys;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ public class SysConfig
/*     */ {
/*     */   private Long id;
/*     */   private String code;
/*     */   private String value;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String type;
/*     */   private String codeDesc;
/*     */   private Short status;
/*     */   MultipartFile file;
/*     */ 
/*     */   public MultipartFile getFile()
/*     */   {
/*  51 */     return this.file;
/*     */   }
/*     */ 
/*     */   public void setFile(MultipartFile file) {
/*  55 */     this.file = file;
/*     */   }
/*     */ 
/*     */   public Short getStatus()
/*     */   {
/*  61 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Short status) {
/*  65 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  69 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  73 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/*  77 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/*  81 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getValue() {
/*  85 */     return this.value;
/*     */   }
/*     */ 
/*     */   public void setValue(String value) {
/*  89 */     this.value = value;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/*  93 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/*  97 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 101 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 105 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 109 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/* 113 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getCodeDesc() {
/* 117 */     return this.codeDesc;
/*     */   }
/*     */ 
/*     */   public void setCodeDesc(String codeDesc) {
/* 121 */     this.codeDesc = codeDesc;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.sys.SysConfig
 * JD-Core Version:    0.6.0
 */