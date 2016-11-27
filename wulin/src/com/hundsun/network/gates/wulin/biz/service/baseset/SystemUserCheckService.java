package com.hundsun.network.gates.wulin.biz.service.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemUserCheck;

public abstract interface SystemUserCheckService
{
  public abstract SystemUserCheck selectByRole(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.baseset.SystemUserCheckService
 * JD-Core Version:    0.6.0
 */