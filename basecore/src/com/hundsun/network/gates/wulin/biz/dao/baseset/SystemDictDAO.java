package com.hundsun.network.gates.wulin.biz.dao.baseset;

import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
import java.util.List;
import java.util.Map;

public abstract interface SystemDictDAO
{
  public abstract List<SystemDict> selectCommonChargeSpecial(String[] paramArrayOfString);

  public abstract List<SystemDict> selectListByKey(String paramString);

  public abstract SystemDict selectSingleByKey(String paramString);

  public abstract Map<String, SystemDict> selectListByMultiKey(List<EnumSystemDictKey> paramList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.baseset.SystemDictDAO
 * JD-Core Version:    0.6.0
 */