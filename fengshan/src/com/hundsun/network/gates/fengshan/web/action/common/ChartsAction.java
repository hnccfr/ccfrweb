/*     */ package com.hundsun.network.gates.fengshan.web.action.common;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class ChartsAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderService tradeOrderService;
/*  30 */   protected final Log log = LogFactory.getLog(getClass());
/*     */ 
/*  32 */   private final Long DEFAULT_INTERVAL = Long.valueOf(7L);
/*     */ 
/*     */   @RequestMapping({"charts/day"})
/*     */   @ResponseBody
/*     */   public Map<String, List<DateStatistics>> queryStatisticsByDay(@RequestParam(value="interval", required=false) String interval, ModelMap model) {
/*  39 */     Long nInterval = this.DEFAULT_INTERVAL;
/*  40 */     if ((!StringUtil.isEmpty(interval)) && (StringUtil.isNumber(interval))) {
/*  41 */       nInterval = Long.valueOf(interval);
/*     */     }
/*  43 */     Map map = new HashMap();
/*  44 */     map.put("project", this.projectListingService.queryProjectListingByDate(EnumDateStatisticsType.DAY, nInterval));
/*     */ 
/*  46 */     map.put("order", this.tradeOrderService.queryProjectListingByDate(EnumDateStatisticsType.DAY, nInterval));
/*     */ 
/*  48 */     return map;
/*     */   }
/*     */ 
/*     */   @RequestMapping({"charts/month"})
/*     */   @ResponseBody
/*     */   public Map<String, List<DateStatistics>> queryStatisticsByMonth(@RequestParam(value="interval", required=false) String interval, ModelMap model) {
/*  56 */     Long nInterval = this.DEFAULT_INTERVAL;
/*  57 */     if ((!StringUtil.isEmpty(interval)) && (StringUtil.isNumber(interval))) {
/*  58 */       nInterval = Long.valueOf(interval);
/*     */     }
/*  60 */     Map map = new HashMap();
/*  61 */     map.put("project", this.projectListingService.queryProjectListingByDate(EnumDateStatisticsType.MONTH, nInterval));
/*     */ 
/*  63 */     map.put("order", this.tradeOrderService.queryProjectListingByDate(EnumDateStatisticsType.MONTH, nInterval));
/*     */ 
/*  65 */     return map;
/*     */   }
/*     */ 
/*     */   @RequestMapping({"charts/week"})
/*     */   @ResponseBody
/*     */   public Map<String, List<DateStatistics>> queryStatisticsByWeek(@RequestParam(value="interval", required=false) String interval, ModelMap model)
/*     */   {
/*  74 */     Long nInterval = this.DEFAULT_INTERVAL;
/*  75 */     if ((!StringUtil.isEmpty(interval)) && (StringUtil.isNumber(interval))) {
/*  76 */       nInterval = Long.valueOf(interval);
/*     */     }
/*  78 */     Map map = new HashMap();
/*  79 */     map.put("project", this.projectListingService.queryProjectListingByDate(EnumDateStatisticsType.WEEK, nInterval));
/*     */ 
/*  81 */     map.put("order", this.tradeOrderService.queryProjectListingByDate(EnumDateStatisticsType.WEEK, nInterval));
/*     */ 
/*  83 */     return map;
/*     */   }
/*     */ 
/*     */   @RequestMapping({"charts/year"})
/*     */   @ResponseBody
/*     */   public Map<String, List<DateStatistics>> queryStatisticsByYear(@RequestParam(value="interval", required=false) String interval, ModelMap model) {
/*  91 */     Long nInterval = this.DEFAULT_INTERVAL;
/*  92 */     if ((!StringUtil.isEmpty(interval)) && (StringUtil.isNumber(interval))) {
/*  93 */       nInterval = Long.valueOf(interval);
/*     */     }
/*  95 */     Map map = new HashMap();
/*  96 */     map.put("project", this.projectListingService.queryProjectListingByDate(EnumDateStatisticsType.YEAR, nInterval));
/*     */ 
/*  98 */     map.put("order", this.tradeOrderService.queryProjectListingByDate(EnumDateStatisticsType.YEAR, nInterval));
/*     */ 
/* 100 */     return map;
/*     */   }
/*     */   @RequestMapping({"charts/line"})
/*     */   public void line(@RequestParam(value="type", required=false) String type, ModelMap model) {
/* 105 */     if (StringUtil.isEmpty(type)) {
/* 106 */       type = "day";
/*     */     }
/* 108 */     if ((!type.equals("day")) && (!type.equals("week")) && (!type.equals("month")) && (!type.equals("year"))) {
/* 109 */       type = "day";
/*     */     }
/* 111 */     model.addAttribute("url", "charts/" + type + ".htm");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.common.ChartsAction
 * JD-Core Version:    0.6.0
 */