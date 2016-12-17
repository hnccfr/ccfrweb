/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.TradeScreenDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.TradeScreen;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeScreenQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.project.ScreenDiyService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("screenDiyService")
/*    */ public class ScreenDiyServiceImpl extends BaseService
/*    */   implements ScreenDiyService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeScreenDAO tradeScreenDAO;
/*    */ 
/*    */   public void paginate(TradeScreenQuery<TradeScreen> page)
/*    */   {
/* 20 */     this.tradeScreenDAO.paginate(page);
/*    */   }
/*    */ 
/*    */   public TradeScreen getTradeScreenById(Long id)
/*    */   {
/* 25 */     return this.tradeScreenDAO.getTradeScreenById(id);
/*    */   }
/*    */ 
/*    */   public void delTradeScreenById(Long id)
/*    */   {
/* 30 */     this.tradeScreenDAO.delTradeScreenById(id);
/*    */   }
/*    */ 
/*    */   public Long add(TradeScreen screenDiy)
/*    */   {
/* 35 */     return this.tradeScreenDAO.insert(screenDiy);
/*    */   }
/*    */ 
/*    */   public Integer edit(TradeScreen screenDiy)
/*    */   {
/* 40 */     return this.tradeScreenDAO.edit(screenDiy);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.project.ScreenDiyServiceImpl
 * JD-Core Version:    0.6.0
 */