/*    */ package com.hundsun.network.gates.genshan.biz.service.baseset.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.SystemDictDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemDict;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemDictQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemDictService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("systemDictService")
/*    */ public class SystemDictServiceImpl
/*    */   implements SystemDictService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemDictDAO systemDictDAO;
/*    */ 
/*    */   public void selectPageList(SystemDictQuery query)
/*    */   {
/* 23 */     this.systemDictDAO.selectPageList(query);
/*    */   }
/*    */ 
/*    */   public List<SystemDict> selectByCond(SystemDictQuery query)
/*    */   {
/* 32 */     return this.systemDictDAO.selectByCond(query);
/*    */   }
/*    */ 
/*    */   public List<SystemDict> checkRepeat(SystemDictQuery query)
/*    */   {
/* 41 */     return this.systemDictDAO.checkRepeat(query);
/*    */   }
/*    */ 
/*    */   public void insert(SystemDict record)
/*    */   {
/* 49 */     this.systemDictDAO.insert(record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(SystemDict record)
/*    */   {
/* 58 */     return this.systemDictDAO.updateByPrimaryKey(record);
/*    */   }
/*    */ 
/*    */   public int updateBySelective(SystemDict record)
/*    */   {
/* 67 */     return this.systemDictDAO.updateBySelective(record);
/*    */   }
/*    */ 
/*    */   public SystemDict selectByPrimaryKey(Long id)
/*    */   {
/* 76 */     return this.systemDictDAO.selectByPrimaryKey(id);
/*    */   }
/*    */ 
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 85 */     return this.systemDictDAO.deleteByPrimaryKey(id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.pojo.SystemDictServiceImpl
 * JD-Core Version:    0.6.0
 */