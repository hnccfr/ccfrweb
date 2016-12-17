/*    */ package com.hundsun.network.gates.genshan.biz.domain.user;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserCredit;
/*    */ 
/*    */ public class UserCreditInfo extends UserCredit
/*    */ {
/*    */   private String buyImgName;
/*    */   private String sellerImgName;
/*    */   private String buyLevelName;
/*    */   private String sellerLevelName;
/*    */ 
/*    */   public String getBuyImgName()
/*    */   {
/* 35 */     return this.buyImgName;
/*    */   }
/*    */ 
/*    */   public void setBuyImgName(String buyImgName) {
/* 39 */     this.buyImgName = buyImgName;
/*    */   }
/*    */ 
/*    */   public String getSellerImgName() {
/* 43 */     return this.sellerImgName;
/*    */   }
/*    */ 
/*    */   public void setSellerImgName(String sellerImgName) {
/* 47 */     this.sellerImgName = sellerImgName;
/*    */   }
/*    */ 
/*    */   public void setBuyLevelName(String buyLevelName) {
/* 51 */     this.buyLevelName = buyLevelName;
/*    */   }
/*    */ 
/*    */   public String getBuyLevelName() {
/* 55 */     return this.buyLevelName;
/*    */   }
/*    */ 
/*    */   public void setSellerLevelName(String sellerLevelName) {
/* 59 */     this.sellerLevelName = sellerLevelName;
/*    */   }
/*    */ 
/*    */   public String getSellerLevelName() {
/* 63 */     return this.sellerLevelName;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.user.UserCreditInfo
 * JD-Core Version:    0.6.0
 */