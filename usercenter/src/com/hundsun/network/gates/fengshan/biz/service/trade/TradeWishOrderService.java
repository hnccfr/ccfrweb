package com.hundsun.network.gates.fengshan.biz.service.trade;

import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.fengshan.biz.domain.query.TradeWishOrderQuery;
import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryRequest;
import com.hundsun.network.gates.luosi.houchao.reomte.result.FundQueryResult;

public abstract interface TradeWishOrderService
{
  public abstract void getTradeWishOrderByQuery(TradeWishOrderQuery paramTradeWishOrderQuery);

  public abstract TradeWishOrder getTradeWishOrderByOrderNum(String paramString);

  public abstract Long addTradeWishOrder(TradeWishOrder paramTradeWishOrder);

  public abstract FundQueryResult getfundInfo(FundQueryRequest paramFundQueryRequest);

  public abstract String generatorWishOrderNo();

  public abstract Long depositGenerator(String paramString, ProjectListing paramProjectListing, Long paramLong);

  public abstract int modifyTradeWishOrder(TradeWishOrder paramTradeWishOrder, String paramString);

  public abstract String isApplyTime(Long paramLong);

  public abstract int changeWishOrderStatus(TradeWishOrder paramTradeWishOrder);

  public abstract int getCountOfMyWishOrder(TradeWishOrder paramTradeWishOrder);

  public abstract int existsWishOrderBidBuyer(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.trade.TradeWishOrderService
 * JD-Core Version:    0.6.0
 */