/*     */ package com.hundsun.network.gates.genshan.web.action.supplydemand;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAccuse;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.AccuseStatusEnum;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.EnumInfoStatus;
/*     */ import com.hundsun.network.gates.genshan.biz.service.supplydemand.SupplyDemandInfoService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.genshan.common.MobileMessageUtil;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuditRes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class SupplyDemandInfoAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private SupplyDemandInfoService supplyDemandInfoService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @Autowired
/*     */   private MobileMessageUtil mobileMessageUtil;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUP_R_INFO_LIST})
/*     */   @RequestMapping({"/supplyDemand/list"})
/*     */   public String list(@ModelAttribute("query") SupplyDemandInfoQuery query, ModelMap model)
/*     */   {
/*  52 */     if (null != query.getTitle()) {
/*  53 */       query.setTitle(query.getTitle().trim());
/*     */     }
/*  55 */     if (null != query.getPublisherAccount()) {
/*  56 */       query.setPublisherAccount(query.getPublisherAccount().trim());
/*     */     }
/*  58 */     this.supplyDemandInfoService.selectPageList(query);
/*  59 */     model.addAttribute("query", query);
/*  60 */     return "/supplyDemand/list";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUP_R_INFO_DETAIL})
/*     */   @RequestMapping({"/supplyDemand/showDetail"})
/*     */   public String showDetail(@RequestParam("sid") Long sid, ModelMap model)
/*     */   {
/*  72 */     SupplyDemandInfo supplyDemandInfo = this.supplyDemandInfoService.selectInfoById(sid);
/*  73 */     if (supplyDemandInfo == null) {
/*  74 */       model.addAttribute("message", "该信息不存在或已删除!");
/*  75 */       model.addAttribute("url", "/supplyDemand/list");
/*  76 */       return "forward:/error.htm";
/*     */     }
/*  78 */     model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/*  79 */     return "/supplyDemand/detail";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUP_U_INFO_AUDIT})
/*     */   @RequestMapping(value={"/supplyDemand/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String toAuditPage(@ModelAttribute("query") SupplyDemandInfoQuery query, @RequestParam("sid") Long sid, ModelMap model)
/*     */   {
/*  91 */     SupplyDemandInfo supplyDemandInfo = this.supplyDemandInfoService.selectInfoById(sid);
/*  92 */     if (supplyDemandInfo == null) {
/*  93 */       model.addAttribute("message", "该信息不存在或已删除!");
/*  94 */       model.addAttribute("url", "/supplyDemand/list");
/*  95 */       return "forward:/error.htm";
/*     */     }
/*  97 */     if (!EnumInfoStatus.AUDIT.getValue().equalsIgnoreCase(supplyDemandInfo.getStatus())) {
/*  98 */       model.addAttribute("message", "该信息已评审!");
/*  99 */       model.addAttribute("url", "/supplyDemand/list");
/* 100 */       return "forward:/error.htm";
/*     */     }
/*     */ 
/* 103 */     model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 104 */     model.addAttribute("audit", new SupplyDemandInfoAudit());
/* 105 */     return "/supplyDemand/audit";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUP_U_INFO_AUDIT})
/*     */   @RequestMapping(value={"/supplyDemand/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView auditOperator(@ModelAttribute("query") SupplyDemandInfoQuery query, SupplyDemandInfoAudit audit, UserAgent userAgent, ModelMap model)
/*     */   {
/* 118 */     if (this.supplyDemandInfoService.selectAuditByInfoId(audit.getInfoId()) != null) {
/* 119 */       model.addAttribute("message", "该信息已经评审!");
/* 120 */       model.addAttribute("url", "/supplyDemand/list");
/* 121 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/* 123 */     SupplyDemandInfo supplyDemandInfo = this.supplyDemandInfoService.selectInfoById(audit.getInfoId());
/* 124 */     if ((supplyDemandInfo == null) || (!EnumInfoStatus.AUDIT.getValue().equalsIgnoreCase(supplyDemandInfo.getStatus()))) {
/* 125 */       model.addAttribute("message", "该信息不存在或已删除!");
/* 126 */       model.addAttribute("url", "/supplyDemand/list");
/* 127 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/* 129 */     Map map = new HashMap();
/* 130 */     map.put("sid", audit.getInfoId());
/* 131 */     if (audit != null) {
/* 132 */       if ((audit.getAuditResult() != null) && ("N".equals(audit.getAuditResult()))) {
/* 133 */         if ((audit.getMark() == null) || ("".equals(audit.getMark().trim()))) {
/* 134 */           model.addAttribute("message", "请填写审核不通过原因!");
/* 135 */           model.addAttribute("url", "/supplyDemand/list");
/* 136 */           return new ModelAndView("forward:/error.htm", model);
/*     */         }
/* 138 */         map.put("status", EnumInfoStatus.FAIL.getValue());
/* 139 */         audit.setMark(audit.getMark().trim());
/* 140 */       } else if ((audit.getAuditResult() != null) && ("Y".equals(audit.getAuditResult()))) {
/* 141 */         audit.setMark("");
/* 142 */         map.put("status", EnumInfoStatus.NORMAL.getValue());
/*     */       } else {
/* 144 */         model.addAttribute("message", "请认真审核供求信息!");
/* 145 */         model.addAttribute("url", "/supplyDemand/list");
/* 146 */         return new ModelAndView("forward:/error.htm", model);
/*     */       }
/*     */ 
/* 151 */       audit.setOperator(userAgent.getUserAccount());
/* 152 */       audit.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/*     */ 
/* 154 */       map.put("operator", userAgent.getUserAccount());
/* 155 */       this.supplyDemandInfoService.insertAudit(audit);
/*     */     } else {
/* 157 */       model.addAttribute("message", "请认真审核供求信息!");
/* 158 */       model.addAttribute("url", "/supplyDemand/list");
/* 159 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/* 161 */     this.supplyDemandInfoService.updateInfoStatus(map);
/* 162 */     model.addAttribute("query", query);
/* 163 */     model.addAttribute("url", "/supplyDemand/list");
/*     */     try
/*     */     {
/* 167 */       UserAccount userAccount = this.userAccountService.getUserByAccount(supplyDemandInfo.getPublisherAccount());
/* 168 */       List nums = new ArrayList();
/* 169 */       nums.add(userAccount.getMobile());
/* 170 */       String msg = "尊敬的" + userAccount.getName() + "您好，您供求信息" + query.getTitle();
/*     */ 
/* 172 */       if (EnumAuditRes.NO.getValue().equals(audit.getAuditResult()))
/*     */       {
/* 174 */         msg = msg + "未通过审核【中部林业产权交易服务中心】";
/* 175 */         this.mobileMessageUtil.sendMsg(nums, msg);
/*     */       }
/*     */       else {
/* 178 */         msg = msg + "已通过审核【中部林业产权交易服务中心】";
/* 179 */         this.mobileMessageUtil.sendMsg(nums, msg);
/*     */       }
/*     */     } catch (Exception e) {
/* 182 */       this.log.error("send mobileMessage for supplyDemand audit error cause by:" + e);
/*     */     }
/* 184 */     return new ModelAndView("forward:/success.htm", model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUP_U_INFO_DISABLE})
/*     */   @RequestMapping({"/supplyDemand/forbid"})
/*     */   public ModelAndView forbidOperator(Long sid, String reason, UserAgent userAgent, ModelMap model)
/*     */   {
/* 198 */     SupplyDemandInfo supplyDemandInfo = this.supplyDemandInfoService.selectInfoById(sid);
/* 199 */     if (supplyDemandInfo == null) {
/* 200 */       model.addAttribute("message", "该信息不存在或已删除!");
/* 201 */       model.addAttribute("url", "/supplyDemand/list");
/* 202 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/* 204 */     if (!EnumInfoStatus.NORMAL.getValue().equalsIgnoreCase(supplyDemandInfo.getStatus())) {
/* 205 */       model.addAttribute("message", "该信息不在禁用范围内");
/* 206 */       model.addAttribute("url", "/supplyDemand/list");
/* 207 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/* 209 */     if ((reason == null) || ("".equals(reason.trim()))) {
/* 210 */       model.addAttribute("message", "请填写禁用原因");
/* 211 */       model.addAttribute("url", "/supplyDemand/list");
/* 212 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/*     */ 
/* 215 */     Map map = new HashMap();
/* 216 */     SupplyDemandInfoAudit audit = this.supplyDemandInfoService.selectAuditByInfoId(sid);
/* 217 */     if (audit == null) {
/* 218 */       model.addAttribute("message", "该信息内容不全");
/* 219 */       model.addAttribute("url", "/supplyDemand/list");
/* 220 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/* 222 */     audit.setAuditResult("N");
/*     */ 
/* 224 */     audit.setOperator(userAgent.getUserAccount());
/* 225 */     audit.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 226 */     audit.setMark(reason.trim());
/* 227 */     map.put("sid", sid);
/* 228 */     map.put("operator", userAgent.getUserAccount());
/* 229 */     map.put("status", EnumInfoStatus.FORBIDDEN.getValue());
/*     */ 
/* 231 */     this.supplyDemandInfoService.updateInfoStatus(map);
/* 232 */     this.supplyDemandInfoService.updateAudit(audit);
/*     */ 
/* 234 */     SupplyDemandInfoAccuse accuse = new SupplyDemandInfoAccuse();
/* 235 */     accuse.setStatus(AccuseStatusEnum.UNACCEPT.getValue());
/* 236 */     accuse.setAccuser(userAgent.getUserAccount());
/*     */ 
/* 238 */     accuse.setInfoId(sid);
/* 239 */     this.supplyDemandInfoService.updateOtherAccuse(accuse);
/*     */ 
/* 241 */     model.addAttribute("url", "/supplyDemand/list");
/* 242 */     return new ModelAndView("forward:/success.htm", model);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.supplydemand.SupplyDemandInfoAction
 * JD-Core Version:    0.6.0
 */