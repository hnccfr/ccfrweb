/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.user.UserUpgradeAuditDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.user.UserUpgradeAudit;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userUpgradeAuditDAO")
/*    */ public class UserUpgradeAuditDAOImpl extends BaseDAO
/*    */   implements UserUpgradeAuditDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 15 */     return getSqlMapClientTemplate().delete("UserUpgradeAudit.deleteByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public void insert(UserUpgradeAudit record) {
/* 19 */     getSqlMapClientTemplate().insert("UserUpgradeAudit.insert", record);
/*    */   }
/*    */ 
/*    */   public UserUpgradeAudit selectByPrimaryKey(Long id) {
/* 23 */     return (UserUpgradeAudit)getSqlMapClientTemplate().queryForObject("UserUpgradeAudit.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(UserUpgradeAudit record) {
/* 27 */     return getSqlMapClientTemplate().update("UserUpgradeAudit.updateByPrimaryKeySelective", record);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.user.UserUpgradeAuditDAOImpl
 * JD-Core Version:    0.6.0
 */