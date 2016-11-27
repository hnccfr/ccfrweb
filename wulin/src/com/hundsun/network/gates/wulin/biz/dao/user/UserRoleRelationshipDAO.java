package com.hundsun.network.gates.wulin.biz.dao.user;

import com.hundsun.network.gates.wulin.biz.domain.user.UserRoleRelationship;

public abstract interface UserRoleRelationshipDAO
{
  public abstract Long addUserRole(UserRoleRelationship paramUserRoleRelationship);

  public abstract int updateUserRole(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.user.UserRoleRelationshipDAO
 * JD-Core Version:    0.6.0
 */