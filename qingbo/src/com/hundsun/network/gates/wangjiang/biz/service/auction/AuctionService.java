package com.hundsun.network.gates.wangjiang.biz.service.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall;
import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
import java.util.List;
import java.util.Map;

public abstract interface AuctionService
{
  public abstract List<AuctionBidder> selectBidderListByProCode(String paramString);

  public abstract AuctionBidder selectBidderBy(String paramString1, String paramString2);

  public abstract Map<String, String> selectListerAccount(String paramString);

  public abstract List<AuctionBidRecord> selectRecordListByProjectCode(String paramString);

  public abstract AuctionHall selectHallByProjectCode(String paramString);

  public abstract AuctionLatestBid selectLBByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.service.auction.AuctionService
 * JD-Core Version:    0.6.0
 */