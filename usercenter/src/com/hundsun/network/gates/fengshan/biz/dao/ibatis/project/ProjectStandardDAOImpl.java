/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectStandardDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectStandard;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectStandardQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("proejctStandardDAO")
/*    */ public class ProjectStandardDAOImpl extends BaseDAO
/*    */   implements ProjectStandardDAO
/*    */ {
/*    */   public void selectPageList(ProjectStandardQuery query)
/*    */   {
/* 29 */     paginate(query, "Standard.selectPageList_count", "Standard.selectPageList");
/*    */   }
/*    */ 
/*    */   public List<ProjectStandard> selectStandardList()
/*    */   {
/* 38 */     return getSqlMapClientTemplate().queryForList("Standard.selectStandardList");
/*    */   }
/*    */ 
/*    */   public List<ProjectStandard> selectStandardListBySelective(ProjectStandard standard)
/*    */   {
/* 48 */     return getSqlMapClientTemplate().queryForList("Standard.selectConditionList", standard);
/*    */   }
/*    */ 
/*    */   public void insert(ProjectStandard record)
/*    */   {
/* 58 */     getSqlMapClientTemplate().insert("Standard.insert", record);
/*    */   }
/*    */ 
/*    */   public ProjectStandard selectByPrimaryKey(Long id)
/*    */   {
/* 68 */     return (ProjectStandard)getSqlMapClientTemplate().queryForObject("Standard.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectStandard record)
/*    */   {
/* 79 */     int rows = getSqlMapClientTemplate().update("Standard.updateByPrimaryKey", record);
/* 80 */     return rows;
/*    */   }
/*    */ 
/*    */   public int setenableStatus(Long id, String enable)
/*    */   {
/* 89 */     Map paras = new HashMap();
/* 90 */     paras.put("id", id + "");
/* 91 */     paras.put("enable", enable);
/*    */ 
/* 93 */     int rows = getSqlMapClientTemplate().update("Standard.updateEnable", paras);
/* 94 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.project.ProjectStandardDAOImpl
 * JD-Core Version:    0.6.0
 */