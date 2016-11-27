/*    */ package com.hundsun.network.gates.taiping.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectDTO;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.result.ProjectInfoServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumProjectErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectService;
/*    */ import com.hundsun.network.gates.taiping.biz.service.project.ProjectService;
/*    */ import com.hundsun.network.gates.taiping.common.util.ConvertUtils;
/*    */ import java.util.List;
/*    */ import nl.justobjects.pushlet.util.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("projectService")
/*    */ public class ProjectServiceImpl
/*    */   implements ProjectService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RemoteProjectService remoteProjectService;
/*    */ 
/*    */   public ProjectInfoServiceResult getProjectInfo(String projectCode)
/*    */   {
/* 22 */     ProjectInfoServiceResult piResult = new ProjectInfoServiceResult();
/* 23 */     ProjectServiceResult result = new ProjectServiceResult();
/*    */     try {
/* 25 */       result = this.remoteProjectService.getProjectInfoByCode(projectCode);
/*    */     } catch (Exception e) {
/* 27 */       Log.error("", e);
/* 28 */       piResult.setErrorInfo(EnumProjectErrors.INTERNAL_ERROR.getInfo());
/* 29 */       piResult.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/* 30 */       return piResult;
/*    */     }
/* 32 */     ProjectDTO projectDTO = new ProjectDTO();
/* 33 */     if (result.correct()) {
/* 34 */       projectDTO = (ProjectDTO)result.getProjectDTOList().get(0);
/* 35 */       piResult.setProjectInfo(ConvertUtils.converntProjectDTO2ProjectInfo(projectDTO));
/* 36 */       return piResult;
/*    */     }
/* 38 */     piResult.setErrorNOInfo(result.getErrorNO(), result.getErrorInfo());
/* 39 */     return piResult;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.pojo.project.ProjectServiceImpl
 * JD-Core Version:    0.6.0
 */