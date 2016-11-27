package com.hundsun.network.gates.fengshan.biz.dao.auction;

import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidRecordHisQuery;

public abstract interface AuctionBidRecordHisDAO
{
  public abstract void queryBidRecordHis(AuctionBidRecordHisQuery paramAuctionBidRecordHisQuery);

  public abstract int existsBidRecord(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionBidRecordHisDAO
 * JD-Core Version:    0.6.0
 */