package com.hundsun.network.gates.wulin.biz.dao.user;

import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
import java.util.Map;

public abstract interface UserAccountDAO
{
  public abstract UserAccount queryByAccount(UserAccount paramUserAccount);

  public abstract UserAccount selectByUserAccount(String paramString);

  public abstract UserAccount selectByFundAccount(String paramString);

  public abstract int queryNumBySericeCode(String paramString);

  public abstract Integer updateUserAccountByAccount(UserAccount paramUserAccount);

  public abstract int updateUserAccountByAccount(Map<String, Object> paramMap);

  public abstract void addUserAccount(UserAccount paramUserAccount);

  public abstract String getMaxFundAccount();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO
 * JD-Core Version:    0.6.0
 */