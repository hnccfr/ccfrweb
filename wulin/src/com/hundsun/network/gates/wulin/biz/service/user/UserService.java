package com.hundsun.network.gates.wulin.biz.service.user;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.request.UserActivateRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLoginRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.request.UserResetPasswordRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.request.UserUpgradeAuditRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.result.CancleAccountResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.UserResetPWDResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;

public abstract interface UserService
{
  public abstract UserServiceResult login(UserAccount paramUserAccount, String paramString);

  public abstract UserServiceResult register(UserAccount paramUserAccount);

  public abstract UserServiceResult specialRegister(UserAccount paramUserAccount);

  public abstract ServiceResult activate(String paramString1, String paramString2);

  public abstract ServiceResult fundActivate(UserActivateRequest paramUserActivateRequest);

  public abstract UserServiceResult checkFundActivate(UserActivateRequest paramUserActivateRequest);

  public abstract ServiceResult checkFundOut(String paramString);

  public abstract ServiceResult resetPassword(String paramString1, String paramString2, String paramString3);

  public abstract UserResetPWDResult updatePassword(UserResetPasswordRequest paramUserResetPasswordRequest);

  public abstract UserAccount addUserAccount(UserAccount paramUserAccount);

  public abstract ServiceResult userUpgradeAudit(UserUpgradeAuditRequest paramUserUpgradeAuditRequest);

  public abstract boolean checkPayPwd(String paramString1, String paramString2);

  public abstract ServiceResult resetFundPwd(UserResetPasswordRequest paramUserResetPasswordRequest);

  public abstract UserServiceResult getUserMsgByAccount(UserLoginRequest paramUserLoginRequest);

  public abstract CancleAccountResult deleteUserValidate(String paramString);

  public abstract CancleAccountResult cancleAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.user.UserService
 * JD-Core Version:    0.6.0
 */