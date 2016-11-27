/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancTransferForm
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private Long buyerAccountId;
/*     */   private Long sellerAccountId;
/*     */   private Long orderId;
/*     */   private Long financApplicationId;
/*     */   private Long warehouseId;
/*     */   private Long goodsId;
/*     */   private BigDecimal quantity;
/*     */   private Long price;
/*     */   private Long totalPrice;
/*     */   private Short dealStatus;
/*     */   private String dealPerson;
/*     */   private Date dealDate;
/*     */   private String creator;
/*     */   private String modifier;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 104 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 113 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getBuyerAccountId()
/*     */   {
/* 122 */     return this.buyerAccountId;
/*     */   }
/*     */ 
/*     */   public void setBuyerAccountId(Long buyerAccountId)
/*     */   {
/* 131 */     this.buyerAccountId = buyerAccountId;
/*     */   }
/*     */ 
/*     */   public Long getSellerAccountId()
/*     */   {
/* 140 */     return this.sellerAccountId;
/*     */   }
/*     */ 
/*     */   public void setSellerAccountId(Long sellerAccountId)
/*     */   {
/* 149 */     this.sellerAccountId = sellerAccountId;
/*     */   }
/*     */ 
/*     */   public Long getOrderId()
/*     */   {
/* 158 */     return this.orderId;
/*     */   }
/*     */ 
/*     */   public void setOrderId(Long orderId)
/*     */   {
/* 167 */     this.orderId = orderId;
/*     */   }
/*     */ 
/*     */   public Long getFinancApplicationId()
/*     */   {
/* 176 */     return this.financApplicationId;
/*     */   }
/*     */ 
/*     */   public void setFinancApplicationId(Long financApplicationId)
/*     */   {
/* 185 */     this.financApplicationId = financApplicationId;
/*     */   }
/*     */ 
/*     */   public Long getWarehouseId()
/*     */   {
/* 194 */     return this.warehouseId;
/*     */   }
/*     */ 
/*     */   public void setWarehouseId(Long warehouseId)
/*     */   {
/* 203 */     this.warehouseId = warehouseId;
/*     */   }
/*     */ 
/*     */   public Long getGoodsId()
/*     */   {
/* 212 */     return this.goodsId;
/*     */   }
/*     */ 
/*     */   public void setGoodsId(Long goodsId)
/*     */   {
/* 221 */     this.goodsId = goodsId;
/*     */   }
/*     */ 
/*     */   public BigDecimal getQuantity()
/*     */   {
/* 230 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(BigDecimal quantity)
/*     */   {
/* 239 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public Long getPrice()
/*     */   {
/* 248 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price)
/*     */   {
/* 257 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public Long getTotalPrice()
/*     */   {
/* 266 */     return this.totalPrice;
/*     */   }
/*     */ 
/*     */   public void setTotalPrice(Long totalPrice)
/*     */   {
/* 275 */     this.totalPrice = totalPrice;
/*     */   }
/*     */ 
/*     */   public Short getDealStatus()
/*     */   {
/* 284 */     return this.dealStatus;
/*     */   }
/*     */ 
/*     */   public void setDealStatus(Short dealStatus)
/*     */   {
/* 293 */     this.dealStatus = dealStatus;
/*     */   }
/*     */ 
/*     */   public String getDealPerson()
/*     */   {
/* 302 */     return this.dealPerson;
/*     */   }
/*     */ 
/*     */   public void setDealPerson(String dealPerson)
/*     */   {
/* 311 */     this.dealPerson = (dealPerson == null ? null : dealPerson.trim());
/*     */   }
/*     */ 
/*     */   public Date getDealDate()
/*     */   {
/* 320 */     return this.dealDate;
/*     */   }
/*     */ 
/*     */   public void setDealDate(Date dealDate)
/*     */   {
/* 329 */     this.dealDate = dealDate;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 338 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 347 */     this.creator = (creator == null ? null : creator.trim());
/*     */   }
/*     */ 
/*     */   public String getModifier()
/*     */   {
/* 356 */     return this.modifier;
/*     */   }
/*     */ 
/*     */   public void setModifier(String modifier)
/*     */   {
/* 365 */     this.modifier = (modifier == null ? null : modifier.trim());
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 374 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 383 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 392 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 401 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object that)
/*     */   {
/* 409 */     if (this == that) {
/* 410 */       return true;
/*     */     }
/* 412 */     if (that == null) {
/* 413 */       return false;
/*     */     }
/* 415 */     if (getClass() != that.getClass()) {
/* 416 */       return false;
/*     */     }
/* 418 */     FinancTransferForm other = (FinancTransferForm)that;
/* 419 */     return (getId() == null ? other.getId() == null : getId().equals(other.getId())) && (getBuyerAccountId() == null ? other.getBuyerAccountId() == null : getBuyerAccountId().equals(other.getBuyerAccountId())) && (getSellerAccountId() == null ? other.getSellerAccountId() == null : getSellerAccountId().equals(other.getSellerAccountId())) && (getOrderId() == null ? other.getOrderId() == null : getOrderId().equals(other.getOrderId())) && (getFinancApplicationId() == null ? other.getFinancApplicationId() == null : getFinancApplicationId().equals(other.getFinancApplicationId())) && (getWarehouseId() == null ? other.getWarehouseId() == null : getWarehouseId().equals(other.getWarehouseId())) && (getGoodsId() == null ? other.getGoodsId() == null : getGoodsId().equals(other.getGoodsId())) && (getQuantity() == null ? other.getQuantity() == null : getQuantity().equals(other.getQuantity())) && (getPrice() == null ? other.getPrice() == null : getPrice().equals(other.getPrice())) && (getTotalPrice() == null ? other.getTotalPrice() == null : getTotalPrice().equals(other.getTotalPrice())) && (getDealStatus() == null ? other.getDealStatus() == null : getDealStatus().equals(other.getDealStatus())) && (getDealPerson() == null ? other.getDealPerson() == null : getDealPerson().equals(other.getDealPerson())) && (getDealDate() == null ? other.getDealDate() == null : getDealDate().equals(other.getDealDate())) && (getCreator() == null ? other.getCreator() == null : getCreator().equals(other.getCreator())) && (getModifier() == null ? other.getModifier() == null : getModifier().equals(other.getModifier())) && (getGmtCreate() == null ? other.getGmtCreate() == null : getGmtCreate().equals(other.getGmtCreate())) && (getGmtModify() == null ? other.getGmtModify() == null : getGmtModify().equals(other.getGmtModify()));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 443 */     int prime = 31;
/* 444 */     int result = 1;
/* 445 */     result = 31 * result + (getId() == null ? 0 : getId().hashCode());
/* 446 */     result = 31 * result + (getBuyerAccountId() == null ? 0 : getBuyerAccountId().hashCode());
/* 447 */     result = 31 * result + (getSellerAccountId() == null ? 0 : getSellerAccountId().hashCode());
/* 448 */     result = 31 * result + (getOrderId() == null ? 0 : getOrderId().hashCode());
/* 449 */     result = 31 * result + (getFinancApplicationId() == null ? 0 : getFinancApplicationId().hashCode());
/* 450 */     result = 31 * result + (getWarehouseId() == null ? 0 : getWarehouseId().hashCode());
/* 451 */     result = 31 * result + (getGoodsId() == null ? 0 : getGoodsId().hashCode());
/* 452 */     result = 31 * result + (getQuantity() == null ? 0 : getQuantity().hashCode());
/* 453 */     result = 31 * result + (getPrice() == null ? 0 : getPrice().hashCode());
/* 454 */     result = 31 * result + (getTotalPrice() == null ? 0 : getTotalPrice().hashCode());
/* 455 */     result = 31 * result + (getDealStatus() == null ? 0 : getDealStatus().hashCode());
/* 456 */     result = 31 * result + (getDealPerson() == null ? 0 : getDealPerson().hashCode());
/* 457 */     result = 31 * result + (getDealDate() == null ? 0 : getDealDate().hashCode());
/* 458 */     result = 31 * result + (getCreator() == null ? 0 : getCreator().hashCode());
/* 459 */     result = 31 * result + (getModifier() == null ? 0 : getModifier().hashCode());
/* 460 */     result = 31 * result + (getGmtCreate() == null ? 0 : getGmtCreate().hashCode());
/* 461 */     result = 31 * result + (getGmtModify() == null ? 0 : getGmtModify().hashCode());
/* 462 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancTransferForm
 * JD-Core Version:    0.6.0
 */