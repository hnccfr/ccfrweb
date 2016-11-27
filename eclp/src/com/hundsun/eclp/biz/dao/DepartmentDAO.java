package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.dept.Department;

public abstract interface DepartmentDAO
{
  public abstract void insert(Department paramDepartment);

  public abstract int update(Department paramDepartment);

  public abstract Department selectById(Long paramLong);

  public abstract int delete(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.DepartmentDAO
 * JD-Core Version:    0.6.0
 */