package com.hundsun.network.gates.genshan.biz.service.project;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
import java.util.List;

public abstract interface ProjectMetasService
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(ProjectMetas paramProjectMetas);

  public abstract void insertSelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKeySelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKey(ProjectMetas paramProjectMetas);

  public abstract List<ProjectMetas> getMetasByProjectId(Long paramLong);

  public abstract List<ProjectMetas> getMetasByProjectIdAndMetaGroup(Long paramLong, String paramString);

  public abstract List<TradeShowDTO> getMetasByProjectListing(ProjectListing paramProjectListing);

  public abstract List<ProjectMetas> getAllProjectMetasByProjectId(Long paramLong);

  public abstract List<ProjectMetas> getAllProjectMetasByrojectListing(ProjectListing paramProjectListing);

  public abstract String getOneMetaValue(ProjectMetas paramProjectMetas);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.project.ProjectMetasService
 * JD-Core Version:    0.6.0
 */