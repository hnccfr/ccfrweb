package com.hundsun.network.gates.fengshan.biz.dao.auction;

import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBidHis;
import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionFreeBidQuery;

public abstract interface AuctionFreeBidHisDAO
{
  public abstract void queryFreeBidHisList(AuctionFreeBidQuery paramAuctionFreeBidQuery);

  public abstract void insert(AuctionFreeBidHis paramAuctionFreeBidHis);

  public abstract AuctionFreeBidHis selectByPrimaryKey(Long paramLong);

  public abstract int selectFreeBidHisCount(String paramString1, String paramString2);

  public abstract int selectBidCountByProjectCode(String paramString);

  public abstract AuctionFreeBidHis selectLastBidRecord(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionFreeBidHisDAO
 * JD-Core Version:    0.6.0
 */