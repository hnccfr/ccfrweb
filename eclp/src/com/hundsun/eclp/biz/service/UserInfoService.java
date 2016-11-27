package com.hundsun.eclp.biz.service;

import com.hundsun.eclp.biz.domain.user.UserAgent;
import com.hundsun.eclp.biz.domain.user.UserInfo;
import com.hundsun.eclp.biz.query.UserInfoQuery;

public abstract interface UserInfoService
{
  public abstract UserInfo selectUserInfoByUserId(Long paramLong);

  public abstract UserInfo selectUserInfoById(Long paramLong);

  public abstract UserInfoQuery selectUserInfoByPage(UserInfoQuery paramUserInfoQuery);

  public abstract boolean addUInfo(UserInfo paramUserInfo, UserAgent paramUserAgent);

  public abstract boolean uppUInfo(UserInfo paramUserInfo, UserAgent paramUserAgent);

  public abstract boolean updateUserWithInfo(UserInfo paramUserInfo, UserAgent paramUserAgent);

  public abstract boolean deleteUInfoById(Long paramLong, UserAgent paramUserAgent);

  public abstract boolean setDept(Long paramLong1, Long paramLong2, UserAgent paramUserAgent);

  public abstract boolean removeDept(Long paramLong);

  public abstract void modifyPosition(Long paramLong, String paramString1, UserAgent paramUserAgent, String paramString2);

  public abstract boolean updateUinfoStatus(Long paramLong, UserAgent paramUserAgent);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.UserInfoService
 * JD-Core Version:    0.6.0
 */