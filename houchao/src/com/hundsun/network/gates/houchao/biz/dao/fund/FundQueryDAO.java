package com.hundsun.network.gates.houchao.biz.dao.fund;

import com.hundsun.network.gates.houchao.biz.domain.fund.query.FundInOutDetailQuery;
import com.hundsun.network.gates.luosi.houchao.reomte.dto.FundInOutDetailDTO;

public abstract interface FundQueryDAO
{
  public abstract void queryFundInOut(FundInOutDetailQuery<FundInOutDetailDTO> paramFundInOutDetailQuery);

  public abstract int queryFundInOutTotal(FundInOutDetailQuery<FundInOutDetailDTO> paramFundInOutDetailQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.FundQueryDAO
 * JD-Core Version:    0.6.0
 */