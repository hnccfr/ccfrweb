package com.hundsun.network.gates.genshan.biz.dao.user;

import com.hundsun.network.gates.genshan.biz.domain.query.UserAccountQuery;
import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
import com.hundsun.network.gates.genshan.biz.domain.user.UserRole;
import java.util.List;
import java.util.Map;

public abstract interface UserAccountDAO
{
  public abstract void selectUserAccountList(UserAccountQuery paramUserAccountQuery);

  public abstract UserAccount selectUserByAccount(String paramString);

  public abstract int updateUserStatus(UserAccount paramUserAccount);

  public abstract List<UserRole> selectRoleList();

  public abstract List<String> selectAccountList(List<String> paramList);

  public abstract Long selectByParaMap(Map<String, Object> paramMap);

  public abstract UserAccount getUserByFundAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.user.UserAccountDAO
 * JD-Core Version:    0.6.0
 */