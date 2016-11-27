/*     */ package com.hundsun.eclp.util;
/*     */ 
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
/*  21 */   private static Log log = LogFactory.getLog(DateUtil.class);
/*     */   private static final String TIME_PATTERN = "HH:mm";
/*     */ 
/*     */   public static String getTimestampToString(Timestamp obj)
/*     */   {
/*  32 */     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*  33 */     String str = df.format(obj);
/*  34 */     return str;
/*     */   }
/*     */ 
/*     */   public static String getTimestampToString(String formatPattern, Timestamp obj)
/*     */   {
/*  41 */     SimpleDateFormat df = new SimpleDateFormat(formatPattern);
/*  42 */     String str = df.format(obj);
/*  43 */     return str;
/*     */   }
/*     */ 
/*     */   public static Timestamp getStringToTimestamp(String str)
/*     */   {
/*  48 */     Timestamp ts = Timestamp.valueOf(str);
/*  49 */     return ts;
/*     */   }
/*     */ 
/*     */   public static Date strToDate(String str, String pattern) {
/*  53 */     Date dateTemp = null;
/*  54 */     SimpleDateFormat formater2 = new SimpleDateFormat(pattern);
/*     */     try {
/*  56 */       dateTemp = formater2.parse(str);
/*     */     } catch (Exception e) {
/*  58 */       log.error("exception in convert string to date!");
/*     */     }
/*  60 */     return dateTemp;
/*     */   }
/*     */ 
/*     */   public static String getDatePattern()
/*     */   {
/*  68 */     return "yyyy-MM-dd";
/*     */   }
/*     */ 
/*     */   public static String getDateTimePattern() {
/*  72 */     return getDatePattern() + " HH:mm:ss.S";
/*     */   }
/*     */ 
/*     */   public static String getDate(Date aDate)
/*     */   {
/*  84 */     String returnValue = "";
/*     */ 
/*  86 */     if (aDate != null) {
/*  87 */       SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
/*  88 */       returnValue = df.format(aDate);
/*     */     }
/*     */ 
/*  91 */     return returnValue;
/*     */   }
/*     */ 
/*     */   public static Date convertStringToDate(String aMask, String strDate)
/*     */     throws ParseException
/*     */   {
/* 107 */     SimpleDateFormat df = new SimpleDateFormat(aMask);
/*     */ 
/* 109 */     if (log.isDebugEnabled())
/* 110 */       log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
/*     */     Date date;
/*     */     try {
/* 114 */       date = df.parse(strDate);
/*     */     }
/*     */     catch (ParseException pe) {
/* 117 */       throw new ParseException(pe.getMessage(), pe.getErrorOffset());
/*     */     }
/*     */ 
/* 120 */     return date;
/*     */   }
/*     */ 
/*     */   public static String getTimeNow(Date theTime)
/*     */   {
/* 131 */     return getDateTime("HH:mm", theTime);
/*     */   }
/*     */ 
/*     */   public static Calendar getToday()
/*     */     throws ParseException
/*     */   {
/* 141 */     Date today = new Date();
/* 142 */     SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
/*     */ 
/* 146 */     String todayAsString = df.format(today);
/* 147 */     Calendar cal = new GregorianCalendar();
/* 148 */     cal.setTime(convertStringToDate(todayAsString));
/*     */ 
/* 150 */     return cal;
/*     */   }
/*     */ 
/*     */   public static Calendar getCurrentDay() throws ParseException {
/* 154 */     Calendar cal = Calendar.getInstance();
/* 155 */     return cal;
/*     */   }
/*     */ 
/*     */   public static String getDateTime(String aMask, Date aDate)
/*     */   {
/* 170 */     SimpleDateFormat df = null;
/* 171 */     String returnValue = "";
/*     */ 
/* 173 */     if (aDate == null) {
/* 174 */       log.error("aDate is null!");
/*     */     } else {
/* 176 */       df = new SimpleDateFormat(aMask);
/* 177 */       returnValue = df.format(aDate);
/*     */     }
/*     */ 
/* 180 */     return returnValue;
/*     */   }
/*     */ 
/*     */   public static String convertDateToString(Date aDate)
/*     */   {
/* 192 */     return getDateTime(getDatePattern(), aDate);
/*     */   }
/*     */ 
/*     */   public static Date convertStringToDate(String strDate)
/*     */     throws ParseException
/*     */   {
/* 203 */     Date aDate = null;
/*     */     try
/*     */     {
/* 206 */       if (log.isDebugEnabled()) {
/* 207 */         log.debug("converting date with pattern: " + getDatePattern());
/*     */       }
/*     */ 
/* 210 */       aDate = convertStringToDate(getDatePattern(), strDate);
/*     */     } catch (ParseException pe) {
/* 212 */       log.error("Could not convert '" + strDate + "' to a date, throwing exception");
/* 213 */       log.error(pe);
/* 214 */       throw new ParseException(pe.getMessage(), pe.getErrorOffset());
/*     */     }
/*     */ 
/* 217 */     return aDate;
/*     */   }
/*     */ 
/*     */   public static String convertDateToString(String pattern, Date aDate)
/*     */   {
/* 226 */     return getDateTime(pattern, aDate);
/*     */   }
/*     */ 
/*     */   public static Date getRelativeDate(Date startDate, int day)
/*     */   {
/* 236 */     Calendar calendar = Calendar.getInstance();
/*     */     try {
/* 238 */       calendar.setTime(startDate);
/* 239 */       calendar.add(5, day);
/* 240 */       return calendar.getTime();
/*     */     } catch (Exception e) {
/* 242 */       log.error(e);
/* 243 */     }return startDate;
/*     */   }
/*     */ 
/*     */   public static int getDay(Date date)
/*     */   {
/* 254 */     Calendar cal = Calendar.getInstance();
/* 255 */     cal.setTime(date);
/* 256 */     return cal.get(7) - 1;
/*     */   }
/*     */ 
/*     */   public static int countDays(String beginStr, String endStr, String Foramt)
/*     */   {
/* 266 */     Date end = strToDate(endStr, Foramt);
/* 267 */     Date begin = strToDate(beginStr, Foramt);
/* 268 */     long times = end.getTime() - begin.getTime();
/* 269 */     return (int)(times / 60L / 60L / 1000L / 24L);
/*     */   }
/*     */ 
/*     */   public static Date getRelativeMonth(Date startDate, int month)
/*     */   {
/* 279 */     Calendar calendar = Calendar.getInstance();
/*     */     try {
/* 281 */       calendar.setTime(startDate);
/* 282 */       calendar.add(2, month);
/* 283 */       return calendar.getTime();
/*     */     } catch (Exception e) {
/* 285 */       log.error(e);
/* 286 */     }return startDate;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.util.DateUtil
 * JD-Core Version:    0.6.0
 */