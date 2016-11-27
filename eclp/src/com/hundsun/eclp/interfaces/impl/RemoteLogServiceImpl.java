/*     */ package com.hundsun.eclp.interfaces.impl;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.WorkLogDAO;
/*     */ import com.hundsun.eclp.biz.domain.sys.WorkLog;
/*     */ import com.hundsun.eclp.biz.domain.user.Users;
/*     */ import com.hundsun.eclp.biz.service.LogService;
/*     */ import com.hundsun.eclp.biz.service.SubSystemService;
/*     */ import com.hundsun.eclp.client.remote.client.RemoteLogService;
/*     */ import com.hundsun.eclp.client.remote.dto.LoginLogDTO;
/*     */ import com.hundsun.eclp.client.remote.dto.WorkLogDTO;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteLogService")
/*     */ public class RemoteLogServiceImpl
/*     */   implements RemoteLogService
/*     */ {
/*  33 */   private static Log _log = LogFactory.getLog(RemoteLogServiceImpl.class);
/*     */ 
/*     */   @Autowired
/*     */   private LogService logService;
/*     */ 
/*     */   @Autowired
/*     */   private WorkLogDAO workLogDAO;
/*     */ 
/*     */   @Autowired
/*     */   private SubSystemService subSystemService;
/*     */ 
/*  49 */   public boolean writeLoginLog(LoginLogDTO loginLogDTO) { _log.debug(loginLogDTO);
/*  50 */     if (checkLoginLogDTO(loginLogDTO)) {
/*  51 */       Users user = new Users(loginLogDTO.getUserid().longValue(), loginLogDTO.getAccount(), "", loginLogDTO.getLoginIp());
/*  52 */       this.logService.createLoginLog(user, loginLogDTO.getLoginIp(), loginLogDTO.getStatus().shortValue() == 1, loginLogDTO.getRemark(), loginLogDTO.getSubSystemCode());
/*  53 */       return true;
/*     */     }
/*  55 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean checkLoginLogDTO(LoginLogDTO loginLogDTO)
/*     */   {
/*  60 */     if (StringUtil.isEmpty(loginLogDTO.getAccount())) {
/*  61 */       return false;
/*     */     }
/*  63 */     if (loginLogDTO.getUserid() == null) {
/*  64 */       return false;
/*     */     }
/*     */ 
/*  67 */     return isIP(loginLogDTO.getLoginIp());
/*     */   }
/*     */ 
/*     */   private boolean isIP(String loginIp)
/*     */   {
/*  73 */     String regex = "(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5]).(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])";
/*  74 */     Pattern p = Pattern.compile(regex);
/*  75 */     Matcher m = p.matcher(loginIp);
/*  76 */     return m.matches();
/*     */   }
/*     */ 
/*     */   public boolean writeWorkLog(WorkLogDTO workLogDTO, String subSystemCode)
/*     */   {
/*  84 */     _log.debug(workLogDTO + " subSystemCode=" + subSystemCode);
/*  85 */     if ((checkSubSystemCode(subSystemCode)) && 
/*  86 */       (checkWorkLogDTO(workLogDTO))) {
/*  87 */       this.workLogDAO.insert(new WorkLog(workLogDTO, subSystemCode));
/*  88 */       return true;
/*     */     }
/*     */ 
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean checkSubSystemCode(String subSystemCode)
/*     */   {
/*  96 */     if (StringUtil.isEmpty(subSystemCode)) {
/*  97 */       return false;
/*     */     }
/*  99 */     return this.subSystemService.selectByCode(subSystemCode) != null;
/*     */   }
/*     */ 
/*     */   private boolean checkWorkLogDTO(WorkLogDTO workLogDTO) {
/* 103 */     if (StringUtil.isEmpty(workLogDTO.getAccount())) {
/* 104 */       return false;
/*     */     }
/* 106 */     if (StringUtil.isEmpty(workLogDTO.getOperationType())) {
/* 107 */       return false;
/*     */     }
/*     */ 
/* 110 */     return workLogDTO.getUserid() != null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.interfaces.impl.RemoteLogServiceImpl
 * JD-Core Version:    0.6.0
 */