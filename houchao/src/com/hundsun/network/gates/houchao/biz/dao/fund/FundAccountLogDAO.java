package com.hundsun.network.gates.houchao.biz.dao.fund;

import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountLog;

public abstract interface FundAccountLogDAO
{
  public abstract Long insert(FundAccountLog paramFundAccountLog);

  public abstract FundAccountLog getByBizNoAndSubTransCode(String paramString1, String paramString2);

  public abstract void updateToCancelFlag(FundAccountLog paramFundAccountLog);

  public abstract FundAccountLog getFundAccountLog(FundAccountLog paramFundAccountLog);

  public abstract FundAccountLog getFundAccLogByBiznoBankno(FundAccountLog paramFundAccountLog);

  public abstract FundAccountLog fundAccountLogBybizNO(String paramString);

  public abstract FundAccountLog getByBizNoAndSubTransCodeAndFundAccount(String paramString1, String paramString2, String paramString3);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountLogDAO
 * JD-Core Version:    0.6.0
 */