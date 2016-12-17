/*    */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*    */ 
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("outFundTrans")
/*    */ @Scope("prototype")
/*    */ public class OutFundTrans extends InOutFundTrans
/*    */ {
/*    */   protected boolean isTrans()
/*    */   {
/* 26 */     return true;
/*    */   }
/*    */ 
/*    */   protected boolean isOutFund()
/*    */   {
/* 31 */     return true;
/*    */   }
/*    */ 
/*    */   protected boolean isNeedRecordUncomeFund()
/*    */   {
/* 39 */     return false;
/*    */   }
/*    */ 
/*    */   protected boolean isInOutTrans()
/*    */   {
/* 49 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.OutFundTrans
 * JD-Core Version:    0.6.0
 */