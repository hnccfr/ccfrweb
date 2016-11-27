/*    */ package com.hundsun.eclp.util;
/*    */ 
/*    */ public class WordUtil
/*    */ {
/*    */   public static int length(String value)
/*    */   {
/* 10 */     return length(value, 3);
/*    */   }
/*    */ 
/*    */   public static int length(String value, int chineseLength)
/*    */   {
/* 20 */     int valueLength = 0;
/* 21 */     String chinese = "[Α-￥]";
/*    */ 
/* 23 */     for (int i = 0; i < value.length(); i++)
/*    */     {
/* 25 */       String temp = value.substring(i, i + 1);
/*    */ 
/* 27 */       if (temp.matches(chinese))
/*    */       {
/* 29 */         valueLength += chineseLength;
/*    */       }
/*    */       else {
/* 32 */         valueLength++;
/*    */       }
/*    */     }
/* 35 */     return valueLength;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.util.WordUtil
 * JD-Core Version:    0.6.0
 */