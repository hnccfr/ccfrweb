package com.hundsun.eclp.biz.service;

import com.hundsun.eclp.biz.domain.user.UserAgent;
import com.hundsun.eclp.biz.domain.user.UserRole;
import java.util.List;

public abstract interface UserRoleService
{
  public abstract int getUserRoleCount(Long paramLong);

  public abstract List<UserRole> selectByUserId(Long paramLong);

  public abstract void insert(Long paramLong, List<UserRole> paramList, UserAgent paramUserAgent);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.UserRoleService
 * JD-Core Version:    0.6.0
 */