package com.hundsun.network.gates.houchao.biz.manager;

import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryPageRequest;
import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryRequest;
import com.hundsun.network.gates.luosi.houchao.reomte.result.FundInOutQueryResult;
import com.hundsun.network.gates.luosi.houchao.reomte.result.FundQueryResult;

public abstract interface AccountQueryManager
{
  public abstract FundQueryResult queryFundByTrader(FundQueryRequest paramFundQueryRequest);

  public abstract FundQueryResult useBalanceCalculate(FundQueryRequest paramFundQueryRequest);

  public abstract FundInOutQueryResult fundInOutQuery(FundQueryPageRequest paramFundQueryPageRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.manager.AccountQueryManager
 * JD-Core Version:    0.6.0
 */