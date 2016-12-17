package com.hundsun.network.gates.genshan.biz.dao.financing;

import com.hundsun.network.gates.genshan.biz.domain.financing.Financing;
import com.hundsun.network.gates.genshan.biz.domain.query.FinancingQuery;
import java.util.Map;

public abstract interface FinancingDAO
{
  public abstract Integer update(Financing paramFinancing);

  public abstract Integer insert(Financing paramFinancing);

  public abstract void selectByQuery(FinancingQuery paramFinancingQuery);

  public abstract Long getNextId();

  public abstract Financing selectById(Long paramLong);

  public abstract Integer updateByMap(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.financing.FinancingDAO
 * JD-Core Version:    0.6.0
 */