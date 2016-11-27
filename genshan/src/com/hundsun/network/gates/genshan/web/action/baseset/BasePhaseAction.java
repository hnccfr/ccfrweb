/*     */ package com.hundsun.network.gates.genshan.web.action.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.BasePhase;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.BasePhaseQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.BaseDayService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.BasePhaseService;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.validator.BasePhaseValidator;
/*     */ import com.hundsun.network.gates.luosi.common.enums.BasePhaseNextStateEnum;
/*     */ import com.hundsun.network.gates.luosi.common.enums.BasePhaseStateEnum;
/*     */ import com.hundsun.network.gates.luosi.common.remote.AjaxResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.BaseDayServiceResult;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class BasePhaseAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   BasePhaseValidator basePhaseValidator;
/*     */ 
/*     */   @Autowired
/*     */   private BasePhaseService basePhaseService;
/*     */ 
/*     */   @Autowired
/*     */   private BaseDayService baseDayService;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_R_BASEPHASE_LIST})
/*     */   @RequestMapping({"baseset/basephase/list"})
/*     */   public String list(@ModelAttribute("page") BasePhaseQuery<BasePhase> query, ModelMap model)
/*     */   {
/*  41 */     BaseDayServiceResult result = this.baseDayService.getTradeDay();
/*  42 */     if (!result.correct()) {
/*  43 */       model.addAttribute("message", getMessage("admin.base.basephase.error.currentbasday.null", new String[0]));
/*     */ 
/*  45 */       return "error";
/*     */     }
/*  47 */     query.setTradeDay(result.getCurrentTradeDay());
/*  48 */     this.basePhaseService.queryPhase(query);
/*  49 */     model.addAttribute("query", query);
/*  50 */     return "/baseset/basephase/list";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_R_BASEPHASE_NEXT})
/*     */   @RequestMapping({"baseset/basephase/next"})
/*     */   public String listNext(@ModelAttribute("page") BasePhaseQuery<BasePhase> query, ModelMap model)
/*     */   {
/*  59 */     BaseDayServiceResult result = this.baseDayService.getTradeDay();
/*  60 */     if (!result.correct())
/*     */     {
/*  62 */       model.addAttribute("message", result.getErrorInfo());
/*  63 */       return "error";
/*     */     }
/*  65 */     query.setTradeDay(result.getCurrentTradeDay());
/*  66 */     this.basePhaseService.queryPhaseNext(query);
/*  67 */     model.addAttribute("query", query);
/*  68 */     return "/baseset/basephase/next";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_C_BASEPHASE_ADD})
/*     */   @RequestMapping(value={"baseset/basephase/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String add(@ModelAttribute("basePhase") BasePhase basePhase)
/*     */   {
/*  78 */     basePhase.setEndHourNext(BasePhaseNextStateEnum.NO.getValue());
/*  79 */     return "/baseset/basephase/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_C_BASEPHASE_ADD})
/*     */   @RequestMapping(value={"baseset/basephase/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String add(@ModelAttribute("basePhase") BasePhase basePhase, BindingResult result, ModelMap model)
/*     */   {
/*  91 */     this.basePhaseValidator.validate(basePhase, result);
/*  92 */     if (result.hasErrors()) {
/*  93 */       return "/baseset/basephase/add";
/*     */     }
/*  95 */     BaseDayServiceResult baseDayServiceResult = this.baseDayService.getTradeDay();
/*  96 */     if (!baseDayServiceResult.correct()) {
/*  97 */       model.addAttribute("url", "/baseset/basephase/add");
/*     */ 
/*  99 */       model.addAttribute("message", baseDayServiceResult.getErrorInfo());
/* 100 */       return "error";
/*     */     }
/* 102 */     basePhase.setGmtValid(baseDayServiceResult.getNextTradeDay());
/* 103 */     basePhase.setState(BasePhaseStateEnum.ENABLE.getValue());
/* 104 */     this.basePhaseService.addBasePhase(basePhase);
/* 105 */     model.addAttribute("url", "/baseset/basephase/next");
/* 106 */     return success(model, "basephase.save.success", new String[0]);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_C_BASEPHASE_MODIFY})
/*     */   @RequestMapping(value={"baseset/basephase/modify"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String modify(@RequestParam("id") Long id, ModelMap model)
/*     */   {
/* 116 */     BasePhase basePhase = this.basePhaseService.getBasePhaseById(id);
/* 117 */     model.addAttribute("basePhase", basePhase);
/* 118 */     return "/baseset/basephase/modify";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_C_BASEPHASE_MODIFY})
/*     */   @RequestMapping(value={"baseset/basephase/modify"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String modify(@ModelAttribute("basePhase") BasePhase basePhase, BindingResult result, ModelMap model)
/*     */   {
/* 130 */     this.basePhaseValidator.validate(basePhase, result);
/* 131 */     if (result.hasErrors()) {
/* 132 */       return "/baseset/basephase/modify";
/*     */     }
/* 134 */     BaseDayServiceResult baseDayServiceResult = this.baseDayService.getTradeDay();
/* 135 */     if (!baseDayServiceResult.correct()) {
/* 136 */       model.addAttribute("url", "/baseset/basephase/modify");
/*     */ 
/* 138 */       model.addAttribute("message", baseDayServiceResult.getErrorInfo());
/* 139 */       return "error";
/*     */     }
/* 141 */     basePhase.setGmtValid(baseDayServiceResult.getNextTradeDay());
/* 142 */     basePhase.setState(BasePhaseStateEnum.ENABLE.getValue());
/* 143 */     this.basePhaseService.modifyBasePhase(basePhase);
/* 144 */     model.addAttribute("url", "/baseset/basephase/next");
/* 145 */     return success(model, "basephase.save.success", new String[0]);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_U_BASEPHASE_DEL})
/*     */   @RequestMapping({"baseset/basephase/delete"})
/*     */   @ResponseBody
/*     */   public AjaxResult delete(@RequestParam("id") Long id)
/*     */   {
/* 158 */     AjaxResult result = new AjaxResult();
/* 159 */     BaseDayServiceResult baseDayServiceResult = this.baseDayService.getTradeDay();
/* 160 */     if (!baseDayServiceResult.correct()) {
/* 161 */       result.setErrorNO(baseDayServiceResult.getErrorNO());
/* 162 */       result.setErrorInfo(baseDayServiceResult.getErrorInfo());
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 167 */       this.basePhaseService.delBasePhase(id, baseDayServiceResult.getNextTradeDay());
/*     */     } catch (Exception e) {
/* 169 */       e.printStackTrace();
/* 170 */       if (this.log.isErrorEnabled()) {
/* 171 */         this.log.error("", e);
/*     */       }
/* 173 */       result.setErrorNO(Integer.valueOf(0));
/* 174 */       result.setErrorInfo(getMessage("basephase.delete.error", new String[0]));
/*     */     }
/* 176 */     return result;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_C_BASEPHASE_DISABLE})
/*     */   @RequestMapping({"baseset/basephase/disable"})
/*     */   @ResponseBody
/*     */   public AjaxResult disable(@RequestParam("id") Long id)
/*     */   {
/* 188 */     AjaxResult result = new AjaxResult();
/*     */ 
/* 190 */     BaseDayServiceResult baseDayServiceResult = this.baseDayService.getTradeDay();
/* 191 */     if (!baseDayServiceResult.correct()) {
/* 192 */       result.setErrorNO(baseDayServiceResult.getErrorNO());
/* 193 */       result.setErrorInfo(baseDayServiceResult.getErrorInfo());
/* 194 */       return result;
/*     */     }
/*     */     try {
/* 197 */       this.basePhaseService.disableBasePhase(id, baseDayServiceResult.getNextTradeDay());
/*     */     } catch (Exception e) {
/* 199 */       e.printStackTrace();
/* 200 */       if (this.log.isErrorEnabled()) {
/* 201 */         this.log.error("", e);
/*     */       }
/* 203 */       result.setErrorNO(Integer.valueOf(0));
/* 204 */       result.setErrorInfo(getMessage("basephase.disable.error", new String[0]));
/*     */     }
/* 206 */     return result;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_C_BASEPHASE_ENABLE})
/*     */   @RequestMapping({"baseset/basephase/enable"})
/*     */   @ResponseBody
/*     */   public AjaxResult enable(@RequestParam("id") Long id)
/*     */   {
/* 219 */     AjaxResult result = new AjaxResult();
/* 220 */     BaseDayServiceResult baseDayServiceResult = this.baseDayService.getTradeDay();
/* 221 */     if (!baseDayServiceResult.correct()) {
/* 222 */       result.setErrorNO(baseDayServiceResult.getErrorNO());
/* 223 */       result.setErrorInfo(baseDayServiceResult.getErrorInfo());
/* 224 */       return result;
/*     */     }
/*     */     try {
/* 227 */       this.basePhaseService.enableBasePhase(id, baseDayServiceResult.getNextTradeDay());
/*     */     }
/*     */     catch (Exception e) {
/* 230 */       e.printStackTrace();
/* 231 */       if (this.log.isErrorEnabled()) {
/* 232 */         this.log.error("", e);
/*     */       }
/* 234 */       result.setErrorNO(Integer.valueOf(0));
/* 235 */       result.setErrorInfo(getMessage("basephase.enable.error", new String[0]));
/*     */     }
/* 237 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.baseset.BasePhaseAction
 * JD-Core Version:    0.6.0
 */