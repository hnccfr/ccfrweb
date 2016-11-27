/*    */ package com.hundsun.eclp.biz.domain.sys;
/*    */ 
/*    */ import com.hundsun.eclp.client.remote.dto.ServerStatusDTO;
/*    */ import java.util.Date;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MemoPermissionFlag
/*    */ {
/* 12 */   private static Map<String, ServerStatusDTO> regMap = new HashMap();
/*    */   private static final long serialVersionUID = 286509573671321587L;
/*    */ 
/*    */   public static boolean containsKey(Object key)
/*    */   {
/* 27 */     return regMap.containsKey(key);
/*    */   }
/*    */ 
/*    */   public static ServerStatusDTO get(Object key)
/*    */   {
/* 35 */     return (ServerStatusDTO)regMap.get(key);
/*    */   }
/*    */ 
/*    */   public static void put(String key, Date value)
/*    */   {
/* 44 */     ServerStatusDTO dto = new ServerStatusDTO();
/* 45 */     dto.setPermissionUpdateTime(value.getTime());
/* 46 */     dto.setStatus(true);
/* 47 */     regMap.put(key, dto);
/*    */   }
/*    */ 
/*    */   public static void put(String key, ServerStatusDTO value)
/*    */   {
/* 55 */     regMap.put(key, value);
/*    */   }
/*    */ 
/*    */   public static void remove(Object key)
/*    */   {
/* 62 */     regMap.remove(key);
/*    */   }
/*    */ 
/*    */   public static Map<String, ServerStatusDTO> getAll() {
/* 66 */     return regMap;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.sys.MemoPermissionFlag
 * JD-Core Version:    0.6.0
 */