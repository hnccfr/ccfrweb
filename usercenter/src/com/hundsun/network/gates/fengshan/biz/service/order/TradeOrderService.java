package com.hundsun.network.gates.fengshan.biz.service.order;

import com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics;
import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder;
import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderAndPro;
import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderDetail;
import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderMoney;
import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderQuery;
import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.request.UserCreditRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCashDepositResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.UserCreditServiceResult;
import java.util.List;
import java.util.Map;

public abstract interface TradeOrderService
{
  public abstract TradeOrder selectByOrderNo(String paramString);

  public abstract void queryTradeOrder(TradeOrderQuery paramTradeOrderQuery);

  public abstract TradeOrderDetail selectDetailByOrderNo(String paramString);

  public abstract TradeOrderDetail selectBuyerOrderDetailByOrderNo(String paramString1, String paramString2);

  public abstract TradeOrderDetail selectSellerOrderDetailByOrderNo(String paramString1, String paramString2);

  public abstract TradeOrderCashDepositResult queryBuyerOrderCashDeposit(String paramString1, String paramString2);

  public abstract TradeOrderCashDepositResult querySellerOrderCashDeposit(String paramString1, String paramString2);

  public abstract ServiceResult orderConfirm(TradeOrderRequest paramTradeOrderRequest);

  public abstract ServiceResult orderPay(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract ServiceResult orderSendGoods(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract TradeOrderGoodAmountServiceResult orderGoodsValidate(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract TradeOrderGoodAmountServiceResult orderInvoiceValidate(TradeOrderBaseRequest paramTradeOrderBaseRequest);

  public abstract UserCreditServiceResult evaluateUser(UserCreditRequest paramUserCreditRequest);

  public abstract TradeOrderMoney queryTradeOrderMoneyByAccountOrderNo(String paramString1, String paramString2);

  public abstract List<TradeOrderAndPro> selectLatestOrder(Integer paramInteger, String paramString);

  public abstract Map<String, List<TradeOrderAndPro>> selectLatestOrder(Integer paramInteger);

  public abstract List<DateStatistics> queryProjectListingByDate(EnumDateStatisticsType paramEnumDateStatisticsType, Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderService
 * JD-Core Version:    0.6.0
 */