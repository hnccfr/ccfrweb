package com.hundsun.network.gates.qingbo.biz.dao.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall;
import java.util.Map;

public abstract interface AuctionHallCoreDAO
{
  public abstract AuctionHall selectHallByProjectCode(String paramString);

  public abstract Map<String, Object> selectSimpleHallByProjectCode(String paramString);

  public abstract int updateByProjectCode(AuctionHall paramAuctionHall);

  public abstract Map<String, Object> selectSimpleHallForBidByProjectCode(String paramString);

  public abstract Map<String, Object> selectSimpleHallForEndByProjectCode(String paramString);

  public abstract int deleteByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionHallCoreDAO
 * JD-Core Version:    0.6.0
 */