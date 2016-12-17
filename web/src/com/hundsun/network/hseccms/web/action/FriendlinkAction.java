/*    */ package com.hundsun.network.hseccms.web.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.model.Cms2Flink;
/*    */ import com.hundsun.network.hseccms.service.Cms2FlinkService;
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
/*    */ public class FriendlinkAction
/*    */ {
/* 29 */   private static Log log = LogFactory.getLog(FriendlinkAction.class);
/*    */ 
/*    */   @Autowired
/*    */   private Cms2FlinkService cms2FlinkService;
/*    */ 
/* 37 */   @RequestMapping(value={"/link_view_url"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void view_url(Long id, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws JSONException { if (id != null) {
/* 38 */       ResponseUtils.renderJson(response, "true");
/*    */       try {
/* 40 */         Cms2Flink link = this.cms2FlinkService.getById(id);
/* 41 */         if ((null != link) && (null != link.getUrl()) && (!link.getUrl().equals(""))) {
/* 42 */           link.setViewCount(Long.valueOf(link.getViewCount().longValue() + 1L));
/* 43 */           this.cms2FlinkService.update(link);
/* 44 */           String url = link.getUrl();
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
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.FriendlinkAction
 * JD-Core Version:    0.6.0
 */