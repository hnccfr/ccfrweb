package com.hundsun.network.gates.wulin.biz.dao.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.UserCredit;

public abstract interface UserCreditDAO
{
  public abstract Long addInsertUserCredit(UserCredit paramUserCredit);

  public abstract int updateUserCredit(UserCredit paramUserCredit);

  public abstract UserCredit selectByUserAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.baseset.UserCreditDAO
 * JD-Core Version:    0.6.0
 */