package com.hundsun.network.gates.wulin.biz.dao.user;

import com.hundsun.network.gates.wulin.biz.domain.user.UserUpgradeAudit;

public abstract interface UserUpgradeAuditDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract UserUpgradeAudit selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(UserUpgradeAudit paramUserUpgradeAudit);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.user.UserUpgradeAuditDAO
 * JD-Core Version:    0.6.0
 */