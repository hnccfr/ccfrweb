package com.hundsun.network.gates.fengshan.biz.dao.user;

import com.hundsun.network.gates.fengshan.biz.domain.user.UserAccount;
import java.util.Map;

public abstract interface UserAccountDAO
{
  public abstract void insert(UserAccount paramUserAccount);

  public abstract UserAccount selectByPrimaryKey(Long paramLong);

  public abstract Long selectByParaMap(Map<String, Object> paramMap);

  public abstract UserAccount selectByAccount(String paramString);

  public abstract int updateByUserAccount(UserAccount paramUserAccount);

  public abstract UserAccount selectFundAccountInfoByAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.user.UserAccountDAO
 * JD-Core Version:    0.6.0
 */