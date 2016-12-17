/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.job;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.wulin.biz.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.job.ProjectAutoService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.melody.common.util.DateUtil;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.MessageSource;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("projectAutoService")
/*     */ public class ProjectAutoServiceImpl extends BaseService
/*     */   implements ProjectAutoService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   @Autowired
/*     */   private MessageSource messageSource;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   public ServiceResult autoProjectValidate()
/*     */   {
/*  35 */     ServiceResult result = new ServiceResult();
/*  36 */     this.log.debug("<---------------quartz autoProjectValidate start ------------------->");
/*     */     try
/*     */     {
/*  39 */       result = dealOverTimeProject();
/*  40 */       if (result.error())
/*  41 */         this.log.error("deal order remind option fail:" + result.getErrorInfo());
/*     */       else
/*  43 */         this.log.info("deal order remind optoin success");
/*     */     }
/*     */     catch (Exception e) {
/*  46 */       this.log.error("deal order remind option error", e);
/*     */     }
/*  48 */     return result;
/*     */   }
/*     */ 
/*     */   private ServiceResult dealOverTimeProject()
/*     */   {
/*  56 */     ServiceResult result = new ServiceResult();
/*  57 */     this.log.debug("<---------------quartz dealOverTimeProject start ------------------->");
/*     */     try
/*     */     {
/*  60 */       ProjectListing projectListing = new ProjectListing();
/*  61 */       projectListing.setStatus(EnumProjectStatus.TRADE.getValue());
/*  62 */       StringBuffer errorInfo = new StringBuffer();
/*  63 */       List<ProjectListing> list = this.projectListingDAO.selectProjectListingByObj(projectListing);
/*  64 */       for (ProjectListing projectObj : list) {
/*  65 */         if ((projectObj == null) || (projectObj.getListingEndTime() == null) || (EnumTradingType.BID_ORDER.getValue().equals(projectObj.getTradingType())))
/*     */         {
/*     */           continue;
/*     */         }
/*  69 */         if (projectObj.getListingEndTime().before(DateUtil.getToday().getTime())) {
/*  70 */           Announcement announcement = new Announcement();
/*  71 */           announcement.setProjectId(projectObj.getId());
/*  72 */           announcement.setStatus(EnumAnnouncementStatus.NORMAL.getValue());
/*  73 */           announcement.setTitle(getMessage("project.auto.option.remind.withdraw.title", new String[0]));
/*  74 */           announcement.setContent(getMessage("project.auto.option.remind.withdraw.content", new String[] { projectObj.getCode() }));
/*     */ 
/*  76 */           announcement.setType(EnumAnnouncementType.SYSTEM.getValue());
/*  77 */           announcement.setCreator(EnumOperatorType.SYSTEM.getValue());
/*  78 */           announcement.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/*  79 */           announcement.setOperator(EnumOperatorType.SYSTEM.getValue());
/*  80 */           announcement.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/*  81 */           result = this.projectListingService.withdrawal(announcement, true);
/*  82 */           if (!result.correct()) {
/*  83 */             errorInfo.append("=项目编号为：" + projectObj.getCode() + " 项目名称：" + projectObj.getTitle() + " 自动撤牌出现错误：" + result.getErrorInfo() + "||");
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  91 */       result.setErrorInfo(errorInfo.toString());
/*     */     }
/*     */     catch (Exception e) {
/*  94 */       this.log.error("deal Over Time Project  error", e);
/*     */     }
/*  96 */     this.log.debug("<---------------quartz dealOverTimeProject  end  ------------------->");
/*  97 */     return result;
/*     */   }
/*     */ 
/*     */   protected String getMessage(String code, String[] args)
/*     */   {
/* 108 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.job.ProjectAutoServiceImpl
 * JD-Core Version:    0.6.0
 */