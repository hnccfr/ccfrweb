/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTransferFormDealStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTransferFormErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TransferFormRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TransferFormResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTransferFormService;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.financing.FinancTransferFormDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancTransferForm;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteTransferFormService")
/*     */ public class RemoteTransferFormServiceImpl extends BaseService
/*     */   implements RemoteTransferFormService
/*     */ {
/*  28 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountDAO accountDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private FinancTransferFormDAO transferFormDAO;
/*     */ 
/*  45 */   public TransferFormResult addTransferForm(TransferFormRequest request) { TransferFormResult result = new TransferFormResult();
/*  46 */     if (null == request) {
/*  47 */       result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.PARAMETER_ERROR.getValue()));
/*  48 */       result.setErrorInfo(EnumTransferFormErrors.PARAMETER_ERROR.getInfo());
/*  49 */       this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/*  50 */       return result;
/*     */     }
/*     */ 
/*  53 */     String buyerAccount = request.getBuyerAccount();
/*  54 */     String sellerAccount = request.getSellerAccount();
/*     */ 
/*  56 */     if (StringUtils.equals(buyerAccount, sellerAccount)) {
/*  57 */       result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.SAME_ACCOUNT_ERROR.getValue()));
/*  58 */       result.setErrorInfo(EnumTransferFormErrors.SAME_ACCOUNT_ERROR.getInfo());
/*  59 */       this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/*  60 */       return result;
/*     */     }
/*     */ 
/*  63 */     if ((StringUtils.isEmpty(buyerAccount)) || (StringUtils.isEmpty(sellerAccount))) {
/*  64 */       result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.EMPTY_ACCOUNT_ERROR.getValue()));
/*  65 */       result.setErrorInfo(EnumTransferFormErrors.EMPTY_ACCOUNT_ERROR.getInfo());
/*  66 */       this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/*  67 */       return result;
/*     */     }
/*     */ 
/*  70 */     UserAccount buyer = null;
/*  71 */     UserAccount seller = null;
/*     */     try {
/*  73 */       buyer = this.accountDAO.selectByUserAccount(buyerAccount);
/*  74 */       seller = this.accountDAO.selectByUserAccount(sellerAccount);
/*  75 */       if (buyer == null) {
/*  76 */         result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.BUYER_NOT_EXISTS.getValue()));
/*  77 */         result.setErrorInfo(EnumTransferFormErrors.BUYER_NOT_EXISTS.getInfo());
/*  78 */         this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/*  79 */         return result;
/*     */       }
/*  81 */       if (seller == null) {
/*  82 */         result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.SELLER_NOT_EXISTS.getValue()));
/*  83 */         result.setErrorInfo(EnumTransferFormErrors.SELLER_NOT_EXISTS.getInfo());
/*  84 */         this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/*  85 */         return result;
/*     */       }
/*     */     } catch (Exception e) {
/*  88 */       result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.INTERNAL_ERROR.getValue()));
/*  89 */       result.setErrorInfo(EnumTransferFormErrors.INTERNAL_ERROR.getInfo());
/*  90 */       this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/*  91 */       return result;
/*     */     }
/*     */ 
/*  94 */     String orderNo = request.getOrderNo();
/*  95 */     TradeOrder order = null;
/*     */     try {
/*  97 */       order = this.tradeOrderDAO.selectByOrderNo(orderNo);
/*  98 */       if (order == null) {
/*  99 */         result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.ORDER_NOT_EXISTS.getValue()));
/* 100 */         result.setErrorInfo(EnumTransferFormErrors.ORDER_NOT_EXISTS.getInfo());
/* 101 */         this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/* 102 */         return result;
/*     */       }
/*     */     } catch (Exception e) {
/* 105 */       result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.INTERNAL_ERROR.getValue()));
/* 106 */       result.setErrorInfo(EnumTransferFormErrors.INTERNAL_ERROR.getInfo());
/* 107 */       this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/* 108 */       return result;
/*     */     }
/*     */ 
/* 112 */     Long goodsId = request.getGoodsId();
/* 113 */     String quantity = request.getQuantity();
/* 114 */     Long totalPrice = request.getTotalPrice();
/* 115 */     if (goodsId == null) {
/* 116 */       result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.EMPTY_GOODS_ID_ERROR.getValue()));
/* 117 */       result.setErrorInfo(EnumTransferFormErrors.EMPTY_GOODS_ID_ERROR.getInfo());
/* 118 */       this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/* 119 */       return result;
/*     */     }
/* 121 */     if (totalPrice == null) {
/* 122 */       result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.EMPTY_TOTAL_PRICE_ERROR.getValue()));
/* 123 */       result.setErrorInfo(EnumTransferFormErrors.EMPTY_TOTAL_PRICE_ERROR.getInfo());
/* 124 */       this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/* 125 */       return result;
/*     */     }
/* 127 */     if (StringUtils.isEmpty(quantity)) {
/* 128 */       result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.EMPTY_QUANTITY_ERROR.getValue()));
/* 129 */       result.setErrorInfo(EnumTransferFormErrors.EMPTY_QUANTITY_ERROR.getInfo());
/* 130 */       this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/* 131 */       return result;
/* 132 */     }if (!StringUtils.isNumeric(StringUtils.replace(quantity, ".", ""))) {
/* 133 */       result.setErrorNO(Integer.valueOf(EnumTransferFormErrors.QUANTITY_TYPE_ERROR.getValue()));
/* 134 */       result.setErrorInfo(EnumTransferFormErrors.QUANTITY_TYPE_ERROR.getInfo());
/* 135 */       this.log.error("addTransferForm error, cause by:" + result.getErrorInfo());
/* 136 */       return result;
/*     */     }
/*     */ 
/* 140 */     FinancTransferForm transferForm = new FinancTransferForm();
/* 141 */     transferForm.setBuyerAccountId(buyer.getId());
/* 142 */     transferForm.setSellerAccountId(seller.getId());
/* 143 */     transferForm.setOrderId(order.getId());
/* 144 */     transferForm.setGoodsId(goodsId);
/* 145 */     transferForm.setQuantity(new BigDecimal(quantity));
/* 146 */     transferForm.setTotalPrice(totalPrice);
/*     */ 
/* 148 */     transferForm.setDealStatus(EnumTransferFormDealStatus.SELLERCONF.getCode());
/* 149 */     transferForm.setCreator(buyer.getAccount());
/* 150 */     transferForm.setModifier(buyer.getAccount());
/* 151 */     transferForm.setGmtCreate(new Date());
/* 152 */     transferForm.setGmtModify(new Date());
/* 153 */     this.transferFormDAO.insertSelective(transferForm);
/* 154 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteTransferFormServiceImpl
 * JD-Core Version:    0.6.0
 */