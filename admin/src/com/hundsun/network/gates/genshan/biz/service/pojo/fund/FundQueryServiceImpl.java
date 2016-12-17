/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.fund.FundQueryDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountMsg;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountReport;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundSettlement;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.query.FundAccountLogQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.fund.FundQueryService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("fundQueryService")
/*     */ public class FundQueryServiceImpl
/*     */   implements FundQueryService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private FundQueryDAO fundQueryDAO;
/*     */ 
/*     */   public FundSettlement queryFundSettlement(String tradeDate)
/*     */   {
/*  39 */     return this.fundQueryDAO.queryFundSettlement(tradeDate);
/*     */   }
/*     */ 
/*     */   public void queryFundAccountLogList(FundAccountLogQuery fundAccountLogQuery)
/*     */   {
/*  48 */     if (!StringUtil.isBlank(fundAccountLogQuery.getFundAccount())) {
/*  49 */       fundAccountLogQuery.setFundAccount(StringUtil.trim(fundAccountLogQuery.getFundAccount()));
/*     */     }
/*  51 */     if (StringUtil.isBlank(fundAccountLogQuery.getBizNo())) {
/*  52 */       fundAccountLogQuery.setBizNo(StringUtil.trim(fundAccountLogQuery.getBizNo()));
/*     */     }
/*  54 */     this.fundQueryDAO.queryFundAccountLogList(fundAccountLogQuery);
/*     */   }
/*     */ 
/*     */   public FundAccountMsg queryFundAccountMsg(String fundAccount, String userAccount)
/*     */   {
/*  64 */     if (!StringUtil.isBlank(fundAccount)) {
/*  65 */       fundAccount = StringUtil.trim(fundAccount);
/*     */     }
/*  67 */     if (!StringUtil.isBlank(userAccount)) {
/*  68 */       userAccount = StringUtil.trim(userAccount);
/*     */     }
/*  70 */     return this.fundQueryDAO.queryFundAccountMsg(fundAccount, userAccount);
/*     */   }
/*     */ 
/*     */   public FundAccountReport queryFundAccountReport(String userAccount, String fundAccount, String tradeDate)
/*     */   {
/*  81 */     FundAccountReport fundMoneyHisReport = this.fundQueryDAO.queryFundMoneyHisReport(userAccount, fundAccount, tradeDate);
/*  82 */     if (fundMoneyHisReport == null) {
/*  83 */       return fundMoneyHisReport;
/*     */     }
/*     */ 
/*  86 */     fundMoneyHisReport.setCurrAmount(fundMoneyHisReport.getAmount());
/*  87 */     fundMoneyHisReport.setUseBalance(Long.valueOf(fundMoneyHisReport.getAmount().longValue() - fundMoneyHisReport.getFreezeTotal().longValue()));
/*     */ 
/*  90 */     fundMoneyHisReport.setOpenAmout(Long.valueOf(0L));
/*  91 */     fundMoneyHisReport.setCloseAmount(Long.valueOf(0L));
/*     */ 
/*  93 */     fundMoneyHisReport.setFundinAmount(Long.valueOf(0L));
/*  94 */     fundMoneyHisReport.setFundoutAmount(Long.valueOf(0L));
/*     */ 
/*  96 */     fundMoneyHisReport.setWriteofAmount(Long.valueOf(0L));
/*     */ 
/*  98 */     fundMoneyHisReport.setGoodsFinal(Long.valueOf(0L));
/*  99 */     fundMoneyHisReport.setGoodsFundin(Long.valueOf(0L));
/* 100 */     fundMoneyHisReport.setGoodsFundout(Long.valueOf(0L));
/*     */ 
/* 102 */     fundMoneyHisReport.setPenaltyFundin(Long.valueOf(0L));
/* 103 */     fundMoneyHisReport.setPenaltyFundout(Long.valueOf(0L));
/*     */ 
/* 105 */     fundMoneyHisReport.setCommissionAmount(Long.valueOf(0L));
/* 106 */     fundMoneyHisReport.setCommissionFundin(Long.valueOf(0L));
/* 107 */     fundMoneyHisReport.setCommissionFundout(Long.valueOf(0L));
/*     */ 
/* 109 */     fundMoneyHisReport.setFreezeDeposit(Long.valueOf(0L));
/* 110 */     fundMoneyHisReport.setUnfreezeDeposit(Long.valueOf(0L));
/*     */ 
/* 112 */     fundMoneyHisReport.setDeliveryFreezedeposit(Long.valueOf(0L));
/* 113 */     fundMoneyHisReport.setDeliveryUnfreezedeposit(Long.valueOf(0L));
/*     */ 
/* 116 */     FundAccountReport fundMoneyTotalHisReport = this.fundQueryDAO.queryFundMoneyTotalHisReport(fundAccount, tradeDate);
/*     */ 
/* 118 */     if (fundMoneyTotalHisReport != null)
/*     */     {
/* 120 */       fundMoneyHisReport.setOpenAmout(fundMoneyTotalHisReport.getOpenAmout());
/* 121 */       fundMoneyHisReport.setCloseAmount(fundMoneyTotalHisReport.getCloseAmount());
/* 122 */       fundMoneyHisReport.setFundinAmount(fundMoneyTotalHisReport.getFundinAmount());
/* 123 */       fundMoneyHisReport.setFundoutAmount(fundMoneyTotalHisReport.getFundoutAmount());
/* 124 */       fundMoneyHisReport.setWriteofAmount(fundMoneyTotalHisReport.getWriteofAmount());
/*     */ 
/* 126 */       fundMoneyHisReport.setGoodsFinal(fundMoneyTotalHisReport.getGoodsFinal());
/* 127 */       fundMoneyHisReport.setGoodsFundin(fundMoneyTotalHisReport.getGoodsFundin());
/* 128 */       fundMoneyHisReport.setGoodsFundout(fundMoneyTotalHisReport.getGoodsFundout());
/*     */ 
/* 130 */       fundMoneyHisReport.setPenaltyFundin(fundMoneyTotalHisReport.getPenaltyFundin());
/* 131 */       fundMoneyHisReport.setPenaltyFundout(fundMoneyTotalHisReport.getPenaltyFundout());
/*     */ 
/* 133 */       fundMoneyHisReport.setCommissionAmount(fundMoneyTotalHisReport.getCommissionFundin().longValue() == 0L ? fundMoneyTotalHisReport.getCommissionFundout() : fundMoneyTotalHisReport.getCommissionFundin());
/*     */ 
/* 135 */       fundMoneyHisReport.setFreezeDeposit(fundMoneyTotalHisReport.getFreezeDeposit());
/* 136 */       fundMoneyHisReport.setUnfreezeDeposit(fundMoneyTotalHisReport.getUnfreezeDeposit());
/*     */ 
/* 138 */       fundMoneyHisReport.setDeliveryFreezedeposit(fundMoneyTotalHisReport.getDeliveryFreezedeposit());
/* 139 */       fundMoneyHisReport.setDeliveryUnfreezedeposit(fundMoneyTotalHisReport.getDeliveryUnfreezedeposit());
/*     */     }
/*     */ 
/* 150 */     return fundMoneyHisReport;
/*     */   }
/*     */ 
/*     */   public FundAccountReport queryFundMoneyHisReportTotal(String tradeDate)
/*     */   {
/* 160 */     return this.fundQueryDAO.queryFundMoneyHisReportTotal(tradeDate);
/*     */   }
/*     */ 
/*     */   public FundAccountReport queryFundMoneyTotalHisReportTotal(String tradeDate)
/*     */   {
/* 170 */     return this.fundQueryDAO.queryFundMoneyTotalHisReportTotal(tradeDate);
/*     */   }
/*     */ 
/*     */   public FundSettlement queryPlatformSettlement(String startTradeDate, String endTradeDate)
/*     */   {
/* 180 */     return this.fundQueryDAO.queryPlatformSettlement(startTradeDate, endTradeDate);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.fund.FundQueryServiceImpl
 * JD-Core Version:    0.6.0
 */