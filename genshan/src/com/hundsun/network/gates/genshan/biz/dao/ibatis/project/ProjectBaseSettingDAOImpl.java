/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectBaseSettingDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectBaseSetting;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectBaseSettingQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("projectBaseSettingDAO")
/*    */ public class ProjectBaseSettingDAOImpl extends BaseDAO
/*    */   implements ProjectBaseSettingDAO
/*    */ {
/*    */   public void selectPageList(ProjectBaseSettingQuery query)
/*    */   {
/* 29 */     paginate(query, "ProjectBaseSetting.selectPageList-count", "ProjectBaseSetting.selectPageList");
/*    */   }
/*    */ 
/*    */   public List<ProjectBaseSetting> selectProBSListBySelective(ProjectBaseSetting proBS)
/*    */   {
/* 38 */     return getSqlMapClientTemplate().queryForList("ProjectBaseSetting.selectConditionList", proBS);
/*    */   }
/*    */ 
/*    */   public void insert(ProjectBaseSetting record)
/*    */   {
/* 47 */     getSqlMapClientTemplate().insert("ProjectBaseSetting.insert", record);
/*    */   }
/*    */ 
/*    */   public ProjectBaseSetting selectByPrimaryKey(Long id)
/*    */   {
/* 57 */     return (ProjectBaseSetting)getSqlMapClientTemplate().queryForObject("ProjectBaseSetting.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectBaseSetting record)
/*    */   {
/* 67 */     int rows = getSqlMapClientTemplate().update("ProjectBaseSetting.updateByPrimaryKey", record);
/* 68 */     return rows;
/*    */   }
/*    */ 
/*    */   public int setenableStatus(Long id, String enable)
/*    */   {
/* 78 */     Map paras = new HashMap();
/* 79 */     paras.put("id", id + "");
/* 80 */     paras.put("enable", enable);
/*    */ 
/* 82 */     int rows = getSqlMapClientTemplate().update("ProjectBaseSetting.updateEnable", paras);
/* 83 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.project.ProjectBaseSettingDAOImpl
 * JD-Core Version:    0.6.0
 */