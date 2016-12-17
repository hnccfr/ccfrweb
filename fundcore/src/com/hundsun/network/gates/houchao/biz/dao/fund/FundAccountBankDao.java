package com.hundsun.network.gates.houchao.biz.dao.fund;

import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountBank;

public abstract interface FundAccountBankDao
{
  public abstract Long insertFundAccountBank(FundAccountBank paramFundAccountBank);

  public abstract FundAccountBank getFundAccountBankIsExist(String paramString);

  public abstract void updateFundAccountBankStatus(FundAccountBank paramFundAccountBank);

  public abstract FundAccountBank getFundAccountBankByAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountBankDao
 * JD-Core Version:    0.6.0
 */