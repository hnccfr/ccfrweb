/*    */ package com.hundsun.network.gates.genshan.web.action.common;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.common.AreaBO;
/*    */ import com.hundsun.network.gates.genshan.biz.service.common.AreaService;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class AreaAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AreaService areaService;
/* 22 */   protected final Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   @RequestMapping({"ajax/queryProvince"})
/*    */   @ResponseBody
/*    */   public List<AreaBO> queryProvince()
/*    */   {
/* 32 */     return this.areaService.queryProvince();
/*    */   }
/*    */ 
/*    */   @RequestMapping({"ajax/queryCity"})
/*    */   @ResponseBody
/*    */   public List<AreaBO> queryCity(@RequestParam("province") String province)
/*    */   {
/* 44 */     return this.areaService.queryCity(province);
/*    */   }
/*    */ 
/*    */   @RequestMapping({"ajax/queryArea"})
/*    */   @ResponseBody
/*    */   public List<AreaBO> queryArea(@RequestParam("city") String city)
/*    */   {
/* 56 */     return this.areaService.queryLocalArea(city);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.common.AreaAction
 * JD-Core Version:    0.6.0
 */