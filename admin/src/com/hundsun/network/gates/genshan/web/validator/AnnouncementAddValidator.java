/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.operation.Announcement;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementType;
/*    */ import org.springframework.util.Assert;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class AnnouncementAddValidator extends ValangValidator
/*    */ {
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 14 */     Assert.notNull(obj);
/* 15 */     Assert.isInstanceOf(Announcement.class, obj);
/* 16 */     super.validate(obj, err);
/*    */ 
/* 18 */     Announcement announcement = (Announcement)obj;
/*    */ 
/* 21 */     Long projectId = announcement.getProjectId();
/* 22 */     if ((EnumAnnouncementType.PROJECT.getValue().equals(announcement.getType())) && (projectId == null))
/*    */     {
/* 24 */       err.rejectValue("projectId", null, null, "项目公告的关联项目不能为空");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.AnnouncementAddValidator
 * JD-Core Version:    0.6.0
 */