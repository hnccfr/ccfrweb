package com.hundsun.network.gates.genshan.biz.dao.financing;

import com.hundsun.network.gates.genshan.biz.domain.financing.FinancingLog;
import java.util.List;

public abstract interface FinancingLogDAO
{
  public abstract Integer insert(FinancingLog paramFinancingLog);

  public abstract List<FinancingLog> getByFinancingId(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.financing.FinancingLogDAO
 * JD-Core Version:    0.6.0
 */