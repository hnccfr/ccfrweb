/*    */ package com.hundsun.network.gates.qingbo.biz;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectListingService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ 
/*    */ public class ServiceLocate
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private static RemoteProjectListingService remoteProjectListingService;
/*    */ 
/*    */   public static RemoteProjectListingService getRemoteProjectListingService()
/*    */   {
/* 24 */     return remoteProjectListingService;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.ServiceLocate
 * JD-Core Version:    0.6.0
 */