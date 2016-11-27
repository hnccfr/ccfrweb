/*    */ package com.hundsun.network.gates.wulin.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemMemberlevelSet;
/*    */ 
/*    */ public class SystemMemberlevelSetQuery extends Pagination<SystemMemberlevelSet>
/*    */ {
/*    */   private static final long serialVersionUID = -4835669221469042910L;
/*    */   private Integer levelNum;
/*    */   private String memberLevel;
/*    */   private Long memberLevelId;
/*    */   private String levelName;
/*    */ 
/*    */   public Integer getLevelNum()
/*    */   {
/* 30 */     return this.levelNum;
/*    */   }
/*    */ 
/*    */   public void setLevelNum(Integer levelNum) {
/* 34 */     this.levelNum = levelNum;
/*    */   }
/*    */ 
/*    */   public String getMemberLevel() {
/* 38 */     return this.memberLevel;
/*    */   }
/*    */ 
/*    */   public void setMemberLevel(String memberLevel) {
/* 42 */     this.memberLevel = memberLevel;
/*    */   }
/*    */ 
/*    */   public static long getSerialversionuid() {
/* 46 */     return -4835669221469042910L;
/*    */   }
/*    */ 
/*    */   public Long getMemberLevelId() {
/* 50 */     return this.memberLevelId;
/*    */   }
/*    */ 
/*    */   public void setMemberLevelId(Long memberLevelId) {
/* 54 */     this.memberLevelId = memberLevelId;
/*    */   }
/*    */ 
/*    */   public String getLevelName() {
/* 58 */     return this.levelName;
/*    */   }
/*    */ 
/*    */   public void setLevelName(String levelName) {
/* 62 */     this.levelName = levelName;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.query.SystemMemberlevelSetQuery
 * JD-Core Version:    0.6.0
 */