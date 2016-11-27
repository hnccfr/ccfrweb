/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserAddressDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAddress;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userAddressDAO")
/*    */ public class UserAddressDAOImpl extends BaseDAO
/*    */   implements UserAddressDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 16 */     return getSqlMapClientTemplate().delete("userAddress.deleteByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public void insert(UserAddress record)
/*    */   {
/* 21 */     getSqlMapClientTemplate().insert("userAddress.insert", record);
/*    */   }
/*    */ 
/*    */   public UserAddress selectByPrimaryKey(Long id)
/*    */   {
/* 26 */     return (UserAddress)getSqlMapClientTemplate().queryForObject("userAddress.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(UserAddress record)
/*    */   {
/* 32 */     return getSqlMapClientTemplate().update("userAddress.updateByPrimaryKeySelective", record);
/*    */   }
/*    */ 
/*    */   public Integer selectNumOfUserAddress(UserAddress userAddress)
/*    */   {
/* 38 */     return (Integer)getSqlMapClientTemplate().queryForObject("userAddress.selectNumOfUserAddress", userAddress);
/*    */   }
/*    */ 
/*    */   public List<UserAddress> selectAllUserAddresses(UserAddress userAddress)
/*    */   {
/* 45 */     return getSqlMapClientTemplate().queryForList("userAddress.selectAllUserAddresses", userAddress);
/*    */   }
/*    */ 
/*    */   public void updateIsDefault(UserAddress userAddress)
/*    */   {
/* 51 */     getSqlMapClientTemplate().update("userAddress.updateIsDefault", userAddress);
/*    */   }
/*    */ 
/*    */   public List<UserAddress> selectUserAddresses(UserAddress userAddress)
/*    */   {
/* 60 */     return getSqlMapClientTemplate().queryForList("userAddress.selectUserAddresses", userAddress);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.user.UserAddressDAOImpl
 * JD-Core Version:    0.6.0
 */