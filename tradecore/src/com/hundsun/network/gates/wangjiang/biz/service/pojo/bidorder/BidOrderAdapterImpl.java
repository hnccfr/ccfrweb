/*    */ package com.hundsun.network.gates.wangjiang.biz.service.pojo.bidorder;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.service.TradeAdapter;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.BidOrderTradeDTO;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.request.TradeRequest;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.service.RemoteGoldTradeService;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.BidOrderDTO;
/*    */ import com.hundsun.network.gates.wangjiang.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wangjiang.biz.util.ConventUtil;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ 
/*    */ public class BidOrderAdapterImpl extends BaseService
/*    */   implements TradeAdapter<BidOrderDTO>
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RemoteGoldTradeService<BidOrderTradeDTO> remoteGoldTradeService;
/*    */ 
/*    */   public OrderServiceResult bargain(BidOrderDTO bidOrderDTO)
/*    */   {
/* 32 */     OrderServiceResult result = new OrderServiceResult();
/* 33 */     TradeRequest request = new TradeRequest();
/* 34 */     BidOrderTradeDTO bidOrderTradeDTO = ConventUtil.conventBidOrderDTO2BidOrderTradeDTO(bidOrderDTO);
/*    */ 
/* 36 */     request.setTradeDTO(bidOrderTradeDTO);
/*    */ 
/* 38 */     this.remoteGoldTradeService.bargain(request);
/* 39 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.service.pojo.bidorder.BidOrderAdapterImpl
 * JD-Core Version:    0.6.0
 */