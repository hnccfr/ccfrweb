/*    */ package com.hundsun.eclp.biz.service.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.SubSystemDAO;
/*    */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*    */ import com.hundsun.eclp.biz.service.SubSystemService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("subSystemService")
/*    */ public class SubSystemServiceImpl
/*    */   implements SubSystemService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   SubSystemDAO subSystemDao;
/*    */ 
/*    */   public List<SubSystem> getSubSystemByUserId(Long userid)
/*    */   {
/* 20 */     if (userid != null) {
/* 21 */       return this.subSystemDao.getSubSystemByUserId(userid);
/*    */     }
/* 23 */     return null;
/*    */   }
/*    */ 
/*    */   public SubSystem selectById(Long id) {
/* 27 */     if (id != null) {
/* 28 */       return this.subSystemDao.selectById(id);
/*    */     }
/* 30 */     return null;
/*    */   }
/*    */ 
/*    */   public SubSystem selectByCode(String systemCode) {
/* 34 */     if (StringUtil.isNotBlank(systemCode)) {
/* 35 */       return this.subSystemDao.selectByCode(systemCode);
/*    */     }
/* 37 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.SubSystemServiceImpl
 * JD-Core Version:    0.6.0
 */