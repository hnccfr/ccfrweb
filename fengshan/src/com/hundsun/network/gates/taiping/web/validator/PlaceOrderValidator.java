/*    */ package com.hundsun.network.gates.taiping.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.taiping.biz.domain.placeorder.PlaceOrderInput;
/*    */ import com.hundsun.network.gates.taiping.web.util.PatternCommon;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class PlaceOrderValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 14 */     if (!(obj instanceof PlaceOrderInput)) {
/* 15 */       return;
/*    */     }
/* 17 */     super.validate(obj, errors);
/*    */ 
/* 19 */     PlaceOrderInput placeOrderInput = (PlaceOrderInput)obj;
/* 20 */     if ((null == placeOrderInput.getProjectCode()) || (placeOrderInput.getProjectCode().equals(""))) {
/* 21 */       errors.rejectValue("projectCode", "common.error.required", null, null);
/*    */     }
/*    */ 
/* 24 */     if ((null == placeOrderInput.getUserAccount()) || (placeOrderInput.getUserAccount().equals(""))) {
/* 25 */       errors.rejectValue("userAccount", "common.error.required", null, null);
/*    */     }
/*    */ 
/* 28 */     if ((null == placeOrderInput.getListingPrice()) || (placeOrderInput.getListingPrice().equals("")))
/*    */     {
/* 30 */       errors.rejectValue("listingPrice", "common.error.required", null, null);
/*    */     }
/*    */ 
/* 33 */     if ((null == placeOrderInput.getQuantity()) || (placeOrderInput.getQuantity().equals(""))) {
/* 34 */       errors.rejectValue("quantity", "common.error.required", null, null);
/*    */     }
/* 36 */     if (!PatternCommon.isDigit(placeOrderInput.getQuantity().toString())) {
/* 37 */       errors.rejectValue("quantity", "common.error.digits", null, null);
/*    */     }
/* 39 */     if ((null == placeOrderInput.getAddress()) || ("".equals(placeOrderInput.getAddress()))) {
/* 40 */       errors.rejectValue("deliveryPlace", "common.error.required", null, null);
/*    */     }
/* 42 */     if ((null == placeOrderInput.getDeliveryType()) || (placeOrderInput.getDeliveryType().equals("")))
/*    */     {
/* 44 */       errors.rejectValue("deliveryType", "common.error.required", null, null);
/*    */     }
/*    */ 
/* 47 */     if ((null == placeOrderInput.getPaymentType()) || (placeOrderInput.getPaymentType().equals(""))) {
/* 48 */       errors.rejectValue("paymentType", "common.error.required", null, null);
/*    */     }
/*    */ 
/* 51 */     if ((null == placeOrderInput.getInvoice()) || (placeOrderInput.getInvoice().equals("")))
/* 52 */       errors.rejectValue("invoice", "common.error.required", null, null);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.web.validator.PlaceOrderValidator
 * JD-Core Version:    0.6.0
 */