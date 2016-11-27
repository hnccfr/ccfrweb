/*    */ package com.hundsun.eclp.util;
/*    */ 
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class ServerPortGetter
/*    */ {
/*    */   private static final String HTTP_DEFAULT_PORT = "80";
/*    */ 
/*    */   public static String getPortString(String port)
/*    */   {
/* 23 */     if ((StringUtils.isNotEmpty(port)) && (StringUtils.isNumeric(port)) && (!"80".equals(port)))
/*    */     {
/* 26 */       return port;
/*    */     }
/* 28 */     return "";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.util.ServerPortGetter
 * JD-Core Version:    0.6.0
 */