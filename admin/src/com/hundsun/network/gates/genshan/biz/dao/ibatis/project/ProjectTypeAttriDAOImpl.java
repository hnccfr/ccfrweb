/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectTypeAttriDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("projectTypeAttriDAO")
/*    */ public class ProjectTypeAttriDAOImpl extends BaseDAO
/*    */   implements ProjectTypeAttriDAO
/*    */ {
/*    */   public List<ProjectTypeAttri> getProjectAttriListByQuery(List<String> codeList)
/*    */   {
/* 23 */     Map map = new HashMap();
/* 24 */     map.put("codeList", codeList);
/* 25 */     return getSqlMapClientTemplate().queryForList("ProjectTypeAttri.queryProjectTypeAttriByTypeCodeList", map);
/*    */   }
/*    */ 
/*    */   public List<ProjectTypeAttri> getProjectAttriListBySelective(Map<String, Object> map)
/*    */   {
/* 32 */     return getSqlMapClientTemplate().queryForList("ProjectTypeAttri.selectConditionList", map);
/*    */   }
/*    */ 
/*    */   public void insert(ProjectTypeAttri record)
/*    */   {
/* 37 */     getSqlMapClientTemplate().insert("ProjectTypeAttri.insert", record);
/*    */   }
/*    */ 
/*    */   public ProjectTypeAttri selectByPrimaryKey(Long id)
/*    */   {
/* 42 */     ProjectTypeAttri _key = new ProjectTypeAttri();
/* 43 */     _key.setId(id);
/* 44 */     ProjectTypeAttri record = (ProjectTypeAttri)getSqlMapClientTemplate().queryForObject("ProjectTypeAttri.selectByPrimaryKey", _key);
/* 45 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectTypeAttri record)
/*    */   {
/* 50 */     int rows = getSqlMapClientTemplate().update("ProjectTypeAttri.updateByPrimaryKey", record);
/* 51 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateEnableStatus(Long id, Long enable)
/*    */   {
/* 56 */     Map map = new HashMap();
/* 57 */     map.put("id", id);
/* 58 */     map.put("enable", enable);
/* 59 */     int rows = getSqlMapClientTemplate().update("ProjectTypeAttri.updateEnableStatus", map);
/* 60 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.project.ProjectTypeAttriDAOImpl
 * JD-Core Version:    0.6.0
 */