/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.SystemServicechargeSpecialDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemServicechargeSpecial;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemServicechargeSpecialQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemServicechargeSpecialDAO")
/*    */ public class SystemServicechargeSpecialDAOImpl extends BaseDAO
/*    */   implements SystemServicechargeSpecialDAO
/*    */ {
/*    */   public void selectPageList(SystemServicechargeSpecialQuery query)
/*    */   {
/* 25 */     paginate(query, "SYSTEM_SERVICECHARGE_SPECIAL.selectPageList-count", "SYSTEM_SERVICECHARGE_SPECIAL.selectPageList");
/*    */   }
/*    */ 
/*    */   public List<SystemServicechargeSpecial> selectConditionList(SystemServicechargeSpecialQuery query)
/*    */   {
/* 35 */     return getSqlMapClientTemplate().queryForList("SYSTEM_SERVICECHARGE_SPECIAL.selectConditionList", query);
/*    */   }
/*    */ 
/*    */   public List<SystemServicechargeSpecial> selectRepeatConfig(SystemServicechargeSpecialQuery query)
/*    */   {
/* 45 */     return getSqlMapClientTemplate().queryForList("SYSTEM_SERVICECHARGE_SPECIAL.selectRepeatConfig", query);
/*    */   }
/*    */ 
/*    */   public Long insert(SystemServicechargeSpecial record)
/*    */   {
/* 53 */     return (Long)getSqlMapClientTemplate().insert("SYSTEM_SERVICECHARGE_SPECIAL.insert", record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(SystemServicechargeSpecial record)
/*    */   {
/* 62 */     int rows = getSqlMapClientTemplate().update("SYSTEM_SERVICECHARGE_SPECIAL.updateByPrimaryKey", record);
/* 63 */     return rows;
/*    */   }
/*    */ 
/*    */   public SystemServicechargeSpecial selectByPrimaryKey(Long id)
/*    */   {
/* 72 */     SystemServicechargeSpecial record = (SystemServicechargeSpecial)getSqlMapClientTemplate().queryForObject("SYSTEM_SERVICECHARGE_SPECIAL.selectByPrimaryKey", id);
/*    */ 
/* 74 */     return record;
/*    */   }
/*    */ 
/*    */   public SystemServicechargeSpecial selectComSpecial()
/*    */   {
/* 82 */     return (SystemServicechargeSpecial)getSqlMapClientTemplate().queryForObject("SYSTEM_SERVICECHARGE_SPECIAL.selectComSpecial");
/*    */   }
/*    */ 
/*    */   public int updateDelByPrimaryKey(Long id)
/*    */   {
/* 92 */     SystemServicechargeSpecial key = new SystemServicechargeSpecial();
/* 93 */     key.setId(id);
/* 94 */     int rows = getSqlMapClientTemplate().update("SYSTEM_SERVICECHARGE_SPECIAL.updateDelByPrimaryKey", key);
/* 95 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset.SystemServicechargeSpecialDAOImpl
 * JD-Core Version:    0.6.0
 */