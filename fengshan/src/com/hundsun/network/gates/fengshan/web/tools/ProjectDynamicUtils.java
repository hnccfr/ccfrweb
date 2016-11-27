/*     */ package com.hundsun.network.gates.fengshan.web.tools;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ProjectDynamicUtils
/*     */ {
/*     */   public static String getKeyInputValue(String keyName, List<TradeShowDTO> dynamicList)
/*     */   {
/*  32 */     if ((StringUtil.isEmpty(keyName)) || (dynamicList == null) || (dynamicList.size() < 1))
/*  33 */       return "";
/*  34 */     for (TradeShowDTO tradeShowDTO : dynamicList) {
/*  35 */       if (tradeShowDTO.getKey().equals(keyName)) {
/*  36 */         return tradeShowDTO.getInputValue();
/*     */       }
/*     */     }
/*  39 */     return "";
/*     */   }
/*     */ 
/*     */   public static String getDynamicKeyInputValue(String keyName, List<AttriMeta> attriMeta)
/*     */   {
/*  50 */     if ((StringUtil.isEmpty(keyName)) || (attriMeta == null) || (attriMeta.size() < 1))
/*  51 */       return "";
/*  52 */     for (AttriMeta attriMetaObj : attriMeta) {
/*  53 */       if (attriMetaObj.getMeta().getMetaKey().equals(keyName)) {
/*  54 */         return attriMetaObj.getMeta().getMetaValue();
/*     */       }
/*     */     }
/*  57 */     return "";
/*     */   }
/*     */ 
/*     */   public static String getDynamicKeyValue(String keyName, List<ProjectMetas> attriMeta)
/*     */   {
/*  68 */     if ((StringUtil.isEmpty(keyName)) || (attriMeta == null) || (attriMeta.size() < 1))
/*  69 */       return "";
/*  70 */     for (ProjectMetas projectMetas : attriMeta) {
/*  71 */       if (projectMetas.getMetaKey().equals(keyName)) {
/*  72 */         return projectMetas.getMetaValue();
/*     */       }
/*     */     }
/*  75 */     return "";
/*     */   }
/*     */ 
/*     */   public static boolean contains(String str, String searchChar)
/*     */   {
/*  87 */     if ((str == null) || (StringUtil.isEmpty(searchChar)) || (str.length() == 0)) {
/*  88 */       return false;
/*     */     }
/*  90 */     if (str.contains(",")) {
/*  91 */       return str.indexOf(searchChar) >= 0;
/*     */     }
/*  93 */     return str.equals(searchChar);
/*     */   }
/*     */ 
/*     */   public static boolean isEq(String key1, String key2, String value1, String value2)
/*     */   {
/* 105 */     if ((StringUtil.isEmpty(key1)) || (StringUtil.isEmpty(key2)) || (StringUtil.isEmpty(value1)) || (StringUtil.isEmpty(value2)) || (key1.length() == 0))
/*     */     {
/* 107 */       return false;
/*     */     }
/*     */ 
/* 110 */     return (key1.equals(key2)) && (value1.equals(value2));
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.tools.ProjectDynamicUtils
 * JD-Core Version:    0.6.0
 */