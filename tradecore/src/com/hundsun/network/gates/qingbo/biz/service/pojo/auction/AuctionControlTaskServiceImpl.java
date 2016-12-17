/*    */ package com.hundsun.network.gates.qingbo.biz.service.pojo.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.service.RemoteAuctionCoreService;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallControlServiceRequest;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionLatestBidCoreDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.auction.ControlAuction;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.auction.AuctionControlTaskService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.io.PrintStream;
/*    */ import java.io.Serializable;
/*    */ import java.util.Date;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("auctionControlTaskService")
/*    */ public class AuctionControlTaskServiceImpl extends BaseService
/*    */   implements AuctionControlTaskService, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 6617565643590447218L;
/*    */ 
/*    */   @Autowired
/*    */   private AuctionLatestBidCoreDAO auctionLatestBidCoreDAO;
/*    */ 
/*    */   @Autowired
/*    */   private RemoteAuctionCoreService remoteAuctionCoreService;
/*    */ 
/*    */   public void testRun()
/*    */   {
/* 34 */     System.out.println("我运行了," + new Date());
/*    */   }
/*    */ 
/*    */   public void controlAuctionRun()
/*    */   {
/* 45 */     List autoControlList = this.auctionLatestBidCoreDAO.selectAutoControlLists();
/* 46 */     Iterator iterator = autoControlList.iterator();
/*    */ 
/* 50 */     while (iterator.hasNext()) {
/* 51 */       ControlAuction ca = (ControlAuction)iterator.next();
/*    */ 
/* 121 */       if (StringUtil.isNotEmpty(ca.getLatestStatus())) {
/* 122 */         if (this.log.isDebugEnabled()) {
/* 123 */           this.log.debug("========当前状态：" + ca.getLatestStatus());
/*    */         }
/* 125 */         HallControlServiceRequest request = new HallControlServiceRequest();
/* 126 */         request.setProjectCode(ca.getProjectCode());
/*    */ 
/* 128 */         request.setLatestStatus(ca.getLatestStatus());
/* 129 */         ServiceResult result = this.remoteAuctionCoreService.auctioneerDo(request);
/* 130 */         if (result.correct()) {
/* 131 */           if (this.log.isDebugEnabled()) {
/* 132 */             this.log.debug("========调用流程控制接口成功=============");
/*    */           }
/*    */         }
/* 135 */         else if (this.log.isDebugEnabled())
/* 136 */           this.log.debug("========失败!" + result.getErrorNO() + ";" + result.getErrorInfo());
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.pojo.auction.AuctionControlTaskServiceImpl
 * JD-Core Version:    0.6.0
 */