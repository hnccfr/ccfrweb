/*    */ package com.hundsun.network.gates.genshan.security;
/*    */ 
/*    */ public class AdminAccessDeniedException extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = -4757581999998896852L;
/*    */ 
/*    */   public AdminAccessDeniedException()
/*    */   {
/*    */   }
/*    */ 
/*    */   public AdminAccessDeniedException(String message, Throwable cause)
/*    */   {
/* 13 */     super(message, cause);
/*    */   }
/*    */ 
/*    */   public AdminAccessDeniedException(String message) {
/* 17 */     super(message);
/*    */   }
/*    */ 
/*    */   public AdminAccessDeniedException(Throwable cause) {
/* 21 */     super(cause);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.security.AdminAccessDeniedException
 * JD-Core Version:    0.6.0
 */