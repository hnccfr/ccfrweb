package com.hundsun.network.gates.genshan.biz.dao.supplydemand;

import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoAccuseQuery;
import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAccuse;

public abstract interface SupplyDemandInfoAccuseDAO
{
  public abstract void selectPageList(SupplyDemandInfoAccuseQuery paramSupplyDemandInfoAccuseQuery);

  public abstract SupplyDemandInfoAccuse selectAccuseById(Long paramLong);

  public abstract int updateAccuse(SupplyDemandInfoAccuse paramSupplyDemandInfoAccuse);

  public abstract int updateOtherAccuse(SupplyDemandInfoAccuse paramSupplyDemandInfoAccuse);

  public abstract Integer getNumByQuery(SupplyDemandInfoAccuseQuery paramSupplyDemandInfoAccuseQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.supplydemand.SupplyDemandInfoAccuseDAO
 * JD-Core Version:    0.6.0
 */