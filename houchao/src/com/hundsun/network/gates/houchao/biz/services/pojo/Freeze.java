/*    */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.TransReq;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ 
/*    */ public abstract class Freeze extends AbstractFundCoreTrans
/*    */ {
/*    */   protected boolean checkParams(TransReq transReq)
/*    */   {
/* 31 */     return (null != transReq) && (transReq.getAmount() != null) && (transReq.getAmount().longValue() > 0L) && (transReq.getFundAccount() != null) && (transReq.getOperator() != null) && (!StringUtil.isBlank(transReq.getMoneyType()));
/*    */   }
/*    */ 
/*    */   protected EnumFundResultCode ExecuteTrans(TransReq transReq)
/*    */   {
/* 43 */     if (isFreeze()) {
/* 44 */       this.fundMoneyDAO.freezeBalance(transReq.getMoneyType(), transReq.getFundAccount(), transReq.getAmount(), transReq.getOperator(), transReq.getMemo(), isFreeze());
/*    */     }
/*    */     else {
/* 47 */       this.fundMoneyDAO.freezeBalance(transReq.getMoneyType(), transReq.getFundAccount(), transReq.getAmount(), transReq.getOperator(), transReq.getMemo(), isFreeze());
/*    */     }
/*    */ 
/* 51 */     this.fundMoney.setPostAmount(this.fundMoney.getAmount());
/* 52 */     return EnumFundResultCode.FUND_SUCCESS;
/*    */   }
/*    */ 
/*    */   protected EnumFundResultCode preExecuteTrans(TransReq transReq)
/*    */   {
/* 61 */     EnumFundResultCode fundResultCode = super.preExecuteTrans(transReq);
/* 62 */     if (!StringUtil.equals(fundResultCode.getCode(), EnumFundResultCode.FUND_SUCCESS.getCode())) {
/* 63 */       return fundResultCode;
/*    */     }
/*    */ 
/* 66 */     Long amount = transReq.getAmount();
/* 67 */     if (isFreeze()) {
/* 68 */       if (amount.longValue() > calculateBalance().longValue()) {
/* 69 */         fundResultCode = EnumFundResultCode.BALACE_NOT_ENOUGH;
/*    */       }
/*    */     }
/* 72 */     else if (amount.longValue() > this.fundMoney.getFreezeTotal().longValue()) {
/* 73 */       fundResultCode = EnumFundResultCode.FREEZE_BALACE_NOT_ENOUGH;
/*    */     }
/*    */ 
/* 76 */     return fundResultCode;
/*    */   }
/*    */ 
/*    */   protected EnumFundResultCode postExecuteTrans(TransReq transReq)
/*    */   {
/* 84 */     EnumFundResultCode fundResultCode = super.postExecuteTrans(transReq);
/* 85 */     return fundResultCode;
/*    */   }
/*    */ 
/*    */   abstract boolean isFreeze();
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.Freeze
 * JD-Core Version:    0.6.0
 */