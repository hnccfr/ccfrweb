package com.hundsun.network.gates.genshan.biz.service.user;

import com.hundsun.network.gates.genshan.biz.domain.user.UserAddress;
import java.util.List;

public abstract interface UserAddressService
{
  public abstract boolean addUserAddress(UserAddress paramUserAddress);

  public abstract int getNumOfUserAddress(UserAddress paramUserAddress);

  public abstract int deleteUserAddress(Long paramLong);

  public abstract int changeUserAddress(UserAddress paramUserAddress);

  public abstract List<UserAddress> getAllUserAddresses(UserAddress paramUserAddress);

  public abstract UserAddress getUserAddressById(Long paramLong);

  public abstract void setDefaultAddress(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.user.UserAddressService
 * JD-Core Version:    0.6.0
 */