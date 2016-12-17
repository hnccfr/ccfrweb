package com.hundsun.network.gates.houchao.biz.manager;

import com.hundsun.network.gates.houchao.biz.services.FundCoreTrans;

public abstract interface FundTransFactory
{
  public abstract FundCoreTrans getFundCoreTrans(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.manager.FundTransFactory
 * JD-Core Version:    0.6.0
 */