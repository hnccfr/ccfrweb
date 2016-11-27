/*     */ package com.hundsun.eclp.web.action.sys;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermissionFlag;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystemReg;
/*     */ import com.hundsun.eclp.client.remote.dto.ServerStatusDTO;
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.eclp.util.DateUtil;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class SubSystemRegAction extends BaseAction
/*     */ {
/*  26 */   protected Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @RequestMapping({"/memo/sub_sys_reg_list"})
/*     */   public void querySubSystemRegInfo(Model model) {
/*  31 */     List regList = new ArrayList();
			  Map<String, ServerStatusDTO> allRegInfo;
			  SubSystemReg reg;
			 Iterator it;
/*     */     try
/*     */     {
/*  34 */       allRegInfo = MemoPermissionFlag.getAll();
/*  35 */       if ((allRegInfo != null) && (!allRegInfo.isEmpty())) {
/*  36 */         reg = new SubSystemReg();
/*  37 */         for (it = allRegInfo.keySet().iterator(); it.hasNext(); ) {
/*  38 */           String key = (String)it.next();
/*  39 */           if (StringUtil.isBlank(key))
/*     */             continue;
/*  41 */           ServerStatusDTO dto = (ServerStatusDTO)allRegInfo.get(key);
/*  42 */           String[] keys = key.split("\\|");
/*  43 */           if (keys.length >= 2) {
/*  44 */             reg = new SubSystemReg();
/*  45 */             reg.setServerIp(keys[0]);
/*  46 */             reg.setSysCode(keys[1]);
/*  47 */             if (keys.length > 2) {
/*  48 */               reg.setServerPort(keys[2]);
/*     */             }
/*  50 */             reg.setStatus(dto.getStatus());
/*  51 */             Calendar cal = DateUtil.getCurrentDay();
/*  52 */             cal.setTimeInMillis(dto.getPermissionUpdateTime());
/*  53 */             reg.setPermissionUpdateTime(cal.getTime());
/*  54 */             regList.add(reg);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {

/*     */       
/*  59 */       this.log.error(e);
/*     */     }
/*     */ 
/*  62 */     model.addAttribute("regList", regList);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/memo/upMemo"})
/*     */   public String upMemo(Model model, @RequestParam("sysCode") String sysCode, @RequestParam("serverip") String serverip, @RequestParam("serverPort") String serverPort)
/*     */   {
/*     */     try {
/*  70 */       String key = serverip + "|" + sysCode + "|" + getNotNullStr(serverPort);
/*  71 */       if (MemoPermissionFlag.containsKey(key))
/*  72 */         MemoPermissionFlag.put(key, DateUtil.getCurrentDay().getTime());
/*     */     }
/*     */     catch (Exception e) {
/*  75 */       this.log.error(e);
/*     */     }
/*  77 */     querySubSystemRegInfo(model);
/*     */ 
/*  79 */     return "/memo/sub_sys_reg_list";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/memo/ref_all"})
/*     */   public String refAll(Model model) {
					Map allRegInfo;
					Iterator it;
/*     */     try {
	 			
/*  86 */       allRegInfo = MemoPermissionFlag.getAll();
/*  87 */       if ((allRegInfo != null) && (!allRegInfo.isEmpty()))
/*  88 */         for (it = allRegInfo.keySet().iterator(); it.hasNext(); ) {
/*  89 */           String key = (String)it.next();
/*  90 */           ServerStatusDTO dto = (ServerStatusDTO)allRegInfo.get(key);
/*  91 */           dto.setStatus(true);
/*  92 */           dto.setPermissionUpdateTime(DateUtil.getCurrentDay().getTime().getTime());
/*  93 */           MemoPermissionFlag.put(key, dto);
/*     */         }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */      
/*  97 */       this.log.error(e);
/*     */     }
/*  99 */     querySubSystemRegInfo(model);
/*     */ 
/* 101 */     return "/memo/sub_sys_reg_list";
/*     */   }
/*     */ 
/*     */   private String getNotNullStr(String str) {
/* 105 */     if (StringUtils.isNotEmpty(str)) {
/* 106 */       return str;
/*     */     }
/* 108 */     return "";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.sys.SubSystemRegAction
 * JD-Core Version:    0.6.0
 */