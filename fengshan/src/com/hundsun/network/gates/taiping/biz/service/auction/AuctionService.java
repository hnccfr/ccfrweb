package com.hundsun.network.gates.taiping.biz.service.auction;

import com.hundsun.network.gates.luosi.common.enums.EnumAuctionLatestStatus;
import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallBidServiceRequest;
import com.hundsun.network.gates.luosi.wangjiang.reomte.result.HallServiceResult;

public abstract interface AuctionService
{
  public abstract HallServiceResult joinAuctionHall(String paramString1, String paramString2, String paramString3);

  public abstract ServiceResult bidderDid(HallBidServiceRequest paramHallBidServiceRequest);

  public abstract ServiceResult auctioneerSetReservePrice(String paramString1, String paramString2, Long paramLong);

  public abstract ServiceResult auctioneerUpdateBidRate(String paramString1, String paramString2, Long paramLong);

  public abstract ServiceResult auctioneerDo(String paramString1, String paramString2, EnumAuctionLatestStatus paramEnumAuctionLatestStatus);

  public abstract ServiceResult auctioneerDo(String paramString1, String paramString2, String paramString3, String paramString4);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.auction.AuctionService
 * JD-Core Version:    0.6.0
 */