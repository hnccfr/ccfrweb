package com.hundsun.network.gates.houchao.biz.dao.fund;

import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoneyTotal;

public abstract interface FundMoneyTotalDAO
{
  public abstract Long insert(FundMoneyTotal paramFundMoneyTotal);

  public abstract FundMoneyTotal queryByTransCode(String paramString1, String paramString2, String paramString3);

  public abstract int update(FundMoneyTotal paramFundMoneyTotal);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyTotalDAO
 * JD-Core Version:    0.6.0
 */