/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemMemberlevelSetDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.UserIntegralLogDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.UserLevelDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemMemberlevelSet;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserIntegralLog;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserLevel;
/*    */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserLevelService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("userLevelService")
/*    */ public class UserLevelServiceImpl
/*    */   implements UserLevelService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserLevelDAO userLevelDAO;
/*    */ 
/*    */   @Autowired
/*    */   private SystemMemberlevelSetDAO systemMemberlevelSetDAO;
/*    */ 
/*    */   @Autowired
/*    */   private UserIntegralLogDAO userIntegralLogDAO;
/*    */ 
/*    */   public UserLevel selectByAccount(String userAccount)
/*    */   {
/* 37 */     return this.userLevelDAO.selectByAccount(userAccount);
/*    */   }
/*    */ 
/*    */   public Long insertUserLevel(String userAccount)
/*    */   {
/* 46 */     SystemMemberlevelSet smls = this.systemMemberlevelSetDAO.selectInitLevel();
/* 47 */     UserLevel userLevel = new UserLevel();
/* 48 */     userLevel.setUserAccount(userAccount);
/* 49 */     userLevel.setMemberLevel(smls.getMemberLevel());
/* 50 */     userLevel.setIntegral(new Integer(0));
/* 51 */     return this.userLevelDAO.insertUserLevel(userLevel);
/*    */   }
/*    */ 
/*    */   public int updateUserLevel(String userAccount, int integral)
/*    */   {
/* 61 */     UserLevel userLevel = this.userLevelDAO.selectByAccount(userAccount);
/* 62 */     int integralNew = userLevel.getIntegral().intValue() + integral;
/* 63 */     SystemMemberlevelSet smls = this.systemMemberlevelSetDAO.selectByIntegral(integralNew);
/* 64 */     userLevel.setMemberLevel(smls.getMemberLevel());
/* 65 */     userLevel.setIntegral(Integer.valueOf(integralNew));
/* 66 */     return this.userLevelDAO.updateUserLevel(userLevel);
/*    */   }
/*    */ 
/*    */   public Long insertUserIntegralLog(String userAccount, String orderNo, String projectCode, String operateCode, Integer integral, String operator)
/*    */   {
/* 76 */     UserIntegralLog record = new UserIntegralLog();
/* 77 */     record.setUserAccount(userAccount);
/* 78 */     record.setOrderNo(orderNo);
/* 79 */     record.setProjectCode(projectCode);
/* 80 */     record.setOperateCode(operateCode);
/* 81 */     record.setIntegral(integral);
/* 82 */     record.setOperator(operator);
/* 83 */     return this.userIntegralLogDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public List<UserIntegralLog> selectUserIntegralLogByUserAccount(String userAccount)
/*    */   {
/* 92 */     return this.userIntegralLogDAO.selectByUserAccount(userAccount);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.baseset.UserLevelServiceImpl
 * JD-Core Version:    0.6.0
 */