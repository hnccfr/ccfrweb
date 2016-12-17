/*    */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*    */ 
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("inFund")
/*    */ @Scope("prototype")
/*    */ public class InFund extends InOutFundTrans
/*    */ {
/*    */   protected boolean isTrans()
/*    */   {
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */   protected boolean isOutFund()
/*    */   {
/* 31 */     return false;
/*    */   }
/*    */ 
/*    */   protected boolean isNeedRecordUncomeFund()
/*    */   {
/* 36 */     return false;
/*    */   }
/*    */ 
/*    */   protected boolean isInOutTrans()
/*    */   {
/* 45 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.InFund
 * JD-Core Version:    0.6.0
 */