/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemMemberlevelSetDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemMemberlevelSet;
/*    */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemMemberlevelSetService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemMemberlevelSetService")
/*    */ public class SystemMemberlevelSetServiceImpl
/*    */   implements SystemMemberlevelSetService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemMemberlevelSetDAO systemMemberlevelSetDAO;
/*    */ 
/*    */   public List<SystemMemberlevelSet> selectAll()
/*    */   {
/* 24 */     return this.systemMemberlevelSetDAO.selectAll();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.baseset.SystemMemberlevelSetServiceImpl
 * JD-Core Version:    0.6.0
 */