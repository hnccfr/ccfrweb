package com.hundsun.network.gates.wulin.biz.dao.auction;

import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionHall;
import java.util.HashMap;

public abstract interface AuctionHallDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionHall paramAuctionHall);

  public abstract AuctionHall selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionHall paramAuctionHall);

  public abstract AuctionHall selectByProjectCode(String paramString);

  public abstract int deleteByProjectCode(String paramString);

  public abstract int updateByMap(HashMap<String, Object> paramHashMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.auction.AuctionHallDAO
 * JD-Core Version:    0.6.0
 */