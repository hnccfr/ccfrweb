package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.user.UserInfo;
import com.hundsun.eclp.biz.query.UserInfoQuery;
import java.util.List;
import java.util.Map;

public abstract interface UserInfoDAO
{
  public abstract Long insert(UserInfo paramUserInfo);

  public abstract int update(UserInfo paramUserInfo);

  public abstract List<UserInfo> selectAll(UserInfo paramUserInfo);

  public abstract UserInfo selectByUserId(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract UserInfoQuery serarchByPage(UserInfoQuery paramUserInfoQuery);

  public abstract int batchUpdateDept(List<UserInfo> paramList);

  public abstract UserInfo selectById(Long paramLong);

  public abstract int updateById(UserInfo paramUserInfo);

  public abstract Long getUpUinfoId(Long paramLong);

  public abstract Long getUpUinfoId(Map<String, Object> paramMap);

  public abstract Long getDowmUinfoId(Long paramLong);

  public abstract Long getDowmUinfoId(Map<String, Object> paramMap);

  public abstract int removeDeptId(Long paramLong);

  public abstract Long getMaxSort();

  public abstract int deleteById(Long paramLong);

  public abstract int updateUserInfoById(UserInfo paramUserInfo);

  public abstract UserInfoQuery selectUserInfo(UserInfoQuery paramUserInfoQuery);

  public abstract UserInfo selectByAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.UserInfoDAO
 * JD-Core Version:    0.6.0
 */