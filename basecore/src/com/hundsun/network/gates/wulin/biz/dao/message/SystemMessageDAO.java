package com.hundsun.network.gates.wulin.biz.dao.message;

import com.hundsun.network.gates.wulin.biz.domain.message.MessageForMore;
import com.hundsun.network.gates.wulin.biz.domain.message.SystemMessage;

public abstract interface SystemMessageDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(SystemMessage paramSystemMessage);

  public abstract void insertSelective(SystemMessage paramSystemMessage);

  public abstract SystemMessage selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(SystemMessage paramSystemMessage);

  public abstract void batchInsertMessage(MessageForMore paramMessageForMore);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.message.SystemMessageDAO
 * JD-Core Version:    0.6.0
 */