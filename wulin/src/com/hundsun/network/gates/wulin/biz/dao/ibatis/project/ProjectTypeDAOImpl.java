/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectTypeDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectType;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("projectTypeDAO")
/*    */ public class ProjectTypeDAOImpl extends BaseDAO
/*    */   implements ProjectTypeDAO
/*    */ {
/*    */   public List<ProjectType> queryProjectTypeAllChild(Map<String, String> paras)
/*    */   {
/* 18 */     return getSqlMapClientTemplate().queryForList("ProjectType.queryProjectTypeAllChild", paras);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.project.ProjectTypeDAOImpl
 * JD-Core Version:    0.6.0
 */