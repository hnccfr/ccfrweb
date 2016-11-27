/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserUpgradeAuditDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserUpgradeAudit;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userUpgradeAuditDAO")
/*    */ public class UserUpgradeAuditDAOImpl extends BaseDAO
/*    */   implements UserUpgradeAuditDAO
/*    */ {
/*    */   public UserUpgradeAudit selectAuditByUserAccount(UserUpgradeAudit userUpgradeAudit)
/*    */   {
/* 21 */     return (UserUpgradeAudit)getSqlMapClientTemplate().queryForObject("UserUpgradeAudit.selectByUserAccount", userUpgradeAudit);
/*    */   }
/*    */ 
/*    */   public Integer updateAuditByUserAccount(UserUpgradeAudit userUpgradeAudit)
/*    */   {
/* 26 */     return Integer.valueOf(getSqlMapClientTemplate().update("UserUpgradeAudit.updateByUserAccount", userUpgradeAudit));
/*    */   }
/*    */ 
/*    */   public Long insertAuditByUserAccount(UserUpgradeAudit userUpgradeAudit)
/*    */   {
/* 31 */     return (Long)getSqlMapClientTemplate().insert("UserUpgradeAudit.insert", userUpgradeAudit);
/*    */   }
/*    */ 
/*    */   public UserUpgradeAudit selectRecentAuditResult(String userAccount)
/*    */   {
/* 36 */     return (UserUpgradeAudit)getSqlMapClientTemplate().queryForObject("UserUpgradeAudit.selectRecentAuditResult", userAccount);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.user.UserUpgradeAuditDAOImpl
 * JD-Core Version:    0.6.0
 */