/*     */ package com.hundsun.network.gates.fengshan.web.util;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTradeBO;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TradeMoneyUtil
/*     */ {
/*     */   public static void convert2Cent(ProjectListing projectListing, ProjectTradeBO tradeBo)
/*     */   {
/*  37 */     if (!EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType()))
/*     */     {
/*  39 */       if (EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  40 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/*  41 */         if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/*  42 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/*  43 */             if (("bidStartPrice".equals(tradeShowDTO.getKey())) && 
/*  44 */               (StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) {
/*  45 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  46 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(
/*  47 */                 projectListing.getValuationUnit()).getScale());
/*  48 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*  50 */             if (("reservePrice".equals(tradeShowDTO.getKey())) && 
/*  51 */               (StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) {
/*  52 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  53 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(
/*  54 */                 projectListing.getValuationUnit()).getScale());
/*  55 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*  57 */             if ((!"bidRate".equals(tradeShowDTO.getKey())) || 
/*  58 */               (!StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) continue;
/*  59 */             BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  60 */             bg = bg.movePointRight(EnumValuationUnit.indexByValue(
/*  61 */               projectListing.getValuationUnit()).getScale());
/*  62 */             tradeShowDTO.setInputValue(bg.toString());
/*     */           }
/*     */         }
/*     */       }
/*  66 */       else if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(
/*  67 */         projectListing.getTradingType())) {
/*  68 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/*  69 */         if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/*  70 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/*  71 */             if (("bidStartPrice".equals(tradeShowDTO.getKey())) && 
/*  72 */               (StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) {
/*  73 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  74 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(
/*  75 */                 projectListing.getValuationUnit()).getScale());
/*  76 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*  78 */             if (("reservePrice".equals(tradeShowDTO.getKey())) && 
/*  79 */               (StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) {
/*  80 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  81 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(
/*  82 */                 projectListing.getValuationUnit()).getScale());
/*  83 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*  85 */             if ((!"bidRate".equals(tradeShowDTO.getKey())) || 
/*  86 */               (!StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) continue;
/*  87 */             BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  88 */             bg = bg.movePointRight(EnumValuationUnit.indexByValue(
/*  89 */               projectListing.getValuationUnit()).getScale());
/*  90 */             tradeShowDTO.setInputValue(bg.toString());
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*  95 */       else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  96 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/*  97 */         if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/*  98 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/*  99 */             if ((!"startPrice".equals(tradeShowDTO.getKey())) || 
/* 100 */               (!StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) continue;
/* 101 */             BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/* 102 */             bg = bg.movePointRight(EnumValuationUnit.indexByValue(
/* 103 */               projectListing.getValuationUnit()).getScale());
/* 104 */             tradeShowDTO.setInputValue(bg.toString());
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/* 109 */       else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 110 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/* 111 */         if ((tradeMetas != null) && (tradeMetas.size() > 0))
/* 112 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 113 */             if ((!"evaluation".equals(tradeShowDTO.getKey())) || 
/* 114 */               (!StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) continue;
/* 115 */             BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/* 116 */             bg = bg.movePointRight(EnumValuationUnit.indexByValue(
/* 117 */               projectListing.getValuationUnit()).getScale());
/* 118 */             tradeShowDTO.setInputValue(bg.toString());
/*     */           }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void conver2ValueUnit(ProjectListing projectListing, ProjectTradeBO tradeBo)
/*     */   {
/* 132 */     if (!EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType()))
/*     */     {
/* 134 */       if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || 
/* 135 */         (EnumTradingType.MULIT_BID_ORDER.getValue().equals(
/* 136 */         projectListing.getTradingType()))) {
/* 137 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/* 138 */         if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 139 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 140 */             if (("bidStartPrice".equals(tradeShowDTO.getKey())) && 
/* 141 */               (StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) {
/* 142 */               tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(
/* 143 */                 Long.valueOf(tradeShowDTO.getInputValue()), projectListing
/* 144 */                 .getValuationUnit()));
/*     */             }
/* 146 */             if (("reservePrice".equals(tradeShowDTO.getKey())) && 
/* 147 */               (StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) {
/* 148 */               tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(
/* 149 */                 Long.valueOf(tradeShowDTO.getInputValue()), projectListing
/* 150 */                 .getValuationUnit()));
/*     */             }
/* 152 */             if ((!"bidRate".equals(tradeShowDTO.getKey())) || 
/* 153 */               (!StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) continue;
/* 154 */             tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(
/* 155 */               Long.valueOf(tradeShowDTO.getInputValue()), projectListing
/* 156 */               .getValuationUnit()));
/*     */           }
/*     */         }
/*     */       }
/* 160 */       else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 161 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/* 162 */         if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 163 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 164 */             if ((!"startPrice".equals(tradeShowDTO.getKey())) || 
/* 165 */               (!StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) continue;
/* 166 */             tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(
/* 167 */               Long.valueOf(tradeShowDTO.getInputValue()), projectListing
/* 168 */               .getValuationUnit()));
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/* 174 */       else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 175 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/* 176 */         if ((tradeMetas != null) && (tradeMetas.size() > 0))
/* 177 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 178 */             if ((!"evaluation".equals(tradeShowDTO.getKey())) || 
/* 179 */               (!StringUtil.isNotEmpty(tradeShowDTO.getInputValue()))) continue;
/* 180 */             tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(
/* 181 */               Long.valueOf(tradeShowDTO.getInputValue()), projectListing
/* 182 */               .getValuationUnit()));
/*     */           }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void conver2ValueUnit(ProjectListing projectListing)
/*     */   {
/* 196 */     if (!EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType()))
/*     */     {
/* 198 */       if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || 
/* 199 */         (EnumTradingType.MULIT_BID_ORDER.getValue().equals(
/* 200 */         projectListing.getTradingType()))) {
/* 201 */         List<AttriMeta> tradeMetaList = projectListing.getTradeMeta();
/* 202 */         if ((tradeMetaList != null) && (tradeMetaList.size() > 0)) {
/* 203 */           for (AttriMeta attriMeta : tradeMetaList) {
/* 204 */             if (("bidStartPrice".equals(attriMeta.getMeta().getMetaKey())) && 
/* 205 */               (StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue()))) {
/* 206 */               attriMeta.getMeta().setMetaValue(
/* 207 */                 CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta()
/* 208 */                 .getMetaValue()), projectListing.getValuationUnit()));
/*     */             }
/* 210 */             if (("reservePrice".equals(attriMeta.getMeta().getMetaKey())) && 
/* 211 */               (StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue()))) {
/* 212 */               attriMeta.getMeta().setMetaValue(
/* 213 */                 CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta()
/* 214 */                 .getMetaValue()), projectListing.getValuationUnit()));
/*     */             }
/* 216 */             if ((!"bidRate".equals(attriMeta.getMeta().getMetaKey())) || 
/* 217 */               (!StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue()))) continue;
/* 218 */             attriMeta.getMeta().setMetaValue(
/* 219 */               CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta()
/* 220 */               .getMetaValue()), projectListing.getValuationUnit()));
/*     */           }
/*     */         }
/*     */       }
/* 224 */       else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 225 */         List<AttriMeta> tradeMetaList = projectListing.getTradeMeta();
/* 226 */         if ((tradeMetaList != null) && (tradeMetaList.size() > 0)) {
/* 227 */           for (AttriMeta attriMeta : tradeMetaList) {
/* 228 */             if ((!"startPrice".equals(attriMeta.getMeta().getMetaKey())) || 
/* 229 */               (!StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue()))) continue;
/* 230 */             attriMeta.getMeta().setMetaValue(
/* 232 */               CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta()
/* 232 */               .getMetaValue()), projectListing.getValuationUnit()) + 
/* 233 */               EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getName());
/*     */           }
/*     */         }
/*     */       }
/* 237 */       else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 238 */         List<AttriMeta> tradeMetaList = projectListing.getTradeMeta();
/* 239 */         if ((tradeMetaList != null) && (tradeMetaList.size() > 0))
/* 240 */           for (AttriMeta attriMeta : tradeMetaList) {
/* 241 */             if ((!"evaluation".equals(attriMeta.getMeta().getMetaKey())) || 
/* 242 */               (!StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue()))) continue;
/* 243 */             attriMeta.getMeta().setMetaValue(
/* 245 */               CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta()
/* 245 */               .getMetaValue()), projectListing.getValuationUnit()) + 
/* 246 */               EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getName());
/*     */           }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static Long getCentByValueUnit(String money, String valueUnit)
/*     */   {
/* 260 */     BigDecimal bg = new BigDecimal(money);
/* 261 */     if ((StringUtil.isNotEmpty(money)) && (StringUtil.isNotEmpty(valueUnit))) {
/* 262 */       bg = bg.movePointRight(EnumValuationUnit.indexByValue(valueUnit).getScale());
/*     */     }
/* 264 */     return Long.valueOf(bg.longValue());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.util.TradeMoneyUtil
 * JD-Core Version:    0.6.0
 */