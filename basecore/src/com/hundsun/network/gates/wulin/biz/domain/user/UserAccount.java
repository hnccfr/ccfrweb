/*     */ package com.hundsun.network.gates.wulin.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.remote.BaseDTO;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserAccount extends BaseDTO
/*     */ {
/*     */   private static final long serialVersionUID = 4362895581891761899L;
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
/* 186 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 193 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getAccount()
/*     */   {
/* 200 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account)
/*     */   {
/* 207 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/* 214 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 221 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 228 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 235 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 242 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/* 249 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 256 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 263 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getMobile()
/*     */   {
/* 270 */     return this.mobile;
/*     */   }
/*     */ 
/*     */   public void setMobile(String mobile)
/*     */   {
/* 277 */     this.mobile = mobile;
/*     */   }
/*     */ 
/*     */   public String getCertificateType()
/*     */   {
/* 286 */     return this.certificateType;
/*     */   }
/*     */ 
/*     */   public void setCertificateType(String certificateType)
/*     */   {
/* 295 */     this.certificateType = certificateType;
/*     */   }
/*     */ 
/*     */   public String getCertificateNum()
/*     */   {
/* 302 */     return this.certificateNum;
/*     */   }
/*     */ 
/*     */   public void setCertificateNum(String certificateNum)
/*     */   {
/* 309 */     this.certificateNum = certificateNum;
/*     */   }
/*     */ 
/*     */   public String getCertificatePath()
/*     */   {
/* 316 */     return this.certificatePath;
/*     */   }
/*     */ 
/*     */   public void setCertificatePath(String certificatePath)
/*     */   {
/* 323 */     this.certificatePath = certificatePath;
/*     */   }
/*     */ 
/*     */   public String getEmail()
/*     */   {
/* 330 */     return this.email;
/*     */   }
/*     */ 
/*     */   public void setEmail(String email)
/*     */   {
/* 337 */     this.email = email;
/*     */   }
/*     */ 
/*     */   public String getZipCode()
/*     */   {
/* 344 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode)
/*     */   {
/* 351 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getProvince()
/*     */   {
/* 358 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province)
/*     */   {
/* 365 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 372 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 379 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea()
/*     */   {
/* 386 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area)
/*     */   {
/* 393 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getAddress()
/*     */   {
/* 400 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/* 407 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getFullName()
/*     */   {
/* 414 */     return this.fullName;
/*     */   }
/*     */ 
/*     */   public void setFullName(String fullName)
/*     */   {
/* 421 */     this.fullName = fullName;
/*     */   }
/*     */ 
/*     */   public String getIntro()
/*     */   {
/* 428 */     return this.intro;
/*     */   }
/*     */ 
/*     */   public void setIntro(String intro)
/*     */   {
/* 435 */     this.intro = intro;
/*     */   }
/*     */ 
/*     */   public String getHomePage()
/*     */   {
/* 442 */     return this.homePage;
/*     */   }
/*     */ 
/*     */   public void setHomePage(String homePage)
/*     */   {
/* 449 */     this.homePage = homePage;
/*     */   }
/*     */ 
/*     */   public String getScope()
/*     */   {
/* 456 */     return this.scope;
/*     */   }
/*     */ 
/*     */   public void setScope(String scope)
/*     */   {
/* 463 */     this.scope = scope;
/*     */   }
/*     */ 
/*     */   public String getTaxNum()
/*     */   {
/* 470 */     return this.taxNum;
/*     */   }
/*     */ 
/*     */   public void setTaxNum(String taxNum)
/*     */   {
/* 477 */     this.taxNum = taxNum;
/*     */   }
/*     */ 
/*     */   public String getUserClass()
/*     */   {
/* 484 */     return this.userClass;
/*     */   }
/*     */ 
/*     */   public void setUserClass(String userClass)
/*     */   {
/* 491 */     this.userClass = userClass;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 498 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 505 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Long getCreditClass()
/*     */   {
/* 512 */     return this.creditClass;
/*     */   }
/*     */ 
/*     */   public void setCreditClass(Long creditClass)
/*     */   {
/* 519 */     this.creditClass = creditClass;
/*     */   }
/*     */ 
/*     */   public String getActiveCode()
/*     */   {
/* 526 */     return this.activeCode;
/*     */   }
/*     */ 
/*     */   public void setActiveCode(String activeCode)
/*     */   {
/* 533 */     this.activeCode = activeCode;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 540 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 547 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 554 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 561 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 568 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 575 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getLastLoginIp() {
/* 579 */     return this.lastLoginIp;
/*     */   }
/*     */ 
/*     */   public void setLastLoginIp(String lastLoginIp) {
/* 583 */     this.lastLoginIp = lastLoginIp;
/*     */   }
/*     */ 
/*     */   public Date getLastLoginTime() {
/* 587 */     return this.lastLoginTime;
/*     */   }
/*     */ 
/*     */   public void setLastLoginTime(Date lastLoginTime) {
/* 591 */     this.lastLoginTime = lastLoginTime;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 595 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 599 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getFundPassword() {
/* 603 */     return this.fundPassword;
/*     */   }
/*     */ 
/*     */   public void setFundPassword(String fundPassword) {
/* 607 */     this.fundPassword = fundPassword;
/*     */   }
/*     */ 
/*     */   public String getBank() {
/* 611 */     return this.bank;
/*     */   }
/*     */ 
/*     */   public void setBank(String bank) {
/* 615 */     this.bank = bank;
/*     */   }
/*     */ 
/*     */   public String getBankCard() {
/* 619 */     return this.bankCard;
/*     */   }
/*     */ 
/*     */   public void setBankCard(String bankCard) {
/* 623 */     this.bankCard = bankCard;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.user.UserAccount
 * JD-Core Version:    0.6.0
 */