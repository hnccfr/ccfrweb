/*    */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*    */ 
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("outFund")
/*    */ @Scope("prototype")
/*    */ public class OutFund extends InOutFundTrans
/*    */ {
/*    */   protected boolean isTrans()
/*    */   {
/* 25 */     return false;
/*    */   }
/*    */ 
/*    */   protected boolean isOutFund()
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */ 
/*    */   protected boolean isNeedRecordUncomeFund()
/*    */   {
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */   protected boolean isInOutTrans()
/*    */   {
/* 44 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.OutFund
 * JD-Core Version:    0.6.0
 */