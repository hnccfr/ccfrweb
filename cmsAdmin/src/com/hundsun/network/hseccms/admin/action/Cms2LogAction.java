/*    */ package com.hundsun.network.hseccms.admin.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.admin.enums.CmsLogTimeEnum;
/*    */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*    */ import com.hundsun.network.hseccms.model.Cms2Log;
/*    */ import com.hundsun.network.hseccms.query.Cms2LogQuery;
/*    */ import com.hundsun.network.hseccms.service.Cms2LogService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/log"})
/*    */ public class Cms2LogAction
/*    */ {
/* 32 */   private static Log _log = LogFactory.getLog(Cms2LogAction.class);
/*    */ 
/*    */   @Autowired
/*    */   private Cms2LogService logService;
/*    */ 
/* 42 */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LOG_LIST})
/*    */   @RequestMapping({"list"})
/*    */   public String logList(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("query") Cms2LogQuery query, Model model) { if (StringUtil.isNotEmpty(queryStr)) {
/* 43 */       query = (Cms2LogQuery)query.riseUp(queryStr);
/*    */     }
/* 45 */     model.addAttribute("query", this.logService.queryLog(query));
/* 46 */     model.addAttribute("timeMap", CmsLogTimeEnum.toMap());
/* 47 */     model.addAttribute("siteList", null);
/* 48 */     if (_log.isDebugEnabled()) {
/* 49 */       _log.debug("query info : query.isFirstPage()=" + query.isFirstPage() + " query.isLastPage()=" + query.isLastPage() + " curPageNum=" + query.getCurrentPage() + "  query.getNextPage()" + query.getNextPage());
/*    */     }
/*    */ 
/* 53 */     return "log/logList"; } 
/*    */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LOG_LIST})
/*    */   @RequestMapping(value={"/delSingle"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public String deleteSingleLog(@RequestParam String ids) {
/* 59 */     if (this.logService.deleteSingleLog(ids)) {
/* 60 */       return "redirect:list.htm";
/*    */     }
/* 62 */     return "error";
/*    */   }
/* 68 */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LOG_LIST})
/*    */   @RequestMapping(value={"/delBatch"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public String deleteBatchLog(@RequestParam(value="deletesiteId", required=false, defaultValue="-1") int deletesiteId, @RequestParam int days) { if (this.logService.deleteBatchLog(deletesiteId, days)) {
/* 69 */       return "redirect:list.htm";
/*    */     }
/* 71 */     return "error"; } 
/*    */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LOG_LIST})
/*    */   @RequestMapping(value={"/addLog"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void showAddLog(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Cms2Log log, Model model) {
/* 77 */     _log.debug("query string = " + queryStr);
/* 78 */     model.addAttribute("q", queryStr);
/* 79 */     _log.debug("get Log :" + log.getUserId());
/* 80 */     model.addAttribute("log", log);
/*    */   }
/*    */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LOG_LIST})
/*    */   @RequestMapping(value={"/addLog"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public String addLog(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Cms2Log log, Model model) {
/* 87 */     _log.debug("get Log : id=" + log.getId() + "   userID=" + log.getUserId());
/* 88 */     model.addAttribute("log", log);
/* 89 */     model.addAttribute("q", queryStr);
/* 90 */     return "forward:/log/list.htm";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.Cms2LogAction
 * JD-Core Version:    0.6.0
 */