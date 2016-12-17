/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectStandardDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectStandard;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectStandardQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("standardDAO")
/*    */ public class ProjectStandardDAOImpl extends BaseDAO
/*    */   implements ProjectStandardDAO
/*    */ {
/*    */   public void selectPageList(ProjectStandardQuery query)
/*    */   {
/* 29 */     paginate(query, "Standard.selectPageList-count", "Standard.selectPageList");
/*    */   }
/*    */ 
/*    */   public List<ProjectStandard> selectStandardList()
/*    */   {
/* 39 */     return getSqlMapClientTemplate().queryForList("Standard.selectStandardList");
/*    */   }
/*    */ 
/*    */   public List<ProjectStandard> selectStandardListBySelective(ProjectStandard standard)
/*    */   {
/* 48 */     return getSqlMapClientTemplate().queryForList("Standard.selectConditionList", standard);
/*    */   }
/*    */ 
/*    */   public void insert(ProjectStandard record)
/*    */   {
/* 57 */     getSqlMapClientTemplate().insert("Standard.insert", record);
/*    */   }
/*    */ 
/*    */   public ProjectStandard selectByPrimaryKey(Long id)
/*    */   {
/* 66 */     return (ProjectStandard)getSqlMapClientTemplate().queryForObject("Standard.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectStandard record)
/*    */   {
/* 76 */     int rows = getSqlMapClientTemplate().update("Standard.updateByPrimaryKey", record);
/* 77 */     return rows;
/*    */   }
/*    */ 
/*    */   public int setenableStatus(Long id, String enable)
/*    */   {
/* 86 */     Map paras = new HashMap();
/* 87 */     paras.put("id", id + "");
/* 88 */     paras.put("enable", enable);
/*    */ 
/* 90 */     int rows = getSqlMapClientTemplate().update("Standard.updateEnable", paras);
/* 91 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.project.ProjectStandardDAOImpl
 * JD-Core Version:    0.6.0
 */