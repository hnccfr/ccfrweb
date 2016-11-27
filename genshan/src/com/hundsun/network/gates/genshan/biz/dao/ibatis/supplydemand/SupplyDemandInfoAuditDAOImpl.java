/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.supplydemand;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoAuditDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("supplyDemandInfoAuditDAO")
/*    */ public class SupplyDemandInfoAuditDAOImpl extends BaseDAO
/*    */   implements SupplyDemandInfoAuditDAO
/*    */ {
/*    */   public void insertAudit(SupplyDemandInfoAudit audit)
/*    */   {
/* 22 */     getSqlMapClientTemplate().insert("SUPPLY_DEMAND_INFO_AUDIT.insertAudit", audit);
/*    */   }
/*    */ 
/*    */   public int updateAudit(SupplyDemandInfoAudit audit)
/*    */   {
/* 27 */     return getSqlMapClientTemplate().update("SUPPLY_DEMAND_INFO_AUDIT.updateAudit", audit);
/*    */   }
/*    */ 
/*    */   public SupplyDemandInfoAudit selectAuditByInfoId(Long sid)
/*    */   {
/* 32 */     return (SupplyDemandInfoAudit)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO_AUDIT.selectAuditByInfoId", sid);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.supplydemand.SupplyDemandInfoAuditDAOImpl
 * JD-Core Version:    0.6.0
 */