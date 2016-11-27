/*     */ package com.hundsun.network.gates.fengshan.web.action.operation;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.operation.Announcement;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.AnnouncementQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.operation.AnnouncementService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementType;
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.codehaus.jackson.map.ObjectMapper;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class AnnouncementManageAction extends BaseAction
/*     */ {
/*  30 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private AnnouncementService announcementService;
/*     */ 
/*     */   @RequestMapping({"/home/announcement/list"})
/*     */   public String list(ModelMap model, @ModelAttribute("page") AnnouncementQuery<Announcement> page)
/*     */     throws Exception
/*     */   {
/*  42 */     if (null == page) {
/*  43 */       page = new AnnouncementQuery();
/*     */     }
/*  45 */     page.trim();
/*  46 */     this.announcementService.paginate(page);
/*  47 */     model.put("page", page);
/*  48 */     model.put("announcementTypeList", EnumAnnouncementType.values());
/*  49 */     return "/home/announcement/list";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/home/announcement/annList"})
/*     */   public String annList(ModelMap model, @RequestParam("projectId") Long projectId)
/*     */     throws Exception
/*     */   {
/*  59 */     AnnouncementQuery page = new AnnouncementQuery();
/*  60 */     page.setProjectId(projectId);
/*  61 */     return list(model, page);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/home/announcement/info"})
/*     */   public String info(ModelMap model, @RequestParam("id") Long id)
/*     */     throws Exception
/*     */   {
/*  71 */     model.put("announcement", this.announcementService.queryAnnouncementInfo(id));
/*  72 */     return "/home/announcement/info";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/cms/announcement"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String cmsAnnouncementList(ModelMap model)
/*     */     throws Exception
/*     */   {
/*  82 */     Integer count = Integer.valueOf(7);
/*  83 */     AnnouncementQuery page = new AnnouncementQuery();
/*  84 */     page.setPageSize(count.intValue());
/*  85 */     this.announcementService.paginate(page);
/*  86 */     model.put("announcementList", page.getData());
/*  87 */     return "/home/cms/announcement";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/home/announcement/auctionAnnouncement"})
/*     */   public String aucAnnouncement(@RequestParam("projectId") Long projectId, ModelMap model)
/*     */   {
/*  97 */     AnnouncementQuery page = new AnnouncementQuery();
/*  98 */     ObjectMapper mapper = new ObjectMapper();
/*  99 */     String announcementsJson = "";
/*     */     List announcements;
/*     */    // List announcements;
/* 101 */     if (null == projectId) {
/* 102 */       announcements = page.getData();
/*     */     } else {
/* 104 */       page.setProjectId(projectId);
/* 105 */       page.setPageSize(3);
/* 106 */       this.announcementService.paginate(page);
/* 107 */       announcements = page.getData();
/*     */     }
/*     */     try {
/* 110 */       announcementsJson = mapper.writeValueAsString(announcements);
/*     */     } catch (IOException e) {
/* 112 */       e.printStackTrace();
/* 113 */       if (this.log.isErrorEnabled()) {
/* 114 */         this.log.error("", e);
/*     */       }
/*     */     }
/* 117 */     model.put("announcementsJson", announcementsJson);
/* 118 */     model.put("projectId", projectId);
/* 119 */     return "/home/announcement/auctionAnnouncement";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/home/announcement/refreshAnnouncement"})
/*     */   @ResponseBody
/*     */   public List<Announcement> auctionAnnouncementAjax(@RequestParam("projectId") Long projectId, @RequestParam("maxMillisecond") Long maxMillisecond)
/*     */   {
/* 129 */     AnnouncementQuery page = new AnnouncementQuery();
/*     */     List announcements;
/*     */    // List announcements;
/* 131 */     if (null == projectId) {
/* 132 */       announcements = page.getData();
/*     */     } else {
/* 134 */       page.setGmtModify(new Date(maxMillisecond.longValue()));
/* 135 */       page.setProjectId(projectId);
/* 136 */       page.setPageSize(3);
/* 137 */       this.announcementService.paginate(page);
/* 138 */       announcements = page.getData();
/*     */     }
/* 140 */     return announcements;
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/home/announcement/auctionAnnouncement/more"})
/*     */   public String aucAnnouncementMore(@RequestParam("projectId") Long projectId, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 149 */     AnnouncementQuery page = new AnnouncementQuery();
/* 150 */     if (null != projectId) {
/* 151 */       page.setProjectId(projectId);
/*     */     }
/* 153 */     return list(model, page);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.operation.AnnouncementManageAction
 * JD-Core Version:    0.6.0
 */