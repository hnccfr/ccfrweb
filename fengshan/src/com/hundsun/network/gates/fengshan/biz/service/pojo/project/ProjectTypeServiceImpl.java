/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeJson;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectTypeService;
/*    */ import com.hundsun.network.gates.fengshan.web.util.ConvertUtils;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeAttriDTO;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeDTO;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectTypeRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectTypeAttriServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectTypeServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectTypeService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("projectTypeService")
/*    */ public class ProjectTypeServiceImpl extends BaseService
/*    */   implements ProjectTypeService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RemoteProjectTypeService remoteProjectTypeService;
/*    */ 
/*    */   public List<ProjectTypeJson> queryProjectTypeTree(String code)
/*    */   {
/* 36 */     List<ProjectTypeDTO> list = new ArrayList();
/* 37 */     ProjectTypeRequest request = new ProjectTypeRequest();
/* 38 */     request.setProjectCode(code);
/*    */     try {
/* 40 */       ProjectTypeServiceResult result = this.remoteProjectTypeService.getProjectTypeByCode(request);
/*    */ 
/* 42 */       if (result.correct())
/* 43 */         list = result.getData();
/*    */     }
/*    */     catch (Exception e) {
/* 46 */       e.printStackTrace();
/* 47 */       this.log.error("remoteProjectTypeService.getProjectTypeByCode fail", e);
/* 48 */       return null;
/*    */     }
/* 50 */     List jsonList = new ArrayList();
/* 51 */     if ((null != list) && (!list.isEmpty())) {
/* 52 */       for (ProjectTypeDTO type : list) {
/* 53 */         String parentcodeShort = null == type.getParCode() ? "" : type.getParCode();
/*    */ 
/* 59 */         ProjectTypeJson jsonDTO = new ProjectTypeJson(type, parentcodeShort);
/* 60 */         jsonList.add(jsonDTO);
/*    */       }
/*    */     }
/* 63 */     return jsonList;
/*    */   }
/*    */ 
/*    */   public List<ProjectTypeAttri> queryProjectTypeAttri(String code)
/*    */   {
/* 68 */     List list = new ArrayList();
/* 69 */     List<ProjectTypeAttriDTO> dtoList = new ArrayList();
/* 70 */     ProjectTypeRequest request = new ProjectTypeRequest();
/* 71 */     request.setProjectCode(code);
/*    */     try {
/* 73 */       ProjectTypeAttriServiceResult result = this.remoteProjectTypeService.getProjectTypeAttriByCode(request);
/*    */ 
/* 75 */       if (result.correct())
/* 76 */         dtoList = result.getData();
/*    */     }
/*    */     catch (Exception e) {
/* 79 */       e.printStackTrace();
/* 80 */       this.log.error("remoteProjectTypeService.getProjectTypeByCode fail", e);
/* 81 */       return list;
/*    */     }
/* 83 */     if (null != dtoList) {
/* 84 */       for (ProjectTypeAttriDTO dto : dtoList) {
/* 85 */         list.add(ConvertUtils.convert(dto));
/*    */       }
/*    */     }
/* 88 */     return list;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.project.ProjectTypeServiceImpl
 * JD-Core Version:    0.6.0
 */