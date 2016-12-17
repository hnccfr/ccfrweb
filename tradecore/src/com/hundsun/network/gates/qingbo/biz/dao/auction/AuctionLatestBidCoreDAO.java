package com.hundsun.network.gates.qingbo.biz.dao.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
import com.hundsun.network.gates.qingbo.biz.domain.auction.ControlAuction;
import java.util.List;
import java.util.Map;

public abstract interface AuctionLatestBidCoreDAO
{
  public abstract AuctionLatestBid selectLBByProjectCode(String paramString);

  public abstract Map<String, String> selectCurrStatusByProjectCode(String paramString);

  public abstract int updateLatestStatus(Map<String, String> paramMap);

  public abstract int updateBidRate(Map<String, Object> paramMap);

  public abstract int updateLatestStatusInDid(AuctionLatestBid paramAuctionLatestBid);

  public abstract List<ControlAuction> selectAutoControlLists();

  public abstract int deleteByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionLatestBidCoreDAO
 * JD-Core Version:    0.6.0
 */