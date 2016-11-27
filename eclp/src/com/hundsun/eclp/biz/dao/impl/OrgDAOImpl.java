/*     */ package com.hundsun.eclp.biz.dao.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.OrgDAO;
/*     */ import com.hundsun.eclp.biz.domain.dept.Department;
/*     */ import com.hundsun.network.common.dao.BaseDAO;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("orgDAO")
/*     */ public class OrgDAOImpl extends BaseDAO
/*     */   implements OrgDAO
/*     */ {
/*     */   public Map<Long, Integer> getCountByParentGroupByParent(List<Long> parentIdList, Short status)
/*     */     throws Exception
/*     */   {
/*  22 */     if ((parentIdList == null) || (parentIdList.isEmpty())) {
/*  23 */       return null;
/*     */     }
/*  25 */     Map map = new HashMap();
/*  26 */     map.put("parentIdList", parentIdList);
/*  27 */     if (null != status) {
/*  28 */       map.put("status", status.toString());
/*     */     }
/*  30 */     List<Map> list = getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.selectCountByParentGroupByParent", map);
/*  31 */     Map result = new HashMap();
/*  32 */     for (Map mapTemp : list) {
/*  33 */       result.put(Long.valueOf(((BigDecimal)mapTemp.get("PARENT_ID")).longValue()), Integer.valueOf(((BigDecimal)mapTemp.get("ID_COUNT")).intValue()));
/*     */     }
/*     */ 
/*  36 */     return result;
/*     */   }
/*     */ 
/*     */   public List<Department> getListAll(Long status)
/*     */     throws Exception
/*     */   {
/*  42 */     return getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.getAll", status);
/*     */   }
/*     */ 
/*     */   public List<Department> getOrgList(Long status)
/*     */     throws Exception
/*     */   {
/*  48 */     return getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.getOrgList", status);
/*     */   }
/*     */ 
/*     */   public List<Department> getFullListById(Long id)
/*     */     throws Exception
/*     */   {
/*  55 */     return getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.getFullListById", id);
/*     */   }
/*     */ 
/*     */   public int batchInsert(List<Department> list)
/*     */     throws Exception
/*     */   {
/*  61 */     return exectuteBatchInsert("ECLP_DEPARTMENT.insert", list);
/*     */   }
/*     */ 
/*     */   public Long insert(Department dept)
/*     */     throws Exception
/*     */   {
/*  67 */     return (Long)getSqlMapClientTemplate().insert("ECLP_DEPARTMENT.insert", dept);
/*     */   }
/*     */ 
/*     */   public int edit(Department dept)
/*     */     throws Exception
/*     */   {
/*  74 */     return getSqlMapClientTemplate().update("ECLP_DEPARTMENT.update", dept);
/*     */   }
/*     */ 
/*     */   public Department getDepartmentById(Long id)
/*     */     throws Exception
/*     */   {
/*  81 */     return (Department)getSqlMapClientTemplate().queryForObject("ECLP_DEPARTMENT.selectById", id);
/*     */   }
/*     */ 
/*     */   public List<Department> getDeptListByIds(List<Long> ids)
/*     */     throws Exception
/*     */   {
/*  88 */     if ((ids != null) && (ids.size() > 0)) {
/*  89 */       return getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.getOrgListByIds", ids);
/*     */     }
/*  91 */     return null;
/*     */   }
/*     */ 
/*     */   public List<Department> getSubOrgList(Long id)
/*     */     throws Exception
/*     */   {
/*  98 */     return getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.getSubOrgList", id);
/*     */   }
/*     */ 
/*     */   public int batchDelete(List<Long> idList)
/*     */     throws Exception
/*     */   {
/* 104 */     return executeBatchDelete("ECLP_DEPARTMENT.delete", idList);
/*     */   }
/*     */ 
/*     */   public Integer getMaxSort(Long pid)
/*     */     throws Exception
/*     */   {
/* 110 */     if (pid == null) {
/* 111 */       return null;
/*     */     }
/* 113 */     return (Integer)getSqlMapClientTemplate().queryForObject("ECLP_DEPARTMENT.getMaxSort", pid);
/*     */   }
/*     */ 
/*     */   public List<Department> getDownOrgList(Long id)
/*     */     throws Exception
/*     */   {
/* 120 */     if (id == null) {
/* 121 */       return null;
/*     */     }
/* 123 */     return getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.getDownOrgList", id);
/*     */   }
/*     */ 
/*     */   public List<Department> getUpOrgList(Long id)
/*     */     throws Exception
/*     */   {
/* 129 */     if (id == null) {
/* 130 */       return null;
/*     */     }
/* 132 */     return getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.getUpOrgList", id);
/*     */   }
/*     */ 
/*     */   public List<Department> getDeptList(Department dept) throws Exception
/*     */   {
/* 137 */     if (dept == null) {
/* 138 */       return null;
/*     */     }
/* 140 */     return getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.selectByName", dept);
/*     */   }
/*     */ 
/*     */   public int batchUpdate(List<Department> deptList)
/*     */     throws Exception
/*     */   {
/* 146 */     if (deptList == null) {
/* 147 */       return 0;
/*     */     }
/* 149 */     return executeBatchUpdate("ECLP_DEPARTMENT.update", deptList);
/*     */   }
/*     */ 
/*     */   public List<Department> getUpOrgListByUserId(Long userId)
/*     */   {
/* 155 */     if (userId == null) {
/* 156 */       return null;
/*     */     }
/* 158 */     return getSqlMapClientTemplate().queryForList("ECLP_DEPARTMENT.getUpOrgListByUserId", userId);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.OrgDAOImpl
 * JD-Core Version:    0.6.0
 */