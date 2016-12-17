package com.hundsun.network.gates.fengshan.biz.dao.user;

import com.hundsun.network.gates.fengshan.biz.domain.user.UserRolePermission;
import java.util.List;

public abstract interface UserRolePermissionDAO
{
  public abstract Long addRolePermission(UserRolePermission paramUserRolePermission);

  public abstract int removeRolePermission(Long paramLong);

  public abstract List<UserRolePermission> getRolePermsByRoleId(Long paramLong);

  public abstract int deleteById(Long paramLong);

  public abstract List<Integer> getUserPermissions(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.user.UserRolePermissionDAO
 * JD-Core Version:    0.6.0
 */