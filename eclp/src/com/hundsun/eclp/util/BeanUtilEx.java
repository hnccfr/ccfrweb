/*    */ package com.hundsun.eclp.util;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.util.Date;
/*    */ import org.apache.commons.beanutils.BeanUtils;
/*    */ import org.apache.commons.beanutils.ConvertUtils;
/*    */ import org.apache.commons.beanutils.converters.SqlDateConverter;
/*    */ 
/*    */ public class BeanUtilEx extends BeanUtils
/*    */ {
/*    */   public static void copyProperties(Object target, Object source)
/*    */     throws IllegalAccessException, InvocationTargetException
/*    */   {
/* 22 */     BeanUtils.copyProperties(target, source);
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 16 */     ConvertUtils.register(new SqlDateConverter(), Date.class);
/*    */ 
/* 18 */     ConvertUtils.register(new DateConverter(), Date.class);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.util.BeanUtilEx
 * JD-Core Version:    0.6.0
 */