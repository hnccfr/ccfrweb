package com.hundsun.network.gates.fengshan.biz.service.supplydemand;

import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandInfoQuery;
import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandVisitorsQuery;
import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.AccuseInfo;
import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfo;
import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
import java.util.List;

public abstract interface SupplyDemandInfoService
{
  public abstract void getSupplyDemandByQuery(SupplyDemandVisitorsQuery paramSupplyDemandVisitorsQuery);

  public abstract SupplyDemandInfo getSupplyDemandByCode(String paramString);

  public abstract String accuseType(AccuseInfo paramAccuseInfo, long paramLong, String paramString);

  public abstract void getSupplyDemandInfoByQuery(SupplyDemandInfoQuery paramSupplyDemandInfoQuery);

  public abstract void addSupplyDemandInfo(SupplyDemandInfo paramSupplyDemandInfo);

  public abstract SupplyDemandInfo getSupplyDemandInfoById(Long paramLong);

  public abstract SupplyDemandInfo getSupplyDemandInfoById2(Long paramLong);

  public abstract SupplyDemandInfoAudit getSupplyDemandInfoAuditById(Long paramLong);

  public abstract List<AccuseInfo> getSupplyDemandInfoAccuseById(Long paramLong);

  public abstract AccuseInfo getAccuseReasonById(Long paramLong);

  public abstract String projectCodeCreator(SupplyDemandInfo paramSupplyDemandInfo);

  public abstract void updateSupplyDemandInfoStatusById(SupplyDemandInfo paramSupplyDemandInfo);

  public abstract void updateSupplyDemandInfo(SupplyDemandInfo paramSupplyDemandInfo);

  public abstract int updateSupplyDemandInfoOverdue();

  public abstract int updateSupplyDemandInfoAccuseOverdue();

  public abstract int deleteSupplyDemandInfoById(SupplyDemandInfo paramSupplyDemandInfo);

  public abstract int deleteSupplyDemandInfoAuditById(SupplyDemandInfoAudit paramSupplyDemandInfoAudit);

  public abstract int deleteSupplyDemandInfoAccuseById(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.supplydemand.SupplyDemandInfoService
 * JD-Core Version:    0.6.0
 */