/*     */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.order;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderAndPro;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("tradeOrderDAO")
/*     */ public class TradeOrderDAOImpl extends BaseDAO
/*     */   implements TradeOrderDAO
/*     */ {
/*     */   public void queryTradeOrder(TradeOrderQuery query)
/*     */   {
/*  27 */     paginate(query, "TradeOrder.queryTradeOrderCount", "TradeOrder.queryTradeOrder");
/*     */   }
/*     */ 
/*     */   public TradeOrder selectByOrderNo(String orderNo)
/*     */   {
/*  32 */     return (TradeOrder)getSqlMapClientTemplate().queryForObject("TradeOrder.selectByOrderNo", orderNo);
/*     */   }
/*     */ 
/*     */   public int updateByOrderNo(TradeOrder record)
/*     */   {
/*  42 */     int rows = getSqlMapClientTemplate().update("TradeOrder.updateByOrderNo", record);
/*  43 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateParamByOrderNo(Map<String, Object> paramMap, String orderNo)
/*     */   {
/*  55 */     if (null == paramMap) {
/*  56 */       return 0;
/*     */     }
/*  58 */     paramMap.put("orderNo", orderNo);
/*  59 */     return getSqlMapClientTemplate().update("TradeOrder.updateParamByOrderNo", paramMap);
/*     */   }
/*     */ 
/*     */   public List<TradeOrderAndPro> selectLatestOrderByCounts(TradeOrderQuery query)
/*     */   {
/*  69 */     return getSqlMapClientTemplate().queryForList("TradeOrder.selectLatestOrderByCounts", query);
/*     */   }
/*     */ 
/*     */   public List<DateStatistics> queryProjectListingByDate(EnumDateStatisticsType type, Long interval)
/*     */   {
/*  82 */     Map paraMap = new HashMap();
/*  83 */     paraMap.put("type", type);
/*  84 */     paraMap.put("interval", interval);
/*  85 */     List baseList = getSqlMapClientTemplate().queryForList("TradeOrder.queryDateRange", paraMap);
/*  86 */     List list = getSqlMapClientTemplate().queryForList("TradeOrder.queryProjectListingByDate", paraMap);
/*  87 */     for (int i = 0; i < baseList.size(); i++) {
/*  88 */       int index = list.indexOf(baseList.get(i));
/*  89 */       if (index >= 0) {
/*  90 */         baseList.set(i, list.get(index));
/*     */       }
/*     */     }
/*  93 */     return baseList;
/*     */   }
/*     */ 
/*     */   public Integer getNumByQuery(TradeOrderQuery query)
/*     */   {
/* 103 */     return (Integer)getSqlMapClientTemplate().queryForObject("TradeOrder.queryTradeOrderCount", query);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.order.TradeOrderDAOImpl
 * JD-Core Version:    0.6.0
 */