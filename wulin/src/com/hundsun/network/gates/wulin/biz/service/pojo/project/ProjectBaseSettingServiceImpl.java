/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectBaseSettingDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectBaseSetting;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectBaseSettingService;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("ProjectBaseSettingService")
/*    */ public class ProjectBaseSettingServiceImpl extends BaseService
/*    */   implements ProjectBaseSettingService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectBaseSettingDAO projectBaseSettingDAO;
/*    */ 
/*    */   public ProjectBaseSetting selectBaseSet(Map<String, Object> parasMap)
/*    */   {
/* 23 */     return this.projectBaseSettingDAO.selectBaseSet(parasMap);
/*    */   }
/*    */ 
/*    */   public List<ProjectBaseSetting> selectBaseSetList(Map<String, Object> parasMap)
/*    */   {
/* 34 */     return this.projectBaseSettingDAO.selectBaseSetList(parasMap);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.project.ProjectBaseSettingServiceImpl
 * JD-Core Version:    0.6.0
 */