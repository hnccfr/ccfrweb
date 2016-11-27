/*     */ package com.hundsun.eclp.biz.service.common.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.AuthorityDAO;
/*     */ import com.hundsun.eclp.biz.dao.sys.EclpSubSystemRegisterDAO;
/*     */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermission;
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermissionFlag;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystemRegister;
/*     */ import com.hundsun.eclp.biz.service.ToolService;
/*     */ import com.hundsun.eclp.biz.service.sys.SubSystemService;
/*     */ import com.hundsun.eclp.util.DateUtil;
/*     */ import com.hundsun.eclp.util.ServerPortGetter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("notifyServer")
/*     */ public class NotifyServerImpl
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ToolService toolService;
/*     */ 
/*     */   @Autowired
/*     */   AuthorityDAO authorityDAO;
/*     */ 
/*     */   @Autowired
/*     */   private SubSystemService subSystemService;
/*     */ 
/*     */   @Autowired
/*     */   EclpSubSystemRegisterDAO eclpSubSystemRegisterDAO;
/*  40 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   public void notifyClient(Long sysid, boolean isUpdate)
/*     */   {
/*     */     try
/*     */     {
/*  47 */       if (sysid != null) {
/*  48 */         SubSystem sys = this.subSystemService.selectById(sysid);
/*  49 */         if (sys != null)
/*     */         {
/*  51 */           queryPermissionBySys(sys);
/*  52 */           if (isUpdate)
/*     */           {
/*  54 */             this.toolService.synchronizeUpdateTime(sys.getName());
/*     */           }
/*     */ 
/*  57 */           updatePermissionFlag(sys);
/*     */         }
/*     */       }
/*     */       else {
/*  61 */         List<SubSystem> sysList = this.subSystemService.getAllSubSystemList();
/*  62 */         if ((sysList != null) && (sysList.size() > 0))
/*  63 */           for (SubSystem sys : sysList)
/*     */           {
/*  65 */             queryPermissionBySys(sys);
/*  66 */             if (isUpdate)
/*     */             {
/*  68 */               this.toolService.synchronizeUpdateTime(sys.getName());
/*     */             }
/*     */ 
/*  71 */             updatePermissionFlag(sys);
/*     */           }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  76 */       this.log.error(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateSysCode(String newSysCode, String oldSysCode)
/*     */   {
/*     */     try
/*     */     {
/*  89 */       List<SubSystemRegister> regList = this.eclpSubSystemRegisterDAO.selectAll();
/*     */ 
/*  91 */       List upList = new ArrayList();
/*  92 */       if ((regList != null) && (regList.size() > 0)) {
/*  93 */         for (SubSystemRegister reg : regList) {
/*  94 */           if (reg.getSubsystemCode().equals(oldSysCode))
/*     */           {
/*  96 */             String key = getRegisterKey(reg);
/*  97 */             MemoPermissionFlag.remove(key);
/*  98 */             reg.setSubsystemCode(newSysCode);
/*  99 */             upList.add(reg);
/*     */ 
/* 101 */             key = getRegisterKey(reg);
/* 102 */             MemoPermissionFlag.put(key, DateUtil.getCurrentDay().getTime());
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 107 */       this.eclpSubSystemRegisterDAO.bathcUpdate(upList);
/*     */     }
/*     */     catch (Exception e) {
/* 110 */       this.log.error(e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private String getRegisterKey(SubSystemRegister reg)
/*     */   {
/* 116 */     return reg.getServerIp() + "|" + reg.getSubsystemCode() + "|" + ServerPortGetter.getPortString(reg.getServerPort());
/*     */   }
/*     */   private void queryPermissionBySys(SubSystem sys) {
/* 119 */     if (sys != null)
/*     */     {
/* 121 */       Map permissionMap = new HashMap();
/*     */ 
/* 123 */       if (sys.getSuperCode() != null) {
/* 124 */         permissionMap.put(Integer.valueOf(sys.getSuperCode().intValue()), Integer.valueOf(0));
/*     */       }
/*     */ 
/* 128 */       List<Authority> authList = this.authorityDAO.selectAuthListBySubSys(sys.getId());
/*     */       int row;
/* 129 */       if ((authList != null) && (authList.size() > 0)) {
/* 130 */         row = 1;
/* 131 */         for (Authority auth : authList) {
/* 132 */           permissionMap.put(Integer.valueOf(auth.getCode().intValue()), Integer.valueOf(row++));
/*     */         }
/*     */       }
/*     */ 
/* 136 */       MemoPermission.put(sys.getName(), permissionMap);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void updatePermissionFlag(SubSystem sys)
/*     */   {
/*     */     try
/*     */     {
/* 146 */       Map map = MemoPermissionFlag.getAll();
				Iterator it ;
/* 147 */       for (it = map.keySet().iterator(); it.hasNext(); ) {
/* 148 */         String key = (String)it.next();
/* 149 */         if (key.contains(sys.getName()))
/*     */         {
/* 151 */           MemoPermissionFlag.put(key, DateUtil.getCurrentDay().getTime());
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       Iterator it;
/* 155 */       this.log.error(e);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.common.impl.NotifyServerImpl
 * JD-Core Version:    0.6.0
 */