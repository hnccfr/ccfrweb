/*    */ package com.hundsun.network.hseccms.admin.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*    */ import com.hundsun.network.hseccms.admin.util.ResponseUtils;
/*    */ import com.hundsun.network.hseccms.lucene.LuceneContentSvc;
/*    */ import com.hundsun.network.hseccms.model.Cms2Site;
/*    */ import com.hundsun.network.hseccms.service.Cms2ChannelService;
/*    */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*    */ import com.hundsun.network.melody.common.util.DateUtil;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.io.IOException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.lucene.index.CorruptIndexException;
/*    */ import org.apache.lucene.queryParser.ParseException;
/*    */ import org.apache.lucene.store.LockObtainFailedException;
/*    */ import org.json.JSONException;
/*    */ import org.json.JSONObject;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class LuceneContentAct
/*    */ {
/* 38 */   private static final Logger log = LoggerFactory.getLogger(LuceneContentAct.class);
/*    */ 
/*    */   @Autowired
/*    */   private LuceneContentSvc luceneContentSvc;
/*    */ 
/*    */   @Autowired
/*    */   private Cms2ChannelService cms2ChannelService;
/*    */ 
/*    */   @Autowired
/*    */   private Cms2SiteService siteService;
/*    */ 
/* 54 */   @RequestMapping({"/lucene/index"})
/*    */   public String index(HttpServletRequest request, ModelMap model) { long siteId = Cms2Utils.getCurrentSiteId(request).longValue();
/* 55 */     Cms2Site site = this.siteService.queryById(Long.valueOf(siteId));
/*    */ 
/* 59 */     List channelList = this.cms2ChannelService.getWholeTreeBySite(Long.valueOf(siteId));
/* 60 */     model.addAttribute("site", site);
/* 61 */     model.addAttribute("channelList", channelList);
/* 62 */     return "lucene/index"; }
/*    */ 
/*    */   @RequestMapping({"/lucene/create"})
/*    */   @ResponseBody
/*    */   public void create(Long channelId, String startDate, String endDate, Integer startId, Integer max, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*    */     throws JSONException
/*    */   {
/*    */     try
/*    */     {
/* 73 */       SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
/* 74 */       Date begin = new Date();
/* 75 */       log.debug("create index file begin = " + formatter.format(begin));
/* 76 */       Long lastId = Long.valueOf(this.luceneContentSvc.createIndex(Cms2Utils.getCurrentSiteId(request), channelId, DateUtil.convertStringToDate(startDate), DateUtil.convertStringToDate(endDate), startId, max));
/*    */ 
/* 78 */       JSONObject json = new JSONObject();
/* 79 */       json.put("success", true);
/* 80 */       if ((lastId != null) && (lastId.longValue() != -1L)) {
/* 81 */         json.put("lastId", lastId);
/*    */       }
/* 83 */       Date end = new Date();
/* 84 */       log.debug("create index file end = " + formatter.format(end));
/* 85 */       log.debug("create index file all times：" + (end.getTime() - begin.getTime()));
/* 86 */       ResponseUtils.renderJson(response, json.toString());
/*    */     } catch (CorruptIndexException e) {
/* 88 */       JSONObject json = new JSONObject();
/* 89 */       json.put("success", false).put("msg", e.getMessage());
/* 90 */       ResponseUtils.renderJson(response, json.toString());
/* 91 */       log.error("", e);
/*    */     } catch (LockObtainFailedException e) {
/* 93 */       JSONObject json = new JSONObject();
/* 94 */       json.put("success", false).put("msg", e.getMessage());
/* 95 */       ResponseUtils.renderJson(response, json.toString());
/* 96 */       log.error("", e);
/*    */     } catch (IOException e) {
/* 98 */       JSONObject json = new JSONObject();
/* 99 */       json.put("success", false).put("msg", e.getMessage());
/* 100 */       ResponseUtils.renderJson(response, json.toString());
/* 101 */       log.error("", e);
/*    */     } catch (ParseException e) {
/* 103 */       JSONObject json = new JSONObject();
/* 104 */       json.put("success", false).put("msg", e.getMessage());
/* 105 */       ResponseUtils.renderJson(response, json.toString());
/* 106 */       log.error("", e);
/*    */     } catch (Exception e) {
/* 108 */       JSONObject json = new JSONObject();
/* 109 */       if (StringUtil.isBlank(e.getMessage()))
/* 110 */         json.put("success", false).put("msg", e.toString());
/*    */       else {
/* 112 */         json.put("success", false).put("msg", e.getMessage());
/*    */       }
/* 114 */       ResponseUtils.renderJson(response, json.toString());
/* 115 */       log.error("", e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.LuceneContentAct
 * JD-Core Version:    0.6.0
 */