/*     */ package com.hundsun.network.gates.houchao.biz.manager.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.DailyEndProcess;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.TradeDayCurrentDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.Cache;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.TradeDayCurrent;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.time.DateUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ 
/*     */ public final class DailyWorkEngine
/*     */ {
/*  31 */   private Log log = LogFactory.getLog(DailyWorkEngine.class);
/*     */ 
/*     */   @Autowired
/*     */   private DailyEndProcess dailyEndProcess;
/*     */ 
/*     */   @Autowired
/*     */   private TradeDayCurrentDAO tradeDayCurrentDAO;
/*     */ 
/*     */   public void init()
/*     */   {
/*     */     try {
/*  46 */       dailyEndDataBackup("");
/*     */     }
/*     */     catch (Exception e) {
/*  49 */       this.log.error("资金表备份时异常：", e);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  54 */       dailyEndAfterBackup("");
/*     */     } catch (Exception e) {
/*  56 */       this.log.error("备份资金流水表、资金汇总表以及每日结算时异常：", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void dailyEndDataBackup(String currentTradeDay)
/*     */   {
/*  65 */     if (this.log.isInfoEnabled()) {
/*  66 */       this.log.info("start dailyEndDataBackup:" + new Date());
/*     */     }
/*  68 */     Map map = new HashMap();
/*  69 */     map.put("tradeDay", currentTradeDay);
/*  70 */     map.put("resultFlag", "");
/*  71 */     map.put("resultMsg", "");
/*  72 */     this.dailyEndProcess.dailyEndDataBackup(map);
/*     */ 
/*  74 */     if (this.log.isInfoEnabled())
/*  75 */       this.log.info("end dailyEndDataBackup:" + new Date());
/*     */   }
/*     */ 
/*     */   public void dailyEndAfterBackup(String currentTradeDay)
/*     */   {
/*  84 */     if (this.log.isInfoEnabled()) {
/*  85 */       this.log.info("start dailyEndAfterBackup:" + new Date());
/*     */     }
/*  87 */     Map map = new HashMap();
/*  88 */     map.put("tradeDay", currentTradeDay);
/*  89 */     map.put("resultFlag", "");
/*  90 */     map.put("resultMsg", "");
/*  91 */     this.dailyEndProcess.dailyEndAfterBackup(map);
/*     */ 
/*  93 */     if (this.log.isInfoEnabled())
/*  94 */       this.log.info("end dailyEndAfterBackup:" + new Date());
/*     */   }
/*     */ 
/*     */   public void initChangeTransDay()
/*     */   {
/* 103 */     if (this.log.isInfoEnabled()) {
/* 104 */       this.log.info("start initChangeTransDay:" + new Date());
/*     */     }
/*     */ 
/* 107 */     Cache.coreBeforeTradingDay = Cache.coreCurrentTradingDay;
/* 108 */     Cache.coreCurrentTradingDay = Cache.coreNextTradingDay;
/* 109 */     Cache.coreNextTradingDay = DateUtil.getDateFormat(DateUtils.addDays(new Date(), 1), "yyyyMMdd");
/*     */ 
/* 111 */     if (this.log.isInfoEnabled())
/* 112 */       this.log.info("end initChangeTransDay:" + new Date());
/*     */   }
/*     */ 
/*     */   public void initTradeDay()
/*     */   {
/* 120 */     if (this.log.isInfoEnabled()) {
/* 121 */       this.log.info("start init tradeday:" + new Date());
/*     */     }
/* 123 */     TradeDayCurrent tradeDayCurrent = this.tradeDayCurrentDAO.getTradeDayCurrent();
/* 124 */     Cache.coreBeforeTradingDay = tradeDayCurrent.getLastTradeDayStr();
/* 125 */     Cache.coreCurrentTradingDay = tradeDayCurrent.getCurrentTradeDayStr();
/* 126 */     Cache.coreNextTradingDay = tradeDayCurrent.getNextTradeDayStr();
/*     */ 
/* 128 */     if (this.log.isInfoEnabled())
/* 129 */       this.log.info("end init tradeday:" + new Date());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.manager.pojo.DailyWorkEngine
 * JD-Core Version:    0.6.0
 */