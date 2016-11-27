/*    */ package com.hundsun.eclp.biz.service.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.SysConfigDAO;
/*    */ import com.hundsun.eclp.biz.domain.sys.SysConfig;
/*    */ import com.hundsun.eclp.biz.service.SysConfigService;
/*    */ import com.hundsun.eclp.util.FileUploadUtil;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("sysConfigService")
/*    */ public class SysConfigServiceImpl
/*    */   implements SysConfigService
/*    */ {
/* 19 */   protected Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   private SysConfigDAO sysConfigDAO;
/*    */ 
/*    */   @Autowired
/*    */   private FileUploadUtil fileUploadUtil;
/*    */ 
/* 26 */   public SysConfig selectSysConfigByCode(String code) { this.log.info("UsersServiceImpl.selectByPage method");
/*    */     try {
/* 28 */       return this.sysConfigDAO.selectSysConfigByCode(code);
/*    */     } catch (Exception e) {
/* 30 */       this.log.error(e.getMessage());
/*    */     }
/* 32 */     return null; }
/*    */ 
/*    */   public List<SysConfig> selectAllSysConfig()
/*    */   {
/* 36 */     return this.sysConfigDAO.selectAllSysConfig();
/*    */   }
/*    */ 
/*    */   public SysConfig selectById(Long id) {
/* 40 */     if (id != null) {
/* 41 */       return this.sysConfigDAO.selectById(id);
/*    */     }
/* 43 */     return null;
/*    */   }
/*    */ 
/*    */   public int update(SysConfig record) {
/* 47 */     if (record != null)
/*    */     {
/* 49 */       if (("file".equalsIgnoreCase(record.getType())) && 
/* 50 */         (record.getFile() != null)) {
/* 51 */         String filePath = this.fileUploadUtil.uploadFile(record.getFile(), "000000", "logo");
/* 52 */         record.setValue(filePath);
/*    */       }
/*    */ 
/* 55 */       return this.sysConfigDAO.update(record);
/*    */     }
/* 57 */     return 0;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.SysConfigServiceImpl
 * JD-Core Version:    0.6.0
 */