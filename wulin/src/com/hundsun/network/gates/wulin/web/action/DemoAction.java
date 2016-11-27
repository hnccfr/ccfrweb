/*    */ package com.hundsun.network.gates.wulin.web.action;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.wulin.biz.service.job.ProjectAutoService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderAutoService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.ui.ModelMap;
/*    */ 
/*    */ public class DemoAction extends BaseAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   TradeOrderAutoService tradeOrderAutoService;
/*    */ 
/*    */   @Autowired
/*    */   ProjectAutoService projectAutoService;
/*    */ 
/*    */   public void role(ModelMap model)
/*    */     throws Exception
/*    */   {
/* 22 */     ServiceResult serviceResult = this.tradeOrderAutoService.autoOrderOption();
/* 23 */     setResult(model, serviceResult);
/*    */   }
/*    */ 
/*    */   public String auto1(ModelMap model)
/*    */     throws Exception
/*    */   {
/* 34 */     ServiceResult serviceResult = this.tradeOrderAutoService.dealOrderRemindOption();
/* 35 */     setResult(model, serviceResult);
/* 36 */     return "/demo/trade/auto";
/*    */   }
/*    */ 
/*    */   public String auto2(ModelMap model)
/*    */     throws Exception
/*    */   {
/* 47 */     ServiceResult serviceResult = new ServiceResult();
/*    */ 
/* 50 */     setResult(model, serviceResult);
/* 51 */     return "/demo/trade/auto";
/*    */   }
/*    */ 
/*    */   public String auto3(ModelMap model)
/*    */     throws Exception
/*    */   {
/* 62 */     ServiceResult serviceResult = this.tradeOrderAutoService.dealUncommentOption();
/* 63 */     setResult(model, serviceResult);
/* 64 */     return "/demo/trade/auto";
/*    */   }
/*    */ 
/*    */   public String auto4(ModelMap model) throws Exception
/*    */   {
/* 69 */     ServiceResult serviceResult = this.projectAutoService.autoProjectValidate();
/* 70 */     setResult(model, serviceResult);
/* 71 */     return "/demo/trade/auto";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.web.action.DemoAction
 * JD-Core Version:    0.6.0
 */