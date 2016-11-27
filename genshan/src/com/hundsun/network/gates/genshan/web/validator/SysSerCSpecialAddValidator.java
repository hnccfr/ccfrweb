/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemServicechargeSpecial;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemServicechargeSpecialQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemServiceCSpecialService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class SysSerCSpecialAddValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserAccountService userAccountService;
/*    */ 
/*    */   @Autowired
/*    */   private SystemServiceCSpecialService systemServiceCSpecialService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 30 */     super.validate(obj, errors);
/* 31 */     SystemServicechargeSpecial sscSpecial = (SystemServicechargeSpecial)obj;
/* 32 */     String userAccount = sscSpecial.getUserAccount();
/* 33 */     String proTypeCode = sscSpecial.getProTypeCode();
/* 34 */     String tradingType = sscSpecial.getTradingType();
/* 35 */     String haveAuctioneer = sscSpecial.getHaveAuctioneer();
/* 36 */     Long turnoverAmount = sscSpecial.getTurnoverAmount();
/* 37 */     String isSystem = sscSpecial.getIsSystem();
/* 38 */     if (!"Y".equals(isSystem))
/*    */     {
/* 41 */       if ((StringUtil.isEmpty(userAccount)) && (StringUtil.isEmpty(proTypeCode)) && (StringUtil.isEmpty(tradingType)) && (StringUtil.isEmpty(haveAuctioneer)) && (null == turnoverAmount))
/*    */       {
/* 43 */         errors.rejectValue("userAccount", "", "选择条件不允许都空！");
/* 44 */         errors.rejectValue("proTypeCode", "", "选择条件不允许都空！");
/* 45 */         errors.rejectValue("tradingType", "", "选择条件不允许都空！");
/* 46 */         errors.rejectValue("haveAuctioneer", "", "选择条件不允许都空！");
/* 47 */         errors.rejectValue("turnoverAmount", "", "选择条件不允许都空！");
/* 48 */         return;
/*    */       }
/*    */ 
/* 51 */       if (StringUtil.isNotBlank(sscSpecial.getUserAccount()))
/*    */       {
/* 53 */         UserAccount ua = this.userAccountService.getUserByAccount(sscSpecial.getUserAccount());
/* 54 */         if (ua == null) {
/* 55 */           errors.rejectValue("userAccount", "", "会员不存在！");
/* 56 */           return;
/*    */         }
/*    */       }
/*    */     }
/*    */ 
/* 61 */     if ((sscSpecial.getListTurnover() == null) && (sscSpecial.getListUnturnover() == null) && (sscSpecial.getOrderTurnover() == null) && (sscSpecial.getOrderUnturnover() == null))
/*    */     {
/* 63 */       errors.rejectValue("listTurnover", "", "设置值不允许都是空！");
/* 64 */       errors.rejectValue("listUnturnover", "", "设置值不允许都是空！");
/* 65 */       errors.rejectValue("orderTurnover", "", "设置值不允许都是空！");
/* 66 */       errors.rejectValue("orderUnturnover", "", "设置值不允许都是空！");
/* 67 */       return;
/*    */     }
/*    */ 
/* 70 */     if (!"Y".equals(isSystem))
/*    */     {
/* 73 */       if ((StringUtil.isNotBlank(userAccount)) && (StringUtil.isNotBlank(proTypeCode))) {
/* 74 */         SystemServicechargeSpecialQuery query = new SystemServicechargeSpecialQuery();
/* 75 */         query.setUserAccount(userAccount);
/* 76 */         query.setProTypeCode(proTypeCode);
/* 77 */         query.setTradingType(tradingType);
/* 78 */         query.setHaveAuctioneer(haveAuctioneer);
/* 79 */         query.setTurnoverAmount(turnoverAmount);
/* 80 */         if (null != sscSpecial.getId()) {
/* 81 */           query.setNoneId(sscSpecial.getId());
/*    */         }
/* 83 */         List list = this.systemServiceCSpecialService.selectRepeatConfig(query);
/* 84 */         if ((list != null) && (list.size() > 0)) {
/* 85 */           errors.rejectValue("listUnturnover", "", "在选择的条件下已经设置过值！");
/* 86 */           errors.rejectValue("listTurnover", "", "在选择的条件下已经设置过值！");
/* 87 */           errors.rejectValue("orderUnturnover", "", "在选择的条件下已经设置过值！");
/* 88 */           errors.rejectValue("orderTurnover", "", "在选择的条件下已经设置过值！");
/* 89 */           return;
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.SysSerCSpecialAddValidator
 * JD-Core Version:    0.6.0
 */