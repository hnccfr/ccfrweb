package com.hundsun.network.gates.genshan.biz.dao.supplydemand;

import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAudit;

public abstract interface SupplyDemandInfoAuditDAO
{
  public abstract SupplyDemandInfoAudit selectAuditByInfoId(Long paramLong);

  public abstract void insertAudit(SupplyDemandInfoAudit paramSupplyDemandInfoAudit);

  public abstract int updateAudit(SupplyDemandInfoAudit paramSupplyDemandInfoAudit);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoAuditDAO
 * JD-Core Version:    0.6.0
 */