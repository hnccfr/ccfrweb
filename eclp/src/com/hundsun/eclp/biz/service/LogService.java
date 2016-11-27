package com.hundsun.eclp.biz.service;

import com.hundsun.eclp.biz.domain.user.Users;
import com.hundsun.eclp.biz.query.LoginLogQuery;

public abstract interface LogService
{
  public abstract void createLoginLog(Users paramUsers, String paramString1, boolean paramBoolean, String paramString2, String paramString3);

  public abstract LoginLogQuery selectLoginLogByPage(LoginLogQuery paramLoginLogQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.LogService
 * JD-Core Version:    0.6.0
 */