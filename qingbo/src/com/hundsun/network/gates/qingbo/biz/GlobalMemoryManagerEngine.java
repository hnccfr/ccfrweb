/*     */ package com.hundsun.network.gates.qingbo.biz;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectTradeStatus;
/*     */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*     */ import com.hundsun.network.gates.qingbo.biz.util.ConvertUtils;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ public class GlobalMemoryManagerEngine extends GlobalMemoryDB
/*     */ {
/*  16 */   private static ReadWriteLock rw = new ReentrantReadWriteLock();
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 100 */     BaseTradeDTO baseTradeDTO1 = new BaseTradeDTO();
/* 101 */     baseTradeDTO1.setProjectCode("1");
/* 102 */     baseTradeDTO1.setTradeStatus(EnumProjectTradeStatus.NORMAL.getValue());
/* 103 */     ProjectTradeEngine.addBaseTradeDTO2Memory(baseTradeDTO1);
/* 104 */     BaseTradeDTO baseTradeDTO2 = new BaseTradeDTO();
/* 105 */     baseTradeDTO2.setProjectCode("2");
/* 106 */     baseTradeDTO2.setTradeStatus(EnumProjectTradeStatus.NORMAL.getValue());
/* 107 */     ProjectTradeEngine.addBaseTradeDTO2Memory(baseTradeDTO2);
/* 108 */     for (BaseTradeDTO baseTradeDTO : baseTrades.values()) {
/* 109 */       System.out.println(baseTradeDTO.getTradeStatus());
/*     */     }
/* 111 */     ProjectTradeEngine.startTrading(baseTradeDTO1.getProjectCode());
/* 112 */     for (BaseTradeDTO baseTradeDTO : baseTrades.values()) {
/* 113 */       System.out.println(baseTradeDTO.getTradeStatus());
/*     */     }
/* 115 */     baseTradeDTO2.setTradeStatus("mmmmm");
/* 116 */     ProjectTradeEngine.updateBaseTradeDTO2Memory(baseTradeDTO2);
/* 117 */     for (BaseTradeDTO baseTradeDTO : baseTrades.values())
/* 118 */       System.out.println(baseTradeDTO.getTradeStatus());
/*     */   }
/*     */ 
/*     */   public static class ProjectTradeEngine
/*     */   {
/*     */     public static void startTrading(String projectCode)
/*     */     {
/*  29 */       GlobalMemoryManagerEngine.rw.writeLock().lock();
/*     */       try {
/*  31 */         BaseTradeDTO baseTradeDTO = (BaseTradeDTO)GlobalMemoryDB.baseTrades.get(projectCode);
/*  32 */         baseTradeDTO.setTradeStatus(EnumProjectTradeStatus.ACTIVE.getValue());
/*     */       } finally {
/*  34 */         GlobalMemoryManagerEngine.rw.writeLock().unlock();
/*     */       }
/*     */     }
/*     */ 
/*     */     public static boolean finishTrading(String projectCode)
/*     */     {
/*  45 */       if (projectCode == null) {
/*  46 */         return false;
/*     */       }
/*  48 */       GlobalMemoryManagerEngine.rw.writeLock().lock();
/*     */       try {
/*  50 */         BaseTradeDTO baseTradeDTO = new BaseTradeDTO();
/*  51 */         baseTradeDTO.setProjectCode(projectCode);
/*  52 */         baseTradeDTO.setTradeStatus(EnumProjectTradeStatus.NORMAL.getValue());
/*  53 */         boolean bool = updateBaseTradeDTO2Memory(baseTradeDTO);
/*     */         return bool; 
				} finally { 
					GlobalMemoryManagerEngine.rw.writeLock().unlock(); 
				} 
/*     */     }
/*     */ 
/*     */     public static boolean addBaseTradeDTO2Memory(BaseTradeDTO baseTradeDTO)
/*     */     {
/*  66 */       if (!GlobalMemoryQueryEngine.ProjectQuery.hasProjectInfoByProjectCode(baseTradeDTO.getProjectCode()))
/*     */       {
/*  69 */         GlobalMemoryManagerEngine.rw.writeLock().lock();
/*     */         try {
/*  71 */           GlobalMemoryDB.baseTrades.put(baseTradeDTO.getProjectCode(), baseTradeDTO);
/*  72 */           //int i = 1;
/*     */           return true; 
					} finally { GlobalMemoryManagerEngine.rw.writeLock().unlock();
/*     */         }
/*     */       }
/*  77 */       return false;
/*     */     }
/*     */ 
/*     */     public static boolean updateBaseTradeDTO2Memory(BaseTradeDTO baseTradeDTO)
/*     */     {
/*  82 */       if (GlobalMemoryQueryEngine.ProjectQuery.hasProjectInfoByProjectCode(baseTradeDTO.getProjectCode()))
/*     */       {
/*  85 */         GlobalMemoryManagerEngine.rw.writeLock().lock();
/*     */         try {
/*  87 */           BaseTradeDTO baseTradeDTOOld = (BaseTradeDTO)GlobalMemoryDB.baseTrades.get(baseTradeDTO.getProjectCode());
/*  88 */           baseTradeDTOOld = ConvertUtils.converntTradeOrderDTO2TradeOrderDTO(baseTradeDTO);
/*     */ 
/*  90 */           //int i = 1;
/*     */           return true; 
				} finally { GlobalMemoryManagerEngine.rw.writeLock().unlock();
/*     */         }
/*     */       }
/*  95 */       return false;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.GlobalMemoryManagerEngine
 * JD-Core Version:    0.6.0
 */