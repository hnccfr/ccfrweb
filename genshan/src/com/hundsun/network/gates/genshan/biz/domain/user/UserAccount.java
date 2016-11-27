/*     */ package com.hundsun.network.gates.genshan.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.enums.CertificateTypeEnum;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.UserRoleEnum;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.UserTypeEnum;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBank;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserStatus;
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
/*     */   private String userRole;
/*     */   private String fundAccount;
/*     */   private String fundPassword;
/*     */   private String bankCard;
/*     */   private String bank;
/*     */ 
/*     */   public String getFundAccount()
/*     */   {
/* 197 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 201 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getFundPassword() {
/* 205 */     return this.fundPassword;
/*     */   }
/*     */ 
/*     */   public void setFundPassword(String fundPassword) {
/* 209 */     this.fundPassword = fundPassword;
/*     */   }
/*     */ 
/*     */   public String getBankCard() {
/* 213 */     return this.bankCard;
/*     */   }
/*     */ 
/*     */   public void setBankCard(String bankCard) {
/* 217 */     this.bankCard = bankCard;
/*     */   }
/*     */ 
/*     */   public String getBank() {
/* 221 */     return this.bank;
/*     */   }
/*     */ 
/*     */   public void setBank(String bank) {
/* 225 */     this.bank = bank;
/*     */   }
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 232 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 239 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getAccount()
/*     */   {
/* 246 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account)
/*     */   {
/* 253 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/* 260 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 267 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 274 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 281 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 288 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/* 295 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 302 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 309 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getMobile()
/*     */   {
/* 316 */     return this.mobile;
/*     */   }
/*     */ 
/*     */   public void setMobile(String mobile)
/*     */   {
/* 323 */     this.mobile = mobile;
/*     */   }
/*     */ 
/*     */   public String getCertificateType()
/*     */   {
/* 332 */     return this.certificateType;
/*     */   }
/*     */ 
/*     */   public void setCertificateType(String certificateType)
/*     */   {
/* 341 */     this.certificateType = certificateType;
/*     */   }
/*     */ 
/*     */   public String getCertificateNum()
/*     */   {
/* 348 */     return this.certificateNum;
/*     */   }
/*     */ 
/*     */   public void setCertificateNum(String certificateNum)
/*     */   {
/* 355 */     this.certificateNum = certificateNum;
/*     */   }
/*     */ 
/*     */   public String getCertificatePath()
/*     */   {
/* 362 */     return this.certificatePath;
/*     */   }
/*     */ 
/*     */   public void setCertificatePath(String certificatePath)
/*     */   {
/* 369 */     this.certificatePath = certificatePath;
/*     */   }
/*     */ 
/*     */   public String getEmail()
/*     */   {
/* 376 */     return this.email;
/*     */   }
/*     */ 
/*     */   public void setEmail(String email)
/*     */   {
/* 383 */     this.email = email;
/*     */   }
/*     */ 
/*     */   public String getZipCode()
/*     */   {
/* 390 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode)
/*     */   {
/* 397 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getProvince()
/*     */   {
/* 404 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province)
/*     */   {
/* 411 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 418 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 425 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea()
/*     */   {
/* 432 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area)
/*     */   {
/* 439 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getAddress()
/*     */   {
/* 446 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/* 453 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getFullName()
/*     */   {
/* 460 */     return this.fullName;
/*     */   }
/*     */ 
/*     */   public void setFullName(String fullName)
/*     */   {
/* 467 */     this.fullName = fullName;
/*     */   }
/*     */ 
/*     */   public String getIntro()
/*     */   {
/* 474 */     return this.intro;
/*     */   }
/*     */ 
/*     */   public void setIntro(String intro)
/*     */   {
/* 481 */     this.intro = intro;
/*     */   }
/*     */ 
/*     */   public String getHomePage()
/*     */   {
/* 488 */     return this.homePage;
/*     */   }
/*     */ 
/*     */   public void setHomePage(String homePage)
/*     */   {
/* 495 */     this.homePage = homePage;
/*     */   }
/*     */ 
/*     */   public String getScope()
/*     */   {
/* 502 */     return this.scope;
/*     */   }
/*     */ 
/*     */   public void setScope(String scope)
/*     */   {
/* 509 */     this.scope = scope;
/*     */   }
/*     */ 
/*     */   public String getTaxNum()
/*     */   {
/* 516 */     return this.taxNum;
/*     */   }
/*     */ 
/*     */   public void setTaxNum(String taxNum)
/*     */   {
/* 523 */     this.taxNum = taxNum;
/*     */   }
/*     */ 
/*     */   public String getUserClass()
/*     */   {
/* 530 */     return this.userClass;
/*     */   }
/*     */ 
/*     */   public void setUserClass(String userClass)
/*     */   {
/* 537 */     this.userClass = userClass;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 544 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 551 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Long getCreditClass()
/*     */   {
/* 558 */     return this.creditClass;
/*     */   }
/*     */ 
/*     */   public void setCreditClass(Long creditClass)
/*     */   {
/* 565 */     this.creditClass = creditClass;
/*     */   }
/*     */ 
/*     */   public String getActiveCode()
/*     */   {
/* 572 */     return this.activeCode;
/*     */   }
/*     */ 
/*     */   public void setActiveCode(String activeCode)
/*     */   {
/* 579 */     this.activeCode = activeCode;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 586 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 593 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 600 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 607 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 614 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 621 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getLastLoginIp() {
/* 625 */     return this.lastLoginIp;
/*     */   }
/*     */ 
/*     */   public void setLastLoginIp(String lastLoginIp) {
/* 629 */     this.lastLoginIp = lastLoginIp;
/*     */   }
/*     */ 
/*     */   public Date getLastLoginTime() {
/* 633 */     return this.lastLoginTime;
/*     */   }
/*     */ 
/*     */   public void setLastLoginTime(Date lastLoginTime) {
/* 637 */     this.lastLoginTime = lastLoginTime;
/*     */   }
/*     */ 
/*     */   public String getCertificateTypeDesc()
/*     */   {
/* 648 */     CertificateTypeEnum typeEnum = CertificateTypeEnum.indexByValue(this.certificateType);
/* 649 */     if (null == typeEnum) {
/* 650 */       return this.certificateType;
/*     */     }
/* 652 */     return typeEnum.getName();
/*     */   }
/*     */ 
/*     */   public void setUserRole(String userRole) {
/* 656 */     this.userRole = userRole;
/*     */   }
/*     */ 
/*     */   public String getUserRole() {
/* 660 */     return this.userRole;
/*     */   }
/*     */ 
/*     */   public String getUserRoleDesc()
/*     */   {
/* 671 */     UserRoleEnum userRoleEnum = UserRoleEnum.indexByValue(this.userRole);
/* 672 */     if (null == userRoleEnum) {
/* 673 */       return this.userRole;
/*     */     }
/* 675 */     return userRoleEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getUserStatusDesc()
/*     */   {
/* 686 */     EnumUserStatus userStatusEnum = EnumUserStatus.indexByValue(this.status);
/* 687 */     if (null == userStatusEnum) {
/* 688 */       return this.status;
/*     */     }
/* 690 */     return userStatusEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getUserTypeDesc() {
/* 694 */     UserTypeEnum userTypeEnum = UserTypeEnum.indexByValue(this.type);
/* 695 */     if (null == userTypeEnum) {
/* 696 */       return this.type;
/*     */     }
/* 698 */     return userTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getBankDesc()
/*     */   {
/* 709 */     String bankDesc = EnumBank.getDescriptionByNo(this.bank);
/* 710 */     if (null == bankDesc) {
/* 711 */       return this.bank;
/*     */     }
/* 713 */     return bankDesc;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.user.UserAccount
 * JD-Core Version:    0.6.0
 */