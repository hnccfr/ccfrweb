/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.result.ProjectBaseTradeServiceResult;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectBaseDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectMetasDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectMetasServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectMetasService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteProjectService")
/*     */ public class RemoteProjectServiceImpl extends BaseService
/*     */   implements RemoteProjectService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasService projectMetasService;
/*     */ 
/*     */   public ProjectServiceResult getAllProjects()
/*     */   {
/*  50 */     ProjectServiceResult result = new ProjectServiceResult();
/*  51 */     List projectDTOList = new ArrayList();
/*     */ 
/*  53 */     ProjectListingServiceResult projectListingServiceResult = this.projectListingService.getAllProjectListing();
/*     */ 
/*  55 */     if (!projectListingServiceResult.correct()) {
/*  56 */       result.setErrorInfo(projectListingServiceResult.getErrorInfo());
/*  57 */       return result;
/*     */     }
/*  59 */     List<ProjectListingDTO> projectListingList = new ArrayList();
/*  60 */     projectListingList = projectListingServiceResult.getProjectListingDTOList();
/*  61 */     ProjectMetasServiceResult projectMetasServiceResult = this.projectMetasService.getAllProjectMetas();
/*     */ 
/*  63 */     if (!projectMetasServiceResult.correct()) {
/*  64 */       result.setErrorInfo(projectMetasServiceResult.getErrorInfo());
/*  65 */       return result;
/*     */     }
/*  67 */     List<ProjectMetasDTO> projectMetasDTOList = new ArrayList();
/*  68 */     projectMetasDTOList = projectMetasServiceResult.getProjectMetasDTOList();
/*  69 */     for (ProjectListingDTO projectListingDTO : projectListingList) {
/*  70 */       ProjectDTO projectDTO = new ProjectDTO();
/*  71 */       ProjectBaseDTO projectBaseDTO = new ProjectBaseDTO();
/*  72 */       projectBaseDTO.setProjectListingDTO(projectListingDTO);
/*  73 */       List metasDTOList = new ArrayList();
/*  74 */       for (ProjectMetasDTO projectMetasDTO : projectMetasDTOList)
/*  75 */         if ((projectListingDTO != null) && (projectMetasDTO != null) && (projectListingDTO.getId().equals(projectMetasDTO.getProjectId())))
/*     */         {
/*  77 */           metasDTOList.add(projectMetasDTO);
/*     */         }
/*  79 */       ProjectTradeDTO projectTradeDTO = new ProjectTradeDTO();
/*     */       try {
/*  81 */         BeanUtils.copyProperties(projectTradeDTO, projectBaseDTO.getProjectListingDTO());
/*     */       } catch (Exception e) {
/*  83 */         this.log.error("projectTradeDTO  projectBaseDTO.getProjectListingDTO()类型转换上面出错了！", e);
/*  84 */         result.setErrorInfo("projectTradeDTO  projectBaseDTO.getProjectListingDTO()类型转换上面出错了！");
/*     */       }
/*     */ 
/*  87 */       projectTradeDTO.setProjectCode(projectBaseDTO.getProjectListingDTO().getCode());
/*  88 */       projectTradeDTO.setProjectId(projectBaseDTO.getProjectListingDTO().getId());
/*     */ 
/*  90 */       projectBaseDTO.setMetasDTOList(metasDTOList);
/*     */ 
/*  92 */       projectDTO.setProjectBaseDTO(projectBaseDTO);
/*     */ 
/*  94 */       projectDTO.setProjectTradeDTO(projectTradeDTO);
/*  95 */       projectDTOList.add(projectDTO);
/*     */     }
/*  97 */     result.setProjectDTOList(projectDTOList);
/*     */ 
/*  99 */     return result;
/*     */   }
/*     */ 
/*     */   public ProjectServiceResult getProjectInfoByCode(String projectCode)
/*     */   {
/* 109 */     ProjectServiceResult result = new ProjectServiceResult();
/* 110 */     List projectDTOList = new ArrayList();
/* 111 */     ProjectListingServiceResult projectListingServiceResult = this.projectListingService.getProjectInfoByCode(projectCode);
/*     */ 
/* 113 */     if (!projectListingServiceResult.correct()) {
/* 114 */       result.setErrorNOInfo(projectListingServiceResult.getErrorNO(), projectListingServiceResult.getErrorInfo());
/*     */ 
/* 116 */       return result;
/*     */     }
/*     */ 
/* 122 */     ProjectMetasServiceResult projectMetasServiceResult = this.projectMetasService.getProjectMetas(projectCode);
/*     */ 
/* 124 */     if (!projectMetasServiceResult.correct()) {
/* 125 */       result.setErrorNOInfo(projectMetasServiceResult.getErrorNO(), projectMetasServiceResult.getErrorInfo());
/*     */ 
/* 127 */       return result;
/*     */     }
/* 129 */     List<ProjectMetasDTO> projectMetasDTOList = new ArrayList();
/* 130 */     projectMetasDTOList = projectMetasServiceResult.getProjectMetasDTOList();
/*     */ 
/* 132 */     ProjectListingDTO projectListingDTO = projectListingServiceResult.getProjectListingDTO();
/* 133 */     ProjectDTO projectDTO = new ProjectDTO();
/* 134 */     ProjectBaseDTO projectBaseDTO = new ProjectBaseDTO();
/* 135 */     projectBaseDTO.setProjectListingDTO(projectListingDTO);
/* 136 */     List metasDTOList = new ArrayList();
/* 137 */     for (ProjectMetasDTO projectMetasDTO : projectMetasDTOList)
/* 138 */       if ((projectListingDTO != null) && (projectMetasDTO != null) && (projectListingDTO.getId().equals(projectMetasDTO.getProjectId())))
/*     */       {
/* 140 */         metasDTOList.add(projectMetasDTO);
/*     */       }
/* 142 */     ProjectTradeDTO projectTradeDTO = new ProjectTradeDTO();
/*     */     try {
/* 144 */       BeanUtils.copyProperties(projectTradeDTO, projectBaseDTO.getProjectListingDTO());
/*     */     } catch (Exception e) {
/* 146 */       this.log.error("projectTradeDTO  projectBaseDTO.getProjectListingDTO()类型转换上面出错了！", e);
/* 147 */       result.setErrorInfo("projectTradeDTO  projectBaseDTO.getProjectListingDTO()类型转换上面出错了！");
/*     */     }
/* 149 */     projectTradeDTO.setProjectCode(projectBaseDTO.getProjectListingDTO().getCode());
/* 150 */     projectTradeDTO.setProjectId(projectBaseDTO.getProjectListingDTO().getId());
/*     */ 
/* 152 */     projectBaseDTO.setMetasDTOList(metasDTOList);
/*     */ 
/* 154 */     projectDTO.setProjectBaseDTO(projectBaseDTO);
/*     */ 
/* 156 */     projectDTO.setProjectTradeDTO(projectTradeDTO);
/* 157 */     projectDTOList.add(projectDTO);
/*     */ 
/* 159 */     result.setProjectDTOList(projectDTOList);
/* 160 */     return result;
/*     */   }
/*     */ 
/*     */   public ProjectBaseTradeServiceResult getAllProjectBaseTrade()
/*     */   {
/* 169 */     ProjectBaseTradeServiceResult result = this.projectListingService.getAllProjectBaseTrade();
/* 170 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteProjectServiceImpl
 * JD-Core Version:    0.6.0
 */