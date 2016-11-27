package com.hundsun.network.gates.genshan.biz.service.user;

import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
import com.hundsun.network.gates.genshan.biz.domain.query.UserAccountQuery;
import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
import com.hundsun.network.gates.genshan.biz.domain.user.UserCreditInfo;
import com.hundsun.network.gates.genshan.biz.domain.user.UserRole;
import com.hundsun.network.gates.luosi.wulin.reomte.result.UserResetPWDResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;

public abstract interface UserAccountService
{
  public abstract void getUserAccountList(UserAccountQuery paramUserAccountQuery);

  public abstract UserAccount getUserByAccount(String paramString);

  public abstract UserResetPWDResult resetUserPwd(String paramString1, String paramString2, String paramString3);

  public abstract UserLevel getUserLevelByUserAccount(String paramString);

  public abstract int changeUserStatus(UserAccount paramUserAccount);

  public abstract UserCreditInfo getUserCreditByUserAccount(String paramString);

  public abstract List<UserRole> getRoleList();

  public abstract UserServiceResult userAdd(UserAccount paramUserAccount);

  public abstract UserServiceResult userAuctioneer(UserAccount paramUserAccount);

  public abstract Long selectByParaMap(Map<String, Object> paramMap);

  public abstract UserServiceResult addReviewer(UserAccount paramUserAccount);

  public abstract void initIssueTodo(Model paramModel);

  public abstract UserAccount getUserByFundAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.user.UserAccountService
 * JD-Core Version:    0.6.0
 */