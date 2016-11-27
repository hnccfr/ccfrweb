/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectMetasDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AnnouncementRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectAuditLogRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectListingRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectAuditLogServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectListingService;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectAuditLog;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectMetasService;
/*     */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*     */ import com.hundsun.network.gates.wulin.common.utils.ProjectCopyUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("remoteProjectListingService")
/*     */ public class RemoteProjectListingServiceImpl extends BaseService
/*     */   implements RemoteProjectListingService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasService projectMetasService;
/*     */ 
/*     */   public ProjectListingServiceResult addProjectListing(ProjectListingRequest projectListingRequest)
/*     */   {
/*  43 */     this.log.debug("RemoteProjectListingServiceImpl add a projectListing");
/*  44 */     ProjectListing projectListing = new ProjectListing();
/*  45 */     projectListing = ConvertUtils.convertProjectListingDTO2ProjectListing(projectListingRequest.getProjectListingDTO());
/*     */ 
/*  47 */     final ProjectListing project = projectListing;
/*  48 */     List projectMetasList = new ArrayList();
/*  49 */     ProjectCopyUtil.copyProperties(projectListingRequest.getProjectMetasDTOList(), projectMetasList);
/*     */ 
/*  51 */     final List<ProjectMetas> metasList = projectMetasList;
/*     */ 
/*  53 */     ProjectListingServiceResult addResult = (ProjectListingServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public ProjectListingServiceResult doInTransaction(TransactionStatus status) {
/*  56 */         Object savePoint = status.createSavepoint();
/*  57 */         ProjectListingServiceResult result = new ProjectListingServiceResult();
/*     */         try {
/*  59 */           result = RemoteProjectListingServiceImpl.this.projectListingService.addProjectListing(project);
/*  60 */           for (ProjectMetas projectMetas : metasList) {
/*  61 */             projectMetas.setProjectId(Long.valueOf(result.getProjectListingDTO().getId().longValue()));
/*     */ 
/*  63 */             projectMetas.setOperator(project.getUserAccount());
/*     */           }
/*  65 */           RemoteProjectListingServiceImpl.this.projectMetasService.insert(metasList);
/*     */         }
/*     */         catch (Exception e) {
/*  68 */           e.printStackTrace();
/*  69 */           RemoteProjectListingServiceImpl.this.log.debug(e.getMessage());
/*  70 */           status.rollbackToSavepoint(savePoint);
/*     */ 
/*  75 */           return result;
/*     */         }
/*  77 */         return result;
/*     */       }
/*     */     });
/*  80 */     return addResult;
/*     */   }
/*     */ 
/*     */   public ProjectAuditLogServiceResult audit(ProjectAuditLogRequest projectAuditLogRequest)
/*     */   {
/*  90 */     this.log.debug("RemoteProjectListingServiceImpl audit a projectListing");
/*  91 */     ProjectAuditLogServiceResult result = new ProjectAuditLogServiceResult();
/*  92 */     ProjectAuditLog projectAuditLog = ConvertUtils.convertRequest2ProjectAuditLog(projectAuditLogRequest);
/*     */ 
/*  94 */     ProjectListing projectListing = ConvertUtils.convertRequest2ProjectListing(projectAuditLogRequest);
/*     */ 
/*  96 */     projectAuditLog.setProjectId(projectListing.getId());
/*  97 */     result = this.projectListingService.auditProjectListing(projectAuditLog, projectListing);
/*  98 */     return result;
/*     */   }
/*     */ 
/*     */   public ProjectListingServiceResult updateProjectListing(ProjectListingRequest projectListingRequest)
/*     */   {
/* 109 */     this.log.debug("RemoteProjectListingServiceImpl update a projectListing");
/* 110 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/* 111 */     ProjectListing projectListing = ConvertUtils.convertRequest2ProjectListing(projectListingRequest);
/*     */ 
/* 113 */     List metas = new ArrayList();
/* 114 */     if ((projectListingRequest.getProjectMetasDTOList() != null) && (projectListingRequest.getProjectMetasDTOList().size() > 0))
/*     */     {
/* 116 */       for (ProjectMetasDTO metaDTO : projectListingRequest.getProjectMetasDTOList()) {
/* 117 */         ProjectMetas meta = ConvertUtils.convertRequest2Metas(metaDTO);
/* 118 */         metas.add(meta);
/*     */       }
/*     */     }
/* 121 */     result = this.projectListingService.updateProjectListing(projectListing, metas);
/* 122 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult suspension(AnnouncementRequest request)
/*     */   {
/* 132 */     this.log.debug("RemoteProjectListingServiceImpl suspension a projectListing");
/* 133 */     ServiceResult result = new ServiceResult();
/* 134 */     result = this.projectListingService.suspension(ConvertUtils.convert2Announcement(request.getAnnouncementDTO()));
/*     */ 
/* 136 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult resumption(AnnouncementRequest request)
/*     */   {
/* 146 */     this.log.debug("RemoteProjectListingServiceImpl resumption a projectListing");
/* 147 */     ServiceResult result = new ServiceResult();
/* 148 */     result = this.projectListingService.resumption(ConvertUtils.convert2Announcement(request.getAnnouncementDTO()));
/*     */ 
/* 150 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult withdrawal(AnnouncementRequest request)
/*     */   {
/* 160 */     this.log.debug("RemoteProjectListingServiceImpl withdrawal a projectListing");
/* 161 */     ServiceResult result = new ServiceResult();
/* 162 */     result = this.projectListingService.withdrawal(ConvertUtils.convert2Announcement(request.getAnnouncementDTO()), false);
/*     */ 
/* 164 */     return result;
/*     */   }
/*     */ 
/*     */   public ProjectListingServiceResult updateProjectListingStatusById(ProjectListingRequest request)
/*     */   {
/* 174 */     this.log.debug("RemoteProjectListingServiceImpl updateProjectListingStatusById a projectListing");
/*     */ 
/* 176 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/* 177 */     ProjectListing projectListing = new ProjectListing();
/* 178 */     projectListing = ConvertUtils.convertProjectListingDTO2ProjectListing(request.getProjectListingDTO());
/*     */ 
/* 180 */     result = this.projectListingService.updateProjectListing(projectListing);
/* 181 */     return result;
/*     */   }
/*     */ 
/*     */   public ProjectListingServiceResult searchProjects() {
/* 185 */     return null;
/*     */   }
/*     */ 
/*     */   public ProjectListingServiceResult rollbackTradeClearProject(ProjectListingRequest request)
/*     */   {
/* 196 */     return null;
/*     */   }
/*     */ 
/*     */   public ProjectListingServiceResult tradeClearProject(ProjectListingRequest request)
/*     */   {
/* 206 */     ProjectListingServiceResult projectServiceResult = new ProjectListingServiceResult();
/* 207 */     ProjectListing projectListing = new ProjectListing();
/* 208 */     projectListing = ConvertUtils.convertProjectListingDTO2ProjectListing(request.getProjectListingDTO());
/*     */ 
/* 210 */     projectServiceResult = this.projectListingService.tradeClearProject(projectListing);
/* 211 */     return projectServiceResult;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteProjectListingServiceImpl
 * JD-Core Version:    0.6.0
 */