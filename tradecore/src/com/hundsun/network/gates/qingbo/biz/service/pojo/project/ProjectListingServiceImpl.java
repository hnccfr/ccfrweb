/*     */ package com.hundsun.network.gates.qingbo.biz.service.pojo.project;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.enums.EnumTradeResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumProjectListingResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.qingbo.biz.util.ConvertUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("projectListingService")
/*     */ public class ProjectListingServiceImpl extends BaseService
/*     */   implements ProjectListingService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   public ProjectListingServiceResult addProjectListing(ProjectListing projectListing)
/*     */     throws Exception
/*     */   {
/*  44 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/*  45 */     if (null == projectListing) {
/*  46 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.PARAMETER_ERROR.getValue()));
/*  47 */       result.setErrorInfo(EnumProjectListingResultErrors.PARAMETER_ERROR.getInfo());
/*  48 */       this.log.error("add projectListing fail, " + result.getErrorInfo());
/*  49 */       throw new ServiceException();
/*     */     }
/*  51 */     String projectId = this.projectListingDAO.addProjectListing(projectListing);
/*  52 */     projectListing.setId(Long.valueOf(projectId));
/*  53 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*  54 */     projectListingDTO = ConvertUtils.convertProjectListing2ProjectListingDTO(projectListing);
/*     */ 
/*  56 */     result.setProjectListingDTO(projectListingDTO);
/*  57 */     return result;
/*     */   }
/*     */ 
/*     */   private ServiceResult doWithdrawal(Long projectListingId, String operatorAccount)
/*     */   {
/*  69 */     final Long proId = projectListingId;
/*  70 */     final String operator = operatorAccount;
/*     */ 
/*  72 */     ServiceResult withdrawalResult = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public ServiceResult doInTransaction(TransactionStatus status) {
/*  75 */         ServiceResult result = new ServiceResult();
/*     */ 
/*  79 */         ProjectListing projectListing = ProjectListingServiceImpl.this.projectListingDAO.getProSimpInfo(proId);
/*     */ 
/*  81 */         projectListing.setStatus(EnumProjectStatus.WITHDRAWAL.getValue());
/*  82 */         projectListing.setOperator(operator);
/*  83 */         ProjectListingServiceImpl.this.projectListingDAO.updateStatusById(projectListing);
/*  84 */         return result;
/*     */       }
/*     */     });
/*  87 */     return withdrawalResult;
/*     */   }
/*     */ 
/*     */   public ProjectListingServiceResult tradeClearProject(ProjectListing projectListing)
/*     */   {
/*  97 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/*  98 */     ProjectListing projObjOld = this.projectListingDAO.selectByProjectCode(projectListing.getCode());
/*  99 */     Long remain = Long.valueOf(projObjOld.getQuantity().longValue() - projectListing.getQuantity().longValue());
/* 100 */     Long quantity = projectListing.getQuantity();
/* 101 */     projectListing.setId(null);
/* 102 */     projectListing.setTitle(null);
/* 103 */     projectListing.setQuantity(remain);
/* 104 */     if (remain.longValue() > 0L) {
/* 105 */       projectListing.setUserAccount(null);
/*     */ 
/* 107 */       Map paramMap = new HashMap();
/* 108 */       paramMap.put("code", projectListing.getCode());
/* 109 */       paramMap.put("quantity", remain);
/* 110 */       paramMap.put("quantityWhere", quantity);
/* 111 */       paramMap.put("statusWhere", projObjOld.getStatus());
/* 112 */       if (this.projectListingDAO.updateProjectListing(paramMap) <= 0) {
/* 113 */         result.setErrorInfo(EnumTradeResultErrors.ORDER_QUANTITY_ERROR.getInfo());
/* 114 */         result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.ORDER_QUANTITY_ERROR.getValue()));
/* 115 */         return result;
/*     */       }
/* 117 */       paramMap.clear();
/* 118 */       projObjOld.setQuantity(remain);
/* 119 */       ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*     */       try {
/* 121 */         projectListingDTO = ConvertUtils.convertProjectListing2ProjectListingDTO(projObjOld);
/*     */       }
/*     */       catch (Exception e) {
/* 124 */         this.log.error("wulin projetlisting对象转换 projectlistingDTO 出错", e);
/* 125 */         result.setErrorInfo("wulin projetlisting对象转换 projectlistingDTO 出错");
/*     */       }
/* 127 */       result.setProjectListingDTO(projectListingDTO);
/*     */     } else {
/* 129 */       Map paramMap = new HashMap();
/* 130 */       paramMap.put("code", projectListing.getCode());
/* 131 */       paramMap.put("quantity", Long.valueOf(0L));
/* 132 */       paramMap.put("status", EnumProjectStatus.OVER.getValue());
/* 133 */       paramMap.put("quantityWhere", quantity);
/* 134 */       paramMap.put("statusWhere", projObjOld.getStatus());
/* 135 */       if (this.projectListingDAO.updateProjectListing(paramMap) <= 0) {
/* 136 */         result.setErrorInfo(EnumTradeResultErrors.ORDER_QUANTITY_ERROR.getInfo());
/* 137 */         result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.ORDER_QUANTITY_ERROR.getValue()));
/* 138 */         return result;
/*     */       }
/* 140 */       paramMap.clear();
/*     */ 
/* 142 */       projObjOld.setQuantity(Long.valueOf(0L));
/* 143 */       projObjOld.setStatus(EnumProjectStatus.OVER.getValue());
/* 144 */       ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*     */       try {
/* 146 */         projectListingDTO = ConvertUtils.convertProjectListing2ProjectListingDTO(projObjOld);
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 150 */         this.log.error("wulin projetlisting对象转换 projectlistingDTO 出错", e);
/* 151 */         result.setErrorInfo("wulin projetlisting对象转换 projectlistingDTO 出错");
/*     */       }
/*     */ 
/* 155 */       result.setProjectListingDTO(projectListingDTO);
/*     */     }
/*     */ 
/* 158 */     return result;
/*     */   }
/*     */ 
/*     */   public ProjectListing getProjectListingByCode(String projectCode)
/*     */     throws SQLException
/*     */   {
/* 169 */     if ((null == projectCode) || (StringUtil.isEmpty(projectCode))) {
/* 170 */       return null;
/*     */     }
/* 172 */     return this.projectListingDAO.selectByProjectCode(projectCode);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.pojo.project.ProjectListingServiceImpl
 * JD-Core Version:    0.6.0
 */