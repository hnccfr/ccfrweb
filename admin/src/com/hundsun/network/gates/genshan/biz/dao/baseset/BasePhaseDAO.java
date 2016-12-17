package com.hundsun.network.gates.genshan.biz.dao.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.BasePhase;
import com.hundsun.network.gates.genshan.biz.domain.query.BasePhaseQuery;

public abstract interface BasePhaseDAO
{
  public abstract void insert(BasePhase paramBasePhase);

  public abstract void businessAdd(BasePhase paramBasePhase);

  public abstract void queryPhase(BasePhaseQuery<BasePhase> paramBasePhaseQuery);

  public abstract void queryPhaseNext(BasePhaseQuery<BasePhase> paramBasePhaseQuery);

  public abstract void logicalDeletePhase(BasePhase paramBasePhase);

  public abstract void physicalDeletePhase(BasePhase paramBasePhase);

  public abstract BasePhase getValidPhase(Long paramLong);

  public abstract BasePhase getBasePhaseById(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.baseset.BasePhaseDAO
 * JD-Core Version:    0.6.0
 */