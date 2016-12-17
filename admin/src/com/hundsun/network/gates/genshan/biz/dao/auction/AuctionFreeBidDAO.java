package com.hundsun.network.gates.genshan.biz.dao.auction;

import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionFreeBid;
import java.util.List;

public abstract interface AuctionFreeBidDAO
{
  public abstract Long insert(AuctionFreeBid paramAuctionFreeBid);

  public abstract AuctionFreeBid selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionFreeBid paramAuctionFreeBid);

  public abstract List<AuctionFreeBid> selectOneProjectAuctionOfUser(AuctionFreeBid paramAuctionFreeBid);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.auction.AuctionFreeBidDAO
 * JD-Core Version:    0.6.0
 */