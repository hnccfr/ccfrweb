/*     */ package com.hundsun.network.gates.genshan.web.action.operation;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.operation.Announcement;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.AnnouncementQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.operation.AnnouncementService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.genshan.web.validator.AnnouncementAddValidator;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AnnouncementRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.AnnouncementServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteAnnouncementService;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class AnnouncementManageAction extends BaseAction
/*     */ {
/*  37 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private RemoteAnnouncementService remoteAnnouncementService;
/*     */ 
/*     */   @Autowired
/*     */   private AnnouncementService announcementService;
/*     */ 
/*     */   @Autowired
/*     */   private AnnouncementAddValidator announcementAddValidator;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*  59 */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_R_ANNOUNCEMENT_LIST})
/*     */   @RequestMapping({"/operation/announcement/list"})
/*     */   public String list(ModelMap model, @ModelAttribute("page") AnnouncementQuery<Announcement> page) throws Exception { page.trim();
/*  60 */     this.announcementService.paginate(page);
/*  61 */     model.put("announcementTypeList", EnumAnnouncementType.values());
/*  62 */     return "/operation/announcement/list";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_R_ANNOUNCEMENT_INFO})
/*     */   @RequestMapping({"/operation/announcement/info"})
/*     */   public String info(ModelMap model, @RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/*  73 */     model.put("announcement", this.announcementService.queryAnnouncementInfo(id));
/*  74 */     return "/operation/announcement/info";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_C_ANNOUNCEMENT_ADD})
/*     */   @RequestMapping(value={"/operation/announcement/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String addSystemAnnouncementPage(ModelMap model)
/*     */     throws Exception
/*     */   {
/*  85 */     model.put("announcementTypeList", EnumAnnouncementType.values());
/*  86 */     model.put("announcement", new Announcement());
/*  87 */     return "/operation/announcement/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_C_ANNOUNCEMENT_ADD})
/*     */   @RequestMapping(value={"/operation/announcement/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String addSystemAnnouncement(@ModelAttribute("announcement") Announcement announcement, BindingResult valiResult, UserAgent userAgent, ModelMap model)
/*     */     throws Exception
/*     */   {
/*  99 */     this.announcementAddValidator.validate(announcement, valiResult);
/* 100 */     if (valiResult.hasErrors()) {
/* 101 */       model.put("announcementTypeList", EnumAnnouncementType.values());
/* 102 */       return "/operation/announcement/add";
/*     */     }
/*     */ 
/* 105 */     AnnouncementDTO announcementDTO = ConvertUtils.convert2AnnouncementDTO(announcement);
/* 106 */     announcementDTO.setCreator(userAgent.getUserAccount());
/* 107 */     announcementDTO.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/* 108 */     AnnouncementRequest request = new AnnouncementRequest();
/* 109 */     request.setAnnouncementDTO(announcementDTO);
/* 110 */     AnnouncementServiceResult result = this.remoteAnnouncementService.createAnnouncement(request);
/* 111 */     if (!result.correct()) {
/* 112 */       model.put("message", "保存 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/* 113 */       return error(model);
/*     */     }
/* 115 */     model.put("message", "保存 成功！");
/* 116 */     model.put("url", "/operation/announcement/list");
/* 117 */     model.put("announcementId", result.getAnnouncementDTO().getId());
/* 118 */     return "/operation/announcement/success";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_D_ANNOUNCEMENT_DEL})
/*     */   @RequestMapping(value={"/operation/announcement/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String delSystemAnnouncement(ModelMap model, @RequestParam("id") Long id, UserAgent userAgent)
/*     */     throws Exception
/*     */   {
/* 128 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/* 129 */     announcementDTO.setId(id);
/* 130 */     announcementDTO.setOperator(userAgent.getUserAccount());
/* 131 */     announcementDTO.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/* 132 */     AnnouncementRequest request = new AnnouncementRequest();
/* 133 */     request.setAnnouncementDTO(announcementDTO);
/* 134 */     AnnouncementServiceResult result = this.remoteAnnouncementService.removeAnnouncement(request);
/* 135 */     if (!result.correct()) {
/* 136 */       model.put("message", "删除 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/* 137 */       model.put("url", "/operation/announcement/list");
/* 138 */       return error(model);
/*     */     }
/* 140 */     model.put("url", "/operation/announcement/list");
/* 141 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_U_ANNOUNCEMENT_JOIN_PRO})
/*     */   @RequestMapping(value={"/operation/announcement/join"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String joinProject(ModelMap model, @RequestParam("announcementId") Long announcementId, @RequestParam("projectId") Long projectId, UserAgent userAgent)
/*     */     throws Exception
/*     */   {
/* 155 */     if ((announcementId == null) || (projectId == null)) {
/* 156 */       model.put("message", "输入参数错误!");
/* 157 */       return error(model);
/*     */     }
/* 159 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/* 160 */     announcementDTO.setId(announcementId);
/* 161 */     announcementDTO.setProjectId(projectId);
/* 162 */     announcementDTO.setOperator(userAgent.getUserAccount());
/* 163 */     announcementDTO.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/* 164 */     AnnouncementRequest request = new AnnouncementRequest();
/* 165 */     request.setAnnouncementDTO(announcementDTO);
/* 166 */     AnnouncementServiceResult result = this.remoteAnnouncementService.joinProject(request);
/* 167 */     if (!result.correct()) {
/* 168 */       model.put("message", "关联 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/* 169 */       return error(model);
/*     */     }
/* 171 */     model.put("url", "/operation/announcement/list");
/* 172 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_U_ANNOUNCEMENT_LEAVE_PRO})
/*     */   @RequestMapping(value={"/operation/announcement/leave"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String leaveProject(ModelMap model, @RequestParam("id") Long id, UserAgent userAgent)
/*     */     throws Exception
/*     */   {
/* 183 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/* 184 */     announcementDTO.setId(id);
/* 185 */     announcementDTO.setOperator(userAgent.getUserAccount());
/* 186 */     announcementDTO.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/* 187 */     AnnouncementRequest request = new AnnouncementRequest();
/* 188 */     request.setAnnouncementDTO(announcementDTO);
/* 189 */     AnnouncementServiceResult result = this.remoteAnnouncementService.leaveProject(request);
/* 190 */     if (!result.correct()) {
/* 191 */       model.put("message", "删除 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/* 192 */       return error(model);
/*     */     }
/* 194 */     model.put("url", "/operation/announcement/list");
/* 195 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_U_ANNOUNCEMENT_NORMAL})
/*     */   @RequestMapping(value={"/operation/announcement/normal"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String normal(ModelMap model, @RequestParam("id") Long id, UserAgent userAgent)
/*     */     throws Exception
/*     */   {
/* 206 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/* 207 */     announcementDTO.setId(id);
/* 208 */     announcementDTO.setOperator(userAgent.getUserAccount());
/* 209 */     announcementDTO.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/* 210 */     AnnouncementRequest request = new AnnouncementRequest();
/* 211 */     request.setAnnouncementDTO(announcementDTO);
/* 212 */     AnnouncementServiceResult result = this.remoteAnnouncementService.normal(request);
/* 213 */     if (!result.correct()) {
/* 214 */       model.put("message", "发布 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/* 215 */       return error(model);
/*     */     }
/* 217 */     model.put("url", "/operation/announcement/list");
/* 218 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_U_ANNOUNCEMENT_EDIT})
/*     */   @RequestMapping(value={"/operation/announcement/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String editAnnouncementPage(ModelMap model, @RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/* 229 */     Announcement announcement = new Announcement();
/* 230 */     announcement = this.announcementService.queryAnnouncementInfo(id);
/* 231 */     if (announcement.isJoinProject())
/* 232 */       announcement.setProjectTitle(this.projectListingService.getProSimpInfo(announcement.getProjectId()).getTitle());
/* 233 */     model.put("announcement", announcement);
/* 234 */     model.put("announcementTypeList", EnumAnnouncementType.values());
/* 235 */     return "/operation/announcement/edit";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.OPR_U_ANNOUNCEMENT_EDIT})
/*     */   @RequestMapping(value={"/operation/announcement/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String edit(@ModelAttribute("announcement") Announcement announcement, BindingResult valiResult, UserAgent userAgent, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 247 */     this.announcementAddValidator.validate(announcement, valiResult);
/* 248 */     if (valiResult.hasErrors()) {
/* 249 */       model.put("announcementTypeList", EnumAnnouncementType.values());
/* 250 */       return "/operation/announcement/edit";
/*     */     }
/*     */ 
/* 253 */     AnnouncementDTO announcementDTO = ConvertUtils.convert2AnnouncementDTO(announcement);
/* 254 */     announcementDTO.setOperator(userAgent.getUserAccount());
/* 255 */     announcementDTO.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 256 */     AnnouncementRequest request = new AnnouncementRequest();
/* 257 */     request.setAnnouncementDTO(announcementDTO);
/* 258 */     AnnouncementServiceResult result = this.remoteAnnouncementService.updateById(request);
/* 259 */     if (!result.correct()) {
/* 260 */       model.put("message", "保存 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/* 261 */       return error(model);
/*     */     }
/* 263 */     model.put("message", "保存 成功！");
/* 264 */     model.put("url", "/operation/announcement/list");
/* 265 */     if (announcement.isCreate())
/* 266 */       model.put("announcementId", announcement.getId());
/* 267 */     return "/operation/announcement/success";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.operation.AnnouncementManageAction
 * JD-Core Version:    0.6.0
 */