package com.hundsun.network.gates.wulin.biz.dao.funds;

import com.hundsun.network.gates.wulin.biz.domain.funds.CashTradeAccount;
import java.util.Map;

public abstract interface CashTradeAccountDAO
{
  public abstract Long registFundsAccount(CashTradeAccount paramCashTradeAccount);

  public abstract CashTradeAccount selectCashTradeAccountByTaid(Map<String, Object> paramMap);

  public abstract int frozenCashAccount(Map<String, Object> paramMap);

  public abstract int thawCashAccount(Map<String, Object> paramMap);

  public abstract int outcomeCashAccount(Map<String, Object> paramMap);

  public abstract int incomeCashAccount(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.funds.CashTradeAccountDAO
 * JD-Core Version:    0.6.0
 */