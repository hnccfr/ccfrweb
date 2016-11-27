/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectStandardDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectStandard;
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
/*    */   public List<ProjectStandard> getStandardListByQuery(List<String> codeList)
/*    */   {
/* 23 */     Map map = new HashMap();
/* 24 */     map.put("codeList", codeList);
/* 25 */     return getSqlMapClientTemplate().queryForList("Standard.queryListByProTypeCode", map);
/*    */   }
/*    */ 
/*    */   public ProjectStandard getStandardById(Long id)
/*    */   {
/* 35 */     return (ProjectStandard)getSqlMapClientTemplate().queryForObject("Standard.selectByPrimaryKey", id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.project.ProjectStandardDAOImpl
 * JD-Core Version:    0.6.0
 */