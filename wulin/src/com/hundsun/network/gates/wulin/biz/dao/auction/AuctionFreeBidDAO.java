package com.hundsun.network.gates.wulin.biz.dao.auction;

import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionFreeBid;
import com.hundsun.network.gates.wulin.biz.domain.query.MulitAuctionReviewQuery;

public abstract interface AuctionFreeBidDAO
{
  public abstract Long insert(AuctionFreeBid paramAuctionFreeBid);

  public abstract AuctionFreeBid selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionFreeBid paramAuctionFreeBid);

  public abstract AuctionFreeBid selectTopByMulitAuctionReviewQuery(MulitAuctionReviewQuery paramMulitAuctionReviewQuery);

  public abstract void insertHisFromFreeBidByProjectCode(String paramString);

  public abstract void insertHisWithOutInitData(String paramString);

  public abstract int deleteWithoutInitData(String paramString);

  public abstract int deleteAllByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.auction.AuctionFreeBidDAO
 * JD-Core Version:    0.6.0
 */