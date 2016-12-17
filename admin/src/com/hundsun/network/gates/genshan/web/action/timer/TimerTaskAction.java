/*    */ package com.hundsun.network.gates.genshan.web.action.timer;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.service.auction.AuctionActiveService;
/*    */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*    */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class TimerTaskAction extends BaseAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AuctionActiveService auctionActiveService;
/*    */ 
/*    */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.COM_U_TIMERTASK_LIST})
/*    */   @RequestMapping({"/timerTask/list"})
/*    */   public String list()
/*    */   {
/* 30 */     return "timerTask/list";
/*    */   }
/*    */ 
/*    */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.COM_U_TIMERTASK_LIST})
/*    */   @RequestMapping({"/timerTask/auctionActive"})
/*    */   public String auctionActive()
/*    */   {
/* 41 */     this.auctionActiveService.activeAuctionProjectsBatch();
/* 42 */     this.auctionActiveService.activeTransferProjectsBatch();
/* 43 */     this.auctionActiveService.activeTenderProjectsBatch();
/* 44 */     return "success";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.timer.TimerTaskAction
 * JD-Core Version:    0.6.0
 */