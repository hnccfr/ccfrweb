/*    */ package com.hundsun.network.hseccms.web.interceptor;
/*    */ 
/*    */ import com.hundsun.network.hseccms.dao.Cms2BaseDictDao;
/*    */ import com.hundsun.network.hseccms.model.Cms2BaseDict;
/*    */ import com.hundsun.network.hseccms.model.Cms2Site;
/*    */ import com.hundsun.network.hseccms.query.Cms2BaseDictQuery;
/*    */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*    */ import com.hundsun.network.hseccms.util.Cms2Utils;
/*    */ import com.hundsun.network.hseccms.web.exceptions.SiteNotFoundException;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*    */ 
/*    */ public class FrontContextInterceptor extends HandlerInterceptorAdapter
/*    */ {
/* 32 */   private static final Log log = LogFactory.getLog(FrontContextInterceptor.class);
/*    */ 
/*    */   @Autowired
/*    */   private Cms2SiteService cms2SiteService;
/*    */ 
/*    */   @Autowired
/*    */   private Cms2BaseDictDao cms2BaseDictDao;
/*    */ 
/* 44 */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException { Cms2Site site = null;
/* 45 */     String server = request.getServerName();
/* 46 */     if (StringUtil.isBlank(server)) {
/* 47 */       log.error("bad request");
/* 48 */       throw new RuntimeException("no site record in database!");
/*    */     }
/* 50 */     List<Cms2Site> list = this.cms2SiteService.queryByServiceName(server);
/*    */ 
/* 52 */     if ((list == null) || (list.size() == 0))
/* 53 */       throw new RuntimeException("no site record in database!");
/* 54 */     if (list.size() == 1) {
/* 55 */       site = (Cms2Site)list.get(0);
/*    */     }
/*    */     else {
/* 58 */       for (Cms2Site s : list) {
/* 59 */         if (s.getDomain().equals(server)) {
/* 60 */           site = s;
/* 61 */           break;
/*    */         }
/* 63 */         String alias = s.getDomainAlias();
/* 64 */         if (!StringUtils.isBlank(alias)) {
/* 65 */           for (String a : StringUtils.split(alias, ',')) {
/* 66 */             if (a.equals(server)) {
/* 67 */               site = s;
/* 68 */               break;
/*    */             }
/*    */           }
/*    */         }
/* 72 */         String redirect = s.getDomainRedirect();
/* 73 */         if (!StringUtils.isBlank(redirect)) {
/* 74 */           for (String r : StringUtils.split(redirect, ',')) {
/* 75 */             if (!r.equals(server)) continue;
/*    */             try {
/* 77 */               Cms2BaseDictQuery query = new Cms2BaseDictQuery();
/* 78 */               query.setCode("port");
/* 79 */               Cms2BaseDict dict = this.cms2BaseDictDao.queryCms2BaseDictByParam(query);
/* 80 */               if (null != dict)
/* 81 */                 response.sendRedirect(s.getUrl(dict.getValue()));
/*    */               else
/* 83 */                 response.sendRedirect(s.getUrl(""));
/*    */             }
/*    */             catch (IOException e)
/*    */             {
/* 87 */               throw new RuntimeException(e);
/*    */             }
/* 89 */             return false;
/*    */           }
/*    */         }
/*    */       }
/*    */ 
/* 94 */       if (site == null) {
/* 95 */         throw new SiteNotFoundException(server);
/*    */       }
/*    */     }
/* 98 */     Cms2Utils.setSite(request, site);
/* 99 */     return true;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.interceptor.FrontContextInterceptor
 * JD-Core Version:    0.6.0
 */