/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.trade.WishOrderAuditDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.trade.WishOrderAudit;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("wishOrderAuditDAO")
/*    */ public class WishOrderAuditDAOImpl extends BaseDAO
/*    */   implements WishOrderAuditDAO
/*    */ {
/*    */   public Long insert(WishOrderAudit wishOrderAudit)
/*    */   {
/* 21 */     return (Long)getSqlMapClientTemplate().insert("WISH_ORDER_AUDIT.insert", wishOrderAudit);
/*    */   }
/*    */ 
/*    */   public int update(WishOrderAudit wishOrderAudit)
/*    */   {
/* 26 */     return getSqlMapClientTemplate().update("WISH_ORDER_AUDIT.updateByPrimaryKeySelective", wishOrderAudit);
/*    */   }
/*    */ 
/*    */   public WishOrderAudit selectWishOrderAudit(WishOrderAudit wishOrderAudit)
/*    */   {
/* 31 */     return (WishOrderAudit)getSqlMapClientTemplate().queryForObject("WISH_ORDER_AUDIT.selectInAuditOrder", wishOrderAudit);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.trade.WishOrderAuditDAOImpl
 * JD-Core Version:    0.6.0
 */