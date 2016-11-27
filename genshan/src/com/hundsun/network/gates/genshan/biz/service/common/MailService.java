package com.hundsun.network.gates.genshan.biz.service.common;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;

public abstract interface MailService
{
  public abstract ServiceResult sendPassWordRestMail(String paramString1, String paramString2, String paramString3);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.common.MailService
 * JD-Core Version:    0.6.0
 */