package com.hundsun.network.gates.genshan.biz.service.financing;

import com.hundsun.network.gates.genshan.biz.domain.financing.Financing;
import com.hundsun.network.gates.genshan.biz.domain.financing.FinancingLog;
import com.hundsun.network.gates.genshan.biz.domain.query.FinancingQuery;
import com.hundsun.network.gates.luosi.common.remote.ServiceResult;

public abstract interface FinancingService
{
  public abstract void getFinancingList(FinancingQuery paramFinancingQuery);

  public abstract Integer add(Financing paramFinancing, String paramString);

  public abstract ServiceResult delete(Long paramLong, String paramString);

  public abstract Financing getFinancingById(Long paramLong);

  public abstract Integer edit(Financing paramFinancing, String paramString);

  public abstract ServiceResult audit(FinancingLog paramFinancingLog, String paramString);

  public abstract ServiceResult loan(Financing paramFinancing, FinancingLog paramFinancingLog, String paramString);

  public abstract ServiceResult repay(Financing paramFinancing, FinancingLog paramFinancingLog, String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.financing.FinancingService
 * JD-Core Version:    0.6.0
 */