package com.hundsun.network.gates.fengshan.biz.dao.funds;

import com.hundsun.network.gates.fengshan.biz.domain.funds.CashTradeAccount;

public abstract interface CashTradeAccountDAO
{
  public abstract CashTradeAccount selectCashTradeAccountByUserAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.funds.CashTradeAccountDAO
 * JD-Core Version:    0.6.0
 */