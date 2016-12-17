/*     */ package com.hundsun.network.gates.qingbo.biz;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.PhaseDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectBaseDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectPoundageDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public final class GlobalMemoryQueryEngine extends GlobalMemoryDB
/*     */ {
/*  33 */   private static final Logger log = Logger.getLogger(GlobalMemoryQueryEngine.class);
/*     */   private static final int DEFAULT_INTERVAL = 30;
/*     */   private static final int DEFAULT_AMOUNT_RATE = 100;
/*     */   private static final long DEFAULT_UNIT_NUM = 1L;
/*     */   private static final long DEFAULT_PRICE_CHANGE = 1L;
/*  60 */   private static Map<String, Projects> projects = new HashMap();
/*     */ 
/*     */   public static String getGoodsPool()
/*     */   {
/*  72 */     return projects.toString();
/*     */   }
/*     */ 
/*     */   public static void buildIndex()
/*     */   {
/* 323 */     projects.clear();
/* 324 */     if (null != projectList)
/* 325 */       for (ProjectDTO projectDTO : projectList) {
/* 326 */         Projects projectsCodeInfo = (Projects)projects.get(projectDTO.projectBaseDTO.getProjectListingDTO().getCode());
/*     */ 
/* 328 */         if (null == projectsCodeInfo) {
/* 329 */           projectsCodeInfo = new Projects(projectDTO.projectBaseDTO.getProjectListingDTO().getCode());
/*     */ 
/* 331 */           projects.put(projectDTO.projectBaseDTO.getProjectListingDTO().getCode(), projectsCodeInfo);
/*     */         }
/*     */ 
/* 334 */         projectsCodeInfo.projectDTO = projectDTO;
/*     */       }
/*     */     else {
/* 337 */       log.warn("Property:projectList is null!");
/*     */     }
/*     */ 
/* 340 */     baseTrades.clear();
/* 341 */     if (null != baseTradeList)
/* 342 */       for (BaseTradeDTO baseTradeDTO : baseTradeList) {
/* 343 */         BaseTradeDTO baseTradeDTOInfo = (BaseTradeDTO)baseTrades.get(baseTradeDTO.getProjectCode());
/* 344 */         if (null == baseTradeDTOInfo) {
/* 345 */           baseTradeDTOInfo = new BaseTradeDTO();
/* 346 */           baseTrades.put(baseTradeDTO.getProjectCode(), baseTradeDTO);
/*     */         }
/* 348 */         if (!baseTradeDTOInfo.equals(baseTradeDTO)) {
/* 349 */           baseTrades.remove(baseTradeDTO.getProjectCode());
/* 350 */           baseTrades.put(baseTradeDTO.getProjectCode(), baseTradeDTO);
/*     */         }
/*     */       }
/*     */     else
/* 354 */       log.warn("baseTradeList is null!");
/*     */   }
/*     */ 
/*     */   public static class projectOperate
/*     */   {
/*     */     public void setProjectTrading(String projectCode)
/*     */     {
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class ProjectQuery
/*     */   {
/*     */     public static List<ProjectDTO> getMarketing()
/*     */     {
/* 607 */       List markingProjectList = new ArrayList();
/* 608 */       if (CollectionUtils.isEmpty(GlobalMemoryQueryEngine.projects.values())) {
/* 609 */         return null;
/*     */       }
/* 611 */       for (GlobalMemoryQueryEngine.Projects g : GlobalMemoryQueryEngine.projects.values()) {
/* 612 */         if (g != null) {
/* 613 */           ProjectDTO project = g.projectDTO;
/* 614 */           if ((project != null) && (project.getProjectBaseDTO() != null) && (project.getProjectBaseDTO().getProjectListingDTO().getStatus().equals(EnumProjectStatus.TRADE.getValue())))
/*     */           {
/* 618 */             markingProjectList.add(project);
/*     */           }
/*     */         }
/*     */       }
/* 622 */       return markingProjectList;
/*     */     }
/*     */ 
/*     */     public static String getNameByCode(String projectCode)
/*     */     {
/*     */       try
/*     */       {
/* 632 */         return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(projectCode)).projectDTO.projectBaseDTO.getProjectListingDTO().getTitle();
/*     */       }
/*     */       catch (Exception e) {
/* 635 */         GlobalMemoryQueryEngine.log.error("getNameByNo(projectCode:" + projectCode + ") error!", e);
/*     */       }
/* 637 */       return projectCode;
/*     */     }
/*     */ 
/*     */     public static ProjectDTO getProjectDTOByCode(String projectCode)
/*     */     {
/*     */       try
/*     */       {
/* 648 */         if (GlobalMemoryQueryEngine.projects.containsKey(projectCode)) {
/* 649 */           return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(projectCode)).projectDTO;
/*     */         }
/* 651 */         return null;
/*     */       } catch (Exception e) {
/* 653 */         GlobalMemoryQueryEngine.log.error("getProjectDTOByCode(projectCode:" + projectCode + ") error!", e);
/* 654 */       }return null;
/*     */     }
/*     */ 
/*     */     public static String getUserAccountByCode(String projectCode)
/*     */     {
/*     */       try
/*     */       {
/* 665 */         return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(projectCode)).projectDTO.projectBaseDTO.getProjectListingDTO().getUserAccount();
/*     */       }
/*     */       catch (Exception e) {
/* 668 */         GlobalMemoryQueryEngine.log.error("getUserAccountByCode(projectCode:" + projectCode + ") error!", e);
/* 669 */       }return projectCode;
/*     */     }
/*     */ 
/*     */     public static String getTradeStatusByCode(String projectCode)
/*     */     {
/*     */       try
/*     */       {
/* 680 */         return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(projectCode)).projectDTO.projectTradeDTO.getTradeStatus();
/*     */       } catch (Exception e) {
/* 682 */         GlobalMemoryQueryEngine.log.error("getTradeStatusByCode(projectCode:" + projectCode + ") error!", e);
/* 683 */       }return projectCode;
/*     */     }
/*     */ 
/*     */     public static boolean hasProjectInfoByProjectCode(String projectCode)
/*     */     {
/* 693 */       if ((projectCode == null) || (StringUtil.isEmpty(projectCode))) {
/* 694 */         return false;
/*     */       }
/* 696 */       return GlobalMemoryDB.baseTrades.containsKey(projectCode);
/*     */     }
/*     */ 
/*     */     public static BigDecimal getBailBuy(String goodsCode)
/*     */     {
/*     */       try
/*     */       {
/* 733 */         return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(goodsCode)).projectPoundageDTO.getBailBuyBigDecimal();
/*     */       } catch (Exception e) {
/* 735 */         GlobalMemoryQueryEngine.log.error("getNameByNo(goodsCode:" + goodsCode + ") error!", e);
/*     */       }
/* 737 */       return null;
/*     */     }
/*     */ 
/*     */     public static BigDecimal getBailSell(String goodsCode)
/*     */     {
/*     */       try
/*     */       {
/* 746 */         return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(goodsCode)).projectPoundageDTO.getBailSaleBigDecimal();
/*     */       } catch (Exception e) {
/* 748 */         GlobalMemoryQueryEngine.log.error("getNameByNo(goodsCode:" + goodsCode + ") error!", e);
/*     */       }
/* 750 */       return null;
/*     */     }
/*     */ 
/*     */     public static Integer getPoundageType(String goodsCode)
/*     */     {
/*     */       try
/*     */       {
/* 759 */         return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(goodsCode)).projectPoundageDTO.fashionPoundage;
/*     */       } catch (Exception e) {
/* 761 */         GlobalMemoryQueryEngine.log.error("getNameByNo(goodsCode:" + goodsCode + ") error!", e);
/*     */       }
/* 763 */       return null;
/*     */     }
/*     */ 
/*     */     public static BigDecimal getPoundageBuyRatio(String goodsCode)
/*     */     {
/*     */       try
/*     */       {
/* 772 */         return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(goodsCode)).projectPoundageDTO.getBuyNewBigDecimal();
/*     */       } catch (Exception e) {
/* 774 */         GlobalMemoryQueryEngine.log.error("getNameByNo(goodsCode:" + goodsCode + ") error!", e);
/*     */       }
/* 776 */       return null;
/*     */     }
/*     */ 
/*     */     public static BigDecimal getPoundageSellRatio(String goodsCode)
/*     */     {
/*     */       try
/*     */       {
/* 785 */         return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(goodsCode)).projectPoundageDTO.getSaleNewBigDecimal();
/*     */       } catch (Exception e) {
/* 787 */         GlobalMemoryQueryEngine.log.error("getNameByNo(goodsCode:" + goodsCode + ") error!", e);
/*     */       }
/* 789 */       return null;
/*     */     }
/*     */ 
/*     */     public static ProjectPoundageDTO getPoundage(String goodsCode)
/*     */     {
/*     */       try
/*     */       {
/* 801 */         return ((GlobalMemoryQueryEngine.Projects)GlobalMemoryQueryEngine.projects.get(goodsCode)).projectPoundageDTO;
/*     */       } catch (Exception e) {
/* 803 */         GlobalMemoryQueryEngine.log.error("getNameByNo(goodsCode:" + goodsCode + ") error!", e);
/*     */       }
/* 805 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class baseTradeQuery
/*     */   {
/*     */     public static String getTradeStatusByProjectCode(String projectCode)
/*     */     {
/* 586 */       if (null == projectCode) {
/* 587 */         return null;
/*     */       }
/* 589 */       BaseTradeDTO baseTradeDTO = (BaseTradeDTO)GlobalMemoryDB.baseTrades.get(projectCode);
/* 590 */       return baseTradeDTO == null ? null : baseTradeDTO.getTradeStatus();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class CommonQuery
/*     */   {
/*     */     public static int getInterval()
/*     */     {
/* 485 */       if (GlobalMemoryDB.time == null) {
/* 486 */         return 30;
/*     */       }
/* 488 */       return GlobalMemoryDB.time.intValue();
/*     */     }
/*     */ 
/*     */     public static Date getCurrentTradeDay()
/*     */     {
/* 497 */       return GlobalMemoryDB.currentDay;
/*     */     }
/*     */ 
/*     */     public static String getCurrentTradeDayStr() {
/* 501 */       return GlobalMemoryDB.currentDayStr;
/*     */     }
/*     */ 
/*     */     public static int getCurrentTradeDayInt()
/*     */     {
/* 506 */       int back = 0;
/* 507 */       back += (GlobalMemoryDB.currentDay.getYear() + 1900) * 10000;
/* 508 */       back += (GlobalMemoryDB.currentDay.getMonth() + 1) * 100;
/* 509 */       back += GlobalMemoryDB.currentDay.getDate();
/* 510 */       return back;
/*     */     }
/*     */ 
/*     */     public static Integer getMarketStatus()
/*     */     {
/* 517 */       return GlobalMemoryDB.marketStatus;
/*     */     }
/*     */ 
/*     */     public static Map<String, Long> getQuotationSeqs() {
/* 521 */       return GlobalMemoryDB.quotationSeqMap;
/*     */     }
/*     */ 
/*     */     public static List<PhaseDTO> getPahses() {
/* 525 */       return GlobalMemoryDB.phaseDTO;
/*     */     }
/*     */   }
/*     */ 
/*     */   protected static class Projects
/*     */   {
/*     */     private String projectCode;
/*     */     public ProjectDTO projectDTO;
/*     */     public ProjectTradeDTO projectTradeDTO;
/*     */     public ProjectPoundageDTO projectPoundageDTO;
/*     */     public Long settlementPriceSafe;
/*     */ 
/*     */     public Projects(String projectCode)
/*     */     {
/* 271 */       this.projectCode = projectCode;
/* 272 */       if (null == this.projectCode)
/* 273 */         this.projectCode = "";
/*     */     }
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 278 */       return this.projectCode.hashCode();
/*     */     }
/*     */ 
/*     */     public boolean equeal(Object obj) {
/* 282 */       return this.projectCode.equals(((Projects)obj).projectCode);
/*     */     }
/*     */ 
/*     */     public String getProjectCode() {
/* 286 */       return this.projectCode;
/*     */     }
/*     */ 
/*     */     public String toString()
/*     */     {
/* 291 */       StringBuilder builder = new StringBuilder();
/* 292 */       builder.append("Goods [allAmountQuotaArray=");
/*     */ 
/* 294 */       builder.append(", goodsCode=");
/* 295 */       builder.append(this.projectCode);
/* 296 */       builder.append(", goodsDTO=");
/* 297 */       builder.append(this.projectDTO);
/* 298 */       builder.append(", projectPoundageDTO=");
/* 299 */       builder.append(this.projectPoundageDTO);
/* 300 */       builder.append(", goodsDTOTrade=");
/* 301 */       builder.append(this.projectTradeDTO);
/* 302 */       builder.append(", netAmountQuotaArray=");
/*     */ 
/* 304 */       builder.append(", poundageArray=");
/*     */ 
/* 306 */       builder.append(", settlementPriceSafe=");
/* 307 */       builder.append(this.settlementPriceSafe);
/* 308 */       builder.append("]");
/* 309 */       return builder.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static class Poundage
/*     */   {
/*     */     private String projectCode;
/*     */     private Integer fashionPoundage;
/*     */     private BigDecimal buyNew;
/*     */     private BigDecimal buyOldCurr;
/*     */     private BigDecimal buyOldHis;
/*     */     private BigDecimal saleNew;
/*     */     private BigDecimal saleOldCurr;
/*     */     private BigDecimal saleOldHis;
/*     */     private BigDecimal buyForce;
/*     */     private BigDecimal saleForce;
/*     */     private BigDecimal bailBuy;
/*     */     private BigDecimal bailSale;
/*     */ 
/*     */     public Poundage(ProjectPoundageDTO projectPoundageDTO)
/*     */     {
/* 145 */       this.projectCode = projectPoundageDTO.getProjectCode();
/* 146 */       this.fashionPoundage = projectPoundageDTO.getFashionPoundage();
/* 147 */       this.buyNew = projectPoundageDTO.getBuyNewBigDecimal();
/* 148 */       this.buyOldCurr = projectPoundageDTO.getBuyOldCurrBigDecimal();
/* 149 */       this.buyOldHis = projectPoundageDTO.getBuyOldHisBigDecimal();
/* 150 */       this.saleNew = projectPoundageDTO.getSaleNewBigDecimal();
/* 151 */       this.saleOldCurr = projectPoundageDTO.getSaleOldCurrBigDecimal();
/* 152 */       this.saleOldHis = projectPoundageDTO.getSaleOldHisBigDecimal();
/* 153 */       this.buyForce = projectPoundageDTO.getBuyForceBigDecimal();
/* 154 */       this.saleForce = projectPoundageDTO.getSaleForceBigDecimal();
/* 155 */       this.bailBuy = projectPoundageDTO.getBailBuyBigDecimal();
/* 156 */       this.bailSale = projectPoundageDTO.getBailSaleBigDecimal();
/*     */     }
/*     */ 
/*     */     public String getProjectCode()
/*     */     {
/* 176 */       return this.projectCode;
/*     */     }
/*     */ 
/*     */     public Integer getFashionPoundage() {
/* 180 */       return this.fashionPoundage;
/*     */     }
/*     */ 
/*     */     public BigDecimal getBuyNew() {
/* 184 */       return this.buyNew;
/*     */     }
/*     */ 
/*     */     public BigDecimal getBuyOldCurr() {
/* 188 */       return this.buyOldCurr;
/*     */     }
/*     */ 
/*     */     public BigDecimal getBuyOldHis() {
/* 192 */       return this.buyOldHis;
/*     */     }
/*     */ 
/*     */     public BigDecimal getSaleNew() {
/* 196 */       return this.saleNew;
/*     */     }
/*     */ 
/*     */     public BigDecimal getSaleOldCurr() {
/* 200 */       return this.saleOldCurr;
/*     */     }
/*     */ 
/*     */     public BigDecimal getSaleOldHis() {
/* 204 */       return this.saleOldHis;
/*     */     }
/*     */ 
/*     */     public BigDecimal getBuyForce() {
/* 208 */       return this.buyForce;
/*     */     }
/*     */ 
/*     */     public BigDecimal getSaleForce() {
/* 212 */       return this.saleForce;
/*     */     }
/*     */ 
/*     */     public BigDecimal getBailBuy() {
/* 216 */       return this.bailBuy;
/*     */     }
/*     */ 
/*     */     public BigDecimal getBailSale() {
/* 220 */       return this.bailSale;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.GlobalMemoryQueryEngine
 * JD-Core Version:    0.6.0
 */