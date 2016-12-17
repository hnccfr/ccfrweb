package com.hundsun.network.gates.fengshan.biz.service.financing;

import com.hundsun.network.gates.fengshan.biz.domain.financing.Financing;
import java.util.List;

public abstract interface FinancingService
{
  public abstract List<Financing> selectFinancingListing(Integer paramInteger);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.financing.FinancingService
 * JD-Core Version:    0.6.0
 */