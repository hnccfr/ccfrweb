package com.hundsun.network.gates.wulin.biz.service.message;

import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMessageResult;
import com.hundsun.network.gates.wulin.biz.domain.message.MessageForMore;
import com.hundsun.network.gates.wulin.biz.domain.message.SystemMessageText;

public abstract interface SystemMessageService
{
  public abstract Long addMessageText(SystemMessageText paramSystemMessageText);

  public abstract void addMessage(MessageForMore paramMessageForMore);

  public abstract SystemMessageResult sendSystemMessage(SystemMessageRequest paramSystemMessageRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.message.SystemMessageService
 * JD-Core Version:    0.6.0
 */