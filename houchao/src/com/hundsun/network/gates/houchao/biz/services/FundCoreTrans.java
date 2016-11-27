package com.hundsun.network.gates.houchao.biz.services;

import com.hundsun.network.gates.houchao.biz.domain.acctrans.TransReq;
import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;

public abstract interface FundCoreTrans
{
  public abstract EnumFundResultCode execute(TransReq paramTransReq);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.FundCoreTrans
 * JD-Core Version:    0.6.0
 */