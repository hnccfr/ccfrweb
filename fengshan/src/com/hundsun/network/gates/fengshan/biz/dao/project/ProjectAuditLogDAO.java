package com.hundsun.network.gates.fengshan.biz.dao.project;

import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectAuditLog;
import java.util.List;

public abstract interface ProjectAuditLogDAO
{
  public abstract int countByprojectAuditLog(ProjectAuditLog paramProjectAuditLog);

  public abstract int deleteByprojectAuditLog(ProjectAuditLog paramProjectAuditLog);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(ProjectAuditLog paramProjectAuditLog);

  public abstract void insertSelective(ProjectAuditLog paramProjectAuditLog);

  public abstract List selectByprojectAuditLog(ProjectAuditLog paramProjectAuditLog);

  public abstract ProjectAuditLog selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(ProjectAuditLog paramProjectAuditLog);

  public abstract int updateByPrimaryKey(ProjectAuditLog paramProjectAuditLog);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.project.ProjectAuditLogDAO
 * JD-Core Version:    0.6.0
 */