package com.hundsun.network.gates.wulin.biz.dao.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.UserLevel;

public abstract interface UserLevelDAO
{
  public abstract Long insertUserLevel(UserLevel paramUserLevel);

  public abstract int updateUserLevel(UserLevel paramUserLevel);

  public abstract UserLevel selectByAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.baseset.UserLevelDAO
 * JD-Core Version:    0.6.0
 */