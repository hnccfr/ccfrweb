/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemUserCheckDao;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemUserCheck;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemUserCheckDao")
/*    */ public class SystemUserCheckDaoImpl extends BaseDAO
/*    */   implements SystemUserCheckDao
/*    */ {
/*    */   public SystemUserCheck selectByRole(String userRole)
/*    */   {
/* 25 */     Map paraMap = new HashMap();
/* 26 */     paraMap.put("userRole", userRole);
/* 27 */     return (SystemUserCheck)getSqlMapClientTemplate().queryForObject("systemUserCheck.selectByRole", paraMap);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset.SystemUserCheckDaoImpl
 * JD-Core Version:    0.6.0
 */