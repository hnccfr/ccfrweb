package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.dept.Department;
import java.util.List;
import java.util.Map;

public abstract interface OrgDAO
{
  public abstract List<Department> getOrgList(Long paramLong)
    throws Exception;

  public abstract Map<Long, Integer> getCountByParentGroupByParent(List<Long> paramList, Short paramShort)
    throws Exception;

  public abstract List<Department> getListAll(Long paramLong)
    throws Exception;

  public abstract List<Department> getFullListById(Long paramLong)
    throws Exception;

  public abstract Long insert(Department paramDepartment)
    throws Exception;

  public abstract int batchInsert(List<Department> paramList)
    throws Exception;

  public abstract Department getDepartmentById(Long paramLong)
    throws Exception;

  public abstract int edit(Department paramDepartment)
    throws Exception;

  public abstract List<Department> getDeptListByIds(List<Long> paramList)
    throws Exception;

  public abstract List<Department> getSubOrgList(Long paramLong)
    throws Exception;

  public abstract int batchDelete(List<Long> paramList)
    throws Exception;

  public abstract Integer getMaxSort(Long paramLong)
    throws Exception;

  public abstract List<Department> getUpOrgList(Long paramLong)
    throws Exception;

  public abstract List<Department> getDownOrgList(Long paramLong)
    throws Exception;

  public abstract List<Department> getDeptList(Department paramDepartment)
    throws Exception;

  public abstract int batchUpdate(List<Department> paramList)
    throws Exception;

  public abstract List<Department> getUpOrgListByUserId(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.OrgDAO
 * JD-Core Version:    0.6.0
 */