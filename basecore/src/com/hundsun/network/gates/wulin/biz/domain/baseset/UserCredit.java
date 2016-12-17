/*     */ package com.hundsun.network.gates.wulin.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserCredit extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -2522842565501625007L;
/*     */   private Long id;
/*     */   private String userAccount;
/*     */   private String sellerCreditLevel;
/*     */   private Long sellerCreditNum;
/*     */   private Long sellerGoodNum;
/*     */   private Long sellerMiddNum;
/*     */   private Long sellerBadNum;
/*     */   private BigDecimal serviceAttitude;
/*     */   private BigDecimal logisticsSpeed;
/*     */   private String buyCreditLevel;
/*     */   private Long buyCreditNum;
/*     */   private Long buyGoodNum;
/*     */   private Long buyMiddNum;
/*     */   private Long buyBadNum;
/*     */   private String creator;
/*     */   private String modifier;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 163 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 175 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/* 187 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 199 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getSellerCreditLevel()
/*     */   {
/* 211 */     return this.sellerCreditLevel;
/*     */   }
/*     */ 
/*     */   public void setSellerCreditLevel(String sellerCreditLevel)
/*     */   {
/* 223 */     this.sellerCreditLevel = sellerCreditLevel;
/*     */   }
/*     */ 
/*     */   public Long getSellerCreditNum()
/*     */   {
/* 235 */     return this.sellerCreditNum;
/*     */   }
/*     */ 
/*     */   public void setSellerCreditNum(Long sellerCreditNum)
/*     */   {
/* 247 */     this.sellerCreditNum = sellerCreditNum;
/*     */   }
/*     */ 
/*     */   public Long getSellerGoodNum()
/*     */   {
/* 259 */     return this.sellerGoodNum;
/*     */   }
/*     */ 
/*     */   public void setSellerGoodNum(Long sellerGoodNum)
/*     */   {
/* 271 */     this.sellerGoodNum = sellerGoodNum;
/*     */   }
/*     */ 
/*     */   public Long getSellerMiddNum()
/*     */   {
/* 283 */     return this.sellerMiddNum;
/*     */   }
/*     */ 
/*     */   public void setSellerMiddNum(Long sellerMiddNum)
/*     */   {
/* 295 */     this.sellerMiddNum = sellerMiddNum;
/*     */   }
/*     */ 
/*     */   public Long getSellerBadNum()
/*     */   {
/* 307 */     return this.sellerBadNum;
/*     */   }
/*     */ 
/*     */   public void setSellerBadNum(Long sellerBadNum)
/*     */   {
/* 319 */     this.sellerBadNum = sellerBadNum;
/*     */   }
/*     */ 
/*     */   public BigDecimal getServiceAttitude()
/*     */   {
/* 331 */     return this.serviceAttitude;
/*     */   }
/*     */ 
/*     */   public void setServiceAttitude(BigDecimal serviceAttitude)
/*     */   {
/* 343 */     this.serviceAttitude = serviceAttitude;
/*     */   }
/*     */ 
/*     */   public BigDecimal getLogisticsSpeed()
/*     */   {
/* 355 */     return this.logisticsSpeed;
/*     */   }
/*     */ 
/*     */   public void setLogisticsSpeed(BigDecimal logisticsSpeed)
/*     */   {
/* 367 */     this.logisticsSpeed = logisticsSpeed;
/*     */   }
/*     */ 
/*     */   public String getBuyCreditLevel()
/*     */   {
/* 379 */     return this.buyCreditLevel;
/*     */   }
/*     */ 
/*     */   public void setBuyCreditLevel(String buyCreditLevel)
/*     */   {
/* 391 */     this.buyCreditLevel = buyCreditLevel;
/*     */   }
/*     */ 
/*     */   public Long getBuyCreditNum()
/*     */   {
/* 403 */     return this.buyCreditNum;
/*     */   }
/*     */ 
/*     */   public void setBuyCreditNum(Long buyCreditNum)
/*     */   {
/* 415 */     this.buyCreditNum = buyCreditNum;
/*     */   }
/*     */ 
/*     */   public Long getBuyGoodNum()
/*     */   {
/* 427 */     return this.buyGoodNum;
/*     */   }
/*     */ 
/*     */   public void setBuyGoodNum(Long buyGoodNum)
/*     */   {
/* 439 */     this.buyGoodNum = buyGoodNum;
/*     */   }
/*     */ 
/*     */   public Long getBuyMiddNum()
/*     */   {
/* 451 */     return this.buyMiddNum;
/*     */   }
/*     */ 
/*     */   public void setBuyMiddNum(Long buyMiddNum)
/*     */   {
/* 463 */     this.buyMiddNum = buyMiddNum;
/*     */   }
/*     */ 
/*     */   public Long getBuyBadNum()
/*     */   {
/* 475 */     return this.buyBadNum;
/*     */   }
/*     */ 
/*     */   public void setBuyBadNum(Long buyBadNum)
/*     */   {
/* 487 */     this.buyBadNum = buyBadNum;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 499 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 511 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getModifier()
/*     */   {
/* 523 */     return this.modifier;
/*     */   }
/*     */ 
/*     */   public void setModifier(String modifier)
/*     */   {
/* 535 */     this.modifier = modifier;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 547 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 559 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 571 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 583 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.baseset.UserCredit
 * JD-Core Version:    0.6.0
 */