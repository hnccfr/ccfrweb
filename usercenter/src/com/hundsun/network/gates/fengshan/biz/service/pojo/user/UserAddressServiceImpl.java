/*     */ package com.hundsun.network.gates.fengshan.biz.service.pojo.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserAddressDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAddress;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserAddressService;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("userAddressService")
/*     */ public class UserAddressServiceImpl extends BaseService
/*     */   implements UserAddressService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserAddressDAO userAddressDAO;
/*     */ 
/*     */   public boolean addUserAddress(UserAddress userAddress)
/*     */   {
/*  32 */     int count = getNumOfUserAddress(userAddress);
/*  33 */     if (count < 10)
/*     */     {
/*  35 */       if ((userAddress.getIsDefault() != null) && 
/*  36 */         (userAddress.getIsDefault().equals("Y"))) {
/*  37 */         UserAddress ua = new UserAddress();
/*  38 */         ua.setIsDefault("N");
/*  39 */         ua.setType(userAddress.getType());
/*  40 */         ua.setUserAccount(userAddress.getUserAccount());
/*  41 */         setDefaultAddress(ua);
/*     */       }
/*     */ 
/*  44 */       this.userAddressDAO.insert(userAddress);
/*     */     } else {
/*  46 */       return false;
/*     */     }
/*  48 */     return true;
/*     */   }
/*     */ 
/*     */   public int deleteUserAddress(Long id)
/*     */   {
/*  53 */     int result = this.userAddressDAO.deleteByPrimaryKey(id);
/*  54 */     return result;
/*     */   }
/*     */ 
/*     */   public int getNumOfUserAddress(UserAddress userAddress)
/*     */   {
/*  59 */     return this.userAddressDAO.selectNumOfUserAddress(userAddress).intValue();
/*     */   }
/*     */ 
/*     */   public int changeUserAddress(UserAddress userAddress)
/*     */   {
/*  65 */     if ((userAddress.getIsDefault() != null) && 
/*  66 */       (userAddress.getIsDefault().equals("Y"))) {
/*  67 */       UserAddress ua = new UserAddress();
/*  68 */       ua.setIsDefault("N");
/*  69 */       ua.setType(userAddress.getType());
/*  70 */       ua.setUserAccount(userAddress.getUserAccount());
/*  71 */       setDefaultAddress(ua);
/*     */     }
/*     */ 
/*  74 */     return this.userAddressDAO.updateByPrimaryKeySelective(userAddress);
/*     */   }
/*     */ 
/*     */   public List<UserAddress> getAllUserAddresses(UserAddress userAddress)
/*     */   {
/*  79 */     return this.userAddressDAO.selectAllUserAddresses(userAddress);
/*     */   }
/*     */ 
/*     */   public UserAddress getUserAddressById(Long id)
/*     */   {
/*  84 */     return this.userAddressDAO.selectByPrimaryKey(id);
/*     */   }
/*     */ 
/*     */   public void setDefaultAddress(UserAddress userAddress)
/*     */   {
/*  89 */     this.userAddressDAO.updateIsDefault(userAddress);
/*     */   }
/*     */ 
/*     */   public UserAddress getDefaultUserAddresses(UserAddress userAddress)
/*     */   {
/*  98 */     List list = this.userAddressDAO.selectUserAddresses(userAddress);
/*  99 */     if ((list != null) && (list.size() > 0)) {
/* 100 */       return (UserAddress)list.get(0);
/*     */     }
/* 102 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.user.UserAddressServiceImpl
 * JD-Core Version:    0.6.0
 */