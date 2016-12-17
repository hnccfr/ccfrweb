package com.hundsun.network.gates.wulin.biz.dao.auction;

import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionBidRecordHis;

public abstract interface AuctionBidRecordHisDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionBidRecordHis paramAuctionBidRecordHis);

  public abstract AuctionBidRecordHis selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionBidRecordHis paramAuctionBidRecordHis);

  public abstract void insertHisFromBidRecordByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.auction.AuctionBidRecordHisDAO
 * JD-Core Version:    0.6.0
 */