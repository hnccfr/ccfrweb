package com.hundsun.network.gates.wulin.biz.dao.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemCreditLevel;
import java.util.List;

public abstract interface SystemCreditLevelDAO
{
  public abstract List<SystemCreditLevel> selectAllList();

  public abstract SystemCreditLevel selectByCreditLevel(String paramString);

  public abstract SystemCreditLevel selectInitCreditLevel();

  public abstract SystemCreditLevel calcCreditLevel(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.baseset.SystemCreditLevelDAO
 * JD-Core Version:    0.6.0
 */