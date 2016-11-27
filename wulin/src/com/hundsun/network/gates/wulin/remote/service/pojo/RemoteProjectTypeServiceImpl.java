/*    */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeAttriDTO;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeDTO;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumProjectErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectTypeRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectTypeAttriServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectTypeServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectTypeService;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectType;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectTypeAttri;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectTypeService;
/*    */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("remoteProjectTypeService")
/*    */ public class RemoteProjectTypeServiceImpl extends BaseService
/*    */   implements RemoteProjectTypeService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private ProjectTypeService projectTypeService;
/*    */ 
/*    */   public ProjectTypeServiceResult getProjectTypeByCode(ProjectTypeRequest request)
/*    */   {
/* 42 */     ProjectTypeServiceResult result = new ProjectTypeServiceResult();
/*    */     try {
/* 44 */       if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/* 45 */         result.setErrorNO(Integer.valueOf(EnumProjectErrors.PARAMETER_ERROR.getValue()));
/* 46 */         result.setErrorInfo(EnumProjectErrors.PARAMETER_ERROR.getInfo());
/* 47 */         this.log.error("getProjectTypeByCode fail, " + result.getErrorInfo());
/* 48 */         return result;
/*    */       }
/* 50 */       List list = this.projectTypeService.getProjectByCode(request);
/* 51 */       if (null != list) {
/* 52 */         List dtoList = new ArrayList();
/* 53 */         Iterator iterator = list.iterator();
/* 54 */         while (iterator.hasNext()) {
/* 55 */           ProjectTypeDTO dto = ConvertUtils.convert((ProjectType)iterator.next());
/* 56 */           dtoList.add(dto);
/*    */         }
/* 58 */         result.setData(dtoList);
/*    */       } else {
/* 60 */         result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/* 61 */         result.setErrorInfo(EnumProjectErrors.INTERNAL_ERROR.getInfo());
/*    */       }
/*    */     }
/*    */     catch (Exception e) {
/* 65 */       e.printStackTrace();
/* 66 */       this.log.error("getProjectTypeByCode fail code:" + request.getProjectCode(), e);
/* 67 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/* 68 */       result.setErrorInfo(EnumProjectErrors.INTERNAL_ERROR.getInfo());
/*    */     }
/* 70 */     return result;
/*    */   }
/*    */ 
/*    */   public ProjectTypeAttriServiceResult getProjectTypeAttriByCode(ProjectTypeRequest request)
/*    */   {
/* 76 */     ProjectTypeAttriServiceResult result = new ProjectTypeAttriServiceResult();
/*    */     try {
/* 78 */       if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/* 79 */         result.setErrorNO(Integer.valueOf(EnumProjectErrors.PARAMETER_ERROR.getValue()));
/* 80 */         result.setErrorInfo(EnumProjectErrors.PARAMETER_ERROR.getInfo());
/* 81 */         this.log.error("getProjectTypeByCode fail, " + result.getErrorInfo());
/* 82 */         return result;
/*    */       }
/* 84 */       List list = this.projectTypeService.getProjectAttriListByQuery(request.getProjectCode());
/* 85 */       List dtoList = new ArrayList();
/*    */       Iterator iterator;
/* 86 */       if (null != list) {
/* 87 */         for (iterator = list.iterator(); iterator.hasNext(); ) {
/* 88 */           ProjectTypeAttriDTO dto = ConvertUtils.convert((ProjectTypeAttri)iterator.next());
/* 89 */           dtoList.add(dto);
/*    */         }
/*    */       }
/* 92 */       result.setData(dtoList);
/*    */     } catch (Exception e) {
/* 94 */       e.printStackTrace();
/* 95 */       this.log.error("getProjectTypeByCode fail code:" + request.getProjectCode(), e);
/* 96 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/* 97 */       result.setErrorInfo(EnumProjectErrors.INTERNAL_ERROR.getInfo());
/*    */     }
/* 99 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteProjectTypeServiceImpl
 * JD-Core Version:    0.6.0
 */