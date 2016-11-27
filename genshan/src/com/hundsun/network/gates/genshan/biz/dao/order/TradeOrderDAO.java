package com.hundsun.network.gates.genshan.biz.dao.order;

import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderQuery;
import java.util.List;
import java.util.Map;

public abstract interface TradeOrderDAO
{
  public abstract TradeOrder selectByOrderNo(String paramString);

  public abstract void queryTradeOrder(TradeOrderQuery paramTradeOrderQuery);

  @Deprecated
  public abstract int updateByOrderNo(TradeOrder paramTradeOrder);

  public abstract int updateParamByOrderNo(Map<String, Object> paramMap, String paramString);

  public abstract Integer getNumByQuery(TradeOrderQuery paramTradeOrderQuery);

  public abstract List<TradeOrder> selectByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderDAO
 * JD-Core Version:    0.6.0
 */