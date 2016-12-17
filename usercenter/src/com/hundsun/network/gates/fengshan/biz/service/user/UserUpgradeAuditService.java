package com.hundsun.network.gates.fengshan.biz.service.user;

import com.hundsun.network.gates.fengshan.biz.domain.user.UserUpgradeAudit;
import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemUserCheckRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemUserCheckResult;

public abstract interface UserUpgradeAuditService
{
  public abstract UserUpgradeAudit getAuditByUserAccount(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract Integer changeAuditByUserAccount(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract Long addAuditByUserAccount(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract Integer upGradeUserRole(UserUpgradeAudit paramUserUpgradeAudit, String paramString);

  public abstract SystemUserCheckResult getCheckProcess(SystemUserCheckRequest paramSystemUserCheckRequest);

  public abstract UserUpgradeAudit getRecentAuditResult(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.user.UserUpgradeAuditService
 * JD-Core Version:    0.6.0
 */