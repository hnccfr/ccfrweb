/*     */ package com.hundsun.network.gates.fengshan.web.action;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectListingQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumCertificateType;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.common.MailService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.common.UploadService;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBank;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.AccountRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Controller
/*     */ public class DemoAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private MailService mailService;
/*     */ 
/*     */   @Autowired
/*     */   private UploadService uploadService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @RequestMapping({"/demo/role"})
/*     */   public void role(UserAgent agent, ModelMap model)
/*     */     throws Exception
/*     */   {
/*  42 */     model.addAttribute("userAgent", agent);
/*     */   }
/*     */   @RequestMapping({"/demo/mail"})
/*     */   public void mailit() {
/*  47 */     this.mailService.sendActivateMail("guowei");
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/demo/pagerTest"})
/*     */   public void pagerTest(@ModelAttribute("query") ProjectListingQuery query, ModelMap model) {
/*  53 */     List list = new ArrayList();
/*  54 */     for (int i = 0; i < 20; i++) {
/*  55 */       ProjectListing projectListing = new ProjectListing();
/*  56 */       projectListing.setTitle("当前页:" + query.getPageNo());
/*  57 */       projectListing.setCode("abcdefghijklmn12345678");
/*  58 */       projectListing.setListingEndTime(new Date());
/*  59 */       projectListing.setProjectTypeCode("钢材" + i);
/*  60 */       projectListing.setTradingType("洽谈交易" + i);
/*  61 */       list.add(projectListing);
/*     */     }
/*  63 */     query.setTotalCount(100);
/*  64 */     query.setData(list);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/demo/upload"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void uploadFileInit(ModelMap model) {
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/demo/upload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void uploadFile(@RequestParam("uploadFile") MultipartFile file, ModelMap model) {
/*  75 */     model.addAttribute("imagePath", this.uploadService.uploadFile(file));
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/demo/active"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String activePage(@ModelAttribute("request") AccountRequest request, Model model)
/*     */     throws Exception
/*     */   {
/*  85 */     model.addAttribute("banks", EnumBank.values());
/*  86 */     model.addAttribute("certificateTypeList", EnumCertificateType.values());
/*  87 */     return "/demo/active";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/demo/active"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String activeAction(UserAgent userAgent, @ModelAttribute("request") AccountRequest request, BindingResult result, Model model)
/*     */     throws Exception
/*     */   {
/*  95 */     request.setHolderName(request.getTradeAccount());
/*     */ 
/*  97 */     FundOperateResult inResult = this.remoteFundService.createFundAccount(request);
/*     */ 
/*  99 */     if (null == inResult) {
/* 100 */       model.addAttribute("errorMsg", "操作失败");
/*     */     }
/* 102 */     else if (inResult.isError())
/* 103 */       model.addAttribute("errorMsg", "操作失败");
/*     */     else {
/* 105 */       model.addAttribute("succMsg", "操作成功");
/*     */     }
/*     */ 
/* 108 */     return "/demo/active";
/*     */   }
/*     */   @RequestMapping({"/demo/agent/add"})
/*     */   public String agentAdd(Cookyjar cookyjar, ModelMap model) {
/* 113 */     UserAgent agent = new UserAgent();
/* 114 */     agent.setAccountId(Long.valueOf(10101L));
/* 115 */     agent.setAccount("pengpeng");
/* 116 */     agent.setFunctions(0);
/* 117 */     agent.setLastLoginIP("");
/* 118 */     agent.setLastLoginTime("");
/* 119 */     agent.setMenuId("");
/* 120 */     agent.setRoleId(Long.valueOf(10000L));
/* 121 */     agent.setRoleName("普通级");
/* 122 */     cookyjar.set(agent);
/* 123 */     return "/demo/role";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.DemoAction
 * JD-Core Version:    0.6.0
 */