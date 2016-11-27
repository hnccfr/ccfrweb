/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectTypeDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectType;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("projectTypeDAO")
/*    */ public class ProjectTypeDAOImpl extends BaseDAO
/*    */   implements ProjectTypeDAO
/*    */ {
/*    */   public List<ProjectType> getProTypeListBySelective(ProjectType proType)
/*    */   {
/* 22 */     return getSqlMapClientTemplate().queryForList("ProjectType.selectConditionList", proType);
/*    */   }
/*    */ 
/*    */   public List<ProjectType> queryProjectTypeAllChild(String code)
/*    */   {
/* 28 */     Map paras = new HashMap();
/* 29 */     paras.put("parCode", code);
/* 30 */     return getSqlMapClientTemplate().queryForList("ProjectType.queryProjectTypeAllChild", paras);
/*    */   }
/*    */ 
/*    */   public ProjectType getProjectTypeByCode(String code)
/*    */   {
/* 35 */     ProjectType _key = new ProjectType();
/* 36 */     _key.setCode(code);
/* 37 */     ProjectType record = (ProjectType)getSqlMapClientTemplate().queryForObject("ProjectType.getProjectTypeByCode", _key);
/* 38 */     return record;
/*    */   }
/*    */ 
/*    */   public void insert(ProjectType record)
/*    */   {
/* 43 */     getSqlMapClientTemplate().insert("ProjectType.insert", record);
/*    */   }
/*    */ 
/*    */   public int getProjectNumByObj(ProjectType record)
/*    */   {
/* 48 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("ProjectType.queryProjectTypeCount", record);
/* 49 */     return count.intValue();
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(ProjectType record) {
/* 53 */     int rows = getSqlMapClientTemplate().update("ProjectType.updateByPrimaryKeySelective", record);
/* 54 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateEnableStatus(String code, int enable)
/*    */   {
/* 61 */     Map paras = new HashMap();
/* 62 */     paras.put("code", code);
/* 63 */     paras.put("enable", enable + "");
/*    */ 
/* 65 */     int rows = getSqlMapClientTemplate().update("ProjectType.updateEnable", paras);
/* 66 */     return rows;
/*    */   }
/*    */ 
/*    */   public List<ProjectType> getProjectTypeForScreen()
/*    */   {
/* 71 */     return getSqlMapClientTemplate().queryForList("ProjectType.getProjectTypeForScreen");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.project.ProjectTypeDAOImpl
 * JD-Core Version:    0.6.0
 */