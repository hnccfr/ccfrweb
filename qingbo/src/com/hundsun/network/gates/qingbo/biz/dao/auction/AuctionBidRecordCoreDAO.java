package com.hundsun.network.gates.qingbo.biz.dao.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
import java.util.List;

public abstract interface AuctionBidRecordCoreDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionBidRecord paramAuctionBidRecord);

  public abstract AuctionBidRecord selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionBidRecord paramAuctionBidRecord);

  public abstract List<AuctionBidRecord> selectRecordListByProjectCode(String paramString);

  public abstract int getRecordsNumByProjectCode(String paramString);

  public abstract int getPriorityRecordsNumByProjectCode(String paramString);

  public abstract int deleteByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionBidRecordCoreDAO
 * JD-Core Version:    0.6.0
 */