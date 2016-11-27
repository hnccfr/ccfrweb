package com.hundsun.eclp.biz.service;

import com.hundsun.eclp.biz.domain.auth.Authority;
import com.hundsun.eclp.biz.domain.sys.SubSystem;
import com.hundsun.eclp.biz.domain.user.Users;
import com.hundsun.eclp.enums.EnumIsCore;
import com.hundsun.eclp.enums.PermissionEnum;
import java.util.List;
import java.util.Map;

public abstract interface AuthorityService
{
  public abstract List<PermissionEnum> getPermissionListByUser(Users paramUsers, String paramString);

  public abstract List<Integer> getSubsystemPermissionListByUser(Users paramUsers, String paramString);

  public abstract List<Integer> getSubsystemAllPermissionListByUser(Users paramUsers, String paramString);

  public abstract SubSystem getDefaultSubSystemByUser(Users paramUsers);

  public abstract List<Authority> getChildrenOfSubSystem(Long paramLong);

  public abstract int getChildrenCountOfSubSystem(Long paramLong);

  public abstract List<Long> getChildrenIdsOfSubSystem(Long paramLong);

  public abstract String deleteAuthorityByIdList(EnumIsCore paramEnumIsCore, List<Long> paramList);

  public abstract short getMaxSort();

  public abstract void insertAuthority(Authority paramAuthority);

  public abstract int updateAuthority(Authority paramAuthority);

  public abstract Authority selectAuthorityById(Long paramLong);

  public abstract Authority selectAuthorityBySubSystemId(Long paramLong);

  public abstract List<Authority> selectMenuByUserAndSubsystem(Long paramLong, String paramString);

  public abstract List<Authority> getListSubSys(Short paramShort);

  public abstract List<Authority> getListAll(Short paramShort);

  public abstract List<Authority> getListBySubSystemParent(Long paramLong1, Long paramLong2, Short paramShort);

  public abstract List<Authority> getListByParentIdList(List<Long> paramList);

  public abstract int getCountBySubSystemParent(Long paramLong1, Long paramLong2, Short paramShort);

  public abstract Map<Long, Integer> getCountByParentGroupByParent(List<Long> paramList, Short paramShort);

  public abstract Authority getInfoById(Long paramLong);

  public abstract Authority getInfoAllById(Long paramLong);

  public abstract String add(Authority paramAuthority);

  public abstract String edit(EnumIsCore paramEnumIsCore, Authority paramAuthority);

  public abstract List<Authority> selectAuthority(Authority paramAuthority);

  public abstract List<Authority> getCanAssginAuthList();

  public abstract List<Authority> selectMenuBySubsystem(Long paramLong);

  public abstract List<Authority> getAllAuthListByUserId(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.AuthorityService
 * JD-Core Version:    0.6.0
 */