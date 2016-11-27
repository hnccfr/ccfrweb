/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectTypeAttriDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri;
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
/* 59 */     Map map = new HashMap();
/* 60 */     map.put("codeList", codeList);
/* 61 */     return getSqlMapClientTemplate().queryForList("ProjectTypeAttri.queryProjectTypeAttriByTypeCodeList", map);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.project.ProjectTypeAttriDAOImpl
 * JD-Core Version:    0.6.0
 */