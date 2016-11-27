package com.hundsun.network.gates.genshan.biz.dao.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemDict;
import com.hundsun.network.gates.genshan.biz.domain.query.SystemDictQuery;
import java.util.List;

public abstract interface SystemDictDAO
{
  public abstract void selectPageList(SystemDictQuery paramSystemDictQuery);

  public abstract List<SystemDict> selectByCond(SystemDictQuery paramSystemDictQuery);

  public abstract List<SystemDict> checkRepeat(SystemDictQuery paramSystemDictQuery);

  public abstract Long insert(SystemDict paramSystemDict);

  public abstract int updateByPrimaryKey(SystemDict paramSystemDict);

  public abstract int updateBySelective(SystemDict paramSystemDict);

  public abstract SystemDict selectByPrimaryKey(Long paramLong);

  public abstract int deleteByPrimaryKey(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.baseset.SystemDictDAO
 * JD-Core Version:    0.6.0
 */