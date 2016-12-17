/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemDictDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*    */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemDictService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemDictService")
/*    */ public class SystemDictServiceImpl
/*    */   implements SystemDictService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SystemDictDAO systemDictDAO;
/*    */ 
/*    */   public List<SystemDict> selectCommonChargeSpecial()
/*    */   {
/* 25 */     String[] paraCodeList = EnumSystemDictKey.selectCommonChargeSpecialKey();
/* 26 */     return this.systemDictDAO.selectCommonChargeSpecial(paraCodeList);
/*    */   }
/*    */ 
/*    */   public List<SystemDict> selectListByKey(String paraCode)
/*    */   {
/* 35 */     return this.systemDictDAO.selectListByKey(paraCode);
/*    */   }
/*    */ 
/*    */   public SystemDict selectSingleByKey(String paraCode)
/*    */   {
/* 44 */     return this.systemDictDAO.selectSingleByKey(paraCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.baseset.SystemDictServiceImpl
 * JD-Core Version:    0.6.0
 */