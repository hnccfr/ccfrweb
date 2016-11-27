/*     */ package com.hundsun.eclp.web.action.sys;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.sys.SysConfig;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.service.SysConfigService;
/*     */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.eclp.security.AdminAccess;
/*     */ import com.hundsun.eclp.util.FileUploadUtil;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.multipart.MultipartHttpServletRequest;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/system"})
/*     */ public class SysConfigAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   SysConfigService sysConfigService;
/*     */ 
/*     */   @Autowired
/*     */   private FileUploadUtil fileUploadUtil;
/*     */ 
/*     */   @Autowired
/*     */   private WorkLogService workLogService;
/*  43 */   public static final String[] EXTARRAY = { "jpg", "jpeg", "gif", "png" };
/*     */   public static final int MAX_FILE_SIZE = 500;
/*     */ 
/*     */   @RequestMapping({"/sys_conf_list"})
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SYS_CONFIG})
/*     */   public void init(@ModelAttribute("sysConfig") SysConfig sysConfig, Model model)
/*     */   {
/*  50 */     List confList = this.sysConfigService.selectAllSysConfig();
/*     */ 
/*  56 */     model.addAttribute("sysConfigList", confList); } 
/*  61 */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SYS_MANAGE_EDIT})
/*     */   @RequestMapping({"/sys_conf_update"})
/*     */   public String updateSysConf(@ModelAttribute("sysConfig") SysConfig sysConfig, Model model, MultipartHttpServletRequest request, UserAgent userAgent) { if ((sysConfig != null) && (sysConfig.getId() != null)) {
/*  62 */       Long sysConfId = sysConfig.getId();
/*     */ 
/*  64 */       SysConfig config = this.sysConfigService.selectById(sysConfId);
/*  65 */       if (config != null) {
/*  66 */         config.setStatus(sysConfig.getStatus());
/*  67 */         config.setValue(sysConfig.getValue());
/*  68 */         String errorStr = null;
/*  69 */         if ("file".equalsIgnoreCase(config.getType())) {
/*  70 */           MultipartFile file = request.getFile("value_" + sysConfig.getId());
/*  71 */           if (file != null) {
/*  72 */             Long fileSize = Long.valueOf(file.getSize());
/*  73 */             if (fileSize.longValue() > 0L)
/*     */             {
/*  75 */               if (!FileUploadUtil.ifExtendNamePermitted(file))
/*  76 */                 errorStr = "图片格式错误，应为[jpg、jpeg、gif、png]";
/*  77 */               else if (!FileUploadUtil.ifFileSizePermitted(file))
/*     */               {
/*  79 */                 errorStr = "'商品图片不能超过500k！'";
/*     */               }
/*     */             }
/*  82 */             config.setFile(file);
/*     */           }
/*     */         }
/*     */         try
/*     */         {
/*  87 */           if (StringUtil.isBlank(errorStr)) {
/*  88 */             this.sysConfigService.update(config);
/*  89 */             model.addAttribute("message", URLEncoder.encode("修改成功", "UTF-8"));
/*     */ 
/*  91 */             this.workLogService.addWorkLog("更新系统配置", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "更新系统配置[" + config.getCodeDesc() + "]成功", userAgent);
/*     */           } else {
/*  93 */             model.addAttribute("message", URLEncoder.encode(errorStr, "UTF-8"));
/*     */           }
/*     */         } catch (Exception e) {
/*  96 */           this._log.equals(e);
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 101 */     model.addAttribute("sysConfigList", this.sysConfigService.selectAllSysConfig());
/* 102 */     return "/system/sys_conf_list";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.sys.SysConfigAction
 * JD-Core Version:    0.6.0
 */