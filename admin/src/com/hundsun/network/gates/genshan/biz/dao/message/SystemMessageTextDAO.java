package com.hundsun.network.gates.genshan.biz.dao.message;

import com.hundsun.network.gates.genshan.biz.domain.message.SystemMessageText;
import com.hundsun.network.gates.genshan.biz.domain.query.SystemMessageTextQuery;
import java.util.List;

public abstract interface SystemMessageTextDAO
{
  public abstract void selectSystemMessageTextList(SystemMessageTextQuery paramSystemMessageTextQuery);

  public abstract Integer deleteTextById(Long paramLong);

  public abstract SystemMessageText selectTextById(Long paramLong);

  public abstract Integer updateTextById(SystemMessageText paramSystemMessageText);

  public abstract Integer deleteUnionByMessageId(Long paramLong);

  public abstract List<String> selectReceiveAccountList(SystemMessageText paramSystemMessageText);

  public abstract Integer deleteMessageOfOne(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.message.SystemMessageTextDAO
 * JD-Core Version:    0.6.0
 */