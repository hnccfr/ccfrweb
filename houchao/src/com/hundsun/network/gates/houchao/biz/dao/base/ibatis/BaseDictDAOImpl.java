/*    */ package com.hundsun.network.gates.houchao.biz.dao.base.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.base.BaseDictDAO;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.base.BaseDict;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.base.query.BaseDictQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("baseDictDAO")
/*    */ public class BaseDictDAOImpl extends BaseDAO
/*    */   implements BaseDictDAO
/*    */ {
/*    */   private static final String SQLMAP_SPACE = "GREENLAKE_BASE_DICT.";
/*    */ 
/*    */   public BaseDict getBaseDictNoVersionByFlay(BaseDictQuery query)
/*    */   {
/* 18 */     return (BaseDict)getSqlMapClientTemplate().queryForObject("GREENLAKE_BASE_DICT.getBaseDictNoVersionByFlay", query);
/*    */   }
/*    */ 
/*    */   public BaseDict getBaseDictCurrVersionByFlay(BaseDictQuery query)
/*    */   {
/* 24 */     return (BaseDict)getSqlMapClientTemplate().queryForObject("GREENLAKE_BASE_DICT.getBaseDictCurrVersionByFlay", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.base.ibatis.BaseDictDAOImpl
 * JD-Core Version:    0.6.0
 */