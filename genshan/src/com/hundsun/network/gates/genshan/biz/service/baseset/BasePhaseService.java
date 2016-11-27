package com.hundsun.network.gates.genshan.biz.service.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.BasePhase;
import com.hundsun.network.gates.genshan.biz.domain.query.BasePhaseQuery;
import java.util.Date;

public abstract interface BasePhaseService
{
  public abstract void queryPhase(BasePhaseQuery<BasePhase> paramBasePhaseQuery);

  public abstract void queryPhaseNext(BasePhaseQuery<BasePhase> paramBasePhaseQuery);

  public abstract BasePhase getBasePhaseById(Long paramLong);

  public abstract void addBasePhase(BasePhase paramBasePhase);

  public abstract void modifyBasePhase(BasePhase paramBasePhase);

  public abstract void delBasePhase(Long paramLong, Date paramDate);

  public abstract void disableBasePhase(Long paramLong, Date paramDate);

  public abstract void enableBasePhase(Long paramLong, Date paramDate);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.BasePhaseService
 * JD-Core Version:    0.6.0
 */