/*    */ package com.hundsun.network.hseccms.admin.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*    */ import com.hundsun.network.hseccms.enums.EnumJobTimingObj;
/*    */ import com.hundsun.network.hseccms.enums.EnumJobTimingType;
/*    */ import com.hundsun.network.hseccms.query.Cms2JobTimingQuery;
/*    */ import com.hundsun.network.hseccms.service.Cms2JobTimingService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/jobtiming"})
/*    */ public class JobTimingAction extends BaseAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private Cms2JobTimingService cms2JobTimingService;
/*    */ 
/*    */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.JOBTIMING})
/*    */   @RequestMapping({"/list"})
/*    */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("query") Cms2JobTimingQuery query, Model model)
/*    */   {
/* 44 */     if (StringUtil.isNotEmpty(queryStr)) {
/* 45 */       query = (Cms2JobTimingQuery)query.riseUp(queryStr);
/*    */     }
/* 47 */     model.addAttribute("query", this.cms2JobTimingService.queryCms2JobTimingPage(query));
/* 48 */     model.addAttribute("EnumJobTimingObj", EnumJobTimingObj.toMap());
/* 49 */     model.addAttribute("EnumJobTimingType", EnumJobTimingType.toMap());
/* 50 */     model.addAttribute("q", query.lieDown());
/* 51 */     return "jobtiming/list";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.JobTimingAction
 * JD-Core Version:    0.6.0
 */