/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.BasePhase;
/*    */ import org.springframework.util.Assert;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class BasePhaseValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 14 */     Assert.notNull(obj);
/* 15 */     Assert.isInstanceOf(BasePhase.class, obj);
/* 16 */     super.validate(obj, err);
/* 17 */     BasePhase entity = (BasePhase)obj;
/*    */ 
/* 19 */     Integer gmtStartHour = entity.getGmtStartHour();
/*    */ 
/* 21 */     Integer gmtStartMinute = entity.getGmtStartMinute();
/*    */ 
/* 23 */     Integer gmtEndHour = entity.getGmtEndHour();
/*    */ 
/* 25 */     Integer gmtEndMinute = entity.getGmtEndMinute();
/*    */ 
/* 27 */     if ((null != gmtStartHour) && (null != gmtStartMinute) && (null != gmtEndHour) && (null != gmtEndMinute))
/*    */     {
/* 29 */       if (!entity.getIsEndNext())
/*    */       {
/* 32 */         if ((gmtStartHour.intValue() > gmtEndHour.intValue()) || ((gmtEndHour == gmtStartHour) && (gmtStartMinute.intValue() >= gmtEndMinute.intValue())))
/*    */         {
/* 34 */           err.rejectValue("gmtEndMinute", null, null, "交易节结束时间必须在开始时间之后");
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.BasePhaseValidator
 * JD-Core Version:    0.6.0
 */