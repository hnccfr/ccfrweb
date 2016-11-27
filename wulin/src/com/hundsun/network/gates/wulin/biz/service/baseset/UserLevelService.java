package com.hundsun.network.gates.wulin.biz.service.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.UserIntegralLog;
import com.hundsun.network.gates.wulin.biz.domain.baseset.UserLevel;
import java.util.List;

public abstract interface UserLevelService
{
  public abstract UserLevel selectByAccount(String paramString);

  public abstract Long insertUserLevel(String paramString);

  public abstract int updateUserLevel(String paramString, int paramInt);

  public abstract Long insertUserIntegralLog(String paramString1, String paramString2, String paramString3, String paramString4, Integer paramInteger, String paramString5);

  public abstract List<UserIntegralLog> selectUserIntegralLogByUserAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.baseset.UserLevelService
 * JD-Core Version:    0.6.0
 */