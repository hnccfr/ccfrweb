/*    */ package com.hundsun.network.gates.houchao.biz.domain.fund.query;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class FundInOutDetailQuery<FundInOutDetailDTO> extends Pagination<FundInOutDetailDTO>
/*    */ {
/*    */   private static final long serialVersionUID = 2308211873892915681L;
/*    */   private String fundAccount;
/*    */   private String clientID;
/*    */   private String dateStart;
/*    */   private String dateEnd;
/*    */   private Date startDate;
/*    */   private Date endDate;
/*    */ 
/*    */   public String getFundAccount()
/*    */   {
/* 48 */     return this.fundAccount;
/*    */   }
/*    */   public void setFundAccount(String fundAccount) {
/* 51 */     this.fundAccount = fundAccount;
/*    */   }
/*    */   public String getClientID() {
/* 54 */     return this.clientID;
/*    */   }
/*    */   public void setClientID(String clientID) {
/* 57 */     this.clientID = clientID;
/*    */   }
/*    */   public String getDateStart() {
/* 60 */     return this.dateStart;
/*    */   }
/*    */   public void setDateStart(String dateStart) {
/* 63 */     this.dateStart = dateStart;
/*    */   }
/*    */   public String getDateEnd() {
/* 66 */     return this.dateEnd;
/*    */   }
/*    */   public void setDateEnd(String dateEnd) {
/* 69 */     this.dateEnd = dateEnd;
/*    */   }
/*    */   public Date getStartDate() {
/* 72 */     return this.startDate;
/*    */   }
/*    */   public void setStartDate(Date startDate) {
/* 75 */     this.startDate = startDate;
/*    */   }
/*    */   public Date getEndDate() {
/* 78 */     return this.endDate;
/*    */   }
/*    */   public void setEndDate(Date endDate) {
/* 81 */     this.endDate = endDate;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.fund.query.FundInOutDetailQuery
 * JD-Core Version:    0.6.0
 */