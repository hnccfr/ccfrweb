package com.hundsun.network.gates.genshan.biz.dao.fund;

import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountMsg;
import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountReport;
import com.hundsun.network.gates.genshan.biz.domain.fund.FundSettlement;
import com.hundsun.network.gates.genshan.biz.domain.fund.query.FundAccountLogQuery;

public abstract interface FundQueryDAO
{
  public abstract FundSettlement queryFundSettlement(String paramString);

  public abstract void queryFundAccountLogList(FundAccountLogQuery paramFundAccountLogQuery);

  public abstract FundAccountMsg queryFundAccountMsg(String paramString1, String paramString2);

  public abstract FundAccountReport queryFundMoneyHisReport(String paramString1, String paramString2, String paramString3);

  public abstract FundAccountReport queryFundMoneyTotalHisReport(String paramString1, String paramString2);

  public abstract FundAccountReport queryFundMoneyHisReportTotal(String paramString);

  public abstract FundAccountReport queryFundMoneyTotalHisReportTotal(String paramString);

  public abstract FundSettlement queryPlatformSettlement(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.fund.FundQueryDAO
 * JD-Core Version:    0.6.0
 */