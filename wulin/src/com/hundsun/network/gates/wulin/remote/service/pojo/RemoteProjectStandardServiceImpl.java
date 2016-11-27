/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectStandardDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumProjectErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectStandardRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectStandardServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectStandardService;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectStandard;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectStandardService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteProjectStandardService")
/*     */ public class RemoteProjectStandardServiceImpl extends BaseService
/*     */   implements RemoteProjectStandardService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectStandardService standardService;
/*     */ 
/*     */   public ProjectStandardServiceResult getStandardByProTypeCode(ProjectStandardRequest request)
/*     */   {
/*  39 */     ProjectStandardServiceResult result = new ProjectStandardServiceResult();
/*     */     try {
/*  41 */       if ((null == request) || (StringUtil.isEmpty(request.getProTypeCode()))) {
/*  42 */         result.setErrorNO(Integer.valueOf(EnumProjectErrors.PARAMETER_ERROR.getValue()));
/*  43 */         result.setErrorInfo(EnumProjectErrors.PARAMETER_ERROR.getInfo());
/*  44 */         this.log.error("getStandardByProTypeCode fail, " + result.getErrorInfo());
/*  45 */         return result;
/*     */       }
/*  47 */       List list = this.standardService.selectListByProTypeCode(request.getProTypeCode());
/*  48 */       if (null != list) {
/*  49 */         List dtoList = new ArrayList();
/*  50 */         Iterator iterator = list.iterator();
/*  51 */         while (iterator.hasNext()) {
/*  52 */           ProjectStandardDTO dto = new ProjectStandardDTO();
/*  53 */           BeanUtils.copyProperties(dto, iterator.next());
/*  54 */           dtoList.add(dto);
/*     */         }
/*  56 */         result.setData(dtoList);
/*     */       } else {
/*  58 */         result.setErrorNO(Integer.valueOf(EnumProjectErrors.PARAMETER_ERROR.getValue()));
/*  59 */         result.setErrorInfo(EnumProjectErrors.PARAMETER_ERROR.getInfo());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  63 */       e.printStackTrace();
/*  64 */       this.log.error("getStandardByProTypeCode fail code:" + request.getProTypeCode(), e);
/*  65 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/*  66 */       result.setErrorInfo(EnumProjectErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/*     */ 
/*  69 */     return result;
/*     */   }
/*     */ 
/*     */   public ProjectStandardServiceResult getStandardById(ProjectStandardRequest request)
/*     */   {
/*  80 */     ProjectStandardServiceResult result = new ProjectStandardServiceResult();
/*     */     try {
/*  82 */       if ((null == request) || (request.getSid() == null)) {
/*  83 */         result.setErrorNO(Integer.valueOf(EnumProjectErrors.PARAMETER_ERROR.getValue()));
/*  84 */         result.setErrorInfo(EnumProjectErrors.PARAMETER_ERROR.getInfo());
/*  85 */         this.log.error("getStandardById fail, " + result.getErrorInfo());
/*  86 */         return result;
/*     */       }
/*  88 */       ProjectStandard standard = this.standardService.getStandardById(request.getSid());
/*     */ 
/*  90 */       if (null != standard) {
/*  91 */         List dtoList = new ArrayList();
/*  92 */         ProjectStandardDTO dto = new ProjectStandardDTO();
/*  93 */         BeanUtils.copyProperties(dto, standard);
/*  94 */         dtoList.add(dto);
/*  95 */         result.setData(dtoList);
/*     */       } else {
/*  97 */         result.setErrorNO(Integer.valueOf(EnumProjectErrors.PARAMETER_ERROR.getValue()));
/*  98 */         result.setErrorInfo(EnumProjectErrors.PARAMETER_ERROR.getInfo());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/* 102 */       e.printStackTrace();
/* 103 */       this.log.error("getStandardById fail code:" + request.getProTypeCode(), e);
/* 104 */       result.setErrorNO(Integer.valueOf(EnumProjectErrors.INTERNAL_ERROR.getValue()));
/* 105 */       result.setErrorInfo(EnumProjectErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/* 107 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteProjectStandardServiceImpl
 * JD-Core Version:    0.6.0
 */