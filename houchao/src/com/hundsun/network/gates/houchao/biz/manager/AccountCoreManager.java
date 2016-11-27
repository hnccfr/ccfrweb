package com.hundsun.network.gates.houchao.biz.manager;

import com.hundsun.network.gates.luosi.houchao.reomte.request.AccountRequest;
import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
import com.hundsun.network.gates.luosi.houchao.reomte.result.FundBatchResult;
import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
import java.util.List;

public abstract interface AccountCoreManager
{
  public abstract FundOperateResult createFundAccount(AccountRequest paramAccountRequest);

  public abstract FundOperateResult cancelFundAccount(AccountRequest paramAccountRequest);

  public abstract FundOperateResult fundInAccount(TransRequest paramTransRequest);

  public abstract FundOperateResult fundOutAccount(TransRequest paramTransRequest);

  public abstract FundOperateResult freezeFundByTrade(TransRequest paramTransRequest);

  public abstract FundOperateResult fillFundByTrade(TransRequest paramTransRequest);

  public abstract FundBatchResult fillFundBatchByTrade(List<TransRequest> paramList);

  public abstract FundBatchResult cancelFundBatchByTrade(List<TransRequest> paramList);

  public abstract FundOperateResult cancelFundByTrade(TransRequest paramTransRequest);

  public abstract FundOperateResult prePayPayment(TransRequest paramTransRequest);

  public abstract FundOperateResult refundPayment(TransRequest paramTransRequest);

  public abstract FundOperateResult payPayment(TransRequest paramTransRequest);

  public abstract FundOperateResult penaltyManager(TransRequest paramTransRequest);

  public abstract FundOperateResult tradeBroken(TransRequest paramTransRequest);

  public abstract FundOperateResult deliveryBroken(TransRequest paramTransRequest);

  public abstract FundOperateResult checkGoodsTicketBroken(TransRequest paramTransRequest);

  public abstract FundOperateResult writeOffFund(TransRequest paramTransRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.manager.AccountCoreManager
 * JD-Core Version:    0.6.0
 */