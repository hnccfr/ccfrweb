/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.enums.EnumLogCategory;
/*     */ import com.hundsun.network.hseccms.model.Cms2Log;
/*     */ import com.hundsun.network.hseccms.service.Cms2LogService;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.WebDataBinder;
/*     */ import org.springframework.web.bind.annotation.InitBinder;
/*     */ import org.springframework.web.util.UrlPathHelper;
/*     */ 
/*     */ public class BaseAction
/*     */ {
/*  34 */   protected final Log _log = LogFactory.getLog(getClass());
/*     */   protected Cookyjar cookyjar;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2LogService cms2LogService;
/*     */ 
/*     */   @InitBinder
/*     */   protected final void initBinderInternal(WebDataBinder binder, Cookyjar cookyjar)
/*     */   {
/*  49 */     this.cookyjar = cookyjar;
/*     */ 
/*  51 */     registerDefaultCustomDateEditor(binder);
/*  52 */     initBinder(binder);
/*     */   }
/*     */ 
/*     */   protected void initBinder(WebDataBinder binder)
/*     */   {
/*     */   }
/*     */ 
/*     */   protected String success(Model model, String message, String url)
/*     */   {
/*  64 */     model.addAttribute("message", message);
/*  65 */     model.addAttribute("url", url);
/*  66 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String error(Model model, String message, String messageDetail, String url) {
/*  70 */     model.addAttribute("message", message);
/*  71 */     model.addAttribute("message_detail", messageDetail);
/*  72 */     model.addAttribute("url", url);
/*  73 */     return "error";
/*     */   }
/*     */ 
/*     */   protected List<String> getUnique(List<String> idList) {
/*  77 */     List<String> resultList = new ArrayList();
/*  78 */     if ((null == idList) || (idList.size() <= 0)) {
/*  79 */       return resultList;
/*     */     }
/*  81 */     boolean isExist = false;
/*  82 */     for (String id : idList) {
/*  83 */       if ((null != id) && (!id.equals(""))) {
/*  84 */         isExist = false;
/*  85 */         for (String result : resultList) {
/*  86 */           if (result.equals(id)) {
/*  87 */             isExist = true;
/*  88 */             break;
/*     */           }
/*     */         }
/*  91 */         if (!isExist) {
/*  92 */           resultList.add(id);
/*     */         }
/*     */       }
/*     */     }
/*  96 */     return resultList;
/*     */   }
/*     */ 
/*     */   protected void addLog(HttpServletRequest request, SettlerAgent cmsAgent, Long siteId, String operTitle, String id, String title)
/*     */   {
/* 101 */     Cms2Log cmslog = new Cms2Log();
/* 102 */     cmslog.setContent("id=" + id + ";title=" + title);
/* 103 */     UrlPathHelper helper = new UrlPathHelper();
/* 104 */     cmslog.setIp(getIpAddr(request));
/* 105 */     cmslog.setSiteId(siteId);
/* 106 */     cmslog.setTitle(operTitle);
/* 107 */     cmslog.setUserId(Long.valueOf(cmsAgent.getId()));
/* 108 */     cmslog.setUserName(cmsAgent.getUserAccount());
/* 109 */     cmslog.setUrl(helper.getOriginatingRequestUri(request));
/* 110 */     cmslog.setCategory(Long.valueOf(EnumLogCategory.OPER.getCode().longValue()));
/* 111 */     cmslog.setGmtCreate(new Date());
/* 112 */     cmslog.setGmtModify(new Date());
/* 113 */     cmslog.setLogTime(new Date());
/* 114 */     this.cms2LogService.addLog(cmslog);
/*     */   }
/*     */ 
/*     */   protected static String getIpAddr(HttpServletRequest request) {
/* 118 */     String ip = request.getHeader("X-Real-IP");
/* 119 */     if ((!StringUtils.isBlank(ip)) && (!"unknown".equalsIgnoreCase(ip))) {
/* 120 */       return ip;
/*     */     }
/* 122 */     ip = request.getHeader("X-Forwarded-For");
/* 123 */     if ((!StringUtils.isBlank(ip)) && (!"unknown".equalsIgnoreCase(ip)))
/*     */     {
/* 125 */       int index = ip.indexOf(44);
/* 126 */       if (index != -1) {
/* 127 */         return ip.substring(0, index);
/*     */       }
/* 129 */       return ip;
/*     */     }
/*     */ 
/* 132 */     return request.getRemoteAddr();
/*     */   }
/*     */ 
/*     */   protected void registerDefaultCustomDateEditor(WebDataBinder binder)
/*     */   {
/* 139 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 140 */     dateFormat.setLenient(false);
/* 141 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*     */   }
/*     */ 
/*     */   protected void registerDefaultCustomDatTimeeEditor(WebDataBinder binder)
/*     */   {
/* 147 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 148 */     dateFormat.setLenient(false);
/* 149 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.BaseAction
 * JD-Core Version:    0.6.0
 */