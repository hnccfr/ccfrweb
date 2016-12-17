package com.hundsun.network.gates.fengshan.biz.dao.order;

import com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics;
import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder;
import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderAndPro;
import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderQuery;
import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
import java.util.List;
import java.util.Map;

public abstract interface TradeOrderDAO
{
  public abstract TradeOrder selectByOrderNo(String paramString);

  public abstract void queryTradeOrder(TradeOrderQuery paramTradeOrderQuery);

  @Deprecated
  public abstract int updateByOrderNo(TradeOrder paramTradeOrder);

  public abstract int updateParamByOrderNo(Map<String, Object> paramMap, String paramString);

  public abstract List<TradeOrderAndPro> selectLatestOrderByCounts(TradeOrderQuery paramTradeOrderQuery);

  public abstract List<DateStatistics> queryProjectListingByDate(EnumDateStatisticsType paramEnumDateStatisticsType, Long paramLong);

  public abstract Integer getNumByQuery(TradeOrderQuery paramTradeOrderQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderDAO
 * JD-Core Version:    0.6.0
 */