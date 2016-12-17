/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.user.UserAddressDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAddress;
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
/* 23 */     return getSqlMapClientTemplate().delete("userAddress.deleteByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public void insert(UserAddress record)
/*    */   {
/* 28 */     getSqlMapClientTemplate().insert("userAddress.insert", record);
/*    */   }
/*    */ 
/*    */   public UserAddress selectByPrimaryKey(Long id)
/*    */   {
/* 33 */     return (UserAddress)getSqlMapClientTemplate().queryForObject("userAddress.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(UserAddress record)
/*    */   {
/* 39 */     return getSqlMapClientTemplate().update("userAddress.updateByPrimaryKeySelective", record);
/*    */   }
/*    */ 
/*    */   public Integer selectNumOfUserAddress(UserAddress userAddress)
/*    */   {
/* 45 */     return (Integer)getSqlMapClientTemplate().queryForObject("userAddress.selectNumOfUserAddress", userAddress);
/*    */   }
/*    */ 
/*    */   public List<UserAddress> selectAllUserAddresses(UserAddress userAddress)
/*    */   {
/* 52 */     return getSqlMapClientTemplate().queryForList("userAddress.selectAllUserAddresses", userAddress);
/*    */   }
/*    */ 
/*    */   public void updateIsDefault(String isDefault)
/*    */   {
/* 58 */     getSqlMapClientTemplate().update("userAddress.updateIsDefault", isDefault);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.user.UserAddressDAOImpl
 * JD-Core Version:    0.6.0
 */