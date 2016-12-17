/*     */ package com.hundsun.network.gates.wangjiang.common;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class DateUtil
/*     */ {
/*  14 */   private static Log log = LogFactory.getLog(DateUtil.class);
/*     */   private static final String TIME_PATTERN = "HH:mm";
/*     */   private static final String TIME_PATTERN_ALL = "yyyy-MM-dd HH:mm:ss.S";
/*     */ 
/*     */   public static String getTimestampToString(Timestamp obj)
/*     */   {
/*  27 */     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*  28 */     String str = df.format(obj);
/*  29 */     return str;
/*     */   }
/*     */ 
/*     */   public static String getTimestampToString(String formatPattern, Timestamp obj)
/*     */   {
/*  36 */     SimpleDateFormat df = new SimpleDateFormat(formatPattern);
/*  37 */     String str = df.format(obj);
/*  38 */     return str;
/*     */   }
/*     */ 
/*     */   public static Timestamp getStringToTimestamp(String str)
/*     */   {
/*  43 */     Timestamp ts = Timestamp.valueOf(str);
/*  44 */     return ts;
/*     */   }
/*     */ 
/*     */   public static Date strToDate(String str, String pattern) {
/*  48 */     Date dateTemp = null;
/*  49 */     SimpleDateFormat formater2 = new SimpleDateFormat(pattern);
/*     */     try {
/*  51 */       dateTemp = formater2.parse(str);
/*     */     } catch (Exception e) {
/*  53 */       log.error("exception in convert string to date!");
/*     */     }
/*  55 */     return dateTemp;
/*     */   }
/*     */ 
/*     */   public static String getDatePattern()
/*     */   {
/*  63 */     return "yyyy-MM-dd";
/*     */   }
/*     */ 
/*     */   public static String getDateTimePattern() {
/*  67 */     return getDatePattern() + " HH:mm:ss.S";
/*     */   }
/*     */ 
/*     */   public static String getDate(Date aDate)
/*     */   {
/*  79 */     String returnValue = "";
/*     */ 
/*  81 */     if (aDate != null) {
/*  82 */       SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
/*  83 */       returnValue = df.format(aDate);
/*     */     }
/*     */ 
/*  86 */     return returnValue;
/*     */   }
/*     */ 
/*     */   public static Date convertStringToDate(String aMask, String strDate)
/*     */     throws ParseException
/*     */   {
/* 102 */     SimpleDateFormat df = new SimpleDateFormat(aMask);
/*     */ 
/* 104 */     if (log.isDebugEnabled())
/* 105 */       log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
/*     */     Date date;
/*     */     try {
/* 109 */       date = df.parse(strDate);
/*     */     }
/*     */     catch (ParseException pe) {
/* 112 */       throw new ParseException(pe.getMessage(), pe.getErrorOffset());
/*     */     }
/*     */ 
/* 115 */     return date;
/*     */   }
/*     */ 
/*     */   public static String getTimeNow(Date theTime)
/*     */   {
/* 126 */     return getDateTime("HH:mm", theTime);
/*     */   }
/*     */ 
/*     */   public static Calendar getToday()
/*     */     throws ParseException
/*     */   {
/* 136 */     Date today = new Date();
/* 137 */     SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
/*     */ 
/* 141 */     String todayAsString = df.format(today);
/* 142 */     Calendar cal = new GregorianCalendar();
/* 143 */     cal.setTime(convertStringToDate(todayAsString));
/*     */ 
/* 145 */     return cal;
/*     */   }
/*     */ 
/*     */   public static Calendar getCurrentDay() throws ParseException {
/* 149 */     Calendar cal = Calendar.getInstance();
/* 150 */     return cal;
/*     */   }
/*     */ 
/*     */   public static String getDateTime(String aMask, Date aDate)
/*     */   {
/* 165 */     SimpleDateFormat df = null;
/* 166 */     String returnValue = "";
/*     */ 
/* 168 */     if (aDate == null) {
/* 169 */       log.error("aDate is null!");
/*     */     } else {
/* 171 */       df = new SimpleDateFormat(aMask);
/* 172 */       returnValue = df.format(aDate);
/*     */     }
/*     */ 
/* 175 */     return returnValue;
/*     */   }
/*     */ 
/*     */   public static String convertDateToString(Date aDate)
/*     */   {
/* 187 */     return getDateTime(getDatePattern(), aDate);
/*     */   }
/*     */ 
/*     */   public static Date convertStringToDate(String strDate)
/*     */     throws ParseException
/*     */   {
/* 198 */     Date aDate = null;
/*     */     try
/*     */     {
/* 201 */       if (log.isDebugEnabled()) {
/* 202 */         log.debug("converting date with pattern: " + getDatePattern());
/*     */       }
/*     */ 
/* 205 */       aDate = convertStringToDate(getDatePattern(), strDate);
/*     */     } catch (ParseException pe) {
/* 207 */       log.error("Could not convert '" + strDate + "' to a date, throwing exception");
/* 208 */       log.error(pe);
/* 209 */       throw new ParseException(pe.getMessage(), pe.getErrorOffset());
/*     */     }
/*     */ 
/* 212 */     return aDate;
/*     */   }
/*     */ 
/*     */   public static String convertDateToString(String pattern, Date aDate)
/*     */   {
/* 221 */     return getDateTime(pattern, aDate);
/*     */   }
/*     */ 
/*     */   public static Date getRelativeDate(Date startDate, int day)
/*     */   {
/* 231 */     Calendar calendar = Calendar.getInstance();
/*     */     try {
/* 233 */       calendar.setTime(startDate);
/* 234 */       calendar.add(5, day);
/* 235 */       return calendar.getTime();
/*     */     } catch (Exception e) {
/* 237 */       log.error(e);
/* 238 */     }return startDate;
/*     */   }
/*     */ 
/*     */   public static int getDay(Date date)
/*     */   {
/* 249 */     Calendar cal = Calendar.getInstance();
/* 250 */     cal.setTime(date);
/* 251 */     return cal.get(7) - 1;
/*     */   }
/*     */ 
/*     */   public static int countDays(String beginStr, String endStr, String Foramt)
/*     */   {
/* 261 */     Date end = strToDate(endStr, Foramt);
/* 262 */     Date begin = strToDate(beginStr, Foramt);
/* 263 */     long times = end.getTime() - begin.getTime();
/* 264 */     return (int)(times / 60L / 60L / 1000L / 24L);
/*     */   }
/*     */   public static float countDays(Date begin, Date end) {
/* 267 */     if ((begin == null) || (end == null)) return -9999.0F;
/* 268 */     long times = end.getTime() - begin.getTime();
/* 269 */     float days = (float)times / 60.0F / 60.0F / 1000.0F / 24.0F;
/* 270 */     return days;
/*     */   }
/*     */ 
/*     */   public static int countMinites(String beginStr, String endStr, String Foramt)
/*     */   {
/* 280 */     Date end = strToDate(endStr, Foramt);
/* 281 */     Date begin = strToDate(beginStr, Foramt);
/* 282 */     long times = end.getTime() - begin.getTime();
/* 283 */     return (int)(times / 60L / 1000L);
/*     */   }
/*     */   public static float countMinites(Date begin, Date end) {
/* 286 */     if ((begin == null) || (end == null)) return -9999.0F;
/* 287 */     long times = end.getTime() - begin.getTime();
/* 288 */     float days = (float)times / 60.0F / 1000.0F;
/* 289 */     return days;
/*     */   }
/*     */ 
/*     */   public static int countSeconds(String beginStr, String endStr, String Foramt)
/*     */   {
/* 300 */     Date end = strToDate(endStr, Foramt);
/* 301 */     Date begin = strToDate(beginStr, Foramt);
/* 302 */     long times = end.getTime() - begin.getTime();
/* 303 */     return (int)(times / 1000L);
/*     */   }
/*     */   public static int countSeconds(Date begin, Date end) {
/* 306 */     if ((begin == null) || (end == null)) return -9999;
/* 307 */     long times = end.getTime() - begin.getTime();
/* 308 */     return (int)(times / 1000L);
/*     */   }
/*     */ 
/*     */   public static int getWholeDay(String in)
/*     */   {
/* 321 */     Double double1 = Double.valueOf(Double.parseDouble(in));
/* 322 */     if (double1.doubleValue() < 0.0D) {
/* 323 */       return 0;
/*     */     }
/* 325 */     return (int)Math.ceil(double1.doubleValue());
/*     */   }
/*     */ 
/*     */   public static boolean isDate(String str, String dateFormat)
/*     */   {
/* 335 */     if (str != null) {
/* 336 */       SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
/* 337 */       formatter.setLenient(false);
/*     */       try {
/* 339 */         formatter.format(formatter.parse(str));
/*     */       } catch (Exception e) {
/* 341 */         return false;
/*     */       }
/* 343 */       return true;
/*     */     }
/* 345 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean isEmpty(String str)
/*     */   {
/* 363 */     return (str == null) || (str.length() == 0);
/*     */   }
/*     */ 
/*     */   public static Date formatDatePatternAll(String datestr) {
/* 367 */     if (isEmpty(datestr))
/* 368 */       return null;
/* 369 */     Date dateTemp = null;
/* 370 */     SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
/*     */     try {
/* 372 */       dateTemp = formater2.parse(datestr);
/*     */     } catch (Exception e) {
/* 374 */       log.error("exception in convert string to date!");
/*     */     }
/* 376 */     return dateTemp;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 380 */     System.out.println(isDate("2011-04-31", "yyyy-MM-dd"));
/* 381 */     System.out.println(formatDatePatternAll("2010-05-02 19:51:03.0"));
/*     */     try
/*     */     {
/* 384 */       Calendar calendar = getCurrentDay();
/* 385 */       Date nowDate = calendar.getTime();
/*     */ 
/* 387 */       int num = countSeconds(nowDate, formatDatePatternAll("2011-12-14 14:19:03.0"));
/* 388 */       System.out.println("num==" + num);
/*     */     } catch (ParseException e) {
/* 390 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.common.DateUtil
 * JD-Core Version:    0.6.0
 */