/*     */ package com.hundsun.network.gates.qingbo.biz.validator;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectTradeStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.project.ProjectService;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("commonValidate")
/*     */ public class CommonValidate
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectService projectService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   public String tradePublicValidate(String projectCode)
/*     */   {
/*  44 */     String backStr = "";
/*     */ 
/*  47 */     backStr = validateMarket();
/*  48 */     if (!"pass".equals(backStr)) {
/*  49 */       return backStr;
/*     */     }
/*  51 */     backStr = validateProjectStauts(projectCode);
/*     */ 
/*  53 */     if (!"pass".equals(backStr)) {
/*  54 */       return backStr;
/*     */     }
/*  56 */     return backStr;
/*     */   }
/*     */ 
/*     */   private String validateMarket()
/*     */   {
/*  64 */     SystemDictRequest request = new SystemDictRequest();
/*  65 */     request.setParaCode(EnumSystemDictKey.MARKET_STATUS.getValue());
/*  66 */     SystemDictServiceResult result = this.remoteSystemBaseService.selectSingleByKey(request);
/*  67 */     if ("Y".equals(result.getSystemDictDTO().getParaValue())) {
/*  68 */       return "pass";
/*     */     }
/*  70 */     return "disconnect";
/*     */   }
/*     */ 
/*     */   private String validateProjectStauts(String projectCode)
/*     */   {
/*  79 */     String projectTradeStatus = this.projectService.getProjectTradeStatusByCode(projectCode);
/*  80 */     if (EnumProjectTradeStatus.NORMAL.getValue().equals(projectTradeStatus)) {
/*  81 */       return "pass";
/*     */     }
/*  83 */     return "trading";
/*     */   }
/*     */ 
/*     */   public OrderServiceResult validateData(BaseTradeDTO baseTradeDTO)
/*     */   {
/*  93 */     OrderServiceResult result = new OrderServiceResult();
/*     */ 
/* 100 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.validator.CommonValidate
 * JD-Core Version:    0.6.0
 */