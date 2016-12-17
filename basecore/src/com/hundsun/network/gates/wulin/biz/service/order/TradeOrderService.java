package com.hundsun.network.gates.wulin.biz.service.order;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCashDepositRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCashDepositResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderFinishedServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderAndPro;
import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderDetail;
import java.util.List;
import java.util.Map;

public abstract interface TradeOrderService
{
  public abstract TradeOrderServiceResult initAddOrder(TradeOrder paramTradeOrder, TradeOrderDetail paramTradeOrderDetail, String paramString, Long paramLong1, Long paramLong2);

  public abstract TradeOrderServiceResult rollbackOrder(TradeOrderRequest paramTradeOrderRequest);

  public abstract TradeOrderCashDepositResult queryOrderCashDeposit(TradeOrderCashDepositRequest paramTradeOrderCashDepositRequest);

  public abstract ServiceResult orderConfirm(TradeOrderRequest paramTradeOrderRequest);

  public abstract TradeOrder selectByOrderNo(String paramString);

  public abstract TradeOrderDetail selectDetailByOrderNo(String paramString);

  public abstract int updateParamByOrderNo(Map<String, Object> paramMap, String paramString);

  public abstract ServiceResult orderPay(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract ServiceResult orderSendGoods(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract TradeOrderGoodAmountServiceResult orderGoodsValidate(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract TradeOrderGoodAmountServiceResult orderInvoiceValidate(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract TradeOrderFinishedServiceResult orderClose(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract List<TradeOrderAndPro> selectLatestOrder(int paramInt, String paramString);

  public abstract TradeOrderGoodAmountServiceResult penaltyCheckGoods(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract TradeOrderGoodAmountServiceResult penaltyCheckTicket(TradeOrderBaseRequest paramTradeOrderBaseRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService
 * JD-Core Version:    0.6.0
 */