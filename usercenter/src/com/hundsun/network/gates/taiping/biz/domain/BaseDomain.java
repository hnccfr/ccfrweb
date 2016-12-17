/*    */ package com.hundsun.network.gates.taiping.biz.domain;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.lang.builder.EqualsBuilder;
/*    */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*    */ import org.apache.commons.lang.builder.ToStringBuilder;
/*    */ import org.apache.commons.lang.builder.ToStringStyle;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class BaseDomain
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -6506377566494049719L;
/* 19 */   protected Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   public String toString() {
/* 22 */     return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 27 */     return EqualsBuilder.reflectionEquals(this, obj);
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 32 */     return HashCodeBuilder.reflectionHashCode(this);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.domain.BaseDomain
 * JD-Core Version:    0.6.0
 */