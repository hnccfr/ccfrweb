package com.hundsun.network.gates.qingbo.biz.dao.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionFreeBid;
import java.util.List;

public abstract interface AuctionFreeBidCoreDAO
{
  public abstract void insert(AuctionFreeBid paramAuctionFreeBid);

  public abstract AuctionFreeBid selectByPrimaryKey(Long paramLong);

  public abstract List<AuctionFreeBid> selectLastFreeBid(String paramString, Long paramLong);

  public abstract void insertHisFromFreeBidByProjectCode(String paramString);

  public abstract int deleteByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionFreeBidCoreDAO
 * JD-Core Version:    0.6.0
 */