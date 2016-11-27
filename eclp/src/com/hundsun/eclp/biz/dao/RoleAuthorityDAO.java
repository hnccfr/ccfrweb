package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.role.RoleAuthority;
import java.util.List;

public abstract interface RoleAuthorityDAO
{
  public abstract void insertRoleAuthority(RoleAuthority paramRoleAuthority);

  public abstract int updateRoleAuthority(RoleAuthority paramRoleAuthority);

  public abstract RoleAuthority selectRoleAuthorityById(Long paramLong);

  public abstract int deleteRoleAuthorityById(Long paramLong);

  public abstract List<RoleAuthority> selectRoleAuthorityByRoleId(Long paramLong);

  public abstract int batchInsertRoleAuth(List<RoleAuthority> paramList);

  public abstract int deleteRoleAuthorityByRoleId(Long paramLong);

  public abstract int deleteRoleAuthorityByAuthIdList(List<Long> paramList);

  public abstract Integer deleteRoleAuthority(List<RoleAuthority> paramList);

  public abstract List<RoleAuthority> findRoleAuthByRoleIdAndAuthId(RoleAuthority paramRoleAuthority);

  public abstract List<RoleAuthority> findParentRoleAuth(RoleAuthority paramRoleAuthority);

  public abstract List<RoleAuthority> findAllRoleByAuthId(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.RoleAuthorityDAO
 * JD-Core Version:    0.6.0
 */