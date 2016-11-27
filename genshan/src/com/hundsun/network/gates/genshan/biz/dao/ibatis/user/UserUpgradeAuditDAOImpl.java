/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.user.UserUpgradeAuditDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.AccountAndUpgradeInfoQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserUpgradeAudit;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumUserCheckProcess;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userUpgradeAuditDAO")
/*    */ public class UserUpgradeAuditDAOImpl extends BaseDAO
/*    */   implements UserUpgradeAuditDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 26 */     UserUpgradeAudit _key = new UserUpgradeAudit();
/* 27 */     _key.setId(id);
/* 28 */     int rows = getSqlMapClientTemplate().delete("USER_UPGRADE_AUDIT.deleteByPrimaryKey", _key);
/* 29 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(UserUpgradeAudit record) {
/* 33 */     getSqlMapClientTemplate().insert("USER_UPGRADE_AUDIT.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(UserUpgradeAudit record) {
/* 37 */     getSqlMapClientTemplate().insert("USER_UPGRADE_AUDIT.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public UserUpgradeAudit selectByPrimaryKey(Long id)
/*    */   {
/* 44 */     UserUpgradeAudit record = (UserUpgradeAudit)getSqlMapClientTemplate().queryForObject("USER_UPGRADE_AUDIT.selectByPrimaryKey", id);
/* 45 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(UserUpgradeAudit record) {
/* 49 */     int rows = getSqlMapClientTemplate().update("USER_UPGRADE_AUDIT.updateByPrimaryKeySelective", record);
/* 50 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(UserUpgradeAudit record) {
/* 54 */     int rows = getSqlMapClientTemplate().update("USER_UPGRADE_AUDIT.updateByPrimaryKey", record);
/* 55 */     return rows;
/*    */   }
/*    */ 
/*    */   public void selectUserOfAudit(AccountAndUpgradeInfoQuery query)
/*    */   {
/* 60 */     paginate(query, "USER_UPGRADE_AUDIT.selectNumberOfAudit", "USER_UPGRADE_AUDIT.selectUserUpgradeInfoByNode");
/*    */   }
/*    */ 
/*    */   public Integer selectNumOfAudit()
/*    */   {
/* 65 */     AccountAndUpgradeInfoQuery query = new AccountAndUpgradeInfoQuery();
/* 66 */     query.setAuditNode(EnumUserCheckProcess.HT_AUDIT.getValue());
/* 67 */     return (Integer)getSqlMapClientTemplate().queryForObject("USER_UPGRADE_AUDIT.selectNumberOfAudit", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.user.UserUpgradeAuditDAOImpl
 * JD-Core Version:    0.6.0
 */