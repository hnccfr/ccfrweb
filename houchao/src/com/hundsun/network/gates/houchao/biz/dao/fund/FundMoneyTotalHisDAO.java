package com.hundsun.network.gates.houchao.biz.dao.fund;

import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoneyTotalHis;
import java.util.List;

public abstract interface FundMoneyTotalHisDAO
{
  public abstract List<FundMoneyTotalHis> queryByFundMoneyHisWithTradeDate(String paramString1, String paramString2);

  public abstract List<FundMoneyTotalHis> queryByFundMoneyTotalHisWithTradeDate(String paramString, List<String> paramList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyTotalHisDAO
 * JD-Core Version:    0.6.0
 */