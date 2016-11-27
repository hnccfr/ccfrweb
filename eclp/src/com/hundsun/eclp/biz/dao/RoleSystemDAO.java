package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.role.RoleSytem;
import com.hundsun.eclp.biz.domain.sys.SubSystem;
import java.util.List;

public abstract interface RoleSystemDAO
{
  public abstract Long insertRoleSystem(RoleSytem paramRoleSytem);

  public abstract String getRoleIDBySystemID(long paramLong);

  public abstract String getRoleIDBySystemCode(String paramString);

  public abstract List<SubSystem> selectSystemByUserId(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.RoleSystemDAO
 * JD-Core Version:    0.6.0
 */