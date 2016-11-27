/*    */ package com.hundsun.network.gates.genshan.web.tools;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.service.common.AreaService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.pojo.common.AreaServiceImpl;
/*    */ 
/*    */ public class AreaTool
/*    */ {
/*    */   private AreaService areaService;
/*    */ 
/*    */   public AreaTool()
/*    */   {
/* 11 */     this.areaService = AreaServiceImpl.getInstance();
/*    */   }
/*    */ 
/*    */   public String getAreaFullName(String areaId)
/*    */   {
/* 21 */     return this.areaService.getAreaFullName(areaId);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.tools.AreaTool
 * JD-Core Version:    0.6.0
 */