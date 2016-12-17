package com.hundsun.network.gates.fengshan.biz.service.funds;

import com.hundsun.network.gates.fengshan.biz.domain.funds.CashTradeAccount;
import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.request.UserResetPasswordRequest;

public abstract interface CashTradeAccountService
{
  public abstract CashTradeAccount getFundsByUserAccount(String paramString);

  public abstract ServiceResult changeFundPwd(UserResetPasswordRequest paramUserResetPasswordRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.funds.CashTradeAccountService
 * JD-Core Version:    0.6.0
 */