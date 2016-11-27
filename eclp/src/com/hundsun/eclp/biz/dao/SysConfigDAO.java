package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.sys.SysConfig;
import java.util.List;

public abstract interface SysConfigDAO
{
  public abstract void insert(SysConfig paramSysConfig);

  public abstract int update(SysConfig paramSysConfig);

  public abstract SysConfig selectById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract SysConfig selectSysConfigByCode(String paramString);

  public abstract List<SysConfig> selectAllSysConfig();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.SysConfigDAO
 * JD-Core Version:    0.6.0
 */