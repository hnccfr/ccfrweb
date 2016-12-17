/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.financing;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.financing.FinancingDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.common.CacheDTO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.financing.Financing;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.FinancingQuery;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.financing.FinancingService;
/*    */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*    */ import java.text.ParseException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Calendar;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("financingService")
/*    */ public class FinancingServiceImpl extends BaseService
/*    */   implements FinancingService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private FinancingDAO financingDAO;
/* 29 */   private static Map<String, CacheDTO<? extends Collection>> cache = new HashMap();
/*    */ 
/*    */   private void updateLatestFinancingCache(Integer count)
/*    */   {
/* 33 */     CacheDTO cmsFinancing = new CacheDTO();
/*    */ 
/* 35 */     FinancingQuery query = new FinancingQuery();
/* 36 */     query.setPageSize(count.intValue());
/* 37 */     this.financingDAO.selectByQuery(query);
/* 38 */     List list = query.getData();
/* 39 */     List result = new ArrayList();
/* 40 */     for (int i = 0; i < count.intValue(); i++) {
/* 41 */       result.add(i < list.size() ? (Financing)list.get(i) : new Financing());
/*    */     }
/* 43 */     cmsFinancing.setData(result);
/* 44 */     cmsFinancing.setOutMs(1800000L);
/*    */     try {
/* 46 */       cmsFinancing.setUpdateTimeMs(DateUtil.getCurrentDay().getTimeInMillis());
/*    */     } catch (ParseException e) {
/* 48 */       e.printStackTrace();
/*    */     }
/* 50 */     cache.put("cmsFinancing", cmsFinancing);
/*    */   }
/*    */ 
/*    */   public List<Financing> selectFinancingListing(Integer count)
/*    */   {
/* 56 */     if ((null == cache.get("cmsFinancing")) || (((CacheDTO)cache.get("cmsFinancing")).isOutTime()))
/* 57 */       updateLatestFinancingCache(count);
/* 58 */     List proList = (List)((CacheDTO)cache.get("cmsFinancing")).getData();
/* 59 */     return proList;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.financing.FinancingServiceImpl
 * JD-Core Version:    0.6.0
 */