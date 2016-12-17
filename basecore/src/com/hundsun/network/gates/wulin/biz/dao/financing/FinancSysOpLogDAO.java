package com.hundsun.network.gates.wulin.biz.dao.financing;

import com.hundsun.network.gates.wulin.biz.domain.financing.FinancSysOpLog;
import com.hundsun.network.gates.wulin.biz.domain.financing.FinancSysOpLogCriteria;
import java.util.List;

public abstract interface FinancSysOpLogDAO
{
  public abstract int countByExample(FinancSysOpLogCriteria paramFinancSysOpLogCriteria);

  public abstract int deleteByExample(FinancSysOpLogCriteria paramFinancSysOpLogCriteria);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(FinancSysOpLog paramFinancSysOpLog);

  public abstract Long insertSelective(FinancSysOpLog paramFinancSysOpLog);

  public abstract List<FinancSysOpLog> selectByExample(FinancSysOpLogCriteria paramFinancSysOpLogCriteria);

  public abstract FinancSysOpLog selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(FinancSysOpLog paramFinancSysOpLog, FinancSysOpLogCriteria paramFinancSysOpLogCriteria);

  public abstract int updateByExample(FinancSysOpLog paramFinancSysOpLog, FinancSysOpLogCriteria paramFinancSysOpLogCriteria);

  public abstract int updateByPrimaryKeySelective(FinancSysOpLog paramFinancSysOpLog);

  public abstract int updateByPrimaryKey(FinancSysOpLog paramFinancSysOpLog);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.financing.FinancSysOpLogDAO
 * JD-Core Version:    0.6.0
 */