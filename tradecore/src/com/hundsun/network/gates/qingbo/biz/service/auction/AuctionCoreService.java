package com.hundsun.network.gates.qingbo.biz.service.auction;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallControlServiceRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionFreeBid;
import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLog;
import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionResult;
import com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder;
import java.util.List;
import java.util.Map;

public abstract interface AuctionCoreService
{
  public abstract Map<String, Object> selectSimpleHallByProjectCode(String paramString);

  public abstract ServiceResult auctioneerSetReservePrice(HallControlServiceRequest paramHallControlServiceRequest, AuctionLatestBid paramAuctionLatestBid);

  public abstract Map<String, Object> selectSimpleHallForBidByProjectCode(String paramString);

  public abstract Map<String, Object> selectSimpleHallForEndByProjectCode(String paramString);

  public abstract Map<String, String> selectCurrStatusByProjectCode(String paramString);

  public abstract int updateLatestStatus(Map<String, String> paramMap);

  public abstract AuctionLatestBid selectLatestBidByProjectCode(String paramString);

  public abstract int updateBidRate(Map<String, Object> paramMap);

  public abstract ServiceResult bidderDid(AuctionLatestBid paramAuctionLatestBid, AuctionBidRecord paramAuctionBidRecord, AuctionLog paramAuctionLog);

  public abstract Long insertLog(AuctionLog paramAuctionLog);

  public abstract AuctionBidder selectBidderByBidAccountAndProjectCode(String paramString1, String paramString2);

  public abstract AuctionBidder selectBidderByBidderTrademarkAndProjectCode(String paramString1, String paramString2);

  public abstract AuctionBidder selectLatestBidder(String paramString);

  public abstract int selectBidderNumProjectCode(String paramString);

  public abstract int getRecordsNumByProjectCode(String paramString);

  public abstract int getPriorityRecordsNumByProjectCode(String paramString);

  public abstract TradeOrderServiceResult endAuctionResult(AuctionResult paramAuctionResult);

  public abstract List<TradeWishOrder> selectBSUListByProjectCode(String paramString);

  public abstract void updateWishOrderStatusBatch(List<TradeWishOrder> paramList);

  public abstract List<AuctionFreeBid> selectLastFreeBid(String paramString, Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.auction.AuctionCoreService
 * JD-Core Version:    0.6.0
 */