/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.trade.WishOrderAuditDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.trade.WishOrderAudit;
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
/* 14 */     return (Long)getSqlMapClientTemplate().insert("WISH_ORDER_AUDIT.insert", wishOrderAudit);
/*    */   }
/*    */ 
/*    */   public int update(WishOrderAudit wishOrderAudit)
/*    */   {
/* 19 */     return getSqlMapClientTemplate().update("WISH_ORDER_AUDIT.updateByPrimaryKeySelective", wishOrderAudit);
/*    */   }
/*    */ 
/*    */   public WishOrderAudit selectWishOrderAudit(WishOrderAudit wishOrderAudit)
/*    */   {
/* 24 */     return (WishOrderAudit)getSqlMapClientTemplate().queryForObject("WISH_ORDER_AUDIT.selectInAuditOrder", wishOrderAudit);
/*    */   }
/*    */ 
/*    */   public WishOrderAudit selectWishOrderAuditInAudit(WishOrderAudit wishOrderAudit)
/*    */   {
/* 29 */     return (WishOrderAudit)getSqlMapClientTemplate().queryForObject("WISH_ORDER_AUDIT.selectWishOrderAuditInAudit", wishOrderAudit);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.trade.WishOrderAuditDAOImpl
 * JD-Core Version:    0.6.0
 */