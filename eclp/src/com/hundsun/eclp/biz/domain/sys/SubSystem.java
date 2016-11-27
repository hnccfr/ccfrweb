/*     */ package com.hundsun.eclp.biz.domain.sys;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ public class SubSystem
/*     */ {
/*     */   private Long id;
/*     */   private String name;
/*     */   private String fullName;
/*     */   private Short isCore;
/*     */   private Short type;
/*     */   private Short openType;
/*     */   private Short sort;
/*     */   private String domain;
/*     */   private String url;
/*     */   private Short status;
/*     */   private String logo;
/*     */   private String isDeleted;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String hessianUrl;
/*     */   private Long superCode;
/*     */   private MultipartFile file;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  97 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 101 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 105 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 109 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getFullName() {
/* 113 */     return this.fullName;
/*     */   }
/*     */ 
/*     */   public void setFullName(String fullName) {
/* 117 */     this.fullName = fullName;
/*     */   }
/*     */ 
/*     */   public Short getIsCore() {
/* 121 */     return this.isCore;
/*     */   }
/*     */ 
/*     */   public void setIsCore(Short isCore) {
/* 125 */     this.isCore = isCore;
/*     */   }
/*     */ 
/*     */   public Short getType() {
/* 129 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(Short type) {
/* 133 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public Short getOpenType() {
/* 137 */     return this.openType;
/*     */   }
/*     */ 
/*     */   public void setOpenType(Short openType) {
/* 141 */     this.openType = openType;
/*     */   }
/*     */ 
/*     */   public Short getSort() {
/* 145 */     return this.sort;
/*     */   }
/*     */ 
/*     */   public void setSort(Short sort) {
/* 149 */     this.sort = sort;
/*     */   }
/*     */ 
/*     */   public String getDomain()
/*     */   {
/* 156 */     return this.domain;
/*     */   }
/*     */ 
/*     */   public void setDomain(String domain) {
/* 160 */     this.domain = domain;
/*     */   }
/*     */ 
/*     */   public String getUrl() {
/* 164 */     return this.url;
/*     */   }
/*     */ 
/*     */   public void setUrl(String url) {
/* 168 */     this.url = url;
/*     */   }
/*     */ 
/*     */   public Short getStatus() {
/* 172 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Short status) {
/* 176 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getLogo() {
/* 180 */     return this.logo;
/*     */   }
/*     */ 
/*     */   public void setLogo(String logo) {
/* 184 */     this.logo = logo;
/*     */   }
/*     */ 
/*     */   public String getIsDeleted() {
/* 188 */     return this.isDeleted;
/*     */   }
/*     */ 
/*     */   public void setIsDeleted(String isDeleted) {
/* 192 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 196 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 200 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 204 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 208 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getHessianUrl() {
/* 212 */     return this.hessianUrl;
/*     */   }
/*     */ 
/*     */   public void setHessianUrl(String hessianUrl) {
/* 216 */     this.hessianUrl = hessianUrl;
/*     */   }
/*     */ 
/*     */   public Long getSuperCode() {
/* 220 */     return this.superCode;
/*     */   }
/*     */ 
/*     */   public void setSuperCode(Long superCode) {
/* 224 */     this.superCode = superCode;
/*     */   }
/*     */ 
/*     */   public MultipartFile getFile() {
/* 228 */     return this.file;
/*     */   }
/*     */ 
/*     */   public void setFile(MultipartFile file) {
/* 232 */     this.file = file;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.sys.SubSystem
 * JD-Core Version:    0.6.0
 */