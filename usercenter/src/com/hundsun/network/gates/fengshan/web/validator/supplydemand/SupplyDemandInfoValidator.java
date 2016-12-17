/*    */ package com.hundsun.network.gates.fengshan.web.validator.supplydemand;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfo;
/*    */ import com.hundsun.network.gates.fengshan.web.util.FileUploadUtil;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*    */ import com.hundsun.network.gates.luosi.common.utils.FormatValidate;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class SupplyDemandInfoValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 20 */     super.validate(obj, errors);
/* 21 */     SupplyDemandInfo supplyDemandInfo = (SupplyDemandInfo)obj;
/*    */ 
/* 23 */     Long maxPrice = Long.valueOf(99999999999999999L);
/* 24 */     EnumValuationUnit valuationUnit = EnumValuationUnit.indexByValue(supplyDemandInfo.getValuationUnit());
/*    */ 
/* 26 */     Date effectiveStartDate = supplyDemandInfo.getEffectiveStartDate();
/* 27 */     Date effectiveEndDate = supplyDemandInfo.getEffectiveEndDate();
/*    */ 
/* 29 */     String priceDesc = supplyDemandInfo.getPriceDesc();
/* 30 */     if (StringUtil.isNotEmpty(priceDesc)) {
/* 31 */       if ((!FormatValidate.isValidFloat(priceDesc)) && (!FormatValidate.isValidInteger(priceDesc)))
/*    */       {
/* 33 */         errors.rejectValue("price", null, null, "请输入正确的价格!");
/*    */       }
/* 35 */       BigDecimal gb = new BigDecimal(priceDesc);
/* 36 */       Long listingPriceConvert2Fen = Long.valueOf(0L);
/* 37 */       listingPriceConvert2Fen = Long.valueOf(gb.movePointRight(valuationUnit.getScale()).longValue());
/* 38 */       if (listingPriceConvert2Fen.longValue() > maxPrice.longValue()) {
/* 39 */         errors.rejectValue("price", null, null, "价格不能超过9999999" + EnumValuationUnit.YIYUAN.getName());
/*    */       }
/*    */     }
/*    */ 
/* 43 */     if (!effectiveEndDate.after(effectiveStartDate)) {
/* 44 */       errors.rejectValue("effectiveEndDate", null, null, "截止时间 要晚于开始时间");
/*    */     }
/* 46 */     if (!effectiveEndDate.after(new Date())) {
/* 47 */       errors.rejectValue("effectiveEndDate", null, null, "截止时间 要晚于当前时间");
/*    */     }
/* 49 */     if (StringUtil.isEmpty(supplyDemandInfo.getInvoice())) {
/* 50 */       errors.rejectValue("invoice", null, null, "发票支持不能为空");
/*    */     }
/* 52 */     if (StringUtil.isEmpty(supplyDemandInfo.getDeliveryType()))
/* 53 */       errors.rejectValue("deliveryType", null, null, "交易方式不能为空");
/*    */   }
/*    */ 
/*    */   public void validatePictures(MultipartFile file, String fileId, Errors errors)
/*    */   {
/* 58 */     if ((null != file) && (!file.isEmpty()) && (file.getSize() > 0L)) {
/* 59 */       FileUploadUtil.MAX_FILE_SIZE = 204800;
/* 60 */       if (!FileUploadUtil.ifExtendNamePermitted(file)) {
/* 61 */         errors.rejectValue(fileId, null, null, "仅仅支持jpg,jpeg,gif,png的图片上传！");
/*    */       }
/* 63 */       if (!FileUploadUtil.ifFileSizePermitted(file))
/* 64 */         errors.rejectValue(fileId, null, null, "上传的图片最大不超过200K！");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.validator.supplydemand.SupplyDemandInfoValidator
 * JD-Core Version:    0.6.0
 */