package com.hundsun.network.gates.fengshan.biz.service.message;

import com.hundsun.network.gates.fengshan.biz.domain.message.SystemMessage;
import com.hundsun.network.gates.fengshan.biz.domain.query.SystemMessageQuery;

public abstract interface SystemMessageService
{
  public abstract void getMessageList(SystemMessageQuery paramSystemMessageQuery);

  public abstract SystemMessage getMessage(Long paramLong);

  public abstract Integer deleteMessage(Long paramLong);

  public abstract Integer changeMessage(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.message.SystemMessageService
 * JD-Core Version:    0.6.0
 */