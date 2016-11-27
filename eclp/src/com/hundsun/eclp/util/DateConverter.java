/*    */ package com.hundsun.eclp.util;
/*    */ 
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.apache.commons.beanutils.Converter;
/*    */ 
/*    */ public class DateConverter
/*    */   implements Converter
/*    */ {
/*    */   public Object convert(Class arg0, Object arg1)
/*    */   {
/* 13 */     if ((arg1 != null) && ((arg1 instanceof Date))) {
/* 14 */       return arg1;
/*    */     }
/* 16 */     String p = (String)arg1;
/* 17 */     if ((p == null) || (p.trim().length() == 0))
/* 18 */       return null;
/*    */     try
/*    */     {
/* 21 */       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 22 */       return df.parse(p.trim());
/*    */     }
/*    */     catch (Exception e) {
/*    */       try {
/* 26 */         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/* 27 */         return df.parse(p.trim()); } catch (ParseException ex) {
/*    */       }
/*    */     }
/* 29 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.util.DateConverter
 * JD-Core Version:    0.6.0
 */