package com.hundsun.network.gates.qingbo.biz.dao.user;

import com.hundsun.network.gates.qingbo.biz.domain.user.UserAccount;

public abstract interface UserAccountDAO
{
  public abstract UserAccount selectUserByAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.user.UserAccountDAO
 * JD-Core Version:    0.6.0
 */