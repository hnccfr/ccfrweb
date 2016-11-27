/*    */ package com.hundsun.network.hseccms.admin.security;
/*    */ 
/*    */ import com.hundsun.eclp.client.common.GenericUserAgent;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.SelfDependence;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.util.SelfUtil;
/*    */ import java.math.BigInteger;
/*    */ 
/*    */ public class SettlerAgent extends GenericUserAgent
/*    */ {
/*    */   private String currentSiteId;
/*    */ 
/*    */   public String lieDown()
/*    */   {
/* 17 */     return SelfUtil.format(new String[] { this.id + "", this.name, getPermissionString(36), this.permissions.toString(36), "", this.eclpLastLoginTime + "", this.currentSystemCode + "", this.userAccount, this.currentSiteId });
/*    */   }
/*    */ 
/*    */   public SelfDependence riseUp(String value)
/*    */   {
/* 22 */     String[] values = SelfUtil.recover(value);
/* 23 */     if (StringUtil.isNotEmpty(values[0])) {
/* 24 */       this.id = Long.parseLong(values[0]);
/*    */     }
/* 26 */     this.name = values[1];
/* 27 */     this.permissionsMap = getPermissionMapFromString(values[2]);
/* 28 */     this.permissions = new BigInteger(values[3], 36);
/* 29 */     if (StringUtil.isNotEmpty(values[5])) {
/* 30 */       this.eclpLastLoginTime = Long.valueOf(Long.parseLong(values[5]));
/*    */     }
/* 32 */     this.currentSystemCode = values[6];
/* 33 */     this.userAccount = values[7];
/* 34 */     this.currentSiteId = values[8];
/* 35 */     return this;
/*    */   }
/*    */ 
/*    */   public boolean haveFunction(PermissionEnum en) {
/* 39 */     if (en != null) {
/* 40 */       return super.havePermission(en.getCode());
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   public boolean access(String PermissionEnumName)
/*    */   {
/* 47 */     if ((StringUtil.isNotEmpty(PermissionEnumName)) && (PermissionEnumName.contains("."))) {
/* 48 */       PermissionEnumName = PermissionEnumName.substring(PermissionEnumName.lastIndexOf(".") + 1);
/*    */     }
/* 50 */     return haveFunction(PermissionEnum.indexOf(PermissionEnumName));
/*    */   }
/*    */ 
/*    */   public String getCurrentSiteId() {
/* 54 */     return this.currentSiteId;
/*    */   }
/*    */ 
/*    */   public void setCurrentSiteId(String currentSiteId) {
/* 58 */     this.currentSiteId = currentSiteId;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.security.SettlerAgent
 * JD-Core Version:    0.6.0
 */