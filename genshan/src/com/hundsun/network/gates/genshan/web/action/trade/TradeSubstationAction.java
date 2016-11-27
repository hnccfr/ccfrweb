/*     */ package com.hundsun.network.gates.genshan.web.action.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeSubstationQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeSubstation;
/*     */ import com.hundsun.network.gates.genshan.biz.service.trade.TradeSubstationService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.validator.TradeSubstationAddValidator;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class TradeSubstationAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeSubstationService tradeSubstationService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeSubstationAddValidator tradeSubstationAddValidator;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUBSTATION_R_LIST})
/*     */   @RequestMapping({"/substation/list"})
/*     */   public void substationList(@ModelAttribute("query") TradeSubstationQuery query, Model model)
/*     */   {
/*  41 */     if (null == query) {
/*  42 */       query = new TradeSubstationQuery();
/*     */     }
/*  44 */     if ((query.getName() != null) && (query.getName().length() > 0)) {
/*  45 */       query.setName(query.getName().trim());
/*     */     }
/*  47 */     this.tradeSubstationService.getTradeSubstationList(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUBSTATION_C_ADD})
/*     */   @RequestMapping(value={"/substation/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String substationAdd(@ModelAttribute("tradeSubstation") TradeSubstation tradeSubstation, ModelMap model)
/*     */   {
/*  57 */     return "/substation/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUBSTATION_C_ADD})
/*     */   @RequestMapping(value={"/substation/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String substationAdd(@ModelAttribute("tradeSubstation") TradeSubstation tradeSubstation, BindingResult bindingResult, ModelMap model, UserAgent userAgent)
/*     */   {
/*  69 */     this.tradeSubstationAddValidator.validate(tradeSubstation, bindingResult);
/*     */ 
/*  71 */     if (!bindingResult.hasErrors()) {
/*  72 */       TradeSubstation old = this.tradeSubstationService.getTradeSubstationById(tradeSubstation.getId());
/*  73 */       if (old != null) {
/*  74 */         bindingResult.rejectValue("id", null, null, "分中心ID已存在");
/*     */       }
/*     */     }
/*  77 */     if (bindingResult.hasErrors()) {
/*  78 */       return "/substation/add";
/*     */     }
/*  80 */     tradeSubstation.setOperator(userAgent.getUserAccount());
/*  81 */     this.tradeSubstationService.insert(tradeSubstation);
/*  82 */     model.put("url", "/substation/list");
/*  83 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUBSTATION_D_DEL})
/*     */   @RequestMapping(value={"/substation/del"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String substationDel(@RequestParam("id") Long id, ModelMap model)
/*     */   {
/*  92 */     model.put("url", "/substation/list");
/*  93 */     Integer result = this.tradeSubstationService.delete(id);
/*  94 */     if ((null == result) || (result.intValue() <= 0)) {
/*  95 */       model.put("message", "删除交易分中心失败！");
/*  96 */       return error(model);
/*     */     }
/*  98 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUBSTATION_U_EDIT})
/*     */   @RequestMapping(value={"/substation/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String edit(@RequestParam("id") Long id, ModelMap model)
/*     */   {
/* 108 */     TradeSubstation tradeSubstation = this.tradeSubstationService.getTradeSubstationById(id);
/* 109 */     if (null == tradeSubstation) {
/* 110 */       model.put("message", "无此交易分中心！");
/* 111 */       return error(model);
/*     */     }
/* 113 */     model.put("tradeSubstation", tradeSubstation);
/* 114 */     return "/substation/edit";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUBSTATION_U_EDIT})
/*     */   @RequestMapping(value={"/substation/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String edit(@ModelAttribute("tradeSubstation") TradeSubstation tradeSubstation, BindingResult bindingResult, ModelMap model, UserAgent userAgent)
/*     */   {
/* 126 */     this.tradeSubstationAddValidator.validate(tradeSubstation, bindingResult);
/* 127 */     if (bindingResult.hasErrors()) {
/* 128 */       return "/substation/edit";
/*     */     }
/* 130 */     tradeSubstation.setOperator(userAgent.getUserAccount());
/* 131 */     Integer result = this.tradeSubstationService.update(tradeSubstation);
/* 132 */     model.put("url", "/substation/list");
/* 133 */     if ((null == result) || (result.intValue() <= 0)) {
/* 134 */       model.put("message", "修改交易分中心失败！");
/* 135 */       return error(model);
/*     */     }
/* 137 */     return success(model);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.trade.TradeSubstationAction
 * JD-Core Version:    0.6.0
 */