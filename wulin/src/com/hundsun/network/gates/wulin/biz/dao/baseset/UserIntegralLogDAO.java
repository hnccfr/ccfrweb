package com.hundsun.network.gates.wulin.biz.dao.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.UserIntegralLog;
import java.util.List;

public abstract interface UserIntegralLogDAO
{
  public abstract Long insert(UserIntegralLog paramUserIntegralLog);

  public abstract List<UserIntegralLog> selectByUserAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.baseset.UserIntegralLogDAO
 * JD-Core Version:    0.6.0
 */