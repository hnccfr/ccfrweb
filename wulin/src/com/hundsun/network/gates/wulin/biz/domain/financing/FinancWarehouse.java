/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancWarehouse
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private Long userAccountId;
/*     */   private Long depositoryId;
/*     */   private String warehouseNo;
/*     */   private String compName;
/*     */   private String lossStandard;
/*     */   private String insuranceNo;
/*     */   private String insuranceName;
/*     */   private Long insuranceAmount;
/*     */   private Date insuranceDateFrom;
/*     */   private Date insuranceDateTo;
/*     */   private String handlePerson;
/*     */   private String storekeeper;
/*     */   private String leader;
/*     */   private Date storageDate;
/*     */   private Short checkStatus;
/*     */   private Long assessingPrice;
/*     */   private BigDecimal ratio;
/*     */   private String checkPerson;
/*     */   private Date checkDate;
/*     */   private Short merchAck;
/*     */   private String merchAckPerson;
/*     */   private Date merchAckDate;
/*     */   private Date gmtModify;
/*     */   private Date gmtCreate;
/*     */   private String memo;
/*     */   private Short storeAckChange;
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 154 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 163 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getUserAccountId()
/*     */   {
/* 172 */     return this.userAccountId;
/*     */   }
/*     */ 
/*     */   public void setUserAccountId(Long userAccountId)
/*     */   {
/* 181 */     this.userAccountId = userAccountId;
/*     */   }
/*     */ 
/*     */   public Long getDepositoryId()
/*     */   {
/* 190 */     return this.depositoryId;
/*     */   }
/*     */ 
/*     */   public void setDepositoryId(Long depositoryId)
/*     */   {
/* 199 */     this.depositoryId = depositoryId;
/*     */   }
/*     */ 
/*     */   public String getWarehouseNo()
/*     */   {
/* 208 */     return this.warehouseNo;
/*     */   }
/*     */ 
/*     */   public void setWarehouseNo(String warehouseNo)
/*     */   {
/* 217 */     this.warehouseNo = (warehouseNo == null ? null : warehouseNo.trim());
/*     */   }
/*     */ 
/*     */   public String getCompName()
/*     */   {
/* 226 */     return this.compName;
/*     */   }
/*     */ 
/*     */   public void setCompName(String compName)
/*     */   {
/* 235 */     this.compName = (compName == null ? null : compName.trim());
/*     */   }
/*     */ 
/*     */   public String getLossStandard()
/*     */   {
/* 244 */     return this.lossStandard;
/*     */   }
/*     */ 
/*     */   public void setLossStandard(String lossStandard)
/*     */   {
/* 253 */     this.lossStandard = (lossStandard == null ? null : lossStandard.trim());
/*     */   }
/*     */ 
/*     */   public String getInsuranceNo()
/*     */   {
/* 262 */     return this.insuranceNo;
/*     */   }
/*     */ 
/*     */   public void setInsuranceNo(String insuranceNo)
/*     */   {
/* 271 */     this.insuranceNo = (insuranceNo == null ? null : insuranceNo.trim());
/*     */   }
/*     */ 
/*     */   public String getInsuranceName()
/*     */   {
/* 280 */     return this.insuranceName;
/*     */   }
/*     */ 
/*     */   public void setInsuranceName(String insuranceName)
/*     */   {
/* 289 */     this.insuranceName = (insuranceName == null ? null : insuranceName.trim());
/*     */   }
/*     */ 
/*     */   public Long getInsuranceAmount()
/*     */   {
/* 298 */     return this.insuranceAmount;
/*     */   }
/*     */ 
/*     */   public void setInsuranceAmount(Long insuranceAmount)
/*     */   {
/* 307 */     this.insuranceAmount = insuranceAmount;
/*     */   }
/*     */ 
/*     */   public Date getInsuranceDateFrom()
/*     */   {
/* 316 */     return this.insuranceDateFrom;
/*     */   }
/*     */ 
/*     */   public void setInsuranceDateFrom(Date insuranceDateFrom)
/*     */   {
/* 325 */     this.insuranceDateFrom = insuranceDateFrom;
/*     */   }
/*     */ 
/*     */   public Date getInsuranceDateTo()
/*     */   {
/* 334 */     return this.insuranceDateTo;
/*     */   }
/*     */ 
/*     */   public void setInsuranceDateTo(Date insuranceDateTo)
/*     */   {
/* 343 */     this.insuranceDateTo = insuranceDateTo;
/*     */   }
/*     */ 
/*     */   public String getHandlePerson()
/*     */   {
/* 352 */     return this.handlePerson;
/*     */   }
/*     */ 
/*     */   public void setHandlePerson(String handlePerson)
/*     */   {
/* 361 */     this.handlePerson = (handlePerson == null ? null : handlePerson.trim());
/*     */   }
/*     */ 
/*     */   public String getStorekeeper()
/*     */   {
/* 370 */     return this.storekeeper;
/*     */   }
/*     */ 
/*     */   public void setStorekeeper(String storekeeper)
/*     */   {
/* 379 */     this.storekeeper = (storekeeper == null ? null : storekeeper.trim());
/*     */   }
/*     */ 
/*     */   public String getLeader()
/*     */   {
/* 388 */     return this.leader;
/*     */   }
/*     */ 
/*     */   public void setLeader(String leader)
/*     */   {
/* 397 */     this.leader = (leader == null ? null : leader.trim());
/*     */   }
/*     */ 
/*     */   public Date getStorageDate()
/*     */   {
/* 406 */     return this.storageDate;
/*     */   }
/*     */ 
/*     */   public void setStorageDate(Date storageDate)
/*     */   {
/* 415 */     this.storageDate = storageDate;
/*     */   }
/*     */ 
/*     */   public Short getCheckStatus()
/*     */   {
/* 424 */     return this.checkStatus;
/*     */   }
/*     */ 
/*     */   public void setCheckStatus(Short checkStatus)
/*     */   {
/* 433 */     this.checkStatus = checkStatus;
/*     */   }
/*     */ 
/*     */   public Long getAssessingPrice()
/*     */   {
/* 442 */     return this.assessingPrice;
/*     */   }
/*     */ 
/*     */   public void setAssessingPrice(Long assessingPrice)
/*     */   {
/* 451 */     this.assessingPrice = assessingPrice;
/*     */   }
/*     */ 
/*     */   public BigDecimal getRatio()
/*     */   {
/* 460 */     return this.ratio;
/*     */   }
/*     */ 
/*     */   public void setRatio(BigDecimal ratio)
/*     */   {
/* 469 */     this.ratio = ratio;
/*     */   }
/*     */ 
/*     */   public String getCheckPerson()
/*     */   {
/* 478 */     return this.checkPerson;
/*     */   }
/*     */ 
/*     */   public void setCheckPerson(String checkPerson)
/*     */   {
/* 487 */     this.checkPerson = (checkPerson == null ? null : checkPerson.trim());
/*     */   }
/*     */ 
/*     */   public Date getCheckDate()
/*     */   {
/* 496 */     return this.checkDate;
/*     */   }
/*     */ 
/*     */   public void setCheckDate(Date checkDate)
/*     */   {
/* 505 */     this.checkDate = checkDate;
/*     */   }
/*     */ 
/*     */   public Short getMerchAck()
/*     */   {
/* 514 */     return this.merchAck;
/*     */   }
/*     */ 
/*     */   public void setMerchAck(Short merchAck)
/*     */   {
/* 523 */     this.merchAck = merchAck;
/*     */   }
/*     */ 
/*     */   public String getMerchAckPerson()
/*     */   {
/* 532 */     return this.merchAckPerson;
/*     */   }
/*     */ 
/*     */   public void setMerchAckPerson(String merchAckPerson)
/*     */   {
/* 541 */     this.merchAckPerson = (merchAckPerson == null ? null : merchAckPerson.trim());
/*     */   }
/*     */ 
/*     */   public Date getMerchAckDate()
/*     */   {
/* 550 */     return this.merchAckDate;
/*     */   }
/*     */ 
/*     */   public void setMerchAckDate(Date merchAckDate)
/*     */   {
/* 559 */     this.merchAckDate = merchAckDate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 568 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 577 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 586 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 595 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public String getMemo()
/*     */   {
/* 604 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo)
/*     */   {
/* 613 */     this.memo = (memo == null ? null : memo.trim());
/*     */   }
/*     */ 
/*     */   public Short getStoreAckChange()
/*     */   {
/* 622 */     return this.storeAckChange;
/*     */   }
/*     */ 
/*     */   public void setStoreAckChange(Short storeAckChange)
/*     */   {
/* 631 */     this.storeAckChange = storeAckChange;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object that)
/*     */   {
/* 639 */     if (this == that) {
/* 640 */       return true;
/*     */     }
/* 642 */     if (that == null) {
/* 643 */       return false;
/*     */     }
/* 645 */     if (getClass() != that.getClass()) {
/* 646 */       return false;
/*     */     }
/* 648 */     FinancWarehouse other = (FinancWarehouse)that;
/* 649 */     return (getId() == null ? other.getId() == null : getId().equals(other.getId())) && (getUserAccountId() == null ? other.getUserAccountId() == null : getUserAccountId().equals(other.getUserAccountId())) && (getDepositoryId() == null ? other.getDepositoryId() == null : getDepositoryId().equals(other.getDepositoryId())) && (getWarehouseNo() == null ? other.getWarehouseNo() == null : getWarehouseNo().equals(other.getWarehouseNo())) && (getCompName() == null ? other.getCompName() == null : getCompName().equals(other.getCompName())) && (getLossStandard() == null ? other.getLossStandard() == null : getLossStandard().equals(other.getLossStandard())) && (getInsuranceNo() == null ? other.getInsuranceNo() == null : getInsuranceNo().equals(other.getInsuranceNo())) && (getInsuranceName() == null ? other.getInsuranceName() == null : getInsuranceName().equals(other.getInsuranceName())) && (getInsuranceAmount() == null ? other.getInsuranceAmount() == null : getInsuranceAmount().equals(other.getInsuranceAmount())) && (getInsuranceDateFrom() == null ? other.getInsuranceDateFrom() == null : getInsuranceDateFrom().equals(other.getInsuranceDateFrom())) && (getInsuranceDateTo() == null ? other.getInsuranceDateTo() == null : getInsuranceDateTo().equals(other.getInsuranceDateTo())) && (getHandlePerson() == null ? other.getHandlePerson() == null : getHandlePerson().equals(other.getHandlePerson())) && (getStorekeeper() == null ? other.getStorekeeper() == null : getStorekeeper().equals(other.getStorekeeper())) && (getLeader() == null ? other.getLeader() == null : getLeader().equals(other.getLeader())) && (getStorageDate() == null ? other.getStorageDate() == null : getStorageDate().equals(other.getStorageDate())) && (getCheckStatus() == null ? other.getCheckStatus() == null : getCheckStatus().equals(other.getCheckStatus())) && (getAssessingPrice() == null ? other.getAssessingPrice() == null : getAssessingPrice().equals(other.getAssessingPrice())) && (getRatio() == null ? other.getRatio() == null : getRatio().equals(other.getRatio())) && (getCheckPerson() == null ? other.getCheckPerson() == null : getCheckPerson().equals(other.getCheckPerson())) && (getCheckDate() == null ? other.getCheckDate() == null : getCheckDate().equals(other.getCheckDate())) && (getMerchAck() == null ? other.getMerchAck() == null : getMerchAck().equals(other.getMerchAck())) && (getMerchAckPerson() == null ? other.getMerchAckPerson() == null : getMerchAckPerson().equals(other.getMerchAckPerson())) && (getMerchAckDate() == null ? other.getMerchAckDate() == null : getMerchAckDate().equals(other.getMerchAckDate())) && (getGmtModify() == null ? other.getGmtModify() == null : getGmtModify().equals(other.getGmtModify())) && (getGmtCreate() == null ? other.getGmtCreate() == null : getGmtCreate().equals(other.getGmtCreate())) && (getMemo() == null ? other.getMemo() == null : getMemo().equals(other.getMemo())) && (getStoreAckChange() == null ? other.getStoreAckChange() == null : getStoreAckChange().equals(other.getStoreAckChange()));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 683 */     int prime = 31;
/* 684 */     int result = 1;
/* 685 */     result = 31 * result + (getId() == null ? 0 : getId().hashCode());
/* 686 */     result = 31 * result + (getUserAccountId() == null ? 0 : getUserAccountId().hashCode());
/* 687 */     result = 31 * result + (getDepositoryId() == null ? 0 : getDepositoryId().hashCode());
/* 688 */     result = 31 * result + (getWarehouseNo() == null ? 0 : getWarehouseNo().hashCode());
/* 689 */     result = 31 * result + (getCompName() == null ? 0 : getCompName().hashCode());
/* 690 */     result = 31 * result + (getLossStandard() == null ? 0 : getLossStandard().hashCode());
/* 691 */     result = 31 * result + (getInsuranceNo() == null ? 0 : getInsuranceNo().hashCode());
/* 692 */     result = 31 * result + (getInsuranceName() == null ? 0 : getInsuranceName().hashCode());
/* 693 */     result = 31 * result + (getInsuranceAmount() == null ? 0 : getInsuranceAmount().hashCode());
/* 694 */     result = 31 * result + (getInsuranceDateFrom() == null ? 0 : getInsuranceDateFrom().hashCode());
/* 695 */     result = 31 * result + (getInsuranceDateTo() == null ? 0 : getInsuranceDateTo().hashCode());
/* 696 */     result = 31 * result + (getHandlePerson() == null ? 0 : getHandlePerson().hashCode());
/* 697 */     result = 31 * result + (getStorekeeper() == null ? 0 : getStorekeeper().hashCode());
/* 698 */     result = 31 * result + (getLeader() == null ? 0 : getLeader().hashCode());
/* 699 */     result = 31 * result + (getStorageDate() == null ? 0 : getStorageDate().hashCode());
/* 700 */     result = 31 * result + (getCheckStatus() == null ? 0 : getCheckStatus().hashCode());
/* 701 */     result = 31 * result + (getAssessingPrice() == null ? 0 : getAssessingPrice().hashCode());
/* 702 */     result = 31 * result + (getRatio() == null ? 0 : getRatio().hashCode());
/* 703 */     result = 31 * result + (getCheckPerson() == null ? 0 : getCheckPerson().hashCode());
/* 704 */     result = 31 * result + (getCheckDate() == null ? 0 : getCheckDate().hashCode());
/* 705 */     result = 31 * result + (getMerchAck() == null ? 0 : getMerchAck().hashCode());
/* 706 */     result = 31 * result + (getMerchAckPerson() == null ? 0 : getMerchAckPerson().hashCode());
/* 707 */     result = 31 * result + (getMerchAckDate() == null ? 0 : getMerchAckDate().hashCode());
/* 708 */     result = 31 * result + (getGmtModify() == null ? 0 : getGmtModify().hashCode());
/* 709 */     result = 31 * result + (getGmtCreate() == null ? 0 : getGmtCreate().hashCode());
/* 710 */     result = 31 * result + (getMemo() == null ? 0 : getMemo().hashCode());
/* 711 */     result = 31 * result + (getStoreAckChange() == null ? 0 : getStoreAckChange().hashCode());
/* 712 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancWarehouse
 * JD-Core Version:    0.6.0
 */