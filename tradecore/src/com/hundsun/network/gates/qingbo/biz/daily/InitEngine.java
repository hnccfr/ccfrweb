/*     */ package com.hundsun.network.gates.qingbo.biz.daily;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.result.ProjectBaseTradeServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectService;
/*     */ import com.hundsun.network.gates.qingbo.biz.GlobalMemoryDB;
/*     */ import com.hundsun.network.gates.qingbo.biz.GlobalMemoryQueryEngine;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository
/*     */ public class InitEngine extends GlobalMemoryDB
/*     */ {
/*  20 */   private static final Logger log = Logger.getLogger(InitEngine.class);
/*     */   private static RemoteProjectService remoteProjectService;
/*     */ 
/*     */   public RemoteProjectService getRemoteProjectService()
/*     */   {
/*  50 */     return remoteProjectService;
/*     */   }
/*     */ 
/*     */   public void setRemoteProjectService(RemoteProjectService remoteProjectService)
/*     */   {
/*  55 */     remoteProjectService = remoteProjectService;
/*     */   }
/*     */ 
/*     */   public static void init()
/*     */   {
/*  70 */     System.gc();
/*     */ 
/*  72 */     loadGoldModel();
/*     */ 
/*  76 */     GlobalMemoryQueryEngine.buildIndex();
/*     */   }
/*     */ 
/*     */   public static void restart()
/*     */   {
/*  85 */     init();
/*     */   }
/*     */ 
/*     */   public static void endDayWork()
/*     */   {
/*     */   }
/*     */ 
/*     */   private static void loadGoldModel()
/*     */   {
/*     */     try
/*     */     {
/* 173 */       ProjectServiceResult pResultService = remoteProjectService.getAllProjects();
/* 174 */       if (null != pResultService)
/* 175 */         GlobalMemoryDB.projectList = pResultService.getProjectDTOList();
/*     */       else {
/* 177 */         log.error(" remoteProjectService.getAllProjects() return null;");
/*     */       }
/*     */ 
/* 181 */       ProjectBaseTradeServiceResult pbtResult = new ProjectBaseTradeServiceResult();
/* 182 */       pbtResult = remoteProjectService.getAllProjectBaseTrade();
/* 183 */       if (null != pbtResult)
/* 184 */         GlobalMemoryDB.baseTradeList = pbtResult.getBaseTradeDTOList();
/*     */       else {
/* 186 */         log.error(" get baseTradeList faild  baseTradeList is null;");
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 208 */       log.error(e.getMessage(), e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static void loadAluminumModel()
/*     */   {
/*     */   }
/*     */ 
/*     */   private static void initDailyWork()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.daily.InitEngine
 * JD-Core Version:    0.6.0
 */