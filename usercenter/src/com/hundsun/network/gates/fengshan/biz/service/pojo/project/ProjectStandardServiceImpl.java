/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectStandardDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectStandard;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectStandardQuery;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectStandardService;
/*    */ import com.hundsun.network.gates.fengshan.web.util.ConvertUtils;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectStandardRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectStandardServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectStandardService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("projectStandardService")
/*    */ public class ProjectStandardServiceImpl
/*    */   implements ProjectStandardService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RemoteProjectStandardService remoteProjectStandardService;
/*    */ 
/*    */   @Autowired
/*    */   private ProjectStandardDAO standardDAO;
/*    */ 
/*    */   public List<ProjectStandard> getStandardByProTypeCode(String projectTypeCode)
/*    */   {
/* 26 */     ProjectStandardRequest request = new ProjectStandardRequest();
/* 27 */     request.setProTypeCode(projectTypeCode);
/* 28 */     ProjectStandardServiceResult result = this.remoteProjectStandardService.getStandardByProTypeCode(request);
/*    */ 
/* 30 */     List list = new ArrayList();
/* 31 */     list = ConvertUtils.convertProjectStandardDTOList2ProjectStandardList(result.getData());
/* 32 */     return list;
/*    */   }
/*    */ 
/*    */   public void selectPageList(ProjectStandardQuery query)
/*    */   {
/* 40 */     this.standardDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public List<ProjectStandard> selectStandardList()
/*    */   {
/* 48 */     return this.standardDAO.selectStandardList();
/*    */   }
/*    */ 
/*    */   public List<ProjectStandard> selectStandardListBySelective(ProjectStandard standard)
/*    */   {
/* 55 */     return this.standardDAO.selectStandardListBySelective(standard);
/*    */   }
/*    */ 
/*    */   public void insert(ProjectStandard record)
/*    */   {
/* 63 */     this.standardDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public ProjectStandard selectByPrimaryKey(Long id)
/*    */   {
/* 72 */     return this.standardDAO.selectByPrimaryKey(id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectStandard record)
/*    */   {
/* 81 */     return this.standardDAO.updateByPrimaryKey(record);
/*    */   }
/*    */ 
/*    */   public int setenableStatus(Long id, String enable)
/*    */   {
/* 89 */     return this.standardDAO.setenableStatus(id, enable);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.project.ProjectStandardServiceImpl
 * JD-Core Version:    0.6.0
 */