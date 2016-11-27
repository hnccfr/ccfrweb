/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.eclp.client.remote.client.RemoteUserService;
/*     */ import com.hundsun.eclp.client.remote.dto.UserDTO;
/*     */ import com.hundsun.eclp.client.remote.dto.UserResult;
/*     */ import com.hundsun.network.cms.client.dto.CommonUserDTO;
/*     */ import com.hundsun.network.cms.client.request.CmsUserRequest;
/*     */ import com.hundsun.network.cms.client.result.CmsUserResult;
/*     */ import com.hundsun.network.cms.client.service.CmsRemoteService;
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.enums.EnumCommonUserSexType;
/*     */ import com.hundsun.network.hseccms.enums.EnumUseSiteIsAllChl;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.model.Cms2UserSite;
/*     */ import com.hundsun.network.hseccms.model.Cms2UserStep;
/*     */ import com.hundsun.network.hseccms.query.Cms2ChannelUserQuery;
/*     */ import com.hundsun.network.hseccms.query.Cms2UserSiteQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelUserService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.hseccms.service.Cms2UserSiteService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/userstep"})
/*     */ public class UserStepAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   CmsRemoteService cmsRemoteService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelService cms2ChannelService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelUserService cms2ChannelUserService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2UserSiteService cms2UserSiteService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Value("${sys.default.finalStep}")
/*     */   private Long sysFinalStep;
/*     */ 
/*     */   @Value("${system.accessType}")
/*     */   private String accessType;
/*     */ 
/*     */   @Value("${subsystemCode}")
/*     */   private String subsystemCode;
/*     */ 
/*     */   @RequestMapping({"/list"})
/*     */   public String list(HttpServletRequest request, Model model)
/*     */   {
/*  81 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/*  82 */     model.addAttribute("siteId", currentSiteId);
/*  83 */     List commonUserDTOList = new ArrayList();
/*  84 */     String message = "";
/*  85 */     if ((null != this.accessType) && (this.accessType.equals("eclp"))) {
/*  86 */       UserDTO user = new UserDTO();
/*  87 */       user.setSubSystemCode(this.subsystemCode);
/*  88 */       user.setPageSize(Integer.valueOf(20));
/*  89 */       user.setCurrPage(Integer.valueOf(1));
/*  90 */       UserResult userResult = this.remoteUserService.getUserListBySubSystemCode(user);
/*     */ 
/*  92 */       if ((userResult != null) && (!userResult.isSuccess())) {
/*  93 */         message = userResult.getErrorMsg();
/*     */       } else {
/*  95 */         List<UserDTO> userDTOList = (ArrayList)userResult.getResult();
/*  96 */         for (UserDTO userDTO : userDTOList) {
/*  97 */           CommonUserDTO commonUserDTO = new CommonUserDTO();
/*  98 */           commonUserDTO.setAccount(userDTO.getAccount());
/*  99 */           commonUserDTO.setId(userDTO.getUserId());
/* 100 */           commonUserDTO.setName(userDTO.getRealName());
/* 101 */           commonUserDTO.setMobilePhone(userDTO.getMobilePhone());
/* 102 */           commonUserDTOList.add(commonUserDTO);
/*     */         }
/*     */       }
/*     */     } else {
/* 106 */       CmsUserRequest cmsRemoteRequest = new CmsUserRequest();
/* 107 */       CmsUserResult cmsRemoteResult = this.cmsRemoteService.getUsers(cmsRemoteRequest);
/* 108 */       if ((cmsRemoteResult != null) && (cmsRemoteResult.isError()))
/* 109 */         message = cmsRemoteResult.getErrorInfo();
/*     */       else {
/* 111 */         commonUserDTOList = cmsRemoteResult.getUserDTOList();
/*     */       }
/*     */     }
/* 114 */     model.addAttribute("userList", commonUserDTOList);
/* 115 */     model.addAttribute("message", message);
/* 116 */     model.addAttribute("sexTypeMap", EnumCommonUserSexType.toMap());
/* 117 */     return "userstep/list";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/editView"})
/*     */   public String editView(@RequestParam(value="userId", required=false, defaultValue="") Long userId, HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/* 124 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/* 125 */     Cms2Site site = this.cms2SiteService.queryById(currentSiteId);
/*     */ 
/* 127 */     model.addAttribute("siteFinalStep", site.getFinalStep());
/* 128 */     List channelList = this.cms2ChannelService.getWholeTreeBySite(currentSiteId);
/*     */ 
/* 130 */     model.addAttribute("channelList", channelList);
/* 131 */     Cms2UserSiteQuery useSiteQuery = new Cms2UserSiteQuery();
/* 132 */     useSiteQuery.setSiteId(currentSiteId.toString());
/* 133 */     useSiteQuery.setAdminId(userId.toString());
/* 134 */     List userSiteList = this.cms2UserSiteService.queryCms2UserSiteList(useSiteQuery);
/* 135 */     if ((null != userSiteList) && (userSiteList.size() > 0)) {
/* 136 */       Cms2UserSite userSite = (Cms2UserSite)userSiteList.get(0);
/* 137 */       if (EnumUseSiteIsAllChl.TRUE.getCode().equals(userSite.getIsAllChannel()))
/* 138 */         model.addAttribute("allChannels", Boolean.valueOf(true));
/*     */       else {
/* 140 */         model.addAttribute("allChannels", Boolean.valueOf(false));
/*     */       }
/* 142 */       model.addAttribute("userSite", userSite);
/*     */     } else {
/* 144 */       model.addAttribute("allChannels", Boolean.valueOf(false));
/*     */     }
/* 146 */     model.addAttribute("maxSiteFinalSetp", this.sysFinalStep);
/* 147 */     model.addAttribute("userId", userId);
/* 148 */     Cms2ChannelUserQuery query = new Cms2ChannelUserQuery();
/* 149 */     query.setAdminId(userId.toString());
/* 150 */     List userChannelList = this.cms2ChannelUserService.queryCms2ChannelUserList(query);
/* 151 */     model.addAttribute("userChannels", userChannelList);
/* 152 */     return "userstep/edit";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/edit"})
/*     */   public String edit(Long userId, Long steps, Long[] channelCheckSetp, Boolean allChannels, HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/* 160 */     if (null != userId) {
/* 161 */       Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/* 162 */       Cms2UserStep userStep = new Cms2UserStep();
/* 163 */       userStep.setSiteId(currentSiteId);
/* 164 */       userStep.setUserId(userId);
/* 165 */       userStep.setAllChannels(allChannels);
/* 166 */       userStep.setChannelCheckSetp(channelCheckSetp);
/* 167 */       userStep.setSiteFinalStep(steps);
/* 168 */       String result = this.cms2ChannelUserService.setUserStep(userStep);
/* 169 */       if (!result.equals("")) {
/* 170 */         return super.error(model, result, "", "/userstep/list.htm");
/*     */       }
/* 172 */       return super.success(model, "设置成功", "/userstep/list.htm");
/*     */     }
/*     */ 
/* 175 */     return super.error(model, "未知错误", "", "/userstep/list.htm");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.UserStepAction
 * JD-Core Version:    0.6.0
 */