package com.hundsun.network.gates.genshan.biz.service.order;

import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderDetail;
import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderQuery;
import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCashDepositResult;

public abstract interface TradeOrderService
{
  public abstract TradeOrder selectByOrderNo(String paramString);

  public abstract void queryTradeOrder(TradeOrderQuery paramTradeOrderQuery);

  public abstract TradeOrderDetail selectDetailByOrderNo(String paramString);

  public abstract TradeOrderDetail selectBuyerOrderDetailByOrderNo(String paramString1, String paramString2);

  public abstract TradeOrderDetail selectSellerOrderDetailByOrderNo(String paramString1, String paramString2);

  public abstract TradeOrderCashDepositResult queryBuyerOrderCashDeposit(String paramString1, String paramString2);

  public abstract TradeOrderCashDepositResult querySellerOrderCashDeposit(String paramString1, String paramString2);

  public abstract ServiceResult orderConfirm(String paramString1, String paramString2, String paramString3);

  public abstract ServiceResult orderGoodsValidate(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract ServiceResult orderInvoiceValidate(TradeOrderBaseRequest paramTradeOrderBaseRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.order.TradeOrderService
 * JD-Core Version:    0.6.0
 */