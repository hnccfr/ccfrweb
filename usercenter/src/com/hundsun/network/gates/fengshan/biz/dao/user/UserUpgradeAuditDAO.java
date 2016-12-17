package com.hundsun.network.gates.fengshan.biz.dao.user;

import com.hundsun.network.gates.fengshan.biz.domain.user.UserUpgradeAudit;

public abstract interface UserUpgradeAuditDAO
{
  public abstract UserUpgradeAudit selectAuditByUserAccount(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract Integer updateAuditByUserAccount(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract Long insertAuditByUserAccount(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract UserUpgradeAudit selectRecentAuditResult(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.user.UserUpgradeAuditDAO
 * JD-Core Version:    0.6.0
 */