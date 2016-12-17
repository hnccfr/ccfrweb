package com.hundsun.network.gates.wangjiang.biz.dao.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall;

public abstract interface AuctionHallDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionHall paramAuctionHall);

  public abstract AuctionHall selectByPrimaryKey(Long paramLong);

  public abstract AuctionHall selectHallByProjectCode(String paramString);

  public abstract int updateByPrimaryKeySelective(AuctionHall paramAuctionHall);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionHallDAO
 * JD-Core Version:    0.6.0
 */