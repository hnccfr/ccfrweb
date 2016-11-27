/*    */ package com.hundsun.network.gates.wulin.biz.domain.message;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class MessageForMore extends SystemMessage
/*    */ {
/*    */   private List<String> userAccountList;
/*    */ 
/*    */   public void setUserAccountList(List<String> userAccountList)
/*    */   {
/* 22 */     this.userAccountList = userAccountList;
/*    */   }
/*    */ 
/*    */   public List<String> getUserAccountList() {
/* 26 */     return this.userAccountList;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.message.MessageForMore
 * JD-Core Version:    0.6.0
 */