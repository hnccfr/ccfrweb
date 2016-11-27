/*     */ package com.hundsun.eclp.biz.domain.auth;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Authority
/*     */ {
/*   8 */   private static Long rootFlag = Long.valueOf(-1L);
/*     */ 
/*  10 */   private static String split = "/";
/*     */   private Long id;
/*     */   private Long code;
/*     */   private String name;
/*     */   private Short type;
/*     */   private Short isCore;
/*     */   private String urlPrefix;
/*     */   private String url;
/*     */   private String subSystemId;
/*     */   private Authority subSystem;
/*     */   private Short sort;
/*     */   private Short status;
/*     */   private Long parentId;
/*     */   private Authority parent;
/*     */   private String parentAllName;
/*     */   private Short isLeaf;
/*     */   private Short openType;
/*     */   private String isDeleted;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private short isAssign;
/* 111 */   private List<Authority> childList = new ArrayList();
/*     */   private Long roleId;
/* 115 */   private List<Short> isCoreList = new ArrayList();
/*     */ 
/*     */   public Long getRoleId() {
/* 118 */     return this.roleId;
/*     */   }
/*     */ 
/*     */   public void setRoleId(Long roleId) {
/* 122 */     this.roleId = roleId;
/*     */   }
/*     */ 
/*     */   public List<Short> getIsCoreList() {
/* 126 */     return this.isCoreList;
/*     */   }
/*     */ 
/*     */   public void setIsCoreList(List<Short> isCoreList) {
/* 130 */     this.isCoreList = isCoreList;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/* 134 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 138 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getCode()
/*     */   {
/* 143 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(Long code) {
/* 147 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 151 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 155 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Short getType() {
/* 159 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(Short type) {
/* 163 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public Short getIsCore() {
/* 167 */     return this.isCore;
/*     */   }
/*     */ 
/*     */   public void setIsCore(Short isCore) {
/* 171 */     this.isCore = isCore;
/*     */   }
/*     */ 
/*     */   public String getUrl() {
/* 175 */     return this.url;
/*     */   }
/*     */ 
/*     */   public String getUrlAll() {
/* 179 */     return "http://" + this.url;
/*     */   }
/*     */ 
/*     */   public void setUrl(String url) {
/* 183 */     this.url = url;
/*     */   }
/*     */ 
/*     */   public String getSubSystemId() {
/* 187 */     return this.subSystemId;
/*     */   }
/*     */ 
/*     */   public void setSubSystemId(String subSystemId) {
/* 191 */     this.subSystemId = subSystemId;
/*     */   }
/*     */ 
/*     */   public Short getSort() {
/* 195 */     return this.sort;
/*     */   }
/*     */ 
/*     */   public void setSort(Short sort) {
/* 199 */     this.sort = sort;
/*     */   }
/*     */ 
/*     */   public Short getStatus() {
/* 203 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Short status) {
/* 207 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Long getParentId() {
/* 211 */     return this.parentId;
/*     */   }
/*     */ 
/*     */   public void setParentId(Long parentId) {
/* 215 */     this.parentId = parentId;
/*     */   }
/*     */ 
/*     */   public Short getIsLeaf() {
/* 219 */     return this.isLeaf;
/*     */   }
/*     */ 
/*     */   public void setIsLeaf(Short isLeaf) {
/* 223 */     this.isLeaf = isLeaf;
/*     */   }
/*     */ 
/*     */   public Short getOpenType() {
/* 227 */     return this.openType;
/*     */   }
/*     */ 
/*     */   public void setOpenType(Short openType) {
/* 231 */     this.openType = openType;
/*     */   }
/*     */ 
/*     */   public String getIsDeleted() {
/* 235 */     return this.isDeleted;
/*     */   }
/*     */ 
/*     */   public void setIsDeleted(String isDeleted) {
/* 239 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 243 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 247 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 251 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 255 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 260 */     int prime = 31;
/* 261 */     int result = 1;
/* 262 */     result = 31 * result + (this.code == null ? 0 : this.code.hashCode());
/* 263 */     result = 31 * result + (this.gmtCreate == null ? 0 : this.gmtCreate.hashCode());
/*     */ 
/* 265 */     result = 31 * result + (this.gmtModify == null ? 0 : this.gmtModify.hashCode());
/*     */ 
/* 267 */     result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
/* 268 */     result = 31 * result + (this.isCore == null ? 0 : this.isCore.hashCode());
/* 269 */     result = 31 * result + (this.isDeleted == null ? 0 : this.isDeleted.hashCode());
/*     */ 
/* 271 */     result = 31 * result + (this.isLeaf == null ? 0 : this.isLeaf.hashCode());
/* 272 */     result = 31 * result + (this.name == null ? 0 : this.name.hashCode());
/* 273 */     result = 31 * result + (this.openType == null ? 0 : this.openType.hashCode());
/*     */ 
/* 275 */     result = 31 * result + (this.parentId == null ? 0 : this.parentId.hashCode());
/*     */ 
/* 277 */     result = 31 * result + (this.sort == null ? 0 : this.sort.hashCode());
/* 278 */     result = 31 * result + (this.status == null ? 0 : this.status.hashCode());
/* 279 */     result = 31 * result + (this.subSystemId == null ? 0 : this.subSystemId.hashCode());
/*     */ 
/* 281 */     result = 31 * result + (this.type == null ? 0 : this.type.hashCode());
/* 282 */     result = 31 * result + (this.url == null ? 0 : this.url.hashCode());
/* 283 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 288 */     if (this == obj)
/* 289 */       return true;
/* 290 */     if (obj == null)
/* 291 */       return false;
/* 292 */     if (getClass() != obj.getClass())
/* 293 */       return false;
/* 294 */     Authority other = (Authority)obj;
/* 295 */     if (this.code == null) {
/* 296 */       if (other.code != null)
/* 297 */         return false;
/* 298 */     } else if (!this.code.equals(other.code))
/* 299 */       return false;
/* 300 */     if (this.gmtCreate == null) {
/* 301 */       if (other.gmtCreate != null)
/* 302 */         return false;
/* 303 */     } else if (!this.gmtCreate.equals(other.gmtCreate))
/* 304 */       return false;
/* 305 */     if (this.gmtModify == null) {
/* 306 */       if (other.gmtModify != null)
/* 307 */         return false;
/* 308 */     } else if (!this.gmtModify.equals(other.gmtModify))
/* 309 */       return false;
/* 310 */     if (this.id == null) {
/* 311 */       if (other.id != null)
/* 312 */         return false;
/* 313 */     } else if (!this.id.equals(other.id))
/* 314 */       return false;
/* 315 */     if (this.isCore == null) {
/* 316 */       if (other.isCore != null)
/* 317 */         return false;
/* 318 */     } else if (!this.isCore.equals(other.isCore))
/* 319 */       return false;
/* 320 */     if (this.isDeleted == null) {
/* 321 */       if (other.isDeleted != null)
/* 322 */         return false;
/* 323 */     } else if (!this.isDeleted.equals(other.isDeleted))
/* 324 */       return false;
/* 325 */     if (this.isLeaf == null) {
/* 326 */       if (other.isLeaf != null)
/* 327 */         return false;
/* 328 */     } else if (!this.isLeaf.equals(other.isLeaf))
/* 329 */       return false;
/* 330 */     if (this.name == null) {
/* 331 */       if (other.name != null)
/* 332 */         return false;
/* 333 */     } else if (!this.name.equals(other.name))
/* 334 */       return false;
/* 335 */     if (this.openType == null) {
/* 336 */       if (other.openType != null)
/* 337 */         return false;
/* 338 */     } else if (!this.openType.equals(other.openType))
/* 339 */       return false;
/* 340 */     if (this.parentId == null) {
/* 341 */       if (other.parentId != null)
/* 342 */         return false;
/* 343 */     } else if (!this.parentId.equals(other.parentId))
/* 344 */       return false;
/* 345 */     if (this.sort == null) {
/* 346 */       if (other.sort != null)
/* 347 */         return false;
/* 348 */     } else if (!this.sort.equals(other.sort))
/* 349 */       return false;
/* 350 */     if (this.status == null) {
/* 351 */       if (other.status != null)
/* 352 */         return false;
/* 353 */     } else if (!this.status.equals(other.status))
/* 354 */       return false;
/* 355 */     if (this.subSystemId == null) {
/* 356 */       if (other.subSystemId != null)
/* 357 */         return false;
/* 358 */     } else if (!this.subSystemId.equals(other.subSystemId))
/* 359 */       return false;
/* 360 */     if (this.type == null) {
/* 361 */       if (other.type != null)
/* 362 */         return false;
/* 363 */     } else if (!this.type.equals(other.type))
/* 364 */       return false;
/* 365 */     if (this.url == null) {
/* 366 */       if (other.url != null)
/* 367 */         return false;
/* 368 */     } else if (!this.url.equals(other.url))
/* 369 */       return false;
/* 370 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 375 */     return "Authority [id=" + this.id + ", code=" + this.code + ", name=" + this.name + ", type=" + this.type + ", isCore=" + this.isCore + ", url=" + this.url + ", subSystemId=" + this.subSystemId + ", sort=" + this.sort + ", status=" + this.status + ", parentId=" + this.parentId + ", isLeaf=" + this.isLeaf + ", openType=" + this.openType + ", isDeleted=" + this.isDeleted + ", gmtCreate=" + this.gmtCreate + ", gmtModify=" + this.gmtModify + "]";
/*     */   }
/*     */ 
/*     */   public List<Authority> getChildList()
/*     */   {
/* 385 */     return this.childList;
/*     */   }
/*     */ 
/*     */   public void setChildList(List<Authority> childList) {
/* 389 */     this.childList = childList;
/*     */   }
/*     */ 
/*     */   public Authority getSubSystem() {
/* 393 */     return this.subSystem;
/*     */   }
/*     */ 
/*     */   public void setSubSystem(Authority subSystem) {
/* 397 */     this.subSystem = subSystem;
/*     */   }
/*     */ 
/*     */   public Authority getParent() {
/* 401 */     return this.parent;
/*     */   }
/*     */ 
/*     */   public String getParentNameByLevel(String split) {
/* 405 */     String result = "";
/* 406 */     if ((null == split) || (split.equals(""))) {
/* 407 */       split = split;
/*     */     }
/* 409 */     if ((null != getParent()) && (null != getParentId())) {
/* 410 */       result = getParent().getParentNameByLevel(split) + split + getParent().getName();
/*     */     }
/* 412 */     return result;
/*     */   }
/*     */ 
/*     */   public void setParent(Authority parent) {
/* 416 */     this.parent = parent;
/*     */   }
/*     */ 
/*     */   public static Long getRootFlag() {
/* 420 */     return rootFlag;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 424 */     System.out.println("start!!!");
/* 425 */     Authority parent0 = new Authority();
/* 426 */     parent0.setId(Long.valueOf(0L));
/* 427 */     parent0.setName("parent0");
/* 428 */     parent0.setParentId(Long.valueOf(-1L));
/* 429 */     Authority parent1 = new Authority();
/* 430 */     parent1.setId(Long.valueOf(1L));
/* 431 */     parent1.setName("parent1");
/* 432 */     parent1.setParent(parent0);
/* 433 */     parent1.setParentId(Long.valueOf(0L));
/* 434 */     Authority parent2 = new Authority();
/* 435 */     parent2.setId(Long.valueOf(2L));
/* 436 */     parent2.setName("parent2");
/* 437 */     parent2.setParent(parent1);
/* 438 */     parent2.setParentId(Long.valueOf(1L));
/* 439 */     Authority parent3 = new Authority();
/* 440 */     parent3.setId(Long.valueOf(2L));
/* 441 */     parent3.setName("parent3");
/* 442 */     parent3.setParent(parent2);
/* 443 */     parent3.setParentId(Long.valueOf(2L));
/* 444 */     System.out.println("show result!!!");
/* 445 */     System.out.println(parent3.getParentNameByLevel(""));
/*     */   }
/*     */ 
/*     */   public String getParentAllName() {
/* 449 */     return this.parentAllName;
/*     */   }
/*     */ 
/*     */   public void setParentAllName(String parentAllName) {
/* 453 */     this.parentAllName = parentAllName;
/*     */   }
/*     */ 
/*     */   public static String getSplit() {
/* 457 */     return split;
/*     */   }
/*     */ 
/*     */   public String getUrlPrefix() {
/* 461 */     return this.urlPrefix;
/*     */   }
/*     */ 
/*     */   public void setUrlPrefix(String urlPrefix) {
/* 465 */     this.urlPrefix = urlPrefix;
/*     */   }
/*     */ 
/*     */   public short getIsAssign() {
/* 469 */     return this.isAssign;
/*     */   }
/*     */ 
/*     */   public void setIsAssign(short isAssign) {
/* 473 */     this.isAssign = isAssign;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.auth.Authority
 * JD-Core Version:    0.6.0
 */