/*     */ package com.hundsun.network.gates.wulin.web.action;
/*     */ 
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
/*  26 */   protected final Log log = LogFactory.getLog(getClass());
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
/*  42 */     registerDefaultCustomDateEditor(binder);
/*  43 */     registerDefaultCustomNumberEditor(binder);
/*  44 */     initBinder(binder);
/*     */   }
/*     */ 
/*     */   private void registerDefaultCustomNumberEditor(WebDataBinder binder)
/*     */   {
/*  50 */     NumberFormat numberFormat = new DecimalFormat("#0.00");
/*  51 */     binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, numberFormat, true));
/*     */   }
/*     */ 
/*     */   protected void registerDefaultCustomDateEditor(WebDataBinder binder)
/*     */   {
/*  58 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*  59 */     dateFormat.setLenient(false);
/*  60 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*     */   }
/*     */ 
/*     */   protected void initBinder(WebDataBinder binder)
/*     */   {
/*     */   }
/*     */ 
/*     */   protected String redirectLogin()
/*     */   {
/*  72 */     return redirect("/login.htm");
/*     */   }
/*     */ 
/*     */   protected String redirectIndex() {
/*  76 */     return redirect("/user/index.htm");
/*     */   }
/*     */ 
/*     */   protected String redirectEmpty() {
/*  80 */     return redirect("/empty.htm");
/*     */   }
/*     */ 
/*     */   protected String redirectError() {
/*  84 */     return redirect("/error.htm");
/*     */   }
/*     */ 
/*     */   protected String success() {
/*  88 */     return redirect("/success.htm");
/*     */   }
/*     */ 
/*     */   protected String getMessage(String code, String[] args) {
/*  92 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*     */   }
/*     */ 
/*     */   protected String error() {
/*  96 */     return "error";
/*     */   }
/*     */ 
/*     */   protected String redirect(String url) {
/* 100 */     return "redirect:" + this.appServerBroker + url;
/*     */   }
/*     */ 
/*     */   protected String success(Model model, String code, String[] args) {
/* 104 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 105 */     model.addAttribute("message", message);
/* 106 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String success(ModelMap model, String code, String[] args) {
/* 110 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 111 */     model.addAttribute("message", message);
/* 112 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String error(Model model, String code, String[] args) {
/* 116 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 117 */     model.addAttribute("message", message);
/* 118 */     return "error";
/*     */   }
/*     */ 
/*     */   protected String error(ModelMap model, String code, String[] args) {
/* 122 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 123 */     model.addAttribute("message", message);
/* 124 */     return "error";
/*     */   }
/*     */ 
/*     */   protected void setResult(ModelMap model, ServiceResult result) {
/* 128 */     if (result != null) {
/* 129 */       if (result.correct()) {
/* 130 */         model.addAttribute("success", Boolean.valueOf(true));
/*     */       } else {
/* 132 */         model.addAttribute("success", Boolean.valueOf(false));
/* 133 */         model.addAttribute("errorMsg", result.getErrorInfo());
/*     */       }
/*     */     }
/* 136 */     else setErrorResult(model, "remote.error.null", new String[0]);
/*     */   }
/*     */ 
/*     */   protected void setErrorResult(ModelMap model, String code, String[] args)
/*     */   {
/* 141 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 142 */     model.addAttribute("success", Boolean.valueOf(false));
/* 143 */     model.addAttribute("errorMsg", message);
/*     */   }
/*     */ 
/*     */   protected void setSuccessResult(ModelMap model) {
/* 147 */     model.addAttribute("success", Boolean.valueOf(true));
/*     */   }
/*     */ 
/*     */   protected String getSourceMsg(String code, String[] args) {
/* 151 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.web.action.BaseAction
 * JD-Core Version:    0.6.0
 */