/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancApplication
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private Long orderId;
/*     */   private Long warehouseId;
/*     */   private Long applicantId;
/*     */   private Long loanAccountId;
/*     */   private String businessCode;
/*     */   private String partnerCode;
/*     */   private String agentSubAccount;
/*     */   private String agentName;
/*     */   private String financingNo;
/*     */   private String subAccount;
/*     */   private Short businessTypes;
/*     */   private Short businessModel;
/*     */   private Long depositSubAccountBalance;
/*     */   private Long totalLoanBalance;
/*     */   private BigDecimal financingRatio;
/*     */   private Long loansAmountAvailable;
/*     */   private Long applicationAmount;
/*     */   private Long ownPayMoney;
/*     */   private String applyDateStr;
/*     */   private String customerNo;
/*     */   private String tradingHours;
/*     */   private Short status;
/*     */   private Long totalCumulativeRepayment;
/*     */   private Long totalCumulativeInterest;
/*     */   private Short activitesStatus;
/*     */   private Short recResult;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String creator;
/*     */   private String modifier;
/*     */   private Long collAckComplete;
/*     */   private Long collSerialNo;
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 185 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 194 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getOrderId()
/*     */   {
/* 203 */     return this.orderId;
/*     */   }
/*     */ 
/*     */   public void setOrderId(Long orderId)
/*     */   {
/* 212 */     this.orderId = orderId;
/*     */   }
/*     */ 
/*     */   public Long getWarehouseId()
/*     */   {
/* 221 */     return this.warehouseId;
/*     */   }
/*     */ 
/*     */   public void setWarehouseId(Long warehouseId)
/*     */   {
/* 230 */     this.warehouseId = warehouseId;
/*     */   }
/*     */ 
/*     */   public Long getApplicantId()
/*     */   {
/* 239 */     return this.applicantId;
/*     */   }
/*     */ 
/*     */   public void setApplicantId(Long applicantId)
/*     */   {
/* 248 */     this.applicantId = applicantId;
/*     */   }
/*     */ 
/*     */   public Long getLoanAccountId()
/*     */   {
/* 257 */     return this.loanAccountId;
/*     */   }
/*     */ 
/*     */   public void setLoanAccountId(Long loanAccountId)
/*     */   {
/* 266 */     this.loanAccountId = loanAccountId;
/*     */   }
/*     */ 
/*     */   public String getBusinessCode()
/*     */   {
/* 277 */     return this.businessCode;
/*     */   }
/*     */ 
/*     */   public void setBusinessCode(String businessCode)
/*     */   {
/* 287 */     this.businessCode = (businessCode == null ? null : businessCode.trim());
/*     */   }
/*     */ 
/*     */   public String getPartnerCode()
/*     */   {
/* 296 */     return this.partnerCode;
/*     */   }
/*     */ 
/*     */   public void setPartnerCode(String partnerCode)
/*     */   {
/* 305 */     this.partnerCode = (partnerCode == null ? null : partnerCode.trim());
/*     */   }
/*     */ 
/*     */   public String getAgentSubAccount()
/*     */   {
/* 314 */     return this.agentSubAccount;
/*     */   }
/*     */ 
/*     */   public void setAgentSubAccount(String agentSubAccount)
/*     */   {
/* 323 */     this.agentSubAccount = (agentSubAccount == null ? null : agentSubAccount.trim());
/*     */   }
/*     */ 
/*     */   public String getAgentName()
/*     */   {
/* 332 */     return this.agentName;
/*     */   }
/*     */ 
/*     */   public void setAgentName(String agentName)
/*     */   {
/* 341 */     this.agentName = (agentName == null ? null : agentName.trim());
/*     */   }
/*     */ 
/*     */   public String getFinancingNo()
/*     */   {
/* 350 */     return this.financingNo;
/*     */   }
/*     */ 
/*     */   public void setFinancingNo(String financingNo)
/*     */   {
/* 359 */     this.financingNo = (financingNo == null ? null : financingNo.trim());
/*     */   }
/*     */ 
/*     */   public String getSubAccount()
/*     */   {
/* 368 */     return this.subAccount;
/*     */   }
/*     */ 
/*     */   public void setSubAccount(String subAccount)
/*     */   {
/* 377 */     this.subAccount = (subAccount == null ? null : subAccount.trim());
/*     */   }
/*     */ 
/*     */   public Short getBusinessTypes()
/*     */   {
/* 386 */     return this.businessTypes;
/*     */   }
/*     */ 
/*     */   public void setBusinessTypes(Short businessTypes)
/*     */   {
/* 395 */     this.businessTypes = businessTypes;
/*     */   }
/*     */ 
/*     */   public Short getBusinessModel()
/*     */   {
/* 404 */     return this.businessModel;
/*     */   }
/*     */ 
/*     */   public void setBusinessModel(Short businessModel)
/*     */   {
/* 413 */     this.businessModel = businessModel;
/*     */   }
/*     */ 
/*     */   public Long getDepositSubAccountBalance()
/*     */   {
/* 422 */     return this.depositSubAccountBalance;
/*     */   }
/*     */ 
/*     */   public void setDepositSubAccountBalance(Long depositSubAccountBalance)
/*     */   {
/* 431 */     this.depositSubAccountBalance = depositSubAccountBalance;
/*     */   }
/*     */ 
/*     */   public Long getTotalLoanBalance()
/*     */   {
/* 440 */     return this.totalLoanBalance;
/*     */   }
/*     */ 
/*     */   public void setTotalLoanBalance(Long totalLoanBalance)
/*     */   {
/* 449 */     this.totalLoanBalance = totalLoanBalance;
/*     */   }
/*     */ 
/*     */   public BigDecimal getFinancingRatio()
/*     */   {
/* 458 */     return this.financingRatio;
/*     */   }
/*     */ 
/*     */   public void setFinancingRatio(BigDecimal financingRatio)
/*     */   {
/* 467 */     this.financingRatio = financingRatio;
/*     */   }
/*     */ 
/*     */   public Long getLoansAmountAvailable()
/*     */   {
/* 476 */     return this.loansAmountAvailable;
/*     */   }
/*     */ 
/*     */   public void setLoansAmountAvailable(Long loansAmountAvailable)
/*     */   {
/* 485 */     this.loansAmountAvailable = loansAmountAvailable;
/*     */   }
/*     */ 
/*     */   public Long getApplicationAmount()
/*     */   {
/* 494 */     return this.applicationAmount;
/*     */   }
/*     */ 
/*     */   public void setApplicationAmount(Long applicationAmount)
/*     */   {
/* 503 */     this.applicationAmount = applicationAmount;
/*     */   }
/*     */ 
/*     */   public Long getOwnPayMoney()
/*     */   {
/* 512 */     return this.ownPayMoney;
/*     */   }
/*     */ 
/*     */   public void setOwnPayMoney(Long ownPayMoney)
/*     */   {
/* 521 */     this.ownPayMoney = ownPayMoney;
/*     */   }
/*     */ 
/*     */   public String getApplyDateStr()
/*     */   {
/* 530 */     return this.applyDateStr;
/*     */   }
/*     */ 
/*     */   public void setApplyDateStr(String applyDateStr)
/*     */   {
/* 539 */     this.applyDateStr = (applyDateStr == null ? null : applyDateStr.trim());
/*     */   }
/*     */ 
/*     */   public String getCustomerNo()
/*     */   {
/* 548 */     return this.customerNo;
/*     */   }
/*     */ 
/*     */   public void setCustomerNo(String customerNo)
/*     */   {
/* 557 */     this.customerNo = (customerNo == null ? null : customerNo.trim());
/*     */   }
/*     */ 
/*     */   public String getTradingHours()
/*     */   {
/* 566 */     return this.tradingHours;
/*     */   }
/*     */ 
/*     */   public void setTradingHours(String tradingHours)
/*     */   {
/* 575 */     this.tradingHours = (tradingHours == null ? null : tradingHours.trim());
/*     */   }
/*     */ 
/*     */   public Short getStatus()
/*     */   {
/* 584 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Short status)
/*     */   {
/* 593 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Long getTotalCumulativeRepayment()
/*     */   {
/* 602 */     return this.totalCumulativeRepayment;
/*     */   }
/*     */ 
/*     */   public void setTotalCumulativeRepayment(Long totalCumulativeRepayment)
/*     */   {
/* 611 */     this.totalCumulativeRepayment = totalCumulativeRepayment;
/*     */   }
/*     */ 
/*     */   public Long getTotalCumulativeInterest()
/*     */   {
/* 620 */     return this.totalCumulativeInterest;
/*     */   }
/*     */ 
/*     */   public void setTotalCumulativeInterest(Long totalCumulativeInterest)
/*     */   {
/* 629 */     this.totalCumulativeInterest = totalCumulativeInterest;
/*     */   }
/*     */ 
/*     */   public Short getActivitesStatus()
/*     */   {
/* 638 */     return this.activitesStatus;
/*     */   }
/*     */ 
/*     */   public void setActivitesStatus(Short activitesStatus)
/*     */   {
/* 647 */     this.activitesStatus = activitesStatus;
/*     */   }
/*     */ 
/*     */   public Short getRecResult()
/*     */   {
/* 656 */     return this.recResult;
/*     */   }
/*     */ 
/*     */   public void setRecResult(Short recResult)
/*     */   {
/* 665 */     this.recResult = recResult;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 674 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 683 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 692 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 701 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 710 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 719 */     this.creator = (creator == null ? null : creator.trim());
/*     */   }
/*     */ 
/*     */   public String getModifier()
/*     */   {
/* 728 */     return this.modifier;
/*     */   }
/*     */ 
/*     */   public void setModifier(String modifier)
/*     */   {
/* 737 */     this.modifier = (modifier == null ? null : modifier.trim());
/*     */   }
/*     */ 
/*     */   public Long getCollAckComplete()
/*     */   {
/* 746 */     return this.collAckComplete;
/*     */   }
/*     */ 
/*     */   public void setCollAckComplete(Long collAckComplete)
/*     */   {
/* 755 */     this.collAckComplete = collAckComplete;
/*     */   }
/*     */ 
/*     */   public Long getCollSerialNo()
/*     */   {
/* 764 */     return this.collSerialNo;
/*     */   }
/*     */ 
/*     */   public void setCollSerialNo(Long collSerialNo)
/*     */   {
/* 773 */     this.collSerialNo = collSerialNo;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object that)
/*     */   {
/* 781 */     if (this == that) {
/* 782 */       return true;
/*     */     }
/* 784 */     if (that == null) {
/* 785 */       return false;
/*     */     }
/* 787 */     if (getClass() != that.getClass()) {
/* 788 */       return false;
/*     */     }
/* 790 */     FinancApplication other = (FinancApplication)that;
/* 791 */     return (getId() == null ? other.getId() == null : getId().equals(other.getId())) && (getOrderId() == null ? other.getOrderId() == null : getOrderId().equals(other.getOrderId())) && (getWarehouseId() == null ? other.getWarehouseId() == null : getWarehouseId().equals(other.getWarehouseId())) && (getApplicantId() == null ? other.getApplicantId() == null : getApplicantId().equals(other.getApplicantId())) && (getLoanAccountId() == null ? other.getLoanAccountId() == null : getLoanAccountId().equals(other.getLoanAccountId())) && (getBusinessCode() == null ? other.getBusinessCode() == null : getBusinessCode().equals(other.getBusinessCode())) && (getPartnerCode() == null ? other.getPartnerCode() == null : getPartnerCode().equals(other.getPartnerCode())) && (getAgentSubAccount() == null ? other.getAgentSubAccount() == null : getAgentSubAccount().equals(other.getAgentSubAccount())) && (getAgentName() == null ? other.getAgentName() == null : getAgentName().equals(other.getAgentName())) && (getFinancingNo() == null ? other.getFinancingNo() == null : getFinancingNo().equals(other.getFinancingNo())) && (getSubAccount() == null ? other.getSubAccount() == null : getSubAccount().equals(other.getSubAccount())) && (getBusinessTypes() == null ? other.getBusinessTypes() == null : getBusinessTypes().equals(other.getBusinessTypes())) && (getBusinessModel() == null ? other.getBusinessModel() == null : getBusinessModel().equals(other.getBusinessModel())) && (getDepositSubAccountBalance() == null ? other.getDepositSubAccountBalance() == null : getDepositSubAccountBalance().equals(other.getDepositSubAccountBalance())) && (getTotalLoanBalance() == null ? other.getTotalLoanBalance() == null : getTotalLoanBalance().equals(other.getTotalLoanBalance())) && (getFinancingRatio() == null ? other.getFinancingRatio() == null : getFinancingRatio().equals(other.getFinancingRatio())) && (getLoansAmountAvailable() == null ? other.getLoansAmountAvailable() == null : getLoansAmountAvailable().equals(other.getLoansAmountAvailable())) && (getApplicationAmount() == null ? other.getApplicationAmount() == null : getApplicationAmount().equals(other.getApplicationAmount())) && (getOwnPayMoney() == null ? other.getOwnPayMoney() == null : getOwnPayMoney().equals(other.getOwnPayMoney())) && (getApplyDateStr() == null ? other.getApplyDateStr() == null : getApplyDateStr().equals(other.getApplyDateStr())) && (getCustomerNo() == null ? other.getCustomerNo() == null : getCustomerNo().equals(other.getCustomerNo())) && (getTradingHours() == null ? other.getTradingHours() == null : getTradingHours().equals(other.getTradingHours())) && (getStatus() == null ? other.getStatus() == null : getStatus().equals(other.getStatus())) && (getTotalCumulativeRepayment() == null ? other.getTotalCumulativeRepayment() == null : getTotalCumulativeRepayment().equals(other.getTotalCumulativeRepayment())) && (getTotalCumulativeInterest() == null ? other.getTotalCumulativeInterest() == null : getTotalCumulativeInterest().equals(other.getTotalCumulativeInterest())) && (getActivitesStatus() == null ? other.getActivitesStatus() == null : getActivitesStatus().equals(other.getActivitesStatus())) && (getRecResult() == null ? other.getRecResult() == null : getRecResult().equals(other.getRecResult())) && (getGmtCreate() == null ? other.getGmtCreate() == null : getGmtCreate().equals(other.getGmtCreate())) && (getGmtModify() == null ? other.getGmtModify() == null : getGmtModify().equals(other.getGmtModify())) && (getCreator() == null ? other.getCreator() == null : getCreator().equals(other.getCreator())) && (getModifier() == null ? other.getModifier() == null : getModifier().equals(other.getModifier())) && (getCollAckComplete() == null ? other.getCollAckComplete() == null : getCollAckComplete().equals(other.getCollAckComplete())) && (getCollSerialNo() == null ? other.getCollSerialNo() == null : getCollSerialNo().equals(other.getCollSerialNo()));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 831 */     int prime = 31;
/* 832 */     int result = 1;
/* 833 */     result = 31 * result + (getId() == null ? 0 : getId().hashCode());
/* 834 */     result = 31 * result + (getOrderId() == null ? 0 : getOrderId().hashCode());
/* 835 */     result = 31 * result + (getWarehouseId() == null ? 0 : getWarehouseId().hashCode());
/* 836 */     result = 31 * result + (getApplicantId() == null ? 0 : getApplicantId().hashCode());
/* 837 */     result = 31 * result + (getLoanAccountId() == null ? 0 : getLoanAccountId().hashCode());
/* 838 */     result = 31 * result + (getBusinessCode() == null ? 0 : getBusinessCode().hashCode());
/* 839 */     result = 31 * result + (getPartnerCode() == null ? 0 : getPartnerCode().hashCode());
/* 840 */     result = 31 * result + (getAgentSubAccount() == null ? 0 : getAgentSubAccount().hashCode());
/* 841 */     result = 31 * result + (getAgentName() == null ? 0 : getAgentName().hashCode());
/* 842 */     result = 31 * result + (getFinancingNo() == null ? 0 : getFinancingNo().hashCode());
/* 843 */     result = 31 * result + (getSubAccount() == null ? 0 : getSubAccount().hashCode());
/* 844 */     result = 31 * result + (getBusinessTypes() == null ? 0 : getBusinessTypes().hashCode());
/* 845 */     result = 31 * result + (getBusinessModel() == null ? 0 : getBusinessModel().hashCode());
/* 846 */     result = 31 * result + (getDepositSubAccountBalance() == null ? 0 : getDepositSubAccountBalance().hashCode());
/* 847 */     result = 31 * result + (getTotalLoanBalance() == null ? 0 : getTotalLoanBalance().hashCode());
/* 848 */     result = 31 * result + (getFinancingRatio() == null ? 0 : getFinancingRatio().hashCode());
/* 849 */     result = 31 * result + (getLoansAmountAvailable() == null ? 0 : getLoansAmountAvailable().hashCode());
/* 850 */     result = 31 * result + (getApplicationAmount() == null ? 0 : getApplicationAmount().hashCode());
/* 851 */     result = 31 * result + (getOwnPayMoney() == null ? 0 : getOwnPayMoney().hashCode());
/* 852 */     result = 31 * result + (getApplyDateStr() == null ? 0 : getApplyDateStr().hashCode());
/* 853 */     result = 31 * result + (getCustomerNo() == null ? 0 : getCustomerNo().hashCode());
/* 854 */     result = 31 * result + (getTradingHours() == null ? 0 : getTradingHours().hashCode());
/* 855 */     result = 31 * result + (getStatus() == null ? 0 : getStatus().hashCode());
/* 856 */     result = 31 * result + (getTotalCumulativeRepayment() == null ? 0 : getTotalCumulativeRepayment().hashCode());
/* 857 */     result = 31 * result + (getTotalCumulativeInterest() == null ? 0 : getTotalCumulativeInterest().hashCode());
/* 858 */     result = 31 * result + (getActivitesStatus() == null ? 0 : getActivitesStatus().hashCode());
/* 859 */     result = 31 * result + (getRecResult() == null ? 0 : getRecResult().hashCode());
/* 860 */     result = 31 * result + (getGmtCreate() == null ? 0 : getGmtCreate().hashCode());
/* 861 */     result = 31 * result + (getGmtModify() == null ? 0 : getGmtModify().hashCode());
/* 862 */     result = 31 * result + (getCreator() == null ? 0 : getCreator().hashCode());
/* 863 */     result = 31 * result + (getModifier() == null ? 0 : getModifier().hashCode());
/* 864 */     result = 31 * result + (getCollAckComplete() == null ? 0 : getCollAckComplete().hashCode());
/* 865 */     result = 31 * result + (getCollSerialNo() == null ? 0 : getCollSerialNo().hashCode());
/* 866 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancApplication
 * JD-Core Version:    0.6.0
 */