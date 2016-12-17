/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.common;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.common.AreaDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.common.Area;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("areaDAO")
/*    */ public class AreaDAOImpl extends BaseDAO
/*    */   implements AreaDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Integer id)
/*    */   {
/* 16 */     return getSqlMapClientTemplate().delete("area.deleteByPrimaryKey");
/*    */   }
/*    */ 
/*    */   public void insert(Area record)
/*    */   {
/* 21 */     getSqlMapClientTemplate().insert("area.insert", record);
/*    */   }
/*    */ 
/*    */   public List<Area> queryAll()
/*    */   {
/* 28 */     return getSqlMapClientTemplate().queryForList("area.queryAll");
/*    */   }
/*    */ 
/*    */   public Area queryByPrimaryKey(Integer id)
/*    */   {
/* 33 */     return (Area)getSqlMapClientTemplate().queryForObject("area.queryByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(Area record)
/*    */   {
/* 38 */     return getSqlMapClientTemplate().update("area.updateByPrimaryKey", record);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.common.AreaDAOImpl
 * JD-Core Version:    0.6.0
 */