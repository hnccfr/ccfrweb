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
/*    */ public class SysMemLevelSetAddValidator extends ValangValidator
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
/* 24 */     SystemMemberlevelSetQuery query = new SystemMemberlevelSetQuery();
/* 25 */     query.setMemberLevel(sysMemLevelSet.getMemberLevel());
/* 26 */     List list = this.systemMemberlevelSetService.selectConditionList(query);
/* 27 */     if ((list != null) && (list.size() > 0)) {
/* 28 */       errors.rejectValue("memberLevel", "", "会员级别重复！");
/*    */     }
/*    */ 
/* 32 */     query = new SystemMemberlevelSetQuery();
/* 33 */     query.setLevelName(sysMemLevelSet.getLevelName());
/* 34 */     List list2 = this.systemMemberlevelSetService.selectConditionList(query);
/* 35 */     if ((list2 != null) && (list2.size() > 0)) {
/* 36 */       errors.rejectValue("levelName", "", "等级名称重复！");
/*    */     }
/*    */ 
/* 39 */     if ((sysMemLevelSet.getIntegralStart() != null) && (sysMemLevelSet.getIntegralEnd() != null)) {
/* 40 */       if (sysMemLevelSet.getIntegralEnd().intValue() <= sysMemLevelSet.getIntegralStart().intValue()) {
/* 41 */         errors.rejectValue("integralEnd", "", "结束值必须大于开始值 ！");
/*    */       }
/*    */ 
/* 45 */       if ((sysMemLevelSet.getIntegralStart() != null) && (sysMemLevelSet.getIntegralEnd() != null)) {
/* 46 */         query = new SystemMemberlevelSetQuery();
/* 47 */         query.setIntegralStart(Integer.valueOf(sysMemLevelSet.getIntegralStart().intValue()));
/* 48 */         query.setIntegralEnd(Integer.valueOf(sysMemLevelSet.getIntegralEnd().intValue()));
/* 49 */         int cc = this.systemMemberlevelSetService.checkIntegralRange(query);
/* 50 */         if (cc > 0)
/* 51 */           errors.rejectValue("integralStart", "", "积分范围已经被占用 ！");
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.SysMemLevelSetAddValidator
 * JD-Core Version:    0.6.0
 */