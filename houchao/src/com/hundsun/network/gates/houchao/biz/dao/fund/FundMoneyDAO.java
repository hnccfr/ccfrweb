package com.hundsun.network.gates.houchao.biz.dao.fund;

import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney;
import java.util.List;

public abstract interface FundMoneyDAO
{
  public abstract Long insertFundMoney(FundMoney paramFundMoney);

  public abstract void update(FundMoney paramFundMoney);

  public abstract FundMoney getByFundAccountWithMoneyType(String paramString1, String paramString2);

  public abstract List<FundMoney> getByFundAccount(String paramString);

  public abstract void updateCurrentBalance(String paramString1, String paramString2, Long paramLong, String paramString3, Boolean paramBoolean);

  public abstract void freezeBalance(String paramString1, String paramString2, Long paramLong, String paramString3, String paramString4, boolean paramBoolean);

  public abstract void writeOffCurrentBalance(String paramString1, String paramString2, Long paramLong, Boolean paramBoolean);

  public abstract void updateFundMoneyByfundAccount(FundMoney paramFundMoney);

  public abstract List<FundMoney> getFundMoneyByAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO
 * JD-Core Version:    0.6.0
 */