/*     */ package com.hundsun.network.gates.genshan.web.action.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemMemberlevelSet;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemMemberlevelSetQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemMemberlevelSetService;
/*     */ import com.hundsun.network.gates.genshan.common.FileUploadUtil;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
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
/*     */ public class SysMemLevelSetAction extends BaseAction
/*     */ {
/*  39 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private SystemMemberlevelSetService systemMemberlevelSetService;
/*     */ 
/*     */   @Autowired
/*     */   private FileUploadUtil fileUploadUtil;
/*     */   private static final int FILE_MAX_SIZE = 512000;
/*     */ 
/*     */   @Autowired
/*     */   private Validator sysMemLevelSetAddValidator;
/*     */ 
/*     */   @Autowired
/*     */   private Validator sysMemLevelSetEditValidator;
/*     */ 
/*  64 */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMLEVSET_LIST})
/*     */   @RequestMapping({"/baseset/sysmemlevel/list"})
/*     */   public void list(@RequestParam(value="memberLevel", required=false) String memberLevel, @RequestParam(value="levelName", required=false) String levelName, @ModelAttribute("query") SystemMemberlevelSetQuery query, ModelMap model) throws Exception { if (StringUtil.isNotEmpty(levelName)) {
/*  65 */       query.setLevelName(levelName.trim());
/*     */     }
/*  67 */     if (StringUtil.isNotEmpty(memberLevel)) {
/*  68 */       query.setMemberLevel(memberLevel.trim());
/*     */     }
/*  70 */     this.systemMemberlevelSetService.selectPageList(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMLEVSET_ADD})
/*     */   @RequestMapping(value={"/baseset/sysmemlevel/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String add(@ModelAttribute("sysMemLevelSet") SystemMemberlevelSet sysMemLevelSet, Model model)
/*     */     throws Exception
/*     */   {
/*  82 */     return "/baseset/sysmemlevel/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMLEVSET_ADD})
/*     */   @RequestMapping(value={"/baseset/sysmemlevel/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView add2(@RequestParam("uploadFile") MultipartFile uploadFile, @ModelAttribute("sysMemLevelSet") SystemMemberlevelSet sysMemLevelSet, BindingResult result, Model model, Cookyjar cookyjar, UserAgent userAgent)
/*     */     throws Exception
/*     */   {
/*  98 */     if ((uploadFile != null) && (uploadFile.getSize() != 0L) && (uploadFile.getOriginalFilename() != null)) {
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
/* 114 */       String fileName = this.fileUploadUtil.uploadFile(uploadFile, "", "memlevel");
/* 115 */       sysMemLevelSet.setImgName(fileName);
/*     */     }
/*     */ 
/* 118 */     this.sysMemLevelSetAddValidator.validate(sysMemLevelSet, result);
/* 119 */     if (result.hasErrors()) {
/* 120 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 121 */       return null;
/*     */     }
/* 123 */     sysMemLevelSet.setGmtModify(new Date());
/* 124 */     sysMemLevelSet.setOperator(userAgent.getUserAccount());
/* 125 */     this.systemMemberlevelSetService.insert(sysMemLevelSet);
/* 126 */     model.addAttribute("url", "/baseset/sysmemlevel/list");
/* 127 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMLEVSET_UPDATE})
/*     */   @RequestMapping(value={"/baseset/sysmemlevel/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String update(@RequestParam(value="id", required=true) Long id, @ModelAttribute("sysMemLevelSet") SystemMemberlevelSet sysMemLevelSet, Model model)
/*     */     throws Exception
/*     */   {
/* 141 */     sysMemLevelSet = this.systemMemberlevelSetService.selectByPrimaryKey(id);
/* 142 */     model.addAttribute("sysMemLevelSet", sysMemLevelSet);
/* 143 */     return "/baseset/sysmemlevel/update";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMLEVSET_UPDATE})
/*     */   @RequestMapping(value={"/baseset/sysmemlevel/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView update2(UserAgent userAgent, @RequestParam("uploadFile") MultipartFile uploadFile, @ModelAttribute("sysMemLevelSet") SystemMemberlevelSet sysMemLevelSet, BindingResult result, Model model)
/*     */     throws Exception
/*     */   {
/* 160 */     if ((uploadFile != null) && (uploadFile.getSize() != 0L) && (uploadFile.getOriginalFilename() != null)) {
/* 161 */       sysMemLevelSet.setImgName(uploadFile.getOriginalFilename());
/* 162 */       if (uploadFile.getSize() == 0L) {
/* 163 */         model.addAttribute("fileuploadError", "请选择图片");
/* 164 */         return null;
/* 165 */       }if (uploadFile.getSize() > 512000L) {
/* 166 */         model.addAttribute("fileuploadError", "图片大小不能超过500k");
/* 167 */         return null;
/* 168 */       }if (uploadFile.getSize() <= 512000L) {
/* 169 */         String orgFileName = uploadFile.getOriginalFilename();
/* 170 */         String exts = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
/*     */ 
/* 172 */         if (!FileUploadUtil.ifExtendNamePermitted(exts)) {
/* 173 */           model.addAttribute("fileuploadError", "图片格式必须为jpg,jpeg,gif,png");
/* 174 */           return null;
/*     */         }
/*     */       }
/* 177 */       String fileName = this.fileUploadUtil.uploadFile(uploadFile, "", "memlevel");
/* 178 */       sysMemLevelSet.setImgName(fileName);
/*     */     }
/*     */ 
/* 181 */     this.sysMemLevelSetEditValidator.validate(sysMemLevelSet, result);
/* 182 */     if (result.hasErrors()) {
/* 183 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 184 */       return null;
/*     */     }
/* 186 */     sysMemLevelSet.setGmtModify(new Date());
/* 187 */     sysMemLevelSet.setOperator(userAgent.getUserAccount());
/* 188 */     this.systemMemberlevelSetService.updateByPrimaryKey(sysMemLevelSet);
/* 189 */     model.addAttribute("url", "/baseset/sysmemlevel/list");
/* 190 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_MEMLEVSET_VIEW})
/*     */   @RequestMapping({"/baseset/sysmemlevel/view"})
/*     */   public void view(@RequestParam("id") Long id, Model model)
/*     */     throws Exception
/*     */   {
/* 200 */     SystemMemberlevelSet smls = this.systemMemberlevelSetService.selectByPrimaryKey(id);
/* 201 */     model.addAttribute("smls", smls);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.baseset.SysMemLevelSetAction
 * JD-Core Version:    0.6.0
 */