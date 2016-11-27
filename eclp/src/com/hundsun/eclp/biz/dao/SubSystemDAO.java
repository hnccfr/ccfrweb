package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.sys.SubSystem;
import java.util.List;

public abstract interface SubSystemDAO
{
  public abstract Long insert(SubSystem paramSubSystem);

  public abstract int update(SubSystem paramSubSystem);

  public abstract SubSystem selectById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract List<SubSystem> getSubSystemByUserId(Long paramLong);

  public abstract List<SubSystem> getAllSubSystemList();

  public abstract List<SubSystem> getAllSubSystemList(SubSystem paramSubSystem);

  public abstract int getSubSystemCountByName(String paramString, Long paramLong);

  public abstract int getSubSystemCountByFullName(String paramString, Long paramLong);

  public abstract SubSystem selectByCode(String paramString);

  public abstract SubSystem selectByCode(Long paramLong);

  public abstract Long getDownSubSystemId(Long paramLong);

  public abstract Long getUpSubSystemId(Long paramLong);

  public abstract Integer getMaxSort();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.SubSystemDAO
 * JD-Core Version:    0.6.0
 */