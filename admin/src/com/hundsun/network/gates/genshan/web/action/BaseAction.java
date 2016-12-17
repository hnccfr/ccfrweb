/*     */ package com.hundsun.network.gates.genshan.web.action;
/*     */ 
/*     */ import com.hundsun.eclp.client.remote.client.RemoteUserService;
/*     */ import com.hundsun.eclp.client.remote.dto.OrgDTO;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.web.editor.StringTrimEditor;
/*     */ import com.hundsun.network.gates.genshan.web.util.CustomDateTimeEditor;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
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
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.beans.propertyeditors.CustomNumberEditor;
/*     */ import org.springframework.context.MessageSource;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.WebDataBinder;
/*     */ import org.springframework.web.bind.annotation.InitBinder;
/*     */ 
/*     */ public class BaseAction
/*     */ {
/*  32 */   protected final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private URLBroker appServerBroker;
/*     */ 
/*     */   @Autowired
/*     */   private MessageSource messageSource;
/*     */   protected Cookyjar cookyjar;
/*     */ 
/*     */   @Autowired
/*     */   private URLBroker uploadServerBroker;
/*     */ 
/*     */   @Value("${root.substation}")
/*     */   private String rootSubstation;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*  57 */   @InitBinder
/*     */   protected final void initBinderInternal(WebDataBinder binder, Cookyjar cookyjar) { this.cookyjar = cookyjar;
/*     */ 
/*  59 */     registerDefaultCustomDateEditor(binder);
/*  60 */     registerDefaultCustomNumberEditor(binder);
/*  61 */     registerDefaultCustomStringEditor(binder);
/*  62 */     initBinder(binder); }
/*     */ 
/*     */   private void registerDefaultCustomStringEditor(WebDataBinder binder)
/*     */   {
/*  66 */     binder.registerCustomEditor(String.class, new StringTrimEditor());
/*     */   }
/*     */ 
/*     */   private void registerDefaultCustomNumberEditor(WebDataBinder binder)
/*     */   {
/*  72 */     NumberFormat numberFormat = new DecimalFormat("#0.00");
/*  73 */     binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, numberFormat, true));
/*     */   }
/*     */ 
/*     */   protected void registerDefaultCustomDateEditor(WebDataBinder binder)
/*     */   {
/*  84 */     DateFormat yearMonthFormat = new SimpleDateFormat("yyyy-MM");
/*  85 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*  86 */     DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  87 */     dateFormat.setLenient(false);
/*  88 */     binder.registerCustomEditor(Date.class, new CustomDateTimeEditor(dateFormat, timeFormat, yearMonthFormat, true));
/*     */   }
/*     */ 
/*     */   protected void initBinder(WebDataBinder binder)
/*     */   {
/*     */   }
/*     */ 
/*     */   protected String redirect(String url)
/*     */   {
/* 101 */     return "redirect:" + this.appServerBroker + url;
/*     */   }
/*     */ 
/*     */   protected String redirectEmpty() {
/* 105 */     return redirect("/empty.htm");
/*     */   }
/*     */ 
/*     */   protected String redirectLogin() {
/* 109 */     return redirect("/login.htm");
/*     */   }
/*     */ 
/*     */   protected String success() {
/* 113 */     return redirect("/success.htm");
/*     */   }
/*     */ 
/*     */   protected String error() {
/* 117 */     return redirect("/error.htm");
/*     */   }
/*     */ 
/*     */   protected String waring() {
/* 121 */     return redirect("/waring.htm");
/*     */   }
/*     */ 
/*     */   protected String success(ModelMap model) {
/* 125 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String error(ModelMap model) {
/* 129 */     return "error";
/*     */   }
/*     */ 
/*     */   protected String success(Model model, String code, String[] args) {
/* 133 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 134 */     model.addAttribute("message", message);
/* 135 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String success(ModelMap model, String code, String[] args) {
/* 139 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 140 */     model.addAttribute("message", message);
/* 141 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String error(Model model, String code, String[] args) {
/* 145 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 146 */     model.addAttribute("message", message);
/* 147 */     return "error";
/*     */   }
/*     */ 
/*     */   protected String error(ModelMap model, String code, String[] args) {
/* 151 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 152 */     model.addAttribute("message", message);
/* 153 */     return "error";
/*     */   }
/*     */ 
/*     */   protected String getMessage(String code, String[] args) {
/* 157 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*     */   }
/*     */ 
/*     */   protected String result(boolean result) {
/* 161 */     return result ? "success" : "error";
/*     */   }
/*     */ 
/*     */   protected void setResult(ModelMap model, ServiceResult result)
/*     */   {
/* 166 */     if (result != null) {
/* 167 */       if (result.correct()) {
/* 168 */         model.addAttribute("success", Boolean.valueOf(true));
/*     */       } else {
/* 170 */         model.addAttribute("success", Boolean.valueOf(false));
/* 171 */         model.addAttribute("errorMsg", result.getErrorInfo());
/*     */       }
/*     */     }
/* 174 */     else setErrorResult(model, "remote.error.null", new String[0]);
/*     */   }
/*     */ 
/*     */   protected void setErrorResult(ModelMap model, String code, String[] args)
/*     */   {
/* 179 */     String message = this.messageSource.getMessage(code, args, Locale.CHINA);
/* 180 */     model.addAttribute("success", Boolean.valueOf(false));
/* 181 */     model.addAttribute("errorMsg", message);
/*     */   }
/*     */ 
/*     */   public URLBroker getUploadServerBroker() {
/* 185 */     return this.uploadServerBroker;
/*     */   }
/*     */ 
/*     */   public void setUploadServerBroker(URLBroker uploadServerBroker) {
/* 189 */     this.uploadServerBroker = uploadServerBroker;
/*     */   }
/*     */ 
/*     */   public URLBroker getAppServerBroker() {
/* 193 */     return this.appServerBroker;
/*     */   }
/*     */ 
/*     */   public void setAppServerBroker(URLBroker appServerBroker) {
/* 197 */     this.appServerBroker = appServerBroker;
/*     */   }
/*     */ 
/*     */   protected Long getSubstationId(UserAgent userAgent) {
/* 201 */     Long substationId = null;
/*     */ 
/* 203 */     OrgDTO org = this.remoteUserService.getDeptInfoByUserId(Long.valueOf(userAgent.getId()));
/*     */ 
/* 205 */     if ((org != null) && (this.rootSubstation.equals(org.getTopDeptId())) && (org.getLeafDeptId() != null)) {
/* 206 */       substationId = Long.valueOf(org.getLeafDeptId());
/*     */     }
/* 208 */     return substationId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.BaseAction
 * JD-Core Version:    0.6.0
 */