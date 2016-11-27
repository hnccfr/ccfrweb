/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.webservice;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeWishOrderDTO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderAndPro;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.AnnouncementQuery;
/*     */ import com.hundsun.network.gates.wulin.biz.service.operation.AnnouncementService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.trade.TradeWishOrderService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.webservice.RemoteProvideService;
/*     */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteProvideService")
/*     */ public class RemoteProvideServiceImpl
/*     */   implements RemoteProvideService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderService tradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private AnnouncementService announcementService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderService tradeWishOrderService;
/*     */ 
/*     */   private String getProjectTypeCodeByNo(String proTypeNo)
/*     */   {
/*  54 */     String projectTypeCode = null;
/*  55 */     if ("1".equals(proTypeNo)) projectTypeCode = "0|1";
/*  56 */     else if ("2".equals(proTypeNo)) projectTypeCode = "0|2";
/*  57 */     else if ("3".equals(proTypeNo)) projectTypeCode = "0|3";
/*  58 */     else if ("4".equals(proTypeNo)) projectTypeCode = "0|4";
/*  59 */     return projectTypeCode;
/*     */   }
/*     */ 
/*     */   public List<AnnouncementDTO> getAnnoumcement(String counts)
/*     */   {
/*  69 */     if (StringUtil.isEmpty(counts)) {
/*  70 */       return null;
/*     */     }
/*  72 */     Integer cout = Integer.valueOf(Integer.parseInt(counts));
/*     */ 
/*  74 */     AnnouncementQuery<Announcement> page = new AnnouncementQuery();
/*  75 */     if (cout.intValue() >= 0)
/*  76 */       page.setPageSize(cout.intValue());
/*  77 */     this.announcementService.paginated(page);
/*  78 */     List result = new ArrayList();
/*  79 */     for (Announcement announcement : page.getData()) {
/*  80 */       result.add(ConvertUtils.convert2AnnouncementDTO(announcement));
/*     */     }
/*  82 */     return result;
/*     */   }
/*     */ 
/*     */   public List<TradeOrderDTO> getTradeOrder(String counts, String proTypeNo)
/*     */   {
/*  95 */     if (StringUtil.isEmpty(counts)) {
/*  96 */       return null;
/*     */     }
/*  98 */     Integer cout = Integer.valueOf(Integer.parseInt(counts));
/*  99 */     String projectTypeCode = getProjectTypeCodeByNo(proTypeNo);
/* 100 */     List<TradeOrderAndPro> tradeOrderAndProList = this.tradeOrderService.selectLatestOrder(cout.intValue(), projectTypeCode);
/* 101 */     List result = new ArrayList();
/* 102 */     for (TradeOrderAndPro tradeOrderAndPro : tradeOrderAndProList) {
/* 103 */       TradeOrderDTO tradeOrderDTO = ConvertUtils.convertTradeOrderAndPro2TradeOrderDTO(tradeOrderAndPro);
/* 104 */       tradeOrderDTO.setBidPriceDesc(convertPrice(tradeOrderDTO.getBidPrice(), EnumValuationUnit.indexByValue(tradeOrderDTO.getValuationUnit())));
/* 105 */       tradeOrderDTO.setValuationUnitDesc(EnumValuationUnit.indexByValue(tradeOrderDTO.getValuationUnit()).getName());
/* 106 */       EnumMeasureUnit measureUnitDesc = EnumMeasureUnit.indexByValue(tradeOrderDTO.getMeasureUnit());
/* 107 */       if (measureUnitDesc != null)
/* 108 */         tradeOrderDTO.setMeasureUnitDesc(measureUnitDesc.getName());
/* 109 */       tradeOrderDTO.setGmtCreateDesc(DateUtil.convertDateToString(tradeOrderDTO.getGmtCreate()));
/* 110 */       result.add(tradeOrderDTO);
/*     */     }
/* 112 */     return result;
/*     */   }
/*     */ 
/*     */   public List<ProjectListingDTO> getProjectListing(String counts, String proTypeNo)
/*     */   {
/* 123 */     if ((StringUtil.isEmpty(counts)) || (StringUtil.isEmpty(proTypeNo))) {
/* 124 */       return null;
/*     */     }
/* 126 */     Integer cout = Integer.valueOf(Integer.parseInt(counts));
/* 127 */     String projectTypeCode = getProjectTypeCodeByNo(proTypeNo);
/*     */ 
/* 129 */     List<ProjectListingDTO> projectListingDTOList = this.projectListingService.selectLatestProjectListing(cout.intValue(), projectTypeCode);
/* 130 */     for (ProjectListingDTO projectListingDTO : projectListingDTOList) {
/* 131 */       convertDTO2View(projectListingDTO);
/*     */     }
/* 133 */     return projectListingDTOList;
/*     */   }
/*     */ 
/*     */   private void convertDTO2View(ProjectListingDTO projectListingDTO) {
/* 137 */     projectListingDTO.setListingTypeDesc(EnumListingType.indexByValue(projectListingDTO.getListingType()).getName());
/* 138 */     projectListingDTO.setValuationUnitDesc(EnumValuationUnit.indexByValue(projectListingDTO.getValuationUnit()).getName());
/* 139 */     projectListingDTO.setMeasureUnitDesc(EnumMeasureUnit.indexByValue(projectListingDTO.getMeasureUnit()).getName());
/* 140 */     projectListingDTO.setDeliveryDateDesc(DateUtil.convertDateToString(projectListingDTO.getDeliveryDate()));
/* 141 */     projectListingDTO.setListingPriceDesc(convertPrice(projectListingDTO.getListingPrice(), EnumValuationUnit.indexByValue(projectListingDTO.getValuationUnit())));
/*     */   }
/*     */ 
/*     */   private String convertPrice(Long longPrice, EnumValuationUnit valuationUnit)
/*     */   {
/* 146 */     if ((longPrice == null) || (valuationUnit == null)) return null;
/* 147 */     Double price = Double.valueOf(longPrice.longValue());
/* 148 */     price = Double.valueOf(price.doubleValue() / valuationUnit.getRate().longValue());
/* 149 */     return price.toString();
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrderDTO> getTradeWishOrder(String counts) {
/* 153 */     if (StringUtil.isEmpty(counts)) {
/* 154 */       return null;
/*     */     }
/* 156 */     Integer cout = Integer.valueOf(Integer.parseInt(counts));
/* 157 */     return this.tradeWishOrderService.selectLatestTradeWishOrder(cout.intValue());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.webservice.RemoteProvideServiceImpl
 * JD-Core Version:    0.6.0
 */