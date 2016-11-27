package com.hundsun.eclp.biz.service;

import com.hundsun.eclp.biz.domain.sys.SysConfig;
import java.util.List;

public abstract interface SysConfigService
{
  public abstract SysConfig selectSysConfigByCode(String paramString);

  public abstract List<SysConfig> selectAllSysConfig();

  public abstract SysConfig selectById(Long paramLong);

  public abstract int update(SysConfig paramSysConfig);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.SysConfigService
 * JD-Core Version:    0.6.0
 */