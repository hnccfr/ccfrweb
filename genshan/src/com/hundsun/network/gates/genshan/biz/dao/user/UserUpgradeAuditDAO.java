package com.hundsun.network.gates.genshan.biz.dao.user;

import com.hundsun.network.gates.genshan.biz.domain.query.AccountAndUpgradeInfoQuery;
import com.hundsun.network.gates.genshan.biz.domain.user.UserUpgradeAudit;

public abstract interface UserUpgradeAuditDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract void insertSelective(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract UserUpgradeAudit selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract int updateByPrimaryKey(UserUpgradeAudit paramUserUpgradeAudit);

  public abstract void selectUserOfAudit(AccountAndUpgradeInfoQuery paramAccountAndUpgradeInfoQuery);

  public abstract Integer selectNumOfAudit();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.user.UserUpgradeAuditDAO
 * JD-Core Version:    0.6.0
 */