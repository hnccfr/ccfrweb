package com.hundsun.network.gates.wulin.biz.dao.user;

import com.hundsun.network.gates.wulin.biz.domain.user.UserRole;
import java.util.List;

public abstract interface UserRoleDAO
{
  public abstract List<UserRole> getUserRoleBaseInfoByUserId(Long paramLong);

  public abstract Long addRole(UserRole paramUserRole);

  public abstract int editRole(UserRole paramUserRole);

  public abstract int removeRole(Long paramLong);

  public abstract UserRole getRoleById(Long paramLong);

  public abstract List<UserRole> getRoles();

  public abstract UserRole getRoleByName(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.user.UserRoleDAO
 * JD-Core Version:    0.6.0
 */