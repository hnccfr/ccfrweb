/*     */ package com.hundsun.network.gates.genshan.web.action.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.genshan.common.MobileMessageUtil;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class FundInOutAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @Autowired
/*     */   private MobileMessageUtil mobileMessageUtil;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FUND_IN_U_FOR_USER})
/*     */   @RequestMapping(value={"/fund/in"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String inCashAction(@RequestParam("fundAccount") String fundAccount, @RequestParam("fundInMoney") Double fundInMoney, UserAgent userAgent, ModelMap model)
/*     */   {
/*  54 */     if ((null == fundAccount) || (null == fundInMoney) || (fundInMoney.doubleValue() <= 0.0D)) {
/*  55 */       model.put("message", "入金账号或金额错误");
/*  56 */       return super.error(model);
/*     */     }
/*     */ 
/*  59 */     long moneyF = new Double(fundInMoney.doubleValue() * 100.0D).longValue();
/*  60 */     TransRequest request = new TransRequest();
/*  61 */     request.setFundAccount(fundAccount);
/*  62 */     request.setAmount(Long.valueOf(moneyF));
/*  63 */     request.setOperator(userAgent.getUserAccount());
/*  64 */     FundOperateResult result = this.remoteFundService.fundInByExchange(request);
/*  65 */     if (null == result) {
/*  66 */       this.log.error("入金时，调用资金账务接口失败。");
/*  67 */       model.put("message", "入金时，调用资金账务接口失败。");
/*  68 */       return super.error(model);
/*     */     }
/*  70 */     if (result.isError()) {
/*  71 */       this.log.error("入金时，调用资金账务接口失败.原因：" + result.getErrorNO() + "," + result.getErrorInfo());
/*  72 */       model.put("message", "操作失败。" + result.getErrorInfo());
/*  73 */       return super.error(model);
/*     */     }
/*     */     try
/*     */     {
/*  77 */       UserAccount userAccount = this.userAccountService.getUserByFundAccount(fundAccount);
/*  78 */       List nums = new ArrayList();
/*  79 */       nums.add(userAccount.getMobile());
/*  80 */       String msg = "尊敬的" + userAccount.getName() + "您好，您的交易账号已成功转入金额" + fundInMoney + "元。请确认【中部林业产权交易服务中心】";
/*  81 */       this.mobileMessageUtil.sendMsg(nums, msg);
/*     */     } catch (Exception e) {
/*  83 */       this.log.error("send mobileMessage for fund in error cause by:" + e);
/*     */     }
/*     */ 
/*  86 */     model.put("url", "/fund/queryFundAccountMsgInit.htm");
/*  87 */     return super.success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FUND_OUT_U_FOR_USER})
/*     */   @RequestMapping(value={"/fund/out"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String outCashAction(@RequestParam("fundAccount") String fundAccount, @RequestParam("fundOutMoney") Double fundOutMoney, UserAgent userAgent, ModelMap model)
/*     */   {
/* 100 */     if ((null == fundAccount) || (null == fundOutMoney) || (fundOutMoney.doubleValue() <= 0.0D)) {
/* 101 */       model.put("message", "出金账号或金额错误");
/* 102 */       return super.error(model);
/*     */     }
/*     */ 
/* 105 */     long moneyF = new Double(fundOutMoney.doubleValue() * 100.0D).longValue();
/* 106 */     TransRequest request = new TransRequest();
/* 107 */     request.setFundAccount(fundAccount);
/* 108 */     request.setAmount(Long.valueOf(moneyF));
/* 109 */     request.setOperator(userAgent.getUserAccount());
/* 110 */     FundOperateResult result = this.remoteFundService.fundOutByExchange(request);
/* 111 */     if (null == result) {
/* 112 */       this.log.error("出金时，调用资金账务接口失败。");
/* 113 */       model.put("message", "出金时，调用资金账务接口失败。");
/* 114 */       return super.error(model);
/*     */     }
/* 116 */     if (result.isError()) {
/* 117 */       this.log.error("出金时，调用资金账务接口失败.原因：" + result.getErrorNO() + "," + result.getErrorInfo());
/* 118 */       model.put("message", "操作失败。" + result.getErrorInfo());
/* 119 */       return super.error(model);
/*     */     }
/*     */     try
/*     */     {
/* 123 */       UserAccount userAccount = this.userAccountService.getUserByFundAccount(fundAccount);
/* 124 */       List nums = new ArrayList();
/* 125 */       nums.add(userAccount.getMobile());
/* 126 */       String msg = "尊敬的" + userAccount.getName() + "您好，您的交易账号已成功转出金额" + fundOutMoney + "元。请确认【中部林业产权交易服务中心】";
/* 127 */       this.mobileMessageUtil.sendMsg(nums, msg);
/*     */     } catch (Exception e) {
/* 129 */       this.log.error("send mobileMessage for fund out error cause by:" + e);
/*     */     }
/*     */ 
/* 132 */     model.put("url", "/fund/queryFundAccountMsgInit.htm");
/* 133 */     return super.success(model);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.fund.FundInOutAction
 * JD-Core Version:    0.6.0
 */