/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionActiveDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionBidderDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionHallDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionLatestBidDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.auction.AuctionLogDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionBidder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionHall;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionLatestBid;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionLog;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.auction.AuctionActiveService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.genshan.common.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionBidderBidStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionLatestStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("auctionActiveService")
/*     */ public class AuctionActiveServiceImpl extends BaseService
/*     */   implements AuctionActiveService, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -7295535225701562376L;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionActiveDAO auctionActiveDAO;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionHallDAO auctionHallDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionBidderDAO auctionBidderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionLatestBidDAO auctionLatestBidDAO;
/*     */ 
/*     */   @Autowired
/*     */   private AuctionLogDAO auctionLogDAO;
/*     */ 
/*     */   public void testRun()
/*     */   {
/*  65 */     System.out.println("genshan==========我运行了," + new Date());
/*     */   }
/*     */ 
/*     */   public void activeAuctionProjectsBatch()
/*     */   {
/*  76 */     List apList = this.auctionActiveDAO.getAuctionProjectList();
/*  77 */     final Iterator iterator = apList.iterator();
/*     */ 
/*  81 */     Boolean flagBoolean = (Boolean)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public Boolean doInTransaction(TransactionStatus status) {
/*     */         try {
/*  84 */           List bidderList = new ArrayList();
/*  85 */           List hallList = new ArrayList();
/*  86 */           List latestBidList = new ArrayList();
/*  87 */           List logList = new ArrayList();
/*  88 */           while (iterator.hasNext()) {
/*  89 */             ProjectListing projectListing = new ProjectListing();
/*     */             try {
/*  91 */               ProjectListing pListing = (ProjectListing)iterator.next();
/*     */ 
/*  93 */               projectListing = AuctionActiveServiceImpl.this.projectListingService.getProjectListingById(pListing.getId());
/*     */             }
/*     */             catch (Exception e) {
/*  96 */               e.printStackTrace();
/*  97 */               AuctionActiveServiceImpl.this.log.error("激活交易大厅接口，获取项目信息出错！");
/*     */             }
/*     */ 
/* 101 */             List<AuctionBidder> tmpBidderL = new ArrayList();
/* 102 */             AuctionHall hall = new AuctionHall();
/* 103 */             AuctionLatestBid latestBid = new AuctionLatestBid();
/* 104 */             AuctionLog acutonLog = new AuctionLog();
/*     */             try
/*     */             {
/* 107 */               Map map = new HashMap();
/* 108 */               map.put("projectCode", projectListing.getCode());
/* 109 */               map.put("status", EnumTradeWishOrderStatus.TRADING.getValue());
/* 110 */               List wishOrderList = AuctionActiveServiceImpl.this.auctionActiveDAO.getAuctionBidderList(map);
/*     */ 
/* 112 */               Iterator it = wishOrderList.iterator();
/* 113 */               int priorityNum = 0;
/* 114 */               while (it.hasNext()) {
/* 115 */                 TradeWishOrder wishOrder = (TradeWishOrder)it.next();
/* 116 */                 AuctionBidder bidder = new AuctionBidder();
/*     */ 
/* 118 */                 bidder.setProjectCode(projectListing.getCode());
/* 119 */                 bidder.setBidderAccount(wishOrder.getUserAccount());
/* 120 */                 if ((wishOrder.getSpecialSign() != null) && ("Y".equalsIgnoreCase(wishOrder.getSpecialSign()))) {
/* 121 */                   bidder.setIsPriority("Y");
/* 122 */                   priorityNum++;
/*     */                 } else {
/* 124 */                   bidder.setIsPriority("N");
/*     */                 }
/* 126 */                 bidder.setBidderTrademark(wishOrder.getTrademark());
/* 127 */                 bidder.setBidStatus(EnumAuctionBidderBidStatus.A.getValue());
/* 128 */                 bidder.setOperator("admin");
/* 129 */                 tmpBidderL.add(bidder);
/*     */               }
/*     */ 
/* 133 */               hall.setPriorityNum(Integer.valueOf(priorityNum));
/*     */ 
/* 135 */               Long bidate = AuctionActiveServiceImpl.this.getAuctionHallData(hall, projectListing);
/*     */ 
/* 138 */               latestBid.setBidRate(bidate);
/* 139 */               latestBid.setLatestBid(Long.valueOf(0L));
/* 140 */               latestBid.setBidderTrademark("-1");
/* 141 */               latestBid.setIsPriority("N");
/* 142 */               latestBid.setLatestBidTime(hall.getBidStartTime());
/* 143 */               latestBid.setProjectCode(projectListing.getCode());
/* 144 */               latestBid.setLatestStatus(EnumAuctionLatestStatus.A.getValue());
/* 145 */               latestBid.setOperator("admin");
/* 146 */               if (hall.getHaveAuctioneer().equalsIgnoreCase("Y"))
/*     */               {
/* 148 */                 latestBid.setNextBidEndtime(null);
/*     */               }
/* 150 */               else latestBid.setNextBidEndtime(hall.getBidStartTime());
/*     */ 
/* 154 */               acutonLog.setProjectCode(projectListing.getCode());
/* 155 */               acutonLog.setNewStatus(EnumAuctionLatestStatus.A.getValue());
/*     */ 
/* 157 */               String dataJsonString = "{竞价开始时间:" + hall.getBidStartTime() + "" + ",拍卖类型:" + hall.getAuctionType() + ",起拍价:" + hall.getBidStartPrice() + "" + ",报价幅度:" + bidate + ",报价周期:" + hall.getBidLimitedPeriod() + ",优先权人数:" + priorityNum + "}";
/*     */ 
/* 162 */               acutonLog.setDataJson(dataJsonString);
/* 163 */               acutonLog.setRemark("激活交易大厅");
/* 164 */               acutonLog.setOperator("admin");
/* 165 */               acutonLog.setOperatorType("系统控制");
/*     */ 
/* 168 */               for (AuctionBidder bidder : tmpBidderL) {
/* 169 */                 bidderList.add(bidder);
/*     */               }
/* 171 */               hallList.add(hall);
/* 172 */               latestBidList.add(latestBid);
/* 173 */               logList.add(acutonLog);
/*     */             } catch (Exception e) {
/* 175 */               if (AuctionActiveServiceImpl.this.log.isErrorEnabled()) {
/* 176 */                 AuctionActiveServiceImpl.this.log.error("激活交易大厅接口，数据组装出错！项目编号：" + projectListing.getCode(), e);
/*     */               }
/*     */             }
/*     */           }
/* 180 */           AuctionActiveServiceImpl.this.auctionBidderDAO.batchInsert(bidderList);
/* 181 */           AuctionActiveServiceImpl.this.auctionHallDAO.batchInsert(hallList);
/* 182 */           AuctionActiveServiceImpl.this.auctionLatestBidDAO.batchInsert(latestBidList);
/* 183 */           AuctionActiveServiceImpl.this.auctionLogDAO.batchInsert(logList);
/* 184 */           return Boolean.valueOf(true);
/*     */         } catch (Exception e) {
/* 186 */           if (AuctionActiveServiceImpl.this.log.isErrorEnabled()) {
/* 187 */             AuctionActiveServiceImpl.this.log.error("激活交易大厅接口异常", e);
/*     */           }
/* 189 */           status.setRollbackOnly();
/* 190 */         }return Boolean.valueOf(false);
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   private Long getAuctionHallData(AuctionHall hall, ProjectListing projectListing)
/*     */   {
/* 204 */     String bidate = "";
/* 205 */     List metasList = projectListing.getTradeMeta();
/* 206 */     if ((metasList == null) || (metasList.size() == 0)) {
/* 207 */       return null;
/*     */     }
/* 209 */     Iterator iterator = metasList.iterator();
/* 210 */     hall.setAuctionType("bid");
/* 211 */     hall.setOperator("admin");
/* 212 */     hall.setProjectCode(projectListing.getCode());
/* 213 */     hall.setValuationUnit(projectListing.getValuationUnit());
/* 214 */     String auctioneerAccount = "";
/* 215 */     while (iterator.hasNext()) {
/* 216 */       ProjectMetas pm = ((AttriMeta)iterator.next()).getMeta();
/* 217 */       if (pm.getMetaKey().equalsIgnoreCase("allowWatch"))
/*     */       {
/* 219 */         hall.setAllowWatch(pm.getMetaValue());
/* 220 */       } else if (pm.getMetaKey().equalsIgnoreCase("auctioneerAccount"))
/*     */       {
/* 222 */         auctioneerAccount = pm.getMetaValue();
/*     */       }
/* 224 */       else if (pm.getMetaKey().equalsIgnoreCase("bidLimitedPeriod"))
/*     */       {
/* 226 */         hall.setBidLimitedPeriod(pm.getMetaValue() == null ? null : Double.valueOf(Double.parseDouble(pm.getMetaValue())));
/*     */       }
/* 228 */       else if (pm.getMetaKey().equalsIgnoreCase("bidStartPrice"))
/*     */       {
/* 230 */         hall.setBidStartPrice(pm.getMetaValue() == null ? null : Long.valueOf(Long.parseLong(pm.getMetaValue())));
/*     */       }
/* 232 */       else if (pm.getMetaKey().equalsIgnoreCase("bidStartTime"))
/*     */       {
/* 234 */         hall.setBidStartTime(pm.getMetaValue() == null ? null : DateUtil.strToDate(pm.getMetaValue(), "yyyy-MM-dd HH:mm:ss"));
/*     */       }
/* 236 */       else if (pm.getMetaKey().equalsIgnoreCase("firstWaitTime"))
/*     */       {
/* 238 */         hall.setFirstWaitTime(pm.getMetaValue() == null ? null : Integer.valueOf(Integer.parseInt(pm.getMetaValue())));
/*     */       }
/* 240 */       else if (pm.getMetaKey().equalsIgnoreCase("haveAuctioneer"))
/*     */       {
/* 242 */         hall.setHaveAuctioneer(pm.getMetaValue());
/* 243 */       } else if (pm.getMetaKey().equalsIgnoreCase("haveReservePrice"))
/*     */       {
/* 245 */         hall.setHaveReservePrice(pm.getMetaValue());
/* 246 */       } else if (pm.getMetaKey().equalsIgnoreCase("priceDirection"))
/*     */       {
/* 248 */         hall.setPriceDirection(pm.getMetaValue() == null ? null : Short.valueOf(Short.parseShort(pm.getMetaValue())));
/*     */       }
/* 250 */       else if (pm.getMetaKey().equalsIgnoreCase("reservePrice"))
/*     */       {
/* 252 */         hall.setReservePrice(pm.getMetaValue() == null ? null : Long.valueOf(Long.parseLong(pm.getMetaValue())));
/*     */       }
/* 254 */       else if (pm.getMetaKey().equalsIgnoreCase("supportPriority"))
/*     */       {
/* 256 */         hall.setSupportPriority(pm.getMetaValue());
/* 257 */       } else if (pm.getMetaKey().equalsIgnoreCase("watchPassword"))
/*     */       {
/* 259 */         hall.setWatchPassword(pm.getMetaValue());
/* 260 */       } else if (pm.getMetaKey().equalsIgnoreCase("bidRate"))
/*     */       {
/* 262 */         bidate = pm.getMetaValue();
/* 263 */       } else if (pm.getMetaKey().equalsIgnoreCase("comFreeStarttime"))
/*     */       {
/* 265 */         hall.setComFreeStarttime(pm.getMetaValue() == null ? null : DateUtil.strToDate(pm.getMetaValue(), "yyyy-MM-dd HH:mm:ss"));
/*     */       }
/* 267 */       else if (pm.getMetaKey().equalsIgnoreCase("comFreeEndtime"))
/*     */       {
/* 269 */         hall.setComFreeStarttime(pm.getMetaValue() == null ? null : DateUtil.strToDate(pm.getMetaValue(), "yyyy-MM-dd HH:mm:ss"));
/*     */       }
/*     */ 
/* 272 */       if (hall.getHaveAuctioneer().equalsIgnoreCase("Y")) {
/* 273 */         hall.setAuctioneerAccount(auctioneerAccount);
/*     */       }
/*     */     }
/*     */ 
/* 277 */     return StringUtil.isEmpty(bidate) ? null : Long.valueOf(Long.parseLong(bidate));
/*     */   }
/*     */ 
/*     */   public void activeTenderProjectsBatch()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void activeTransferProjectsBatch()
/*     */   {
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.auction.AuctionActiveServiceImpl
 * JD-Core Version:    0.6.0
 */