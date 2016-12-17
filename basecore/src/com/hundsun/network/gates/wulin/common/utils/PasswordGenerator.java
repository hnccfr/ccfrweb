/*    */ package com.hundsun.network.gates.wulin.common.utils;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ public class PasswordGenerator
/*    */ {
/*  7 */   private static int DEFAULT_PWD_LENGTH = 6;
/*    */ 
/*  9 */   private static char[] pwChar = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
/*    */ 
/*    */   public static String pwGenerator(Integer pwLength)
/*    */   {
/* 14 */     if ((null == pwLength) || (pwLength.intValue() <= 0)) {
/* 15 */       pwLength = Integer.valueOf(DEFAULT_PWD_LENGTH);
/*    */     }
/* 17 */     StringBuffer password = new StringBuffer();
/* 18 */     Random random = new Random();
/* 19 */     for (int i = 0; i < pwLength.intValue(); i++) {
/* 20 */       password.append(pwChar[random.nextInt(36)]);
/*    */     }
/* 22 */     return password.toString();
/*    */   }
/*    */ 
/*    */   public static String pwGenerator() {
/* 26 */     return pwGenerator(null);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.common.utils.PasswordGenerator
 * JD-Core Version:    0.6.0
 */