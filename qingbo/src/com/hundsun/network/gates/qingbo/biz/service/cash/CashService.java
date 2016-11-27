package com.hundsun.network.gates.qingbo.biz.service.cash;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.qingbo.biz.domain.cash.TradeCashDTO;

public abstract interface CashService
{
  public abstract ServiceResult tradeClearCash(TradeCashDTO paramTradeCashDTO, String paramString, Long paramLong1, Long paramLong2)
    throws Exception;
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.cash.CashService
 * JD-Core Version:    0.6.0
 */