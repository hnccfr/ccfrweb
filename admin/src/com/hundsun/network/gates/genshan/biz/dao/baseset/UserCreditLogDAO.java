package com.hundsun.network.gates.genshan.biz.dao.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.UserCreditLog;

public abstract interface UserCreditLogDAO
{
  public abstract Long insert(UserCreditLog paramUserCreditLog);

  public abstract UserCreditLog selectByPrimaryKey(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.baseset.UserCreditLogDAO
 * JD-Core Version:    0.6.0
 */