/*    */ package com.hundsun.eclp.web.action.sys;
/*    */ 
/*    */ import com.hundsun.eclp.biz.domain.sys.Region;
/*    */ import com.hundsun.eclp.biz.service.sys.RegionService;
/*    */ import com.hundsun.eclp.enums.EnumRegionType;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class RegionAction
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RegionService regionService;
/*    */ 
/*    */   @RequestMapping({"/getRegionList"})
/*    */   @ResponseBody
/*    */   public List<Region> getRegionList(HttpServletRequest request)
/*    */   {
/* 34 */     String regionType = request.getParameter("regionType");
/* 35 */     String parentCode = request.getParameter("code");
/* 36 */     return this.regionService.getChildRegionList(EnumRegionType.getEnumByCode(regionType), parentCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.sys.RegionAction
 * JD-Core Version:    0.6.0
 */