package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.sys.LoginLog;
import com.hundsun.eclp.biz.query.LoginLogQuery;

public abstract interface LoginLogDAO
{
  public abstract void insert(LoginLog paramLoginLog);

  public abstract int update(LoginLog paramLoginLog);

  public abstract LoginLog selectById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract LoginLog getLastLoginLog(String paramString);

  public abstract LoginLogQuery serarchByPage(LoginLogQuery paramLoginLogQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.LoginLogDAO
 * JD-Core Version:    0.6.0
 */