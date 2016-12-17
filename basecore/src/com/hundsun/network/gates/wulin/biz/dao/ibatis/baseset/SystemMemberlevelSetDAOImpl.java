/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemMemberlevelSetDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemMemberlevelSet;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemMemberlevelSetDAO")
/*    */ public class SystemMemberlevelSetDAOImpl extends BaseDAO
/*    */   implements SystemMemberlevelSetDAO
/*    */ {
/*    */   public List<SystemMemberlevelSet> selectAll()
/*    */   {
/* 25 */     return getSqlMapClientTemplate().queryForList("SYSTEM_MEMBERLEVEL_SET.selectAll");
/*    */   }
/*    */ 
/*    */   public SystemMemberlevelSet selectInitLevel()
/*    */   {
/* 33 */     return (SystemMemberlevelSet)getSqlMapClientTemplate().queryForObject("SYSTEM_MEMBERLEVEL_SET.selectInitLevel");
/*    */   }
/*    */ 
/*    */   public SystemMemberlevelSet selectByIntegral(int integral)
/*    */   {
/* 42 */     return (SystemMemberlevelSet)getSqlMapClientTemplate().queryForObject("SYSTEM_MEMBERLEVEL_SET.selectByIntegral", Integer.valueOf(integral));
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset.SystemMemberlevelSetDAOImpl
 * JD-Core Version:    0.6.0
 */