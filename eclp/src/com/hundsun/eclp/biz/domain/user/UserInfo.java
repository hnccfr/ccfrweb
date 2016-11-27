/*     */ package com.hundsun.eclp.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.eclp.client.remote.dto.UserDTO;
/*     */ import com.hundsun.eclp.util.BeanUtilEx;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class UserInfo
/*     */ {
/*     */   private Long id;
/*     */   private Long deptId;
/*     */   private Long userId;
/*     */   private String realName;
/*     */   private Short status;
/*     */   private String position;
/*     */   private Date birthday;
/*     */   private String qq;
/*     */   private String msn;
/*     */   private String wangwang;
/*     */   private String officePhone;
/*     */   private String homePhone;
/*     */   private String mobilePhone;
/*     */   private String emall;
/*     */   private String address;
/*     */   private Date availableDate;
/*     */   private Short workYear;
/*     */   private Short idType;
/*     */   private String idCard;
/*     */   private String education;
/*     */   private String degree;
/*     */   private Short isActive;
/*     */   private String jobNo;
/*     */   private Short gender;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private Short sort;
/*     */   private String isDeleted;
/*     */   private Long uinfoId;
/*     */   private String account;
/*     */   private String regProvinceCode;
/*     */   private String regProvince;
/*     */   private String regCityCode;
/*     */   private String regCity;
/*     */   private String regDistrict;
/*     */   private String regDistrictCode;
/*     */   private String regAddr;
/*     */   private String ext1;
/*     */   private String ext2;
/*     */   private String ext3;
/*     */   private Short userType;
/*     */   private List<Long> deptList;
/*     */   private String deptName;
/*     */ 
/*     */   public Long getUinfoId()
/*     */   {
/* 216 */     return this.uinfoId;
/*     */   }
/*     */ 
/*     */   public void setUinfoId(Long uinfoId) {
/* 220 */     this.uinfoId = uinfoId;
/*     */   }
/*     */ 
/*     */   public String getIsDeleted() {
/* 224 */     return this.isDeleted;
/*     */   }
/*     */ 
/*     */   public void setIsDeleted(String isDeleted) {
/* 228 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ 
/*     */   public List<Long> getDeptList()
/*     */   {
/* 234 */     return this.deptList;
/*     */   }
/*     */ 
/*     */   public void setDeptList(List<Long> deptList) {
/* 238 */     this.deptList = deptList;
/*     */   }
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 244 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 248 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getDeptId() {
/* 252 */     return this.deptId;
/*     */   }
/*     */ 
/*     */   public void setDeptId(Long deptId) {
/* 256 */     this.deptId = deptId;
/*     */   }
/*     */ 
/*     */   public Long getUserId() {
/* 260 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(Long userId) {
/* 264 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public String getRealName() {
/* 268 */     return this.realName;
/*     */   }
/*     */ 
/*     */   public void setRealName(String realName) {
/* 272 */     this.realName = realName;
/*     */   }
/*     */ 
/*     */   public Short getStatus() {
/* 276 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Short status) {
/* 280 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getPosition() {
/* 284 */     return this.position;
/*     */   }
/*     */ 
/*     */   public void setPosition(String position) {
/* 288 */     this.position = position;
/*     */   }
/*     */ 
/*     */   public Date getBirthday() {
/* 292 */     return this.birthday;
/*     */   }
/*     */ 
/*     */   public void setBirthday(Date birthday) {
/* 296 */     this.birthday = birthday;
/*     */   }
/*     */ 
/*     */   public String getQq() {
/* 300 */     return this.qq;
/*     */   }
/*     */ 
/*     */   public void setQq(String qq) {
/* 304 */     this.qq = qq;
/*     */   }
/*     */ 
/*     */   public String getMsn() {
/* 308 */     return this.msn;
/*     */   }
/*     */ 
/*     */   public void setMsn(String msn) {
/* 312 */     this.msn = msn;
/*     */   }
/*     */ 
/*     */   public String getWangwang() {
/* 316 */     return this.wangwang;
/*     */   }
/*     */ 
/*     */   public void setWangwang(String wangwang) {
/* 320 */     this.wangwang = wangwang;
/*     */   }
/*     */ 
/*     */   public String getOfficePhone() {
/* 324 */     return this.officePhone;
/*     */   }
/*     */ 
/*     */   public void setOfficePhone(String officePhone) {
/* 328 */     this.officePhone = officePhone;
/*     */   }
/*     */ 
/*     */   public String getHomePhone() {
/* 332 */     return this.homePhone;
/*     */   }
/*     */ 
/*     */   public void setHomePhone(String homePhone) {
/* 336 */     this.homePhone = homePhone;
/*     */   }
/*     */ 
/*     */   public String getMobilePhone() {
/* 340 */     return this.mobilePhone;
/*     */   }
/*     */ 
/*     */   public void setMobilePhone(String mobilePhone) {
/* 344 */     this.mobilePhone = mobilePhone;
/*     */   }
/*     */ 
/*     */   public String getEmall() {
/* 348 */     return this.emall;
/*     */   }
/*     */ 
/*     */   public void setEmall(String emall) {
/* 352 */     this.emall = emall;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/* 356 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/* 360 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public Date getAvailableDate() {
/* 364 */     return this.availableDate;
/*     */   }
/*     */ 
/*     */   public void setAvailableDate(Date availableDate) {
/* 368 */     this.availableDate = availableDate;
/*     */   }
/*     */ 
/*     */   public Short getWorkYear() {
/* 372 */     return this.workYear;
/*     */   }
/*     */ 
/*     */   public void setWorkYear(Short workYear) {
/* 376 */     this.workYear = workYear;
/*     */   }
/*     */ 
/*     */   public Short getIdType() {
/* 380 */     return this.idType;
/*     */   }
/*     */ 
/*     */   public void setIdType(Short idType) {
/* 384 */     this.idType = idType;
/*     */   }
/*     */ 
/*     */   public String getIdCard() {
/* 388 */     return this.idCard;
/*     */   }
/*     */ 
/*     */   public void setIdCard(String idCard) {
/* 392 */     this.idCard = idCard;
/*     */   }
/*     */ 
/*     */   public String getEducation() {
/* 396 */     return this.education;
/*     */   }
/*     */ 
/*     */   public void setEducation(String education) {
/* 400 */     this.education = education;
/*     */   }
/*     */ 
/*     */   public String getDegree() {
/* 404 */     return this.degree;
/*     */   }
/*     */ 
/*     */   public void setDegree(String degree) {
/* 408 */     this.degree = degree;
/*     */   }
/*     */ 
/*     */   public Short getIsActive() {
/* 412 */     return this.isActive;
/*     */   }
/*     */ 
/*     */   public void setIsActive(Short isActive) {
/* 416 */     this.isActive = isActive;
/*     */   }
/*     */ 
/*     */   public String getJobNo() {
/* 420 */     return this.jobNo;
/*     */   }
/*     */ 
/*     */   public void setJobNo(String jobNo) {
/* 424 */     this.jobNo = jobNo;
/*     */   }
/*     */ 
/*     */   public Short getGender() {
/* 428 */     return this.gender;
/*     */   }
/*     */ 
/*     */   public void setGender(Short gender) {
/* 432 */     this.gender = gender;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 436 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 440 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 444 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 448 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getDeptName() {
/* 452 */     return this.deptName;
/*     */   }
/*     */ 
/*     */   public void setDeptName(String deptName) {
/* 456 */     this.deptName = deptName;
/*     */   }
/*     */ 
/*     */   public Short getSort() {
/* 460 */     return this.sort;
/*     */   }
/*     */ 
/*     */   public void setSort(Short sort) {
/* 464 */     this.sort = sort;
/*     */   }
/*     */ 
/*     */   public String getAccount() {
/* 468 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account) {
/* 472 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getRegProvinceCode() {
/* 476 */     return this.regProvinceCode;
/*     */   }
/*     */ 
/*     */   public void setRegProvinceCode(String regProvinceCode) {
/* 480 */     this.regProvinceCode = regProvinceCode;
/*     */   }
/*     */ 
/*     */   public String getRegProvince() {
/* 484 */     return this.regProvince;
/*     */   }
/*     */ 
/*     */   public void setRegProvince(String regProvince) {
/* 488 */     this.regProvince = regProvince;
/*     */   }
/*     */ 
/*     */   public String getRegCityCode() {
/* 492 */     return this.regCityCode;
/*     */   }
/*     */ 
/*     */   public void setRegCityCode(String regCityCode) {
/* 496 */     this.regCityCode = regCityCode;
/*     */   }
/*     */ 
/*     */   public String getRegCity() {
/* 500 */     return this.regCity;
/*     */   }
/*     */ 
/*     */   public void setRegCity(String regCity) {
/* 504 */     this.regCity = regCity;
/*     */   }
/*     */ 
/*     */   public String getRegDistrict() {
/* 508 */     return this.regDistrict;
/*     */   }
/*     */ 
/*     */   public void setRegDistrict(String regDistrict) {
/* 512 */     this.regDistrict = regDistrict;
/*     */   }
/*     */ 
/*     */   public String getRegDistrictCode() {
/* 516 */     return this.regDistrictCode;
/*     */   }
/*     */ 
/*     */   public void setRegDistrictCode(String regDistrictCode) {
/* 520 */     this.regDistrictCode = regDistrictCode;
/*     */   }
/*     */ 
/*     */   public String getRegAddr() {
/* 524 */     return this.regAddr;
/*     */   }
/*     */ 
/*     */   public void setRegAddr(String regAddr) {
/* 528 */     this.regAddr = regAddr;
/*     */   }
/*     */ 
/*     */   public String getExt1() {
/* 532 */     return this.ext1;
/*     */   }
/*     */ 
/*     */   public void setExt1(String ext1) {
/* 536 */     this.ext1 = ext1;
/*     */   }
/*     */ 
/*     */   public String getExt2() {
/* 540 */     return this.ext2;
/*     */   }
/*     */ 
/*     */   public void setExt2(String ext2) {
/* 544 */     this.ext2 = ext2;
/*     */   }
/*     */ 
/*     */   public String getExt3() {
/* 548 */     return this.ext3;
/*     */   }
/*     */ 
/*     */   public void setExt3(String ext3) {
/* 552 */     this.ext3 = ext3;
/*     */   }
/*     */ 
/*     */   public Short getUserType() {
/* 556 */     return this.userType;
/*     */   }
/*     */ 
/*     */   public void setUserType(Short userType) {
/* 560 */     this.userType = userType;
/*     */   }
/*     */ 
/*     */   public UserDTO toDTO() {
/* 564 */     UserDTO dto = new UserDTO();
/*     */     try {
/* 566 */       BeanUtilEx.copyProperties(dto, this);
/*     */     } catch (IllegalAccessException e) {
/* 568 */       e.printStackTrace();
/*     */     } catch (InvocationTargetException e) {
/* 570 */       e.printStackTrace();
/*     */     }
/* 572 */     return dto;
/*     */   }
/*     */ 
/*     */   public String getRegFullAddr()
/*     */   {
/* 581 */     StringBuilder sb = new StringBuilder();
/* 582 */     if (StringUtil.isNotBlank(this.regProvince)) {
/* 583 */       sb.append(this.regProvince);
/* 584 */       sb.append(" ");
/*     */     }
/* 586 */     if (StringUtil.isNotBlank(this.regCity)) {
/* 587 */       sb.append(this.regCity);
/* 588 */       sb.append(" ");
/*     */     }
/* 590 */     if (StringUtil.isNotBlank(this.regDistrict)) {
/* 591 */       sb.append(this.regDistrict);
/* 592 */       sb.append(" ");
/*     */     }
/* 594 */     if (StringUtil.isNotBlank(this.regAddr)) {
/* 595 */       sb.append(this.regAddr);
/*     */     }
/* 597 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.user.UserInfo
 * JD-Core Version:    0.6.0
 */