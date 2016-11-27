package com.hundsun.network.gates.fengshan.biz.service.user;

import com.hundsun.network.gates.fengshan.biz.domain.user.UserRole;
import java.util.List;

public abstract interface UserRoleService
{
  public abstract UserRole getRoleByUserId(Long paramLong);

  public abstract UserRole getRoleById(Long paramLong);

  public abstract List<UserRole> getRoles();

  public abstract List<UserRole> getUpRoleByRoleName(String paramString);

  public abstract UserRole getRoleInfoByAccount(String paramString);

  public abstract UserRole getRoleInfoByName(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.user.UserRoleService
 * JD-Core Version:    0.6.0
 */