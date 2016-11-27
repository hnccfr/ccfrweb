/*     */ package com.hundsun.network.gates.fengshan.biz.service.pojo.supplydemand;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.supplydemand.SupplyDemandInfoDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandInfoQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandVisitorsQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.AccuseInfo;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfo;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.supplydemand.SupplyDemandInfoService;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("SupplyDemandInfoService")
/*     */ public class SupplyDemandInfoServiceImpl extends BaseService
/*     */   implements SupplyDemandInfoService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private SupplyDemandInfoDAO supplyDemandInfoDAO;
/*     */ 
/*     */   public void getSupplyDemandInfoByQuery(SupplyDemandInfoQuery query)
/*     */   {
/*  30 */     this.supplyDemandInfoDAO.selectByQuery2(query);
/*     */   }
/*     */ 
/*     */   public void addSupplyDemandInfo(SupplyDemandInfo supplyDemandInfo)
/*     */   {
/*  38 */     this.supplyDemandInfoDAO.addSupplyDemandInfo(supplyDemandInfo);
/*     */   }
/*     */ 
/*     */   public SupplyDemandInfo getSupplyDemandInfoById(Long id)
/*     */   {
/*  43 */     return this.supplyDemandInfoDAO.selectByPrimaryKey(id);
/*     */   }
/*     */ 
/*     */   public SupplyDemandInfo getSupplyDemandInfoById2(Long id)
/*     */   {
/*  48 */     return this.supplyDemandInfoDAO.selectByPrimaryKey2(id);
/*     */   }
/*     */ 
/*     */   public SupplyDemandInfoAudit getSupplyDemandInfoAuditById(Long id)
/*     */   {
/*  53 */     if (null == id) {
/*  54 */       return null;
/*     */     }
/*  56 */     return this.supplyDemandInfoDAO.selectAuditInfoById(id);
/*     */   }
/*     */ 
/*     */   public List<AccuseInfo> getSupplyDemandInfoAccuseById(Long id)
/*     */   {
/*  61 */     return this.supplyDemandInfoDAO.selectAccuseInfoById(id);
/*     */   }
/*     */ 
/*     */   public AccuseInfo getAccuseReasonById(Long id) {
/*  65 */     return this.supplyDemandInfoDAO.selectAccuseReasonById(id);
/*     */   }
/*     */ 
/*     */   public String projectCodeCreator(SupplyDemandInfo supplyDemandInfo)
/*     */   {
/*  73 */     if (null == supplyDemandInfo.getInfoType()) {
/*  74 */       return null;
/*     */     }
/*  76 */     String projectTypeStr = supplyDemandInfo.getInfoType().substring(0, 1);
/*  77 */     String dateStr = CommonUtils.convertDateToString("yyyyMMddHHmm", new Date());
/*  78 */     long randomStr = Math.round(Math.random() * 900.0D) + 100L;
/*  79 */     String projectCode = projectTypeStr + dateStr + String.valueOf(randomStr);
/*  80 */     return projectCode;
/*     */   }
/*     */ 
/*     */   public void updateSupplyDemandInfoStatusById(SupplyDemandInfo supplyDemandInfo)
/*     */   {
/*  89 */     this.supplyDemandInfoDAO.updateStatusById(supplyDemandInfo);
/*     */   }
/*     */ 
/*     */   public void updateSupplyDemandInfo(SupplyDemandInfo supplyDemandInfo)
/*     */   {
/*  94 */     this.supplyDemandInfoDAO.updateByPrimaryKeySelective(supplyDemandInfo);
/*     */   }
/*     */ 
/*     */   public int updateSupplyDemandInfoOverdue()
/*     */   {
/*  99 */     return this.supplyDemandInfoDAO.updateInfoOverdue();
/*     */   }
/*     */ 
/*     */   public int deleteSupplyDemandInfoById(SupplyDemandInfo supplyDemandInfo)
/*     */   {
/* 104 */     return this.supplyDemandInfoDAO.deleteInfoMain(supplyDemandInfo);
/*     */   }
/*     */ 
/*     */   public int deleteSupplyDemandInfoAuditById(SupplyDemandInfoAudit supplyDemandInfoAudit)
/*     */   {
/* 109 */     return this.supplyDemandInfoDAO.deleteInfoAudit(supplyDemandInfoAudit);
/*     */   }
/*     */ 
/*     */   public int deleteSupplyDemandInfoAccuseById(Long id)
/*     */   {
/* 114 */     return this.supplyDemandInfoDAO.deleteInfoAccuse(id);
/*     */   }
/*     */ 
/*     */   public void getSupplyDemandByQuery(SupplyDemandVisitorsQuery query)
/*     */   {
/* 119 */     if (null != query.getInfoType()) {
/* 120 */       query.setInfoType(query.getInfoType().trim());
/*     */     }
/* 122 */     if (null != query.getTitle()) {
/* 123 */       query.setTitle(query.getTitle().trim());
/*     */     }
/* 125 */     if (null != query.getProjectCode()) {
/* 126 */       query.setProjectCode(query.getProjectCode().trim());
/*     */     }
/* 128 */     this.supplyDemandInfoDAO.selectByQuery(query);
/*     */   }
/*     */ 
/*     */   public SupplyDemandInfo getSupplyDemandByCode(String projectCode)
/*     */   {
/* 133 */     if (null == projectCode) {
/* 134 */       return null;
/*     */     }
/* 136 */     SupplyDemandInfo sdinfo = this.supplyDemandInfoDAO.selectByCode(projectCode);
/* 137 */     return sdinfo;
/*     */   }
/*     */ 
/*     */   public String accuseType(AccuseInfo accuseInfo, long infoId, String accuser)
/*     */   {
/* 143 */     if ((null == accuseInfo) || (0L == infoId) || (null == accuser)) {
/* 144 */       return "false";
/*     */     }
/* 146 */     accuseInfo.setInfoId(infoId);
/* 147 */     accuseInfo.setAccuser(accuser);
/* 148 */     accuseInfo.setStatus("A");
/* 149 */     this.supplyDemandInfoDAO.accuseType(accuseInfo);
/* 150 */     return "success";
/*     */   }
/*     */ 
/*     */   public int updateSupplyDemandInfoAccuseOverdue()
/*     */   {
/* 157 */     return this.supplyDemandInfoDAO.updateAccuseInfoOverdue();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.supplydemand.SupplyDemandInfoServiceImpl
 * JD-Core Version:    0.6.0
 */