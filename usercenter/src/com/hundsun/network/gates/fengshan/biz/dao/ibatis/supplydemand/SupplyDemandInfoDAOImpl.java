/*     */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.supplydemand;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.supplydemand.SupplyDemandInfoDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandInfoQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandVisitorsQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.AccuseInfo;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfo;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("SupplyDemandInfoDAO")
/*     */ public class SupplyDemandInfoDAOImpl extends BaseDAO
/*     */   implements SupplyDemandInfoDAO
/*     */ {
/*     */   public void selectByQuery2(SupplyDemandInfoQuery query)
/*     */   {
/*  22 */     paginate(query, "SUPPLY_DEMAND_INFO.querySupplyDemandInfoCount", "SUPPLY_DEMAND_INFO.querySupplyDemandInfo");
/*     */   }
/*     */ 
/*     */   public void addSupplyDemandInfo(SupplyDemandInfo supplyDemandInfo)
/*     */   {
/*  28 */     getSqlMapClientTemplate().insert("SUPPLY_DEMAND_INFO.insert", supplyDemandInfo);
/*     */   }
/*     */ 
/*     */   public SupplyDemandInfo selectByPrimaryKey(Long id)
/*     */   {
/*  36 */     return (SupplyDemandInfo)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO.selectByPrimaryKey", id);
/*     */   }
/*     */ 
/*     */   public SupplyDemandInfo selectByPrimaryKey2(Long id)
/*     */   {
/*  42 */     return (SupplyDemandInfo)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO.selectByPrimaryKey2", id);
/*     */   }
/*     */ 
/*     */   public SupplyDemandInfoAudit selectAuditInfoById(Long id)
/*     */   {
/*  48 */     if (null == id) {
/*  49 */       return null;
/*     */     }
/*  51 */     return (SupplyDemandInfoAudit)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO_AUDIT.selectAuditInfoById", id);
/*     */   }
/*     */ 
/*     */   public List<AccuseInfo> selectAccuseInfoById(Long id)
/*     */   {
/*  59 */     List list = getSqlMapClientTemplate().queryForList("ACCUSE_INFO.selectAccuseInfoById", id);
/*     */ 
/*  61 */     return list;
/*     */   }
/*     */ 
/*     */   public AccuseInfo selectAccuseReasonById(Long id)
/*     */   {
/*  66 */     return (AccuseInfo)getSqlMapClientTemplate().queryForObject("ACCUSE_INFO.selectAccuseReasonById", id);
/*     */   }
/*     */ 
/*     */   public void updateStatusById(SupplyDemandInfo supplyDemandInfo)
/*     */   {
/*  72 */     getSqlMapClientTemplate().update("SUPPLY_DEMAND_INFO.updateStatusById", supplyDemandInfo);
/*     */   }
/*     */ 
/*     */   public void updateByPrimaryKeySelective(SupplyDemandInfo supplyDemandInfo)
/*     */   {
/*  77 */     getSqlMapClientTemplate().update("SUPPLY_DEMAND_INFO.updateByPrimaryKeySelective", supplyDemandInfo);
/*     */   }
/*     */ 
/*     */   public int updateInfoOverdue()
/*     */   {
/*  82 */     return getSqlMapClientTemplate().update("SUPPLY_DEMAND_INFO.updateInfoOverdue");
/*     */   }
/*     */ 
/*     */   public int deleteInfoMain(SupplyDemandInfo supplyDemandInfo)
/*     */   {
/*  87 */     return getSqlMapClientTemplate().delete("SUPPLY_DEMAND_INFO.deleteInfo", supplyDemandInfo);
/*     */   }
/*     */ 
/*     */   public int deleteInfoAudit(SupplyDemandInfoAudit supplyDemandInfoAudit)
/*     */   {
/*  92 */     return getSqlMapClientTemplate().delete("SUPPLY_DEMAND_INFO_AUDIT.deleteInfo", supplyDemandInfoAudit);
/*     */   }
/*     */ 
/*     */   public int deleteInfoAccuse(Long id)
/*     */   {
/*  97 */     return getSqlMapClientTemplate().delete("ACCUSE_INFO.deleteInfo", id);
/*     */   }
/*     */ 
/*     */   public void selectByQuery(SupplyDemandVisitorsQuery query)
/*     */   {
/* 102 */     paginate(query, "SUPPLY_DEMAND_INFO.supplyDemandInfoCount", "SUPPLY_DEMAND_INFO.supplyDemandInfo");
/*     */   }
/*     */ 
/*     */   public SupplyDemandInfo selectByCode(String projectCode)
/*     */   {
/* 108 */     if (null == projectCode) {
/* 109 */       return null;
/*     */     }
/* 111 */     SupplyDemandInfo record = (SupplyDemandInfo)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO.supplyDemandInfoByCode", projectCode);
/*     */ 
/* 113 */     return record;
/*     */   }
/*     */ 
/*     */   public void accuseType(AccuseInfo accuseInfo)
/*     */   {
/* 119 */     getSqlMapClientTemplate().insert("ACCUSE_INFO.accuse", accuseInfo);
/*     */   }
/*     */ 
/*     */   public Integer getNumByQuery(SupplyDemandInfoQuery query)
/*     */   {
/* 129 */     return (Integer)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO.querySupplyDemandInfoCount", query);
/*     */   }
/*     */ 
/*     */   public int updateAccuseInfoOverdue()
/*     */   {
/* 134 */     return getSqlMapClientTemplate().update("ACCUSE_INFO.updateAccuseInfoOverdue");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.supplydemand.SupplyDemandInfoDAOImpl
 * JD-Core Version:    0.6.0
 */