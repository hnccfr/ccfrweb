/*     */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.project;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionMulitBidProjectQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectListingQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("projectListingDAO")
/*     */ public class ProjectListingDAOImpl extends BaseDAO
/*     */   implements ProjectListingDAO
/*     */ {
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  27 */     if (null == id) {
/*  28 */       return 0;
/*     */     }
/*  30 */     int rows = getSqlMapClientTemplate().delete("PROJECT_LISTING.deleteByPrimaryKey", id);
/*  31 */     return rows;
/*     */   }
/*     */ 
/*     */   public void insert(ProjectListing record)
/*     */   {
/*  36 */     getSqlMapClientTemplate().insert("PROJECT_LISTING.insert", record);
/*     */   }
/*     */ 
/*     */   public void insertSelective(ProjectListing record) {
/*  40 */     getSqlMapClientTemplate().insert("PROJECT_LISTING.insertSelective", record);
/*     */   }
/*     */ 
/*     */   public ProjectListing selectByPrimaryKey(Long id) {
/*  44 */     if (null == id) {
/*  45 */       return null;
/*     */     }
/*  47 */     ProjectListing record = (ProjectListing)getSqlMapClientTemplate().queryForObject("PROJECT_LISTING.selectByPrimaryKey", id);
/*     */ 
/*  49 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(ProjectListing record)
/*     */   {
/*  54 */     int rows = getSqlMapClientTemplate().update("PROJECT_LISTING.updateByPrimaryKeySelective", record);
/*     */ 
/*  56 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(ProjectListing record) {
/*  60 */     int rows = getSqlMapClientTemplate().update("PROJECT_LISTING.updateByPrimaryKey", record);
/*  61 */     return rows;
/*     */   }
/*     */ 
/*     */   public void selectByQuery(ProjectListingQuery query)
/*     */   {
/*  66 */     paginate(query, "PROJECT_LISTING.queryProjectListingCount", "PROJECT_LISTING.queryProjectListing");
/*     */   }
/*     */ 
/*     */   public ProjectListing selectByCode(String code)
/*     */   {
/*  77 */     ProjectListing projectListing = (ProjectListing)getSqlMapClientTemplate().queryForObject("PROJECT_LISTING.selectProjectListingByCode", code);
/*     */ 
/*  79 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public List<DateStatistics> queryProjectListingByDate(EnumDateStatisticsType type, Long interval)
/*     */   {
/*  85 */     Map paraMap = new HashMap();
/*  86 */     paraMap.put("type", type);
/*  87 */     paraMap.put("interval", interval);
/*  88 */     List baseList = getSqlMapClientTemplate().queryForList("PROJECT_LISTING.queryDateRange", paraMap);
/*     */ 
/*  90 */     List list = getSqlMapClientTemplate().queryForList("PROJECT_LISTING.queryProjectListingByDate", paraMap);
/*     */ 
/*  92 */     for (int i = 0; i < baseList.size(); i++) {
/*  93 */       int index = list.indexOf(baseList.get(i));
/*  94 */       if (index >= 0) {
/*  95 */         baseList.set(i, list.get(index));
/*     */       }
/*     */     }
/*  98 */     return baseList;
/*     */   }
/*     */ 
/*     */   public void selectAuctionProjectlist(ProjectListingQuery query)
/*     */   {
/* 106 */     paginate(query, "PROJECT_LISTING.selectAuctionProjectlistCount", "PROJECT_LISTING.selectAuctionProjectlist");
/*     */   }
/*     */ 
/*     */   public int existsAuctioner(String projectCode, String userAccount)
/*     */   {
/* 117 */     Map paraMap = new HashMap();
/* 118 */     paraMap.put("projectCode", projectCode);
/*     */ 
/* 120 */     String[] tradingTypeArr = { EnumTradingType.BID_ORDER.getValue(), EnumTradingType.MULIT_BID_ORDER.getValue() };
/* 121 */     paraMap.put("tradingTypeArr", tradingTypeArr);
/* 122 */     paraMap.put("auctioneerAccountkey", EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/* 123 */     paraMap.put("haveAuctioneerKey", EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/* 124 */     paraMap.put("auctioneerAccount", userAccount);
/* 125 */     return ((Integer)getSqlMapClientTemplate().queryForObject("PROJECT_LISTING.existsAuctioner", paraMap)).intValue();
/*     */   }
/*     */ 
/*     */   public void queryAuctionMulitBidProject(AuctionMulitBidProjectQuery query)
/*     */   {
/* 136 */     paginate(query, "PROJECT_LISTING.queryAuctionMulitBidProjectCount", "PROJECT_LISTING.queryAuctionMulitBidProject");
/*     */   }
/*     */ 
/*     */   public String selectStatusByCode(String code)
/*     */   {
/* 142 */     Object obj = getSqlMapClientTemplate().queryForObject("PROJECT_LISTING.selectStatusByCode", code);
/* 143 */     return null == obj ? null : String.valueOf(obj);
/*     */   }
/*     */ 
/*     */   public Integer getNumByQuery(ProjectListingQuery query)
/*     */   {
/* 153 */     return (Integer)getSqlMapClientTemplate().queryForObject("PROJECT_LISTING.queryProjectListingCount", query);
/*     */   }
/*     */ 
/*     */   public Integer selectAuctionProjectNum(ProjectListingQuery query)
/*     */   {
/* 163 */     return (Integer)getSqlMapClientTemplate().queryForObject("PROJECT_LISTING.selectAuctionProjectlistCount", query);
/*     */   }
/*     */ 
/*     */   public Integer queryAuctionMulitBidProjectNum(AuctionMulitBidProjectQuery query)
/*     */   {
/* 173 */     return (Integer)getSqlMapClientTemplate().queryForObject("PROJECT_LISTING.queryAuctionMulitBidProjectCount", query);
/*     */   }
/*     */ 
/*     */   public Long getProjectIdByCode(String projectCode)
/*     */   {
/* 178 */     Object obj = getSqlMapClientTemplate().queryForObject("PROJECT_LISTING.getProjectIdByCode", projectCode);
/* 179 */     return null == obj ? null : (Long)obj;
/*     */   }
/*     */ 
/*     */   public int updateAttachedFilePath(ProjectListing projectListing)
/*     */   {
/* 184 */     return Integer.valueOf(getSqlMapClientTemplate().update("PROJECT_LISTING.updateAttachedFilePath", projectListing)).intValue();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.project.ProjectListingDAOImpl
 * JD-Core Version:    0.6.0
 */