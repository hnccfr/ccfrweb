/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.supplydemand;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoAccuseDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoAccuseQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAccuse;
/*    */ import com.hundsun.network.gates.genshan.biz.service.supplydemand.SupplyDemandInfoAccuseService;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("SupplyDemandInfoAccuseService")
/*    */ public class SupplyDemandInfoAccuseServiceImpl
/*    */   implements SupplyDemandInfoAccuseService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SupplyDemandInfoAccuseDAO accuseDAO;
/*    */ 
/*    */   @Autowired
/*    */   private SupplyDemandInfoDAO supplyDemandInfoDAO;
/*    */ 
/*    */   public void selectPageList(SupplyDemandInfoAccuseQuery query)
/*    */   {
/* 33 */     this.accuseDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public SupplyDemandInfoAccuse selectAccuseById(Long aid)
/*    */   {
/* 38 */     return this.accuseDAO.selectAccuseById(aid);
/*    */   }
/*    */ 
/*    */   public SupplyDemandInfo selectInfoById(Long sid)
/*    */   {
/* 43 */     return this.supplyDemandInfoDAO.selectInfoById(sid);
/*    */   }
/*    */ 
/*    */   public int updateAccuse(SupplyDemandInfoAccuse accuse)
/*    */   {
/* 48 */     return this.accuseDAO.updateAccuse(accuse);
/*    */   }
/*    */ 
/*    */   public int updateOtherAccuse(SupplyDemandInfoAccuse accuse)
/*    */   {
/* 53 */     return this.accuseDAO.updateOtherAccuse(accuse);
/*    */   }
/*    */ 
/*    */   public int updateInfoStatus(Map<String, Object> map)
/*    */   {
/* 58 */     return this.supplyDemandInfoDAO.updateInfoStatus(map);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.supplydemand.SupplyDemandInfoAccuseServiceImpl
 * JD-Core Version:    0.6.0
 */