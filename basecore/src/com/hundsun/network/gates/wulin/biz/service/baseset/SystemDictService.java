package com.hundsun.network.gates.wulin.biz.service.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
import java.util.List;

public abstract interface SystemDictService
{
  public abstract List<SystemDict> selectCommonChargeSpecial();

  public abstract List<SystemDict> selectListByKey(String paramString);

  public abstract SystemDict selectSingleByKey(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.baseset.SystemDictService
 * JD-Core Version:    0.6.0
 */