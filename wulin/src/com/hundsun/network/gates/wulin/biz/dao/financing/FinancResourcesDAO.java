package com.hundsun.network.gates.wulin.biz.dao.financing;

import com.hundsun.network.gates.wulin.biz.domain.financing.FinancResources;
import com.hundsun.network.gates.wulin.biz.domain.financing.FinancResourcesCriteria;
import java.util.List;

public abstract interface FinancResourcesDAO
{
  public abstract int countByExample(FinancResourcesCriteria paramFinancResourcesCriteria);

  public abstract int deleteByExample(FinancResourcesCriteria paramFinancResourcesCriteria);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(FinancResources paramFinancResources);

  public abstract Long insertSelective(FinancResources paramFinancResources);

  public abstract List<FinancResources> selectByExample(FinancResourcesCriteria paramFinancResourcesCriteria);

  public abstract FinancResources selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(FinancResources paramFinancResources, FinancResourcesCriteria paramFinancResourcesCriteria);

  public abstract int updateByExample(FinancResources paramFinancResources, FinancResourcesCriteria paramFinancResourcesCriteria);

  public abstract int updateByPrimaryKeySelective(FinancResources paramFinancResources);

  public abstract int updateByPrimaryKey(FinancResources paramFinancResources);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.financing.FinancResourcesDAO
 * JD-Core Version:    0.6.0
 */