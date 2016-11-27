package com.hundsun.network.gates.houchao.biz.dao.fund;

import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccount;

public abstract interface FundAccountDAO
{
  public abstract Long insert(FundAccount paramFundAccount);

  public abstract int updateStatusClosed(FundAccount paramFundAccount);

  public abstract void updateFundAccountByAcc(FundAccount paramFundAccount);

  public abstract FundAccount queryByFundAccount(String paramString, boolean paramBoolean);

  public abstract String getFundAccountNO();

  public abstract String getInnerBillNoSeq();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountDAO
 * JD-Core Version:    0.6.0
 */