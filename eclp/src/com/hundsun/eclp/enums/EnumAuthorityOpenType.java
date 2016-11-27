package com.hundsun.eclp.enums;
 
 public enum EnumAuthorityOpenType
 {
	  INNER((short)1, "内嵌"), 
	  OUTER((short)2, "弹出");
 
   private short code;
   private String desc;
 
   public short getCode() { return this.code; }
 
   public void setCode(short code)
   {
    this.code = code;
   }
 
   public String getDesc() {
    return this.desc;
   }
 
   public void setDesc(String desc) {
     this.desc = desc;
   }
 
   private EnumAuthorityOpenType(short code, String desc) {
     this.code = code;
    this.desc = desc;
   }
 }

