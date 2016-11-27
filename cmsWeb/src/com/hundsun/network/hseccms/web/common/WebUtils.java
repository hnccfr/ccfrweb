/*    */ package com.hundsun.network.hseccms.web.common;
/*    */ 
/*    */ import java.io.BufferedWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.io.OutputStreamWriter;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class WebUtils
/*    */ {
/*    */   public static void toHtmlPage(HttpServletResponse response, String htmlStr)
/*    */     throws IOException
/*    */   {
/* 24 */     response.setContentType("text/html;charset=utf-8");
/* 25 */     OutputStream out = response.getOutputStream();
/* 26 */     PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out, "utf-8")));
/* 27 */     pw.print(htmlStr);
/* 28 */     pw.flush();
/* 29 */     pw.close();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.common.WebUtils
 * JD-Core Version:    0.6.0
 */