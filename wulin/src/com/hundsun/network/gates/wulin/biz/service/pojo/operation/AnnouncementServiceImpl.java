/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.operation;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionMessageCode;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.service.RemoteAuctionPushletService;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionMessageServiceRequest;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.operation.AnnouncementDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.AnnouncementQuery;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.operation.AnnouncementService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.codehaus.jackson.map.ObjectMapper;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("announcementService")
/*     */ public class AnnouncementServiceImpl extends BaseService
/*     */   implements AnnouncementService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AnnouncementDAO announcementDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteAuctionPushletService remoteAuctionPushletService;
/*  37 */   private ExecutorService pool = Executors.newSingleThreadExecutor();
/*  38 */   private ObjectMapper mapper = new ObjectMapper();
/*     */ 
/*     */   public void paginated(AnnouncementQuery<Announcement> page)
/*     */   {
/*  46 */     this.announcementDAO.paginated(page);
/*     */   }
/*     */ 
/*     */   public List<Announcement> queryAnnouncementList(AnnouncementQuery<Announcement> query)
/*     */   {
/*  55 */     return this.announcementDAO.queryAnnouncementList(query);
/*     */   }
/*     */ 
/*     */   public Announcement queryAnnouncementInfo(Long announcementId)
/*     */   {
/*  64 */     return this.announcementDAO.selectByPrimaryKey(announcementId);
/*     */   }
/*     */ 
/*     */   public Long insert(Announcement announcement)
/*     */   {
/*  73 */     return this.announcementDAO.insert(announcement);
/*     */   }
/*     */ 
/*     */   public int removeAnnouncement(Announcement announcement)
/*     */   {
/*  81 */     Announcement annData = new Announcement();
/*  82 */     annData.setId(announcement.getId());
/*  83 */     annData.setStatus(EnumAnnouncementStatus.DEL.getValue());
/*  84 */     annData.setOperator(announcement.getOperator());
/*  85 */     annData.setOperatorType(announcement.getOperatorType());
/*  86 */     int sum = this.announcementDAO.updateByPrimaryKeySelective(annData);
/*  87 */     pushAnnouncement(announcement);
/*  88 */     return sum;
/*     */   }
/*     */ 
/*     */   public int joinProject(Announcement announcement)
/*     */   {
/*  98 */     Announcement annData = new Announcement();
/*  99 */     annData.setId(announcement.getId());
/* 100 */     annData.setProjectId(announcement.getProjectId());
/* 101 */     annData.setOperator(announcement.getOperator());
/* 102 */     annData.setOperatorType(announcement.getOperatorType());
/* 103 */     return this.announcementDAO.updateByPrimaryKeySelective(annData);
/*     */   }
/*     */ 
/*     */   public int leaveProject(Announcement announcement)
/*     */   {
/* 113 */     Announcement annData = new Announcement();
/* 114 */     annData.setId(announcement.getId());
/* 115 */     annData.setOperator(announcement.getOperator());
/* 116 */     annData.setOperatorType(announcement.getOperatorType());
/* 117 */     return this.announcementDAO.leaveProjectByPrimaryKey(annData);
/*     */   }
/*     */ 
/*     */   public Announcement queryNewestAnnouncement()
/*     */   {
/* 126 */     return this.announcementDAO.selectNewestAnnouncement();
/*     */   }
/*     */ 
/*     */   public int normal(Announcement announcement)
/*     */   {
/* 135 */     Announcement annData = new Announcement();
/* 136 */     annData.setId(announcement.getId());
/* 137 */     annData.setStatus(EnumAnnouncementStatus.NORMAL.getValue());
/* 138 */     annData.setOperator(announcement.getOperator());
/* 139 */     annData.setOperatorType(announcement.getOperatorType());
/* 140 */     int sum = this.announcementDAO.updateByPrimaryKeySelective(annData);
/* 141 */     pushAnnouncement(announcement);
/* 142 */     return sum;
/*     */   }
/*     */ 
/*     */   public void updateById(Announcement announcement)
/*     */   {
/* 151 */     if ((announcement.getProjectId() == null) || (announcement.getProjectId().longValue() == 0L))
/* 152 */       leaveProject(announcement);
/* 153 */     this.announcementDAO.updateByPrimaryKeySelective(announcement);
/* 154 */     pushAnnouncement(announcement);
/*     */   }
/*     */ 
/*     */   public Long insertNormal(Announcement announcement)
/*     */   {
/* 165 */     if (null == announcement) {
/* 166 */       return null;
/*     */     }
/* 168 */     announcement.setStatus(EnumAnnouncementStatus.NORMAL.getValue());
/* 169 */     Long id = insert(announcement);
/* 170 */     pushAnnouncement(announcement);
/* 171 */     return id;
/*     */   }
/*     */ 
/*     */   private void pushAnnouncement(final Announcement announcement)
/*     */   {
/*     */     try
/*     */     {
/* 182 */       if ((null == announcement) || (null == announcement.getProjectId())) {
/* 183 */         return;
/*     */       }
/* 185 */       final ProjectListing projectListing = this.projectListingDAO.getProSimpInfo(announcement.getProjectId());
/*     */ 
/* 187 */       if ((null == projectListing) || (StringUtil.isEmpty(projectListing.getCode()))) {
/* 188 */         return;
/*     */       }
/* 190 */       this.pool.execute(new Thread()
/*     */       {
/*     */         public void run() {
/* 193 */           AuctionMessageServiceRequest messageRequest = new AuctionMessageServiceRequest();
/* 194 */           messageRequest.setMessageCode(EnumAuctionMessageCode.Announcement.getValue());
/* 195 */           messageRequest.setProjectCode(projectListing.getCode());
/* 196 */           messageRequest.setShowIt(EnumActiveStatus.No.getValue());
/*     */           try {
/* 198 */             messageRequest.setMessage(AnnouncementServiceImpl.this.mapper.writeValueAsString(announcement));
/* 199 */             AnnouncementServiceImpl.this.remoteAuctionPushletService.sendAuctionMessage(messageRequest);
/*     */           } catch (Exception e) {
/* 201 */             if (AnnouncementServiceImpl.this.log.isErrorEnabled())
/* 202 */               AnnouncementServiceImpl.this.log.error("remote pushAnnouncement error", e);
/*     */           }
/*     */         } } );
/*     */     } catch (Exception e) {
/* 207 */       this.log.error("", e);
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.operation.AnnouncementServiceImpl
 * JD-Core Version:    0.6.0
 */