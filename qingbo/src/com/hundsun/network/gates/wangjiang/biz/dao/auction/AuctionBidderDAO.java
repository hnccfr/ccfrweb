package com.hundsun.network.gates.wangjiang.biz.dao.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
import java.util.List;
import java.util.Map;

public abstract interface AuctionBidderDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionBidder paramAuctionBidder);

  public abstract AuctionBidder selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionBidder paramAuctionBidder);

  public abstract List<AuctionBidder> selectBidderListByProCode(String paramString);

  public abstract AuctionBidder selectBidderBy(String paramString1, String paramString2);

  public abstract Map<String, String> selectListerAccount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionBidderDAO
 * JD-Core Version:    0.6.0
 */