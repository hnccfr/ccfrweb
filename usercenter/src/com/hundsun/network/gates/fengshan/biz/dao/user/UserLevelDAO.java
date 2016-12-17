package com.hundsun.network.gates.fengshan.biz.dao.user;

import com.hundsun.network.gates.fengshan.biz.domain.user.UserLevel;

public abstract interface UserLevelDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(UserLevel paramUserLevel);

  public abstract UserLevel selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(UserLevel paramUserLevel);

  public abstract UserLevel selectByUserAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.user.UserLevelDAO
 * JD-Core Version:    0.6.0
 */