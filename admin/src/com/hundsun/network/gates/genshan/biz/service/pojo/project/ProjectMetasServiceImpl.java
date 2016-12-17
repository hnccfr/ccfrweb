/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectListingDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectMetasDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectMetasService;
/*    */ import com.hundsun.network.gates.genshan.web.util.ConvertUtils;
/*    */ import com.hundsun.network.gates.genshan.web.util.ProjectCopyUtil;
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
/*    */   public List<ProjectMetas> getMetasByProjectIdAndMetaGroup(Long projectId, String metaGroup)
/*    */   {
/* 53 */     return this.projectMetasDAO.getMetasByProjectIdAndMetaGroup(projectId, metaGroup);
/*    */   }
/*    */ 
/*    */   public List<TradeShowDTO> getMetasByProjectListing(ProjectListing projectListing)
/*    */   {
/* 63 */     ProjectListingDTO projectListingDTO = ConvertUtils.convertProjectListing2ProjectListingDTO(projectListing);
/*    */ 
/* 65 */     List list = PackageTradeData.getPlaceOrderShowDTO(projectListingDTO);
/* 66 */     return list;
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> getAllProjectMetasByProjectId(Long projectListingId)
/*    */   {
/* 76 */     ProjectListing projectListing = this.projectListingDAO.selectByPrimaryKey(projectListingId);
/* 77 */     return getAllProjectMetasByrojectListing(projectListing);
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> getAllProjectMetasByrojectListing(ProjectListing projectListing)
/*    */   {
/* 87 */     List projectMetasList = getMetasByProjectId(projectListing.getId());
/* 88 */     if ((projectMetasList != null) && 
/* 89 */       (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType()))) {
/* 90 */       ProjectCopyUtil.copyProjectListing2ProjectMetasList(projectListing, projectMetasList);
/*    */     }
/*    */ 
/* 93 */     return projectMetasList;
/*    */   }
/*    */ 
/*    */   public String getOneMetaValue(ProjectMetas projectMetas)
/*    */   {
/* 98 */     return this.projectMetasDAO.selectOneMetaValue(projectMetas);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.project.ProjectMetasServiceImpl
 * JD-Core Version:    0.6.0
 */