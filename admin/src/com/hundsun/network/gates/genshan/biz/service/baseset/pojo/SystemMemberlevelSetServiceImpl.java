/*     */ package com.hundsun.network.gates.genshan.biz.service.baseset.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.sysmemlevel.SystemMemberlevelSetDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemMemberlevelSet;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemMemberlevelSetQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemMemberlevelSetService;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("systemMemberlevelSetService")
/*     */ public class SystemMemberlevelSetServiceImpl
/*     */   implements SystemMemberlevelSetService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private SystemMemberlevelSetDAO systemMemberlevelSetDAO;
/*     */ 
/*     */   public void selectPageList(SystemMemberlevelSetQuery query)
/*     */   {
/*  23 */     this.systemMemberlevelSetDAO.selectPageList(query);
/*     */   }
/*     */ 
/*     */   public List<SystemMemberlevelSet> selectConditionList(SystemMemberlevelSetQuery query)
/*     */   {
/*  31 */     return this.systemMemberlevelSetDAO.selectConditionList(query);
/*     */   }
/*     */ 
/*     */   public int checkIntegralRange(SystemMemberlevelSetQuery query)
/*     */   {
/*  39 */     return this.systemMemberlevelSetDAO.checkIntegralRange(query);
/*     */   }
/*     */ 
/*     */   public int selectConditionCount(SystemMemberlevelSetQuery query)
/*     */   {
/*  47 */     return this.systemMemberlevelSetDAO.selectConditionCount(query);
/*     */   }
/*     */ 
/*     */   public List<SystemMemberlevelSet> selectSystemMemberlevelList()
/*     */   {
/*  55 */     return this.systemMemberlevelSetDAO.selectSystemMemberlevelList();
/*     */   }
/*     */ 
/*     */   public void insert(SystemMemberlevelSet record)
/*     */   {
/*  63 */     this.systemMemberlevelSetDAO.insert(record);
/*     */   }
/*     */ 
/*     */   public SystemMemberlevelSet selectByPrimaryKey(Long id)
/*     */   {
/*  72 */     return this.systemMemberlevelSetDAO.selectByPrimaryKey(id);
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(SystemMemberlevelSet record)
/*     */   {
/*  81 */     return this.systemMemberlevelSetDAO.updateByPrimaryKey(record);
/*     */   }
/*     */ 
/*     */   public int updateBySelective(SystemMemberlevelSet record)
/*     */   {
/*  90 */     return this.systemMemberlevelSetDAO.updateBySelective(record);
/*     */   }
/*     */ 
/*     */   public SystemMemberlevelSet selectByLevelNum(SystemMemberlevelSetQuery query)
/*     */   {
/*  99 */     return this.systemMemberlevelSetDAO.selectByLevelNum(query);
/*     */   }
/*     */ 
/*     */   public SystemMemberlevelSet selectByIntegral(int integral)
/*     */   {
/* 108 */     return this.systemMemberlevelSetDAO.selectByIntegral(integral);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.pojo.SystemMemberlevelSetServiceImpl
 * JD-Core Version:    0.6.0
 */