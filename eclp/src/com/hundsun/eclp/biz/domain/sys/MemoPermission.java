/*    */ package com.hundsun.eclp.biz.domain.sys;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MemoPermission
/*    */ {
/* 11 */   private static Map<String, Map<Integer, Integer>> subsystemPermissionMap = new HashMap();
/*    */   private static final long serialVersionUID = 286509573671321587L;
/*    */ 
/*    */   public static boolean containsKey(Object key)
/*    */   {
/* 23 */     return subsystemPermissionMap.containsKey(key);
/*    */   }
/*    */ 
/*    */   public static Map<Integer, Integer> get(Object key)
/*    */   {
/* 31 */     return (Map)subsystemPermissionMap.get(key);
/*    */   }
/*    */ 
/*    */   public static void put(String key, Map<Integer, Integer> value)
/*    */   {
/* 39 */     subsystemPermissionMap.put(key, value);
/*    */   }
/*    */ 
/*    */   public static void remove(Object key)
/*    */   {
/* 46 */     subsystemPermissionMap.remove(key);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.sys.MemoPermission
 * JD-Core Version:    0.6.0
 */