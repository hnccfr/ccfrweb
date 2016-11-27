/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemMemberlevelSet;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class SystemMemberlevelSetQuery extends Pagination<SystemMemberlevelSet>
/*    */ {
/*    */   private static final long serialVersionUID = 2563115559580242110L;
/*    */   private Integer levelNum;
/*    */   private String memberLevel;
/*    */   private Long noneId;
/*    */   private Long memberLevelId;
/*    */   private String levelName;
/*    */   private Integer integralStart;
/*    */   private Integer integralEnd;
/*    */ 
/*    */   public Integer getLevelNum()
/*    */   {
/* 43 */     return this.levelNum;
/*    */   }
/*    */ 
/*    */   public void setLevelNum(Integer levelNum) {
/* 47 */     this.levelNum = levelNum;
/*    */   }
/*    */ 
/*    */   public String getMemberLevel() {
/* 51 */     return this.memberLevel;
/*    */   }
/*    */ 
/*    */   public void setMemberLevel(String memberLevel) {
/* 55 */     this.memberLevel = memberLevel;
/*    */   }
/*    */ 
/*    */   public Long getMemberLevelId() {
/* 59 */     return this.memberLevelId;
/*    */   }
/*    */ 
/*    */   public void setMemberLevelId(Long memberLevelId) {
/* 63 */     this.memberLevelId = memberLevelId;
/*    */   }
/*    */ 
/*    */   public String getLevelName() {
/* 67 */     return this.levelName;
/*    */   }
/*    */ 
/*    */   public void setLevelName(String levelName) {
/* 71 */     this.levelName = levelName;
/*    */   }
/*    */ 
/*    */   public Long getNoneId() {
/* 75 */     return this.noneId;
/*    */   }
/*    */ 
/*    */   public void setNoneId(Long noneId) {
/* 79 */     this.noneId = noneId;
/*    */   }
/*    */ 
/*    */   public Integer getIntegralStart() {
/* 83 */     return this.integralStart;
/*    */   }
/*    */ 
/*    */   public void setIntegralStart(Integer integralStart) {
/* 87 */     this.integralStart = integralStart;
/*    */   }
/*    */ 
/*    */   public Integer getIntegralEnd() {
/* 91 */     return this.integralEnd;
/*    */   }
/*    */ 
/*    */   public void setIntegralEnd(Integer integralEnd) {
/* 95 */     this.integralEnd = integralEnd;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.SystemMemberlevelSetQuery
 * JD-Core Version:    0.6.0
 */