package com.hundsun.eclp.biz.service.role;

import com.hundsun.eclp.biz.domain.role.RoleAuthority;
import java.util.List;

public abstract interface RoleAuthorityService
{
  public abstract List<RoleAuthority> selectRoleAuthorityByRoleId(Long paramLong);

  public abstract void batchInsertRoleAuth(Long paramLong, List<RoleAuthority> paramList);

  public abstract Integer deleteRoleAuthorityByRoleId(Long paramLong);

  public abstract Integer deleteRoleAuthorityById(Long paramLong);

  public abstract void deleteRoleAuthority(List<RoleAuthority> paramList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.role.RoleAuthorityService
 * JD-Core Version:    0.6.0
 */