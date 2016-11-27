/*     */ package com.hundsun.eclp.biz.service.common;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.RoleSystemDAO;
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermission;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.service.AuthorityService;
/*     */ import com.hundsun.eclp.biz.service.SubSystemService;
/*     */ import com.hundsun.eclp.biz.service.UsersService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("cookieWriter")
/*     */ public class CookieWriter
/*     */ {
/*  27 */   private static Log _log = LogFactory.getLog(CookieWriter.class);
/*     */ 
/*     */   @Autowired
/*     */   AuthorityService authorityService;
/*     */ 
/*     */   @Autowired
/*     */   private RoleSystemDAO roleSystemDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UsersService usersService;
/*     */ 
/*     */   @Autowired
/*     */   private SubSystemService subSystemService;
/*     */ 
/*  48 */   public void updateUserAgentPermissionBySubsystem(UserAgent userAgent, Cookyjar cookyjar, String subSystemCode) { Users user = new Users();
/*  49 */     user.setId(Long.valueOf(userAgent.getId()));
/*  50 */     userAgent.setCurrentSystemCode(subSystemCode);
/*     */ 
/*  52 */     userAgent.setPermissionsByList(this.authorityService.getSubsystemPermissionListByUser(user, subSystemCode), subSystemCode);
/*     */ 
/*  54 */     String roleid = this.roleSystemDAO.getRoleIDBySystemCode(subSystemCode);
/*  55 */     if (_log.isDebugEnabled())
/*  56 */       _log.debug("roleID:" + roleid + "   subsystemCode:" + subSystemCode);
/*     */     Map<Integer, Integer> permissionMap;
/*  58 */     if (StringUtil.isNotEmpty(roleid)) {
/*  59 */       Users dbuser = this.usersService.getUserByID(userAgent.getId());
/*  60 */       if (_log.isDebugEnabled()) {
/*  61 */         _log.debug("the user info : <" + dbuser.getId() + "><" + dbuser.getAccount() + "><" + dbuser.getStatus() + "><" + dbuser.getRoleId() + ">");
/*     */       }
/*     */ 
/*  64 */       boolean isSuperUser = isSuperUser(dbuser, roleid);
/*  65 */       if (_log.isDebugEnabled()) {
/*  66 */         _log.debug("isSuperUser = " + isSuperUser);
/*     */       }
/*  68 */       if (isSuperUser) {
/*  69 */         SubSystem subSystem = this.subSystemService.selectByCode(userAgent.getCurrentSystemCode());
/*  70 */         if (_log.isDebugEnabled()) {
/*  71 */           _log.debug("subsystem: <" + subSystem.getName() + "><" + subSystem.getSuperCode() + ">");
/*     */         }
/*  73 */         userAgent.setIsSuperUser(isSuperUser);
/*  74 */         if (subSystem.getSuperCode() != null) {
/*  75 */           userAgent.setPermission(getSubsystemSuperUserCode(subSystem));
/*     */         } else {
/*  77 */           _log.debug("subsystem's superCode is null...");
/*  78 */           permissionMap = MemoPermission.get(subSystem.getName());
/*  79 */           if (permissionMap == null) {
/*  80 */             throw new RuntimeException("MemoPermission's data maybe have some errors, please check the permission data ...");
/*     */           }
/*  82 */           for (Integer item : permissionMap.keySet()) {
/*  83 */             if (_log.isDebugEnabled()) {
/*  84 */               _log.debug("add permission index : " + item);
/*     */             }
/*  86 */             userAgent.setPermission(((Integer)permissionMap.get(item)).intValue());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  92 */     cookyjar.set(userAgent); }
/*     */ 
/*     */   private boolean isSuperUser(Users dbuser, String roleid)
/*     */   {
/*  96 */     Long[] arr$ = dbuser.getRoleId(); int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { long item = arr$[i$].longValue();
/*  97 */       if (item == Long.valueOf(roleid).longValue()) {
/*  98 */         return true;
/*     */       }
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   private int getSubsystemSuperUserCode(SubSystem subSystem)
/*     */   {
/* 106 */     Map map = MemoPermission.get(subSystem.getName());
/* 107 */     if (map != null) {
/* 108 */       Integer permissionIndex = (Integer)map.get(Integer.valueOf(subSystem.getSuperCode().intValue()));
/* 109 */       if (permissionIndex != null) {
/* 110 */         return permissionIndex.intValue();
/*     */       }
/*     */     }
/* 113 */     throw new RuntimeException("MemoPermission's data maybe have some errors, please check the permission data ...");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.common.CookieWriter
 * JD-Core Version:    0.6.0
 */