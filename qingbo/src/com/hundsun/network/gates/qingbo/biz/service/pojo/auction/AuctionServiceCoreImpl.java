/*     */ package com.hundsun.network.gates.qingbo.biz.service.pojo.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionLatestStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallBidErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallControlErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.enums.EnumHallErrorNO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionMessageServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallControlServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.service.RemoteAuctionService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDetailDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AnnouncementRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteAnnouncementService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemMessageService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderService;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionBidRecordCoreDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionBidRecordHisCoreDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionBidderCoreDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionFreeBidCoreDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionHallCoreDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionLatestBidCoreDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionLogCoreDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionResultCoreDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidRecord;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionFreeBid;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLog;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionResult;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.auction.AuctionCoreService;
/*     */ import com.hundsun.network.gates.qingbo.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.qingbo.common.MobileMessageUtil;
/*     */ import com.hundsun.network.melody.common.util.Money;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.codehaus.jackson.map.ObjectMapper;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("auctionCoreService")
/*     */ public class AuctionServiceCoreImpl extends BaseService
/*     */   implements AuctionCoreService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AuctionHallCoreDAO auctionHallCoreDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionLatestBidCoreDAO auctionLatestBidCoreDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionLogCoreDAO auctionLogCoreDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidderCoreDAO auctionBidderCoreDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidRecordCoreDAO auctionBidRecordCoreDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionResultCoreDAO auctionResultCoreDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidRecordHisCoreDAO auctionBidRecordHisCoreDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderDAO tradeWishOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionFreeBidCoreDAO auctionFreeBidCoreDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteTradeOrderService remoteTradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteAuctionService remoteAuctionService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemMessageService remoteSystemMessageService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteAnnouncementService remoteAnnouncementService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @Autowired
/*     */   private MobileMessageUtil mobileMessageUtil;
/*     */ 
/*     */   public Map<String, Object> selectSimpleHallByProjectCode(String projectCode)
/*     */   {
/* 129 */     return this.auctionHallCoreDAO.selectSimpleHallByProjectCode(projectCode);
/*     */   }
/*     */ 
/*     */   public ServiceResult auctioneerSetReservePrice(HallControlServiceRequest request, AuctionLatestBid latestBid)
/*     */   {
/* 143 */     Map latestBidMap = new HashMap();
/* 144 */     latestBidMap.put("projectCode", request.getProjectCode());
/* 145 */     latestBidMap.put("beforeStatus", latestBid.getLatestStatus());
/* 146 */     latestBidMap.put("nowStatus", EnumAuctionLatestStatus.Z.getValue());
/*     */ 
/* 149 */     AuctionLog logObj = new AuctionLog();
/* 150 */     logObj.setProjectCode(request.getProjectCode());
/* 151 */     logObj.setBeforeStatus(latestBid.getLatestStatus());
/* 152 */     logObj.setNewStatus(EnumAuctionLatestStatus.Z.getValue());
/* 153 */     ObjectMapper mapper = new ObjectMapper();
/*     */     try {
/* 155 */       logObj.setDataJson(mapper.writeValueAsString(latestBid));
/*     */     } catch (Exception e) {
/* 157 */       e.printStackTrace();
/* 158 */       if (this.log.isErrorEnabled()) this.log.error("convert auctionLatestBid object to json string error");
/*     */     }
/* 160 */     logObj.setRemark("设置保留价完成，拍卖结束");
/* 161 */     logObj.setOperator(request.getUserAccount());
/* 162 */     logObj.setOperatorType(EnumOperatorType.AUCTIONEER.getValue());
/*     */ 
/* 165 */     AuctionHall hallObj = new AuctionHall();
/* 166 */     hallObj.setProjectCode(request.getProjectCode());
/* 167 */     hallObj.setReservePrice(request.getReservePrice());
/*     */ 
/* 169 */     final Map latestBidPara = latestBidMap;
/* 170 */     final AuctionLog logPara = logObj;
/* 171 */     final AuctionHall hallPara = hallObj;
/*     */ 
/* 173 */     ServiceResult result = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public ServiceResult doInTransaction(TransactionStatus status) {
/* 176 */         ServiceResult reservePriceResult = new ServiceResult();
/*     */         try
/*     */         {
/* 179 */           AuctionServiceCoreImpl.this.auctionLatestBidCoreDAO.updateLatestStatus(latestBidPara);
/*     */ 
/* 182 */           AuctionServiceCoreImpl.this.auctionLogCoreDAO.insert(logPara);
/*     */ 
/* 185 */           AuctionServiceCoreImpl.this.auctionHallCoreDAO.updateByProjectCode(hallPara);
/*     */         }
/*     */         catch (Exception e) {
/* 188 */           e.printStackTrace();
/* 189 */           if (AuctionServiceCoreImpl.this.log.isErrorEnabled()) AuctionServiceCoreImpl.this.log.error("auctioneerSetReservePrice update auction internal error:", e);
/* 190 */           status.setRollbackOnly();
/* 191 */           reservePriceResult.setErrorNOInfo(Integer.valueOf(EnumHallControlErrorNO.OPERATION_FAILED.getValue()), EnumHallControlErrorNO.OPERATION_FAILED.getName());
/* 192 */           return reservePriceResult;
/*     */         }
/* 194 */         return reservePriceResult;
/*     */       }
/*     */     });
/* 198 */     return result;
/*     */   }
/*     */ 
/*     */   public Map<String, Object> selectSimpleHallForBidByProjectCode(String projectCode)
/*     */   {
/* 206 */     return this.auctionHallCoreDAO.selectSimpleHallForBidByProjectCode(projectCode);
/*     */   }
/*     */ 
/*     */   public Map<String, Object> selectSimpleHallForEndByProjectCode(String projectCode)
/*     */   {
/* 214 */     return this.auctionHallCoreDAO.selectSimpleHallForEndByProjectCode(projectCode);
/*     */   }
/*     */ 
/*     */   public Map<String, String> selectCurrStatusByProjectCode(String projectCode)
/*     */   {
/* 226 */     return this.auctionLatestBidCoreDAO.selectCurrStatusByProjectCode(projectCode);
/*     */   }
/*     */ 
/*     */   public int updateLatestStatus(Map<String, String> paraMap)
/*     */   {
/* 234 */     return this.auctionLatestBidCoreDAO.updateLatestStatus(paraMap);
/*     */   }
/*     */ 
/*     */   public int updateBidRate(Map<String, Object> paraMap)
/*     */   {
/* 242 */     return this.auctionLatestBidCoreDAO.updateBidRate(paraMap);
/*     */   }
/*     */ 
/*     */   public AuctionLatestBid selectLatestBidByProjectCode(String projectCode)
/*     */   {
/* 250 */     return this.auctionLatestBidCoreDAO.selectLBByProjectCode(projectCode);
/*     */   }
/*     */ 
/*     */   public ServiceResult bidderDid(AuctionLatestBid auctionLatestBidPara, AuctionBidRecord auctionBidRecord, AuctionLog auctionLog)
/*     */   {
/* 263 */    final AuctionLatestBid latestBid = auctionLatestBidPara;
/* 264 */     final AuctionBidRecord bidRecord = auctionBidRecord;
/* 265 */     final AuctionLog logPara = auctionLog;
/*     */ 
/* 267 */     ServiceResult result = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public ServiceResult doInTransaction(TransactionStatus status) {
/* 270 */         ServiceResult reservePriceResult = new ServiceResult();
/*     */         try
/*     */         {
/* 273 */           int bidResult = AuctionServiceCoreImpl.this.auctionLatestBidCoreDAO.updateLatestStatusInDid(latestBid);
/*     */ 
/* 275 */           if (bidResult > 0)
/*     */           {
/* 277 */             AuctionServiceCoreImpl.this.auctionBidRecordCoreDAO.insert(bidRecord);
/*     */ 
/* 280 */             if (!logPara.getBeforeStatus().equals(logPara.getNewStatus()))
/* 281 */               AuctionServiceCoreImpl.this.auctionLogCoreDAO.insert(logPara);
/*     */           }
/*     */           else {
/* 284 */             if (AuctionServiceCoreImpl.this.log.isErrorEnabled()) AuctionServiceCoreImpl.this.log.error("bidderDid update auctionLatestBid error");
/* 285 */             status.setRollbackOnly();
/*     */ 
/* 287 */             reservePriceResult.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.SAVE_ERROR.getValue()), EnumHallBidErrorNO.SAVE_ERROR.getName());
/* 288 */             return reservePriceResult;
/*     */           }
/*     */         }
/*     */         catch (Exception e) {
/* 292 */           e.printStackTrace();
/* 293 */           if (AuctionServiceCoreImpl.this.log.isErrorEnabled()) AuctionServiceCoreImpl.this.log.error("auctioneerSetReservePrice update auction internal error:", e);
/* 294 */           status.setRollbackOnly();
/* 295 */           reservePriceResult.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.OPERATION_FAILED.getValue()), EnumHallBidErrorNO.OPERATION_FAILED.getName());
/* 296 */           return reservePriceResult;
/*     */         }
/* 298 */         return reservePriceResult;
/*     */       }
/*     */     });
/* 302 */     return result;
/*     */   }
/*     */ 
/*     */   public Long insertLog(AuctionLog auctionLog)
/*     */   {
/* 311 */     return this.auctionLogCoreDAO.insert(auctionLog);
/*     */   }
/*     */ 
/*     */   public AuctionBidder selectBidderByBidAccountAndProjectCode(String bidOperatorAccount, String projectCode)
/*     */   {
/* 320 */     return this.auctionBidderCoreDAO.selectBidderByBidAccountAndProjectCode(bidOperatorAccount, projectCode);
/*     */   }
/*     */ 
/*     */   public AuctionBidder selectBidderByBidderTrademarkAndProjectCode(String projectCode, String bidderTrademark)
/*     */   {
/* 328 */     return this.auctionBidderCoreDAO.selectBidderByBidderTrademarkAndProjectCode(projectCode, bidderTrademark);
/*     */   }
/*     */ 
/*     */   public AuctionBidder selectLatestBidder(String projectCode)
/*     */   {
/* 336 */     return this.auctionBidderCoreDAO.selectLatestBidder(projectCode);
/*     */   }
/*     */ 
/*     */   public int selectBidderNumProjectCode(String projectCode)
/*     */   {
/* 344 */     return this.auctionBidderCoreDAO.selectBidderNumProjectCode(projectCode);
/*     */   }
/*     */ 
/*     */   public int getRecordsNumByProjectCode(String projectCode)
/*     */   {
/* 353 */     return this.auctionBidRecordCoreDAO.getRecordsNumByProjectCode(projectCode);
/*     */   }
/*     */ 
/*     */   public int getPriorityRecordsNumByProjectCode(String projectCode)
/*     */   {
/* 361 */     return this.auctionBidRecordCoreDAO.getPriorityRecordsNumByProjectCode(projectCode);
/*     */   }
/*     */ 
/*     */   public TradeOrderServiceResult endAuctionResult(AuctionResult auctionResult)
/*     */   {
/* 386 */     List<TradeWishOrder> tradeWishOrders = this.tradeWishOrderDAO.selectListInTradeByProjectCode(auctionResult.getProjectCode());
/*     */ 
/* 388 */     Map projectListing = this.projectListingDAO.selectByProjectCodeForCancelFund(auctionResult.getProjectCode());
/* 389 */     Map map = new HashMap();
/*     */     try
/*     */     {
/* 393 */       map = getCancelFundListForEnd(auctionResult, tradeWishOrders, projectListing);
/*     */     } catch (Exception e1) {
/* 395 */       if (this.log.isErrorEnabled()) this.log.error("查出需要退还的保证金：", e1);
/* 396 */       e1.printStackTrace();
/*     */     }
/*     */ 
/* 399 */     final AuctionResult resultPara = auctionResult;
/*     */ 
/* 401 */     final List cancelFundList = (List)map.get("list");
/* 402 */     final TradeWishOrder done = (TradeWishOrder)map.get("done");
/* 403 */     final List tradeWishOrderList = tradeWishOrders;
/* 404 */     TradeOrderServiceResult result = (TradeOrderServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public TradeOrderServiceResult doInTransaction(TransactionStatus status) {
/* 407 */         TradeOrderServiceResult tradeOrderResult = new TradeOrderServiceResult();
/*     */         try
/*     */         {
/* 410 */           AuctionServiceCoreImpl.this.auctionResultCoreDAO.insert(resultPara);
/*     */ 
/* 413 */           AuctionServiceCoreImpl.this.auctionBidRecordHisCoreDAO.insertHisFromBidRecordByProjectCode(resultPara.getProjectCode());
/*     */ 
/* 416 */           AuctionServiceCoreImpl.this.auctionBidRecordCoreDAO.deleteByProjectCode(resultPara.getProjectCode());
/*     */ 
/* 421 */           AuctionServiceCoreImpl.this.auctionFreeBidCoreDAO.insertHisFromFreeBidByProjectCode(resultPara.getProjectCode());
/* 422 */           AuctionServiceCoreImpl.this.auctionFreeBidCoreDAO.deleteByProjectCode(resultPara.getProjectCode());
/*     */ 
/* 425 */           AuctionServiceCoreImpl.this.auctionBidderCoreDAO.deleteByProjectCode(resultPara.getProjectCode());
/*     */ 
/* 428 */           AuctionServiceCoreImpl.this.auctionLatestBidCoreDAO.deleteByProjectCode(resultPara.getProjectCode());
/*     */ 
/* 431 */           AuctionServiceCoreImpl.this.auctionHallCoreDAO.deleteByProjectCode(resultPara.getProjectCode());
/*     */ 
/* 434 */           Map projectMap = new HashMap();
/* 435 */           projectMap.put("status", EnumProjectStatus.OVER.getValue());
/* 436 */           projectMap.put("code", resultPara.getProjectCode());
/* 437 */           projectMap.put("statusWhere", EnumProjectStatus.TRADE.getValue());
/* 438 */           AuctionServiceCoreImpl.this.projectListingDAO.updateProjectListing(projectMap);
/*     */ 
/* 445 */           AuctionServiceCoreImpl.this.cancelFundBatchByTrade(cancelFundList, resultPara.getProjectCode());
/*     */ 
/* 451 */           AuctionServiceCoreImpl.this.tradeWishOrderDAO.updateStatusEndAuctionBatch(tradeWishOrderList);
/*     */ 
/* 453 */           AuctionServiceCoreImpl.this.tradeWishOrderDAO.cancelCreateTradeWishOrder(resultPara.getProjectCode());
/*     */ 
/* 456 */           if ("Y".equals(resultPara.getTranResult()))
/*     */           {
/* 458 */             tradeOrderResult = AuctionServiceCoreImpl.this.clearOrder(resultPara, done);
/*     */           }
/*     */         }
/*     */         catch (Exception e) {
/* 462 */           e.printStackTrace();
/* 463 */           if (AuctionServiceCoreImpl.this.log.isErrorEnabled()) AuctionServiceCoreImpl.this.log.error("endAuctionResult error:", e);
/* 464 */           status.setRollbackOnly();
/* 465 */           tradeOrderResult.setErrorNOInfo(Integer.valueOf(EnumHallBidErrorNO.OPERATION_FAILED.getValue()), EnumHallBidErrorNO.OPERATION_FAILED.getName());
/* 466 */           return tradeOrderResult;
/*     */         }
/* 468 */         return tradeOrderResult;
/*     */       }
/*     */     });
/* 473 */     String proTitle = projectListing.get("title").toString();
/* 474 */     if (proTitle.length() > 100) proTitle = new StringBuilder().append(proTitle.substring(0, 95)).append("..").toString();
/* 475 */     String title = new StringBuilder().append("【").append(proTitle).append("】项目已").append("Y".equals(auctionResult.getTranResult()) ? "成交" : "流拍").toString();
/* 476 */     String content = new StringBuilder().append("【").append(proTitle).append("（项目编号:").append(projectListing.get("code")).append("）】的拍卖已").append("Y".equals(auctionResult.getTranResult()) ? new StringBuilder().append("成交，成交牌号:").append(done.getTrademark()).toString() : "流拍").append("！如有疑问请联系交易所管理员").toString();
/*     */ 
/* 481 */     if (result.correct()) {
/* 482 */       AnnouncementDTO announcement = new AnnouncementDTO();
/* 483 */       announcement.setTitle(title);
/* 484 */       announcement.setContent(content);
/* 485 */       announcement.setType(EnumAnnouncementType.SYSTEM.getValue());
/* 486 */       announcement.setProjectId(Long.valueOf(Long.parseLong(projectListing.get("id").toString())));
/* 487 */       announcement.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/* 488 */       announcement.setCreator(EnumOperatorType.SYSTEM.getValue());
/* 489 */       AnnouncementRequest announcementRequest = new AnnouncementRequest();
/* 490 */       announcementRequest.setAnnouncementDTO(announcement);
/* 491 */       announcementRequest.setInsertNormal(true);
/* 492 */       this.remoteAnnouncementService.createAnnouncement(announcementRequest);
/*     */     }
/*     */ 
/* 496 */     if (projectListing != null) {
/* 497 */       SystemMessageRequest request = new SystemMessageRequest();
/*     */ 
/* 504 */       request.setTitle(title);
/* 505 */       request.setContent(content);
/* 506 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 507 */       request.addUser(projectListing.get("userAccount").toString());
/* 508 */       if ((tradeWishOrders != null) && (tradeWishOrders.size() > 0))
/* 509 */         for (TradeWishOrder tradeWishOrder : tradeWishOrders)
/* 510 */           request.addUser(tradeWishOrder.getUserAccount());
/* 511 */       this.remoteSystemMessageService.sendSystemMessage(request);
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/* 517 */       List nums = new ArrayList();
/* 518 */       UserAccount userAccount = this.userAccountService.getUserByAccount(projectListing.get("userAccount").toString());
/* 519 */       nums.add(userAccount.getMobile());
/* 520 */       if ((tradeWishOrders != null) && (tradeWishOrders.size() > 0)) {
/* 521 */         for (TradeWishOrder tradeWishOrder : tradeWishOrders) {
/* 522 */           UserAccount bidderAccount = this.userAccountService.getUserByAccount(tradeWishOrder.getUserAccount());
/* 523 */           nums.add(bidderAccount.getMobile());
/*     */         }
/*     */       }
/* 526 */       this.mobileMessageUtil.sendMsg(nums, new StringBuilder().append(content).append("【中部林业产权交易服务中心】").toString());
/*     */     } catch (Exception e) {
/* 528 */       this.log.error(new StringBuilder().append("send mobileMessage for endAuction error cause by:").append(e).toString());
/*     */     }
/*     */ 
/* 531 */     return result;
/*     */   }
/*     */ 
/*     */   private void cancelFundBatchByTrade(List<TransRequest> transRequestList, String projectCode)
/*     */   {
/* 536 */     if ((null != transRequestList) && (transRequestList.size() > 0)) {
/* 537 */       FundOperateResult fundOperateResult = this.remoteFundService.cancelFundBatchByTrade(transRequestList);
/* 538 */       if (fundOperateResult.isError()) {
/* 539 */         if (this.log.isErrorEnabled()) this.log.error(new StringBuilder().append("调用资金接口 退还挂牌保证金 出错。资金接口返回错误信息：").append(fundOperateResult.getErrorInfo()).toString());
/*     */ 
/* 543 */         Long waitMillis = Long.valueOf(60000L);
/* 544 */         AuctionMessageServiceRequest request = new AuctionMessageServiceRequest();
/* 545 */         request.setMessage(new StringBuilder().append("退还未成交保证金 处理中，请耐心等待。处理时间约为").append(waitMillis.longValue() / 60000L).append("分钟").toString());
/* 546 */         request.setProjectCode(projectCode);
/* 547 */         this.remoteAuctionService.sendAuctionMessage(request);
/*     */         try {
/* 549 */           Thread.sleep(waitMillis.longValue());
/* 550 */           cancelFundBatchByTrade(transRequestList, projectCode);
/*     */         } catch (Exception e) {
/* 552 */           if (this.log.isErrorEnabled()) this.log.error(new StringBuilder().append("").append(fundOperateResult.getErrorInfo()).toString()); 
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private Map<String, Object> getCancelFundListForEnd(AuctionResult auctionResult, List<TradeWishOrder> tradeWishOrderList, Map<String, Object> projectListing)
/*     */     throws Exception
/*     */   {
/* 560 */     Map map = new HashMap();
/* 561 */     List transRequestList = new ArrayList();
/*     */ 
/* 565 */     if ("N".equals(auctionResult.getTranResult()))
/*     */     {
/* 567 */       if ((null == projectListing) || (null == projectListing.get("deposit"))) {
/* 568 */         throw new Exception("获得挂牌方交易保证金额 错误！");
/*     */       }
/* 570 */       Long projectJyDeposit = Long.valueOf(0L);
/* 571 */       Long deposit = Long.valueOf(0L);
/* 572 */       Long quantity = Long.valueOf(0L);
/*     */       try {
/* 574 */         deposit = Long.valueOf(Long.parseLong(projectListing.get("deposit").toString()));
/* 575 */         quantity = Long.valueOf(Long.parseLong(projectListing.get("quantity").toString()));
/* 576 */         projectJyDeposit = Long.valueOf(deposit.longValue() * quantity.longValue());
/*     */       } catch (Exception e) {
/* 578 */         throw new Exception("转换挂牌方交易保证金额 错误！", e);
/*     */       }
/* 580 */       TransRequest transRequest = new TransRequest();
/* 581 */       transRequest.setFundAccount(projectListing.get("fundAccount").toString());
/* 582 */       transRequest.setOrderProperty(projectListing.get("tradingType").toString());
/* 583 */       transRequest.setAmount(projectJyDeposit);
/* 584 */       transRequest.setBizNo(projectListing.get("id").toString());
/* 585 */       transRequest.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 586 */       transRequest.setMemo("项目流拍，退还挂牌方交易保证金额");
/* 587 */       if (projectJyDeposit.longValue() > 0L) transRequestList.add(transRequest);
/*     */     }
/*     */ 
/* 590 */     for (TradeWishOrder tradeWishOrder : tradeWishOrderList)
/*     */     {
/* 592 */       if (null == tradeWishOrder.getDeposit()) {
/* 593 */         throw new Exception("获得下单方交易保证金额 错误！");
/*     */       }
/* 595 */       String memo = "项目流拍，退还报名方交易保证金额";
/* 596 */       boolean needCancel = true;
/*     */ 
/* 599 */       if ("Y".equals(auctionResult.getTranResult())) {
/* 600 */         if (auctionResult.getBidderAccount().equals(tradeWishOrder.getUserAccount())) {
/* 601 */           tradeWishOrder.setStatus(EnumTradeWishOrderStatus.DONE.getValue());
/* 602 */           needCancel = false;
/* 603 */           map.put("done", tradeWishOrder);
/*     */         } else {
/* 605 */           tradeWishOrder.setStatus(EnumTradeWishOrderStatus.UNDONECANCEL.getValue());
/* 606 */           memo = "未成交的报名，退还交易保证金额";
/*     */         }
/*     */       }
/*     */       else {
/* 610 */         tradeWishOrder.setStatus(EnumTradeWishOrderStatus.CANCEL.getValue());
/*     */       }
/*     */ 
/* 613 */       Long wishJyDeposit = tradeWishOrder.getDeposit();
/* 614 */       if ((needCancel) && (wishJyDeposit.longValue() > 0L)) {
/* 615 */         TransRequest wishTransRequest = new TransRequest();
/* 616 */         wishTransRequest.setFundAccount(tradeWishOrder.getFundAccount());
/* 617 */         wishTransRequest.setOrderProperty(projectListing.get("tradingType").toString());
/* 618 */         wishTransRequest.setAmount(wishJyDeposit);
/* 619 */         wishTransRequest.setBizNo(tradeWishOrder.getWishOrderNum());
/* 620 */         wishTransRequest.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 621 */         wishTransRequest.setMemo(memo);
/* 622 */         transRequestList.add(wishTransRequest);
/*     */       }
/*     */     }
/* 625 */     map.put("list", transRequestList);
/* 626 */     return map;
/*     */   }
/*     */ 
/*     */   private TradeOrderServiceResult clearOrder(AuctionResult resultPara, TradeWishOrder done) throws Exception
/*     */   {
/* 631 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/*     */ 
/* 634 */     String projectCode = resultPara.getProjectCode();
/* 635 */     ProjectListing projectListing = this.projectListingDAO.selectByProjectCode(projectCode);
/* 636 */     TradeWishOrder tradeWishOrder = this.tradeWishOrderDAO.selectByPrimaryKey(done.getId());
/* 637 */     TradeOrderRequest request = new TradeOrderRequest();
/* 638 */     TradeOrderDetailDTO tradeOrderDetailDTO = new TradeOrderDetailDTO();
/* 639 */     TradeOrderDTO tradeOrderDTO = new TradeOrderDTO();
/* 640 */     tradeOrderDTO.setSubstationId(projectListing.getSubstationId());
/*     */ 
/* 642 */     tradeOrderDTO.setTradingType(projectListing.getTradingType());
/*     */ 
/* 644 */     tradeOrderDTO.setBidPrice(resultPara.getPrice());
/* 645 */     tradeOrderDTO.setValuationUnit(tradeWishOrder.getValuationUnit());
/* 646 */     tradeOrderDTO.setQuantity(tradeWishOrder.getQuantity());
/* 647 */     tradeOrderDTO.setMeasureUnit(tradeWishOrder.getMeasureUnit());
/*     */ 
/* 649 */     Money orderAmount = new Money();
/* 650 */     orderAmount.setCent(resultPara.getPrice().longValue());
/* 651 */     tradeOrderDTO.setOrderAmount(Long.valueOf(orderAmount.multiply(tradeWishOrder.getQuantity().longValue()).getCent()));
/* 652 */     tradeOrderDTO.setDeliveryType(tradeWishOrder.getDeliveryType());
/* 653 */     tradeOrderDTO.setPaymentType(tradeWishOrder.getPaymentType());
/* 654 */     tradeOrderDTO.setExpectTime(tradeWishOrder.getExpectTime());
/*     */ 
/* 657 */     tradeOrderDTO.setHasInvoice(tradeWishOrder.getIsInvoice());
/*     */ 
/* 659 */     tradeOrderDTO.setProjectCode(tradeWishOrder.getProjectCode());
/* 660 */     tradeOrderDTO.setProjectName(tradeWishOrder.getProjectName());
/*     */ 
/* 662 */     tradeOrderDTO.setCreator(EnumOperatorType.SYSTEM.getValue());
/* 663 */     tradeOrderDTO.setOperator(EnumOperatorType.SYSTEM.getValue());
/*     */ 
/* 665 */     if (EnumListingType.SELL.getValue().equals(projectListing.getListingType()))
/*     */     {
/* 668 */       tradeOrderDTO.setSellerAccount(projectListing.getUserAccount());
/* 669 */       tradeOrderDTO.setBuyerAccount(resultPara.getBidderAccount());
/* 670 */       tradeOrderDetailDTO.setSellerLinkMan(projectListing.getLinkMan());
/* 671 */       tradeOrderDetailDTO.setSellerPhone(projectListing.getPhone());
/* 672 */       tradeOrderDetailDTO.setSellerProvince(projectListing.getProvince());
/* 673 */       tradeOrderDetailDTO.setSellerCity(projectListing.getCity());
/* 674 */       tradeOrderDetailDTO.setSellerArea(projectListing.getArea());
/* 675 */       tradeOrderDetailDTO.setSellerZipCode(projectListing.getZipCode());
/* 676 */       tradeOrderDetailDTO.setSellerAddress(projectListing.getAddress());
/* 677 */       tradeOrderDetailDTO.setSellerName(projectListing.getLinkMan());
/* 678 */       tradeOrderDetailDTO.setStorehouse(projectListing.getStorehouse());
/* 679 */       tradeOrderDetailDTO.setSellerCompany(null);
/*     */ 
/* 681 */       tradeOrderDetailDTO.setBuyerLinkMan(tradeWishOrder.getLinkMan());
/* 682 */       tradeOrderDetailDTO.setBuyerPhone(tradeWishOrder.getPhone());
/* 683 */       tradeOrderDetailDTO.setBuyerProvince(tradeWishOrder.getProvince());
/* 684 */       tradeOrderDetailDTO.setBuyerCity(tradeWishOrder.getCity());
/* 685 */       tradeOrderDetailDTO.setBuyerArea(tradeWishOrder.getArea());
/* 686 */       tradeOrderDetailDTO.setBuyerZipCode(tradeWishOrder.getZipCode());
/* 687 */       tradeOrderDetailDTO.setBuyerAddress(tradeWishOrder.getAddress());
/* 688 */       tradeOrderDetailDTO.setBuyerName(tradeWishOrder.getLinkMan());
/*     */ 
/* 690 */       tradeOrderDetailDTO.setBuyerCompany(null);
/* 691 */       Money money = new Money();
/* 692 */       money.setCent(projectListing.getDeposit().longValue());
/* 693 */       tradeOrderDTO.setSellerDepositAmount(Long.valueOf(money.multiply(tradeWishOrder.getQuantity().longValue()).getCent()));
/* 694 */       tradeOrderDTO.setBuyerDepositAmount(tradeWishOrder.getDeposit());
/*     */     }
/*     */     else
/*     */     {
/* 698 */       tradeOrderDTO.setSellerAccount(tradeWishOrder.getUserAccount());
/* 699 */       tradeOrderDTO.setBuyerAccount(projectListing.getUserAccount());
/* 700 */       tradeOrderDetailDTO.setSellerLinkMan(tradeWishOrder.getLinkMan());
/* 701 */       tradeOrderDetailDTO.setSellerPhone(tradeWishOrder.getPhone());
/* 702 */       tradeOrderDetailDTO.setSellerProvince(tradeWishOrder.getProvince());
/* 703 */       tradeOrderDetailDTO.setSellerCity(tradeWishOrder.getCity());
/* 704 */       tradeOrderDetailDTO.setSellerArea(tradeWishOrder.getArea());
/* 705 */       tradeOrderDetailDTO.setSellerZipCode(tradeWishOrder.getZipCode());
/* 706 */       tradeOrderDetailDTO.setSellerAddress(tradeWishOrder.getAddress());
/* 707 */       tradeOrderDetailDTO.setSellerName(tradeWishOrder.getLinkMan());
/*     */ 
/* 709 */       tradeOrderDetailDTO.setSellerCompany(null);
/*     */ 
/* 711 */       tradeOrderDetailDTO.setBuyerLinkMan(projectListing.getLinkMan());
/* 712 */       tradeOrderDetailDTO.setBuyerPhone(projectListing.getPhone());
/* 713 */       tradeOrderDetailDTO.setBuyerProvince(projectListing.getProvince());
/* 714 */       tradeOrderDetailDTO.setBuyerCity(projectListing.getCity());
/* 715 */       tradeOrderDetailDTO.setBuyerArea(projectListing.getArea());
/* 716 */       tradeOrderDetailDTO.setBuyerZipCode(projectListing.getZipCode());
/* 717 */       tradeOrderDetailDTO.setBuyerAddress(projectListing.getAddress());
/* 718 */       tradeOrderDetailDTO.setBuyerName(projectListing.getLinkMan());
/* 719 */       tradeOrderDetailDTO.setStorehouse(projectListing.getStorehouse());
/* 720 */       tradeOrderDetailDTO.setBuyerCompany(null);
/* 721 */       Money money = new Money();
/* 722 */       money.setCent(projectListing.getDeposit().longValue());
/* 723 */       tradeOrderDTO.setBuyerDepositAmount(Long.valueOf(money.multiply(tradeWishOrder.getQuantity().longValue()).getCent()));
/* 724 */       tradeOrderDTO.setSellerDepositAmount(tradeWishOrder.getDeposit());
/*     */     }
/*     */ 
/* 727 */     tradeOrderDetailDTO.setRemark(tradeWishOrder.getComments());
/* 728 */     tradeOrderDTO.setWishOrderNum(tradeWishOrder.getWishOrderNum());
/* 729 */     tradeOrderDTO.setCreator(EnumOperatorType.SYSTEM.getValue());
/*     */ 
/* 731 */     request.setSellTradeDeposit(tradeOrderDTO.getSellerDepositAmount());
/* 732 */     request.setBuyTradeDeposit(tradeOrderDTO.getBuyerDepositAmount());
/*     */ 
/* 734 */     request.setTradeOrderDTO(tradeOrderDTO);
/* 735 */     request.setTradeOrderDetailDTO(tradeOrderDetailDTO);
/*     */ 
/* 737 */     request.setOperator(EnumOperatorType.SYSTEM.getValue());
/*     */     try {
/* 739 */       result = this.remoteTradeOrderService.initAddOrder(request);
/*     */     } catch (Exception e) {
/* 741 */       this.log.error("remoteTradeOrderService.initAddOrder error:", e);
/* 742 */       result.setErrorNOInfo(Integer.valueOf(EnumHallErrorNO.SERVER_ERROR.getValue()), EnumHallErrorNO.SERVER_ERROR.getName());
/* 743 */       throw new Exception("remoteTradeOrderService.initAddOrder() error");
/*     */     }
/* 745 */     return result;
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> selectBSUListByProjectCode(String proCode)
/*     */   {
/* 757 */     return this.tradeWishOrderDAO.selectBSUListByProjectCode(proCode);
/*     */   }
/*     */ 
/*     */   public void updateWishOrderStatusBatch(List<TradeWishOrder> list)
/*     */   {
/* 767 */     this.tradeWishOrderDAO.updateWishOrderStatusBatch(list);
/*     */ 
/* 770 */     if ((list != null) && (list.size() > 0)) {
/* 771 */       SystemMessageRequest request = new SystemMessageRequest();
/* 772 */       request.setTitle("拍卖已开始，未审核的报名已关闭");
/* 773 */       request.setContent(new StringBuilder().append(((TradeWishOrder)list.get(0)).getProjectName()).append("（项目编号:").append(((TradeWishOrder)list.get(0)).getProjectCode()).append("）的拍卖已开始，您的未审核的报名已关闭！如有疑问请联系交易所管理员").toString());
/*     */ 
/* 775 */       request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 776 */       for (TradeWishOrder tradeWishOrder : list)
/* 777 */         request.addUser(tradeWishOrder.getUserAccount());
/* 778 */       this.remoteSystemMessageService.sendSystemMessage(request);
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<AuctionFreeBid> selectLastFreeBid(String project, Long priceDirection)
/*     */   {
/* 787 */     return this.auctionFreeBidCoreDAO.selectLastFreeBid(project, priceDirection);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.pojo.auction.AuctionServiceCoreImpl
 * JD-Core Version:    0.6.0
 */