/*     */ package com.hundsun.network.hseccms.admin.timetask;
/*     */ 
/*     */ import com.hundsun.network.hseccms.enums.EnumContStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumSiteStaticRange;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*     */ import com.hundsun.network.hseccms.lucene.LuceneContentSvc;
/*     */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*     */ import com.hundsun.network.hseccms.model.Cms2ContAll;
/*     */ import com.hundsun.network.hseccms.model.Cms2ContExt;
/*     */ import com.hundsun.network.hseccms.model.Cms2Job;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.query.Cms2JobQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelAttrService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelExtService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelGroupService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelUserService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ContService;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.hseccms.staticpage.StaticPageSvc;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.TimerTask;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ public class Cms2JobExcuse extends TimerTask
/*     */ {
/*  71 */   protected final Log _log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private TransactionTemplate transactionTemplate;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobService cms2JobService;
/*     */ 
/*     */   @Autowired
/*     */   private StaticPageSvc staticPageSvc;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ContService cms2ContService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelService cms2ChannelService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelExtService cms2ChannelExtService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelGroupService cms2ChannelGroupService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelAttrService cms2ChannelAttrService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelUserService cms2ChannelUserService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Autowired
/*     */   private LuceneContentSvc luceneContentSvc;
/*     */ 
/*     */   @Value("${job.error.everMax}")
/*     */   private int everMax;
/*     */ 
/*     */   @Value("${job.error.allMax}")
/*     */   private Long allMax;
/*     */ 
/* 107 */   public void setLuceneContentSvc(LuceneContentSvc luceneContentSvc) { this.luceneContentSvc = luceneContentSvc;
/*     */   }
/*     */ 
/*     */   public void run()
/*     */   {
/*     */     while (true)
/*     */       try
/*     */       {
/* 131 */         if (!runFirstJob().booleanValue())
/*     */         {
/*     */           break;
/*     */         }
/*     */ 
/* 136 */         continue;
/*     */       }
/*     */       catch (Exception e)
/*     */       {
/* 135 */         this._log.error(e.getMessage());
/*     */       }
/*     */   }
/*     */ 
/*     */   private Boolean runFirstJob()
/*     */   {
/* 143 */     return (Boolean)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public Boolean doInTransaction(TransactionStatus status) {
/*     */         try {
/* 146 */           Cms2Job cms2Job = null;
/*     */ 
/* 148 */           Cms2JobExcuse.this._log.error("in runJob!!!" + new Date());
/*     */           try {
/* 150 */             cms2Job = Cms2JobExcuse.this.cms2JobService.selectFirstItem(Cms2JobExcuse.this.allMax);
/* 151 */             if (cms2Job == null) {
/* 152 */               return Boolean.valueOf(false);
/*     */             }
/* 154 */             Cms2JobExcuse.this._log.info("in runJob!!!   cms2Job.getObjType = " + cms2Job.getObjType() + "     cms2Job.getOper() = " + cms2Job.getOper() + "     cms2Job.getObjId() = " + cms2Job.getObjId());
/*     */ 
/* 157 */             switch (Integer.parseInt(cms2Job.getObjType().toString())) {
/*     */             case 1:
/* 159 */               Cms2JobExcuse.this.contentLucene(cms2Job.getSiteId(), cms2Job.getObjId(), cms2Job.getOper());
/* 160 */               Cms2JobExcuse.this.contentStatic(cms2Job.getSiteId(), cms2Job.getObjId(), cms2Job.getOper());
/* 161 */               break;
/*     */             case 2:
/* 163 */               Cms2JobExcuse.this.channelStatic(cms2Job.getSiteId(), cms2Job.getObjId(), cms2Job.getOper());
/* 164 */               break;
/*     */             case 3:
/* 167 */               break;
/*     */             case 4:
/* 169 */               Cms2JobExcuse.this.frindListStatic(cms2Job.getSiteId(), cms2Job.getObjId(), cms2Job.getOper());
/* 170 */               break;
/*     */             case 5:
/* 172 */               Cms2JobExcuse.this.advertisingSpaceStatic(cms2Job.getSiteId(), cms2Job.getObjId(), cms2Job.getOper());
/* 173 */               break;
/*     */             case 6:
/* 176 */               break;
/*     */             }
/*     */ 
/* 184 */             Cms2JobQuery cms2JobQuery = new Cms2JobQuery();
/* 185 */             cms2JobQuery.setId(cms2Job.getId().toString());
/* 186 */             Cms2JobExcuse.this.cms2JobService.delete(cms2JobQuery);
/*     */           } catch (Exception e) {
/* 188 */             Cms2JobExcuse.this._log.error("in runJob!!!", e);
/* 189 */             if (cms2Job != null) {
/* 190 */               Cms2JobExcuse.this._log.error("in runJob!!!ERROR   cms2Job.getObjType = " + cms2Job.getObjType() + "     cms2Job.getOper() = " + cms2Job.getOper() + "     cms2Job.getObjId() = " + cms2Job.getObjId());
/*     */ 
/* 193 */               cms2Job.setError(Long.valueOf(cms2Job.getError().longValue() + 1L));
/* 194 */               cms2Job.setLog(e.toString());
/* 195 */               cms2Job.setDealTime(new Date());
/* 196 */               Cms2JobExcuse.this.cms2JobService.update(cms2Job);
/* 197 */               if ((cms2Job.getError().longValue() % Cms2JobExcuse.this.everMax == 0L) && (cms2Job.getError().longValue() != 0L))
/* 198 */                 return Boolean.valueOf(false);
/*     */             }
/*     */             else {
/* 201 */               return Boolean.valueOf(false);
/*     */             }
/*     */           }
/* 203 */           return Boolean.valueOf(true);
/*     */ 
/* 205 */          // return Boolean.valueOf(true);
/*     */         } catch (Exception e) {
/* 207 */           status.setRollbackOnly();
/* 208 */           Cms2JobExcuse.this._log.error("in runJob after!!!", e);
/*     */         }
/* 210 */         return Boolean.valueOf(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private void advertisingSpaceStatic(Long siteId, Long objId, Integer oper)
/*     */     throws Exception
/*     */   {
/* 221 */     this.staticPageSvc.advertisingSpace(siteId);
/*     */   }
/*     */ 
/*     */   private void frindListStatic(Long siteId, Long objId, Integer oper) throws Exception
/*     */   {
/* 226 */     this.staticPageSvc.Frindlink(siteId);
/*     */   }
/*     */ 
/*     */   private void channelStatic(Long siteId, Long objId, Integer oper)
/*     */     throws Exception
/*     */   {
/* 235 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*     */ 
/* 238 */     if (EnumSiteStaticRange.ACTIVE.getValue().equals(site.getStaticRange().toString())) {
/* 239 */       return;
/*     */     }
/*     */ 
/* 242 */     if ((EnumStaticOper.ADD_STATIC.getType().equals(oper)) || (EnumStaticOper.MODIFY_STATIC.getType().equals(oper)))
/*     */     {
/* 244 */       this.staticPageSvc.menu(siteId);
/*     */ 
/* 246 */       List<Cms2Channel> channelList = this.cms2ChannelService.channelALLForListBySite(siteId);
/*     */ 
/* 248 */       for (Cms2Channel channelforRelate : channelList)
/*     */       {
/* 250 */         this.staticPageSvc.relatePage(siteId, channelforRelate);
/*     */       }
/*     */ 
/* 255 */       Cms2Channel channel = this.cms2ChannelService.channelALLForObjectById(objId, Long.valueOf(1L));
/* 256 */       this.staticPageSvc.channel(siteId, channel);
/* 257 */       while (null != channel.getParentId()) {
/* 258 */         channel = this.cms2ChannelService.channelALLForObjectById(channel.getParentId(), Long.valueOf(1L));
/* 259 */         this.staticPageSvc.channel(siteId, channel);
/*     */       }
/*     */ 
/* 262 */       this.staticPageSvc.Homepage(siteId);
/*     */     }
/*     */ 
/* 265 */     if (EnumStaticOper.DELETE_STATIC.getType().equals(oper)) {
/* 266 */       Cms2Channel channel = this.cms2ChannelService.channelALLForObjectById(objId, null);
/*     */ 
/* 269 */       this.staticPageSvc.channelDelete(siteId, channel);
/*     */ 
/* 272 */       this.cms2ChannelService.deleteById(objId);
/* 273 */       this.cms2ChannelExtService.deleteByChannelId(objId);
/* 274 */       this.cms2ChannelGroupService.deleteByChannelId(objId);
/* 275 */       this.cms2ChannelAttrService.deleteByChannelId(objId);
/* 276 */       this.cms2ChannelUserService.deleteByChannelId(objId);
/*     */ 
/* 278 */       List<Cms2Channel> channelList = this.cms2ChannelService.channelALLForListBySite(siteId);
/*     */ 
/* 280 */       for (Cms2Channel channelforRelate : channelList)
/*     */       {
/* 282 */         this.staticPageSvc.relatePage(siteId, channelforRelate);
/*     */       }
/*     */ 
/* 285 */       this.staticPageSvc.menu(siteId);
/*     */ 
/* 288 */       while (null != channel.getParentId()) {
/* 289 */         channel = this.cms2ChannelService.channelALLForObjectById(channel.getParentId(), Long.valueOf(1L));
/* 290 */         this.staticPageSvc.channel(siteId, channel);
/*     */       }
/*     */ 
/* 294 */       this.staticPageSvc.Homepage(siteId);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void contentStatic(Long siteId, Long objId, Integer oper)
/*     */     throws Exception
/*     */   {
/* 310 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*     */ 
/* 313 */     if (EnumSiteStaticRange.ACTIVE.getValue().equals(site.getStaticRange().toString())) {
/* 314 */       return;
/*     */     }
/*     */ 
/* 317 */     Cms2ContAll content = this.cms2ContService.selectAllById(objId);
/* 318 */     if ((content != null) || (
/* 324 */       (EnumStaticOper.ADD_STATIC.getType().equals(oper)) || (EnumStaticOper.MODIFY_STATIC.getType().equals(oper)) || (EnumStaticOper.CANSER_RELESAE.getType().equals(oper)) || (EnumStaticOper.CYCLE_STATIC.getType().equals(oper)))) {
/* 325 */       if ((EnumContStatus.FINISH.getCode().equals(content.getStatus())) && (new Date().after(content.getContExt().getReleaseDate()))) {
/* 326 */         List<Cms2Channel> channelList = this.cms2ChannelService.channelALLForListBySite(siteId);
/*     */ 
/* 328 */         for (Cms2Channel channelforRelate : channelList)
/*     */         {
/* 330 */           this.staticPageSvc.relatePage(siteId, channelforRelate);
/*     */         }
/*     */ 
/* 334 */         this.staticPageSvc.Homepage(siteId);
/*     */ 
/* 337 */         this.staticPageSvc.content(siteId, content);
/*     */ 
/* 340 */         Cms2Channel Mainchannel = this.cms2ChannelService.channelALLForObjectById(content.getChannelId(), null);
/* 341 */         this.staticPageSvc.channel(siteId, Mainchannel);
/*     */ 
/* 344 */         while (null != Mainchannel.getParentId()) {
/* 345 */           Mainchannel = this.cms2ChannelService.channelALLForObjectById(Mainchannel.getParentId(), Long.valueOf(1L));
/* 346 */           this.staticPageSvc.channel(siteId, Mainchannel);
/*     */         }
/*     */ 
/*     */       }
/* 351 */       else if (this.staticPageSvc.contentDelete(siteId, content) != 0)
/*     */       {
/* 353 */         List<Cms2Channel> channelList = this.cms2ChannelService.channelALLForListBySite(siteId);
/*     */ 
/* 355 */         for (Cms2Channel channelforRelate : channelList)
/*     */         {
/* 357 */           this.staticPageSvc.relatePage(siteId, channelforRelate);
/*     */         }
/*     */ 
/* 362 */         Cms2Channel Mainchannel = this.cms2ChannelService.channelALLForObjectById(content.getChannelId(), null);
/* 363 */         this.staticPageSvc.channel(siteId, Mainchannel);
/*     */ 
/* 366 */         while (null != Mainchannel.getParentId()) {
/* 367 */           Mainchannel = this.cms2ChannelService.channelALLForObjectById(Mainchannel.getParentId(), Long.valueOf(1L));
/* 368 */           this.staticPageSvc.channel(siteId, Mainchannel);
/*     */         }
/*     */ 
/* 373 */         this.staticPageSvc.Homepage(siteId);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 381 */     if (EnumStaticOper.DELETE_STATIC.getType().equals(oper))
/*     */     {
/* 383 */       List<Cms2Channel> channelList = this.cms2ChannelService.channelALLForListBySite(siteId);
/*     */ 
/* 385 */       for (Cms2Channel channelforRelate : channelList)
/*     */       {
/* 387 */         this.staticPageSvc.relatePage(siteId, channelforRelate);
/*     */       }
/*     */ 
/* 391 */       this.staticPageSvc.contentDelete(siteId, content);
/*     */ 
/* 394 */       Cms2Channel Mainchannel = this.cms2ChannelService.channelALLForObjectById(content.getChannelId(), null);
/* 395 */       this.staticPageSvc.channel(siteId, Mainchannel);
/*     */ 
/* 398 */       while (null != Mainchannel.getParentId()) {
/* 399 */         Mainchannel = this.cms2ChannelService.channelALLForObjectById(Mainchannel.getParentId(), Long.valueOf(1L));
/* 400 */         this.staticPageSvc.channel(siteId, Mainchannel);
/*     */       }
/*     */ 
/* 406 */       this.staticPageSvc.Homepage(siteId);
/*     */ 
/* 409 */       this.cms2ContService.deleteByIdReal(content.getId().toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   private void contentLucene(Long siteId, Long objId, Integer oper)
/*     */     throws Exception
/*     */   {
/* 425 */     Cms2ContAll content = this.cms2ContService.queryAllByContentId(objId.longValue());
/* 426 */     if ((content != null) || (
/* 432 */       (EnumStaticOper.ADD_STATIC.getType().equals(oper)) || (EnumStaticOper.MODIFY_STATIC.getType().equals(oper)) || (EnumStaticOper.CANSER_RELESAE.getType().equals(oper)) || (EnumStaticOper.CYCLE_STATIC.getType().equals(oper)))) {
/* 433 */       if ((EnumContStatus.FINISH.getCode().equals(content.getStatus())) && (new Date().after(content.getContExt().getReleaseDate())))
/* 434 */         this.luceneContentSvc.createIndex(content);
/*     */       else {
/* 436 */         this.luceneContentSvc.deleteIndex(objId.longValue());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 441 */     if (EnumStaticOper.DELETE_STATIC.getType().equals(oper))
/* 442 */       this.luceneContentSvc.deleteIndex(objId.longValue());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.timetask.Cms2JobExcuse
 * JD-Core Version:    0.6.0
 */