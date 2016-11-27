/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionBidderDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionFreeBidDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionHallDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.baseset.SystemDictDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectMetasDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.trade.WishOrderAuditDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionBidder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionFreeBid;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionHall;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.WishOrderAudit;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.EnumAuditWishOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.trade.TradeWishOrderService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.trade.WishOrderAuditService;
/*     */ import com.hundsun.network.gates.genshan.common.DateUtil;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionBidderBidStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidCheckStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumCheckCommonNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProcessAuditNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumYesOrNo;
/*     */ import com.hundsun.network.gates.luosi.common.utils.AutomaticGenerator;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLevelRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserLevelServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemMessageService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.io.PrintStream;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("wishOrderAuditService")
/*     */ public class WishOrderAuditServiceImpl extends BaseService
/*     */   implements WishOrderAuditService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private WishOrderAuditDAO wishOrderAuditDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderService tradeWishOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderDAO tradeWishOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountDAO userAccountDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectMetasDAO projectMetasDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionHallDAO auctionHallDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidderDAO auctionBidderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemDictDAO systemDictDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionFreeBidDAO auctionFreeBidDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemMessageService remoteSystemMessageService;
/*     */ 
/*     */   @Value("${fengshan.domain}")
/*     */   private String fengshanDomain;
/*     */ 
/*     */   public Long addWishOrderAudit(WishOrderAudit wishOrderAudit)
/*     */   {
/* 116 */     return this.wishOrderAuditDAO.insert(wishOrderAudit);
/*     */   }
/*     */ 
/*     */   public int updateWishOrderAudit(WishOrderAudit wishOrderAudit)
/*     */   {
/* 121 */     return this.wishOrderAuditDAO.update(wishOrderAudit);
/*     */   }
/*     */ 
/*     */   public WishOrderAudit getWishOrderAudit(WishOrderAudit wishOrderAudit)
/*     */   {
/* 126 */     return this.wishOrderAuditDAO.selectWishOrderAudit(wishOrderAudit);
/*     */   }
/*     */ 
/*     */   public WishOrderAudit selectWishOrderAuditInAudit(WishOrderAudit wishOrderAudit)
/*     */   {
/* 131 */     return this.wishOrderAuditDAO.selectWishOrderAudit(wishOrderAudit);
/*     */   }
/*     */ 
/*     */   public String auditWishOrder(final String ip, final UserAgent userAgent, Long orderId, String auditNodeRemark, String auditResult, String projectCode, String isSpecialMan, final String trademark, ProjectListing projectListing)
/*     */   {
/* 136 */     WishOrderAudit query = new WishOrderAudit();
/* 137 */     query.setOrderId(orderId);
/*     */ 
/* 141 */     WishOrderAudit resultAudit = selectWishOrderAuditInAudit(query);
/*     */ 
/* 143 */     if ((null == resultAudit) || ((!EnumProcessAuditNodes.ADVANCE_AUDIT.getValue().endsWith(resultAudit.getAuditNode())) && (!EnumProcessAuditNodes.FINAL_AUDIT.getValue().equals(resultAudit.getAuditNode()))))
/*     */     {
/* 146 */       return EnumAuditWishOrder.ERROR1.getName();
/*     */     }
/*     */ 
/* 149 */     String curNote = resultAudit.getAuditNode();
/* 150 */     String processAuditNodes = resultAudit.getProcessAuditNodes();
/* 151 */     int curNoteIndex = processAuditNodes.indexOf(curNote);
/* 152 */     if ("Y".equals(auditResult)) {
/* 153 */       if (curNoteIndex < 0)
/* 154 */         resultAudit.setAuditNode(EnumCheckCommonNodes.END_NODE.getValue());
/*     */       else {
/* 156 */         resultAudit.setAuditNode(processAuditNodes.substring(curNoteIndex + 1, curNoteIndex + 2));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 161 */       resultAudit.setAuditNode(EnumCheckCommonNodes.END_NODE.getValue());
/*     */     }
/* 163 */     resultAudit.setAuditRes(auditResult);
/* 164 */     resultAudit.setAuditMemo(auditNodeRemark);
/* 165 */     resultAudit.setOperator(userAgent.getUserAccount());
/*     */ 
/* 167 */     final WishOrderAudit wishOrderAudit = resultAudit;
/* 168 */    final TradeWishOrder wishOrder = new TradeWishOrder();
/* 169 */     final String auditRecord = auditResult;
/* 170 */     final String code = projectCode;
/* 171 */     final ProjectListing project = projectListing;
/* 172 */     wishOrder.setId(orderId);
/* 173 */     wishOrder.setSpecialSign(isSpecialMan);
/* 174 */     String result = (String)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public String doInTransaction(TransactionStatus status) {
/*     */         try {
/* 177 */           TradeWishOrder tradeWishOrder = WishOrderAuditServiceImpl.this.tradeWishOrderDAO.selectByPrimaryKey(wishOrder.getId());
/*     */ 
/* 179 */           if (!EnumTradeWishOrderStatus.AUDIT.getValue().equals(tradeWishOrder.getStatus())) {
/* 180 */             WishOrderAuditServiceImpl.this.log.equals("auditWishOrder error cause by: " + EnumAuditWishOrder.ERROR8.getName());
/* 181 */             return EnumAuditWishOrder.ERROR8.getName();
/*     */           }
/* 183 */           if (auditRecord.equals("Y"))
/*     */           {
/* 185 */             if (!EnumCheckCommonNodes.END_NODE.getValue().equals(wishOrderAudit.getAuditNode())) {
/* 186 */               int auditRes = WishOrderAuditServiceImpl.this.wishOrderAuditDAO.update(wishOrderAudit);
/* 187 */               if (auditRes <= 0) {
/* 188 */                 status.setRollbackOnly();
/* 189 */                 WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by: 更新审核表失败");
/* 190 */                 return EnumAuditWishOrder.ERROR1.getName();
/*     */               }
/*     */             }
/*     */             else
/*     */             {
/* 195 */               String resultTradeMark = WishOrderAuditServiceImpl.this.getTradeMark(code, trademark);
/* 196 */               if (resultTradeMark.equals("error")) {
/* 197 */                 status.setRollbackOnly();
/* 198 */                 WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by: 输入的牌号已存在");
/* 199 */                 return EnumAuditWishOrder.ERROR5.getName();
/*     */               }
/* 201 */               wishOrder.setTrademark(resultTradeMark);
/* 202 */               wishOrder.setStatus(EnumTradeWishOrderStatus.TRADING.getValue());
/* 203 */               int auditRes = WishOrderAuditServiceImpl.this.wishOrderAuditDAO.update(wishOrderAudit);
/* 204 */               if (auditRes <= 0) {
/* 205 */                 status.setRollbackOnly();
/* 206 */                 WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by: 更新审核表失败");
/* 207 */                 return EnumAuditWishOrder.ERROR1.getName();
/*     */               }
/* 209 */               int wishOrderRes = WishOrderAuditServiceImpl.this.tradeWishOrderDAO.updateWishOrderInfo(wishOrder);
/* 210 */               if (wishOrderRes <= 0) {
/* 211 */                 status.setRollbackOnly();
/* 212 */                 WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by: 更新意向单表失败");
/* 213 */                 return EnumAuditWishOrder.ERROR2.getName();
/*     */               }
/* 215 */               AuctionHall auctionHall = WishOrderAuditServiceImpl.this.auctionHallDAO.selectByProjectCode(code);
/* 216 */               if (null != auctionHall) {
/* 217 */                 AuctionBidder auctionBidder = new AuctionBidder();
/* 218 */                 auctionBidder.setBidderAccount(tradeWishOrder.getUserAccount());
/* 219 */                 auctionBidder.setBidderTrademark(wishOrder.getTrademark());
/* 220 */                 auctionBidder.setBidStatus(EnumAuctionBidderBidStatus.A.getValue());
/* 221 */                 auctionBidder.setIsPriority(wishOrder.getSpecialSign());
/* 222 */                 auctionBidder.setOperator(userAgent.getUserAccount());
/* 223 */                 auctionBidder.setProjectCode(code);
/*     */                 try {
/* 225 */                   WishOrderAuditServiceImpl.this.auctionBidderDAO.insert(auctionBidder);
/*     */                 } catch (Exception e) {
/* 227 */                   status.setRollbackOnly();
/* 228 */                   WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by:", e);
/* 229 */                   return EnumAuditWishOrder.ERROR4.getName();
/*     */                 }
/*     */ 
/* 232 */                 if ((EnumYesOrNo.YES.getValue().equals(wishOrder.getSpecialSign())) && 
/* 233 */                   (WishOrderAuditServiceImpl.this.auctionHallDAO.updatePriorityNumById(auctionHall.getId()) <= 0)) {
/* 234 */                   status.setRollbackOnly();
/* 235 */                   WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by:" + EnumAuditWishOrder.ERROR6.getName());
/* 236 */                   return EnumAuditWishOrder.ERROR6.getName();
/*     */                 }
/*     */ 
/*     */               }
/*     */ 
/* 241 */               UserLevelRequest userLevelRequest = new UserLevelRequest();
/* 242 */               Integer integral = Integer.valueOf(0);
/*     */ 
/* 256 */               userLevelRequest.setIntegral(integral);
/* 257 */               userLevelRequest.setOperateCode(EnumSystemDictKey.PROJECT_AUCTSUCC_INTEGRAL.getValue());
/* 258 */               userLevelRequest.setOperator(userAgent.getUserAccount());
/* 259 */               userLevelRequest.setOrderNo(tradeWishOrder.getWishOrderNum());
/* 260 */               userLevelRequest.setProjectCode(code);
/* 261 */               userLevelRequest.setUserAccount(tradeWishOrder.getUserAccount());
/* 262 */               userLevelRequest.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 263 */               UserLevelServiceResult userLevelServiceResult = WishOrderAuditServiceImpl.this.remoteUserService.updateUserLevel(userLevelRequest);
/* 264 */               if (userLevelServiceResult.error()) {
/* 265 */                 status.setRollbackOnly();
/* 266 */                 WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by:" + userLevelServiceResult.getErrorInfo());
/* 267 */                 return userLevelServiceResult.getErrorInfo();
/*     */               }
/*     */ 
/* 271 */               if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(tradeWishOrder.getTradeType())) {
/* 272 */                 AuctionFreeBid auctionFreeBid = new AuctionFreeBid();
/* 273 */                 auctionFreeBid.setBidderAccount(tradeWishOrder.getUserAccount());
/* 274 */                 auctionFreeBid.setBidderTrademark(resultTradeMark);
/* 275 */                 auctionFreeBid.setBidOperatorAccount(tradeWishOrder.getUserAccount());
/*     */ 
/* 277 */                 auctionFreeBid.setOperator(EnumOperatorType.SYSTEM.getValue());
/* 278 */                 auctionFreeBid.setPrice(null);
/* 279 */                 auctionFreeBid.setIp(ip);
/* 280 */                 auctionFreeBid.setProjectCode(tradeWishOrder.getProjectCode());
/* 281 */                 auctionFreeBid.setStatus(EnumBidPriceStatus.EFFECTIVE.getValue());
/* 282 */                 auctionFreeBid.setCheckStatus(EnumBidCheckStatus.Pass.getValue());
/* 283 */                 Long auctionFreeBidId = WishOrderAuditServiceImpl.this.auctionFreeBidDAO.insert(auctionFreeBid);
/* 284 */                 if (auctionFreeBidId.intValue() <= 0) {
/* 285 */                   status.setRollbackOnly();
/* 286 */                   WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by:" + EnumAuditWishOrder.ERROR7.getName());
/* 287 */                   return EnumAuditWishOrder.ERROR7.getName();
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */           else {
/* 293 */             wishOrder.setStatus(EnumTradeWishOrderStatus.NPCANCEL.getValue());
/* 294 */             int auditRes = WishOrderAuditServiceImpl.this.wishOrderAuditDAO.update(wishOrderAudit);
/* 295 */             if (auditRes <= 0) {
/* 296 */               status.setRollbackOnly();
/* 297 */               WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by: 更新审核表失败");
/* 298 */               return EnumAuditWishOrder.ERROR1.getName();
/*     */             }
/* 300 */             int wishOrderRes = WishOrderAuditServiceImpl.this.tradeWishOrderDAO.updateWishOrderInfo(wishOrder);
/* 301 */             if (wishOrderRes <= 0) {
/* 302 */               status.setRollbackOnly();
/* 303 */               WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by: 更新意向单表失败");
/* 304 */               return EnumAuditWishOrder.ERROR2.getName();
/*     */             }
/*     */ 
/* 307 */             UserAccount userAccount = WishOrderAuditServiceImpl.this.userAccountDAO.selectUserByAccount(tradeWishOrder.getUserAccount());
/* 308 */             TransRequest request = new TransRequest();
/* 309 */             request.setFundAccount(userAccount.getFundAccount());
/* 310 */             request.setOrderProperty(tradeWishOrder.getTradeType());
/* 311 */             request.setAmount(tradeWishOrder.getDeposit());
/* 312 */             request.setBizNo(tradeWishOrder.getWishOrderNum());
/* 313 */             request.setOperator(userAgent.getUserAccount());
/* 314 */             request.setTransDate(DateUtil.convertDateToString("yyyyMMdd", tradeWishOrder.getGmtModify()));
/* 315 */             FundOperateResult result = new FundOperateResult();
/* 316 */             result = WishOrderAuditServiceImpl.this.remoteFundService.cancelFundByTrade(request);
/* 317 */             if (result.isError()) {
/* 318 */               status.setRollbackOnly();
/* 319 */               WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by:" + result.getErrorInfo());
/* 320 */               return result.getErrorInfo();
/*     */             }
/*     */           }
/*     */           try
/*     */           {
/* 325 */             WishOrderAuditServiceImpl.this.sendSystemMessage(wishOrderAudit.getAuditRes(), wishOrderAudit.getAuditMemo(), tradeWishOrder.getUserAccount(), userAgent.getUserAccount(), project);
/*     */           } catch (Exception e) {
/* 327 */             WishOrderAuditServiceImpl.this.log.error("send system message error cause by:" + e);
/*     */           }
/* 329 */           return EnumAuditWishOrder.SUCCESS.getValue();
/*     */         } catch (Exception e) {
/* 331 */           status.setRollbackOnly();
/* 332 */           WishOrderAuditServiceImpl.this.log.error("auditWishOrder error cause by:", e);
/* 333 */         }return EnumAuditWishOrder.ERROR3.getName();
/*     */       }
/*     */     });
/* 337 */     return result;
/*     */   }
/*     */ 
/*     */   public String getTradeMark(String projectCode, String trademark)
/*     */   {
/* 349 */     TradeWishOrder query = new TradeWishOrder();
/* 350 */     query.setStatus(EnumTradeWishOrderStatus.TRADING.getValue());
/* 351 */     query.setProjectCode(projectCode);
/* 352 */     List<String> tradeMarks = this.tradeWishOrderService.getTradeMarkOfOneProject(query);
/* 353 */     String tradeMark = null;
/*     */ 
/* 357 */     if (StringUtil.isEmpty(trademark)) {
/* 358 */       tradeMark = AutomaticGenerator.tradeMarkGenerator();
/* 359 */       if (tradeMarks.size() == 0) {
/* 360 */         return tradeMark;
/*     */       }
/* 362 */       for (String compare : tradeMarks)
/* 363 */         if (tradeMark.equals(compare))
/* 364 */           tradeMark = AutomaticGenerator.tradeMarkGenerator();
/*     */     }
/*     */     else
/*     */     {
/* 368 */       tradeMark = trademark;
/* 369 */       for (String compare : tradeMarks) {
/* 370 */         if (tradeMark.equals(compare)) {
/* 371 */           tradeMark = "error";
/*     */         }
/*     */       }
/*     */     }
/* 375 */     return tradeMark;
/*     */   }
/*     */ 
/*     */   public Boolean isOutOfTime(Long projectId)
/*     */   {
/* 388 */     int num = this.projectMetasDAO.selectNumByProjectId(projectId).intValue();
/* 389 */     if (num > 0) {
/* 390 */       return Boolean.valueOf(false);
/*     */     }
/* 392 */     return Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   public void sendSystemMessage(String auditResult, String auditNodeRemark, String userAccount, String operatorAccount, ProjectListing projectListing)
/*     */   {
/* 397 */     SystemMessageRequest request = new SystemMessageRequest();
/* 398 */     List userAccountList = new ArrayList();
/* 399 */     userAccountList.add(userAccount);
/* 400 */     request.setUserAccountList(userAccountList);
/* 401 */     request.setOperator(operatorAccount);
/* 402 */     request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 403 */     StringBuffer sb = new StringBuffer();
/* 404 */     sb.append("尊敬的用户您好，您的<a style='color: blue;' href='http://" + this.fengshanDomain + "/home/detail.htm?projectCode=" + projectListing.getCode() + "' target='_blank' >【" + projectListing.getTitle() + "】</a>项目的报名请求");
/*     */ 
/* 407 */     if (auditResult.equalsIgnoreCase("Y")) {
/* 408 */       request.setTitle("【" + projectListing.getTitle() + "】项目报名审核通过");
/* 409 */       sb.append("已经审核通过，请注意后续的相关事件，以免影响您在平台上的拍卖");
/* 410 */       request.setContent(sb.toString());
/* 411 */       this.remoteSystemMessageService.sendSystemMessage(request);
/*     */     } else {
/* 413 */       request.setTitle("【" + projectListing.getTitle() + "】项目报名审核不通过");
/* 414 */       sb.append("未能通过审核，审核失败原因是：" + auditNodeRemark);
/* 415 */       request.setContent(sb.toString());
/* 416 */       this.remoteSystemMessageService.sendSystemMessage(request);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws ParseException {
/* 421 */     System.out.println(new Date().getTime());
/* 422 */     System.out.println("ddd：" + DateUtil.convertStringToDate("yyyy-MM-dd hh:MM:ss", "2011-12-19 18:52:40"));
/* 423 */     System.out.println(DateUtil.convertDateToString("yyyyMMdd hhmmss", new Date()));
/*     */ 
/* 425 */     System.out.println(DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", new Date()));
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.trade.WishOrderAuditServiceImpl
 * JD-Core Version:    0.6.0
 */