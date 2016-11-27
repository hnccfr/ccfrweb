/*    */ package com.hundsun.network.hseccms.web.service.impl;
/*    */ 
/*    */ import com.hundsun.network.hseccms.model.Cms2Template;
/*    */ import com.hundsun.network.hseccms.service.impl.Cms2TemplateServiceImpl;
/*    */ import com.hundsun.network.hseccms.web.service.TemplateService;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("templateService")
/*    */ public class TemplateServiceImpl extends Cms2TemplateServiceImpl
/*    */   implements TemplateService
/*    */ {
/* 23 */   private static Log logger = LogFactory.getLog(TemplateService.class);
/*    */ 
/*    */   public String getTemplateContentByName(String tplName, String siteId)
/*    */   {
/* 27 */     List templateList = getTplByName(tplName, siteId);
/* 28 */     if ((templateList != null) && (templateList.size() > 0)) {
/* 29 */       return ((Cms2Template)templateList.get(0)).getCont();
/*    */     }
/* 31 */     return "";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.service.impl.TemplateServiceImpl
 * JD-Core Version:    0.6.0
 */