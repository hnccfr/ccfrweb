/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.supplydemand;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoAccuseDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoAccuseQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAccuse;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("supplyDemandInfoAccuseDAO")
/*    */ public class SupplyDemandInfoAccuseDAOImpl extends BaseDAO
/*    */   implements SupplyDemandInfoAccuseDAO
/*    */ {
/*    */   public void selectPageList(SupplyDemandInfoAccuseQuery query)
/*    */   {
/* 23 */     paginate(query, "SUPPLY_DEMAND_INFO_ACCUSE.selectPageList-count", "SUPPLY_DEMAND_INFO_ACCUSE.selectPageList");
/*    */   }
/*    */ 
/*    */   public SupplyDemandInfoAccuse selectAccuseById(Long aid)
/*    */   {
/* 28 */     return (SupplyDemandInfoAccuse)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO_ACCUSE.selectAccuseById", aid);
/*    */   }
/*    */ 
/*    */   public int updateAccuse(SupplyDemandInfoAccuse accuse)
/*    */   {
/* 33 */     return getSqlMapClientTemplate().update("SUPPLY_DEMAND_INFO_ACCUSE.updateAccuse", accuse);
/*    */   }
/*    */ 
/*    */   public int updateOtherAccuse(SupplyDemandInfoAccuse accuse)
/*    */   {
/* 38 */     return getSqlMapClientTemplate().update("SUPPLY_DEMAND_INFO_ACCUSE.updateOtherAccuse", accuse);
/*    */   }
/*    */ 
/*    */   public Integer getNumByQuery(SupplyDemandInfoAccuseQuery query)
/*    */   {
/* 48 */     return (Integer)getSqlMapClientTemplate().queryForObject("SUPPLY_DEMAND_INFO_ACCUSE.selectPageList-count", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.supplydemand.SupplyDemandInfoAccuseDAOImpl
 * JD-Core Version:    0.6.0
 */