/*     */ package com.hundsun.network.gates.qingbo.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionLatestStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.service.RemoteAuctionCoreService;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallBidErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallControlErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionResultServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallBidServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallControlServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallDataServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.service.RemoteAuctionService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLog;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionResult;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.auction.AuctionCoreService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.common.AuctionStatusOperate;
/*     */ import com.hundsun.network.gates.qingbo.biz.util.ConvertUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.codehaus.jackson.map.ObjectMapper;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.util.Assert;
/*     */ 
/*     */ @Service("remoteAuctionCoreService")
/*     */ public class RemoteAuctionCoreServiceImpl extends BaseService
/*     */   implements RemoteAuctionCoreService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AuctionCoreService auctionCoreService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteAuctionService remoteAuctionService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   public ServiceResult auctioneerDo(HallControlServiceRequest request)
/*     */   {
/*  67 */     ServiceResult result = new ServiceResult();
/*     */     try
/*     */     {
/*  72 */       if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/*  73 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/*  74 */         return result;
/*     */       }
/*  76 */       if ((null == request) || (StringUtil.isEmpty(request.getLatestStatus()))) {
/*  77 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_NEXTSTATUS_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_NEXTSTATUS_NULL.getName());
/*  78 */         return result;
/*     */       }
/*     */ 
/*  85 */       Map simpleResultMap = this.auctionCoreService.selectSimpleHallByProjectCode(request.getProjectCode());
/*  86 */       if (null == simpleResultMap) {
/*  87 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.HALL_ERROR.getValue()), EnumHallControlErrorNO.HALL_ERROR.getName());
/*  88 */         return result;
/*     */       }
/*  90 */       String haveAuctioneer = simpleResultMap.get("haveAuctioneer") == null ? "N" : simpleResultMap.get("haveAuctioneer").toString();
/*  91 */       if ((haveAuctioneer.equalsIgnoreCase("Y")) && (StringUtil.isEmpty(request.getUserAccount()))) {
/*  92 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/*  93 */         return result;
/*     */       }
/*     */ 
/*  98 */       if ((haveAuctioneer.equalsIgnoreCase("Y")) && (!simpleResultMap.get("auctioneerAccount").equals(request.getUserAccount()))) {
/*  99 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.AUCTIONEER_ERROR.getValue()), EnumHallControlErrorNO.AUCTIONEER_ERROR.getName());
/* 100 */         return result;
/*     */       }
/*     */ 
/* 107 */       String nowStatus = request.getLatestStatus();
/* 108 */       AuctionLatestBid latestBid = this.auctionCoreService.selectLatestBidByProjectCode(request.getProjectCode());
/* 109 */       if ((null == latestBid) || (StringUtil.isEmpty(latestBid.getLatestStatus()))) {
/* 110 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.INTERNAL_ERROR.getValue()), EnumHallControlErrorNO.INTERNAL_ERROR.getName());
/* 111 */         return result;
/*     */       }
/* 113 */       if (!nowStatus.equalsIgnoreCase(latestBid.getLatestStatus())) {
/* 114 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_LSTATUS_ERROR.getValue()), EnumHallControlErrorNO.PARAMETER_LSTATUS_ERROR.getName());
/* 115 */         return result;
/*     */       }
/* 117 */       AuctionStatusOperate statusOp = new AuctionStatusOperate(this.auctionCoreService, this.remoteUserService, this.remoteFundService);
/* 118 */       String nextStatus = statusOp.getNextStatus(request, simpleResultMap);
/* 119 */       if (this.log.isDebugEnabled()) {
/* 120 */         this.log.debug(new StringBuilder().append("========下一状态：").append(nextStatus).toString());
/*     */       }
/*     */ 
/* 127 */       Map paraMap = new HashMap();
/* 128 */       paraMap.put("projectCode", request.getProjectCode());
/* 129 */       paraMap.put("nowStatus", nextStatus);
/* 130 */       paraMap.put("beforeStatus", nowStatus);
/*     */ 
/* 132 */       if (haveAuctioneer.equalsIgnoreCase("N")) {
/* 133 */         Long bidLimitedPeriod = Long.valueOf(simpleResultMap.get("bidLimitedPeriod") == null ? 30L : Long.parseLong(simpleResultMap.get("bidLimitedPeriod").toString()));
/* 134 */         if ((nextStatus.equalsIgnoreCase(EnumAuctionLatestStatus.E.getValue())) || (nextStatus.equalsIgnoreCase(EnumAuctionLatestStatus.L.getValue()))) {
/* 135 */           bidLimitedPeriod = Long.valueOf(bidLimitedPeriod.longValue() + (simpleResultMap.get("firstWaitTime") == null ? 120L : Long.parseLong(simpleResultMap.get("firstWaitTime").toString())));
/*     */         }
/* 137 */         paraMap.put("bidLimitedPeriod", new StringBuilder().append(bidLimitedPeriod).append("").toString());
/*     */       }
/*     */ 
/* 140 */       int num = this.auctionCoreService.updateLatestStatus(paraMap);
/* 141 */       if (num == 0) {
/* 142 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.OPERATION_FAILED.getValue()), EnumHallControlErrorNO.OPERATION_FAILED.getName());
/* 143 */         return result;
/*     */       }
/*     */ 
/* 147 */       AuctionLog acutonLog = new AuctionLog();
/* 148 */       acutonLog.setProjectCode(request.getProjectCode());
/* 149 */       acutonLog.setBeforeStatus(nowStatus);
/* 150 */       acutonLog.setNewStatus(nextStatus);
/*     */ 
/* 152 */       ObjectMapper mapper = new ObjectMapper();
/*     */       try {
/* 154 */         acutonLog.setDataJson(mapper.writeValueAsString(latestBid));
/*     */       } catch (Exception e) {
/* 156 */         if (this.log.isErrorEnabled()) this.log.error("auctioneerDo,convert auctionLatestBid object to json string error", e);
/*     */       }
/* 158 */       String remark = "Y".equalsIgnoreCase(haveAuctioneer) ? "拍卖师操作" : "系统";
/* 159 */       acutonLog.setRemark(new StringBuilder().append(remark).append("控制拍卖流程").toString());
/* 160 */       acutonLog.setOperator("Y".equalsIgnoreCase(haveAuctioneer) ? request.getUserAccount() : EnumOperatorType.SYSTEM.getValue());
/* 161 */       acutonLog.setOperatorType("Y".equalsIgnoreCase(haveAuctioneer) ? EnumOperatorType.AUCTIONEER.getValue() : EnumOperatorType.SYSTEM.getValue());
/* 162 */       this.auctionCoreService.insertLog(acutonLog);
/*     */ 
/* 165 */       sendAuctionLatestBid(request.getProjectCode());
/* 166 */       if (nextStatus.equalsIgnoreCase(EnumAuctionLatestStatus.Z.getValue())) {
/* 167 */         endAuctionResult(request.getProjectCode());
/*     */       }
/*     */ 
/* 171 */       if (nextStatus.equalsIgnoreCase(EnumAuctionLatestStatus.E.getValue())) {
/* 172 */         HallBidServiceRequest bidRequest = statusOp.determineBidStartPrice(request.getProjectCode());
/* 173 */         if (null != bidRequest)
/* 174 */           bidderDid(bidRequest);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 179 */       e.printStackTrace();
/* 180 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.SERVER_ERROR.getValue()), EnumHallControlErrorNO.SERVER_ERROR.getName());
/*     */     }
/*     */ 
/* 183 */     return result;
/*     */   }
/*     */ 
/*     */   private void sendAuctionLatestBid(String projectCode)
/*     */   {
/* 193 */     Assert.notNull(projectCode, "projectCode is null");
/* 194 */     final String proCode = projectCode;
/*     */ 
/* 196 */     ExecutorService pool = Executors.newSingleThreadExecutor();
/* 197 */     pool.execute(new Thread(proCode)
/*     */     {
/*     */       public void run() {
/* 200 */         HallDataServiceRequest request = new HallDataServiceRequest();
/*     */ 
/* 202 */         AuctionLatestBid auctionLatestBid = RemoteAuctionCoreServiceImpl.this.auctionCoreService.selectLatestBidByProjectCode(proCode);
/* 203 */         if (null == auctionLatestBid) {
/* 204 */           if (RemoteAuctionCoreServiceImpl.this.log.isErrorEnabled()) RemoteAuctionCoreServiceImpl.this.log.error("auctionLatestBid is not exist");
/* 205 */           return;
/*     */         }
/* 207 */         request.setAuctionLatestBidDTO(ConvertUtils.convertauctionLatestBid2DTO(auctionLatestBid));
/*     */         try
/*     */         {
/* 210 */           RemoteAuctionCoreServiceImpl.this.remoteAuctionService.sendAuctionLatestBid(request);
/*     */         } catch (Exception e) {
/* 212 */           if (RemoteAuctionCoreServiceImpl.this.log.isErrorEnabled()) RemoteAuctionCoreServiceImpl.this.log.error("remote sendAuctionLatestBid error", e);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerUpdateBidRate(HallControlServiceRequest request)
/*     */   {
/* 223 */     ServiceResult result = new ServiceResult();
/*     */     try
/*     */     {
/* 229 */       if ((null == request) || (StringUtil.isEmpty(request.getUserAccount()))) {
/* 230 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/* 231 */         return result;
/*     */       }
/* 233 */       if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/* 234 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/* 235 */         return result;
/*     */       }
/* 237 */       if ((null == request) || (null == request.getBidRate())) {
/* 238 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_BIDRATE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_BIDRATE_NULL.getName());
/* 239 */         return result;
/*     */       }
/*     */ 
/* 246 */       Map simpleResultMap = this.auctionCoreService.selectSimpleHallByProjectCode(request.getProjectCode());
/* 247 */       if ((null == simpleResultMap) || (StringUtil.isEmpty(simpleResultMap.get("auctioneerAccount").toString()))) {
/* 248 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.HALL_ERROR.getValue()), EnumHallControlErrorNO.HALL_ERROR.getName());
/* 249 */         return result;
/*     */       }
/*     */ 
/* 252 */       if (!simpleResultMap.get("auctioneerAccount").equals(request.getUserAccount())) {
/* 253 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.AUCTIONEER_ERROR.getValue()), EnumHallControlErrorNO.AUCTIONEER_ERROR.getName());
/* 254 */         return result;
/*     */       }
/*     */ 
/* 259 */       Map latestStatus = this.auctionCoreService.selectCurrStatusByProjectCode(request.getProjectCode());
/* 260 */       if ((null == latestStatus) || (StringUtil.isEmpty((String)latestStatus.get("latestStatus")))) {
/* 261 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.INTERNAL_ERROR.getValue()), EnumHallControlErrorNO.INTERNAL_ERROR.getName());
/* 262 */         return result;
/*     */       }
/*     */ 
/* 268 */       Map paraMap = new HashMap();
/* 269 */       paraMap.put("projectCode", request.getProjectCode());
/* 270 */       paraMap.put("bidRate", request.getBidRate());
/* 271 */       int num = this.auctionCoreService.updateBidRate(paraMap);
/* 272 */       if (num == 0) {
/* 273 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.OPERATION_FAILED.getValue()), EnumHallControlErrorNO.OPERATION_FAILED.getName());
/* 274 */         return result;
/*     */       }
/*     */ 
/* 278 */       AuctionLog acutonLog = new AuctionLog();
/* 279 */       acutonLog.setProjectCode(request.getProjectCode());
/* 280 */       acutonLog.setBeforeStatus((String)latestStatus.get("latestStatus"));
/* 281 */       acutonLog.setNewStatus((String)latestStatus.get("latestStatus"));
/* 282 */       String dataJsonString = new StringBuilder().append("{项目编号").append(request.getProjectCode()).append(":,拍卖师:").append(request.getUserAccount()).append(",竞价幅度:").append(request.getBidRate()).append("分}").toString();
/*     */ 
/* 284 */       acutonLog.setDataJson(dataJsonString);
/* 285 */       acutonLog.setRemark("拍卖师修改报价幅度");
/* 286 */       acutonLog.setOperator(request.getUserAccount());
/* 287 */       acutonLog.setOperatorType(EnumOperatorType.AUCTIONEER.getValue());
/* 288 */       this.auctionCoreService.insertLog(acutonLog);
/*     */ 
/* 291 */       sendAuctionLatestBid(request.getProjectCode());
/*     */     } catch (Exception e) {
/* 293 */       e.printStackTrace();
/* 294 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.SERVER_ERROR.getValue()), EnumHallControlErrorNO.SERVER_ERROR.getName());
/*     */     }
/* 296 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerSetReservePrice(HallControlServiceRequest request)
/*     */   {
/* 304 */     ServiceResult result = new ServiceResult();
/*     */ 
/* 306 */     if ((null == request) || (StringUtil.isEmpty(request.getUserAccount()))) {
/* 307 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/*     */ 
/* 310 */       return result;
/*     */     }
/* 312 */     if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/* 313 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/*     */ 
/* 316 */       return result;
/*     */     }
/* 318 */     if ((null == request) || (null == request.getReservePrice())) {
/* 319 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_RESERVEPRICE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_RESERVEPRICE_NULL.getName());
/*     */ 
/* 322 */       return result;
/*     */     }
/*     */ 
/* 327 */     Map simpleResultMap = this.auctionCoreService.selectSimpleHallByProjectCode(request.getProjectCode());
/* 328 */     if ((null == simpleResultMap) || (StringUtil.isEmpty(simpleResultMap.get("auctioneerAccount").toString()))) {
/* 329 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.HALL_ERROR.getValue()), EnumHallControlErrorNO.HALL_ERROR.getName());
/* 330 */       return result;
/*     */     }
/*     */ 
/* 335 */     if (!simpleResultMap.get("auctioneerAccount").equals(request.getUserAccount())) {
/* 336 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.AUCTIONEER_ERROR.getValue()), EnumHallControlErrorNO.AUCTIONEER_ERROR.getName());
/* 337 */       return result;
/*     */     }
/*     */ 
/* 343 */     AuctionLatestBid latestBid = this.auctionCoreService.selectLatestBidByProjectCode(request.getProjectCode());
/* 344 */     if (null == latestBid) {
/* 345 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.INTERNAL_ERROR.getValue()), EnumHallControlErrorNO.INTERNAL_ERROR.getName());
/* 346 */       return result;
/*     */     }
/* 348 */     String nowStatus = latestBid.getLatestStatus();
/* 349 */     if (!EnumAuctionLatestStatus.P.getValue().equals(nowStatus)) {
/* 350 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.NEXTSTATUS_ERROR.getValue()), EnumHallControlErrorNO.NEXTSTATUS_ERROR.getName());
/* 351 */       return result;
/*     */     }
/*     */ 
/* 358 */     result = this.auctionCoreService.auctioneerSetReservePrice(request, latestBid);
/*     */ 
/* 361 */     if (result.correct()) {
/* 362 */       sendAuctionLatestBid(request.getProjectCode());
/* 363 */       endAuctionResult(request.getProjectCode());
/*     */     }
/*     */ 
/* 366 */     return result;
/*     */   }
/*     */ 
/*     */   private void endAuctionResult(String projectCode)
/*     */   {
/* 375 */     Assert.notNull(projectCode, "projectCode is null");
/* 376 */     final String proCode = projectCode;
/*     */ 
/* 378 */     ExecutorService pool = Executors.newSingleThreadExecutor();
/* 379 */     pool.execute(new Thread(proCode)
/*     */     {
/*     */       public void run()
/*     */       {
/* 383 */         AuctionLatestBid auctionLatestBid = RemoteAuctionCoreServiceImpl.this.auctionCoreService.selectLatestBidByProjectCode(proCode);
/* 384 */         if (null == auctionLatestBid) {
/* 385 */           if (RemoteAuctionCoreServiceImpl.this.log.isErrorEnabled()) RemoteAuctionCoreServiceImpl.this.log.error("auctionLatestBid is not exist");
/* 386 */           return;
/*     */         }
/*     */ 
/* 389 */         Map auctionHall = RemoteAuctionCoreServiceImpl.this.auctionCoreService.selectSimpleHallForEndByProjectCode(proCode);
/* 390 */         if ((null == auctionHall) || ((null != auctionHall.get("haveReservePrice")) && (StringUtil.isEmpty(auctionHall.get("haveReservePrice").toString())))) {
/* 391 */           if (RemoteAuctionCoreServiceImpl.this.log.isErrorEnabled()) RemoteAuctionCoreServiceImpl.this.log.error("auctionHall is not exist");
/* 392 */           return;
/*     */         }
/*     */ 
/* 396 */         AuctionResult auctionResult = RemoteAuctionCoreServiceImpl.this.checkAuctionResult(auctionLatestBid, auctionHall);
/*     */ 
/* 399 */         TradeOrderServiceResult result = new TradeOrderServiceResult();
/* 400 */         result = RemoteAuctionCoreServiceImpl.this.auctionCoreService.endAuctionResult(auctionResult);
/*     */ 
/* 403 */         if (result.correct()) {
/* 404 */           AuctionResultServiceRequest request = new AuctionResultServiceRequest();
/* 405 */           request.setTranResult(auctionResult.getTranResult());
/* 406 */           request.setProjectCode(auctionResult.getProjectCode());
/* 407 */           if ("Y".equals(auctionResult.getTranResult())) {
/* 408 */             request.setBidderTrademark(auctionResult.getBidderTrademark());
/* 409 */             request.setPrice(auctionResult.getPrice());
/* 410 */             request.setOrderNo(result.getOrderNo());
/*     */           }
/*     */           try {
/* 413 */             RemoteAuctionCoreServiceImpl.this.remoteAuctionService.sendAuctionResult(request);
/*     */           } catch (Exception e) {
/* 415 */             if (RemoteAuctionCoreServiceImpl.this.log.isErrorEnabled()) RemoteAuctionCoreServiceImpl.this.log.error("endAuctionResult remote error");
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private AuctionResult checkAuctionResult(AuctionLatestBid auctionLatestBid, Map<String, Object> auctionHall)
/*     */   {
/* 428 */     AuctionResult auctionResult = new AuctionResult();
/* 429 */     auctionResult.setProjectCode(auctionLatestBid.getProjectCode());
/* 430 */     auctionResult.setValuationUnit(auctionHall.get("valuationUnit").toString());
/* 431 */     auctionResult.setEndTime(Calendar.getInstance().getTime());
/*     */ 
/* 433 */     if (null == auctionHall.get("auctioneerAccount")) {
/* 434 */       auctionResult.setOperator(EnumOperatorType.SYSTEM.getValue());
/*     */     } else {
/* 436 */       auctionResult.setAuctioneerAccount(auctionHall.get("auctioneerAccount").toString());
/* 437 */       auctionResult.setOperator(EnumOperatorType.AUCTIONEER.getValue());
/*     */     }
/* 439 */     String tranResult = "Y";
/* 440 */     String remark = "";
/* 441 */     String haveReservePrice = auctionHall.get("haveReservePrice").toString();
/* 442 */     if ((null == auctionLatestBid.getLatestBid()) || (auctionLatestBid.getLatestBid().longValue() == 0L)) {
/* 443 */       tranResult = "N";
/*     */ 
/* 445 */       int bidderNum = this.auctionCoreService.selectBidderNumProjectCode(auctionLatestBid.getProjectCode());
/* 446 */       remark = bidderNum > 1 ? "无人报价， 流拍" : "有效竞价人小于2人，流拍";
/* 447 */     } else if ("N".equals(haveReservePrice)) {
/* 448 */       tranResult = "Y";
/* 449 */       remark = new StringBuilder().append(auctionLatestBid.getBidderTrademark()).append("号 成交").toString();
/*     */     } else {
/* 451 */       long latestBid = auctionLatestBid.getLatestBid().longValue();
/* 452 */       long reservePrice = Long.parseLong(auctionHall.get("reservePrice").toString());
/* 453 */       long priceDirection = Long.parseLong(auctionHall.get("priceDirection").toString());
/* 454 */       long rate = latestBid - reservePrice;
/* 455 */       if (rate * priceDirection < 0L) {
/* 456 */         tranResult = "N";
/* 457 */         remark = "最后出价未优于保留价， 流拍";
/*     */       } else {
/* 459 */         tranResult = "Y";
/* 460 */         remark = new StringBuilder().append("最后出价优于保留价， ").append(auctionLatestBid.getBidderTrademark()).append("号 成交").toString();
/*     */       }
/*     */     }
/* 463 */     auctionResult.setTranResult(tranResult);
/* 464 */     auctionResult.setRemark(remark);
/* 465 */     if ("Y".equals(tranResult)) {
/* 466 */       auctionResult.setPrice(auctionLatestBid.getLatestBid());
/* 467 */       AuctionBidder auctionBidder = this.auctionCoreService.selectBidderByBidderTrademarkAndProjectCode(auctionLatestBid.getProjectCode(), auctionLatestBid.getBidderTrademark());
/* 468 */       auctionResult.setBidderAccount(auctionBidder.getBidderAccount());
/* 469 */       auctionResult.setBidderTrademark(auctionLatestBid.getBidderTrademark());
/*     */     }
/*     */ 
/* 472 */     return auctionResult;
/*     */   }
/*     */ 
/*     */   public ServiceResult bidderDid(HallBidServiceRequest request)
/*     */   {
/* 480 */     ServiceResult result = new ServiceResult();
/*     */ 
/* 482 */     if ((null == request) || (StringUtil.isEmpty(request.getBidOperatorAccount()))) {
/* 483 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_BIDOPERATORACCOUNT_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_BIDOPERATORACCOUNT_NULL.getName());
/*     */ 
/* 486 */       return result;
/*     */     }
/* 488 */     if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/* 489 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/*     */ 
/* 492 */       return result;
/*     */     }
/* 494 */     if ((null == request) || (StringUtil.isEmpty(request.getBidderTrademark()))) {
/* 495 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_BIDDERTRADEMARK_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_BIDDERTRADEMARK_NULL.getName());
/*     */ 
/* 498 */       return result;
/*     */     }
/* 500 */     if ((null == request) || (null == request.getPrice())) {
/* 501 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_PRICE_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_PRICE_NULL.getName());
/*     */ 
/* 504 */       return result;
/*     */     }
/* 506 */     if (request.getPrice().longValue() <= 0L) {
/* 507 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_PRICE_ERROR.getValue()), EnumHallBidErrorNO.PARAMETER_PRICE_ERROR.getName());
/*     */ 
/* 510 */       return result;
/*     */     }
/* 512 */     if ((null == request) || (StringUtil.isEmpty(request.getIp()))) {
/* 513 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_IP_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_IP_NULL.getName());
/*     */ 
/* 516 */       return result;
/*     */     }
/*     */ 
/* 521 */     AuctionLatestBid latestBid = this.auctionCoreService.selectLatestBidByProjectCode(request.getProjectCode());
/* 522 */     if (null == latestBid) {
/* 523 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.HALL_ERROR.getValue()), EnumHallBidErrorNO.HALL_ERROR.getName());
/* 524 */       return result;
/*     */     }
/*     */ 
/* 527 */     AuctionBidder bidder = this.auctionCoreService.selectBidderByBidAccountAndProjectCode(request.getBidOperatorAccount(), request.getProjectCode());
/* 528 */     if (null == bidder) {
/* 529 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.AUCTIONEER_ERROR.getValue()), EnumHallBidErrorNO.AUCTIONEER_ERROR.getName());
/* 530 */       return result;
/*     */     }
/*     */ 
/* 533 */     EnumAuctionLatestStatus nowStatusEnum = EnumAuctionLatestStatus.indexByValue(latestBid.getLatestStatus());
/* 534 */     if ("Y".equals(request.getUsePriority()))
/*     */     {
/* 536 */       if (!isCanUsePriority(nowStatusEnum)) {
/* 537 */         result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.NEXTSTATUS_ERROR.getValue()), EnumHallBidErrorNO.NEXTSTATUS_ERROR.getName());
/* 538 */         return result;
/*     */       }
/* 540 */       if (!"Y".equals(bidder.getIsPriority())) {
/* 541 */         result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.USE_PRIORITY_ERROR.getValue()), EnumHallBidErrorNO.USE_PRIORITY_ERROR.getName());
/* 542 */         return result;
/*     */       }
/*     */ 
/* 546 */       if (!latestBid.getBidderTrademark().equals(latestBid.getLastBidTrademark())) {
/* 547 */         result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PRIORITY_ADD_PRIORITY_ERROR.getValue()), EnumHallBidErrorNO.PRIORITY_ADD_PRIORITY_ERROR.getName());
/* 548 */         return result;
/*     */       }
/*     */ 
/* 554 */       AuctionBidder lastBidder = this.auctionCoreService.selectBidderByBidderTrademarkAndProjectCode(request.getProjectCode(), latestBid.getLastBidTrademark());
/* 555 */       if ("Y".equals(lastBidder.getIsPriority())) {
/* 556 */         result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PRIORITY_ADD_PRIORITY_ERROR.getValue()), EnumHallBidErrorNO.PRIORITY_ADD_PRIORITY_ERROR.getName());
/* 557 */         return result;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 562 */       if (!isCanBid(nowStatusEnum)) {
/* 563 */         result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.NEXTSTATUS_ERROR.getValue()), EnumHallBidErrorNO.NEXTSTATUS_ERROR.getName());
/* 564 */         return result;
/*     */       }
/*     */ 
/* 567 */       if ((isCanUsePriority(nowStatusEnum)) && 
/* 568 */         (!"Y".equals(bidder.getIsPriority())) && (!bidder.getBidderTrademark().equals(latestBid.getLastBidTrademark()))) {
/* 569 */         result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.BID_IN_PRIORITY_ERROR.getValue()), EnumHallBidErrorNO.BID_IN_PRIORITY_ERROR.getName());
/* 570 */         return result;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 576 */     Map auctionHall = this.auctionCoreService.selectSimpleHallForBidByProjectCode(request.getProjectCode());
/* 577 */     if ((null == auctionHall) || (StringUtil.isEmpty(auctionHall.get("priceDirection").toString())) || (StringUtil.isEmpty(auctionHall.get("bidStartPrice").toString())))
/*     */     {
/* 579 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.HALL_ERROR.getValue()), EnumHallBidErrorNO.HALL_ERROR.getName());
/* 580 */       return result;
/*     */     }
/* 582 */     long priceDirection = Long.parseLong(auctionHall.get("priceDirection").toString());
/*     */ 
/* 584 */     long latestBidPrice = latestBid.getLatestBid().longValue() == 0L ? Long.parseLong(auctionHall.get("bidStartPrice").toString()) : latestBid.getLatestBid().longValue();
/*     */ 
/* 586 */     long rate = request.getPrice().longValue() - latestBidPrice;
/*     */ 
/* 588 */     if (rate * priceDirection < 0L) {
/* 589 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PRICE_NOT_BETTER_ERROR.getValue()), EnumHallBidErrorNO.PRICE_NOT_BETTER_ERROR.getName());
/* 590 */       return result;
/*     */     }
/* 592 */     if ((null == request.getNeedCheckBidRate()) || (!"N".equals(request.getNeedCheckBidRate())))
/*     */     {
/* 597 */       if ((latestBid.getBidRate() != null) && (latestBid.getBidRate().longValue() != 0L) && (rate % latestBid.getBidRate().longValue() != 0L))
/*     */       {
/* 600 */         result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PRICE_RATE_ERROR.getValue()), EnumHallBidErrorNO.PRICE_RATE_ERROR.getName());
/* 601 */         return result;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 607 */     String nextStatus = isNormalMission(nowStatusEnum) ? EnumAuctionLatestStatus.G.getValue() : EnumAuctionLatestStatus.M.getValue();
/*     */ 
/* 610 */     AuctionLatestBid auctionLatestBidPara = new AuctionLatestBid();
/* 611 */     auctionLatestBidPara.setProjectCode(request.getProjectCode());
/* 612 */     auctionLatestBidPara.setBidderTrademark(request.getBidderTrademark());
/* 613 */     auctionLatestBidPara.setLatestBid(request.getPrice());
/* 614 */     auctionLatestBidPara.setIsPriority(request.getUsePriority());
/*     */ 
/* 617 */     auctionLatestBidPara.setLatestStatus(nextStatus);
/* 618 */     auctionLatestBidPara.setBeforeStatus(nowStatusEnum.getValue());
/* 619 */     auctionLatestBidPara.setPriceDirection(Long.valueOf(priceDirection));
/*     */ 
/* 622 */     Long bidLimitedPeriod = null;
/*     */     try {
/* 624 */       if (StringUtil.isNotEmpty(auctionHall.get("bidLimitedPeriod").toString()))
/* 625 */         bidLimitedPeriod = Long.valueOf(Long.parseLong(auctionHall.get("bidLimitedPeriod").toString()));
/*     */     } catch (Exception e) {
/* 627 */       e.printStackTrace();
/* 628 */       if (this.log.isErrorEnabled()) this.log.error("bidLimitedPeriod convert error");
/*     */     }
/* 630 */     if ((null != bidLimitedPeriod) && (bidLimitedPeriod.longValue() > 0L))
/*     */     {
/* 633 */       auctionLatestBidPara.setBidLimitedPeriod(bidLimitedPeriod);
/*     */     }
/*     */ 
/* 637 */     AuctionBidRecord auctionBidRecord = new AuctionBidRecord();
/* 638 */     auctionBidRecord.setBidderAccount(request.getBidOperatorAccount());
/* 639 */     auctionBidRecord.setBidderTrademark(request.getBidderTrademark());
/* 640 */     auctionBidRecord.setProjectCode(request.getProjectCode());
/* 641 */     auctionBidRecord.setPrice(request.getPrice());
/* 642 */     auctionBidRecord.setBidOperatorAccount(request.getBidOperatorAccount());
/* 643 */     auctionBidRecord.setUsePriority(request.getUsePriority());
/* 644 */     auctionBidRecord.setIp(request.getIp());
/* 645 */     auctionBidRecord.setStatus("B");
/* 646 */     auctionBidRecord.setOperator(request.getBidOperatorAccount());
/*     */ 
/* 649 */     AuctionLog auctionLog = new AuctionLog();
/* 650 */     auctionLog.setBeforeStatus(nowStatusEnum.getValue());
/* 651 */     auctionLog.setNewStatus(nextStatus);
/* 652 */     if (!nowStatusEnum.getValue().equals(nextStatus)) {
/* 653 */       auctionLog.setProjectCode(request.getProjectCode());
/* 654 */       ObjectMapper mapper = new ObjectMapper();
/*     */       try {
/* 656 */         auctionLog.setDataJson(mapper.writeValueAsString(latestBid));
/*     */       } catch (Exception e) {
/* 658 */         e.printStackTrace();
/* 659 */         if (this.log.isErrorEnabled()) this.log.error("convert auctionLatestBid object to json string error");
/*     */       }
/* 661 */       String remark = new StringBuilder().append(request.getBidOperatorAccount()).append("Y".equals(request.getUsePriority()) ? "使用优先权" : new StringBuilder().append("报价").append(request.getPrice()).toString()).toString();
/*     */ 
/* 663 */       auctionLog.setRemark(remark);
/* 664 */       auctionLog.setOperator(request.getBidOperatorAccount());
/* 665 */       auctionLog.setOperatorType(EnumOperatorType.BIDDER.getValue());
/*     */     }
/*     */ 
/* 670 */     result = this.auctionCoreService.bidderDid(auctionLatestBidPara, auctionBidRecord, auctionLog);
/*     */ 
/* 673 */     if (result.correct()) {
/* 674 */       sendAuctionLatestBid(request.getProjectCode());
/*     */     }
/*     */ 
/* 677 */     return result;
/*     */   }
/*     */ 
/*     */   private boolean isCanUsePriority(EnumAuctionLatestStatus nowStatusEnum)
/*     */   {
/* 682 */     return (EnumAuctionLatestStatus.L.equals(nowStatusEnum)) || (EnumAuctionLatestStatus.M.equals(nowStatusEnum)) || (EnumAuctionLatestStatus.M1.equals(nowStatusEnum)) || (EnumAuctionLatestStatus.M2.equals(nowStatusEnum));
/*     */   }
/*     */ 
/*     */   private boolean isCanBid(EnumAuctionLatestStatus nowStatusEnum)
/*     */   {
/* 690 */     return (isNormalMission(nowStatusEnum)) || (EnumAuctionLatestStatus.L.equals(nowStatusEnum)) || (EnumAuctionLatestStatus.M.equals(nowStatusEnum)) || (EnumAuctionLatestStatus.M1.equals(nowStatusEnum)) || (EnumAuctionLatestStatus.M2.equals(nowStatusEnum));
/*     */   }
/*     */ 
/*     */   private boolean isNormalMission(EnumAuctionLatestStatus nowStatusEnum)
/*     */   {
/* 699 */     return (EnumAuctionLatestStatus.E.equals(nowStatusEnum)) || (EnumAuctionLatestStatus.G.equals(nowStatusEnum)) || (EnumAuctionLatestStatus.G1.equals(nowStatusEnum)) || (EnumAuctionLatestStatus.G2.equals(nowStatusEnum));
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.remote.service.pojo.RemoteAuctionCoreServiceImpl
 * JD-Core Version:    0.6.0
 */