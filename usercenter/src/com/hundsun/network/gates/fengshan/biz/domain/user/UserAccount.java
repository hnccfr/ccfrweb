/*     */ package com.hundsun.network.gates.fengshan.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumCertificateType;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.UserTypeEnum;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBank;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserAccount
/*     */ {
/*     */   private Long id;
/*     */   private String account;
/*     */   private String type;
/*     */   private String name;
/*     */   private String password;
/*     */   private String phone;
/*     */   private String mobile;
/*     */   private String certificateType;
/*     */   private String certificateNum;
/*     */   private String certificatePath;
/*     */   private String email;
/*     */   private String zipCode;
/*     */   private String province;
/*     */   private String city;
/*     */   private String area;
/*     */   private String address;
/*     */   private String fullName;
/*     */   private String intro;
/*     */   private String homePage;
/*     */   private String scope;
/*     */   private String taxNum;
/*     */   private String userClass;
/*     */   private String status;
/*     */   private Long creditClass;
/*     */   private String activeCode;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private String lastLoginIp;
/*     */   private Date lastLoginTime;
/*     */   private String fundAccount;
/*     */   private String fundPassword;
/*     */   private String bank;
/*     */   private String bankCard;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 185 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 192 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getAccount()
/*     */   {
/* 199 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account)
/*     */   {
/* 206 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/* 213 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 220 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 227 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 234 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 241 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/* 248 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 255 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 262 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getMobile()
/*     */   {
/* 269 */     return this.mobile;
/*     */   }
/*     */ 
/*     */   public void setMobile(String mobile)
/*     */   {
/* 276 */     this.mobile = mobile;
/*     */   }
/*     */ 
/*     */   public String getCertificateType()
/*     */   {
/* 285 */     return this.certificateType;
/*     */   }
/*     */ 
/*     */   public void setCertificateType(String certificateType)
/*     */   {
/* 294 */     this.certificateType = certificateType;
/*     */   }
/*     */ 
/*     */   public String getCertificateNum()
/*     */   {
/* 301 */     return this.certificateNum;
/*     */   }
/*     */ 
/*     */   public void setCertificateNum(String certificateNum)
/*     */   {
/* 308 */     this.certificateNum = certificateNum;
/*     */   }
/*     */ 
/*     */   public String getCertificatePath()
/*     */   {
/* 315 */     return this.certificatePath;
/*     */   }
/*     */ 
/*     */   public void setCertificatePath(String certificatePath)
/*     */   {
/* 322 */     this.certificatePath = certificatePath;
/*     */   }
/*     */ 
/*     */   public String getEmail()
/*     */   {
/* 329 */     return this.email;
/*     */   }
/*     */ 
/*     */   public void setEmail(String email)
/*     */   {
/* 336 */     this.email = email;
/*     */   }
/*     */ 
/*     */   public String getZipCode()
/*     */   {
/* 343 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode)
/*     */   {
/* 350 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getProvince()
/*     */   {
/* 357 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province)
/*     */   {
/* 364 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 371 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 378 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea()
/*     */   {
/* 385 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area)
/*     */   {
/* 392 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getAddress()
/*     */   {
/* 399 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/* 406 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getFullName()
/*     */   {
/* 413 */     return this.fullName;
/*     */   }
/*     */ 
/*     */   public void setFullName(String fullName)
/*     */   {
/* 420 */     this.fullName = fullName;
/*     */   }
/*     */ 
/*     */   public String getIntro()
/*     */   {
/* 427 */     return this.intro;
/*     */   }
/*     */ 
/*     */   public void setIntro(String intro)
/*     */   {
/* 434 */     this.intro = intro;
/*     */   }
/*     */ 
/*     */   public String getHomePage()
/*     */   {
/* 441 */     return this.homePage;
/*     */   }
/*     */ 
/*     */   public void setHomePage(String homePage)
/*     */   {
/* 448 */     this.homePage = homePage;
/*     */   }
/*     */ 
/*     */   public String getScope()
/*     */   {
/* 455 */     return this.scope;
/*     */   }
/*     */ 
/*     */   public void setScope(String scope)
/*     */   {
/* 462 */     this.scope = scope;
/*     */   }
/*     */ 
/*     */   public String getTaxNum()
/*     */   {
/* 469 */     return this.taxNum;
/*     */   }
/*     */ 
/*     */   public void setTaxNum(String taxNum)
/*     */   {
/* 476 */     this.taxNum = taxNum;
/*     */   }
/*     */ 
/*     */   public String getUserClass()
/*     */   {
/* 483 */     return this.userClass;
/*     */   }
/*     */ 
/*     */   public void setUserClass(String userClass)
/*     */   {
/* 490 */     this.userClass = userClass;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 497 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 504 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Long getCreditClass()
/*     */   {
/* 511 */     return this.creditClass;
/*     */   }
/*     */ 
/*     */   public void setCreditClass(Long creditClass)
/*     */   {
/* 518 */     this.creditClass = creditClass;
/*     */   }
/*     */ 
/*     */   public String getActiveCode()
/*     */   {
/* 525 */     return this.activeCode;
/*     */   }
/*     */ 
/*     */   public void setActiveCode(String activeCode)
/*     */   {
/* 532 */     this.activeCode = activeCode;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 539 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 546 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 553 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 560 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 567 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 574 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getLastLoginIp() {
/* 578 */     return this.lastLoginIp;
/*     */   }
/*     */ 
/*     */   public void setLastLoginIp(String lastLoginIp) {
/* 582 */     this.lastLoginIp = lastLoginIp;
/*     */   }
/*     */ 
/*     */   public Date getLastLoginTime() {
/* 586 */     return this.lastLoginTime;
/*     */   }
/*     */ 
/*     */   public void setLastLoginTime(Date lastLoginTime) {
/* 590 */     this.lastLoginTime = lastLoginTime;
/*     */   }
/*     */ 
/*     */   public String getCertificateTypeDesc()
/*     */   {
/* 601 */     EnumCertificateType typeEnum = EnumCertificateType.indexByValue(this.certificateType);
/* 602 */     if (null == typeEnum) {
/* 603 */       return this.certificateType;
/*     */     }
/* 605 */     return typeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getUserTypeDesc()
/*     */   {
/* 616 */     UserTypeEnum userTypeEnum = UserTypeEnum.indexByValue(this.type);
/* 617 */     if (null == userTypeEnum) {
/* 618 */       return this.type;
/*     */     }
/* 620 */     return userTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 624 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 628 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getFundPassword() {
/* 632 */     return this.fundPassword;
/*     */   }
/*     */ 
/*     */   public void setFundPassword(String fundPassword) {
/* 636 */     this.fundPassword = fundPassword;
/*     */   }
/*     */ 
/*     */   public void setBank(String bank) {
/* 640 */     this.bank = bank;
/*     */   }
/*     */ 
/*     */   public String getBank() {
/* 644 */     return this.bank;
/*     */   }
/*     */ 
/*     */   public void setBankCard(String bankCard) {
/* 648 */     this.bankCard = bankCard;
/*     */   }
/*     */ 
/*     */   public String getBankCard() {
/* 652 */     return this.bankCard;
/*     */   }
/*     */   public String getBankDesc() {
/* 655 */     EnumBank bankEnum = EnumBank.getByBankNo(this.bank);
/* 656 */     if (null == bankEnum) {
/* 657 */       return this.bank;
/*     */     }
/* 659 */     return bankEnum.getDescription();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.user.UserAccount
 * JD-Core Version:    0.6.0
 */