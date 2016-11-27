/*    */ package com.hundsun.eclp.biz.service.sys.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.sys.RegionDAO;
/*    */ import com.hundsun.eclp.biz.domain.sys.Region;
/*    */ import com.hundsun.eclp.biz.service.sys.RegionService;
/*    */ import com.hundsun.eclp.enums.EnumRegionType;
/*    */ import com.hundsun.network.common.service.BaseService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("regionService")
/*    */ public class RegionServiceImpl extends BaseService
/*    */   implements RegionService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RegionDAO regionDAO;
/*    */ 
/*    */   public List<Region> getRegionByType(EnumRegionType regionType)
/*    */   {
/*    */     try
/*    */     {
/* 33 */       Region region = new Region();
/* 34 */       region.setRegionType(Short.valueOf(Short.parseShort(regionType.getCode())));
/* 35 */       return this.regionDAO.selectRegionList(region);
/*    */     } catch (Exception e) {
/* 37 */       this.logger.error("getRegionByType: " + e.getMessage());
/*    */     }
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */   public List<Region> getChildRegionList(EnumRegionType regionType, String parnetCode)
/*    */   {
/* 44 */     if (StringUtil.isBlank(parnetCode)) {
/* 45 */       return null;
/*    */     }
/* 47 */     Region region = new Region();
/* 48 */     region.setRegionType(Short.valueOf(Short.parseShort(regionType.getCode())));
/* 49 */     region.setParentCode(parnetCode);
/* 50 */     return this.regionDAO.selectRegionList(region);
/*    */   }
/*    */ 
/*    */   public Region selectRegionByName(String regionName)
/*    */   {
/*    */     try {
/* 56 */       return this.regionDAO.selectRegionByName(regionName);
/*    */     } catch (Exception e) {
/* 58 */       this.logger.error("selectRegionByName method: " + e.getMessage());
/*    */     }
/* 60 */     return null;
/*    */   }
/*    */ 
/*    */   public Region selectRegionByCode(String code)
/*    */   {
/*    */     try {
/* 66 */       return this.regionDAO.selectRegionByCode(code);
/*    */     } catch (Exception e) {
/* 68 */       this.logger.error("selectRegionByName method: " + e.getMessage());
/*    */     }
/* 70 */     return null;
/*    */   }
/*    */ 
/*    */   public List<Region> getProvinceList()
/*    */   {
/* 75 */     return getRegionByType(EnumRegionType.PROVINCE);
/*    */   }
/*    */ 
/*    */   public List<Region> getCityList()
/*    */   {
/* 80 */     return getRegionByType(EnumRegionType.CITY);
/*    */   }
/*    */ 
/*    */   public List<Region> getDistrictList()
/*    */   {
/* 85 */     return getRegionByType(EnumRegionType.DISTRICT);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.sys.impl.RegionServiceImpl
 * JD-Core Version:    0.6.0
 */