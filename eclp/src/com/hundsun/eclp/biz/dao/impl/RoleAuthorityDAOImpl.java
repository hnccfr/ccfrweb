/*    */ package com.hundsun.eclp.biz.dao.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.RoleAuthorityDAO;
/*    */ import com.hundsun.eclp.biz.domain.role.RoleAuthority;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("roleAuthorityDAO")
/*    */ public class RoleAuthorityDAOImpl extends BaseDAO
/*    */   implements RoleAuthorityDAO
/*    */ {
/*    */   private static final String SQLMAP_SPACE = "RoleAuthority.";
/*    */ 
/*    */   public void insertRoleAuthority(RoleAuthority record)
/*    */   {
/* 17 */     getSqlMapClientTemplate().insert("RoleAuthority.insertRoleAuthority", record);
/*    */   }
/*    */ 
/*    */   public int updateRoleAuthority(RoleAuthority record)
/*    */   {
/* 22 */     return getSqlMapClientTemplate().update("RoleAuthority.updateRoleAuthority", record);
/*    */   }
/*    */ 
/*    */   public RoleAuthority selectRoleAuthorityById(Long id)
/*    */   {
/* 27 */     return (RoleAuthority)getSqlMapClientTemplate().queryForObject("RoleAuthority.selectRoleAuthorityById", id);
/*    */   }
/*    */ 
/*    */   public int deleteRoleAuthorityById(Long id)
/*    */   {
/* 32 */     return getSqlMapClientTemplate().delete("RoleAuthority.deleteRoleAuthorityById", id);
/*    */   }
/*    */ 
/*    */   public List<RoleAuthority> selectRoleAuthorityByRoleId(Long roleId)
/*    */   {
/* 38 */     if (roleId == null) {
/* 39 */       return null;
/*    */     }
/* 41 */     return getSqlMapClientTemplate().queryForList("RoleAuthority.selectRoleAuthorityByRoleId", roleId);
/*    */   }
/*    */ 
/*    */   public int batchInsertRoleAuth(List<RoleAuthority> list)
/*    */   {
/* 46 */     if (list != null) {
/* 47 */       exectuteBatchInsert("RoleAuthority.insertRoleAuthority", list);
/*    */     }
/* 49 */     return 0;
/*    */   }
/*    */ 
/*    */   public int deleteRoleAuthorityByRoleId(Long roleId)
/*    */   {
/* 54 */     if (roleId != null) {
/* 55 */       return getSqlMapClientTemplate().delete("RoleAuthority.deleteRoleAuthorityByRoleId", roleId);
/*    */     }
/* 57 */     return 0;
/*    */   }
/*    */ 
/*    */   public int deleteRoleAuthorityByAuthIdList(List<Long> idList)
/*    */   {
/* 62 */     return getSqlMapClientTemplate().delete("RoleAuthority.deleteRoleAuthorityByAuthIdList", idList);
/*    */   }
/*    */ 
/*    */   public Integer deleteRoleAuthority(List<RoleAuthority> list)
/*    */   {
/* 67 */     if (list != null) {
/* 68 */       return Integer.valueOf(executeBatchDelete("RoleAuthority.deleteRoleAuthority", list));
/*    */     }
/* 70 */     return null;
/*    */   }
/*    */ 
/*    */   public List<RoleAuthority> findRoleAuthByRoleIdAndAuthId(RoleAuthority roleAuth)
/*    */   {
/* 77 */     if (roleAuth != null) {
/* 78 */       return getSqlMapClientTemplate().queryForList("RoleAuthority.selectRoleAuthByRoleIdAndAuthId", roleAuth);
/*    */     }
/* 80 */     return null;
/*    */   }
/*    */ 
/*    */   public List<RoleAuthority> findParentRoleAuth(RoleAuthority roleAuth)
/*    */   {
/* 86 */     if (roleAuth != null) {
/* 87 */       return getSqlMapClientTemplate().queryForList("RoleAuthority.selectParentRoleAuth", roleAuth);
/*    */     }
/* 89 */     return null;
/*    */   }
/*    */ 
/*    */   public List<RoleAuthority> findAllRoleByAuthId(Long authId)
/*    */   {
/* 95 */     if (authId != null) {
/* 96 */       return getSqlMapClientTemplate().queryForList("RoleAuthority.selectAllRoleByAuthId", authId);
/*    */     }
/* 98 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.RoleAuthorityDAOImpl
 * JD-Core Version:    0.6.0
 */