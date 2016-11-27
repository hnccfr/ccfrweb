/*    */ package com.hundsun.network.gates.genshan.biz.service.baseset.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.BasePhaseDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.BasePhase;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.BasePhaseQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.BasePhaseService;
/*    */ import com.hundsun.network.gates.luosi.common.enums.BasePhaseStateEnum;
/*    */ import java.util.Date;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("basePhaseService")
/*    */ public class BasePhaseServiceImpl extends BaseService
/*    */   implements BasePhaseService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BasePhaseDAO basePhaseDAO;
/*    */ 
/*    */   public void queryPhase(BasePhaseQuery<BasePhase> query)
/*    */   {
/* 22 */     if (null != query.getPhaseCode()) {
/* 23 */       query.setPhaseCode(query.getPhaseCode().trim());
/*    */     }
/* 25 */     if (null != query.getPhaseName()) {
/* 26 */       query.setPhaseName(query.getPhaseName());
/*    */     }
/* 28 */     this.basePhaseDAO.queryPhase(query);
/*    */   }
/*    */ 
/*    */   public void addBasePhase(BasePhase record)
/*    */   {
/* 34 */     this.basePhaseDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public void delBasePhase(Long phseMark, Date tradeDay)
/*    */   {
/* 39 */     BasePhase record = new BasePhase();
/* 40 */     record.setState(BasePhaseStateEnum.DELETE.getValue());
/* 41 */     record.setUniqueMark(phseMark);
/* 42 */     record.setGmtValid(tradeDay);
/* 43 */     this.basePhaseDAO.logicalDeletePhase(record);
/*    */   }
/*    */ 
/*    */   public void disableBasePhase(Long mark, Date nextTradeDay)
/*    */   {
/* 49 */     BasePhase basePhase = this.basePhaseDAO.getValidPhase(mark);
/* 50 */     if (null != basePhase) {
/* 51 */       basePhase.setState(BasePhaseStateEnum.DISABLE.getValue());
/* 52 */       basePhase.setGmtValid(nextTradeDay);
/* 53 */       this.basePhaseDAO.businessAdd(basePhase);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void enableBasePhase(Long mark, Date valid)
/*    */   {
/* 59 */     BasePhase basePhase = this.basePhaseDAO.getValidPhase(mark);
/* 60 */     if (null != basePhase) {
/* 61 */       basePhase.setState(BasePhaseStateEnum.ENABLE.getValue());
/* 62 */       basePhase.setGmtValid(valid);
/* 63 */       this.basePhaseDAO.businessAdd(basePhase);
/*    */     }
/*    */   }
/*    */ 
/*    */   public BasePhase getBasePhaseById(Long id)
/*    */   {
/* 70 */     return this.basePhaseDAO.getBasePhaseById(id);
/*    */   }
/*    */ 
/*    */   public void modifyBasePhase(BasePhase record)
/*    */   {
/* 75 */     this.basePhaseDAO.businessAdd(record);
/*    */   }
/*    */ 
/*    */   public void queryPhaseNext(BasePhaseQuery<BasePhase> query)
/*    */   {
/* 80 */     if (null != query.getPhaseCode()) {
/* 81 */       query.setPhaseCode(query.getPhaseCode().trim());
/*    */     }
/* 83 */     if (null != query.getPhaseName()) {
/* 84 */       query.setPhaseName(query.getPhaseName());
/*    */     }
/* 86 */     this.basePhaseDAO.queryPhaseNext(query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.pojo.BasePhaseServiceImpl
 * JD-Core Version:    0.6.0
 */