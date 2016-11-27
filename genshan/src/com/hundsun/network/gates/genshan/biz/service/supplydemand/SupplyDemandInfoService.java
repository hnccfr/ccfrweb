package com.hundsun.network.gates.genshan.biz.service.supplydemand;

import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoQuery;
import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAccuse;
import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
import java.util.Map;

public abstract interface SupplyDemandInfoService
{
  public abstract void selectPageList(SupplyDemandInfoQuery paramSupplyDemandInfoQuery);

  public abstract SupplyDemandInfo getAuditByInfoId(Long paramLong);

  public abstract void insertAudit(SupplyDemandInfoAudit paramSupplyDemandInfoAudit);

  public abstract int updateAudit(SupplyDemandInfoAudit paramSupplyDemandInfoAudit);

  public abstract int updateOtherAccuse(SupplyDemandInfoAccuse paramSupplyDemandInfoAccuse);

  public abstract SupplyDemandInfoAudit selectAuditByInfoId(Long paramLong);

  public abstract SupplyDemandInfo selectInfoById(Long paramLong);

  public abstract int updateInfoStatus(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.supplydemand.SupplyDemandInfoService
 * JD-Core Version:    0.6.0
 */