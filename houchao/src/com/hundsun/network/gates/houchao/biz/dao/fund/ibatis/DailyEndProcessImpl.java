/*    */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.DailyEndProcess;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("dailyEndProcess")
/*    */ public class DailyEndProcessImpl extends BaseDAO
/*    */   implements DailyEndProcess
/*    */ {
/*    */   public void dailyEndDataBackup(Map<String, String> map)
/*    */   {
/* 31 */     getSqlMapClientTemplate().insert("DailyEndProcess.dailyEndDataBackup", map);
/*    */   }
/*    */ 
/*    */   public void dailyEndAfterBackup(Map<String, String> map)
/*    */   {
/* 40 */     getSqlMapClientTemplate().insert("DailyEndProcess.dailyEndAfterBackup", map);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.DailyEndProcessImpl
 * JD-Core Version:    0.6.0
 */