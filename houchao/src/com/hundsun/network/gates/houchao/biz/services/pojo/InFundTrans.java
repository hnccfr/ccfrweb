/*    */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*    */ 
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("inFundTrans")
/*    */ @Scope("prototype")
/*    */ public class InFundTrans extends InOutFundTrans
/*    */ {
/*    */   protected boolean isTrans()
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */ 
/*    */   protected boolean isOutFund()
/*    */   {
/* 30 */     return false;
/*    */   }
/*    */ 
/*    */   protected boolean isNeedRecordUncomeFund()
/*    */   {
/* 38 */     return true;
/*    */   }
/*    */ 
/*    */   protected boolean isInOutTrans()
/*    */   {
/* 48 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.InFundTrans
 * JD-Core Version:    0.6.0
 */