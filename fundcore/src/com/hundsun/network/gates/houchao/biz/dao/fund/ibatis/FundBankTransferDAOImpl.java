/*    */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundBankTransferDAO;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundBankTransfer;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.apache.commons.lang.Validate;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("fundBankTransferDAO")
/*    */ public class FundBankTransferDAOImpl extends BaseDAO
/*    */   implements FundBankTransferDAO
/*    */ {
/*    */   private static final String NAME_SPACE = "FUND_BANK_TRANSFER.";
/*    */ 
/*    */   public Long insertFundBankTransfer(FundBankTransfer fundBankTransfer)
/*    */   {
/* 22 */     Validate.notNull(fundBankTransfer, "when insert,fundBankTransfer must not be null");
/* 23 */     return (Long)getSqlMapClientTemplate().insert("FUND_BANK_TRANSFER.insert", fundBankTransfer);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.FundBankTransferDAOImpl
 * JD-Core Version:    0.6.0
 */