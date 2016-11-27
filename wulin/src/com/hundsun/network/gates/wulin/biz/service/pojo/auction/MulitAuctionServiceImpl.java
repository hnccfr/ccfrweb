/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidCheckStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumAuctionErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AuctionMulitBidRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionBidderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionFreeBidDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionHallDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.auction.AuctionLogDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionBidder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionFreeBid;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionLog;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionMulitBidProject;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.AuctionMulitBidProjectQuery;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.MulitAuctionReviewQuery;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.auction.MulitAuctionService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.message.SystemMessageService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.codehaus.jackson.map.ObjectMapper;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.MessageSource;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("mulitAuctionService")
/*     */ public class MulitAuctionServiceImpl extends BaseService
/*     */   implements MulitAuctionService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionFreeBidDAO auctionFreeBidDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidderDAO auctionBidderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionLogDAO auctionLogDAO;
/*     */ 
/*     */   @Autowired
/*     */   private MessageSource messageSource;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionHallDAO auctionHallDAO;
/*     */ 
/*     */   @Autowired
/*     */   private SystemMessageService systemMessageService;
/*     */ 
/*     */   public ServiceResult review(final AuctionMulitBidRequest request)
/*     */   {
/*  70 */     ServiceResult serviceResult = new ServiceResult();
/*     */ 
/*  72 */     if ((null == request) || (StringUtil.isEmpty(request.getBidderAccount())) || (StringUtil.isEmpty(request.getReviewer())) || (StringUtil.isEmpty(request.getProjectCode())) || (StringUtil.isEmpty(request.getRemark())))
/*     */     {
/*  76 */       serviceResult.setErrorNOInfo(Integer.valueOf(EnumAuctionErrors.PARAMETER_ERROR.getValue()), EnumAuctionErrors.PARAMETER_ERROR.getInfo());
/*     */ 
/*  78 */       return serviceResult;
/*     */     }
/*  80 */     AuctionMulitBidProjectQuery query = new AuctionMulitBidProjectQuery();
/*  81 */     query.setReviewer(request.getReviewer());
/*  82 */     query.setProjectCode(request.getProjectCode());
/*  83 */     List projectList = this.projectListingService.queryAuctionMulitBidProjectUncheckedByProjectCode(query);
/*     */ 
/*  86 */     if ((null == projectList) || (projectList.size() <= 0)) {
/*  87 */       serviceResult.setErrorNOInfo(Integer.valueOf(EnumAuctionErrors.CHECK_PROJECT_LISTING_NULL.getValue()), EnumAuctionErrors.CHECK_PROJECT_LISTING_NULL.getInfo());
/*     */ 
/*  89 */       return serviceResult;
/*     */     }
/*     */ 
/*  92 */     AuctionFreeBid auctionFreeBid = queryTopUncheckFreeBid(request.getProjectCode(), request.getBidderAccount());
/*     */ 
/*  94 */     if (null == auctionFreeBid) {
/*  95 */       serviceResult.setErrorNOInfo(Integer.valueOf(EnumAuctionErrors.PARAMETER_ERROR.getValue()), EnumAuctionErrors.PARAMETER_ERROR.getInfo());
/*     */ 
/*  97 */       return serviceResult;
/*     */     }
/*     */ 
/* 100 */     AuctionBidder auctionBidder = this.auctionBidderDAO.selectNormalByBidderAccount(request.getProjectCode(), request.getBidderAccount());
/*     */ 
/* 102 */     if (null == auctionBidder) {
/* 103 */       serviceResult.setErrorNOInfo(Integer.valueOf(EnumAuctionErrors.CHECK_BIDDER_NULL.getValue()), EnumAuctionErrors.CHECK_BIDDER_NULL.getInfo());
/*     */ 
/* 105 */       return serviceResult;
/*     */     }
/* 107 */     ObjectMapper mapper = new ObjectMapper();
/* 108 */     String auctionBidderJson = "";
/*     */     try {
/* 110 */       auctionBidderJson = mapper.writeValueAsString(auctionBidder);
/*     */     } catch (IOException e) {
/* 112 */       if (this.log.isErrorEnabled()) {
/* 113 */         this.log.error("convert auctionBidder to json format fail,", e);
/*     */       }
/*     */     }
/* 116 */     final String fAuctionBidderJson = auctionBidderJson;
/* 117 */     final AuctionFreeBid fAuctionFreeBid = auctionFreeBid;
/* 118 */     final String logRemark = getMessage("project.auction.mulitbid.review.log.remark", new String[] { request.getReviewer(), auctionBidder.getBidderAccount() });
/*     */ 
/* 120 */     final AuctionBidder fAuctionBidder = auctionBidder;
/* 121 */     final AuctionMulitBidProject fAuctionMulitBidProject = (AuctionMulitBidProject)projectList.get(0);
/*     */ 
/* 123 */     serviceResult = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public ServiceResult doInTransaction(TransactionStatus status) {
/* 125 */         ServiceResult result = new ServiceResult();
/* 126 */         Object savePoint = status.createSavepoint();
/*     */         try
/*     */         {
/* 129 */           AuctionFreeBid auctionFreeBid = new AuctionFreeBid();
/* 130 */           auctionFreeBid.setBidderAccount(fAuctionFreeBid.getBidderAccount());
/* 131 */           auctionFreeBid.setBidderTrademark(fAuctionFreeBid.getBidderTrademark());
/* 132 */           auctionFreeBid.setBidOperatorAccount(fAuctionFreeBid.getBidOperatorAccount());
/* 133 */           auctionFreeBid.setCheckRemark(request.getRemark());
/* 134 */           auctionFreeBid.setCheckStatus(EnumBidCheckStatus.Fail.getValue());
/* 135 */           auctionFreeBid.setIp(fAuctionFreeBid.getIp());
/* 136 */           auctionFreeBid.setOperator(request.getOperator());
/* 137 */           auctionFreeBid.setPrice(fAuctionFreeBid.getPrice());
/* 138 */           auctionFreeBid.setProjectCode(request.getProjectCode());
/* 139 */           auctionFreeBid.setStatus(fAuctionFreeBid.getStatus());
/* 140 */           MulitAuctionServiceImpl.this.auctionFreeBidDAO.insert(auctionFreeBid);
/*     */ 
/* 143 */           if (MulitAuctionServiceImpl.this.auctionBidderDAO.deleteByBidderAccount(request.getProjectCode(), request.getBidderAccount()) <= 0)
/*     */           {
/* 145 */             throw new ServiceException(EnumAuctionErrors.REVIEW_DELETE_BIDDER_FAIL.getInfo(), Integer.valueOf(EnumAuctionErrors.REVIEW_DELETE_BIDDER_FAIL.getValue()));
/*     */           }
/*     */ 
/* 150 */           if (EnumActiveStatus.Yes.getValue().equals(fAuctionBidder.getIsPriority())) {
/* 151 */             HashMap actionHallMap = new HashMap();
/* 152 */             actionHallMap.put("priorityNumSub", Integer.valueOf(1));
/* 153 */             actionHallMap.put("whereProjectCode", request.getProjectCode());
/* 154 */             if (MulitAuctionServiceImpl.this.auctionHallDAO.updateByMap(actionHallMap) <= 0) {
/* 155 */               throw new ServiceException(EnumAuctionErrors.REVIEW_UPDATE_HALL_FALL.getInfo(), Integer.valueOf(EnumAuctionErrors.REVIEW_UPDATE_HALL_FALL.getValue()));
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 172 */           SystemMessageRequest systemMessageRequest = new SystemMessageRequest();
/* 173 */           systemMessageRequest.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 174 */           systemMessageRequest.setContent(MulitAuctionServiceImpl.this.getMessage("project.auction.mulitbid.review.message.content", new String[] { fAuctionMulitBidProject.getProjectTitle(), request.getRemark() }));
/*     */ 
/* 177 */           systemMessageRequest.setTitle(MulitAuctionServiceImpl.this.getMessage("project.auction.mulitbid.review.message.title", new String[0]));
/*     */ 
/* 179 */           List userAccountList = new ArrayList();
/* 180 */           userAccountList.add(fAuctionBidder.getBidderAccount());
/* 181 */           systemMessageRequest.setUserAccountList(userAccountList);
/* 182 */           MulitAuctionServiceImpl.this.systemMessageService.sendSystemMessage(systemMessageRequest);
/*     */ 
/* 185 */           AuctionLog auctionLog = new AuctionLog();
/* 186 */           auctionLog.setDataJson(fAuctionBidderJson);
/* 187 */           auctionLog.setProjectCode(request.getProjectCode());
/* 188 */           auctionLog.setRemark(logRemark);
/* 189 */           auctionLog.setOperatorType(EnumOperatorType.REVIEWER.getValue());
/* 190 */           auctionLog.setOperator(request.getReviewer());
/* 191 */           MulitAuctionServiceImpl.this.auctionLogDAO.insert(auctionLog);
/*     */         }
/*     */         catch (ServiceException e) {
/* 194 */           status.rollbackToSavepoint(savePoint);
/* 195 */           MulitAuctionServiceImpl.this.log.error("MulitAuctionServiceImpl review fail", e);
/* 196 */           result.setErrorNO(e.getErrorNO());
/* 197 */           result.setErrorInfo(e.getErrorInfo());
/*     */         } catch (Exception e) {
/* 199 */           status.rollbackToSavepoint(savePoint);
/* 200 */           MulitAuctionServiceImpl.this.log.error("MulitAuctionServiceImpl review error", e);
/* 201 */           result.setErrorNO(Integer.valueOf(EnumAuctionErrors.INTERNAL_ERROR.getValue()));
/* 202 */           result.setErrorInfo(EnumAuctionErrors.INTERNAL_ERROR.getInfo());
/*     */         }
/* 204 */         return result;
/*     */       }
/*     */     });
/* 208 */     return serviceResult;
/*     */   }
/*     */ 
/*     */   public AuctionFreeBid queryTopUncheckFreeBid(String projectCode, String bidderAccount)
/*     */   {
/* 213 */     MulitAuctionReviewQuery query = new MulitAuctionReviewQuery();
/* 214 */     query.setBidderAccount(bidderAccount);
/* 215 */     query.setCheckStatus(EnumBidCheckStatus.Pass);
/* 216 */     query.setProjectCode(projectCode);
/* 217 */     query.setStatus(EnumBidPriceStatus.EFFECTIVE);
/* 218 */     return this.auctionFreeBidDAO.selectTopByMulitAuctionReviewQuery(query);
/*     */   }
/*     */ 
/*     */   protected String getMessage(String code, String[] args) {
/* 222 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.auction.MulitAuctionServiceImpl
 * JD-Core Version:    0.6.0
 */