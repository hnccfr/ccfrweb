/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*     */ import com.hundsun.network.hseccms.model.Cms2ChannelGroup;
/*     */ import com.hundsun.network.hseccms.model.Cms2Group;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.query.Cms2ChannelQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelGroupService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2GroupService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ModelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/permuser"})
/*     */ public class PermissionUser extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ModelService cms2ModelService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelService cms2ChannelService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelGroupService cms2ChannelGroupService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2GroupService cms2GroupService;
/*     */ 
/*     */   @RequestMapping({"/index"})
/*     */   public String index(Model model)
/*     */   {
/*  48 */     return "permuser/index";
/*     */   }
/*     */   @RequestMapping({"/tree"})
/*     */   public String tree(Model model, HttpServletRequest request) {
/*  53 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  54 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*  55 */     List list = this.cms2ChannelService.getWholeTreeBySite(site.getId());
/*  56 */     model.addAttribute("list", list);
/*  57 */     return "permuser/tree";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Cms2ChannelQuery query, HttpServletRequest request, Model model) {
/*  63 */     if (StringUtil.isNotEmpty(queryStr)) {
/*  64 */       query = (Cms2ChannelQuery)query.riseUp(queryStr);
/*     */     }
/*  66 */     model.addAttribute("query", query);
/*  67 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/*  68 */     List<Cms2Channel> channelList = null;
/*  69 */     Map channelGroupMap = new HashMap();
/*  70 */     if ((StringUtil.isBlank(query.getParentId())) || (Long.parseLong(query.getParentId()) <= 0L))
/*     */     {
/*  72 */       channelList = this.cms2ChannelService.getTopListBySite(currentSiteId.longValue(), true);
/*     */     }
/*  74 */     else channelList = this.cms2ChannelService.queryListByParent(Long.parseLong(query.getParentId()), true);
/*     */ 
/*  76 */     if ((channelList != null) && (channelList.size() > 0)) {
/*  77 */       for (Cms2Channel channel : channelList) {
/*  78 */         List channelGroupUploadList = this.cms2ChannelGroupService.getGroupByChannelIdType(channel.getId(), Long.valueOf(1L));
/*  79 */         String channelGroups = "";
/*  80 */         if ((channelGroupUploadList != null) && (channelGroupUploadList.size() > 0)) {
/*  81 */           for (int i = 0; i < channelGroupUploadList.size(); i++) {
/*  82 */             if (i != channelGroupUploadList.size() - 1)
/*  83 */               channelGroups = channelGroups + ((Cms2Group)channelGroupUploadList.get(i)).getGroupName() + ",";
/*     */             else {
/*  85 */               channelGroups = channelGroups + ((Cms2Group)channelGroupUploadList.get(i)).getGroupName();
/*     */             }
/*  87 */             channelGroupMap.put(channel.getId().toString(), channelGroups);
/*     */           }
/*     */         } else {
/*  90 */           channelGroups = "暂无权限";
/*  91 */           channelGroupMap.put(channel.getId().toString(), channelGroups);
/*     */         }
/*     */       }
/*     */     }
/*  95 */     List modelList = this.cms2ModelService.getEnabledModelList();
/*  96 */     model.addAttribute("parentId", query.getParentId());
/*  97 */     model.addAttribute("modelList", modelList);
/*  98 */     model.addAttribute("channelList", channelList);
/*  99 */     model.addAttribute("channelGroupMap", channelGroupMap);
/* 100 */     return "permuser/list";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/view"})
/*     */   public String view(Long id, Model model, HttpServletRequest request)
/*     */   {
/* 111 */     List channelGroupUploadList = this.cms2ChannelGroupService.getGroupByChannelIdType(id, Long.valueOf(1L));
/* 112 */     List channelGroupViewList = this.cms2ChannelGroupService.getGroupByChannelIdType(id, Long.valueOf(2L));
/* 113 */     Cms2Channel channel = this.cms2ChannelService.queryById(id);
/* 114 */     model.addAttribute("groupUploadList", channelGroupUploadList);
/* 115 */     model.addAttribute("groupViewList", channelGroupViewList);
/* 116 */     model.addAttribute("channel", channel);
/* 117 */     return "permuser/view";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String edit(Long channelId, @RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request) {
/* 123 */     Cms2Channel channel = this.cms2ChannelService.queryById(channelId);
/* 124 */     List cms2GroupList = this.cms2GroupService.getAllGroup();
/* 125 */     List channelGroupUploadList = this.cms2ChannelGroupService.getGroupByChannelIdType(channelId, Long.valueOf(1L));
/* 126 */     List channelGroupViewList = this.cms2ChannelGroupService.getGroupByChannelIdType(channelId, Long.valueOf(2L));
/* 127 */     model.addAttribute("channel", channel);
/* 128 */     model.addAttribute("cms2GroupList", cms2GroupList);
/* 129 */     model.addAttribute("groupUploadList", channelGroupUploadList);
/* 130 */     model.addAttribute("groupViewList", channelGroupViewList);
/* 131 */     model.addAttribute("q", queryStr);
/* 132 */     return "permuser/edit";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String save(Long channelId, @RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="uploadperms", required=false) List<Long> uploadPermsList, @RequestParam(value="viewperms", required=false) List<Long> viewPermsList, @RequestParam(value="", required=false) List<Long> sorts, Model model, HttpServletRequest request)
/*     */   {
/* 141 */     this.cms2ChannelGroupService.deleteByChannelId(channelId);
/* 142 */     Cms2ChannelGroup cms2ChannelGroup = new Cms2ChannelGroup();
/*     */     int i;
/* 143 */     if (null != uploadPermsList) {
/* 144 */       i = 0;
/* 145 */       for (Long uploadPerms : uploadPermsList) {
/* 146 */         cms2ChannelGroup.setChannelId(channelId);
/* 147 */         cms2ChannelGroup.setGroupId(uploadPerms);
/* 148 */         cms2ChannelGroup.setType(Long.valueOf(1L));
/* 149 */         cms2ChannelGroup.setSort((Long)sorts.get(i));
/* 150 */         this.cms2ChannelGroupService.add(cms2ChannelGroup);
/* 151 */         i++;
/*     */       }
/*     */     }
/* 154 */     if (null != viewPermsList) {
/* 155 */       for (Long viewPerms : viewPermsList) {
/* 156 */         cms2ChannelGroup.setChannelId(channelId);
/* 157 */         cms2ChannelGroup.setGroupId(viewPerms);
/* 158 */         cms2ChannelGroup.setType(Long.valueOf(2L));
/* 159 */         this.cms2ChannelGroupService.add(cms2ChannelGroup);
/*     */       }
/*     */     }
/* 162 */     String message = "修改成功";
/* 163 */     model.addAttribute("q", queryStr);
/* 164 */     return super.success(model, message, "/permuser/list.htm");
/*     */   }
/* 170 */   @RequestMapping({"/getNextSort"})
/*     */   @ResponseBody
/*     */   public Model getNextSort(String channelId, String groupId, Model model, HttpServletRequest request) { Cms2ChannelGroup channelGroup = this.cms2ChannelGroupService.getByChannelAndGroup(channelId, groupId);
/* 171 */     int sort = 0;
/* 172 */     if ((channelGroup != null) && (channelGroup.getSort() != null))
/* 173 */       sort = channelGroup.getSort().intValue();
/*     */     else
/* 175 */       sort = this.cms2ChannelGroupService.getNextSortNum(Long.valueOf(Long.parseLong(groupId)));
/* 176 */     model.addAttribute("nextSort", Integer.valueOf(sort));
/* 177 */     return model;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.PermissionUser
 * JD-Core Version:    0.6.0
 */