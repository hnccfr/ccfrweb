package com.hundsun.network.gates.wulin.biz.dao.message;

import com.hundsun.network.gates.wulin.biz.domain.message.SystemMessageText;

public abstract interface SystemMessageTextDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(SystemMessageText paramSystemMessageText);

  public abstract void insertSelective(SystemMessageText paramSystemMessageText);

  public abstract SystemMessageText selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(SystemMessageText paramSystemMessageText);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.message.SystemMessageTextDAO
 * JD-Core Version:    0.6.0
 */