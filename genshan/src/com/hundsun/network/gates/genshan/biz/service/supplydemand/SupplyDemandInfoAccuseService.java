package com.hundsun.network.gates.genshan.biz.service.supplydemand;

import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoAccuseQuery;
import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAccuse;
import java.util.Map;

public abstract interface SupplyDemandInfoAccuseService
{
  public abstract void selectPageList(SupplyDemandInfoAccuseQuery paramSupplyDemandInfoAccuseQuery);

  public abstract SupplyDemandInfoAccuse selectAccuseById(Long paramLong);

  public abstract SupplyDemandInfo selectInfoById(Long paramLong);

  public abstract int updateAccuse(SupplyDemandInfoAccuse paramSupplyDemandInfoAccuse);

  public abstract int updateOtherAccuse(SupplyDemandInfoAccuse paramSupplyDemandInfoAccuse);

  public abstract int updateInfoStatus(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.supplydemand.SupplyDemandInfoAccuseService
 * JD-Core Version:    0.6.0
 */