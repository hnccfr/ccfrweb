package com.hundsun.eclp.biz.service.sys;

import com.hundsun.eclp.biz.domain.sys.SubSystem;
import com.hundsun.eclp.biz.domain.user.UserAgent;
import java.util.List;
import org.springframework.ui.Model;

public abstract interface SubSystemService
{
  public abstract List<SubSystem> getAllSubSystemList(UserAgent paramUserAgent);

  public abstract List<SubSystem> getAllSubSystemList();

  public abstract boolean deleteSubSystem(Long paramLong, UserAgent paramUserAgent);

  public abstract Long insert(SubSystem paramSubSystem, UserAgent paramUserAgent);

  public abstract int update(SubSystem paramSubSystem, UserAgent paramUserAgent);

  public abstract SubSystem selectById(Long paramLong);

  public abstract Object[] subSystemNameCheck(String paramString, Long paramLong);

  public abstract Object[] subSystemFullNameCheck(String paramString, Long paramLong);

  public abstract boolean checkSubSystemNames(String paramString1, String paramString2, Long paramLong, Model paramModel);

  public abstract boolean checkChildAuth(SubSystem paramSubSystem, Model paramModel);

  public abstract void modifyStatus(Long paramLong, Short paramShort, UserAgent paramUserAgent);

  public abstract SubSystem getSubsystemByCode(String paramString);

  public abstract void modifyPosition(Long paramLong, String paramString, UserAgent paramUserAgent);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.sys.SubSystemService
 * JD-Core Version:    0.6.0
 */