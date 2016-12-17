package com.hundsun.network.gates.wulin.biz.dao.order;

import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderAndPro;
import com.hundsun.network.gates.wulin.biz.domain.query.TradeOrderQuery;
import java.util.List;
import java.util.Map;

public abstract interface TradeOrderDAO
{
  public abstract String generalOrderNo();

  public abstract Long insert(TradeOrder paramTradeOrder);

  public abstract int updateByOrderNo(TradeOrder paramTradeOrder);

  public abstract TradeOrder selectByOrderNo(String paramString);

  public abstract int deleteByOrderNo(String paramString);

  public abstract int updateParamByOrderNo(Map<String, Object> paramMap, String paramString);

  public abstract List<TradeOrder> queryTradeOrderByCondition(TradeOrderQuery paramTradeOrderQuery);

  public abstract List<TradeOrderAndPro> selectLatestOrderByCounts(TradeOrderQuery paramTradeOrderQuery);

  public abstract int selectNumOfUnfinishedOrder(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO
 * JD-Core Version:    0.6.0
 */