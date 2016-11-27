/*     */ package com.hundsun.eclp.biz.dao.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.SubSystemDAO;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.network.common.dao.BaseDAO;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("subSystemDAO")
/*     */ public class SubSystemDAOImpl extends BaseDAO
/*     */   implements SubSystemDAO
/*     */ {
/*     */   private static final String SQLMAP_SPACE = "ECLP_SUB_SYSTEM.";
/*     */ 
/*     */   public Long insert(SubSystem record)
/*     */   {
/*  17 */     return (Long)getSqlMapClientTemplate().insert("ECLP_SUB_SYSTEM.insert", record);
/*     */   }
/*     */ 
/*     */   public int update(SubSystem record) {
/*  21 */     int rows = getSqlMapClientTemplate().update("ECLP_SUB_SYSTEM.update", record);
/*  22 */     return rows;
/*     */   }
/*     */ 
/*     */   public SubSystem selectById(Long id) {
/*  26 */     SubSystem record = (SubSystem)getSqlMapClientTemplate().queryForObject("ECLP_SUB_SYSTEM.selectById", id);
/*  27 */     return record;
/*     */   }
/*     */ 
/*     */   public int delete(Long id) {
/*  31 */     int rows = getSqlMapClientTemplate().delete("ECLP_SUB_SYSTEM.delete", id);
/*  32 */     return rows;
/*     */   }
/*     */ 
/*     */   public List<SubSystem> getSubSystemByUserId(Long userid)
/*     */   {
/*  39 */     if (userid != null) {
/*  40 */       return getSqlMapClientTemplate().queryForList("ECLP_SUB_SYSTEM.selectSubSystemByUserId", userid);
/*     */     }
/*  42 */     return null;
/*     */   }
/*     */ 
/*     */   public List<SubSystem> getAllSubSystemList(SubSystem subSystem)
/*     */   {
/*  48 */     return getSqlMapClientTemplate().queryForList("ECLP_SUB_SYSTEM.getAllSubSystemListWithoutBasic", subSystem);
/*     */   }
/*     */ 
/*     */   public List<SubSystem> getAllSubSystemList()
/*     */   {
/*  53 */     return getSqlMapClientTemplate().queryForList("ECLP_SUB_SYSTEM.getAllSubSystemList");
/*     */   }
/*     */ 
/*     */   public int getSubSystemCountByName(String subSystemName, Long subSystemId) {
/*  57 */     SubSystem subSystem = new SubSystem();
/*  58 */     subSystem.setId(subSystemId);
/*  59 */     subSystem.setName(subSystemName);
/*  60 */     return ((Integer)getSqlMapClientTemplate().queryForObject("ECLP_SUB_SYSTEM.getSubSystemCountByName", subSystem)).intValue();
/*     */   }
/*     */ 
/*     */   public int getSubSystemCountByFullName(String subSystemName, Long subSystemId) {
/*  64 */     SubSystem subSystem = new SubSystem();
/*  65 */     subSystem.setId(subSystemId);
/*  66 */     subSystem.setFullName(subSystemName);
/*  67 */     return ((Integer)getSqlMapClientTemplate().queryForObject("ECLP_SUB_SYSTEM.getSubSystemCountByFullName", subSystem)).intValue();
/*     */   }
/*     */ 
/*     */   public SubSystem selectByCode(String systemCode)
/*     */   {
/*  72 */     SubSystem subSystem = new SubSystem();
/*  73 */     subSystem.setName(systemCode);
/*  74 */     return (SubSystem)getSqlMapClientTemplate().queryForObject("ECLP_SUB_SYSTEM.getSubSystemBySystemCode", subSystem);
/*     */   }
/*     */ 
/*     */   public Long getDownSubSystemId(Long systemId)
/*     */   {
/*  79 */     if (systemId != null) {
/*  80 */       return (Long)getSqlMapClientTemplate().queryForObject("ECLP_SUB_SYSTEM.getDownSubSystemId", systemId);
/*     */     }
/*  82 */     return null;
/*     */   }
/*     */ 
/*     */   public Long getUpSubSystemId(Long systemId)
/*     */   {
/*  87 */     if (systemId != null) {
/*  88 */       return (Long)getSqlMapClientTemplate().queryForObject("ECLP_SUB_SYSTEM.getUpSubSystemId", systemId);
/*     */     }
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */   public SubSystem selectByCode(Long systemId)
/*     */   {
/*  95 */     if (systemId != null) {
/*  96 */       return (SubSystem)getSqlMapClientTemplate().queryForObject("ECLP_SUB_SYSTEM.selectById", systemId);
/*     */     }
/*  98 */     return null;
/*     */   }
/*     */ 
/*     */   public Integer getMaxSort()
/*     */   {
/* 104 */     return (Integer)getSqlMapClientTemplate().queryForObject("ECLP_SUB_SYSTEM.selectMaxSort");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.SubSystemDAOImpl
 * JD-Core Version:    0.6.0
 */