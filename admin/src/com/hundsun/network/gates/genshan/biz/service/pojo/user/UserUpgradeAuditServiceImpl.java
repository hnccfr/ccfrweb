/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.user;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.user.UserUpgradeAuditDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.AccountAndUpgradeInfoQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserUpgradeAudit;
/*    */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.user.UserUpgradeAuditService;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumUserCheckProcess;
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserUpgradeAuditRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemMessageService;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("userUpgradeAuditService")
/*    */ public class UserUpgradeAuditServiceImpl extends BaseService
/*    */   implements UserUpgradeAuditService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserUpgradeAuditDAO userUpgradeAuditDAO;
/*    */ 
/*    */   @Autowired
/*    */   private RemoteUserService remoteUserService;
/*    */ 
/*    */   @Autowired
/*    */   private RemoteSystemMessageService remoteSystemMessageService;
/*    */ 
/*    */   public void getUserOfAudit(AccountAndUpgradeInfoQuery query)
/*    */   {
/* 43 */     query.setAuditNode(EnumUserCheckProcess.HT_AUDIT.getValue());
/* 44 */     this.userUpgradeAuditDAO.selectUserOfAudit(query);
/*    */   }
/*    */ 
/*    */   public UserUpgradeAudit getAuditById(Long id)
/*    */   {
/* 50 */     UserUpgradeAudit userUpgradeAudit = this.userUpgradeAuditDAO.selectByPrimaryKey(id);
/* 51 */     userUpgradeAudit.setAuditNodeRemark("");
/* 52 */     return userUpgradeAudit;
/*    */   }
/*    */ 
/*    */   public ServiceResult auditUserUpgrade(UserUpgradeAudit userUpgradeAudit)
/*    */   {
/* 57 */     UserUpgradeAuditRequest request = new UserUpgradeAuditRequest();
/* 58 */     request.setAuditId(userUpgradeAudit.getId());
/* 59 */     request.setOperator(userUpgradeAudit.getOperator());
/* 60 */     request.setOperateType(userUpgradeAudit.getOperateType());
/* 61 */     request.setAuditNodeRemark(userUpgradeAudit.getAuditNodeRemark());
/* 62 */     if (userUpgradeAudit.getAuditNodeResult().equalsIgnoreCase("true")) {
/* 63 */       request.setAuditNodeResult("Y");
/* 64 */       request.setAuditNodeRemark("后台审核通过(" + request.getAuditNodeRemark() + ")");
/*    */     }
/*    */     else {
/* 67 */       request.setAuditNodeResult("N");
/* 68 */       request.setAuditNodeRemark("后台审核不通过(" + request.getAuditNodeRemark() + ")");
/*    */     }
/* 70 */     ServiceResult result = this.remoteUserService.userUpgradeAudit(request);
/* 71 */     return result;
/*    */   }
/*    */ 
/*    */   public void sendSystemMessage(UserUpgradeAudit userUpgradeAudit, String userAccount, String operatorAccount)
/*    */   {
/* 76 */     SystemMessageRequest request = new SystemMessageRequest();
/* 77 */     List userAccountList = new ArrayList();
/* 78 */     userAccountList.add(userAccount);
/* 79 */     request.setUserAccountList(userAccountList);
/* 80 */     request.setOperator(operatorAccount);
/* 81 */     request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 82 */     request.setTitle("升级审核结果");
/* 83 */     if (userUpgradeAudit.getAuditNodeResult().equalsIgnoreCase("true")) {
/* 84 */       request.setContent("尊敬的用户您好，您的交易权限申请已经审核通过，请退出系统后重新登录查看最新结果");
/* 85 */       this.remoteSystemMessageService.sendSystemMessage(request);
/*    */     } else {
/* 87 */       request.setContent("尊敬的用户您好，您的交易权限申请未能通过审核，审核失败原因是：" + userUpgradeAudit.getAuditNodeRemark());
/* 88 */       this.remoteSystemMessageService.sendSystemMessage(request);
/*    */     }
/*    */   }
/*    */ 
/*    */   public Integer getNumOfAudit()
/*    */   {
/* 94 */     return this.userUpgradeAuditDAO.selectNumOfAudit();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.user.UserUpgradeAuditServiceImpl
 * JD-Core Version:    0.6.0
 */