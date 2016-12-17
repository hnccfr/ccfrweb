package com.hundsun.network.gates.wulin.biz.service.fund;

import com.hundsun.network.gates.luosi.houchao.reomte.request.AccountRequest;
import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
import com.hundsun.network.gates.luosi.houchao.reomte.result.FundBatchResult;
import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
import java.util.List;

public abstract interface CashTradeService
{
  public abstract FundOperateResult createFundAccount(AccountRequest paramAccountRequest);

  public abstract FundOperateResult fundInAccount(TransRequest paramTransRequest);

  public abstract FundOperateResult fundOutAccount(TransRequest paramTransRequest);

  public abstract FundOperateResult freezeFundByTrade(TransRequest paramTransRequest);

  public abstract FundOperateResult fillFundByTrade(TransRequest paramTransRequest);

  public abstract FundOperateResult prePayPayment(TransRequest paramTransRequest);

  public abstract FundOperateResult payPayment(TransRequest paramTransRequest);

  public abstract FundOperateResult tradeBroken(TransRequest paramTransRequest);

  public abstract FundOperateResult deliveryBroken(TransRequest paramTransRequest);

  public abstract FundOperateResult cancelFundByTrade(TransRequest paramTransRequest);

  public abstract FundBatchResult cancelFundBatchByTrade(List<TransRequest> paramList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.fund.CashTradeService
 * JD-Core Version:    0.6.0
 */