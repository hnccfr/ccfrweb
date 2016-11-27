package com.hundsun.network.gates.genshan.biz.dao.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemCreditLevel;
import com.hundsun.network.gates.genshan.biz.domain.query.SystemCreditLevelQuery;
import java.util.List;

public abstract interface SystemCreditLevelDAO
{
  public abstract void selectPageList(SystemCreditLevelQuery paramSystemCreditLevelQuery);

  public abstract List<SystemCreditLevel> selectAllList();

  public abstract Long insert(SystemCreditLevel paramSystemCreditLevel);

  public abstract int updateByPrimaryKey(SystemCreditLevel paramSystemCreditLevel);

  public abstract int updateBySelective(SystemCreditLevel paramSystemCreditLevel);

  public abstract SystemCreditLevel selectByPrimaryKey(Long paramLong);

  public abstract SystemCreditLevel selectByCond(SystemCreditLevelQuery paramSystemCreditLevelQuery);

  public abstract int checkIntegralRange(SystemCreditLevelQuery paramSystemCreditLevelQuery);

  public abstract int deleteByPrimaryKey(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.baseset.SystemCreditLevelDAO
 * JD-Core Version:    0.6.0
 */