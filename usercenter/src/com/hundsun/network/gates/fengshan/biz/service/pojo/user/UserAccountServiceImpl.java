/*     */ package com.hundsun.network.gates.fengshan.biz.service.pojo.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.message.SystemMessageDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderCcDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.supplydemand.SupplyDemandInfoDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserCreditDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserLevelDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserRolePermissionDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionMulitBidProjectQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.EvaluateQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectListingQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandInfoQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.SystemMessageQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderCcQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeWishOrderQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserCredit;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserLevel;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserLogin;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumSystemMessageStatus;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.common.MailService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.fengshan.web.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInfoStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundQueryResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundQueryService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserAccountDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumCancleAccount;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserActivateRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLoginRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserRegisterRequset;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserResetPasswordRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.CancleAccountResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Repository;
/*     */ import org.springframework.ui.Model;
/*     */ 
/*     */ @Repository("userAccountService")
/*     */ public class UserAccountServiceImpl extends BaseService
/*     */   implements UserAccountService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   private UserRolePermissionDAO userRolePermissionDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountDAO userAccountDAO;
/*     */ 
/*     */   @Autowired
/*     */   private MailService mailService;
/*     */ 
/*     */   @Autowired
/*     */   private UserLevelDAO userLevelDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UserCreditDAO userCreditDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundQueryService remoteFundQueryService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemMessageDAO systemMessageDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingDAO projectListingDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderDAO tradeWishOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderCcDAO tradeOrderCcDAO;
/*     */ 
/*     */   @Autowired
/*     */   private SupplyDemandInfoDAO supplyDemandInfoDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   public UserServiceResult login(UserLogin userLogin)
/*     */   {
/*  96 */     UserServiceResult result = new UserServiceResult();
/*  97 */     if (null == userLogin) {
/*  98 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/*  99 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 100 */       return result;
/*     */     }
/* 102 */     UserLoginRequest request = new UserLoginRequest();
/* 103 */     request.setLoginIp(userLogin.getLoginIp());
/* 104 */     request.setUserAccount(userLogin.getAccount());
/* 105 */     request.setPassword(userLogin.getPassword());
/*     */     try {
/* 107 */       result = this.remoteUserService.login(request);
/*     */     } catch (Exception e) {
/* 109 */       this.log.error("", e);
/* 110 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 111 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 112 */       return result;
/*     */     }
/* 114 */     return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult register(UserAccount userAccount)
/*     */   {
/* 119 */     UserServiceResult result = new UserServiceResult();
/* 120 */     if (null == userAccount) {
/* 121 */       return null;
/*     */     }
/*     */ 
/* 124 */     UserRegisterRequset request = ConvertUtils.convertUAccount2RegRequest(userAccount);
/*     */     try
/*     */     {
/* 127 */       result = this.remoteUserService.register(request);
/*     */     } catch (Exception e) {
/* 129 */       e.printStackTrace();
/* 130 */       this.log.error("", e);
/* 131 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 132 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 133 */       return result;
/*     */     }
/* 135 */     if ((result.correct()) && 
/* 136 */       (null == result.getUserAccountDTO())) {
/* 137 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 138 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 139 */       return result;
/*     */     }
/*     */ 
/* 142 */     boolean isActive = result.getUserAccountDTO().isShouldActive();
/* 143 */     if (isActive) {
/*     */       try
/*     */       {
/* 146 */         this.mailService.sendActivateMail(userAccount.getAccount());
/*     */       } catch (Exception e) {
/* 148 */         e.printStackTrace();
/* 149 */         this.log.error("", e);
/*     */       }
/*     */     }
/* 152 */     return result;
/*     */   }
/*     */ 
/*     */   public List<Integer> getUserPermissions(Long userId)
/*     */   {
/* 157 */     return this.userRolePermissionDAO.getUserPermissions(userId);
/*     */   }
/*     */ 
/*     */   public Long selectByParaMap(Map<String, Object> map)
/*     */   {
/* 163 */     return this.userAccountDAO.selectByParaMap(map);
/*     */   }
/*     */ 
/*     */   public ServiceResult activate(String account, String activeCode)
/*     */   {
/* 169 */     ServiceResult result = new ServiceResult();
/* 170 */     if ((StringUtil.isEmpty(account)) || (StringUtil.isEmpty(activeCode))) {
/* 171 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 172 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 173 */       return result;
/*     */     }
/* 175 */     UserActivateRequest request = new UserActivateRequest();
/* 176 */     request.setAccount(account);
/* 177 */     request.setActiveCode(activeCode);
/*     */     try {
/* 179 */       result = this.remoteUserService.activate(request);
/*     */     } catch (Exception e) {
/* 181 */       this.log.error("", e);
/* 182 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 183 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 184 */       return result;
/*     */     }
/* 186 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult resetPassword(String account, String oldPassword, String newPassword)
/*     */   {
/* 191 */     ServiceResult result = new ServiceResult();
/* 192 */     if ((StringUtil.isEmpty(account)) || (StringUtil.isEmpty(oldPassword)) || (StringUtil.isEmpty(newPassword)))
/*     */     {
/* 194 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 195 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 196 */       return result;
/*     */     }
/* 198 */     UserResetPasswordRequest request = new UserResetPasswordRequest();
/* 199 */     request.setAccount(account);
/* 200 */     request.setOldPassword(oldPassword);
/* 201 */     request.setNewPassword(newPassword);
/*     */     try {
/* 203 */       result = this.remoteUserService.resetPassword(request);
/*     */     } catch (Exception e) {
/* 205 */       this.log.error("", e);
/* 206 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 207 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 208 */       return result;
/*     */     }
/* 210 */     return result;
/*     */   }
/*     */ 
/*     */   public UserAccount getUserAccountByAccount(String account)
/*     */   {
/* 215 */     return this.userAccountDAO.selectByAccount(account);
/*     */   }
/*     */ 
/*     */   public int changeUserAccount(UserAccount userAccount)
/*     */   {
/* 220 */     return this.userAccountDAO.updateByUserAccount(userAccount);
/*     */   }
/*     */ 
/*     */   public UserLevel getUserLevelByUserAccount(String userAccount)
/*     */   {
/* 225 */     return this.userLevelDAO.selectByUserAccount(userAccount);
/*     */   }
/*     */ 
/*     */   public UserCredit getUserCreditLevelUserAccount(String userAccount)
/*     */   {
/* 230 */     return this.userCreditDAO.selectByUserAccount(userAccount);
/*     */   }
/*     */ 
/*     */   public void getEvaluateList(EvaluateQuery query)
/*     */   {
/* 235 */     this.userCreditDAO.selectEvaluateList(query);
/*     */   }
/*     */ 
/*     */   public UserAccount getFundInfoByAccount(String account)
/*     */   {
/* 240 */     return this.userAccountDAO.selectFundAccountInfoByAccount(account);
/*     */   }
/*     */ 
/*     */   public UserAccount getUserAccountById(Long id)
/*     */   {
/* 245 */     return this.userAccountDAO.selectByPrimaryKey(id);
/*     */   }
/*     */ 
/*     */   public CancleAccountResult applyCancle(UserAccount account, String fundAccount)
/*     */   {
/* 250 */     CancleAccountResult result = new CancleAccountResult();
/* 251 */     if (account.getStatus().equals(EnumUserStatus.Unfund.getValue())) {
/* 252 */       account.setStatus(EnumUserStatus.Delete.getValue());
/* 253 */       int number = this.userAccountDAO.updateByUserAccount(account);
/* 254 */       if (number <= 0) {
/* 255 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 256 */         result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 257 */         return result;
/*     */       }
/* 259 */       result.setResult(EnumCancleAccount.CANCLE_SUCCESS.getValue());
/* 260 */       return result;
/*     */     }
/* 262 */     UserLoginRequest request = new UserLoginRequest();
/* 263 */     request.setUserAccount(account.getAccount());
/* 264 */     FundQueryRequest fundQueryRequest = new FundQueryRequest();
/* 265 */     fundQueryRequest.setClientID(account.getAccount());
/* 266 */     fundQueryRequest.setFundAccount(fundAccount);
/* 267 */     FundQueryResult fundQueryResult = this.remoteFundQueryService.useBalanceCalculate(fundQueryRequest);
/* 268 */     if (fundQueryResult.isError()) {
/* 269 */       result.setErrorNO(Integer.valueOf(Integer.parseInt(fundQueryResult.getErrorNO())));
/* 270 */       result.setErrorInfo(fundQueryResult.getErrorInfo());
/* 271 */       return result;
/*     */     }
/* 273 */     if ((null == fundQueryResult) || ((fundQueryResult.getUsedBalance().equals(Long.valueOf(0L))) && (fundQueryResult.getFreezeAmount().equals(Long.valueOf(0L))))) {
/* 274 */       result = this.remoteUserService.applyCancleAccount(request);
/* 275 */       return result;
/*     */     }
/* 277 */     result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_DELETE_FUNDACCOUNT_NOT_FREE.getValue()));
/* 278 */     result.setErrorInfo(EnumUserResultErrors.USER_DELETE_FUNDACCOUNT_NOT_FREE.getInfo());
/* 279 */     result.setResult(EnumCancleAccount.CANCLE_ERROR.getValue());
/* 280 */     return result;
/*     */   }
/*     */ 
/*     */   public void initIssueTodo(Model model, String account)
/*     */   {
/* 292 */     model.addAttribute("buyType", EnumListingType.BUY.getValue());
/* 293 */     model.addAttribute("sellType", EnumListingType.SELL.getValue());
/*     */ 
/* 296 */     SystemMessageQuery msgQuery = new SystemMessageQuery();
/* 297 */     msgQuery.setStatus(EnumSystemMessageStatus.NOTREAD.getValue());
/* 298 */     msgQuery.setReceiveAccount(account);
/* 299 */     Integer msgNumber = this.systemMessageDAO.getNumByQuery(msgQuery);
/* 300 */     model.addAttribute("msgNumber", msgNumber);
/* 301 */     model.addAttribute("msgStatus", EnumSystemMessageStatus.NOTREAD.getValue());
/*     */ 
/* 304 */     ProjectListingQuery proQuery = new ProjectListingQuery();
/* 305 */     proQuery.setStatus(EnumProjectStatus.CREATE.getValue());
/* 306 */     proQuery.setUserAccount(account);
/* 307 */     proQuery.setListingType(EnumListingType.BUY.getValue());
/* 308 */     Integer buyProNumber = this.projectListingDAO.getNumByQuery(proQuery);
/* 309 */     model.addAttribute("buyProNumber", buyProNumber);
/* 310 */     proQuery.setListingType(EnumListingType.SELL.getValue());
/* 311 */     Integer sellProNumber = this.projectListingDAO.getNumByQuery(proQuery);
/* 312 */     model.addAttribute("sellProNumber", sellProNumber);
/* 313 */     model.addAttribute("proStatus", EnumProjectStatus.CREATE.getValue());
/*     */ 
/* 316 */     TradeWishOrderQuery twoQuery = new TradeWishOrderQuery();
/* 317 */     twoQuery.setStatus(EnumTradeWishOrderStatus.CREATE.getValue());
/* 318 */     twoQuery.setUserAccount(account);
/* 319 */     twoQuery.setTradeDictor(EnumListingType.BUY.getValue());
/* 320 */     Integer buyTwoNumber = this.tradeWishOrderDAO.getNumByQuery(twoQuery);
/* 321 */     model.addAttribute("buyTwoNumber", buyTwoNumber);
/* 322 */     twoQuery.setTradeDictor(EnumListingType.SELL.getValue());
/* 323 */     Integer sellTwoNumber = this.tradeWishOrderDAO.getNumByQuery(twoQuery);
/* 324 */     model.addAttribute("sellTwoNumber", sellTwoNumber);
/* 325 */     model.addAttribute("twoStatus", EnumTradeWishOrderStatus.CREATE.getValue());
/*     */ 
/* 328 */     TradeOrderCcQuery tocQuery = new TradeOrderCcQuery();
/* 329 */     tocQuery.setStatus(EnumTradeOrderCcStatus.SUBMIT.getValue());
/* 330 */     tocQuery.setComplainedType(EnumListingType.BUY.getValue());
/* 331 */     tocQuery.setBuyerAccount(account);
/* 332 */     Integer buyTocNumber = this.tradeOrderCcDAO.getNumByQuery(tocQuery);
/* 333 */     model.addAttribute("buyTocNumber", buyTocNumber);
/* 334 */     tocQuery.setComplainedType(EnumListingType.SELL.getValue());
/* 335 */     tocQuery.setBuyerAccount(null);
/* 336 */     tocQuery.setSellerAccount(account);
/* 337 */     Integer sellTocNumber = this.tradeOrderCcDAO.getNumByQuery(tocQuery);
/* 338 */     model.addAttribute("sellTocNumber", sellTocNumber);
/* 339 */     model.addAttribute("tocStatus", EnumTradeOrderCcStatus.SUBMIT.getValue());
/*     */ 
/* 342 */     SupplyDemandInfoQuery supQuery = new SupplyDemandInfoQuery();
/* 343 */     supQuery.setStatus(EnumInfoStatus.CREATE.getValue());
/* 344 */     supQuery.setPublisherAccount(account);
/* 345 */     Integer supNumber = this.supplyDemandInfoDAO.getNumByQuery(supQuery);
/* 346 */     model.addAttribute("supNumber", supNumber);
/* 347 */     model.addAttribute("supStatus", EnumInfoStatus.CREATE.getValue());
/*     */ 
/* 350 */     model.addAttribute("confirmStatus", EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue());
/* 351 */     TradeOrderQuery toQuery = new TradeOrderQuery();
/* 352 */     toQuery.setStatus(EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue());
/* 353 */     toQuery.setBuyerAccount(null);
/* 354 */     toQuery.setSellerAccount(account);
/* 355 */     Integer sellConfirmNumber = this.tradeOrderDAO.getNumByQuery(toQuery);
/* 356 */     model.addAttribute("sellConfirmNumber", sellConfirmNumber);
/*     */ 
/* 358 */     toQuery.setStatus(EnumTradeOrderStatus.WAIT_SENDGOODS.getValue());
/* 359 */     Integer sellSendgoodsNumber = this.tradeOrderDAO.getNumByQuery(toQuery);
/* 360 */     model.addAttribute("sellSendgoodsNumber", sellSendgoodsNumber);
/* 361 */     model.addAttribute("sellSendgoodsStatus", EnumTradeOrderStatus.WAIT_SENDGOODS.getValue());
/*     */ 
/* 363 */     toQuery.setStatus(EnumTradeOrderStatus.FINISHED.getValue());
/* 364 */     toQuery.setHasSellerRank("N");
/* 365 */     toQuery.setHasBuyerRank(null);
/* 366 */     Integer sellerRankNumber = this.tradeOrderDAO.getNumByQuery(toQuery);
/* 367 */     model.addAttribute("sellerRankNumber", sellerRankNumber);
/* 368 */     model.addAttribute("sellerRankStatus", EnumTradeOrderStatus.FINISHED.getValue());
/*     */ 
/* 371 */     toQuery.setStatus(EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue());
/* 372 */     toQuery.setSellerAccount(null);
/* 373 */     toQuery.setBuyerAccount(account);
/* 374 */     Integer buyConfirmNumber = this.tradeOrderDAO.getNumByQuery(toQuery);
/* 375 */     model.addAttribute("buyConfirmNumber", buyConfirmNumber);
/*     */ 
/* 377 */     toQuery.setStatus(EnumTradeOrderStatus.WAIT_PAYGOODS.getValue());
/* 378 */     Integer payNumber = this.tradeOrderDAO.getNumByQuery(toQuery);
/* 379 */     model.addAttribute("payNumber", payNumber);
/* 380 */     model.addAttribute("payStatus", EnumTradeOrderStatus.WAIT_PAYGOODS.getValue());
/*     */ 
/* 382 */     toQuery.setStatus(EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue());
/* 383 */     Integer checkGoodNumber = this.tradeOrderDAO.getNumByQuery(toQuery);
/* 384 */     model.addAttribute("checkGoodNumber", checkGoodNumber);
/* 385 */     model.addAttribute("checkGoodStatus", EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue());
/*     */ 
/* 387 */     toQuery.setStatus(EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue());
/* 388 */     Integer checkTicketNumber = this.tradeOrderDAO.getNumByQuery(toQuery);
/* 389 */     model.addAttribute("checkTicketNumber", checkTicketNumber);
/* 390 */     model.addAttribute("checkTicketStatus", EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue());
/*     */ 
/* 392 */     toQuery.setStatus(EnumTradeOrderStatus.FINISHED.getValue());
/* 393 */     toQuery.setHasSellerRank(null);
/* 394 */     toQuery.setHasBuyerRank("N");
/* 395 */     Integer buyerRankNumber = this.tradeOrderDAO.getNumByQuery(toQuery);
/* 396 */     model.addAttribute("buyerRankNumber", buyerRankNumber);
/* 397 */     model.addAttribute("buyerRankStatus", EnumTradeOrderStatus.FINISHED.getValue());
/*     */ 
/* 401 */     twoQuery.setStatus(EnumTradeWishOrderStatus.TRADING.getValue());
/* 402 */     twoQuery.setUserAccount(account);
/* 403 */     twoQuery.setTradeDictor(EnumListingType.BUY.getValue());
/* 404 */     Integer buyAuctionNumber = this.tradeWishOrderDAO.getNumByQuery(twoQuery);
/* 405 */     model.addAttribute("buyAuctionNumber", buyAuctionNumber);
/* 406 */     twoQuery.setTradeDictor(EnumListingType.SELL.getValue());
/* 407 */     Integer sellAuctionNumber = this.tradeWishOrderDAO.getNumByQuery(twoQuery);
/* 408 */     model.addAttribute("sellAuctionNumber", sellAuctionNumber);
/* 409 */     model.addAttribute("tradeStatus", EnumTradeWishOrderStatus.TRADING.getValue());
/*     */   }
/*     */ 
/*     */   public void initIssueTodoForAuctioneer(Model model, String account)
/*     */   {
/* 420 */     ProjectListingQuery query = new ProjectListingQuery();
/* 421 */     String[] tradingTypeArr = { EnumTradingType.BID_ORDER.getValue(), EnumTradingType.MULIT_BID_ORDER.getValue() };
/* 422 */     query.setTradingTypeArr(tradingTypeArr);
/* 423 */     query.setStatus(EnumProjectStatus.TRADE.getValue());
/* 424 */     query.setAuctioneerAccount(account);
/* 425 */     query.setAuctioneerAccountKey(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/* 426 */     query.setHaveAuctioneerKey(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/* 427 */     query.setApplyStartTimeKey(EnumBidOrderProperty.APPLY_START_TIME.getKey());
/* 428 */     Integer waitprojectNumber = this.projectListingDAO.selectAuctionProjectNum(query);
/* 429 */     model.addAttribute("waitprojectNumber", waitprojectNumber);
/*     */   }
/*     */ 
/*     */   public void initIssueTodoForReviewer(Model model, String account)
/*     */   {
/* 440 */     AuctionMulitBidProjectQuery query = new AuctionMulitBidProjectQuery();
/* 441 */     query.setReviewer(account);
/* 442 */     List projectStatus = new ArrayList();
/* 443 */     projectStatus.add(EnumProjectStatus.TRADE);
/* 444 */     query.setProjectStatus(projectStatus);
/* 445 */     query.setReviewed(EnumActiveStatus.No);
/* 446 */     query.setReviewerKey(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT);
/* 447 */     query.setBidStartTimeKey(EnumMulitBidOrderProperty.BID_START_TIME);
/* 448 */     query.setTradingType(EnumTradingType.MULIT_BID_ORDER);
/* 449 */     Integer waitprojectNumber = this.projectListingDAO.queryAuctionMulitBidProjectNum(query);
/* 450 */     model.addAttribute("waitreviewproNumber", waitprojectNumber);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.user.UserAccountServiceImpl
 * JD-Core Version:    0.6.0
 */