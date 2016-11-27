/*    */ package com.hundsun.eclp.biz.dao.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.RoleSystemDAO;
/*    */ import com.hundsun.eclp.biz.domain.role.RoleSytem;
/*    */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("roleSystemDAO")
/*    */ public class RoleSystemDAOImpl extends BaseDAO
/*    */   implements RoleSystemDAO
/*    */ {
/*    */   private static final String SQLMAP_SPACE = "RoleSystem.";
/*    */ 
/*    */   public Long insertRoleSystem(RoleSytem roleSytem)
/*    */   {
/* 18 */     if (roleSytem != null) {
/* 19 */       return (Long)getSqlMapClientTemplate().insert("RoleSystem.insertRoleSystem", roleSytem);
/*    */     }
/* 21 */     return null;
/*    */   }
/*    */ 
/*    */   public String getRoleIDBySystemID(long subsystemID)
/*    */   {
/* 26 */     if (subsystemID > 0L) {
/* 27 */       return (String)getSqlMapClientTemplate().queryForObject("RoleSystem.getRoleIDBySystemID", Long.valueOf(subsystemID));
/*    */     }
/* 29 */     return null;
/*    */   }
/*    */ 
/*    */   public List<SubSystem> selectSystemByUserId(Long userid)
/*    */   {
/* 35 */     if (userid != null) {
/* 36 */       return getSqlMapClientTemplate().queryForList("RoleSystem.selectSystemByUserId", userid);
/*    */     }
/* 38 */     return null;
/*    */   }
/*    */ 
/*    */   public String getRoleIDBySystemCode(String subsystemCode)
/*    */   {
/* 43 */     if (StringUtil.isNotEmpty(subsystemCode)) {
/* 44 */       return (String)getSqlMapClientTemplate().queryForObject("RoleSystem.getRoleIDBySystemCode", subsystemCode);
/*    */     }
/* 46 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.RoleSystemDAOImpl
 * JD-Core Version:    0.6.0
 */