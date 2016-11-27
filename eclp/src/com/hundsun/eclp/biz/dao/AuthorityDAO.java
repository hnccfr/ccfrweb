package com.hundsun.eclp.biz.dao;

import com.hundsun.eclp.biz.domain.auth.Authority;
import com.hundsun.eclp.biz.domain.sys.SubSystem;
import com.hundsun.eclp.biz.domain.user.Users;
import java.util.List;
import java.util.Map;

public abstract interface AuthorityDAO
{
  public abstract List<Authority> selectAuthorityByParent(Long paramLong, Short paramShort);

  public abstract List<Authority> selectAuthorityByParentList(List<Long> paramList);

  public abstract List<Authority> selectAuthorityByIdList(List<Long> paramList);

  public abstract List<Authority> selectAuthoritySubSys(Short paramShort);

  public abstract List<Authority> selectAuthorityAll(Short paramShort);

  public abstract List<Authority> selectAuthorityAllBySubSys(String paramString);

  public abstract String selectAuthorityExist(Authority paramAuthority);

  public abstract int selectCountByParent(Long paramLong, Short paramShort);

  public abstract Map<Long, Integer> selectCountByParentGroupByParent(List<Long> paramList, Short paramShort);

  public abstract int selectUseCountByParent(Long paramLong);

  public abstract int selectCountBySubSys(Long paramLong);

  public abstract void insertAuthority(Authority paramAuthority);

  public abstract int updateAuthority(Authority paramAuthority);

  public abstract int updateAuthoritySubSysByIdList(List<Long> paramList, String paramString);

  public abstract Authority selectAuthorityById(Long paramLong);

  public abstract int deleteAuthorityById(Long paramLong);

  public abstract List<Integer> selectAuthorityByUserAndSubsystem(Users paramUsers, String paramString);

  public abstract List<SubSystem> selectSubSystemAuthorityByUser(Users paramUsers);

  public abstract List<Authority> selectMenuByUserAndSubsystem(Long paramLong, String paramString);

  public abstract List<Authority> getChildrenOfSubSystem(Long paramLong);

  public abstract int getChildrenCountOfSubSystem(Long paramLong);

  public abstract List<Long> getChildrenIdsOfSubSystem(Long paramLong);

  public abstract int deleteAuthorityByIdList(List<Long> paramList);

  public abstract short getMaxSort();

  public abstract Authority selectAuthorityBySubSystemId(Long paramLong);

  public abstract List<Authority> selectAuthority(Authority paramAuthority);

  public abstract List<Authority> selectCanAssginAuthList();

  public abstract List<Authority> selectAuthListBySubSys(Long paramLong);

  public abstract List<Authority> selectMenuBySubsystem(Long paramLong);

  public abstract List<Integer> selectAllAuthorityByUserAndSubsystem(Users paramUsers, String paramString);

  public abstract List<Long> selectAuthByUserId(Long paramLong);

  public abstract List<Long> selectAuthIdBySubsystemId(List<Long> paramList);

  public abstract List<Authority> selectAuthListByRoleId(List<Long> paramList);

  public abstract List<Authority> selectAuthListBySuperRoleId(List<Long> paramList);

  public abstract List<Authority> selectAllAuthByUserId(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.AuthorityDAO
 * JD-Core Version:    0.6.0
 */