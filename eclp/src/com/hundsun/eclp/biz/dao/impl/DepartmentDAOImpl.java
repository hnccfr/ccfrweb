/*    */ package com.hundsun.eclp.biz.dao.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.DepartmentDAO;
/*    */ import com.hundsun.eclp.biz.domain.dept.Department;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("departmentDAO")
/*    */ public class DepartmentDAOImpl extends BaseDAO
/*    */   implements DepartmentDAO
/*    */ {
/*    */   public void insert(Department department)
/*    */   {
/* 13 */     getSqlMapClientTemplate().insert("ECLP_DEPARTMENT.insert", department);
/*    */   }
/*    */ 
/*    */   public int update(Department department) {
/* 17 */     int rows = getSqlMapClientTemplate().update("ECLP_DEPARTMENT.update", department);
/* 18 */     return rows;
/*    */   }
/*    */ 
/*    */   public Department selectById(Long id) {
/* 22 */     Department record = (Department)getSqlMapClientTemplate().queryForObject("ECLP_DEPARTMENT.selectById", id);
/* 23 */     return record;
/*    */   }
/*    */ 
/*    */   public int delete(Long id) {
/* 27 */     int rows = getSqlMapClientTemplate().delete("ECLP_DEPARTMENT.delete", id);
/* 28 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.DepartmentDAOImpl
 * JD-Core Version:    0.6.0
 */