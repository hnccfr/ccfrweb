/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.financing.FinancingDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.financing.FinancingLogDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.financing.Financing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.financing.FinancingLog;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.FinancingQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.financing.FinancingService;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumCheckCommonNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFinancingProcessNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFinancingStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumYesOrNo;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.ParseException;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Repository("financingService")
/*     */ public class FinancingServiceImpl extends BaseService
/*     */   implements FinancingService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private FinancingDAO financingDAO;
/*     */ 
/*     */   @Autowired
/*     */   private FinancingLogDAO financingLogDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   public void getFinancingList(FinancingQuery query)
/*     */   {
/*  49 */     this.financingDAO.selectByQuery(query);
/*     */   }
/*     */ 
/*     */   public Integer add(Financing financing, String operator)
/*     */   {
/*  55 */     BigDecimal applyAmountBD = new BigDecimal(financing.getApplyAmountDes());
/*  56 */     Long applyAmount = Long.valueOf(applyAmountBD.movePointRight(2).longValue());
/*  57 */     financing.setApplyAmount(applyAmount);
/*     */ 
/*  60 */     if (StringUtil.isNotBlank(financing.getLoanRateDes())) {
/*  61 */       BigDecimal loanRateBD = new BigDecimal(financing.getLoanRateDes());
/*  62 */       Long loanRate = Long.valueOf(loanRateBD.movePointRight(2).longValue());
/*  63 */       financing.setLoanRate(loanRate);
/*     */     }
/*     */ 
/*  67 */     Long applyLimit = Long.valueOf(financing.getApplyLimitDes());
/*  68 */     financing.setApplyLimit(applyLimit);
/*     */ 
/*  70 */     financing.setStatus(EnumFinancingStatus.CREATE.getValue());
/*  71 */     String processAuditNodes = "AFLZ";
/*     */ 
/*  74 */     SystemDictRequest dictRequest = new SystemDictRequest();
/*  75 */     SystemDictServiceResult dictResult = new SystemDictServiceResult();
/*  76 */     dictRequest.setParaCode(EnumSystemDictKey.FINANCING_AUDITPROCESS.getValue());
/*     */     try {
/*  78 */       dictResult = this.remoteSystemBaseService.selectSingleByKey(dictRequest);
/*  79 */       if (dictResult.correct()) {
/*  80 */         SystemDictDTO dictDto = dictResult.getSystemDictDTO();
/*  81 */         String paraV = dictDto.getParaValue();
/*  82 */         if (StringUtil.isNotEmpty(paraV)) {
/*  83 */           paraV = paraV + EnumCheckCommonNodes.END_NODE.getValue();
/*  84 */           processAuditNodes = paraV;
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/*  88 */       this.log.error("sysdict is null, error:", e);
/*     */     }
/*     */ 
/*  91 */     financing.setProcessAuditNodes(processAuditNodes);
/*     */ 
/*  93 */     financing.setAuditNode(EnumFinancingProcessNodes.ADVANCE.getValue());
/*     */ 
/*  95 */     financing.setCreator(operator);
/*  96 */     financing.setOperator(operator);
/*     */ 
/*  98 */     codeCreator(financing);
/*     */ 
/* 100 */     return this.financingDAO.insert(financing);
/*     */   }
/*     */ 
/*     */   public ServiceResult delete(Long id, String operator)
/*     */   {
/* 105 */     ServiceResult result = new ServiceResult();
/* 106 */     Financing srcFinancing = this.financingDAO.selectById(id);
/* 107 */     if (!srcFinancing.isCanDelete()) {
/* 108 */       result.setErrorNOInfo(Integer.valueOf(0), "该状态不可删除");
/* 109 */       return result;
/*     */     }
/*     */ 
/* 112 */     Financing financing = new Financing();
/* 113 */     financing.setId(id);
/* 114 */     financing.setOperator(operator);
/* 115 */     financing.setStatus(EnumFinancingStatus.DELETE.getValue());
/* 116 */     financing.setAuditNode(EnumFinancingProcessNodes.END.getValue());
/*     */ 
/* 118 */     Integer delRs = this.financingDAO.update(financing);
/* 119 */     if ((null == delRs) || (delRs.intValue() <= 0)) {
/* 120 */       result.setErrorNOInfo(Integer.valueOf(0), "删除融资失败");
/* 121 */       return result;
/*     */     }
/* 123 */     return result;
/*     */   }
/*     */ 
/*     */   public void codeCreator(Financing financing)
/*     */   {
/* 131 */     String code = "F";
/* 132 */     String dateStr = "00000000";
/*     */ 
/* 134 */     Long id = this.financingDAO.getNextId();
/* 135 */     String idStr = dateStr + id;
/* 136 */     idStr = idStr.substring(idStr.length() - 4);
/*     */     try {
/* 138 */       dateStr = CommonUtils.convertDateToString("yyyyMMdd", DateUtil.getCurrentDay().getTime());
/*     */     } catch (ParseException e) {
/* 140 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 143 */     financing.setId(id);
/* 144 */     financing.setCode(code + dateStr + idStr);
/*     */   }
/*     */ 
/*     */   public Financing getFinancingById(Long id)
/*     */   {
/* 149 */     Financing srcFinancing = this.financingDAO.selectById(id);
/* 150 */     List financingLogList = this.financingLogDAO.getByFinancingId(id);
/* 151 */     srcFinancing.setFinancingLogList(financingLogList);
/* 152 */     return srcFinancing;
/*     */   }
/*     */ 
/*     */   public Integer edit(Financing financing, String operator)
/*     */   {
/* 157 */     Financing paraFinancing = new Financing();
/* 158 */     Financing srcFinancing = this.financingDAO.selectById(financing.getId());
/*     */ 
/* 162 */     paraFinancing.setId(financing.getId());
/* 163 */     paraFinancing.setTitle(financing.getTitle());
/* 164 */     paraFinancing.setOperator(operator);
/* 165 */     paraFinancing.setGmtApply(financing.getGmtApply());
/* 166 */     paraFinancing.setGmtLoan(financing.getGmtLoan());
/* 167 */     paraFinancing.setGmtRepay(financing.getGmtRepay());
/* 168 */     paraFinancing.setUserName(financing.getUserName());
/* 169 */     paraFinancing.setUserTel(financing.getUserTel());
/* 170 */     paraFinancing.setUserAddress(financing.getUserAddress());
/* 171 */     paraFinancing.setGuaranteeName(financing.getGuaranteeName());
/* 172 */     paraFinancing.setGuaranteeTel(financing.getGuaranteeTel());
/* 173 */     paraFinancing.setGuaranteeAddress(financing.getGuaranteeAddress());
/* 174 */     paraFinancing.setRemark(financing.getRemark());
/*     */ 
/* 177 */     Long applyLimit = Long.valueOf(financing.getApplyLimitDes());
/* 178 */     paraFinancing.setApplyLimit(applyLimit);
/*     */ 
/* 181 */     if (EnumFinancingStatus.REPAY.getValue().equals(srcFinancing.getStatus()));
/* 184 */     Date gmtLoan = financing.getGmtLoan();
/* 185 */     if (gmtLoan != null) {
/* 186 */       Calendar cal = Calendar.getInstance();
/* 187 */       cal.setTime(gmtLoan);
/* 188 */       cal.add(5, applyLimit.intValue());
/* 189 */       Date newGmtLimit = cal.getTime();
/* 190 */       paraFinancing.setGmtLimit(newGmtLimit);
/*     */     }
/*     */ 
/* 194 */     BigDecimal applyAmountBD = new BigDecimal(financing.getApplyAmountDes());
/* 195 */     Long applyAmount = Long.valueOf(applyAmountBD.movePointRight(2).longValue());
/* 196 */     paraFinancing.setApplyAmount(applyAmount);
/*     */ 
/* 199 */     if (StringUtil.isNotBlank(financing.getLoanAmountDes())) {
/* 200 */       BigDecimal loanAmountBD = new BigDecimal(financing.getLoanAmountDes());
/* 201 */       Long loanAmount = Long.valueOf(loanAmountBD.movePointRight(2).longValue());
/* 202 */       paraFinancing.setLoanAmount(loanAmount);
/*     */     }
/*     */ 
/* 206 */     if (StringUtil.isNotBlank(financing.getRepayAmountDes())) {
/* 207 */       BigDecimal repayAmountBD = new BigDecimal(financing.getRepayAmountDes());
/* 208 */       Long repayAmount = Long.valueOf(repayAmountBD.movePointRight(2).longValue());
/* 209 */       paraFinancing.setRepayAmount(repayAmount);
/*     */     }
/*     */ 
/* 213 */     if (StringUtil.isNotBlank(financing.getLoanRateDes())) {
/* 214 */       BigDecimal loanRateBD = new BigDecimal(financing.getLoanRateDes());
/* 215 */       Long loanRate = Long.valueOf(loanRateBD.movePointRight(2).longValue());
/* 216 */       paraFinancing.setLoanRate(loanRate);
/*     */     }
/*     */ 
/* 219 */     return this.financingDAO.update(paraFinancing);
/*     */   }
/*     */ 
/*     */   public ServiceResult audit(FinancingLog financingLog, String userAccount)
/*     */   {
/* 224 */     Financing srcfinancing = this.financingDAO.selectById(financingLog.getFinancingId());
/*     */ 
/* 227 */     String processAuditNodes = srcfinancing.getProcessAuditNodes();
/*     */ 
/* 229 */     String curNode = srcfinancing.getAuditNode();
/* 230 */     int curNodeIndex = processAuditNodes.indexOf(curNode);
/* 231 */     String nextNode = null;
/* 232 */     String status = null;
/*     */ 
/* 234 */     if (EnumYesOrNo.YES.getValue().equals(financingLog.getAuditResult())) {
/* 235 */       nextNode = processAuditNodes.substring(curNodeIndex + 1, curNodeIndex + 2);
/* 236 */       if (EnumFinancingProcessNodes.LOAN.getValue().equals(nextNode)) {
/* 237 */         status = EnumFinancingStatus.LOAN.getValue();
/*     */       }
/*     */ 
/*     */     }
/* 241 */     else if (EnumYesOrNo.NO.getValue().equals(financingLog.getAuditResult())) {
/* 242 */       nextNode = EnumFinancingProcessNodes.END.getValue();
/* 243 */       status = EnumFinancingStatus.CLOSE.getValue();
/*     */     } else {
/* 245 */       return null;
/*     */     }
/*     */ 
/* 248 */     final Map paraFinancing = new HashMap();
/* 249 */     paraFinancing.put("id", financingLog.getFinancingId());
/* 250 */     paraFinancing.put("status", status);
/* 251 */     paraFinancing.put("auditNode", nextNode);
/* 252 */     paraFinancing.put("operator", userAccount);
/* 253 */     paraFinancing.put("where_status", srcfinancing.getStatus());
/* 254 */     paraFinancing.put("where_auditNode", srcfinancing.getAuditNode());
/*     */ 
/* 257 */     final FinancingLog paraLog = new FinancingLog();
/* 258 */     paraLog.setFinancingId(financingLog.getFinancingId());
/* 259 */     paraLog.setAuditNode(curNode);
/* 260 */     paraLog.setAuditResult(financingLog.getAuditResult());
/* 261 */     paraLog.setLogRemark(financingLog.getLogRemark());
/* 262 */     paraLog.setOperator(userAccount);
/*     */ 
/* 264 */     ServiceResult addResult = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public ServiceResult doInTransaction(TransactionStatus status) {
/* 266 */         Object savePoint = status.createSavepoint();
/* 267 */         ServiceResult result = new ServiceResult();
/*     */         try
/*     */         {
/* 270 */           FinancingServiceImpl.this.financingDAO.updateByMap(paraFinancing);
/*     */ 
/* 272 */           FinancingServiceImpl.this.financingLogDAO.insert(paraLog);
/*     */         } catch (Exception e) {
/* 274 */           e.printStackTrace();
/* 275 */           FinancingServiceImpl.this.log.debug(e.getMessage());
/* 276 */           status.rollbackToSavepoint(savePoint);
/* 277 */           return result;
/*     */         }
/* 279 */         return result;
/*     */       }
/*     */     });
/* 282 */     return addResult;
/*     */   }
/*     */ 
/*     */   public ServiceResult loan(Financing financing, FinancingLog financingLog, String userAccount)
/*     */   {
/* 288 */     Financing srcfinancing = this.financingDAO.selectById(financingLog.getFinancingId());
/*     */ 
/* 291 */     String processAuditNodes = srcfinancing.getProcessAuditNodes();
/*     */ 
/* 293 */     String curNode = srcfinancing.getAuditNode();
/* 294 */     int curNodeIndex = processAuditNodes.indexOf(curNode);
/* 295 */     String nextNode = null;
/* 296 */     String status = null;
/*     */ 
/* 298 */     if (EnumYesOrNo.YES.getValue().equals(financingLog.getAuditResult())) {
/* 299 */       nextNode = processAuditNodes.substring(curNodeIndex + 1, curNodeIndex + 2);
/* 300 */       status = EnumFinancingStatus.REPAY.getValue();
/*     */     }
/* 303 */     else if (EnumYesOrNo.NO.getValue().equals(financingLog.getAuditResult())) {
/* 304 */       nextNode = EnumFinancingProcessNodes.END.getValue();
/* 305 */       status = EnumFinancingStatus.CLOSE.getValue();
/*     */     } else {
/* 307 */       return null;
/*     */     }
/*     */ 
/* 310 */     final Map paraFinancing = new HashMap();
/* 311 */     paraFinancing.put("id", financingLog.getFinancingId());
/* 312 */     paraFinancing.put("status", status);
/* 313 */     paraFinancing.put("auditNode", nextNode);
/* 314 */     paraFinancing.put("operator", userAccount);
/* 315 */     paraFinancing.put("gmtLoan", financing.getGmtLoan());
/* 316 */     paraFinancing.put("where_status", srcfinancing.getStatus());
/* 317 */     paraFinancing.put("where_auditNode", srcfinancing.getAuditNode());
/*     */ 
/* 320 */     Long applyLimit = Long.valueOf(financing.getApplyLimitDes());
/* 321 */     paraFinancing.put("applyLimit", applyLimit);
/*     */ 
/* 324 */     if (StringUtil.isNotBlank(financing.getLoanRateDes())) {
/* 325 */       BigDecimal loanRateBD = new BigDecimal(financing.getLoanRateDes());
/* 326 */       Long loanRate = Long.valueOf(loanRateBD.movePointRight(2).longValue());
/* 327 */       paraFinancing.put("loanRate", loanRate);
/*     */     }
/*     */ 
/* 331 */     BigDecimal loanAmountBD = new BigDecimal(financing.getLoanAmountDes());
/* 332 */     Long loanAmount = Long.valueOf(loanAmountBD.movePointRight(2).longValue());
/* 333 */     paraFinancing.put("loanAmount", loanAmount);
/*     */ 
/* 336 */     Date gmtLoan = financing.getGmtLoan();
/* 337 */     if (gmtLoan != null) {
/* 338 */       Calendar cal = Calendar.getInstance();
/* 339 */       cal.setTime(gmtLoan);
/* 340 */       cal.add(5, applyLimit.intValue());
/* 341 */       Date newGmtLimit = cal.getTime();
/* 342 */       paraFinancing.put("gmtLimit", newGmtLimit);
/*     */     }
/*     */ 
/* 346 */     final FinancingLog paraLog = new FinancingLog();
/* 347 */     paraLog.setFinancingId(financingLog.getFinancingId());
/* 348 */     paraLog.setAuditNode(curNode);
/* 349 */     paraLog.setAuditResult(financingLog.getAuditResult());
/* 350 */     paraLog.setLogRemark(financingLog.getLogRemark());
/* 351 */     paraLog.setOperator(userAccount);
/*     */ 
/* 353 */     ServiceResult addResult = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public ServiceResult doInTransaction(TransactionStatus status) {
/* 355 */         Object savePoint = status.createSavepoint();
/* 356 */         ServiceResult result = new ServiceResult();
/*     */         try
/*     */         {
/* 359 */           FinancingServiceImpl.this.financingDAO.updateByMap(paraFinancing);
/*     */ 
/* 361 */           FinancingServiceImpl.this.financingLogDAO.insert(paraLog);
/*     */         } catch (Exception e) {
/* 363 */           e.printStackTrace();
/* 364 */           FinancingServiceImpl.this.log.debug(e.getMessage());
/* 365 */           status.rollbackToSavepoint(savePoint);
/* 366 */           return result;
/*     */         }
/* 368 */         return result;
/*     */       }
/*     */     });
/* 371 */     return addResult;
/*     */   }
/*     */ 
/*     */   public ServiceResult repay(Financing financing, FinancingLog financingLog, String userAccount)
/*     */   {
/* 378 */     final Map paraFinancing = new HashMap();
/* 379 */     paraFinancing.put("id", financingLog.getFinancingId());
/* 380 */     paraFinancing.put("status", EnumFinancingStatus.FINISH.getValue());
/* 381 */     paraFinancing.put("operator", userAccount);
/* 382 */     paraFinancing.put("gmtRepay", financing.getGmtRepay());
/* 383 */     paraFinancing.put("where_status", EnumFinancingStatus.REPAY.getValue());
/*     */ 
/* 386 */     BigDecimal repayAmountBD = new BigDecimal(financing.getRepayAmountDes());
/* 387 */     Long repayAmount = Long.valueOf(repayAmountBD.movePointRight(2).longValue());
/* 388 */     paraFinancing.put("repayAmount", repayAmount);
/*     */ 
/* 391 */     final FinancingLog paraLog = new FinancingLog();
/* 392 */     paraLog.setFinancingId(financingLog.getFinancingId());
/* 393 */     paraLog.setAuditNode(EnumFinancingProcessNodes.END.getValue());
/* 394 */     paraLog.setAuditResult(financingLog.getAuditResult());
/* 395 */     paraLog.setLogRemark(financingLog.getLogRemark());
/* 396 */     paraLog.setOperator(userAccount);
/*     */ 
/* 398 */     ServiceResult addResult = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public ServiceResult doInTransaction(TransactionStatus status) {
/* 400 */         Object savePoint = status.createSavepoint();
/* 401 */         ServiceResult result = new ServiceResult();
/*     */         try
/*     */         {
/* 404 */           FinancingServiceImpl.this.financingDAO.updateByMap(paraFinancing);
/*     */ 
/* 406 */           FinancingServiceImpl.this.financingLogDAO.insert(paraLog);
/*     */         } catch (Exception e) {
/* 408 */           e.printStackTrace();
/* 409 */           FinancingServiceImpl.this.log.debug(e.getMessage());
/* 410 */           status.rollbackToSavepoint(savePoint);
/* 411 */           return result;
/*     */         }
/* 413 */         return result;
/*     */       }
/*     */     });
/* 416 */     return addResult;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.financing.FinancingServiceImpl
 * JD-Core Version:    0.6.0
 */