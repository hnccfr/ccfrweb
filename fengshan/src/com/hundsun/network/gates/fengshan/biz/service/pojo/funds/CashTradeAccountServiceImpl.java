/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.funds;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.funds.CashTradeAccountDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.funds.CashTradeAccount;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.funds.CashTradeAccountService;
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserResetPasswordRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("cashTradeAccountService")
/*    */ public class CashTradeAccountServiceImpl extends BaseService
/*    */   implements CashTradeAccountService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private CashTradeAccountDAO cashTradeAccountDAO;
/*    */ 
/*    */   @Autowired
/*    */   private RemoteUserService remoteUserService;
/*    */ 
/*    */   public CashTradeAccount getFundsByUserAccount(String userAccount)
/*    */   {
/* 34 */     return this.cashTradeAccountDAO.selectCashTradeAccountByUserAccount(userAccount);
/*    */   }
/*    */ 
/*    */   public ServiceResult changeFundPwd(UserResetPasswordRequest request)
/*    */   {
/* 39 */     ServiceResult result = new ServiceResult();
/* 40 */     if ((null == request) || (StringUtil.isEmpty(request.getAccount())) || (StringUtil.isEmpty(request.getOldPassword())) || (StringUtil.isEmpty(request.getNewPassword())))
/*    */     {
/* 42 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 43 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 44 */       return result;
/*    */     }
/* 46 */     return this.remoteUserService.resetFundPwd(request);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.funds.CashTradeAccountServiceImpl
 * JD-Core Version:    0.6.0
 */