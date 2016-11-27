/*     */ package com.hundsun.network.gates.genshan.web.action.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemServicechargeSpecial;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemServicechargeSpecialQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemServiceCSpecialService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSysSerCSpecialIsDel;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumYesOrNo;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.validation.Validator;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class SysSerCSpecialAction extends BaseAction
/*     */ {
/*  41 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private SystemServiceCSpecialService systemServicechargeSpecialService;
/*     */ 
/*     */   @Autowired
/*     */   private Validator sysSerCSpecialAddValidator;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SSCSSPECIAL_LIST})
/*     */   @RequestMapping({"/baseset/sysscpecial/list"})
/*     */   public void list(@RequestParam(value="userAccount", required=false) String userAccount, @RequestParam(value="proTypeCode", required=false) String proTypeCode, @ModelAttribute("query") SystemServicechargeSpecialQuery query, ModelMap model)
/*     */     throws Exception
/*     */   {
/*  60 */     model.addAttribute("EnumSysSerCSpecialIsDelMap", EnumSysSerCSpecialIsDel.toMap());
/*  61 */     model.put("transTypeList", getTradingTypes());
/*     */ 
/*  63 */     model.put("haveAuctioneerEnum", EnumYesOrNo.values());
/*  64 */     if (StringUtil.isNotEmpty(userAccount)) {
/*  65 */       query.setUserAccount(userAccount.trim());
/*     */     }
/*  67 */     if (StringUtil.isNotEmpty(proTypeCode)) {
/*  68 */       query.setProTypeCode(proTypeCode.trim());
/*     */     }
/*  70 */     this.systemServicechargeSpecialService.selectPageList(query);
/*     */   }
/*     */ 
/*     */   private EnumTradingType[] getTradingTypes()
/*     */   {
/*  75 */     EnumTradingType[] tradingTypes = { EnumTradingType.BID_ORDER, EnumTradingType.TRANSFER_ORDER, EnumTradingType.TENDER_ORDER, EnumTradingType.PLACE_ORDER };
/*     */ 
/*  81 */     return tradingTypes;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SSCSSPECIAL_ADD})
/*     */   @RequestMapping(value={"/baseset/sysscpecial/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String add(@ModelAttribute("sscSpecial") SystemServicechargeSpecial sscSpecial, Model model)
/*     */     throws Exception
/*     */   {
/*  93 */     model.addAttribute("transTypeList", getTradingTypes());
/*     */ 
/*  95 */     model.addAttribute("haveAuctioneerEnum", EnumYesOrNo.values());
/*  96 */     return "/baseset/sysscpecial/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SSCSSPECIAL_ADD})
/*     */   @RequestMapping(value={"/baseset/sysscpecial/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView add2(UserAgent userAgent, @ModelAttribute("sscSpecial") SystemServicechargeSpecial sscSpecial, BindingResult result, Model model, Cookyjar cookyjar)
/*     */     throws Exception
/*     */   {
/* 112 */     this.sysSerCSpecialAddValidator.validate(sscSpecial, result);
/* 113 */     if (result.hasErrors()) {
/* 114 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 115 */       model.addAttribute("transTypeList", getTradingTypes());
/*     */ 
/* 117 */       model.addAttribute("haveAuctioneerEnum", EnumYesOrNo.values());
/* 118 */       return null;
/*     */     }
/* 120 */     sscSpecial.setIsDel(new Short(EnumSysSerCSpecialIsDel.IN_USERD.getValue()));
/* 121 */     sscSpecial.setOperator(userAgent.getUserAccount());
/* 122 */     this.systemServicechargeSpecialService.insert(sscSpecial);
/* 123 */     model.addAttribute("url", "/baseset/sysscpecial/list");
/* 124 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SSCSSPECIAL_UPDATE})
/*     */   @RequestMapping(value={"/baseset/sysscpecial/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String update(@RequestParam(value="id", required=true) Long id, @ModelAttribute("sscSpecial") SystemServicechargeSpecial sscSpecial, Model model)
/*     */     throws Exception
/*     */   {
/* 138 */     sscSpecial = this.systemServicechargeSpecialService.selectByPrimaryKey(id);
/* 139 */     model.addAttribute("sscSpecial", sscSpecial);
/* 140 */     model.addAttribute("transTypeList", getTradingTypes());
/*     */ 
/* 142 */     model.addAttribute("haveAuctioneerEnum", EnumYesOrNo.values());
/* 143 */     return "/baseset/sysscpecial/update";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SSCSSPECIAL_UPDATE})
/*     */   @RequestMapping(value={"/baseset/sysscpecial/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView update2(UserAgent userAgent, @ModelAttribute("sscSpecial") SystemServicechargeSpecial sscSpecial, BindingResult result, Model model)
/*     */     throws Exception
/*     */   {
/* 159 */     this.sysSerCSpecialAddValidator.validate(sscSpecial, result);
/* 160 */     if (result.hasErrors()) {
/* 161 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 162 */       model.addAttribute("transTypeList", getTradingTypes());
/*     */ 
/* 164 */       model.addAttribute("haveAuctioneerEnum", EnumYesOrNo.values());
/* 165 */       return null;
/*     */     }
/*     */ 
/* 168 */     sscSpecial.setGmtModify(new Date());
/* 169 */     sscSpecial.setOperator(userAgent.getUserAccount());
/* 170 */     this.systemServicechargeSpecialService.updateByPrimaryKey(sscSpecial);
/* 171 */     model.addAttribute("url", "/baseset/sysscpecial/list");
/* 172 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SSCSSPECIAL_VIEW})
/*     */   @RequestMapping({"/baseset/sysscpecial/view"})
/*     */   public void view(@RequestParam("id") Long id, Model model)
/*     */     throws Exception
/*     */   {
/* 182 */     SystemServicechargeSpecial smls = this.systemServicechargeSpecialService.selectByPrimaryKey(id);
/* 183 */     model.addAttribute("smls", smls);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SSCSSPECIAL_UPDATE})
/*     */   @RequestMapping({"/baseset/sysscpecial/ajaxenable"})
/*     */   @ResponseBody
/*     */   public String ajaxSystemDictEnable(UserAgent userAgent, @RequestParam(value="id", required=true) Long id, @RequestParam(value="enable", required=true) String enable, Model model)
/*     */   {
/*     */     try
/*     */     {
/* 203 */       SystemServicechargeSpecial smls = this.systemServicechargeSpecialService.selectByPrimaryKey(id);
/* 204 */       if (smls == null) {
/* 205 */         return "error_nofoundId";
/*     */       }
/* 207 */       SystemServicechargeSpecial specialNew = new SystemServicechargeSpecial();
/* 208 */       specialNew.setId(smls.getId());
/* 209 */       if (enable.equals(EnumSysSerCSpecialIsDel.IN_USERD.getValue()))
/* 210 */         specialNew.setIsDel(new Short(EnumSysSerCSpecialIsDel.IN_USERD.getValue()));
/* 211 */       else if (enable.equals(EnumSysSerCSpecialIsDel.UN_USERD.getValue())) {
/* 212 */         specialNew.setIsDel(new Short(EnumSysSerCSpecialIsDel.UN_USERD.getValue()));
/*     */       }
/* 214 */       specialNew.setGmtModify(new Date());
/* 215 */       specialNew.setOperator(userAgent.getUserAccount());
/* 216 */       this.systemServicechargeSpecialService.updateByPrimaryKey(specialNew);
/*     */     } catch (Exception e) {
/* 218 */       this.logger.error("ajaxSystemDictEnable error:", e);
/* 219 */       return "error_other";
/*     */     }
/* 221 */     return "success";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_COMSPECIAL_UPDATE})
/*     */   @RequestMapping(value={"/baseset/sysscpecial/comspecial"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String comspecial(@ModelAttribute("sscSpecial") SystemServicechargeSpecial sscSpecial, Model model)
/*     */     throws Exception
/*     */   {
/* 235 */     sscSpecial = this.systemServicechargeSpecialService.selectComSpecial();
/* 236 */     model.addAttribute("sscSpecial", sscSpecial);
/* 237 */     return "/baseset/sysscpecial/comspecial";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_COMSPECIAL_UPDATE})
/*     */   @RequestMapping(value={"/baseset/sysscpecial/comspecial"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView comspecial(UserAgent userAgent, @ModelAttribute("sscSpecial") SystemServicechargeSpecial sscSpecial, BindingResult result, Model model)
/*     */     throws Exception
/*     */   {
/* 253 */     this.sysSerCSpecialAddValidator.validate(sscSpecial, result);
/* 254 */     if (result.hasErrors()) {
/* 255 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 256 */       return null;
/*     */     }
/* 258 */     sscSpecial.setGmtModify(new Date());
/* 259 */     sscSpecial.setOperator(userAgent.getUserAccount());
/* 260 */     this.systemServicechargeSpecialService.updateByPrimaryKey(sscSpecial);
/* 261 */     model.addAttribute("url", "/baseset/sysscpecial/comspecial");
/* 262 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.baseset.SysSerCSpecialAction
 * JD-Core Version:    0.6.0
 */