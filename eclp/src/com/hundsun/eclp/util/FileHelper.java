/*    */ package com.hundsun.eclp.util;
/*    */ 
/*    */ import java.io.BufferedOutputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import javax.servlet.ServletOutputStream;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*    */ 
/*    */ public class FileHelper
/*    */ {
/* 20 */   private static Log _log = LogFactory.getLog(FileHelper.class);
/*    */ 
/*    */   public static void ExportExcelReport(HttpServletResponse response, File file) throws IOException
/*    */   {
/* 24 */     if (file.exists()) {
/* 25 */       response.setContentType("application/vnd.ms-excel");
/*    */       try {
/* 27 */         response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(file.getName().getBytes("GBK"), "iso8859-1") + "\"");
/*    */ 
/* 29 */         ServletOutputStream outStr = response.getOutputStream();
/* 30 */         BufferedOutputStream buff = new BufferedOutputStream(outStr);
/* 31 */         InputStream is = new FileInputStream(file);
/* 32 */         byte[] tempbyte = new byte[1024];
/* 33 */         while (is.read(tempbyte) != -1)
/* 34 */           buff.write(tempbyte);
/* 35 */         if (is != null)
/* 36 */           is.close();
/* 37 */         buff.flush();
/*    */       } catch (UnsupportedEncodingException e) {
/* 39 */         if (_log.isErrorEnabled())
/* 40 */           _log.error("报表名称字符串转换错误", e);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void ExportPdfReport(HttpServletResponse response, File file) throws IOException
/*    */   {
/*    */     try {
/* 48 */       if (file.exists()) {
/* 49 */         response.setContentType("application/pdf");
/* 50 */         response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(file.getName().getBytes("GBK"), "iso8859-1") + "\"");
/*    */ 
/* 52 */         ServletOutputStream outStr = response.getOutputStream();
/* 53 */         BufferedOutputStream buff = new BufferedOutputStream(outStr);
/* 54 */         InputStream is = new FileInputStream(file);
/* 55 */         byte[] tempbyte = new byte[1024];
/* 56 */         while (is.read(tempbyte) != -1)
/* 57 */           buff.write(tempbyte);
/* 58 */         if (is != null)
/* 59 */           is.close();
/* 60 */         buff.flush();
/*    */       }
/*    */     } catch (UnsupportedEncodingException e) {
/* 63 */       if (_log.isErrorEnabled())
/* 64 */         _log.error("报表名称字符串转换错误", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void ExportExcelReport(HttpServletResponse response, HSSFWorkbook book, String fileName)
/*    */     throws IOException
/*    */   {
/*    */     try
/*    */     {
/* 78 */       response.setContentType("application/vnd.ms-excel");
/* 79 */       response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("GBK"), "iso8859-1") + ".xls" + "\"");
/* 80 */       book.write(response.getOutputStream());
/*    */     } catch (Exception e) {
/* 82 */       if (_log.isErrorEnabled())
/* 83 */         _log.error("生成EXCEL报表文件异常", e);
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void ExportExcelReport(HttpServletResponse response, String fileContent, String fileName)
/*    */     throws IOException
/*    */   {
/*    */     try
/*    */     {
/* 97 */       response.setContentType("application/vnd.ms-excel");
/* 98 */       response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("GBK"), "iso8859-1") + ".xls" + "\"");
/*    */ 
/* 100 */       ServletOutputStream outStr = response.getOutputStream();
/* 101 */       BufferedOutputStream buff = new BufferedOutputStream(outStr);
/* 102 */       InputStream is = new FileInputStream(fileContent);
/* 103 */       byte[] tempbyte = new byte[1024];
/* 104 */       while (is.read(tempbyte) != -1)
/* 105 */         buff.write(tempbyte);
/* 106 */       if (is != null) {
/* 107 */         is.close();
/*    */       }
/* 109 */       buff.flush();
/*    */     } catch (Exception e) {
/* 111 */       if (_log.isErrorEnabled())
/* 112 */         _log.error("生成EXCEL报表文件异常", e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.util.FileHelper
 * JD-Core Version:    0.6.0
 */