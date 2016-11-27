package com.hundsun.network.gates.fengshan.biz.dao.user;

import com.hundsun.network.gates.fengshan.biz.domain.query.EvaluateQuery;
import com.hundsun.network.gates.fengshan.biz.domain.user.UserCredit;

public abstract interface UserCreditDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(UserCredit paramUserCredit);

  public abstract UserCredit selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(UserCredit paramUserCredit);

  public abstract UserCredit selectByUserAccount(String paramString);

  public abstract void selectEvaluateList(EvaluateQuery paramEvaluateQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.user.UserCreditDAO
 * JD-Core Version:    0.6.0
 */