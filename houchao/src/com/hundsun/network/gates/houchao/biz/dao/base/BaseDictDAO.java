package com.hundsun.network.gates.houchao.biz.dao.base;

import com.hundsun.network.gates.houchao.biz.domain.base.BaseDict;
import com.hundsun.network.gates.houchao.biz.domain.base.query.BaseDictQuery;

public abstract interface BaseDictDAO
{
  public abstract BaseDict getBaseDictNoVersionByFlay(BaseDictQuery paramBaseDictQuery);

  public abstract BaseDict getBaseDictCurrVersionByFlay(BaseDictQuery paramBaseDictQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.base.BaseDictDAO
 * JD-Core Version:    0.6.0
 */