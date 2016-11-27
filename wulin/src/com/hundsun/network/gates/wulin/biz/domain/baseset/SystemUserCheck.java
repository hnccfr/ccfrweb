/*     */ package com.hundsun.network.gates.wulin.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SystemUserCheck extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -8823774001626935926L;
/*     */   private Long id;
/*     */   private String userRole;
/*     */   private String checkProcess;
/*     */   private String remark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  49 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  56 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserRole()
/*     */   {
/*  63 */     return this.userRole;
/*     */   }
/*     */ 
/*     */   public void setUserRole(String userRole)
/*     */   {
/*  70 */     this.userRole = userRole;
/*     */   }
/*     */ 
/*     */   public String getCheckProcess()
/*     */   {
/*  77 */     return this.checkProcess;
/*     */   }
/*     */ 
/*     */   public void setCheckProcess(String checkProcess)
/*     */   {
/*  84 */     this.checkProcess = checkProcess;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/*  91 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/*  98 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 105 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 112 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 119 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 126 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 133 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 140 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.baseset.SystemUserCheck
 * JD-Core Version:    0.6.0
 */