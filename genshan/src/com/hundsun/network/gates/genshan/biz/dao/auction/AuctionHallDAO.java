package com.hundsun.network.gates.genshan.biz.dao.auction;

import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionHall;
import java.util.List;

public abstract interface AuctionHallDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(AuctionHall paramAuctionHall);

  public abstract AuctionHall selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionHall paramAuctionHall);

  public abstract void batchInsert(List<AuctionHall> paramList);

  public abstract AuctionHall selectByProjectCode(String paramString);

  public abstract int updatePriorityNumById(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.auction.AuctionHallDAO
 * JD-Core Version:    0.6.0
 */