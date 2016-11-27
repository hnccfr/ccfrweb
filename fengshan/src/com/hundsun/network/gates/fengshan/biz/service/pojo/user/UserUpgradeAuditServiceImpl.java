/*     */ package com.hundsun.network.gates.fengshan.biz.service.pojo.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserUpgradeAuditDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserRole;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserUpgradeAudit;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserRoleService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserUpgradeAuditService;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumCheckCommonNodes;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemUserCheckRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemUserCheckResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("userUpgradeAuditService")
/*     */ public class UserUpgradeAuditServiceImpl extends BaseService
/*     */   implements UserUpgradeAuditService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserUpgradeAuditDAO userUpgradeAuditDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   @Autowired
/*     */   private UserRoleService userRoleService;
/*     */ 
/*     */   public Integer changeAuditByUserAccount(UserUpgradeAudit userUpgradeAudit)
/*     */   {
/*  38 */     return this.userUpgradeAuditDAO.updateAuditByUserAccount(userUpgradeAudit);
/*     */   }
/*     */ 
/*     */   public UserUpgradeAudit getAuditByUserAccount(UserUpgradeAudit userUpgradeAudit) {
/*  42 */     return this.userUpgradeAuditDAO.selectAuditByUserAccount(userUpgradeAudit);
/*     */   }
/*     */ 
/*     */   public Long addAuditByUserAccount(UserUpgradeAudit userUpgradeAudit) {
/*  46 */     return this.userUpgradeAuditDAO.insertAuditByUserAccount(userUpgradeAudit);
/*     */   }
/*     */ 
/*     */   public Integer upGradeUserRole(UserUpgradeAudit userUpgradeAudit, String userAccount)
/*     */   {
/*  65 */     UserUpgradeAudit query = userUpgradeAudit;
/*  66 */     query.setAuditNode(EnumCheckCommonNodes.END_NODE.getValue());
/*  67 */     UserRole userRoleNow = this.userRoleService.getRoleInfoByAccount(userAccount);
/*  68 */     UserRole userRoleApply = this.userRoleService.getRoleInfoByName(userUpgradeAudit.getApplyLevel());
/*  69 */     if (userRoleApply.getRanking().longValue() <= userRoleNow.getRanking().longValue()) {
/*  70 */       return Integer.valueOf(-2);
/*     */     }
/*  72 */     SystemUserCheckRequest request = new SystemUserCheckRequest();
/*  73 */     request.setRoleName(userRoleNow.getName());
/*  74 */     request.setUpgradeRoleName(userUpgradeAudit.getApplyLevel());
/*  75 */     SystemUserCheckResult result = getCheckProcess(request);
/*  76 */     if ((result.error()) || (null == result.getCheckProcess())) {
/*  77 */       this.log.error("UserUpGradeAuditServiceImpl升级用户失败：" + result.getErrorInfo());
/*  78 */       return Integer.valueOf(-1);
/*     */     }
/*     */ 
/*  81 */     UserUpgradeAudit resultOfQueryAudit = getAuditByUserAccount(query);
/*     */ 
/*  83 */     if (null == resultOfQueryAudit) {
/*  84 */       userUpgradeAudit.setAuditProcess(result.getCheckProcess());
/*  85 */       userUpgradeAudit.setAuditNode(result.getCheckProcess().substring(0, 1));
/*  86 */       Long resultLong = addAuditByUserAccount(userUpgradeAudit);
/*  87 */       if (resultLong.longValue() > 0L)
/*  88 */         return Integer.valueOf(1);
/*  89 */       return Integer.valueOf(0);
/*     */     }
/*  91 */     return Integer.valueOf(-1);
/*     */   }
/*     */ 
/*     */   public SystemUserCheckResult getCheckProcess(SystemUserCheckRequest request)
/*     */   {
/*  99 */     SystemUserCheckResult result = new SystemUserCheckResult();
/* 100 */     if (null == request) {
/* 101 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 102 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 103 */       return result;
/*     */     }
/*     */     try {
/* 106 */       result = this.remoteSystemBaseService.getUserUpgradeCheckProcess(request);
/*     */     } catch (Exception e) {
/* 108 */       this.log.error(e);
/* 109 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 110 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 111 */       return result;
/*     */     }
/* 113 */     return result;
/*     */   }
/*     */ 
/*     */   public UserUpgradeAudit getRecentAuditResult(String userAccount) {
/* 117 */     return this.userUpgradeAuditDAO.selectRecentAuditResult(userAccount);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.user.UserUpgradeAuditServiceImpl
 * JD-Core Version:    0.6.0
 */