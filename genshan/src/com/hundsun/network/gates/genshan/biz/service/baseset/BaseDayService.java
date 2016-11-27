package com.hundsun.network.gates.genshan.biz.service.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.BaseDay;
import com.hundsun.network.gates.luosi.wulin.reomte.result.BaseDayServiceResult;
import java.util.Date;
import java.util.List;

public abstract interface BaseDayService
{
  public abstract List<BaseDay> getBaseDay(BaseDay paramBaseDay);

  public abstract void addBaseDay(List<Date> paramList, int paramInt, Date paramDate, String paramString);

  public abstract BaseDayServiceResult getTradeDay();

  public abstract BaseDayServiceResult addWorkDay(Date paramDate, String paramString);

  public abstract BaseDayServiceResult initTradeDay(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.BaseDayService
 * JD-Core Version:    0.6.0
 */