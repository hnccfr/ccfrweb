package com.hundsun.network.gates.genshan.biz.service.auction;

import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;

public abstract interface TransferOrderService
{
  public abstract TradeOrderServiceResult endAuctionResult(AuctionResult paramAuctionResult);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.auction.TransferOrderService
 * JD-Core Version:    0.6.0
 */