/*     */ package com.hundsun.eclp.biz.service.common.impl;
/*     */ 
/*     */ import com.caucho.hessian.client.HessianProxyFactory;
/*     */ import com.hundsun.eclp.biz.dao.sys.EclpSubSystemRegisterDAO;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystemRegister;
/*     */ import com.hundsun.eclp.biz.service.common.RemoteService;
/*     */ import com.hundsun.eclp.biz.service.sys.SubSystemService;
/*     */ import com.hundsun.eclp.client.remote.service.PermissionSynchronize;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.net.MalformedURLException;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteService")
/*     */ public class RemoteServiceImpl
/*     */   implements RemoteService
/*     */ {
/*  23 */   private static Log _log = LogFactory.getLog(RemoteServiceImpl.class);
/*     */   private final String HTTP_PER = "http://";
/*     */ 
/*     */   @Autowired
/*     */   SubSystemService subSystemService;
/*     */ 
/*     */   @Autowired
/*     */   EclpSubSystemRegisterDAO subSystemRegisterDAO;
/*     */ 
/*     */   public RemoteServiceImpl()
/*     */   {
/*  25 */     //this.HTTP_PER = "http://";
/*     */   }
/*     */ 
/*     */   public boolean synchronizeUpdateTime(String subSystemCode)
/*     */   {
/*  35 */     if (StringUtil.isEmpty(subSystemCode)) {
	 			SubSystem subSystem;
/*  36 */       List list = this.subSystemService.getAllSubSystemList();
/*  37 */       List<SubSystemRegister> regiesterList = this.subSystemRegisterDAO.selectAll();
/*  38 */       for (Iterator i$ = list.iterator(); i$.hasNext(); ) { subSystem = (SubSystem)i$.next();
/*  39 */         if (!StringUtil.isEmpty(subSystem.getHessianUrl()))
/*  40 */           for (SubSystemRegister register : regiesterList)
/*  41 */             if (register.getSubsystemCode().equals(subSystem.getName()))
/*  42 */               sendNotifySignal(getHessianUrl(subSystem, register));
/*     */       }
/*     */      
/*  47 */       return true;
/*     */     }
/*  49 */     SubSystem subSystem = this.subSystemService.getSubsystemByCode(subSystemCode);
/*  50 */     List<SubSystemRegister> regiesterList = this.subSystemRegisterDAO.selectBySysCode(subSystemCode);
/*  51 */     if ((subSystem != null) && (StringUtil.isNotEmpty(subSystem.getHessianUrl()))) {
/*  52 */       for (SubSystemRegister register : regiesterList) {
/*  53 */         sendNotifySignal(getHessianUrl(subSystem, register));
/*     */       }
/*  55 */       return true;
/*     */     }
/*     */ 
/*  58 */     return false;
/*     */   }
/*     */ 
/*     */   private String getHessianUrl(SubSystem subSystem, SubSystemRegister register) {
/*  62 */     String finalUrl = "";
/*  63 */     String serverLocation = getServerLocation(register);
/*  64 */     if (!subSystem.getHessianUrl().startsWith("/"))
/*  65 */       finalUrl = serverLocation + "/" + subSystem.getHessianUrl();
/*     */     else {
/*  67 */       finalUrl = serverLocation + subSystem.getHessianUrl();
/*     */     }
/*  69 */     if (_log.isDebugEnabled()) {
/*  70 */       _log.debug("request client remote interface url : " + finalUrl);
/*     */     }
/*  72 */     return finalUrl;
/*     */   }
/*     */ 
/*     */   private boolean sendNotifySignal(String targetUrl) {
/*  76 */     NotifySender sender = new NotifySender(targetUrl);
/*  77 */     sender.start();
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */   private String getServerLocation(SubSystemRegister register) {
/*  82 */     if (StringUtil.isEmpty(register.getServerPort())) {
/*  83 */       return "http://" + register.getServerIp();
/*     */     }
/*  85 */     return "http://" + register.getServerIp() + ":" + register.getServerPort();
/*     */   }
/*     */ 
/*     */   class NotifySender extends Thread
/*     */   {
/*     */     private String targetUrl;
/*     */ 
/*     */     NotifySender(String targetUrl) {
/*  94 */       this.targetUrl = targetUrl;
/*     */     }
/*     */ 
/*     */     public void run()
/*     */     {
/*  99 */       HessianProxyFactory factory = new HessianProxyFactory();
/*     */       try
/*     */       {
/* 102 */         PermissionSynchronize permissionSender = (PermissionSynchronize)factory.create(this.targetUrl);
/* 103 */         permissionSender.notifyPermissionUpdated(System.currentTimeMillis());
/*     */       } catch (MalformedURLException e) {
/* 105 */         RemoteServiceImpl._log.error("HessianProxyFactory create client with wrong formed URL : " + this.targetUrl);
/*     */       } catch (ClassNotFoundException e) {
/* 107 */         e.printStackTrace();
/*     */       } catch (Exception e) {
/* 109 */         RemoteServiceImpl._log.error("there is something wrong with request the URL :" + this.targetUrl);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.common.impl.RemoteServiceImpl
 * JD-Core Version:    0.6.0
 */