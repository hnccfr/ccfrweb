/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectBaseSetting;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class ProjectBaseSettingQuery extends Pagination<ProjectBaseSetting>
/*    */ {
/*    */   private static final long serialVersionUID = -4211786015137541182L;
/*    */   private String proTypeCode;
/*    */   private String sleProTypeName;
/*    */   private String tradingType;
/*    */   private String memberLevel;
/*    */   private Long goodComment;
/*    */   private Long badComment;
/*    */ 
/*    */   public String getProTypeCode()
/*    */   {
/* 24 */     return this.proTypeCode;
/*    */   }
/*    */ 
/*    */   public void setProTypeCode(String proTypeCode) {
/* 28 */     this.proTypeCode = proTypeCode;
/*    */   }
/*    */ 
/*    */   public String getSleProTypeName() {
/* 32 */     return this.sleProTypeName;
/*    */   }
/*    */ 
/*    */   public void setSleProTypeName(String sleProTypeName) {
/* 36 */     this.sleProTypeName = sleProTypeName;
/*    */   }
/*    */ 
/*    */   public String getTradingType() {
/* 40 */     return this.tradingType;
/*    */   }
/*    */ 
/*    */   public void setTradingType(String tradingType) {
/* 44 */     this.tradingType = tradingType;
/*    */   }
/*    */ 
/*    */   public String getMemberLevel() {
/* 48 */     return this.memberLevel;
/*    */   }
/*    */ 
/*    */   public void setMemberLevel(String memberLevel) {
/* 52 */     this.memberLevel = memberLevel;
/*    */   }
/*    */ 
/*    */   public Long getGoodComment() {
/* 56 */     return this.goodComment;
/*    */   }
/*    */ 
/*    */   public void setGoodComment(Long goodComment) {
/* 60 */     this.goodComment = goodComment;
/*    */   }
/*    */ 
/*    */   public Long getBadComment() {
/* 64 */     return this.badComment;
/*    */   }
/*    */ 
/*    */   public void setBadComment(Long badComment) {
/* 68 */     this.badComment = badComment;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.ProjectBaseSettingQuery
 * JD-Core Version:    0.6.0
 */