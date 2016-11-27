/*     */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.sysmemlevel;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.sysmemlevel.SystemMemberlevelSetDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemMemberlevelSet;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemMemberlevelSetQuery;
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("systemMemberlevelSetDAO")
/*     */ public class SystemMemberlevelSetDAOImpl extends BaseDAO
/*     */   implements SystemMemberlevelSetDAO
/*     */ {
/*     */   public void selectPageList(SystemMemberlevelSetQuery query)
/*     */   {
/*  25 */     paginate(query, "SYSTEM_MEMBERLEVEL_SET.selectPageList-count", "SYSTEM_MEMBERLEVEL_SET.selectPageList");
/*     */   }
/*     */ 
/*     */   public List<SystemMemberlevelSet> selectConditionList(SystemMemberlevelSetQuery query)
/*     */   {
/*  34 */     return getSqlMapClientTemplate().queryForList("SYSTEM_MEMBERLEVEL_SET.selectConditionList", query);
/*     */   }
/*     */ 
/*     */   public int checkIntegralRange(SystemMemberlevelSetQuery query)
/*     */   {
/*  42 */     return ((Integer)getSqlMapClientTemplate().queryForObject("SYSTEM_MEMBERLEVEL_SET.checkIntegralRange", query)).intValue();
/*     */   }
/*     */ 
/*     */   public int selectConditionCount(SystemMemberlevelSetQuery query)
/*     */   {
/*  51 */     return ((Integer)getSqlMapClientTemplate().queryForObject("SYSTEM_MEMBERLEVEL_SET.selectConditionCount", query)).intValue();
/*     */   }
/*     */ 
/*     */   public List<SystemMemberlevelSet> selectSystemMemberlevelList()
/*     */   {
/*  61 */     return getSqlMapClientTemplate().queryForList("SYSTEM_MEMBERLEVEL_SET.selectSystemMemberlevelList");
/*     */   }
/*     */ 
/*     */   public void insert(SystemMemberlevelSet record)
/*     */   {
/*  69 */     getSqlMapClientTemplate().insert("SYSTEM_MEMBERLEVEL_SET.insert", record);
/*     */   }
/*     */ 
/*     */   public SystemMemberlevelSet selectByPrimaryKey(Long id)
/*     */   {
/*  78 */     return (SystemMemberlevelSet)getSqlMapClientTemplate().queryForObject("SYSTEM_MEMBERLEVEL_SET.selectByPrimaryKey", id);
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(SystemMemberlevelSet record)
/*     */   {
/*  87 */     int rows = getSqlMapClientTemplate().update("SYSTEM_MEMBERLEVEL_SET.updateByPrimaryKey", record);
/*  88 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateBySelective(SystemMemberlevelSet record)
/*     */   {
/*  97 */     int rows = getSqlMapClientTemplate().update("SYSTEM_MEMBERLEVEL_SET.updateBySelective", record);
/*  98 */     return rows;
/*     */   }
/*     */ 
/*     */   public SystemMemberlevelSet selectByLevelNum(SystemMemberlevelSetQuery query)
/*     */   {
/* 107 */     return (SystemMemberlevelSet)getSqlMapClientTemplate().queryForObject("SYSTEM_MEMBERLEVEL_SET.selectByLevelNum");
/*     */   }
/*     */ 
/*     */   public SystemMemberlevelSet selectByIntegral(int integral)
/*     */   {
/* 116 */     return (SystemMemberlevelSet)getSqlMapClientTemplate().queryForObject("SYSTEM_MEMBERLEVEL_SET.selectByIntegral", Integer.valueOf(integral));
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.sysmemlevel.SystemMemberlevelSetDAOImpl
 * JD-Core Version:    0.6.0
 */