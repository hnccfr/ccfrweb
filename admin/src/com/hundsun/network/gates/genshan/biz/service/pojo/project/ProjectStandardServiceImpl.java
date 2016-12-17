/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectStandardDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectStandard;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectStandardQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectStandardService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("standardService")
/*    */ public class ProjectStandardServiceImpl
/*    */   implements ProjectStandardService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectStandardDAO standardDAO;
/*    */ 
/*    */   public void selectPageList(ProjectStandardQuery query)
/*    */   {
/* 23 */     this.standardDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public List<ProjectStandard> selectStandardList()
/*    */   {
/* 31 */     return this.standardDAO.selectStandardList();
/*    */   }
/*    */ 
/*    */   public List<ProjectStandard> selectStandardListBySelective(ProjectStandard standard)
/*    */   {
/* 38 */     return this.standardDAO.selectStandardListBySelective(standard);
/*    */   }
/*    */ 
/*    */   public void insert(ProjectStandard record)
/*    */   {
/* 46 */     this.standardDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public ProjectStandard selectByPrimaryKey(Long id)
/*    */   {
/* 55 */     return this.standardDAO.selectByPrimaryKey(id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectStandard record)
/*    */   {
/* 64 */     return this.standardDAO.updateByPrimaryKey(record);
/*    */   }
/*    */ 
/*    */   public int setenableStatus(Long id, String enable)
/*    */   {
/* 72 */     return this.standardDAO.setenableStatus(id, enable);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.project.ProjectStandardServiceImpl
 * JD-Core Version:    0.6.0
 */