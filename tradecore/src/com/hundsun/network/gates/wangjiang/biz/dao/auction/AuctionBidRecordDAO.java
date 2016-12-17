package com.hundsun.network.gates.wangjiang.biz.dao.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
import java.util.List;

public abstract interface AuctionBidRecordDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionBidRecord paramAuctionBidRecord);

  public abstract AuctionBidRecord selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionBidRecord paramAuctionBidRecord);

  public abstract List<AuctionBidRecord> selectRecordListByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionBidRecordDAO
 * JD-Core Version:    0.6.0
 */