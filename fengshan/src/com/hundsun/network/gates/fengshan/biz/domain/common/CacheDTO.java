/*    */ package com.hundsun.network.gates.fengshan.biz.domain.common;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*    */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*    */ import java.text.ParseException;
/*    */ import java.util.Calendar;
/*    */ 
/*    */ public class CacheDTO<T> extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = -2765609135472597330L;
/*    */   private long updateTimeMs;
/*    */   private long outMs;
/*    */   private T data;
/*    */ 
/*    */   public boolean isOutTime()
/*    */   {
/*    */     try
/*    */     {
/* 34 */       return DateUtil.getCurrentDay().getTimeInMillis() > this.updateTimeMs + this.outMs;
/*    */     } catch (ParseException e) {
/* 36 */       e.printStackTrace();
/* 37 */     }return true;
/*    */   }
/*    */ 
/*    */   public long getUpdateTimeMs()
/*    */   {
/* 42 */     return this.updateTimeMs;
/*    */   }
/*    */ 
/*    */   public void setUpdateTimeMs(long updateTimeMs)
/*    */   {
/* 47 */     this.updateTimeMs = updateTimeMs;
/*    */   }
/*    */ 
/*    */   public long getOutMs()
/*    */   {
/* 52 */     return this.outMs;
/*    */   }
/*    */ 
/*    */   public void setOutMs(long outMs)
/*    */   {
/* 57 */     this.outMs = outMs;
/*    */   }
/*    */ 
/*    */   public T getData()
/*    */   {
/* 62 */     return this.data;
/*    */   }
/*    */ 
/*    */   public void setData(T data)
/*    */   {
/* 67 */     this.data = data;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.common.CacheDTO
 * JD-Core Version:    0.6.0
 */