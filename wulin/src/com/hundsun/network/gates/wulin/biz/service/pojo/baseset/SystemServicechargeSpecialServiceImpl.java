/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemServicechargeSpecialDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemServicechargeSpecial;
/*    */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemServicechargeSpecialService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemServicechargeSpecialService")
/*    */ public class SystemServicechargeSpecialServiceImpl
/*    */   implements SystemServicechargeSpecialService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemServicechargeSpecialDAO systemServicechargeSpecialDAO;
/*    */ 
/*    */   public List selectChargeSpecialByCond(String userAccount, String proTypeCode, String tradingType, String haveAuctioneer, Long turnoverAmount)
/*    */   {
/* 22 */     return this.systemServicechargeSpecialDAO.selectChargeSpecialByCond(userAccount, proTypeCode, tradingType, haveAuctioneer, turnoverAmount);
/*    */   }
/*    */ 
/*    */   public SystemServicechargeSpecial selectChargeSpecialSystem()
/*    */   {
/* 27 */     return this.systemServicechargeSpecialDAO.selectChargeSpecialSystem();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.baseset.SystemServicechargeSpecialServiceImpl
 * JD-Core Version:    0.6.0
 */