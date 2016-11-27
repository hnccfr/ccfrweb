package com.hundsun.eclp.biz.service;

import com.hundsun.eclp.biz.domain.user.UserAgent;
import com.hundsun.eclp.biz.domain.user.Users;
import com.hundsun.eclp.biz.query.UsersQuery;
import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
import java.util.List;

public abstract interface UsersService
{
  public abstract UsersQuery selectUsersByPage(UsersQuery paramUsersQuery);

  public abstract boolean addUser(Users paramUsers, UserAgent paramUserAgent);

  public abstract boolean login(Users paramUsers, String paramString1, String paramString2, Cookyjar paramCookyjar);

  public abstract Users getUserByAccount(String paramString);

  public abstract boolean updateUserStatus(Users paramUsers, UserAgent paramUserAgent);

  public abstract Users selectUserById(Long paramLong);

  public abstract boolean deleteUserById(Long paramLong, UserAgent paramUserAgent);

  public abstract boolean resetPassword(Users paramUsers, UserAgent paramUserAgent);

  public abstract boolean updateUserPassword(Users paramUsers, UserAgent paramUserAgent);

  public abstract boolean updateUserWithInfo(Users paramUsers, UserAgent paramUserAgent);

  public abstract Users getUserByID(long paramLong);

  public abstract List<Users> getUserList();

  public abstract List<Users> selectNotReleUsers();

  public abstract boolean checkAccountAndPassword(Users paramUsers);

  public abstract Users queryUserByAccount(String paramString);

  public abstract UsersQuery selectUsersByAuth(Long paramLong1, Long paramLong2, UsersQuery paramUsersQuery);

  public abstract UsersQuery selectUsersByRoleId(UsersQuery paramUsersQuery);

  public abstract List<Users> selectUsersListByRoleId(Long paramLong);

  public abstract List<Users> selectListByRoleList(Long paramLong1, Long paramLong2, UsersQuery paramUsersQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.UsersService
 * JD-Core Version:    0.6.0
 */