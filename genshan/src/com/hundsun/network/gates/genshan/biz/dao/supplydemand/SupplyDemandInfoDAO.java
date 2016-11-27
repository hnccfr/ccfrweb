package com.hundsun.network.gates.genshan.biz.dao.supplydemand;

import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoQuery;
import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
import java.util.Map;

public abstract interface SupplyDemandInfoDAO
{
  public abstract void selectPageList(SupplyDemandInfoQuery paramSupplyDemandInfoQuery);

  public abstract SupplyDemandInfo getAuditByInfoId(Long paramLong);

  public abstract SupplyDemandInfo selectInfoById(Long paramLong);

  public abstract int updateInfoStatus(Map<String, Object> paramMap);

  public abstract void insertInfoAudit(SupplyDemandInfoAudit paramSupplyDemandInfoAudit);

  public abstract int updateInfoAudit(SupplyDemandInfoAudit paramSupplyDemandInfoAudit);

  public abstract Integer getNumByQuery(SupplyDemandInfoQuery paramSupplyDemandInfoQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoDAO
 * JD-Core Version:    0.6.0
 */