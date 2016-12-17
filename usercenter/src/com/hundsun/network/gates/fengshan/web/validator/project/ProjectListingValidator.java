/*     */ package com.hundsun.network.gates.fengshan.web.validator.project;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetasBO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTradeBO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectTypeService;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.PackageTradeData;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.SelectValueDTO;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.util.Assert;
/*     */ import org.springframework.validation.Errors;
/*     */ import org.springmodules.validation.valang.ValangValidator;
/*     */ 
/*     */ public class ProjectListingValidator extends ValangValidator
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectTypeService projectTypeService;
/*     */ 
/*     */   public void validate(Object obj, Errors errors)
/*     */   {
/*  40 */     super.validate(obj, errors);
/*  41 */     ProjectListing pl = (ProjectListing)obj;
/*     */ 
/*  43 */     if (StringUtil.isEmpty(pl.getProjectTypeCode()))
/*     */     {
/*  45 */       errors.rejectValue("projectTypeName", "common.error.required", null, "项目类型为空");
/*     */     }
/*  47 */     if (StringUtil.isEmpty(pl.getTitle())) {
/*  48 */       errors.rejectValue("title", "common.error.required", null, "项目挂牌名称为空");
/*     */     }
/*  50 */     if (StringUtil.isEmpty(pl.getTradingType())) {
/*  51 */       errors.rejectValue("tradingType", "common.error.required", null, "交易方式为空");
/*     */     }
/*  53 */     if (StringUtil.isEmpty(pl.getPaymentType())) {
/*  54 */       errors.rejectValue("paymentType", "common.error.required", null, "货款支付为空");
/*     */     }
/*  56 */     if (StringUtil.isEmpty(pl.getDeliveryType())) {
/*  57 */       errors.rejectValue("deliveryType", "common.error.required", null, "交货方式为空");
/*     */     }
/*  59 */     if (StringUtil.isEmpty(pl.getInvoice())) {
/*  60 */       errors.rejectValue("invoice", "common.error.required", null, "发票为空");
/*     */     }
/*  62 */     if (StringUtil.isEmpty(pl.getAddress()))
/*  63 */       errors.rejectValue("address", "common.error.required", null, "详细地址为空");
/*     */   }
/*     */ 
/*     */   public boolean projecTypeMetaValidate(Object obj, String projectTypeCode)
/*     */   {
/*  69 */     boolean typeMetaResult = true;
/*  70 */     Assert.notNull(obj);
/*  71 */     Assert.isInstanceOf(ProjectMetasBO.class, obj);
/*     */ 
/*  73 */     List<ProjectTypeAttri> list = this.projectTypeService.queryProjectTypeAttri(projectTypeCode);
/*     */ 
/*  75 */     ProjectMetasBO projectMeta = (ProjectMetasBO)obj;
/*  76 */     List<ProjectMetas> metas = projectMeta.getMetaValues();
/*  77 */     for (ProjectMetas meta : metas) {
/*  78 */       if ((null != meta) && (null != meta.getMetaValue()) && (!meta.getMetaValue().equals("")))
/*     */       {
/*  80 */         for (ProjectTypeAttri prjTypeAttri : list) {
/*  81 */           if (prjTypeAttri.getInputType().equals(meta.getInputType())) {
/*  82 */             String reg = prjTypeAttri.getValueValidate();
/*  83 */             if ((meta != null) && (meta.getMetaValue() != null) && (reg != null) && (!meta.getMetaValue().matches(reg)))
/*     */             {
/*  85 */               typeMetaResult = false;
/*  86 */               break;
/*     */             }
/*     */           }
/*     */         }
/*  90 */         if (!typeMetaResult) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*  95 */     return typeMetaResult;
/*     */   }
/*     */ 
/*     */   public boolean tradeMetaValidate(Object obj, Errors errors)
/*     */   {
/* 100 */     Assert.notNull(obj);
/* 101 */     Assert.isInstanceOf(ProjectTradeBO.class, obj);
/* 102 */     List<TradeShowDTO> list = PackageTradeData.getPlaceOrderShowDTO(null);
/* 103 */     ProjectTradeBO tradeMeta = (ProjectTradeBO)obj;
/* 104 */     List metas = tradeMeta.getTradeMetas();
/*     */ 
/* 106 */     for (Iterator i$ = metas.iterator(); i$.hasNext(); ) { TradeShowDTO meta = (TradeShowDTO)i$.next();
/*     */ 
/* 108 */       if ((null == meta.getInputValue()) || (meta.getInputValue().equals(""))) {
/* 109 */         return false;
/*     */       }
/*     */ 
/* 112 */       for (TradeShowDTO tDTO : list)
/*     */       {
/* 115 */         if (tDTO.getKey().equals(meta.getKey())) {
/* 116 */           String type = tDTO.getType();
/* 117 */           String inputValue = meta.getInputValue();
/* 118 */           if (type.toLowerCase().equals("varchar"))
/*     */           {
/* 120 */             if ((inputValue != null) && (tDTO != null) && (tDTO.getLength() != null) && (inputValue.length() > tDTO.getLength().intValue()))
/*     */             {
/* 122 */               return false;
/*     */             }
/* 124 */           } else if (type.toLowerCase().equals("integer"))
/*     */           {
/* 126 */             if (inputValue.length() > tDTO.getLength().intValue()) {
/* 127 */               return false;
/*     */             }
/* 129 */             if (!inputValue.matches("^[0-9]*$")) {
/* 130 */               return false;
/*     */             }
/* 132 */             if ((Integer.valueOf(inputValue).intValue() > 2147483647) || (Integer.valueOf(inputValue).intValue() < 0))
/*     */             {
/* 134 */               return false;
/*     */             }
/*     */           }
/* 137 */           else if (type.toLowerCase().equals("number"))
/*     */           {
/* 140 */             if (inputValue.length() > tDTO.getLength().intValue()) {
/* 141 */               return false;
/*     */             }
/* 143 */             if (!inputValue.matches("^[0-9]*$")) {
/* 144 */               return false;
/*     */             }
/* 146 */             if ((Integer.valueOf(inputValue).intValue() > 2147483647) || (Integer.valueOf(inputValue).intValue() < 0))
/*     */             {
/* 148 */               return false;
/*     */             }
/*     */           }
/* 151 */           else if (type.toLowerCase().equals("datetime"))
/*     */           {
/*     */             try {
/* 154 */               SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
/* 155 */               formater.parse(inputValue);
/*     */             }
/*     */             catch (Exception e) {
/* 158 */               return false;
/*     */             }
/*     */           }
/* 161 */           else if (type.toLowerCase().equals("char"))
/*     */           {
/* 164 */             List<SelectValueDTO> radioList = tDTO.getSelectValues();
/* 165 */             List keyList = new ArrayList();
/* 166 */             for (SelectValueDTO radio : radioList) {
/* 167 */               keyList.add(radio.getKey());
/*     */             }
/* 169 */             if (!keyList.contains(inputValue))
/* 170 */               return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     TradeShowDTO meta;
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean tradeMetaValidate(Object obj)
/*     */   {
/* 182 */     Assert.notNull(obj);
/* 183 */     Assert.isInstanceOf(ProjectTradeBO.class, obj);
/* 184 */     List<TradeShowDTO> list = PackageTradeData.getPlaceOrderShowDTO(null);
/* 185 */     ProjectTradeBO tradeMeta = (ProjectTradeBO)obj;
/* 186 */     List metas = tradeMeta.getTradeMetas();
/*     */ 
/* 188 */     for (Iterator i$ = metas.iterator(); i$.hasNext(); ) { TradeShowDTO meta = (TradeShowDTO)i$.next();
/*     */ 
/* 190 */       if ((null == meta.getInputValue()) || (meta.getInputValue().equals(""))) {
/* 191 */         return false;
/*     */       }
/*     */ 
/* 194 */       for (TradeShowDTO tDTO : list)
/*     */       {
/* 197 */         if (tDTO.getKey().equals(meta.getKey())) {
/* 198 */           String type = tDTO.getType();
/* 199 */           String inputValue = meta.getInputValue();
/* 200 */           if (type.toLowerCase().equals("varchar"))
/*     */           {
/* 202 */             if ((inputValue != null) && (tDTO != null) && (tDTO.getLength() != null) && (inputValue.length() > tDTO.getLength().intValue()))
/*     */             {
/* 204 */               return false;
/*     */             }
/* 206 */           } else if (type.toLowerCase().equals("integer"))
/*     */           {
/* 208 */             if (inputValue.length() > tDTO.getLength().intValue()) {
/* 209 */               return false;
/*     */             }
/* 211 */             if (!inputValue.matches("^[0-9]*$")) {
/* 212 */               return false;
/*     */             }
/* 214 */             if ((Integer.valueOf(inputValue).intValue() > 2147483647) || (Integer.valueOf(inputValue).intValue() < 0))
/*     */             {
/* 216 */               return false;
/*     */             }
/*     */           }
/* 219 */           else if (type.toLowerCase().equals("number"))
/*     */           {
/* 222 */             if (inputValue.length() > tDTO.getLength().intValue()) {
/* 223 */               return false;
/*     */             }
/* 225 */             if (!inputValue.matches("^[0-9]*$")) {
/* 226 */               return false;
/*     */             }
/* 228 */             if ((Integer.valueOf(inputValue).intValue() > 2147483647) || (Integer.valueOf(inputValue).intValue() < 0))
/*     */             {
/* 230 */               return false;
/*     */             }
/*     */           }
/* 233 */           else if (type.toLowerCase().equals("datetime"))
/*     */           {
/*     */             try {
/* 236 */               SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
/* 237 */               formater.parse(inputValue);
/*     */             } catch (Exception e) {
/* 239 */               return false;
/*     */             }
/*     */           }
/* 242 */           else if (type.toLowerCase().equals("char"))
/*     */           {
/* 245 */             List<SelectValueDTO> radioList = tDTO.getSelectValues();
/* 246 */             List keyList = new ArrayList();
/* 247 */             for (SelectValueDTO radio : radioList) {
/* 248 */               keyList.add(radio.getKey());
/*     */             }
/* 250 */             if (!keyList.contains(inputValue))
/* 251 */               return false;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     TradeShowDTO meta;
/* 258 */     return true;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.validator.project.ProjectListingValidator
 * JD-Core Version:    0.6.0
 */