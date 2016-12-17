/*     */ package com.hundsun.network.gates.taiping.biz.service.pojo.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionLatestBidDTO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionMessageServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionResultServiceRequest;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallDataServiceRequest;
/*     */ import com.hundsun.network.gates.taiping.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.taiping.biz.service.auction.AuctionPushletService;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Queue;
/*     */ import javax.annotation.PostConstruct;
/*     */ import nl.justobjects.pushlet.core.Dispatcher;
/*     */ import nl.justobjects.pushlet.core.Event;
/*     */ import nl.justobjects.pushlet.core.EventPullSource;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.codehaus.jackson.map.ObjectMapper;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("auctionPushletService")
/*     */ public class AuctionPushletServiceImpl extends BaseService
/*     */   implements AuctionPushletService
/*     */ {
/*     */ 
/*     */   @Value("${hall.pushlet.sleep.time}")
/*     */   private Long sleepTime;
/*  29 */   private static String webEncoding = "UTF-8";
/*  30 */   private static ObjectMapper mapper = new ObjectMapper();
/*  31 */   private static Event event = Event.createDataEvent("/refreshHallData");
/*     */ 
/*  33 */   protected static Log log = LogFactory.getLog(AuctionPushletServiceImpl.class);
/*     */ 
/*  35 */   private static Queue<HallDataServiceRequest> hallDataList = new LinkedList();
/*  36 */   private static Queue<AuctionResultServiceRequest> auctionResultList = new LinkedList();
/*  37 */   private static Queue<AuctionMessageServiceRequest> messageRequestList = new LinkedList();
/*     */ 
/*  41 */   @PostConstruct
/*     */   public void init() { HallDataPushlet.sleepTime = this.sleepTime;
/*     */   }
/*     */ 
/*     */   public synchronized void sendAuctionLatestBid(HallDataServiceRequest request)
/*     */   {
/*     */     try
/*     */     {
/*  76 */       hallDataList.offer(request);
/*  77 */       if (log.isDebugEnabled()) {
/*  78 */         log.debug("sendAuctionLatestBid data:" + request);
/*     */       }
/*  80 */       pushAuctionLatestBid();
/*     */     } catch (Exception e) {
/*  82 */       log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public synchronized void sendAuctionResult(AuctionResultServiceRequest request)
/*     */   {
/*     */     try {
/*  89 */       auctionResultList.offer(request);
/*  90 */       pushAuctionResult();
/*     */     } catch (Exception e) {
/*  92 */       log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public synchronized void sendAuctionMessage(AuctionMessageServiceRequest request)
/*     */   {
/*     */     try {
/*  99 */       messageRequestList.offer(request);
/* 100 */       pushAuctionMessage();
/*     */     } catch (Exception e) {
/* 102 */       log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   private static synchronized void pushAuctionLatestBid() {
/* 107 */     if (hallDataList.size() > 0) {
/* 108 */       HallDataServiceRequest hallData = null;
/* 109 */       while ((hallData = (HallDataServiceRequest)hallDataList.poll()) != null)
/*     */         try {
/* 111 */           event.setField(hallData.getAuctionLatestBidDTO().getProjectCode() + "_data", new String(String.valueOf(mapper.writeValueAsString(hallData)).getBytes(webEncoding), "ISO-8859-1"));
/*     */ 
/* 114 */           if (log.isDebugEnabled()) {
/* 115 */             log.debug("pullEvent value:" + hallData);
/*     */           }
/* 117 */           directlyPublish(event);
/*     */         } catch (Exception e) {
/* 119 */           log.error("pullEvent fail:", e);
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private static synchronized void pushAuctionResult()
/*     */   {
/* 126 */     if (auctionResultList.size() > 0) {
/* 127 */       AuctionResultServiceRequest auctionResult = null;
/* 128 */       while ((auctionResult = (AuctionResultServiceRequest)auctionResultList.poll()) != null)
/*     */         try {
/* 130 */           event.setField(auctionResult.getProjectCode() + "_result", new String(String.valueOf(mapper.writeValueAsString(auctionResult)).getBytes(webEncoding), "ISO-8859-1"));
/*     */ 
/* 133 */           directlyPublish(event);
/*     */         } catch (Exception e) {
/* 135 */           log.error("", e);
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private static synchronized void pushAuctionMessage()
/*     */   {
/* 164 */     if (messageRequestList.size() > 0) {
/* 165 */       AuctionMessageServiceRequest messageRequest = null;
/* 166 */       while ((messageRequest = (AuctionMessageServiceRequest)messageRequestList.poll()) != null)
/*     */         try {
/* 168 */           event.setField(messageRequest.getProjectCode() + "_message", new String(String.valueOf(mapper.writeValueAsString(messageRequest)).getBytes(webEncoding), "ISO-8859-1"));
/*     */ 
/* 171 */           directlyPublish(event);
/*     */         } catch (Exception e) {
/* 173 */           log.error("", e);
/*     */         }
/*     */     }
/*     */   }
/*     */ 
/*     */   private static synchronized void directlyPublish(Event event)
/*     */   {
/* 184 */     Dispatcher.getInstance().multicast(event);
/*     */   }
/*     */ 
/*     */   public static class HallDataPushlet extends EventPullSource
/*     */   {
/*     */     public static Long sleepTime;
/*     */ 
/*     */     protected long getSleepTime()
/*     */     {
/*  53 */       return sleepTime.longValue();
/*     */     }
/*     */ 
/*     */     protected Event pullEvent()
/*     */     {
/*  61 */       if (AuctionPushletServiceImpl.log.isDebugEnabled()) {
/*  62 */         AuctionPushletServiceImpl.log.debug("get pullEvent !!");
/*     */       }
///*  64 */       AuctionPushletServiceImpl.access$000();
///*  65 */       AuctionPushletServiceImpl.access$100();              ?????????????????????????????????
///*  66 */       AuctionPushletServiceImpl.access$200();
/*  67 */       Event pullE = Event.createDataEvent("/pullEvent");
/*  68 */       pullE.setField("event", "common");
/*  69 */       return pullE;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.pojo.auction.AuctionPushletServiceImpl
 * JD-Core Version:    0.6.0
 */