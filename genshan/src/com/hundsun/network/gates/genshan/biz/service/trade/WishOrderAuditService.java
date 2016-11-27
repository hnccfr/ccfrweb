package com.hundsun.network.gates.genshan.biz.service.trade;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.genshan.biz.domain.trade.WishOrderAudit;
import com.hundsun.network.gates.genshan.common.UserAgent;

public abstract interface WishOrderAuditService
{
  public abstract Long addWishOrderAudit(WishOrderAudit paramWishOrderAudit);

  public abstract int updateWishOrderAudit(WishOrderAudit paramWishOrderAudit);

  public abstract WishOrderAudit getWishOrderAudit(WishOrderAudit paramWishOrderAudit);

  public abstract WishOrderAudit selectWishOrderAuditInAudit(WishOrderAudit paramWishOrderAudit);

  public abstract String auditWishOrder(String paramString1, UserAgent paramUserAgent, Long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, ProjectListing paramProjectListing);

  public abstract Boolean isOutOfTime(Long paramLong);

  public abstract String getTradeMark(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.trade.WishOrderAuditService
 * JD-Core Version:    0.6.0
 */