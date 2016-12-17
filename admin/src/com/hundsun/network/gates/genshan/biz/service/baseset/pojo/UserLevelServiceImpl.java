/*    */ package com.hundsun.network.gates.genshan.biz.service.baseset.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.UserLevelDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.UserLevelQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.UserLevelService;
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
/*    */   public void selectPageList(UserLevelQuery query)
/*    */   {
/* 21 */     this.userLevelDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public void insert(UserLevel record)
/*    */   {
/* 29 */     this.userLevelDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(UserLevel record)
/*    */   {
/* 38 */     return this.userLevelDAO.updateByPrimaryKey(record);
/*    */   }
/*    */ 
/*    */   public UserLevel selectByPrimaryKey(Long id)
/*    */   {
/* 47 */     return this.userLevelDAO.selectByPrimaryKey(id);
/*    */   }
/*    */ 
/*    */   public UserLevel selectByUserAccount(String userAccount)
/*    */   {
/* 56 */     return this.userLevelDAO.selectByUserAccount(userAccount);
/*    */   }
/*    */ 
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 65 */     return this.userLevelDAO.deleteByPrimaryKey(id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.pojo.UserLevelServiceImpl
 * JD-Core Version:    0.6.0
 */