package com.hundsun.network.gates.genshan.biz.dao.auction;

import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionLog;
import java.util.List;

public abstract interface AuctionLogDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(AuctionLog paramAuctionLog);

  public abstract AuctionLog selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionLog paramAuctionLog);

  public abstract void batchInsert(List<AuctionLog> paramList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.auction.AuctionLogDAO
 * JD-Core Version:    0.6.0
 */