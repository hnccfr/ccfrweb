package com.hundsun.network.gates.genshan.biz.dao.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
import com.hundsun.network.gates.genshan.biz.domain.query.UserLevelQuery;

public abstract interface UserLevelDAO
{
  public abstract void selectPageList(UserLevelQuery paramUserLevelQuery);

  public abstract Long insert(UserLevel paramUserLevel);

  public abstract int updateByPrimaryKey(UserLevel paramUserLevel);

  public abstract UserLevel selectByPrimaryKey(Long paramLong);

  public abstract UserLevel selectByUserAccount(String paramString);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract UserLevel selectUserLevelByUserAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.baseset.UserLevelDAO
 * JD-Core Version:    0.6.0
 */