package com.hundsun.network.gates.genshan.biz.service.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.UserCredit;
import com.hundsun.network.gates.genshan.biz.domain.query.UserCreditQuery;
import java.util.List;

public abstract interface UserCreditService
{
  public abstract void selectPageList(UserCreditQuery paramUserCreditQuery);

  public abstract List<UserCredit> selectConditionList(UserCreditQuery paramUserCreditQuery);

  public abstract void insert(UserCredit paramUserCredit);

  public abstract int updateByPrimaryKey(UserCredit paramUserCredit);

  public abstract UserCredit selectByPrimaryKey(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.UserCreditService
 * JD-Core Version:    0.6.0
 */