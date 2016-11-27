package com.hundsun.network.gates.fengshan.biz.dao.auction;

import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBid;
import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionFreeBidQuery;
import java.util.List;

public abstract interface AuctionFreeBidDAO
{
  public abstract void queryFreeBidList(AuctionFreeBidQuery paramAuctionFreeBidQuery);

  public abstract Long insert(AuctionFreeBid paramAuctionFreeBid);

  public abstract AuctionFreeBid selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionFreeBid paramAuctionFreeBid);

  public abstract List<AuctionFreeBid> selectOneProjectAuctionOfUser(AuctionFreeBid paramAuctionFreeBid);

  public abstract int selectFreeBidCount(String paramString1, String paramString2);

  public abstract int selectBidCountByProjectCode(String paramString);

  public abstract AuctionFreeBid selectLatestAuctionFreeBidByTradeMark(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionFreeBidDAO
 * JD-Core Version:    0.6.0
 */