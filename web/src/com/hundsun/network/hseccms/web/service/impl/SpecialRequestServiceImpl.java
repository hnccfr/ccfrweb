/*    */ package com.hundsun.network.hseccms.web.service.impl;
/*    */ 
/*    */ import com.hundsun.network.hseccms.dao.Cms2ContDao;
/*    */ import com.hundsun.network.hseccms.dao.Cms2GroupDao;
/*    */ import com.hundsun.network.hseccms.enums.EnumContStatus;
/*    */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*    */ import com.hundsun.network.hseccms.web.service.SpecialRequestService;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("specialRequestService")
/*    */ public class SpecialRequestServiceImpl
/*    */   implements SpecialRequestService
/*    */ {
/* 21 */   private static Log logger = LogFactory.getLog(SpecialRequestServiceImpl.class);
/*    */ 
/* 23 */   Map<String, Object> param = new HashMap();
/*    */ 
/*    */   @Autowired
/*    */   private Cms2GroupDao cms2GroupDao;
/*    */ 
/*    */   @Autowired
/*    */   private Cms2ContDao cms2ContDao;
/*    */ 
/*    */   public List<Cms2Channel> queryByGroupCode(String groupCode, String groupType) {
/* 36 */     this.param.clear();
/* 37 */     this.param.put("code", groupCode);
/* 38 */     this.param.put("type", groupType);
/* 39 */     return this.cms2GroupDao.queryChannelsByGroupCode(this.param);
/*    */   }
/*    */ 
/*    */   public Cms2Channel queryChannelByUserOwn(String groupCode, String groupType, Long channelId)
/*    */   {
/* 48 */     this.param.clear();
/* 49 */     this.param.put("code", groupCode);
/* 50 */     this.param.put("type", groupType);
/* 51 */     this.param.put("channelId", channelId);
/* 52 */     return this.cms2GroupDao.queryChannelByUserOwn(this.param);
/*    */   }
/*    */ 
/*    */   public Long queryCountByMemberAndChannel(String excludeId, String memberId, Long channelId)
/*    */   {
/* 60 */     this.param.clear();
/* 61 */     this.param.put("excludeId", excludeId);
/* 62 */     this.param.put("memberId", memberId);
/* 63 */     this.param.put("channelId", channelId);
/* 64 */     Short[] status = { EnumContStatus.DRAFT.getCode(), EnumContStatus.AUDITING.getCode() };
/* 65 */     this.param.put("status", status);
/* 66 */     return this.cms2ContDao.queryCountByMemberAndChannel(this.param);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.service.impl.SpecialRequestServiceImpl
 * JD-Core Version:    0.6.0
 */