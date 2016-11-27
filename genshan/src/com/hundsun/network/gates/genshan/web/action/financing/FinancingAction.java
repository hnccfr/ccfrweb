/*     */ package com.hundsun.network.gates.genshan.web.action.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.financing.Financing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.financing.FinancingLog;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.FinancingQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.financing.FinancingService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.validator.FinancingAddValidator;
/*     */ import com.hundsun.network.gates.genshan.web.validator.FinancingEditValidator;
/*     */ import com.hundsun.network.gates.genshan.web.validator.FinancingLoanValidator;
/*     */ import com.hundsun.network.gates.genshan.web.validator.FinancingRepayValidator;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFinancingStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumYesOrNo;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class FinancingAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private FinancingService financingService;
/*     */ 
/*     */   @Autowired
/*     */   private FinancingAddValidator financingAddValidator;
/*     */ 
/*     */   @Autowired
/*     */   private FinancingEditValidator financingEditValidator;
/*     */ 
/*     */   @Autowired
/*     */   private FinancingLoanValidator financingLoanValidator;
/*     */ 
/*     */   @Autowired
/*     */   private FinancingRepayValidator financingRepayValidator;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_R_LIST})
/*     */   @RequestMapping({"/financing/list"})
/*     */   public void substationList(@ModelAttribute("query") FinancingQuery query, ModelMap model)
/*     */   {
/*  55 */     if (null == query) {
/*  56 */       query = new FinancingQuery();
/*     */     }
/*  58 */     model.put("statusList", EnumFinancingStatus.valuesWithoutDel());
/*  59 */     query.trim();
/*  60 */     this.financingService.getFinancingList(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_C_ADD})
/*     */   @RequestMapping(value={"/financing/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String financingAdd(@ModelAttribute("financing") Financing financing, ModelMap model)
/*     */   {
/*  70 */     return "/financing/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_C_ADD})
/*     */   @RequestMapping(value={"/financing/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String financingAdd(@ModelAttribute("financing") Financing financing, BindingResult bindingResult, ModelMap model, UserAgent userAgent)
/*     */   {
/*  82 */     this.financingAddValidator.validate(financing, bindingResult);
/*  83 */     if (bindingResult.hasErrors()) {
/*  84 */       return "/financing/add";
/*     */     }
/*     */ 
/*  87 */     this.financingService.add(financing, userAgent.getUserAccount());
/*     */ 
/*  89 */     model.put("url", "/financing/list");
/*  90 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_D_DEL})
/*     */   @RequestMapping(value={"/financing/del"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String financingDel(@RequestParam("id") Long id, ModelMap model, UserAgent userAgent)
/*     */   {
/*  99 */     model.put("url", "/financing/list");
/* 100 */     ServiceResult result = this.financingService.delete(id, userAgent.getUserAccount());
/* 101 */     if (result.error()) {
/* 102 */       model.put("message", result.getErrorInfo());
/* 103 */       return error(model);
/*     */     }
/* 105 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_R_LIST})
/*     */   @RequestMapping(value={"/financing/info"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String info(@RequestParam("id") Long id, ModelMap model, UserAgent userAgent)
/*     */   {
/* 114 */     model.put("url", "/financing/list");
/* 115 */     Financing financing = this.financingService.getFinancingById(id);
/* 116 */     model.put("financing", financing);
/* 117 */     return "/financing/info";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_EDIT})
/*     */   @RequestMapping(value={"/financing/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String financingEdit(@RequestParam("id") Long id, ModelMap model)
/*     */   {
/* 127 */     model.put("url", "/financing/list");
/* 128 */     Financing financing = this.financingService.getFinancingById(id);
/*     */ 
/* 130 */     convertNum2Des(financing);
/*     */ 
/* 132 */     model.put("financing", financing);
/* 133 */     return "/financing/edit";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_EDIT})
/*     */   @RequestMapping(value={"/financing/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String financingEdit(@ModelAttribute("financing") Financing financing, BindingResult bindingResult, ModelMap model, UserAgent userAgent)
/*     */   {
/* 145 */     this.financingEditValidator.validate(financing, bindingResult);
/* 146 */     if (bindingResult.hasErrors()) {
/* 147 */       Financing srcfinancing = this.financingService.getFinancingById(financing.getId());
/* 148 */       financing.setFinancingLogList(srcfinancing.getFinancingLogList());
/* 149 */       return "/financing/edit";
/*     */     }
/*     */ 
/* 152 */     this.financingService.edit(financing, userAgent.getUserAccount());
/*     */ 
/* 154 */     model.put("url", "/financing/list");
/* 155 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_AUDIT1})
/*     */   @RequestMapping(value={"/financing/advance"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String financingAdvance(@RequestParam("id") Long id, ModelMap model)
/*     */   {
/* 165 */     model.put("url", "/financing/list");
/* 166 */     model.put("formGuade", "advance");
/* 167 */     if (null == id) {
/* 168 */       return error(model);
/*     */     }
/* 170 */     Financing financing = this.financingService.getFinancingById(id);
/* 171 */     if ((null == financing) || (!financing.isCanAdvance())) {
/* 172 */       return error(model);
/*     */     }
/*     */ 
/* 175 */     convertNum2Des(financing);
/*     */ 
/* 177 */     model.put("financing", financing);
/* 178 */     model.put("financingLog", new FinancingLog());
/* 179 */     return "/financing/audit";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_AUDIT1})
/*     */   @RequestMapping(value={"/financing/advance"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String financingAdvance(@ModelAttribute("financing") Financing financing, @ModelAttribute("financingLog") FinancingLog financingLog, BindingResult bindingResult, ModelMap model, UserAgent userAgent)
/*     */   {
/* 191 */     model.put("url", "/financing/list");
/* 192 */     model.put("formGuade", "advance");
/* 193 */     if (null == financing.getId()) {
/* 194 */       return error(model);
/*     */     }
/* 196 */     Financing srcfinancing = this.financingService.getFinancingById(financing.getId());
/* 197 */     if ((null == srcfinancing) || (!srcfinancing.isCanAdvance())) {
/* 198 */       return error(model);
/*     */     }
/*     */ 
/* 202 */     String auditResult = financingLog.getAuditResult();
/* 203 */     EnumYesOrNo eAuditResult = EnumYesOrNo.indexByValue(auditResult);
/* 204 */     if (null == eAuditResult) {
/* 205 */       model.put("message", "审核结论错误");
/* 206 */       return error(model);
/*     */     }
/*     */ 
/* 210 */     String remark = financingLog.getLogRemark();
/* 211 */     if (StringUtil.isBlank(remark))
/* 212 */       bindingResult.rejectValue("logRemark", null, null, "不能为空");
/* 213 */     else if (remark.length() > 320) {
/* 214 */       bindingResult.rejectValue("logRemark", null, null, "不能超过320字");
/*     */     }
/*     */ 
/* 217 */     if (bindingResult.hasErrors())
/*     */     {
/* 219 */       convertNum2Des(srcfinancing);
/* 220 */       model.put("financing", srcfinancing);
/* 221 */       return "/financing/audit";
/*     */     }
/*     */ 
/* 224 */     financingLog.setFinancingId(financing.getId());
/* 225 */     this.financingService.audit(financingLog, userAgent.getUserAccount());
/*     */ 
/* 227 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_AUDIT2})
/*     */   @RequestMapping(value={"/financing/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String audit(@RequestParam("id") Long id, ModelMap model)
/*     */   {
/* 237 */     model.put("url", "/financing/list");
/* 238 */     model.put("formGuade", "audit");
/* 239 */     if (null == id) {
/* 240 */       return error(model);
/*     */     }
/* 242 */     Financing financing = this.financingService.getFinancingById(id);
/* 243 */     if ((null == financing) || (!financing.isCanFinalAudit())) {
/* 244 */       return error(model);
/*     */     }
/*     */ 
/* 247 */     convertNum2Des(financing);
/*     */ 
/* 249 */     model.put("financing", financing);
/* 250 */     model.put("financingLog", new FinancingLog());
/* 251 */     return "/financing/audit";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_AUDIT2})
/*     */   @RequestMapping(value={"/financing/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String audit(@ModelAttribute("financing") Financing financing, @ModelAttribute("financingLog") FinancingLog financingLog, BindingResult bindingResult, ModelMap model, UserAgent userAgent)
/*     */   {
/* 263 */     model.put("url", "/financing/list");
/* 264 */     model.put("formGuade", "audit");
/* 265 */     if (null == financing.getId()) {
/* 266 */       return error(model);
/*     */     }
/* 268 */     Financing srcfinancing = this.financingService.getFinancingById(financing.getId());
/* 269 */     if ((null == srcfinancing) || (!srcfinancing.isCanFinalAudit())) {
/* 270 */       return error(model);
/*     */     }
/*     */ 
/* 274 */     String auditResult = financingLog.getAuditResult();
/* 275 */     EnumYesOrNo eAuditResult = EnumYesOrNo.indexByValue(auditResult);
/* 276 */     if (null == eAuditResult) {
/* 277 */       model.put("message", "审核结论错误");
/* 278 */       return error(model);
/*     */     }
/*     */ 
/* 282 */     String remark = financingLog.getLogRemark();
/* 283 */     if (StringUtil.isBlank(remark))
/* 284 */       bindingResult.rejectValue("logRemark", null, null, "不能为空");
/* 285 */     else if (remark.length() > 320) {
/* 286 */       bindingResult.rejectValue("logRemark", null, null, "不能超过320字");
/*     */     }
/*     */ 
/* 289 */     if (bindingResult.hasErrors())
/*     */     {
/* 291 */       convertNum2Des(srcfinancing);
/* 292 */       model.put("financing", srcfinancing);
/* 293 */       return "/financing/audit";
/*     */     }
/*     */ 
/* 296 */     financingLog.setFinancingId(financing.getId());
/* 297 */     this.financingService.audit(financingLog, userAgent.getUserAccount());
/*     */ 
/* 299 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_LOAN})
/*     */   @RequestMapping(value={"/financing/loan"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String loan(@RequestParam("id") Long id, ModelMap model)
/*     */   {
/* 309 */     model.put("url", "/financing/list");
/* 310 */     model.put("formGuade", "loan");
/* 311 */     if (null == id) {
/* 312 */       return error(model);
/*     */     }
/* 314 */     Financing financing = this.financingService.getFinancingById(id);
/* 315 */     if ((null == financing) || (!financing.isCanLoan())) {
/* 316 */       return error(model);
/*     */     }
/*     */ 
/* 319 */     convertNum2Des(financing);
/*     */ 
/* 321 */     model.put("financing", financing);
/* 322 */     model.put("financingLog", new FinancingLog());
/* 323 */     return "/financing/loan";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_LOAN})
/*     */   @RequestMapping(value={"/financing/loan"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String loan(@ModelAttribute("financing") Financing financing, BindingResult financingResult, @ModelAttribute("financingLog") FinancingLog financingLog, BindingResult bindingResult, ModelMap model, UserAgent userAgent)
/*     */   {
/* 335 */     model.put("url", "/financing/list");
/* 336 */     model.put("formGuade", "loan");
/* 337 */     if (null == financing.getId()) {
/* 338 */       return error(model);
/*     */     }
/* 340 */     Financing srcfinancing = this.financingService.getFinancingById(financing.getId());
/* 341 */     if ((null == srcfinancing) || (!srcfinancing.isCanLoan())) {
/* 342 */       return error(model);
/*     */     }
/*     */ 
/* 346 */     this.financingLoanValidator.validate(financing, financingResult);
/*     */ 
/* 350 */     String auditResult = financingLog.getAuditResult();
/* 351 */     EnumYesOrNo eAuditResult = EnumYesOrNo.indexByValue(auditResult);
/* 352 */     if (null == eAuditResult) {
/* 353 */       model.put("message", "审核结论错误");
/* 354 */       return error(model);
/*     */     }
/*     */ 
/* 358 */     String remark = financingLog.getLogRemark();
/* 359 */     if (StringUtil.isBlank(remark))
/* 360 */       bindingResult.rejectValue("logRemark", null, null, "不能为空");
/* 361 */     else if (remark.length() > 320) {
/* 362 */       bindingResult.rejectValue("logRemark", null, null, "不能超过320字");
/*     */     }
/*     */ 
/* 365 */     if ((financingResult.hasErrors()) || (bindingResult.hasErrors())) {
/* 366 */       financing.setFinancingLogList(srcfinancing.getFinancingLogList());
/* 367 */       return "/financing/loan";
/*     */     }
/*     */ 
/* 370 */     financingLog.setFinancingId(financing.getId());
/* 371 */     this.financingService.loan(financing, financingLog, userAgent.getUserAccount());
/*     */ 
/* 373 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_REPAY})
/*     */   @RequestMapping(value={"/financing/repay"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String repay(@RequestParam("id") Long id, ModelMap model, UserAgent userAgent)
/*     */   {
/* 383 */     model.put("url", "/financing/list");
/* 384 */     model.put("formGuade", "repay");
/* 385 */     if (null == id) {
/* 386 */       return error(model);
/*     */     }
/* 388 */     Financing financing = this.financingService.getFinancingById(id);
/* 389 */     if ((null == financing) || (!financing.isCanRepay())) {
/* 390 */       return error(model);
/*     */     }
/*     */ 
/* 393 */     convertNum2Des(financing);
/*     */ 
/* 395 */     model.put("financing", financing);
/* 396 */     model.put("financingLog", new FinancingLog());
/* 397 */     return "/financing/repay";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FINANCING_U_REPAY})
/*     */   @RequestMapping(value={"/financing/repay"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String repay(@ModelAttribute("financing") Financing financing, BindingResult financingResult, @ModelAttribute("financingLog") FinancingLog financingLog, BindingResult bindingResult, ModelMap model, UserAgent userAgent)
/*     */   {
/* 409 */     model.put("url", "/financing/list");
/* 410 */     model.put("formGuade", "repay");
/* 411 */     if (null == financing.getId()) {
/* 412 */       return error(model);
/*     */     }
/* 414 */     Financing srcfinancing = this.financingService.getFinancingById(financing.getId());
/* 415 */     if ((null == srcfinancing) || (!srcfinancing.isCanRepay())) {
/* 416 */       return error(model);
/*     */     }
/*     */ 
/* 420 */     this.financingRepayValidator.validate(financing, financingResult);
/*     */ 
/* 424 */     String auditResult = financingLog.getAuditResult();
/* 425 */     EnumYesOrNo eAuditResult = EnumYesOrNo.indexByValue(auditResult);
/* 426 */     if (null == eAuditResult) {
/* 427 */       model.put("message", "审核结论错误");
/* 428 */       return error(model);
/*     */     }
/*     */ 
/* 432 */     String remark = financingLog.getLogRemark();
/* 433 */     if (StringUtil.isBlank(remark))
/* 434 */       bindingResult.rejectValue("logRemark", null, null, "不能为空");
/* 435 */     else if (remark.length() > 320) {
/* 436 */       bindingResult.rejectValue("logRemark", null, null, "不能超过320字");
/*     */     }
/*     */ 
/* 439 */     if ((financingResult.hasErrors()) || (bindingResult.hasErrors())) {
/* 440 */       financing.setFinancingLogList(srcfinancing.getFinancingLogList());
/* 441 */       return "/financing/repay";
/*     */     }
/*     */ 
/* 444 */     financingLog.setFinancingId(financing.getId());
/* 445 */     this.financingService.repay(financing, financingLog, userAgent.getUserAccount());
/*     */ 
/* 447 */     return success(model);
/*     */   }
/*     */ 
/*     */   private void convertNum2Des(Financing financing) {
/* 451 */     if (financing.getLoanRate() != null) {
/* 452 */       financing.setLoanRateDes(CommonUtils.getMoneyDesc(financing.getLoanRate()));
/*     */     }
/* 454 */     if (financing.getApplyAmount() != null) {
/* 455 */       financing.setApplyAmountDes(CommonUtils.getMoneyDesc(financing.getApplyAmount()));
/*     */     }
/* 457 */     if (financing.getLoanAmount() != null) {
/* 458 */       financing.setLoanAmountDes(CommonUtils.getMoneyDesc(financing.getLoanAmount()));
/*     */     }
/* 460 */     if (financing.getRepayAmount() != null) {
/* 461 */       financing.setRepayAmountDes(CommonUtils.getMoneyDesc(financing.getRepayAmount()));
/*     */     }
/* 463 */     if (financing.getApplyLimit() != null)
/* 464 */       financing.setApplyLimitDes(financing.getApplyLimit().toString());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.financing.FinancingAction
 * JD-Core Version:    0.6.0
 */