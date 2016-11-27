package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.role.Role;
import com.hundsun.eclp.biz.query.UsersQuery;
import com.hundsun.network.common.query.QueryPage;
import java.util.List;

public abstract interface RoleDAO
{
  public abstract Long insertRole(Role paramRole);

  public abstract int updateRole(Role paramRole);

  public abstract Role selectRoleById(Long paramLong);

  public abstract int deleteRoleById(Long paramLong);

  public abstract List<Role> getRoleList();

  public abstract List<Role> getRoleList(Role paramRole);

  public abstract int getRoleCountByCode(String paramString, Long paramLong);

  public abstract int getRoleCountByDisplayName(String paramString, Long paramLong);

  public abstract int getMaxSort();

  public abstract List<Role> getSuperRoleList(Long paramLong);

  public abstract QueryPage getRoleByAuthId(UsersQuery paramUsersQuery);

  public abstract List<Role> getRoleByAuthId(Long paramLong);

  public abstract List<Role> getRoleByUserId(Long paramLong);

  public abstract List<Long> getRoleIdBySubSystemCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.RoleDAO
 * JD-Core Version:    0.6.0
 */