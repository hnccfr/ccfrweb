/*    */ package com.hundsun.network.hseccms.web.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.model.Cms2Adv;
/*    */ import com.hundsun.network.hseccms.service.Cms2AdvService;
/*    */ import com.hundsun.network.hseccms.web.common.ResponseUtils;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.json.JSONException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class AdvAction
/*    */ {
/* 29 */   private static Log log = LogFactory.getLog(AdvAction.class);
/*    */ 
/*    */   @Autowired
/*    */   private Cms2AdvService cms2AdvService;
/*    */ 
/* 37 */   @RequestMapping(value={"/adv_view_url"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void click_url(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws JSONException { if (id != null) {
/* 38 */       ResponseUtils.renderJson(response, "true");
/*    */       try {
/* 40 */         Cms2Adv adv = this.cms2AdvService.getById(id);
/* 41 */         if ((null != adv) && (null != adv.getLink()) && (!adv.getLink().equals(""))) {
/* 42 */           adv.setClickCount(Long.valueOf(adv.getClickCount().longValue() + 1L));
/* 43 */           this.cms2AdvService.update(adv);
/* 44 */           String url = adv.getLink();
/* 45 */           if (!url.startsWith("http://")) {
/* 46 */             url = "http://" + url;
/*    */           }
/* 48 */           response.sendRedirect(url);
/*    */         } else {
/* 50 */           ResponseUtils.renderJson(response, "false");
/*    */         }
/*    */       } catch (IOException e) {
/* 53 */         log.error(e.getMessage());
/*    */       }
/*    */     } else {
/* 56 */       ResponseUtils.renderJson(response, "false");
/*    */     } }
/*    */ 
/*    */   @RequestMapping(value={"/adv_view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void view(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*    */     throws JSONException
/*    */   {
/* 64 */     if (id == null) {
/* 65 */       ResponseUtils.renderJson(response, "[]");
/* 66 */       return;
/*    */     }
/* 68 */     Cms2Adv adv = this.cms2AdvService.getById(id);
/* 69 */     if (null != adv) {
/* 70 */       adv.setDisplayCount(Long.valueOf(adv.getDisplayCount().longValue() + 1L));
/* 71 */       this.cms2AdvService.update(adv);
/* 72 */       ResponseUtils.renderJson(response, "[]");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.AdvAction
 * JD-Core Version:    0.6.0
 */