package com.hundsun.network.gates.fengshan.biz.dao.trade;

import com.hundsun.network.gates.fengshan.biz.domain.trade.WishOrderAudit;

public abstract interface WishOrderAuditDAO
{
  public abstract Long insert(WishOrderAudit paramWishOrderAudit);

  public abstract int update(WishOrderAudit paramWishOrderAudit);

  public abstract WishOrderAudit selectWishOrderAudit(WishOrderAudit paramWishOrderAudit);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.trade.WishOrderAuditDAO
 * JD-Core Version:    0.6.0
 */