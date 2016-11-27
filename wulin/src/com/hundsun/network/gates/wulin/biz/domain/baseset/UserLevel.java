/*     */ package com.hundsun.network.gates.wulin.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ 
/*     */ public class UserLevel extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -3104036504504287066L;
/*     */   private Long id;
/*     */   private String userAccount;
/*     */   private String memberLevel;
/*     */   private Integer integral;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  49 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  61 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/*  73 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/*  85 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getMemberLevel()
/*     */   {
/*  97 */     return this.memberLevel;
/*     */   }
/*     */ 
/*     */   public void setMemberLevel(String memberLevel)
/*     */   {
/* 109 */     this.memberLevel = memberLevel;
/*     */   }
/*     */ 
/*     */   public Integer getIntegral()
/*     */   {
/* 121 */     return this.integral;
/*     */   }
/*     */ 
/*     */   public void setIntegral(Integer integral)
/*     */   {
/* 133 */     this.integral = integral;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.baseset.UserLevel
 * JD-Core Version:    0.6.0
 */