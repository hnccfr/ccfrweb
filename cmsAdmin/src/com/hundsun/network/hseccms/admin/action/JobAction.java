/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*     */ import com.hundsun.network.hseccms.admin.util.ResponseUtils;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*     */ import com.hundsun.network.hseccms.model.Cms2Job;
/*     */ import com.hundsun.network.hseccms.query.Cms2JobQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/job"})
/*     */ public class JobAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobService cms2JobService;
/*     */ 
/*     */   @Value("${job.error.allMax}")
/*     */   private Long allMax;
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.JOB})
/*     */   @RequestMapping({"/list"})
/*     */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("query") Cms2JobQuery query, Model model)
/*     */   {
/*  53 */     if (StringUtil.isNotEmpty(queryStr)) {
/*  54 */       query = (Cms2JobQuery)query.riseUp(queryStr);
/*     */     }
/*  56 */     model.addAttribute("query", this.cms2JobService.queryCms2JobPage(query));
/*  57 */     model.addAttribute("EnumStaticOper", EnumStaticOper.toMap());
/*  58 */     model.addAttribute("EnumStaticType", EnumStaticType.toMap());
/*  59 */     model.addAttribute("maxError", this.allMax);
/*  60 */     model.addAttribute("q", query.lieDown());
/*  61 */     return "job/list";
/*     */   }
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.JOB})
/*     */   @RequestMapping({"/delete"})
/*     */   public String delete(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("query") Cms2JobQuery query, Long ids, Model model) {
/*  68 */     if (StringUtil.isNotEmpty(queryStr)) {
/*  69 */       query = (Cms2JobQuery)query.riseUp(queryStr);
/*     */     }
/*  71 */     this.cms2JobService.deleteById(ids);
/*  72 */     model.addAttribute("query", this.cms2JobService.queryCms2JobPage(query));
/*  73 */     model.addAttribute("EnumStaticOper", EnumStaticOper.toMap());
/*  74 */     model.addAttribute("EnumStaticType", EnumStaticType.toMap());
/*  75 */     model.addAttribute("maxError", this.allMax);
/*  76 */     model.addAttribute("q", query.lieDown());
/*  77 */     return "job/list";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.JOB})
/*     */   @RequestMapping({"/recoverErrors"})
/*     */   public void recoverErrors(Long id, HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/*     */     try
/*     */     {
/*  92 */       Cms2JobQuery cms2JobQuery = new Cms2JobQuery();
/*  93 */       cms2JobQuery.setId(id.toString());
/*  94 */       Cms2Job cms2Job = this.cms2JobService.queryCms2Job(cms2JobQuery);
/*  95 */       if (cms2Job != null) {
/*  96 */         cms2Job.setError(Long.valueOf(0L));
/*  97 */         this.cms2JobService.update(cms2Job);
/*  98 */         ResponseUtils.renderJson(response, "{'success':true}");
/*     */       } else {
/* 100 */         ResponseUtils.renderJson(response, "{'success':false,'msg':'该信息不存在或已删除'}");
/*     */       }
/*     */     } catch (Exception e) {
/* 103 */       this._log.error("recover error!", e);
/* 104 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.JOB})
/*     */   @RequestMapping({"/showErrorLog"})
/*     */   public String showErrorLog(Long id, HttpServletResponse response, ModelMap model)
/*     */   {
/* 115 */     Cms2JobQuery cms2JobQuery = new Cms2JobQuery();
/* 116 */     cms2JobQuery.setId(id.toString());
/* 117 */     Cms2Job cms2Job = this.cms2JobService.queryCms2Job(cms2JobQuery);
/* 118 */     if (cms2Job != null)
/* 119 */       model.addAttribute("errorLog", cms2Job.getLog());
/*     */     else {
/* 121 */       model.addAttribute("errorLog", "该信息不存在或已删除");
/*     */     }
/* 123 */     response.setHeader("Cache-Control", "no-cache");
/* 124 */     response.setContentType("text/json;charset=UTF-8");
/* 125 */     return "job/errorLog";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.JobAction
 * JD-Core Version:    0.6.0
 */