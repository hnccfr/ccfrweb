/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemUserCheckDao;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemUserCheck;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemUserCheckService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemUserCheckService")
/*    */ public class SystemUserCheckServiceImpl extends BaseService
/*    */   implements SystemUserCheckService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemUserCheckDao systemUserCheckDao;
/*    */ 
/*    */   public SystemUserCheck selectByRole(String userRole)
/*    */   {
/* 20 */     return this.systemUserCheckDao.selectByRole(userRole);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.baseset.SystemUserCheckServiceImpl
 * JD-Core Version:    0.6.0
 */