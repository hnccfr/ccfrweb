package com.hundsun.network.gates.genshan.biz.dao.auction;

import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionFreeBidHis;
import com.hundsun.network.gates.genshan.biz.domain.query.AuctionFreeBidQuery;

public abstract interface AuctionFreeBidHisDAO
{
  public abstract void queryFreeBidHisList(AuctionFreeBidQuery paramAuctionFreeBidQuery);

  public abstract void insert(AuctionFreeBidHis paramAuctionFreeBidHis);

  public abstract AuctionFreeBidHis selectByPrimaryKey(Long paramLong);

  public abstract int selectFreeBidHisCount(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.auction.AuctionFreeBidHisDAO
 * JD-Core Version:    0.6.0
 */