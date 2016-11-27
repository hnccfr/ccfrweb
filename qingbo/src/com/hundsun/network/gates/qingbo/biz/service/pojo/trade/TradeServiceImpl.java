/*    */ package com.hundsun.network.gates.qingbo.biz.service.pojo.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.UserAccountDTO;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.enums.EnumTradeResultErrors;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.request.TradeProjectAvailableCheckRequest;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.request.TradeUserAvailableCheckRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.project.ProjectListingDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.user.UserRolePermissionDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.trade.TradeService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tradeService")
/*    */ public class TradeServiceImpl extends BaseService
/*    */   implements TradeService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectListingDAO projectListingDAO;
/*    */ 
/*    */   @Autowired
/*    */   private UserRolePermissionDAO userRolePermissionDAO;
/*    */ 
/*    */   public ServiceResult checkProjectAvailable(TradeProjectAvailableCheckRequest request)
/*    */   {
/* 28 */     ServiceResult result = new ServiceResult();
/* 29 */     if (null == request.getProjectListingDTO()) {
/* 30 */       result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.PARAMETER_ERROR.getValue()));
/* 31 */       result.setErrorInfo(EnumTradeResultErrors.PARAMETER_ERROR.getInfo());
/* 32 */       return result;
/*    */     }
/*    */     try {
/* 35 */       ProjectListing projectListing = this.projectListingDAO.selectByPrimaryKey(request.getProjectListingDTO().getId());
/*    */ 
/* 37 */       if (null == projectListing) {
/* 38 */         result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.PROJECT_EXIST_ERROR.getValue()));
/* 39 */         result.setErrorInfo(EnumTradeResultErrors.PROJECT_EXIST_ERROR.getInfo());
/* 40 */         return result;
/*    */       }
/* 42 */       if (!projectListing.getStatus().equals(EnumProjectStatus.TRADE.getValue())) {
/* 43 */         result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.PROJECT_AVAILABLE_ERROR.getValue()));
/* 44 */         result.setErrorInfo(EnumTradeResultErrors.PROJECT_AVAILABLE_ERROR.getInfo());
/* 45 */         return result;
/*    */       }
/*    */     } catch (Exception e) {
/* 48 */       e.printStackTrace();
/* 49 */       result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.INTERNAL_ERROR.getValue()));
/* 50 */       result.setErrorInfo(EnumTradeResultErrors.INTERNAL_ERROR.getInfo());
/* 51 */       return result;
/*    */     }
/* 53 */     return result;
/*    */   }
/*    */ 
/*    */   public ServiceResult checkUserAvailable(TradeUserAvailableCheckRequest request)
/*    */   {
/* 58 */     ServiceResult result = new ServiceResult();
/* 59 */     if ((null == request.getUserAccountDTO()) || (null == request.getPermissionId())) {
/* 60 */       result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.PARAMETER_ERROR.getValue()));
/* 61 */       result.setErrorInfo(EnumTradeResultErrors.PARAMETER_ERROR.getInfo());
/* 62 */       return result;
/*    */     }
/*    */     try
/*    */     {
/* 66 */       List permissions = this.userRolePermissionDAO.getUserPermissions(request.getUserAccountDTO().getId());
/*    */ 
/* 68 */       if ((null == permissions) || (!permissions.contains(Integer.valueOf(request.getPermissionId().toString()))))
/*    */       {
/* 70 */         result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.USER_PERMISSION_ERROE.getValue()));
/* 71 */         result.setErrorInfo(EnumTradeResultErrors.USER_PERMISSION_ERROE.getInfo());
/* 72 */         return result;
/*    */       }
/*    */     } catch (Exception e) {
/* 75 */       e.printStackTrace();
/* 76 */       result.setErrorNO(Integer.valueOf(EnumTradeResultErrors.INTERNAL_ERROR.getValue()));
/* 77 */       result.setErrorInfo(EnumTradeResultErrors.INTERNAL_ERROR.getInfo());
/* 78 */       return result;
/*    */     }
/* 80 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.pojo.trade.TradeServiceImpl
 * JD-Core Version:    0.6.0
 */