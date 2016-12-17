/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectBaseSetting;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectBaseSettingService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class ProjectBaseSettingValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectBaseSettingService projectBaseSettingService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 20 */     super.validate(obj, errors);
/* 21 */     ProjectBaseSetting currObj = (ProjectBaseSetting)obj;
/*    */ 
/* 27 */     if ((StringUtil.isEmpty(currObj.getProTypeCode())) && (StringUtil.isEmpty(currObj.getMemberLevel())) && (StringUtil.isEmpty(currObj.getTradingType())) && (currObj.getGoodComment() == null) && (currObj.getBadComment() == null))
/*    */     {
/* 29 */       errors.rejectValue("proTypeCode", "", "选择条件不允许都空！");
/* 30 */       errors.rejectValue("tradingType", "", "选择条件不允许都空！");
/* 31 */       errors.rejectValue("memberLevel", "", "选择条件不允许都空！");
/* 32 */       errors.rejectValue("goodComment", "", "选择条件不允许都空！");
/* 33 */       errors.rejectValue("badComment", "", "选择条件不允许都空！");
/* 34 */       return;
/*    */     }
/*    */ 
/* 40 */     if ((StringUtil.isEmpty(currObj.getListingCheckProcess())) && (StringUtil.isEmpty(currObj.getIntentionCheckProcess())) && (currObj.getListingJyProportion() == null) && (currObj.getListingJsProportion() == null) && (currObj.getOrderJyProportion() == null) && (currObj.getOrderJsProportion() == null))
/*    */     {
/* 43 */       errors.rejectValue("listingCheckProcess", "", "设置值不允许都是空！");
/* 44 */       errors.rejectValue("intentionCheckProcess", "", "设置值不允许都是空！");
/* 45 */       errors.rejectValue("listingJyProportion", "", "设置值不允许都是空！");
/* 46 */       errors.rejectValue("listingJsProportion", "", "设置值不允许都是空！");
/* 47 */       errors.rejectValue("orderJyProportion", "", "设置值不允许都是空！");
/* 48 */       errors.rejectValue("orderJsProportion", "", "设置值不允许都是空！");
/* 49 */       return;
/*    */     }
/*    */ 
/* 56 */     ProjectBaseSetting queryObj = new ProjectBaseSetting();
/* 57 */     queryObj.setProTypeCode(currObj.getProTypeCode());
/* 58 */     queryObj.setTradingType(currObj.getTradingType());
/* 59 */     queryObj.setMemberLevel(currObj.getMemberLevel());
/* 60 */     queryObj.setGoodComment(currObj.getGoodComment());
/* 61 */     queryObj.setBadComment(currObj.getBadComment());
/* 62 */     if (null != currObj.getId()) {
/* 63 */       queryObj.setId(currObj.getId());
/*    */     }
/* 65 */     List list = this.projectBaseSettingService.selectProBSListBySelective(queryObj);
/* 66 */     if ((list != null) && (list.size() > 0)) {
/* 67 */       errors.rejectValue("listingCheckProcess", "", "在选择的条件下已经设置过值！");
/* 68 */       errors.rejectValue("intentionCheckProcess", "", "在选择的条件下已经设置过值！");
/* 69 */       errors.rejectValue("listingJyProportion", "", "在选择的条件下已经设置过值！");
/* 70 */       errors.rejectValue("listingJsProportion", "", "在选择的条件下已经设置过值！");
/* 71 */       errors.rejectValue("orderJyProportion", "", "在选择的条件下已经设置过值！");
/* 72 */       errors.rejectValue("orderJsProportion", "", "在选择的条件下已经设置过值！");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.ProjectBaseSettingValidator
 * JD-Core Version:    0.6.0
 */