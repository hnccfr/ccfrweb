/*    */ package com.hundsun.network.hseccms.web.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.model.Cms2ContCount;
/*    */ import com.hundsun.network.hseccms.service.Cms2ContCountService;
/*    */ import com.hundsun.network.hseccms.web.common.ResponseUtils;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.json.JSONArray;
/*    */ import org.json.JSONException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class ContentCountAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private Cms2ContCountService cms2ContCountService;
/*    */ 
/*    */   @RequestMapping(value={"/cont_view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void contView(Long contentId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*    */     throws JSONException
/*    */   {
/* 29 */     if (contentId == null) {
/* 30 */       ResponseUtils.renderJson(response, "[]");
/* 31 */       return;
/*    */     }
/* 33 */     this.cms2ContCountService.update(contentId);
/* 34 */     Cms2ContCount count = this.cms2ContCountService.selectByContId(contentId);
/*    */ 
/* 36 */     if ((count != null) && (count.getViews() != null)) {
/* 37 */       Long[] result = { count.getViews(), count.getComments(), count.getDownloads(), count.getUps(), count.getDowns() };
/* 38 */       String json = new JSONArray(result).toString();
/* 39 */       ResponseUtils.renderJson(response, json);
/*    */     } else {
/* 41 */       ResponseUtils.renderJson(response, "[]");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.ContentCountAction
 * JD-Core Version:    0.6.0
 */