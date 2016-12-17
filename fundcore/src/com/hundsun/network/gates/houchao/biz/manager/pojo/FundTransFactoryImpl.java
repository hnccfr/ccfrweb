/*    */ package com.hundsun.network.gates.houchao.biz.manager.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.manager.FundTransFactory;
/*    */ import com.hundsun.network.gates.houchao.biz.services.FundCoreTrans;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ 
/*    */ public class FundTransFactoryImpl
/*    */   implements FundTransFactory
/*    */ {
/* 24 */   protected Log log = LogFactory.getLog(FundTransFactoryImpl.class);
/*    */   private Map<String, FundCoreTrans> serviceMap;
/*    */ 
/*    */   public FundCoreTrans getFundCoreTrans(String transCode)
/*    */   {
/* 36 */     if (transCode == null) {
/* 37 */       return null;
/*    */     }
/* 39 */     if (this.serviceMap == null) {
/* 40 */       this.log.error("serviceMap为空,初始化失败");
/* 41 */       return null;
/*    */     }
/*    */ 
/* 44 */     return (FundCoreTrans)this.serviceMap.get(transCode);
/*    */   }
/*    */ 
/*    */   public void setServiceMap(Map<String, FundCoreTrans> serviceMap)
/*    */   {
/* 49 */     this.serviceMap = serviceMap;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.manager.pojo.FundTransFactoryImpl
 * JD-Core Version:    0.6.0
 */