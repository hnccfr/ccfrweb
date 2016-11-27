/*    */ package com.hundsun.network.gates.qingbo.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.PlaceOrderTradeDTO;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.enums.EnumTradeResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
import com.hundsun.network.gates.qingbo.biz.GlobalMemoryQueryEngine;
/*    */ import com.hundsun.network.gates.qingbo.biz.GlobalMemoryQueryEngine.ProjectQuery;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.cash.TradeCashDTO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.project.ProjectListingService;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.project.ProjectService;
/*    */ import com.hundsun.network.gates.qingbo.biz.util.ConvertUtils;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("projectService")
/*    */ public class ProjectServiceImpl extends BaseService
/*    */   implements ProjectService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectListingService projectListingService;
/*    */ 
/*    */   public ProjectListingServiceResult rollbackTradeClearProject(PlaceOrderTradeDTO placeOrderTradeDTO)
/*    */   {
/* 45 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/*    */ 
/* 50 */     return result;
/*    */   }
/*    */ 
/*    */   public ProjectListingServiceResult tradeClearProject(PlaceOrderTradeDTO placeOrderTradeDTO)
/*    */     throws Exception
/*    */   {
/* 61 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/* 62 */     ProjectListing projectListing = ConvertUtils.converntPlaceOrderTradeDTO2ProjectListing(placeOrderTradeDTO);
/*    */ 
/* 64 */     result = this.projectListingService.tradeClearProject(projectListing);
/* 65 */     if (result == null) {
/* 66 */       result = new ProjectListingServiceResult();
/* 67 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeResultErrors.REMOTE_PROJECT_CALL_ERROR.getValue()), EnumTradeResultErrors.REMOTE_PROJECT_CALL_ERROR.getInfo());
/*    */ 
/* 69 */       throw new ServiceException(EnumTradeResultErrors.REMOTE_PROJECT_CALL_ERROR.getInfo(), Integer.valueOf(EnumTradeResultErrors.REMOTE_PROJECT_CALL_ERROR.getValue()));
/*    */     }
/*    */ 
/* 72 */     return result;
/*    */   }
/*    */ 
/*    */   public ServiceResult tradeClearCash(TradeCashDTO tradeCashDTO)
/*    */   {
/* 82 */     return null;
/*    */   }
/*    */ 
/*    */   public String getProjectTradeStatusByCode(String projectCode)
/*    */   {
/* 92 */     String projectTradeStatus = GlobalMemoryQueryEngine.ProjectQuery.getTradeStatusByCode(projectCode);
/*    */ 
/* 94 */     return projectTradeStatus;
/*    */   }
/*    */ 
/*    */   public ProjectListing getProjectListingByCode(String projectCode) throws Exception
/*    */   {
/* 99 */     return this.projectListingService.getProjectListingByCode(projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.pojo.project.ProjectServiceImpl
 * JD-Core Version:    0.6.0
 */