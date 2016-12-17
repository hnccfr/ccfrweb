/*     */ package com.hundsun.network.gates.fengshan.biz.service.pojo.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectMetasDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.trade.WishOrderAuditDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserCreditDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeWishOrderQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.trade.WishOrderAudit;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserCredit;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumApplyTime;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.trade.TradeWishOrderService;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundQueryResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundQueryService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectBaseSettingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectBaseSettingRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectBaseSettingServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectBaseSettingService;
/*     */ import com.hundsun.network.melody.common.util.Money;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Repository("tradeWishOrderService")
/*     */ public class TradeWishOrderServiceImpl extends BaseService
/*     */   implements TradeWishOrderService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderDAO tradeWishOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundQueryService remoteFundQueryService;
/*     */ 
/*     */   @Autowired
/*     */   private UserCreditDAO userCreditDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteProjectBaseSettingService remoteProjectBaseSettingService;
/*     */ 
/*     */   @Autowired
/*     */   private WishOrderAuditDAO wishOrderAuditDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasDAO projectMetasDAO;
/*     */ 
/*     */   public void getTradeWishOrderByQuery(TradeWishOrderQuery query)
/*     */   {
/*  57 */     if (null != query.getWishOrderNum()) {
/*  58 */       query.setWishOrderNum(query.getWishOrderNum().trim());
/*     */     }
/*  60 */     if (null != query.getProjectName()) {
/*  61 */       query.setProjectName(query.getProjectName().trim());
/*     */     }
/*  63 */     this.tradeWishOrderDAO.selectByQuery(query);
/*     */   }
/*     */ 
/*     */   public TradeWishOrder getTradeWishOrderByOrderNum(String orderNum) {
/*  67 */     return this.tradeWishOrderDAO.selectByOrderNum(orderNum);
/*     */   }
/*     */ 
/*     */   public Long addTradeWishOrder(TradeWishOrder tradeWishOrder)
/*     */   {
/*  72 */     return this.tradeWishOrderDAO.insert(tradeWishOrder);
/*     */   }
/*     */ 
/*     */   public FundQueryResult getfundInfo(FundQueryRequest request)
/*     */   {
/*  77 */     return this.remoteFundQueryService.useBalanceCalculate(request);
/*     */   }
/*     */ 
/*     */   public String generatorWishOrderNo()
/*     */   {
/*  82 */     return this.tradeWishOrderDAO.selectWishOrderNo();
/*     */   }
/*     */ 
/*     */   public Long depositGenerator(String userAccount, ProjectListing projectListing, Long bidStartPrice)
/*     */   {
/*  87 */     UserCredit userCredit = this.userCreditDAO.selectByUserAccount(userAccount);
/*  88 */     ProjectBaseSettingRequest request = new ProjectBaseSettingRequest();
/*  89 */     request.setProTypeCode(projectListing.getProjectTypeCode());
/*  90 */     request.setTradingType(projectListing.getTradingType());
/*  91 */     request.setDictParaCode(EnumSystemDictKey.ORDER_JY_PROPORTION.getValue());
/*     */ 
/*  93 */     if (EnumListingType.BUY.getValue().equals(projectListing.getListingType())) {
/*  94 */       request.setMemberLevel(userCredit.getSellerCreditLevel());
/*  95 */       request.setGoodComment(userCredit.getSellerGoodNum());
/*  96 */       request.setBadComment(userCredit.getSellerBadNum());
/*     */     } else {
/*  98 */       request.setMemberLevel(userCredit.getBuyCreditLevel());
/*  99 */       request.setGoodComment(userCredit.getBuyGoodNum());
/* 100 */       request.setBadComment(userCredit.getBuyBadNum());
/*     */     }
/* 102 */     ProjectBaseSettingServiceResult projectBaseSettingServiceResult = this.remoteProjectBaseSettingService.getProjectBaseSet(request);
/* 103 */     if (projectBaseSettingServiceResult.error()) {
/* 104 */       return Long.valueOf(-1L);
/*     */     }
/* 106 */     ProjectBaseSettingDTO projectBaseSettingDTO = projectBaseSettingServiceResult.getProjectBaseSettingDTO();
/* 107 */     Long orderJyProportion = projectBaseSettingDTO.getOrderJyProportion();
/* 108 */     Money money = new Money();
/* 109 */     money.setCent(projectListing.getListingPrice().longValue() * projectListing.getQuantity().longValue());
/* 110 */     Long depositBig = Long.valueOf(money.multiply(orderJyProportion.longValue()).getCent());
/* 111 */     money.setCent(depositBig.longValue());
/* 112 */     Long deposit = Long.valueOf(money.divide(10000.0D).getCent());
/* 113 */     return deposit;
/*     */   }
/*     */ 
/*     */   public int modifyTradeWishOrder(TradeWishOrder tradeWishOrder, String userAccount)
/*     */   {
/* 118 */     final WishOrderAudit record = new WishOrderAudit();
/* 119 */     String processAuditNodes = "AFZ";
/*     */ 
/* 121 */     ProjectBaseSettingRequest pbsRequest = new ProjectBaseSettingRequest();
/* 122 */     pbsRequest.setTradingType(tradeWishOrder.getTradeType());
/* 123 */     ProjectBaseSettingServiceResult pbssResult = this.remoteProjectBaseSettingService.getProjectBaseSet(pbsRequest);
/* 124 */     if ((pbssResult != null) && (pbssResult.correct()) && (pbssResult.getProjectBaseSettingDTO() != null)) {
/* 125 */       processAuditNodes = pbssResult.getProjectBaseSettingDTO().getIntentionCheckProcess();
/*     */     }
/* 127 */     record.setProcessAuditNodes(processAuditNodes);
/*     */ 
/* 130 */     record.setAuditNode(record.getProcessAuditNodes().substring(0, 1));
/* 131 */     record.setOperator(userAccount);
/* 132 */     record.setOrderId(tradeWishOrder.getId());
/* 133 */     final TradeWishOrder query = tradeWishOrder;
/* 134 */     int result = ((Integer)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public Integer doInTransaction(TransactionStatus status) {
/*     */         try {
/* 137 */           TradeWishOrderServiceImpl.this.wishOrderAuditDAO.insert(record);
/* 138 */           return Integer.valueOf(TradeWishOrderServiceImpl.this.tradeWishOrderDAO.updateByPrimaryKey(query));
/*     */         } catch (Exception e) {
/* 140 */           status.setRollbackOnly();
/* 141 */           TradeWishOrderServiceImpl.this.log.error("modifyTradeWishOrder cause by:" + e);
/* 142 */         }return Integer.valueOf(0);
/*     */       }
/*     */     })).intValue();
/*     */ 
/* 146 */     return result;
/*     */   }
/*     */ 
/*     */   public String isApplyTime(Long projectId)
/*     */   {
/* 158 */     int startNum = this.projectMetasDAO.selectAfterApplyStartTime(projectId).intValue();
/* 159 */     if (startNum <= 0) {
/* 160 */       return EnumApplyTime.EARLY_THAN_START.getName();
/*     */     }
/* 162 */     int endNum = this.projectMetasDAO.selectBeforeApplyEndTime(projectId).intValue();
/* 163 */     if (endNum <= 0) {
/* 164 */       return EnumApplyTime.LATE_THAN_END.getName();
/*     */     }
/* 166 */     return EnumApplyTime.SUCCESS.getValue();
/*     */   }
/*     */ 
/*     */   public int changeWishOrderStatus(TradeWishOrder tradeWishOrder)
/*     */   {
/* 179 */     return this.tradeWishOrderDAO.updateStatusByOrderNum(tradeWishOrder);
/*     */   }
/*     */ 
/*     */   public int getCountOfMyWishOrder(TradeWishOrder query)
/*     */   {
/* 193 */     return this.tradeWishOrderDAO.selectCountOfOne(query);
/*     */   }
/*     */ 
/*     */   public int existsWishOrderBidBuyer(String projectCode, String userAccount)
/*     */   {
/* 203 */     Map paramMap = new HashMap();
/* 204 */     paramMap.put("projectCode", projectCode);
/* 205 */     paramMap.put("userAccount", userAccount);
/* 206 */     paramMap.put("statusList", EnumTradeWishOrderStatus.getBidstatus());
/* 207 */     return this.tradeWishOrderDAO.existsWishOrderBidBuyer(paramMap);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/* 211 */     Long long1 = Long.valueOf(130L);
/* 212 */     Long long2 = Long.valueOf(200L);
/* 213 */     Long rat = Long.valueOf(10000L);
/* 214 */     Money money = new Money();
/* 215 */     money.setCent(long1.longValue());
/* 216 */     Long aLong = Long.valueOf(money.multiply(long2.longValue()).getCent());
/* 217 */     money.setCent(aLong.longValue());
/* 218 */     System.out.println(money.divide(rat.longValue()).getCent());
/* 219 */     money.setCent(119L);
/* 220 */     System.out.println(money.divide(100.0D).getCent());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.trade.TradeWishOrderServiceImpl
 * JD-Core Version:    0.6.0
 */