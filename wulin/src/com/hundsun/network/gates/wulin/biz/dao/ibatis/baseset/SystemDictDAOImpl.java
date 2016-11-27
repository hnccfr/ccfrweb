/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictEnable;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemDictDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemDictDAO")
/*    */ public class SystemDictDAOImpl extends BaseDAO
/*    */   implements SystemDictDAO
/*    */ {
/*    */   public List<SystemDict> selectCommonChargeSpecial(String[] paraCodeList)
/*    */   {
/* 26 */     Map param = new HashMap();
/* 27 */     param.put("paraCodeList", paraCodeList);
/* 28 */     param.put("enable", Short.valueOf(EnumSystemDictEnable.ENABLE.getCode()));
/* 29 */     return getSqlMapClientTemplate().queryForList("SYSTEM_DICT.selectCommonChargeSpecial", param);
/*    */   }
/*    */ 
/*    */   public List<SystemDict> selectListByKey(String paraCode)
/*    */   {
/* 39 */     return getSqlMapClientTemplate().queryForList("SYSTEM_DICT.selectListByKey", paraCode);
/*    */   }
/*    */ 
/*    */   public SystemDict selectSingleByKey(String paraCode)
/*    */   {
/* 48 */     return (SystemDict)getSqlMapClientTemplate().queryForObject("SYSTEM_DICT.selectSingleByKey", paraCode);
/*    */   }
/*    */ 
/*    */   public Map<String, SystemDict> selectListByMultiKey(List<EnumSystemDictKey> param)
/*    */   {
/* 60 */     Map map = new HashMap();
/* 61 */     map.put("paramList", param);
/* 62 */     List<SystemDict> list = getSqlMapClientTemplate().queryForList("SYSTEM_DICT.selectListByMultiKey", map);
/* 63 */     Map retMap = new HashMap();
/* 64 */     if (null != list) {
/* 65 */       for (SystemDict item : list) {
/* 66 */         retMap.put(item.getParaCode(), item);
/*    */       }
/*    */     }
/* 69 */     return retMap;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset.SystemDictDAOImpl
 * JD-Core Version:    0.6.0
 */