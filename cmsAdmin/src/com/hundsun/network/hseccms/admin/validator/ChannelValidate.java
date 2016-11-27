/*     */ package com.hundsun.network.hseccms.admin.validator;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.enums.EnumChannelStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumContStatus;
/*     */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*     */ import com.hundsun.network.hseccms.model.Cms2ChannelExt;
/*     */ import com.hundsun.network.hseccms.model.Cms2ModelItem;
/*     */ import com.hundsun.network.hseccms.query.Cms2ChannelQuery;
/*     */ import com.hundsun.network.hseccms.query.Cms2ContQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ContService;
/*     */ import com.hundsun.network.hseccms.util.Cms2TreeSortTool;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.ui.Model;
/*     */ 
/*     */ @Service("channelValidate")
/*     */ public class ChannelValidate
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelService cms2ChannelService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ContService cms2ContService;
/*     */ 
/*     */   public boolean ifSiteChangeOver(Long channelSiteId, Model model, HttpServletRequest request)
/*     */   {
/*  37 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/*  38 */     if ((currentSiteId == null) || (currentSiteId.compareTo(channelSiteId) != 0))
/*     */     {
/*  40 */       model.addAttribute("message", "站点不存在或已切换");
/*  41 */       return false;
/*     */     }
/*  43 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean channelNumLimit(String treeSort, Model model)
/*     */   {
/*  51 */     int suffix = Integer.parseInt(Cms2TreeSortTool.getSuffix(treeSort));
/*  52 */     if (suffix > 998) {
/*  53 */       model.addAttribute("message", "该父栏目下排序号已用完,请联系管理员");
/*  54 */       return false;
/*     */     }
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   public boolean addOperatorValidate(Long currentSiteId, Long parentId, Long modelId, Model model)
/*     */   {
/*  64 */     boolean is_success = true;
/*  65 */     if ((currentSiteId == null) || (currentSiteId.compareTo(Long.valueOf(0L)) <= 0)) {
/*  66 */       model.addAttribute("message", "站点信息缺失!");
/*  67 */       is_success = false;
/*  68 */       return is_success;
/*     */     }
/*  70 */     if ((modelId == null) || (modelId.compareTo(Long.valueOf(0L)) <= 0)) {
/*  71 */       model.addAttribute("message", "未选择模型!");
/*  72 */       is_success = false;
/*  73 */       return is_success;
/*     */     }
/*  75 */     if ((parentId != null) && (parentId.compareTo(Long.valueOf(0L)) > 0)) {
/*  76 */       Cms2Channel channel = this.cms2ChannelService.queryById(parentId);
/*  77 */       if (channel == null) {
/*  78 */         model.addAttribute("message", "父栏目不存在或已删除");
/*  79 */         is_success = false;
/*  80 */         return is_success;
/*     */       }
/*  82 */       if (!channel.getSiteId().equals(currentSiteId)) {
/*  83 */         model.addAttribute("message", "由于站点切换，此次添加操作无效!");
/*  84 */         is_success = false;
/*  85 */         return is_success;
/*     */       }
/*     */     }
/*  88 */     return is_success;
/*     */   }
/*     */ 
/*     */   public boolean saveOperValidate(Long siteId, Long parentId, List<Cms2ModelItem> modelItemList, Cms2Channel channel, Cms2ChannelExt channelExt, Model model)
/*     */   {
/*  96 */     boolean is_success = true;
/*  97 */     is_success = matchChannelAndModelItem(siteId, modelItemList, channel, channelExt, model);
/*  98 */     return is_success;
/*     */   }
/*     */ 
/*     */   public boolean updateOperatorValidate(Long currentSiteId, List<Cms2ModelItem> modelItemList, Cms2Channel channel, Cms2ChannelExt channelExt, Model model)
/*     */   {
/* 105 */     boolean is_success = true;
/* 106 */     is_success = matchChannelAndModelItem(currentSiteId, modelItemList, channel, channelExt, model);
/* 107 */     return is_success;
/*     */   }
/*     */ 
/*     */   public boolean deleteOperatorValidate(Cms2Channel channel, Model model)
/*     */   {
/* 114 */     boolean is_success = true;
/*     */ 
/* 116 */     Cms2ChannelQuery cms2ChannelQuery = new Cms2ChannelQuery();
/* 117 */     cms2ChannelQuery.setParentId(channel.getId().toString());
/* 118 */     cms2ChannelQuery.setStatus(EnumChannelStatus.AVAILABLE.getValue().toString());
/* 119 */     int count = this.cms2ChannelService.queryCms2ChannelCount(cms2ChannelQuery).intValue();
/* 120 */     if (count > 0) {
/* 121 */       model.addAttribute("message", "该栏目下存在子栏目");
/* 122 */       is_success = false;
/*     */     }
/*     */ 
/* 125 */     Cms2ContQuery cms2ContQuery = new Cms2ContQuery();
/* 126 */     cms2ContQuery.setChannelId(channel.getId().toString());
/* 127 */     cms2ContQuery.setStatusReject(EnumContStatus.DELETING.getCode().toString());
/* 128 */     long counts = this.cms2ContService.queryCms2ContCount(cms2ContQuery).longValue();
/* 129 */     if (counts > 0L) {
/* 130 */       model.addAttribute("message", "该栏目下存在文章");
/* 131 */       is_success = false;
/*     */     }
/* 133 */     return is_success;
/*     */   }
/*     */ 
/*     */   private boolean matchChannelAndModelItem(Long siteId, List<Cms2ModelItem> modelItemList, Cms2Channel channel, Cms2ChannelExt channelExt, Model model)
/*     */   {
/* 140 */     String value = null;
/* 141 */     for (Cms2ModelItem modelItem : modelItemList) {
/* 142 */       if ("code".equalsIgnoreCase(modelItem.getField())) {
/* 143 */         value = channel.getCode();
/* 144 */         if (StringUtil.isBlank(value)) {
/* 145 */           model.addAttribute("code_err", "栏目路径不能为空");
/* 146 */           return false;
/*     */         }
/* 148 */         channel.setCode(value.trim());
/*     */ 
/* 150 */         if (this.cms2ChannelService.judgeHasSameCodeInSite(channel.getId(), siteId, value.trim())) {
/* 151 */           model.addAttribute("code_err", "存在相同栏目路径");
/* 152 */           return false;
/*     */         }
/* 154 */       } else if ("channelName".equalsIgnoreCase(modelItem.getField())) {
/* 155 */         value = channel.getChannelName();
/* 156 */         channel.setChannelName(value == null ? value : value.trim());
/* 157 */       } else if ("keywords".equalsIgnoreCase(modelItem.getField())) {
/* 158 */         value = channelExt.getKeywords();
/* 159 */         channelExt.setKeywords(value == null ? value : value.trim());
/* 160 */       } else if ("title".equalsIgnoreCase(modelItem.getField())) {
/* 161 */         value = channelExt.getTitle();
/* 162 */         channelExt.setTitle(value == null ? value : value.trim());
/* 163 */       } else if ("remark".equalsIgnoreCase(modelItem.getField())) {
/* 164 */         value = channelExt.getRemark();
/* 165 */         channelExt.setRemark(value == null ? value : value.trim());
/* 166 */       } else if ("link".equalsIgnoreCase(modelItem.getField())) {
/* 167 */         value = channelExt.getLink();
/* 168 */         channelExt.setLink(value == null ? value : value.trim());
/*     */       }
/*     */     }
/* 171 */     return true;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.validator.ChannelValidate
 * JD-Core Version:    0.6.0
 */