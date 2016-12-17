package com.hundsun.network.gates.fengshan.biz.service.auction;

import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidRecordHisQuery;
import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
import com.hundsun.network.gates.luosi.biz.domain.UserAgent;

public abstract interface AuctionBidRecordHisService
{
  public abstract void queryBidRecordHis(AuctionBidRecordHisQuery paramAuctionBidRecordHisQuery);

  public abstract int existsBidRecord(String paramString1, String paramString2);

  public abstract Boolean isOutOfTime(Long paramLong);

  public abstract String loginOut(TradeWishOrder paramTradeWishOrder, UserAgent paramUserAgent);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.auction.AuctionBidRecordHisService
 * JD-Core Version:    0.6.0
 */