package com.hundsun.network.gates.genshan.biz.dao.auction;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
import java.util.List;
import java.util.Map;

public abstract interface AuctionActiveDAO
{
  public abstract List<ProjectListing> getAuctionProjectList();

  public abstract List<TradeWishOrder> getAuctionBidderList(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.auction.AuctionActiveDAO
 * JD-Core Version:    0.6.0
 */