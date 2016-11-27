/*    */ package com.hundsun.eclp.biz.dao.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.SysConfigDAO;
/*    */ import com.hundsun.eclp.biz.domain.sys.SysConfig;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("sysConfigDAO")
/*    */ public class SysConfigDAOImpl extends BaseDAO
/*    */   implements SysConfigDAO
/*    */ {
/*    */   public void insert(SysConfig record)
/*    */   {
/* 16 */     getSqlMapClientTemplate().insert("ECLP_SYS_CONFIG.insert", record);
/*    */   }
/*    */ 
/*    */   public int update(SysConfig record) {
/* 20 */     int rows = getSqlMapClientTemplate().update("ECLP_SYS_CONFIG.update", record);
/* 21 */     return rows;
/*    */   }
/*    */ 
/*    */   public SysConfig selectById(Long id) {
/* 25 */     SysConfig record = (SysConfig)getSqlMapClientTemplate().queryForObject("ECLP_SYS_CONFIG.selectById", id);
/* 26 */     return record;
/*    */   }
/*    */ 
/*    */   public int delete(Long id) {
/* 30 */     int rows = getSqlMapClientTemplate().delete("ECLP_SYS_CONFIG.delete", id);
/* 31 */     return rows;
/*    */   }
/*    */ 
/*    */   public SysConfig selectSysConfigByCode(String code)
/*    */   {
/* 36 */     if (StringUtil.isNotBlank(code)) {
/* 37 */       return (SysConfig)getSqlMapClientTemplate().queryForObject("ECLP_SYS_CONFIG.selectSysConfigByCode", code);
/*    */     }
/* 39 */     return null;
/*    */   }
/*    */ 
/*    */   public List<SysConfig> selectAllSysConfig()
/*    */   {
/* 46 */     return getSqlMapClientTemplate().queryForList("ECLP_SYS_CONFIG.selectAllSysConfig");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.SysConfigDAOImpl
 * JD-Core Version:    0.6.0
 */