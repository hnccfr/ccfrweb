/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.supplydemand;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("supplyDemandInfoDAO")
/*    */ public class SupplyDemandInfoDAOImpl extends BaseDAO
/*    */   implements SupplyDemandInfoDAO
/*    */ {
/*    */   public void selectPageList(SupplyDemandInfoQuery query)
/*    */   {
/* 29 */     paginate(query, "SUPPLY_DEMAND_INFO.selectPageList-count", "SUPPLY_DEMAND_INFO.selectPageList");
/*    */   }
/*    */ 
/*    */   public SupplyDemandInfo getAuditByInfoId(Long sid)
/*    */   {
/* 34 */     return (SupplyDemandInfo)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO.getAuditByInfoId", sid);
/*    */   }
/*    */ 
/*    */   public int updateInfoAudit(SupplyDemandInfoAudit audit)
/*    */   {
/* 39 */     int rows = getSqlMapClientTemplate().update("SUPPLY_DEMAND_INFO.updateInfoAudit", audit);
/* 40 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insertInfoAudit(SupplyDemandInfoAudit audit)
/*    */   {
/* 45 */     getSqlMapClientTemplate().insert("SUPPLY_DEMAND_INFO.insertInfoAudit", audit);
/*    */   }
/*    */ 
/*    */   public SupplyDemandInfo selectInfoById(Long sid)
/*    */   {
/* 50 */     return (SupplyDemandInfo)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO.selectInfoById", sid);
/*    */   }
/*    */ 
/*    */   public int updateInfoStatus(Map<String, Object> map)
/*    */   {
/* 55 */     return getSqlMapClientTemplate().update("SUPPLY_DEMAND_INFO.updateInfoStatus", map);
/*    */   }
/*    */ 
/*    */   public Integer getNumByQuery(SupplyDemandInfoQuery query)
/*    */   {
/* 65 */     return (Integer)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO.selectPageList-count", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.supplydemand.SupplyDemandInfoDAOImpl
 * JD-Core Version:    0.6.0
 */