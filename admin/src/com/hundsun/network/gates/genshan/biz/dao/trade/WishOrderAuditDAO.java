package com.hundsun.network.gates.genshan.biz.dao.trade;

import com.hundsun.network.gates.genshan.biz.domain.trade.WishOrderAudit;

public abstract interface WishOrderAuditDAO
{
  public abstract Long insert(WishOrderAudit paramWishOrderAudit);

  public abstract int update(WishOrderAudit paramWishOrderAudit);

  public abstract WishOrderAudit selectWishOrderAudit(WishOrderAudit paramWishOrderAudit);

  public abstract WishOrderAudit selectWishOrderAuditInAudit(WishOrderAudit paramWishOrderAudit);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.trade.WishOrderAuditDAO
 * JD-Core Version:    0.6.0
 */