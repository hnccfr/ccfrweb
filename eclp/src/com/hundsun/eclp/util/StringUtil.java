/*      */ package com.hundsun.eclp.util;
/*      */ 
/*      */ import com.hundsun.network.melody.common.util.ArrayUtil;

/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ 
/*      */ public class StringUtil
/*      */ {
/*      */   public static final String EMPTY_STRING = "";
/* 1246 */   private static final WordTokenizer CAMEL_CASE_TOKENIZER = new WordTokenizer()
/*      */   {
/*      */     protected void startSentence(StringBuffer buffer, char ch)
/*      */     {
/* 1250 */       buffer.append(Character.toLowerCase(ch));
/*      */     }
/*      */ 
/*      */     protected void startWord(StringBuffer buffer, char ch)
/*      */     {
/* 1258 */       if (!isDelimiter(buffer.charAt(buffer.length() - 1)))
/*      */       {
/* 1261 */         buffer.append(Character.toUpperCase(ch));
/*      */       }
/*      */       else
/*      */       {
/* 1265 */         buffer.append(Character.toLowerCase(ch));
/*      */       }
/*      */     }
/*      */ 
/*      */     protected void inWord(StringBuffer buffer, char ch)
/*      */     {
/* 1274 */       buffer.append(Character.toLowerCase(ch));
/*      */     }
/*      */ 
/*      */     protected void startDigitSentence(StringBuffer buffer, char ch)
/*      */     {
/* 1282 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void startDigitWord(StringBuffer buffer, char ch)
/*      */     {
/* 1289 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void inDigitWord(StringBuffer buffer, char ch)
/*      */     {
/* 1296 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void inDelimiter(StringBuffer buffer, char ch)
/*      */     {
/* 1303 */       if (ch != '_')
/* 1304 */         buffer.append(ch);
/*      */     }
/* 1246 */   };
/*      */ 
/* 1310 */   private static final WordTokenizer PASCAL_CASE_TOKENIZER = new WordTokenizer()
/*      */   {
/*      */     protected void startSentence(StringBuffer buffer, char ch)
/*      */     {
/* 1314 */       buffer.append(Character.toUpperCase(ch));
/*      */     }
/*      */ 
/*      */     protected void startWord(StringBuffer buffer, char ch)
/*      */     {
/* 1322 */       buffer.append(Character.toUpperCase(ch));
/*      */     }
/*      */ 
/*      */     protected void inWord(StringBuffer buffer, char ch)
/*      */     {
/* 1330 */       buffer.append(Character.toLowerCase(ch));
/*      */     }
/*      */ 
/*      */     protected void startDigitSentence(StringBuffer buffer, char ch)
/*      */     {
/* 1338 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void startDigitWord(StringBuffer buffer, char ch)
/*      */     {
/* 1345 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void inDigitWord(StringBuffer buffer, char ch)
/*      */     {
/* 1352 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void inDelimiter(StringBuffer buffer, char ch)
/*      */     {
/* 1359 */       if (ch != '_')
/* 1360 */         buffer.append(ch);
/*      */     }
/* 1310 */   };
/*      */ 
/* 1366 */   private static final WordTokenizer UPPER_CASE_WITH_UNDERSCORES_TOKENIZER = new WordTokenizer()
/*      */   {
/*      */     protected void startSentence(StringBuffer buffer, char ch)
/*      */     {
/* 1370 */       buffer.append(Character.toUpperCase(ch));
/*      */     }
/*      */ 
/*      */     protected void startWord(StringBuffer buffer, char ch)
/*      */     {
/* 1378 */       if (!isDelimiter(buffer.charAt(buffer.length() - 1)))
/*      */       {
/* 1381 */         buffer.append('_');
/*      */       }
/*      */ 
/* 1385 */       buffer.append(Character.toUpperCase(ch));
/*      */     }
/*      */ 
/*      */     protected void inWord(StringBuffer buffer, char ch)
/*      */     {
/* 1393 */       buffer.append(Character.toUpperCase(ch));
/*      */     }
/*      */ 
/*      */     protected void startDigitSentence(StringBuffer buffer, char ch)
/*      */     {
/* 1401 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void startDigitWord(StringBuffer buffer, char ch)
/*      */     {
/* 1408 */       if (!isDelimiter(buffer.charAt(buffer.length() - 1)))
/*      */       {
/* 1411 */         buffer.append('_');
/*      */       }
/*      */ 
/* 1415 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void inDigitWord(StringBuffer buffer, char ch)
/*      */     {
/* 1422 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void inDelimiter(StringBuffer buffer, char ch)
/*      */     {
/* 1429 */       buffer.append(ch);
/*      */     }
/* 1366 */   };
/*      */ 
/* 1434 */   private static final WordTokenizer LOWER_CASE_WITH_UNDERSCORES_TOKENIZER = new WordTokenizer()
/*      */   {
/*      */     protected void startSentence(StringBuffer buffer, char ch)
/*      */     {
/* 1438 */       buffer.append(Character.toLowerCase(ch));
/*      */     }
/*      */ 
/*      */     protected void startWord(StringBuffer buffer, char ch)
/*      */     {
/* 1446 */       if (!isDelimiter(buffer.charAt(buffer.length() - 1)))
/*      */       {
/* 1449 */         buffer.append('_');
/*      */       }
/*      */ 
/* 1453 */       buffer.append(Character.toLowerCase(ch));
/*      */     }
/*      */ 
/*      */     protected void inWord(StringBuffer buffer, char ch)
/*      */     {
/* 1461 */       buffer.append(Character.toLowerCase(ch));
/*      */     }
/*      */ 
/*      */     protected void startDigitSentence(StringBuffer buffer, char ch)
/*      */     {
/* 1469 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void startDigitWord(StringBuffer buffer, char ch)
/*      */     {
/* 1476 */       if (!isDelimiter(buffer.charAt(buffer.length() - 1)))
/*      */       {
/* 1479 */         buffer.append('_');
/*      */       }
/*      */ 
/* 1483 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void inDigitWord(StringBuffer buffer, char ch)
/*      */     {
/* 1490 */       buffer.append(ch);
/*      */     }
/*      */ 
/*      */     protected void inDelimiter(StringBuffer buffer, char ch)
/*      */     {
/* 1497 */       buffer.append(ch);
/*      */     }
/* 1434 */   };
/*      */ 
/*      */   public static void trim(Object pojo)
/*      */   {
/*   29 */     Field[] fields = pojo.getClass().getDeclaredFields();
/*   30 */     for (Field f : fields)
/*   31 */       if (f.getType() == String.class) {
/*   32 */         String fName = f.getName();
/*   33 */         String pojoGetSet = fName.substring(0, 1).toUpperCase() + fName.substring(1, fName.length());
/*      */         try
/*      */         {
/*   36 */           Method getter = pojo.getClass().getMethod("get" + pojoGetSet, new Class[0]);
/*   37 */           Method setter = pojo.getClass().getMethod("set" + pojoGetSet, new Class[] { String.class });
/*      */ 
/*   39 */           Object value = getter.invoke(pojo, new Object[0]);
/*   40 */           if (value != null)
/*   41 */             setter.invoke(pojo, new Object[] { com.hundsun.network.melody.common.util.StringUtil.trim(value.toString()) });
/*      */         }
/*      */         catch (SecurityException e)
/*      */         {
/*      */         }
/*      */         catch (NoSuchMethodException e)
/*      */         {
/*      */         }
/*      */         catch (IllegalArgumentException e)
/*      */         {
/*      */         }
/*      */         catch (IllegalAccessException e)
/*      */         {
/*      */         }
/*      */         catch (InvocationTargetException e)
/*      */         {
/*      */         }
/*      */       }
/*      */   }
/*      */ 
/*      */   public static void trim(Object pojo, String[] exceptFields)
/*      */   {
/*   63 */     Set exceptFieldSet = new HashSet(exceptFields.length);
/*   64 */     for (String f : exceptFields) {
/*   65 */       exceptFieldSet.add(f);
/*      */     }
/*      */ 
/*   68 */     Field[] fields = pojo.getClass().getDeclaredFields();
/*   69 */     for (Field f : fields)
/*   70 */       if (f.getType() == String.class) {
/*   71 */         String fName = f.getName();
/*   72 */         if (exceptFieldSet.contains(fName)) {
/*      */           continue;
/*      */         }
/*   75 */         String pojoGetSet = fName.substring(0, 1).toUpperCase() + fName.substring(1, fName.length());
/*      */         try
/*      */         {
/*   78 */           Method getter = pojo.getClass().getMethod("get" + pojoGetSet, new Class[0]);
/*   79 */           Method setter = pojo.getClass().getMethod("set" + pojoGetSet, new Class[] { String.class });
/*      */ 
/*   81 */           Object value = getter.invoke(pojo, new Object[0]);
/*   82 */           if (value != null)
/*   83 */             setter.invoke(pojo, new Object[] { com.hundsun.network.melody.common.util.StringUtil.trim(value.toString()) });
/*      */         }
/*      */         catch (SecurityException e)
/*      */         {
/*      */         }
/*      */         catch (NoSuchMethodException e)
/*      */         {
/*      */         }
/*      */         catch (IllegalArgumentException e)
/*      */         {
/*      */         }
/*      */         catch (IllegalAccessException e)
/*      */         {
/*      */         }
/*      */         catch (InvocationTargetException e)
/*      */         {
/*      */         }
/*      */       }
/*      */   }
/*      */ 
/*      */   public static boolean isEmpty(String str)
/*      */   {
/*  126 */     return (str == null) || (str.length() == 0);
/*      */   }
/*      */ 
/*      */   public static boolean isNotEmpty(String str)
/*      */   {
/*  144 */     return (str != null) && (str.length() > 0);
/*      */   }
/*      */ 
/*      */   public static boolean isBlank(String str)
/*      */   {
/*      */     int length;
/*  164 */     if ((str == null) || ((length = str.length()) == 0))
/*  165 */       return true;
/*  168 */     for (int i = 0; i < length; i++) {
/*  169 */       if (!Character.isWhitespace(str.charAt(i))) {
/*  170 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*  174 */     return true;
/*      */   }
/*      */ 
/*      */   public static boolean isNotBlank(String str)
/*      */   {
/*      */     int length;
/*  194 */     if ((str == null) || ((length = str.length()) == 0))
/*  195 */       return false;
/*      */     //int length;
/*  198 */     for (int i = 0; i < length; i++) {
/*  199 */       if (!Character.isWhitespace(str.charAt(i))) {
/*  200 */         return true;
/*      */       }
/*      */     }
/*      */ 
/*  204 */     return false;
/*      */   }
/*      */ 
/*      */   public static String defaultIfNull(String str)
/*      */   {
/*  227 */     return str == null ? "" : str;
/*      */   }
/*      */ 
/*      */   public static String defaultIfNull(String str, String defaultStr)
/*      */   {
/*  245 */     return str == null ? defaultStr : str;
/*      */   }
/*      */ 
/*      */   public static String defaultIfEmpty(String str)
/*      */   {
/*  266 */     return str == null ? "" : str;
/*      */   }
/*      */ 
/*      */   public static String defaultIfEmpty(String str, String defaultStr)
/*      */   {
/*  284 */     return (str == null) || (str.length() == 0) ? defaultStr : str;
/*      */   }
/*      */ 
/*      */   public static String defaultIfBlank(String str)
/*      */   {
/*  301 */     return isBlank(str) ? "" : str;
/*      */   }
/*      */ 
/*      */   public static String defaultIfBlank(String str, String defaultStr)
/*      */   {
/*  319 */     return isBlank(str) ? defaultStr : str;
/*      */   }
/*      */ 
/*      */   public static String trim(String str)
/*      */   {
/*  348 */     return trim(str, null, 0);
/*      */   }
/*      */ 
/*      */   public static String trim(String str, String stripChars)
/*      */   {
/*  369 */     return trim(str, stripChars, 0);
/*      */   }
/*      */ 
/*      */   public static String trimStart(String str)
/*      */   {
/*  393 */     return trim(str, null, -1);
/*      */   }
/*      */ 
/*      */   public static String trimStart(String str, String stripChars)
/*      */   {
/*  415 */     return trim(str, stripChars, -1);
/*      */   }
/*      */ 
/*      */   public static String trimEnd(String str)
/*      */   {
/*  439 */     return trim(str, null, 1);
/*      */   }
/*      */ 
/*      */   public static String trimEnd(String str, String stripChars)
/*      */   {
/*  461 */     return trim(str, stripChars, 1);
/*      */   }
/*      */ 
/*      */   public static String trimToNull(String str)
/*      */   {
/*  484 */     return trimToNull(str, null);
/*      */   }
/*      */ 
/*      */   public static String trimToNull(String str, String stripChars)
/*      */   {
/*  510 */     String result = trim(str, stripChars);
/*      */ 
/*  512 */     if ((result == null) || (result.length() == 0)) {
/*  513 */       return null;
/*      */     }
/*      */ 
/*  516 */     return result;
/*      */   }
/*      */ 
/*      */   public static String trimToEmpty(String str)
/*      */   {
/*  539 */     return trimToEmpty(str, null);
/*      */   }
/*      */ 
/*      */   public static String trimToEmpty(String str, String stripChars)
/*      */   {
/*  564 */     String result = trim(str, stripChars);
/*      */ 
/*  566 */     if (result == null) {
/*  567 */       return "";
/*      */     }
/*      */ 
/*  570 */     return result;
/*      */   }
/*      */ 
/*      */   private static String trim(String str, String stripChars, int mode)
/*      */   {
/*  592 */     if (str == null) {
/*  593 */       return null;
/*      */     }
/*      */ 
/*  596 */     int length = str.length();
/*  597 */     int start = 0;
/*  598 */     int end = length;
/*      */ 
/*  601 */     if (mode <= 0) {
/*  602 */       if (stripChars == null) {
/*  603 */         while ((start < end) && (Character.isWhitespace(str.charAt(start))))
/*  604 */           start++;
/*      */       }
/*  606 */       if (stripChars.length() == 0) {
/*  607 */         return str;
/*      */       }
/*  609 */       while ((start < end) && (stripChars.indexOf(str.charAt(start)) != -1)) {
/*  610 */         start++;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  616 */     if (mode >= 0) {
/*  617 */       if (stripChars == null) {
/*  618 */         while ((start < end) && (Character.isWhitespace(str.charAt(end - 1))))
/*  619 */           end--;
/*      */       }
/*  621 */       if (stripChars.length() == 0) {
/*  622 */         return str;
/*      */       }
/*  624 */       while ((start < end) && (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
/*  625 */         end--;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  630 */     if ((start > 0) || (end < length)) {
/*  631 */       return str.substring(start, end);
/*      */     }
/*      */ 
/*  634 */     return str;
/*      */   }
/*      */ 
/*      */   public static boolean equals(String str1, String str2)
/*      */   {
/*  659 */     if (str1 == null) {
/*  660 */       return str2 == null;
/*      */     }
/*      */ 
/*  663 */     return str1.equals(str2);
/*      */   }
/*      */ 
/*      */   public static boolean equalsIgnoreCase(String str1, String str2)
/*      */   {
/*  682 */     if (str1 == null) {
/*  683 */       return str2 == null;
/*      */     }
/*      */ 
/*  686 */     return str1.equalsIgnoreCase(str2);
/*      */   }
/*      */ 
/*      */   public static boolean isAlpha(String str)
/*      */   {
/*  715 */     if (str == null) {
/*  716 */       return false;
/*      */     }
/*      */ 
/*  719 */     int length = str.length();
/*      */ 
/*  721 */     for (int i = 0; i < length; i++) {
/*  722 */       if (!Character.isLetter(str.charAt(i))) {
/*  723 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*  727 */     return true;
/*      */   }
/*      */ 
/*      */   public static boolean isAlphaSpace(String str)
/*      */   {
/*  751 */     if (str == null) {
/*  752 */       return false;
/*      */     }
/*      */ 
/*  755 */     int length = str.length();
/*      */ 
/*  757 */     for (int i = 0; i < length; i++) {
/*  758 */       if ((!Character.isLetter(str.charAt(i))) && (str.charAt(i) != ' ')) {
/*  759 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*  763 */     return true;
/*      */   }
/*      */ 
/*      */   public static boolean isAlphanumeric(String str)
/*      */   {
/*  787 */     if (str == null) {
/*  788 */       return false;
/*      */     }
/*      */ 
/*  791 */     int length = str.length();
/*      */ 
/*  793 */     for (int i = 0; i < length; i++) {
/*  794 */       if (!Character.isLetterOrDigit(str.charAt(i))) {
/*  795 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*  799 */     return true;
/*      */   }
/*      */ 
/*      */   public static boolean isAlphanumericSpace(String str)
/*      */   {
/*  823 */     if (str == null) {
/*  824 */       return false;
/*      */     }
/*      */ 
/*  827 */     int length = str.length();
/*      */ 
/*  829 */     for (int i = 0; i < length; i++) {
/*  830 */       if ((!Character.isLetterOrDigit(str.charAt(i))) && (str.charAt(i) != ' ')) {
/*  831 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*  835 */     return true;
/*      */   }
/*      */ 
/*      */   public static boolean isNumeric(String str)
/*      */   {
/*  860 */     if (str == null) {
/*  861 */       return false;
/*      */     }
/*      */ 
/*  864 */     int length = str.length();
/*      */ 
/*  866 */     for (int i = 0; i < length; i++) {
/*  867 */       if (!Character.isDigit(str.charAt(i))) {
/*  868 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*  872 */     return true;
/*      */   }
/*      */ 
/*      */   public static boolean isNumber(String str)
/*      */   {
/*  897 */     if (isBlank(str)) {
/*  898 */       return false;
/*      */     }
/*  900 */     int index = str.indexOf(".");
/*  901 */     if (index < 0) {
/*  902 */       return isNumeric(str);
/*      */     }
/*  904 */     String num1 = str.substring(0, index);
/*  905 */     String num2 = str.substring(index + 1);
/*  906 */     return (isNumeric(num1)) && (isNumeric(num2));
/*      */   }
/*      */ 
/*      */   public static boolean isNumericSpace(String str)
/*      */   {
/*  933 */     if (str == null) {
/*  934 */       return false;
/*      */     }
/*      */ 
/*  937 */     int length = str.length();
/*      */ 
/*  939 */     for (int i = 0; i < length; i++) {
/*  940 */       if ((!Character.isDigit(str.charAt(i))) && (str.charAt(i) != ' ')) {
/*  941 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*  945 */     return true;
/*      */   }
/*      */ 
/*      */   public static boolean isWhitespace(String str)
/*      */   {
/*  968 */     if (str == null) {
/*  969 */       return false;
/*      */     }
/*      */ 
/*  972 */     int length = str.length();
/*      */ 
/*  974 */     for (int i = 0; i < length; i++) {
/*  975 */       if (!Character.isWhitespace(str.charAt(i))) {
/*  976 */         return false;
/*      */       }
/*      */     }
/*      */ 
/*  980 */     return true;
/*      */   }
/*      */ 
/*      */   public static String toUpperCase(String str)
/*      */   {
/* 1004 */     if (str == null) {
/* 1005 */       return null;
/*      */     }
/*      */ 
/* 1008 */     return str.toUpperCase();
/*      */   }
/*      */ 
/*      */   public static String toLowerCase(String str)
/*      */   {
/* 1028 */     if (str == null) {
/* 1029 */       return null;
/*      */     }
/*      */ 
/* 1032 */     return str.toLowerCase();
/*      */   }
/*      */ 
/*      */   public static String capitalize(String str)
/*      */   {
/*      */     int strLen;
/* 1055 */     if ((str == null) || ((strLen = str.length()) == 0))
/* 1056 */       return str;
/*      */     //int strLen;
/* 1059 */     return new StringBuffer(strLen).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString();
/*      */   }
/*      */ 
/*      */   public static String uncapitalize(String str)
/*      */   {
/*      */     int strLen;
/* 1083 */     if ((str == null) || ((strLen = str.length()) == 0))
/* 1084 */       return str;
/*      */     //int strLen;
/* 1087 */     return new StringBuffer(strLen).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
/*      */   }
/*      */ 
/*      */   public static String swapCase(String str)
/*      */   {
/*      */     int strLen;
/* 1110 */     if ((str == null) || ((strLen = str.length()) == 0))
/* 1111 */       return str;
/*      */     //int strLen;
/* 1114 */     StringBuffer buffer = new StringBuffer(strLen);
/*      */ 
/* 1116 */     char ch = '\000';
/*      */ 
/* 1118 */     for (int i = 0; i < strLen; i++) {
/* 1119 */       ch = str.charAt(i);
/*      */ 
/* 1121 */       if (Character.isUpperCase(ch))
/* 1122 */         ch = Character.toLowerCase(ch);
/* 1123 */       else if (Character.isTitleCase(ch))
/* 1124 */         ch = Character.toLowerCase(ch);
/* 1125 */       else if (Character.isLowerCase(ch)) {
/* 1126 */         ch = Character.toUpperCase(ch);
/*      */       }
/*      */ 
/* 1129 */       buffer.append(ch);
/*      */     }
/*      */ 
/* 1132 */     return buffer.toString();
/*      */   }
/*      */ 
/*      */   public static String toCamelCase(String str)
/*      */   {
/* 1159 */     return CAMEL_CASE_TOKENIZER.parse(str);
/*      */   }
/*      */ 
/*      */   public static String toPascalCase(String str)
/*      */   {
/* 1186 */     return PASCAL_CASE_TOKENIZER.parse(str);
/*      */   }
/*      */ 
/*      */   public static String toUpperCaseWithUnderscores(String str)
/*      */   {
/* 1214 */     return UPPER_CASE_WITH_UNDERSCORES_TOKENIZER.parse(str);
/*      */   }
/*      */ 
/*      */   public static String toLowerCaseWithUnderscores(String str)
/*      */   {
/* 1242 */     return LOWER_CASE_WITH_UNDERSCORES_TOKENIZER.parse(str);
/*      */   }
/*      */ 
/*      */   public static String[] split(String str)
/*      */   {
/* 1734 */     return split(str, null, -1);
/*      */   }
/*      */ 
/*      */   public static String[] split(String str, char separatorChar)
/*      */   {
/* 1758 */     if (str == null) {
/* 1759 */       return null;
/*      */     }
/*      */ 
/* 1762 */     int length = str.length();
/*      */ 
/* 1764 */     if (length == 0) {
/* 1765 */       return ArrayUtil.EMPTY_STRING_ARRAY;
/*      */     }
/*      */ 
/* 1768 */     List list = new ArrayList();
/* 1769 */     int i = 0;
/* 1770 */     int start = 0;
/* 1771 */     boolean match = false;
/*      */ 
/* 1773 */     while (i < length) {
/* 1774 */       if (str.charAt(i) == separatorChar) {
/* 1775 */         if (match) {
/* 1776 */           list.add(str.substring(start, i));
/* 1777 */           match = false;
/*      */         }
/*      */ 
/* 1780 */         i++; start = i;
/* 1781 */         continue;
/*      */       }
/*      */ 
/* 1784 */       match = true;
/* 1785 */       i++;
/*      */     }
/*      */ 
/* 1788 */     if (match) {
/* 1789 */       list.add(str.substring(start, i));
/*      */     }
/*      */ 
/* 1792 */     return (String[])(String[])list.toArray(new String[list.size()]);
/*      */   }
/*      */ 
/*      */   public static String[] split(String str, String separatorChars)
/*      */   {
/* 1817 */     return split(str, separatorChars, -1);
/*      */   }
/*      */ 
/*      */   public static String[] split(String str, String separatorChars, int max)
/*      */   {
/* 1843 */     if (str == null) {
/* 1844 */       return null;
/*      */     }
/*      */ 
/* 1847 */     int length = str.length();
/*      */ 
/* 1849 */     if (length == 0) {
/* 1850 */       return ArrayUtil.EMPTY_STRING_ARRAY;
/*      */     }
/*      */ 
/* 1853 */     List list = new ArrayList();
/* 1854 */     int sizePlus1 = 1;
/* 1855 */     int i = 0;
/* 1856 */     int start = 0;
/* 1857 */     boolean match = false;
/*      */ 
/* 1859 */     if (separatorChars == null)
/*      */     {
/* 1861 */       while (i < length) {
/* 1862 */         if (Character.isWhitespace(str.charAt(i))) {
/* 1863 */           if (match) {
/* 1864 */             if (sizePlus1++ == max) {
/* 1865 */               i = length;
/*      */             }
/*      */ 
/* 1868 */             list.add(str.substring(start, i));
/* 1869 */             match = false;
/*      */           }
/*      */ 
/* 1872 */           i++; start = i;
/* 1873 */           continue;
/*      */         }
/*      */ 
/* 1876 */         match = true;
/* 1877 */         i++;
/*      */       }
/*      */     }
/* 1879 */     if (separatorChars.length() == 1)
/*      */     {
/* 1881 */       char sep = separatorChars.charAt(0);
/*      */ 
/* 1883 */       while (i < length) {
/* 1884 */         if (str.charAt(i) == sep) {
/* 1885 */           if (match) {
/* 1886 */             if (sizePlus1++ == max) {
/* 1887 */               i = length;
/*      */             }
/*      */ 
/* 1890 */             list.add(str.substring(start, i));
/* 1891 */             match = false;
/*      */           }
/*      */ 
/* 1894 */           i++; start = i;
/* 1895 */           continue;
/*      */         }
/*      */ 
/* 1898 */         match = true;
/* 1899 */         i++;
/*      */       }
/*      */     }
/*      */     else {
/* 1903 */       while (i < length) {
/* 1904 */         if (separatorChars.indexOf(str.charAt(i)) >= 0) {
/* 1905 */           if (match) {
/* 1906 */             if (sizePlus1++ == max) {
/* 1907 */               i = length;
/*      */             }
/*      */ 
/* 1910 */             list.add(str.substring(start, i));
/* 1911 */             match = false;
/*      */           }
/*      */ 
/* 1914 */           i++; start = i;
/* 1915 */           continue;
/*      */         }
/*      */ 
/* 1918 */         match = true;
/* 1919 */         i++;
/*      */       }
/*      */     }
/*      */ 
/* 1923 */     if (match) {
/* 1924 */       list.add(str.substring(start, i));
/*      */     }
/*      */ 
/* 1927 */     return (String[])(String[])list.toArray(new String[list.size()]);
/*      */   }
/*      */ 
/*      */   public static String join(Object[] array)
/*      */   {
/* 1951 */     return join(array, null);
/*      */   }
/*      */ 
/*      */   public static String join(Object[] array, char separator)
/*      */   {
/* 1971 */     if (array == null) {
/* 1972 */       return null;
/*      */     }
/*      */ 
/* 1975 */     int arraySize = array.length;
/* 1976 */     int bufSize = arraySize == 0 ? 0 : ((array[0] == null ? 16 : array[0].toString().length()) + 1) * arraySize;
/*      */ 
/* 1978 */     StringBuffer buf = new StringBuffer(bufSize);
/*      */ 
/* 1980 */     for (int i = 0; i < arraySize; i++) {
/* 1981 */       if (i > 0) {
/* 1982 */         buf.append(separator);
/*      */       }
/*      */ 
/* 1985 */       if (array[i] != null) {
/* 1986 */         buf.append(array[i]);
/*      */       }
/*      */     }
/*      */ 
/* 1990 */     return buf.toString();
/*      */   }
/*      */ 
/*      */   public static String join(Object[] array, String separator)
/*      */   {
/* 2011 */     if (array == null) {
/* 2012 */       return null;
/*      */     }
/*      */ 
/* 2015 */     if (separator == null) {
/* 2016 */       separator = "";
/*      */     }
/*      */ 
/* 2019 */     int arraySize = array.length;
/*      */ 
/* 2024 */     int bufSize = arraySize == 0 ? 0 : arraySize * ((array[0] == null ? 16 : array[0].toString().length()) + (separator != null ? separator.length() : 0));
/*      */ 
/* 2027 */     StringBuffer buf = new StringBuffer(bufSize);
/*      */ 
/* 2029 */     for (int i = 0; i < arraySize; i++) {
/* 2030 */       if ((separator != null) && (i > 0)) {
/* 2031 */         buf.append(separator);
/*      */       }
/*      */ 
/* 2034 */       if (array[i] != null) {
/* 2035 */         buf.append(array[i]);
/*      */       }
/*      */     }
/*      */ 
/* 2039 */     return buf.toString();
/*      */   }
/*      */ 
/*      */   public static String join(Iterator iterator, char separator)
/*      */   {
/* 2060 */     if (iterator == null) {
/* 2061 */       return null;
/*      */     }
/*      */ 
/* 2064 */     StringBuffer buf = new StringBuffer(256);
/*      */ 
/* 2066 */     while (iterator.hasNext()) {
/* 2067 */       Object obj = iterator.next();
/*      */ 
/* 2069 */       if (obj != null) {
/* 2070 */         buf.append(obj);
/*      */       }
/*      */ 
/* 2073 */       if (iterator.hasNext()) {
/* 2074 */         buf.append(separator);
/*      */       }
/*      */     }
/*      */ 
/* 2078 */     return buf.toString();
/*      */   }
/*      */ 
/*      */   public static String join(Iterator iterator, String separator)
/*      */   {
/* 2099 */     if (iterator == null) {
/* 2100 */       return null;
/*      */     }
/*      */ 
/* 2103 */     StringBuffer buf = new StringBuffer(256);
/*      */ 
/* 2105 */     while (iterator.hasNext()) {
/* 2106 */       Object obj = iterator.next();
/*      */ 
/* 2108 */       if (obj != null) {
/* 2109 */         buf.append(obj);
/*      */       }
/*      */ 
/* 2112 */       if ((separator != null) && (iterator.hasNext())) {
/* 2113 */         buf.append(separator);
/*      */       }
/*      */     }
/*      */ 
/* 2117 */     return buf.toString();
/*      */   }
/*      */ 
/*      */   public static int indexOf(String str, char searchChar)
/*      */   {
/* 2141 */     if ((str == null) || (str.length() == 0)) {
/* 2142 */       return -1;
/*      */     }
/*      */ 
/* 2145 */     return str.indexOf(searchChar);
/*      */   }
/*      */ 
/*      */   public static int indexOf(String str, char searchChar, int startPos)
/*      */   {
/* 2166 */     if ((str == null) || (str.length() == 0)) {
/* 2167 */       return -1;
/*      */     }
/*      */ 
/* 2170 */     return str.indexOf(searchChar, startPos);
/*      */   }
/*      */ 
/*      */   public static int indexOf(String str, String searchStr)
/*      */   {
/* 2191 */     if ((str == null) || (searchStr == null)) {
/* 2192 */       return -1;
/*      */     }
/*      */ 
/* 2195 */     return str.indexOf(searchStr);
/*      */   }
/*      */ 
/*      */   public static int indexOf(String str, String searchStr, int startPos)
/*      */   {
/* 2221 */     if ((str == null) || (searchStr == null)) {
/* 2222 */       return -1;
/*      */     }
/*      */ 
/* 2226 */     if ((searchStr.length() == 0) && (startPos >= str.length())) {
/* 2227 */       return str.length();
/*      */     }
/*      */ 
/* 2230 */     return str.indexOf(searchStr, startPos);
/*      */   }
/*      */ 
/*      */   public static int indexOfAny(String str, char[] searchChars)
/*      */   {
/* 2252 */     if ((str == null) || (str.length() == 0) || (searchChars == null) || (searchChars.length == 0))
/*      */     {
/* 2254 */       return -1;
/*      */     }
/*      */ 
/* 2257 */     for (int i = 0; i < str.length(); i++) {
/* 2258 */       char ch = str.charAt(i);
/*      */ 
/* 2260 */       for (int j = 0; j < searchChars.length; j++) {
/* 2261 */         if (searchChars[j] == ch) {
/* 2262 */           return i;
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 2267 */     return -1;
/*      */   }
/*      */ 
/*      */   public static int indexOfAny(String str, String searchChars)
/*      */   {
/* 2289 */     if ((str == null) || (str.length() == 0) || (searchChars == null) || (searchChars.length() == 0))
/*      */     {
/* 2291 */       return -1;
/*      */     }
/*      */ 
/* 2294 */     for (int i = 0; i < str.length(); i++) {
/* 2295 */       char ch = str.charAt(i);
/*      */ 
/* 2297 */       for (int j = 0; j < searchChars.length(); j++) {
/* 2298 */         if (searchChars.charAt(j) == ch) {
/* 2299 */           return i;
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 2304 */     return -1;
/*      */   }
/*      */ 
/*      */   public static int indexOfAny(String str, String[] searchStrs)
/*      */   {
/* 2330 */     if ((str == null) || (searchStrs == null)) {
/* 2331 */       return -1;
/*      */     }
/*      */ 
/* 2334 */     int sz = searchStrs.length;
/*      */ 
/* 2337 */     int ret = 2147483647;
/*      */ 
/* 2339 */     int tmp = 0;
/*      */ 
/* 2341 */     for (int i = 0; i < sz; i++) {
/* 2342 */       String search = searchStrs[i];
/*      */ 
/* 2344 */       if (search == null)
/*      */       {
/*      */         continue;
/*      */       }
/* 2348 */       tmp = str.indexOf(search);
/*      */ 
/* 2350 */       if (tmp == -1)
/*      */       {
/*      */         continue;
/*      */       }
/* 2354 */       if (tmp < ret) {
/* 2355 */         ret = tmp;
/*      */       }
/*      */     }
/*      */ 
/* 2359 */     return ret == 2147483647 ? -1 : ret;
/*      */   }
/*      */ 
/*      */   public static int indexOfAnyBut(String str, char[] searchChars)
/*      */   {
/* 2381 */     if ((str == null) || (str.length() == 0) || (searchChars == null) || (searchChars.length == 0))
/*      */     {
/* 2383 */       return -1;
/*      */     }
/*      */ 
/* 2386 */     for (int i = 0; i < str.length(); i++) {
/* 2387 */       char ch = str.charAt(i);
/*      */ 
/* 2389 */       int j = 0;
/*      */       while (true) if (j < searchChars.length) {
/* 2390 */           if (searchChars[j] == ch)
/*      */             break;
/* 2389 */           j++; continue;
/*      */         }
/*      */         else
/*      */         {
/* 2395 */           return i;
/*      */         }
/*      */     }
/* 2398 */     return -1;
/*      */   }
/*      */ 
/*      */   public static int indexOfAnyBut(String str, String searchChars)
/*      */   {
/* 2420 */     if ((str == null) || (str.length() == 0) || (searchChars == null) || (searchChars.length() == 0))
/*      */     {
/* 2422 */       return -1;
/*      */     }
/*      */ 
/* 2425 */     for (int i = 0; i < str.length(); i++) {
/* 2426 */       if (searchChars.indexOf(str.charAt(i)) < 0) {
/* 2427 */         return i;
/*      */       }
/*      */     }
/*      */ 
/* 2431 */     return -1;
/*      */   }
/*      */ 
/*      */   public static int lastIndexOf(String str, char searchChar)
/*      */   {
/* 2449 */     if ((str == null) || (str.length() == 0)) {
/* 2450 */       return -1;
/*      */     }
/*      */ 
/* 2453 */     return str.lastIndexOf(searchChar);
/*      */   }
/*      */ 
/*      */   public static int lastIndexOf(String str, char searchChar, int startPos)
/*      */   {
/* 2476 */     if ((str == null) || (str.length() == 0)) {
/* 2477 */       return -1;
/*      */     }
/*      */ 
/* 2480 */     return str.lastIndexOf(searchChar, startPos);
/*      */   }
/*      */ 
/*      */   public static int lastIndexOf(String str, String searchStr)
/*      */   {
/* 2498 */     if ((str == null) || (searchStr == null)) {
/* 2499 */       return -1;
/*      */     }
/*      */ 
/* 2502 */     return str.lastIndexOf(searchStr);
/*      */   }
/*      */ 
/*      */   public static int lastIndexOf(String str, String searchStr, int startPos)
/*      */   {
/* 2526 */     if ((str == null) || (searchStr == null)) {
/* 2527 */       return -1;
/*      */     }
/*      */ 
/* 2530 */     return str.lastIndexOf(searchStr, startPos);
/*      */   }
/*      */ 
/*      */   public static int lastIndexOfAny(String str, String[] searchStrs)
/*      */   {
/* 2555 */     if ((str == null) || (searchStrs == null)) {
/* 2556 */       return -1;
/*      */     }
/*      */ 
/* 2559 */     int searchStrsLength = searchStrs.length;
/* 2560 */     int index = -1;
/* 2561 */     int tmp = 0;
/*      */ 
/* 2563 */     for (int i = 0; i < searchStrsLength; i++) {
/* 2564 */       String search = searchStrs[i];
/*      */ 
/* 2566 */       if (search == null)
/*      */       {
/*      */         continue;
/*      */       }
/* 2570 */       tmp = str.lastIndexOf(search);
/*      */ 
/* 2572 */       if (tmp > index) {
/* 2573 */         index = tmp;
/*      */       }
/*      */     }
/*      */ 
/* 2577 */     return index;
/*      */   }
/*      */ 
/*      */   public static boolean contains(String str, char searchChar)
/*      */   {
/* 2595 */     if ((str == null) || (str.length() == 0)) {
/* 2596 */       return false;
/*      */     }
/*      */ 
/* 2599 */     return str.indexOf(searchChar) >= 0;
/*      */   }
/*      */ 
/*      */   public static boolean contains(String str, String searchStr)
/*      */   {
/* 2619 */     if ((str == null) || (searchStr == null)) {
/* 2620 */       return false;
/*      */     }
/*      */ 
/* 2623 */     return str.indexOf(searchStr) >= 0;
/*      */   }
/*      */ 
/*      */   public static boolean containsOnly(String str, char[] valid)
/*      */   {
/* 2649 */     if ((valid == null) || (str == null)) {
/* 2650 */       return false;
/*      */     }
/*      */ 
/* 2653 */     if (str.length() == 0) {
/* 2654 */       return true;
/*      */     }
/*      */ 
/* 2657 */     if (valid.length == 0) {
/* 2658 */       return false;
/*      */     }
/*      */ 
/* 2661 */     return indexOfAnyBut(str, valid) == -1;
/*      */   }
/*      */ 
/*      */   public static boolean containsOnly(String str, String valid)
/*      */   {
/* 2687 */     if ((str == null) || (valid == null)) {
/* 2688 */       return false;
/*      */     }
/*      */ 
/* 2691 */     return containsOnly(str, valid.toCharArray());
/*      */   }
/*      */ 
/*      */   public static boolean containsNone(String str, char[] invalid)
/*      */   {
/* 2717 */     if ((str == null) || (invalid == null)) {
/* 2718 */       return true;
/*      */     }
/*      */ 
/* 2721 */     int strSize = str.length();
/* 2722 */     int validSize = invalid.length;
/*      */ 
/* 2724 */     for (int i = 0; i < strSize; i++) {
/* 2725 */       char ch = str.charAt(i);
/*      */ 
/* 2727 */       for (int j = 0; j < validSize; j++) {
/* 2728 */         if (invalid[j] == ch) {
/* 2729 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 2734 */     return true;
/*      */   }
/*      */ 
/*      */   public static boolean containsNone(String str, String invalidChars)
/*      */   {
/* 2760 */     if ((str == null) || (invalidChars == null)) {
/* 2761 */       return true;
/*      */     }
/*      */ 
/* 2764 */     return containsNone(str, invalidChars.toCharArray());
/*      */   }
/*      */ 
/*      */   public static int countMatches(String str, String subStr)
/*      */   {
/* 2789 */     if ((str == null) || (str.length() == 0) || (subStr == null) || (subStr.length() == 0)) {
/* 2790 */       return 0;
/*      */     }
/*      */ 
/* 2793 */     int count = 0;
/* 2794 */     int index = 0;
/*      */ 
/* 2796 */     while ((index = str.indexOf(subStr, index)) != -1) {
/* 2797 */       count++;
/* 2798 */       index += subStr.length();
/*      */     }
/*      */ 
/* 2801 */     return count;
/*      */   }
/*      */ 
/*      */   public static String substring(String str, int start)
/*      */   {
/* 2830 */     if (str == null) {
/* 2831 */       return null;
/*      */     }
/*      */ 
/* 2834 */     if (start < 0) {
/* 2835 */       start = str.length() + start;
/*      */     }
/*      */ 
/* 2838 */     if (start < 0) {
/* 2839 */       start = 0;
/*      */     }
/*      */ 
/* 2842 */     if (start > str.length()) {
/* 2843 */       return "";
/*      */     }
/*      */ 
/* 2846 */     return str.substring(start);
/*      */   }
/*      */ 
/*      */   public static String substring(String str, int start, int end)
/*      */   {
/* 2874 */     if (str == null) {
/* 2875 */       return null;
/*      */     }
/*      */ 
/* 2878 */     if (end < 0) {
/* 2879 */       end = str.length() + end;
/*      */     }
/*      */ 
/* 2882 */     if (start < 0) {
/* 2883 */       start = str.length() + start;
/*      */     }
/*      */ 
/* 2886 */     if (end > str.length()) {
/* 2887 */       end = str.length();
/*      */     }
/*      */ 
/* 2890 */     if (start > end) {
/* 2891 */       return "";
/*      */     }
/*      */ 
/* 2894 */     if (start < 0) {
/* 2895 */       start = 0;
/*      */     }
/*      */ 
/* 2898 */     if (end < 0) {
/* 2899 */       end = 0;
/*      */     }
/*      */ 
/* 2902 */     return str.substring(start, end);
/*      */   }
/*      */ 
/*      */   public static String left(String str, int len)
/*      */   {
/* 2922 */     if (str == null) {
/* 2923 */       return null;
/*      */     }
/*      */ 
/* 2926 */     if (len < 0) {
/* 2927 */       return "";
/*      */     }
/*      */ 
/* 2930 */     if (str.length() <= len) {
/* 2931 */       return str;
/*      */     }
/* 2933 */     return str.substring(0, len);
/*      */   }
/*      */ 
/*      */   public static String right(String str, int len)
/*      */   {
/* 2954 */     if (str == null) {
/* 2955 */       return null;
/*      */     }
/*      */ 
/* 2958 */     if (len < 0) {
/* 2959 */       return "";
/*      */     }
/*      */ 
/* 2962 */     if (str.length() <= len) {
/* 2963 */       return str;
/*      */     }
/* 2965 */     return str.substring(str.length() - len);
/*      */   }
/*      */ 
/*      */   public static String mid(String str, int pos, int len)
/*      */   {
/* 2989 */     if (str == null) {
/* 2990 */       return null;
/*      */     }
/*      */ 
/* 2993 */     if ((len < 0) || (pos > str.length())) {
/* 2994 */       return "";
/*      */     }
/*      */ 
/* 2997 */     if (pos < 0) {
/* 2998 */       pos = 0;
/*      */     }
/*      */ 
/* 3001 */     if (str.length() <= pos + len) {
/* 3002 */       return str.substring(pos);
/*      */     }
/* 3004 */     return str.substring(pos, pos + len);
/*      */   }
/*      */ 
/*      */   public static String substringBefore(String str, String separator)
/*      */   {
/* 3035 */     if ((str == null) || (separator == null) || (str.length() == 0)) {
/* 3036 */       return str;
/*      */     }
/*      */ 
/* 3039 */     if (separator.length() == 0) {
/* 3040 */       return "";
/*      */     }
/*      */ 
/* 3043 */     int pos = str.indexOf(separator);
/*      */ 
/* 3045 */     if (pos == -1) {
/* 3046 */       return str;
/*      */     }
/*      */ 
/* 3049 */     return str.substring(0, pos);
/*      */   }
/*      */ 
/*      */   public static String substringAfter(String str, String separator)
/*      */   {
/* 3075 */     if ((str == null) || (str.length() == 0)) {
/* 3076 */       return str;
/*      */     }
/*      */ 
/* 3079 */     if (separator == null) {
/* 3080 */       return "";
/*      */     }
/*      */ 
/* 3083 */     int pos = str.indexOf(separator);
/*      */ 
/* 3085 */     if (pos == -1) {
/* 3086 */       return "";
/*      */     }
/*      */ 
/* 3089 */     return str.substring(pos + separator.length());
/*      */   }
/*      */ 
/*      */   public static String substringBeforeLast(String str, String separator)
/*      */   {
/* 3115 */     if ((str == null) || (separator == null) || (str.length() == 0) || (separator.length() == 0))
/*      */     {
/* 3117 */       return str;
/*      */     }
/*      */ 
/* 3120 */     int pos = str.lastIndexOf(separator);
/*      */ 
/* 3122 */     if (pos == -1) {
/* 3123 */       return str;
/*      */     }
/*      */ 
/* 3126 */     return str.substring(0, pos);
/*      */   }
/*      */ 
/*      */   public static String substringAfterLast(String str, String separator)
/*      */   {
/* 3153 */     if ((str == null) || (str.length() == 0)) {
/* 3154 */       return str;
/*      */     }
/*      */ 
/* 3157 */     if ((separator == null) || (separator.length() == 0)) {
/* 3158 */       return "";
/*      */     }
/*      */ 
/* 3161 */     int pos = str.lastIndexOf(separator);
/*      */ 
/* 3163 */     if ((pos == -1) || (pos == str.length() - separator.length())) {
/* 3164 */       return "";
/*      */     }
/*      */ 
/* 3167 */     return str.substring(pos + separator.length());
/*      */   }
/*      */ 
/*      */   public static String substringBetween(String str, String tag)
/*      */   {
/* 3191 */     return substringBetween(str, tag, tag, 0);
/*      */   }
/*      */ 
/*      */   public static String substringBetween(String str, String open, String close)
/*      */   {
/* 3218 */     return substringBetween(str, open, close, 0);
/*      */   }
/*      */ 
/*      */   public static String substringBetween(String str, String open, String close, int fromIndex)
/*      */   {
/* 3246 */     if ((str == null) || (open == null) || (close == null)) {
/* 3247 */       return null;
/*      */     }
/*      */ 
/* 3250 */     int start = str.indexOf(open, fromIndex);
/*      */ 
/* 3252 */     if (start != -1) {
/* 3253 */       int end = str.indexOf(close, start + open.length());
/*      */ 
/* 3255 */       if (end != -1) {
/* 3256 */         return str.substring(start + open.length(), end);
/*      */       }
/*      */     }
/*      */ 
/* 3260 */     return null;
/*      */   }
/*      */ 
/*      */   public static String deleteWhitespace(String str)
/*      */   {
/* 3281 */     if (str == null) {
/* 3282 */       return null;
/*      */     }
/*      */ 
/* 3285 */     int sz = str.length();
/* 3286 */     StringBuffer buffer = new StringBuffer(sz);
/*      */ 
/* 3288 */     for (int i = 0; i < sz; i++) {
/* 3289 */       if (!Character.isWhitespace(str.charAt(i))) {
/* 3290 */         buffer.append(str.charAt(i));
/*      */       }
/*      */     }
/*      */ 
/* 3294 */     return buffer.toString();
/*      */   }
/*      */ 
/*      */   public static String replaceOnce(String text, String repl, String with)
/*      */   {
/* 3324 */     return replace(text, repl, with, 1);
/*      */   }
/*      */ 
/*      */   public static String replace(String text, String repl, String with)
/*      */   {
/* 3350 */     return replace(text, repl, with, -1);
/*      */   }
/*      */ 
/*      */   public static String replace(String text, String repl, String with, int max)
/*      */   {
/* 3380 */     if ((text == null) || (repl == null) || (with == null) || (repl.length() == 0) || (max == 0))
/*      */     {
/* 3382 */       return text;
/*      */     }
/*      */ 
/* 3385 */     StringBuffer buf = new StringBuffer(text.length());
/* 3386 */     int start = 0;
/* 3387 */     int end = 0;
/*      */ 
/* 3389 */     while ((end = text.indexOf(repl, start)) != -1) {
/* 3390 */       buf.append(text.substring(start, end)).append(with);
/* 3391 */       start = end + repl.length();
/*      */ 
/* 3393 */       max--; if (max == 0) {
/* 3394 */         break;
/*      */       }
/*      */     }
/*      */ 
/* 3398 */     buf.append(text.substring(start));
/* 3399 */     return buf.toString();
/*      */   }
/*      */ 
/*      */   public static String replaceChars(String str, char searchChar, char replaceChar)
/*      */   {
/* 3422 */     if (str == null) {
/* 3423 */       return null;
/*      */     }
/*      */ 
/* 3426 */     return str.replace(searchChar, replaceChar);
/*      */   }
/*      */ 
/*      */   public static String replaceChars(String str, String searchChars, String replaceChars)
/*      */   {
/* 3462 */     if ((str == null) || (str.length() == 0) || (searchChars == null) || (searchChars.length() == 0))
/*      */     {
/* 3464 */       return str;
/*      */     }
/*      */ 
/* 3467 */     char[] chars = str.toCharArray();
/* 3468 */     int len = chars.length;
/* 3469 */     boolean modified = false;
/*      */ 
/* 3471 */     int i = 0; for (int isize = searchChars.length(); i < isize; i++) {
/* 3472 */       char searchChar = searchChars.charAt(i);
/*      */ 
/* 3474 */       if ((replaceChars == null) || (i >= replaceChars.length()))
/*      */       {
/* 3476 */         int pos = 0;
/*      */ 
/* 3478 */         for (int j = 0; j < len; j++) {
/* 3479 */           if (chars[j] != searchChar)
/* 3480 */             chars[(pos++)] = chars[j];
/*      */           else {
/* 3482 */             modified = true;
/*      */           }
/*      */         }
/*      */ 
/* 3486 */         len = pos;
/*      */       }
/*      */       else {
/* 3489 */         for (int j = 0; j < len; j++) {
/* 3490 */           if (chars[j] == searchChar) {
/* 3491 */             chars[j] = replaceChars.charAt(i);
/* 3492 */             modified = true;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 3498 */     if (!modified) {
/* 3499 */       return str;
/*      */     }
/*      */ 
/* 3502 */     return new String(chars, 0, len);
/*      */   }
/*      */ 
/*      */   public static String overlay(String str, String overlay, int start, int end)
/*      */   {
/* 3533 */     if (str == null) {
/* 3534 */       return null;
/*      */     }
/*      */ 
/* 3537 */     if (overlay == null) {
/* 3538 */       overlay = "";
/*      */     }
/*      */ 
/* 3541 */     int len = str.length();
/*      */ 
/* 3543 */     if (start < 0) {
/* 3544 */       start = 0;
/*      */     }
/*      */ 
/* 3547 */     if (start > len) {
/* 3548 */       start = len;
/*      */     }
/*      */ 
/* 3551 */     if (end < 0) {
/* 3552 */       end = 0;
/*      */     }
/*      */ 
/* 3555 */     if (end > len) {
/* 3556 */       end = len;
/*      */     }
/*      */ 
/* 3559 */     if (start > end) {
/* 3560 */       int temp = start;
/*      */ 
/* 3562 */       start = end;
/* 3563 */       end = temp;
/*      */     }
/*      */ 
/* 3566 */     return new StringBuffer(len + start - end + overlay.length() + 1).append(str.substring(0, start)).append(overlay).append(str.substring(end)).toString();
/*      */   }
/*      */ 
/*      */   public static String chomp(String str)
/*      */   {
/* 3599 */     if ((str == null) || (str.length() == 0)) {
/* 3600 */       return str;
/*      */     }
/*      */ 
/* 3603 */     if (str.length() == 1) {
/* 3604 */       char ch = str.charAt(0);
/*      */ 
/* 3606 */       if ((ch == '\r') || (ch == '\n')) {
/* 3607 */         return "";
/*      */       }
/* 3609 */       return str;
/*      */     }
/*      */ 
/* 3613 */     int lastIdx = str.length() - 1;
/* 3614 */     char last = str.charAt(lastIdx);
/*      */ 
/* 3616 */     if (last == '\n') {
/* 3617 */       if (str.charAt(lastIdx - 1) == '\r')
/* 3618 */         lastIdx--;
/*      */     }
/* 3620 */     else if (last != '\r')
/*      */     {
/* 3622 */       lastIdx++;
/*      */     }
/*      */ 
/* 3625 */     return str.substring(0, lastIdx);
/*      */   }
/*      */ 
/*      */   public static String chomp(String str, String separator)
/*      */   {
/* 3649 */     if ((str == null) || (str.length() == 0) || (separator == null)) {
/* 3650 */       return str;
/*      */     }
/*      */ 
/* 3653 */     if (str.endsWith(separator)) {
/* 3654 */       return str.substring(0, str.length() - separator.length());
/*      */     }
/*      */ 
/* 3657 */     return str;
/*      */   }
/*      */ 
/*      */   public static String chop(String str)
/*      */   {
/* 3685 */     if (str == null) {
/* 3686 */       return null;
/*      */     }
/*      */ 
/* 3689 */     int strLen = str.length();
/*      */ 
/* 3691 */     if (strLen < 2) {
/* 3692 */       return "";
/*      */     }
/*      */ 
/* 3695 */     int lastIdx = strLen - 1;
/* 3696 */     String ret = str.substring(0, lastIdx);
/* 3697 */     char last = str.charAt(lastIdx);
/*      */ 
/* 3699 */     if ((last == '\n') && 
/* 3700 */       (ret.charAt(lastIdx - 1) == '\r')) {
/* 3701 */       return ret.substring(0, lastIdx - 1);
/*      */     }
/*      */ 
/* 3705 */     return ret;
/*      */   }
/*      */ 
/*      */   public static String repeat(String str, int repeat)
/*      */   {
/* 3730 */     if (str == null) {
/* 3731 */       return null;
/*      */     }
/*      */ 
/* 3734 */     if (repeat <= 0) {
/* 3735 */       return "";
/*      */     }
/*      */ 
/* 3738 */     int inputLength = str.length();
/*      */ 
/* 3740 */     if ((repeat == 1) || (inputLength == 0)) {
/* 3741 */       return str;
/*      */     }
/*      */ 
/* 3744 */     int outputLength = inputLength * repeat;
/*      */ 
/* 3746 */     switch (inputLength)
/*      */     {
/*      */     case 1:
/* 3749 */       char ch = str.charAt(0);
/* 3750 */       char[] output1 = new char[outputLength];
/*      */ 
/* 3752 */       for (int i = repeat - 1; i >= 0; i--) {
/* 3753 */         output1[i] = ch;
/*      */       }
/*      */ 
/* 3756 */       return new String(output1);
/*      */     case 2:
/* 3760 */       char ch0 = str.charAt(0);
/* 3761 */       char ch1 = str.charAt(1);
/* 3762 */       char[] output2 = new char[outputLength];
/*      */ 
/* 3764 */       for (int i = repeat * 2 - 2; i >= 0; i--) {
/* 3765 */         output2[i] = ch0;
/* 3766 */         output2[(i + 1)] = ch1;
/*      */ 
/* 3764 */         i--;
/*      */       }
/*      */ 
/* 3769 */       return new String(output2);
/*      */     }
/*      */ 
/* 3773 */     StringBuffer buf = new StringBuffer(outputLength);
/*      */ 
/* 3775 */     for (int i = 0; i < repeat; i++) {
/* 3776 */       buf.append(str);
/*      */     }
/*      */ 
/* 3779 */     return buf.toString();
/*      */   }
/*      */ 
/*      */   public static String alignLeft(String str, int size)
/*      */   {
/* 3800 */     return alignLeft(str, size, ' ');
/*      */   }
/*      */ 
/*      */   public static String alignLeft(String str, int size, char padChar)
/*      */   {
/* 3821 */     if (str == null) {
/* 3822 */       return null;
/*      */     }
/*      */ 
/* 3825 */     int pads = size - str.length();
/*      */ 
/* 3827 */     if (pads <= 0) {
/* 3828 */       return str;
/*      */     }
/*      */ 
/* 3831 */     return alignLeft(str, size, String.valueOf(padChar));
/*      */   }
/*      */ 
/*      */   public static String alignLeft(String str, int size, String padStr)
/*      */   {
/* 3855 */     if (str == null) {
/* 3856 */       return null;
/*      */     }
/*      */ 
/* 3859 */     if ((padStr == null) || (padStr.length() == 0)) {
/* 3860 */       padStr = " ";
/*      */     }
/*      */ 
/* 3863 */     int padLen = padStr.length();
/* 3864 */     int strLen = str.length();
/* 3865 */     int pads = size - strLen;
/*      */ 
/* 3867 */     if (pads <= 0) {
/* 3868 */       return str;
/*      */     }
/*      */ 
/* 3871 */     if (pads == padLen)
/* 3872 */       return str.concat(padStr);
/* 3873 */     if (pads < padLen) {
/* 3874 */       return str.concat(padStr.substring(0, pads));
/*      */     }
/* 3876 */     char[] padding = new char[pads];
/* 3877 */     char[] padChars = padStr.toCharArray();
/*      */ 
/* 3879 */     for (int i = 0; i < pads; i++) {
/* 3880 */       padding[i] = padChars[(i % padLen)];
/*      */     }
/*      */ 
/* 3883 */     return str.concat(new String(padding));
/*      */   }
/*      */ 
/*      */   public static String alignRight(String str, int size)
/*      */   {
/* 3904 */     return alignRight(str, size, ' ');
/*      */   }
/*      */ 
/*      */   public static String alignRight(String str, int size, char padChar)
/*      */   {
/* 3925 */     if (str == null) {
/* 3926 */       return null;
/*      */     }
/*      */ 
/* 3929 */     int pads = size - str.length();
/*      */ 
/* 3931 */     if (pads <= 0) {
/* 3932 */       return str;
/*      */     }
/*      */ 
/* 3935 */     return alignRight(str, size, String.valueOf(padChar));
/*      */   }
/*      */ 
/*      */   public static String alignRight(String str, int size, String padStr)
/*      */   {
/* 3959 */     if (str == null) {
/* 3960 */       return null;
/*      */     }
/*      */ 
/* 3963 */     if ((padStr == null) || (padStr.length() == 0)) {
/* 3964 */       padStr = " ";
/*      */     }
/*      */ 
/* 3967 */     int padLen = padStr.length();
/* 3968 */     int strLen = str.length();
/* 3969 */     int pads = size - strLen;
/*      */ 
/* 3971 */     if (pads <= 0) {
/* 3972 */       return str;
/*      */     }
/*      */ 
/* 3975 */     if (pads == padLen)
/* 3976 */       return padStr.concat(str);
/* 3977 */     if (pads < padLen) {
/* 3978 */       return padStr.substring(0, pads).concat(str);
/*      */     }
/* 3980 */     char[] padding = new char[pads];
/* 3981 */     char[] padChars = padStr.toCharArray();
/*      */ 
/* 3983 */     for (int i = 0; i < pads; i++) {
/* 3984 */       padding[i] = padChars[(i % padLen)];
/*      */     }
/*      */ 
/* 3987 */     return new String(padding).concat(str);
/*      */   }
/*      */ 
/*      */   public static String center(String str, int size)
/*      */   {
/* 4008 */     return center(str, size, ' ');
/*      */   }
/*      */ 
/*      */   public static String center(String str, int size, char padChar)
/*      */   {
/* 4030 */     if ((str == null) || (size <= 0)) {
/* 4031 */       return str;
/*      */     }
/*      */ 
/* 4034 */     int strLen = str.length();
/* 4035 */     int pads = size - strLen;
/*      */ 
/* 4037 */     if (pads <= 0) {
/* 4038 */       return str;
/*      */     }
/*      */ 
/* 4041 */     str = alignRight(str, strLen + pads / 2, padChar);
/* 4042 */     str = alignLeft(str, size, padChar);
/* 4043 */     return str;
/*      */   }
/*      */ 
/*      */   public static String center(String str, int size, String padStr)
/*      */   {
/* 4067 */     if ((str == null) || (size <= 0)) {
/* 4068 */       return str;
/*      */     }
/*      */ 
/* 4071 */     if ((padStr == null) || (padStr.length() == 0)) {
/* 4072 */       padStr = " ";
/*      */     }
/*      */ 
/* 4075 */     int strLen = str.length();
/* 4076 */     int pads = size - strLen;
/*      */ 
/* 4078 */     if (pads <= 0) {
/* 4079 */       return str;
/*      */     }
/*      */ 
/* 4082 */     str = alignRight(str, strLen + pads / 2, padStr);
/* 4083 */     str = alignLeft(str, size, padStr);
/* 4084 */     return str;
/*      */   }
/*      */ 
/*      */   public static String reverse(String str)
/*      */   {
/* 4108 */     if ((str == null) || (str.length() == 0)) {
/* 4109 */       return str;
/*      */     }
/*      */ 
/* 4112 */     return new StringBuffer(str).reverse().toString();
/*      */   }
/*      */ 
/*      */   public static String reverseDelimited(String str, char separatorChar)
/*      */   {
/* 4134 */     if (str == null) {
/* 4135 */       return null;
/*      */     }
/*      */ 
/* 4138 */     String[] strs = split(str, separatorChar);
/*      */ 
/* 4140 */     ArrayUtil.reverse(strs);
/*      */ 
/* 4142 */     return join(strs, separatorChar);
/*      */   }
/*      */ 
/*      */   public static String reverseDelimited(String str, String separatorChars, String separator)
/*      */   {
/* 4167 */     if (str == null) {
/* 4168 */       return null;
/*      */     }
/*      */ 
/* 4171 */     String[] strs = split(str, separatorChars);
/*      */ 
/* 4173 */     ArrayUtil.reverse(strs);
/*      */ 
/* 4175 */     if (separator == null) {
/* 4176 */       return join(strs, ' ');
/*      */     }
/*      */ 
/* 4179 */     return join(strs, separator);
/*      */   }
/*      */ 
/*      */   public static String abbreviate(String str, int maxWidth)
/*      */   {
/* 4220 */     return abbreviate(str, 0, maxWidth);
/*      */   }
/*      */ 
/*      */   public static String abbreviate(String str, int offset, int maxWidth)
/*      */   {
/* 4257 */     if (str == null) {
/* 4258 */       return null;
/*      */     }
/*      */ 
/* 4262 */     if (maxWidth < 4) {
/* 4263 */       maxWidth = 4;
/*      */     }
/*      */ 
/* 4266 */     if (str.length() <= maxWidth) {
/* 4267 */       return str;
/*      */     }
/*      */ 
/* 4270 */     if (offset > str.length()) {
/* 4271 */       offset = str.length();
/*      */     }
/*      */ 
/* 4274 */     if (str.length() - offset < maxWidth - 3) {
/* 4275 */       offset = str.length() - (maxWidth - 3);
/*      */     }
/*      */ 
/* 4278 */     if (offset <= 4) {
/* 4279 */       return str.substring(0, maxWidth - 3) + "...";
/*      */     }
/*      */ 
/* 4283 */     if (maxWidth < 7) {
/* 4284 */       maxWidth = 7;
/*      */     }
/*      */ 
/* 4287 */     if (offset + (maxWidth - 3) < str.length()) {
/* 4288 */       return "..." + abbreviate(str.substring(offset), maxWidth - 3);
/*      */     }
/*      */ 
/* 4291 */     return "..." + str.substring(str.length() - (maxWidth - 3));
/*      */   }
/*      */ 
/*      */   public static String difference(String str1, String str2)
/*      */   {
/* 4321 */     if (str1 == null) {
/* 4322 */       return str2;
/*      */     }
/*      */ 
/* 4325 */     if (str2 == null) {
/* 4326 */       return str1;
/*      */     }
/*      */ 
/* 4329 */     int index = indexOfDifference(str1, str2);
/*      */ 
/* 4331 */     if (index == -1) {
/* 4332 */       return "";
/*      */     }
/*      */ 
/* 4335 */     return str2.substring(index);
/*      */   }
/*      */ 
/*      */   public static int indexOfDifference(String str1, String str2)
/*      */   {
/* 4359 */      if (str1 == str2) {
				    return -1;
				}
				if (str1 == null || str2 == null) {
				    return 0;
				}
				int i;
				for (i = 0; i < str1.length() && i < str2.length(); ++i) {
				    if (str1.charAt(i) != str2.charAt(i)) {
				        break;
				    }
				}
				if (i < str2.length() || i < str1.length()) {
				    return i;
				}
				return -1;
/*      */   }
/*      */ 
/*      */   public static int getLevenshteinDistance(String s, String t)
/*      */   {
/* 4405 */    if (s == null || t == null) {
				    throw new IllegalArgumentException("Strings must not be null");
				}
				
				/*
				   The difference between this impl. and the previous is that, rather 
				   than creating and retaining a matrix of size s.length()+1 by t.length()+1, 
				   we maintain two single-dimensional arrays of length s.length()+1.  The first, d,
				   is the 'current working' distance array that maintains the newest distance cost
				   counts as we iterate through the characters of String s.  Each time we increment
				   the index of String t we are comparing, d is copied to p, the second int[].  Doing so
				   allows us to retain the previous cost counts as required by the algorithm (taking 
				   the minimum of the cost count to the left, up one, and diagonally up and to the left
				   of the current cost count being calculated).  (Note that the arrays aren't really 
				   copied anymore, just switched...this is clearly much better than cloning an array 
				   or doing a System.arraycopy() each time  through the outer loop.)
				
				   Effectively, the difference between the two implementations is this one does not 
				   cause an out of memory condition when calculating the LD over two very large strings.
				 */
				
				int n = s.length(); // length of s
				int m = t.length(); // length of t
				
				if (n == 0) {
				    return m;
				} else if (m == 0) {
				    return n;
				}
				
				if (n > m) {
				    // swap the input strings to consume less memory
				    String tmp = s;
				    s = t;
				    t = tmp;
				    n = m;
				    m = t.length();
				}
				
				int p[] = new int[n+1]; //'previous' cost array, horizontally
				int d[] = new int[n+1]; // cost array, horizontally
				int _d[]; //placeholder to assist in swapping p and d
				
				// indexes into strings s and t
				int i; // iterates through s
				int j; // iterates through t
				
				char t_j; // jth character of t
				
				int cost; // cost
				
				for (i = 0; i<=n; i++) {
				    p[i] = i;
				}
				
				for (j = 1; j<=m; j++) {
				    t_j = t.charAt(j-1);
				    d[0] = j;
				
				    for (i=1; i<=n; i++) {
				        cost = s.charAt(i-1)==t_j ? 0 : 1;
				        // minimum of cell to the left+1, to the top+1, diagonally left and up +cost
				        d[i] = Math.min(Math.min(d[i-1]+1, p[i]+1),  p[i-1]+cost);
				    }
				
				    // copy current distance counts to 'previous row' distance counts
				    _d = p;
				    p = d;
				    d = _d;
				}
				
				// our last action in the above loop was to switch d and p, so p now 
				// actually has the most recent cost counts
				return p[n];
/*      */   }
/*      */ 
/*      */   private static int min(int a, int b, int c)
/*      */   {
/* 4474 */     if (b < a) {
/* 4475 */       a = b;
/*      */     }
/*      */ 
/* 4478 */     if (c < a) {
/* 4479 */       a = c;
/*      */     }
/*      */ 
/* 4482 */     return a;
/*      */   }
/*      */ 
/*      */   private static abstract class WordTokenizer
/*      */   {
/*      */     protected static final char UNDERSCORE = '_';
/*      */ 
/*      */     public String parse(String str)
/*      */     {
/* 1529 */       if (StringUtil.isEmpty(str)) {
/* 1530 */         return str;
/*      */       }
/*      */ 
/* 1533 */       int length = str.length();
/* 1534 */       StringBuffer buffer = new StringBuffer(length);
/*      */ 
/* 1536 */       for (int index = 0; index < length; index++) {
/* 1537 */         char ch = str.charAt(index);
/*      */ 
/* 1540 */         if (Character.isWhitespace(ch))
/*      */         {
/*      */           continue;
/*      */         }
/*      */ 
/* 1545 */         if (Character.isUpperCase(ch)) {
/* 1546 */           int wordIndex = index + 1;
/*      */ 
/* 1548 */           while (wordIndex < length) {
/* 1549 */             char wordChar = str.charAt(wordIndex);
/*      */ 
/* 1551 */             if (Character.isUpperCase(wordChar)) {
/* 1552 */               wordIndex++; } else {
/* 1553 */               if (!Character.isLowerCase(wordChar)) break;
/* 1554 */               wordIndex--;
/* 1555 */               break;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1564 */           if ((wordIndex == length) || (wordIndex > index))
/* 1565 */             index = parseUpperCaseWord(buffer, str, index, wordIndex);
/*      */           else {
/* 1567 */             index = parseTitleCaseWord(buffer, str, index);
/*      */           }
/*      */ 
/*      */         }
/* 1574 */         else if (Character.isLowerCase(ch)) {
/* 1575 */           index = parseLowerCaseWord(buffer, str, index);
/*      */         }
/* 1580 */         else if (Character.isDigit(ch)) {
/* 1581 */           index = parseDigitWord(buffer, str, index);
/*      */         }
/*      */         else
/*      */         {
/* 1586 */           inDelimiter(buffer, ch);
/*      */         }
/*      */       }
/* 1589 */       return buffer.toString();
/*      */     }
/*      */ 
/*      */     private int parseUpperCaseWord(StringBuffer buffer, String str, int index, int length) {
/* 1593 */       char ch = str.charAt(index++);
/*      */ 
/* 1596 */       if (buffer.length() == 0)
/* 1597 */         startSentence(buffer, ch);
/*      */       else {
/* 1599 */         startWord(buffer, ch);
/*      */       }
/*      */ 
/* 1603 */       for (; index < length; index++) {
/* 1604 */         ch = str.charAt(index);
/* 1605 */         inWord(buffer, ch);
/*      */       }
/*      */ 
/* 1608 */       return index - 1;
/*      */     }
/*      */ 
/*      */     private int parseLowerCaseWord(StringBuffer buffer, String str, int index) {
/* 1612 */       char ch = str.charAt(index++);
/*      */ 
/* 1615 */       if (buffer.length() == 0)
/* 1616 */         startSentence(buffer, ch);
/*      */       else {
/* 1618 */         startWord(buffer, ch);
/*      */       }
/*      */ 
/* 1622 */       int length = str.length();
/*      */ 
/* 1624 */       for (; index < length; index++) {
/* 1625 */         ch = str.charAt(index);
/*      */ 
/* 1627 */         if (!Character.isLowerCase(ch)) break;
/* 1628 */         inWord(buffer, ch);
/*      */       }
/*      */ 
/* 1634 */       return index - 1;
/*      */     }
/*      */ 
/*      */     private int parseTitleCaseWord(StringBuffer buffer, String str, int index) {
/* 1638 */       char ch = str.charAt(index++);
/*      */ 
/* 1641 */       if (buffer.length() == 0)
/* 1642 */         startSentence(buffer, ch);
/*      */       else {
/* 1644 */         startWord(buffer, ch);
/*      */       }
/*      */ 
/* 1648 */       int length = str.length();
/*      */ 
/* 1650 */       for (; index < length; index++) {
/* 1651 */         ch = str.charAt(index);
/*      */ 
/* 1653 */         if (!Character.isLowerCase(ch)) break;
/* 1654 */         inWord(buffer, ch);
/*      */       }
/*      */ 
/* 1660 */       return index - 1;
/*      */     }
/*      */ 
/*      */     private int parseDigitWord(StringBuffer buffer, String str, int index) {
/* 1664 */       char ch = str.charAt(index++);
/*      */ 
/* 1667 */       if (buffer.length() == 0)
/* 1668 */         startDigitSentence(buffer, ch);
/*      */       else {
/* 1670 */         startDigitWord(buffer, ch);
/*      */       }
/*      */ 
/* 1674 */       int length = str.length();
/*      */ 
/* 1676 */       for (; index < length; index++) {
/* 1677 */         ch = str.charAt(index);
/*      */ 
/* 1679 */         if (!Character.isDigit(ch)) break;
/* 1680 */         inDigitWord(buffer, ch);
/*      */       }
/*      */ 
/* 1686 */       return index - 1;
/*      */     }
/*      */ 
/*      */     protected boolean isDelimiter(char ch) {
/* 1690 */       return (!Character.isUpperCase(ch)) && (!Character.isLowerCase(ch)) && (!Character.isDigit(ch));
/*      */     }
/*      */ 
/*      */     protected abstract void startSentence(StringBuffer paramStringBuffer, char paramChar);
/*      */ 
/*      */     protected abstract void startWord(StringBuffer paramStringBuffer, char paramChar);
/*      */ 
/*      */     protected abstract void inWord(StringBuffer paramStringBuffer, char paramChar);
/*      */ 
/*      */     protected abstract void startDigitSentence(StringBuffer paramStringBuffer, char paramChar);
/*      */ 
/*      */     protected abstract void startDigitWord(StringBuffer paramStringBuffer, char paramChar);
/*      */ 
/*      */     protected abstract void inDigitWord(StringBuffer paramStringBuffer, char paramChar);
/*      */ 
/*      */     protected abstract void inDelimiter(StringBuffer paramStringBuffer, char paramChar);
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.util.StringUtil
 * JD-Core Version:    0.6.0
 */