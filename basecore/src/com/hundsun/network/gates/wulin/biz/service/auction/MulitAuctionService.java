package com.hundsun.network.gates.wulin.biz.service.auction;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.request.AuctionMulitBidRequest;
import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionFreeBid;

public abstract interface MulitAuctionService
{
  public abstract ServiceResult review(AuctionMulitBidRequest paramAuctionMulitBidRequest);

  public abstract AuctionFreeBid queryTopUncheckFreeBid(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.auction.MulitAuctionService
 * JD-Core Version:    0.6.0
 */