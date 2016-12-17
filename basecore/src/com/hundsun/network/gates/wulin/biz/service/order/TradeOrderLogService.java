package com.hundsun.network.gates.wulin.biz.service.order;

import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderLog;
import java.util.List;

public abstract interface TradeOrderLogService
{
  public abstract Long insert(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);

  public abstract List<TradeOrderLog> selectByOrderNo(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.order.TradeOrderLogService
 * JD-Core Version:    0.6.0
 */