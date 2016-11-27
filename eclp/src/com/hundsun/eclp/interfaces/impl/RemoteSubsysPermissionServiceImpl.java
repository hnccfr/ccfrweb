/*    */ package com.hundsun.eclp.interfaces.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.AuthorityDAO;
/*    */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*    */ import com.hundsun.eclp.biz.domain.sys.MemoPermission;
/*    */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*    */ import com.hundsun.eclp.biz.service.SubSystemService;
/*    */ import com.hundsun.eclp.client.remote.client.RemoteSubsystemPermissionService;
/*    */ import com.hundsun.eclp.client.remote.dto.SubsystemPermissionSetDTO;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("remoteSubsystemPermissionService")
/*    */ public class RemoteSubsysPermissionServiceImpl
/*    */   implements RemoteSubsystemPermissionService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   SubSystemService subSystemService;
/*    */ 
/*    */   @Autowired
/*    */   AuthorityDAO authorityDAO;
/* 28 */   protected Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   public SubsystemPermissionSetDTO getSubsystemPermissionSet(String sc)
/*    */   {
/* 32 */     SubsystemPermissionSetDTO dto = new SubsystemPermissionSetDTO();
/* 33 */     Map subsysPermissionMap = new HashMap();
/* 34 */     for (String subsystemCode : sc.trim().split(","))
/*    */     {
/*    */       try {
/* 37 */         if (StringUtil.isBlank(subsystemCode)) {
/* 38 */           return dto;
/*    */         }
/*    */ 
/* 41 */         SubSystem subSystem = this.subSystemService.selectByCode(subsystemCode);
/* 42 */         if (subSystem == null) {
/* 43 */           return dto;
/*    */         }
/* 45 */         Map permissionMap = new HashMap();
/*    */ 
/* 47 */         if (MemoPermission.containsKey(subsystemCode))
/*    */         {
/* 49 */           permissionMap = MemoPermission.get(subsystemCode);
/*    */ 
/* 51 */           if ((permissionMap == null) || (permissionMap.isEmpty()))
/* 52 */             permissionMap = queryPermissionBySysId(subSystem.getId());
/*    */         }
/*    */         else
/*    */         {
/* 56 */           permissionMap = queryPermissionBySysId(subSystem.getId());
/*    */         }
/*    */ 
/* 59 */         MemoPermission.put(subsystemCode, permissionMap);
/*    */ 
/* 61 */         subsysPermissionMap.put(subsystemCode, permissionMap);
/* 62 */         this.log.debug("服务器端返回子系统[" + subsystemCode + "]权限信息：" + permissionMap);
/*    */       } catch (Exception e) {
/* 64 */         this.log.error(e);
/*    */       }
/* 66 */       dto.setSubsystemPermissionMap(subsysPermissionMap);
/*    */     }
/* 68 */     return dto;
/*    */   }
/*    */ 
/*    */   private Map<Integer, Integer> queryPermissionBySysId(Long sysId)
/*    */   {
/* 73 */     Map permissionMap = new HashMap();
/*    */     int row;
/* 74 */     if (sysId != null)
/*    */     {
/* 76 */       List<Authority> authList = this.authorityDAO.selectAuthListBySubSys(sysId);
/* 77 */       if ((authList != null) && (authList.size() > 0)) {
/* 78 */         row = 1;
/* 79 */         for (Authority auth : authList) {
/* 80 */           permissionMap.put(Integer.valueOf(auth.getCode().intValue()), Integer.valueOf(row++));
/*    */         }
/*    */       }
/*    */     }
/* 84 */     return permissionMap;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.interfaces.impl.RemoteSubsysPermissionServiceImpl
 * JD-Core Version:    0.6.0
 */