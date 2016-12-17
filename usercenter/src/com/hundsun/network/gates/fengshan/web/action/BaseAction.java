/*     */ package com.hundsun.network.gates.fengshan.web.action;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.web.editor.StringTrimEditor;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.melody.common.web.url.URLBroker;
/*     */ import java.text.DateFormat;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.NumberFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*     */ import org.springframework.beans.propertyeditors.CustomNumberEditor;
/*     */ import org.springframework.context.MessageSource;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.WebDataBinder;
/*     */ import org.springframework.web.bind.annotation.InitBinder;
/*     */ 
/*     */ public class BaseAction
/*     */ {
/*  27 */   protected final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private URLBroker appServerBroker;
/*     */ 
/*     */   @Autowired
/*     */   private MessageSource messageSource;
/*     */ 
/*     */   @InitBinder
/*     */   protected final void initBinderInternal(WebDataBinder binder)
/*     */   {
/*  43 */     registerDefaultCustomDateEditor(binder);
/*  44 */     registerDefaultCustomNumberEditor(binder);
/*  45 */     registerDefaultCustomStringEditor(binder);
/*  46 */     initBinder(binder);
/*     */   }
/*     */ 
/*     */   private void registerDefaultCustomStringEditor(WebDataBinder binder) {
/*  50 */     binder.registerCustomEditor(String.class, new StringTrimEditor());
/*     */   }
/*     */ 
/*     */   private void registerDefaultCustomNumberEditor(WebDataBinder binder)
/*     */   {
/*  56 */     NumberFormat numberFormat = new DecimalFormat("#0.00");
/*  57 */     binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, numberFormat, true));
/*     */   }
/*     */ 
/*     */   protected void registerDefaultCustomDateEditor(WebDataBinder binder)
/*     */   {
/*  64 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*  65 */     dateFormat.setLenient(false);
/*  66 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*     */   }
/*     */ 
/*     */   protected void initBinder(WebDataBinder binder)
/*     */   {
/*     */   }
/*     */ 
/*     */   protected String redirectLogin()
/*     */   {
/*  78 */     return redirect("/login.htm");
/*     */   }
/*     */ 
/*     */   protected String redirectIndex() {
/*  82 */     return redirect("/user/index.htm");
/*     */   }
/*     */ 
/*     */   protected String redirectEmpty() {
/*  86 */     return redirect("/empty.htm");
/*     */   }
/*     */ 
/*     */   protected String redirectError() {
/*  90 */     return redirect("/error.htm");
/*     */   }
/*     */ 
/*     */   protected String success() {
/*  94 */     return redirect("/success.htm");
/*     */   }
/*     */ 
/*     */   protected String getMessage(String code, String[] args) {
/*  98 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*     */   }
/*     */ 
/*     */   protected String error() {
/* 102 */     return "error";
/*     */   }
/*     */ 
/*     */   protected String redirect(String url) {
/* 106 */     return "redirect:" + this.appServerBroker + url;
/*     */   }
/*     */ 
/*     */   protected String success(Model model, String code, String[] args) {
/* 110 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 111 */     model.addAttribute("message", message);
/* 112 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String success(ModelMap model, String code, String[] args) {
/* 116 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 117 */     model.addAttribute("message", message);
/* 118 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String error(Model model, String code, String[] args) {
/* 122 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 123 */     model.addAttribute("message", message);
/* 124 */     return "error";
/*     */   }
/*     */ 
/*     */   protected String error(ModelMap model, String code, String[] args) {
/* 128 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 129 */     model.addAttribute("message", message);
/* 130 */     return "error";
/*     */   }
/*     */ 
/*     */   protected void setResult(ModelMap model, ServiceResult result) {
/* 134 */     if (result != null) {
/* 135 */       if (result.correct()) {
/* 136 */         model.addAttribute("success", Boolean.valueOf(true));
/*     */       } else {
/* 138 */         model.addAttribute("success", Boolean.valueOf(false));
/* 139 */         model.addAttribute("errorMsg", result.getErrorInfo());
/*     */       }
/*     */     }
/* 142 */     else setErrorResult(model, "remote.error.null", new String[0]);
/*     */   }
/*     */ 
/*     */   protected void setErrorResult(ModelMap model, String code, String[] args)
/*     */   {
/* 147 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 148 */     model.addAttribute("success", Boolean.valueOf(false));
/* 149 */     model.addAttribute("errorMsg", message);
/*     */   }
/*     */ 
/*     */   protected void setSuccessResult(ModelMap model) {
/* 153 */     model.addAttribute("success", Boolean.valueOf(true));
/*     */   }
/*     */ 
/*     */   protected String getSourceMsg(String code, String[] args) {
/* 157 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.BaseAction
 * JD-Core Version:    0.6.0
 */