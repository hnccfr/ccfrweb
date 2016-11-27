/*     */ package com.hundsun.network.gates.genshan.web.util;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTradeBO;
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
/*  43 */             if (("bidStartPrice".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/*  45 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  46 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale());
/*     */ 
/*  48 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*  50 */             if (("reservePrice".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/*  52 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  53 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale());
/*     */ 
/*  55 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*  57 */             if (("bidRate".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/*  59 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  60 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale());
/*     */ 
/*  62 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*  67 */       else if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType()))
/*     */       {
/*  69 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/*  70 */         if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/*  71 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/*  72 */             if (("bidStartPrice".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/*  74 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  75 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale());
/*     */ 
/*  77 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*  79 */             if (("reservePrice".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/*  81 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  82 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale());
/*     */ 
/*  84 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*  86 */             if (("bidRate".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/*  88 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/*  89 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale());
/*     */ 
/*  91 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*  96 */       else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  97 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/*  98 */         if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/*  99 */           for (TradeShowDTO tradeShowDTO : tradeMetas)
/* 100 */             if (("startPrice".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/* 102 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/* 103 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale());
/*     */ 
/* 105 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*     */         }
/*     */       }
/* 109 */       else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 110 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/* 111 */         if ((tradeMetas != null) && (tradeMetas.size() > 0))
/* 112 */           for (TradeShowDTO tradeShowDTO : tradeMetas)
/* 113 */             if (("evaluation".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/* 115 */               BigDecimal bg = new BigDecimal(tradeShowDTO.getInputValue());
/* 116 */               bg = bg.movePointRight(EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale());
/*     */ 
/* 118 */               tradeShowDTO.setInputValue(bg.toString());
/*     */             }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void conver2ValueUnit(ProjectListing projectListing, ProjectTradeBO tradeBo)
/*     */   {
/* 131 */     if (!EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType()))
/*     */     {
/* 133 */       if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*     */       {
/* 136 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/* 137 */         if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 138 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 139 */             if (("bidStartPrice".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/* 141 */               tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(Long.valueOf(tradeShowDTO.getInputValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */ 
/* 145 */             if (("reservePrice".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/* 147 */               tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(Long.valueOf(tradeShowDTO.getInputValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */ 
/* 151 */             if (("bidRate".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/* 153 */               tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(Long.valueOf(tradeShowDTO.getInputValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/* 159 */       else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 160 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/* 161 */         if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 162 */           for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 163 */             if (("startPrice".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/* 165 */               tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(Long.valueOf(tradeShowDTO.getInputValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/* 171 */       else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 172 */         List<TradeShowDTO> tradeMetas = tradeBo.getTradeMetas();
/* 173 */         if ((tradeMetas != null) && (tradeMetas.size() > 0))
/* 174 */           for (TradeShowDTO tradeShowDTO : tradeMetas)
/* 175 */             if (("evaluation".equals(tradeShowDTO.getKey())) && (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())))
/*     */             {
/* 177 */               tradeShowDTO.setInputValue(CommonUtils.getValuationUnit(Long.valueOf(tradeShowDTO.getInputValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void conver2ValueUnit(ProjectListing projectListing)
/*     */   {
/* 192 */     if (!EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType()))
/*     */     {
/* 194 */       if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*     */       {
/* 197 */         List<AttriMeta> tradeMetaList = projectListing.getTradeMeta();
/* 198 */         if ((tradeMetaList != null) && (tradeMetaList.size() > 0)) {
/* 199 */           for (AttriMeta attriMeta : tradeMetaList) {
/* 200 */             if (("bidStartPrice".equals(attriMeta.getMeta().getMetaKey())) && (StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue())))
/*     */             {
/* 202 */               attriMeta.getMeta().setMetaValue(CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta().getMetaValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */ 
/* 206 */             if (("reservePrice".equals(attriMeta.getMeta().getMetaKey())) && (StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue())))
/*     */             {
/* 208 */               attriMeta.getMeta().setMetaValue(CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta().getMetaValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */ 
/* 212 */             if (("bidRate".equals(attriMeta.getMeta().getMetaKey())) && (StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue())))
/*     */             {
/* 214 */               attriMeta.getMeta().setMetaValue(CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta().getMetaValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/* 220 */       else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 221 */         List<AttriMeta> tradeMetaList = projectListing.getTradeMeta();
/* 222 */         if ((tradeMetaList != null) && (tradeMetaList.size() > 0)) {
/* 223 */           for (AttriMeta attriMeta : tradeMetaList) {
/* 224 */             if (("startPrice".equals(attriMeta.getMeta().getMetaKey())) && (StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue())))
/*     */             {
/* 226 */               attriMeta.getMeta().setMetaValue(CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta().getMetaValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/* 232 */       else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 233 */         List<AttriMeta> tradeMetaList = projectListing.getTradeMeta();
/* 234 */         if ((tradeMetaList != null) && (tradeMetaList.size() > 0))
/* 235 */           for (AttriMeta attriMeta : tradeMetaList)
/* 236 */             if (("evaluation".equals(attriMeta.getMeta().getMetaKey())) && (StringUtil.isNotEmpty(attriMeta.getMeta().getMetaValue())))
/*     */             {
/* 238 */               attriMeta.getMeta().setMetaValue(CommonUtils.getValuationUnit(Long.valueOf(attriMeta.getMeta().getMetaValue()), projectListing.getValuationUnit()));
/*     */             }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public static Long getCentByValueUnit(String money, String valueUnit)
/*     */   {
/* 254 */     BigDecimal bg = new BigDecimal(money);
/* 255 */     if ((StringUtil.isNotEmpty(money)) && (StringUtil.isNotEmpty(valueUnit))) {
/* 256 */       bg = bg.movePointRight(EnumValuationUnit.indexByValue(valueUnit).getScale());
/*     */     }
/* 258 */     return Long.valueOf(bg.longValue());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.util.TradeMoneyUtil
 * JD-Core Version:    0.6.0
 */