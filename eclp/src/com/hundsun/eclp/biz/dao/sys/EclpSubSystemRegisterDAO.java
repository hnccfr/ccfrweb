package com.hundsun.eclp.biz.dao.sys;

import com.hundsun.eclp.biz.domain.sys.SubSystemRegister;
import java.util.List;

public abstract interface EclpSubSystemRegisterDAO
{
  public abstract Long insert(SubSystemRegister paramSubSystemRegister);

  public abstract int updateByPrimaryKey(SubSystemRegister paramSubSystemRegister);

  public abstract SubSystemRegister selectByPrimaryKey(Long paramLong);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract SubSystemRegister selectBySysCodeAndIP(String paramString1, String paramString2);

  public abstract SubSystemRegister selectByClientInfo(String paramString1, String paramString2, String paramString3);

  public abstract List<SubSystemRegister> selectAll();

  public abstract List<SubSystemRegister> selectBySysCode(String paramString);

  public abstract void bathcUpdate(List<SubSystemRegister> paramList);

  public abstract void deleteAll();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.sys.EclpSubSystemRegisterDAO
 * JD-Core Version:    0.6.0
 */