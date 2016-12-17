/*     */ package com.hundsun.network.gates.qingbo.biz;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.PhaseDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectPoundageDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectTradeDTO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public abstract class GlobalMemoryDB
/*     */ {
/*  29 */   protected static GlobalMemoryDB instance = new GlobalMemoryQueryEngine();
/*     */ 
/*  34 */   protected static Integer marketStatus = Integer.valueOf(1);
/*     */ 
/*  39 */   protected static Date currentDay = new Date();
/*     */ 
/*  44 */   protected static String currentDayStr = "";
/*     */ 
/*  49 */   protected static List<PhaseDTO> phaseDTO = new ArrayList();
/*     */   protected static Integer time;
/*  59 */   protected static List<ProjectTradeDTO> projectTradeList = new ArrayList();
/*     */ 
/*  63 */   protected static List<BaseTradeDTO> baseTradeList = new ArrayList();
/*     */ 
/*  67 */   protected static Map<String, BaseTradeDTO> baseTrades = new HashMap();
/*     */ 
/*  71 */   protected static List<ProjectPoundageDTO> projectPoundageList = new ArrayList();
/*     */ 
/*  86 */   protected static List<ProjectDTO> projectList = new ArrayList();
/*     */ 
/* 106 */   protected static Map<String, Long> goodsSettlementPriceSafeMap = new HashMap();
/*     */ 
/* 108 */   protected static Map<String, Long> goodsTopPriceMap = new HashMap();
/*     */ 
/* 110 */   protected static Map<String, Long> goodsLowPriceMap = new HashMap();
/*     */ 
/* 112 */   protected static Map<String, Long> quotationSeqMap = new HashMap();
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.GlobalMemoryDB
 * JD-Core Version:    0.6.0
 */