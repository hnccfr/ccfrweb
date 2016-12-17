/*     */ package com.hundsun.network.gates.fengshan.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.UserAddressTypeEnum;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserAddress
/*     */ {
/*     */   private Long id;
/*     */   private String userAccount;
/*     */   private String linkman;
/*     */   private String phone;
/*     */   private String type;
/*     */   private String province;
/*     */   private String city;
/*     */   private String area;
/*     */   private String address;
/*     */   private String zipCode;
/*     */   private String isDefault;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private String storehouse;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  84 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  91 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/*  98 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 105 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getLinkman()
/*     */   {
/* 112 */     return this.linkman;
/*     */   }
/*     */ 
/*     */   public void setLinkman(String linkman)
/*     */   {
/* 119 */     this.linkman = linkman;
/*     */   }
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 126 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 133 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/* 140 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 147 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getProvince()
/*     */   {
/* 154 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province)
/*     */   {
/* 161 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 168 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 175 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea()
/*     */   {
/* 182 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area)
/*     */   {
/* 189 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/* 193 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/* 197 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getZipCode()
/*     */   {
/* 204 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode)
/*     */   {
/* 211 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getIsDefault()
/*     */   {
/* 218 */     return this.isDefault;
/*     */   }
/*     */ 
/*     */   public void setIsDefault(String isDefault)
/*     */   {
/* 225 */     this.isDefault = isDefault;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 232 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 239 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 246 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 253 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 260 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 267 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public boolean isPersonal() {
/* 271 */     return UserAddressTypeEnum.Personal.getValue().equals(getType());
/*     */   }
/*     */ 
/*     */   public boolean isStore() {
/* 275 */     return UserAddressTypeEnum.Storehouse.getValue().equals(getType());
/*     */   }
/*     */ 
/*     */   public void setStorehouse(String storehouse) {
/* 279 */     this.storehouse = storehouse;
/*     */   }
/*     */ 
/*     */   public String getStorehouse() {
/* 283 */     return this.storehouse;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.user.UserAddress
 * JD-Core Version:    0.6.0
 */