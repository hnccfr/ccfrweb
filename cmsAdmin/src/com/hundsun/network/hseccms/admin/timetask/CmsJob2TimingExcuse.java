/*    */ package com.hundsun.network.hseccms.admin.timetask;
/*    */ 
/*    */ import com.hundsun.network.hseccms.enums.EnumJobTimingObj;
/*    */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*    */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*    */ import com.hundsun.network.hseccms.model.Cms2Cont;
/*    */ import com.hundsun.network.hseccms.model.Cms2Job;
/*    */ import com.hundsun.network.hseccms.model.Cms2JobTiming;
/*    */ import com.hundsun.network.hseccms.service.Cms2ContService;
/*    */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*    */ import com.hundsun.network.hseccms.service.Cms2JobTimingService;
/*    */ import java.util.List;
/*    */ import org.quartz.JobExecutionContext;
/*    */ import org.quartz.JobExecutionException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.scheduling.quartz.QuartzJobBean;
/*    */ 
/*    */ public class CmsJob2TimingExcuse extends QuartzJobBean
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private Cms2JobTimingService cms2JobTimingService;
/*    */ 
/*    */   @Autowired
/*    */   private Cms2JobService cms2JobService;
/*    */ 
/*    */   @Autowired
/*    */   private Cms2ContService cms2ContService;
/*    */ 
/*    */   protected void executeInternal(JobExecutionContext arg0)
/*    */     throws JobExecutionException
/*    */   {
/* 48 */     List<Cms2JobTiming> adToStartList = this.cms2JobTimingService.queryCms2StartJobTiming();
/* 49 */     for (Cms2JobTiming bean : adToStartList) { 
/* 50 */       if (bean.getObjType().equals(EnumJobTimingObj.OBJ_TYPE_ADVERSITING.getType()))
/*    */       {
/* 52 */         Cms2Job cms2Job = new Cms2Job(bean.getSiteId(), EnumStaticType.ADV_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 53 */         this.cms2JobService.save(cms2Job);
/* 54 */       } else if (bean.getObjType().equals(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType())) {
/* 55 */         Cms2Cont cont = this.cms2ContService.queryAllByContentId(bean.getObjId().longValue());
/*    */ 
/* 57 */         if (null != cont)
/*    */         {
/* 59 */           Cms2Job cms2Job = new Cms2Job(bean.getSiteId(), EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 60 */           this.cms2JobService.save(cms2Job);
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/* 65 */       this.cms2JobTimingService.deleteById(bean.getId());
/*    */     }
/*    */ 
/* 68 */     List<Cms2JobTiming> adToEndList = this.cms2JobTimingService.queryCms2EndJobTiming();
/* 69 */     for (Cms2JobTiming bean : adToEndList) {
/* 70 */       if (bean.getObjType().equals(EnumJobTimingObj.OBJ_TYPE_ADVERSITING.getType()))
/*    */       {
/* 72 */         Cms2Job cms2Job = new Cms2Job(bean.getSiteId(), EnumStaticType.ADV_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 73 */         this.cms2JobService.save(cms2Job);
/* 74 */       } else if (bean.getObjType().equals(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType())) {
/* 75 */         Cms2Cont cont = this.cms2ContService.queryAllByContentId(bean.getObjId().longValue());
/*    */ 
/* 77 */         if (null != cont)
/*    */         {
/* 79 */           Cms2Job cms2Job = new Cms2Job(bean.getSiteId(), EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 80 */           this.cms2JobService.save(cms2Job);
/*    */         }
/*    */ 
/*    */       }
/*    */ 
/* 85 */       this.cms2JobTimingService.deleteById(bean.getId());
/*    */     }
/*    */   }
/*    */ 
/*    */   public void setCms2JobTimingService(Cms2JobTimingService cms2JobTimingService) {
/* 90 */     this.cms2JobTimingService = cms2JobTimingService;
/*    */   }
/*    */ 
/*    */   public void setCms2JobService(Cms2JobService cms2JobService) {
/* 94 */     this.cms2JobService = cms2JobService;
/*    */   }
/*    */ 
/*    */   public void setCms2ContService(Cms2ContService cms2ContService) {
/* 98 */     this.cms2ContService = cms2ContService;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.timetask.CmsJob2TimingExcuse
 * JD-Core Version:    0.6.0
 */