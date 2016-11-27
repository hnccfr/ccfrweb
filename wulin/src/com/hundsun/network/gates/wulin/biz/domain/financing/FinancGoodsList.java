/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancGoodsList
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private Long warehouseId;
/*     */   private Long goodsId;
/*     */   private String goodsName;
/*     */   private String goodsSpec;
/*     */   private String goodsUnits;
/*     */   private BigDecimal oriQuantity;
/*     */   private BigDecimal remainQuantity;
/*     */   private Long oriPrice;
/*     */   private Long oriTotalPrice;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String memo;
/*     */   private BigDecimal frozenQuantity;
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  89 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  98 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getWarehouseId()
/*     */   {
/* 107 */     return this.warehouseId;
/*     */   }
/*     */ 
/*     */   public void setWarehouseId(Long warehouseId)
/*     */   {
/* 116 */     this.warehouseId = warehouseId;
/*     */   }
/*     */ 
/*     */   public Long getGoodsId()
/*     */   {
/* 125 */     return this.goodsId;
/*     */   }
/*     */ 
/*     */   public void setGoodsId(Long goodsId)
/*     */   {
/* 134 */     this.goodsId = goodsId;
/*     */   }
/*     */ 
/*     */   public String getGoodsName()
/*     */   {
/* 143 */     return this.goodsName;
/*     */   }
/*     */ 
/*     */   public void setGoodsName(String goodsName)
/*     */   {
/* 152 */     this.goodsName = (goodsName == null ? null : goodsName.trim());
/*     */   }
/*     */ 
/*     */   public String getGoodsSpec()
/*     */   {
/* 161 */     return this.goodsSpec;
/*     */   }
/*     */ 
/*     */   public void setGoodsSpec(String goodsSpec)
/*     */   {
/* 170 */     this.goodsSpec = (goodsSpec == null ? null : goodsSpec.trim());
/*     */   }
/*     */ 
/*     */   public String getGoodsUnits()
/*     */   {
/* 179 */     return this.goodsUnits;
/*     */   }
/*     */ 
/*     */   public void setGoodsUnits(String goodsUnits)
/*     */   {
/* 188 */     this.goodsUnits = (goodsUnits == null ? null : goodsUnits.trim());
/*     */   }
/*     */ 
/*     */   public BigDecimal getOriQuantity()
/*     */   {
/* 197 */     return this.oriQuantity;
/*     */   }
/*     */ 
/*     */   public void setOriQuantity(BigDecimal oriQuantity)
/*     */   {
/* 206 */     this.oriQuantity = oriQuantity;
/*     */   }
/*     */ 
/*     */   public BigDecimal getRemainQuantity()
/*     */   {
/* 215 */     return this.remainQuantity;
/*     */   }
/*     */ 
/*     */   public void setRemainQuantity(BigDecimal remainQuantity)
/*     */   {
/* 224 */     this.remainQuantity = remainQuantity;
/*     */   }
/*     */ 
/*     */   public Long getOriPrice()
/*     */   {
/* 233 */     return this.oriPrice;
/*     */   }
/*     */ 
/*     */   public void setOriPrice(Long oriPrice)
/*     */   {
/* 242 */     this.oriPrice = oriPrice;
/*     */   }
/*     */ 
/*     */   public Long getOriTotalPrice()
/*     */   {
/* 251 */     return this.oriTotalPrice;
/*     */   }
/*     */ 
/*     */   public void setOriTotalPrice(Long oriTotalPrice)
/*     */   {
/* 260 */     this.oriTotalPrice = oriTotalPrice;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 269 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 278 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 287 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 296 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getMemo()
/*     */   {
/* 305 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo)
/*     */   {
/* 314 */     this.memo = (memo == null ? null : memo.trim());
/*     */   }
/*     */ 
/*     */   public BigDecimal getFrozenQuantity()
/*     */   {
/* 323 */     return this.frozenQuantity;
/*     */   }
/*     */ 
/*     */   public void setFrozenQuantity(BigDecimal frozenQuantity)
/*     */   {
/* 332 */     this.frozenQuantity = frozenQuantity;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object that)
/*     */   {
/* 340 */     if (this == that) {
/* 341 */       return true;
/*     */     }
/* 343 */     if (that == null) {
/* 344 */       return false;
/*     */     }
/* 346 */     if (getClass() != that.getClass()) {
/* 347 */       return false;
/*     */     }
/* 349 */     FinancGoodsList other = (FinancGoodsList)that;
/* 350 */     return (getId() == null ? other.getId() == null : getId().equals(other.getId())) && (getWarehouseId() == null ? other.getWarehouseId() == null : getWarehouseId().equals(other.getWarehouseId())) && (getGoodsId() == null ? other.getGoodsId() == null : getGoodsId().equals(other.getGoodsId())) && (getGoodsName() == null ? other.getGoodsName() == null : getGoodsName().equals(other.getGoodsName())) && (getGoodsSpec() == null ? other.getGoodsSpec() == null : getGoodsSpec().equals(other.getGoodsSpec())) && (getGoodsUnits() == null ? other.getGoodsUnits() == null : getGoodsUnits().equals(other.getGoodsUnits())) && (getOriQuantity() == null ? other.getOriQuantity() == null : getOriQuantity().equals(other.getOriQuantity())) && (getRemainQuantity() == null ? other.getRemainQuantity() == null : getRemainQuantity().equals(other.getRemainQuantity())) && (getOriPrice() == null ? other.getOriPrice() == null : getOriPrice().equals(other.getOriPrice())) && (getOriTotalPrice() == null ? other.getOriTotalPrice() == null : getOriTotalPrice().equals(other.getOriTotalPrice())) && (getGmtCreate() == null ? other.getGmtCreate() == null : getGmtCreate().equals(other.getGmtCreate())) && (getGmtModify() == null ? other.getGmtModify() == null : getGmtModify().equals(other.getGmtModify())) && (getMemo() == null ? other.getMemo() == null : getMemo().equals(other.getMemo())) && (getFrozenQuantity() == null ? other.getFrozenQuantity() == null : getFrozenQuantity().equals(other.getFrozenQuantity()));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 371 */     int prime = 31;
/* 372 */     int result = 1;
/* 373 */     result = 31 * result + (getId() == null ? 0 : getId().hashCode());
/* 374 */     result = 31 * result + (getWarehouseId() == null ? 0 : getWarehouseId().hashCode());
/* 375 */     result = 31 * result + (getGoodsId() == null ? 0 : getGoodsId().hashCode());
/* 376 */     result = 31 * result + (getGoodsName() == null ? 0 : getGoodsName().hashCode());
/* 377 */     result = 31 * result + (getGoodsSpec() == null ? 0 : getGoodsSpec().hashCode());
/* 378 */     result = 31 * result + (getGoodsUnits() == null ? 0 : getGoodsUnits().hashCode());
/* 379 */     result = 31 * result + (getOriQuantity() == null ? 0 : getOriQuantity().hashCode());
/* 380 */     result = 31 * result + (getRemainQuantity() == null ? 0 : getRemainQuantity().hashCode());
/* 381 */     result = 31 * result + (getOriPrice() == null ? 0 : getOriPrice().hashCode());
/* 382 */     result = 31 * result + (getOriTotalPrice() == null ? 0 : getOriTotalPrice().hashCode());
/* 383 */     result = 31 * result + (getGmtCreate() == null ? 0 : getGmtCreate().hashCode());
/* 384 */     result = 31 * result + (getGmtModify() == null ? 0 : getGmtModify().hashCode());
/* 385 */     result = 31 * result + (getMemo() == null ? 0 : getMemo().hashCode());
/* 386 */     result = 31 * result + (getFrozenQuantity() == null ? 0 : getFrozenQuantity().hashCode());
/* 387 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoodsList
 * JD-Core Version:    0.6.0
 */