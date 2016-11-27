/*     */ package com.hundsun.eclp.common;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.user.UserInfo;
/*     */ import com.hundsun.eclp.biz.service.sys.RegionService;
/*     */ import com.hundsun.eclp.enums.EnumRegionType;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import javax.servlet.http.Cookie;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ 
/*     */ public class BaseAction
/*     */ {
/*  21 */   protected final Log _log = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Value("${app.domain}")
/*     */   private String domain;
/*     */ 
/*     */   @Autowired
/*     */   private RegionService regionService;
/*     */ 
/*     */   protected String success(Model model, String message)
/*     */   {
/*  54 */     model.addAttribute("message", message);
/*  55 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String success(ModelMap model, String message) {
/*  59 */     model.addAttribute("message", message);
/*  60 */     return "success";
/*     */   }
/*     */ 
/*     */   protected String error(Model model, String message) {
/*  64 */     model.addAttribute("message", message);
/*  65 */     return "error";
/*     */   }
/*     */ 
/*     */   protected String error(ModelMap model, String message) {
/*  69 */     model.addAttribute("message", message);
/*  70 */     return "error";
/*     */   }
/*     */ 
/*     */   protected void removeCookies(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  80 */     Cookie[] cookies = request.getCookies();
/*  81 */     if ((null != cookies) && (cookies.length > 0))
/*  82 */       for (Cookie cookie : cookies)
/*  83 */         response.addCookie(delCookie(cookie.getName()));
/*     */   }
/*     */ 
/*     */   private Cookie delCookie(String cookieName)
/*     */   {
/*  89 */     Cookie newCookie = new Cookie(cookieName, null);
/*  90 */     newCookie.setMaxAge(0);
/*  91 */     newCookie.setPath("/");
/*  92 */     newCookie.setDomain(this.domain);
/*  93 */     return newCookie;
/*     */   }
/*     */ 
/*     */   protected void initAddr(ModelMap model, UserInfo userInfo)
/*     */   {
/* 103 */     model.addAttribute("provinceList", this.regionService.getRegionByType(EnumRegionType.PROVINCE));
/*     */ 
/* 105 */     if (StringUtil.isNotBlank(userInfo.getRegCityCode())) {
/* 106 */       model.addAttribute("cityList", this.regionService.getChildRegionList(EnumRegionType.CITY, userInfo.getRegProvinceCode()));
/*     */     }
/*     */ 
/* 109 */     if (StringUtil.isNotBlank(userInfo.getRegDistrictCode()))
/* 110 */       model.addAttribute("districtList", this.regionService.getChildRegionList(EnumRegionType.DISTRICT, userInfo.getRegCityCode()));
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.common.BaseAction
 * JD-Core Version:    0.6.0
 */