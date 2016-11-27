/*     */ package com.hundsun.network.gates.houchao.biz.domain.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.domain.BaseDomain;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringStyle;
/*     */ 
/*     */ public class TradeDayCurrent extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 1981785907778030109L;
/*     */   private Date currentTradeDay;
/*     */   private Date lastTradeDay;
/*     */   private Date nextTradeDay;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*  31 */   DateFormat df = new SimpleDateFormat("yyyyMMdd");
/*     */ 
/*     */   public void setCurrentTradeDay(Date obj)
/*     */   {
/*  36 */     this.currentTradeDay = obj;
/*     */   }
/*     */ 
/*     */   public Date getCurrentTradeDay()
/*     */   {
/*  41 */     return this.currentTradeDay;
/*     */   }
/*     */ 
/*     */   public String getCurrentTradeDayStr()
/*     */   {
/*  46 */     return this.df.format(this.currentTradeDay);
/*     */   }
/*     */ 
/*     */   public void setLastTradeDay(Date obj)
/*     */   {
/*  51 */     this.lastTradeDay = obj;
/*     */   }
/*     */ 
/*     */   public Date getLastTradeDay()
/*     */   {
/*  56 */     return this.lastTradeDay;
/*     */   }
/*     */ 
/*     */   public String getLastTradeDayStr()
/*     */   {
/*  61 */     return this.df.format(this.lastTradeDay);
/*     */   }
/*     */ 
/*     */   public void setNextTradeDay(Date obj)
/*     */   {
/*  66 */     this.nextTradeDay = obj;
/*     */   }
/*     */ 
/*     */   public Date getNextTradeDay()
/*     */   {
/*  71 */     return this.nextTradeDay;
/*     */   }
/*     */ 
/*     */   public String getNextTradeDayStr()
/*     */   {
/*  76 */     return this.df.format(this.nextTradeDay);
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date obj)
/*     */   {
/*  81 */     this.gmtCreate = obj;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/*  86 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date obj)
/*     */   {
/*  91 */     this.gmtModify = obj;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/*  96 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object o)
/*     */   {
/* 101 */     if (this == o) {
/* 102 */       return true;
/*     */     }
/* 104 */     if (!(o instanceof TradeDayCurrent)) {
/* 105 */       return false;
/*     */     }
/* 107 */     TradeDayCurrent tradedaycurrent = (TradeDayCurrent)o;
/* 108 */     return hashCode() == tradedaycurrent.hashCode();
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 113 */     return hashCode();
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 118 */     ToStringBuilder sb = new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append("currentTradeDay", this.currentTradeDay).append("lastTradeDay", this.lastTradeDay).append("nextTradeDay", this.nextTradeDay).append("gmtCreate", this.gmtCreate).append("gmtModify", this.gmtModify);
/*     */ 
/* 122 */     return sb.toString();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.fund.TradeDayCurrent
 * JD-Core Version:    0.6.0
 */