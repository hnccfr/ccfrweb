package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.user.UserRole;
import java.util.List;

public abstract interface UserRoleDAO
{
  public abstract int insert(List<UserRole> paramList);

  public abstract int update(UserRole paramUserRole);

  public abstract int deleteById(Long paramLong);

  public abstract int deleteByUserId(Long paramLong);

  public abstract List<UserRole> selectByUserId(Long paramLong);

  public abstract int getUserRoleCount(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.UserRoleDAO
 * JD-Core Version:    0.6.0
 */