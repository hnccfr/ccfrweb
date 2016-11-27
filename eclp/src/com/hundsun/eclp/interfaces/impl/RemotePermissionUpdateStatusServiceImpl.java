/*     */ package com.hundsun.eclp.interfaces.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.sys.EclpSubSystemRegisterDAO;
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermissionFlag;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystemRegister;
/*     */ import com.hundsun.eclp.biz.service.SubSystemService;
/*     */ import com.hundsun.eclp.client.remote.client.RemotePermissionUpdateStatusService;
/*     */ import com.hundsun.eclp.client.remote.dto.ServerStatusDTO;
/*     */ import com.hundsun.eclp.util.DateUtil;
/*     */ import com.hundsun.eclp.util.ServerPortGetter;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.Calendar;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("remotePermissionUpdateStatusService")
/*     */ public class RemotePermissionUpdateStatusServiceImpl
/*     */   implements RemotePermissionUpdateStatusService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   SubSystemService subSystemService;
/*     */ 
/*     */   @Autowired
/*     */   EclpSubSystemRegisterDAO eclpSubSystemRegisterDAO;
/*     */   private static final String HTTP_DEFAULT_PORT = "80";
/*  31 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   public ServerStatusDTO getServerStatus(String sc, String serverIP, String clientPort)
/*     */   {
/*  35 */     ServerStatusDTO dto = new ServerStatusDTO();
/*  36 */     for (String subsystemCode : sc.trim().split(",")) {
/*  37 */       this.log.info("RemotePermissionUpdateStatusService.getServerStatus, subsystemCode=" + subsystemCode + ",serverIP=" + serverIP + ",clientPort=" + clientPort);
/*  38 */       dto.setStatus(false);
/*     */       try
/*     */       {
/*  41 */         if ((StringUtil.isBlank(subsystemCode)) || (StringUtil.isBlank(serverIP))) {
/*  42 */           return null;
/*     */         }
/*     */ 
/*  45 */         SubSystem subSystem = this.subSystemService.selectByCode(subsystemCode);
/*  46 */         if (subSystem == null) {
/*  47 */           dto.setMsg("子系统不存在");
/*  48 */           return dto;
/*     */         }
/*  50 */         clientPort = ServerPortGetter.getPortString(clientPort);
/*  51 */         String regStr = getRegisterStr(subsystemCode, serverIP, clientPort);
/*     */ 
/*  54 */         SubSystemRegister reg = this.eclpSubSystemRegisterDAO.selectBySysCodeAndIP(subsystemCode, serverIP);
/*  55 */         if (reg == null)
/*     */         {
/*  57 */           reg = new SubSystemRegister();
/*  58 */           reg.setServerIp(serverIP);
/*  59 */           reg.setSubsystemCode(subsystemCode);
/*  60 */           reg.setServerPort(clientPort);
/*  61 */           Long id = this.eclpSubSystemRegisterDAO.insert(reg);
/*     */ 
/*  63 */           if (id == null) {
/*  64 */             dto.setMsg("注册子系统失败");
/*  65 */             return dto;
/*     */           }
/*     */ 
/*  68 */           MemoPermissionFlag.put(regStr, DateUtil.getCurrentDay().getTime());
/*     */         }
/*     */ 
/*  71 */         if (MemoPermissionFlag.containsKey(regStr))
/*  72 */           return MemoPermissionFlag.get(regStr);
/*     */       }
/*     */       catch (Exception e) {
/*  75 */         this.log.equals(e);
/*     */       }
/*  77 */       if (!dto.getStatus()) {
/*     */         break;
/*     */       }
/*     */     }
/*  81 */     return dto;
/*     */   }
/*     */ 
/*     */   private String getRegisterStr(String subsystemCode, String serverIP, String serverPort)
/*     */   {
/*  86 */     String regStr = serverIP + "|" + subsystemCode + "|" + serverPort;
/*  87 */     return regStr;
/*     */   }
/*     */ 
/*     */   public boolean updateServerStatusToCompeleted(String sc, String serverIP, String serverPort, Long datetime)
/*     */   {
/*  93 */     for (String subsystemCode : sc.trim().split(","))
/*     */     {
/*  95 */       if ((StringUtil.isBlank(subsystemCode)) || (StringUtil.isBlank(serverIP)) || (datetime == null))
/*  96 */         return false;
/*  97 */       serverPort = ServerPortGetter.getPortString(serverPort);
/*     */       try {
/*  99 */         String regStr = getRegisterStr(subsystemCode, serverIP, serverPort);
/*     */ 
/* 101 */         if (MemoPermissionFlag.containsKey(regStr)) {
/* 102 */           ServerStatusDTO dto = MemoPermissionFlag.get(regStr);
/* 103 */           if ((dto != null) && (datetime.longValue() == dto.getPermissionUpdateTime())) {
/* 104 */             dto.setStatus(false);
/* 105 */             MemoPermissionFlag.put(regStr, dto);
/*     */           } else {
/* 107 */             return false;
/*     */           }
/*     */         } else {
/* 110 */           return false;
/*     */         }
/*     */       } catch (Exception e) {
/* 113 */         this.log.error(e);
/* 114 */         return false;
/*     */       }
/*     */     }
/* 117 */     return true;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.interfaces.impl.RemotePermissionUpdateStatusServiceImpl
 * JD-Core Version:    0.6.0
 */