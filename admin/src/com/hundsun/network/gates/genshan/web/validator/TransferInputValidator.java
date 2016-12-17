/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionResult;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionResultTranResult;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.math.BigDecimal;
/*    */ import org.springframework.util.Assert;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class TransferInputValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 17 */     Assert.notNull(obj);
/* 18 */     Assert.isInstanceOf(AuctionResult.class, obj);
/* 19 */     super.validate(obj, err);
/*    */ 
/* 21 */     AuctionResult auctionResult = (AuctionResult)obj;
/*    */ 
/* 24 */     String tranResult = auctionResult.getTranResult();
/* 25 */     if ((StringUtil.isBlank(tranResult)) || (null == EnumAuctionResultTranResult.indexByValue(tranResult)))
/*    */     {
/* 27 */       err.rejectValue("tranResult", null, null, "请选择 交易结果");
/*    */     }
/* 30 */     else if (EnumAuctionResultTranResult.RESULT_FINISHED.getValue().equals(tranResult))
/*    */     {
/* 32 */       String priceDesc = auctionResult.getPriceDesc();
/* 33 */       if (StringUtil.isBlank(priceDesc))
/* 34 */         err.rejectValue("priceDesc", null, null, "成交价格 不能为空");
/*    */       else {
/*    */         try {
/* 37 */           BigDecimal bgPrice = new BigDecimal(priceDesc);
/* 38 */           if (bgPrice.doubleValue() <= 0.0D)
/* 39 */             throw new Exception();
/*    */         }
/*    */         catch (Exception e) {
/* 42 */           err.rejectValue("priceDesc", null, null, "成交价格 请输入大于0的有效金额格式");
/*    */         }
/*    */       }
/*    */ 
/* 46 */       String bidderAccount = auctionResult.getBidderAccount();
/* 47 */       if (StringUtil.isBlank(bidderAccount))
/* 48 */         err.rejectValue("bidderAccount", null, null, "成交人账号 不能为空");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.TransferInputValidator
 * JD-Core Version:    0.6.0
 */