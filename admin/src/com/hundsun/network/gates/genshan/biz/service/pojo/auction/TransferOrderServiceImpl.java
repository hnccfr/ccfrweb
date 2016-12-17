/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionResultDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionResult;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.auction.TransferOrderService;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallBidErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDetailDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderService;
/*     */ import com.hundsun.network.melody.common.util.Money;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("transferOrderService")
/*     */ public class TransferOrderServiceImpl extends BaseService
/*     */   implements TransferOrderService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AuctionResultDAO auctionResultDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderDAO tradeWishOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteTradeOrderService remoteTradeOrderService;
/*     */ 
/*     */   public TradeOrderServiceResult endAuctionResult(AuctionResult auctionResult)
/*     */   {
/*  55 */     List tradeWishOrders = this.tradeWishOrderDAO.selectListInTradeByProjectCode(auctionResult.getProjectCode());
/*     */ 
/*  57 */     Map projectListing = this.projectListingDAO.selectByProjectCodeForCancelFund(auctionResult.getProjectCode());
/*  58 */     Map map = new HashMap();
/*     */     try
/*     */     {
/*  62 */       map = getCancelFundListForEnd(auctionResult, tradeWishOrders, projectListing);
/*     */     } catch (Exception e1) {
/*  64 */       if (this.log.isErrorEnabled()) this.log.error("查出需要退还的保证金：", e1);
/*  65 */       e1.printStackTrace();
/*     */     }
/*     */ 
/*  68 */     final AuctionResult resultPara = auctionResult;
/*     */ 
/*  70 */     final List cancelFundList = (List)map.get("list");
/*  71 */     final Long proId = Long.valueOf(projectListing.get("id").toString());
/*  72 */     final TradeWishOrder done = (TradeWishOrder)map.get("done");
/*  73 */     final List tradeWishOrderList = tradeWishOrders;
/*  74 */     TradeOrderServiceResult result = (TradeOrderServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public TradeOrderServiceResult doInTransaction(TransactionStatus status) {
/*  77 */         TradeOrderServiceResult tradeOrderResult = new TradeOrderServiceResult();
/*     */         try
/*     */         {
/*  80 */           TransferOrderServiceImpl.this.auctionResultDAO.insert(resultPara);
/*     */ 
/*  83 */           Map projectMap = new HashMap();
/*  84 */           projectMap.put("status", EnumProjectStatus.OVER.getValue());
/*  85 */           projectMap.put("code", resultPara.getProjectCode());
/*  86 */           projectMap.put("statusWhere", EnumProjectStatus.TRADE.getValue());
/*  87 */           ProjectListing para2 = new ProjectListing();
/*  88 */           para2.setStatus(EnumProjectStatus.OVER.getValue());
/*  89 */           para2.setId(proId);
/*  90 */           TransferOrderServiceImpl.this.projectListingDAO.updateByPrimaryKeySelective(para2);
/*     */ 
/*  97 */           TransferOrderServiceImpl.this.cancelFundBatchByTrade(cancelFundList, resultPara.getProjectCode());
/*     */ 
/* 103 */           TransferOrderServiceImpl.this.tradeWishOrderDAO.updateStatusEndAuctionBatch(tradeWishOrderList);
/*     */ 
/* 105 */           TransferOrderServiceImpl.this.tradeWishOrderDAO.cancelCreateTradeWishOrder(resultPara.getProjectCode());
/*     */ 
/* 108 */           if ("Y".equals(resultPara.getTranResult()))
/*     */           {
/* 110 */             tradeOrderResult = TransferOrderServiceImpl.this.clearOrder(resultPara, done);
/*     */           }
/*     */         }
/*     */         catch (Exception e) {
/* 114 */           e.printStackTrace();
/* 115 */           if (TransferOrderServiceImpl.this.log.isErrorEnabled()) TransferOrderServiceImpl.this.log.error("endAuctionResult error:", e);
/* 116 */           status.setRollbackOnly();
/* 117 */           tradeOrderResult.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.OPERATION_FAILED.getValue()), EnumHallBidErrorNO.OPERATION_FAILED.getName());
/* 118 */           return tradeOrderResult;
/*     */         }
/* 120 */         return tradeOrderResult;
/*     */       }
/*     */     });
/* 125 */     return result;
/*     */   }
/*     */ 
/*     */   private Map<String, Object> getCancelFundListForEnd(AuctionResult auctionResult, List<TradeWishOrder> tradeWishOrderList, Map<String, Object> projectListing) throws Exception
/*     */   {
/* 130 */     Map map = new HashMap();
/* 131 */     List transRequestList = new ArrayList();
/*     */ 
/* 135 */     if ("N".equals(auctionResult.getTranResult()))
/*     */     {
/* 137 */       if ((null == projectListing) || (null == projectListing.get("deposit"))) {
/* 138 */         throw new Exception("获得挂牌方交易保证金额 错误！");
/*     */       }
/* 140 */       Long projectJyDeposit = Long.valueOf(0L);
/* 141 */       Long deposit = Long.valueOf(0L);
/* 142 */       Long quantity = Long.valueOf(0L);
/*     */       try {
/* 144 */         deposit = Long.valueOf(Long.parseLong(projectListing.get("deposit").toString()));
/* 145 */         quantity = Long.valueOf(Long.parseLong(projectListing.get("quantity").toString()));
/* 146 */         projectJyDeposit = Long.valueOf(deposit.longValue() * quantity.longValue());
/*     */       } catch (Exception e) {
/* 148 */         throw new Exception("转换挂牌方交易保证金额 错误！", e);
/*     */       }
/* 150 */       TransRequest transRequest = new TransRequest();
/* 151 */       transRequest.setFundAccount(projectListing.get("fundAccount").toString());
/* 152 */       transRequest.setOrderProperty(projectListing.get("tradingType").toString());
/* 153 */       transRequest.setAmount(projectJyDeposit);
/* 154 */       transRequest.setBizNo(projectListing.get("id").toString());
/* 155 */       transRequest.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 156 */       transRequest.setMemo("项目流拍，退还挂牌方交易保证金额");
/* 157 */       if (projectJyDeposit.longValue() > 0L) transRequestList.add(transRequest);
/*     */     }
/*     */ 
/* 160 */     for (TradeWishOrder tradeWishOrder : tradeWishOrderList)
/*     */     {
/* 162 */       if (null == tradeWishOrder.getDeposit()) {
/* 163 */         throw new Exception("获得下单方交易保证金额 错误！");
/*     */       }
/* 165 */       String memo = "项目流拍，退还报名方交易保证金额";
/* 166 */       boolean needCancel = true;
/*     */ 
/* 169 */       if ("Y".equals(auctionResult.getTranResult())) {
/* 170 */         if (auctionResult.getBidderAccount().equals(tradeWishOrder.getUserAccount())) {
/* 171 */           tradeWishOrder.setStatus(EnumTradeWishOrderStatus.DONE.getValue());
/* 172 */           needCancel = false;
/* 173 */           map.put("done", tradeWishOrder);
/*     */         } else {
/* 175 */           tradeWishOrder.setStatus(EnumTradeWishOrderStatus.UNDONECANCEL.getValue());
/* 176 */           memo = "未成交的报名，退还交易保证金额";
/*     */         }
/*     */       }
/*     */       else {
/* 180 */         tradeWishOrder.setStatus(EnumTradeWishOrderStatus.CANCEL.getValue());
/*     */       }
/*     */ 
/* 183 */       Long wishJyDeposit = tradeWishOrder.getDeposit();
/* 184 */       if ((needCancel) && (wishJyDeposit.longValue() > 0L)) {
/* 185 */         TransRequest wishTransRequest = new TransRequest();
/* 186 */         wishTransRequest.setFundAccount(tradeWishOrder.getFundAccount());
/* 187 */         wishTransRequest.setOrderProperty(projectListing.get("tradingType").toString());
/* 188 */         wishTransRequest.setAmount(wishJyDeposit);
/* 189 */         wishTransRequest.setBizNo(tradeWishOrder.getWishOrderNum());
/* 190 */         wishTransRequest.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 191 */         wishTransRequest.setMemo(memo);
/* 192 */         transRequestList.add(wishTransRequest);
/*     */       }
/*     */     }
/* 195 */     map.put("list", transRequestList);
/* 196 */     return map;
/*     */   }
/*     */ 
/*     */   private void cancelFundBatchByTrade(List<TransRequest> transRequestList, String projectCode)
/*     */   {
/* 201 */     if ((null != transRequestList) && (transRequestList.size() > 0)) {
/* 202 */       FundOperateResult fundOperateResult = this.remoteFundService.cancelFundBatchByTrade(transRequestList);
/* 203 */       if ((fundOperateResult.isError()) && 
/* 204 */         (this.log.isErrorEnabled())) this.log.error("调用资金接口 退还挂牌保证金 出错。资金接口返回错误信息：" + fundOperateResult.getErrorInfo());
/*     */     }
/*     */   }
/*     */ 
/*     */   private TradeOrderServiceResult clearOrder(AuctionResult resultPara, TradeWishOrder done)
/*     */     throws Exception
/*     */   {
/* 211 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/*     */ 
/* 214 */     String projectCode = resultPara.getProjectCode();
/* 215 */     ProjectListing projectListing = this.projectListingDAO.selectByCode(projectCode);
/* 216 */     TradeWishOrder tradeWishOrder = this.tradeWishOrderDAO.selectByPrimaryKey(done.getId());
/* 217 */     TradeOrderRequest request = new TradeOrderRequest();
/* 218 */     TradeOrderDetailDTO tradeOrderDetailDTO = new TradeOrderDetailDTO();
/* 219 */     TradeOrderDTO tradeOrderDTO = new TradeOrderDTO();
/* 220 */     tradeOrderDTO.setSubstationId(projectListing.getSubstationId());
/*     */ 
/* 222 */     tradeOrderDTO.setTradingType(projectListing.getTradingType());
/*     */ 
/* 224 */     tradeOrderDTO.setBidPrice(resultPara.getPrice());
/* 225 */     tradeOrderDTO.setValuationUnit(tradeWishOrder.getValuationUnit());
/* 226 */     tradeOrderDTO.setQuantity(tradeWishOrder.getQuantity());
/* 227 */     tradeOrderDTO.setMeasureUnit(tradeWishOrder.getMeasureUnit());
/*     */ 
/* 229 */     Money orderAmount = new Money();
/* 230 */     orderAmount.setCent(resultPara.getPrice().longValue());
/* 231 */     tradeOrderDTO.setOrderAmount(Long.valueOf(orderAmount.multiply(tradeWishOrder.getQuantity().longValue()).getCent()));
/* 232 */     tradeOrderDTO.setDeliveryType(tradeWishOrder.getDeliveryType());
/* 233 */     tradeOrderDTO.setPaymentType(tradeWishOrder.getPaymentType());
/* 234 */     tradeOrderDTO.setExpectTime(tradeWishOrder.getExpectTime());
/*     */ 
/* 237 */     tradeOrderDTO.setHasInvoice(tradeWishOrder.getIsInvoice());
/*     */ 
/* 239 */     tradeOrderDTO.setProjectCode(tradeWishOrder.getProjectCode());
/* 240 */     tradeOrderDTO.setProjectName(tradeWishOrder.getProjectName());
/*     */ 
/* 242 */     tradeOrderDTO.setCreator(EnumOperatorType.SYSTEM.getValue());
/* 243 */     tradeOrderDTO.setOperator(EnumOperatorType.SYSTEM.getValue());
/*     */ 
/* 245 */     if (EnumListingType.SELL.getValue().equals(projectListing.getListingType()))
/*     */     {
/* 248 */       tradeOrderDTO.setSellerAccount(projectListing.getUserAccount());
/* 249 */       tradeOrderDTO.setBuyerAccount(resultPara.getBidderAccount());
/* 250 */       tradeOrderDetailDTO.setSellerLinkMan(projectListing.getLinkMan());
/* 251 */       tradeOrderDetailDTO.setSellerPhone(projectListing.getPhone());
/* 252 */       tradeOrderDetailDTO.setSellerProvince(projectListing.getProvince());
/* 253 */       tradeOrderDetailDTO.setSellerCity(projectListing.getCity());
/* 254 */       tradeOrderDetailDTO.setSellerArea(projectListing.getArea());
/* 255 */       tradeOrderDetailDTO.setSellerZipCode(projectListing.getZipCode());
/* 256 */       tradeOrderDetailDTO.setSellerAddress(projectListing.getAddress());
/* 257 */       tradeOrderDetailDTO.setSellerName(projectListing.getLinkMan());
/* 258 */       tradeOrderDetailDTO.setStorehouse(projectListing.getStorehouse());
/* 259 */       tradeOrderDetailDTO.setSellerCompany(null);
/*     */ 
/* 261 */       tradeOrderDetailDTO.setBuyerLinkMan(tradeWishOrder.getLinkMan());
/* 262 */       tradeOrderDetailDTO.setBuyerPhone(tradeWishOrder.getPhone());
/* 263 */       tradeOrderDetailDTO.setBuyerProvince(tradeWishOrder.getProvince());
/* 264 */       tradeOrderDetailDTO.setBuyerCity(tradeWishOrder.getCity());
/* 265 */       tradeOrderDetailDTO.setBuyerArea(tradeWishOrder.getArea());
/* 266 */       tradeOrderDetailDTO.setBuyerZipCode(tradeWishOrder.getZipCode());
/* 267 */       tradeOrderDetailDTO.setBuyerAddress(tradeWishOrder.getAddress());
/* 268 */       tradeOrderDetailDTO.setBuyerName(tradeWishOrder.getLinkMan());
/*     */ 
/* 270 */       tradeOrderDetailDTO.setBuyerCompany(null);
/* 271 */       Money money = new Money();
/* 272 */       money.setCent(projectListing.getDeposit().longValue());
/* 273 */       tradeOrderDTO.setSellerDepositAmount(Long.valueOf(money.multiply(tradeWishOrder.getQuantity().longValue()).getCent()));
/* 274 */       tradeOrderDTO.setBuyerDepositAmount(tradeWishOrder.getDeposit());
/*     */     }
/*     */     else
/*     */     {
/* 278 */       tradeOrderDTO.setSellerAccount(tradeWishOrder.getUserAccount());
/* 279 */       tradeOrderDTO.setBuyerAccount(projectListing.getUserAccount());
/* 280 */       tradeOrderDetailDTO.setSellerLinkMan(tradeWishOrder.getLinkMan());
/* 281 */       tradeOrderDetailDTO.setSellerPhone(tradeWishOrder.getPhone());
/* 282 */       tradeOrderDetailDTO.setSellerProvince(tradeWishOrder.getProvince());
/* 283 */       tradeOrderDetailDTO.setSellerCity(tradeWishOrder.getCity());
/* 284 */       tradeOrderDetailDTO.setSellerArea(tradeWishOrder.getArea());
/* 285 */       tradeOrderDetailDTO.setSellerZipCode(tradeWishOrder.getZipCode());
/* 286 */       tradeOrderDetailDTO.setSellerAddress(tradeWishOrder.getAddress());
/* 287 */       tradeOrderDetailDTO.setSellerName(tradeWishOrder.getLinkMan());
/*     */ 
/* 289 */       tradeOrderDetailDTO.setSellerCompany(null);
/*     */ 
/* 291 */       tradeOrderDetailDTO.setBuyerLinkMan(projectListing.getLinkMan());
/* 292 */       tradeOrderDetailDTO.setBuyerPhone(projectListing.getPhone());
/* 293 */       tradeOrderDetailDTO.setBuyerProvince(projectListing.getProvince());
/* 294 */       tradeOrderDetailDTO.setBuyerCity(projectListing.getCity());
/* 295 */       tradeOrderDetailDTO.setBuyerArea(projectListing.getArea());
/* 296 */       tradeOrderDetailDTO.setBuyerZipCode(projectListing.getZipCode());
/* 297 */       tradeOrderDetailDTO.setBuyerAddress(projectListing.getAddress());
/* 298 */       tradeOrderDetailDTO.setBuyerName(projectListing.getLinkMan());
/* 299 */       tradeOrderDetailDTO.setStorehouse(projectListing.getStorehouse());
/* 300 */       tradeOrderDetailDTO.setBuyerCompany(null);
/* 301 */       Money money = new Money();
/* 302 */       money.setCent(projectListing.getDeposit().longValue());
/* 303 */       tradeOrderDTO.setBuyerDepositAmount(Long.valueOf(money.multiply(tradeWishOrder.getQuantity().longValue()).getCent()));
/* 304 */       tradeOrderDTO.setSellerDepositAmount(tradeWishOrder.getDeposit());
/*     */     }
/*     */ 
/* 307 */     tradeOrderDetailDTO.setRemark(tradeWishOrder.getComments());
/* 308 */     tradeOrderDTO.setWishOrderNum(tradeWishOrder.getWishOrderNum());
/* 309 */     tradeOrderDTO.setCreator(EnumOperatorType.SYSTEM.getValue());
/*     */ 
/* 311 */     request.setSellTradeDeposit(tradeOrderDTO.getSellerDepositAmount());
/* 312 */     request.setBuyTradeDeposit(tradeOrderDTO.getBuyerDepositAmount());
/*     */ 
/* 314 */     request.setTradeOrderDTO(tradeOrderDTO);
/* 315 */     request.setTradeOrderDetailDTO(tradeOrderDetailDTO);
/*     */ 
/* 317 */     request.setOperator(EnumOperatorType.SYSTEM.getValue());
/*     */     try {
/* 319 */       result = this.remoteTradeOrderService.initAddOrder(request);
/*     */     } catch (Exception e) {
/* 321 */       this.log.error("remoteTradeOrderService.initAddOrder error:", e);
/* 322 */       result.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.SERVER_ERROR.getValue()), EnumHallErrorNO.SERVER_ERROR.getName());
/* 323 */       throw new Exception("remoteTradeOrderService.initAddOrder() error");
/*     */     }
/* 325 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.auction.TransferOrderServiceImpl
 * JD-Core Version:    0.6.0
 */