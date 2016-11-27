/*     */ package com.hundsun.network.gates.qingbo.biz.service.common;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionLatestStatus;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallBidServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallControlServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserAccountDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLoginRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionFreeBid;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.auction.AuctionCoreService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ 
/*     */ public class AuctionStatusOperate extends BaseService
/*     */ {
/*     */   private AuctionCoreService auctionCoreService;
/*     */   private RemoteUserService remoteUserService;
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   public AuctionStatusOperate(AuctionCoreService auctionCoreService, RemoteUserService remoteUserService, RemoteFundService remoteFundService)
/*     */   {
/*  33 */     this.auctionCoreService = auctionCoreService;
/*  34 */     this.remoteUserService = remoteUserService;
/*  35 */     this.remoteFundService = remoteFundService;
/*     */   }
/*     */ 
/*     */   public String getNextStatus(HallControlServiceRequest request, Map<String, Object> simpleResultMap)
/*     */   {
/*  42 */     String nowStatus = request.getLatestStatus();
/*  43 */     String nextStatus = "";
/*  44 */     String projectCode = request.getProjectCode();
/*  45 */     String haveAuctioneer = simpleResultMap.get("haveAuctioneer").toString();
/*  46 */     String haveReservePrice = simpleResultMap.get("haveReservePrice").toString();
/*  47 */     String supportPriority = simpleResultMap.get("supportPriority").toString();
/*  48 */     Long priorityNum = Long.valueOf(((BigDecimal)simpleResultMap.get("priorityNum")).longValue());
/*     */ 
/*  54 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.A.getValue())) {
/*  55 */       int biddrNum = this.auctionCoreService.selectBidderNumProjectCode(projectCode);
/*  56 */       if (biddrNum < 2) {
/*  57 */         nextStatus = EnumAuctionLatestStatus.Z.getValue();
/*     */       }
/*     */       else {
/*  60 */         nextStatus = EnumAuctionLatestStatus.E.getValue();
/*     */ 
/*  62 */         tradeWishOrderCancel(projectCode);
/*     */       }
/*     */ 
/*  66 */       return nextStatus;
/*     */     }
/*     */ 
/*  70 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.E.getValue())) {
/*  71 */       int recordNum = this.auctionCoreService.getRecordsNumByProjectCode(projectCode);
/*  72 */       if (recordNum == 0)
/*  73 */         nextStatus = EnumAuctionLatestStatus.G1.getValue();
/*     */       else {
/*  75 */         nextStatus = EnumAuctionLatestStatus.G.getValue();
/*     */       }
/*  77 */       return nextStatus;
/*     */     }
/*     */ 
/*  81 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.G.getValue())) {
/*  82 */       nextStatus = EnumAuctionLatestStatus.G1.getValue();
/*  83 */       return nextStatus;
/*     */     }
/*     */ 
/*  88 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.G1.getValue())) {
/*  89 */       nextStatus = EnumAuctionLatestStatus.G2.getValue();
/*  90 */       return nextStatus;
/*     */     }
/*     */ 
/* 106 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.G2.getValue())) {
/* 107 */       int recordNum = this.auctionCoreService.getRecordsNumByProjectCode(projectCode);
/*     */ 
/* 109 */       if ((supportPriority.equalsIgnoreCase("Y")) && (priorityNum.longValue() == 1L) && (recordNum > 0)) {
/* 110 */         AuctionBidder lb = this.auctionCoreService.selectLatestBidder(projectCode);
/* 111 */         if ("Y".equalsIgnoreCase(lb.getIsPriority())) {
/* 112 */           if ((haveAuctioneer.equalsIgnoreCase("Y")) && (haveReservePrice.equalsIgnoreCase("Y")))
/* 113 */             nextStatus = EnumAuctionLatestStatus.P.getValue();
/*     */           else {
/* 115 */             nextStatus = EnumAuctionLatestStatus.Z.getValue();
/*     */           }
/* 117 */           return nextStatus;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 122 */       if ((supportPriority.equalsIgnoreCase("Y")) && (priorityNum.longValue() >= 1L) && (recordNum > 0)) {
/* 123 */         if (haveAuctioneer.equalsIgnoreCase("N"))
/* 124 */           nextStatus = EnumAuctionLatestStatus.L.getValue();
/*     */         else {
/* 126 */           nextStatus = EnumAuctionLatestStatus.K.getValue();
/*     */         }
/* 128 */         return nextStatus;
/*     */       }
/*     */ 
/* 132 */       if ((haveReservePrice.equalsIgnoreCase("Y")) && (haveAuctioneer.equalsIgnoreCase("Y")) && (
/* 133 */         (supportPriority.equalsIgnoreCase("N")) || ((supportPriority.equalsIgnoreCase("Y")) && (priorityNum.longValue() < 1L)) || ((supportPriority.equalsIgnoreCase("Y")) && (priorityNum.longValue() >= 1L) && (recordNum == 0))))
/*     */       {
/* 136 */         nextStatus = EnumAuctionLatestStatus.P.getValue();
/* 137 */         return nextStatus;
/*     */       }
/*     */ 
/* 141 */       if ((haveReservePrice.equalsIgnoreCase("N")) || ((haveReservePrice.equalsIgnoreCase("Y")) && (haveAuctioneer.equalsIgnoreCase("N"))))
/*     */       {
/* 143 */         nextStatus = EnumAuctionLatestStatus.Z.getValue();
/* 144 */         return nextStatus;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 150 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.K.getValue())) {
/* 151 */       int recordNum = this.auctionCoreService.getRecordsNumByProjectCode(projectCode);
/* 152 */       if ((supportPriority.equalsIgnoreCase("Y")) && (priorityNum.longValue() >= 1L) && (haveAuctioneer.equalsIgnoreCase("Y")) && (recordNum > 0))
/*     */       {
/* 154 */         nextStatus = EnumAuctionLatestStatus.L.getValue();
/* 155 */         return nextStatus;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 162 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.L.getValue())) {
/* 163 */       int recordNum = this.auctionCoreService.getRecordsNumByProjectCode(projectCode);
/* 164 */       int priorityRecordsNum = this.auctionCoreService.getPriorityRecordsNumByProjectCode(projectCode);
/* 165 */       if ((supportPriority.equalsIgnoreCase("Y")) && (priorityNum.longValue() >= 1L) && (recordNum > 0)) {
/* 166 */         if (priorityRecordsNum == 0)
/* 167 */           nextStatus = EnumAuctionLatestStatus.M1.getValue();
/*     */         else {
/* 169 */           nextStatus = EnumAuctionLatestStatus.M.getValue();
/*     */         }
/*     */       }
/* 172 */       return nextStatus;
/*     */     }
/*     */ 
/* 176 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.M.getValue())) {
/* 177 */       nextStatus = EnumAuctionLatestStatus.M1.getValue();
/* 178 */       return nextStatus;
/*     */     }
/*     */ 
/* 184 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.M1.getValue())) {
/* 185 */       nextStatus = EnumAuctionLatestStatus.M2.getValue();
/* 186 */       return nextStatus;
/*     */     }
/*     */ 
/* 193 */     if (nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.M2.getValue()))
/*     */     {
/* 195 */       if ((haveAuctioneer.equalsIgnoreCase("Y")) && (haveReservePrice.equalsIgnoreCase("Y"))) {
/* 196 */         nextStatus = EnumAuctionLatestStatus.P.getValue();
/* 197 */         return nextStatus;
/*     */       }
/*     */ 
/* 201 */       if ((haveReservePrice.equalsIgnoreCase("N")) || ((haveReservePrice.equalsIgnoreCase("Y")) && (haveAuctioneer.equalsIgnoreCase("N"))))
/*     */       {
/* 204 */         nextStatus = EnumAuctionLatestStatus.Z.getValue();
/* 205 */         return nextStatus;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 217 */     if ((nowStatus.equalsIgnoreCase(EnumAuctionLatestStatus.P.getValue())) && 
/* 218 */       (haveReservePrice.equalsIgnoreCase("Y")) && (haveAuctioneer.equalsIgnoreCase("Y")))
/*     */     {
/* 220 */       nextStatus = EnumAuctionLatestStatus.Z.getValue();
/* 221 */       return nextStatus;
/*     */     }
/*     */ 
/* 225 */     return nextStatus;
/*     */   }
/*     */ 
/*     */   public void tradeWishOrderCancel(String projectCode)
/*     */   {
/* 237 */     List transRequestList = new ArrayList();
/*     */ 
/* 242 */     List<TradeWishOrder> tradeWishOrderList = this.auctionCoreService.selectBSUListByProjectCode(projectCode);
/*     */ 
/* 244 */     for (TradeWishOrder tradeWishOrder : tradeWishOrderList)
/*     */     {
/* 246 */       if (tradeWishOrder.getDeposit() == null)
/*     */       {
/*     */         continue;
/*     */       }
/* 250 */       Long wishJyDeposit = tradeWishOrder.getDeposit();
/* 251 */       TransRequest wishTransRequest = new TransRequest();
/* 252 */       UserLoginRequest userRequest = new UserLoginRequest();
/* 253 */       userRequest.setUserAccount(tradeWishOrder.getUserAccount());
/* 254 */       UserServiceResult wishUserResult = this.remoteUserService.getUserMsgByAccount(userRequest);
/* 255 */       UserAccountDTO wishUserDTO = wishUserResult.getUserAccountDTO();
/* 256 */       wishTransRequest.setFundAccount(wishUserDTO.getFundAccount());
/* 257 */       wishTransRequest.setOrderProperty(tradeWishOrder.getTradeType());
/* 258 */       wishTransRequest.setAmount(wishJyDeposit);
/* 259 */       wishTransRequest.setBizNo("" + tradeWishOrder.getWishOrderNum());
/* 260 */       wishTransRequest.setOperator("admin");
/* 261 */       wishTransRequest.setMemo("拍卖已开始，还未审核的意向单关闭，退还下单方交易保证金额");
/* 262 */       if (wishJyDeposit.longValue() > 0L) transRequestList.add(wishTransRequest);
/*     */ 
/*     */     }
/*     */ 
/* 266 */     if (transRequestList.size() > 0) {
/* 267 */       FundOperateResult fundOperateResult = this.remoteFundService.cancelFundBatchByTrade(transRequestList);
/* 268 */       if (fundOperateResult.isError()) {
/* 269 */         if (this.log.isErrorEnabled()) this.log.error("调用资金接口 退还挂牌保证金 出错。资金接口返回错误信息：" + fundOperateResult.getErrorInfo());
/* 270 */         return;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 275 */     if (tradeWishOrderList.size() > 0)
/* 276 */       this.auctionCoreService.updateWishOrderStatusBatch(tradeWishOrderList);
/*     */   }
/*     */ 
/*     */   public HallBidServiceRequest determineBidStartPrice(String projectCode)
/*     */   {
/* 289 */     Map auctionHall = this.auctionCoreService.selectSimpleHallForBidByProjectCode(projectCode);
/* 290 */     if ((null == auctionHall) || (StringUtil.isEmpty(auctionHall.get("priceDirection").toString())) || (StringUtil.isEmpty(auctionHall.get("bidStartPrice").toString())))
/*     */     {
/* 292 */       return null;
/*     */     }
/*     */ 
/* 295 */     long priceDirection = Long.parseLong(auctionHall.get("priceDirection").toString());
/* 296 */     long bidStartPrice = Long.parseLong(auctionHall.get("bidStartPrice").toString());
/*     */ 
/* 298 */     AuctionFreeBid auctionFreeBid = new AuctionFreeBid();
/*     */ 
/* 301 */     List list = this.auctionCoreService.selectLastFreeBid(projectCode, Long.valueOf(priceDirection));
/* 302 */     if ((null != list) && (list.size() > 0)) {
/* 303 */       auctionFreeBid = (AuctionFreeBid)list.get(0);
/* 304 */       if ((null == auctionFreeBid) || (null == auctionFreeBid.getPrice())) {
/* 305 */         return null;
/*     */       }
/*     */ 
/* 308 */       if (priceDirection == 1L)
/*     */       {
/* 310 */         Long maxFreePrice = auctionFreeBid.getPrice();
/* 311 */         if (maxFreePrice.longValue() < bidStartPrice)
/* 312 */           return null;
/*     */       }
/*     */       else
/*     */       {
/* 316 */         Long minFreePrice = auctionFreeBid.getPrice();
/* 317 */         if (minFreePrice.longValue() > bidStartPrice) {
/* 318 */           return null;
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 323 */     HallBidServiceRequest request = new HallBidServiceRequest();
/* 324 */     request.setBidderTrademark(auctionFreeBid.getBidderTrademark());
/* 325 */     request.setBidOperatorAccount(auctionFreeBid.getBidOperatorAccount());
/* 326 */     request.setIp(auctionFreeBid.getIp());
/* 327 */     request.setPrice(auctionFreeBid.getPrice());
/* 328 */     request.setProjectCode(auctionFreeBid.getProjectCode());
/* 329 */     request.setUsePriority("N");
/* 330 */     request.setNeedCheckBidRate("N");
/* 331 */     return request;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.common.AuctionStatusOperate
 * JD-Core Version:    0.6.0
 */