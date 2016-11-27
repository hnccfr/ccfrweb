package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.sys.WorkLog;
import com.hundsun.eclp.biz.query.WorkLogQuery;

public abstract interface WorkLogDAO
{
  public abstract void insert(WorkLog paramWorkLog);

  public abstract int update(WorkLog paramWorkLog);

  public abstract WorkLog selectById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract WorkLogQuery serarchByPage(WorkLogQuery paramWorkLogQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.WorkLogDAO
 * JD-Core Version:    0.6.0
 */