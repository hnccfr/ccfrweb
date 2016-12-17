/*     */ package com.hundsun.network.gates.wangjiang.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.service.RemoteAuctionCoreService;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.service.RemoteAuctionPushletService;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionBidRecordDTO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionBidderDTO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionHallDTO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionLatestBidDTO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallBidErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallControlErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionMessageServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionResultServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallBidServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallControlServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallDataServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.result.HallServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.service.RemoteAuctionService;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wangjiang.biz.service.auction.AuctionService;
/*     */ import com.hundsun.network.gates.wangjiang.common.ConvertUtil;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteAuctionService")
/*     */ public class RemoteAuctionServiceImpl extends BaseService
/*     */   implements RemoteAuctionService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AuctionService auctionService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteAuctionCoreService remoteAuctionCoreService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteAuctionPushletService remoteAuctionPushletService;
/*     */ 
/*     */   public HallServiceResult loginHall(HallServiceRequest request)
/*     */   {
/*  69 */     HallServiceResult hallServiceResult = new HallServiceResult();
/*     */     try
/*     */     {
/*  74 */       if ((null == request) || (StringUtil.isEmpty(request.getUserAccount()))) {
/*  75 */         hallServiceResult.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()), EnumHallErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/*     */ 
/*  78 */         return hallServiceResult;
/*     */       }
/*  80 */       if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/*  81 */         hallServiceResult.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()), EnumHallErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/*     */ 
/*  84 */         return hallServiceResult;
/*     */       }
/*     */ 
/*  89 */       AuctionHall hall = this.auctionService.selectHallByProjectCode(request.getProjectCode());
/*  90 */       if (null == hall) {
/*  91 */         hallServiceResult.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.HALL_ERROR.getValue()), EnumHallErrorNO.HALL_ERROR.getName());
/*     */ 
/*  93 */         return hallServiceResult;
/*     */       }
/*     */ 
/*  98 */       AuctionHallDTO auctionHallDTO = new AuctionHallDTO();
/*  99 */       ConvertUtil.auctionHall2DTO(hall, auctionHallDTO);
/*     */ 
/* 105 */       if (hall.getBidStartCountDownMilliSeconds().longValue() > 0L) {
/* 106 */         hallServiceResult.setAuctionHallDTO(auctionHallDTO);
/* 107 */         hallServiceResult.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.WAITSTART_ERROR.getValue()), EnumHallErrorNO.WAITSTART_ERROR.getName());
/*     */ 
/* 109 */         return hallServiceResult;
/*     */       }
/*     */ 
/* 115 */       AuctionLatestBid auctionLatestBid = this.auctionService.selectLBByProjectCode(request.getProjectCode());
/*     */ 
/* 117 */       List bidderList = this.auctionService.selectBidderListByProCode(request.getProjectCode());
/*     */ 
/* 119 */       if (null == auctionLatestBid) {
/* 120 */         hallServiceResult.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.INTERNAL_ERROR.getValue()), EnumHallErrorNO.INTERNAL_ERROR.getName());
/*     */ 
/* 122 */         return hallServiceResult;
/*     */       }
/*     */ 
/* 129 */       AuctionBidder bidder = this.auctionService.selectBidderBy(request.getProjectCode(), request.getUserAccount());
/*     */ 
/* 132 */       Map proMsgmap = this.auctionService.selectListerAccount(request.getProjectCode());
/* 133 */       hallServiceResult.setProjectTitle((String)proMsgmap.get("title"));
/* 134 */       hallServiceResult.setHallUserType(EnumOperatorType.VIEWER.getValue());
/* 135 */       if (null != bidder)
/*     */       {
/* 137 */         hallServiceResult.setHallUserType(EnumOperatorType.BIDDER.getValue());
/* 138 */         hallServiceResult.setIsPriority(bidder.getIsPriority());
/* 139 */         hallServiceResult.setBidderTrademark(bidder.getBidderTrademark());
/* 140 */       } else if (("Y".equalsIgnoreCase(hall.getHaveAuctioneer())) && (hall.getAuctioneerAccount().equals(request.getUserAccount())))
/*     */       {
/* 142 */         hallServiceResult.setHallUserType(EnumOperatorType.AUCTIONEER.getValue());
/*     */       } else {
/* 144 */         String lister = (String)proMsgmap.get("userAccount");
/*     */ 
/* 146 */         if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(proMsgmap.get("tradingType"))) {
/* 147 */           String reviewer = (String)proMsgmap.get("reviewerAccount");
/* 148 */           if ((StringUtil.isNotEmpty(lister)) && (StringUtil.isNotEmpty(reviewer)) && (lister.equals(request.getUserAccount())) && ((reviewer + ",").indexOf(request.getUserAccount() + ",") >= 0))
/*     */           {
/* 152 */             hallServiceResult.setHallUserType(EnumOperatorType.REVIEWER_LISTINGER.getValue());
/*     */           } else {
/* 154 */             if ((StringUtil.isNotEmpty(lister)) && (lister.equals(request.getUserAccount())))
/*     */             {
/* 157 */               hallServiceResult.setHallUserType(EnumOperatorType.LISTINGER.getValue());
/*     */             }
/* 159 */             if ((StringUtil.isNotEmpty(reviewer)) && ((reviewer + ",").indexOf(request.getUserAccount() + ",") >= 0))
/*     */             {
/* 162 */               hallServiceResult.setHallUserType(EnumOperatorType.REVIEWER.getValue());
/*     */             }
/*     */           }
/*     */         }
/*     */ 
/* 167 */         if ((EnumTradingType.BID_ORDER.getValue().equals(proMsgmap.get("tradingType"))) && 
/* 168 */           (StringUtil.isNotEmpty(lister)) && (lister.equals(request.getUserAccount())))
/*     */         {
/* 171 */           hallServiceResult.setHallUserType(EnumOperatorType.LISTINGER.getValue());
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 179 */       if ((hallServiceResult.getHallUserType().equalsIgnoreCase("viewer")) && ("N".equalsIgnoreCase(hall.getAllowWatch())))
/*     */       {
/* 181 */         if (StringUtil.isEmpty(request.getWatchPassword())) {
/* 182 */           hallServiceResult.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.PARAMETER_WATCHPASSWORD_NEED.getValue()), EnumHallErrorNO.PARAMETER_WATCHPASSWORD_NEED.getName());
/*     */ 
/* 185 */           return hallServiceResult;
/*     */         }
/* 187 */         if ((StringUtil.isEmpty(hall.getWatchPassword())) || (!hall.getWatchPassword().equals(request.getWatchPassword()))) {
/* 188 */           hallServiceResult.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.PARAMETER_WATCHPASSWORD_ERROR.getValue()), EnumHallErrorNO.PARAMETER_WATCHPASSWORD_ERROR.getName());
/*     */ 
/* 191 */           return hallServiceResult;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 198 */       List recordList = this.auctionService.selectRecordListByProjectCode(request.getProjectCode());
/*     */ 
/* 200 */       Collection recordDTOList = new ArrayList();
/* 201 */       Iterator itRecord = recordList.iterator();
/* 202 */       while (itRecord.hasNext()) {
/* 203 */         AuctionBidRecord o = (AuctionBidRecord)itRecord.next();
/* 204 */         AuctionBidRecordDTO dto = new AuctionBidRecordDTO();
/* 205 */         ConvertUtil.AuctionBidRecord2DTO(o, dto);
/* 206 */         recordDTOList.add(dto);
/*     */       }
/* 208 */       hallServiceResult.setAuctionBidRecordDTOs(recordDTOList);
/*     */ 
/* 210 */       AuctionLatestBidDTO latestDTO = new AuctionLatestBidDTO();
/* 211 */       ConvertUtil.AuctionLatestBid2DTO(auctionLatestBid, latestDTO);
/* 212 */       hallServiceResult.setAuctionLatestBidDTO(latestDTO);
/*     */ 
/* 214 */       Collection bidderDTOList = new ArrayList();
/* 215 */       Iterator itBidder = bidderList.iterator();
/* 216 */       while (itBidder.hasNext()) {
/* 217 */         AuctionBidder o = (AuctionBidder)itBidder.next();
/* 218 */         AuctionBidderDTO dto = new AuctionBidderDTO();
/* 219 */         ConvertUtil.AuctionBidder2DTO(o, dto);
/* 220 */         bidderDTOList.add(dto);
/*     */       }
/* 222 */       hallServiceResult.setAuctionBidderDTOs(bidderDTOList);
/*     */ 
/* 224 */       hallServiceResult.setAuctionHallDTO(auctionHallDTO);
/*     */     }
/*     */     catch (Exception e) {
/* 227 */       this.log.error("登陆大厅失败", e);
/* 228 */       hallServiceResult.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.SERVER_ERROR.getValue()), EnumHallErrorNO.SERVER_ERROR.getName());
/*     */     }
/*     */ 
/* 231 */     return hallServiceResult;
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerDo(HallControlServiceRequest request)
/*     */   {
/* 239 */     ServiceResult result = new ServiceResult();
/*     */     try
/*     */     {
/* 245 */       if ((null == request) || (StringUtil.isEmpty(request.getUserAccount()))) {
/* 246 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/* 247 */         return result;
/*     */       }
/* 249 */       if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/* 250 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/* 251 */         return result;
/*     */       }
/* 253 */       if ((null == request) || (StringUtil.isEmpty(request.getLatestStatus()))) {
/* 254 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_NEXTSTATUS_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_NEXTSTATUS_NULL.getName());
/* 255 */         return result;
/*     */       }
/*     */ 
/* 259 */       result = this.remoteAuctionCoreService.auctioneerDo(request);
/*     */     } catch (Exception e) {
/* 261 */       e.printStackTrace();
/* 262 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.SERVER_ERROR.getValue()), EnumHallControlErrorNO.SERVER_ERROR.getName());
/*     */     }
/*     */ 
/* 265 */     return result;
/*     */   }
/*     */ 
/*     */   public void sendAuctionLatestBid(HallDataServiceRequest request)
/*     */   {
/* 274 */     if ((null == request) || (null == request.getAuctionLatestBidDTO())) {
/* 275 */       if (this.log.isErrorEnabled()) this.log.error("request or auctionLatestBidDTO is null");
/* 276 */       return;
/*     */     }
/*     */ 
/* 281 */     this.remoteAuctionPushletService.sendAuctionLatestBid(request);
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerUpdateBidRate(HallControlServiceRequest request)
/*     */   {
/* 289 */     ServiceResult result = new ServiceResult();
/*     */     try
/*     */     {
/* 295 */       if ((null == request) || (StringUtil.isEmpty(request.getUserAccount()))) {
/* 296 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/* 297 */         return result;
/*     */       }
/* 299 */       if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/* 300 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/* 301 */         return result;
/*     */       }
/* 303 */       if ((null == request) || (null == request.getBidRate())) {
/* 304 */         result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_BIDRATE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_BIDRATE_NULL.getName());
/* 305 */         return result;
/*     */       }
/*     */ 
/* 309 */       result = this.remoteAuctionCoreService.auctioneerUpdateBidRate(request);
/*     */     }
/*     */     catch (Exception e) {
/* 312 */       e.printStackTrace();
/* 313 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.SERVER_ERROR.getValue()), EnumHallControlErrorNO.SERVER_ERROR.getName());
/*     */     }
/*     */ 
/* 316 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerSetReservePrice(HallControlServiceRequest request)
/*     */   {
/* 324 */     ServiceResult result = new ServiceResult();
/*     */ 
/* 326 */     if ((null == request) || (StringUtil.isEmpty(request.getUserAccount()))) {
/* 327 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_USERACCOUNT_NULL.getName());
/*     */ 
/* 330 */       return result;
/*     */     }
/* 332 */     if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/* 333 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/*     */ 
/* 336 */       return result;
/*     */     }
/* 338 */     if ((null == request) || (null == request.getReservePrice())) {
/* 339 */       result.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.PARAMETER_RESERVEPRICE_NULL.getValue()), EnumHallControlErrorNO.PARAMETER_RESERVEPRICE_NULL.getName());
/*     */ 
/* 342 */       return result;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 347 */       result = this.remoteAuctionCoreService.auctioneerSetReservePrice(request);
/*     */     } catch (Exception e) {
/* 349 */       result.setErrorNO(Integer.valueOf(EnumHallControlErrorNO.SERVER_ERROR.getValue()));
/* 350 */       result.setErrorInfo(EnumHallControlErrorNO.SERVER_ERROR.getName());
/*     */     }
/*     */ 
/* 353 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult bidderDid(HallBidServiceRequest request)
/*     */   {
/* 361 */     ServiceResult result = new ServiceResult();
/*     */ 
/* 363 */     if ((null == request) || (StringUtil.isEmpty(request.getBidOperatorAccount()))) {
/* 364 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_BIDOPERATORACCOUNT_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_BIDOPERATORACCOUNT_NULL.getName());
/*     */ 
/* 367 */       return result;
/*     */     }
/* 369 */     if ((null == request) || (StringUtil.isEmpty(request.getProjectCode()))) {
/* 370 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_PROJECTCODE_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_PROJECTCODE_NULL.getName());
/*     */ 
/* 373 */       return result;
/*     */     }
/* 375 */     if ((null == request) || (StringUtil.isEmpty(request.getBidderTrademark()))) {
/* 376 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_BIDDERTRADEMARK_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_BIDDERTRADEMARK_NULL.getName());
/*     */ 
/* 379 */       return result;
/*     */     }
/* 381 */     if ((null == request) || (null == request.getPrice())) {
/* 382 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_PRICE_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_PRICE_NULL.getName());
/*     */ 
/* 385 */       return result;
/*     */     }
/* 387 */     if (request.getPrice().longValue() <= 0L) {
/* 388 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_PRICE_ERROR.getValue()), EnumHallBidErrorNO.PARAMETER_PRICE_ERROR.getName());
/*     */ 
/* 391 */       return result;
/*     */     }
/* 393 */     if ((null == request) || (StringUtil.isEmpty(request.getIp()))) {
/* 394 */       result.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.PARAMETER_IP_NULL.getValue()), EnumHallBidErrorNO.PARAMETER_IP_NULL.getName());
/*     */ 
/* 397 */       return result;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 402 */       result = this.remoteAuctionCoreService.bidderDid(request);
/*     */     } catch (Exception e) {
/* 404 */       result.setErrorNO(Integer.valueOf(EnumHallBidErrorNO.SERVER_ERROR.getValue()));
/* 405 */       result.setErrorInfo(EnumHallBidErrorNO.SERVER_ERROR.getName());
/*     */     }
/*     */ 
/* 408 */     return result;
/*     */   }
/*     */ 
/*     */   public void sendAuctionResult(AuctionResultServiceRequest request)
/*     */   {
/* 417 */     if ((null == request) || (null == request.getTranResult()) || (null == request.getProjectCode())) {
/* 418 */       if (this.log.isErrorEnabled()) this.log.error("request or tranResult or projectCode is null");
/* 419 */       return;
/* 420 */     }if ("Y".equals(request.getTranResult())) {
/* 421 */       if (((null == request.getBidderTrademark()) || (null == request.getPrice())) && 
/* 422 */         (this.log.isErrorEnabled())) this.log.error("成交项目 丢失成交牌号或成交价格");
/*     */ 
/* 424 */       if ((null == request.getOrderNo()) && 
/* 425 */         (this.log.isErrorEnabled())) this.log.error("成交项目 丢失订单号");
/*     */ 
/*     */     }
/*     */ 
/* 430 */     this.remoteAuctionPushletService.sendAuctionResult(request);
/*     */   }
/*     */ 
/*     */   public void sendAuctionMessage(AuctionMessageServiceRequest request)
/*     */   {
/* 440 */     this.remoteAuctionPushletService.sendAuctionMessage(request);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.remote.service.pojo.RemoteAuctionServiceImpl
 * JD-Core Version:    0.6.0
 */