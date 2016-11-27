/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemMemberlevelSet;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemMemberlevelSetQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemMemberlevelSetService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class SysMemLevelSetEditValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemMemberlevelSetService systemMemberlevelSetService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 20 */     super.validate(obj, errors);
/* 21 */     SystemMemberlevelSet sysMemLevelSet = (SystemMemberlevelSet)obj;
/*    */ 
/* 23 */     SystemMemberlevelSetQuery query = new SystemMemberlevelSetQuery();
/* 24 */     query.setNoneId(sysMemLevelSet.getId());
/* 25 */     query.setMemberLevel(sysMemLevelSet.getMemberLevel());
/* 26 */     List listA = this.systemMemberlevelSetService.selectConditionList(query);
/* 27 */     if ((listA != null) && (listA.size() > 0)) {
/* 28 */       errors.rejectValue("memberLevel", "", "会员级别重复！");
/*    */     }
/*    */ 
/* 32 */     query = new SystemMemberlevelSetQuery();
/* 33 */     query.setNoneId(sysMemLevelSet.getId());
/* 34 */     query.setLevelName(sysMemLevelSet.getLevelName());
/* 35 */     List listB = this.systemMemberlevelSetService.selectConditionList(query);
/* 36 */     if ((listB != null) && (listB.size() > 0)) {
/* 37 */       errors.rejectValue("levelName", "", "等级名称重复！");
/*    */     }
/*    */ 
/* 40 */     if (sysMemLevelSet.getIntegralStart() == null) {
/* 41 */       errors.rejectValue("integralStart", "", "积分必须是整数！");
/*    */     }
/* 43 */     if (sysMemLevelSet.getIntegralEnd() == null) {
/* 44 */       errors.rejectValue("integralEnd", "", "积分必须是整数！");
/*    */     }
/*    */ 
/* 47 */     if ((sysMemLevelSet.getIntegralStart() != null) && (sysMemLevelSet.getIntegralEnd() != null)) {
/* 48 */       query = new SystemMemberlevelSetQuery();
/* 49 */       query.setNoneId(sysMemLevelSet.getId());
/* 50 */       query.setIntegralStart(Integer.valueOf(sysMemLevelSet.getIntegralStart().intValue()));
/* 51 */       query.setIntegralEnd(Integer.valueOf(sysMemLevelSet.getIntegralEnd().intValue()));
/* 52 */       int cc = this.systemMemberlevelSetService.checkIntegralRange(query);
/* 53 */       if (cc > 0)
/* 54 */         errors.rejectValue("integralStart", "", "积分范围已经被占用 ！");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.SysMemLevelSetEditValidator
 * JD-Core Version:    0.6.0
 */