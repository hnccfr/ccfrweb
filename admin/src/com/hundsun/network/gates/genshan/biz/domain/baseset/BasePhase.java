/*     */ package com.hundsun.network.gates.genshan.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.BasePhaseNextStateEnum;
/*     */ import com.hundsun.network.gates.luosi.common.enums.BasePhaseStateEnum;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class BasePhase
/*     */ {
/*     */   private Long id;
/*     */   private String phaseCode;
/*     */   private String phaseName;
/*     */   private Integer gmtStartHour;
/*     */   private Integer gmtStartMinute;
/*     */   private Integer gmtEndHour;
/*     */   private Integer gmtEndMinute;
/*     */   private String state;
/*     */   private Date gmtValid;
/*     */   private Date gmtInvalid;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String endHourNext;
/*     */   private Long uniqueMark;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  83 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  90 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getPhaseCode()
/*     */   {
/*  97 */     return this.phaseCode;
/*     */   }
/*     */ 
/*     */   public void setPhaseCode(String phaseCode)
/*     */   {
/* 104 */     this.phaseCode = phaseCode;
/*     */   }
/*     */ 
/*     */   public String getPhaseName()
/*     */   {
/* 111 */     return this.phaseName;
/*     */   }
/*     */ 
/*     */   public void setPhaseName(String phaseName)
/*     */   {
/* 118 */     this.phaseName = phaseName;
/*     */   }
/*     */ 
/*     */   public Integer getGmtStartHour()
/*     */   {
/* 125 */     return this.gmtStartHour;
/*     */   }
/*     */ 
/*     */   public void setGmtStartHour(Integer gmtStartHour)
/*     */   {
/* 132 */     this.gmtStartHour = gmtStartHour;
/*     */   }
/*     */ 
/*     */   public Integer getGmtStartMinute()
/*     */   {
/* 139 */     return this.gmtStartMinute;
/*     */   }
/*     */ 
/*     */   public void setGmtStartMinute(Integer gmtStartMinute)
/*     */   {
/* 146 */     this.gmtStartMinute = gmtStartMinute;
/*     */   }
/*     */ 
/*     */   public Integer getGmtEndHour()
/*     */   {
/* 153 */     return this.gmtEndHour;
/*     */   }
/*     */ 
/*     */   public void setGmtEndHour(Integer gmtEndHour)
/*     */   {
/* 160 */     this.gmtEndHour = gmtEndHour;
/*     */   }
/*     */ 
/*     */   public Integer getGmtEndMinute()
/*     */   {
/* 167 */     return this.gmtEndMinute;
/*     */   }
/*     */ 
/*     */   public void setGmtEndMinute(Integer gmtEndMinute)
/*     */   {
/* 174 */     this.gmtEndMinute = gmtEndMinute;
/*     */   }
/*     */ 
/*     */   public String getState()
/*     */   {
/* 181 */     return this.state;
/*     */   }
/*     */ 
/*     */   public void setState(String state)
/*     */   {
/* 188 */     this.state = state;
/*     */   }
/*     */ 
/*     */   public Date getGmtValid()
/*     */   {
/* 195 */     return this.gmtValid;
/*     */   }
/*     */ 
/*     */   public void setGmtValid(Date gmtValid)
/*     */   {
/* 202 */     this.gmtValid = gmtValid;
/*     */   }
/*     */ 
/*     */   public Date getGmtInvalid()
/*     */   {
/* 209 */     return this.gmtInvalid;
/*     */   }
/*     */ 
/*     */   public void setGmtInvalid(Date gmtInvalid)
/*     */   {
/* 216 */     this.gmtInvalid = gmtInvalid;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 223 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 230 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 237 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 244 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getEndHourNext()
/*     */   {
/* 251 */     return this.endHourNext;
/*     */   }
/*     */ 
/*     */   public void setEndHourNext(String endHourNext)
/*     */   {
/* 258 */     this.endHourNext = endHourNext;
/*     */   }
/*     */ 
/*     */   public Long getUniqueMark()
/*     */   {
/* 265 */     return this.uniqueMark;
/*     */   }
/*     */ 
/*     */   public void setUniqueMark(Long uniqueMark)
/*     */   {
/* 272 */     this.uniqueMark = uniqueMark;
/*     */   }
/*     */ 
/*     */   public boolean getIsEnable()
/*     */   {
/* 280 */     return BasePhaseStateEnum.isEnable(this.state);
/*     */   }
/*     */ 
/*     */   public boolean getIsDisable()
/*     */   {
/* 288 */     return BasePhaseStateEnum.isDisable(this.state);
/*     */   }
/*     */ 
/*     */   public boolean getIsDelete()
/*     */   {
/* 296 */     return BasePhaseStateEnum.isDelete(this.state);
/*     */   }
/*     */ 
/*     */   public boolean getIsEndNext()
/*     */   {
/* 304 */     return BasePhaseNextStateEnum.isNext(this.endHourNext);
/*     */   }
/*     */ 
/*     */   public String getBasePhaseStateDesc() {
/* 308 */     BasePhaseStateEnum stateEnum = BasePhaseStateEnum.indexByValue(this.state);
/* 309 */     if (null == stateEnum) {
/* 310 */       return this.state;
/*     */     }
/* 312 */     return stateEnum.getDescription();
/*     */   }
/*     */ 
/*     */   public String getGmtStartHourStr() {
/* 316 */     String str = this.gmtStartHour.toString();
/* 317 */     if (str.length() != 2)
/* 318 */       str = '0' + str;
/* 319 */     return str;
/*     */   }
/*     */ 
/*     */   public String getGmtStartMinuteStr() {
/* 323 */     String str = null;
/* 324 */     if (this.gmtStartMinute != null) {
/* 325 */       if (this.gmtStartMinute.toString().length() != 2)
/* 326 */         str = '0' + this.gmtStartMinute.toString();
/*     */       else
/* 328 */         str = this.gmtStartMinute.toString();
/*     */     }
/*     */     else {
/* 331 */       str = "00";
/*     */     }
/* 333 */     return str;
/*     */   }
/*     */ 
/*     */   public String getGmtEndHourStr() {
/* 337 */     String str = this.gmtEndHour.toString();
/* 338 */     if (str.length() != 2)
/* 339 */       str = '0' + str;
/* 340 */     return str;
/*     */   }
/*     */ 
/*     */   public String getGmtEndMinuteStr() {
/* 344 */     String str = null;
/* 345 */     if (this.gmtEndMinute != null) {
/* 346 */       if (this.gmtEndMinute.toString().length() != 2)
/* 347 */         str = '0' + this.gmtEndMinute.toString();
/*     */       else
/* 349 */         str = this.gmtEndMinute.toString();
/*     */     }
/*     */     else {
/* 352 */       str = "00";
/*     */     }
/* 354 */     return str;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.baseset.BasePhase
 * JD-Core Version:    0.6.0
 */