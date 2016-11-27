/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumIsLeaf
/*    */ {
/* 11 */   LEAF((short)1, "子节点"), 
/* 12 */   STALK((short)2, "非子节点");
/*    */ 
/*    */   private short code;
/*    */   private String desc;
/*    */ 
/* 19 */   public short getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(short code)
/*    */   {
/* 23 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getDesc() {
/* 27 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 31 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   private EnumIsLeaf(short code, String desc) {
/* 35 */     this.code = code;
/* 36 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<Short, String> toMap() {
/* 40 */     Map map = new HashMap();
/* 41 */     for (EnumIsLeaf item : values()) {
/* 42 */       map.put(Short.valueOf(item.getCode()), item.getDesc());
/*    */     }
/* 44 */     return map;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumIsLeaf
 * JD-Core Version:    0.6.0
 */