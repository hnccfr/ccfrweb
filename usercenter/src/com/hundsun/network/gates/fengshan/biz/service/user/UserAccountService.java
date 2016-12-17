package com.hundsun.network.gates.fengshan.biz.service.user;

import com.hundsun.network.gates.fengshan.biz.domain.query.EvaluateQuery;
import com.hundsun.network.gates.fengshan.biz.domain.user.UserAccount;
import com.hundsun.network.gates.fengshan.biz.domain.user.UserCredit;
import com.hundsun.network.gates.fengshan.biz.domain.user.UserLevel;
import com.hundsun.network.gates.fengshan.biz.domain.user.UserLogin;
import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.CancleAccountResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;

public abstract interface UserAccountService
{
  public abstract UserServiceResult login(UserLogin paramUserLogin);

  public abstract List<Integer> getUserPermissions(Long paramLong);

  public abstract UserServiceResult register(UserAccount paramUserAccount);

  public abstract ServiceResult activate(String paramString1, String paramString2);

  public abstract Long selectByParaMap(Map<String, Object> paramMap);

  public abstract ServiceResult resetPassword(String paramString1, String paramString2, String paramString3);

  public abstract UserAccount getUserAccountByAccount(String paramString);

  public abstract UserAccount getUserAccountById(Long paramLong);

  public abstract int changeUserAccount(UserAccount paramUserAccount);

  public abstract UserLevel getUserLevelByUserAccount(String paramString);

  public abstract UserCredit getUserCreditLevelUserAccount(String paramString);

  public abstract void getEvaluateList(EvaluateQuery paramEvaluateQuery);

  public abstract UserAccount getFundInfoByAccount(String paramString);

  public abstract CancleAccountResult applyCancle(UserAccount paramUserAccount, String paramString);

  public abstract void initIssueTodo(Model paramModel, String paramString);

  public abstract void initIssueTodoForAuctioneer(Model paramModel, String paramString);

  public abstract void initIssueTodoForReviewer(Model paramModel, String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.user.UserAccountService
 * JD-Core Version:    0.6.0
 */