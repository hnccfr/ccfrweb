/*    */ package com.hundsun.network.gates.wangjiang.biz.util;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.BidOrderTradeDTO;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.PlaceOrderTradeDTO;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.BidOrderDTO;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.PlaceOrderDTO;
/*    */ 
/*    */ public class ConventUtil
/*    */ {
/*    */   public static BidOrderTradeDTO conventBidOrderDTO2BidOrderTradeDTO(BidOrderDTO bidOrderDTO)
/*    */   {
/* 11 */     return null;
/*    */   }
/*    */ 
/*    */   public static PlaceOrderTradeDTO conventPlaceOrderDTO2PlaceOrderTradeDTO(PlaceOrderDTO placeOrderDTO)
/*    */   {
/* 17 */     PlaceOrderTradeDTO placeOrderTradeDTO = new PlaceOrderTradeDTO();
/* 18 */     placeOrderTradeDTO.setProjectName(placeOrderDTO.getProjectName());
/* 19 */     placeOrderTradeDTO.setUserId(placeOrderDTO.getUserId());
/* 20 */     placeOrderTradeDTO.setMeasureUnit(placeOrderDTO.getMeasureUnit());
/* 21 */     placeOrderTradeDTO.setValuationUnit(placeOrderDTO.getValuationUnit());
/* 22 */     placeOrderTradeDTO.setDeliveryDate(placeOrderDTO.getDeliveryDate());
/* 23 */     placeOrderTradeDTO.setDeliveryPlace(placeOrderDTO.getDeliveryPlace());
/* 24 */     placeOrderTradeDTO.setDeliveryType(placeOrderDTO.getDeliveryType());
/* 25 */     placeOrderTradeDTO.setPaymentType(placeOrderDTO.getPaymentType());
/* 26 */     placeOrderTradeDTO.setInvoice(placeOrderDTO.getInvoice());
/* 27 */     placeOrderTradeDTO.setProjectCode(placeOrderDTO.getProjectCode());
/* 28 */     placeOrderTradeDTO.setUserAccount(placeOrderDTO.getUserAccount());
/* 29 */     placeOrderTradeDTO.setFundAccount(placeOrderDTO.getFundAccount());
/* 30 */     placeOrderTradeDTO.setTradingType(placeOrderDTO.getTradingType());
/* 31 */     placeOrderTradeDTO.setQuantity(placeOrderDTO.getQuantity());
/* 32 */     placeOrderTradeDTO.setListingPrice(placeOrderDTO.getListingPrice());
/* 33 */     placeOrderTradeDTO.setListingType(placeOrderDTO.getListingType());
/* 34 */     placeOrderTradeDTO.setTotalPay(placeOrderDTO.getTotalPay());
/* 35 */     placeOrderTradeDTO.setComments(placeOrderDTO.getComments());
/* 36 */     placeOrderTradeDTO.setUserName(placeOrderDTO.getUserName());
/* 37 */     placeOrderTradeDTO.setProjectTypeCode(placeOrderDTO.getProjectTypeCode());
/* 38 */     placeOrderTradeDTO.setProvince(placeOrderDTO.getProvince());
/* 39 */     placeOrderTradeDTO.setCity(placeOrderDTO.getCity());
/* 40 */     placeOrderTradeDTO.setArea(placeOrderDTO.getArea());
/* 41 */     placeOrderTradeDTO.setAddress(placeOrderDTO.getAddress());
/* 42 */     placeOrderTradeDTO.setLinkMan(placeOrderDTO.getLinkMan());
/* 43 */     placeOrderTradeDTO.setZipCode(placeOrderDTO.getZipCode());
/* 44 */     placeOrderTradeDTO.setPhone(placeOrderDTO.getPhone());
/* 45 */     placeOrderTradeDTO.setStorehouse(placeOrderDTO.getStorehouse());
/* 46 */     return placeOrderTradeDTO;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.util.ConventUtil
 * JD-Core Version:    0.6.0
 */