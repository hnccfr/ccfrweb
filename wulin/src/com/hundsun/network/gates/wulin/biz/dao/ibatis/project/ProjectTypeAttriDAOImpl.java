/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectTypeAttriDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectTypeAttri;
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
/* 25 */     Map map = new HashMap();
/* 26 */     map.put("codeList", codeList);
/* 27 */     return getSqlMapClientTemplate().queryForList("ProjectTypeAttri.queryProjectTypeAttriByTypeCodeList", map);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.project.ProjectTypeAttriDAOImpl
 * JD-Core Version:    0.6.0
 */