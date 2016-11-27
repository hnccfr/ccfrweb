/*    */ package com.hundsun.eclp.biz.dao.sys.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.sys.RegionDAO;
/*    */ import com.hundsun.eclp.biz.domain.sys.Region;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("regionDAO")
/*    */ public class RegionDAOImpl extends BaseDAO
/*    */   implements RegionDAO
/*    */ {
/*    */   private static final String SQLMAP_SPACE = "REGION.";
/*    */ 
/*    */   public Long insert(Region region)
/*    */     throws Exception
/*    */   {
/* 19 */     return (Long)getSqlMapClientTemplate().insert("REGION.insert", region);
/*    */   }
/*    */ 
/*    */   public int delete(Long id) throws Exception
/*    */   {
/* 24 */     return getSqlMapClientTemplate().delete("REGION.deleteByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int update(Region region) throws Exception
/*    */   {
/* 29 */     return getSqlMapClientTemplate().update("REGION.updateByPrimaryKey", region);
/*    */   }
/*    */ 
/*    */   public Region selectRegion(Long id) throws Exception
/*    */   {
/* 34 */     return (Region)getSqlMapClientTemplate().queryForObject("REGION.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public List<Region> selectRegionList(Region region)
/*    */   {
/* 40 */     return getSqlMapClientTemplate().queryForList("REGION.selectByExample", region);
/*    */   }
/*    */ 
/*    */   public Region selectRegionByName(String regionName)
/*    */   {
/* 46 */     Region region = new Region();
/* 47 */     if (StringUtil.isNotBlank(regionName)) {
/* 48 */       region.setRegionName(regionName);
/* 49 */       List reList = getSqlMapClientTemplate().queryForList("REGION.selectByExample", region);
/* 50 */       if ((null != reList) && (reList.size() > 0)) {
/* 51 */         return (Region)reList.get(0);
/*    */       }
/*    */     }
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */   public Region selectRegionByCode(String code)
/*    */   {
/* 60 */     Region region = new Region();
/* 61 */     if (StringUtil.isNotBlank(code)) {
/* 62 */       region.setCode(code);
/* 63 */       List reList = getSqlMapClientTemplate().queryForList("REGION.selectByExample", region);
/* 64 */       if ((null != reList) && (reList.size() > 0)) {
/* 65 */         return (Region)reList.get(0);
/*    */       }
/*    */     }
/* 68 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.sys.impl.RegionDAOImpl
 * JD-Core Version:    0.6.0
 */