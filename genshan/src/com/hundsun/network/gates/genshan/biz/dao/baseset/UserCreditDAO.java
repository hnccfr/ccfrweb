package com.hundsun.network.gates.genshan.biz.dao.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.UserCredit;
import com.hundsun.network.gates.genshan.biz.domain.query.UserCreditQuery;
import com.hundsun.network.gates.genshan.biz.domain.user.UserCreditInfo;
import java.util.List;

public abstract interface UserCreditDAO
{
  public abstract void selectPageList(UserCreditQuery paramUserCreditQuery);

  public abstract List<UserCredit> selectConditionList(UserCreditQuery paramUserCreditQuery);

  public abstract Long insert(UserCredit paramUserCredit);

  public abstract int updateByPrimaryKey(UserCredit paramUserCredit);

  public abstract UserCredit selectByPrimaryKey(Long paramLong);

  public abstract UserCreditInfo selectByUserAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.baseset.UserCreditDAO
 * JD-Core Version:    0.6.0
 */