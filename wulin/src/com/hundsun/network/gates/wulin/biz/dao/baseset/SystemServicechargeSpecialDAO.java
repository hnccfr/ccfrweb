package com.hundsun.network.gates.wulin.biz.dao.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemServicechargeSpecial;
import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemServicechargeSpecialExt;
import java.util.List;

public abstract interface SystemServicechargeSpecialDAO
{
  public abstract List<SystemServicechargeSpecialExt> selectChargeSpecialByCond(String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong);

  public abstract SystemServicechargeSpecial selectChargeSpecialSystem();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.baseset.SystemServicechargeSpecialDAO
 * JD-Core Version:    0.6.0
 */