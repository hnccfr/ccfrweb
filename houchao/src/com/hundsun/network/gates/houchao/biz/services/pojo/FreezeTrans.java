/*    */ package com.hundsun.network.gates.houchao.biz.services.pojo;
/*    */ 
/*    */ import org.springframework.context.annotation.Scope;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("freezeTrans")
/*    */ @Scope("prototype")
/*    */ public class FreezeTrans extends Freeze
/*    */ {
/*    */   boolean isFreeze()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.services.pojo.FreezeTrans
 * JD-Core Version:    0.6.0
 */