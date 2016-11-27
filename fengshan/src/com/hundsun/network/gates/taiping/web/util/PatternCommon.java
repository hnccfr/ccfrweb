/*    */ package com.hundsun.network.gates.taiping.web.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class PatternCommon
/*    */ {
/*    */   public static boolean isEmail(String str)
/*    */   {
/* 25 */     Pattern pattern = Pattern.compile("[//w//.//-]+@([//w//-]+//.)+[//w//-]+", 2);
/*    */ 
/* 27 */     Matcher matcher = pattern.matcher(str);
/* 28 */     return matcher.matches();
/*    */   }
/*    */ 
/*    */   public static boolean isDigit(String str) {
/* 32 */     Pattern pattern = Pattern.compile("^[0-9]{1,20}$", 2);
/* 33 */     Matcher matcher = pattern.matcher(str);
/* 34 */     return matcher.matches();
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 38 */     System.out.println(isDigit("2"));
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.web.util.PatternCommon
 * JD-Core Version:    0.6.0
 */