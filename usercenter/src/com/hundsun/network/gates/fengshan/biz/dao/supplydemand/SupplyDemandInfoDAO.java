package com.hundsun.network.gates.fengshan.biz.dao.supplydemand;

import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandInfoQuery;
import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandVisitorsQuery;
import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.AccuseInfo;
import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfo;
import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
import java.util.List;

public abstract interface SupplyDemandInfoDAO
{
  public abstract void selectByQuery2(SupplyDemandInfoQuery paramSupplyDemandInfoQuery);

  public abstract void addSupplyDemandInfo(SupplyDemandInfo paramSupplyDemandInfo);

  public abstract SupplyDemandInfo selectByPrimaryKey(Long paramLong);

  public abstract SupplyDemandInfo selectByPrimaryKey2(Long paramLong);

  public abstract SupplyDemandInfoAudit selectAuditInfoById(Long paramLong);

  public abstract List<AccuseInfo> selectAccuseInfoById(Long paramLong);

  public abstract AccuseInfo selectAccuseReasonById(Long paramLong);

  public abstract void updateStatusById(SupplyDemandInfo paramSupplyDemandInfo);

  public abstract void updateByPrimaryKeySelective(SupplyDemandInfo paramSupplyDemandInfo);

  public abstract int updateInfoOverdue();

  public abstract int updateAccuseInfoOverdue();

  public abstract int deleteInfoMain(SupplyDemandInfo paramSupplyDemandInfo);

  public abstract int deleteInfoAudit(SupplyDemandInfoAudit paramSupplyDemandInfoAudit);

  public abstract int deleteInfoAccuse(Long paramLong);

  public abstract void selectByQuery(SupplyDemandVisitorsQuery paramSupplyDemandVisitorsQuery);

  public abstract SupplyDemandInfo selectByCode(String paramString);

  public abstract void accuseType(AccuseInfo paramAccuseInfo);

  public abstract Integer getNumByQuery(SupplyDemandInfoQuery paramSupplyDemandInfoQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.supplydemand.SupplyDemandInfoDAO
 * JD-Core Version:    0.6.0
 */