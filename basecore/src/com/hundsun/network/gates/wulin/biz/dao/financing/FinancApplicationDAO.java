package com.hundsun.network.gates.wulin.biz.dao.financing;

import com.hundsun.network.gates.wulin.biz.domain.financing.FinancApplication;
import com.hundsun.network.gates.wulin.biz.domain.financing.FinancApplicationCriteria;
import java.util.List;

public abstract interface FinancApplicationDAO
{
  public abstract int countByExample(FinancApplicationCriteria paramFinancApplicationCriteria);

  public abstract int deleteByExample(FinancApplicationCriteria paramFinancApplicationCriteria);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(FinancApplication paramFinancApplication);

  public abstract Long insertSelective(FinancApplication paramFinancApplication);

  public abstract List<FinancApplication> selectByExample(FinancApplicationCriteria paramFinancApplicationCriteria);

  public abstract FinancApplication selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(FinancApplication paramFinancApplication, FinancApplicationCriteria paramFinancApplicationCriteria);

  public abstract int updateByExample(FinancApplication paramFinancApplication, FinancApplicationCriteria paramFinancApplicationCriteria);

  public abstract int updateByPrimaryKeySelective(FinancApplication paramFinancApplication);

  public abstract int updateByPrimaryKey(FinancApplication paramFinancApplication);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.financing.FinancApplicationDAO
 * JD-Core Version:    0.6.0
 */