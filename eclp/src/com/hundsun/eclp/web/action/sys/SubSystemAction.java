/*     */ package com.hundsun.eclp.web.action.sys;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.service.AuthorityService;
/*     */ import com.hundsun.eclp.biz.service.sys.SubSystemService;
/*     */ import com.hundsun.eclp.enums.EnumSubSystemIsCore;
/*     */ import com.hundsun.eclp.enums.EnumSubSystemOpenType;
/*     */ import com.hundsun.eclp.enums.EnumSubSystemStatus;
/*     */ import com.hundsun.eclp.security.AdminAccess;
/*     */ import com.hundsun.eclp.util.FileUploadUtil;
/*     */ import com.hundsun.eclp.util.StringUtil;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.multipart.MultipartHttpServletRequest;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/system"})
/*     */ public class SubSystemAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private SubSystemService subSystemService;
/*     */ 
/*     */   @Autowired
/*     */   private AuthorityService authorityService;
/*     */   public static final int MAX_FILE_SIZE = 500;
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_MANAGE})
/*     */   @RequestMapping(value={"/subsystem_list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void subSystemList(Model model, UserAgent user)
/*     */   {
/*  52 */     List subSystemList = this.subSystemService.getAllSubSystemList(user);
/*  53 */     model.addAttribute("subSystemList", subSystemList);
/*  54 */     model.addAttribute("enumSubSystemOpenType", EnumSubSystemOpenType.values());
/*  55 */     model.addAttribute("enumSubSystemIsCore", EnumSubSystemIsCore.values());
/*  56 */     model.addAttribute("enumSubSystemStatus", EnumSubSystemStatus.values());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_DEL})
/*     */   @RequestMapping({"/delete_subsystem_check"})
/*     */   @ResponseBody
/*     */   public int deleteSubSystemCheck(@RequestParam(value="subSystemId", required=false) Long subSystemId, Model model)
/*     */   {
/*  71 */     int count = this.authorityService.getChildrenCountOfSubSystem(subSystemId);
/*  72 */     return count;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_DEL})
/*     */   @RequestMapping(value={"/delete_subsystem"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String deleteSubSystem(@RequestParam(value="subSystemId", required=false) Long subSystemId, Model model, UserAgent user)
/*     */   {
/*  87 */     this.subSystemService.deleteSubSystem(subSystemId, user);
/*     */ 
/*  89 */     return "redirect:/system/subsystem_list.htm";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_ADD, com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_EDIT})
/*     */   @RequestMapping({"/subsystem_name_check"})
/*     */   @ResponseBody
/*     */   public Object[] subSystemNameCheck(@RequestParam(value="name", required=false) String name, @RequestParam(value="subSystemId", required=false) Long subSystemId, Model model)
/*     */   {
/* 105 */     Object[] temp = this.subSystemService.subSystemNameCheck(name, subSystemId);
/* 106 */     return temp;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_ADD, com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_EDIT})
/*     */   @RequestMapping({"/subsystem_fullname_check"})
/*     */   @ResponseBody
/*     */   public Object[] subSystemFullNameCheck(@RequestParam(value="fullName", required=false) String fullName, @RequestParam(value="subSystemId", required=false) Long subSystemId, Model model)
/*     */   {
/* 122 */     Object[] temp = this.subSystemService.subSystemFullNameCheck(fullName, subSystemId);
/* 123 */     return temp;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_ENABLE, com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_DISABLE})
/*     */   @RequestMapping({"/subsystem_status_modify"})
/*     */   public String subSystemStatusModify(@RequestParam(value="subSystemId", required=false) Long subSystemId, @RequestParam(value="status", required=false) Short status, Model model, UserAgent user)
/*     */   {
/* 140 */     this.subSystemService.modifyStatus(subSystemId, status, user);
/* 141 */     return "redirect:/system/subsystem_list.htm";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_ADD})
/*     */   @RequestMapping(value={"/subsystem_add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void subSystemAdd(@ModelAttribute("subSystem") SubSystem subSystem, Model model)
/*     */   {
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_ADD})
/*     */   @RequestMapping(value={"/subsystem_add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String subSystemAddSubmit(@ModelAttribute("subSystem") SubSystem subSystem, Model model, UserAgent user, MultipartHttpServletRequest request)
/*     */   {
/* 168 */     boolean checkName = this.subSystemService.checkSubSystemNames(subSystem.getName(), subSystem.getFullName(), null, model);
/* 169 */     boolean checkFile = checkFile(request, model, subSystem);
/* 170 */     if ((!checkName) || (!checkFile)) {
/* 171 */       return null;
/*     */     }
/* 173 */     StringUtil.trim(subSystem);
/* 174 */     this.subSystemService.insert(subSystem, user);
/*     */ 
/* 176 */     return "redirect:/system/subsystem_list.htm";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_EDIT})
/*     */   @RequestMapping(value={"/subsystem_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void subSystemEdit(@RequestParam(value="subSystemId", required=false) Long subSystemId, @ModelAttribute("subSystem") SubSystem subSystem, Model model)
/*     */   {
/* 189 */     subSystem = this.subSystemService.selectById(subSystemId);
/* 190 */     StringUtil.trim(subSystem);
/* 191 */     model.addAttribute("subSystem", subSystem);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.SUBSYSTEM_EDIT})
/*     */   @RequestMapping(value={"/subsystem_edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String subSystemEditSubmit(@ModelAttribute("subSystem") SubSystem subSystem, Model model, UserAgent user, MultipartHttpServletRequest request)
/*     */   {
/* 207 */     boolean checkName = this.subSystemService.checkSubSystemNames(subSystem.getName(), subSystem.getFullName(), subSystem.getId(), model);
/*     */ 
/* 209 */     boolean checkChildAuth = this.subSystemService.checkChildAuth(subSystem, model);
/* 210 */     boolean checkFile = checkFile(request, model, subSystem);
/*     */ 
/* 212 */     if ((!checkName) || (!checkChildAuth) || (!checkFile)) {
/* 213 */       return null;
/*     */     }
/* 215 */     this.subSystemService.update(subSystem, user);
/*     */ 
/* 217 */     return "redirect:/system/subsystem_list.htm";
/*     */   }
/*     */ 
/*     */   public boolean checkFile(MultipartHttpServletRequest request, Model model, SubSystem subSystem)
/*     */   {
/* 222 */     MultipartFile file = request.getFile("subSysLogo");
/* 223 */     if (file != null) {
/* 224 */       Long fileSize = Long.valueOf(file.getSize());
/* 225 */       if (fileSize.longValue() > 0L) {
/* 226 */         if (!FileUploadUtil.ifExtendNamePermitted(file))
/*     */         {
/* 228 */           String errorStr = "图片格式错误，应为[jpg、jpeg、gif、png]";
/* 229 */           model.addAttribute("fileUploadError", errorStr);
/* 230 */           return false;
/* 231 */         }if (!FileUploadUtil.ifFileSizePermitted(file))
/*     */         {
/* 233 */           String errorStr = "'子系统图片不能超过500k！'";
/* 234 */           model.addAttribute("fileUploadError", errorStr);
/* 235 */           return false;
/*     */         }
/* 237 */         subSystem.setFile(file);
/*     */       }
/*     */     }
/* 240 */     return true;
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/subsystem_position_modify"})
/*     */   public String subSystemPositonModify(@RequestParam(value="subSystemId", required=false) Long subSystemId, @RequestParam(value="flag", required=false) String flag, Model model, UserAgent user)
/*     */   {
/* 255 */     this.subSystemService.modifyPosition(subSystemId, flag, user);
/* 256 */     return "redirect:/system/subsystem_list.htm";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.sys.SubSystemAction
 * JD-Core Version:    0.6.0
 */