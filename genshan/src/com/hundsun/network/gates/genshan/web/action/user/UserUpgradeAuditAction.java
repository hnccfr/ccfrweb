/*     */ package com.hundsun.network.gates.genshan.web.action.user;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.AccountAndUpgradeInfoQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserUpgradeAudit;
/*     */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.user.UserUpgradeAuditService;
/*     */ import com.hundsun.network.gates.genshan.common.MobileMessageUtil;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class UserUpgradeAuditAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserUpgradeAuditService userUpgradeAuditService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @Autowired
/*     */   private MobileMessageUtil mobileMessageUtil;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_AUDIT_LIST})
/*     */   @RequestMapping({"/user/audit/list"})
/*     */   public void accountUpgradeList(@ModelAttribute("query") AccountAndUpgradeInfoQuery query)
/*     */   {
/*  50 */     if (null != query.getAccount()) {
/*  51 */       query.setAccount(query.getAccount().trim());
/*     */     }
/*  53 */     if (null != query.getName()) {
/*  54 */       query.setName(query.getName().trim());
/*     */     }
/*  56 */     this.userUpgradeAuditService.getUserOfAudit(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_AUDIT})
/*     */   @RequestMapping(value={"/user/audit/info"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void initUpgradeAudit(@ModelAttribute("userUpgradeAudit") UserUpgradeAudit userUpgradeAudit, @ModelAttribute("userAccount") UserAccount userAccount, @ModelAttribute("userLevel") UserLevel userLevel, Model model)
/*     */   {
/*  74 */     userAccount = this.userAccountService.getUserByAccount(userAccount.getAccount());
/*  75 */     userLevel = this.userAccountService.getUserLevelByUserAccount(userAccount.getAccount());
/*  76 */     userUpgradeAudit = this.userUpgradeAuditService.getAuditById(userUpgradeAudit.getId());
/*  77 */     model.addAttribute("userAccount", userAccount);
/*  78 */     model.addAttribute("userLevel", userLevel);
/*  79 */     model.addAttribute("userUpgradeAudit", userUpgradeAudit);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_AUDIT})
/*     */   @RequestMapping(value={"/user/audit/info"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String userUpgradeAudit(UserAgent userAgent, @ModelAttribute("userUpgradeAudit") UserUpgradeAudit userUpgradeAudit, @RequestParam("userAccount") String userAccount, ModelMap model)
/*     */     throws Exception
/*     */   {
/*  97 */     userUpgradeAudit.setOperator(userAgent.getUserAccount());
/*  98 */     userUpgradeAudit.setOperateType(userAgent.getCurrentSystemCode());
/*  99 */     ServiceResult result = this.userUpgradeAuditService.auditUserUpgrade(userUpgradeAudit);
/* 100 */     this.userUpgradeAuditService.sendSystemMessage(userUpgradeAudit, userAccount, userAgent.getUserAccount());
/*     */ 
/* 102 */     if (result.error()) {
/* 103 */       model.put("message", result.getErrorInfo());
/* 104 */       model.put("url", "/user/audit/list");
/* 105 */       return error(model);
/*     */     }
/* 107 */     model.put("url", "/user/audit/list");
/*     */     try
/*     */     {
/* 111 */       List nums = new ArrayList();
/* 112 */       UserAccount account = this.userAccountService.getUserByAccount(userAccount);
/* 113 */       nums.add(account.getMobile());
/* 114 */       String msg = "";
/* 115 */       if (userUpgradeAudit.getAuditNodeResult().equalsIgnoreCase("true"))
/* 116 */         msg = "尊敬的" + account.getName() + "您好，您的交易权限申请已经审核通过【中部林业产权交易服务中心】";
/*     */       else {
/* 118 */         msg = "尊敬的" + account.getName() + "您好，您的交易权限申请未能通过审核，审核失败原因是：" + userUpgradeAudit.getAuditNodeRemark() + "【中部林业产权交易服务中心】";
/*     */       }
/* 120 */       this.mobileMessageUtil.sendMsg(nums, msg);
/*     */     } catch (Exception e) {
/* 122 */       this.log.error("send mobileMessage for UpgradeAudit error cause by:" + e);
/*     */     }
/* 124 */     return success(model);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.user.UserUpgradeAuditAction
 * JD-Core Version:    0.6.0
 */