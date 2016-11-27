/*    */ package com.hundsun.network.hseccms.web.exceptions;
/*    */ 
/*    */ public class SiteNotFoundException extends RuntimeException
/*    */ {
/*    */   private String domain;
/*    */ 
/*    */   public SiteNotFoundException(String domain)
/*    */   {
/*  8 */     super(domain);
/*  9 */     this.domain = domain;
/*    */   }
/*    */ 
/*    */   public String getDomain() {
/* 13 */     return this.domain;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.exceptions.SiteNotFoundException
 * JD-Core Version:    0.6.0
 */