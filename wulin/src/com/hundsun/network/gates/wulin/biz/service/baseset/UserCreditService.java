package com.hundsun.network.gates.wulin.biz.service.baseset;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.wulin.biz.domain.baseset.UserCredit;
import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;

public abstract interface UserCreditService
{
  public abstract Long addInsertUserCredit(String paramString);

  public abstract ServiceResult autoUserCredit(TradeOrder paramTradeOrder, String paramString1, String paramString2);

  public abstract int updateUserCredit(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString3);

  public abstract UserCredit selectByUserAccount(String paramString);

  public abstract int deductUserCredit(String paramString1, String paramString2, Integer paramInteger, String paramString3);

  public abstract Long addUserCreditLog(String paramString1, String paramString2, String paramString3, Short paramShort, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString4, String paramString5, String paramString6);

  public abstract void changeUserCredit(String paramString1, String paramString2, String paramString3, Integer paramInteger, String paramString4, String paramString5);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.baseset.UserCreditService
 * JD-Core Version:    0.6.0
 */