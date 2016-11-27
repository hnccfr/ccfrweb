/*     */ package com.hundsun.eclp.interfaces.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.sys.EclpSubSystemRegisterDAO;
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermissionFlag;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystemRegister;
/*     */ import com.hundsun.eclp.client.remote.client.RegisterResult;
/*     */ import com.hundsun.eclp.client.remote.client.RemoteClientAutoRegisterService;
/*     */ import com.hundsun.eclp.util.DateUtil;
/*     */ import com.hundsun.eclp.util.ServerPortGetter;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.text.ParseException;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("remoteClientAutoRegisterService")
/*     */ public class RemoteClientAutoRegServiceImpl
/*     */   implements RemoteClientAutoRegisterService
/*     */ {
/*  23 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   EclpSubSystemRegisterDAO eclpSubSystemRegisterDAO;
/*     */ 
/*  29 */   public RegisterResult registerClient(String sc, String serverIP, String clientPort) { Date regTime = null;
/*     */     try {
/*  31 */       regTime = DateUtil.getCurrentDay().getTime();
/*     */     } catch (ParseException e1) {
/*  33 */       return null;
/*     */     }
/*  35 */     RegisterResult result = null;
/*  36 */     for (String subsystemCode : sc.trim().split(",")) {
/*  37 */       result = new RegisterResult(false, regTime);
/*  38 */       this.log.info("RemoteClientAutoRegServiceImpl.registerClient, subsystemCode=" + subsystemCode + ",serverIP=" + serverIP + ",clientPort=" + clientPort);
/*     */       try
/*     */       {
/*  41 */         if ((StringUtil.isBlank(subsystemCode)) || (StringUtil.isBlank(serverIP)))
/*  42 */           return result;
/*  43 */         clientPort = ServerPortGetter.getPortString(clientPort);
/*     */ 
/*  45 */         String regStr = serverIP + "|" + subsystemCode + "|" + clientPort;
/*     */ 
/*  49 */         SubSystemRegister reg = this.eclpSubSystemRegisterDAO.selectByClientInfo(subsystemCode, serverIP, clientPort);
/*  50 */         if (reg == null)
/*     */         {
/*  52 */           reg = new SubSystemRegister();
/*  53 */           reg.setServerIp(serverIP);
/*  54 */           reg.setSubsystemCode(subsystemCode);
/*  55 */           reg.setServerPort(clientPort);
/*  56 */           Long id = this.eclpSubSystemRegisterDAO.insert(reg);
/*     */ 
/*  58 */           if (id == null) {
/*  59 */             return result;
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*  64 */         MemoPermissionFlag.put(regStr, regTime);
/*     */ 
/*  74 */         result.setResult(true);
/*  75 */         result.setRegisterTime(regTime);
/*     */       } catch (Exception e) {
/*  77 */         this.log.error(e);
/*  78 */         return null;
/*     */       }
/*     */     }
/*  81 */     return result;
/*     */   }
/*     */ 
/*     */   public RegisterResult unregisterClient(String subsystemCode, String serverIP, String serverPort)
/*     */   {
/*  86 */     this.log.info("RemoteClientAutoRegServiceImpl.unregisterClient, subsystemCode=" + subsystemCode + ",serverIP=" + serverIP + ",serverPort=" + serverPort);
/*     */     try {
/*  88 */       Date regTime = DateUtil.getCurrentDay().getTime();
/*  89 */       RegisterResult result = new RegisterResult(false, regTime);
/*     */ 
/*  91 */       if ((StringUtil.isBlank(subsystemCode)) || (StringUtil.isBlank(serverIP)))
/*  92 */         return result;
/*  93 */       serverPort = ServerPortGetter.getPortString(serverPort);
/*     */ 
/*  95 */       String regStr = serverIP + "|" + subsystemCode + "|" + serverPort;
/*     */ 
/*  97 */       SubSystemRegister reg = this.eclpSubSystemRegisterDAO.selectByClientInfo(subsystemCode, serverIP, serverPort);
/*  98 */       if (reg != null)
/*     */       {
/* 100 */         this.eclpSubSystemRegisterDAO.deleteByPrimaryKey(reg.getId());
/*     */       }
/*     */ 
/* 103 */       if (MemoPermissionFlag.containsKey(regStr))
/*     */       {
/* 105 */         MemoPermissionFlag.remove(regStr);
/*     */       }
/*     */ 
/* 108 */       result.setResult(true);
/* 109 */       result.setRegisterTime(DateUtil.getCurrentDay().getTime());
/* 110 */       return result;
/*     */     } catch (Exception e) {
/* 112 */       this.log.error(e);
/*     */     }
/* 114 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.interfaces.impl.RemoteClientAutoRegServiceImpl
 * JD-Core Version:    0.6.0
 */