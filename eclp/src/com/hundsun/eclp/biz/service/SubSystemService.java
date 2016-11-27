package com.hundsun.eclp.biz.service;

import com.hundsun.eclp.biz.domain.sys.SubSystem;
import java.util.List;

public abstract interface SubSystemService
{
  public abstract List<SubSystem> getSubSystemByUserId(Long paramLong);

  public abstract SubSystem selectById(Long paramLong);

  public abstract SubSystem selectByCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.SubSystemService
 * JD-Core Version:    0.6.0
 */