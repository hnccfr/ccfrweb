/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemDict;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class SystemDictQuery extends Pagination<SystemDict>
/*    */ {
/*    */   private static final long serialVersionUID = 6369030739720515721L;
/*    */   private String paraCode;
/*    */   private String paraName;
/*    */   private String paraValue;
/*    */   private Long noneId;
/*    */ 
/*    */   public String getParaCode()
/*    */   {
/* 15 */     return this.paraCode;
/*    */   }
/*    */   public void setParaCode(String paraCode) {
/* 18 */     this.paraCode = paraCode;
/*    */   }
/*    */   public String getParaName() {
/* 21 */     return this.paraName;
/*    */   }
/*    */   public void setParaName(String paraName) {
/* 24 */     this.paraName = paraName;
/*    */   }
/*    */   public String getParaValue() {
/* 27 */     return this.paraValue;
/*    */   }
/*    */   public void setParaValue(String paraValue) {
/* 30 */     this.paraValue = paraValue;
/*    */   }
/*    */   public Long getNoneId() {
/* 33 */     return this.noneId;
/*    */   }
/*    */   public void setNoneId(Long noneId) {
/* 36 */     this.noneId = noneId;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.SystemDictQuery
 * JD-Core Version:    0.6.0
 */