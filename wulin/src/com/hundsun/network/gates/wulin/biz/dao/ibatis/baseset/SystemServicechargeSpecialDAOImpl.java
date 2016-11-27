/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemServicechargeSpecialDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemServicechargeSpecial;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemServicechargeSpecialExt;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemServicechargeSpecialDAO")
/*    */ public class SystemServicechargeSpecialDAOImpl extends BaseDAO
/*    */   implements SystemServicechargeSpecialDAO
/*    */ {
/*    */   public List<SystemServicechargeSpecialExt> selectChargeSpecialByCond(String userAccount, String proTypeCode, String tradingType, String haveAuctioneer, Long turnoverAmount)
/*    */   {
/* 25 */     SystemServicechargeSpecial sscs = new SystemServicechargeSpecial();
/* 26 */     if (StringUtil.isNotEmpty(userAccount)) {
/* 27 */       sscs.setUserAccount(userAccount);
/*    */     }
/* 29 */     if (StringUtil.isNotEmpty(proTypeCode)) {
/* 30 */       sscs.setProTypeCode(proTypeCode);
/*    */     }
/* 32 */     if (StringUtil.isNotEmpty(tradingType)) {
/* 33 */       sscs.setTradingType(tradingType);
/*    */     }
/* 35 */     if (StringUtil.isNotEmpty(haveAuctioneer)) {
/* 36 */       sscs.setHaveAuctioneer(haveAuctioneer);
/*    */     }
/* 38 */     if (null != turnoverAmount) {
/* 39 */       sscs.setTurnoverAmount(turnoverAmount);
/*    */     }
/* 41 */     return getSqlMapClientTemplate().queryForList("SYSTEM_SERVICECHARGE_SPECIAL.selectChargeSpecialByCond", sscs);
/*    */   }
/*    */ 
/*    */   public SystemServicechargeSpecial selectChargeSpecialSystem()
/*    */   {
/* 49 */     return (SystemServicechargeSpecial)getSqlMapClientTemplate().queryForObject("SYSTEM_SERVICECHARGE_SPECIAL.selectChargeSpecialSystem");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset.SystemServicechargeSpecialDAOImpl
 * JD-Core Version:    0.6.0
 */