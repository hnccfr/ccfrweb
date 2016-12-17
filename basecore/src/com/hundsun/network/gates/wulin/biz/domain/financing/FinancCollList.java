/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancCollList
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private Long serialNo;
/*     */   private Long warehouseId;
/*     */   private Long goodsListId;
/*     */   private BigDecimal ratio;
/*     */   private BigDecimal curCollNum;
/*     */   private Long curUnitPrice;
/*     */   private Long curTotalPrice;
/*     */   private Short isValid;
/*     */   private Short merchAck;
/*     */   private String merchAckPerson;
/*     */   private Date merchAckDate;
/*     */   private Short banksAck;
/*     */   private String banksAckPerson;
/*     */   private Date banksAckDate;
/*     */   private Short storeAck;
/*     */   private String storeAckPerson;
/*     */   private Date storeAckDate;
/*     */   private Short reguAck;
/*     */   private String reguAckPerson;
/*     */   private Date reguAckDate;
/*     */   private Short platAck;
/*     */   private String platAckPerson;
/*     */   private Date platAckDate;
/*     */   private Date gmtModify;
/*     */   private Date gmtCreate;
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 149 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 158 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getSerialNo()
/*     */   {
/* 167 */     return this.serialNo;
/*     */   }
/*     */ 
/*     */   public void setSerialNo(Long serialNo)
/*     */   {
/* 176 */     this.serialNo = serialNo;
/*     */   }
/*     */ 
/*     */   public Long getWarehouseId()
/*     */   {
/* 185 */     return this.warehouseId;
/*     */   }
/*     */ 
/*     */   public void setWarehouseId(Long warehouseId)
/*     */   {
/* 194 */     this.warehouseId = warehouseId;
/*     */   }
/*     */ 
/*     */   public Long getGoodsListId()
/*     */   {
/* 203 */     return this.goodsListId;
/*     */   }
/*     */ 
/*     */   public void setGoodsListId(Long goodsListId)
/*     */   {
/* 212 */     this.goodsListId = goodsListId;
/*     */   }
/*     */ 
/*     */   public BigDecimal getRatio()
/*     */   {
/* 221 */     return this.ratio;
/*     */   }
/*     */ 
/*     */   public void setRatio(BigDecimal ratio)
/*     */   {
/* 230 */     this.ratio = ratio;
/*     */   }
/*     */ 
/*     */   public BigDecimal getCurCollNum()
/*     */   {
/* 239 */     return this.curCollNum;
/*     */   }
/*     */ 
/*     */   public void setCurCollNum(BigDecimal curCollNum)
/*     */   {
/* 248 */     this.curCollNum = curCollNum;
/*     */   }
/*     */ 
/*     */   public Long getCurUnitPrice()
/*     */   {
/* 257 */     return this.curUnitPrice;
/*     */   }
/*     */ 
/*     */   public void setCurUnitPrice(Long curUnitPrice)
/*     */   {
/* 266 */     this.curUnitPrice = curUnitPrice;
/*     */   }
/*     */ 
/*     */   public Long getCurTotalPrice()
/*     */   {
/* 275 */     return this.curTotalPrice;
/*     */   }
/*     */ 
/*     */   public void setCurTotalPrice(Long curTotalPrice)
/*     */   {
/* 284 */     this.curTotalPrice = curTotalPrice;
/*     */   }
/*     */ 
/*     */   public Short getIsValid()
/*     */   {
/* 293 */     return this.isValid;
/*     */   }
/*     */ 
/*     */   public void setIsValid(Short isValid)
/*     */   {
/* 302 */     this.isValid = isValid;
/*     */   }
/*     */ 
/*     */   public Short getMerchAck()
/*     */   {
/* 311 */     return this.merchAck;
/*     */   }
/*     */ 
/*     */   public void setMerchAck(Short merchAck)
/*     */   {
/* 320 */     this.merchAck = merchAck;
/*     */   }
/*     */ 
/*     */   public String getMerchAckPerson()
/*     */   {
/* 329 */     return this.merchAckPerson;
/*     */   }
/*     */ 
/*     */   public void setMerchAckPerson(String merchAckPerson)
/*     */   {
/* 338 */     this.merchAckPerson = (merchAckPerson == null ? null : merchAckPerson.trim());
/*     */   }
/*     */ 
/*     */   public Date getMerchAckDate()
/*     */   {
/* 347 */     return this.merchAckDate;
/*     */   }
/*     */ 
/*     */   public void setMerchAckDate(Date merchAckDate)
/*     */   {
/* 356 */     this.merchAckDate = merchAckDate;
/*     */   }
/*     */ 
/*     */   public Short getBanksAck()
/*     */   {
/* 365 */     return this.banksAck;
/*     */   }
/*     */ 
/*     */   public void setBanksAck(Short banksAck)
/*     */   {
/* 374 */     this.banksAck = banksAck;
/*     */   }
/*     */ 
/*     */   public String getBanksAckPerson()
/*     */   {
/* 383 */     return this.banksAckPerson;
/*     */   }
/*     */ 
/*     */   public void setBanksAckPerson(String banksAckPerson)
/*     */   {
/* 392 */     this.banksAckPerson = (banksAckPerson == null ? null : banksAckPerson.trim());
/*     */   }
/*     */ 
/*     */   public Date getBanksAckDate()
/*     */   {
/* 401 */     return this.banksAckDate;
/*     */   }
/*     */ 
/*     */   public void setBanksAckDate(Date banksAckDate)
/*     */   {
/* 410 */     this.banksAckDate = banksAckDate;
/*     */   }
/*     */ 
/*     */   public Short getStoreAck()
/*     */   {
/* 419 */     return this.storeAck;
/*     */   }
/*     */ 
/*     */   public void setStoreAck(Short storeAck)
/*     */   {
/* 428 */     this.storeAck = storeAck;
/*     */   }
/*     */ 
/*     */   public String getStoreAckPerson()
/*     */   {
/* 437 */     return this.storeAckPerson;
/*     */   }
/*     */ 
/*     */   public void setStoreAckPerson(String storeAckPerson)
/*     */   {
/* 446 */     this.storeAckPerson = (storeAckPerson == null ? null : storeAckPerson.trim());
/*     */   }
/*     */ 
/*     */   public Date getStoreAckDate()
/*     */   {
/* 455 */     return this.storeAckDate;
/*     */   }
/*     */ 
/*     */   public void setStoreAckDate(Date storeAckDate)
/*     */   {
/* 464 */     this.storeAckDate = storeAckDate;
/*     */   }
/*     */ 
/*     */   public Short getReguAck()
/*     */   {
/* 473 */     return this.reguAck;
/*     */   }
/*     */ 
/*     */   public void setReguAck(Short reguAck)
/*     */   {
/* 482 */     this.reguAck = reguAck;
/*     */   }
/*     */ 
/*     */   public String getReguAckPerson()
/*     */   {
/* 491 */     return this.reguAckPerson;
/*     */   }
/*     */ 
/*     */   public void setReguAckPerson(String reguAckPerson)
/*     */   {
/* 500 */     this.reguAckPerson = (reguAckPerson == null ? null : reguAckPerson.trim());
/*     */   }
/*     */ 
/*     */   public Date getReguAckDate()
/*     */   {
/* 509 */     return this.reguAckDate;
/*     */   }
/*     */ 
/*     */   public void setReguAckDate(Date reguAckDate)
/*     */   {
/* 518 */     this.reguAckDate = reguAckDate;
/*     */   }
/*     */ 
/*     */   public Short getPlatAck()
/*     */   {
/* 527 */     return this.platAck;
/*     */   }
/*     */ 
/*     */   public void setPlatAck(Short platAck)
/*     */   {
/* 536 */     this.platAck = platAck;
/*     */   }
/*     */ 
/*     */   public String getPlatAckPerson()
/*     */   {
/* 545 */     return this.platAckPerson;
/*     */   }
/*     */ 
/*     */   public void setPlatAckPerson(String platAckPerson)
/*     */   {
/* 554 */     this.platAckPerson = (platAckPerson == null ? null : platAckPerson.trim());
/*     */   }
/*     */ 
/*     */   public Date getPlatAckDate()
/*     */   {
/* 563 */     return this.platAckDate;
/*     */   }
/*     */ 
/*     */   public void setPlatAckDate(Date platAckDate)
/*     */   {
/* 572 */     this.platAckDate = platAckDate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 581 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 590 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 599 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 608 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object that)
/*     */   {
/* 616 */     if (this == that) {
/* 617 */       return true;
/*     */     }
/* 619 */     if (that == null) {
/* 620 */       return false;
/*     */     }
/* 622 */     if (getClass() != that.getClass()) {
/* 623 */       return false;
/*     */     }
/* 625 */     FinancCollList other = (FinancCollList)that;
/* 626 */     return (getId() == null ? other.getId() == null : getId().equals(other.getId())) && (getSerialNo() == null ? other.getSerialNo() == null : getSerialNo().equals(other.getSerialNo())) && (getWarehouseId() == null ? other.getWarehouseId() == null : getWarehouseId().equals(other.getWarehouseId())) && (getGoodsListId() == null ? other.getGoodsListId() == null : getGoodsListId().equals(other.getGoodsListId())) && (getRatio() == null ? other.getRatio() == null : getRatio().equals(other.getRatio())) && (getCurCollNum() == null ? other.getCurCollNum() == null : getCurCollNum().equals(other.getCurCollNum())) && (getCurUnitPrice() == null ? other.getCurUnitPrice() == null : getCurUnitPrice().equals(other.getCurUnitPrice())) && (getCurTotalPrice() == null ? other.getCurTotalPrice() == null : getCurTotalPrice().equals(other.getCurTotalPrice())) && (getIsValid() == null ? other.getIsValid() == null : getIsValid().equals(other.getIsValid())) && (getMerchAck() == null ? other.getMerchAck() == null : getMerchAck().equals(other.getMerchAck())) && (getMerchAckPerson() == null ? other.getMerchAckPerson() == null : getMerchAckPerson().equals(other.getMerchAckPerson())) && (getMerchAckDate() == null ? other.getMerchAckDate() == null : getMerchAckDate().equals(other.getMerchAckDate())) && (getBanksAck() == null ? other.getBanksAck() == null : getBanksAck().equals(other.getBanksAck())) && (getBanksAckPerson() == null ? other.getBanksAckPerson() == null : getBanksAckPerson().equals(other.getBanksAckPerson())) && (getBanksAckDate() == null ? other.getBanksAckDate() == null : getBanksAckDate().equals(other.getBanksAckDate())) && (getStoreAck() == null ? other.getStoreAck() == null : getStoreAck().equals(other.getStoreAck())) && (getStoreAckPerson() == null ? other.getStoreAckPerson() == null : getStoreAckPerson().equals(other.getStoreAckPerson())) && (getStoreAckDate() == null ? other.getStoreAckDate() == null : getStoreAckDate().equals(other.getStoreAckDate())) && (getReguAck() == null ? other.getReguAck() == null : getReguAck().equals(other.getReguAck())) && (getReguAckPerson() == null ? other.getReguAckPerson() == null : getReguAckPerson().equals(other.getReguAckPerson())) && (getReguAckDate() == null ? other.getReguAckDate() == null : getReguAckDate().equals(other.getReguAckDate())) && (getPlatAck() == null ? other.getPlatAck() == null : getPlatAck().equals(other.getPlatAck())) && (getPlatAckPerson() == null ? other.getPlatAckPerson() == null : getPlatAckPerson().equals(other.getPlatAckPerson())) && (getPlatAckDate() == null ? other.getPlatAckDate() == null : getPlatAckDate().equals(other.getPlatAckDate())) && (getGmtModify() == null ? other.getGmtModify() == null : getGmtModify().equals(other.getGmtModify())) && (getGmtCreate() == null ? other.getGmtCreate() == null : getGmtCreate().equals(other.getGmtCreate()));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 659 */     int prime = 31;
/* 660 */     int result = 1;
/* 661 */     result = 31 * result + (getId() == null ? 0 : getId().hashCode());
/* 662 */     result = 31 * result + (getSerialNo() == null ? 0 : getSerialNo().hashCode());
/* 663 */     result = 31 * result + (getWarehouseId() == null ? 0 : getWarehouseId().hashCode());
/* 664 */     result = 31 * result + (getGoodsListId() == null ? 0 : getGoodsListId().hashCode());
/* 665 */     result = 31 * result + (getRatio() == null ? 0 : getRatio().hashCode());
/* 666 */     result = 31 * result + (getCurCollNum() == null ? 0 : getCurCollNum().hashCode());
/* 667 */     result = 31 * result + (getCurUnitPrice() == null ? 0 : getCurUnitPrice().hashCode());
/* 668 */     result = 31 * result + (getCurTotalPrice() == null ? 0 : getCurTotalPrice().hashCode());
/* 669 */     result = 31 * result + (getIsValid() == null ? 0 : getIsValid().hashCode());
/* 670 */     result = 31 * result + (getMerchAck() == null ? 0 : getMerchAck().hashCode());
/* 671 */     result = 31 * result + (getMerchAckPerson() == null ? 0 : getMerchAckPerson().hashCode());
/* 672 */     result = 31 * result + (getMerchAckDate() == null ? 0 : getMerchAckDate().hashCode());
/* 673 */     result = 31 * result + (getBanksAck() == null ? 0 : getBanksAck().hashCode());
/* 674 */     result = 31 * result + (getBanksAckPerson() == null ? 0 : getBanksAckPerson().hashCode());
/* 675 */     result = 31 * result + (getBanksAckDate() == null ? 0 : getBanksAckDate().hashCode());
/* 676 */     result = 31 * result + (getStoreAck() == null ? 0 : getStoreAck().hashCode());
/* 677 */     result = 31 * result + (getStoreAckPerson() == null ? 0 : getStoreAckPerson().hashCode());
/* 678 */     result = 31 * result + (getStoreAckDate() == null ? 0 : getStoreAckDate().hashCode());
/* 679 */     result = 31 * result + (getReguAck() == null ? 0 : getReguAck().hashCode());
/* 680 */     result = 31 * result + (getReguAckPerson() == null ? 0 : getReguAckPerson().hashCode());
/* 681 */     result = 31 * result + (getReguAckDate() == null ? 0 : getReguAckDate().hashCode());
/* 682 */     result = 31 * result + (getPlatAck() == null ? 0 : getPlatAck().hashCode());
/* 683 */     result = 31 * result + (getPlatAckPerson() == null ? 0 : getPlatAckPerson().hashCode());
/* 684 */     result = 31 * result + (getPlatAckDate() == null ? 0 : getPlatAckDate().hashCode());
/* 685 */     result = 31 * result + (getGmtModify() == null ? 0 : getGmtModify().hashCode());
/* 686 */     result = 31 * result + (getGmtCreate() == null ? 0 : getGmtCreate().hashCode());
/* 687 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancCollList
 * JD-Core Version:    0.6.0
 */