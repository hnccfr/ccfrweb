/*    */ package com.hundsun.network.gates.genshan.web.tools;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.AttriMeta;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*    */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ProjectDynamicUtils
/*    */ {
/*    */   public static String getKeyInputValue(String keyName, List<TradeShowDTO> dynamicList)
/*    */   {
/* 31 */     if ((StringUtil.isEmpty(keyName)) || (dynamicList == null) || (dynamicList.size() < 1))
/* 32 */       return "";
/* 33 */     for (TradeShowDTO tradeShowDTO : dynamicList) {
/* 34 */       if (tradeShowDTO.getKey().equals(keyName)) {
/* 35 */         return tradeShowDTO.getInputValue();
/*    */       }
/*    */     }
/* 38 */     return "";
/*    */   }
/*    */ 
/*    */   public static String getDynamicKeyInputValue(String keyName, List<AttriMeta> attriMeta)
/*    */   {
/* 49 */     if ((StringUtil.isEmpty(keyName)) || (attriMeta == null) || (attriMeta.size() < 1))
/* 50 */       return "";
/* 51 */     for (AttriMeta attriMetaObj : attriMeta) {
/* 52 */       if (attriMetaObj.getMeta().getMetaKey().equals(keyName)) {
/* 53 */         return attriMetaObj.getMeta().getMetaValue();
/*    */       }
/*    */     }
/* 56 */     return "";
/*    */   }
/*    */ 
/*    */   public static boolean contains(String str, String searchChar)
/*    */   {
/* 68 */     if ((str == null) || (str.length() == 0)) {
/* 69 */       return false;
/*    */     }
/*    */ 
/* 72 */     if (str.contains(",")) {
/* 73 */       return str.indexOf(searchChar) >= 0;
/*    */     }
/* 75 */     return str.equals(searchChar);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.tools.ProjectDynamicUtils
 * JD-Core Version:    0.6.0
 */