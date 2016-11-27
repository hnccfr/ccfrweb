package com.hundsun.eclp.biz.service.sys;

import com.hundsun.eclp.biz.domain.user.UserAgent;
import com.hundsun.eclp.biz.query.WorkLogQuery;

public abstract interface WorkLogService
{
  public abstract void addWorkLog(String paramString1, String paramString2, UserAgent paramUserAgent);

  public abstract WorkLogQuery selectWorkLogByPage(WorkLogQuery paramWorkLogQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.sys.WorkLogService
 * JD-Core Version:    0.6.0
 */