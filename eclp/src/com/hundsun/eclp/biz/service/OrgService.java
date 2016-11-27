package com.hundsun.eclp.biz.service;

import com.hundsun.eclp.biz.domain.dept.Department;
import com.hundsun.eclp.biz.domain.user.UserAgent;
import java.util.List;
import java.util.Map;

public abstract interface OrgService
{
  public abstract List<Department> getOrgList(Short paramShort);

  public abstract Map<Long, Integer> getCountByParentGroupByParent(List<Long> paramList, Short paramShort);

  public abstract List<Department> getListAll(Short paramShort);

  public abstract String getFullNameById(Long paramLong);

  public abstract String insert(Department paramDepartment, UserAgent paramUserAgent);

  public abstract int batchInsert(List<Department> paramList);

  public abstract Department getDepartmentById(Long paramLong);

  public abstract String edit(Department paramDepartment, UserAgent paramUserAgent);

  public abstract String deleteOrgByIdList(List<Long> paramList, UserAgent paramUserAgent);

  public abstract String deleteOrgByIdList(List<Long> paramList, Long paramLong, UserAgent paramUserAgent);

  public abstract List<Department> getUpOrgList(Long paramLong);

  public abstract List<Department> getDownOrgList(Long paramLong);

  public abstract List<Department> getRepeatDeptList(Department paramDepartment);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.OrgService
 * JD-Core Version:    0.6.0
 */