/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.order;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.UserIntegralLogDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserIntegralLog;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userIntegralLogDAO")
/*    */ public class UserIntegralLogDAOImpl extends BaseDAO
/*    */   implements UserIntegralLogDAO
/*    */ {
/*    */   public Long insert(UserIntegralLog record)
/*    */   {
/* 20 */     return (Long)getSqlMapClientTemplate().insert("USER_INTEGRAL_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public List<UserIntegralLog> selectByUserAccount(String userAccount)
/*    */   {
/* 30 */     return getSqlMapClientTemplate().queryForList("USER_INTEGRAL_LOG.selectByUserAccount", userAccount);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.order.UserIntegralLogDAOImpl
 * JD-Core Version:    0.6.0
 */