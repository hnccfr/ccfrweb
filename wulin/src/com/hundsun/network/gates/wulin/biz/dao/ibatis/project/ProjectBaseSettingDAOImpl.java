/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectBaseSettingDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectBaseSetting;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("ProjectBaseSettingDAO")
/*    */ public class ProjectBaseSettingDAOImpl extends BaseDAO
/*    */   implements ProjectBaseSettingDAO
/*    */ {
/*    */   public ProjectBaseSetting selectBaseSet(Map<String, Object> parasMap)
/*    */   {
/* 18 */     ProjectBaseSetting proBaseSet = (ProjectBaseSetting)getSqlMapClientTemplate().queryForObject("ProjectBaseSetting.selectBaseSet", parasMap);
/* 19 */     return proBaseSet;
/*    */   }
/*    */ 
/*    */   public List<ProjectBaseSetting> selectBaseSetList(Map<String, Object> parasMap)
/*    */   {
/* 25 */     return getSqlMapClientTemplate().queryForList("ProjectBaseSetting.selectBaseSetList", parasMap);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.project.ProjectBaseSettingDAOImpl
 * JD-Core Version:    0.6.0
 */