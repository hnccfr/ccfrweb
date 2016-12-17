package com.hundsun.network.gates.genshan.biz.dao.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemServicechargeSpecial;
import com.hundsun.network.gates.genshan.biz.domain.query.SystemServicechargeSpecialQuery;
import java.util.List;

public abstract interface SystemServicechargeSpecialDAO
{
  public abstract void selectPageList(SystemServicechargeSpecialQuery paramSystemServicechargeSpecialQuery);

  public abstract List<SystemServicechargeSpecial> selectConditionList(SystemServicechargeSpecialQuery paramSystemServicechargeSpecialQuery);

  public abstract List<SystemServicechargeSpecial> selectRepeatConfig(SystemServicechargeSpecialQuery paramSystemServicechargeSpecialQuery);

  public abstract Long insert(SystemServicechargeSpecial paramSystemServicechargeSpecial);

  public abstract int updateByPrimaryKey(SystemServicechargeSpecial paramSystemServicechargeSpecial);

  public abstract SystemServicechargeSpecial selectByPrimaryKey(Long paramLong);

  public abstract SystemServicechargeSpecial selectComSpecial();

  public abstract int updateDelByPrimaryKey(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.baseset.SystemServicechargeSpecialDAO
 * JD-Core Version:    0.6.0
 */