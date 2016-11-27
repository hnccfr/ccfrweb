package com.hundsun.network.gates.fengshan.biz.dao.user;

import com.hundsun.network.gates.fengshan.biz.domain.user.UserRole;
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

  public abstract List<UserRole> selectUpRoleByRoleName(String paramString);

  public abstract UserRole selectRoleInfoByUserAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.user.UserRoleDAO
 * JD-Core Version:    0.6.0
 */