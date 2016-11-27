/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectBaseSettingDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectBaseSetting;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectBaseSettingQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectBaseSettingService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("projectBaseSettingService")
/*    */ public class ProjectBaseSettingServiceImpl
/*    */   implements ProjectBaseSettingService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectBaseSettingDAO projectBaseSettingDAO;
/*    */ 
/*    */   public void selectPageList(ProjectBaseSettingQuery query)
/*    */   {
/* 20 */     this.projectBaseSettingDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public List<ProjectBaseSetting> selectProBSListBySelective(ProjectBaseSetting proBS)
/*    */   {
/* 26 */     return this.projectBaseSettingDAO.selectProBSListBySelective(proBS);
/*    */   }
/*    */ 
/*    */   public void insert(ProjectBaseSetting record)
/*    */   {
/* 31 */     this.projectBaseSettingDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public ProjectBaseSetting selectByPrimaryKey(Long id)
/*    */   {
/* 37 */     return this.projectBaseSettingDAO.selectByPrimaryKey(id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectBaseSetting record)
/*    */   {
/* 43 */     return this.projectBaseSettingDAO.updateByPrimaryKey(record);
/*    */   }
/*    */ 
/*    */   public int setenableStatus(Long id, String enable)
/*    */   {
/* 49 */     return this.projectBaseSettingDAO.setenableStatus(id, enable);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.project.ProjectBaseSettingServiceImpl
 * JD-Core Version:    0.6.0
 */