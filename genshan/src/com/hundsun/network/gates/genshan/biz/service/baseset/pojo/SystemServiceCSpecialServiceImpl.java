/*    */ package com.hundsun.network.gates.genshan.biz.service.baseset.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.SystemServicechargeSpecialDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemServicechargeSpecial;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemServicechargeSpecialQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemServiceCSpecialService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("systemServicechargeSpecialService")
/*    */ public class SystemServiceCSpecialServiceImpl
/*    */   implements SystemServiceCSpecialService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemServicechargeSpecialDAO systemServicechargeSpecialDAO;
/*    */ 
/*    */   public void selectPageList(SystemServicechargeSpecialQuery query)
/*    */   {
/* 24 */     this.systemServicechargeSpecialDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public List<SystemServicechargeSpecial> selectConditionList(SystemServicechargeSpecialQuery query)
/*    */   {
/* 33 */     return this.systemServicechargeSpecialDAO.selectConditionList(query);
/*    */   }
/*    */ 
/*    */   public List<SystemServicechargeSpecial> selectRepeatConfig(SystemServicechargeSpecialQuery query)
/*    */   {
/* 42 */     return this.systemServicechargeSpecialDAO.selectRepeatConfig(query);
/*    */   }
/*    */ 
/*    */   public void insert(SystemServicechargeSpecial record)
/*    */   {
/* 50 */     this.systemServicechargeSpecialDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(SystemServicechargeSpecial record)
/*    */   {
/* 59 */     return this.systemServicechargeSpecialDAO.updateByPrimaryKey(record);
/*    */   }
/*    */ 
/*    */   public SystemServicechargeSpecial selectByPrimaryKey(Long id)
/*    */   {
/* 68 */     return this.systemServicechargeSpecialDAO.selectByPrimaryKey(id);
/*    */   }
/*    */ 
/*    */   public SystemServicechargeSpecial selectComSpecial()
/*    */   {
/* 76 */     return this.systemServicechargeSpecialDAO.selectComSpecial();
/*    */   }
/*    */ 
/*    */   public int updateDelByPrimaryKey(Long id)
/*    */   {
/* 85 */     return this.systemServicechargeSpecialDAO.updateDelByPrimaryKey(id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.pojo.SystemServiceCSpecialServiceImpl
 * JD-Core Version:    0.6.0
 */