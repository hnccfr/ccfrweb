package com.hundsun.network.gates.houchao.biz.dao.fund;

import java.util.Map;

public abstract interface DailyEndProcess
{
  public abstract void dailyEndDataBackup(Map<String, String> paramMap);

  public abstract void dailyEndAfterBackup(Map<String, String> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.DailyEndProcess
 * JD-Core Version:    0.6.0
 */