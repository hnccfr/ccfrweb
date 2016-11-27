/*    */ package com.hundsun.network.gates.qingbo.biz.domain.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectMetasDTO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.BaseDomain;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class project extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = 141438549337759004L;
/*    */   private ProjectListing projectListing;
/* 31 */   private List<ProjectMetasDTO> projMetasList = new ArrayList();
/*    */   private String tradingStatus;
/*    */ 
/*    */   public ProjectListing getProjectListing()
/*    */   {
/* 38 */     return this.projectListing;
/*    */   }
/*    */ 
/*    */   public void setProjectListing(ProjectListing projectListing) {
/* 42 */     this.projectListing = projectListing;
/*    */   }
/*    */ 
/*    */   public List<ProjectMetasDTO> getProjMetasList() {
/* 46 */     return this.projMetasList;
/*    */   }
/*    */ 
/*    */   public void setProjMetasList(List<ProjectMetasDTO> projMetasList) {
/* 50 */     this.projMetasList = projMetasList;
/*    */   }
/*    */ 
/*    */   public String getTradingStatus() {
/* 54 */     return this.tradingStatus;
/*    */   }
/*    */ 
/*    */   public void setTradingStatus(String tradingStatus) {
/* 58 */     this.tradingStatus = tradingStatus;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.project.project
 * JD-Core Version:    0.6.0
 */