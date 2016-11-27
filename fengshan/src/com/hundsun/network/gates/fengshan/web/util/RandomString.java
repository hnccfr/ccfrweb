/*    */ package com.hundsun.network.gates.fengshan.web.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public class RandomString
/*    */ {
/*  6 */   private final String splitStr = " ";
/*    */ 
/*    */   private String getNumberString()
/*    */   {
/* 10 */     StringBuffer buf = new StringBuffer();
/* 11 */     for (int i = 0; i < 10; i++) {
/* 12 */       buf.append(String.valueOf(i));
/* 13 */       buf.append(" ");
/*    */     }
/* 15 */     return buf.toString();
/*    */   }
/*    */ 
/*    */   private String getUppercase()
/*    */   {
/* 20 */     StringBuffer buf = new StringBuffer();
/* 21 */     for (int i = 0; i < 26; i++) {
/* 22 */       buf.append(String.valueOf((char)(65 + i)));
/* 23 */       buf.append(" ");
/*    */     }
/* 25 */     return buf.toString();
/*    */   }
/*    */ 
/*    */   private String getLowercase()
/*    */   {
/* 30 */     StringBuffer buf = new StringBuffer();
/* 31 */     for (int i = 0; i < 26; i++) {
/* 32 */       buf.append(String.valueOf((char)(97 + i)));
/* 33 */       buf.append(" ");
/*    */     }
/* 35 */     return buf.toString();
/*    */   }
/*    */ 
/*    */   private String getSpecialString()
/*    */   {
/* 40 */     String str = "~@#$%^&*()_+|\\=-`";
/* 41 */     StringBuffer buf = new StringBuffer();
/* 42 */     for (int i = 0; i < str.length(); i++) {
/* 43 */       buf.append(str.substring(i, i + 1));
/* 44 */       buf.append(" ");
/*    */     }
/* 46 */     return buf.toString();
/*    */   }
/*    */ 
/*    */   private String getString(String type)
/*    */   {
/* 51 */     StringBuffer pstr = new StringBuffer();
/* 52 */     if (type.length() > 0) {
/* 53 */       if (type.indexOf('i') != -1)
/* 54 */         pstr.append(getNumberString());
/* 55 */       if (type.indexOf('l') != -1)
/* 56 */         pstr.append(getLowercase());
/* 57 */       if (type.indexOf('u') != -1)
/* 58 */         pstr.append(getUppercase());
/* 59 */       if (type.indexOf('s') != -1) {
/* 60 */         pstr.append(getSpecialString());
/*    */       }
/*    */     }
/* 63 */     return pstr.toString();
/*    */   }
/*    */ 
/*    */   public String getRandomString(int length, String type)
/*    */   {
/* 80 */     String allStr = getString(type);
/* 81 */     String[] arrStr = allStr.split(" ");
/* 82 */     StringBuffer pstr = new StringBuffer();
/* 83 */     if (length > 0) {
/* 84 */       for (int i = 0; i < length; i++) {
/* 85 */         pstr.append(arrStr[new java.util.Random().nextInt(arrStr.length)]);
/*    */       }
/*    */     }
/* 88 */     return pstr.toString();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 93 */     System.out.println("type=i:" + new RandomString().getRandomString(10, "i"));
/* 94 */     System.out.println("type=il:" + new RandomString().getRandomString(10, "il"));
/* 95 */     System.out.println("type=ilu:" + new RandomString().getRandomString(10, "ilu"));
/* 96 */     System.out.println("type=ilus:" + new RandomString().getRandomString(10, "ilus"));
/* 97 */     for (int i = 0; i < 100; i++)
/* 98 */       System.out.println("type=ilus:" + new RandomString().getRandomString(10, "ilus"));
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.util.RandomString
 * JD-Core Version:    0.6.0
 */