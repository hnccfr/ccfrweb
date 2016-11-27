package com.hundsun.network.gates.genshan.biz.service.message;

import com.hundsun.network.gates.genshan.biz.domain.message.MessageInfo;
import com.hundsun.network.gates.genshan.biz.domain.message.SystemMessageText;
import com.hundsun.network.gates.genshan.biz.domain.query.SystemMessageTextQuery;
import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMessageResult;
import java.util.List;

public abstract interface SystemMessageService
{
  public abstract SystemMessageResult sendMessage(MessageInfo paramMessageInfo);

  public abstract void getAllSystemMessageText(SystemMessageTextQuery paramSystemMessageTextQuery);

  public abstract SystemMessageText getSystemMessageText(Long paramLong);

  public abstract Integer deleteMessage(Long paramLong);

  public abstract Integer changeSystemMessageText(SystemMessageText paramSystemMessageText);

  public abstract Integer deleteMessageOfOne(Long paramLong);

  public abstract List<String> getReceivedList(SystemMessageText paramSystemMessageText);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.message.SystemMessageService
 * JD-Core Version:    0.6.0
 */