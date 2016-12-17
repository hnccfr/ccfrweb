/*     */ package com.hundsun.network.gates.genshan.web.action.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemDict;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemDictQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemDictService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictEnable;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictInputType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
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
/*     */ public class SystemDictAction extends BaseAction
/*     */ {
/*  42 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private SystemDictService systemDictService;
/*     */ 
/*     */   @Autowired
/*     */   private Validator systemDictAddValidator;
/*     */ 
/*     */   @Autowired
/*     */   private Validator systemDictEditValidator;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SYSDICT_LIST})
/*     */   @RequestMapping({"/baseset/systemdict/list"})
/*     */   public void list(@RequestParam(value="paraCode", required=false) String paraCode, @RequestParam(value="paraName", required=false) String paraName, @ModelAttribute("query") SystemDictQuery query, ModelMap model) throws Exception {
/*  64 */     if (StringUtil.isNotEmpty(paraCode)) {
/*  65 */       query.setParaCode(paraCode.trim());
/*     */     }
/*  67 */     if (StringUtil.isNotEmpty(paraName)) {
/*  68 */       query.setParaName(paraName.trim());
/*     */     }
/*  70 */     Map EnumSystemDictMap = EnumSystemDictEnable.toMap();
/*  71 */     model.addAttribute("EnumSystemDictMap", EnumSystemDictMap);
/*  72 */     this.systemDictService.selectPageList(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SYSDICT_ADD})
/*     */   @RequestMapping(value={"/baseset/systemdict/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String add(@ModelAttribute("systemDict") SystemDict systemDict, Model model)
/*     */     throws Exception
/*     */   {
/*  85 */     model.addAttribute("EnumSystemDictInputTypeList", EnumSystemDictInputType.toList());
/*  86 */     return "/baseset/systemdict/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SYSDICT_ADD})
/*     */   @RequestMapping(value={"/baseset/systemdict/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView add2(UserAgent userAgent, @ModelAttribute("systemDict") SystemDict systemDict, BindingResult result, Model model, Cookyjar cookyjar)
/*     */     throws Exception
/*     */   {
/* 101 */     model.addAttribute("EnumSystemDictInputTypeList", EnumSystemDictInputType.toList());
/*     */ 
/* 103 */     this.systemDictAddValidator.validate(systemDict, result);
/* 104 */     if (result.hasErrors()) {
/* 105 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 106 */       return null;
/*     */     }
/* 108 */     systemDict.setOperator(userAgent.getUserAccount());
/* 109 */     systemDict.setEnable(Short.valueOf(EnumSystemDictEnable.ENABLE.getCode()));
/* 110 */     this.systemDictService.insert(systemDict);
/* 111 */     model.addAttribute("url", "/baseset/systemdict/list");
/* 112 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SYSDICT_UPDATE})
/*     */   @RequestMapping(value={"/baseset/systemdict/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String update(@RequestParam(value="id", required=true) Long id, @ModelAttribute("systemDict") SystemDict systemDict, Model model)
/*     */     throws Exception
/*     */   {
/* 126 */     model.addAttribute("EnumSystemDictInputTypeList", EnumSystemDictInputType.toList());
/* 127 */     systemDict = this.systemDictService.selectByPrimaryKey(id);
/* 128 */     model.addAttribute("systemDict", systemDict);
/* 129 */     return "/baseset/systemdict/update";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SYSDICT_UPDATE})
/*     */   @RequestMapping(value={"/baseset/systemdict/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView update2(UserAgent userAgent, @ModelAttribute("systemDict") SystemDict systemDict, BindingResult result, Model model)
/*     */     throws Exception
/*     */   {
/* 144 */     model.addAttribute("EnumSystemDictInputTypeList", EnumSystemDictInputType.toList());
/*     */ 
/* 146 */     this.systemDictEditValidator.validate(systemDict, result);
/* 147 */     if (result.hasErrors()) {
/* 148 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 149 */       return null;
/*     */     }
/* 151 */     if ((systemDict.getParaCode().equals(EnumSystemDictKey.LISTING_JY_PROPORTION.getValue())) || (systemDict.getParaCode().equals(EnumSystemDictKey.LISTING_JS_PROPORTION.getValue())) || (systemDict.getParaCode().equals(EnumSystemDictKey.ORDER_JY_PROPORTION.getValue())) || (systemDict.getParaCode().equals(EnumSystemDictKey.ORDER_JS_PROPORTION.getValue())) || (systemDict.getParaCode().equals(EnumSystemDictKey.JY_LIQUIDATED_DAMAGES.getValue())) || (systemDict.getParaCode().equals(EnumSystemDictKey.JS_LIQUIDATED_DAMAGES.getValue())) || (systemDict.getParaCode().equals(EnumSystemDictKey.GOODS_PAY_PROPORTION.getValue())))
/*     */     {
/*     */       try
/*     */       {
/* 156 */         Double numDouble = Double.valueOf(Double.parseDouble(systemDict.getParaValue()));
/* 157 */         numDouble = Double.valueOf(numDouble.doubleValue() * 100.0D);
/* 158 */         int numVLong = numDouble.intValue();
/* 159 */         systemDict.setParaValue(numVLong + "");
/*     */       } catch (Exception e) {
/* 161 */         this.log.error("参数设置错误");
/*     */       }
/*     */     }
/* 164 */     systemDict.setGmtModify(new Date());
/* 165 */     systemDict.setOperator(userAgent.getUserAccount());
/* 166 */     this.systemDictService.updateByPrimaryKey(systemDict);
/* 167 */     model.addAttribute("url", "/baseset/systemdict/list");
/* 168 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_SYSDICT_VIEW})
/*     */   @RequestMapping({"/baseset/systemdict/view"})
/*     */   public void view(@RequestParam("id") Long id, Model model)
/*     */     throws Exception
/*     */   {
/* 181 */     SystemDict smls = this.systemDictService.selectByPrimaryKey(id);
/* 182 */     model.addAttribute("smls", smls);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/baseset/systemdict/ajaxenable"})
/*     */   @ResponseBody
/*     */   public String ajaxSystemDictEnable(UserAgent userAgent, @RequestParam(value="id", required=true) Long id, @RequestParam(value="enable", required=true) String enable, Model model)
/*     */   {
/*     */     try
/*     */     {
/* 201 */       SystemDict smls = this.systemDictService.selectByPrimaryKey(id);
/* 202 */       if (smls == null) {
/* 203 */         return "error_nofoundId";
/*     */       }
/* 205 */       SystemDict smlsNew = new SystemDict();
/* 206 */       smlsNew.setId(smls.getId());
/* 207 */       if (enable.equals("" + EnumSystemDictEnable.ENABLE.getCode()))
/* 208 */         smlsNew.setEnable(Short.valueOf(EnumSystemDictEnable.ENABLE.getCode()));
/* 209 */       else if (enable.equals("" + EnumSystemDictEnable.DISABLE.getCode())) {
/* 210 */         smlsNew.setEnable(Short.valueOf(EnumSystemDictEnable.DISABLE.getCode()));
/*     */       }
/* 212 */       smlsNew.setGmtModify(new Date());
/* 213 */       smlsNew.setOperator(userAgent.getUserAccount());
/* 214 */       this.systemDictService.updateByPrimaryKey(smlsNew);
/*     */     } catch (Exception e) {
/* 216 */       this.logger.error("ajaxSystemDictEnable error:", e);
/* 217 */       return "error_other";
/*     */     }
/* 219 */     return "success";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.baseset.SystemDictAction
 * JD-Core Version:    0.6.0
 */