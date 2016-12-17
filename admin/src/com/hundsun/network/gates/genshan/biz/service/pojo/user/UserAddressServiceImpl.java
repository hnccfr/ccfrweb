/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.user;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.user.UserAddressDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAddress;
/*    */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.user.UserAddressService;
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("userAddressService")
/*    */ public class UserAddressServiceImpl extends BaseService
/*    */   implements UserAddressService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserAddressDAO userAddressDAO;
/*    */ 
/*    */   public boolean addUserAddress(UserAddress userAddress)
/*    */   {
/* 32 */     int count = getNumOfUserAddress(userAddress);
/* 33 */     if (count < 10)
/*    */     {
/* 35 */       if ((userAddress.getIsDefault() != null) && 
/* 36 */         (userAddress.getIsDefault().equals("Y"))) {
/* 37 */         System.out.print(userAddress.getIsDefault());
/* 38 */         setDefaultAddress("N");
/*    */       }
/*    */ 
/* 41 */       this.userAddressDAO.insert(userAddress);
/*    */     } else {
/* 43 */       return false;
/*    */     }
/* 45 */     return true;
/*    */   }
/*    */ 
/*    */   public int deleteUserAddress(Long id)
/*    */   {
/* 50 */     int result = this.userAddressDAO.deleteByPrimaryKey(id);
/* 51 */     return result;
/*    */   }
/*    */ 
/*    */   public int getNumOfUserAddress(UserAddress userAddress)
/*    */   {
/* 56 */     return this.userAddressDAO.selectNumOfUserAddress(userAddress).intValue();
/*    */   }
/*    */ 
/*    */   public int changeUserAddress(UserAddress userAddress)
/*    */   {
/* 62 */     if ((userAddress.getIsDefault() != null) && 
/* 63 */       (userAddress.getIsDefault().equals("Y"))) {
/* 64 */       setDefaultAddress("N");
/*    */     }
/*    */ 
/* 67 */     return this.userAddressDAO.updateByPrimaryKeySelective(userAddress);
/*    */   }
/*    */ 
/*    */   public List<UserAddress> getAllUserAddresses(UserAddress userAddress)
/*    */   {
/* 72 */     return this.userAddressDAO.selectAllUserAddresses(userAddress);
/*    */   }
/*    */ 
/*    */   public UserAddress getUserAddressById(Long id)
/*    */   {
/* 77 */     return this.userAddressDAO.selectByPrimaryKey(id);
/*    */   }
/*    */ 
/*    */   public void setDefaultAddress(String isDefault)
/*    */   {
/* 82 */     this.userAddressDAO.updateIsDefault(isDefault);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.user.UserAddressServiceImpl
 * JD-Core Version:    0.6.0
 */