/*     */ package com.hundsun.eclp.biz.dao.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.RoleDAO;
/*     */ import com.hundsun.eclp.biz.domain.role.Role;
/*     */ import com.hundsun.eclp.biz.query.UsersQuery;
/*     */ import com.hundsun.network.common.dao.BaseDAO;
/*     */ import com.hundsun.network.common.query.QueryPage;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("roleDAO")
/*     */ public class RoleDAOImpl extends BaseDAO
/*     */   implements RoleDAO
/*     */ {
/*     */   private static final String SQLMAP_SPACE = "Role.";
/*     */ 
/*     */   public Long insertRole(Role record)
/*     */   {
/*  19 */     if (record != null) {
/*  20 */       return (Long)getSqlMapClientTemplate().insert("Role.insertRole", record);
/*     */     }
/*  22 */     return null;
/*     */   }
/*     */ 
/*     */   public int updateRole(Role record) {
/*  26 */     if (record != null) {
/*  27 */       return getSqlMapClientTemplate().update("Role.updateRole", record);
/*     */     }
/*  29 */     return 0;
/*     */   }
/*     */ 
/*     */   public Role selectRoleById(Long id)
/*     */   {
/*  34 */     if (id != null) {
/*  35 */       return (Role)getSqlMapClientTemplate().queryForObject("Role.selectRoleById", id);
/*     */     }
/*  37 */     return null;
/*     */   }
/*     */ 
/*     */   public int deleteRoleById(Long id)
/*     */   {
/*  42 */     if (id != null) {
/*  43 */       Role role = selectRoleById(id);
/*  44 */       if (role != null) {
/*  45 */         role.setIsDeleted("Y");
/*  46 */         return updateRole(role);
/*     */       }
/*     */     }
/*  49 */     return 0;
/*     */   }
/*     */ 
/*     */   public List<Role> getRoleList()
/*     */   {
/*  54 */     return getSqlMapClientTemplate().queryForList("Role.getRoleList");
/*     */   }
/*     */ 
/*     */   public List<Role> getRoleList(Role role)
/*     */   {
/*  59 */     return getSqlMapClientTemplate().queryForList("Role.getRoleListWithoutBasic", role);
/*     */   }
/*     */ 
/*     */   public int getRoleCountByCode(String code, Long roleId) {
/*  63 */     Role role = new Role();
/*  64 */     role.setCode(code);
/*  65 */     role.setId(roleId);
/*  66 */     return ((Integer)getSqlMapClientTemplate().queryForObject("Role.getRoleCountByCode", role)).intValue();
/*     */   }
/*     */ 
/*     */   public int getRoleCountByDisplayName(String displayName, Long roleId) {
/*  70 */     Role role = new Role();
/*  71 */     role.setDisplayName(displayName);
/*  72 */     role.setId(roleId);
/*  73 */     return ((Integer)getSqlMapClientTemplate().queryForObject("Role.getRoleCountByDisplayName", role)).intValue();
/*     */   }
/*     */ 
/*     */   public int getMaxSort() {
/*  77 */     return ((Integer)getSqlMapClientTemplate().queryForObject("Role.getRoleMaxSort")).intValue();
/*     */   }
/*     */ 
/*     */   public List<Role> getSuperRoleList(Long sysId)
/*     */   {
/*  83 */     return getSqlMapClientTemplate().queryForList("Role.getSuperRoleCountByCode", sysId);
/*     */   }
/*     */ 
/*     */   public QueryPage getRoleByAuthId(UsersQuery query) {
/*  87 */     return getPagination(query, "Role.getRoleCountByAuthId", "Role.getRoleByAuthId");
/*     */   }
/*     */ 
/*     */   public List<Role> getRoleByAuthId(Long authId)
/*     */   {
/*  92 */     if (authId == null)
/*  93 */       return null;
/*  94 */     return getSqlMapClientTemplate().queryForList("Role.getRoleListByAuthId", authId);
/*     */   }
/*     */ 
/*     */   public List<Role> getRoleByUserId(Long userId)
/*     */   {
/*  99 */     if (userId == null)
/* 100 */       return null;
/* 101 */     return getSqlMapClientTemplate().queryForList("Role.getRoleListByUserId", userId);
/*     */   }
/*     */ 
/*     */   public List<Long> getRoleIdBySubSystemCode(String code)
/*     */   {
/* 107 */     if (StringUtil.isBlank(code))
/* 108 */       return null;
/* 109 */     return getSqlMapClientTemplate().queryForList("Role.getRoleIdBySubSystemCode", code);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.RoleDAOImpl
 * JD-Core Version:    0.6.0
 */