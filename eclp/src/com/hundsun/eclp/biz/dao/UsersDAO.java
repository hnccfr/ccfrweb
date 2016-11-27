package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.user.Users;
import com.hundsun.eclp.biz.query.UsersQuery;
import java.util.List;

public abstract interface UsersDAO
{
  public abstract int delete(Long paramLong);

  public abstract Long insert(Users paramUsers);

  public abstract int update(Users paramUsers);

  public abstract Users selectById(Long paramLong);

  public abstract List<Users> select(Users paramUsers);

  public abstract UsersQuery serarchByPage(UsersQuery paramUsersQuery);

  public abstract List<Users> selectNotReleUsers();

  public abstract UsersQuery selectByAuthId(UsersQuery paramUsersQuery);

  public abstract UsersQuery selectUsersByRoleId(UsersQuery paramUsersQuery);

  public abstract List<Users> selectUsersListByRoleId(Long paramLong);

  public abstract List<Users> selectListByRoleList(UsersQuery paramUsersQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.UsersDAO
 * JD-Core Version:    0.6.0
 */