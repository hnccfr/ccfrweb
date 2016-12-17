/*     */ package com.hundsun.network.gates.genshan.web.action.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemCreditLevel;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemCreditLevelQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemCreditLevelService;
/*     */ import com.hundsun.network.gates.genshan.common.FileUploadUtil;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.validation.Validator;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class SystemCreditLevelAction extends BaseAction
/*     */ {
/*  38 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private SystemCreditLevelService systemCreditLevelService;
/*     */ 
/*     */   @Autowired
/*     */   private FileUploadUtil fileUploadUtil;
/*     */   private static final int FILE_MAX_SIZE = 512000;
/*     */ 
/*     */   @Autowired
/*     */   private Validator systemCreditLevelAddValidator;
/*     */ 
/*     */   @Autowired
/*     */   private Validator systemCreditLevelEditValidator;
/*     */ 
/*  62 */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMCREDITLEVEL_LIST})
/*     */   @RequestMapping({"/baseset/syscreditlevel/list"})
/*     */   public void list(@ModelAttribute("query") SystemCreditLevelQuery query, ModelMap model) throws Exception { if (StringUtil.isNotEmpty(query.getCreditLevel())) {
/*  63 */       query.setCreditLevel(query.getCreditLevel().trim());
/*     */     }
/*  65 */     if (StringUtil.isNotEmpty(query.getLevelName())) {
/*  66 */       query.setLevelName(query.getLevelName().trim());
/*     */     }
/*  68 */     this.systemCreditLevelService.selectPageList(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMCREDITLEVEL_ADD})
/*     */   @RequestMapping(value={"/baseset/syscreditlevel/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String add(@ModelAttribute("systemCreditLevel") SystemCreditLevel systemCreditLevel, Model model)
/*     */     throws Exception
/*     */   {
/*  80 */     return "/baseset/syscreditlevel/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMCREDITLEVEL_ADD})
/*     */   @RequestMapping(value={"/baseset/syscreditlevel/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView add2(UserAgent userAgent, @RequestParam("uploadFile") MultipartFile uploadFile, @ModelAttribute("systemCreditLevel") SystemCreditLevel systemCreditLevel, BindingResult result, Model model)
/*     */     throws Exception
/*     */   {
/*  97 */     if ((uploadFile != null) && (uploadFile.getSize() != 0L) && (uploadFile.getOriginalFilename() != null)) {
/*  98 */       systemCreditLevel.setImgName(uploadFile.getOriginalFilename());
/*  99 */       if (uploadFile.getSize() == 0L) {
/* 100 */         model.addAttribute("fileuploadError", "请选择图片");
/* 101 */         return null;
/* 102 */       }if (uploadFile.getSize() > 512000L) {
/* 103 */         model.addAttribute("fileuploadError", "图片大小不能超过500k");
/* 104 */         return null;
/* 105 */       }if (uploadFile.getSize() <= 512000L) {
/* 106 */         String orgFileName = uploadFile.getOriginalFilename();
/* 107 */         String exts = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
/*     */ 
/* 109 */         if (!FileUploadUtil.ifExtendNamePermitted(exts)) {
/* 110 */           model.addAttribute("fileuploadError", "图片格式必须为jpg,jpeg,gif,png");
/* 111 */           return null;
/*     */         }
/*     */       }
/* 114 */       String fileName = this.fileUploadUtil.uploadFile(uploadFile, "", "usercredit");
/* 115 */       systemCreditLevel.setImgName(fileName);
/*     */     }
/*     */ 
/* 119 */     this.systemCreditLevelAddValidator.validate(systemCreditLevel, result);
/* 120 */     if (result.hasErrors()) {
/* 121 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 122 */       return null;
/*     */     }
/*     */ 
/* 125 */     systemCreditLevel.setOperator(userAgent.getUserAccount());
/* 126 */     this.systemCreditLevelService.insert(systemCreditLevel);
/* 127 */     return new ModelAndView("redirect:/baseset/syscreditlevel/list.htm?pageNo=1", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMCREDITLEVEL_UPDATE})
/*     */   @RequestMapping(value={"/baseset/syscreditlevel/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String update(@RequestParam(value="id", required=true) Long id, @ModelAttribute("systemCreditLevel") SystemCreditLevel systemCreditLevel, Model model)
/*     */     throws Exception
/*     */   {
/* 140 */     systemCreditLevel = this.systemCreditLevelService.selectByPrimaryKey(id);
/* 141 */     model.addAttribute("systemCreditLevel", systemCreditLevel);
/* 142 */     return "/baseset/syscreditlevel/update";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMCREDITLEVEL_UPDATE})
/*     */   @RequestMapping(value={"/baseset/syscreditlevel/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView update2(UserAgent userAgent, @RequestParam("uploadFile") MultipartFile uploadFile, @ModelAttribute("systemCreditLevel") SystemCreditLevel systemCreditLevel, BindingResult result, Model model)
/*     */     throws Exception
/*     */   {
/* 158 */     if ((uploadFile != null) && (uploadFile.getSize() != 0L) && (uploadFile.getOriginalFilename() != null)) {
/* 159 */       if (uploadFile.getSize() == 0L) {
/* 160 */         model.addAttribute("fileuploadError", "请选择图片");
/* 161 */         return null;
/* 162 */       }if (uploadFile.getSize() > 512000L) {
/* 163 */         model.addAttribute("fileuploadError", "图片大小不能超过500k");
/* 164 */         return null;
/* 165 */       }if (uploadFile.getSize() <= 512000L) {
/* 166 */         String orgFileName = uploadFile.getOriginalFilename();
/* 167 */         String exts = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
/*     */ 
/* 169 */         if (!FileUploadUtil.ifExtendNamePermitted(exts)) {
/* 170 */           model.addAttribute("fileuploadError", "图片格式必须为jpg,jpeg,gif,png");
/* 171 */           return null;
/*     */         }
/*     */       }
/* 174 */       String fileName = this.fileUploadUtil.uploadFile(uploadFile, "", "usercredit");
/* 175 */       systemCreditLevel.setImgName(fileName);
/*     */     }
/*     */ 
/* 179 */     this.systemCreditLevelEditValidator.validate(systemCreditLevel, result);
/* 180 */     if (result.hasErrors()) {
/* 181 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 182 */       return null;
/*     */     }
/*     */ 
/* 185 */     systemCreditLevel.setGmtModify(new Date());
/* 186 */     systemCreditLevel.setOperator(userAgent.getUserAccount());
/* 187 */     this.systemCreditLevelService.updateByPrimaryKey(systemCreditLevel);
/* 188 */     return new ModelAndView("redirect:/baseset/syscreditlevel/list.htm?pageNo=1", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMCREDITLEVEL_VIEW})
/*     */   @RequestMapping({"/baseset/syscreditlevel/view"})
/*     */   public void view(@RequestParam("id") Long id, Model model)
/*     */     throws Exception
/*     */   {
/* 198 */     SystemCreditLevel smls = this.systemCreditLevelService.selectByPrimaryKey(id);
/* 199 */     model.addAttribute("smls", smls);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.baseset.SystemCreditLevelAction
 * JD-Core Version:    0.6.0
 */