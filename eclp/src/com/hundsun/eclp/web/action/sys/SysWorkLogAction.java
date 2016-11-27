/*    */ package com.hundsun.eclp.web.action.sys;
/*    */ 
/*    */ import com.hundsun.eclp.biz.query.WorkLogQuery;
/*    */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*    */ import com.hundsun.eclp.security.AdminAccess;
/*    */ import com.hundsun.eclp.util.StringUtil;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.WebDataBinder;
/*    */ import org.springframework.web.bind.annotation.InitBinder;
/*    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/system"})
/*    */ public class SysWorkLogAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   WorkLogService workLogService;
/*    */ 
/*    */   @InitBinder
/*    */   private void initBinder(WebDataBinder binder)
/*    */   {
/* 39 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 40 */     dateFormat.setLenient(false);
/* 41 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*    */   }
/*    */ 
/*    */   @RequestMapping({"/sys_worklog_list"})
/*    */   @AdminAccess({com.hundsun.eclp.enums.PermissionEnum.OPERATE_LOG})
/*    */   public String queryInit(@ModelAttribute("query") WorkLogQuery query, @RequestParam(value="page", required=false, defaultValue="1") int page, Model model, Cookyjar cookyjar) {
/* 49 */     query.setCurrentPage(Integer.valueOf(page));
/*    */ 
/* 51 */     StringUtil.trim(query);
/* 52 */     query = this.workLogService.selectWorkLogByPage(query);
/* 53 */     return "/system/sys_worklog_list";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.sys.SysWorkLogAction
 * JD-Core Version:    0.6.0
 */