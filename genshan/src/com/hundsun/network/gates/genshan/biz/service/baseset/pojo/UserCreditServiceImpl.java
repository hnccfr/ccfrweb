/*    */ package com.hundsun.network.gates.genshan.biz.service.baseset.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.UserCreditDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserCredit;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.UserCreditQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.UserCreditService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("userCreditService")
/*    */ public class UserCreditServiceImpl
/*    */   implements UserCreditService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserCreditDAO userCreditDAO;
/*    */ 
/*    */   public void selectPageList(UserCreditQuery query)
/*    */   {
/* 24 */     this.userCreditDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public List<UserCredit> selectConditionList(UserCreditQuery query)
/*    */   {
/* 32 */     return this.userCreditDAO.selectConditionList(query);
/*    */   }
/*    */ 
/*    */   public void insert(UserCredit record)
/*    */   {
/* 39 */     this.userCreditDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(UserCredit record)
/*    */   {
/* 47 */     return this.userCreditDAO.updateByPrimaryKey(record);
/*    */   }
/*    */ 
/*    */   public UserCredit selectByPrimaryKey(Long id)
/*    */   {
/* 56 */     return this.userCreditDAO.selectByPrimaryKey(id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.pojo.UserCreditServiceImpl
 * JD-Core Version:    0.6.0
 */