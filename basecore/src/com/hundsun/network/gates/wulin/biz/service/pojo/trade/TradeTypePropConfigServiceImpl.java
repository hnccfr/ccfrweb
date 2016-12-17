/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.dao.trade.TradeTypePropConfigDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.trade.TradeTypePropConfig;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.trade.TradeTypePropConfigService;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("tradeTypePropConfigService")
/*     */ public class TradeTypePropConfigServiceImpl extends BaseService
/*     */   implements TradeTypePropConfigService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeTypePropConfigDAO tradeTypePropConfigDAO;
/*     */ 
/*     */   public int countByExample(TradeTypePropConfig tradeTypePropConfig)
/*     */   {
/*  38 */     return 0;
/*     */   }
/*     */ 
/*     */   public int deleteByExample(TradeTypePropConfig tradeTypePropConfig)
/*     */   {
/*  48 */     return 0;
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  58 */     return 0;
/*     */   }
/*     */ 
/*     */   public List<TradeTypePropConfig> getTradeTypePropList(TradeTypePropConfig tradeTypePropConfig)
/*     */   {
/*  69 */     return this.tradeTypePropConfigDAO.getTradeTypePropList(tradeTypePropConfig);
/*     */   }
/*     */ 
/*     */   public void insert(TradeTypePropConfig record)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void insertSelective(TradeTypePropConfig record)
/*     */   {
/*     */   }
/*     */ 
/*     */   public TradeTypePropConfig selectByPrimaryKey(Long id)
/*     */   {
/*  95 */     return null;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(TradeTypePropConfig record)
/*     */   {
/* 105 */     return 0;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(TradeTypePropConfig record)
/*     */   {
/* 115 */     return 0;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.trade.TradeTypePropConfigServiceImpl
 * JD-Core Version:    0.6.0
 */