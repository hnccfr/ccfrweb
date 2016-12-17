/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class SupplyDemandInfoAccuseQuery extends Pagination<SupplyDemandInfo>
/*    */ {
/*    */   private static final long serialVersionUID = -6637157281672152590L;
/*    */   private Long id;
/*    */   private String title;
/*    */   private String type;
/*    */   private String status;
/*    */   private Date gmtCreateFrom;
/*    */   private Date gmtCreateTo;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 27 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 31 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getTitle() {
/* 35 */     return this.title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 39 */     this.title = title;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 43 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String type) {
/* 47 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String getStatus() {
/* 51 */     return this.status;
/*    */   }
/*    */ 
/*    */   public void setStatus(String status) {
/* 55 */     this.status = status;
/*    */   }
/*    */ 
/*    */   public Date getGmtCreateFrom() {
/* 59 */     return this.gmtCreateFrom;
/*    */   }
/*    */ 
/*    */   public void setGmtCreateFrom(Date gmtCreateFrom) {
/* 63 */     this.gmtCreateFrom = gmtCreateFrom;
/*    */   }
/*    */ 
/*    */   public Date getGmtCreateTo() {
/* 67 */     return this.gmtCreateTo;
/*    */   }
/*    */ 
/*    */   public void setGmtCreateTo(Date gmtCreateTo) {
/* 71 */     this.gmtCreateTo = gmtCreateTo;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 75 */     return "[id:" + this.id + "][title:" + this.title + "][type:" + this.type + "][status:" + this.status + "][gmtCreateFrom:" + this.gmtCreateFrom + "][gmtCreateTo:" + this.gmtCreateTo + "]";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoAccuseQuery
 * JD-Core Version:    0.6.0
 */