package com.hundsun.network.gates.genshan.biz.service.project;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectType;
import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeJson;
import java.util.List;

public abstract interface ProjectTypeService
{
  public abstract List<ProjectTypeJson> queryProjectTypeTree(String paramString);

  public abstract List<ProjectTypeAttri> getProjectAttriListByQuery(String paramString);

  public abstract List<ProjectType> getProTypeListBySelective(ProjectType paramProjectType);

  public abstract void insertProjectType(ProjectType paramProjectType);

  public abstract int updateByPrimaryKeySelective(ProjectType paramProjectType);

  public abstract String getCodeWhenInsert(String paramString);

  public abstract ProjectType getProjectTypeByCode(String paramString);

  public abstract int updateEnableStatus(String paramString, int paramInt);

  public abstract List<ProjectTypeAttri> getProjectAttriListBySelective(ProjectTypeAttri paramProjectTypeAttri);

  public abstract void insertProjectTypeAttri(ProjectTypeAttri paramProjectTypeAttri);

  public abstract ProjectTypeAttri getProjectTypeAttriById(Long paramLong);

  public abstract int updateAttriByPrimaryKey(ProjectTypeAttri paramProjectTypeAttri);

  public abstract int updateAttriEnableStatus(Long paramLong1, Long paramLong2);

  public abstract List<ProjectTypeAttri> queryProjectTypeAttri(String paramString);

  public abstract List<ProjectType> getProjectTypeForScreen();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.project.ProjectTypeService
 * JD-Core Version:    0.6.0
 */