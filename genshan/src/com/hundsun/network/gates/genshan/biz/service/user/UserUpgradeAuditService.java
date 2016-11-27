package com.hundsun.network.gates.genshan.biz.service.user;

import com.hundsun.network.gates.genshan.biz.domain.query.AccountAndUpgradeInfoQuery;
import com.hundsun.network.gates.genshan.biz.domain.user.UserUpgradeAudit;
import com.hundsun.network.gates.luosi.common.remote.ServiceResult;

public abstract interface UserUpgradeAuditService
{
  public abstract void getUserOfAudit(AccountAndUpgradeInfoQuery paramAccountAndUpgradeInfoQuery);

  public abstract UserUpgradeAudit getAuditById(Long paramLong);

  public abstract ServiceResult auditUserUpgrade(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract void sendSystemMessage(UserUpgradeAudit paramUserUpgradeAudit, String paramString1, String paramString2);

  public abstract Integer getNumOfAudit();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.user.UserUpgradeAuditService
 * JD-Core Version:    0.6.0
 */