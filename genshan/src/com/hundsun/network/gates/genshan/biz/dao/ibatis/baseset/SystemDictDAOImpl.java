/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.SystemDictDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemDict;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemDictQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemDictDAO")
/*    */ public class SystemDictDAOImpl extends BaseDAO
/*    */   implements SystemDictDAO
/*    */ {
/*    */   public void selectPageList(SystemDictQuery query)
/*    */   {
/* 25 */     paginate(query, "SYSTEM_DICT.selectPageList-count", "SYSTEM_DICT.selectPageList");
/*    */   }
/*    */ 
/*    */   public List<SystemDict> selectByCond(SystemDictQuery query)
/*    */   {
/* 35 */     return getSqlMapClientTemplate().queryForList("SYSTEM_DICT.selectByCond", query);
/*    */   }
/*    */ 
/*    */   public List<SystemDict> checkRepeat(SystemDictQuery query)
/*    */   {
/* 45 */     return getSqlMapClientTemplate().queryForList("SYSTEM_DICT.checkRepeat", query);
/*    */   }
/*    */ 
/*    */   public Long insert(SystemDict record)
/*    */   {
/* 53 */     return (Long)getSqlMapClientTemplate().insert("SYSTEM_DICT.insert", record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(SystemDict record)
/*    */   {
/* 62 */     int rows = getSqlMapClientTemplate().update("SYSTEM_DICT.updateByPrimaryKey", record);
/* 63 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateBySelective(SystemDict record)
/*    */   {
/* 72 */     int rows = getSqlMapClientTemplate().update("SYSTEM_DICT.updateBySelective", record);
/* 73 */     return rows;
/*    */   }
/*    */ 
/*    */   public SystemDict selectByPrimaryKey(Long id)
/*    */   {
/* 82 */     SystemDict record = (SystemDict)getSqlMapClientTemplate().queryForObject("SYSTEM_DICT.selectByPrimaryKey", id);
/* 83 */     return record;
/*    */   }
/*    */ 
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 92 */     SystemDict key = new SystemDict();
/* 93 */     key.setId(id);
/* 94 */     int rows = getSqlMapClientTemplate().delete("SYSTEM_DICT.deleteByPrimaryKey", key);
/* 95 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset.SystemDictDAOImpl
 * JD-Core Version:    0.6.0
 */