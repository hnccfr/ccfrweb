/*     */ package com.hundsun.network.gates.houchao.biz.manager.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyTotalHisDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundQueryDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoneyTotalHis;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.query.FundInOutDetailQuery;
/*     */ import com.hundsun.network.gates.houchao.biz.manager.AccountQueryManager;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFundResultCode;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMoneyType;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.dto.FundQueryDTO;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryPageRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundInOutQueryResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundQueryResult;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("accountQueryManager")
/*     */ public class AccountQueryManagerImpl
/*     */   implements AccountQueryManager
/*     */ {
/*  42 */   private Log log = LogFactory.getLog(AccountQueryManagerImpl.class);
/*     */ 
/*     */   @Autowired
/*     */   private FundMoneyDAO fundMoneyDAO;
/*     */ 
/*     */   @Autowired
/*     */   private FundQueryDAO fundQueryDAO;
/*     */ 
/*     */   @Autowired
/*     */   private FundMoneyTotalHisDAO fundMoneyTotalHisDAO;
/*     */ 
/*  59 */   public FundQueryResult queryFundByTrader(FundQueryRequest request) { FundQueryResult fundQueryResult = new FundQueryResult();
/*     */ 
/*  61 */     if (request == null) {
/*  62 */       fundQueryResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  63 */       fundQueryResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  64 */       this.log.error("queryFundByTrader request params is null!");
/*  65 */       return fundQueryResult;
/*     */     }
/*     */ 
/*  68 */     if (StringUtil.isBlank(request.getFundAccount())) {
/*  69 */       fundQueryResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  70 */       fundQueryResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  71 */       this.log.error("queryFundByTrader request params is error, fundAccount:" + request.getFundAccount());
/*  72 */       return fundQueryResult;
/*     */     }
/*     */ 
/*  75 */     if (StringUtil.isBlank(request.getTradeDate())) {
/*  76 */       fundQueryResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/*  77 */       fundQueryResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/*  78 */       this.log.error("queryFundByTrader request params is error, tradeDate:" + request.getTradeDate());
/*  79 */       return fundQueryResult;
/*     */     }
/*     */ 
/*  83 */     List<FundMoneyTotalHis> list = this.fundMoneyTotalHisDAO.queryByFundMoneyHisWithTradeDate(request.getFundAccount(), request.getTradeDate());
/*     */ 
/*  86 */     List result_list = new ArrayList();
/*     */ 
/*  88 */     if ((list == null) || (list.size() <= 0)) {
/*  89 */       fundQueryResult.setFundRecords(result_list);
/*     */ 
/*  91 */       fundQueryResult.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/*  92 */       fundQueryResult.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*     */ 
/*  94 */       return fundQueryResult;
/*     */     }
/*     */ 
/*  98 */     List trade_date_list = new ArrayList();
/*     */ 
/* 100 */     for (FundMoneyTotalHis fundMoneyTotalHis : list) {
/* 101 */       FundQueryDTO fundQueryDTO = new FundQueryDTO();
/* 102 */       fundQueryDTO.setFundAccount(fundMoneyTotalHis.getFundAccount());
/* 103 */       fundQueryDTO.setTradeDate(fundMoneyTotalHis.getTradeDate());
/* 104 */       fundQueryDTO.setBeginAmount(fundMoneyTotalHis.getBeginAmount());
/* 105 */       fundQueryDTO.setAmount(fundMoneyTotalHis.getAmount());
/* 106 */       fundQueryDTO.setCurrAmount(fundMoneyTotalHis.getAmount());
/* 107 */       fundQueryDTO.setUseBalance(Long.valueOf(fundMoneyTotalHis.getAmount().longValue() - fundMoneyTotalHis.getFreezeTotal().longValue()));
/* 108 */       fundQueryDTO.setFreezeTotal(fundMoneyTotalHis.getFreezeTotal());
/* 109 */       fundQueryDTO.setFundinAmount(Long.valueOf(0L));
/* 110 */       fundQueryDTO.setFundoutAmount(Long.valueOf(0L));
/* 111 */       fundQueryDTO.setGoodsFundin(Long.valueOf(0L));
/* 112 */       fundQueryDTO.setGoodsFundout(Long.valueOf(0L));
/* 113 */       fundQueryDTO.setCommissionAmount(Long.valueOf(0L));
/* 114 */       fundQueryDTO.setPenaltyFundin(Long.valueOf(0L));
/* 115 */       fundQueryDTO.setPenaltyFundout(Long.valueOf(0L));
/*     */ 
/* 118 */       if ((fundQueryDTO.getTradeDate() != null) && (!"".equals(fundQueryDTO.getTradeDate()))) {
/* 119 */         trade_date_list.add(fundQueryDTO.getTradeDate());
/*     */       }
/*     */ 
/* 122 */       result_list.add(fundQueryDTO);
/*     */     }
/*     */ 
/* 125 */     if ((trade_date_list == null) || (trade_date_list.size() <= 0)) {
/* 126 */       fundQueryResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 127 */       fundQueryResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 128 */       this.log.error("trade_date_list params is null!");
/* 129 */       return fundQueryResult;
/*     */     }
/*     */ 
/* 133 */     List<FundMoneyTotalHis> fund_money_total_his_list = this.fundMoneyTotalHisDAO.queryByFundMoneyTotalHisWithTradeDate(request.getFundAccount(), trade_date_list);
/*     */ 		
				FundQueryDTO fundQueryDTO;
/* 135 */     for (Iterator i$ = result_list.iterator(); i$.hasNext(); ) { 
					fundQueryDTO = (FundQueryDTO)i$.next();
/*     */ 
/* 137 */       for (FundMoneyTotalHis fundMoneyTotalHis : fund_money_total_his_list)
/*     */       {
/* 139 */         if ((fundQueryDTO.getTradeDate().equals(fundMoneyTotalHis.getTradeDate())) && (fundQueryDTO.getFundAccount().equals(fundMoneyTotalHis.getFundAccount())))
/*     */         {
/* 142 */           fundQueryDTO.setFundinAmount(fundMoneyTotalHis.getFundinAmount());
/* 143 */           fundQueryDTO.setFundoutAmount(fundMoneyTotalHis.getFundoutAmount());
/* 144 */           fundQueryDTO.setGoodsFundin(Long.valueOf(fundMoneyTotalHis.getGoodsFinal().longValue() + fundMoneyTotalHis.getGoodsFundin().longValue()));
/* 145 */           fundQueryDTO.setGoodsFundout(fundMoneyTotalHis.getGoodsFundout());
/* 146 */           fundQueryDTO.setCommissionAmount(fundMoneyTotalHis.getCommissionFundin().longValue() == 0L ? fundMoneyTotalHis.getCommissionFundout() : fundMoneyTotalHis.getCommissionFundin());
/* 147 */           fundQueryDTO.setPenaltyFundin(fundMoneyTotalHis.getPenaltyFundin());
/* 148 */           fundQueryDTO.setPenaltyFundout(fundMoneyTotalHis.getPenaltyFundout());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 179 */     fundQueryResult.setFundRecords(result_list);
/*     */ 
/* 181 */     fundQueryResult.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/* 182 */     fundQueryResult.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/*     */ 
/* 184 */     return fundQueryResult;
/*     */   }
/*     */ 
/*     */   public FundQueryResult useBalanceCalculate(FundQueryRequest request)
/*     */   {
/* 194 */     FundQueryResult fundQueryResult = new FundQueryResult();
/* 195 */     if (null == request) {
/* 196 */       fundQueryResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 197 */       fundQueryResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 198 */       this.log.error("useBalanceCalculate request params is null!");
/* 199 */       return fundQueryResult;
/*     */     }
/*     */ 
/* 202 */     if (StringUtil.isBlank(request.getFundAccount())) {
/* 203 */       fundQueryResult.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 204 */       fundQueryResult.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 205 */       this.log.error("useBalanceCalculate request params is error, FundAccount:" + request.getFundAccount());
/* 206 */       return fundQueryResult;
/*     */     }
/*     */ 
/* 209 */     FundMoney fundMoney = this.fundMoneyDAO.getByFundAccountWithMoneyType(request.getFundAccount(), EnumMoneyType.CNY.getCode());
/* 210 */     fundQueryResult.setFundAccount(fundMoney.getFundAccount());
/* 211 */     fundQueryResult.setAmount(fundMoney.getAmount());
/* 212 */     fundQueryResult.setFreezeAmount(fundMoney.getFreezeTotal());
/*     */ 
/* 214 */     if (fundMoney.getAmount().longValue() - fundMoney.getFreezeTotal().longValue() >= 0L)
/* 215 */       fundQueryResult.setUsedBalance(Long.valueOf(fundMoney.getAmount().longValue() - fundMoney.getFreezeTotal().longValue()));
/*     */     else {
/* 217 */       fundQueryResult.setUsedBalance(Long.valueOf(0L));
/*     */     }
/* 219 */     fundQueryResult.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/* 220 */     fundQueryResult.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/* 221 */     return fundQueryResult;
/*     */   }
/*     */ 
/*     */   public FundInOutQueryResult fundInOutQuery(FundQueryPageRequest request)
/*     */   {
/* 231 */     FundInOutQueryResult result = new FundInOutQueryResult();
/* 232 */     if ((null == request) || (StringUtil.isBlank(request.getFundAccount())) || (null == request.getStartDate()) || (null == request.getEndDate()))
/*     */     {
/* 234 */       result.setErrorNO(EnumFundResultCode.REQUEST_PARAM_ERROR.getCode());
/* 235 */       result.setErrorInfo(EnumFundResultCode.REQUEST_PARAM_ERROR.getDescription());
/* 236 */       this.log.error("fundInOutQuery request params is blank, params : " + request);
/* 237 */       return result;
/*     */     }
/*     */ 
/* 240 */     FundInOutDetailQuery fundInOutDetailQuery = new FundInOutDetailQuery();
/* 241 */     fundInOutDetailQuery.setFundAccount(request.getFundAccount());
/* 242 */     fundInOutDetailQuery.setStartDate(request.getStartDate());
/* 243 */     fundInOutDetailQuery.setEndDate(request.getEndDate());
/* 244 */     if (null != request.getPageSize())
/* 245 */       fundInOutDetailQuery.setPageSize(request.getPageSize().intValue());
/* 246 */     if (null != request.getPageNo()) {
/* 247 */       fundInOutDetailQuery.setPageNo(request.getPageNo().intValue());
/*     */     }
/* 249 */     int totalCount = this.fundQueryDAO.queryFundInOutTotal(fundInOutDetailQuery);
/* 250 */     int maxPageNo = totalCount / request.getPageSize().intValue();
/* 251 */     if ((totalCount % request.getPageSize().intValue() != 0) || (maxPageNo == 0)) {
/* 252 */       maxPageNo++;
/*     */     }
/* 254 */     if (request.getPageNo().intValue() > maxPageNo) {
/* 255 */       request.setPageNo(Integer.valueOf(maxPageNo));
/*     */     }
/* 257 */     this.fundQueryDAO.queryFundInOut(fundInOutDetailQuery);
/* 258 */     result.setFundRecords(fundInOutDetailQuery.getData());
/*     */ 
/* 260 */     result.setFundCount(Integer.valueOf(totalCount));
/* 261 */     result.setErrorNO(EnumFundResultCode.FUND_SUCCESS.getCode());
/* 262 */     result.setErrorInfo(EnumFundResultCode.FUND_SUCCESS.getDescription());
/* 263 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.manager.pojo.AccountQueryManagerImpl
 * JD-Core Version:    0.6.0
 */