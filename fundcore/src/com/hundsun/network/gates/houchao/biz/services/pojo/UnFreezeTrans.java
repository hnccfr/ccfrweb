/*    */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*    */ 
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("unFreezeTrans")
/*    */ @Scope("prototype")
/*    */ public class UnFreezeTrans extends Freeze
/*    */ {
/*    */   boolean isFreeze()
/*    */   {
/* 28 */     return false;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.UnFreezeTrans
 * JD-Core Version:    0.6.0
 */