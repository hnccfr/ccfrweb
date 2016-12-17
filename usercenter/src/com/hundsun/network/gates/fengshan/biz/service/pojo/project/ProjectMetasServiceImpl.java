/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectListingDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectMetasDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectMetasService;
/*    */ import com.hundsun.network.gates.fengshan.web.util.ConvertUtils;
/*    */ import com.hundsun.network.gates.fengshan.web.util.ProjectCopyUtil;
/*    */ import com.hundsun.network.gates.luosi.biz.domain.PackageTradeData;
/*    */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("projectMetasService")
/*    */ public class ProjectMetasServiceImpl
/*    */   implements ProjectMetasService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectMetasDAO projectMetasDAO;
/*    */ 
/*    */   @Autowired
/*    */   private ProjectListingDAO projectListingDAO;
/*    */ 
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */ 
/*    */   public void insert(ProjectMetas record) {
/* 32 */     this.projectMetasDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(ProjectMetas record) {
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(ProjectMetas record) {
/* 39 */     return 0;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectMetas record) {
/* 43 */     return 0;
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> getMetasByProjectId(Long projectId)
/*    */   {
/* 48 */     return this.projectMetasDAO.selectByProjectId(projectId);
/*    */   }
/*    */ 
/*    */   public String getMetaValue(ProjectMetas projectMetas)
/*    */   {
/* 53 */     return this.projectMetasDAO.selectMetaValue(projectMetas);
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> getMetasByProjectIdAndMetaGroup(Long projectId, String metaGroup)
/*    */   {
/* 58 */     return this.projectMetasDAO.getMetasByProjectIdAndMetaGroup(projectId, metaGroup);
/*    */   }
/*    */ 
/*    */   public List<TradeShowDTO> getMetasByProjectListing(ProjectListing projectListing)
/*    */   {
/* 68 */     ProjectListingDTO projectListingDTO = ConvertUtils.convertProjectListing2ProjectListingDTO(projectListing);
/*    */ 
/* 70 */     List list = PackageTradeData.getPlaceOrderShowDTO(projectListingDTO);
/* 71 */     return list;
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> getAllProjectMetasByProjectId(Long projectListingId)
/*    */   {
/* 81 */     ProjectListing projectListing = this.projectListingDAO.selectByPrimaryKey(projectListingId);
/* 82 */     return getAllProjectMetasByrojectListing(projectListing);
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> getAllProjectMetasByrojectListing(ProjectListing projectListing)
/*    */   {
/* 92 */     List projectMetasList = getMetasByProjectId(projectListing.getId());
/* 93 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 94 */       ProjectCopyUtil.copyProjectListing2ProjectMetasList(projectListing, projectMetasList);
/*    */     }
/* 96 */     return projectMetasList;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.project.ProjectMetasServiceImpl
 * JD-Core Version:    0.6.0
 */