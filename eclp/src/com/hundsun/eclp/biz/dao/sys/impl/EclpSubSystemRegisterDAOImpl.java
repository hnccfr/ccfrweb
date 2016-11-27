/*     */ package com.hundsun.eclp.biz.dao.sys.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.sys.EclpSubSystemRegisterDAO;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystemRegister;
/*     */ import com.hundsun.network.common.dao.BaseDAO;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("eclpSubSystemRegisterDAO")
/*     */ public class EclpSubSystemRegisterDAOImpl extends BaseDAO
/*     */   implements EclpSubSystemRegisterDAO
/*     */ {
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  19 */     return getSqlMapClientTemplate().delete("SUB_SYSTEM_REGISTER.deleteByPrimaryKey", id);
/*     */   }
/*     */ 
/*     */   public Long insert(SubSystemRegister record)
/*     */   {
/*  24 */     return (Long)getSqlMapClientTemplate().insert("SUB_SYSTEM_REGISTER.insert", record);
/*     */   }
/*     */ 
/*     */   public SubSystemRegister selectByPrimaryKey(Long id)
/*     */   {
/*  31 */     return (SubSystemRegister)getSqlMapClientTemplate().queryForObject("SUB_SYSTEM_REGISTER.selectByPrimaryKey", id);
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(SubSystemRegister record)
/*     */   {
/*  37 */     return getSqlMapClientTemplate().update("SUB_SYSTEM_REGISTER.updateByPrimaryKey", record);
/*     */   }
/*     */ 
/*     */   public SubSystemRegister selectBySysCodeAndIP(String syscode, String serverIP)
/*     */   {
/*  44 */     if ((StringUtil.isBlank(syscode)) || (StringUtil.isBlank(serverIP))) {
/*  45 */       return null;
/*     */     }
/*  47 */     SubSystemRegister reg = new SubSystemRegister();
/*  48 */     reg.setSubsystemCode(syscode);
/*  49 */     reg.setServerIp(serverIP);
/*     */ 
/*  51 */     List regList = getSqlMapClientTemplate().queryForList("SUB_SYSTEM_REGISTER.selectBySysCodeAndIP", reg);
/*     */ 
/*  53 */     if ((regList != null) && (regList.size() > 0)) {
/*  54 */       return (SubSystemRegister)regList.get(0);
/*     */     }
/*  56 */     return null;
/*     */   }
/*     */ 
/*     */   public SubSystemRegister selectByClientInfo(String syscode, String serverIP, String clientPort)
/*     */   {
/*  63 */     if ((StringUtil.isBlank(syscode)) || (StringUtil.isBlank(serverIP))) {
/*  64 */       return null;
/*     */     }
/*  66 */     SubSystemRegister reg = new SubSystemRegister();
/*  67 */     reg.setSubsystemCode(syscode);
/*  68 */     reg.setServerIp(serverIP);
/*  69 */     reg.setServerPort(clientPort);
/*     */ 
/*  71 */     List regList = getSqlMapClientTemplate().queryForList("SUB_SYSTEM_REGISTER.selectByClientInfo", reg);
/*     */ 
/*  73 */     if ((regList != null) && (regList.size() > 0)) {
/*  74 */       return (SubSystemRegister)regList.get(0);
/*     */     }
/*  76 */     return null;
/*     */   }
/*     */ 
/*     */   public List<SubSystemRegister> selectAll()
/*     */   {
/*  83 */     return getSqlMapClientTemplate().queryForList("SUB_SYSTEM_REGISTER.selectAll");
/*     */   }
/*     */ 
/*     */   public void bathcUpdate(List<SubSystemRegister> list)
/*     */   {
/*  88 */     if ((list != null) && (list.size() > 0))
/*  89 */       executeBatchUpdate("SUB_SYSTEM_REGISTER.updateByPrimaryKey", list);
/*     */   }
/*     */ 
/*     */   public List<SubSystemRegister> selectBySysCode(String syscode)
/*     */   {
/*  98 */     SubSystemRegister reg = new SubSystemRegister();
/*  99 */     reg.setSubsystemCode(syscode);
/* 100 */     return getSqlMapClientTemplate().queryForList("SUB_SYSTEM_REGISTER.selectBySysCodeAndIP", reg);
/*     */   }
/*     */ 
/*     */   public void deleteAll()
/*     */   {
/* 105 */     getSqlMapClientTemplate().delete("SUB_SYSTEM_REGISTER.deleteAll");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.sys.impl.EclpSubSystemRegisterDAOImpl
 * JD-Core Version:    0.6.0
 */