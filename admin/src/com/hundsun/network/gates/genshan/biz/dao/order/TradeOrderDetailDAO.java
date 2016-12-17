package com.hundsun.network.gates.genshan.biz.dao.order;

import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderDetail;
import java.util.Map;

public abstract interface TradeOrderDetailDAO
{
  public abstract TradeOrderDetail selectByOrderNo(String paramString);

  public abstract TradeOrderDetail selectOrderByMapParam(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderDetailDAO
 * JD-Core Version:    0.6.0
 */