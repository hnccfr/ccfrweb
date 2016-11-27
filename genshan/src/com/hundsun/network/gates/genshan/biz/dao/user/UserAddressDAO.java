package com.hundsun.network.gates.genshan.biz.dao.user;

import com.hundsun.network.gates.genshan.biz.domain.user.UserAddress;
import java.util.List;

public abstract interface UserAddressDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(UserAddress paramUserAddress);

  public abstract UserAddress selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(UserAddress paramUserAddress);

  public abstract Integer selectNumOfUserAddress(UserAddress paramUserAddress);

  public abstract List<UserAddress> selectAllUserAddresses(UserAddress paramUserAddress);

  public abstract void updateIsDefault(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.user.UserAddressDAO
 * JD-Core Version:    0.6.0
 */