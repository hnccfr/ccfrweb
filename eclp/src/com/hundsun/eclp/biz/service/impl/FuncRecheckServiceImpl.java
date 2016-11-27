/*    */ package com.hundsun.eclp.biz.service.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.FuncRecheckDAO;
/*    */ import com.hundsun.eclp.biz.domain.auth.FuncRecheck;
/*    */ import com.hundsun.eclp.biz.service.FuncRecheckService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("funcCheckerService")
/*    */ public class FuncRecheckServiceImpl
/*    */   implements FuncRecheckService
/*    */ {
/* 16 */   protected Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   FuncRecheckDAO funcCheckerDao;
/*    */ 
/* 21 */   public int deleteById(Long id) { this.log.info("FuncCheckerServiceImpl.FuncCheckerService method");
/*    */     try {
/* 23 */       return this.funcCheckerDao.deleteById(id);
/*    */     } catch (Exception e) {
/* 25 */       this.log.error(e.getMessage());
/*    */     }
/* 27 */     return 0;
/*    */   }
/*    */ 
/*    */   public Long insertOrUpdate(FuncRecheck record)
/*    */   {
/* 32 */     this.log.info("FuncCheckerServiceImpl.insert method");
/*    */     try {
/* 34 */       if (record.getId() != null) {
/* 35 */         return this.funcCheckerDao.update(record) > 0 ? record.getId() : null;
/*    */       }
/* 37 */       return this.funcCheckerDao.insert(record);
/*    */     }
/*    */     catch (Exception e) {
/* 40 */       this.log.error(e.getMessage());
/*    */     }
/* 42 */     return null;
/*    */   }
/*    */ 
/*    */   public List<FuncRecheck> selectAll()
/*    */   {
/* 47 */     this.log.info("FuncCheckerServiceImpl.selectAll method");
/*    */     try {
/* 49 */       return this.funcCheckerDao.selectAll();
/*    */     } catch (Exception e) {
/* 51 */       this.log.error(e.getMessage());
/*    */     }
/* 53 */     return null;
/*    */   }
/*    */ 
/*    */   public FuncRecheck selectById(Long id)
/*    */   {
/* 58 */     this.log.info("FuncCheckerServiceImpl.selectById method");
/*    */     try {
/* 60 */       return this.funcCheckerDao.selectById(id);
/*    */     } catch (Exception e) {
/* 62 */       this.log.error(e.getMessage());
/*    */     }
/* 64 */     return null;
/*    */   }
/*    */ 
/*    */   public int update(FuncRecheck record)
/*    */   {
/* 69 */     this.log.info("FuncCheckerServiceImpl.update method");
/*    */     try {
/* 71 */       return this.funcCheckerDao.update(record);
/*    */     } catch (Exception e) {
/* 73 */       this.log.error(e.getMessage());
/*    */     }
/* 75 */     return 0;
/*    */   }
/*    */ 
/*    */   public FuncRecheck selectByFuncCode(String funcCode)
/*    */   {
/* 80 */     this.log.info("FuncCheckerServiceImpl.selectByFuncCode method");
/*    */     try {
/* 82 */       if (StringUtil.isBlank(funcCode)) {
/* 83 */         return null;
/*    */       }
/* 85 */       List list = this.funcCheckerDao.selectByFuncCode(funcCode);
/* 86 */       return list != null ? (FuncRecheck)list.get(0) : null;
/*    */     } catch (Exception e) {
/* 88 */       this.log.error(e.getMessage());
/*    */     }
/* 90 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.FuncRecheckServiceImpl
 * JD-Core Version:    0.6.0
 */