package com.hundsun.network.gates.wulin.biz.dao.financing;

import com.hundsun.network.gates.wulin.biz.domain.financing.FinancCollList;
import com.hundsun.network.gates.wulin.biz.domain.financing.FinancCollListCriteria;
import java.util.List;

public abstract interface FinancCollListDAO
{
  public abstract int countByExample(FinancCollListCriteria paramFinancCollListCriteria);

  public abstract int deleteByExample(FinancCollListCriteria paramFinancCollListCriteria);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(FinancCollList paramFinancCollList);

  public abstract Long insertSelective(FinancCollList paramFinancCollList);

  public abstract List<FinancCollList> selectByExample(FinancCollListCriteria paramFinancCollListCriteria);

  public abstract FinancCollList selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(FinancCollList paramFinancCollList, FinancCollListCriteria paramFinancCollListCriteria);

  public abstract int updateByExample(FinancCollList paramFinancCollList, FinancCollListCriteria paramFinancCollListCriteria);

  public abstract int updateByPrimaryKeySelective(FinancCollList paramFinancCollList);

  public abstract int updateByPrimaryKey(FinancCollList paramFinancCollList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.financing.FinancCollListDAO
 * JD-Core Version:    0.6.0
 */