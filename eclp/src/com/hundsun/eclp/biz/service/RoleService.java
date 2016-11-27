package com.hundsun.eclp.biz.service;

import com.hundsun.eclp.biz.domain.role.Role;
import com.hundsun.eclp.biz.domain.user.UserAgent;
import com.hundsun.eclp.biz.domain.user.Users;
import com.hundsun.eclp.biz.query.UsersQuery;
import com.hundsun.network.common.query.QueryPage;
import java.util.List;
import org.springframework.ui.Model;

public abstract interface RoleService
{
  public abstract Role getRoleByUser(Users paramUsers);

  public abstract List<Role> getRoleList(UserAgent paramUserAgent);

  public abstract List<Role> getRoleList();

  public abstract void modifyStatus(Long paramLong, Short paramShort, UserAgent paramUserAgent);

  public abstract void deleteRole(Long paramLong, UserAgent paramUserAgent);

  public abstract Object[] roleCodeCheck(String paramString, Long paramLong);

  public abstract Object[] roleDisplayNameCheck(String paramString, Long paramLong);

  public abstract boolean checkRole(String paramString1, String paramString2, Long paramLong, Model paramModel);

  public abstract void insert(Role paramRole, UserAgent paramUserAgent);

  public abstract Role getRoleById(Long paramLong);

  public abstract void update(Role paramRole, UserAgent paramUserAgent);

  public abstract QueryPage getRoleByAuthId(UsersQuery paramUsersQuery);

  public abstract List<Role> getRoleByAuthId(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.RoleService
 * JD-Core Version:    0.6.0
 */