/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.supplydemand;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoAccuseDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoAuditDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAccuse;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
/*    */ import com.hundsun.network.gates.genshan.biz.service.supplydemand.SupplyDemandInfoService;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("supplyDemandInfoService")
/*    */ public class SupplyDemandInfoServiceImpl
/*    */   implements SupplyDemandInfoService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SupplyDemandInfoDAO supplyDemandInfoDAO;
/*    */ 
/*    */   @Autowired
/*    */   private SupplyDemandInfoAuditDAO supplyDemandInfoAuditDAO;
/*    */ 
/*    */   @Autowired
/*    */   private SupplyDemandInfoAccuseDAO accuseDAO;
/*    */ 
/*    */   public void selectPageList(SupplyDemandInfoQuery query)
/*    */   {
/* 34 */     this.supplyDemandInfoDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public SupplyDemandInfo getAuditByInfoId(Long sid)
/*    */   {
/* 42 */     return this.supplyDemandInfoDAO.getAuditByInfoId(sid);
/*    */   }
/*    */ 
/*    */   public void insertAudit(SupplyDemandInfoAudit audit)
/*    */   {
/* 50 */     this.supplyDemandInfoAuditDAO.insertAudit(audit);
/*    */   }
/*    */ 
/*    */   public int updateAudit(SupplyDemandInfoAudit audit)
/*    */   {
/* 58 */     return this.supplyDemandInfoAuditDAO.updateAudit(audit);
/*    */   }
/*    */ 
/*    */   public SupplyDemandInfoAudit selectAuditByInfoId(Long sid)
/*    */   {
/* 66 */     return this.supplyDemandInfoAuditDAO.selectAuditByInfoId(sid);
/*    */   }
/*    */ 
/*    */   public SupplyDemandInfo selectInfoById(Long sid)
/*    */   {
/* 74 */     return this.supplyDemandInfoDAO.selectInfoById(sid);
/*    */   }
/*    */ 
/*    */   public int updateInfoStatus(Map<String, Object> map)
/*    */   {
/* 82 */     return this.supplyDemandInfoDAO.updateInfoStatus(map);
/*    */   }
/*    */ 
/*    */   public int updateOtherAccuse(SupplyDemandInfoAccuse accuse)
/*    */   {
/* 87 */     return this.accuseDAO.updateOtherAccuse(accuse);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.supplydemand.SupplyDemandInfoServiceImpl
 * JD-Core Version:    0.6.0
 */