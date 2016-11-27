package com.hundsun.network.gates.fengshan.biz.dao.message;

import com.hundsun.network.gates.fengshan.biz.domain.message.SystemMessage;
import com.hundsun.network.gates.fengshan.biz.domain.query.SystemMessageQuery;

public abstract interface SystemMessageDAO
{
  public abstract void selectMessageListByQuery(SystemMessageQuery paramSystemMessageQuery);

  public abstract SystemMessage selectMessageById(Long paramLong);

  public abstract Integer deleteMessageById(Long paramLong);

  public abstract Integer updateMessageById(Long paramLong);

  public abstract Integer getNumByQuery(SystemMessageQuery paramSystemMessageQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.message.SystemMessageDAO
 * JD-Core Version:    0.6.0
 */